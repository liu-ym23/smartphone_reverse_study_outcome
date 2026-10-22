package d5;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import x4.j0;

/* JADX INFO: loaded from: classes.dex */
public final class t {
    public static void a(Context r11, x4.s r12, j0 r13) {
        SharedPreferences r14 = k5.a.a(r11, r13);
        SharedPreferences r15 = r12.a(r13);
        boolean r8 = false;
        if (r14.getBoolean("dr_install_migrate", false) == false) goto L5;
        return;
    L5:
        SharedPreferences r16 = r13.b();
        String r10 = r16.getString("device_id", null);
        String r17 = r16.getString("bd_did", null);
        String r18 = r16.getString("install_id", null);
        String r19 = r16.getString("ssid", null);
        SharedPreferences.Editor r110 = r15.edit();
        if (TextUtils.isEmpty(r10) == true) goto L9;
        r110.putString("device_id", r10);
        r8 = true;
    L9:
        if (TextUtils.isEmpty(r17) == true) goto L12;
        r110.putString("bd_did", r17);
        r8 = true;
    L12:
        if (TextUtils.isEmpty(r18) == true) goto L15;
        r110.putString("install_id", r18);
        r8 = true;
    L15:
        if (TextUtils.isEmpty(r19) == true) goto L17;
        r110.putString("ssid", r19);
        r8 = true;
    L17:
        if (r8 == false) goto L19;
        r110.apply();
    L19:
        r14.edit().putBoolean("dr_install_migrate", true).apply();
    }
}
