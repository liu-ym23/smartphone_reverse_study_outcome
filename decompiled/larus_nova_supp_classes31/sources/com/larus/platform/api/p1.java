package com.larus.platform.api;

import com.bytedance.applet.aibridge.navigation.g0;
import com.bytedance.applet.impl.r;
import com.larus.platform.model.CoordinateType;
import com.larus.platform.model.LocateScene;
import com.larus.platform.model.LocationResult;
import hq9.a3;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface p1 {
    LocationResult a(CoordinateType r1, r r2, String r3);

    void b(LocateScene r1, CoordinateType r2, a3 r3);

    void c(LocateScene r1, CoordinateType r2, Integer r3, Long r4, String r5, Long r6, com.bytedance.applet.impl.s0.a r7, Boolean r8, String r9);

    void d(String r1);

    void e(LocateScene r1, CoordinateType r2, Long r3, com.bytedance.applet.aibridge.navi.a r4);

    void f(String r1);

    LocationResult g(long r1, CoordinateType r3, JSONObject r4, hq9.z2 r5);

    LocationResult h(long r1, CoordinateType r3, g0 r4, String r5, String r6);
}
