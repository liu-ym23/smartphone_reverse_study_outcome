package com.bytedance.apm6.consumer.slardar.persistent;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.log.Logger;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LogFile {
    private List<LogItem> logList;
    private File source;
    private long startID;
    private int totalBytes;
    private int totalCount;

    public LogFile(long r10, int r11, int r12, List<LogItem> r13) {
        this.startID = r10;
        this.totalCount = r11;
        this.totalBytes = r12;
        this.logList = r13;
    }

    public static LogFile fromFile(File r10) {
        byte[] r11 = FileUtils.readFileToByteArray(r10);     // Catch: Throwable -> L11
        if (r11 == null) goto L9;
        LogFile r12 = fromMemory(ByteBuffer.wrap(r11));     // Catch: Throwable -> L11
        if (r12 == null) goto L7;
        r12.source = r10;     // Catch: Throwable -> L11
    L8:
        return r12;
    L7:
        Logger.e(Constants.TAG, "fromMemory bytes is null");     // Catch: Throwable -> L11
        goto L8
    L9:
        Logger.e(Constants.TAG, "fromFile bytes is null");     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        Logger.e(Constants.TAG, "fromFile", th);
        return null;
    }

    public static LogFile fromMemory(ByteBuffer r10) {
    L14:
        return null;
    L4:
        if (r10.getShort() == 2082) goto L6;
        return null;
    L6:
        long r11 = r10.getLong();     // Catch: Throwable -> L14
        int r12 = r10.getInt();     // Catch: Throwable -> L14
        int r13 = r10.getInt();     // Catch: Throwable -> L14
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L14
        int r15 = 0;
        int r16 = 0;
    L7:
        if (r15 >= r12) goto L12;
        int r17 = r10.getInt();     // Catch: Throwable -> L14
        r16 = r16 + r17;     // Catch: Throwable -> L14
        if (r16 > r13) goto L10;
        byte[] r18 = new byte[r17];     // Catch: Throwable -> L14
        r10.get(r18);     // Catch: Throwable -> L14
        r14.add(new LogItem(r18));     // Catch: Throwable -> L14
        r15 = r15 + 1;     // Catch: Throwable -> L14
        goto L7
    L10:
        return null;
    L12:
        return new LogFile(r11, r12, r13, r14);
    }

    public List<LogItem> getLogList() {
        return this.logList;
    }

    public File getSource() {
        return this.source;
    }

    public long getStartID() {
        return this.startID;
    }

    public int getTotalBytes() {
        return this.totalBytes;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public String toString() {
        return "LogFile{startID=" + this.startID + ", totalCount=" + this.totalCount + ", totalBytes=" + this.totalBytes + ", source=" + this.source + ", logList=" + this.logList + '}';
    }
}
