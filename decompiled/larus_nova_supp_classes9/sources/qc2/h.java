package qc2;

import com.bytedance.android.live.broadcast.api.stable.AnchorStrategy;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.o7;
import com.bytedance.android.livesdk.config.t20;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.HotCommentFeatureLevel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import nz.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends oc2.a<f32.e, HotCommentFeatureLevel> {
    public final DegradeFeature f;
    public final CompositeDisposable g;
    public final pc2.b h;

    @Override // oc2.a
    public final Enum e() {
        HotCommentFeatureLevel r0 = HotCommentFeatureLevel.LEVEL_DEFAULT;
        if (this.e.b(DegradeScene.ECOM) != DegradeSceneLevel.Ecom.HAPPEN) goto L8;
        if (g32.a.a.c() != 2) goto L8;
        r0 = HotCommentFeatureLevel.LEVEL_ONE;
    L8:
        if (this.e.b(DegradeScene.GAME) != DegradeSceneLevel.Game.HAPPEN) goto L11;
        r0 = HotCommentFeatureLevel.LEVEL_SMART;
    L11:
        if (this.e.b(DegradeScene.AUDIENCE_EXP_HOT_COMMENT_TRAY) == DegradeSceneLevel.AudienceExpLevel.Degrade) goto L13;
        return r0;
    L13:
        return HotCommentFeatureLevel.LEVEL_TWO;
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
        l61.d.a.x0 r1 = l61.d.a.x0.e;
        DegradeScene r3 = DegradeScene.AUDIENCE_EXP_HOT_COMMENT_TRAY;
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
        com.bytedance.android.live.broadcast.api.stable.d.a r8 = com.bytedance.android.live.broadcast.api.stable.d.a.a;
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
    public final f32.f c(Enum r4) {
        HotCommentFeatureLevel r5 = (HotCommentFeatureLevel) r4;
        Intrinsics.checkNotNullParameter(r5, "level");
        int r6 = g.a[r5.ordinal()];
        if (r6 == 1) goto L12;
        if (r6 == 2) goto L15;
        if (r6 == 3) goto L14;
        return new f32.e(false, 3);
    L14:
        return new f32.e(((o7) t20.a.getValue()).a(), 1);
    L15:
        return new f32.e(false, 2);
    L12:
        return new f32.e(true, 1);
    }

    public h(HotCommentFeatureLevel r2, com.bytedance.android.livesdk.interactivity.b r3, pc2.a.C0265a r4) {
        Intrinsics.checkNotNullParameter(r2, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r3, "statusHolder");
        Intrinsics.checkNotNullParameter(r4, "degradeRequester");
        super(r2, r3);
        this.h = r4;
        this.f = DegradeFeature.HOT_COMMENT_TRAY;
        this.g = new CompositeDisposable();
    }
}
