package com.larus.avlink.record.page;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public final Context a;
    public final View b;
    public final Function0<Unit> c;
    public final Function0<Unit> d;
    public PopupWindow e;

    public g(Context r2, ConstraintLayout r3, k r4, l r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "anchor");
        Intrinsics.checkNotNullParameter(r4, "onDeleteClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
