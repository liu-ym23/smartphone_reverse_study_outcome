package k5;

import android.os.Build;
import android.text.TextUtils;
import x4.r;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8942a = null;

    public static class a extends l<Boolean> {
        @Override // k5.l
        public final Boolean a(Object[] r8) {
            Class<?> r10 = Class.forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L4
            return Boolean.valueOf("harmony".equals(r10.getMethod("getOsBrand", new Class[0]).invoke(r10, new Object[0])));
        L4:
            int r11 = r.f13543a;
            return Boolean.FALSE;
        }
    }

    static {
        f8942a = new a();
    }

    public static String a() {
        String r8 = b("persist.pxr.product.forcename");
        if (TextUtils.isEmpty(r8) == false) goto L6;
        r8 = b("pxr.vendorhw.product.name");
    L6:
        if (TextUtils.isEmpty(r8) == true) goto L8;
        return r8;
    L8:
        return Build.PRODUCT;
    }

    public static String b(String r8) {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r8, ""});
    L5:
        return "";
    }

    public static String c(String r8) {
        return (String) n.a(r8);
    }

    public static boolean d() {
        Class<?> r8 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L7
        if (TextUtils.isEmpty((String) r8.getDeclaredMethod("get", new Class[]{String.class}).invoke(r8, new Object[]{"ro.build.version.emui"})) == true) goto L9;
        int r10 = r.f13543a;     // Catch: Exception -> L7
        return true;
    L9:
        return false;
    L7:
        e = move-exception;
        e.getMessage();
        int r11 = r.f13543a;
        goto L9
    }

    public static boolean e() {
        if ("oppo".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L10;
        String r8 = Build.BRAND;
        if ("oppo".equalsIgnoreCase(r8) == true) goto L10;
        if ("realme".equalsIgnoreCase(r8) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean f() {
        String r8 = Build.DISPLAY;
        if (TextUtils.isEmpty(r8) == true) goto L7;
        if (r8.contains("Flyme") == false) goto L7;
    L8:
        return true;
    L7:
        if ("flyme".equals(Build.USER) == true) goto L8;
        return false;
    }

    public static boolean g() {
        String r8 = Build.BRAND;
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L6:
        String r10 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r10) == true) goto L11;
        if (r10.toLowerCase().startsWith("honor") == false) goto L11;
    L12:
        return true;
    L11:
        if ("HONOR".equalsIgnoreCase(r10) == true) goto L12;
        return false;
    L5:
        if (r8.toLowerCase().startsWith("honor") == true) goto L12;
        goto L6
    }

    public static boolean h() {
        if (Class.forName("miui.os.Build").getName().length() <= 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }
}
