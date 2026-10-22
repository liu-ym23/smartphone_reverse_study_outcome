package com.tencent.wcdb.extension.fts;

import com.tencent.wcdb.extension.a;

/* JADX INFO: loaded from: classes6.dex */
public final class MMFtsTokenizer implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15869a = null;

    static {
        f15869a = new MMFtsTokenizer();
    }

    private MMFtsTokenizer() {
    }

    private static native void nativeInitialize(long r0, long r2);

    @Override // com.tencent.wcdb.extension.a
    public void a(long r1, long r3) {
        nativeInitialize(r1, r3);
    }
}
