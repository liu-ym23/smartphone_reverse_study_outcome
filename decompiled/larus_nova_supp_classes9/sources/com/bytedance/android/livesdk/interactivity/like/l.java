package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.qq;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeDimension;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyMonitor;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l extends BasePerformanceStrategyTask {
    public final h32.a a;
    public final RoomContext b;

    public final boolean onTriggerEnhance(int r1, Map<String, String> r2, IPerformanceStrategyMonitor r3) {
        return false;
    }

    public final boolean a() {
        if (this.b != null) goto L5;
        return false;
    L5:
        if (((Boolean) qq.a.getValue()).booleanValue() == false) goto L18;
        LiveMode r0 = ((Room) this.b.getRoom().getValue()).getStreamType();
        if (((Boolean) this.b.isAnchor().getValue()).booleanValue() == true) goto L10;
        return false;
    L10:
        if (r0 != LiveMode.MEDIA) goto L12;
    L13:
        return true;
    L12:
        if (r0 == LiveMode.VIDEO) goto L13;
        return false;
    L18:
        return false;
    }

    public l(h32.a r1, RoomContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onTriggerOrigin(Map<String, String> r9, IPerformanceStrategyMonitor r10) {
        HashMap r0 = new HashMap();
        r0.put("scene", "digg");
        r10.updatePerformanceNotifyMonitor(r0, 0);
        if (a() == false) goto L7;
        e32.a r2 = new e32.a(DegradeScene.PERFORMANCE_FRAME, DegradeSceneLevel.Default.NONE, DegradeDimension.ROOM);
        Intrinsics.checkNotNullParameter(this, "$this$triggerAnchorDegrade");
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r9, "extraInfo");
        h32.a r3 = this.a;
        if (r3 == null) goto L10;
        r3.a(r2, r9);
    L10:
        r10.updatePerformanceExecuteMonitor(r0, 0);
        return;
    L7:
        e32.a r4 = new e32.a(DegradeScene.PERFORMANCE_FRAME, DegradeSceneLevel.Default.NONE, DegradeDimension.GLOBAL);
        Intrinsics.checkNotNullParameter(this, "$this$triggerDegrade");
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r9, "extraInfo");
        h32.a r5 = this.a;
        if (r5 == null) goto L10;
        r5.a(r4, r9);
        goto L10
    }

    public final boolean onTriggerDegrade(int r6, Map<String, String> r7, IPerformanceStrategyMonitor r8) {
        HashMap r0 = new HashMap();
        r0.put("scene", "digg");
        r8.updatePerformanceNotifyMonitor(r0, r6);
        if (a() == false) goto L5;
    L18:
        r8.updatePerformanceExecuteMonitor(r0, r6);
        return false;
    L5:
        if (r6 != 1) goto L7;
        e32.a r1 = new e32.a(DegradeScene.PERFORMANCE_FRAME, DegradeSceneLevel.PerformanceFrame.LEVEL_ONE, DegradeDimension.GLOBAL);
    L14:
        if (r1 == null) goto L18;
        Intrinsics.checkNotNullParameter(this, "$this$triggerDegrade");
        Intrinsics.checkNotNullParameter(r1, "request");
        Intrinsics.checkNotNullParameter(r7, "extraInfo");
        h32.a r2 = this.a;
        if (r2 == null) goto L18;
        r2.a(r1, r7);
        goto L18
    L7:
        if (r6 != 2) goto L9;
        r1 = new e32.a(DegradeScene.PERFORMANCE_FRAME, DegradeSceneLevel.PerformanceFrame.LEVEL_TWO, DegradeDimension.GLOBAL);
        goto L14
    L9:
        if (r6 == 11) goto L11;
        r1 = null;
        goto L14
    L11:
        r1 = new e32.a(DegradeScene.PERFORMANCE_FRAME, DegradeSceneLevel.PerformanceFrame.LOW_BATTERY, DegradeDimension.GLOBAL);
        goto L14
    }
}
