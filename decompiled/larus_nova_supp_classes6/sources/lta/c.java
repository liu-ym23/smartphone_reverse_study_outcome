package lta;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c {
    public static boolean a;
    public static final a b = null;

    public static class a extends pta.e<SharedPreferences> {
        public a() {
        }

        @Override // pta.e
        public final SharedPreferences a(Object[] r3) {
            return ((Context) r3[0]).getSharedPreferences("ug_install_settings_pref", 0);
        }
    }

    static {
        b = new a();
    }
}
