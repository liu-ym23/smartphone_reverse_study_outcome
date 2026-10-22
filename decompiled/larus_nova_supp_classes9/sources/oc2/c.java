package oc2;

import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.EnterAnimFeatureLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends a<f32.b, EnterAnimFeatureLevel> {
    public final DegradeFeature f;

    @Override // oc2.a
    public final Enum e() {
        EnterAnimFeatureLevel r0 = EnterAnimFeatureLevel.LEVEL_DEFAULT;
        if (this.e.b(DegradeScene.ECOM) == DegradeSceneLevel.Ecom.HAPPEN) goto L5;
        return r0;
    L5:
        if (g32.a.a.e() == 3) goto L7;
        return r0;
    L7:
        return EnterAnimFeatureLevel.LEVEL_ONE;
    }

    @Override // oc2.a
    public final DegradeFeature d() {
        return this.f;
    }

    @Override // oc2.a
    public final f32.f c(Enum r17) {
        EnterAnimFeatureLevel r0 = (EnterAnimFeatureLevel) r17;
        Intrinsics.checkNotNullParameter(r0, "level");
        if (b.a[r0.ordinal()] == 1) goto L6;
        return new f32.b(false, false, false, false, false, 31);
    L6:
        return new f32.b(true, false, false, false, false, 30);
    }

    public c(EnterAnimFeatureLevel r2, com.bytedance.android.livesdk.interactivity.b r3) {
        Intrinsics.checkNotNullParameter(r2, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r3, "statusHolder");
        super(r2, r3);
        this.f = DegradeFeature.ENTER_ANIM;
    }
}
