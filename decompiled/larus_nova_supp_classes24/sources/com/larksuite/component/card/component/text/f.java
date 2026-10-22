package com.larksuite.component.card.component.text;

import android.text.Layout;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public final b a;
    public final int b;
    public final int c;
    public boolean d;

    public static final class a {
    }

    static {
    }

    public f(b r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "renderEntity");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final Layout a(CharSequence r5, d r6, float r7, float r8, int r9) {
        TextLayoutBuilder r0 = new TextLayoutBuilder();
        r0.h(r5);
        r0.j(r6.d);
        int r10 = r6.e;
        if (r10 == 0) goto L5;
        r0.i(r10);
    L5:
        r0.k(r6.h);
        r0.f((int) r7);
        r0.c(r6.f);
        boolean r11 = false;
        r0.f = false;
        int r12 = h18.e.a;
        r0.m(h18.e.a(LarkContext.getApplication()));
        TextLayoutBuilder.a r13 = r0.c;
        if (r13.h == true) goto L8;
        r13.h = true;
        r0.d = null;
    L8:
        r13.c = this.c;
        r0.d(r6.g);
        int r14 = (int) r8;
        TextLayoutBuilder.a r15 = r0.c;
        if (r15.l == r14) goto L11;
        r15.l = r14;
        r0.d = null;
    L11:
        r0.e(r9);
        if (this.b <= 0) goto L14;
        r11 = true;
    L14:
        r0.g(r11);
        return r0.a();
    }
}
