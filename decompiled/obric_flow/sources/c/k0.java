package c;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f1061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f1062c;

    static {
        if ("userdebug".equals(b("ro.build.type", "")) == true) goto L5;
        IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST.equals(b("ro.debuggable", ""));
    L5:
        f1061b = null;
    }

    public static String a(Context r5) {
        String r10 = f1060a;
        if (r10 == null) goto L5;
        return r10;
    L5:
        f1060a = "";
        String r11 = Settings.System.getString(r5.getContentResolver(), "android_id");     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r11) == true) goto L17;
        if (r11.length() >= 16) goto L17;
        StringBuilder r12 = new StringBuilder();     // Catch: Exception -> L13
        int r13 = 16 - r11.length();     // Catch: Exception -> L13
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L15;
        r12.append("0");     // Catch: Exception -> L13
        r14 = r14 + 1;     // Catch: Exception -> L13
        goto L11
    L15:
        r12.append(r11);     // Catch: Exception -> L13
        r11 = r12.toString();     // Catch: Exception -> L13
    L17:
        if (TextUtils.isEmpty(r11) == true) goto L22;
        f1060a = r11;     // Catch: Exception -> L13
    L22:
        return f1060a;
    L13:
        e = move-exception;
        m.j("PhoneUtils", "getAndroidId error", e);
        goto L22
    }

    public static String b(String r5, String r10) {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r5, r10});
    L4:
        e = move-exception;
        m.j("PhoneUtils", "getStringSystemProperties error", e);
        return r10;
    }

    public static String c() {
        if (f1061b != null) goto L5;
        f1061b = Build.PRODUCT.toLowerCase(Locale.US);
    L5:
        m.i("PhoneUtils", "getProductName sProductName = " + f1061b);
        return f1061b;
    }
}
