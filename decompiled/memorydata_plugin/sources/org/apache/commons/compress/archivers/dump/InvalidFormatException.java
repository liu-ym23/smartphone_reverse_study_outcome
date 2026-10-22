package org.apache.commons.compress.archivers.dump;

/* JADX INFO: loaded from: classes6.dex */
public class InvalidFormatException extends DumpArchiveException {
    private static final long serialVersionUID = 1;
    protected long offset;

    public InvalidFormatException() {
        super("there was an error decoding a tape segment");
    }

    public InvalidFormatException(long r3) {
        super("there was an error decoding a tape segment header at offset " + r3 + ".");
        this.offset = r3;
    }

    public long getOffset() {
        return this.offset;
    }
}
