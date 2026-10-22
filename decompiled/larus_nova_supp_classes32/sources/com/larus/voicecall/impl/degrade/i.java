package com.larus.voicecall.impl.degrade;

import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.obric.aivoice.core.data.NameKeys;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public static final Keva a = null;
    public static final ConcurrentHashMap<String, Long> b = null;

    static {
        a = Keva.getRepo("realtime_call_duration");
        b = new ConcurrentHashMap();
    }

    public static void a(String r3) {
        String r0 = "duration_" + r3;
        Keva r1 = a;
        r1.erase(r0);
        r1.erase("last_date_" + r3);
    }

    public static long b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        String r0 = "duration_".concat(r6);
        String r1 = "last_date_".concat(r6);
        String r2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        Keva r3 = a;
        if (Intrinsics.areEqual(r2, r3.getString(r1, NameKeys.UnloadStrategy_No_Strategy)) == true) goto L5;
        a(r6);
        return 0;
    L5:
        return r3.getLong(r0, 0);
    }

    public static long c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        if (z2.a.enableRealtimeCallDowngrade() == true) goto L5;
        return 0;
    L5:
        AppHost.Companion r1 = AppHost.a;
        if (r1.isDebug() == true) goto L8;
    L8:
        Long r4 = b.remove(r10);
        if (r4 == null) goto L26;
        long r5 = r4.longValue();
        long r6 = (System.currentTimeMillis() - r5) / 1000;
        Keva r8 = RealtimeCallDegradeManager.a;
        Intrinsics.checkNotNullParameter(r10, "scene");
        if (RealtimeCallDegradeManager.d(r10) == null) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == true) goto L17;
        a(r10);
        return r6;
    L17:
        Date r2 = new Date(r5);
        String r3 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(r2);
        String r7 = "duration_".concat(r10);
        String r11 = "last_date_".concat(r10);
        Keva r9 = a;
        String r12 = r9.getString(r11, NameKeys.UnloadStrategy_No_Strategy);
        long r13 = r9.getLong(r7, 0);
        if (Intrinsics.areEqual(r3, r12) == false) goto L20;
        long r14 = r13 + r6;
    L22:
        if (r1.isDebug() == true) goto L24;
    L24:
        r9.storeLong(r7, r14);
        r9.storeString(r11, r3);
        return r6;
    L20:
        r14 = r6;
        goto L22
    L13:
        r0 = false;
        goto L14
    L26:
        return 0;
    }
}
