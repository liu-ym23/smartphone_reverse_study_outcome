package com.bytedance.sdk.xbridge.cn.storage.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f7484b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f7485a;

    static {
        f7484b = new c(NativeStorageImpl$Companion$1.f7479a);
    }

    public d(Context r5) {
        if (r5 == null) goto L5;
        SharedPreferences r10 = r5.getSharedPreferences("xbridge-storage", 0);
    L6:
        this.f7485a = r10;
        return;
    L5:
        r10 = null;
        goto L6
    }
}
