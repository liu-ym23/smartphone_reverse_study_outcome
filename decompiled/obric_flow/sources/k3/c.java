package k3;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import com.bytedance.ai.model.p;
import com.bytedance.ai.view.popup.RadiusLayout;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements j3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f18592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f18593c;

    public c(AppletPopupSchemaParam r5, View r10) {
        this.f18591a = 2;
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "view");
        this.f18592b = r5;
        this.f18593c = r10;
    }

    @Override // j3.a
    public final void invoke() {
        ViewGroup.MarginLayoutParams r5 = null;
        Window r10 = null;
        r10 = null;
        Object r11 = this.f18593c;
        Object r12 = this.f18592b;
        switch(this.f18591a) {
            case 0: goto L34;
            case 1: goto L32;
            case 2: goto L27;
            default: goto L4;
        };
    L4:
        LinearLayout r13 = (LinearLayout) r12;
        Context r14 = r13.getContext();
        AppletPopupSchemaParam r15 = (AppletPopupSchemaParam) r11;
        int r16 = r15.f2888b;
        if (AppletPopupSchemaParam.b(r14) == false) goto L9;
        int r17 = r15.f2889c;
        if (r17 <= 0) goto L9;
        r16 = r17;
    L9:
        ViewGroup.LayoutParams r18 = r13.getLayoutParams();
        if (r16 <= 0) goto L20;
        t0.b r19 = p.f2294c;
        if (r19 == null) goto L16;
        Activity r20 = r19.currentActivity();
        if (r20 == null) goto L16;
        r10 = r20.getWindow();
    L16:
        if (r10 == null) goto L18;
        int r21 = com.bytedance.ai.utils.c.f(r10).widthPixels;
    L19:
        r16 = RangesKt.coerceAtMost(r16, r21);
    L25:
        r18.width = r16;
        return;
    L18:
        r21 = Resources.getSystem().getDisplayMetrics().widthPixels;
        goto L19
    L20:
        if (r16 != 0) goto L25;
        if (Intrinsics.areEqual(r15.a(r13.getContext()), "center") == false) goto L24;
        r16 = com.bytedance.ai.utils.c.c(r13.getContext(), 300.0d);
        goto L25
    L24:
        r16 = -1;
        goto L25
    L27:
        View r22 = (View) r11;
        if (((AppletPopupSchemaParam) r12).g == false) goto L30;
        r22.setVisibility(0);
        r22.setAlpha(1.0f);
        return;
    L30:
        r22.setVisibility(0);
        r22.setAlpha(0.0f);
        return;
    L32:
        ((RadiusLayout) r11).setRadiusNew(((AppletPopupSchemaParam) r12).f);
        return;
    L34:
        Integer[] r23 = (Integer[]) r11;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L37
        Integer r25 = r23[0];     // Catch: Throwable -> L37
        r25.getClass();     // Catch: Throwable -> L37
        Object r26 = Result.m124constructorimpl(r25);     // Catch: Throwable -> L37
    L40:
        if (Result.m130isFailureimpl(r26) == false) goto L42;
        r26 = 0;
    L42:
        int r27 = ((Number) r26).intValue();
        Integer r28 = r23[1];     // Catch: Throwable -> L45
        r28.getClass();     // Catch: Throwable -> L45
        Object r29 = Result.m124constructorimpl(r28);     // Catch: Throwable -> L45
    L48:
        if (Result.m130isFailureimpl(r29) == false) goto L50;
        r29 = 0;
    L50:
        int r30 = ((Number) r29).intValue();
        Integer r31 = r23[2];     // Catch: Throwable -> L53
        r31.getClass();     // Catch: Throwable -> L53
        Object r32 = Result.m124constructorimpl(r31);     // Catch: Throwable -> L53
    L56:
        if (Result.m130isFailureimpl(r32) == false) goto L58;
        r32 = 0;
    L58:
        int r33 = ((Number) r32).intValue();
        Integer r34 = r23[3];     // Catch: Throwable -> L61
        r34.getClass();     // Catch: Throwable -> L61
        Object r35 = Result.m124constructorimpl(r34);     // Catch: Throwable -> L61
    L64:
        if (Result.m130isFailureimpl(r35) == false) goto L66;
        r35 = 0;
    L66:
        int r36 = ((Number) r35).intValue();
        if (r30 > 0) goto L71;
        if (r36 > 0) goto L71;
        if (r27 > 0) goto L71;
        if (r33 > 0) goto L71;
        return;
    L71:
        LinearLayout r37 = (LinearLayout) r12;
        ViewGroup.LayoutParams r38 = r37.getLayoutParams();
        if ((r38 instanceof ViewGroup.MarginLayoutParams) == false) goto L74;
        r5 = (ViewGroup.MarginLayoutParams) r38;
    L74:
        if (r5 == null) goto L76;
        r5.leftMargin = r27;
        r5.topMargin = r30;
        r5.rightMargin = r33;
        r5.bottomMargin = r36;
    L76:
        r37.requestLayout();
        return;
    L61:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r35 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L53:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r32 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L45:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r29 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L37:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r26 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L40
    }

    public c(AppletPopupSchemaParam r5, LinearLayout r10) {
        this.f18591a = 3;
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "view");
        this.f18593c = r5;
        this.f18592b = r10;
    }

    public c(AppletPopupSchemaParam r5, LinearLayout r10, RadiusLayout r11, String r12) {
        this.f18591a = 1;
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "popupContainer");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "gravity");
        this.f18592b = r5;
        this.f18593c = r11;
    }

    public c(AppletPopupSchemaParam r5, LinearLayout r10, Integer[] r11) {
        this.f18591a = 0;
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "popupContainer");
        Intrinsics.checkNotNullParameter(r11, "margin");
        this.f18592b = r10;
        this.f18593c = r11;
    }
}
