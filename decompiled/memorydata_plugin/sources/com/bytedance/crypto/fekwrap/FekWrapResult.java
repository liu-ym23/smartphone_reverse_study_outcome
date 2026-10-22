package com.bytedance.crypto.fekwrap;

/* JADX INFO: loaded from: classes2.dex */
public final class FekWrapResult {
    public final int code;
    public final String wrapKeyAlias;
    public final byte[] wrappedFekBlob;

    public FekWrapResult(int r1, String r2, byte[] r3) {
        this.code = r1;
        this.wrapKeyAlias = r2;
        if (r3 != null) goto L5;
        r3 = new byte[0];
    L5:
        this.wrappedFekBlob = r3;
    }
}
