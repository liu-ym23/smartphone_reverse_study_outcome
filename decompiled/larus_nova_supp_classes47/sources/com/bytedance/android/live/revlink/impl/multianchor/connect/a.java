package com.bytedance.android.live.revlink.impl.multianchor.connect;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements gq2.c {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ Function1 b;

    public final void onSuccess() {
        this.a.invoke();
    }

    public final void onFailed(int r2) {
        this.b.invoke(Integer.valueOf(r2));
    }

    public a(Function0 r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
