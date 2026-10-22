package com.larus.avlink.record.util;

import com.larus.common.apphost.AppHost;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r {
    public static final Calendar a = null;
    public static final Calendar b = null;
    public static final SimpleDateFormat c = null;
    public static final SimpleDateFormat d = null;
    public static final SimpleDateFormat e = null;

    static {
        a = Calendar.getInstance();
        b = Calendar.getInstance();
        c = new SimpleDateFormat("H:mm", Locale.getDefault());
        StringBuilder r1 = new StringBuilder("M");
        AppHost.Companion r2 = AppHost.a;
        r1.append(r2.getApplication().getString(2131907418));
        r1.append('d');
        r1.append(r2.getApplication().getString(2131907415));
        r1.append(" H:mm");
        d = new SimpleDateFormat(r1.toString(), Locale.getDefault());
        e = new SimpleDateFormat("yyyy" + r2.getApplication().getString(2131907424) + 'M' + r2.getApplication().getString(2131907418) + 'd' + r2.getApplication().getString(2131907415) + " H:mm", Locale.getDefault());
    }

    public static boolean a() {
        Calendar r0 = a;
        int r2 = r0.get(0);
        Calendar r3 = b;
        if (r2 == r3.get(0)) goto L5;
        return false;
    L5:
        if (r0.get(1) == r3.get(1)) goto L7;
        return false;
    L7:
        if (r0.get(6) != r3.get(6)) goto L12;
        return true;
    L12:
        return false;
    }
}
