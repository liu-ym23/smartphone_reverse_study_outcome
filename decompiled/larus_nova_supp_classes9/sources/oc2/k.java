package oc2;

import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.HotCommentFeatureLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends a<f32.e, HotCommentFeatureLevel> {
    public final DegradeFeature f;

    @Override // oc2.a
    public final Enum e() {
        HotCommentFeatureLevel r0 = HotCommentFeatureLevel.LEVEL_DEFAULT;
        if (this.e.b(DegradeScene.ECOM) == DegradeSceneLevel.Ecom.HAPPEN) goto L5;
        return r0;
    L5:
        if (g32.a.a.c() == 2) goto L7;
        return r0;
    L7:
        return HotCommentFeatureLevel.LEVEL_ONE;
    }

    @Override // oc2.a
    public final DegradeFeature d() {
        return this.f;
    }

    @Override // oc2.a
    public final f32.f c(Enum r3) {
        HotCommentFeatureLevel r4 = (HotCommentFeatureLevel) r3;
        Intrinsics.checkNotNullParameter(r4, "level");
        if (j.a[r4.ordinal()] == 1) goto L6;
        return new f32.e(false, 3);
    L6:
        return new f32.e(true, 1);
    }

    public k(HotCommentFeatureLevel r2, com.bytedance.android.livesdk.interactivity.b r3) {
        Intrinsics.checkNotNullParameter(r2, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r3, "statusHolder");
        super(r2, r3);
        this.f = DegradeFeature.HOT_COMMENT_TRAY;
    }
}
