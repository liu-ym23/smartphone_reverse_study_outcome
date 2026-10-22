package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z0 implements ix7.c {
    public View a;
    public View b;
    public final /* synthetic */ LynxBox c;

    public final View b() {
        return this.a;
    }

    public z0(LynxBox r1) {
        this.c = r1;
    }

    public final void a(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        LynxBox r0 = this.c;
        int r1 = 2131242971;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        if (Intrinsics.areEqual(r0.getTemplateInfo().getTemplateId(), "9") == false) goto L6;
        int r3 = 2131243033;
    L7:
        Object r4 = Result.constructor-impl(Integer.valueOf(r3));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r4) == false) goto L14;
        r4 = null;
    L14:
        Integer r5 = (Integer) r4;
        if (r5 == null) goto L18;
        r1 = r5.intValue();
    L18:
        if (this.c.getLynxBoxConfig().c == true) goto L20;
        ImageView r6 = new ImageView(r9);
        r6.setImageResource(r1);
        r6.setScaleType(ImageView.ScaleType.FIT_XY);
        r6.setLayoutParams(new ViewGroup.LayoutParams(-1, r6.getResources().getDimensionPixelOffset(v19.c.b(2130971179, null, 2131166727))));
    L21:
        this.a = r6;
        ImageView r7 = new ImageView(r9);
        r7.setImageResource(2131242972);
        r7.setScaleType(ImageView.ScaleType.FIT_XY);
        r7.setLayoutParams(new ViewGroup.LayoutParams(-1, r7.getResources().getDimensionPixelOffset(v19.c.b(2130971179, null, 2131166727))));
        this.b = r7;
        return;
    L20:
        r6 = null;
        goto L21
    L6:
        r3 = 2131242971;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final View c(final com.ivy.ivykit.plugin.impl.render.e r4) {
        Intrinsics.checkNotNullParameter(r4, "refresher");
        View r0 = this.b;
        this.c.setOnClickListener(new y0(r4));
        return r0;
    }
}
