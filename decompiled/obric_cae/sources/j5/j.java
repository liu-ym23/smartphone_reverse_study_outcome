package j5;

import android.annotation.SuppressLint;
import android.content.Context;
import x4.j0;
import x4.s;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    @SuppressLint({"VisibleForTests"})
    public static void a(Context r8, s r10, j0 r11) {
        if (r10.f13380m == false) goto L6;
        String r12 = "dp";
    L9:
        String r13 = k5.a.b(r10, r12);
        if (r11.f13487y == false) goto L12;
        r13 = defpackage.a.e(r13, "_local");
    L12:
        String r14 = defpackage.a.e(r13, ".dat");
        o r15 = new o();
        r15.f8680a = r14;
        r15.f8681b = r10.a(r11);
        r15.f8683d = r11.C;
        r15.f8682c = r11.f13487y;
        String r16 = k5.a.b(r10, "");
        r15.f8684e = r11.f13484v;
        r15.f8685f = r16;
        r15.f8686g = false;
        r15.f8687h = r11;
        if (r10.f13380m == true) goto L15;
        i5.a r17 = new d(r8, r15);
    L16:
        i5.c r18 = (i5.c) i5.d.a(i5.c.class, r11.a());
        if (r18 == null) goto L19;
        r17 = (i5.a) r18.c();
    L19:
        i5.d.b(i5.a.class, r17, r11.a());
        return;
    L15:
        r17 = new k(r8, r15);
        goto L16
    L6:
        if (r11.J == false) goto L8;
        r12 = "device_parameters";
        goto L9
    L8:
        r12 = "device_parameters_" + r11.f13463a;
        goto L9
    }
}
