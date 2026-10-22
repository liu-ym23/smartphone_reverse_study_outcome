package com.bytedance.android.livesdk.gamesticker.layoutstrategy;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContainerViewProxy;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveGameStickerLayoutStrategy {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public IGameStickerContainerViewProxy h;
    public final long i;
    public final LifecycleOwner j;
    public final ILivePlayerClient k;
    public final DataCenter l;

    public final void a(String r4) {
        ALogger.d("LayoutStrategyLive", this.i + " live " + r4);
    }

    public final void b(boolean r3) {
        a("onConfigurationChanged isPortrait:" + r3);
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L8;
        ((LiveUniversalLayoutStrategy) this.g.getValue()).detach();
        ((LiveUniversalLayoutStrategy) this.g.getValue()).e = r3;
        IGameStickerContainerViewProxy r4 = this.h;
        if (r4 == null) goto L40;
        ((LiveUniversalLayoutStrategy) this.g.getValue()).attach(r4);
        return;
    L40:
        return;
    L8:
        if (FoldScreenUtils.f() == false) goto L25;
        ((LiveFoldScreenPortraitGameStickerLayoutStrategy) this.d.getValue()).detach();
        ((LiveFoldScreenLandscapeLayoutStrategy) this.e.getValue()).detach();
        if (r3 == false) goto L15;
        IGameStickerContainerViewProxy r5 = this.h;
        if (r5 == null) goto L34;
        ((LiveFoldScreenPortraitGameStickerLayoutStrategy) this.d.getValue()).attach(r5);
        return;
    L34:
        return;
    L15:
        if (FoldScreenUtils.e() == false) goto L20;
        IGameStickerContainerViewProxy r6 = this.h;
        if (r6 == null) goto L36;
        ((LiveFoldScreenFullLandscapeLayoutStrategy) this.f.getValue()).attach(r6);
        return;
    L36:
        return;
    L20:
        if (FoldScreenUtils.e() == true) goto L38;
        IGameStickerContainerViewProxy r7 = this.h;
        if (r7 == null) goto L39;
        ((LiveFoldScreenLandscapeLayoutStrategy) this.e.getValue()).attach(r7);
        return;
    L39:
        return;
    L38:
        return;
    L25:
        ((h) this.b.getValue()).detach();
        ((e) this.c.getValue()).detach();
        if (r3 == false) goto L30;
        IGameStickerContainerViewProxy r8 = this.h;
        if (r8 == null) goto L42;
        ((h) this.b.getValue()).attach(r8);
        return;
    L42:
        return;
    L30:
        IGameStickerContainerViewProxy r9 = this.h;
        if (r9 == null) goto L44;
        ((e) this.c.getValue()).attach(r9);
        return;
    }

    public LiveGameStickerLayoutStrategy(long r2, LifecycleOwner r4, ILivePlayerClient r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        Intrinsics.checkNotNullParameter(r5, "player");
        this.i = r2;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.a = LazyKt.lazy(LiveGameStickerLayoutStrategy$stickerLayoutOpt$2.INSTANCE);
        this.b = LazyKt.lazy(new LiveGameStickerLayoutStrategy$portraitLayoutStrategy$2(this));
        this.c = LazyKt.lazy(new LiveGameStickerLayoutStrategy$landscapeLayoutStrategy$2(this));
        this.d = LazyKt.lazy(new LiveGameStickerLayoutStrategy$foldScreenLayoutStrategy$2(this));
        this.e = LazyKt.lazy(new LiveGameStickerLayoutStrategy$foldScreenLandscapeLayoutStrategy$2(this));
        this.f = LazyKt.lazy(new LiveGameStickerLayoutStrategy$foldScreenFullLandscapeLayoutStrategy$2(this));
        this.g = LazyKt.lazy(new LiveGameStickerLayoutStrategy$universalLayoutStrategy$2(this));
    }
}
