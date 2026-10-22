package org.apache.commons.compress;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class MemoryLimitException extends IOException {
    private static final long serialVersionUID = 1;
    private final int memoryLimitInKb;
    private final long memoryNeededInKb;

    public MemoryLimitException(long r2, int r4) {
        super(buildMessage(r2, r4));
        this.memoryNeededInKb = r2;
        this.memoryLimitInKb = r4;
    }

    public MemoryLimitException(long r2, int r4, Exception r5) {
        super(buildMessage(r2, r4), r5);
        this.memoryNeededInKb = r2;
        this.memoryLimitInKb = r4;
    }

    private static String buildMessage(long r1, int r3) {
        return r1 + " kb of memory would be needed; limit was " + r3 + " kb. If the file is not corrupt, consider increasing the memory limit.";
    }

    public int getMemoryLimitInKb() {
        return this.memoryLimitInKb;
    }

    public long getMemoryNeededInKb() {
        return this.memoryNeededInKb;
    }
}
