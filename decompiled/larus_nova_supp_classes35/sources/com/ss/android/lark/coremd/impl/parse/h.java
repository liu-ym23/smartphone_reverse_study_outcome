package com.ss.android.lark.coremd.impl.parse;

import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.coremd.base.parse.z;
import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h extends ClickableSpan {
    public final Class<s> a;
    public final Function1<View, z<View>> b;
    public final Function4<Integer, Integer, View, Layout, Unit> c;

    public static final class a {
    }

    static {
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
    }

    public final Class<s> getType() {
        return this.a;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "widget");
        z r0 = (z) this.b.invoke(r5);
        if (r0 != null) goto L6;
        Log.e("NodeClickableSpan", "onClick: adapter is null");
        return;
    L6:
        Layout r2 = r0.a(r5);
        if (r2 != null) goto L10;
        Log.e("NodeClickableSpan", "onClick: layout is null");
        return;
    L10:
        CharSequence r1 = r0.c(r5);
        if ((r1 instanceof Spanned) == true) goto L14;
        Log.e("NodeClickableSpan", "onClick: text is not Spanned");
        return;
    L14:
        Spanned r3 = (Spanned) r1;
        int r4 = r3.getSpanStart(this);
        int r6 = r3.getSpanEnd(this);
        this.c.invoke(Integer.valueOf(r4), Integer.valueOf(r6), r5, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Class<s> r2, Function1<? super View, ? extends z<View>> r3, Function4<? super Integer, ? super Integer, ? super View, ? super Layout, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r3, "adapterProvider");
        Intrinsics.checkNotNullParameter(r4, "invocation");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
