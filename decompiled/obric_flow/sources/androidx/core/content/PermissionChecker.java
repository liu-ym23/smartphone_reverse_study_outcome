package androidx.core.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.util.ObjectsCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class PermissionChecker {
    public static final int PERMISSION_DENIED = -1;
    public static final int PERMISSION_DENIED_APP_OP = -2;
    public static final int PERMISSION_GRANTED = 0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface PermissionResult {
    }

    private PermissionChecker() {
    }

    public static int checkCallingOrSelfPermission(@NonNull Context r5, @NonNull String r10) {
        if (Binder.getCallingPid() != Process.myPid()) goto L5;
        String r11 = r5.getPackageName();
    L7:
        return checkPermission(r5, r10, Binder.getCallingPid(), Binder.getCallingUid(), r11);
    L5:
        r11 = null;
        goto L7
    }

    public static int checkCallingPermission(@NonNull Context r5, @NonNull String r10, @Nullable String r11) {
        if (Binder.getCallingPid() != Process.myPid()) goto L7;
        return -1;
    L7:
        return checkPermission(r5, r10, Binder.getCallingPid(), Binder.getCallingUid(), r11);
    }

    public static int checkPermission(@NonNull Context r5, @NonNull String r10, int r11, int r12, @Nullable String r13) {
        if (r5.checkPermission(r10, r11, r12) != (-1)) goto L5;
        return -1;
    L5:
        String r14 = AppOpsManagerCompat.permissionToOp(r10);
        if (r14 != null) goto L8;
        return 0;
    L8:
        if (r13 != null) goto L16;
        String[] r15 = r5.getPackageManager().getPackagesForUid(r12);
        if (r15 != null) goto L12;
    L15:
        return -1;
    L12:
        if (r15.length <= 0) goto L15;
        r13 = r15[0];
    L16:
        int r16 = Process.myUid();
        String r17 = r5.getPackageName();
        if (r16 == r12) goto L19;
    L21:
        int r18 = AppOpsManagerCompat.noteProxyOpNoThrow(r5, r14, r13);
    L22:
        if (r18 == 0) goto L26;
        return -2;
    L26:
        return 0;
    L19:
        if (ObjectsCompat.equals(r17, r13) == false) goto L21;
        r18 = AppOpsManagerCompat.checkOrNoteProxyOp(r5, r12, r14, r13);
        goto L22
    }

    public static int checkSelfPermission(@NonNull Context r5, @NonNull String r10) {
        return checkPermission(r5, r10, Process.myPid(), Process.myUid(), r5.getPackageName());
    }
}
