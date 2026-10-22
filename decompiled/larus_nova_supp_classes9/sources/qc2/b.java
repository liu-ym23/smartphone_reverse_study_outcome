package qc2;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.CommentCarnivalFeatureLevel;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends oc2.a<f32.a, CommentCarnivalFeatureLevel> {
    public final DegradeFeature f;
    public final CompositeDisposable g;
    public final pc2.b h;

    @Override // oc2.a
    public final Enum e() {
        CommentCarnivalFeatureLevel r0 = CommentCarnivalFeatureLevel.LEVEL_DEFAULT;
        if (this.e.b(DegradeScene.AUDIENCE_EXP_COMMENT_CARNIVAL) == DegradeSceneLevel.AudienceExpLevel.Degrade) goto L5;
        return r0;
    L5:
        return CommentCarnivalFeatureLevel.LEVEL_ONE;
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
        l61.d.a.a r1 = l61.d.a.a.e;
        RxUtilKt.c(r0.registerExpBizListener(r1, new rc2.a(DegradeScene.AUDIENCE_EXP_COMMENT_CARNIVAL, r1, this.h)), this.g);
    }

    @Override // oc2.a
    public final DegradeFeature d() {
        return this.f;
    }

    @Override // oc2.a
    public final f32.f c(Enum r2) {
        CommentCarnivalFeatureLevel r3 = (CommentCarnivalFeatureLevel) r2;
        Intrinsics.checkNotNullParameter(r3, "level");
        if (a.a[r3.ordinal()] == 1) goto L6;
        return new f32.a(true);
    L6:
        return new f32.a(false);
    }

    public b(CommentCarnivalFeatureLevel r2, com.bytedance.android.livesdk.interactivity.b r3, pc2.a.C0265a r4) {
        Intrinsics.checkNotNullParameter(r2, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r3, "statusHolder");
        Intrinsics.checkNotNullParameter(r4, "degradeRequester");
        super(r2, r3);
        this.h = r4;
        this.f = DegradeFeature.COMMENT_CARNIVAL;
        this.g = new CompositeDisposable();
    }
}
