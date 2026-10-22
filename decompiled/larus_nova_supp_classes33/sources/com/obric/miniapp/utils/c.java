package com.obric.miniapp.utils;

import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static String a;
    public static Boolean b;
    public static final b c = null;
    public static final a d = null;

    public static final class a implements k0.a {
        public a() {
        }

        @Override // com.obric.miniapp.utils.k0.a
        public final void a(boolean r7) {
            FLogger r0 = FLogger.a;
            r0.i("AppletEventCenter", "Device sleeping state changed to: " + r7);
            if (Intrinsics.areEqual(c.b, Boolean.valueOf(r7)) == true) goto L6;
            c.b = Boolean.valueOf(r7);
            Lazy r1 = l3.d.a;
            JsonObject r2 = new JsonObject();
            r2.addProperty("isSleepMode", Boolean.valueOf(r7));
            Unit r3 = Unit.INSTANCE;
            l3.d.c(new l3.a("onSleepChange", r2, 4));
            r0.d("AppletEventCenter", "Device sleeping change event sent: " + r7);
            return;
        }
    }

    public static final class b implements k0.b {
        public b() {
        }

        @Override // com.obric.miniapp.utils.k0.b
        public final void a(String r7) {
            Intrinsics.checkNotNullParameter(r7, "screenMode");
            FLogger r1 = FLogger.a;
            r1.i("AppletEventCenter", "Screen mode changed to: ".concat(r7));
            if (Intrinsics.areEqual(c.a, r7) == true) goto L6;
            c.a = r7;
            Lazy r2 = l3.d.a;
            JsonObject r3 = new JsonObject();
            r3.addProperty("screenMode", r7);
            Unit r0 = Unit.INSTANCE;
            l3.d.c(new l3.a("onScreenModeChange", r3, 4));
            r1.i("AppletEventCenter", "Screen mode change event sent: ".concat(r7));
            return;
        }
    }

    static {
        c = new b();
        d = new a();
    }
}
