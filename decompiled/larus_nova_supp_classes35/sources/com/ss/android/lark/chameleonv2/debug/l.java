package com.ss.android.lark.chameleonv2.debug;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.chameleonv2.debug.ui.LoadingView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;

    public l(f r1, Context r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        f r0 = this.a;
        w0b.a r1 = r0.a;
        if (r1 != null) goto L30;
        r0.a = new w0b.a(this.b, this.c);
        w0b.a r2 = this.a.a;
        if (r2 == null) goto L9;
        Dialog r3 = r2.d;
        if (r3 == null) goto L9;
        r3.setCancelable(false);
    L9:
        w0b.a r4 = this.a.a;
        if (r4 != null) goto L12;
        return;
    L12:
        if (r4.e == true) goto L41;
        Dialog r5 = r4.d;
        if (r5 != null) goto L16;
    L20:
        LoadingView r6 = r4.b;
        if (r6 == null) goto L29;
        ValueAnimator r7 = r6.g;
        if (r7 == null) goto L25;
        r6.clearAnimation();
        r7.setRepeatCount(1);
        r7.cancel();
        r7.end();
    L25:
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r8.setDuration(1000);
        r8.setInterpolator(new LinearInterpolator());
        r8.setRepeatCount(-1);
        r8.setRepeatMode(1);
        r8.addUpdateListener(new w0b.b(r6));
        r8.addListener(new w0b.c());
        if (r8.isRunning() == true) goto L28;
        r8.start();
    L28:
        r6.g = r8;
    L29:
        r4.e = true;
        return;
    L16:
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L38;
        DialogLancet.handleBlockedDialogShow(r5);
        goto L20
    L38:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
    L19:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        goto L20
    L41:
        return;
    L30:
        String r9 = this.c + '%';
        Intrinsics.checkNotNullParameter(r9, "msg");
        if (r1.e == false) goto L35;
        TextView r10 = r1.c;
        if (r10 == null) goto L35;
        r10.setText(r9);
    L35:
        r1.a = r9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
