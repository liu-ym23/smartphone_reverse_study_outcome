package com.bytedance.apm6.consumer.slardar.persistent;

import a0.a;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.DiskEnvironmentHelper;
import com.bytedance.apm6.consumer.slardar.LogReporter;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.log.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PersistentBuffer {
    private static final int BUFFER_SIZE = 262162;
    private static final int HEADER_SIZE = 18;
    public static final short MAGIC_NUMBER = 2082;
    private static final int MAX_DATA_SIZE = 262144;
    private static final String SUFFIX_LOG = ".log";
    private static final String SUFFIX_TMP = ".txt";
    private static final int TOTAL_BYTES_THRESHOLD = 262134;
    private static final int TOTAL_COUNT_THRESHOLD = 256;
    private ByteBuffer byteBuffer;
    private final File flushDir;
    private final long headerId;
    private FileLock lock;

    public PersistentBuffer(long r10, File r11, File r12) {
        this.flushDir = r12;
        this.headerId = r10;
        FileChannel r13 = new RandomAccessFile(r11, "rw").getChannel();     // Catch: Throwable -> L5
        this.lock = r13.tryLock();     // Catch: Throwable -> L5
        this.byteBuffer = r13.map(FileChannel.MapMode.READ_WRITE, 0, 262162);     // Catch: Throwable -> L5
        flush();     // Catch: Throwable -> L5
    L8:
        if (this.byteBuffer != null) goto L10;
        this.byteBuffer = ByteBuffer.allocate(BUFFER_SIZE);
    L10:
        reset();
        return;
    L5:
        th = move-exception;
        Logger.e(Constants.TAG, "create MappedByteBuffer failed. will fallback into HeapByteBuffer", th);
        goto L8
    }

    private Monitorable createLargeEvent(JSONObject r10) {
        final JSONObject r11 = null;
        if (r10 == null) goto L5;
        final JSONObject r12 = r10.optJSONObject("service");
    L6:
        if (r10 == null) goto L9;
        r11 = r10.optJSONObject("log_type");
    L9:
        return new AnonymousClass2(this, r12, r11);
    L5:
        r12 = null;
        goto L6
    }

    private void flushToMemory() {
        this.byteBuffer.position(getTotalBytes() + 18);
        this.byteBuffer.flip();
        LogFile r10 = LogFile.fromMemory(this.byteBuffer);
        if (ApmBaseContext.isDebugMode() == false) goto L5;
        Logger.d(Constants.TAG, "flush to memory success. logFile=" + r10);
    L5:
        LogReporter.getInstance().saveLogFileInMemory(r10);
    }

    private long getHeaderId() {
        return this.byteBuffer.getLong(2);
    }

    private short getMagicNumber() {
        return this.byteBuffer.getShort(0);
    }

    private int getTotalBytes() {
        return this.byteBuffer.getInt(14);
    }

    private int getTotalCount() {
        return this.byteBuffer.getInt(10);
    }

    private void reset() {
        this.byteBuffer.clear();
        this.byteBuffer.putShort(MAGIC_NUMBER);
        this.byteBuffer.putLong(this.headerId);
        this.byteBuffer.putInt(0);
        this.byteBuffer.putInt(0);
    }

    private void setTotalBytes(int r10) {
        this.byteBuffer.putInt(14, r10);
    }

    private void setTotalCount(int r10) {
        this.byteBuffer.putInt(10, r10);
    }

    public synchronized void flush() {
        monitor-enter(this);
        short r10 = getMagicNumber();     // Catch: Throwable -> L51
        long r11 = getHeaderId();     // Catch: Throwable -> L51
        int r12 = getTotalCount();     // Catch: Throwable -> L51
        int r13 = getTotalBytes();     // Catch: Throwable -> L51
        if (r10 != 2082) goto L46;
        if (r13 <= 0) goto L46;
        if (r12 <= 0) goto L46;
        if (ApmBaseContext.isDebugMode() == false) goto L11;
        Logger.d(Constants.TAG, "flushing: headerId=" + r11 + " totalCount=" + r12 + " totalBytes=" + r13);     // Catch: Throwable -> L51
    L11:
        long r14 = System.nanoTime();     // Catch: Throwable -> L51
        FileChannel r15 = null;
        boolean r16 = false;
        String r17 = System.currentTimeMillis() + "_" + UUID.randomUUID().toString();     // Catch: Throwable -> L35
    L21:
        th = move-exception;
        Logger.e(Constants.TAG, "flushDir create error.", th);     // Catch: Throwable -> L35
    L23:
        File r18 = new File(this.flushDir, r17 + SUFFIX_TMP);     // Catch: Throwable -> L35
        if (r18.exists() == false) goto L26;
        Logger.e(Constants.TAG, "file is exist:" + r18.getName());     // Catch: Throwable -> L35
    L26:
        r15 = new FileOutputStream(r18, false).getChannel();     // Catch: Throwable -> L35
        this.byteBuffer.position(r13 + 18);     // Catch: Throwable -> L35
        this.byteBuffer.flip();     // Catch: Throwable -> L35
        r15.write(this.byteBuffer);     // Catch: Throwable -> L35
        if (r18.renameTo(new File(this.flushDir, r17 + SUFFIX_LOG)) == false) goto L29;
        r16 = true;
    L31:
        if (ApmBaseContext.isDebugMode() == false) goto L33;
        Logger.d(Constants.TAG, "flush to file success. flushFile=" + r18.getAbsolutePath());     // Catch: Throwable -> L35
    L33:
        IOUtils.closeQuietly(r15);     // Catch: Throwable -> L51
        if (r16 == true) goto L40;
        flushToMemory();     // Catch: Throwable -> L51
    L40:
        reset();     // Catch: Throwable -> L51
        if (ApmBaseContext.isDebugMode() == false) goto L43;
        Logger.d(Constants.TAG, "flush cost=" + (System.nanoTime() - r14));     // Catch: Throwable -> L51
    L43:
        monitor-exit(this);
        return;
    L29:
        Logger.e(Constants.TAG, "rename error" + r18.getAbsolutePath());     // Catch: Throwable -> L35
        goto L31
    L15:
        if (this.flushDir.exists() == true) goto L23;
        File r19 = this.flushDir.getParentFile();     // Catch: Throwable -> L21
        if (r19.exists() == true) goto L19;
        r19.mkdirs();     // Catch: Throwable -> L21
    L19:
        this.flushDir.mkdirs();     // Catch: Throwable -> L21
    L35:
        th = move-exception;
        Logger.e(Constants.TAG, this.flushDir.exists() + " flush to file failed.", th);     // Catch: Throwable -> L54
    L46:
        if (ApmBaseContext.isDebugMode() == false) goto L48;
        Logger.d(Constants.TAG, "flushing: Skipped. no data to flush. reset buffer now.");     // Catch: Throwable -> L51
    L48:
        reset();     // Catch: Throwable -> L51
        monitor-exit(this);
        return;
    L51:
        th = move-exception;
        throw th;
    }

    public synchronized String[] list() {
        monitor-enter(this);
        File[] r10 = DiskEnvironmentHelper.getFlushDirectory().listFiles(new AnonymousClass1(this));     // Catch: Throwable -> L14
        if (r10 == null) goto L6;
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L14
        int r12 = r10.length;     // Catch: Throwable -> L14
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L11;
        r11.add(r10[r13].getName());     // Catch: Throwable -> L14
        r13 = r13 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        String[] r14 = (String[]) r11.toArray(new String[r11.size()]);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r14;
    L6:
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized void push(JSONObject r10) {
        monitor-enter(this);
        if (r10 != null) goto L30;
        monitor-exit(this);
        return;
    L30:
        String r11 = r10.toString();     // Catch: Throwable -> L27
        if (ApmBaseContext.isDebugMode() == false) goto L9;
        a.c(r10);     // Catch: Throwable -> L27
    L9:
        byte[] r12 = r11.getBytes();     // Catch: Throwable -> L27
        int r13 = r12.length + 4;     // Catch: Throwable -> L27
        if (r13 <= 262144) goto L15;
        Monitor.record(createLargeEvent(r10));     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L15:
        if (r13 <= this.byteBuffer.remaining()) goto L17;
        flush();     // Catch: Throwable -> L27
    L17:
        this.byteBuffer.putInt(r12.length);     // Catch: Throwable -> L27
        this.byteBuffer.put(r12);     // Catch: Throwable -> L27
        setTotalCount(getTotalCount() + 1);     // Catch: Throwable -> L27
        setTotalBytes(getTotalBytes() + r13);     // Catch: Throwable -> L27
        if (ApmBaseContext.isDebugMode() == false) goto L21;
        Logger.d(Constants.TAG, String.format("push success: totalCount=%s, totalBytes=%s, logItem=%s", new Object[]{Integer.valueOf(getTotalCount()), Integer.valueOf(getTotalBytes()), r11}));     // Catch: Throwable -> L27
    L21:
        if (this.byteBuffer.position() < TOTAL_BYTES_THRESHOLD) goto L23;
    L24:
        flush();     // Catch: Throwable -> L27
    L25:
        monitor-exit(this);
        return;
    L23:
        if (getTotalCount() < 256) goto L25;
    L27:
        th = move-exception;
        throw th;
    }
}
