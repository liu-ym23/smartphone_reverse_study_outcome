package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static int a(AppOpsManager r8, String r10, int r11, String r12) {
        if (r8 != null) goto L6;
        return 1;
    L6:
        return r8.checkOpNoThrow(r10, r11, r12);
    }

    public static String b(Context r8) {
        return r8.getOpPackageName();
    }

    public static AppOpsManager c(Context r8) {
        return (AppOpsManager) r8.getSystemService(AppOpsManager.class);
    }
}
