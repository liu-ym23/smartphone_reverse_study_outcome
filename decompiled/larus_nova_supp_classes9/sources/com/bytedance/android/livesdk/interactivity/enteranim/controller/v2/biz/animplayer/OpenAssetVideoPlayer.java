package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.dress.api.OpenAssetPlayErrorType;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class OpenAssetVideoPlayer extends AnimPlayer<k32.c> {
    public final CompositeDisposable c;
    public final Lazy d;
    public final Lazy e;

    public static final class a implements Action {
        public final /* synthetic */ OpenAssetVideoPlayer a;

        public a(OpenAssetVideoPlayer r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.c.clear();
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public AnimPlayer.PlayerType getType() {
        return AnimPlayer.PlayerType.OpenAssetVideo;
    }

    public OpenAssetVideoPlayer(InteractivityPlatformContext r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "interactivityContext");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, r3);
        CompositeDisposable r4 = new CompositeDisposable();
        this.c = r4;
        this.d = LazyKt.lazy(OpenAssetVideoPlayer$slardar$2.INSTANCE);
        this.e = LazyKt.lazy(OpenAssetVideoPlayer$assetManager$2.INSTANCE);
        RxUtilKt.c(r2.getOnCleared().subscribe(new a(this)), r4);
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public final void b(k32.a r27, Context r28, AnimPlayer.a r29, ViewGroup r30, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r31) {
        k32.c r2 = (k32.c) r27;
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r28, "context");
        Intrinsics.checkNotNullParameter(r29, "animParams");
        Intrinsics.checkNotNullParameter(r30, "parentView");
        Intrinsics.checkNotNullParameter(r31, "animatorPlayerListener");
        ALogger.w("OpenAsset", "start to play");
        com.bytedance.android.live.profit.dress.u r10 = yt0.c.a().getDressData(r2.u, 23, "OpenAsset: playAnim");
        if (r10 != null) goto L5;
        d(r2, 0, OpenAssetPlayErrorType.DressIdNotFound, "dressModel or openAssetConfig is null", r31);
        return;
    L5:
        long r3 = r10.a;
        a5 r0 = r10.d;
        if (r0 != null) goto L8;
        r0 = r2.v;
    L8:
        a5 r15 = r0;
        if (r15 != null) goto L11;
        d(r2, r3, OpenAssetPlayErrorType.SomeIsNull, "both fullText and template is null", r31);
        return;
    L11:
        String r14 = ((IAssetsManager) this.e.getValue()).H0(r3);
        if (r14 != null) goto L14;
        d(r2, r3, OpenAssetPlayErrorType.AssetNotFound, "resource not ready: assetId=" + r3, r31);
        return;
    L14:
        com.bytedance.android.live.profit.player.d r23 = yt0.c.h();
        if (r23 != null) goto L17;
        d(r2, r3, OpenAssetPlayErrorType.SomeIsNull, "player service is null", r31);
        return;
    L17:
        RxUtilKt.c(com.bytedance.android.live.profit.player.e.a.a(r23.Qh(), r28, r14, r15, r2.w, r10.f, r2.c, r10.e, 0, new com.bytedance.android.live.profit.player.o.e((int) r10.b, (int) r10.c), 384).subscribe(new s(this, r2, r3, r31, r23, r29, r30, r28, r10)), this.c);
    }

    public final void d(k32.c r8, long r9, OpenAssetPlayErrorType r11, String r13, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r14) {
        ALogger.e("OpenAsset", r13);
        ((zt0.f) this.d.getValue()).e(r8.u, r9, r11, r13);
        if (r8.t.getAndSet(true) == true) goto L7;
        r8.z.onEnd();
        ((v72.c.a) r14).a();
        return;
    }
}
