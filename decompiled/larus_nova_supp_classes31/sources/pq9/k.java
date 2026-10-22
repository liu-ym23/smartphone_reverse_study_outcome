package pq9;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.platform.api.c4;
import com.larus.platform.model.camera.ve.Ratio;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k {
    public static final k a = null;
    public static final Pair<Integer, Integer> b = null;
    public static final Pair<Integer, Integer> c = null;
    public static final Pair<Integer, Integer> d = null;
    public static final String e = null;
    public static final String f = null;
    public static final String g = null;
    public static final String h = null;
    public static final String i = null;

    public k() {
    }

    static {
        a = new k();
        b = new Pair(1440, 2560);
        c = new Pair(1080, 1920);
        d = new Pair(720, 1280);
        StringBuilder r0 = new StringBuilder();
        c4.a.getClass();
        r0.append(c4.a.a());
        r0.append("/model");
        File r1 = b(r0.toString());
        if (r1 == null) goto L5;
        r1.getPath();
    L5:
        File r2 = b(c4.a.a() + "/camera");
        String r3 = null;
        if (r2 == null) goto L8;
        String r4 = r2.getPath();
    L9:
        String r5 = "";
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        e = r4;
        File r6 = b(r4.concat("/photo"));
        if (r6 == null) goto L15;
        String r7 = r6.getPath();
    L16:
        if (r7 != null) goto L18;
        r7 = "";
    L18:
        f = r7;
        File r8 = b(r4.concat("/video"));
        if (r8 == null) goto L21;
        String r9 = r8.getPath();
    L22:
        if (r9 != null) goto L24;
        r9 = "";
    L24:
        g = r9;
        File r10 = b(c4.a.a() + "/transition");
        if (r10 == null) goto L27;
        r3 = r10.getPath();
    L27:
        if (r3 == null) goto L30;
        r5 = r3;
    L30:
        h = r5;
        i = r5.concat("/transition_temp.jpg");
        return;
    L21:
        r9 = null;
        goto L22
    L15:
        r7 = null;
        goto L16
    L8:
        r4 = null;
        goto L9
    }

    public static String a(Ratio r2) {
        Intrinsics.checkNotNullParameter(r2, "ratio");
        if (r2 != Ratio.RATIO_3_4) goto L7;
        return h + "/transition.jpg";
    L7:
        return h + '/' + r2.name() + "_transition.jpg";
    }

    public static File b(String r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        PolarisFileWrapper r1 = new PolarisFileWrapper(r5);     // Catch: Throwable -> L7
        if (r1.exists() == true) goto L5;
        r1.mkdirs();     // Catch: Throwable -> L7
    L5:
        Object r2 = Result.constructor-impl(r1);     // Catch: Throwable -> L7
    L9:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L13;
        FLogger.a.e("VeCameraConstants", "path:" + r5 + ", error:" + r3.getMessage());
    L13:
        if (Result.isFailure-impl(r2) == false) goto L16;
        r2 = null;
    L16:
        return (File) r2;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }
}
