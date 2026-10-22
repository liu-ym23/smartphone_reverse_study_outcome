package com.obric.miniapp.alarm;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.y0;
import com.obric.miniapp.view.CalendarMiniAppActivity;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class m0 {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;

    static {
        a = LazyKt.lazy(new g0());
        b = LazyKt.lazy(new h0());
        c = LazyKt.lazy(new i0());
        d = LazyKt.lazy(new j0());
        e = LazyKt.lazy(new k0());
        f = LazyKt.lazy(new l0());
    }

    public static Application b() {
        return AppHost.a.getApplication();
    }

    public static boolean a(a r5) {
        Intrinsics.checkNotNullParameter(r5, "alarm");
        if (r5.k == true) goto L5;
        return false;
    L5:
        String r6 = r5.j.get("alarm_clock_id");
        if (r6 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
    L18:
        return false;
    L14:
        if (Intrinsics.areEqual(r6, "-1") == true) goto L18;
        Bundle r1 = new Bundle();
        r1.putString("alarm_id", r6);
        b().getContentResolver().call("com.obric.clock.alarm", "method_delete", null, r1);
        return true;
    L8:
        if (r6.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    public static boolean d(a r9) {
        Intrinsics.checkNotNullParameter(r9, "alarm");
        if (r9.k == true) goto L5;
        return false;
    L5:
        Object r0 = r9.d.a;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.time.Instant");
        LocalDateTime r1 = LocalDateTime.ofInstant((Instant) r0, ZoneId.systemDefault());
        String r2 = r9.b;
        if (StringsKt.isBlank(r2) == false) goto L8;
        r2 = "";
    L8:
        String r3 = r1.toLocalDate().format((DateTimeFormatter) a.getValue());
        LinkedHashMap r4 = new LinkedHashMap();
        r4.putAll(r9.j);
        r4.put("activity", (String) b.getValue());
        r4.put("date_alarm", r3);
        String r5 = s.c(r4);
        Bundle r6 = new Bundle();
        r6.putInt("hour", r1.getHour());
        r6.putInt("minute", r1.getMinute());
        r6.putString("date", r3);
        r6.putString("label", r2);
        r6.putString("extra", r5);
        Long r7 = null;
        Bundle r8 = b().getContentResolver().call("com.obric.clock.alarm", "method_set", null, r6);
        if (r8 == null) goto L11;
        r7 = Long.valueOf(r8.getLong("alarm_id", -1));
    L11:
        if (r7 != null) goto L14;
    L16:
        r4.put("alarm_clock_id", String.valueOf(r7));
        Map<String, String> r10 = r9.j;
        r10.clear();
        r10.putAll(r4);
        return true;
    L14:
        if (r7.longValue() != (-1)) goto L16;
        return false;
    }

    public static PendingIntent c(a r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intent r0 = new Intent(r4, CalendarMiniAppActivity.class);
        r0.setData(y0.j("com.flow.calendar"));
        r0.putExtra("appletId", "com.flow.calendar");
        Iterator<Map.Entry<String, String>> r5 = r3.j.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        Map.Entry<String, String> r1 = r5.next();
        r0.putExtra(r1.getKey(), r1.getValue());
        goto L4
    L7:
        return PendingIntent.getActivity(r4, (int) System.currentTimeMillis(), r0, ((Number) f.getValue()).intValue());
    }
}
