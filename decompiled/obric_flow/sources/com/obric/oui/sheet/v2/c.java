package com.obric.oui.sheet.v2;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oui.R$id;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14506b;

    public /* synthetic */ c(e r5, int r10) {
        this.f14505a = r10;
        this.f14506b = r5;
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.obric.oui.sheet.v2.SheetAnimStyle$sheetShow$2, java.lang.Object, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.obric.oui.sheet.v2.OSheetBase$performEnterAnimation$1$animBuilder$1, java.lang.Object, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.obric.oui.sheet.v2.e, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        Object r5 = null;
        int r10 = 0;
        ?? r11 = this.f14506b;
        switch(this.f14505a) {
            case 0: goto L21;
            case 1: goto L10;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r11, "this$0");
        jp.d r12 = r11.getRunningAnim();
        if (r12 == null) goto L8;
        r12.a(true);
    L8:
        r11.getRootContainer().setAlpha(0.0f);
        return;
    L10:
        b r13 = (b) r11;
        Intrinsics.checkNotNullParameter(r13, "this$0");
        r13.getClass();
        d.c(r13);
        if (r13.A == true) goto L47;
        r13.getRootContainer().setAlpha(0.0f);
        r13.A = true;
        Intrinsics.checkNotNullParameter(r13, "this");
        jp.d r14 = r13.f14497r;
        if (r14 == null) goto L17;
        int r15 = jp.d.d;
        r14.a(false);
    L17:
        if (r13.f14488i == true) goto L19;
        r13.k();
        r13.getRootContainer().setAlpha(1.0f);
        r13.getRootContainer().setTranslationY(0.0f);
        RadiusLayout r16 = r13.getRootContainer();
        int r17 = R$id.o_dialog_anim_in;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        r16.setTag(r17, null);
        r13.f14497r = null;
        return;
    L19:
        r13.getRootContainer().setAlpha(0.0f);
        r13.getRootContainer().post(new c(r13, r10));
        return;
    L47:
        return;
    L21:
        final e r18 = (e) r11;
        Intrinsics.checkNotNullParameter(r18, "this$0");
        RadiusLayout r19 = r18.getRootContainer();
        final Window r110 = r18.h();
        final View r111 = r18.getDimView();
        final boolean r112 = r18.e();
        final boolean r113 = r18.d();
        Context r20 = r18.getSheetContext();
        Intrinsics.checkNotNullParameter(r20, "context");
        if ((r20.getResources().getConfiguration().uiMode & 48) != 32) goto L25;
        float r21 = 0.5f;
    L24:
        final float r114 = r21;
        Intrinsics.checkNotNullParameter(r19, "<this>");
        int r22 = Resources.getSystem().getDisplayMetrics().heightPixels;
        if (r112 == false) goto L34;
        if (r113 == false) goto L34;
        if (r110 == null) goto L34;
        r110.addFlags(2);     // Catch: Exception -> L32
    L32:
        e = move-exception;
        Log.w("SheetAnimStyle", Intrinsics.stringPlus("dialogBottomShow, can't show dim anim: ", e.getMessage()));
    L34:
        int r23 = com.lynx.tasm.utils.a.B(32, r19) + r19.getHeight();
        r19.setAlpha(1.0f);
        final float r115 = r23;
        r19.setTranslationY(r115);
        Pair r24 = o.c(r19.getHeight() / r22, true);
        float r25 = ((Number) r24.component1()).floatValue();
        float r26 = ((Number) r24.component2()).floatValue();
        final float r116 = com.lynx.tasm.utils.a.B(2, r19);
        int r27 = R$id.o_dialog_anim_in;
        Object r28 = r19.getTag(r27);
        if (r28 != null) goto L38;
    L40:
        com.obric.common.oea.foundation.animation.builder.a r29 = (com.obric.common.oea.foundation.animation.builder.a) r5;
        if (r29 != null) goto L43;
        r29 = new com.obric.common.oea.foundation.animation.builder.a(r19);
        r19.setTag(r27, r29);
    L43:
        AnimationProperty$FloatProperty r117 = AnimationProperty$FloatProperty.TRANSLATION_Y;
        Float r118 = Float.valueOf(r115);
        com.obric.common.oea.foundation.animation.spec.spring.b r30 = ug.a.l(r25, r26);
        r30.f11323b = 1.0f;
        Unit r31 = Unit.INSTANCE;
        r29.c(r117, r118, r116, r30, null);
        ?? r32 = new SheetAnimStyle$sheetShow$2(r112, r113, r110, r115, r116, r114, r111);
        Intrinsics.checkNotNullParameter(r32, "callback");
        r29.d = r32;
        ?? r33 = new OSheetBase$performEnterAnimation$1$animBuilder$1(r18);
        Intrinsics.checkNotNullParameter(r33, "callback");
        r29.e = r33;
        r18.setRunningAnim(com.obric.common.oea.foundation.animation.builder.b.a(r29.b()));
        return;
    L38:
        if ((r28 instanceof com.obric.common.oea.foundation.animation.builder.a) == false) goto L40;
        r5 = r28;
        goto L40
    L25:
        r21 = 0.16f;
        goto L24
    }
}
