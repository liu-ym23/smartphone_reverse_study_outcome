package org.apache.commons.compress.archivers;

/* JADX INFO: loaded from: classes6.dex */
public class StreamingNotSupportedException extends ArchiveException {
    private static final long serialVersionUID = 1;
    private final String format;

    public StreamingNotSupportedException(String r3) {
        super("The " + r3 + " doesn't support streaming.");
        this.format = r3;
    }

    public String getFormat() {
        return this.format;
    }
}
