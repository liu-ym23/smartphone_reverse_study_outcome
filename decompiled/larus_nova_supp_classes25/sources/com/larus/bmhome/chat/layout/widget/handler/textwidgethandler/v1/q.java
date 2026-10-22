package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q implements lw8.c {
    public final /* synthetic */ l a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ CustomMarkdownTextView c;

    public final void a(View r10, psc.d r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "span");
        if (r11.c == true) goto L6;
        FLogger.a.i("MarkdownTextViewWidgetHandlerV2", "CodeCopySpanClickListener is uncompleted");
        return;
    L6:
        l r0 = this.a;
        r0.b = SystemClock.elapsedRealtime();
        if (r11.d == false) goto L15;
        l r1 = this.a;
        fh8.r r2 = r1.d;
        if (r2 == null) goto L13;
        Function2<View, lw8.f, Unit> r3 = r2.a;
        if (r3 == null) goto L13;
        r3.invoke(r10, r11);
        return;
    L13:
        r1.h().f(r10, r11);
        return;
    L15:
        l r4 = this.a;
        fh8.r r5 = r4.d;
        if (r5 == null) goto L20;
        Function4<Context, View, lw8.f, View, Unit> r6 = r5.b;
        if (r6 == null) goto L20;
        r6.invoke(this.b, r10, r11, this.c);
        return;
    L20:
        if8.c r7 = r4.h();
        Context r8 = this.b;
        CustomMarkdownTextView r9 = this.c;
        int r12 = if8.c.b;
        r7.e(r8, r10, r11, r9, null);
    }

    public q(l r1, Context r2, CustomMarkdownTextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
