package d5;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.room.writer.DaoWriter;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import td.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f16593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f16594b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f16595c = null;

    static {
        ((com.bytedance.android.anniex.base.depend.b) com.bytedance.android.anniex.base.depend.a.f3113b.getValue()).getClass();
        f16593a = false;
        f16594b = Log.isLoggable("HBMonitorSDK_V2", 3);
        f16595c = new c();
    }

    public static String a(WebView r5) {
        if (r5 != null) goto L6;
        return "null";
    L6:
        return r5.getClass().toString();
    }

    public static String b(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return "HBMonitorSDK_V2";
    L6:
        if (r5.startsWith("HBMonitorSDK_V2") == true) goto L9;
        r5 = "HBMonitorSDK_V2_".concat(r5);
    L9:
        return r5 + "(" + Process.myPid() + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + Process.myTid() + ")";
    }

    public static void c(String r5, String r10) {
        if (f16593a == false) goto L5;
    L6:
        String r11 = b(r5);
        f16595c.getClass();
    L8:
        if (r10.length() <= 3000) goto L16;
        if (c.f16596a == false) goto L12;
    L13:
        Log.d(d.b("NA_", r11), r10.substring(0, PathInterpolatorCompat.MAX_NUM_POINTS));
    L14:
        r10 = r10.substring(PathInterpolatorCompat.MAX_NUM_POINTS);
        goto L8
    L12:
        if (a.b(a.a("d"), r11, r10.substring(0, PathInterpolatorCompat.MAX_NUM_POINTS)) == true) goto L14;
    L16:
        if (c.f16596a == false) goto L18;
    L21:
        Log.d("NA_" + r11, r10);
        return;
    L18:
        if (a.b(a.a("d"), r11, r10) == false) goto L21;
        return;
    L5:
        if (f16594b == true) goto L6;
    }

    public static void d(String r5, String r10, Throwable r11) {
        String r12 = b(r5);
        f16595c.getClass();
        if (c.f16596a == false) goto L5;
    L8:
        Log.e("NA_" + r12, r10, r11);
        return;
    L5:
        if (a.b(a.a("e"), r12, r10) == false) goto L8;
    }

    public static void e(String r5, String r10) {
        String r11 = b(r5);
        f16595c.getClass();
    L4:
        if (r10.length() <= 3000) goto L12;
        if (c.f16596a == false) goto L8;
    L9:
        Log.w(d.b("NA_", r11), r10.substring(0, PathInterpolatorCompat.MAX_NUM_POINTS));
    L10:
        r10 = r10.substring(PathInterpolatorCompat.MAX_NUM_POINTS);
        goto L4
    L8:
        if (a.b(a.a("e"), r11, r10.substring(0, PathInterpolatorCompat.MAX_NUM_POINTS)) == true) goto L10;
    L12:
        if (c.f16596a == false) goto L14;
    L17:
        Log.e("NA_" + r11, r10);
        return;
    L14:
        if (a.b(a.a("e"), r11, r10) == false) goto L17;
    }

    public static void f(String r5, String r10) {
        String r11 = b(r5);
        f16595c.getClass();
    L4:
        if (r10.length() <= 3000) goto L12;
        if (c.f16596a == false) goto L8;
    L9:
        Log.i(d.b("NA_", r11), r10.substring(0, PathInterpolatorCompat.MAX_NUM_POINTS));
    L10:
        r10 = r10.substring(PathInterpolatorCompat.MAX_NUM_POINTS);
        goto L4
    L8:
        if (a.b(a.a("i"), r11, r10.substring(0, PathInterpolatorCompat.MAX_NUM_POINTS)) == true) goto L10;
    L12:
        if (c.f16596a == false) goto L14;
    L17:
        Log.i("NA_" + r11, r10);
        return;
    L14:
        if (a.b(a.a("i"), r11, r10) == false) goto L17;
    }
}
