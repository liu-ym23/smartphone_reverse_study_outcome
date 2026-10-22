package n4a;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.loc.al;
import com.miui.easygo.constant.EasyGoConstant;
import com.obric.aivoice.core.data.NameKeys;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m {
    public static volatile al a;

    public m() {
    }

    public static al a() {
        if (a != null) goto L28;
        monitor-enter(m.class);
    L24:
        th = move-exception;
        throw th;
    L7:
        if (a == null) goto L31;
    L22:
        monitor-exit(m.class);     // Catch: Throwable -> L24
        goto L28
    L31:
        al r1 = b(Build.MANUFACTURER);     // Catch: Exception -> L20 Throwable -> L24
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r1.a()) == false) goto L18;
        Iterator r2 = Arrays.asList(new String[]{al.a.a(), al.b.a(), al.c.a(), al.d.a(), al.e.a(), al.f.a(), al.g.a(), al.i.a(), al.j.a(), al.k.a(), al.l.a()}).iterator();     // Catch: Exception -> L20 Throwable -> L24
    L13:
        if (r2.hasNext() == false) goto L17;
        al r3 = b((String) r2.next());     // Catch: Exception -> L20 Throwable -> L24
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r3.a()) == true) goto L13;
        r1 = r3;
        goto L18
    L17:
        r1 = al.m;     // Catch: Exception -> L20 Throwable -> L24
    L18:
        a = r1;     // Catch: Exception -> L20 Throwable -> L24
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
    L28:
        return a;
    }

    public static void c(al r1, String r2) {
        Matcher r3 = PatternProtector.compile("([\\d.]+)[^\\d]*").matcher(r2);
        if (r3.find() == true) goto L10;
        return;
    L10:
        String r4 = r3.group(1);     // Catch: Exception -> L7
        r1.a(r4);     // Catch: Exception -> L7
        r1.a(CastIntegerProtector.parseInt(r4.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN)[0]));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public static al b(String r5) {
        if (r5 == null) goto L110;
        if (r5.length() <= 0) goto L110;
        al r0 = al.a;
        boolean r2 = true;
        if (r5.equalsIgnoreCase(r0.a()) == true) goto L9;
        al r1 = al.b;
        if (r5.equalsIgnoreCase(r1.a()) == false) goto L25;
        String r6 = d("ro.flyme.published");
        String r3 = d("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(r6) == true) goto L19;
    L22:
        String r7 = d("ro.build.display.id");
        c(r1, r7);
        r1.b(r7);
    L23:
        if (r2 == false) goto L108;
        return r1;
    L108:
        return al.m;
    L19:
        if (TextUtils.isEmpty(r3) == false) goto L22;
        r2 = false;
        goto L23
    L25:
        al r4 = al.c;
        if (r5.equalsIgnoreCase(r4.a()) == false) goto L33;
        String r8 = d("ro.build.version.emui");
        if (TextUtils.isEmpty(r8) == true) goto L30;
        c(r4, r8);
        r4.b(r8);
    L31:
        if (r2 == false) goto L108;
        return r4;
    L30:
        r2 = false;
        goto L31
    L33:
        al r9 = al.d;
        if (r5.equalsIgnoreCase(r9.a()) == false) goto L41;
        String r10 = d("ro.build.version.opporom");
        if (TextUtils.isEmpty(r10) == true) goto L38;
        c(r9, r10);
        r9.b(r10);
    L39:
        if (r2 == false) goto L108;
        return r9;
    L38:
        r2 = false;
        goto L39
    L41:
        al r11 = al.e;
        if (r5.equalsIgnoreCase(r11.a()) == false) goto L49;
        String r12 = d("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r12) == true) goto L46;
        c(r11, r12);
        r11.b(r12);
    L47:
        if (r2 == false) goto L108;
        return r11;
    L46:
        r2 = false;
        goto L47
    L49:
        al r13 = al.f;
        if (r5.equalsIgnoreCase(r13.a()) == false) goto L57;
        String r14 = d("ro.smartisan.version");
        if (TextUtils.isEmpty(r14) == true) goto L54;
        c(r13, r14);
        r13.b(r14);
    L55:
        if (r2 == false) goto L108;
        return r13;
    L54:
        r2 = false;
        goto L55
    L57:
        al r15 = al.g;
        if (r5.equalsIgnoreCase(r15.a()) == false) goto L67;
        String r16 = d("ro.build.display.id");
        if (TextUtils.isEmpty(r16) == false) goto L62;
    L64:
        r2 = false;
    L65:
        if (r2 == false) goto L108;
        return r15;
    L62:
        if (r16.matches("amigo([\\d.]+)[a-zA-Z]*") == false) goto L64;
        c(r15, r16);
        r15.b(r16);
        goto L65
    L67:
        al r17 = al.h;
        if (r5.equalsIgnoreCase(r17.a()) == false) goto L75;
        String r18 = d("ro.letv.release.version");
        if (TextUtils.isEmpty(r18) == true) goto L72;
        c(r17, r18);
        r17.b(r18);
    L73:
        if (r2 == false) goto L108;
        return r17;
    L72:
        r2 = false;
        goto L73
    L75:
        al r19 = al.i;
        if (r5.equalsIgnoreCase(r19.a()) == false) goto L83;
        String r20 = d("ro.build.sense.version");
        if (TextUtils.isEmpty(r20) == true) goto L80;
        c(r19, r20);
        r19.b(r20);
    L81:
        if (r2 == false) goto L108;
        return r19;
    L80:
        r2 = false;
        goto L81
    L83:
        al r21 = al.j;
        if (r5.equalsIgnoreCase(r21.a()) == false) goto L91;
        String r22 = d("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(r22) == true) goto L88;
        c(r21, r22);
        r21.b(r22);
    L89:
        if (r2 == false) goto L108;
        return r21;
    L88:
        r2 = false;
        goto L89
    L91:
        al r23 = al.k;
        if (r5.equalsIgnoreCase(r23.a()) == true) goto L94;
        al r24 = al.l;
        if (r5.equalsIgnoreCase(r24.a()) == false) goto L108;
        String r25 = d("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(r25) == true) goto L104;
        c(r24, r25);
        r24.b(r25);
    L105:
        if (r2 == false) goto L108;
        return r24;
    L104:
        r2 = false;
        goto L105
    L94:
        if ("android-google".equals(d("ro.com.google.clientidbase")) == false) goto L96;
        String r26 = d("ro.build.version.release");
        r23.a(Build.VERSION.SDK_INT);
        r23.b(r26);
    L97:
        if (r2 == false) goto L108;
        return r23;
    L96:
        r2 = false;
        goto L97
    L9:
        if (TextUtils.isEmpty(d("ro.miui.ui.version.name")) == true) goto L11;
        String r27 = d("ro.build.version.incremental");
        c(r0, r27);
        r0.b(r27);
    L12:
        if (r2 == false) goto L108;
        return r0;
    L11:
        r2 = false;
    L110:
        return al.m;
    }

    public static String d(String r3) {
        BufferedReader r0 = null;
        if (TextUtils.isEmpty(null) == true) goto L31;
        throw null;
    L31:
        BufferedReader r1 = new BufferedReader(new InputStreamReader(e(Runtime.getRuntime(), "getprop ".concat(r3)).getInputStream()), 1024);     // Catch: Throwable -> L11 IOException -> L15
        String r4 = r1.readLine();     // Catch: Throwable -> L8 IOException -> L10
        r1.close();     // Catch: Throwable -> L8 IOException -> L10
        r1.close();     // Catch: IOException -> L20
    L33:
        return r4;
    L8:
        th = th;
        r0 = r1;
    L12:
        if (r0 != null) goto L27;
    L14:
        throw th;
    L27:
        r0.close();     // Catch: IOException -> L22
    L16:
        if (r1 == null) goto L34;
        r1.close();     // Catch: IOException -> L21
        return null;
    L35:
        return null;
    L34:
        return null;
    L15:
        r1 = null;
    L11:
        th = th;
        goto L12
    }

    public static Process e(Runtime r12, String r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(102900, "java/lang/Runtime", "exec", r12, r9, "java.lang.Process", r10);
        if (r11.a == false) goto L6;
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, null, r10, false);
        return (Process) r11.b;
    L6:
        Process r14 = r12.exec(r13);
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, r14, r10, true);
        return r14;
    }
}
