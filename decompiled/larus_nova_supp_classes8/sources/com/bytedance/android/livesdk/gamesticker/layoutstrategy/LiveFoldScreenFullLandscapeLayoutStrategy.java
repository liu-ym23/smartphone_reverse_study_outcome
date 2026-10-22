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
public final class LiveFoldScreenFullLandscapeLayoutStrategy implements IGameStickerLayoutStrategy {
    public static final /* synthetic */ int g = 0;
    public IGameStickerContainerViewProxy a;
    public final com.bytedance.android.livesdk.gamesticker.layoutstrategy.a b;
    public final b c;
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
        IGameStickerContext r1 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.a.getDataContext(GameStickerScene.ENTER);
        if (r1 == null) goto L5;
        r1.setFoldScreenInputSize(null);
        r1.setFoldScreenOutputParam(null);
        r1.setFoldScreenOutParamChangeListener(null);
        r1.setFoldScreenV3OutputParam(null);
    L5:
        IRenderView r2 = this.f.getRenderView();
        GameStickerContext r3 = b();
        if (r3 == null) goto L8;
        r3.setFoldScreenOutParamChangeListener(null);
    L8:
        if (r2 == null) goto L10;
        r2.removeRenderViewLayoutListener(this.b);
    L10:
        if (r2 == null) goto L13;
        r2.removeTranslationAndScaleListener(this.c);
        return;
    }

    public static final void a(LiveFoldScreenFullLandscapeLayoutStrategy r5) {
        r5.getClass();
        com.bytedance.android.livesdk.chatroom.gamestickerv2.f r0 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.a;
        GameStickerScene r1 = GameStickerScene.ENTER;
        IGameStickerContext r2 = r0.getDataContext(r1);
        BottomContainerParams r3 = null;
        if (r2 == null) goto L5;
        BottomContainerParams r4 = r2.getLandscapeOutputParam();
    L6:
        IGameStickerContext r6 = r0.getDataContext(r1);
        if (r6 == null) goto L9;
        r3 = r6.getFoldScreenV3OutputParam();
    L9:
        if (r4 != null) goto L11;
        BottomContainerParams r7 = r3;
    L12:
        r5.c("onOutputParamChange params:" + r4 + ' ' + r3);
        if (r7 == null) goto L28;
        GameStickerContext r8 = r5.b();
        if (r8 == null) goto L19;
        TranslationAndScaleProperty r9 = r8.getTranslationAndScaleProperty();
        if (r9 == null) goto L19;
        r5.e(r9.getTranslationX(), r9.getTranslationY(), r9.getScaleX(), r9.getScaleY());
    L19:
        IGameStickerContainerViewProxy r10 = r5.a;
        if (r10 == null) goto L22;
        r10.setMargin(r7.getContainerY(), r7.getContainerX());
    L22:
        IGameStickerContainerViewProxy r11 = r5.a;
        if (r11 == null) goto L25;
        r11.setSize(r7.getContainerW(), r7.getContainerH());
    L25:
        IGameStickerContainerViewProxy r12 = r5.a;
        if (r12 == null) goto L35;
        r12.onLayoutFinished();
        return;
    L35:
        return;
    L28:
        IGameStickerContainerViewProxy r13 = r5.a;
        if (r13 == null) goto L31;
        r13.setSize(0, 0);
    L31:
        IGameStickerContainerViewProxy r14 = r5.a;
        if (r14 == null) goto L37;
        r14.onLayoutFinished();
        return;
    L37:
        return;
    L11:
        r7 = r4;
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    public final void attach(IGameStickerContainerViewProxy r2) {
        Intrinsics.checkNotNullParameter(r2, "viewProxy");
        c("attach");
        this.a = r2;
        IRenderView r3 = this.f.getRenderView();
        if (r3 == null) goto L5;
        r3.addRenderViewLayoutListener(this.b);
    L5:
        if (r3 == null) goto L7;
        r3.addTranslationAndScaleListener(this.c);
    L7:
        GameStickerContext r4 = b();
        if (r4 == null) goto L10;
        r4.setFoldScreenOutParamChangeListener(new AnonymousClass1(this));
    L10:
        IGameStickerContainerViewProxy r5 = this.a;
        if (r5 == null) goto L14;
        r5.setLayoutStrategy(this);
        return;
    }

    public final void c(String r4) {
        ALogger.d("FoldScreenStrategy", this.d + " live foldScreen full landscape " + r4);
    }

    public final void d(String r3) {
        this.f.getEventHub().getLayoutEvent().postValue(new LayoutEvent(r3));
    }

    public final void requestLayout(GameStickerInfo r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "info");
        IGameStickerContext r0 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.a.getDataContext(GameStickerScene.ENTER);
        if (r0 != null) goto L5;
        return;
    L5:
        GameStickerSetting r1 = GameStickerSetting.f;
        c("requestLayout operate:" + r6.getStickerOpr() + " code:" + r7);
        if (r6.getStickerOpr() != GameStickerOpr.CREATE) goto L8;
    L16:
        InvisibleCode r8 = r1.isInvisibleCode(r7);
        if (r8 == null) goto L19;
        c("requestLayout invisible code " + r8);
        r0.setFoldScreenInputSize(null);
        d("GameStickerHide");
        return;
    L19:
        c("requestLayout setFoldScreenInputSize");
        r0.setFoldScreenInputSize(new BottomContainerSize(r1.getSizeMode(r6).ordinal(), r6.getStickerSize().getWidth(), r6.getStickerSize().getHeight()));
        d("GameStickerCreateOrRefresh");
        return;
    L8:
        if (r6.getStickerOpr() == GameStickerOpr.REFRESH) goto L16;
        if (r6.getStickerOpr() != GameStickerOpr.DESTROY) goto L21;
        c("requestLayout destroy");
        IGameStickerContainerViewProxy r9 = this.a;
        if (r9 == null) goto L15;
        r9.setSize(0, 0);
    L15:
        r0.setFoldScreenInputSize(null);
        d("GameStickerDestroy");
        return;
    }

    public LiveFoldScreenFullLandscapeLayoutStrategy(long r2, LifecycleOwner r4, ILivePlayerClient r5) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        Intrinsics.checkNotNullParameter(r5, "player");
        this.d = r2;
        this.e = r4;
        this.f = r5;
        this.b = new com.bytedance.android.livesdk.gamesticker.layoutstrategy.a(this);
        this.c = new b(this);
    }

    public final void e(float r3, float r4, float r5, float r6) {
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
