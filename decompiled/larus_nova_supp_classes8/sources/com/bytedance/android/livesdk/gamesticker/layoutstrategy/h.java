package com.bytedance.android.livesdk.gamesticker.layoutstrategy;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.gamestickerv2.GameStickerSetting;
import com.bytedance.android.livesdk.chatroom.gamestickerv2.s;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerOpr;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContainerViewProxy;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerLayoutStrategy;
import com.bytedance.android.livesdkapi.gamestickerv2.config.InvisibleCode;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerMultiRenderController;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements IGameStickerLayoutStrategy {
    public IGameStickerContainerViewProxy a;
    public int b;
    public final b c;
    public final a d;
    public final long e;
    public final LifecycleOwner f;
    public final ILivePlayerClient g;
    public final DataCenter h;

    public static final class a<T> implements Observer {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Integer r2 = (Integer) r1;
            h.c(this.a);
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            KVData r4 = (KVData) r3;
            if (r4 != null) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r4.getKey(), "live_render_view_params") == true) goto L8;
            r4 = null;
        L8:
            if (r4 == null) goto L14;
            VideoViewParams r5 = (VideoViewParams) r4.getData();
            if (r5 == null) goto L15;
            this.a.b(r5);
            return;
        L15:
            return;
        }
    }

    public final void detach() {
        a("detach");
        this.a = null;
        DataCenter r0 = this.h;
        if (r0 == null) goto L5;
        r0.removeObserver("live_render_view_params", this.c);
    L5:
        this.g.multiRenderController().eventHub().getMultiRenderBottom().removeObserver(this.d);
    }

    public static /* synthetic */ void c(h r3) {
        DataCenter r0 = r3.h;
        VideoViewParams r1 = null;
        if (r0 == null) goto L5;
        r1 = (VideoViewParams) r0.get("live_render_view_params", null);
    L5:
        r3.b(r1);
    }

    public final void a(String r4) {
        ALogger.d("LayoutStrategyPortrait", this.e + " live portrait LayoutStrategy " + r4);
    }

    public final void attach(IGameStickerContainerViewProxy r3) {
        Intrinsics.checkNotNullParameter(r3, "viewProxy");
        a("attach");
        this.a = r3;
        if (r3 == null) goto L5;
        r3.setTranslationAndScale(0.0f, 0.0f, 1.0f, 1.0f);
    L5:
        IGameStickerContainerViewProxy r4 = this.a;
        if (r4 == null) goto L8;
        r4.setLayoutStrategy(this);
    L8:
        c(this);
        this.g.multiRenderController().eventHub().getMultiRenderBottom().observe(this.f, this.d);
        DataCenter r5 = this.h;
        if (r5 == null) goto L12;
        r5.observe("live_render_view_params", this.c);
        return;
    }

    public final void b(VideoViewParams r6) {
        ILivePlayerClient r0 = LivePlatformPlayerManager.a(this.e, false);
        Integer r1 = null;
        if (r0 == null) goto L5;
        ILivePlayerMultiRenderController r2 = r0.multiRenderController();
    L6:
        if (r2 == null) goto L19;
        boolean r4 = true;
        if (r2.isEnable() != true) goto L19;
        Integer r7 = (Integer) r2.eventHub().getMultiRenderBottom().getValue();
        if (r7 != null) goto L12;
    L21:
        int r8 = 0;
    L23:
        if (r8 == this.b) goto L28;
        this.b = r8;
        IGameStickerContainerViewProxy r3 = this.a;
        if (r3 == null) goto L29;
        r3.setMargin(r8, 0);
        return;
    L29:
        return;
    L28:
        return;
    L12:
        if (Intrinsics.compare(r7.intValue(), 0) > 0) goto L15;
        r4 = false;
    L15:
        if (r4 == false) goto L17;
        r1 = r7;
    L17:
        if (r1 == null) goto L21;
        r8 = r1.intValue();
    L19:
        if (r6 == null) goto L21;
        r8 = r6.b + r6.c;
        goto L23
    L5:
        r2 = null;
        goto L6
    }

    public final void requestLayout(GameStickerInfo r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "info");
        a("requestLayout operate:" + r4.getStickerOpr() + " code:" + r5);
        if (r4.getStickerOpr() != GameStickerOpr.CREATE) goto L5;
    L15:
        c(this);
        com.bytedance.android.livesdk.chatroom.gamestickerv2.f r0 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.a;
        InvisibleCode r6 = GameStickerSetting.f.isInvisibleCode(r5);
        if (r6 == null) goto L23;
        a("requestLayout invisible code:" + r6);
        IGameStickerContainerViewProxy r7 = this.a;
        if (r7 == null) goto L20;
        r7.setSize(0, 0);
    L20:
        IGameStickerContainerViewProxy r8 = this.a;
        if (r8 == null) goto L33;
        r8.onLayoutFinished();
        return;
    L33:
        return;
    L23:
        Pair r9 = s.a.calculate(r4);
        IGameStickerContainerViewProxy r10 = this.a;
        if (r10 == null) goto L26;
        r10.setSize(((Number) r9.getFirst()).intValue(), ((Number) r9.getSecond()).intValue());
    L26:
        IGameStickerContainerViewProxy r11 = this.a;
        if (r11 == null) goto L35;
        r11.onLayoutFinished();
        return;
    L35:
        return;
    L5:
        if (r4.getStickerOpr() == GameStickerOpr.REFRESH) goto L15;
        if (r4.getStickerOpr() != GameStickerOpr.DESTROY) goto L30;
        IGameStickerContainerViewProxy r12 = this.a;
        if (r12 == null) goto L12;
        r12.setSize(0, 0);
    L12:
        IGameStickerContainerViewProxy r13 = this.a;
        if (r13 == null) goto L31;
        r13.onLayoutFinished();
        return;
    L31:
        return;
    }

    public h(long r2, LifecycleOwner r4, ILivePlayerClient r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        Intrinsics.checkNotNullParameter(r5, "player");
        this.e = r2;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.b = -1;
        this.c = new b(this);
        this.d = new a(this);
    }
}
