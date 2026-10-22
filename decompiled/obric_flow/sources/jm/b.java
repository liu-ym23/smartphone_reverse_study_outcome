package jm;

import android.os.Build;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.util.AnimaXLog;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f18354a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f18355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f18356c = false;
    public static boolean d;
    public static boolean e;
    public static boolean f;

    static {
        String r5 = Build.MODEL.toLowerCase();
        f18354a = r5;
        f18355b = -1;
        f18356c = Arrays.asList(new String[]{"m6 note", "m721c"}).contains(r5);
        d = false;
        e = false;
        f = false;
    }

    public static String a(String r5, BaseAbility r10) {
        com.lynx.animax.setting.b r11 = (com.lynx.animax.setting.b) r10.f9577c.c(com.lynx.animax.setting.b.class);
        if (r11 != null) goto L5;
        return "";
    L5:
        return r11.a(r5).b();
    }

    public static boolean b(String r5) {
        if (r5 != null) goto L4;
        return false;
    L4:
        if (r5.isEmpty() == false) goto L6;
        return false;
    L6:
        if (IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST.equals(r5) == false) goto L8;
        return true;
    L8:
        if ("true".equalsIgnoreCase(r5) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean c(String r5, BaseAbility r10) {
        com.lynx.animax.setting.b r11 = (com.lynx.animax.setting.b) r10.f9577c.c(com.lynx.animax.setting.b.class);
        if (r11 != null) goto L26;
        return false;
    L26:
        com.lynx.animax.setting.a r12 = r11.a(r5);     // Catch: Throwable -> L9
        if (r12.d() == false) goto L12;
        return b(r12.b());
    L12:
        if (r12.c() == false) goto L25;
        Collection r13 = r12.a();     // Catch: Throwable -> L9
        if (r13.isEmpty() == true) goto L23;
        String r14 = f18354a;     // Catch: Throwable -> L9
        if (r14 == null) goto L23;
        if (r14.isEmpty() == true) goto L23;
        if (r13.contains(r14) == false) goto L23;
        return true;
    L23:
        return false;
    L25:
        return false;
    L9:
        th = move-exception;
        String r15 = androidx.room.jarjarred.org.antlr.runtime.a.x(th, new StringBuilder("isInSettingList fail, message"));
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "DeviceUtil", r15);
        goto L25
    }
}
