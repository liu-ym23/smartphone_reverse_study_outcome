package com.bytedance.android.live.broadcastgame.api.openplatform;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    public final String a;
    public final LiveTracingMonitor.EventType b;
    public final int c;
    public final JSONObject d;
    public final JSONObject e;
    public final JSONObject f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L18;
        g r4 = (g) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        LiveTracingMonitor.EventType r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((r3 + r5) * 31) + this.c) * 31;
        JSONObject r7 = this.d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        JSONObject r11 = this.e;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        JSONObject r14 = this.f;
        if (r14 == null) goto L22;
        r1 = r14.hashCode();
    L22:
        return r13 + r1;
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenPlatformMonitorEvent(service=" + this.a + ", eventType=" + this.b + ", statusCode=" + this.c + ", category=" + this.d + ", metric=" + this.e + ", extra=" + this.f + ")";
    }

    public final void c() {
        ALogger.d("OpenPlatformMonitorV2", "\n Service: " + this.a + " statusCode: " + this.c + " \n Category: " + this.d + " \n Metric: " + this.e + "  \n Extra: " + this.f);
        LiveTracingMonitor.e(this.a, LiveTracingMonitor.EventModule.OPEN_PLATFORM, this.b, this.d, this.e, this.f);
    }

    public final void a(Function1<? super JSONObject, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        r2.invoke(this.d);
    }

    public final void b(Function1<? super JSONObject, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        r2.invoke(this.e);
    }

    public g(String r5, LiveTracingMonitor.EventType r6, int r7) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter(r5, "service");
        Intrinsics.checkNotNullParameter(r6, "eventType");
        Intrinsics.checkNotNullParameter(r0, "category");
        Intrinsics.checkNotNullParameter(r1, "metric");
        Intrinsics.checkNotNullParameter(r2, "extra");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r0;
        this.e = r1;
        this.f = r2;
    }
}
