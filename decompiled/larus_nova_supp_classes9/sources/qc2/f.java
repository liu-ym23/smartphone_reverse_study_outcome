package qc2;

import com.bytedance.android.live.broadcast.api.stable.AnchorStrategy;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.m5;
import com.bytedance.android.livesdk.config.q20;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.FlowLikeFeatureLevel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import nz.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends oc2.a<f32.d, FlowLikeFeatureLevel> {
    public final DegradeFeature f;
    public final CompositeDisposable g;
    public final pc2.b h;

    @Override // oc2.a
    public final Enum e() {
        FlowLikeFeatureLevel r0 = FlowLikeFeatureLevel.LEVEL_DEFAULT;
        DegradeSceneLevel r1 = this.e.b(DegradeScene.PERFORMANCE_FRAME);
        if (this.e.b(DegradeScene.ECOM) != DegradeSceneLevel.Ecom.HAPPEN) goto L8;
        if (g32.a.a.b() != 3) goto L8;
        r0 = FlowLikeFeatureLevel.LEVEL_FIVE;
    L31:
        if (this.e.b(DegradeScene.AUDIENCE_EXP_LIKE_FLOW) == DegradeSceneLevel.AudienceExpLevel.Degrade) goto L33;
        return r0;
    L33:
        return FlowLikeFeatureLevel.LEVEL_FIVE;
    L8:
        if (this.e.a() == false) goto L13;
        if (this.e.b(DegradeScene.LOW_PERFORMANCE_PHONE) != DegradeSceneLevel.LowPerformancePhone.HAPPEN) goto L13;
        r0 = FlowLikeFeatureLevel.LEVEL_FOUR;
    L13:
        if (this.e.b(DegradeScene.LOW_PERFORMANCE_PHONE) != DegradeSceneLevel.LowPerformancePhone.HAPPEN) goto L15;
    L29:
        r0 = FlowLikeFeatureLevel.LEVEL_THREE;
        goto L31
    L15:
        if (r1 == DegradeSceneLevel.PerformanceFrame.ANCHOR_OVERHEAT) goto L29;
        if (r1 != DegradeSceneLevel.PerformanceFrame.LEVEL_TWO) goto L20;
    L28:
        r0 = FlowLikeFeatureLevel.LEVEL_TWO;
        goto L31
    L20:
        if (r1 == DegradeSceneLevel.PerformanceFrame.LOW_BATTERY) goto L28;
        if (r1 != DegradeSceneLevel.PerformanceFrame.LEVEL_ONE) goto L26;
        r0 = FlowLikeFeatureLevel.LEVEL_ONE;
        goto L31
    L26:
        if (this.e.b(DegradeScene.GAME) != DegradeSceneLevel.Game.HAPPEN) goto L31;
        r0 = FlowLikeFeatureLevel.LEVEL_SMART;
        goto L31
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
        l61.d.a.b1 r1 = l61.d.a.b1.e;
        DegradeScene r3 = DegradeScene.AUDIENCE_EXP_LIKE_FLOW;
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
        com.bytedance.android.live.broadcast.api.stable.d.b r8 = com.bytedance.android.live.broadcast.api.stable.d.b.a;
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
    public final f32.f c(Enum r17) {
        FlowLikeFeatureLevel r0 = (FlowLikeFeatureLevel) r17;
        Intrinsics.checkNotNullParameter(r0, "level");
        switch(e.a[r0.ordinal()]) {
            case 1: goto L11;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L5;
            default: goto L12;
        };
    L5:
        m5 r1 = (m5) q20.a.getValue();
        return new f32.d(false, r1.a(), r1.b(), false, 9);
    L12:
        return new f32.d(false, false, 0, false, 15);
    L14:
        return new f32.d(true, false, 0, false, 14);
    L15:
        return new f32.d(false, true, 0, true, 5);
    L16:
        return new f32.d(false, false, 0, true, 7);
    L17:
        return new f32.d(false, true, 1000, false, 9);
    L11:
        return new f32.d(false, true, 500, false, 9);
    }

    public f(FlowLikeFeatureLevel r2, com.bytedance.android.livesdk.interactivity.b r3, pc2.a.C0265a r4) {
        Intrinsics.checkNotNullParameter(r2, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r3, "statusHolder");
        Intrinsics.checkNotNullParameter(r4, "degradeRequester");
        super(r2, r3);
        this.h = r4;
        this.f = DegradeFeature.HOT_COMMENT_TRAY;
        this.g = new CompositeDisposable();
    }
}
