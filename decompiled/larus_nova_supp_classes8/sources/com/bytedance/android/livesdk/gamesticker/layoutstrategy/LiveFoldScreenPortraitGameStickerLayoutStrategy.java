package com.bytedance.android.livesdk.gamesticker.layoutstrategy;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.gamestickerv2.GameStickerSetting;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerParams;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerSize;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerOpr;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerScene;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContainerViewProxy;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerLayoutStrategy;
import com.bytedance.android.livesdkapi.gamestickerv2.config.InvisibleCode;
import com.bytedance.android.livesdkapi.model.LayoutEvent;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerMultiRenderController;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveFoldScreenPortraitGameStickerLayoutStrategy implements IGameStickerLayoutStrategy {
    public static final /* synthetic */ int j = 0;
    public IGameStickerContainerViewProxy a;
    public int b;
    public final c c;
    public final b d;
    public final d e;
    public final long f;
    public final LifecycleOwner g;
    public final ILivePlayerClient h;
    public final DataCenter i;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ LiveFoldScreenPortraitGameStickerLayoutStrategy a;

        public b(LiveFoldScreenPortraitGameStickerLayoutStrategy r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            LiveFoldScreenPortraitGameStickerLayoutStrategy r6 = this.a;
            DataCenter r0 = r6.i;
            VideoViewParams r1 = null;
            if (r0 == null) goto L5;
            r1 = (VideoViewParams) r0.get("live_render_view_params", null);
        L5:
            r6.d(r1);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ LiveFoldScreenPortraitGameStickerLayoutStrategy a;

        public c(LiveFoldScreenPortraitGameStickerLayoutStrategy r1) {
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
            this.a.d(r5);
            return;
        L15:
            return;
        }
    }

    public static final class d implements IRenderView.LayoutListener {
        public final /* synthetic */ LiveFoldScreenPortraitGameStickerLayoutStrategy a;

        public d(LiveFoldScreenPortraitGameStickerLayoutStrategy r1) {
            this.a = r1;
        }

        public final void onLayoutReady(int r1, int r2, int r3, int r4) {
            this.a.b("on render layout change");
            LiveFoldScreenPortraitGameStickerLayoutStrategy.a(this.a);
        }
    }

    static {
    }

    public final void detach() {
        b("detach");
        this.a = null;
        IGameStickerContext r1 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.a.getDataContext(GameStickerScene.ENTER);
        if (r1 == null) goto L5;
        r1.setFoldScreenInputSize(null);
        r1.setFoldScreenOutputParam(null);
        r1.setFoldScreenOutParamChangeListener(null);
        r1.setFoldScreenV3OutputParam(null);
    L5:
        IRenderView r0 = this.h.getRenderView();
        if (r0 == null) goto L8;
        r0.removeRenderViewLayoutListener(this.e);
    L8:
        DataCenter r2 = this.i;
        if (r2 == null) goto L11;
        r2.removeObserver("live_render_view_params", this.c);
    L11:
        this.h.multiRenderController().eventHub().getMultiRenderBottom().removeObserver(this.d);
    }

    public static final void a(LiveFoldScreenPortraitGameStickerLayoutStrategy r5) {
        r5.getClass();
        com.bytedance.android.livesdk.chatroom.gamestickerv2.f r0 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.a;
        GameStickerScene r1 = GameStickerScene.ENTER;
        IGameStickerContext r2 = r0.getDataContext(r1);
        VideoViewParams r3 = null;
        if (r2 == null) goto L5;
        Pair r4 = r2.getFoldScreenOutputParam();
    L6:
        IGameStickerContext r6 = r0.getDataContext(r1);
        if (r6 == null) goto L9;
        BottomContainerParams r7 = r6.getFoldScreenV3OutputParam();
    L10:
        r5.b("onOutputParamChange params:" + r4 + ' ' + r7);
        if (r4 == null) goto L21;
        IGameStickerContainerViewProxy r8 = r5.a;
        if (r8 == null) goto L15;
        r8.setSize(((Number) r4.getFirst()).intValue(), ((Number) r4.getSecond()).intValue());
    L15:
        DataCenter r9 = r5.i;
        if (r9 == null) goto L18;
        r3 = (VideoViewParams) r9.get("live_render_view_params", null);
    L18:
        r5.d(r3);
        IGameStickerContainerViewProxy r10 = r5.a;
        if (r10 == null) goto L38;
        r10.onLayoutFinished();
        return;
    L38:
        return;
    L21:
        if (r7 == null) goto L31;
        IGameStickerContainerViewProxy r11 = r5.a;
        if (r11 == null) goto L25;
        r11.setMargin(r7.getContainerY(), r7.getContainerX());
    L25:
        IGameStickerContainerViewProxy r12 = r5.a;
        if (r12 == null) goto L28;
        r12.setSize(r7.getContainerW(), r7.getContainerH());
    L28:
        IGameStickerContainerViewProxy r13 = r5.a;
        if (r13 == null) goto L40;
        r13.onLayoutFinished();
        return;
    L40:
        return;
    L31:
        IGameStickerContainerViewProxy r14 = r5.a;
        if (r14 == null) goto L34;
        r14.setSize(0, 0);
    L34:
        IGameStickerContainerViewProxy r15 = r5.a;
        if (r15 == null) goto L42;
        r15.onLayoutFinished();
        return;
    L42:
        return;
    L9:
        r7 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final void attach(IGameStickerContainerViewProxy r3) {
        Intrinsics.checkNotNullParameter(r3, "viewProxy");
        b("attach");
        this.a = r3;
        IRenderView r4 = this.h.getRenderView();
        if (r4 == null) goto L5;
        r4.addRenderViewLayoutListener(this.e);
    L5:
        IGameStickerContext r5 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.a.getDataContext(GameStickerScene.ENTER);
        if (r5 == null) goto L8;
        r5.setFoldScreenOutParamChangeListener(new AnonymousClass1(this));
    L8:
        IGameStickerContainerViewProxy r6 = this.a;
        if (r6 == null) goto L11;
        r6.setLayoutStrategy(this);
    L11:
        DataCenter r7 = this.i;
        if (r7 == null) goto L14;
        r7.observe("live_render_view_params", this.c);
    L14:
        this.h.multiRenderController().eventHub().getMultiRenderBottom().observe(this.g, this.d);
    }

    public final void b(String r4) {
        ALogger.d("FoldScreenStrategy", this.f + " live foldScreen all portrait " + r4);
    }

    public final void c(String r3) {
        this.h.getEventHub().getLayoutEvent().postValue(new LayoutEvent(r3));
    }

    public final void d(VideoViewParams r6) {
        ILivePlayerClient r0 = LivePlatformPlayerManager.a(this.f, false);
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

    public final void requestLayout(GameStickerInfo r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "info");
        IGameStickerContext r0 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.a.getDataContext(GameStickerScene.ENTER);
        if (r0 != null) goto L5;
        return;
    L5:
        GameStickerSetting r1 = GameStickerSetting.f;
        b("requestLayout operate:" + r6.getStickerOpr() + " code:" + r7);
        if (r6.getStickerOpr() != GameStickerOpr.CREATE) goto L8;
    L16:
        InvisibleCode r8 = r1.isInvisibleCode(r7);
        if (r8 == null) goto L19;
        b("requestLayout invisible code:" + r8);
        r0.setFoldScreenInputSize(null);
        c("GameStickerHide");
        return;
    L19:
        b("requestLayout setFoldScreenInputSize");
        r0.setFoldScreenInputSize(new BottomContainerSize(r1.getSizeMode(r6).ordinal(), r6.getStickerSize().getWidth(), r6.getStickerSize().getHeight()));
        c("GameStickerCreateOrRefresh");
        return;
    L8:
        if (r6.getStickerOpr() == GameStickerOpr.REFRESH) goto L16;
        if (r6.getStickerOpr() != GameStickerOpr.DESTROY) goto L21;
        b("requestLayout destroy");
        IGameStickerContainerViewProxy r9 = this.a;
        if (r9 == null) goto L15;
        r9.setSize(0, 0);
    L15:
        r0.setFoldScreenInputSize(null);
        c("GameStickerDestroy");
        return;
    }

    public LiveFoldScreenPortraitGameStickerLayoutStrategy(long r2, LifecycleOwner r4, ILivePlayerClient r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        Intrinsics.checkNotNullParameter(r5, "player");
        this.f = r2;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.b = -1;
        this.c = new c(this);
        this.d = new b(this);
        this.e = new d(this);
    }
}
