package com.ss.android.lark.keyboard.edittext2.edittors.image;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.widget.light.viewstub.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements h {
    public final com.ss.android.lark.widget.span.b.b<?> a;
    public int b;
    public int c;
    public int d;

    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public a(com.ss.android.lark.widget.span.b.b<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "loadInfo");
        this.a = r2;
        this.d = -1;
    }

    public final View b(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        UrlImageSpanView r0 = new UrlImageSpanView(r5, this.a);
        int r6 = this.b;
        int r1 = this.c;
        r0.setPadding(r6, r0.getPaddingTop(), r1, r0.getPaddingBottom());
        r0.setFixSize(this.d);
        return r0;
    }
}
