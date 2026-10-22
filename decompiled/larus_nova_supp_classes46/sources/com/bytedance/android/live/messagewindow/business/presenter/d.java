package com.bytedance.android.live.messagewindow.business.presenter;

import android.view.View;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardConstant;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends b7.a {
    public final /* synthetic */ Integer a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Function1 c;

    public final void onLoadSuccess(View r6) {
        super.onLoadSuccess(r6);
        i r7 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r7 == null) goto L6;
        CardAlogParamsBuilder r0 = new CardAlogParamsBuilder();
        r0.d("PortraitCommonCardPresenter");
        r0.c("preLoad onLoadSuccess");
        Unit r1 = Unit.INSTANCE;
        r7.d(r0.b());
    L6:
        i r8 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r8 == null) goto L10;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r2 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_result");
        r2.b("position", Integer.valueOf(CommonCardConstant.Position.BOTTOM_RIGHT.getValue()));
        r2.b("type", this.a);
        r2.b("result", Integer.valueOf(CommonCardConstant.Result.SUCCESS.getValue()));
        Unit r3 = Unit.INSTANCE;
        r8.b(r2.a());
    L10:
        i r9 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r9 == null) goto L15;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r4 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_time_cost");
        r4.b("position", Integer.valueOf(CommonCardConstant.Position.BOTTOM_RIGHT.getValue()));
        r4.b("type", this.a);
        r4.b("cost_time", Long.valueOf(System.currentTimeMillis() - this.b));
        Unit r5 = Unit.INSTANCE;
        r9.b(r4.a());
        return;
    }

    public final void onInnerFallback(int r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "errorMessage");
        super.onInnerFallback(r6, r7);
        i r1 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r1 == null) goto L6;
        CardAlogParamsBuilder r2 = new CardAlogParamsBuilder();
        r2.d("PortraitCommonCardPresenter");
        r2.c("preLoad onInnerFallback");
        r2.a("errorCode", String.valueOf(r6));
        r2.a("errorMessage", r7);
        Unit r0 = Unit.INSTANCE;
        r1.d(r2.b());
    L6:
        i r3 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r3 == null) goto L11;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r4 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_fallback");
        r4.b("position", Integer.valueOf(CommonCardConstant.Position.BOTTOM_RIGHT.getValue()));
        r4.b("type", this.a);
        r4.b("error_code", String.valueOf(r6));
        r4.b("error_msg", r7);
        Unit r8 = Unit.INSTANCE;
        r3.b(r4.a());
        return;
    }

    public final void onLoadStart(View r2, boolean r3) {
        super.onLoadStart(r2, r3);
        i r4 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r4 == null) goto L7;
        CardAlogParamsBuilder r5 = new CardAlogParamsBuilder();
        r5.d("PortraitCommonCardPresenter");
        r5.c("preLoad onHybridCardLoadStart");
        Unit r0 = Unit.INSTANCE;
        r4.d(r5.b());
        return;
    }

    public d(Integer r1, long r2, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void onLoadFail(View r3, String r4, String r5) {
        super.onLoadFail(r3, r4, r5);
        i r6 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r6 == null) goto L6;
        CardAlogParamsBuilder r7 = new CardAlogParamsBuilder();
        r7.d("PortraitCommonCardPresenter");
        r7.c("preLoad onLoadFail");
        Unit r0 = Unit.INSTANCE;
        r6.d(r7.b());
    L6:
        Function1 r8 = this.c;
        p71.a.f r9 = new p71.a.f();
        String r1 = String.valueOf(r5);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        ((p71.a) r9).b = r1;
        Unit r2 = Unit.INSTANCE;
        r8.invoke(r9);
        i r10 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r10 == null) goto L11;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r11 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_result");
        r11.b("position", Integer.valueOf(CommonCardConstant.Position.BOTTOM_RIGHT.getValue()));
        r11.b("type", this.a);
        r11.b("result", Integer.valueOf(CommonCardConstant.Result.FAIL.getValue()));
        r11.b("error_msg", r5);
        r10.b(r11.a());
        return;
    }
}
