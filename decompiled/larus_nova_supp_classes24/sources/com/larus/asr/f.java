package com.larus.asr;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.EditText;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import r19.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public boolean a;
    public b b;
    public ValueAnimator c;

    public static final class a {
    }

    static {
    }

    public f() {
    }

    public final void a(EditText r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        FLogger.a.i("AsrLoadingHelper", "[dismissLoading]");
        this.a = false;
        ValueAnimator r1 = this.c;
        if (r1 == null) goto L7;
        r1.cancel();
    L7:
        this.c = null;
        Editable r2 = r5.getText();
        if ((r2 instanceof Spannable) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L15;
        b r3 = this.b;
        if (r3 == null) goto L15;
        r2.removeSpan(r3);
    L15:
        Editable r6 = r5.getText();
        if (r6 != null) goto L18;
    L20:
        this.b = null;
        return;
    L18:
        if (StringsKt.endsWith$default(r6, " ", false, 2, null) == false) goto L20;
        r6.delete(r6.length() - 1, r6.length());
        goto L20
    }

    public final void b(final EditText r8, int r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "currentText");
        if (r8 != null) goto L6;
        return;
    L6:
        if (this.a == false) goto L8;
        return;
    L8:
        Context r0 = r8.getContext();
        if (r0 != null) goto L11;
        return;
    L11:
        this.a = true;
        FLogger.a.i("AsrLoadingHelper", "[showLoading] currentText=" + g2a.d.b(r10));
        String r11 = r10.concat(" ");
        this.b = new b(r9, r0);
        SpannableString r12 = new SpannableString(r11);
        Integer r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L18
        b r3 = this.b;     // Catch: Throwable -> L18
        if (r3 == null) goto L15;
        r12.setSpan(r3, RangesKt.coerceAtLeast(r12.length() - 1, 0), r12.length(), 17);     // Catch: Throwable -> L18
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L18
    L20:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L23;
        FLogger.a.e("AsrLoadingHelper", "renderTextWithLoading error " + r6.getMessage() + " currentText=" + r11, r6);
    L23:
        r8.setText(r12);
        ValueAnimator r13 = ValueAnimator.ofInt(new int[]{0, 255});
        r13.setDuration(400);
        r13.setRepeatCount(-1);
        r13.setRepeatMode(2);
        r13.addUpdateListener(new e(this, r8));
        FLogger r14 = FLogger.a;
        StringBuilder r7 = new StringBuilder("textLen=");
        Editable r15 = r8.getText();
        if (r15 == null) goto L26;
        r1 = Integer.valueOf(r15.length());
    L26:
        r7.append(r1);
        r14.i("AsrLoadingHelper", r7.toString());
        r13.start();
        this.c = r13;
        return;
    L15:
        r4 = null;
    L18:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }
}
