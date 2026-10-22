package jg;

import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Printer;
import l9.m;
import l9.o;
import l9.s;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Printer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18331a;

    public /* synthetic */ g(int r5) {
        this.f18331a = r5;
    }

    @Override // android.util.Printer
    public final void println(String r17) {
        switch(this.f18331a) {
            case 0: goto L93;
            case 1: goto L70;
            case 2: goto L40;
            default: goto L5;
        };
    L70:
        if (r17 != null) goto L73;
        return;
    L73:
        if (r17.charAt(0) != '>') goto L80;
        m r5 = m.a();
        r5.f19576a = -1;
        m.b(r17, r5.f19577b);     // Catch: Exception -> L77
    L86:
        Printer r10 = m.e;
        if (r10 != null) goto L89;
        return;
    L89:
        if (r10 == m.g) goto L113;
        r10.println(r17);
        return;
    L113:
        return;
    L77:
        e = move-exception;
        io.reactivex.exceptions.a.f(e);
        goto L86
    L80:
        if (r17.charAt(0) != '<') goto L86;
        m r11 = m.a();
        r11.getClass();
        r11.f19576a = SystemClock.uptimeMillis();
        m.b(r17, r11.f19578c);     // Catch: Exception -> L84
    L84:
        e = move-exception;
        io.reactivex.exceptions.a.j(e);
        goto L86
    L5:
        if (a.a.d == true) goto L8;
        return;
    L8:
        if (a.a.f28r < 0) goto L107;
        long r12 = a.a.g;
        a.a.f24n = "no message running";
        long r13 = r12 - a.a.f28r;
        if (r13 <= 0) goto L108;
        long r14 = a.a.f27q;
        long r15 = SystemClock.uptimeMillis();
        if (r13 == 1) goto L16;
    L18:
        if (r13 == 1) goto L20;
    L22:
        if (r13 > 1) goto L24;
    L26:
        if (r13 > 1) goto L28;
    L30:
        int r16 = 0;
    L32:
        if (a.a.f25o == true) goto L37;
        z8.g r18 = a.a.s();
        long r19 = r14 - a.a.f20j;
        long r110 = r15 - a.a.f21k;
        int r111 = a.a.f22l;
        r18.e = r19;
        r18.f23422c = r13;
        r18.d = r110;
        r18.f23420a = r111;
        if (r17 == null) goto L36;
        r18.f = r17;
    L36:
        r18.f23421b = r16;
    L37:
        a.a.f20j = r14;
        a.a.f21k = r15;
        a.a.f22l = 0;
        a.a.f28r = r12;
        return;
    L28:
        if (a.a.f22l != 1) goto L30;
        r16 = 8;
        goto L32
    L24:
        if (a.a.f22l <= 1) goto L26;
        r16 = 4;
        goto L32
    L20:
        if (a.a.f22l != 1) goto L22;
        r16 = 2;
        goto L32
    L16:
        if (a.a.f22l <= 1) goto L18;
        r16 = 9;
        goto L32
    L108:
        return;
    L107:
        return;
    L40:
        if (a.a.d == false) goto L111;
        a.a.f24n = r17;
        if (a.a.f23m == true) goto L46;
        a.a.f23m = true;
        a.a.f26p = Process.myTid();
        s r20 = o.j();
        a.a.f19i = SystemClock.uptimeMillis();
        new Handler(r20.getLooper()).postDelayed(new so.e(9), a.a.f18h);
    L46:
        if (a.a.f28r != (-1)) goto L48;
        a.a.f28r = 0;
        a.a.s = 0;
        return;
    L48:
        long r21 = a.a.g;
        a.a.s = r21;
        long r22 = r21 - a.a.f28r;
        if (r22 > 0) goto L52;
        a.a.f22l++;
        return;
    L52:
        if (r22 != 1) goto L59;
        int r23 = a.a.f22l;
        if (r23 <= 1) goto L56;
        int r24 = 7;
    L65:
        long r25 = a.a.f27q;
        long r26 = SystemClock.uptimeMillis();
        if (a.a.f25o == true) goto L68;
        z8.g r112 = a.a.s();
        long r113 = r25 - a.a.f20j;
        long r114 = r26 - a.a.f21k;
        int r115 = a.a.f22l;
        r112.e = r113;
        r112.f23422c = r22;
        r112.d = r114;
        r112.f23420a = r115;
        r112.f23421b = r24;
    L68:
        a.a.f20j = r25;
        a.a.f21k = r26;
        a.a.f22l = 1;
        a.a.f28r = r21;
        return;
    L56:
        if (r23 != 1) goto L58;
        r24 = 3;
        goto L65
    L58:
        r24 = 0;
        goto L65
    L59:
        int r27 = a.a.f22l;
        if (r27 <= 1) goto L62;
        r24 = 5;
        goto L65
    L62:
        if (r27 != 1) goto L64;
        r24 = 6;
        goto L65
    L64:
        r24 = 1;
        goto L65
    L111:
        return;
    L93:
        if (TextUtils.isEmpty(r17) == false) goto L96;
        return;
    L96:
        if (r17.charAt(0) != '>') goto L99;
        i.a(true, r17, null);
        return;
    L99:
        if (r17.charAt(0) != '<') goto L116;
        i.a(false, r17, null);
        return;
    }
}
