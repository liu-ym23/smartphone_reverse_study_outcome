package jw0;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.utils.j;
import com.bytedance.android.livesdk.utils.r1;
import com.bytedance.android.livesdk.utils.u6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static u6 a() {
        String r0 = (String) j.f.getValue(null, j.a[4]);
        u6 r1 = new u6(r0);
        String r3 = r1.a("url");
        if (r3 == null) goto L14;
        u6 r2 = new u6(r3);
        boolean r4 = vh6.c.b(wh6.a.class).Wb();
        String r5 = DataType.TRUE;
        if (r4 == false) goto L7;
        String r6 = DataType.TRUE;
    L8:
        r2.b("new_exchange_type", r6);
        if (vh6.c.b(wh6.a.class).wn() == true) goto L12;
        r5 = DataType.FALSE;
    L12:
        r2.b("show_authorize", r5);
        r2.b("app_name", vh6.c.b(wh6.a.class).getAppName());
        r2.b("exchange_authority_content", vh6.c.b(wh6.a.class).o8());
        r1.b("url", r2.toString());
        r0 = r1.toString();
        goto L14
    L7:
        r6 = DataType.FALSE;
    L14:
        return new u6(r0);
    }

    static {
    }

    public static String b(int r2) {
        if (r2 != 0) goto L5;
        return String.valueOf(r2);
    L5:
        return r1.b("%.2f", new Object[]{Float.valueOf(r2 / 100.0f)});
    }
}
