package qc2;

import com.bytedance.android.live.broadcast.api.stable.AnchorStrategy;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.PortraitDanmakuFeatureLevel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import nz.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends oc2.a<f32.g, PortraitDanmakuFeatureLevel> {
    public final DegradeFeature f;
    public final CompositeDisposable g;
    public final pc2.b h;

    @Override // oc2.a
    public final Enum e() {
        PortraitDanmakuFeatureLevel r0 = PortraitDanmakuFeatureLevel.LEVEL_DEFAULT;
        if (this.e.b(DegradeScene.AUDIENCE_EXP_PORTRAIT_DANMAKU) == DegradeSceneLevel.AudienceExpLevel.Degrade) goto L5;
        return r0;
    L5:
        return PortraitDanmakuFeatureLevel.LEVEL_ONE;
    }

    @Override // oc2.a
    public final void g() {
        super.g();
        this.g.clear();
    }

    @Override // oc2.a
    public final void h() {
        super.h();
        ILiveExpOptService r0 = jc1.k.n(ILiveExpOptService.class);
        l61.d.a.e1 r1 = l61.d.a.e1.e;
        DegradeScene r3 = DegradeScene.AUDIENCE_EXP_PORTRAIT_DANMAKU;
        RxUtilKt.c(r0.registerExpBizListener(r1, new rc2.a(r3, r1, this.h)), this.g);
        if (com.bytedance.android.livesdk.config.setting.b.a() == false) goto L14;
        rc2.a r2 = new rc2.a(r3, r1, this.h);
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r4 == null) goto L15;
        com.bytedance.live.datacontext.j r5 = r4.getAnchorStableViewModel();
        if (r5 == null) goto L16;
        n r6 = (n) r5.getValue();
        if (r6 == null) goto L17;
        AnchorStrategy r7 = AnchorStrategy.StableMode;
        com.bytedance.android.live.broadcast.api.stable.d.c r8 = com.bytedance.android.live.broadcast.api.stable.d.c.a;
        Intrinsics.checkNotNullParameter(r2, "wrapper");
        Intrinsics.checkNotNullParameter(r8, "type");
        Disposable r9 = r6.b();
        if (r9 == null) goto L18;
        RxUtilKt.c(r9, this.g);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // oc2.a
    public final DegradeFeature d() {
        return this.f;
    }

    @Override // oc2.a
    public final f32.f c(Enum r3) {
        PortraitDanmakuFeatureLevel r4 = (PortraitDanmakuFeatureLevel) r3;
        Intrinsics.checkNotNullParameter(r4, "level");
        if (i.a[r4.ordinal()] == 1) goto L6;
        return new f32.g(true, true, true);
    L6:
        return new f32.g(true, true, false);
    }

    public j(PortraitDanmakuFeatureLevel r2, com.bytedance.android.livesdk.interactivity.b r3, pc2.a.C0265a r4) {
        Intrinsics.checkNotNullParameter(r2, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r3, "statusHolder");
        Intrinsics.checkNotNullParameter(r4, "degradeRequester");
        super(r2, r3);
        this.h = r4;
        this.f = DegradeFeature.PORARAIT_DANMAKU;
        this.g = new CompositeDisposable();
    }
}
