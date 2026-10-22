package com.bytedance.apm6.consumer.slardar;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
public class SeqNumGenerator {
    private MappedByteBuffer byteBuffer;
    private long seqNum;

    private static class InnerHolder {
        private static final SeqNumGenerator instance = null;

        static {
            instance = new SeqNumGenerator();
        }

        private InnerHolder() {
        }

        static /* synthetic */ SeqNumGenerator access$000() {
            return instance;
        }
    }

    public SeqNumGenerator() {
        this.seqNum = 0;
    }

    public static SeqNumGenerator getInstance() {
        return InnerHolder.access$000();
    }

    public long next() {
        if (this.byteBuffer == null) goto L19;
    L13:
        MappedByteBuffer r10 = this.byteBuffer;
        if (r10 == null) goto L17;
        long r11 = r10.getLong(0) + 1;
        this.seqNum = r11;
        this.byteBuffer.putLong(0, r11);
        return this.seqNum;
    L17:
        long r12 = this.seqNum;
        this.seqNum = 1 + r12;
        return r12;
    L19:
        File r13 = new File(DiskEnvironmentHelper.getWorkingDirectory(), ApmContext.getCurrentProcessName().replace(".", "_").replace(":", "-") + "_seq_num.txt");     // Catch: Throwable -> L11
        boolean r14 = r13.exists();     // Catch: Throwable -> L11
        if (r14 == true) goto L7;
        r13.createNewFile();     // Catch: Throwable -> L11
    L7:
        MappedByteBuffer r15 = new RandomAccessFile(r13, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 8);     // Catch: Throwable -> L11
        this.byteBuffer = r15;     // Catch: Throwable -> L11
        if (r14 == true) goto L13;
        r15.putLong(0, 0);     // Catch: Throwable -> L11
        return 0;
    L11:
        th = move-exception;
        Logger.e(Constants.TAG, "prepare seq_number fail.", th);
        goto L13
    }
}
