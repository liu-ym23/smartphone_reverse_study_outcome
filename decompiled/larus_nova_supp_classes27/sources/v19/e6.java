package v19;

import android.os.Build;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.g3;
import com.larus.platform.service.i2;
import com.larus.platform.service.k2;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e6 {
    public static final e6 a = null;

    static {
        a = new e6();
    }

    public e6() {
    }

    public static String a() {
        Object r0 = "disable";
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L22
        k2 r3 = k2.a;     // Catch: Throwable -> L22
        if (g3.a.d() == false) goto L7;
        FLogger.a.i("PermissionStatusHelper", "getAlbumStatus() = open");     // Catch: Throwable -> L22
        Object r4 = Result.constructor-impl("open");     // Catch: Throwable -> L22
    L24:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 != null) goto L27;
        r0 = r4;
    L29:
        return (String) r0;
    L27:
        FLogger.a.e("PermissionStatusHelper", "getAlbumStatus error", r5);
        goto L29
    L7:
        if (Build.VERSION.SDK_INT < 33) goto L9;
        String r6 = "android.permission.READ_MEDIA_IMAGES";
    L30:
        Object r7 = Result.constructor-impl(Boolean.valueOf(i2.b.d(r6)));     // Catch: Throwable -> L12
    L14:
        Boolean r8 = Boolean.FALSE;     // Catch: Throwable -> L22
        if (Result.isFailure-impl(r7) == false) goto L18;
        r7 = r8;
    L18:
        if (((Boolean) r7).booleanValue() == true) goto L33;
        return "request_authorization";
    L33:
        return "disable";
    L12:
        th = move-exception;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L22
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L22
        goto L14
    L9:
        r6 = "android.permission.READ_EXTERNAL_STORAGE";
    L22:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }

    public final String b() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        String r3 = d(this, "android.permission.CAMERA", "camera_disable", "camera_open", 2);     // Catch: Throwable -> L5
        FLogger.a.i("PermissionStatusHelper", "getCameraStatus() = " + r3);     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(r3);     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.exceptionOrNull-impl(r1);
        if (r4 == null) goto L12;
        FLogger.a.e("PermissionStatusHelper", "getCameraStatus error", r4);
        r1 = "request_authorization";
    L12:
        return (String) r1;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final String c() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        String r3 = d(this, "android.permission.RECORD_AUDIO", null, null, 14);     // Catch: Throwable -> L5
        FLogger.a.i("PermissionStatusHelper", "getMicStatus() = " + r3);     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(r3);     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.exceptionOrNull-impl(r1);
        if (r4 == null) goto L12;
        FLogger.a.e("PermissionStatusHelper", "getMicStatus error", r4);
        r1 = "disable";
    L12:
        return (String) r1;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static String d(e6 r2, String r3, String r4, String r5, int r6) {
        if ((r6 & 2) == 0) goto L5;
        String r0 = "request_authorization";
    L7:
        if ((r6 & 4) == 0) goto L10;
        r4 = "disable";
    L10:
        if ((r6 & 8) == 0) goto L12;
        r5 = "open";
    L12:
        r2.getClass();
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), r3) != 0) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == true) goto L32;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L20
        Object r9 = Result.constructor-impl(Boolean.valueOf(i2.b.d(r3)));     // Catch: Throwable -> L20
    L22:
        Boolean r10 = Boolean.FALSE;
        if (Result.isFailure-impl(r9) == false) goto L26;
        r9 = r10;
    L26:
        if (((Boolean) r9).booleanValue() == false) goto L29;
        r0 = r4;
    L29:
        return r0;
    L20:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L32:
        return r5;
    L15:
        r7 = false;
        goto L16
    L5:
        r0 = null;
        goto L7
    }
}
