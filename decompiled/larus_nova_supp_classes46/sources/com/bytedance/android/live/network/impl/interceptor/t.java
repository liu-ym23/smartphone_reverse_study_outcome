package com.bytedance.android.live.network.impl.interceptor;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.config.m4;
import com.bytedance.android.livesdk.config.sm0;
import com.bytedance.android.livesdk.recharge.model.RechargeVerifyTraceStep;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t implements DialogInterface.OnClickListener {
    public final /* synthetic */ u.a a;

    public t(u.a r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r13, int r14) {
        if (((Boolean) sm0.a.getValue()).booleanValue() == false) goto L9;
        Dialog r15 = u.a;
        u.a r16 = this.a;
        Activity r1 = r16.a;
        String r2 = (String) r16.d.element;
        String r3 = (String) r16.e.element;
        t80.a r17 = r16.b;
        ALogger.i("LiveRechargeInterceptor", "start to verify with authentication 3.0， scene：" + r2 + ", flow: " + r3);
        Map r11 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("faceOnly", String.valueOf(false))});
        y80.b r0 = y80.c.a();
        v80.f r5 = new v80.f();
        Intrinsics.checkNotNullParameter(r2, "scene");
        r5.c.put("scene", r2);
        Intrinsics.checkNotNullParameter(r3, "flow");
        r5.c.put("flow", r3);
        r5.d = false;
        ((v80.h) r5).a = r1;
        v r4 = new v(r5, r17, r11);
        Intrinsics.checkNotNullParameter(r4, "callback");
        r5.b = r4;
        int r18 = do0.a.a;
        do0.a.a(RechargeVerifyTraceStep.STEP_RECHARGE_VERIFY_SDK, 0, "", "", "", r11);
        if (r0 == null) goto L12;
        y80.a r19 = r0.a;
        if (r19 == null) goto L12;
        r19.a(r5.getContext(), r5);
    L12:
        int r110 = do0.a.a;
        do0.a.b(RechargeVerifyTraceStep.STEP_RECHARGE_VERIFY_CONFIRM_CLICK, this.a.c, "", "", "");
        r13.dismiss();
        return;
    L9:
        Dialog r111 = u.a;
        u.a r112 = this.a;
        Activity r6 = r112.a;
        String r113 = (String) r112.d.element;
        ALogger.i("LiveRechargeInterceptor", "start to verify with authentication old， source：" + r113);
        Uri r114 = UriProtector.parse((String) m4.a.getValue()).buildUpon().appendQueryParameter("enter_from", r113).build();
        if (r114 == null) goto L12;
        TTLiveSDK.hostService().action().handleSchema(r6, r114.toString(), new Bundle());
        goto L12
    }
}
