package com.bytedance.android.live.core.utils;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ com.bytedance.live.datacontext.l a;

    public c0(com.bytedance.live.datacontext.m r1) {
        this.a = r1;
    }

    public final void accept(T r2) {
        this.a.setValue(r2);
    }
}
