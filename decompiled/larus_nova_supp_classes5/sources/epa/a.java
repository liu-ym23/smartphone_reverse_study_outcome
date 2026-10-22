package epa;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static a a;
    public static SharedPreferences b;
    public static SharedPreferences.Editor c;

    public static Map a() {
        return b.getAll();
    }

    public a(Context r3) {
        SharedPreferences r4 = r3.getSharedPreferences("c_tee_d_n_config", 0);
        b = r4;
        c = r4.edit();
    }

    public static a b(Context r1) {
        if (a != null) goto L6;
        a = new a(r1);
    L6:
        return a;
    }

    public static long c(String r3) {
        return b.getLong(r3, 0);
    }

    public static void d(String r1, long r2) {
        c.putLong(r1, r2);
        c.commit();
    }

    public static void e(String r1, String r2) {
        c.putString(r1, r2);
        c.commit();
    }
}
