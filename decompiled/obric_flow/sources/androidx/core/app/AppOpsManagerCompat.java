package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
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

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static <T> T getSystemService(Context r5, Class<T> r10) {
            return (T) r5.getSystemService(r10);
        }

        @DoNotInline
        public static int noteProxyOp(AppOpsManager r5, String r10, String r11) {
            return r5.noteProxyOp(r10, r11);
        }

        @DoNotInline
        public static int noteProxyOpNoThrow(AppOpsManager r5, String r10, String r11) {
            return r5.noteProxyOpNoThrow(r10, r11);
        }

        @DoNotInline
        public static String permissionToOp(String r5) {
            return AppOpsManager.permissionToOp(r5);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static int checkOpNoThrow(@Nullable AppOpsManager r5, @NonNull String r10, int r11, @NonNull String r12) {
            if (r5 != null) goto L6;
            return 1;
        L6:
            return r5.checkOpNoThrow(r10, r11, r12);
        }

        @NonNull
        @DoNotInline
        public static String getOpPackageName(@NonNull Context r5) {
            return r5.getOpPackageName();
        }

        @Nullable
        @DoNotInline
        public static AppOpsManager getSystemService(@NonNull Context r5) {
            return (AppOpsManager) r5.getSystemService(AppOpsManager.class);
        }
    }

    private AppOpsManagerCompat() {
    }

    public static int checkOrNoteProxyOp(@NonNull Context r5, int r10, @NonNull String r11, @NonNull String r12) {
        AppOpsManager r13 = Api29Impl.getSystemService(r5);
        int r14 = Api29Impl.checkOpNoThrow(r13, r11, Binder.getCallingUid(), r12);
        if (r14 == 0) goto L6;
        return r14;
    L6:
        return Api29Impl.checkOpNoThrow(r13, r11, r10, Api29Impl.getOpPackageName(r5));
    }

    public static int noteOp(@NonNull Context r5, @NonNull String r10, int r11, @NonNull String r12) {
        return ((AppOpsManager) r5.getSystemService("appops")).noteOp(r10, r11, r12);
    }

    public static int noteOpNoThrow(@NonNull Context r5, @NonNull String r10, int r11, @NonNull String r12) {
        return ((AppOpsManager) r5.getSystemService("appops")).noteOpNoThrow(r10, r11, r12);
    }

    public static int noteProxyOp(@NonNull Context r5, @NonNull String r10, @NonNull String r11) {
        return Api23Impl.noteProxyOp((AppOpsManager) Api23Impl.getSystemService(r5, AppOpsManager.class), r10, r11);
    }

    public static int noteProxyOpNoThrow(@NonNull Context r5, @NonNull String r10, @NonNull String r11) {
        return Api23Impl.noteProxyOpNoThrow((AppOpsManager) Api23Impl.getSystemService(r5, AppOpsManager.class), r10, r11);
    }

    @Nullable
    public static String permissionToOp(@NonNull String r5) {
        return Api23Impl.permissionToOp(r5);
    }
}
