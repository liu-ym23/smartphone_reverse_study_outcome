package com.bytedance.android.livesdk.interactivity;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeDimension;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import java.util.EnumMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final Map<DegradeScene, DegradeSceneLevel> b = null;
    public final Map<DegradeScene, DegradeSceneLevel> a;

    public static final class a {
    }

    static {
        b = new EnumMap(DegradeScene.class);
    }

    public final boolean a() {
        DegradeSceneLevel r0 = b(DegradeScene.PERFORMANCE_FRAME);
        if (r0 != DegradeSceneLevel.Default.NONE) goto L5;
    L7:
        return false;
    L5:
        if (r0 == DegradeSceneLevel.PerformanceFrame.ANCHOR_OVERHEAT) goto L7;
        return true;
    }

    public b() {
        this.a = new EnumMap(DegradeScene.class);
    }

    public final DegradeSceneLevel b(DegradeScene r2) {
        Intrinsics.checkNotNullParameter(r2, "degradeScene");
        DegradeSceneLevel r0 = (DegradeSceneLevel) ((EnumMap) this.a).get(r2);
        if (r0 != null) goto L5;
        r0 = (DegradeSceneLevel) ((EnumMap) b).get(r2);
    L5:
        if (r0 == null) goto L7;
        return r0;
    L7:
        return DegradeSceneLevel.Default.NONE;
    }

    public final void c(e32.a r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        if (r5.c != DegradeDimension.GLOBAL) goto L5;
        Map<DegradeScene, DegradeSceneLevel> r0 = b;
    L6:
        DegradeSceneLevel r1 = r0.get(r5.a);
        if (r1 != null) goto L9;
        r1 = DegradeSceneLevel.Default.NONE;
    L9:
        DegradeSceneLevel r2 = r5.b;
        if (r2 != DegradeSceneLevel.Default.NONE) goto L12;
        r0.remove(r5.a);
    L13:
        int r3 = g32.c.a;
        Intrinsics.checkNotNullParameter(r5, "degradeRequest");
        Intrinsics.checkNotNullParameter(r1, "oldLevel");
        ALogger.i("InteractivityDegradeLogger", "degrade status update. type: " + r5.a.name() + ", old level: " + r1.logName() + ", new level: " + r5.b.logName() + ", dimension: " + r5.c.name());
        return;
    L12:
        r0.put(r5.a, r2);
        goto L13
    L5:
        r0 = this.a;
        goto L6
    }
}
