package com.bytedance.sdk.account;

import com.bytedance.sdk.account.a.a.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T extends com.bytedance.sdk.account.a.a.b> extends com.bytedance.sdk.account.a.a.a<T> {
    public c() {
    }

    @Override // com.bytedance.sdk.account.a.a.a
    public void a(T r2) {
        if (r2.f3096b == false) goto L6;
        e(r2);
        return;
    L6:
        if (b(r2) == true) goto L8;
    L10:
        a(r2, r2.d);
        return;
    L8:
        if (c(r2) == false) goto L10;
        a(r2, d(r2));
    }

    public abstract void a(T r1, int r2);

    @Deprecated
    public void a(T r1, String r2) {
    }

    @Deprecated
    public boolean b(T r1) {
        return false;
    }

    @Deprecated
    public boolean c(T r1) {
        return false;
    }

    @Deprecated
    public String d(T r1) {
        return null;
    }

    public abstract void e(T r1);
}
