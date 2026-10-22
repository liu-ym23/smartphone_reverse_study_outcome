package com.bytedance.android.live.platformplayer.layout;

import android.content.Context;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerSize;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerScene;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.TranslationAndScaleProperty;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerServiceV2;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientContext;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LivePlayerWidget$updatePlayerLayout$1 implements d {
    public final Pair<Integer, Integer> a;
    public final Function0<a> b;
    public final /* synthetic */ LivePlayerWidget c;
    public final /* synthetic */ Integer d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final void c(e r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final void getMarginTop() {
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final Function0<a> h() {
        return null;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final Context b() {
        return ((Widget) this.c).context;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final c d() {
        return this.c.P;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final ILivePlayerScene f() {
        LivePlayerWidget r0 = this.c;
        int r1 = LivePlayerWidget.V2;
        ILivePlayerClient r2 = r0.dr();
        if (r2 == null) goto L9;
        LivePlayerClientContext r3 = r2.context();
        if (r3 == null) goto L9;
        ILivePlayerScene r4 = r3.getUseScene();
        if (r4 == null) goto L9;
        return r4;
    L9:
        return ILivePlayerScene.Companion.innerDraw();
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final BottomContainerSize g() {
        LivePlayerWidget r0 = this.c;
        int r1 = LivePlayerWidget.V2;
        r0.getClass();
        ILiveService r2 = TTLiveService.getLiveService();
        if (r2 == null) goto L7;
        IGameStickerServiceV2 r3 = r2.getGameStickerServiceV2();
        if (r3 == null) goto L7;
        IGameStickerContext r4 = r3.getDataContext(GameStickerScene.ENTER);
    L8:
        if (r4 != null) goto L10;
        return null;
    L10:
        return r4.getInputSize();
    L7:
        r4 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final DataCenter getDataCenter() {
        return ((Widget) this.c).dataCenter;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final ILivePlayerClient getLivePlayerClient() {
        LivePlayerWidget r0 = this.c;
        int r1 = LivePlayerWidget.V2;
        return r0.dr();
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final Room getRoom() {
        LivePlayerWidget r0 = this.c;
        int r1 = LivePlayerWidget.V2;
        return r0.bs();
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final LiveMode getStreamType() {
        return this.c.U2.getStreamType();
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final StreamUrl getStreamUrl() {
        return this.c.U2.getStreamUrl();
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final TranslationAndScaleProperty getTranslationAndScaleProperty() {
        LivePlayerWidget r0 = this.c;
        int r1 = LivePlayerWidget.V2;
        r0.getClass();
        ILiveService r2 = TTLiveService.getLiveService();
        if (r2 == null) goto L7;
        IGameStickerServiceV2 r3 = r2.getGameStickerServiceV2();
        if (r3 == null) goto L7;
        IGameStickerContext r4 = r3.getDataContext(GameStickerScene.ENTER);
    L8:
        if (r4 != null) goto L10;
        return null;
    L10:
        return r4.getTranslationAndScaleProperty();
    L7:
        r4 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final int getVideoHeight() {
        return ((Number) this.a.getSecond()).intValue();
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final int getVideoWidth() {
        return ((Number) this.a.getFirst()).intValue();
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final boolean isPortrait() {
        LivePlayerWidget r0 = this.c;
        Integer r1 = this.d;
        int r2 = LivePlayerWidget.V2;
        return r0.Rq(r1);
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final Function0<a> e() {
        return this.b;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final int getScreenHeight() {
        return this.e;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.d
    public final int getScreenWidth() {
        return this.f;
    }

    public LivePlayerWidget$updatePlayerLayout$1(LivePlayerWidget r1, Integer r2, int r3, int r4) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        int r5 = LivePlayerWidget.V2;
        this.a = r1.lr();
        this.b = new LivePlayerWidget$updatePlayerLayout$1$extraLayoutDataFuncInRoom$1(this);
    }
}
