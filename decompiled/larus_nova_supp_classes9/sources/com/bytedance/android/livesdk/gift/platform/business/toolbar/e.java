package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.platform.business.effect.service.EffectGameStatus;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import i12.o;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends zr2.k {
    public final Context b;
    public final String c;

    public static final class a {
    }

    static {
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
    }

    public final void onClick(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        zy0.d r2 = null;
        ay1.b.B0.setValue(null, ay1.b.a[94], Boolean.FALSE);
        i12.e r7 = o.b();
        if (r7 == null) goto L5;
        Object r8 = com.bytedance.android.scope.m.e.d(r7, l02.e.class);
    L6:
        l02.e r9 = (l02.e) r8;
        if (r9 == null) goto L10;
        EffectGameStatus r10 = r9.a;
        if (r10 == null) goto L10;
    L11:
        i12.e r0 = o.b();
        if (r0 == null) goto L14;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, l02.e.class);
    L15:
        l02.e r3 = (l02.e) r1;
        if (r3 == null) goto L18;
        Integer r4 = r3.b;
    L20:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(this.c) == false) goto L41;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L33
        d r11 = (d) GsonHelper.get().fromJson(this.c, d.class);     // Catch: Throwable -> L33
        if (r10 == EffectGameStatus.RUNNING) goto L24;
    L28:
        String r13 = r11.c();     // Catch: Throwable -> L33
        if (r13 == null) goto L31;
        r2 = com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.c.a(this.b, r13);     // Catch: Throwable -> L33
    L31:
        Object r14 = Result.constructor-impl(r2);     // Catch: Throwable -> L33
    L36:
        if (Result.exceptionOrNull-impl(r14) == null) goto L42;
        int r15 = x8.a.a;
        x8.a.b("ToolbarGameEffectBehavior", "parse extra error, extra: " + this.c, false);
        return;
    L42:
        return;
    L24:
        if (Intrinsics.areEqual(r4, r11.a()) == false) goto L28;
        String r16 = r11.b();     // Catch: Throwable -> L33
        if (r16 == null) goto L31;
        r2 = com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.c.a(this.b, r16);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L41:
        return;
    L18:
        r4 = null;
        goto L20
    L14:
        r1 = null;
    L10:
        r10 = EffectGameStatus.IDLE;
        goto L11
    L5:
        r8 = null;
        goto L6
    }

    public e(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
        this.c = r3;
    }

    public final void p4(View r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        View r5 = r3.findViewById(2131384095);
        if (((Boolean) ay1.b.B0.getValue(null, ay1.b.a[94])).booleanValue() == false) goto L5;
        UIUtils.setViewVisibility(r5, 0);
        return;
    L5:
        UIUtils.setViewVisibility(r5, 8);
    }
}
