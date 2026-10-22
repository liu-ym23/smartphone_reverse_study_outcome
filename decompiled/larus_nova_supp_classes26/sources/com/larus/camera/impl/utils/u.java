package com.larus.camera.impl.utils;

import android.util.Pair;
import com.bytedance.common.utility.NetworkClient;
import com.larus.platform.api.b2;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u {
    public static boolean a;
    public static final a b = null;

    public static final class a implements nx8.k {
        public a() {
        }

        @Override // nx8.k
        public final void d(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            FLogger.a.d(r2, r3);
        }

        @Override // nx8.k
        public final void i(String r2, String r3) {
            Intrinsics.checkNotNullParameter("EduCamera", "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            FLogger.a.i("EduCamera", r3);
        }

        @Override // nx8.k
        public final void e(String r2, String r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            FLogger.a.e(r2, r3, r4);
        }
    }

    public static final class b implements nx8.a {
        public b() {
        }

        @Override // nx8.a
        public final void a(String r3, JSONObject r4, JSONObject r5) {
            Intrinsics.checkNotNullParameter(r3, "serviceName");
            Intrinsics.checkNotNullParameter(r4, "category");
            Intrinsics.checkNotNullParameter(r5, "metric");
            com.larus.platform.service.g.a.monitorEventForSlardar(r3, r4, r5, null);
        }
    }

    public static final class c extends NetworkClient {
        public final String get(String r1, Map<String, String> r2, NetworkClient.ReqContext r3) {
            return "";
        }

        public final String post(String r1, List<Pair<String, String>> r2, Map<String, String> r3, NetworkClient.ReqContext r4) {
            return "";
        }

        public final String post(String r1, byte[] r2, Map<String, String> r3, NetworkClient.ReqContext r4) {
            return "";
        }

        public c() {
        }
    }

    static {
        b = new a();
    }

    public static void a() {
        if (a == true) goto L27;
        a = true;
        b r0 = new b();
        if (k.a() == false) goto L7;
        c r1 = new c();
    L8:
        String r3 = b2.a.l();
        Intrinsics.checkNotNullParameter(r3, "apiHost");
        Intrinsics.checkNotNullParameter(r0, "apmMonitor");
        a r4 = b;
        Intrinsics.checkNotNullParameter(r4, "logger");
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(r1, "client");
    L12:
        com.larus.camera.impl.edulibs.camera.a r5 = com.larus.camera.impl.edulibs.camera.a.a;
        nx8.e r6 = new nx8.e(r3, r1, r4, r0);
        Intrinsics.checkNotNullParameter(r6, "config");
        String r2 = r6.a;
        if (StringsKt.startsWith$default(r2, "https://", false, 2, null) == false) goto L15;
        com.larus.camera.impl.edulibs.camera.internal.util.c.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        com.larus.camera.impl.edulibs.camera.internal.util.c.b = r2;
    L16:
        nx8.k r7 = r6.c;
        if (r7 == null) goto L19;
        com.larus.camera.impl.edulibs.camera.a.c = new com.larus.camera.impl.edulibs.camera.a.b(r7);
    L19:
        NetworkClient r8 = r6.b;
        if (r8 == null) goto L22;
        com.larus.camera.impl.edulibs.camera.internal.util.c.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "networkClient");
        com.larus.camera.impl.edulibs.camera.internal.util.c.d = r8;
    L22:
        nx8.a r9 = r6.d;
        if (r9 == null) goto L25;
        com.larus.camera.impl.edulibs.camera.a.d = r9;
    L25:
        oq9.h r10 = z2.a.getEduCameraConfig();
        nx8.d r11 = new nx8.d(r10.o(), r10.q(), 1, r10.s());
        Intrinsics.checkNotNullParameter(r11, "config");
        com.larus.camera.impl.edulibs.camera.a.b.update(r11);
        return;
    L15:
        String r12 = "https://" + r2;
        com.larus.camera.impl.edulibs.camera.internal.util.c.a.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        com.larus.camera.impl.edulibs.camera.internal.util.c.b = r12;
        goto L16
    L11:
        r1 = null;
        goto L12
    L7:
        r1 = null;
        goto L8
    }
}
