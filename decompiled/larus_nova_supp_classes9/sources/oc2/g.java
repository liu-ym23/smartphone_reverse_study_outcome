package oc2;

import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.FlowLikeFeatureLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends a<f32.d, FlowLikeFeatureLevel> {
    public final DegradeFeature f;

    @Override // oc2.a
    public final Enum e() {
        FlowLikeFeatureLevel r0 = FlowLikeFeatureLevel.LEVEL_DEFAULT;
        DegradeSceneLevel r1 = this.e.b(DegradeScene.PERFORMANCE_FRAME);
        if (this.e.b(DegradeScene.ECOM) != DegradeSceneLevel.Ecom.HAPPEN) goto L8;
        if (g32.a.a.b() != 3) goto L8;
        return FlowLikeFeatureLevel.LEVEL_FIVE;
    L8:
        if (this.e.a() == false) goto L13;
        if (this.e.b(DegradeScene.LOW_PERFORMANCE_PHONE) != DegradeSceneLevel.LowPerformancePhone.HAPPEN) goto L13;
        return FlowLikeFeatureLevel.LEVEL_FOUR;
    L13:
        if (this.e.b(DegradeScene.LOW_PERFORMANCE_PHONE) == DegradeSceneLevel.LowPerformancePhone.HAPPEN) goto L27;
        if (r1 == DegradeSceneLevel.PerformanceFrame.ANCHOR_OVERHEAT) goto L27;
        if (r1 == DegradeSceneLevel.PerformanceFrame.LEVEL_TWO) goto L32;
        if (r1 == DegradeSceneLevel.PerformanceFrame.LOW_BATTERY) goto L32;
        if (r1 == DegradeSceneLevel.PerformanceFrame.LEVEL_ONE) goto L31;
        return r0;
    L31:
        return FlowLikeFeatureLevel.LEVEL_ONE;
    L32:
        return FlowLikeFeatureLevel.LEVEL_TWO;
    L27:
        return FlowLikeFeatureLevel.LEVEL_THREE;
    }

    @Override // oc2.a
    public final DegradeFeature d() {
        return this.f;
    }

    @Override // oc2.a
    public final f32.f c(Enum r17) {
        FlowLikeFeatureLevel r0 = (FlowLikeFeatureLevel) r17;
        Intrinsics.checkNotNullParameter(r0, "level");
        int r1 = f.a[r0.ordinal()];
        if (r1 == 1) goto L18;
        if (r1 == 2) goto L23;
        if (r1 == 3) goto L22;
        if (r1 == 4) goto L21;
        if (r1 == 5) goto L20;
        return new f32.d(false, false, 0, false, 15);
    L20:
        return new f32.d(true, false, 0, false, 14);
    L21:
        return new f32.d(false, true, 0, true, 5);
    L22:
        return new f32.d(false, false, 0, true, 7);
    L23:
        return new f32.d(false, true, 1000, false, 9);
    L18:
        return new f32.d(false, true, 500, false, 9);
    }

    public g(FlowLikeFeatureLevel r2, com.bytedance.android.livesdk.interactivity.b r3) {
        Intrinsics.checkNotNullParameter(r2, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r3, "statusHolder");
        super(r2, r3);
        this.f = DegradeFeature.FLOW_LIKE;
    }
}
