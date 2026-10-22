package ms.bd.c;

import android.content.Context;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Method;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ d0 b;

    public final void a() {
    L89:
        if (((Boolean) p2.a(67108868, 0, 0, null, null)).booleanValue() == true) goto L6;
        Thread.sleep(500);     // Catch: Throwable -> L86
        goto L89
    L6:
        d0 r1 = this.b;     // Catch: Throwable -> L86
        Context r2 = this.a;     // Catch: Throwable -> L86
        r1.getClass();     // Catch: Throwable -> L86
        String r3 = d0.e(r2);     // Catch: Throwable -> L86
        if (r3 == null) goto L9;
        this.b.a.a.c = r3;     // Catch: Throwable -> L86
    L9:
        String r4 = d0.c(this.a);     // Catch: Throwable -> L86
        if (r4 == null) goto L13;
        this.b.a.a.b = r4;     // Catch: Throwable -> L86
    L13:
        if (((String) p2.a(16777217, 0, 0, "0ebc4a", new byte[]{0, 84, 36, 36})).equals(d0.b().toUpperCase()) == false) goto L15;
        new b(this.a).a(this.b.a);     // Catch: Throwable -> L86
    L77:
        String r5 = null;
    L78:
        if (r5 == null) goto L84;
        y2 r6 = this.b.a;     // Catch: Throwable -> L86
        if (r6 == null) goto L92;
        r6.a.a = r5;     // Catch: Throwable -> L86
        return;
    L92:
        return;
    L84:
        return;
    L15:
        this.b.getClass();     // Catch: Throwable -> L86
        String r7 = d0.d((String) p2.a(16777217, 0, 0, "d9c00a", new byte[]{103, 52, 94, 70, 26, ByteCompanionObject.MAX_VALUE, 107, 28, 124, 118, 112, 41, 3, 77, 0, 120, 41, 29, 63, 117, 124}));     // Catch: Throwable -> L86
        if (TextUtils.isEmpty(r7) == true) goto L21;
        if (r7.contains((String) p2.a(16777217, 0, 0, "b4cf27", new byte[]{102, 56, 27, 28, 2, 55, 111})) == true) goto L21;
    L76:
        new y0(this.a).a(this.b.a);     // Catch: Throwable -> L86
    L21:
        if (((String) p2.a(16777217, 0, 0, "7a4865", new byte[]{14, 86, 102, 123, 44, 11})).equals(d0.b().toUpperCase()) == true) goto L76;
        if (((String) p2.a(16777217, 0, 0, "1f3e0b", new byte[]{8, 77, 110, 62, 57, 84})).equals(d0.b().toUpperCase()) == true) goto L76;
        if (((String) p2.a(16777217, 0, 0, "d8cd28", new byte[]{93, 21, 62, 63, 63})).equals(d0.b().toUpperCase()) == false) goto L29;
        new d1(this.a).b(this.b.a);     // Catch: Throwable -> L86
        goto L77
    L29:
        if (((String) p2.a(16777217, 0, 0, "e8e07c", new byte[]{91, 10, 38, 107})).equals(d0.b().toUpperCase()) == false) goto L31;
    L75:
        new b3(this.a).c(this.b.a);     // Catch: Throwable -> L86
        goto L77
    L31:
        if (((String) p2.a(16777217, 0, 0, "b3b76e", new byte[]{65, 20, 48, 111, 36, 87})).equals(d0.b().toUpperCase()) == true) goto L75;
        if (((String) p2.a(16777217, 0, 0, "9c4409", new byte[]{7, 79, 98, 112, 35, 27, 9})).equals(d0.b().toUpperCase()) == true) goto L75;
        if (((String) p2.a(16777217, 0, 0, "0d8898", new byte[]{18, 71, 102, ByteCompanionObject.MAX_VALUE, 51, 1, 20})).equals(d0.b().toUpperCase()) == false) goto L39;
        new p3(this.a).a(this.b.a);     // Catch: Throwable -> L86
        goto L77
    L39:
        if (((String) p2.a(16777217, 0, 0, "bd9338", new byte[]{95, 67, 100, 104, 58, 0})).equals(d0.b().toUpperCase()) == false) goto L42;
        j1 r8 = new j1(this.a);     // Catch: Throwable -> L86
        y2 r9 = this.b.a;     // Catch: Throwable -> L86
    L44:
        r8.a(r9);     // Catch: Throwable -> L86
        goto L77
    L42:
        if (((String) p2.a(16777217, 0, 0, "611228", new byte[]{10, 28, 118, 105, 33, 0, 7, 49})).equals(d0.b().toUpperCase()) == false) goto L46;
        r8 = new j1(this.a);     // Catch: Throwable -> L86
        r9 = this.b.a;     // Catch: Throwable -> L86
        goto L44
    L46:
        if (((String) p2.a(16777217, 0, 0, "174010", new byte[]{14, 0, 101, 109, 47})).equals(d0.b().toUpperCase()) == false) goto L49;
        r5 = new x2(this.a).a();     // Catch: Throwable -> L86
        goto L78
    L49:
        if (((String) p2.a(16777217, 0, 0, "27b98a", new byte[]{21, 28, 39, 98})).equals(d0.b().toUpperCase()) == false) goto L52;
        r5 = new j4(this.a).b();     // Catch: Throwable -> L86
        goto L78
    L52:
        if (((String) p2.a(16777217, 0, 0, "f52561", new byte[]{90, 18, 104, 123, 60})).equals(d0.b().toUpperCase()) == false) goto L54;
        new q2(this.a).b(this.b.a);     // Catch: Throwable -> L86
        goto L77
    L54:
        this.b.getClass();     // Catch: Throwable -> L86
        String r10 = d0.d((String) p2.a(16777217, 0, 0, "00e0a8", new byte[]{51, 61, 88, 73, 87, 58, 58, 95, 33, 105, 111, 36, 19, 86, 77, 38, 60, 31, 122, 110, 32, 63, 19}));     // Catch: Throwable -> L86
        if (TextUtils.isEmpty(r10) == true) goto L60;
        if (r10.contains((String) p2.a(16777217, 0, 0, "c6cc91", new byte[]{103, 58, 27, 25, 9, 49, 110})) == true) goto L60;
    L67:
        Context r11 = this.a;     // Catch: Throwable -> L86
        k4 r12 = new k4();     // Catch: Throwable -> L86
        if (r12.a == null) goto L77;
        Object r13 = r12.b;     // Catch: Throwable -> L86
        if (r13 == null) goto L77;
        Method r14 = r12.c;     // Catch: Throwable -> L86
        if (r14 == null) goto L77;
        r5 = (String) r14.invoke(r13, new Object[]{r11});     // Catch: Exception -> L85 Throwable -> L86
    L60:
        if (((String) p2.a(16777217, 0, 0, "282feb", new byte[]{27, 19, 96, 61, 119, 92})).equals(d0.b().toUpperCase()) == true) goto L67;
        if (((String) p2.a(16777217, 0, 0, "ebdc1d", new byte[]{70, 69, 51, 58, 39})).equals(d0.b().toUpperCase()) == true) goto L67;
        if (((String) p2.a(16777217, 0, 0, "727d80", new byte[]{4, 28, 101, 51, 44, 20, 28, 50, 84, 31})).equals(d0.b().toUpperCase()) == true) goto L67;
        new y(this.a).a(this.b.a);     // Catch: Throwable -> L86
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b0(d0 r1, Context r2) {
        this.b = r1;
        this.a = r2;
    }
}
