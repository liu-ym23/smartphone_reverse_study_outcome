package qa;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile j f10657a;

    public k() {
    }

    public static j a() {
        if (f10657a != null) goto L28;
        monitor-enter(k.class);
    L24:
        th = move-exception;
        throw th;
    L7:
        if (f10657a == null) goto L31;
    L22:
        monitor-exit(k.class);     // Catch: Throwable -> L24
        goto L28
    L31:
        j r8 = b(Build.MANUFACTURER);     // Catch: Exception -> L20 Throwable -> L24
        if ("".equals(r8.f10605a) == false) goto L18;
        Iterator r10 = Arrays.asList(new String[]{j.f10594p.f10605a, j.f10595q.f10605a, j.f10596r.f10605a, j.f10597s.f10605a, j.f10598t.f10605a, j.f10599u.f10605a, j.f10600v.f10605a, j.f10602x.f10605a, j.f10603y.f10605a, j.f10604z.f10605a, j.A.f10605a}).iterator();     // Catch: Exception -> L20 Throwable -> L24
    L13:
        if (r10.hasNext() == false) goto L17;
        j r11 = b((String) r10.next());     // Catch: Exception -> L20 Throwable -> L24
        if ("".equals(r11.f10605a) == true) goto L13;
        r8 = r11;
        goto L18
    L17:
        r8 = j.B;     // Catch: Exception -> L20 Throwable -> L24
    L18:
        f10657a = r8;     // Catch: Exception -> L20 Throwable -> L24
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
    L28:
        return f10657a;
    }

    public static j b(String r8) {
        if (r8 == null) goto L110;
        if (r8.length() <= 0) goto L110;
        j r10 = j.f10594p;
        boolean r11 = true;
        if (r8.equalsIgnoreCase(r10.f10605a) == true) goto L9;
        j r12 = j.f10595q;
        if (r8.equalsIgnoreCase(r12.f10605a) == false) goto L25;
        String r13 = d("ro.flyme.published");
        String r14 = d("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(r13) == true) goto L19;
    L22:
        String r15 = d("ro.build.display.id");
        c(r12, r15);
        r12.f10608n = r15;
    L23:
        if (r11 == false) goto L108;
        return r12;
    L108:
        return j.B;
    L19:
        if (TextUtils.isEmpty(r14) == false) goto L22;
        r11 = false;
        goto L23
    L25:
        j r16 = j.f10596r;
        if (r8.equalsIgnoreCase(r16.f10605a) == false) goto L33;
        String r17 = d("ro.build.version.emui");
        if (TextUtils.isEmpty(r17) == true) goto L30;
        c(r16, r17);
        r16.f10608n = r17;
    L31:
        if (r11 == false) goto L108;
        return r16;
    L30:
        r11 = false;
        goto L31
    L33:
        j r18 = j.f10597s;
        if (r8.equalsIgnoreCase(r18.f10605a) == false) goto L41;
        String r19 = d("ro.build.version.opporom");
        if (TextUtils.isEmpty(r19) == true) goto L38;
        c(r18, r19);
        r18.f10608n = r19;
    L39:
        if (r11 == false) goto L108;
        return r18;
    L38:
        r11 = false;
        goto L39
    L41:
        j r20 = j.f10598t;
        if (r8.equalsIgnoreCase(r20.f10605a) == false) goto L49;
        String r21 = d("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r21) == true) goto L46;
        c(r20, r21);
        r20.f10608n = r21;
    L47:
        if (r11 == false) goto L108;
        return r20;
    L46:
        r11 = false;
        goto L47
    L49:
        j r22 = j.f10599u;
        if (r8.equalsIgnoreCase(r22.f10605a) == false) goto L57;
        String r23 = d("ro.smartisan.version");
        if (TextUtils.isEmpty(r23) == true) goto L54;
        c(r22, r23);
        r22.f10608n = r23;
    L55:
        if (r11 == false) goto L108;
        return r22;
    L54:
        r11 = false;
        goto L55
    L57:
        j r24 = j.f10600v;
        if (r8.equalsIgnoreCase(r24.f10605a) == false) goto L67;
        String r25 = d("ro.build.display.id");
        if (TextUtils.isEmpty(r25) == false) goto L62;
    L64:
        r11 = false;
    L65:
        if (r11 == false) goto L108;
        return r24;
    L62:
        if (r25.matches("amigo([\\d.]+)[a-zA-Z]*") == false) goto L64;
        c(r24, r25);
        r24.f10608n = r25;
        goto L65
    L67:
        j r26 = j.f10601w;
        if (r8.equalsIgnoreCase(r26.f10605a) == false) goto L75;
        String r27 = d("ro.letv.release.version");
        if (TextUtils.isEmpty(r27) == true) goto L72;
        c(r26, r27);
        r26.f10608n = r27;
    L73:
        if (r11 == false) goto L108;
        return r26;
    L72:
        r11 = false;
        goto L73
    L75:
        j r28 = j.f10602x;
        if (r8.equalsIgnoreCase(r28.f10605a) == false) goto L83;
        String r29 = d("ro.build.sense.version");
        if (TextUtils.isEmpty(r29) == true) goto L80;
        c(r28, r29);
        r28.f10608n = r29;
    L81:
        if (r11 == false) goto L108;
        return r28;
    L80:
        r11 = false;
        goto L81
    L83:
        j r30 = j.f10603y;
        if (r8.equalsIgnoreCase(r30.f10605a) == false) goto L91;
        String r31 = d("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(r31) == true) goto L88;
        c(r30, r31);
        r30.f10608n = r31;
    L89:
        if (r11 == false) goto L108;
        return r30;
    L88:
        r11 = false;
        goto L89
    L91:
        j r32 = j.f10604z;
        if (r8.equalsIgnoreCase(r32.f10605a) == true) goto L94;
        j r33 = j.A;
        if (r8.equalsIgnoreCase(r33.f10605a) == false) goto L108;
        String r34 = d("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(r34) == true) goto L104;
        c(r33, r34);
        r33.f10608n = r34;
    L105:
        if (r11 == false) goto L108;
        return r33;
    L104:
        r11 = false;
        goto L105
    L94:
        if ("android-google".equals(d("ro.com.google.clientidbase")) == false) goto L96;
        String r35 = d("ro.build.version.release");
        r32.f10606b = Build.VERSION.SDK_INT;
        r32.f10608n = r35;
    L97:
        if (r11 == false) goto L108;
        return r32;
    L96:
        r11 = false;
        goto L97
    L9:
        if (TextUtils.isEmpty(d("ro.miui.ui.version.name")) == true) goto L11;
        String r36 = d("ro.build.version.incremental");
        c(r10, r36);
        r10.f10608n = r36;
    L12:
        if (r11 == false) goto L108;
        return r10;
    L11:
        r11 = false;
    L110:
        return j.B;
    }

    public static void c(j r8, String r10) {
        Matcher r11 = Pattern.compile("([\\d.]+)[^\\d]*").matcher(r10);
        if (r11.find() == true) goto L10;
        return;
    L10:
        String r12 = r11.group(1);     // Catch: Exception -> L7
        r8.f10607m = r12;     // Catch: Exception -> L7
        r8.f10606b = Integer.parseInt(r12.split("\\.")[0]);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public static String d(String r8) {
        BufferedReader r10 = null;
        if (TextUtils.isEmpty(null) == true) goto L31;
        throw null;
    L31:
        BufferedReader r11 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(r8)).getInputStream()), 1024);     // Catch: Throwable -> L10 IOException -> L14
        String r12 = r11.readLine();     // Catch: Throwable -> L8 IOException -> L22
        r11.close();     // Catch: Throwable -> L8 IOException -> L22
        r11.close();     // Catch: IOException -> L19
    L33:
        return r12;
    L8:
        th = th;
        r10 = r11;
    L11:
        if (r10 != null) goto L23;
    L13:
        throw th;
    L23:
        r10.close();     // Catch: IOException -> L21
    L15:
        if (r11 == null) goto L34;
        r11.close();     // Catch: IOException -> L20
        return null;
    L35:
        return null;
    L34:
        return null;
    L14:
        r11 = null;
    L10:
        th = th;
        goto L11
    }
}
