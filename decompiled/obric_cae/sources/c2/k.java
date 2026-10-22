package c2;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f3298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final JSONObject f3299c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, String> f3300d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DefaultHttpServiceImpl f3301e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f3302f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile int f3303g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f3304h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f3305i;

    static {
        f3299c = new JSONObject();
        f3300d = Collections.emptyMap();
        f3301e = new DefaultHttpServiceImpl();
        f3302f = -1;
        f3303g = -1;
    }

    public static String a() {
        if (TextUtils.isEmpty(f3305i) == false) goto L6;
        f3305i = l6.a.P(Process.myPid());
    L6:
        return f3305i;
    }

    public static long b() {
        if (f3302f != (-1)) goto L6;
        f3302f = System.currentTimeMillis();
    L6:
        return f3302f;
    }

    public static String c(long r8) {
        long r10 = r8 - 0;
        if (r10 >= 30000) goto L7;
        return "0 - 30s";
    L7:
        if (r10 >= 60000) goto L11;
        return "30s - 1min";
    L11:
        if (r10 >= 120000) goto L15;
        return "1min - 2min";
    L15:
        if (r10 >= 300000) goto L19;
        return "2min - 5min";
    L19:
        if (r10 >= 600000) goto L23;
        return "5min - 10min";
    L23:
        if (r10 >= 1800000) goto L27;
        return "10min - 30min";
    L27:
        if (r10 >= 3600000) goto L30;
        return "30min - 1h";
    L30:
        return "1h - ";
    }

    public static boolean d() {
        if (f3297a == true) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean e() {
        return f();
    }

    public static boolean f() {
        String r8 = a();
        if (r8 != null) goto L5;
        return true;
    L5:
        if (r8.contains(BdimCategoryConstants.SEPARATOR_COLON) == false) goto L10;
        return false;
    L10:
        return true;
    }
}
