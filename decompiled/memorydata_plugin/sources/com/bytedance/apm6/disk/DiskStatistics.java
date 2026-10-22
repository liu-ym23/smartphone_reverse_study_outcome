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
import com.bytedance.apm.d.f;
import com.bytedance.apm.util.v;
import com.bytedance.apm6.disk.config.DiskConfig;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        private DiskInfoNode(DiskStatistics r1) {
            this.this$0 = r1;
            this.reportType = "normal";
            this.nextDisk = new ArrayList();
        }

        /* synthetic */ DiskInfoNode(DiskStatistics r1, AnonymousClass1 r2) {
            this(r1);
        }

        private String parsePath() {
            String r0 = this.path;
            String r1 = DiskStatistics.access$700(this.this$0, r0);
            if (r1 == null) goto L6;
            r0 = r1;
        L6:
            if (r0.contains(DiskStatistics.access$800(this.this$0)) == false) goto L10;
            String r2 = DiskStatistics.access$800(this.this$0);
            String r3 = DiskStatistics.INTERNAL_PREFIX;
        L12:
            return r0.replace(r2, r3);
        L10:
            if (r0.contains(DiskStatistics.access$900(this.this$0)) == false) goto L13;
            r2 = DiskStatistics.access$900(this.this$0);
            r3 = DiskStatistics.EXTERNAL_PREFIX;
            goto L12
        L13:
            return r0;
        }

        public JSONObject toJson() {
            JSONObject r0 = new JSONObject();
            r0.put("path", parsePath());     // Catch: JSONException -> L11
            r0.put(DiskStatistics.PERF_DISK_FILE_SIZE, this.size);     // Catch: JSONException -> L11
            r0.put("size_rate", this.sizeRate);     // Catch: JSONException -> L11
            r0.put("is_folder", this.isFolder);     // Catch: JSONException -> L11
            r0.put("report_type", this.reportType);     // Catch: JSONException -> L11
            if (this.nextDisk.isEmpty() == true) goto L13;
            JSONArray r1 = new JSONArray();     // Catch: JSONException -> L11
            Iterator<DiskInfoNode> r5 = this.nextDisk.iterator();     // Catch: JSONException -> L11
        L7:
            if (r5.hasNext() == false) goto L9;
            r1.put(((DiskInfoNode) ZeusTransformUtils.preCheckCast(r5.next(), DiskInfoNode.class, "com.obric.memorydata.plugin")).toJson());     // Catch: JSONException -> L11
            goto L7
        L9:
            r0.put("next_disk", r1);     // Catch: JSONException -> L11
        L13:
            return r0;
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

        public FileNode(DiskStatistics r1) {
            this.this$0 = r1;
        }

        public FileNode(DiskStatistics r1, String r2, long r3, int r5) {
            this.this$0 = r1;
            this.path = r2;
            this.size = r3;
            this.num = r5;
        }

        static /* synthetic */ String access$100(FileNode r0) {
            return r0.path;
        }

        private String parsePath() {
            String r0 = this.path;
            String r1 = DiskStatistics.access$700(this.this$0, r0);
            if (r1 == null) goto L6;
            r0 = r1;
        L6:
            if (r0.contains(DiskStatistics.access$800(this.this$0)) == false) goto L10;
            String r2 = DiskStatistics.access$800(this.this$0);
            String r3 = DiskStatistics.INTERNAL_PREFIX;
        L12:
            return r0.replace(r2, r3);
        L10:
            if (r0.contains(DiskStatistics.access$900(this.this$0)) == false) goto L13;
            r2 = DiskStatistics.access$900(this.this$0);
            r3 = DiskStatistics.EXTERNAL_PREFIX;
            goto L12
        L13:
            return r0;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r4) {
            FileNode r5 = (FileNode) ZeusTransformUtils.preCheckCast(r4, FileNode.class, "com.obric.memorydata.plugin");
            long r0 = this.size;
            long r3 = r5.size;
            if (r0 != r3) goto L7;
            return 0;
        L7:
            if (r0 <= r3) goto L10;
            return 1;
        L10:
            return -1;
        }

        public JSONObject toJSON() {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
            r0.put("name", parsePath());     // Catch: Exception -> L6
            r0.put(DiskStatistics.PERF_DISK_FILE_SIZE, this.size);     // Catch: Exception -> L6
            int r4 = this.num;     // Catch: Exception -> L6
            if (r4 <= 0) goto L5;
            r0.put(DiskStatistics.PERF_DISK_FILE_NUM, r4);     // Catch: Exception -> L6
        L5:
            return r0;
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

        private Node(DiskStatistics r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Node(DiskStatistics r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ String access$000(Node r0) {
            return r0.path;
        }

        static /* synthetic */ String access$002(Node r0, String r1) {
            r0.path = r1;
            return r1;
        }

        static /* synthetic */ int access$302(Node r0, int r1) {
            r0.childCount = r1;
            return r1;
        }

        static /* synthetic */ int access$310(Node r2) {
            int r0 = r2.childCount;
            r2.childCount = r0 - 1;
            return r0;
        }

        static /* synthetic */ boolean access$400(Node r0) {
            return r0.isOutdated;
        }

        static /* synthetic */ boolean access$402(Node r0, boolean r1) {
            r0.isOutdated = r1;
            return r1;
        }

        static /* synthetic */ long access$502(Node r0, long r1) {
            r0.outdateInterval = r1;
            return r1;
        }

        public void appendChildInfo(long r9, v<FileNode> r11, v<FileNode> r12) {
            this.size += r9;
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
            DiskStatistics r1 = this.this$0;
            String r2 = this.path;
            long r3 = this.size;
            int r5 = this.childCount;
            r11.a(new OutdatedNode(r1, r2, r3, r5, r5));
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

        public OutdatedNode(DiskStatistics r1, String r2, long r3, int r5, long r6) {
            this.this$0 = r1;
            super(r1);
            this.path = r2;
            this.size = r3;
            this.num = r5;
            this.outdatedInterval = r6;
        }

        private String parsePath() {
            String r0 = this.path;
            String r1 = DiskStatistics.access$700(this.this$0, r0);
            if (r1 == null) goto L6;
            r0 = r1;
        L6:
            if (r0.contains(DiskStatistics.access$800(this.this$0)) == false) goto L10;
            String r2 = DiskStatistics.access$800(this.this$0);
            String r3 = DiskStatistics.INTERNAL_PREFIX;
        L12:
            return r0.replace(r2, r3);
        L10:
            if (r0.contains(DiskStatistics.access$900(this.this$0)) == false) goto L13;
            r2 = DiskStatistics.access$900(this.this$0);
            r3 = DiskStatistics.EXTERNAL_PREFIX;
            goto L12
        L13:
            return r0;
        }

        @Override // com.bytedance.apm6.disk.DiskStatistics.FileNode, java.lang.Comparable
        public int compareTo(Object r4) {
            OutdatedNode r5 = (OutdatedNode) ZeusTransformUtils.preCheckCast(r4, OutdatedNode.class, "com.obric.memorydata.plugin");
            long r0 = this.outdatedInterval;
            long r3 = r5.outdatedInterval;
            if (r0 != r3) goto L7;
            return 0;
        L7:
            if (r0 <= r3) goto L10;
            return 1;
        L10:
            return -1;
        }

        @Override // com.bytedance.apm6.disk.DiskStatistics.FileNode
        public JSONObject toJSON() {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L7
            r0.put("name", parsePath());     // Catch: Exception -> L7
            r0.put(DiskStatistics.PERF_DISK_FILE_SIZE, this.size);     // Catch: Exception -> L7
            int r1 = this.num;     // Catch: Exception -> L7
            if (r1 <= 0) goto L5;
            r0.put(DiskStatistics.PERF_DISK_FILE_NUM, r1);     // Catch: Exception -> L7
        L5:
            r0.put("outdate_interval", this.outdatedInterval);     // Catch: Exception -> L7
            return r0;
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

    static /* synthetic */ DiskConfig access$1000(DiskStatistics r0) {
        return r0.config;
    }

    static /* synthetic */ boolean access$1100(DiskStatistics r0, long r1) {
        return r0.isOutOfMaxCheckSize(r1);
    }

    static /* synthetic */ String access$700(DiskStatistics r0, String r1) {
        return r0.getCompliancePath(r1);
    }

    static /* synthetic */ String access$800(DiskStatistics r0) {
        return r0.insideDataPath;
    }

    static /* synthetic */ String access$900(DiskStatistics r0) {
        return r0.outsideDataPath;
    }

    private DiskReportEvent calculate() {
        ArrayList r0 = new ArrayList();
        calculateFirstLevelDiskInfo(new File(this.insideDataPath), r0);
        calculateFirstLevelDiskInfo(new File(this.outsideDataPath), r0);
        ArrayList r1 = new ArrayList();
        Iterator<DiskInfoNode> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        DiskInfoNode r3 = (DiskInfoNode) ZeusTransformUtils.preCheckCast(r2.next(), DiskInfoNode.class, "com.obric.memorydata.plugin");
        boolean r5 = true;
        Iterator<DiskInfoNode> r6 = r3.nextDisk.iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        if (((DiskInfoNode) ZeusTransformUtils.preCheckCast(r6.next(), DiskInfoNode.class, "com.obric.memorydata.plugin")).isFolder == false) goto L7;
        r5 = false;
    L11:
        if (r5 == false) goto L4;
        r1.remove(r3);
        goto L4
    L13:
        r0.removeAll(r1);
        if (ApmContext.isDebugMode() == false) goto L19;
        Iterator<DiskInfoNode> r4 = r0.iterator();
    L17:
        if (r4.hasNext() == false) goto L19;
        Logger.d(Constants.TAG, "diskInfoNodes:" + ((DiskInfoNode) ZeusTransformUtils.preCheckCast(r4.next(), DiskInfoNode.class, "com.obric.memorydata.plugin")).toJson());
    L19:
        v<FileNode> r7 = new v(this.config.getReportMaxTopCount());
        v<FileNode> r8 = new v(this.config.getReportExceptionDirMaxCount());
        v<FileNode> r11 = new v(this.config.getReportMaxOutdatedCount());
        List<String> r12 = new ArrayList();
        r12.add(this.insideDataPath);
        r12.add(this.insideCachePath);
        calculateDiskTotalSize(calculateDiskTopK(this.insideDataPath, r7, r8, r11, r12));
        r12.clear();
        r12.add(this.outsideCachePath);
        r12.add(this.outsideDataPath);
        calculateDiskTotalSize(calculateDiskTopK(this.outsideDataPath, r7, r8, r11, r12));
        if (ApmContext.isDebugMode() == false) goto L34;
        Iterator r9 = r7.a().iterator();
    L23:
        if (r9.hasNext() == false) goto L25;
        Logger.d(Constants.TAG, "fileListTopK:" + ((FileNode) ZeusTransformUtils.preCheckCast(r9.next(), FileNode.class, "com.obric.memorydata.plugin")).toJSON());
        goto L23
    L25:
        Iterator r10 = r8.a().iterator();
    L27:
        if (r10.hasNext() == false) goto L29;
        Logger.d(Constants.TAG, "dirListTopK:" + ((FileNode) ZeusTransformUtils.preCheckCast(r10.next(), FileNode.class, "com.obric.memorydata.plugin")).toJSON());
        goto L27
    L29:
        Iterator r13 = r11.a().iterator();
    L31:
        if (r13.hasNext() == false) goto L33;
        Logger.d(Constants.TAG, "outdatedListTopK:" + ((FileNode) ZeusTransformUtils.preCheckCast(r13.next(), FileNode.class, "com.obric.memorydata.plugin")).toJSON());
        goto L31
    L33:
        Logger.d(Constants.TAG, "insideDataSize:" + this.insideDataSize + " outsideDataSize:" + this.outsideDataSize + " insideCacheSize:" + this.insideCacheSize + " outsideCacheSize:" + this.outsideCacheSize);
    L34:
        calculateCustomDiskInfo(r0);
        return createReportEvent(r7, r8, r11, r0);
    }

    private void calculateCustomDiskInfo(File r6, List<DiskInfoNode> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.exists() == true) goto L7;
        return;
    L7:
        if (isIgnored(r6) == true) goto L17;
        AnonymousClass1 r2 = null;
        if (r6.isFile() == false) goto L14;
        long r3 = r6.length();
        DiskInfoNode r0 = new DiskInfoNode(this, r2);
        r0.isFolder = false;
        r0.path = r6.getAbsolutePath();
        r0.size = r3;
        r0.reportType = "custom";
    L12:
        r8.add(r0);
        return;
    L14:
        r0 = new DiskInfoNode(this, r2);
        r0.isFolder = true;
        r0.reportType = "custom";
        r0.path = r6.getAbsolutePath();
        r0.size = getFolderSize(r6);
        goto L12
    }

    private void calculateCustomDiskInfo(List<DiskInfoNode> r5) {
        List<DiskInfoNode> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ListUtils.isEmpty(this.customCollectPaths) == false) goto L5;
        return;
    L5:
        Iterator<String> r0 = this.customCollectPaths.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        calculateCustomDiskInfo(new File((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin")), r6);
        goto L7
    }

    private long calculateDiskInfo(File r9, List<DiskInfoNode> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        long r0 = 0;
        if (r9 != null) goto L5;
    L33:
        return r0;
    L5:
        if (r9.exists() == false) goto L33;
        if (isIgnored(r9) == true) goto L33;
        int r3 = 0;
        AnonymousClass1 r4 = null;
        if (r9.isFile() == false) goto L16;
        long r1 = r9.length();
        if (r1 >= this.config.getFileThresholdBytes()) goto L14;
        return r1;
    L14:
        DiskInfoNode r2 = new DiskInfoNode(this, r4);
        r2.isFolder = false;
        r2.path = r9.getAbsolutePath();
        r2.size = r1;
        r11.add(r2);
        return r1;
    L16:
        File[] r5 = r9.listFiles();
        if (r5 == null) goto L33;
        if (r5.length == 0) goto L33;
        DiskInfoNode r6 = new DiskInfoNode(this, r4);
        r6.isFolder = r9.isDirectory();
        r6.path = r9.getAbsolutePath();
        ArrayList r12 = new ArrayList();
        r6.nextDisk = r12;
        r11.add(r6);
        int r13 = r5.length;
    L22:
        if (r3 >= r13) goto L32;
        File r7 = r5[r3];
        if (r7 == null) goto L31;
        if (r7.exists() == false) goto L31;
        if (isIgnored(r7) == true) goto L31;
        r0 = r0 + calculateDiskInfo(r7, r12);
    L31:
        r3 = r3 + 1;
        goto L22
    L32:
        r6.size = r0;
        goto L33
    }

    private List<Node> calculateDiskTopK(String r24, v<FileNode> r25, v<FileNode> r26, v<FileNode> r27, List<String> r28) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.memorydata.plugin");
        ArrayList r13 = new ArrayList();
        File r1 = new File(r24);
        AnonymousClass1 r14 = null;
        Node r2 = new Node(this, r14);
        Node.access$002(r2, r24);
        r2.parent = new Node(this, r14);
        File[] r0 = r1.listFiles();
        if (r0 == null) goto L65;
        if (r0.length == 0) goto L65;
        if (r12.contains(r1.getAbsolutePath()) == false) goto L10;
        r13.add(r2);
        r12.remove(r1.getAbsolutePath());
    L10:
        Node.access$302(r2, r0.length);
        LinkedList r15 = new LinkedList();
        r15.offer(r2);
    L12:
        if (r15.isEmpty() == true) goto L63;
        int r6 = r15.size();
        int r7 = 0;
    L14:
        if (r7 >= r6) goto L12;
        Node r5 = (Node) ZeusTransformUtils.preCheckCast(r15.poll(), Node.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L18;
        int r19 = r7;
        LinkedList r3 = r15;
        int r16 = r6;
    L62:
        r7 = r19 + 1;
        r6 = r16;
        r15 = r3;
        goto L14
    L18:
        String r4 = Node.access$000(r5);
        File r8 = new File(r4);
        if (r8.exists() == true) goto L21;
    L61:
        r19 = r7;
        r3 = r15;
        r16 = r6;
        Node.access$310(r5.parent);
        goto L62
    L21:
        if (isIgnored(r8) == true) goto L61;
        if (r8.isFile() == false) goto L41;
        LinkedList r29 = r15;
        long r17 = r8.length();
        if (isOutOfMaxCheckSize(r17) == true) goto L30;
        r25.a(new FileNode(this, r4, r17, 1));
    L30:
        if (r5.parent != null) goto L32;
        r3 = r29;
        r16 = r6;
        r19 = r7;
        goto L62
    L32:
        r5.parent.appendChildInfo(r17, r27, r26);
        if (Node.access$400(r5.parent) == true) goto L39;
        long r18 = getOutOfDateInterval(r8.lastModified());
        if (r18 <= 0) goto L39;
        if (isOutdatedFileSizeValid(r17) == false) goto L39;
        r16 = r6;
        r19 = r7;
        r27.a(new OutdatedNode(this, r4, r6, 0, r18));
    L40:
        r3 = r29;
    L39:
        r16 = r6;
        r19 = r7;
        goto L40
    L41:
        r19 = r7;
        r29 = r15;
        r16 = r6;
        if (r12.contains(r8.getAbsolutePath()) == false) goto L44;
        r13.add(r5);
        r12.remove(r8.getAbsolutePath());
    L44:
        File[] r9 = r8.listFiles();
        if (r9 != null) goto L47;
    L60:
        r3 = r29;
        r5.parent.appendChildInfo(0, r27, r26);
        goto L62
    L47:
        if (r9.length == 0) goto L60;
        Node.access$302(r5, r9.length);
        int r10 = r9.length;
        int r11 = 0;
    L50:
        if (r11 >= r10) goto L40;
        File r20 = r9[r11];
        Node r21 = new Node(this, null);
        r21.parent = r5;
        Node.access$002(r21, r20.getAbsolutePath());
        if (r20.isDirectory() == true) goto L54;
    L58:
        File[] r110 = r9;
        int r111 = r10;
    L59:
        LinkedList r22 = r29;
        r22.offer(r21);
        r11 = r11 + 1;
        r29 = r22;
        r9 = r110;
        r10 = r111;
        goto L50
    L54:
        if (Node.access$400(r5) == true) goto L58;
        r110 = r9;
        r111 = r10;
        long r23 = getOutOfDateInterval(r20.lastModified());
        if (r23 <= 0) goto L59;
        Node.access$402(r21, true);
        Node.access$502(r21, r23);
        goto L59
    L63:
        return r13;
    L65:
        return null;
    }

    private void calculateDiskTotalSize(List<Node> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ListUtils.isEmpty(r6) == false) goto L5;
        return;
    L5:
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L20;
        Node r0 = (Node) ZeusTransformUtils.preCheckCast(r7.next(), Node.class, "com.obric.memorydata.plugin");
        if (TextUtils.equals(Node.access$000(r0), this.insideDataPath) == true) goto L10;
        if (TextUtils.equals(Node.access$000(r0), this.outsideDataPath) == true) goto L13;
        if (TextUtils.equals(Node.access$000(r0), this.insideCachePath) == true) goto L16;
        if (TextUtils.equals(Node.access$000(r0), this.outsideCachePath) == false) goto L7;
        this.outsideCacheSize = r0.size;
        goto L7
    L16:
        this.insideCacheSize = r0.size;
        goto L7
    L13:
        this.outsideDataSize = r0.size;
        goto L7
    L10:
        this.insideDataSize = r0.size;
        goto L7
    }

    private void calculateFirstLevelDiskInfo(File r4, List<DiskInfoNode> r5) {
        List<DiskInfoNode> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        File[] r7 = r4.listFiles();
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.length == 0) goto L12;
        int r0 = r7.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L13;
        calculateDiskInfo(r7[r1], r6);
        r1 = r1 + 1;
        goto L8
    L13:
        return;
    }

    private static List<String> convertFileNodeList(v<? extends FileNode> r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        LinkedList r0 = new LinkedList();
        Iterator r5 = r4.a().iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r0.add(FileNode.access$100((FileNode) ZeusTransformUtils.preCheckCast(r5.next(), FileNode.class, "com.obric.memorydata.plugin")));
        goto L7
    L9:
        return r0;
    }

    private JSONArray createDiskInfo(List<DiskInfoNode> r8, long r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.isEmpty() == true) goto L37;
        BigDecimal r0 = new BigDecimal(r9);
        JSONArray r11 = new JSONArray();
        Iterator r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L25;
        DiskInfoNode r13 = (DiskInfoNode) ZeusTransformUtils.preCheckCast(r12.next(), DiskInfoNode.class, "com.obric.memorydata.plugin");
        if (isIgnoredNode(r13) == false) goto L12;
        r13.sizeRate = 0.0f;
    L13:
        List<DiskInfoNode> r2 = r13.nextDisk;
        if (r2 == null) goto L24;
        if (r2.size() <= 0) goto L24;
        Iterator<DiskInfoNode> r3 = r2.iterator();
    L19:
        if (r3.hasNext() == false) goto L24;
        DiskInfoNode r4 = (DiskInfoNode) ZeusTransformUtils.preCheckCast(r3.next(), DiskInfoNode.class, "com.obric.memorydata.plugin");
        if (isIgnoredNode(r4) == true) goto L22;
        r4.sizeRate = getRate(r4.size, r0);
        goto L19
    L22:
        r4.sizeRate = 0.0f;
    L24:
        r11.put(r13.toJson());
        goto L8
    L12:
        r13.sizeRate = getRate(r13.size, r0);
        goto L13
    L25:
        return r11;
    L37:
        return null;
    }

    private DiskReportEvent createReportEvent(v<FileNode> r31, v<FileNode> r32, v<FileNode> r33, List<DiskInfoNode> r34) {
        List<DiskInfoNode> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.memorydata.plugin");
        long r10 = this.insideDataSize + this.outsideDataSize;     // Catch: Throwable -> L15
        long r5 = this.insideCacheSize + this.outsideCacheSize;     // Catch: Throwable -> L15
        long r14 = Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace();     // Catch: Throwable -> L15
        long r16 = Environment.getDataDirectory().getFreeSpace();     // Catch: Throwable -> L15
        long r12 = Math.min(r10, MAX_STORAGE_CHECK_VALUE_BYTES);     // Catch: Throwable -> L15
        long r6 = Math.min(r5, MAX_STORAGE_CHECK_VALUE_BYTES);     // Catch: Throwable -> L15
        if (r12 >= 0) goto L7;
        return null;
    L7:
        if (this.listener == null) goto L9;
        this.listener.a(this.config.getDiskThresholdBytes(), r12, convertFileNodeList(r31), convertFileNodeList(r32), convertFileNodeList(r33));     // Catch: Throwable -> L15
    L9:
        Pair<Long, Long> r7 = getPhoneStorage();     // Catch: Throwable -> L15
        long r8 = getAppUsage();     // Catch: Throwable -> L15
        if (ApmContext.isDebugMode() == false) goto L13;
        Logger.d(Constants.TAG, "appUsage:" + r8);     // Catch: Throwable -> L15
    L13:
        return new DiskReportEvent(r10, r6, r14, r16, r8, ((Long) ZeusTransformUtils.preCheckCast(r7.first, Long.class, "com.obric.memorydata.plugin")).longValue(), ((Long) ZeusTransformUtils.preCheckCast(r7.second, Long.class, "com.obric.memorydata.plugin")).longValue(), getRate(r8, new BigDecimal(r14)), createJSONArray(r31), createJSONArray(r32), createJSONArray(r33), createDiskInfo(r2, r12));
    L15:
        th = move-exception;
        Log.e(Constants.TAG, "error", th);
        return null;
    }

    private String findFirstCompliancePath(String r4) {
        if (ListUtils.isEmpty(this.compliancePaths) == true) goto L11;
        if (r4 == null) goto L16;
        Iterator<String> r3 = this.compliancePaths.iterator();
    L7:
        if (r3.hasNext() == false) goto L17;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        if (r4.startsWith(r0) == false) goto L7;
        return r0;
    L17:
        return null;
    L16:
        return null;
    L11:
        return null;
    }

    private long getAppUsage() {
        if (Build.VERSION.SDK_INT < 26) goto L20;
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        String r4 = r0.getPackageName();     // Catch: Throwable -> L17
        StorageStats r1 = ((StorageStatsManager) ZeusTransformUtils.preCheckCast(r0.getSystemService("storagestats"), StorageStatsManager.class, "com.obric.memorydata.plugin")).queryStatsForUid(((StorageManager) ZeusTransformUtils.preCheckCast(r0.getSystemService(Scraps.STORAGE), StorageManager.class, "com.obric.memorydata.plugin")).getUuidForPath(new File(r0.getDataDir().getParent(), r4)), r0.getPackageManager().getApplicationInfo(r4, 128).uid);     // Catch: Throwable -> L17
        if (ApmContext.isDebugMode() == false) goto L7;
        Log.e(Constants.TAG, "storageStats.getAppBytes():" + r1.getAppBytes());     // Catch: Throwable -> L17
    L7:
        return r1.getAppBytes();
    L20:
        long r3 = getFolderSize(new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getPackageManager().getApplicationInfo(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getPackageName(), 0).sourceDir).getParentFile());     // Catch: Exception -> L15
        if (ApmContext.isDebugMode() == false) goto L12;
        Log.e(Constants.TAG, "storageStats.getAppBytes():" + (((getMediaDirLength() + r3) + this.insideDataSize) + this.outsideDataSize));     // Catch: Exception -> L15
    L12:
        return ((r3 + getMediaDirLength()) + this.insideDataSize) + this.outsideDataSize;
    L15:
        return 0;
    }

    private String getCompliancePath(String r3) {
        String r2 = findFirstCompliancePath(r3);
        if (r2 == null) goto L7;
        if (r3 != null) goto L6;
        return null;
    L6:
        return r2 + r3.substring(r2.length()).replaceAll("[^/]", "*");
    L7:
        return null;
    }

    private String getExternalDir(Context r2) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getExternalFilesDir(null).getParentFile().getAbsolutePath();
    L5:
        return null;
    }

    private long getFolderSize(File r7) {
        long r0 = 0;
        File[] r8 = r7.listFiles();     // Catch: Exception -> L16
        if (r8 != null) goto L6;
    L15:
        return 0;
    L6:
        if (r8.length == 0) goto L15;
        int r2 = r8.length;     // Catch: Exception -> L16
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L18;
        File r4 = r8[r3];     // Catch: Exception -> L16
        if (r4.isDirectory() == false) goto L13;
        long r5 = getFolderSize(r4);     // Catch: Exception -> L16
    L14:
        r0 = r0 + r5;
        r3 = r3 + 1;
        goto L9
    L13:
        r5 = r4.length();     // Catch: Exception -> L16
    L18:
        return r0;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public static DiskStatistics getInstance() {
        return instance;
    }

    private long getMediaDirLength() {
        long r1 = 0;
        if (Build.VERSION.SDK_INT < 21) goto L7;
        File[] r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getExternalMediaDirs();
        int r3 = r0.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L7;
        r1 = r1 + getFolderSize(r0[r4]);
        r4 = r4 + 1;
    L7:
        return r1;
    }

    private long getOutOfDateInterval(long r3) {
        long r0 = System.currentTimeMillis() - r3;
        if (r0 >= this.config.getOutdatedIntervalMs()) goto L5;
        return 0;
    L5:
        if (r0 >= 62899200000L) goto L9;
        return r0;
    L9:
        return 0;
    }

    private Pair<Long, Long> getPhoneStorage() {
        long r2 = 0;
        if (Build.VERSION.SDK_INT < 26) goto L17;
        StorageStatsManager r14 = (StorageStatsManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSystemService("storagestats"), StorageStatsManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        StorageManager r0 = (StorageManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSystemService(Scraps.STORAGE), StorageManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        Iterator<StorageVolume> r1 = r0.getStorageVolumes().iterator();     // Catch: Throwable -> L34
        long r9 = 0;
    L7:
        if (r1.hasNext() == false) goto L14;
        String r11 = ((StorageVolume) ZeusTransformUtils.preCheckCast(r1.next(), StorageVolume.class, "com.obric.memorydata.plugin")).getUuid();     // Catch: Throwable -> L34
        if (r11 != null) goto L11;
        UUID r12 = StorageManager.UUID_DEFAULT;     // Catch: Throwable -> L34
    L12:
        r2 = r2 + r14.getTotalBytes(r12);     // Catch: Throwable -> L34
        r9 = r9 + r0.getAllocatableBytes(r12);     // Catch: Throwable -> L34
        goto L7
    L11:
        r12 = UUID.fromString(r11);     // Catch: Throwable -> L34
        goto L12
    L14:
        return new Pair(Long.valueOf((((r2 / 1000) / 1000) * 1024) * 1024), Long.valueOf((((r9 / 1000) / 1000) * 1024) * 1024));
    L17:
        if (Build.VERSION.SDK_INT < 24) goto L28;
        List<StorageVolume> r15 = ((StorageManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSystemService(Scraps.STORAGE), StorageManager.class, "com.obric.memorydata.plugin")).getStorageVolumes();     // Catch: Throwable -> L34
        if (ListUtils.isEmpty(r15) == false) goto L22;
        return null;
    L22:
        Iterator<StorageVolume> r16 = r15.iterator();     // Catch: Throwable -> L34
        long r3 = 0;
    L24:
        if (r16.hasNext() == false) goto L27;
        StorageVolume r13 = (StorageVolume) ZeusTransformUtils.preCheckCast(r16.next(), StorageVolume.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        File r17 = (File) ZeusTransformUtils.preCheckCast(reflectHideMethod(r13.getClass(), "getPathFile", new Class[0]).invoke(r13, new Object[0]), File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        r2 = r2 + r17.getTotalSpace();     // Catch: Throwable -> L34
        r3 = r3 + r17.getFreeSpace();     // Catch: Throwable -> L34
        goto L24
    L27:
        return new Pair(Long.valueOf((((r2 / 1000) / 1000) * 1024) * 1024), Long.valueOf((((r3 / 1000) / 1000) * 1024) * 1024));
    L28:
        StorageManager r18 = (StorageManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSystemService(Scraps.STORAGE), StorageManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        Iterator r19 = ((List) ZeusTransformUtils.preCheckCast(reflectHideMethod(r18.getClass(), "getVolumes", new Class[0]).invoke(r18, new Object[0]), List.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L34
        long r4 = 0;
    L30:
        if (r19.hasNext() == false) goto L33;
        Object r5 = r19.next();     // Catch: Throwable -> L34
        File r6 = (File) ZeusTransformUtils.preCheckCast(reflectHideMethod(r5.getClass(), "getPathFile", new Class[0]).invoke(r5, new Object[0]), File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        r4 = r4 + r6.getFreeSpace();     // Catch: Throwable -> L34
        r2 = r2 + r6.getFreeSpace();     // Catch: Throwable -> L34
        goto L30
    L33:
        return new Pair(Long.valueOf(r2), Long.valueOf(r4));
    L35:
        return new Pair(Long.valueOf(FileUtils.getTotalStorageSize(Environment.getDataDirectory().getPath()) + FileUtils.getTotalStorageSize(Environment.getRootDirectory().getPath())), Long.valueOf(FileUtils.getAvailableStorage(Environment.getDataDirectory().getPath())));
    }

    private float getRate(long r1, BigDecimal r3) {
        return (float) new BigDecimal(r1).divide(r3, 4, 4).doubleValue();
    }

    private void initPaths() {
        if (this.inited == false) goto L5;
        return;
    L5:
        this.inited = true;
        Application r1 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        r1.getPackageName();     // Catch: Exception -> L10
        this.insideDataPath = r1.getFilesDir().getParent();     // Catch: Exception -> L10
        this.insideCachePath = r1.getCacheDir().getAbsolutePath();     // Catch: Exception -> L10
        this.outsideDataPath = getExternalDir(r1);     // Catch: Exception -> L10
        File r2 = r1.getExternalCacheDir();     // Catch: Exception -> L10
        if (r2 == null) goto L14;
        this.outsideCachePath = r2.getAbsolutePath();     // Catch: Exception -> L10
        return;
    L14:
        return;
    L10:
        this.initException = true;
    }

    private boolean isIgnored(File r2) {
        if (ListUtils.isEmpty(this.ignoredPaths) == false) goto L5;
        return false;
    L5:
        return this.ignoredPaths.contains(r2.getAbsolutePath());
    }

    private boolean isIgnoredNode(DiskInfoNode r4) {
        Iterator<String> r3 = this.ignoredPaths.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        if (r4.path.contains(r0) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean isOutOfMaxCheckSize(long r3) {
        if (r3 >= 0) goto L5;
    L8:
        return true;
    L5:
        if (r3 > MAX_STORAGE_CHECK_VALUE_BYTES) goto L8;
        return false;
    }

    private static Method reflectHideMethod(Class r7, String r8, Class<?>... r9) {
        Method r10 = (Method) ZeusTransformUtils.preCheckCast(Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r7, new Object[]{r8, r9}), Method.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        return r10;
    L4:
        return null;
    }

    private List<String> toAbsolutePath(List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        if (ListUtils.isEmpty(r7) == false) goto L5;
        return r0;
    L5:
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L15;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        String r3 = INTERNAL_PREFIX;
        if (r2.contains(INTERNAL_PREFIX) == true) goto L10;
        r3 = EXTERNAL_PREFIX;
        if (r2.contains(EXTERNAL_PREFIX) == false) goto L7;
        String r4 = this.outsideDataPath;
    L11:
        r0.add(r2.replace(r3, r4));
        goto L7
    L10:
        r4 = this.insideDataPath;
        goto L11
    L15:
        return r0;
    }

    DiskReportEvent collect(DiskConfig r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (this.initException == false) goto L8;
        return null;
    L8:
        this.config = r3;
        initPaths();
        this.ignoredPaths = toAbsolutePath(r3.getIgnoredRelativePaths());
        this.customCollectPaths = toAbsolutePath(r3.getCustomRelativePaths());
        this.compliancePaths = toAbsolutePath(r3.getComplianceRelativePaths());
        return calculate();
    }

    JSONArray createJSONArray(v<FileNode> r4) {
        JSONArray r3 = new JSONArray();
        Iterator r5 = r4.a().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        JSONObject r0 = ((FileNode) ZeusTransformUtils.preCheckCast(r5.next(), FileNode.class, "com.obric.memorydata.plugin")).toJSON();
        if (r0 == null) goto L4;
        r3.put(r0);
        goto L4
    L8:
        return r3;
    }

    boolean isOutdatedFileSizeValid(long r3) {
        if (r3 >= 104857600) goto L5;
    L7:
        return false;
    L5:
        if (r3 > MAX_STORAGE_CHECK_VALUE_BYTES) goto L7;
        return true;
    }

    public void setListener(f r3) {
        this.listener = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
    }
}
