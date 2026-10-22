package com.bytedance.android.live.revenue.platform.hybrid.impl;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.scope.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vy0.d;
import yy0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements d, o {
    public b() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vy0.d
    public final <PARAMS> zy0.b Xi(Context r2, vy0.a<PARAMS> r3, Uri r4, Function1<? super c, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "type");
        return ((vy0.c) f.a(vy0.c.class)).q8(r2, r4, r5);
    }
}
