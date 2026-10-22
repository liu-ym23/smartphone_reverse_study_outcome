package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    static class Api19Impl {
        private Api19Impl() {
        }

        static int noteOp(AppOpsManager r0, String r1, int r2, String r3) {
            return r0.noteOp(r1, r2, r3);
        }

        static int noteOpNoThrow(AppOpsManager r0, String r1, int r2, String r3) {
            return r0.noteOpNoThrow(r1, r2, r3);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static <T> T getSystemService(Context r2, Class<T> r3) {
            return (T) ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService(r3);
        }

        static int noteProxyOp(AppOpsManager r0, String r1, String r2) {
            return r0.noteProxyOp(r1, r2);
        }

        static int noteProxyOpNoThrow(AppOpsManager r0, String r1, String r2) {
            return r0.noteProxyOpNoThrow(r1, r2);
        }

        static String permissionToOp(String r0) {
            return AppOpsManager.permissionToOp(r0);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static int checkOpNoThrow(AppOpsManager r0, String r1, int r2, String r3) {
            if (r0 != null) goto L6;
            return 1;
        L6:
            return r0.checkOpNoThrow(r1, r2, r3);
        }

        static String getOpPackageName(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getOpPackageName();
        }

        static AppOpsManager getSystemService(Context r2) {
            return (AppOpsManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService(AppOpsManager.class), AppOpsManager.class, "com.obric.memorydata.plugin");
        }
    }

    private AppOpsManagerCompat() {
    }

    public static int checkOrNoteProxyOp(Context r2, int r3, String r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 29) goto L10;
        AppOpsManager r0 = Api29Impl.getSystemService(r6);
        int r7 = Api29Impl.checkOpNoThrow(r0, r4, Binder.getCallingUid(), r5);
        if (r7 == 0) goto L8;
        return r7;
    L8:
        return Api29Impl.checkOpNoThrow(r0, r4, r3, Api29Impl.getOpPackageName(r6));
    L10:
        return noteProxyOpNoThrow(r6, r4, r5);
    }

    public static int noteOp(Context r3, String r4, int r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 1;
    L5:
        return Api19Impl.noteOp((AppOpsManager) ZeusTransformUtils.preCheckCast(r7.getSystemService("appops"), AppOpsManager.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    public static int noteOpNoThrow(Context r3, String r4, int r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 1;
    L5:
        return Api19Impl.noteOpNoThrow((AppOpsManager) ZeusTransformUtils.preCheckCast(r7.getSystemService("appops"), AppOpsManager.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    public static int noteProxyOp(Context r3, String r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return 1;
    L5:
        return Api23Impl.noteProxyOp((AppOpsManager) ZeusTransformUtils.preCheckCast(Api23Impl.getSystemService(r6, AppOpsManager.class), AppOpsManager.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public static int noteProxyOpNoThrow(Context r3, String r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return 1;
    L5:
        return Api23Impl.noteProxyOpNoThrow((AppOpsManager) ZeusTransformUtils.preCheckCast(Api23Impl.getSystemService(r6, AppOpsManager.class), AppOpsManager.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public static String permissionToOp(String r2) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return null;
    L5:
        return Api23Impl.permissionToOp(r2);
    }
}
