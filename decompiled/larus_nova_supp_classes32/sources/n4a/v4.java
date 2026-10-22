package n4a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v4 {
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e;
    public static boolean f;

    public class a extends l1 {
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;

        public a(Context r1, String r2) {
            this.b = r1;
            this.c = r2;
        }

        @Override // n4a.l1
        public final void a() {
            FileOutputStream r0 = null;
            PolarisFileWrapper r2 = new PolarisFileWrapper(p.c(this.b, "k.store"));     // Catch: Throwable -> L15
            if (r2.getParentFile().exists() == true) goto L6;
            r2.getParentFile().mkdirs();     // Catch: Throwable -> L15
        L6:
            FileOutputStream r1 = new PolarisFileOutputStreamWrapper(r2);     // Catch: Throwable -> L15
            r1.write(f5.j(this.c));     // Catch: Throwable -> L13
            r1.close();     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            th.printStackTrace();
            return;
        L13:
            th = move-exception;
            th = th;
            r0 = r1;
        L40:
            n.a(th, "AI", "stf");     // Catch: Throwable -> L23
            if (r0 == null) goto L42;
            r0.close();     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            th.printStackTrace();
            return;
        L42:
            return;
        L23:
            th = move-exception;
            if (r0 != null) goto L32;
        L29:
            throw th;
        L32:
            r0.close();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            th.printStackTrace();
        L15:
            th = th;
            goto L40
        }
    }

    public static boolean a() {
        if (f == false) goto L7;
        return true;
    L7:
        if (c(e) == false) goto L11;
        f = true;     // Catch: Throwable -> L23
        return true;
    L11:
        if (TextUtils.isEmpty(e) == true) goto L15;
        f = false;     // Catch: Throwable -> L23
        e = null;     // Catch: Throwable -> L23
        return false;
    L15:
        if (c(b) == false) goto L19;
        f = true;     // Catch: Throwable -> L23
        return true;
    L19:
        if (TextUtils.isEmpty(b) == true) goto L22;
        f = false;     // Catch: Throwable -> L23
        b = null;     // Catch: Throwable -> L23
        return false;
    L22:
        return true;
    }

    public static String b(Context r2) {
    L8:
        th = move-exception;
        n.a(th, "AI", "gAN");
    L11:
        return a;
    L3:
        if (NameKeys.UnloadStrategy_No_Strategy.equals(a) == false) goto L5;
        PackageManager r0 = r2.getPackageManager();     // Catch: Throwable -> L8
        a = (String) r0.getApplicationLabel(r0.getApplicationInfo(r2.getPackageName(), 0));     // Catch: Throwable -> L8
        goto L11
    L5:
        return a;
    }

    public static String d(Context r2) {
        String r0 = b;     // Catch: Throwable -> L12
        if (r0 != null) goto L5;
    L8:
        String r1 = r2.getPackageName();     // Catch: Throwable -> L12
        b = r1;     // Catch: Throwable -> L12
        if (c(r1) == true) goto L15;
        b = r2.getPackageName();     // Catch: Throwable -> L12
    L15:
        return b;
    L5:
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r0) == true) goto L8;
        return b;
    L12:
        th = move-exception;
        n.a(th, "AI", "gpck");
        goto L15
    }

    public static String e(Context r3) {
    L9:
        th = move-exception;
        n.a(th, "AI", "gAV");
    L11:
        String r4 = c;
        if (r4 != null) goto L14;
        return NameKeys.UnloadStrategy_No_Strategy;
    L14:
        return r4;
    L4:
        if (NameKeys.UnloadStrategy_No_Strategy.equals(c) == false) goto L6;
        c = r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionName;     // Catch: Throwable -> L9
        goto L11
    L6:
        return c;
    }

    public static String f(Context r7) {
        PackageInfo r0 = r7.getPackageManager().getPackageInfo(r7.getPackageName(), 64);     // Catch: Throwable -> L18
        int r2 = 0;
        byte[] r1 = r0.signatures[0].toByteArray();     // Catch: Throwable -> L18
        byte[] r3 = MessageDigest.getInstance(f5.o("IU0hBMQ")).digest(r1);     // Catch: Throwable -> L18
        StringBuffer r4 = new StringBuffer();     // Catch: Throwable -> L18
    L4:
        if (r2 >= r3.length) goto L9;
        String r5 = Integer.toHexString(r3[r2] & 255).toUpperCase(Locale.US);     // Catch: Throwable -> L18
        if (r5.length() != 1) goto L8;
        r4.append("0");     // Catch: Throwable -> L18
    L8:
        r4.append(r5);     // Catch: Throwable -> L18
        r4.append(":");     // Catch: Throwable -> L18
        r2 = r2 + 1;     // Catch: Throwable -> L18
        goto L4
    L9:
        String r6 = r0.packageName;     // Catch: Throwable -> L18
        if (c(r6) == false) goto L13;
        r6 = r0.packageName;     // Catch: Throwable -> L18
    L13:
        if (TextUtils.isEmpty(b) == true) goto L16;
        r6 = d(r7);     // Catch: Throwable -> L18
    L16:
        r4.append(r6);     // Catch: Throwable -> L18
        String r8 = r4.toString();     // Catch: Throwable -> L18
        e = r8;     // Catch: Throwable -> L18
        return r8;
    L18:
        th = move-exception;
        n.a(th, "AI", "gsp");
        return e;
    }

    public static boolean c(String r7) {
        if (TextUtils.isEmpty(r7) == true) goto L32;
        r7.toCharArray();
        char[] r0 = r7.toCharArray();
        int r2 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L31;
        char r5 = r0[r3];
        if ('A' > r5) goto L12;
        if (r5 > 'z') goto L12;
    L30:
        r3 = r3 + 1;
    L12:
        if ('0' > r5) goto L16;
        if (r5 <= ':') goto L30;
    L16:
        if (r5 == '.') goto L30;
        String[] r1 = f5.a;     // Catch: Throwable -> L33
        e5.a r4 = new e5.a("collection", "1.0", "AMap_collection_1.0");     // Catch: Throwable -> L33
        r4.e = (String[]) new String[]{"com.amap.api.collection"}.clone();     // Catch: Throwable -> L33
        e5 r6 = r4.a();     // Catch: Throwable -> L33
        Set<Integer> r8 = r.e;     // Catch: Throwable -> L33
        r r9 = n.c;     // Catch: Throwable -> L33
        if (r9 == null) goto L29;
        Context r10 = r9.d;     // Catch: Throwable -> L33
        if (r6.c != 1) goto L22;
        boolean r11 = true;
    L23:
        if (r11 == false) goto L25;
        boolean r12 = true;
    L26:
        if (r12 == false) goto L29;
        t.b(r10, r6, 1, "errorPackage", r7);     // Catch: Throwable -> L33
        goto L29
    L25:
        r12 = false;
        goto L26
    L22:
        r11 = false;
    L29:
        return false;
    L31:
        return true;
    L32:
        return false;
    }

    public static String g(Context r2) {
        int r0 = com.loc.i.a;     // Catch: Throwable -> L10
        if (r2 == null) goto L13;
        com.loc.i.c = r2.getApplicationContext();     // Catch: Throwable -> L10
    L13:
        return h(r2);
    L7:
        th = move-exception;
        n.a(th, "AI", "gKy");
        return d;
    }

    public static String h(Context r5) throws PackageManager.NameNotFoundException {
        String r0 = d;
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
        if (r0 != null) goto L5;
    L6:
        ApplicationInfo r2 = r5.getPackageManager().getApplicationInfo(r5.getPackageName(), LynxTouchEvent.kPseudoStateFocusTransition);
        if (r2 == null) goto L49;
        Bundle r3 = r2.metaData;
        if (r3 == null) goto L49;
        String r4 = r3.getString("com.amap.api.v2.apikey");
        d = r4;
        if (r4 != null) goto L47;
        PolarisFileWrapper r6 = new PolarisFileWrapper(p.c(r5, "k.store"));
        if (r6.exists() == false) goto L38;
        PolarisFileInputStreamWrapper r7 = new PolarisFileInputStreamWrapper(r6);     // Catch: Throwable -> L27
        byte[] r8 = new byte[r7.available()];     // Catch: Throwable -> L25
        r7.read(r8);     // Catch: Throwable -> L25
        String r9 = f5.d(r8);     // Catch: Throwable -> L25
        if (r9.length() != 32) goto L21;
        r1 = r9;
    L21:
        r7.close();     // Catch: Throwable -> L23
    L59:
    L25:
        Throwable th = th;
    L52:
        n.a(th, "AI", "gKe");     // Catch: Throwable -> L39
    L34:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L39
    L36:
        if (r7 == null) goto L38;
        r7.close();     // Catch: Throwable -> L23
        goto L59
    L31:
        if (r6.exists() == false) goto L36;
        r6.delete();     // Catch: Throwable -> L34
    L39:
        th = move-exception;
        if (r7 != null) goto L57;
    L45:
        throw th;
    L57:
        r7.close();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.printStackTrace();
    L27:
        th = move-exception;
        th = th;
        r7 = null;
    L38:
        d = r1;
    L23:
        th = move-exception;
        th.printStackTrace();
    L47:
        return d;
    L49:
        return d;
    L5:
        if (r0.equals(NameKeys.UnloadStrategy_No_Strategy) == false) goto L47;
        goto L6
    }
}
