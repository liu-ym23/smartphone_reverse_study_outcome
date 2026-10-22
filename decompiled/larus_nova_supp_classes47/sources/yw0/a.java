package yw0;

import ay0.c;
import bx0.d;
import com.bytedance.android.live.recharge.utils.e;
import com.bytedance.android.live.recharge.utils.j;
import com.bytedance.android.live.recharge.utils.r;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import jta.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements d {
    public boolean a;

    public a() {
        this.a = true;
    }

    @Override // bx0.d
    public final boolean g() {
        int r0 = c.a();
        int r1 = e.a;
        boolean r2 = false;
        if (r0 == 0) goto L42;
        if (r.b() == true) goto L66;
        HashMap r3 = (HashMap) r.h.getValue(null, r.a[7]);
        Long r4 = (Long) r3.get("show_times");
        if (r4 != null) goto L10;
        r4 = 0L;
    L10:
        long r8 = r4.longValue();
        Long r5 = (Long) r3.get("timestamp");
        if (r5 != null) goto L13;
        r5 = 0L;
    L13:
        long r10 = r5.longValue();
        if (c.a() != 2) goto L22;
        if (r8 >= 1) goto L19;
        a(r8 + 1);
    L63:
        r2 = true;
        goto L66
    L19:
        if ((System.currentTimeMillis() - r10) < 86400000) goto L66;
        a(1);
        goto L63
    L22:
        if (c.a() == 3) goto L24;
        Long r6 = (Long) r3.get("click_exchange");
        if (r6 != null) goto L32;
        r6 = 0L;
    L32:
        long r9 = r6.longValue();
        Long r12 = (Long) r3.get("click_exchange_timestamp");
        if (r12 != null) goto L35;
        r12 = 0L;
    L35:
        long r13 = r12.longValue();
        if (r9 == 0) goto L63;
        if ((System.currentTimeMillis() - r13) < 604800000) goto L66;
        r3.put("click_exchange", 0L);
        r3.put("click_exchange_timestamp", Long.valueOf(System.currentTimeMillis()));
        r.d(r3);
        goto L63
    L24:
        if (r8 >= 3) goto L27;
        a(r8 + 1);
        goto L63
    L27:
        if ((System.currentTimeMillis() - r10) < 604800000) goto L66;
        a(1);
    L66:
        this.a = r2;
        return r2;
    L42:
        if (c.b() == 0) goto L45;
        boolean r7 = r.b();
    L65:
        r2 = !r7;
        goto L66
    L45:
        if (c.c() == 0) goto L47;
        r7 = r.b();
        goto L65
    L47:
        int r14 = j.b();
        if (r14 == 1) goto L64;
        if (r14 == 2) goto L64;
        String r15 = (String) ((Map) r.b.getValue(null, r.a[0])).get(g.d());
        if (r15 == null) goto L63;
        Intrinsics.checkNotNullParameter(r15, "date");
        if (r15.length() != 0) goto L55;
        boolean r16 = true;
    L57:
        if (r16 == false) goto L59;
        Date r17 = null;
    L60:
        if (r17 == null) goto L63;
        SimpleDateFormat r18 = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        Date r19 = r18.parse(r18.format(new Date(System.currentTimeMillis())));
        Calendar r20 = Calendar.getInstance();
        r20.setTime(r17);
        Calendar r22 = Calendar.getInstance();
        r22.setTime(r19);
        if (((r22.getTimeInMillis() - r20.getTimeInMillis()) / ((long) 86400000)) <= ((com.bytedance.android.live.recharge.utils.d) j.b.getValue(null, j.a[0])).a()) goto L66;
    L59:
        r17 = new SimpleDateFormat("yyyy-MM-dd-HH-mm").parse(r15);
        goto L60
    L55:
        r16 = false;
    L64:
        r7 = r.b();
        goto L65
    }

    @Override // bx0.d
    public final boolean c() {
        return this.a;
    }

    public static void a(long r3) {
        HashMap r0 = (HashMap) r.h.getValue(null, r.a[7]);
        r0.put("show_times", Long.valueOf(r3));
        r0.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        r.d(r0);
    }
}
