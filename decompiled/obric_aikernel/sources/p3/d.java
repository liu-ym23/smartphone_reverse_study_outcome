package p3;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import java.io.File;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f12321a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f12322b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f12323c = false;

    static {
    }

    public static void a(@NonNull File r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.exists() == true) goto L7;
        return;
    L7:
        if (r10.isDirectory() == false) goto L17;
        File[] r11 = r10.listFiles();
        int r12 = r11.length;
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L17;
        File r14 = r11[r13];
        if (r14.isFile() == false) goto L14;
        r14.delete();
    L16:
        r13 = r13 + 1;
        goto L9
    L14:
        if (r10.isDirectory() == false) goto L16;
        a(r14);
    L17:
        r10.delete();
    }

    private static long b() {
        long r10 = f12321a;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        long r11 = Runtime.getRuntime().maxMemory();
        f12321a = r11;
        return r11;
    }

    public static float c() {
        float r10 = ((float) new BigDecimal(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()).divide(new BigDecimal(b()), 4, 4).doubleValue()) * 100.0f;
        c.c("currentRate %f", new Object[]{Float.valueOf(r10)});
        return r10;
    }

    public static boolean d(Context r10) {
        if ((r10.getApplicationInfo().flags & 2) == 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    public static boolean e(Context r10) {
        if (f12322b == true) goto L5;
        String r11 = null;
        if (Build.VERSION.SDK_INT < 28) goto L9;
        r11 = Application.getProcessName();
    L9:
        if (r11 != null) goto L12;
        return false;
    L12:
        f12323c = r11.equals(r10.getPackageName() + ":apm_memory_upload");
        f12322b = true;
        return f12323c;
    L5:
        return f12323c;
    }

    public static void f(Context r10, Class<?> r11, boolean r12) {
        if (r11 == null) goto L9;
        ComponentName r13 = new ComponentName(r10, r11);
        PackageManager r14 = r10.getPackageManager();
        if (r12 == false) goto L6;
        int r15 = 1;
    L7:
        r14.setComponentEnabledSetting(r13, r15, 1);
        return;
    L6:
        r15 = 2;
        goto L7
    }
}
