package com.bytedance.apm6.consumer.slardar.send;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.DiskEnvironmentHelper;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.log.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class DiskFileHelper {
    private static final String DOT = ".";
    private static final String JOINER = "_";
    private static final String LOG = "log";
    private static final long MAX_SIZE = 5000;
    private static final String REPORT_MESSAGE = "log_report_message";
    private File directory;
    private ArrayList<String> failedFiles;
    private volatile boolean failedFilesInited;
    private volatile boolean inited;
    private long remainSize;
    private ConcurrentHashMap<String, RetryMessage> retryMessages;
    private SharedPreferences sharedPreferences;

    private static class InnerHolder {
        private static DiskFileHelper instance;

        static {
            instance = new DiskFileHelper(null);
        }

        private InnerHolder() {
        }

        static /* synthetic */ DiskFileHelper access$000() {
            return instance;
        }
    }

    static class RetryMessage {
        private static final String SPLIT = "_";
        private long nextSendTime;
        private int retryCount;

        public RetryMessage(int r1, long r2) {
            this.retryCount = r1;
            this.nextSendTime = r2;
        }

        static /* synthetic */ int access$100(RetryMessage r0) {
            return r0.retryCount;
        }

        static /* synthetic */ long access$200(RetryMessage r2) {
            return r2.nextSendTime;
        }

        public static RetryMessage parse(String r4) {
            String[] r5 = r4.split("_");     // Catch: Exception -> L4
            return new RetryMessage(Integer.parseInt(r5[0]), Long.parseLong(r5[1]));
        L4:
            return null;
        }

        public int getRetryCount() {
            return this.retryCount;
        }

        public String getString() {
            return this.retryCount + "_" + this.nextSendTime;
        }

        void update(int r1, long r2) {
            this.retryCount = r1;
            this.nextSendTime = r2;
        }
    }

    private DiskFileHelper() {
        this.retryMessages = new ConcurrentHashMap();
        this.remainSize = 0;
        this.failedFilesInited = false;
        this.failedFiles = new ArrayList();
    }

    /* synthetic */ DiskFileHelper(AnonymousClass1 r1) {
        this();
    }

    private void add(String r5) {
        if (this.failedFiles.size() <= 5000) goto L6;
        this.remainSize++;
        return;
    L6:
        this.failedFiles.add(r5);
    }

    private synchronized void ensureInit() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.inited == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        File r0 = new File(DiskEnvironmentHelper.getWorkingDirectory(), LOG);     // Catch: Throwable -> L13
        if (r0.exists() == true) goto L10;
        r0.mkdirs();     // Catch: Throwable -> L13
    L10:
        this.directory = r0;     // Catch: Throwable -> L13
        this.sharedPreferences = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSharedPreferences(REPORT_MESSAGE, 0);     // Catch: Throwable -> L13
        this.inited = true;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    static long getCreateTime(File r4) {
        String[] r5 = r4.getName().split("_");     // Catch: Throwable -> L8
        if (r5.length == 2) goto L6;
        return -1;
    L6:
        return Long.parseLong(r5[0]);
    L11:
        return -1;
    }

    static DiskFileHelper getInstance() {
        return InnerHolder.access$000();
    }

    private synchronized void initFailedFiles() {
        monitor-enter(this);
        int r1 = 0;
        if (this.failedFilesInited == true) goto L13;
        String[] r0 = getInstance().getDirectory().list();     // Catch: Throwable -> L25
        int r2 = r0.length;     // Catch: Throwable -> L25
    L6:
        if (r1 >= r2) goto L11;
        String r3 = r0[r1];     // Catch: Throwable -> L25
        if (this.failedFiles.contains(r3) == true) goto L10;
        add(r3);     // Catch: Throwable -> L25
    L10:
        r1 = r1 + 1;     // Catch: Throwable -> L25
        goto L6
    L11:
        this.failedFilesInited = true;     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L13:
        if (this.remainSize <= 0) goto L23;
        if (this.failedFiles.size() != 0) goto L23;
        String[] r4 = getInstance().getDirectory().list();     // Catch: Throwable -> L25
        int r5 = r4.length;     // Catch: Throwable -> L25
    L17:
        if (r1 >= r5) goto L22;
        String r6 = r4[r1];     // Catch: Throwable -> L25
        if (this.failedFiles.contains(r6) == true) goto L21;
        add(r6);     // Catch: Throwable -> L25
    L21:
        r1 = r1 + 1;     // Catch: Throwable -> L25
        goto L17
    L22:
        this.remainSize -= (long) this.failedFiles.size();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    synchronized void deleteLog(File r3) {
        monitor-enter(this);
        if (r3 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.failedFiles.remove(r3.getName());     // Catch: Throwable -> L9
        ensureInit();     // Catch: Throwable -> L9
        FileUtils.deleteFile(r3);     // Catch: Throwable -> L9
        this.retryMessages.remove(r3.getName());     // Catch: Throwable -> L9
        SharedPreferences.Editor r0 = this.sharedPreferences.edit();     // Catch: Throwable -> L9
        r0.remove(r3.getName());     // Catch: Throwable -> L9
        r0.commit();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    File getDirectory() {
        ensureInit();
        return this.directory;
    }

    RetryMessage getReportMessage(File r4) {
        RetryMessage r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        ensureInit();
        String r5 = r4.getName();
        if (this.retryMessages.containsKey(r5) == false) goto L10;
        return (RetryMessage) ZeusTransformUtils.preCheckCast(this.retryMessages.get(r5), RetryMessage.class, "com.obric.memorydata.plugin");
    L10:
        if (this.sharedPreferences.contains(r5) == false) goto L16;
        String r1 = this.sharedPreferences.getString(r5, "");
        if (TextUtils.isEmpty(r1) == true) goto L14;
        r0 = RetryMessage.parse(r1);
    L14:
        if (r0 == null) goto L16;
        this.retryMessages.put(r5, r0);
    L16:
        return r0;
    }

    synchronized File getSendFile(String r9) {
        monitor-enter(this);
        String r10 = DOT + r9;     // Catch: Throwable -> L43
        initFailedFiles();     // Catch: Throwable -> L43
        if (ApmContext.isDebugMode() == false) goto L7;
        Logger.d(Constants.TAG, "failedFiles:" + this.failedFiles + " " + r10);     // Catch: Throwable -> L43
    L7:
        File r1 = null;
        if (this.failedFiles.size() != 0) goto L11;
        monitor-exit(this);
        return null;
    L11:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L43
        Iterator<String> r2 = this.failedFiles.iterator();     // Catch: Throwable -> L43
    L13:
        if (r2.hasNext() == false) goto L18;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        if (r3.endsWith(r10) == false) goto L13;
        r0.add(r3);     // Catch: Throwable -> L43
        goto L13
    L18:
        if (ListUtils.isEmpty(r0) == false) goto L21;
        monitor-exit(this);
        return null;
    L21:
        Collections.sort(r0, new AnonymousClass1(this));     // Catch: Throwable -> L43
        Iterator r11 = r0.iterator();     // Catch: Throwable -> L43
        RetryMessage r4 = null;
    L22:
        if (r11.hasNext() == false) goto L41;
        File r5 = new File(getInstance().getDirectory(), (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L43
        RetryMessage r6 = getReportMessage(r5);     // Catch: Throwable -> L43
        if (r6 == null) goto L40;
        if (ApmContext.isDebugMode() == false) goto L31;
        Logger.d(Constants.TAG, "list send file:" + r5.getName() + " " + RetryMessage.access$100(r6) + " " + RetryMessage.access$200(r6) + " " + System.currentTimeMillis());     // Catch: Throwable -> L43
    L31:
        if (RetryMessage.access$100(r6) == 0) goto L40;
        if (RetryMessage.access$200(r6) < System.currentTimeMillis()) goto L40;
        if (r4 == null) goto L39;
        if (RetryMessage.access$200(r4) <= RetryMessage.access$200(r6)) goto L22;
    L39:
        r4 = r6;
        r1 = r5;
    L40:
        r1 = r5;
    L41:
        monitor-exit(this);
        return r1;
    L43:
        th = move-exception;
        throw th;
    }

    File[] listFiles() {
        ensureInit();
        File r0 = this.directory;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.listFiles();
    }

    synchronized boolean saveFile(byte[] r7, String r8, int r9, long r10) {
        monitor-enter(this);
        ensureInit();     // Catch: Throwable -> L27
        if (this.directory != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        String r11 = String.format("%d%s%s%s%s", new Object[]{Long.valueOf(System.currentTimeMillis()), "_", UUID.randomUUID().toString(), DOT, r8});     // Catch: Throwable -> L27
        File r0 = new File(this.directory, r11);     // Catch: Throwable -> L27
        FileChannel r2 = null;
        updateRetryMessage(r0, r9, r10);     // Catch: Throwable -> L19
        r2 = new FileOutputStream(r0).getChannel();     // Catch: Throwable -> L19
        r2.write(ByteBuffer.wrap(r7));     // Catch: Throwable -> L19
        if (this.failedFiles.contains(r11) == true) goto L14;
        add(r11);     // Catch: Throwable -> L19
    L14:
        if (ApmContext.isDebugMode() == false) goto L16;
        Logger.d(Constants.TAG, "saveFile:" + r0.getName());     // Catch: Throwable -> L19
    L16:
        IOUtils.closeQuietly(r2);     // Catch: Throwable -> L27
        monitor-exit(this);
        return true;
    L19:
        th = move-exception;
        Logger.e(Constants.TAG, "saveFile", th);     // Catch: Throwable -> L24
        IOUtils.closeQuietly(r2);     // Catch: Throwable -> L27
        return false;
    L24:
        th = move-exception;
        IOUtils.closeQuietly(r2);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    void updateRetryMessage(File r4, int r5, long r6) {
        if (r4 != null) goto L13;
        return;
    L13:
        ensureInit();     // Catch: Throwable -> L10
        SharedPreferences.Editor r0 = this.sharedPreferences.edit();     // Catch: Throwable -> L10
        String r7 = r4.getName();     // Catch: Throwable -> L10
        if (this.retryMessages.containsKey(r7) == false) goto L7;
        RetryMessage r3 = (RetryMessage) ZeusTransformUtils.preCheckCast(this.retryMessages.get(r7), RetryMessage.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L8:
        r3.update(r5, r6);     // Catch: Throwable -> L10
        r0.putString(r7, r3.getString());     // Catch: Throwable -> L10
        r0.commit();     // Catch: Throwable -> L10
        return;
    L7:
        RetryMessage r1 = new RetryMessage(r5, r6);     // Catch: Throwable -> L10
        this.retryMessages.put(r7, r1);     // Catch: Throwable -> L10
        r3 = r1;
    L10:
        th = move-exception;
        Logger.e(Constants.TAG, "updateRetryMessage", th);
    }
}
