package com.bytedance.apm6.consumer.slardar.persistent;

import com.bytedance.apm.doctor.a;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.DiskEnvironmentHelper;
import com.bytedance.apm6.consumer.slardar.LogReporter;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.log.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public PersistentBuffer(long r7, File r9, File r10) {
        this.flushDir = r10;
        this.headerId = r7;
        FileChannel r0 = new RandomAccessFile(r9, "rw").getChannel();     // Catch: Throwable -> L5
        this.lock = r0.tryLock();     // Catch: Throwable -> L5
        this.byteBuffer = r0.map(FileChannel.MapMode.READ_WRITE, 0, 262162);     // Catch: Throwable -> L5
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

    private Monitorable createLargeEvent(JSONObject r3) {
        final JSONObject r0 = null;
        if (r3 == null) goto L5;
        final JSONObject r1 = r3.optJSONObject("service");
    L6:
        if (r3 == null) goto L9;
        r0 = r3.optJSONObject("log_type");
    L9:
        return new AnonymousClass2(this, r1, r0);
    L5:
        r1 = null;
        goto L6
    }

    private void flushToMemory() {
        this.byteBuffer.position(getTotalBytes() + 18);
        this.byteBuffer.flip();
        LogFile r3 = LogFile.fromMemory(this.byteBuffer);
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d(Constants.TAG, "flush to memory success. logFile=" + r3);
    L5:
        LogReporter.getInstance().saveLogFileInMemory(r3);
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

    private void setTotalBytes(int r2) {
        this.byteBuffer.putInt(14, r2);
    }

    private void setTotalCount(int r2) {
        this.byteBuffer.putInt(10, r2);
    }

    public synchronized void flush() {
        monitor-enter(this);
        short r0 = getMagicNumber();     // Catch: Throwable -> L51
        long r1 = getHeaderId();     // Catch: Throwable -> L51
        int r3 = getTotalCount();     // Catch: Throwable -> L51
        int r4 = getTotalBytes();     // Catch: Throwable -> L51
        if (r0 != 2082) goto L46;
        if (r4 <= 0) goto L46;
        if (r3 <= 0) goto L46;
        if (ApmContext.isDebugMode() == false) goto L11;
        Logger.d(Constants.TAG, "flushing: headerId=" + r1 + " totalCount=" + r3 + " totalBytes=" + r4);     // Catch: Throwable -> L51
    L11:
        long r2 = System.nanoTime();     // Catch: Throwable -> L51
        FileChannel r5 = null;
        boolean r6 = false;
        String r7 = System.currentTimeMillis() + "_" + UUID.randomUUID().toString();     // Catch: Throwable -> L35
    L21:
        th = move-exception;
        Logger.e(Constants.TAG, "flushDir create error.", th);     // Catch: Throwable -> L35
    L23:
        File r8 = new File(this.flushDir, r7 + SUFFIX_TMP);     // Catch: Throwable -> L35
        if (r8.exists() == false) goto L26;
        Logger.e(Constants.TAG, "file is exist:" + r8.getName());     // Catch: Throwable -> L35
    L26:
        r5 = new FileOutputStream(r8, false).getChannel();     // Catch: Throwable -> L35
        this.byteBuffer.position(r4 + 18);     // Catch: Throwable -> L35
        this.byteBuffer.flip();     // Catch: Throwable -> L35
        r5.write(this.byteBuffer);     // Catch: Throwable -> L35
        if (r8.renameTo(new File(this.flushDir, r7 + SUFFIX_LOG)) == false) goto L29;
        r6 = true;
    L31:
        if (ApmContext.isDebugMode() == false) goto L33;
        Logger.d(Constants.TAG, "flush to file success. flushFile=" + r8.getAbsolutePath());     // Catch: Throwable -> L35
    L33:
        IOUtils.closeQuietly(r5);     // Catch: Throwable -> L51
        if (r6 == true) goto L40;
        flushToMemory();     // Catch: Throwable -> L51
    L40:
        reset();     // Catch: Throwable -> L51
        if (ApmContext.isDebugMode() == false) goto L43;
        Logger.d(Constants.TAG, "flush cost=" + (System.nanoTime() - r2));     // Catch: Throwable -> L51
    L43:
        monitor-exit(this);
        return;
    L29:
        Logger.e(Constants.TAG, "rename error" + r8.getAbsolutePath());     // Catch: Throwable -> L35
        goto L31
    L15:
        if (this.flushDir.exists() == true) goto L23;
        File r9 = this.flushDir.getParentFile();     // Catch: Throwable -> L21
        if (r9.exists() == true) goto L19;
        r9.mkdirs();     // Catch: Throwable -> L21
    L19:
        this.flushDir.mkdirs();     // Catch: Throwable -> L21
    L35:
        th = move-exception;
        Logger.e(Constants.TAG, this.flushDir.exists() + " flush to file failed.", th);     // Catch: Throwable -> L54
    L46:
        if (ApmContext.isDebugMode() == false) goto L48;
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
        File[] r0 = DiskEnvironmentHelper.getFlushDirectory().listFiles(new AnonymousClass1(this));     // Catch: Throwable -> L14
        if (r0 == null) goto L6;
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L14
        int r2 = r0.length;     // Catch: Throwable -> L14
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L11;
        r1.add(r0[r3].getName());     // Catch: Throwable -> L14
        r3 = r3 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        String[] r4 = (String[]) ZeusTransformUtils.preCheckCast(r1.toArray(new String[r1.size()]), String[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        monitor-exit(this);
        return r4;
    L6:
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized void push(JSONObject r6) {
        monitor-enter(this);
        if (r6 != null) goto L30;
        monitor-exit(this);
        return;
    L30:
        String r0 = r6.toString();     // Catch: Throwable -> L27
        if (ApmContext.isDebugMode() == false) goto L9;
        a.a(r6);     // Catch: Throwable -> L27
    L9:
        byte[] r1 = r0.getBytes();     // Catch: Throwable -> L27
        int r2 = r1.length + 4;     // Catch: Throwable -> L27
        if (r2 <= 262144) goto L15;
        Monitor.record(createLargeEvent(r6));     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L15:
        if (r2 <= this.byteBuffer.remaining()) goto L17;
        flush();     // Catch: Throwable -> L27
    L17:
        this.byteBuffer.putInt(r1.length);     // Catch: Throwable -> L27
        this.byteBuffer.put(r1);     // Catch: Throwable -> L27
        setTotalCount(getTotalCount() + 1);     // Catch: Throwable -> L27
        setTotalBytes(getTotalBytes() + r2);     // Catch: Throwable -> L27
        if (ApmContext.isDebugMode() == false) goto L21;
        Logger.d(Constants.TAG, String.format("push success: totalCount=%s, totalBytes=%s, logItem=%s", new Object[]{Integer.valueOf(getTotalCount()), Integer.valueOf(getTotalBytes()), r0}));     // Catch: Throwable -> L27
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
