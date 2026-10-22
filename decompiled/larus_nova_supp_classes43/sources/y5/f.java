package y5;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements x5.a {
    public final View a;
    public final Integer[] b;

    @Override // x5.a
    public final void invoke() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r10 = Result.constructor-impl(Integer.valueOf(this.b[0].intValue()));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r10) == false) goto L10;
        r10 = 0;
    L10:
        int r11 = ((Number) r10).intValue();
        Object r12 = Result.constructor-impl(Integer.valueOf(this.b[1].intValue()));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r12) == false) goto L18;
        r12 = 0;
    L18:
        int r13 = ((Number) r12).intValue();
        Object r14 = Result.constructor-impl(Integer.valueOf(this.b[2].intValue()));     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r14) == false) goto L26;
        r14 = 0;
    L26:
        int r15 = ((Number) r14).intValue();
        Object r16 = Result.constructor-impl(Integer.valueOf(this.b[3].intValue()));     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r16) == false) goto L34;
        r16 = 0;
    L34:
        int r0 = ((Number) r16).intValue();
        if (r13 > 0) goto L39;
        if (r0 > 0) goto L39;
        if (r11 > 0) goto L39;
        if (r15 > 0) goto L39;
        return;
    L39:
        ViewGroup.LayoutParams r17 = this.a.getLayoutParams();
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L42;
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
    L43:
        if (r18 == null) goto L45;
        r18.leftMargin = r11;
        r18.topMargin = r13;
        r18.rightMargin = r15;
        r18.bottomMargin = r0;
    L45:
        this.a.requestLayout();
        return;
    L42:
        r18 = null;
    L29:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L13:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public f(AppletPopupSchemaParam r10, View r11, Integer[] r12) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "popupContainer");
        Intrinsics.checkNotNullParameter(r12, "margin");
        this.a = r11;
        this.b = r12;
    }
}
