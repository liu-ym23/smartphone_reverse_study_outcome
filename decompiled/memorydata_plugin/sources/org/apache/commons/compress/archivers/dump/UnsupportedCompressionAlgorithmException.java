package org.apache.commons.compress.archivers.dump;

/* JADX INFO: loaded from: classes6.dex */
public class UnsupportedCompressionAlgorithmException extends DumpArchiveException {
    private static final long serialVersionUID = 1;

    public UnsupportedCompressionAlgorithmException() {
        super("this file uses an unsupported compression algorithm.");
    }

    public UnsupportedCompressionAlgorithmException(String r3) {
        super("this file uses an unsupported compression algorithm: " + r3 + ".");
    }
}
