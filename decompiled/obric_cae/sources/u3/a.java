package u3;

import android.app.Application;
import android.text.TextUtils;
import c4.l;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import r3.n;
import v4.i;
import x4.b0;
import x4.o0;

/* JADX INFO: loaded from: classes.dex */
public final class a implements b0, z3.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r3.c f12424b;

    public /* synthetic */ a(r3.c r8) {
        this.f12424b = r8;
    }

    @Override // z3.a
    public final boolean a() {
        this.f12424b.getClass();
        return true;
    }

    @Override // z3.a
    public final boolean b(e4.a r8, String r10, String r11) {
        this.f12424b.getClass();
        return false;
    }

    public final String c(Application r8, String r10) {
        if (this.f12424b.f11409q == true) goto L5;
    L9:
        r3.c r11 = this.f12424b;
        o0 r12 = o0.f13535a;
        return q4.a.c(r11.a(r8, r10), v4.b.f12721c);
    L5:
        if (r10.contains("?") == false) goto L7;
        String r13 = "&tt_data=a";
    L8:
        r10 = r10.concat(r13);
        goto L9
    L7:
        r13 = "?tt_data=a";
        goto L8
    }

    public final String[] d(y3.c r8, boolean r10, m4.b r11) {
        n r12 = r8.d();
        if (r10 == false) goto L5;
        String[] r13 = r12.f11440b;
    L6:
        int r14 = 0;
        if (r11 == null) goto L44;
        r11.getClass();
        if (TextUtils.isEmpty(null) == false) goto L14;
        r11.getClass();
        if (TextUtils.isEmpty(null) == false) goto L14;
    L39:
        String[] r15 = null;
    L40:
        if (r15 == null) goto L44;
        if (r15.length <= 0) goto L44;
        r13 = r15;
    L14:
        if (r11.f9261a != null) goto L32;
        r11.f9261a = new String[r13.length];
        int r16 = 0;
    L17:
        if (r16 >= r13.length) goto L32;
        int r17 = r13[r16].indexOf("/service/2/app_log/");
        if (r17 <= 0) goto L29;
        String r18 = r13[r16].substring(0, r17);
        String r19 = r13[r16].substring(r17);
        r11.getClass();
        if (TextUtils.isEmpty(null) == false) goto L27;
        r11.getClass();
        if (TextUtils.isEmpty(null) == false) goto L25;
        r11.f9261a[r16] = defpackage.a.e(r18, r19);
    L30:
        r16 = r16 + 1;
        goto L17
    L25:
        r11.getClass();
        throw null;
    L27:
        r11.getClass();
        throw null;
    L29:
        r11.f9261a[r16] = r13[r16];
    L32:
        if (r11.f9262b == true) goto L39;
        r15 = r11.f9261a;
        if (r15 == null) goto L39;
        if (r15.length <= 0) goto L39;
    L44:
        Application r20 = r8.f13937m.f11402j;
        int r21 = r13.length;
        String[] r22 = new String[r21];
    L45:
        if (r14 >= r21) goto L47;
        r22[r14] = c(r20, r13[r14]);
        r14 = r14 + 1;
        goto L45
    L47:
        return r22;
    L5:
        r13 = r12.f11439a;
        goto L6
    }

    public final String e(String r8, byte[] r10, HashMap r11) {
        if (l.b() == false) goto L6;
        return "";
    L6:
        String r12 = UUID.randomUUID().toString();
        this.f12424b.f11397e.h(r8, r12, r10, r11);
        return r12;
    }

    public final void f(String r8, String r10) {
        if (l.b() == false) goto L5;
        return;
    L5:
        boolean r11 = i.h(r10);
        r3.c r12 = this.f12424b;
        if (r11 == true) goto L12;
        r12.f11397e.g(r8, -1, null, "BDInstall get response empty");
        return;
    L12:
        r12.f11397e.g(r8, 200, r10.getBytes("UTF-8"), null);     // Catch: Throwable -> L11
        return;
    }

    @Override // x4.b0
    public final String get(String r10, Map r11) {
        boolean r8 = l.b();
        r3.c r12 = this.f12424b;
        if (r8 == false) goto L5;
        String r13 = "";
    L6:
        String r14 = r12.f().get(r10, r11);
        f(r13, r14);
        return r14;
    L5:
        String r15 = UUID.randomUUID().toString();
        r12.f11397e.i(r10, r15, null, 0, (HashMap) r11);
        r13 = r15;
        goto L6
    }

    @Override // x4.b0
    public final String post(String r8, byte[] r10, Map r11) {
        String r12 = e(r8, r10, (HashMap) r11);
        String r13 = this.f12424b.f().post(r8, r10, r11);
        f(r12, r13);
        return r13;
    }

    @Override // x4.b0
    public final byte[] postStream(String r8, byte[] r10, Map r11) {
        String r12 = e(r8, r10, (HashMap) r11);
        byte[] r13 = this.f12424b.f().postStream(r8, r10, r11);
        if (r13 == null) goto L5;
        String r14 = new String(r13);
    L6:
        f(r12, r14);
        return r13;
    L5:
        r14 = "";
        goto L6
    }
}
