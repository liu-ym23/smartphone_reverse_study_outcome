package com.bytedance.android.live.platformplayer.panel;

import am2.x;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.animation.AccelerateInterpolator;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.nk;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.StreamAutoAdapterConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t implements d {
    public final float a;
    public LivePlayerView b;
    public float c;
    public float d;
    public float e;
    public Animator f;
    public final StreamAutoAdapterService g;

    public t() {
        StreamAutoAdapterService r0 = StreamAutoAdapterService.o;
        Intrinsics.checkNotNullParameter(r0, "adapterService");
        this.g = r0;
        this.a = 0.999f;
        this.c = 0.999f;
        this.e = 0.5f;
    }

    @Override // com.bytedance.android.live.platformplayer.panel.d
    public final void D() {
        if (this.c == this.a) goto L11;
        this.g.getClass();
        StreamAutoAdapterConfig r0 = StreamAutoAdapterService.b();
        if (r0 == null) goto L11;
        if (r0.getSearchSceneFix() != true) goto L11;
        LivePlayerView r1 = this.b;
        if (r1 == null) goto L11;
        r1.setScrollY((int) this.c);
    L11:
        this.c = this.a;
        this.d = 0.0f;
        this.b = null;
        this.f = null;
    }

    @Override // com.bytedance.android.live.platformplayer.panel.d
    public final void E(float r5) {
        if (Float.isNaN(r5) == true) goto L23;
        LivePlayerView r0 = this.b;
        if (r0 == null) goto L12;
        ILivePlayerClient r1 = r0.getClient();
        if (r1 == null) goto L12;
        if (r1.isVideoHorizontal() != true) goto L12;
        return;
    L12:
        if (this.c != this.a) goto L19;
        this.g.getClass();
        StreamAutoAdapterConfig r2 = StreamAutoAdapterService.b();
        if (r2 == null) goto L19;
        if (r2.getCanScrollIntercept() != true) goto L19;
        this.g.e("onPanelScroll, originY is not set, so no scroll");
        return;
    L19:
        LivePlayerView r3 = this.b;
        if (r3 == null) goto L24;
        float r4 = this.d + (r5 * this.e);
        this.g.e("onPanelScroll, newScrollY : " + r4 + ", originY: " + this.c);
        r3.scrollTo(r3.getScrollX(), (int) r4);
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.live.platformplayer.panel.d
    public final void H(LivePlayerView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.b = r2;
    }

    @Override // com.bytedance.android.live.platformplayer.panel.d
    public final void G(ds0.b r7, String r8, Boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "panelEvent");
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == false) goto L6;
        return;
    L6:
        if (this.c != this.a) goto L9;
        this.g.e("no need restoreStream.");
        return;
    L9:
        LivePlayerView r10 = this.b;
        if (r10 != null) goto L13;
        this.g.e("restoreStream failed. playerView is null");
        return;
    L13:
        float r11 = r10.getScrollY() - this.c;
        this.g.e("restoreStream. scroll y : " + r11 + ", origin y " + this.c);
        Animator r0 = this.f;
        if (r0 == null) goto L21;
        if (r0.isRunning() != true) goto L21;
        this.g.e("cancel running animator");
        Animator r1 = this.f;
        if (r1 == null) goto L21;
        r1.cancel();
    L21:
        if (r7.g == 0) goto L26;
        this.g.getClass();
        if (StreamAutoAdapterService.b().getDisableAnimator() == true) goto L26;
        ObjectAnimator r12 = ObjectAnimator.ofInt(r10, "scrollY", new int[]{(int) r11, (int) this.c});
        r12.setDuration(r7.g);
        r12.start();
        Unit r13 = Unit.INSTANCE;
        this.f = r12;
        return;
    L26:
        r10.setScrollY((int) this.c);
    }

    @Override // com.bytedance.android.live.platformplayer.panel.d
    public final void F(nk r10, ds0.b r11, String r12, Boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "panelEvent");
        if (r10 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r13, Boolean.TRUE) == false) goto L8;
        return;
    L8:
        LivePlayerView r14 = this.b;
        if (r14 != null) goto L12;
        this.g.e("adaptStream failed. playerView is null");
        return;
    L12:
        this.g.e("game adaptStreamOnOpen  adaptionMessage.adaptationType = " + r10.H() + " ，adaptation_height_ratio = " + r10.G() + ", adaptationBodyCenterRatio = " + r10.E() + "  ");
        LivePlayerView r0 = this.b;
        if (r0 == null) goto L21;
        ILivePlayerClient r1 = r0.getClient();
        if (r1 == null) goto L21;
        if (r1.isVideoHorizontal() == false) goto L19;
        return;
    L19:
        if (Intrinsics.areEqual((Boolean) r1.getEventHub().getFirstFrame().getValue(), Boolean.FALSE) == false) goto L21;
        return;
    L21:
        int r2 = r10.H();
        int r3 = nk.a;
        if (r2 != 1) goto L26;
        this.g.getClass();
        StreamAutoAdapterService.g(r11);
        return;
    L26:
        if (r10.H() != 2) goto L29;
        this.e = 0.5f;
        this.d = (r11.c * 1.0f) / 2;
    L29:
        if (r10.H() != 3) goto L41;
        float r4 = r14.getHeight() * r10.G();
        float r5 = r14.getHeight();
        this.g.getClass();
        float r6 = r5 * StreamAutoAdapterService.b().getHeadSafeDistance();
        float r7 = r14.getHeight() * r10.E();
        int r8 = r14.getHeight();
        int r9 = r11.c;
        int r15 = (r8 - r9) / 2;
        float r16 = r7 - r15;
        this.d = r16;
        if ((r4 - r16) >= r6) goto L33;
        this.d = r4 - r6;
        int r17 = -1;
    L35:
        if (this.d <= r9) goto L37;
        this.g.getClass();
        this.d = r9 - s1.f(StreamAutoAdapterService.b().getUiOptimizeDp());
        r17 = -2;
    L37:
        float r18 = this.d;
        if (r18 >= 0) goto L40;
        return;
    L40:
        this.e = r18 / r11.c;
        this.g.e("adaptStream type@3, adaptMode : " + r17 + ", bodyCenterOffset :" + r7 + ", availableAreaCenterOffset:" + r15);
        goto L41
    L33:
        r17 = 0;
    L41:
        this.g.e("start adaptStream. scroll y : " + this.d + " , panelHeight : " + r11.c);
        this.c = (float) r14.getScrollY();
        Animator r19 = this.f;
        if (r19 == null) goto L49;
        if (r19.isRunning() != true) goto L49;
        this.g.e("cancel running animator");
        Animator r20 = this.f;
        if (r20 == null) goto L49;
        r20.cancel();
    L49:
        if (r11.f == 0) goto L54;
        this.g.getClass();
        if (StreamAutoAdapterService.b().getDisableAnimator() == true) goto L54;
        ObjectAnimator r110 = ObjectAnimator.ofInt(r14, "scrollY", new int[]{(int) this.c, (int) this.d});
        r110.setDuration(r11.f);
        r110.setInterpolator(new AccelerateInterpolator());
        r110.start();
        Unit r21 = Unit.INSTANCE;
        this.f = r110;
    L55:
        int r111 = (int) this.d;
        if (r111 == 0) goto L60;
        Intrinsics.checkNotNullParameter(r11, "panelEvent");
        Intrinsics.checkNotNullParameter(r10, "adapterMsg");
        com.bytedance.android.livesdk.log.g r112 = u.l();
        HashMap r22 = new HashMap();
        r22.put("panel_scene", r11.getType().getIdentifier());
        r22.put("strategy_type", String.valueOf(r10.H()));
        r22.put("move_length", String.valueOf(r111));
        Unit r113 = Unit.INSTANCE;
        r112.sendLog("livesdk_live_screen_adaptive_strategy", r22, new Object[]{Room.class, x.class});
        return;
    L60:
        return;
    L54:
        r14.setScrollY((int) this.d);
        goto L55
    }
}
