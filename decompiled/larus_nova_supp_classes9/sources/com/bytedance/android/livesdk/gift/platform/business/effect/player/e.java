package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.platform.business.effect.utils.VideoGiftLinkMonitor;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements IPlayerActionListener {
    public final /* synthetic */ IPlayerActionListener a;
    public final /* synthetic */ f b;

    public final /* synthetic */ void onFirstFrame() {
        IPlayerActionListener.-CC.$default$onFirstFrame(this);
    }

    public final void onEnd() {
        this.b.i = true;
        IPlayerActionListener r0 = this.a;
        if (r0 == null) goto L5;
        r0.onEnd();
    L5:
        this.b.o.a();
        String r1 = v12.f.a;
        f r2 = this.b;
        v12.f.E("effect_play_end", r2.j, r2.i);
        this.b.c();
        VideoGiftLinkMonitor.Event r3 = VideoGiftLinkMonitor.Event.playcontroller_end;
        f r4 = this.b;
        VideoGiftLinkMonitor.a(r3, r4.j, r4.k, r4.l);
    }

    public final void onStart() {
        this.b.i = false;
        IPlayerActionListener r0 = this.a;
        if (r0 == null) goto L5;
        r0.onStart();
    L5:
        this.b.o.b();
        String r1 = v12.f.a;
        f r2 = this.b;
        v12.f.E("onStart", r2.j, r2.i);
    }

    public final void onStop() {
        this.b.i = true;
        IPlayerActionListener r0 = this.a;
        if (r0 == null) goto L5;
        r0.onStop();
    L5:
        this.b.o.a();
        String r1 = v12.f.a;
        f r2 = this.b;
        v12.f.E("onStop", r2.j, r2.i);
        VideoGiftLinkMonitor.Event r4 = VideoGiftLinkMonitor.Event.playcontroller_end;
        f r3 = this.b;
        VideoGiftLinkMonitor.a(r4, r3.j, r3.k, r3.l);
        this.b.c();
    }

    public final void onReportPlayMetrics(Map<String, String> r4) {
        Map<String, String> r0 = this.b.o.b;
        if (r0 == null) goto L5;
        r4.putAll(r0);
        this.b.o.a();
    L5:
        r4.put("mask_src_size", this.b.n + BuildConfig.FLAVOR);
        EffectMessage r1 = this.b.m;
        String r2 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        Intrinsics.checkNotNullParameter(r4, "metrics");
        LinkedHashMap r3 = new LinkedHashMap();
        r3.putAll(r4);
        String r5 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.a(r3, r1);
        mz0.n r6 = new mz0.n();
        Map r7 = r6.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r3, "map");
        r7.putAll(r3);
        mz0.m r8 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r9 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r9, "pageSourceLog");
        ((ArrayList) r8.a).add(r9.a);
        r8.b(LogCommon.ROOM);
        ((ArrayList) r6.b).addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r11 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r11);
        ((f80.a) r11).w3("livesdk_rd_gift_effect_play_metrics", r6.a, r6.b);
    }

    public e(f r1, com.bytedance.android.livesdk.gift.platform.business.effect.giftview.i r2) {
        this.b = r1;
        this.a = r2;
    }

    public final void onFileLoaded(int r3, int r4) {
        String r5 = v12.f.a;
        v12.f.E("onFileLoaded", this.b.j, false);
    }

    public final void updateTextEffectPosition(float r2, float r3, float r4, float r5) {
        IPlayerActionListener r0 = this.a;
        if (r0 == null) goto L5;
        r0.updateTextEffectPosition(r2, r3, r4, r5);
    L5:
        String r6 = v12.f.a;
        v12.f.E("updateTextEffectPosition", this.b.j, false);
    }
}
