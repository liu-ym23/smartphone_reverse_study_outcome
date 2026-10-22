package qa;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f10506a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f10507b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f10508c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f10509d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f10510e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f10511f = false;

    public class a extends m1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f10512b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f10513m;

        public a(Context r8, String r10) {
            this.f10512b = r8;
            this.f10513m = r10;
        }

        @Override // qa.m1
        public final void a() {
            FileOutputStream r8 = null;
            File r10 = new File(n.b(this.f10512b, "k.store"));     // Catch: Throwable -> L15
            if (r10.getParentFile().exists() == true) goto L6;
            r10.getParentFile().mkdirs();     // Catch: Throwable -> L15
        L6:
            FileOutputStream r11 = new FileOutputStream(r10);     // Catch: Throwable -> L15
            r11.write(t4.i(this.f10513m));     // Catch: Throwable -> L13
            r11.close();     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            th.printStackTrace();
            return;
        L13:
            th = th;
            r8 = r11;
        L40:
            l.a("AI", "stf", th);     // Catch: Throwable -> L23
            if (r8 == null) goto L42;
            r8.close();     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            th.printStackTrace();
            return;
        L42:
            return;
        L23:
            th = move-exception;
            if (r8 != null) goto L32;
        L29:
            throw th;
        L32:
            r8.close();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            th.printStackTrace();
        L15:
            th = th;
            goto L40
        }
    }

    public static boolean a() {
        if (f10511f == false) goto L7;
        return true;
    L7:
        if (c(f10510e) == false) goto L11;
        f10511f = true;     // Catch: Throwable -> L23
        return true;
    L11:
        if (TextUtils.isEmpty(f10510e) == true) goto L15;
        f10511f = false;     // Catch: Throwable -> L23
        f10510e = null;     // Catch: Throwable -> L23
        return false;
    L15:
        if (c(f10507b) == false) goto L19;
        f10511f = true;     // Catch: Throwable -> L23
        return true;
    L19:
        if (TextUtils.isEmpty(f10507b) == true) goto L22;
        f10511f = false;     // Catch: Throwable -> L23
        f10507b = null;     // Catch: Throwable -> L23
        return false;
    L22:
        return true;
    }

    public static String b(Context r8) {
    L8:
        th = move-exception;
        l.a("AI", "gAN", th);
    L11:
        return f10506a;
    L3:
        if ("".equals(f10506a) == false) goto L5;
        PackageManager r10 = r8.getPackageManager();     // Catch: Throwable -> L8
        f10506a = (String) r10.getApplicationLabel(r10.getApplicationInfo(r8.getPackageName(), 0));     // Catch: Throwable -> L8
        goto L11
    L5:
        return f10506a;
    }

    public static boolean c(String r8) {
        if (TextUtils.isEmpty(r8) == true) goto L32;
        r8.toCharArray();
        char[] r10 = r8.toCharArray();
        int r11 = r10.length;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L31;
        char r13 = r10[r12];
        if ('A' > r13) goto L12;
        if (r13 > 'z') goto L12;
    L30:
        r12 = r12 + 1;
    L12:
        if ('0' > r13) goto L16;
        if (r13 <= ':') goto L30;
    L16:
        if (r13 == '.') goto L30;
        String[] r14 = t4.f11124a;     // Catch: Throwable -> L33
        s4.a r15 = new s4.a("collection", "1.0", "AMap_collection_1.0");     // Catch: Throwable -> L33
        r15.f11105e = (String[]) new String[]{"com.amap.api.collection"}.clone();     // Catch: Throwable -> L33
        s4 r16 = r15.a();     // Catch: Throwable -> L33
        Set<Integer> r17 = q.f10946e;     // Catch: Throwable -> L33
        q r18 = l.f10778c;     // Catch: Throwable -> L33
        if (r18 == null) goto L29;
        if (r16.f11093c != 1) goto L22;
        boolean r19 = true;
    L23:
        if (r19 == false) goto L25;
        boolean r20 = true;
    L26:
        if (r20 == false) goto L29;
        s.b(r18.f10947d, r16, 1, "errorPackage", r8);     // Catch: Throwable -> L33
        goto L29
    L25:
        r20 = false;
        goto L26
    L22:
        r19 = false;
    L29:
        return false;
    L31:
        return true;
    L32:
        return false;
    }

    public static String d(Context r8) {
        String r10 = f10507b;     // Catch: Throwable -> L12
        if (r10 != null) goto L5;
    L8:
        String r11 = r8.getPackageName();     // Catch: Throwable -> L12
        f10507b = r11;     // Catch: Throwable -> L12
        if (c(r11) == true) goto L15;
        f10507b = r8.getPackageName();     // Catch: Throwable -> L12
    L15:
        return f10507b;
    L5:
        if ("".equals(r10) == true) goto L8;
        return f10507b;
    L12:
        th = move-exception;
        l.a("AI", "gpck", th);
        goto L15
    }

    public static String e(Context r8) {
    L9:
        th = move-exception;
        l.a("AI", "gAV", th);
    L11:
        String r10 = f10508c;
        if (r10 != null) goto L14;
        return "";
    L14:
        return r10;
    L4:
        if ("".equals(f10508c) == false) goto L6;
        f10508c = r8.getPackageManager().getPackageInfo(r8.getPackageName(), 0).versionName;     // Catch: Throwable -> L9
        goto L11
    L6:
        return f10508c;
    }

    public static String f(Context r8) {
        PackageInfo r10 = r8.getPackageManager().getPackageInfo(r8.getPackageName(), 64);     // Catch: Throwable -> L18
        int r11 = 0;
        byte[] r12 = r10.signatures[0].toByteArray();     // Catch: Throwable -> L18
        byte[] r13 = MessageDigest.getInstance(t4.n("IU0hBMQ")).digest(r12);     // Catch: Throwable -> L18
        StringBuffer r14 = new StringBuffer();     // Catch: Throwable -> L18
    L4:
        if (r11 >= r13.length) goto L9;
        String r15 = Integer.toHexString(r13[r11] & 255).toUpperCase(Locale.US);     // Catch: Throwable -> L18
        if (r15.length() != 1) goto L8;
        r14.append("0");     // Catch: Throwable -> L18
    L8:
        r14.append(r15);     // Catch: Throwable -> L18
        r14.append(BdimCategoryConstants.SEPARATOR_COLON);     // Catch: Throwable -> L18
        r11 = r11 + 1;     // Catch: Throwable -> L18
        goto L4
    L9:
        String r16 = r10.packageName;     // Catch: Throwable -> L18
        if (c(r16) == false) goto L13;
        r16 = r10.packageName;     // Catch: Throwable -> L18
    L13:
        if (TextUtils.isEmpty(f10507b) == true) goto L16;
        r16 = d(r8);     // Catch: Throwable -> L18
    L16:
        r14.append(r16);     // Catch: Throwable -> L18
        String r17 = r14.toString();     // Catch: Throwable -> L18
        f10510e = r17;     // Catch: Throwable -> L18
        return r17;
    L18:
        th = move-exception;
        l.a("AI", "gsp", th);
        return f10510e;
    }

    public static String g(Context r8) {
        int r10 = i4.f10541a;     // Catch: Throwable -> L10
        if (r8 == null) goto L13;
        i4.f10543c = r8.getApplicationContext();     // Catch: Throwable -> L10
    L13:
        return h(r8);
    L7:
        th = move-exception;
        l.a("AI", "gKy", th);
        return f10509d;
    }

    public static String h(Context r8) {
        String r10 = f10509d;
        String r11 = "";
        if (r10 != null) goto L5;
    L6:
        ApplicationInfo r12 = r8.getPackageManager().getApplicationInfo(r8.getPackageName(), 128);
        if (r12 == null) goto L49;
        Bundle r13 = r12.metaData;
        if (r13 == null) goto L49;
        String r14 = r13.getString("com.amap.api.v2.apikey");
        f10509d = r14;
        if (r14 != null) goto L47;
        File r15 = new File(n.b(r8, "k.store"));
        if (r15.exists() == false) goto L38;
        FileInputStream r16 = new FileInputStream(r15);     // Catch: Throwable -> L27
        byte[] r17 = new byte[r16.available()];     // Catch: Throwable -> L25
        r16.read(r17);     // Catch: Throwable -> L25
        String r18 = t4.c(r17);     // Catch: Throwable -> L25
        if (r18.length() != 32) goto L21;
        r11 = r18;
    L21:
        r16.close();     // Catch: Throwable -> L23
    L59:
    L25:
        Throwable th = th;
    L52:
        l.a("AI", "gKe", th);     // Catch: Throwable -> L39
    L34:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L39
    L36:
        if (r16 == null) goto L38;
        r16.close();     // Catch: Throwable -> L23
        goto L59
    L31:
        if (r15.exists() == false) goto L36;
        r15.delete();     // Catch: Throwable -> L34
    L39:
        th = move-exception;
        if (r16 != null) goto L57;
    L45:
        throw th;
    L57:
        r16.close();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.printStackTrace();
    L27:
        th = move-exception;
        th = th;
        r16 = null;
    L38:
        f10509d = r11;
    L23:
        th = move-exception;
        th.printStackTrace();
    L47:
        return f10509d;
    L49:
        return f10509d;
    L5:
        if (r10.equals("") == false) goto L47;
        goto L6
    }
}
