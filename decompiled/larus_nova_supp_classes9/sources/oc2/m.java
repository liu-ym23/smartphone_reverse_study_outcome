package oc2;

import com.bytedance.android.livesdk.config.e30;
import com.bytedance.android.livesdk.config.yh1;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.TapLikeFeatureLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends a<f32.i, TapLikeFeatureLevel> {
    public final DegradeFeature f;

    @Override // oc2.a
    public final Enum e() {
        TapLikeFeatureLevel r0 = TapLikeFeatureLevel.LEVEL_DEFAULT;
        boolean r2 = true;
        if (this.e.a() == false) goto L13;
        if (this.e.b(DegradeScene.ECOM) == DegradeSceneLevel.Ecom.HAPPEN) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L13;
        return TapLikeFeatureLevel.LEVEL_THREE;
    L7:
        if (g32.a.a.d() != 2) goto L9;
        r1 = true;
    L13:
        if (this.e.b(DegradeScene.ECOM) == DegradeSceneLevel.Ecom.HAPPEN) goto L15;
    L17:
        r2 = false;
    L18:
        if (r2 == false) goto L21;
        return TapLikeFeatureLevel.LEVEL_TWO;
    L21:
        if (this.e.a() == false) goto L24;
        return TapLikeFeatureLevel.LEVEL_ONE;
    L24:
        if (this.e.b(DegradeScene.GAME) == DegradeSceneLevel.Game.HAPPEN) goto L26;
        return r0;
    L26:
        return TapLikeFeatureLevel.LEVEL_SMART;
    L15:
        if (g32.a.a.d() != 2) goto L17;
        goto L17
    }

    @Override // oc2.a
    public final DegradeFeature d() {
        return this.f;
    }

    @Override // oc2.a
    public final f32.f c(Enum r19) {
        TapLikeFeatureLevel r0 = (TapLikeFeatureLevel) r19;
        Intrinsics.checkNotNullParameter(r0, "level");
        int r1 = l.a[r0.ordinal()];
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 != 4) goto L16;
        yh1 r2 = (yh1) e30.a.getValue();
        long r3 = r2.f();
        boolean r7 = r2.c();
        boolean r8 = r2.b();
        boolean r6 = r2.d();
        return new f32.i(r3, r2.a(), r2.e(), r6, r7, r8);
    L16:
        return new f32.i(0, false, false, false, false, 63);
    L18:
        return new f32.i(500, true, true, true, true, 8);
    L19:
        return new f32.i(500, true, false, true, true, 12);
    L15:
        return new f32.i(0, false, true, false, false, 59);
    }

    public m(TapLikeFeatureLevel r2, com.bytedance.android.livesdk.interactivity.b r3) {
        Intrinsics.checkNotNullParameter(r2, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r3, "statusHolder");
        super(r2, r3);
        this.f = DegradeFeature.TAP_LIKE;
    }
}
