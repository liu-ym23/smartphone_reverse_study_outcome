package n60;

import android.content.Context;
import android.hardware.Camera;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bpea.cert.token.TokenCert;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements d {
    public static final TokenCert a = null;

    public b() {
    }

    static {
        a = TokenCert.with("bpea-live_camerachecker_check_camara");
    }

    public static boolean b(TokenCert r7) {
        Field r2 = null;
        int r4 = Camera.getNumberOfCameras();     // Catch: Exception -> L24
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L26;
        Camera.CameraInfo r6 = new Camera.CameraInfo();     // Catch: Exception -> L24
        Camera.getCameraInfo(r5, r6);     // Catch: Exception -> L24
        if (r6.facing == 1) goto L48;
        if (r4 == 1) goto L48;
        r5 = r5 + 1;
    L48:
        Camera r8 = g80.b.b(r5, r7);     // Catch: Exception -> L16 RuntimeException -> L18
        if (r8 != null) goto L54;
    L27:
        if (r8 != null) goto L55;
        return false;
    L55:
        r2 = r8.getClass().getDeclaredField("mHasPermission");     // Catch: NoSuchFieldException -> L31
    L51:
        if (r2 != null) goto L52;
        g80.b.c(r8, r7);
        return true;
    L52:
        r2.setAccessible(true);     // Catch: Throwable -> L39 IllegalAccessException -> L41
        boolean r0 = r2.getBoolean(r8);     // Catch: Throwable -> L39 IllegalAccessException -> L41
        g80.b.c(r8, r7);
        return r0;
    L41:
        e = move-exception;
        ALogger.e("CameraChecker", e);     // Catch: Throwable -> L39
        g80.b.c(r8, r7);
        return true;
    L39:
        th = move-exception;
        g80.b.c(r8, r7);
        throw th;
    L31:
        e = move-exception;
        ALogger.e("CameraChecker", e);
        goto L51
    L54:
        r8.setParameters(r8.getParameters());     // Catch: RuntimeException -> L14 Exception -> L16
    L14:
        e = e;
    L20:
        e.getLocalizedMessage();     // Catch: Exception -> L24
        if (r8 == null) goto L26;
        g80.b.c(r8, r7);     // Catch: Exception -> L24
    L16:
        e = move-exception;
        ALogger.e("CameraChecker", e);     // Catch: Exception -> L24
    L18:
        e = e;
        r8 = null;
    L26:
        r8 = null;
    L24:
        e = move-exception;
        ALogger.e("CameraChecker", e);
        goto L26
    }

    @Override // n60.d
    public final boolean a(Context r1, String r2) {
        return b(a);
    }
}
