package k5;

import android.content.Context;
import android.content.SharedPreferences;
import x4.j0;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0106a f8930a = null;

    /* JADX INFO: renamed from: k5.a$a, reason: collision with other inner class name */
    public static class C0106a extends l<SharedPreferences> {
        @Override // k5.l
        public final SharedPreferences a(Object[] r8) {
            return ((Context) r8[0]).getSharedPreferences("ug_install_settings_pref", 0);
        }
    }

    static {
        f8930a = new C0106a();
    }

    public static SharedPreferences a(Context r8, j0 r10) {
        C0106a r11 = f8930a;
        if (r10 == null) goto L10;
        if (r10.J == false) goto L8;
        return r11.b(new Object[]{r8});
    L8:
        return r8.getSharedPreferences("ug_install_settings_pref_" + String.valueOf(r10.f13463a), 0);
    L10:
        return r11.b(new Object[]{r8});
    }

    public static String b(x4.b r8, String r10) {
        if (r8.f13380m == false) goto L6;
        r10 = defpackage.a.e(r10, "_i18n");
    L6:
        if (r8.f13381n == false) goto L9;
        r10 = defpackage.a.e(r10, "_boe");
    L9:
        if (r8.f13378a == true) goto L11;
        return r10;
    L11:
        return defpackage.a.e(r10, "_cm");
    }
}
