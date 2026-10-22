package com.bytedance.apm6.disk;

import android.app.Application;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.apm.util.y;
import com.bytedance.apm6.disk.config.DiskConfig;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.crash.dumper.Scraps;
import d0.f;
import java.io.File;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DiskStatistics {
    private static final String EXTERNAL_PREFIX = "external";
    private static final long FACTOR_1024 = 1024;
    private static final String INTERNAL_PREFIX = "internal";
    private static final long MAX_STORAGE_CHECK_VALUE_BYTES = 17179869184L;
    private static final long MIN_OUTDATE_FILE_SIZE_BYTES = 102400;
    private static final String OUTSIDE_STORAGE = "/Android/data/";
    private static final String PERF_DISK_FILE_NAME = "name";
    private static final String PERF_DISK_FILE_NUM = "num";
    private static final String PERF_DISK_FILE_SIZE = "size";
    private static final long SHORT_UNIT = 1000;
    private static DiskStatistics instance;
    private List<String> compliancePaths;
    private DiskConfig config;
    private List<String> customCollectPaths;
    private List<String> ignoredPaths;
    private volatile boolean initException;
    private boolean inited;
    private String insideCachePath;
    private long insideCacheSize;
    private String insideDataPath;
    private long insideDataSize;
    private f listener;
    private String outsideCachePath;
    private long outsideCacheSize;
    private String outsideDataPath;
    private long outsideDataSize;

    /* JADX INFO: renamed from: com.bytedance.apm6.disk.DiskStatistics$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class DiskInfoNode {
        public static final String TYPE_CUSTOM = "custom";
        public static final String TYPE_NORMAL = "normal";
        public boolean isFolder;
        public List<DiskInfoNode> nextDisk;
        public String path;
        public String reportType;
        public long size;
        public float sizeRate;
        final /* synthetic */ DiskStatistics this$0;

        private DiskInfoNode(DiskStatistics r10) {
            this.this$0 = r10;
            this.reportType = "normal";
            this.nextDisk = new ArrayList();
        }

        /* synthetic */ DiskInfoNode(DiskStatistics r10, AnonymousClass1 r11) {
            this(r10);
        }

        private String parsePath() {
            String r10 = this.path;
            String r11 = DiskStatistics.access$700(this.this$0, r10);
            if (r11 == null) goto L6;
            r10 = r11;
        L6:
            if (r10.contains(DiskStatistics.access$800(this.this$0)) == false) goto L10;
            String r12 = DiskStatistics.access$800(this.this$0);
            String r13 = DiskStatistics.INTERNAL_PREFIX;
        L12:
            return r10.replace(r12, r13);
        L10:
            if (r10.contains(DiskStatistics.access$900(this.this$0)) == false) goto L13;
            r12 = DiskStatistics.access$900(this.this$0);
            r13 = DiskStatistics.EXTERNAL_PREFIX;
            goto L12
        L13:
            return r10;
        }

        public JSONObject toJson() {
            JSONObject r10 = new JSONObject();
            r10.put("path", parsePath());     // Catch: JSONException -> L11
            r10.put(DiskStatistics.PERF_DISK_FILE_SIZE, this.size);     // Catch: JSONException -> L11
            r10.put("size_rate", this.sizeRate);     // Catch: JSONException -> L11
            r10.put("is_folder", this.isFolder);     // Catch: JSONException -> L11
            r10.put("report_type", this.reportType);     // Catch: JSONException -> L11
            if (this.nextDisk.isEmpty() == true) goto L13;
            JSONArray r11 = new JSONArray();     // Catch: JSONException -> L11
            Iterator<DiskInfoNode> r12 = this.nextDisk.iterator();     // Catch: JSONException -> L11
        L7:
            if (r12.hasNext() == false) goto L9;
            r11.put(r12.next().toJson());     // Catch: JSONException -> L11
            goto L7
        L9:
            r10.put("next_disk", r11);     // Catch: JSONException -> L11
        L13:
            return r10;
        L11:
            e = move-exception;
            e.printStackTrace();
            goto L13
        }
    }

    private class FileNode implements Comparable {
        private int num;
        private String path;
        public long size;
        final /* synthetic */ DiskStatistics this$0;

        public FileNode(DiskStatistics r10) {
            this.this$0 = r10;
        }

        public FileNode(DiskStatistics r10, String r11, long r12, int r13) {
            this.this$0 = r10;
            this.path = r11;
            this.size = r12;
            this.num = r13;
        }

        static /* synthetic */ String access$100(FileNode r10) {
            return r10.path;
        }

        private String parsePath() {
            String r10 = this.path;
            String r11 = DiskStatistics.access$700(this.this$0, r10);
            if (r11 == null) goto L6;
            r10 = r11;
        L6:
            if (r10.contains(DiskStatistics.access$800(this.this$0)) == false) goto L10;
            String r12 = DiskStatistics.access$800(this.this$0);
            String r13 = DiskStatistics.INTERNAL_PREFIX;
        L12:
            return r10.replace(r12, r13);
        L10:
            if (r10.contains(DiskStatistics.access$900(this.this$0)) == false) goto L13;
            r12 = DiskStatistics.access$900(this.this$0);
            r13 = DiskStatistics.EXTERNAL_PREFIX;
            goto L12
        L13:
            return r10;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r10) {
            long r11 = this.size;
            long r12 = ((FileNode) r10).size;
            if (r11 != r12) goto L7;
            return 0;
        L7:
            if (r11 <= r12) goto L10;
            return 1;
        L10:
            return -1;
        }

        public JSONObject toJSON() {
            JSONObject r10 = new JSONObject();     // Catch: Exception -> L6
            r10.put("name", parsePath());     // Catch: Exception -> L6
            r10.put(DiskStatistics.PERF_DISK_FILE_SIZE, this.size);     // Catch: Exception -> L6
            int r11 = this.num;     // Catch: Exception -> L6
            if (r11 <= 0) goto L5;
            r10.put(DiskStatistics.PERF_DISK_FILE_NUM, r11);     // Catch: Exception -> L6
        L5:
            return r10;
        L6:
            return null;
        }
    }

    private class Node {
        private int childAccuCount;
        private int childCount;
        private boolean isChildExceedThreshold;
        private boolean isOutdated;
        private long outdateInterval;
        public Node parent;
        private String path;
        public long size;
        final /* synthetic */ DiskStatistics this$0;

        private Node(DiskStatistics r10) {
            this.this$0 = r10;
        }

        /* synthetic */ Node(DiskStatistics r10, AnonymousClass1 r11) {
            this(r10);
        }

        static /* synthetic */ String access$000(Node r10) {
            return r10.path;
        }

        static /* synthetic */ String access$002(Node r10, String r11) {
            r10.path = r11;
            return r11;
        }

        static /* synthetic */ int access$302(Node r10, int r11) {
            r10.childCount = r11;
            return r11;
        }

        static /* synthetic */ int access$310(Node r10) {
            int r11 = r10.childCount;
            r10.childCount = r11 - 1;
            return r11;
        }

        static /* synthetic */ boolean access$400(Node r10) {
            return r10.isOutdated;
        }

        static /* synthetic */ boolean access$402(Node r10, boolean r11) {
            r10.isOutdated = r11;
            return r11;
        }

        static /* synthetic */ long access$502(Node r10, long r11) {
            r10.outdateInterval = r11;
            return r11;
        }

        public void appendChildInfo(long r10, y<FileNode> r11, y<FileNode> r12) {
            this.size += r10;
            this.childAccuCount++;
            if (this.parent != null) goto L5;
            return;
        L5:
            if (isFull() == true) goto L7;
            return;
        L7:
            if (this.isChildExceedThreshold == false) goto L10;
            this.parent.isChildExceedThreshold = true;
        L10:
            if (this.size >= DiskStatistics.access$1000(this.this$0).getFolderThresholdBytes()) goto L12;
        L17:
            this.parent.appendChildInfo(this.size, r11, r12);
            if (this.isOutdated == true) goto L20;
            return;
        L20:
            if (this.this$0.isOutdatedFileSizeValid(this.size) == false) goto L26;
            DiskStatistics r13 = this.this$0;
            String r14 = this.path;
            long r15 = this.size;
            int r16 = this.childCount;
            r11.a(new OutdatedNode(r13, r14, r15, r16, r16));
            return;
        L26:
            return;
        L12:
            if (this.isChildExceedThreshold == true) goto L17;
            if (DiskStatistics.access$1100(this.this$0, this.size) == true) goto L16;
            r12.a(new FileNode(this.this$0, this.path, this.size, this.childCount));
        L16:
            this.parent.isChildExceedThreshold = true;
            goto L17
        }

        public boolean isFull() {
            if (this.childAccuCount != this.childCount) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private class OutdatedNode extends FileNode {
        private int num;
        private long outdatedInterval;
        private final String path;
        public long size;
        final /* synthetic */ DiskStatistics this$0;

        public OutdatedNode(DiskStatistics r10, String r11, long r12, int r13, long r14) {
            this.this$0 = r10;
            super(r10);
            this.path = r11;
            this.size = r12;
            this.num = r13;
            this.outdatedInterval = r14;
        }

        private String parsePath() {
            String r10 = this.path;
            String r11 = DiskStatistics.access$700(this.this$0, r10);
            if (r11 == null) goto L6;
            r10 = r11;
        L6:
            if (r10.contains(DiskStatistics.access$800(this.this$0)) == false) goto L10;
            String r12 = DiskStatistics.access$800(this.this$0);
            String r13 = DiskStatistics.INTERNAL_PREFIX;
        L12:
            return r10.replace(r12, r13);
        L10:
            if (r10.contains(DiskStatistics.access$900(this.this$0)) == false) goto L13;
            r12 = DiskStatistics.access$900(this.this$0);
            r13 = DiskStatistics.EXTERNAL_PREFIX;
            goto L12
        L13:
            return r10;
        }

        @Override // com.bytedance.apm6.disk.DiskStatistics.FileNode, java.lang.Comparable
        public int compareTo(Object r10) {
            long r11 = this.outdatedInterval;
            long r12 = ((OutdatedNode) r10).outdatedInterval;
            if (r11 != r12) goto L7;
            return 0;
        L7:
            if (r11 <= r12) goto L10;
            return 1;
        L10:
            return -1;
        }

        @Override // com.bytedance.apm6.disk.DiskStatistics.FileNode
        public JSONObject toJSON() {
            JSONObject r10 = new JSONObject();     // Catch: Exception -> L7
            r10.put("name", parsePath());     // Catch: Exception -> L7
            r10.put(DiskStatistics.PERF_DISK_FILE_SIZE, this.size);     // Catch: Exception -> L7
            int r11 = this.num;     // Catch: Exception -> L7
            if (r11 <= 0) goto L5;
            r10.put(DiskStatistics.PERF_DISK_FILE_NUM, r11);     // Catch: Exception -> L7
        L5:
            r10.put("outdate_interval", this.outdatedInterval);     // Catch: Exception -> L7
            return r10;
        L7:
            return null;
        }
    }

    static {
        instance = new DiskStatistics();
    }

    private DiskStatistics() {
        this.initException = false;
        this.insideDataSize = 0;
        this.outsideDataSize = 0;
        this.insideCacheSize = 0;
        this.outsideCacheSize = 0;
    }

    static /* synthetic */ DiskConfig access$1000(DiskStatistics r10) {
        return r10.config;
    }

    static /* synthetic */ boolean access$1100(DiskStatistics r10, long r11) {
        return r10.isOutOfMaxCheckSize(r11);
    }

    static /* synthetic */ String access$700(DiskStatistics r10, String r11) {
        return r10.getCompliancePath(r11);
    }

    static /* synthetic */ String access$800(DiskStatistics r10) {
        return r10.insideDataPath;
    }

    static /* synthetic */ String access$900(DiskStatistics r10) {
        return r10.outsideDataPath;
    }

    private DiskReportEvent calculate() {
        ArrayList r10 = new ArrayList();
        calculateFirstLevelDiskInfo(new File(this.insideDataPath), r10);
        calculateFirstLevelDiskInfo(new File(this.outsideDataPath), r10);
        ArrayList r11 = new ArrayList();
        Iterator<DiskInfoNode> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L13;
        DiskInfoNode r13 = r12.next();
        boolean r14 = true;
        Iterator<DiskInfoNode> r15 = r13.nextDisk.iterator();
    L7:
        if (r15.hasNext() == false) goto L11;
        if (r15.next().isFolder == false) goto L7;
        r14 = false;
    L11:
        if (r14 == false) goto L4;
        r11.remove(r13);
        goto L4
    L13:
        r10.removeAll(r11);
        if (ApmBaseContext.isDebugMode() == false) goto L19;
        Iterator<DiskInfoNode> r16 = r10.iterator();
    L17:
        if (r16.hasNext() == false) goto L19;
        Logger.d(Constants.TAG, "diskInfoNodes:" + r16.next().toJson());
    L19:
        y<FileNode> r17 = new y(this.config.getReportMaxTopCount());
        y<FileNode> r18 = new y(this.config.getReportExceptionDirMaxCount());
        y<FileNode> r19 = new y(this.config.getReportMaxOutdatedCount());
        List<String> r110 = new ArrayList();
        r110.add(this.insideDataPath);
        r110.add(this.insideCachePath);
        calculateDiskTotalSize(calculateDiskTopK(this.insideDataPath, r17, r18, r19, r110));
        r110.clear();
        r110.add(this.outsideCachePath);
        r110.add(this.outsideDataPath);
        calculateDiskTotalSize(calculateDiskTopK(this.outsideDataPath, r17, r18, r19, r110));
        if (ApmBaseContext.isDebugMode() == false) goto L34;
        Iterator r20 = r17.d().iterator();
    L23:
        if (r20.hasNext() == false) goto L25;
        Logger.d(Constants.TAG, "fileListTopK:" + ((FileNode) r20.next()).toJSON());
        goto L23
    L25:
        Iterator r21 = r18.d().iterator();
    L27:
        if (r21.hasNext() == false) goto L29;
        Logger.d(Constants.TAG, "dirListTopK:" + ((FileNode) r21.next()).toJSON());
        goto L27
    L29:
        Iterator r22 = r19.d().iterator();
    L31:
        if (r22.hasNext() == false) goto L33;
        Logger.d(Constants.TAG, "outdatedListTopK:" + ((FileNode) r22.next()).toJSON());
        goto L31
    L33:
        Logger.d(Constants.TAG, "insideDataSize:" + this.insideDataSize + " outsideDataSize:" + this.outsideDataSize + " insideCacheSize:" + this.insideCacheSize + " outsideCacheSize:" + this.outsideCacheSize);
    L34:
        calculateCustomDiskInfo(r10);
        return createReportEvent(r17, r18, r19, r10);
    }

    private void calculateCustomDiskInfo(File r10, List<DiskInfoNode> r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.exists() == true) goto L6;
        return;
    L6:
        if (isIgnored(r10) == true) goto L16;
        AnonymousClass1 r12 = null;
        if (r10.isFile() == false) goto L13;
        long r13 = r10.length();
        DiskInfoNode r14 = new DiskInfoNode(this, r12);
        r14.isFolder = false;
        r14.path = r10.getAbsolutePath();
        r14.size = r13;
        r14.reportType = "custom";
    L11:
        r11.add(r14);
        return;
    L13:
        r14 = new DiskInfoNode(this, r12);
        r14.isFolder = true;
        r14.reportType = "custom";
        r14.path = r10.getAbsolutePath();
        r14.size = getFolderSize(r10);
        goto L11
    }

    private void calculateCustomDiskInfo(List<DiskInfoNode> r10) {
        if (ListUtils.isEmpty(this.customCollectPaths) == false) goto L5;
        return;
    L5:
        Iterator<String> r11 = this.customCollectPaths.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        calculateCustomDiskInfo(new File(r11.next()), r10);
        goto L7
    }

    private long calculateDiskInfo(File r10, List<DiskInfoNode> r11) {
        long r12 = 0;
        if (r10 != null) goto L5;
    L33:
        return r12;
    L5:
        if (r10.exists() == false) goto L33;
        if (isIgnored(r10) == true) goto L33;
        int r13 = 0;
        AnonymousClass1 r14 = null;
        if (r10.isFile() == false) goto L16;
        long r15 = r10.length();
        if (r15 >= this.config.getFileThresholdBytes()) goto L14;
        return r15;
    L14:
        DiskInfoNode r16 = new DiskInfoNode(this, r14);
        r16.isFolder = false;
        r16.path = r10.getAbsolutePath();
        r16.size = r15;
        r11.add(r16);
        return r15;
    L16:
        File[] r17 = r10.listFiles();
        if (r17 == null) goto L33;
        if (r17.length == 0) goto L33;
        DiskInfoNode r18 = new DiskInfoNode(this, r14);
        r18.isFolder = r10.isDirectory();
        r18.path = r10.getAbsolutePath();
        ArrayList r19 = new ArrayList();
        r18.nextDisk = r19;
        r11.add(r18);
        int r110 = r17.length;
    L22:
        if (r13 >= r110) goto L32;
        File r20 = r17[r13];
        if (r20 == null) goto L31;
        if (r20.exists() == false) goto L31;
        if (isIgnored(r20) == true) goto L31;
        r12 = r12 + calculateDiskInfo(r20, r19);
    L31:
        r13 = r13 + 1;
        goto L22
    L32:
        r18.size = r12;
        goto L33
    }

    private List<Node> calculateDiskTopK(String r23, y<FileNode> r24, y<FileNode> r25, y<FileNode> r26, List<String> r27) {
        List<String> r11 = r27;
        ArrayList r12 = new ArrayList();
        File r10 = new File(r23);
        AnonymousClass1 r13 = null;
        Node r14 = new Node(this, r13);
        Node.access$002(r14, r23);
        r14.parent = new Node(this, r13);
        File[] r15 = r10.listFiles();
        if (r15 == null) goto L69;
        if (r15.length == 0) goto L69;
        if (r11.contains(r10.getAbsolutePath()) == false) goto L10;
        r12.add(r14);
        r11.remove(r10.getAbsolutePath());
    L10:
        Node.access$302(r14, r15.length);
        LinkedList r16 = new LinkedList();
        r16.offer(r14);
    L12:
        if (r16.isEmpty() == true) goto L67;
        int r17 = r16.size();
        int r18 = 0;
    L14:
        if (r18 >= r17) goto L12;
        Node r19 = (Node) r16.poll();
        if (r19 != null) goto L18;
        r27 = r11;
        ArrayList r20 = r12;
        LinkedList r110 = r16;
        int r111 = r17;
        r18 = r18;
    L65:
        r18 = r18 + 1;
        r12 = r20;
        r16 = r110;
        r17 = r111;
        r11 = r27;
        goto L14
    L18:
        String r21 = Node.access$000(r19);
        File r22 = new File(r21);
        if (r22.exists() == true) goto L21;
    L64:
        r27 = r11;
        r20 = r12;
        r110 = r16;
        r111 = r17;
        r18 = r18;
        Node.access$310(r19.parent);
        goto L65
    L21:
        if (isIgnored(r22) == true) goto L64;
        if (r22.isFile() == false) goto L42;
        r110 = r16;
        long r112 = r22.length();
        if (isOutOfMaxCheckSize(r112) == true) goto L29;
        r24.a(new FileNode(this, r21, r112, 1));
    L29:
        Node r28 = r19.parent;
        if (r28 != null) goto L32;
        r18 = r18;
    L41:
        r111 = r17;
        r20 = r12;
        goto L65
    L32:
        r28.appendChildInfo(r112, r26, r25);
        if (Node.access$400(r19.parent) == true) goto L41;
        long r29 = getOutOfDateInterval(r22.lastModified());
        if (r29 <= 0) goto L41;
        if (isOutdatedFileSizeValid(r112) == false) goto L41;
        r26.a(new OutdatedNode(this, r21, r17, 0, r29));
        goto L41
    L42:
        ArrayList r113 = r12;
        LinkedList r210 = r16;
        r18 = r18;
        r27 = r27;
        if (r27.contains(r22.getAbsolutePath()) == false) goto L45;
        r20 = r113;
        r20.add(r19);
        r27.remove(r22.getAbsolutePath());
    L46:
        File[] r30 = r22.listFiles();
        if (r30 != null) goto L49;
    L63:
        r110 = r210;
        r111 = r17;
        r19.parent.appendChildInfo(0, r26, r25);
        goto L65
    L49:
        if (r30.length == 0) goto L63;
        Node.access$302(r19, r30.length);
        int r31 = r30.length;
        int r32 = 0;
    L52:
        if (r32 >= r31) goto L62;
        File r114 = r30[r32];
        Node r115 = new Node(this, null);
        r115.parent = r19;
        Node.access$002(r115, r114.getAbsolutePath());
        if (r114.isDirectory() == true) goto L56;
    L60:
        int r116 = r17;
    L61:
        LinkedList r117 = r210;
        r117.offer(r115);
        r32 = r32 + 1;
        r210 = r117;
        r17 = r116;
        goto L52
    L56:
        if (Node.access$400(r19) == true) goto L60;
        r116 = r17;
        long r118 = getOutOfDateInterval(r114.lastModified());
        if (r118 <= 0) goto L61;
        Node.access$402(r115, true);
        Node.access$502(r115, r118);
        goto L61
    L62:
        r110 = r210;
        r111 = r17;
        goto L65
    L45:
        r20 = r113;
        goto L46
    L67:
        return r12;
    L69:
        return null;
    }

    private void calculateDiskTotalSize(List<Node> r10) {
        if (ListUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        Iterator<Node> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L20;
        Node r12 = r11.next();
        if (TextUtils.equals(Node.access$000(r12), this.insideDataPath) == true) goto L10;
        if (TextUtils.equals(Node.access$000(r12), this.outsideDataPath) == true) goto L13;
        if (TextUtils.equals(Node.access$000(r12), this.insideCachePath) == true) goto L16;
        if (TextUtils.equals(Node.access$000(r12), this.outsideCachePath) == false) goto L7;
        this.outsideCacheSize = r12.size;
        goto L7
    L16:
        this.insideCacheSize = r12.size;
        goto L7
    L13:
        this.outsideDataSize = r12.size;
        goto L7
    L10:
        this.insideDataSize = r12.size;
        goto L7
    }

    private void calculateFirstLevelDiskInfo(File r10, List<DiskInfoNode> r11) {
        File[] r12 = r10.listFiles();
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.length == 0) goto L12;
        int r13 = r12.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L13;
        calculateDiskInfo(r12[r14], r11);
        r14 = r14 + 1;
        goto L8
    L13:
        return;
    }

    private static List<String> convertFileNodeList(y<? extends FileNode> r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        LinkedList r11 = new LinkedList();
        Iterator r12 = r10.d().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r11.add(FileNode.access$100((FileNode) r12.next()));
        goto L7
    L9:
        return r11;
    }

    private JSONArray createDiskInfo(List<DiskInfoNode> r10, long r11) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L36;
        BigDecimal r12 = new BigDecimal(r11);
        JSONArray r13 = new JSONArray();
        Iterator<DiskInfoNode> r14 = r10.iterator();
    L7:
        if (r14.hasNext() == false) goto L24;
        DiskInfoNode r15 = r14.next();
        if (isIgnoredNode(r15) == false) goto L11;
        r15.sizeRate = 0.0f;
    L12:
        List<DiskInfoNode> r16 = r15.nextDisk;
        if (r16 == null) goto L23;
        if (r16.size() <= 0) goto L23;
        Iterator<DiskInfoNode> r17 = r16.iterator();
    L18:
        if (r17.hasNext() == false) goto L23;
        DiskInfoNode r18 = r17.next();
        if (isIgnoredNode(r18) == true) goto L21;
        r18.sizeRate = getRate(r18.size, r12);
        goto L18
    L21:
        r18.sizeRate = 0.0f;
    L23:
        r13.put(r15.toJson());
        goto L7
    L11:
        r15.sizeRate = getRate(r15.size, r12);
        goto L12
    L24:
        return r13;
    L36:
        return null;
    }

    private DiskReportEvent createReportEvent(y<FileNode> r29, y<FileNode> r30, y<FileNode> r31, List<DiskInfoNode> r32) {
        long r10 = this.insideDataSize + this.outsideDataSize;     // Catch: Throwable -> L15
        long r11 = this.insideCacheSize + this.outsideCacheSize;     // Catch: Throwable -> L15
        long r12 = Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace();     // Catch: Throwable -> L15
        long r14 = Environment.getDataDirectory().getFreeSpace();     // Catch: Throwable -> L15
        long r13 = Math.min(r10, MAX_STORAGE_CHECK_VALUE_BYTES);     // Catch: Throwable -> L15
        long r15 = Math.min(r11, MAX_STORAGE_CHECK_VALUE_BYTES);     // Catch: Throwable -> L15
        if (r13 >= 0) goto L7;
        return null;
    L7:
        if (this.listener == null) goto L9;
        this.listener.a(this.config.getDiskThresholdBytes(), r13, convertFileNodeList(r29), convertFileNodeList(r30), convertFileNodeList(r31));     // Catch: Throwable -> L15
    L9:
        Pair<Long, Long> r16 = getPhoneStorage();     // Catch: Throwable -> L15
        long r17 = getAppUsage();     // Catch: Throwable -> L15
        if (ApmBaseContext.isDebugMode() == false) goto L13;
        Logger.d(Constants.TAG, "appUsage:" + r17);     // Catch: Throwable -> L15
    L13:
        return new DiskReportEvent(r10, r15, r12, r14, r17, ((Long) r16.first).longValue(), ((Long) r16.second).longValue(), getRate(r17, new BigDecimal(r12)), createJSONArray(r29), createJSONArray(r30), createJSONArray(r31), createDiskInfo(r32, r13));
    L15:
        th = move-exception;
        Log.e(Constants.TAG, "error", th);
        return null;
    }

    private String findFirstCompliancePath(String r10) {
        if (ListUtils.isEmpty(this.compliancePaths) == true) goto L11;
        if (r10 == null) goto L16;
        Iterator<String> r11 = this.compliancePaths.iterator();
    L7:
        if (r11.hasNext() == false) goto L17;
        String r12 = r11.next();
        if (r10.startsWith(r12) == false) goto L7;
        return r12;
    L17:
        return null;
    L16:
        return null;
    L11:
        return null;
    }

    private long getAppUsage() {
        if (Build.VERSION.SDK_INT < 26) goto L20;
        Application r10 = ApmBaseContext.getContext();     // Catch: Throwable -> L17
        String r11 = r10.getPackageName();     // Catch: Throwable -> L17
        StorageStats r12 = ((StorageStatsManager) r10.getSystemService("storagestats")).queryStatsForUid(((StorageManager) r10.getSystemService(Scraps.STORAGE)).getUuidForPath(new File(r10.getDataDir().getParent(), r11)), r10.getPackageManager().getApplicationInfo(r11, 128).uid);     // Catch: Throwable -> L17
        if (ApmBaseContext.isDebugMode() == false) goto L7;
        Log.e(Constants.TAG, "storageStats.getAppBytes():" + r12.getAppBytes());     // Catch: Throwable -> L17
    L7:
        return r12.getAppBytes();
    L20:
        long r13 = getFolderSize(new File(ApmBaseContext.getContext().getPackageManager().getApplicationInfo(ApmBaseContext.getContext().getPackageName(), 0).sourceDir).getParentFile());     // Catch: Exception -> L15
        if (ApmBaseContext.isDebugMode() == false) goto L12;
        Log.e(Constants.TAG, "storageStats.getAppBytes():" + (((getMediaDirLength() + r13) + this.insideDataSize) + this.outsideDataSize));     // Catch: Exception -> L15
    L12:
        return ((r13 + getMediaDirLength()) + this.insideDataSize) + this.outsideDataSize;
    L15:
        return 0;
    }

    private String getCompliancePath(String r10) {
        String r11 = findFirstCompliancePath(r10);
        if (r11 == null) goto L7;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r11 + r10.substring(r11.length()).replaceAll("[^/]", "*");
    L7:
        return null;
    }

    private String getExternalDir(Context r10) {
        return r10.getExternalFilesDir(null).getParentFile().getAbsolutePath();
    L8:
        return null;
    }

    private long getFolderSize(File r10) {
        long r11 = 0;
        File[] r12 = r10.listFiles();     // Catch: Exception -> L16
        if (r12 != null) goto L6;
    L15:
        return 0;
    L6:
        if (r12.length == 0) goto L15;
        int r13 = r12.length;     // Catch: Exception -> L16
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L18;
        File r15 = r12[r14];     // Catch: Exception -> L16
        if (r15.isDirectory() == false) goto L13;
        long r16 = getFolderSize(r15);     // Catch: Exception -> L16
    L14:
        r11 = r11 + r16;
        r14 = r14 + 1;
        goto L9
    L13:
        r16 = r15.length();     // Catch: Exception -> L16
    L18:
        return r11;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public static DiskStatistics getInstance() {
        return instance;
    }

    private long getMediaDirLength() {
        long r10 = 0;
        if (Build.VERSION.SDK_INT < 21) goto L7;
        File[] r11 = ApmBaseContext.getContext().getApplicationContext().getExternalMediaDirs();
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        r10 = r10 + getFolderSize(r11[r13]);
        r13 = r13 + 1;
    L7:
        return r10;
    }

    private long getOutOfDateInterval(long r10) {
        long r11 = System.currentTimeMillis() - r10;
        if (r11 >= this.config.getOutdatedIntervalMs()) goto L5;
        return 0;
    L5:
        if (r11 >= 62899200000L) goto L9;
        return r11;
    L9:
        return 0;
    }

    private Pair<Long, Long> getPhoneStorage() {
        int r13 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L33
        long r10 = 0;
        if (r13 < 26) goto L16;
        StorageStatsManager r14 = (StorageStatsManager) ApmBaseContext.getContext().getSystemService("storagestats");     // Catch: Throwable -> L33
        StorageManager r11 = (StorageManager) ApmBaseContext.getContext().getSystemService(Scraps.STORAGE);     // Catch: Throwable -> L33
        Iterator<StorageVolume> r12 = r11.getStorageVolumes().iterator();     // Catch: Throwable -> L33
        long r15 = 0;
    L7:
        if (r12.hasNext() == false) goto L14;
        String r16 = r12.next().getUuid();     // Catch: Throwable -> L33
        if (r16 != null) goto L11;
        UUID r17 = StorageManager.UUID_DEFAULT;     // Catch: Throwable -> L33
    L12:
        r10 = r10 + r14.getTotalBytes(r17);     // Catch: Throwable -> L33
        r15 = r15 + r11.getAllocatableBytes(r17);     // Catch: Throwable -> L33
        goto L7
    L11:
        r17 = UUID.fromString(r16);     // Catch: Throwable -> L33
        goto L12
    L14:
        return new Pair(Long.valueOf((((r10 / 1000) / 1000) * 1024) * 1024), Long.valueOf((((r15 / 1000) / 1000) * 1024) * 1024));
    L16:
        if (r13 < 24) goto L27;
        List<StorageVolume> r18 = ((StorageManager) ApmBaseContext.getContext().getSystemService(Scraps.STORAGE)).getStorageVolumes();     // Catch: Throwable -> L33
        if (ListUtils.isEmpty(r18) == false) goto L21;
        return null;
    L21:
        Iterator<StorageVolume> r19 = r18.iterator();     // Catch: Throwable -> L33
        long r20 = 0;
    L23:
        if (r19.hasNext() == false) goto L26;
        StorageVolume r110 = r19.next();     // Catch: Throwable -> L33
        File r111 = (File) reflectHideMethod(r110.getClass(), "getPathFile", new Class[0]).invoke(r110, new Object[0]);     // Catch: Throwable -> L33
        r10 = r10 + r111.getTotalSpace();     // Catch: Throwable -> L33
        r20 = r20 + r111.getFreeSpace();     // Catch: Throwable -> L33
        goto L23
    L26:
        return new Pair(Long.valueOf((((r10 / 1000) / 1000) * 1024) * 1024), Long.valueOf((((r20 / 1000) / 1000) * 1024) * 1024));
    L27:
        StorageManager r112 = (StorageManager) ApmBaseContext.getContext().getSystemService(Scraps.STORAGE);     // Catch: Throwable -> L33
        Iterator r113 = ((List) reflectHideMethod(r112.getClass(), "getVolumes", new Class[0]).invoke(r112, new Object[0])).iterator();     // Catch: Throwable -> L33
        long r21 = 0;
    L29:
        if (r113.hasNext() == false) goto L32;
        Object r22 = r113.next();     // Catch: Throwable -> L33
        File r23 = (File) reflectHideMethod(r22.getClass(), "getPathFile", new Class[0]).invoke(r22, new Object[0]);     // Catch: Throwable -> L33
        r21 = r21 + r23.getFreeSpace();     // Catch: Throwable -> L33
        r10 = r10 + r23.getFreeSpace();     // Catch: Throwable -> L33
        goto L29
    L32:
        return new Pair(Long.valueOf(r10), Long.valueOf(r21));
    L34:
        return new Pair(Long.valueOf(FileUtils.getTotalStorageSize(Environment.getDataDirectory().getPath()) + FileUtils.getTotalStorageSize(Environment.getRootDirectory().getPath())), Long.valueOf(FileUtils.getAvailableStorage(Environment.getDataDirectory().getPath())));
    }

    private float getRate(long r10, BigDecimal r11) {
        return (float) new BigDecimal(r10).divide(r11, 4, 4).doubleValue();
    }

    private void initPaths() {
        if (this.inited == false) goto L5;
        return;
    L5:
        this.inited = true;
        Application r10 = ApmBaseContext.getContext();
        r10.getPackageName();     // Catch: Exception -> L10
        this.insideDataPath = r10.getFilesDir().getParent();     // Catch: Exception -> L10
        this.insideCachePath = r10.getCacheDir().getAbsolutePath();     // Catch: Exception -> L10
        this.outsideDataPath = getExternalDir(r10);     // Catch: Exception -> L10
        File r11 = r10.getExternalCacheDir();     // Catch: Exception -> L10
        if (r11 == null) goto L14;
        this.outsideCachePath = r11.getAbsolutePath();     // Catch: Exception -> L10
        return;
    L14:
        return;
    L10:
        this.initException = true;
    }

    private boolean isIgnored(File r10) {
        if (ListUtils.isEmpty(this.ignoredPaths) == false) goto L5;
        return false;
    L5:
        return this.ignoredPaths.contains(r10.getAbsolutePath());
    }

    private boolean isIgnoredNode(DiskInfoNode r10) {
        Iterator<String> r11 = this.ignoredPaths.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        String r12 = r11.next();
        if (r10.path.contains(r12) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean isOutOfMaxCheckSize(long r10) {
        if (r10 >= 0) goto L5;
    L8:
        return true;
    L5:
        if (r10 > MAX_STORAGE_CHECK_VALUE_BYTES) goto L8;
        return false;
    }

    private static Method reflectHideMethod(Class r10, String r11, Class<?>... r12) {
        Method r13 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r10, new Object[]{r11, r12});     // Catch: Exception -> L4
        r13.setAccessible(true);     // Catch: Exception -> L4
        return r13;
    L4:
        return null;
    }

    private List<String> toAbsolutePath(List<String> r10) {
        ArrayList r11 = new ArrayList();
        if (ListUtils.isEmpty(r10) == false) goto L5;
        return r11;
    L5:
        Iterator<String> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L15;
        String r13 = r12.next();
        String r14 = INTERNAL_PREFIX;
        if (r13.contains(INTERNAL_PREFIX) == true) goto L10;
        r14 = EXTERNAL_PREFIX;
        if (r13.contains(EXTERNAL_PREFIX) == false) goto L7;
        String r15 = this.outsideDataPath;
    L11:
        r11.add(r13.replace(r14, r15));
        goto L7
    L10:
        r15 = this.insideDataPath;
        goto L11
    L15:
        return r11;
    }

    DiskReportEvent collect(DiskConfig r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (this.initException == false) goto L8;
        return null;
    L8:
        this.config = r10;
        initPaths();
        this.ignoredPaths = toAbsolutePath(r10.getIgnoredRelativePaths());
        this.customCollectPaths = toAbsolutePath(r10.getCustomRelativePaths());
        this.compliancePaths = toAbsolutePath(r10.getComplianceRelativePaths());
        return calculate();
    }

    JSONArray createJSONArray(y<FileNode> r10) {
        JSONArray r11 = new JSONArray();
        Iterator r12 = r10.d().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        JSONObject r13 = ((FileNode) r12.next()).toJSON();
        if (r13 == null) goto L4;
        r11.put(r13);
        goto L4
    L8:
        return r11;
    }

    boolean isOutdatedFileSizeValid(long r10) {
        if (r10 >= 104857600) goto L5;
    L7:
        return false;
    L5:
        if (r10 > MAX_STORAGE_CHECK_VALUE_BYTES) goto L7;
        return true;
    }

    public void setListener(f r10) {
        this.listener = r10;
    }
}
