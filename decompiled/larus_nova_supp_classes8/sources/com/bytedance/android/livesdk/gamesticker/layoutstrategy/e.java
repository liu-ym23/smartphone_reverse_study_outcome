package com.bytedance.android.livesdk.gamesticker.layoutstrategy;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.gamestickerv2.GameStickerContext;
import com.bytedance.android.livesdk.chatroom.gamestickerv2.GameStickerSetting;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerParams;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerSize;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerOpr;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerScene;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContainerViewProxy;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerLayoutStrategy;
import com.bytedance.android.livesdkapi.gamestickerv2.config.InvisibleCode;
import com.bytedance.android.livesdkapi.model.LayoutEvent;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements IGameStickerLayoutStrategy {
    public IGameStickerContainerViewProxy a;
    public final f b;
    public final g c;
    public final long d;
    public final LifecycleOwner e;
    public final ILivePlayerClient f;

    public static final class a {
    }

    static {
    }

    public final GameStickerContext a() {
        return com.bytedance.android.livesdk.chatroom.gamestickerv2.f.a.getDataContext(GameStickerScene.ENTER);
    }

    public final void detach() {
        b("detach");
        this.a = null;
        IRenderView r1 = this.f.getRenderView();
        if (r1 == null) goto L5;
        r1.removeRenderViewLayoutListener(this.b);
    L5:
        if (r1 == null) goto L7;
        r1.removeTranslationAndScaleListener(this.c);
    L7:
        GameStickerContext r2 = a();
        if (r2 == null) goto L10;
        r2.setTranslationAndScaleProperty(null);
    L10:
        GameStickerContext r3 = a();
        if (r3 == null) goto L13;
        r3.setLandscapeInputSize(null);
    L13:
        GameStickerContext r4 = a();
        if (r4 == null) goto L17;
        r4.setLandscapeOutputParam(null);
        return;
    }

    public final void attach(IGameStickerContainerViewProxy r3) {
        Intrinsics.checkNotNullParameter(r3, "viewProxy");
        b("attach");
        this.a = r3;
        IRenderView r4 = this.f.getRenderView();
        if (r4 == null) goto L5;
        r4.addTranslationAndScaleListener(this.c);
    L5:
        if (r4 == null) goto L7;
        r4.addRenderViewLayoutListener(this.b);
    L7:
        IGameStickerContainerViewProxy r5 = this.a;
        if (r5 == null) goto L10;
        r5.setTranslationAndScale(0.0f, 0.0f, 1.0f, 1.0f);
    L10:
        IGameStickerContainerViewProxy r6 = this.a;
        if (r6 == null) goto L14;
        r6.setLayoutStrategy(this);
        return;
    }

    public final void b(String r4) {
        ALogger.d("LayoutStrategyLandscape", this.d + " live landscape LayoutStrategy " + r4);
    }

    public final void requestLayout(GameStickerInfo r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "info");
        GameStickerSetting r0 = GameStickerSetting.f;
        if (r0.enableLandscape(r5.getStickerType()) == true) goto L5;
        return;
    L5:
        b("requestLayout operate:" + r5.getStickerOpr() + " code:" + r6);
        if (r5.getStickerOpr() != GameStickerOpr.CREATE) goto L8;
    L19:
        com.bytedance.android.livesdk.chatroom.gamestickerv2.f r1 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.a;
        InvisibleCode r7 = r0.isInvisibleCode(r6);
        if (r7 == null) goto L25;
        b("requestLayout invisible code:" + r7);
        GameStickerContext r8 = a();
        if (r8 == null) goto L24;
        r8.setLandscapeInputSize(null);
    L24:
        this.f.getEventHub().getLayoutEvent().setValue(new LayoutEvent("GameStickerHide"));
        return;
    L25:
        GameStickerContext r9 = a();
        if (r9 == null) goto L28;
        r9.setLandscapeInputSize(new BottomContainerSize(r0.getSizeMode(r5).ordinal(), r5.getStickerSize().getWidth(), r5.getStickerSize().getHeight()));
    L28:
        this.f.getEventHub().getLayoutEvent().setValue(new LayoutEvent("GameStickerCreateOrRefresh"));
        return;
    L8:
        if (r5.getStickerOpr() == GameStickerOpr.REFRESH) goto L19;
        if (r5.getStickerOpr() != GameStickerOpr.DESTROY) goto L30;
        IGameStickerContainerViewProxy r10 = this.a;
        if (r10 == null) goto L15;
        r10.setSize(0, 0);
    L15:
        GameStickerContext r11 = a();
        if (r11 == null) goto L18;
        r11.setLandscapeInputSize(null);
    L18:
        this.f.getEventHub().getLayoutEvent().setValue(new LayoutEvent("GameStickerDestroy"));
        return;
    }

    public e(long r2, LifecycleOwner r4, ILivePlayerClient r5) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        Intrinsics.checkNotNullParameter(r5, "player");
        this.d = r2;
        this.e = r4;
        this.f = r5;
        this.b = new f(this);
        this.c = new g(this);
    }

    public final void c(float r3, float r4, float r5, float r6) {
        GameStickerContext r0 = a();
        if (r0 == null) goto L5;
        BottomContainerParams r1 = r0.getLandscapeOutputParam();
    L6:
        if (r1 == null) goto L11;
        float r7 = r4 + (((r1.getPlayerH() + r1.getContainerH()) * (r6 - 1)) * 0.5f);
        IGameStickerContainerViewProxy r2 = this.a;
        if (r2 == null) goto L12;
        r2.setTranslationAndScale(r3, r7, r5, r6);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
