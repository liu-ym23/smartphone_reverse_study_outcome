package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static int noteOp(AppOpsManager r10, String r11, int r12, String r13) {
            return r10.noteOp(r11, r12, r13);
        }

        @DoNotInline
        static int noteOpNoThrow(AppOpsManager r10, String r11, int r12, String r13) {
            return r10.noteOpNoThrow(r11, r12, r13);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static <T> T getSystemService(Context r10, Class<T> r11) {
            return (T) r10.getSystemService(r11);
        }

        @DoNotInline
        static int noteProxyOp(AppOpsManager r10, String r11, String r12) {
            return r10.noteProxyOp(r11, r12);
        }

        @DoNotInline
        static int noteProxyOpNoThrow(AppOpsManager r10, String r11, String r12) {
            return r10.noteProxyOpNoThrow(r11, r12);
        }

        @DoNotInline
        static String permissionToOp(String r10) {
            return AppOpsManager.permissionToOp(r10);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static int checkOpNoThrow(@Nullable AppOpsManager r10, @NonNull String r11, int r12, @NonNull String r13) {
            if (r10 != null) goto L6;
            return 1;
        L6:
            return r10.checkOpNoThrow(r11, r12, r13);
        }

        @NonNull
        @DoNotInline
        static String getOpPackageName(@NonNull Context r10) {
            return r10.getOpPackageName();
        }

        @Nullable
        @DoNotInline
        static AppOpsManager getSystemService(@NonNull Context r10) {
            return (AppOpsManager) r10.getSystemService(AppOpsManager.class);
        }
    }

    private AppOpsManagerCompat() {
    }

    public static int checkOrNoteProxyOp(@NonNull Context r10, int r11, @NonNull String r12, @NonNull String r13) {
        if (Build.VERSION.SDK_INT < 29) goto L10;
        AppOpsManager r14 = Api29Impl.getSystemService(r10);
        int r15 = Api29Impl.checkOpNoThrow(r14, r12, Binder.getCallingUid(), r13);
        if (r15 == 0) goto L8;
        return r15;
    L8:
        return Api29Impl.checkOpNoThrow(r14, r12, r11, Api29Impl.getOpPackageName(r10));
    L10:
        return noteProxyOpNoThrow(r10, r12, r13);
    }

    public static int noteOp(@NonNull Context r10, @NonNull String r11, int r12, @NonNull String r13) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 1;
    L5:
        return Api19Impl.noteOp((AppOpsManager) r10.getSystemService("appops"), r11, r12, r13);
    }

    public static int noteOpNoThrow(@NonNull Context r10, @NonNull String r11, int r12, @NonNull String r13) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 1;
    L5:
        return Api19Impl.noteOpNoThrow((AppOpsManager) r10.getSystemService("appops"), r11, r12, r13);
    }

    public static int noteProxyOp(@NonNull Context r10, @NonNull String r11, @NonNull String r12) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return 1;
    L5:
        return Api23Impl.noteProxyOp((AppOpsManager) Api23Impl.getSystemService(r10, AppOpsManager.class), r11, r12);
    }

    public static int noteProxyOpNoThrow(@NonNull Context r10, @NonNull String r11, @NonNull String r12) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return 1;
    L5:
        return Api23Impl.noteProxyOpNoThrow((AppOpsManager) Api23Impl.getSystemService(r10, AppOpsManager.class), r11, r12);
    }

    @Nullable
    public static String permissionToOp(@NonNull String r10) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return null;
    L5:
        return Api23Impl.permissionToOp(r10);
    }
}
