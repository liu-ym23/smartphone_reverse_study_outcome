package com.bytedance.android.livesdk.gamesticker.layoutstrategy;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
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
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerLayoutStrategy;
import com.bytedance.android.livesdkapi.model.LayoutEvent;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveUniversalLayoutStrategy implements IGameStickerLayoutStrategy {
    public static final /* synthetic */ int i = 0;
    public IGameStickerContainerViewProxy a;
    public final b b;
    public final Lazy c;
    public String d;
    public boolean e;
    public final long f;
    public final LifecycleOwner g;
    public final ILivePlayerClient h;

    public static final class a {
    }

    public static final class b implements IRenderView.TranslationAndScaleListener {
        public final /* synthetic */ LiveUniversalLayoutStrategy a;

        public b(LiveUniversalLayoutStrategy r1) {
            this.a = r1;
        }

        public final void onTranslationAndScaleChange(float r3, float r4, float r5, float r6) {
            this.a.c(r3, r4, r5, r6);
            this.a.getClass();
            GameStickerContext r0 = LiveUniversalLayoutStrategy.d();
            if (r0 == null) goto L9;
            TranslationAndScaleProperty r1 = r0.getTranslationAndScaleProperty();
            if (r1 != null) goto L7;
            r1 = new TranslationAndScaleProperty();
        L7:
            r1.setTranslationX(r3);
            r1.setTranslationY(r4);
            r1.setScaleX(r5);
            r1.setScaleY(r6);
            r0.setTranslationAndScaleProperty(r1);
            return;
        }
    }

    static {
    }

    public static GameStickerContext d() {
        return com.bytedance.android.livesdk.chatroom.gamestickerv2.f.a.getDataContext(GameStickerScene.ENTER);
    }

    public final void detach() {
        a("detach");
        this.d = null;
        this.a = null;
        GameStickerContext r1 = d();
        if (r1 == null) goto L5;
        r1.setUniversalInputSize(null);
        r1.setUniversalOutputParam(null);
        r1.getUniversalOutputParamLiveData().removeObserver((Observer) this.c.getValue());
        r1.setTranslationAndScaleProperty(null);
    L5:
        IRenderView r0 = this.h.getRenderView();
        if (r0 == null) goto L9;
        r0.removeTranslationAndScaleListener(this.b);
        return;
    }

    public final void a(String r4) {
        ALogger.d("UniversalLayoutStrategy", this.f + " live universal layoutStrategy " + r4);
    }

    public final void attach(IGameStickerContainerViewProxy r3) {
        Intrinsics.checkNotNullParameter(r3, "viewProxy");
        a("attach");
        this.d = null;
        this.a = r3;
        if (r3 == null) goto L5;
        r3.setTranslationAndScale(0.0f, 0.0f, 1.0f, 1.0f);
    L5:
        IGameStickerContainerViewProxy r4 = this.a;
        if (r4 == null) goto L8;
        r4.setLayoutStrategy(this);
    L8:
        IRenderView r5 = this.h.getRenderView();
        if (r5 == null) goto L11;
        r5.addTranslationAndScaleListener(this.b);
    L11:
        GameStickerContext r6 = d();
        if (r6 == null) goto L17;
        NextLiveData r7 = r6.getUniversalOutputParamLiveData();
        if (r7 == null) goto L18;
        r7.observe(this.g, (Observer) this.c.getValue());
        return;
    L18:
        return;
    }

    public final void requestLayout(GameStickerInfo r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "info");
        GameStickerContext r0 = d();
        if (r0 != null) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.chatroom.gamestickerv2.f r1 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.a;
        GameStickerSetting r2 = GameStickerSetting.f;
        if (r2.enableLandscape(r7.getStickerType()) == false) goto L8;
    L10:
        GameStickerOpr r3 = r7.getStickerOpr();
        GameStickerOpr r4 = GameStickerOpr.CREATE;
        if (r3 == r4) goto L22;
        if (r7.getStickerOpr() == GameStickerOpr.REFRESH) goto L22;
        if (r7.getStickerOpr() != GameStickerOpr.DESTROY) goto L30;
        IGameStickerContainerViewProxy r5 = this.a;
        if (r5 == null) goto L20;
        r5.setUiParams(0, 0, 0, 0);
    L20:
        r0.setUniversalInputSize(null);
        b("GameStickerDestroy", r7.getStickerOpr(), r8);
        return;
    L30:
        return;
    L22:
        if (r2.isInvisibleCode(r8) == null) goto L24;
        r0.setUniversalInputSize(null);
        b("GameStickerHide", r7.getStickerOpr(), r8);
        return;
    L24:
        r0.setUniversalInputSize(new BottomContainerSize(r2.getSizeMode(r7).ordinal(), r7.getStickerSize().getWidth(), r7.getStickerSize().getHeight()));
        if (r7.getStickerOpr() != r4) goto L27;
        String r6 = "GameStickerCreate";
    L28:
        b(r6, r7.getStickerOpr(), r8);
        return;
    L27:
        r6 = "GameStickerRefresh";
        goto L28
    L8:
        if (this.e == true) goto L10;
    }

    public LiveUniversalLayoutStrategy(long r2, LifecycleOwner r4, ILivePlayerClient r5) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        Intrinsics.checkNotNullParameter(r5, "player");
        this.f = r2;
        this.g = r4;
        this.h = r5;
        this.b = new b(this);
        this.c = LazyKt.lazy(new LiveUniversalLayoutStrategy$outPutParamsObserver$2(this));
        this.e = true;
    }

    public final void b(String r4, GameStickerOpr r5, int r6) {
        String r0 = r4 + r6;
        if (Intrinsics.areEqual(this.d, r0) == false) goto L5;
        return;
    L5:
        a("requestLayout operate:" + r5 + " code:" + r6);
        this.d = r0;
        this.h.getEventHub().getLayoutEvent().postValue(new LayoutEvent(r4));
    }

    public final void c(float r3, float r4, float r5, float r6) {
        GameStickerContext r0 = d();
        if (r0 == null) goto L5;
        BottomContainerParams r1 = r0.getUniversalOutputParam();
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
