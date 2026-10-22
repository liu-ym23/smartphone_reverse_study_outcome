package qc2;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.livesdk.config.n20;
import com.bytedance.android.livesdk.config.o4;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.EnterAnimFeatureLevel;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends oc2.a<f32.b, EnterAnimFeatureLevel> {
    public final DegradeFeature f;
    public final CompositeDisposable g;
    public final pc2.b h;

    @Override // oc2.a
    public final Enum e() {
        EnterAnimFeatureLevel r0 = EnterAnimFeatureLevel.LEVEL_DEFAULT;
        if (this.e.b(DegradeScene.ECOM) != DegradeSceneLevel.Ecom.HAPPEN) goto L8;
        if (g32.a.a.e() != 3) goto L8;
        r0 = EnterAnimFeatureLevel.LEVEL_ONE;
    L8:
        if (this.e.b(DegradeScene.GAME) != DegradeSceneLevel.Game.HAPPEN) goto L10;
        r0 = EnterAnimFeatureLevel.LEVEL_SMART;
    L10:
        DegradeSceneLevel r1 = this.e.b(DegradeScene.AUDIENCE_EXP_HIGH_LEVEL_ECOM_ANIM);
        DegradeSceneLevel.AudienceExpLevel r2 = DegradeSceneLevel.AudienceExpLevel.Degrade;
        if (r1 != r2) goto L14;
        r0 = EnterAnimFeatureLevel.LEVEL_ONE;
    L14:
        if (this.e.b(DegradeScene.AUDIENCE_EXP_HIGH_LEVEL_ENTER_ANIM) != r2) goto L17;
        r0 = EnterAnimFeatureLevel.LEVEL_TWO;
    L17:
        if (this.e.b(DegradeScene.AUDIENCE_EXP_DISABLE_HIGH_LEVEL_ENTER) == r2) goto L19;
        return r0;
    L19:
        return EnterAnimFeatureLevel.LEVEL_THREE;
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
        l61.d.a.u0 r1 = l61.d.a.u0.e;
        RxUtilKt.c(r0.registerExpBizListener(l61.e.a(r1), new rc2.a(DegradeScene.AUDIENCE_EXP_HIGH_LEVEL_ECOM_ANIM, l61.e.a(r1), this.h)), this.g);
        ILiveExpOptService r2 = jc1.k.n(ILiveExpOptService.class);
        l61.d.a.w0 r3 = l61.d.a.w0.e;
        RxUtilKt.c(r2.registerExpBizListener(r3, new rc2.a(DegradeScene.AUDIENCE_EXP_HIGH_LEVEL_ENTER_ANIM, r3, this.h)), this.g);
        ILiveExpOptService r4 = jc1.k.n(ILiveExpOptService.class);
        l61.d.a.y r5 = l61.d.a.y.e;
        RxUtilKt.c(r4.registerExpBizListener(r5, new rc2.a(DegradeScene.AUDIENCE_EXP_DISABLE_HIGH_LEVEL_ENTER, r5, this.h)), this.g);
    }

    @Override // oc2.a
    public final DegradeFeature d() {
        return this.f;
    }

    @Override // oc2.a
    public final f32.f c(Enum r17) {
        EnterAnimFeatureLevel r0 = (EnterAnimFeatureLevel) r17;
        Intrinsics.checkNotNullParameter(r0, "level");
        int r1 = c.a[r0.ordinal()];
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return new f32.b(false, false, false, false, false, 31);
    L17:
        return new f32.b(false, false, false, false, ((o4) n20.a.getValue()).a(), 15);
    L18:
        return new f32.b(true, true, true, true, false, 16);
    L19:
        return new f32.b(true, true, false, false, false, 28);
    L15:
        return new f32.b(true, false, false, false, false, 30);
    }

    public d(EnterAnimFeatureLevel r2, com.bytedance.android.livesdk.interactivity.b r3, pc2.a.C0265a r4) {
        Intrinsics.checkNotNullParameter(r2, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r3, "statusHolder");
        Intrinsics.checkNotNullParameter(r4, "degradeRequester");
        super(r2, r3);
        this.h = r4;
        this.f = DegradeFeature.ENTER_ANIM;
        this.g = new CompositeDisposable();
    }
}
