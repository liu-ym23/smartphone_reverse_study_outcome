package com.bytedance.android.live.liveinteract.service;

import android.os.Bundle;
import io.reactivex.disposables.Disposable;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements gd0.e {
    public ny.a a;
    public Disposable b;

    public c() {
    }

    public static final void a(c r3) {
        r3.getClass();
        h1 r4 = new h1(6);
        Bundle r0 = new Bundle();
        r0.putBoolean("DATA_BOOLEAN_SKIP_INTERCEPTOR", true);
        r4.d = r0;
        xs2.b.a().post(r4);
    }
}
