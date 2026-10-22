package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import android.content.Context;
import android.os.Handler;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.platform.business.effect.utils.VideoGiftLinkMonitor;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayController;
import com.bytedance.android.livesdkapi.depend.live.gift.IResultMonitor;
import com.bytedance.android.livesdkapi.depend.live.gift.SuperResolutionModel;
import com.bytedance.android.livesdkapi.model.GiftPlayerAutoReleaseSwitch;
import com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc;
import java.util.Iterator;
import java.util.List;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public final Context a;
    public final FrameLayout b;
    public final e c;
    public final d d;
    public final IResultMonitor e;
    public ILiveGiftPlayController f;
    public final a g;
    public final c h;
    public boolean i;
    public long j;
    public long k;
    public long l;
    public EffectMessage m;
    public int n;
    public final com.bytedance.android.livesdk.gift.platform.core.utils.k o;

    public interface a {
        boolean a();
    }

    public final void a() {
        jy0.b.a("GiftCtlManager", "controller release() called with [" + this.f + "]");
        i0.c().removeCallbacks(this.h);
        ILiveGiftPlayController r0 = this.f;
        if (r0 == null) goto L5;
        r0.stopWhenSlideSwitch();
        this.f.removePlayerActionListener();
        this.f.removeMonitor();
        this.f.detachAlphaView(this.b);
    L5:
        this.f = null;
        this.m = null;
        this.n = 0;
        i.a().release(this.a.hashCode());
    }

    public final void c() {
        ReadOnlyProperty r0 = com.bytedance.android.livesdk.gift.platform.business.effect.a.w;
        KProperty[] r1 = com.bytedance.android.livesdk.gift.platform.business.effect.a.a;
        if (((GiftPlayerAutoReleaseSwitch) r0.getValue(null, r1[21])).enable == false) goto L10;
        i0.c().removeCallbacks(this.h);
        long r2 = ((GiftPlayerAutoReleaseSwitch) r0.getValue(null, r1[21])).aliveDuration;
        Handler r3 = i0.c();
        c r4 = this.h;
        if (r2 > 0) goto L8;
        r2 = 15000;
    L8:
        r3.postDelayed(r4, r2);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.livesdk.gift.platform.business.effect.player.c] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.livesdk.gift.platform.business.effect.player.d] */
    public f(Context r2, FrameLayout r3, com.bytedance.android.livesdk.gift.platform.business.effect.giftview.i r4, final BaseVideoGiftWidget.m r5, a r6, BaseVideoGiftWidget.h r7) {
        this.h = new c(this);
        this.i = true;
        this.o = new com.bytedance.android.livesdk.gift.platform.core.utils.k();
        this.a = r2;
        this.b = r3;
        this.e = r7;
        this.g = r6;
        this.d = new d(r5);
        this.c = new e(this, r4);
    }

    public final boolean b(String r23, long r24, long r26, long r28, List<MaskSrc> r30, SuperResolutionModel r31, String r33, EffectMessage r34) {
        i0.c().removeCallbacks(this.h);
        if (this.f != null) goto L16;
        ILiveGiftPlayController r3 = jc1.k.f(IGiftService.class).giftPlayControllerManager().get(this.a.hashCode());
        this.f = r3;
        if (r3 == null) goto L7;
    L9:
        ILiveGiftPlayController r4 = this.f;
        if (r4 != null) goto L12;
        ILiveGiftPlayController r5 = null;
    L18:
        if (r5 != null) goto L21;
        jy0.b.d("GiftCtlManager", "play gift video fail, because player is null.");
        v12.f.C("play gift video fail, because player is null", r33);
        return false;
    L21:
        this.j = r24;
        this.k = r26;
        this.l = r28;
        this.m = r34;
        this.n = r30.size();
        VideoGiftLinkMonitor.a(VideoGiftLinkMonitor.Event.playcontroller_start, this.j, this.k, this.l);
        Iterator<MaskSrc> r15 = r30.iterator();
    L23:
        if (r15.hasNext() == false) goto L30;
        MaskSrc r6 = r15.next();
        if (r6.getType() == 0) goto L26;
        if (r6.getType() != 1) goto L23;
        r5.setImageMask(r6.a, r6.g);
        goto L23
    L26:
        String r7 = r6.a;
        String r8 = r6.c;
        String r9 = r6.d;
        int r10 = r6.e;
        boolean r11 = r6.f;
        r5.setTextMask(r7, r8, r9, r10, r11);
        goto L23
    L30:
        r5.setSuperResolutionModel(r31);
        int r13 = r5.start(r23, r24);
        v12.f.G(r24, r26, r28, r13);
        if (r13 == 12) goto L34;
        if (r13 == 0) goto L34;
        return false;
    L34:
        return true;
    L12:
        r4.setPlayerActionListener(this.c);
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.e().disableProgressThread == true) goto L15;
        this.f.setPlayerProgressListener(this.d, 50);
    L15:
        this.f.setMonitor(this.e);
        this.f.attachAlphaView(this.b);
        goto L16
    L7:
        if ((this.a instanceof FragmentActivity) == false) goto L9;
        this.f = jc1.k.f(IGiftService.class).giftPlayControllerManager().initializeForPlay(this.a.hashCode(), this.a);
    L16:
        r5 = this.f;
        goto L18
    }
}
