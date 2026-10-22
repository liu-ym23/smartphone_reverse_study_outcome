package j5;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import x4.j0;

/* JADX INFO: loaded from: classes.dex */
public final class n extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f8677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f8678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j0 f8679d;

    public n(Context r8, SharedPreferences r10, j0 r11) {
        if (r8 == null) goto L7;
        this.f8677b = r8;
        this.f8678c = r10;
        this.f8679d = r11;
        return;
    L7:
        throw new IllegalArgumentException("context can't be null");
    }

    @Override // j5.m
    public final void b(String r8, String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L7;
        SharedPreferences.Editor r11 = i(r8).edit();
        r11.putString(r8, r10);
        r11.apply();
        return;
    }

    @Override // j5.m
    public final String c(String r8) {
        return i(r8).getString(r8, null);
    }

    @Override // j5.e
    public final void d(String[] r8) {
        if (r8 == null) goto L9;
        String r10 = TextUtils.join("\n", r8);
        if (TextUtils.isEmpty(r10) == true) goto L10;
        SharedPreferences.Editor r11 = i("sim_serial_number").edit();
        r11.putString("sim_serial_number", r10);
        r11.apply();
        return;
    L10:
        return;
    }

    @Override // j5.e
    public final void e(List<String> r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        HashMap r10 = new HashMap();
        Iterator<String> r11 = r8.iterator();
    L6:
        if (r11.hasNext() == false) goto L16;
        String r12 = r11.next();
        if (TextUtils.isEmpty(r12) == true) goto L6;
        SharedPreferences r13 = i(r12);
        SharedPreferences.Editor r14 = (SharedPreferences.Editor) r10.get(r13);
        if (r14 != null) goto L12;
        r14 = i(r12).edit();
        r10.put(r13, r14);
    L12:
        if (r13 == null) goto L6;
        if (r13.contains(r12) == false) goto L6;
        r14.remove(r12);
        goto L6
    L16:
        Iterator r15 = r10.entrySet().iterator();
    L18:
        if (r15.hasNext() == false) goto L20;
        ((SharedPreferences.Editor) ((Map.Entry) r15.next()).getValue()).apply();
        goto L18
    L20:
        super.e(r8);
    }

    @Override // j5.e
    public final String[] f() {
        String r8 = i("sim_serial_number").getString("sim_serial_number", null);
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return null;
    L6:
        return r8.split("\n");
    }

    public final SharedPreferences i(String r8) {
        if ("device_id".equals(r8) == true) goto L12;
        if ("install_id".equals(r8) == true) goto L12;
        if ("bd_did".equals(r8) == true) goto L12;
        return k5.a.a(this.f8677b, this.f8679d);
    L12:
        return this.f8678c;
    }
}
