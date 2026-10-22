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

    public static int checkCallingOrSelfPermission(@NonNull Context r10, @NonNull String r11) {
        if (Binder.getCallingPid() != Process.myPid()) goto L5;
        String r12 = r10.getPackageName();
    L7:
        return checkPermission(r10, r11, Binder.getCallingPid(), Binder.getCallingUid(), r12);
    L5:
        r12 = null;
        goto L7
    }

    public static int checkCallingPermission(@NonNull Context r10, @NonNull String r11, @Nullable String r12) {
        if (Binder.getCallingPid() != Process.myPid()) goto L7;
        return -1;
    L7:
        return checkPermission(r10, r11, Binder.getCallingPid(), Binder.getCallingUid(), r12);
    }

    public static int checkPermission(@NonNull Context r10, @NonNull String r11, int r12, int r13, @Nullable String r14) {
        if (r10.checkPermission(r11, r12, r13) != (-1)) goto L5;
        return -1;
    L5:
        String r15 = AppOpsManagerCompat.permissionToOp(r11);
        if (r15 != null) goto L8;
        return 0;
    L8:
        if (r14 != null) goto L16;
        String[] r16 = r10.getPackageManager().getPackagesForUid(r13);
        if (r16 != null) goto L12;
    L15:
        return -1;
    L12:
        if (r16.length <= 0) goto L15;
        r14 = r16[0];
    L16:
        int r17 = Process.myUid();
        String r18 = r10.getPackageName();
        if (r17 == r13) goto L19;
    L21:
        boolean r19 = false;
    L22:
        if (r19 == false) goto L24;
        int r20 = AppOpsManagerCompat.checkOrNoteProxyOp(r10, r13, r15, r14);
    L25:
        if (r20 == 0) goto L29;
        return -2;
    L29:
        return 0;
    L24:
        r20 = AppOpsManagerCompat.noteProxyOpNoThrow(r10, r15, r14);
        goto L25
    L19:
        if (ObjectsCompat.equals(r18, r14) == false) goto L21;
        r19 = true;
        goto L22
    }

    public static int checkSelfPermission(@NonNull Context r10, @NonNull String r11) {
        return checkPermission(r10, r11, Process.myPid(), Process.myUid(), r10.getPackageName());
    }
}
