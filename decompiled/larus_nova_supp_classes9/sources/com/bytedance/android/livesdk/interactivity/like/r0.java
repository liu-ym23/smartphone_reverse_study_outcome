package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeDimension;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r0<T> implements Observer {
    public final /* synthetic */ DiggWidget a;

    public r0(DiggWidget r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel$PlatformTapLikeDegradeLevel[]] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel$Default] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel$PlatformTapLikeDegradeLevel] */
    public final void onChanged(Object r7) {
        Integer r8 = (Integer) r7;
        if (r8.intValue() > this.a.L0.tapLikeDegradeFactorMaxValue) goto L25;
        DegradeSceneLevel.PlatformTapLikeDegradeLevel.a r0 = DegradeSceneLevel.PlatformTapLikeDegradeLevel.Companion;
        int r9 = r8.intValue();
        r0.getClass();
        ?? r1 = DegradeSceneLevel.PlatformTapLikeDegradeLevel.values();
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L14;
        ?? r4 = r1[r3];
        if (r4.getLevel() != r9) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == true) goto L15;
        r3 = r3 + 1;
    L15:
        if (r4 != 0) goto L18;
        r4 = DegradeSceneLevel.Default.NONE;
    L18:
        h32.a r10 = this.a.M;
        if (r10 == null) goto L24;
        r10.a(new e32.a(DegradeScene.STRATEGY_PLATFORM_TAP_LIKE_DEGRADE, r4, DegradeDimension.ROOM), MapsKt.emptyMap());
        return;
    L24:
        return;
    L10:
        r5 = false;
        goto L11
    L14:
        r4 = 0;
        goto L15
    }
}
