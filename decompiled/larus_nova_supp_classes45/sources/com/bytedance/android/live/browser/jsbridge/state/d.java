package com.bytedance.android.live.browser.jsbridge.state;

import com.bytedance.android.live.browser.jsbridge.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> extends a<T> {
    public final i.a<T> c;

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final Object b() {
        return this.c.b();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final i.f<T> d() {
        return this.c.c();
    }

    public d(i.a<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "original");
        super(0);
        this.c = r2;
    }
}
