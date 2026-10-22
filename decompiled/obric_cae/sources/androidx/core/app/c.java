package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static <T> T a(Context r8, Class<T> r10) {
        return (T) r8.getSystemService(r10);
    }

    public static int b(AppOpsManager r8, String r10, String r11) {
        return r8.noteProxyOp(r10, r11);
    }

    public static int c(AppOpsManager r8, String r10, String r11) {
        return r8.noteProxyOpNoThrow(r10, r11);
    }

    public static String d(String r8) {
        return AppOpsManager.permissionToOp(r8);
    }
}
