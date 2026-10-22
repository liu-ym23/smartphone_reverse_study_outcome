package com.bytedance.apm6.consumer.slardar.send;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.DiskEnvironmentHelper;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.log.Logger;
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

        public RetryMessage(int r10, long r11) {
            this.retryCount = r10;
            this.nextSendTime = r11;
        }

        static /* synthetic */ int access$100(RetryMessage r10) {
            return r10.retryCount;
        }

        static /* synthetic */ long access$200(RetryMessage r10) {
            return r10.nextSendTime;
        }

        public static RetryMessage parse(String r10) {
            String[] r11 = r10.split("_");     // Catch: Exception -> L4
            return new RetryMessage(Integer.parseInt(r11[0]), Long.parseLong(r11[1]));
        L4:
            return null;
        }

        public int getRetryCount() {
            return this.retryCount;
        }

        public String getString() {
            return this.retryCount + "_" + this.nextSendTime;
        }

        void update(int r10, long r11) {
            this.retryCount = r10;
            this.nextSendTime = r11;
        }
    }

    private DiskFileHelper() {
        this.retryMessages = new ConcurrentHashMap();
        this.remainSize = 0;
        this.failedFilesInited = false;
        this.failedFiles = new ArrayList();
    }

    /* synthetic */ DiskFileHelper(AnonymousClass1 r10) {
        this();
    }

    private void add(String r10) {
        if (this.failedFiles.size() <= MAX_SIZE) goto L6;
        this.remainSize++;
        return;
    L6:
        this.failedFiles.add(r10);
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
        File r10 = new File(DiskEnvironmentHelper.getWorkingDirectory(), LOG);     // Catch: Throwable -> L13
        if (r10.exists() == true) goto L10;
        r10.mkdirs();     // Catch: Throwable -> L13
    L10:
        this.directory = r10;     // Catch: Throwable -> L13
        this.sharedPreferences = ApmBaseContext.getContext().getSharedPreferences(REPORT_MESSAGE, 0);     // Catch: Throwable -> L13
        this.inited = true;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    static long getCreateTime(File r10) {
        String[] r11 = r10.getName().split("_");     // Catch: Throwable -> L8
        if (r11.length == 2) goto L6;
        return -1;
    L6:
        return Long.parseLong(r11[0]);
    L11:
        return -1;
    }

    static DiskFileHelper getInstance() {
        return InnerHolder.access$000();
    }

    private synchronized void initFailedFiles() {
        monitor-enter(this);
        int r10 = 0;
        if (this.failedFilesInited == true) goto L13;
        String[] r11 = getInstance().getDirectory().list();     // Catch: Throwable -> L25
        int r12 = r11.length;     // Catch: Throwable -> L25
    L6:
        if (r10 >= r12) goto L11;
        String r13 = r11[r10];     // Catch: Throwable -> L25
        if (this.failedFiles.contains(r13) == true) goto L10;
        add(r13);     // Catch: Throwable -> L25
    L10:
        r10 = r10 + 1;     // Catch: Throwable -> L25
        goto L6
    L11:
        this.failedFilesInited = true;     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L13:
        if (this.remainSize <= 0) goto L23;
        if (this.failedFiles.size() != 0) goto L23;
        String[] r14 = getInstance().getDirectory().list();     // Catch: Throwable -> L25
        int r15 = r14.length;     // Catch: Throwable -> L25
    L17:
        if (r10 >= r15) goto L22;
        String r16 = r14[r10];     // Catch: Throwable -> L25
        if (this.failedFiles.contains(r16) == true) goto L21;
        add(r16);     // Catch: Throwable -> L25
    L21:
        r10 = r10 + 1;     // Catch: Throwable -> L25
        goto L17
    L22:
        this.remainSize -= (long) this.failedFiles.size();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"ApplySharedPref"})
    synchronized void deleteLog(File r10) {
        monitor-enter(this);
        if (r10 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.failedFiles.remove(r10.getName());     // Catch: Throwable -> L9
        ensureInit();     // Catch: Throwable -> L9
        FileUtils.deleteFile(r10);     // Catch: Throwable -> L9
        this.retryMessages.remove(r10.getName());     // Catch: Throwable -> L9
        SharedPreferences.Editor r11 = this.sharedPreferences.edit();     // Catch: Throwable -> L9
        r11.remove(r10.getName());     // Catch: Throwable -> L9
        r11.commit();     // Catch: Throwable -> L9
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

    RetryMessage getReportMessage(File r10) {
        RetryMessage r11 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        ensureInit();
        String r12 = r10.getName();
        if (this.retryMessages.containsKey(r12) == false) goto L10;
        return this.retryMessages.get(r12);
    L10:
        if (this.sharedPreferences.contains(r12) == false) goto L16;
        String r13 = this.sharedPreferences.getString(r12, "");
        if (TextUtils.isEmpty(r13) == true) goto L14;
        r11 = RetryMessage.parse(r13);
    L14:
        if (r11 == null) goto L16;
        this.retryMessages.put(r12, r11);
    L16:
        return r11;
    }

    synchronized File getSendFile(String r10) {
        monitor-enter(this);
        String r11 = DOT + r10;     // Catch: Throwable -> L43
        initFailedFiles();     // Catch: Throwable -> L43
        if (ApmBaseContext.isDebugMode() == false) goto L7;
        Logger.d(Constants.TAG, "failedFiles:" + this.failedFiles + " " + r11);     // Catch: Throwable -> L43
    L7:
        File r12 = null;
        if (this.failedFiles.size() != 0) goto L11;
        monitor-exit(this);
        return null;
    L11:
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L43
        Iterator<String> r14 = this.failedFiles.iterator();     // Catch: Throwable -> L43
    L13:
        if (r14.hasNext() == false) goto L18;
        String r15 = r14.next();     // Catch: Throwable -> L43
        if (r15.endsWith(r11) == false) goto L13;
        r13.add(r15);     // Catch: Throwable -> L43
        goto L13
    L18:
        if (ListUtils.isEmpty(r13) == false) goto L21;
        monitor-exit(this);
        return null;
    L21:
        Collections.sort(r13, new AnonymousClass1(this));     // Catch: Throwable -> L43
        Iterator r16 = r13.iterator();     // Catch: Throwable -> L43
        RetryMessage r17 = null;
    L22:
        if (r16.hasNext() == false) goto L41;
        File r18 = new File(getInstance().getDirectory(), (String) r16.next());     // Catch: Throwable -> L43
        RetryMessage r19 = getReportMessage(r18);     // Catch: Throwable -> L43
        if (r19 == null) goto L40;
        if (ApmBaseContext.isDebugMode() == false) goto L31;
        Logger.d(Constants.TAG, "list send file:" + r18.getName() + " " + RetryMessage.access$100(r19) + " " + RetryMessage.access$200(r19) + " " + System.currentTimeMillis());     // Catch: Throwable -> L43
    L31:
        if (RetryMessage.access$100(r19) == 0) goto L40;
        if (RetryMessage.access$200(r19) < System.currentTimeMillis()) goto L40;
        if (r17 == null) goto L39;
        if (RetryMessage.access$200(r17) <= RetryMessage.access$200(r19)) goto L22;
    L39:
        r17 = r19;
        r12 = r18;
    L40:
        r12 = r18;
    L41:
        monitor-exit(this);
        return r12;
    L43:
        th = move-exception;
        throw th;
    }

    File[] listFiles() {
        ensureInit();
        File r10 = this.directory;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.listFiles();
    }

    synchronized boolean saveFile(byte[] r10, String r11, int r12, long r13) {
        monitor-enter(this);
        ensureInit();     // Catch: Throwable -> L27
        if (this.directory != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        String r14 = String.format("%d%s%s%s%s", new Object[]{Long.valueOf(System.currentTimeMillis()), "_", UUID.randomUUID().toString(), DOT, r11});     // Catch: Throwable -> L27
        File r15 = new File(this.directory, r14);     // Catch: Throwable -> L27
        FileChannel r16 = null;
        updateRetryMessage(r15, r12, r13);     // Catch: Throwable -> L19
        r16 = new FileOutputStream(r15).getChannel();     // Catch: Throwable -> L19
        r16.write(ByteBuffer.wrap(r10));     // Catch: Throwable -> L19
        if (this.failedFiles.contains(r14) == true) goto L14;
        add(r14);     // Catch: Throwable -> L19
    L14:
        if (ApmBaseContext.isDebugMode() == false) goto L16;
        Logger.d(Constants.TAG, "saveFile:" + r15.getName());     // Catch: Throwable -> L19
    L16:
        IOUtils.closeQuietly(r16);     // Catch: Throwable -> L27
        monitor-exit(this);
        return true;
    L19:
        th = move-exception;
        Logger.e(Constants.TAG, "saveFile", th);     // Catch: Throwable -> L24
        IOUtils.closeQuietly(r16);     // Catch: Throwable -> L27
        return false;
    L24:
        th = move-exception;
        IOUtils.closeQuietly(r16);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"ApplySharedPref"})
    void updateRetryMessage(File r10, int r11, long r12) {
        if (r10 != null) goto L13;
        return;
    L13:
        ensureInit();     // Catch: Throwable -> L10
        SharedPreferences.Editor r13 = this.sharedPreferences.edit();     // Catch: Throwable -> L10
        String r14 = r10.getName();     // Catch: Throwable -> L10
        if (this.retryMessages.containsKey(r14) == false) goto L7;
        RetryMessage r15 = this.retryMessages.get(r14);     // Catch: Throwable -> L10
    L8:
        r15.update(r11, r12);     // Catch: Throwable -> L10
        r13.putString(r14, r15.getString());     // Catch: Throwable -> L10
        r13.commit();     // Catch: Throwable -> L10
        return;
    L7:
        RetryMessage r16 = new RetryMessage(r11, r12);     // Catch: Throwable -> L10
        this.retryMessages.put(r14, r16);     // Catch: Throwable -> L10
        r15 = r16;
    L10:
        th = move-exception;
        Logger.e(Constants.TAG, "updateRetryMessage", th);
    }
}
