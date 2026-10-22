package androidx.core.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.util.ObjectsCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class PermissionChecker {
    public static final int PERMISSION_DENIED = -1;
    public static final int PERMISSION_DENIED_APP_OP = -2;
    public static final int PERMISSION_GRANTED = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionResult {
    }

    private PermissionChecker() {
    }

    public static int checkCallingOrSelfPermission(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Binder.getCallingPid() != Process.myPid()) goto L5;
        String r0 = r5.getPackageName();
    L7:
        return checkPermission(r5, r4, Binder.getCallingPid(), Binder.getCallingUid(), r0);
    L5:
        r0 = null;
        goto L7
    }

    public static int checkCallingPermission(Context r2, String r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Binder.getCallingPid() != Process.myPid()) goto L7;
        return -1;
    L7:
        return checkPermission(r5, r3, Binder.getCallingPid(), Binder.getCallingUid(), r4);
    }

    public static int checkPermission(Context r2, String r3, int r4, int r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r7.checkPermission(r3, r4, r5) != (-1)) goto L5;
        return -1;
    L5:
        String r8 = AppOpsManagerCompat.permissionToOp(r3);
        if (r8 != null) goto L8;
        return 0;
    L8:
        if (r6 != null) goto L16;
        String[] r9 = r7.getPackageManager().getPackagesForUid(r5);
        if (r9 != null) goto L12;
    L15:
        return -1;
    L12:
        if (r9.length <= 0) goto L15;
        r6 = r9[0];
    L16:
        int r0 = Process.myUid();
        String r1 = r7.getPackageName();
        if (r0 == r5) goto L19;
    L21:
        boolean r10 = false;
    L22:
        if (r10 == false) goto L24;
        int r11 = AppOpsManagerCompat.checkOrNoteProxyOp(r7, r5, r8, r6);
    L25:
        if (r11 == 0) goto L29;
        return -2;
    L29:
        return 0;
    L24:
        r11 = AppOpsManagerCompat.noteProxyOpNoThrow(r7, r8, r6);
        goto L25
    L19:
        if (ObjectsCompat.equals(r1, r6) == false) goto L21;
        r10 = true;
        goto L22
    }

    public static int checkSelfPermission(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        return checkPermission(r5, r4, Process.myPid(), Process.myUid(), r5.getPackageName());
    }
}
