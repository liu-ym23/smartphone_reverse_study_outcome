package com.bytedance.android.livesdk.clearscreen;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenLogUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q implements jg1.a {
    public final /* synthetic */ o a;

    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return true;
    }

    public final long d() {
        return 0;
    }

    public final void c() {
        int r0 = k.K;
        ALogger.i("GestureBaseBehavior", "onEnterClearEnd");
        ClearScreenLogUtils.Companion r1 = ClearScreenLogUtils.a;
        DataCenter r2 = this.a.J;
        Map r3 = MapsKt.emptyMap();
        r1.getClass();
        ClearScreenLogUtils.Companion.d(r2, "enlarge", r3);
    }

    public final void f() {
        int r0 = k.K;
        ALogger.i("GestureBaseBehavior", "onExitClearEnd");
        ClearScreenLogUtils.Companion r1 = ClearScreenLogUtils.a;
        DataCenter r2 = this.a.J;
        Map r3 = MapsKt.emptyMap();
        r1.getClass();
        ClearScreenLogUtils.Companion.f(r2, "enlarge", r3);
    }

    public final ClearScreenConst.AnimType g() {
        return ClearScreenConst.AnimType.None;
    }

    public final ClearScreenConst.InteractType getInteractType() {
        return ClearScreenConst.InteractType.ZOOM_MODE_CLEAR;
    }

    public q(o r1) {
        this.a = r1;
    }

    public final boolean e(jg1.b.a r3) {
        Intrinsics.checkNotNullParameter(r3, "param");
        int r4 = k.K;
        ALogger.i("GestureBaseBehavior", "intercept, clearBySlide=" + this.a.g0);
        ALogger.i("GestureBaseBehavior", "IClearAssistant hashcode = " + hashCode());
        return this.a.g0;
    }
}
