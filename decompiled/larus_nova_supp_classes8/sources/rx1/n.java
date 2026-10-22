package rx1;

import android.content.Intent;
import com.ss.android.ugc.route_monitor.utils.Logger;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n {
    public static String a;
    public static boolean b;

    static {
        a = "91101698";
    }

    @JvmStatic
    public static final void a(Intent r4) {
        if (b == false) goto L13;
        int r0 = com.ss.android.ugc.route_monitor.impl.route_out.control.i.a;
        String r1 = a;
        Logger r2 = Logger.c;
        r4.toString();
        r2.b();
        if (r1.length() != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        r2.e();
    L11:
        b = false;
        a = "";
        return;
    L10:
        r4.putExtra("ug_open_third_app_cert_id", r1);
        goto L11
    L7:
        r3 = false;
        goto L8
    }
}
