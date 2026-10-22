package j5;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public final class d extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile String f8654i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile String[] f8655j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile String f8656k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile JSONArray f8657l;

    @Override // j5.a, i5.a
    public final String b() {
        if (TextUtils.isEmpty(this.f8644f) == false) goto L5;
        SharedPreferences r8 = k5.a.a(this.f8639a, this.f8640b.f8687h);     // Catch: Exception -> L23
        String r10 = null;
        String r11 = r8.getString("clientudid", null);     // Catch: Exception -> L23
        boolean r12 = x0.g(r11);     // Catch: Exception -> L23
        c r13 = this.f8642d;
        if (r12 == true) goto L16;
        r11 = UUID.randomUUID().toString();     // Catch: Exception -> L23
        if (r13 == null) goto L13;
        r10 = (String) r13.g(null, r11, new f(r13));     // Catch: Exception -> L23
    L13:
        if (x0.g(r10) == false) goto L15;
        r11 = r10;
    L15:
        SharedPreferences.Editor r14 = r8.edit();     // Catch: Exception -> L23
        r14.putString("clientudid", r11);     // Catch: Exception -> L23
        r14.apply();     // Catch: Exception -> L23
    L19:
        if (TextUtils.isEmpty(r11) == true) goto L21;
        r11 = r11 + this.f8646h;     // Catch: Exception -> L23
    L21:
        this.f8644f = r11;     // Catch: Exception -> L23
        return r11;
    L16:
        if (r13 == null) goto L19;
        String r15 = (String) r13.g(r11, null, new f(r13));     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
        return "";
    L5:
        return this.f8644f;
    }

    @Override // i5.a
    public final void c() {
        List<String> r8 = Arrays.asList(new String[]{"openudid", "clientudid", "serial_number", "sim_serial_number", "udid", "device_id", "install_id"});
        this.f8641c.e(r8);
    }

    @Override // j5.a
    public final void d(o r21, c r22) {
        String r8 = this.f8646h;
        String r10 = "ZQLiNFJR+CWEI4px" + t2.b.x();
        String r11 = new String(new char[]{r10.charAt(1), r10.charAt(3), r10.charAt(1), r10.charAt(11), r10.charAt(15), r10.charAt(10), r10.charAt(8), r10.charAt(17), r10.charAt(9), r10.charAt(9), r10.charAt(12), r10.charAt(13), r10.charAt(13), r10.charAt(5), r10.charAt(18), r10.charAt(13), r10.charAt(14), r10.charAt(11), r10.charAt(4), r10.charAt(19), r10.charAt(7)}).substring(2, 18);
        boolean r12 = !r21.f8683d;
        e r13 = new l(r12, Environment.getExternalStorageDirectory().getPath() + t2.b.j("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U=") + r8, r21.f8680a, r11, r21.f8687h.a());     // Catch: Exception -> L9
        c r14 = r22;
        r14.f8658a = r13;     // Catch: Exception -> L7
    L17:
        r13.f8658a = new l(r12, Environment.getExternalStorageDirectory().getPath() + "/" + t2.b.x() + r8, r21.f8680a, r11, r21.f8687h.a());     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = e;
    L11:
        e.printStackTrace();
        r13 = r14;
    L9:
        e = e;
        r14 = r22;
        goto L11
    }

    @Override // j5.a, i5.a
    public final String getOpenUdid() {
        if (TextUtils.isEmpty(this.f8643e) == false) goto L5;
        Context r8 = this.f8639a;
        String r10 = null;
        String r11 = Settings.Secure.getString(r8.getContentResolver(), "android_id");     // Catch: Exception -> L9
    L11:
        SharedPreferences r12 = k5.a.a(r8, this.f8640b.f8687h);
        String r13 = r12.getString("openudid", null);
        if (x0.g(r11) == true) goto L15;
    L23:
        boolean r14 = x0.g(r13);     // Catch: Exception -> L51
        c r15 = this.f8642d;
        if (r14 == true) goto L41;
        r13 = new BigInteger(80, new SecureRandom()).toString(16);     // Catch: Exception -> L51
        if (r13.charAt(0) != '-') goto L29;
        r13 = r13.substring(1);     // Catch: Exception -> L51
    L29:
        int r16 = 13 - r13.length();     // Catch: Exception -> L51
        if (r16 <= 0) goto L35;
        StringBuilder r17 = new StringBuilder();     // Catch: Exception -> L51
    L32:
        if (r16 <= 0) goto L34;
        r17.append('F');     // Catch: Exception -> L51
        r16 = r16 - 1;     // Catch: Exception -> L51
        goto L32
    L34:
        r17.append(r13);     // Catch: Exception -> L51
        r13 = r17.toString();     // Catch: Exception -> L51
    L35:
        if (r15 == null) goto L38;
        r10 = r15.h(null, r13);     // Catch: Exception -> L51
    L38:
        if (x0.g(r10) == false) goto L40;
        r13 = r10;
    L40:
        SharedPreferences.Editor r18 = r12.edit();     // Catch: Exception -> L51
        r18.putString("openudid", r13);     // Catch: Exception -> L51
        r18.apply();     // Catch: Exception -> L51
    L43:
        r11 = r13;
        goto L45
    L41:
        if (r15 == null) goto L43;
        r15.h(r13, null);     // Catch: Exception -> L51
        goto L43
    L15:
        if ("9774d56d682e549c".equals(r11) == true) goto L23;
        boolean r19 = x0.g(r13);     // Catch: Exception -> L51
        n r20 = this.f8641c;
        if (r19 == false) goto L21;
        String r21 = r20.h(r11, r13);     // Catch: Exception -> L51
    L22:
        r11 = r21;
        goto L45
    L21:
        r21 = r20.h(null, r11);     // Catch: Exception -> L51
    L45:
        if (TextUtils.isEmpty(r11) == true) goto L48;
        StringBuilder r22 = android.aimedia.a.j(r11);
        r22.append(this.f8646h);
        r11 = r22.toString();
    L48:
        if (TextUtils.isEmpty(r11) == true) goto L50;
        this.f8643e = r11;
    L50:
        return r11;
    L9:
        e = move-exception;
        e.printStackTrace();
        r11 = null;
        goto L11
    L5:
        return this.f8643e;
    }
}
