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
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.TranslationAndScaleProperty;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContainerViewProxy;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerLayoutStrategy;
import com.bytedance.android.livesdkapi.gamestickerv2.config.InvisibleCode;
import com.bytedance.android.livesdkapi.model.LayoutEvent;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveFoldScreenLandscapeLayoutStrategy implements IGameStickerLayoutStrategy {
    public static final /* synthetic */ int g = 0;
    public IGameStickerContainerViewProxy a;
    public final c b;
    public final d c;
    public final long d;
    public final LifecycleOwner e;
    public final ILivePlayerClient f;

    public static final class a {
    }

    static {
    }

    public final GameStickerContext b() {
        return com.bytedance.android.livesdk.chatroom.gamestickerv2.f.a.getDataContext(GameStickerScene.ENTER);
    }

    public final void detach() {
        c("detach");
        this.a = null;
        IRenderView r1 = this.f.getRenderView();
        if (r1 == null) goto L5;
        r1.removeRenderViewLayoutListener(this.b);
    L5:
        if (r1 == null) goto L7;
        r1.removeTranslationAndScaleListener(this.c);
    L7:
        GameStickerContext r2 = b();
        if (r2 == null) goto L11;
        r2.setTranslationAndScaleProperty(null);
        r2.setLandscapeInputSize(null);
        r2.setLandscapeOutputParam(null);
        return;
    }

    public static final void a(LiveFoldScreenLandscapeLayoutStrategy r5) {
        GameStickerContext r0 = r5.b();
        if (r0 == null) goto L5;
        BottomContainerParams r1 = r0.getLandscapeOutputParam();
    L6:
        r5.c("onOutputParamChange params:" + r1);
        if (r1 == null) goto L22;
        GameStickerContext r2 = r5.b();
        if (r2 == null) goto L13;
        TranslationAndScaleProperty r3 = r2.getTranslationAndScaleProperty();
        if (r3 == null) goto L13;
        r5.d(r3.getTranslationX(), r3.getTranslationY(), r3.getScaleX(), r3.getScaleY());
    L13:
        IGameStickerContainerViewProxy r4 = r5.a;
        if (r4 == null) goto L16;
        r4.setMargin(r1.getContainerY(), r1.getContainerX());
    L16:
        IGameStickerContainerViewProxy r6 = r5.a;
        if (r6 == null) goto L19;
        r6.setSize(r1.getContainerW(), r1.getContainerH());
    L19:
        IGameStickerContainerViewProxy r7 = r5.a;
        if (r7 == null) goto L29;
        r7.onLayoutFinished();
        return;
    L29:
        return;
    L22:
        IGameStickerContainerViewProxy r8 = r5.a;
        if (r8 == null) goto L25;
        r8.setSize(0, 0);
    L25:
        IGameStickerContainerViewProxy r9 = r5.a;
        if (r9 == null) goto L31;
        r9.onLayoutFinished();
        return;
    L31:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void attach(IGameStickerContainerViewProxy r3) {
        Intrinsics.checkNotNullParameter(r3, "viewProxy");
        c("attach");
        this.a = r3;
        IRenderView r4 = this.f.getRenderView();
        if (r4 == null) goto L5;
        r4.addTranslationAndScaleListener(this.c);
    L5:
        if (r4 == null) goto L7;
        r4.addRenderViewLayoutListener(this.b);
    L7:
        IGameStickerContext r5 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.a.getDataContext(GameStickerScene.ENTER);
        if (r5 == null) goto L10;
        r5.setFoldScreenOutParamChangeListener(new AnonymousClass1(this));
    L10:
        IGameStickerContainerViewProxy r6 = this.a;
        if (r6 == null) goto L13;
        r6.setTranslationAndScale(0.0f, 0.0f, 1.0f, 1.0f);
    L13:
        IGameStickerContainerViewProxy r7 = this.a;
        if (r7 == null) goto L17;
        r7.setLayoutStrategy(this);
        return;
    }

    public final void c(String r4) {
        ALogger.d("FoldScreenStrategy", this.d + " live foldScreen half landscape " + r4);
    }

    public final void requestLayout(GameStickerInfo r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "info");
        GameStickerSetting r0 = GameStickerSetting.f;
        if (r0.enableLandscape(r5.getStickerType()) == true) goto L5;
        return;
    L5:
        c("requestLayout operate:" + r5.getStickerOpr() + " code:" + r6);
        if (r5.getStickerOpr() != GameStickerOpr.CREATE) goto L8;
    L19:
        com.bytedance.android.livesdk.chatroom.gamestickerv2.f r1 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.a;
        InvisibleCode r7 = r0.isInvisibleCode(r6);
        if (r7 == null) goto L25;
        c("requestLayout invisible code:" + r7);
        GameStickerContext r8 = b();
        if (r8 == null) goto L24;
        r8.setLandscapeInputSize(null);
    L24:
        this.f.getEventHub().getLayoutEvent().setValue(new LayoutEvent("GameStickerHide"));
        return;
    L25:
        c("requestLayout setFoldScreenInputSize");
        GameStickerContext r9 = b();
        if (r9 == null) goto L28;
        r9.setLandscapeInputSize(new BottomContainerSize(r0.getSizeMode(r5).ordinal(), r5.getStickerSize().getWidth(), r5.getStickerSize().getHeight()));
    L28:
        this.f.getEventHub().getLayoutEvent().setValue(new LayoutEvent("GameStickerCreateOrRefresh"));
        return;
    L8:
        if (r5.getStickerOpr() == GameStickerOpr.REFRESH) goto L19;
        if (r5.getStickerOpr() != GameStickerOpr.DESTROY) goto L30;
        c("requestLayout destroy");
        IGameStickerContainerViewProxy r10 = this.a;
        if (r10 == null) goto L15;
        r10.setSize(0, 0);
    L15:
        GameStickerContext r11 = b();
        if (r11 == null) goto L18;
        r11.setLandscapeInputSize(null);
    L18:
        this.f.getEventHub().getLayoutEvent().setValue(new LayoutEvent("GameStickerDestroy"));
        return;
    }

    public LiveFoldScreenLandscapeLayoutStrategy(long r2, LifecycleOwner r4, ILivePlayerClient r5) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        Intrinsics.checkNotNullParameter(r5, "player");
        this.d = r2;
        this.e = r4;
        this.f = r5;
        this.b = new c(this);
        this.c = new d(this);
    }

    public final void d(float r3, float r4, float r5, float r6) {
        GameStickerContext r0 = b();
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
