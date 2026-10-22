package a70;

import com.bytedance.android.live.core.setting.d6;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wa1.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final Map<String, Long> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static Long b() {
        Intrinsics.checkNotNullParameter("ColdStrategy_gson", "tag");
        Long r0 = (Long) ((LinkedHashMap) a).get("ColdStrategy_gson");
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
        return Long.valueOf(System.currentTimeMillis() - r1);
    L5:
        return null;
    }

    public static void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Long r0 = (Long) ((LinkedHashMap) a).get(r5);
        if (r0 == null) goto L6;
        e("_MAIN", r5 + " 耗时计时：" + (System.currentTimeMillis() - r0.longValue()));
        return;
    }

    public static void d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        int r1 = d6.a;
        Intrinsics.checkNotNullParameter("SettingReportMonitor_MAIN", "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        wa1.a r0 = d.a;
        Intrinsics.checkNotNullParameter("SettingReportMonitor_MAIN", "tag");
        wa1.a r2 = d.a;
        if (r2 == null) goto L6;
        r2.e(r3);
        return;
    }

    public static void f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        a.put(r3, Long.valueOf(System.currentTimeMillis()));
    }

    public static boolean c(String r4, String r5) {
        if (StringsKt.contains$default(r5, "keva_remote_config_setting_keys", false, 2, null) == false) goto L5;
        return false;
    L5:
        if ((!Intrinsics.areEqual(r4, "_VALUE")) == true) goto L8;
        int r6 = d6.a;
        if (d.b == true) goto L8;
        return false;
    L8:
        return true;
    }

    @JvmStatic
    public static final void e(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (c(r1, r2) == false) goto L6;
        d6.c("SettingReportMonitor".concat(r1), r2);
        return;
    }
}
