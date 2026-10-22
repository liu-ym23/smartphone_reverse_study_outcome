package com.larus.chat.gallery.providers.input;

import android.view.View;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h0 {
    public final View a;
    public final View b;
    public final CommonDownLoadLayout c;
    public final Function0<Unit> d;
    public final Function0<Unit> e;
    public boolean f;
    public boolean g;
    public Function0<Unit> h;

    public final void a() {
        CommonDownLoadLayout r0 = this.c;
        if (this.f == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        r0.setLayoutEnable(r1);
        if (this.g == false) goto L11;
        this.c.T5();
        return;
    L11:
        this.c.R5();
        return;
    L5:
        if (this.g == true) goto L7;
        r1 = true;
        goto L8
    }

    public h0(View r2, View r3, CommonDownLoadLayout r4, x r5, y r6) {
        Intrinsics.checkNotNullParameter(r2, "inputContainer");
        Intrinsics.checkNotNullParameter(r3, "bottomContainer");
        Intrinsics.checkNotNullParameter(r4, "saveButton");
        Intrinsics.checkNotNullParameter(r5, "hideInputMethod");
        Intrinsics.checkNotNullParameter(r6, "removeInputInterceptor");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = true;
        r4.setOnClickListener(new g0(this));
    }
}
