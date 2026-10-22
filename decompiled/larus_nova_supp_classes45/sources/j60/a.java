package j60;

import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public b a;
    public double b;
    public long c;
    public long d;
    public long e;
    public double f;
    public final boolean g;

    public final void a() {
        long r13 = System.currentTimeMillis();
        BufferedReader r5 = null;
        BufferedReader r8 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L10
        String r2 = r8.readLine();     // Catch: Throwable -> L70
        r8.close();     // Catch: Throwable -> L70
        String[] r3 = r2.split(" ");     // Catch: Throwable -> L70
        long r9 = ((Long.parseLong(r3[13]) + Long.parseLong(r3[14])) + Long.parseLong(r3[15])) + Long.parseLong(r3[16]);
        r8.close();     // Catch: Throwable -> L8
    L9:
        long r11 = r9;
    L17:
        if (this.g == true) goto L71;
        long r4 = 0;
    L31:
        long r1 = this.e;
        if (r1 > (-1)) goto L34;
        long r15 = 0;
        double r7 = 0.0d;
        double r12 = 0.0d;
    L48:
        if (this.e <= (-1)) goto L66;
        b r6 = this.a;
        if (r6 != null) goto L52;
        long r21 = r4;
        double r17 = r7;
        long r14 = r15;
        long r25 = r11;
        this.a = new b(r13, r12, r12, r17, r17);
        long r16 = r13;
        double r18 = r17;
        double r19 = r12;
    L62:
        b r22 = this.a;
        if ((r16 - r22.a) <= 300000) goto L65;
        r22.a = r14;
        r22.b = 0.0d;
        r22.c = 0.0d;
    L65:
        long r23 = r21;
    L67:
        this.c = r23;
        this.d = r25;
        this.b = r19;
        this.e = r16;
        this.f = r18;
        return;
    L52:
        double r110 = r7;
        double r24 = r12;
        r25 = r11;
        r21 = r4;
        r14 = r15;
        if (r6.a != r14) goto L55;
        r16 = r13;
        r6.a = r16;
    L56:
        r19 = r24;
        if (r6.b >= r19) goto L59;
        r6.b = r19;
    L59:
        r18 = r110;
        if (r6.c >= r18) goto L62;
        r6.c = r18;
        goto L62
    L55:
        r16 = r13;
        goto L56
    L66:
        r18 = r7;
        r19 = r12;
        r25 = r11;
        r16 = r13;
        r23 = r4;
        goto L67
    L34:
        if (this.g == false) goto L36;
        double r26 = ((r11 - this.d) * 1.0d) / (r4 - this.c);
    L37:
        double r27 = ((r11 - this.d) * 1000.0d) / (r13 - r1);
        if (i60.a.a != (-1)) goto L44;
        long r28 = Os.sysconf(OsConstants._SC_CLK_TCK);
        r15 = 0;
        if (r28 > 0) goto L43;
        r28 = 100;
    L43:
        i60.a.a = r28;
    L45:
        r12 = r26;
        r7 = r27 / i60.a.a;
        goto L48
    L44:
        r15 = 0;
        goto L45
    L36:
        r26 = 0.0d;
        goto L37
    L71:
        BufferedReader r29 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/stat")), 1000);     // Catch: Throwable -> L69
        String r31 = r29.readLine();     // Catch: Throwable -> L24
        r29.close();     // Catch: Throwable -> L24
        String[] r32 = r31.split(" ");     // Catch: Throwable -> L24
        r4 = (((((Long.parseLong(r32[2]) + Long.parseLong(r32[3])) + Long.parseLong(r32[4])) + Long.parseLong(r32[6])) + Long.parseLong(r32[5])) + Long.parseLong(r32[7])) + Long.parseLong(r32[8]);
        r29.close();     // Catch: Throwable -> L23
    L24:
        r5 = r29;
    L25:
        if (r5 != null) goto L75;
    L29:
        r4 = -1;
        goto L31
    L75:
        r5.close();     // Catch: Throwable -> L28
    L11:
        if (r8 != null) goto L83;
    L15:
        r11 = -1;
        goto L17
    L83:
        r8.close();     // Catch: Throwable -> L14
    L10:
        r8 = null;
        goto L11
    }

    public a() {
        this.b = -1.0d;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1.0d;
        this.g = i60.a.c();
    }
}
