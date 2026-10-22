package com.larus.avlink.env.event;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j0 {
    public final Context a;
    public final View b;
    public final Function0<Unit> c;
    public final Function0<Unit> d;
    public final Function0<Unit> e;
    public PopupWindow f;

    public j0(Context r2, View r3, d0 r4, e0 r5, f0 r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "anchor");
        Intrinsics.checkNotNullParameter(r4, "onEditClick");
        Intrinsics.checkNotNullParameter(r5, "onDeleteClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
