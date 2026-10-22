package com.ss.android.lark.keyboard.event;

import com.ss.android.lark.keyboard.event.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class t<T extends m> implements j {
    public final T a;
    public final T b;

    @Override // com.ss.android.lark.keyboard.event.c
    public final String getTag() {
        return "Transform: form " + this.a.getTag() + " to " + this.b.getTag();
    }

    public t(T r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "to");
        this.a = r2;
        this.b = r3;
    }
}
