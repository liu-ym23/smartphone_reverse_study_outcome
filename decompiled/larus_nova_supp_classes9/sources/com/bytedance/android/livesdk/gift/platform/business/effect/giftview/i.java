package com.bytedance.android.livesdk.gift.platform.business.effect.giftview;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.t3;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements IPlayerActionListener {
    public final /* synthetic */ IPlayerActionListener a;
    public final /* synthetic */ VideoGiftView b;

    public final /* synthetic */ void onFirstFrame() {
        IPlayerActionListener.-CC.$default$onFirstFrame(this);
    }

    public final /* synthetic */ void onReportPlayMetrics(Map r1) {
        IPlayerActionListener.-CC.$default$onReportPlayMetrics(this, r1);
    }

    public final void onEnd() {
        this.b.q = false;
        IPlayerActionListener r0 = this.a;
        if (r0 == null) goto L5;
        r0.onEnd();
    L5:
        a(false);
    }

    public final void onStart() {
        VideoGiftView r0 = this.b;
        if (r0.q == true) goto L7;
        List<Long> r1 = r0.r;
        ArrayList r2 = (ArrayList) r1;
        if (r2.contains(Long.valueOf(r0.s)) == false) goto L7;
        long r3 = this.b.s;
        String r4 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        n r5 = new n();
        Map r6 = r5.a;
        Intrinsics.checkNotNullParameter(r6, "map");
        String r7 = String.valueOf(r3);
        Intrinsics.checkNotNullParameter("asset_id", "key");
        Intrinsics.checkNotNullParameter(r7, "value");
        r6.put("asset_id", r7);
        mz0.m r8 = new mz0.m();
        r8.b(LogCommon.PAGE_SOURCE_LOG);
        r8.b(LogCommon.ROOM);
        List r9 = r5.b;
        ArrayList r10 = (ArrayList) r9;
        r10.addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r11 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r11).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((f80.a) r13).w3("livesdk_match_atmosphere_effect_show", r5.a, r5.b);
    L7:
        this.b.q = true;
        IPlayerActionListener r14 = this.a;
        if (r14 == null) goto L10;
        r14.onStart();
    L10:
        a(true);
    }

    public final void onStop() {
        IPlayerActionListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onStop();
        return;
    }

    public final void a(boolean r4) {
        EffectMessage r0 = this.b.m;
        if (r0 == null) goto L14;
        com.bytedance.android.livesdk.gift.model.a r1 = r0.q;
        if (r1 == null) goto L15;
        t3 r2 = r1.c;
        if (r2 == null) goto L16;
        IBaseUser r3 = r2.d;
        String r5 = r2.e;
        com.bytedance.android.live.profit.player.d r6 = yt0.c.h();
        if (r6 == null) goto L17;
        if (r4 == false) goto L12;
        r6.f1().c(r3, r5);
        return;
    L12:
        r6.f1().b(r3, r5);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public i(VideoGiftView r1, BaseVideoGiftWidget.g r2) {
        this.b = r1;
        this.a = r2;
    }

    public final void onFileLoaded(int r2, int r3) {
        IPlayerActionListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFileLoaded(r2, r3);
        return;
    }

    public final void updateTextEffectPosition(float r2, float r3, float r4, float r5) {
        IPlayerActionListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.updateTextEffectPosition(r2, r3, r4, r5);
        return;
    }
}
