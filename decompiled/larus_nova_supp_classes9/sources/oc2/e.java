package oc2;

import com.bytedance.android.livesdk.config.o20;
import com.bytedance.android.livesdk.config.p4;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.EnterRoomDurationFeatureLevel;
import kotlin.jvm.internal.Intrinsics;
import r52.l0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends a<f32.c, EnterRoomDurationFeatureLevel> {
    public final long f;
    public final DegradeFeature g;

    @Override // oc2.a
    public final Enum e() {
        EnterRoomDurationFeatureLevel r0 = EnterRoomDurationFeatureLevel.OutEnterRoomDuration;
        com.bytedance.android.livesdk.interactivity.b r1 = this.e;
        DegradeScene r2 = DegradeScene.ENTER_ROOM_DURATION;
        DegradeSceneLevel r3 = r1.b(r2);
        DegradeSceneLevel.EnterRoomDuration r4 = DegradeSceneLevel.EnterRoomDuration.InEnterRoomDuration;
        if (r3 != r4) goto L6;
        r0 = EnterRoomDurationFeatureLevel.InEnterRoomDuration;
    L6:
        if (this.e.b(DegradeScene.GAME) == DegradeSceneLevel.Game.HAPPEN) goto L8;
        return r0;
    L8:
        if (this.e.b(r2) == r4) goto L10;
        return r0;
    L10:
        return EnterRoomDurationFeatureLevel.LEVEL_SMART;
    }

    @Override // oc2.a
    public final DegradeFeature d() {
        return this.g;
    }

    @Override // oc2.a
    public final f32.f c(Enum r7) {
        EnterRoomDurationFeatureLevel r8 = (EnterRoomDurationFeatureLevel) r7;
        Intrinsics.checkNotNullParameter(r8, "level");
        int r9 = d.a[r8.ordinal()];
        if (r9 == 1) goto L14;
        if (r9 != 2) goto L15;
        p4 r10 = (p4) o20.a.getValue();
        if (r10.b() == false) goto L17;
        if (r10.c() <= 0) goto L17;
        return new f32.c(r10.c());
    L17:
        return new f32.c(0);
    L15:
        return new f32.c(0);
    L14:
        return new f32.c(this.f);
    }

    public e(EnterRoomDurationFeatureLevel r2, com.bytedance.android.livesdk.interactivity.b r3) {
        Intrinsics.checkNotNullParameter(r2, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r3, "statusHolder");
        super(r2, r3);
        int r4 = com.bytedance.android.livesdk.interactivity.api.settings.config.h.a;
        this.f = ((com.bytedance.android.livesdk.interactivity.api.settings.config.h) l0.a.getValue()).c();
        this.g = DegradeFeature.ENTER_ROOM_DURATION;
    }
}
