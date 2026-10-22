package com.bytedance.android.livesdk.interactivity.zdanmaku;

import android.content.Context;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.WindScreenCombinedAnimTrayView;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.WindScreenCommonAnimTrayView;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public BaseWindScreenAnimEnterTrayView a;
    public final h3 b;
    public final Function1<d, Unit> c;

    /* JADX WARN: Multi-variable type inference failed */
    public d(h3 r4, Function1<? super d, Unit> r5, Context r6, BarrageWidgetContext r7) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r5, "renderEndCallBack");
        this.b = r4;
        this.c = r5;
        if (r6 == null) goto L49;
        IMiddlewareUserService r8 = jc1.k.n(IMiddlewareUserService.class);
        k32.d r2 = new k32.d(r4, r8.user().n(), r8.user().b().getRealNickName(), r8.user().b().getAvatarUrl());
        int r0 = 0;
        if (r2.a() == false) goto L7;
        WindScreenCombinedAnimTrayView r9 = new WindScreenCombinedAnimTrayView(r6, null, 6, r0);
        r9.setConfigSceneInterceptor(new com.bytedance.android.livesdk.interactivity.common.enterAnim.b());
        r9.a = new WindScreenCombinedAnimTrayView.a(new CombinedTextDanmakuData$getTrayView$1(this));
        BaseWindScreenAnimEnterTrayView r10 = r9;
    L13:
        this.a = r10;
        if (r7 == null) goto L22;
        n<p22.i> r11 = r7.getNormalDanmakuSettingConfig();
        if (r11 == null) goto L22;
        p22.i r13 = (p22.i) r11.getValue();
        if (r13 == null) goto L22;
        p22.i.a r14 = r13.d;
        if (r14 == null) goto L22;
        float r15 = r14.a;
    L23:
        r10.setTextSize(r15);
        BaseWindScreenAnimEnterTrayView r16 = this.a;
        if (r16 != null) goto L26;
    L45:
        BaseWindScreenAnimEnterTrayView r17 = this.a;
        if (r17 == null) goto L50;
        r17.R5(r2);
        return;
    L50:
        return;
    L26:
        if (r7 == null) goto L34;
        n<p22.i> r18 = r7.getNormalDanmakuSettingConfig();
        if (r18 == null) goto L34;
        p22.i r19 = (p22.i) r18.getValue();
        if (r19 == null) goto L34;
        p22.i.a r20 = r19.d;
        if (r20 == null) goto L34;
        int r21 = r20.b;
    L35:
        if (r7 == null) goto L43;
        n<p22.i> r23 = r7.getNormalDanmakuSettingConfig();
        if (r23 == null) goto L43;
        p22.i r24 = (p22.i) r23.getValue();
        if (r24 == null) goto L43;
        p22.i.a r25 = r24.d;
        if (r25 == null) goto L43;
        int r26 = r25.b;
    L44:
        r16.U5(r21, r26);
    L43:
        r26 = UtilityKotlinExtentionsKt.i(22);
    L34:
        r21 = UtilityKotlinExtentionsKt.i(22);
    L22:
        r15 = UtilityKotlinExtentionsKt.m(14);
        goto L23
    L7:
        WindScreenCommonAnimTrayView r27 = new WindScreenCommonAnimTrayView(r6);
        r27.a = new com.bytedance.android.livesdk.interactivity.common.enterAnim.a(new CombinedTextDanmakuData$getTrayView$2(this));
        List r28 = r4.N();
        if (r28 == null) goto L12;
        py.k r29 = (py.k) ListProtector.get(r28, 0);
        if (r29 == null) goto L12;
        a1.k(r29).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r27));
    L12:
        r10 = r27;
        goto L13
    }
}
