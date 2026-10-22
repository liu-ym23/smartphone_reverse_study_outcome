package com.bytedance.badger.utils;

import android.content.Context;
import com.bytedance.bd_sec_tee.core.TeeProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a0 {
    public static volatile a0 b;
    public final TeeProvider a;

    public a0(Context r2) {
        h74.a.a r0 = new h74.a.a(r2);
        r0.b = new z();
        this.a = new TeeProvider(new h74.a(r0));
    }
}
