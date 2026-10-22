package com.larus.platform.service;

import com.bytedance.applet.aibridge.navigation.g0;
import com.bytedance.applet.impl.r;
import com.larus.platform.api.p1;
import com.larus.platform.model.CoordinateType;
import com.larus.platform.model.LocateScene;
import com.larus.platform.model.LocationResult;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import hq9.z2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m implements p1 {
    public static final m a = null;
    public static final Lazy b = null;

    public m() {
    }

    static {
        a = new m();
        b = LazyKt.lazy(new l());
    }

    public static p1 i() {
        return (p1) b.getValue();
    }

    @Override // com.larus.platform.api.p1
    public final void d(String r3) {
        Intrinsics.checkNotNullParameter("jsb_stop_location", CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        Intrinsics.checkNotNullParameter(r3, "identifier");
        p1 r0 = i();
        if (r0 == null) goto L6;
        r0.d(r3);
        return;
    }

    @Override // com.larus.platform.api.p1
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        p1 r0 = i();
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    @Override // com.larus.platform.api.p1
    public final LocationResult a(CoordinateType r2, r r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "coordinateType");
        Intrinsics.checkNotNullParameter(r4, "identifier");
        p1 r0 = i();
        if (r0 == null) goto L7;
        LocationResult r5 = r0.a(r2, r3, r4);
        if (r5 == null) goto L7;
        return r5;
    L7:
        return LocationResult.NO_IMPL_MODULE;
    }

    @Override // com.larus.platform.api.p1
    public final void b(LocateScene r2, CoordinateType r3, hq9.a3 r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "coordinateType");
        p1 r0 = i();
        if (r0 == null) goto L6;
        r0.b(r2, r3, r4);
        return;
    }

    @Override // com.larus.platform.api.p1
    public final void e(LocateScene r2, CoordinateType r3, Long r4, com.bytedance.applet.aibridge.navi.a r5) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "coordinateType");
        p1 r0 = i();
        if (r0 == null) goto L6;
        r0.e(r2, r3, r4, r5);
        return;
    }

    @Override // com.larus.platform.api.p1
    public final LocationResult g(long r8, CoordinateType r10, JSONObject r11, z2 r12) {
        Intrinsics.checkNotNullParameter(r10, "coordinateType");
        p1 r1 = i();
        if (r1 == null) goto L7;
        LocationResult r9 = r1.g(r8, r10, r11, r12);
        if (r9 == null) goto L7;
        return r9;
    L7:
        return LocationResult.NO_IMPL_MODULE;
    }

    @Override // com.larus.platform.api.p1
    public final LocationResult h(long r9, CoordinateType r11, g0 r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r11, "coordinateType");
        Intrinsics.checkNotNullParameter(r13, "identifier");
        p1 r1 = i();
        if (r1 == null) goto L7;
        LocationResult r10 = r1.h(r9, r11, r12, r13, r14);
        if (r10 == null) goto L7;
        return r10;
    L7:
        return LocationResult.NO_IMPL_MODULE;
    }

    @Override // com.larus.platform.api.p1
    public final void c(LocateScene r12, CoordinateType r13, Integer r14, Long r15, String r16, Long r17, com.bytedance.applet.impl.s0.a r18, Boolean r19, String r20) {
        Intrinsics.checkNotNullParameter(r12, "scene");
        Intrinsics.checkNotNullParameter(r13, "coordinateType");
        p1 r1 = i();
        if (r1 == null) goto L6;
        r1.c(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        return;
    }
}
