package com.ss.android.account;

import com.ss.android.e;

/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.ss.android.d f14992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile e f14993b;
    private static volatile com.bytedance.sdk.account.utils.c c;

    public static com.ss.android.d a() {
        if (f14992a == null) goto L7;
        return f14992a;
    L7:
        throw new IllegalStateException("not init TTAccount config");
    }

    public static e b() {
        return f14993b;
    }

    public static com.bytedance.sdk.account.utils.c c() {
        return c;
    }
}
