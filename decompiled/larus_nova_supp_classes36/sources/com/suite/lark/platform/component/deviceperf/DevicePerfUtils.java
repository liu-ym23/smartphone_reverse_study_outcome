package com.suite.lark.platform.component.deviceperf;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.CarUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DevicePerfUtils {
    public static String a = "";
    public static a b;

    public static final enum DevicePerfLevel extends Enum<DevicePerfLevel> {
        public static final DevicePerfLevel HIGH = null;
        public static final DevicePerfLevel LOW = null;
        public static final DevicePerfLevel MIDDLE = null;
        public static final DevicePerfLevel ULTRALOW = null;
        public static final DevicePerfLevel UNKNOWN = null;
        public static final /* synthetic */ DevicePerfLevel[] a = null;
        private final String value;

        static {
            DevicePerfLevel r0 = new DevicePerfLevel("UNKNOWN", 0, InvRouter.UNKNOWN);
            UNKNOWN = r0;
            DevicePerfLevel r1 = new DevicePerfLevel("HIGH", 1, "high");
            HIGH = r1;
            DevicePerfLevel r2 = new DevicePerfLevel("MIDDLE", 2, "middle");
            MIDDLE = r2;
            DevicePerfLevel r4 = new DevicePerfLevel("LOW", 3, "low");
            LOW = r4;
            DevicePerfLevel r6 = new DevicePerfLevel("ULTRALOW", 4, "ultralow");
            ULTRALOW = r6;
            a = new DevicePerfLevel[]{r0, r1, r2, r4, r6};
        }

        public static DevicePerfLevel[] values() {
            return (DevicePerfLevel[]) a.clone();
        }

        public String getValue() {
            return this.value;
        }

        public static DevicePerfLevel fromValue(String r2) {
            r2.getClass();
            byte r1 = -1;
            switch(r2.hashCode()) {
                case -1754211288: goto L14;
                case 107348: goto L10;
                case 3202466: goto L6;
                default: goto L17;
            };
        L17:
            switch(r1) {
                case 0: goto L25;
                case 1: goto L23;
                case 2: goto L21;
                default: goto L19;
            };
        L19:
            return MIDDLE;
        L21:
            return HIGH;
        L23:
            return LOW;
        L25:
            return ULTRALOW;
        L6:
            if (r2.equals("high") == false) goto L17;
            r1 = 2;
            goto L17
        L10:
            if (r2.equals("low") == false) goto L17;
            r1 = 1;
            goto L17
        L14:
            if (r2.equals("ultralow") == false) goto L17;
            r1 = 0;
            goto L17
        }

        public static DevicePerfLevel valueOf(String r1) {
            return (DevicePerfLevel) r27.a.a(DevicePerfLevel.class, r1);
        }

        public DevicePerfLevel(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static class a {
        public final double a;
        public final double b;
        public final double c;
        public final double d;
        public final double e;

        public final String toString() {
            return "DevicePerfScore{cpuScore=" + this.a + ", gpuScore=" + this.b + ", ioScore=" + this.c + ", memoryScore=" + this.d + ", overallScore=" + this.e + '}';
        }

        public a(double r1, double r3, double r5, double r7, double r9) {
            this.a = r1;
            this.b = r3;
            this.c = r5;
            this.d = r7;
            this.e = r9;
        }
    }

    public static JSONObject b() {
        JSONObject r1 = new JSONObject();
        r1.put("bytebench", c());     // Catch: Exception -> L5
        r1.put("device_perf_level", "middle");     // Catch: Exception -> L5
    L7:
        Log.i("DevicePerfUtils", "createDefaultByteBenchSetting is : " + r1);
        return r1;
    L5:
        e = move-exception;
        Log.w("DevicePerfUtils", "createDefaultByteBenchSetting exception!", e);
        goto L7
    }

    public static JSONObject c() {
        JSONObject r0 = new JSONObject();
        r0.put("cpu_score", 8.0d);     // Catch: Exception -> L5
        r0.put("gpu_score", 8.0d);     // Catch: Exception -> L5
        r0.put("io_score", 8.0d);     // Catch: Exception -> L5
        r0.put("memory_score", 8.0d);     // Catch: Exception -> L5
        r0.put("overall_score", 8.0d);     // Catch: Exception -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        Log.w("DevicePerfUtils", "createDefaultPerfScore exception!", e);
        goto L7
    }

    public static DevicePerfLevel d() {
        String[] r0 = CarUtils.a;
        String r2 = "middle";
        String r1 = eac.a.a().getString("device_perf_level", "middle");
        if (TextUtils.equals(r1, InvRouter.UNKNOWN) == false) goto L14;
        double r3 = e().e;
        if (r3 < 8.3d) goto L8;
        r2 = "high";
    L16:
        return DevicePerfLevel.fromValue(r2);
    L8:
        if (r3 >= 7.3d) goto L16;
        if (r3 < 5.4d) goto L13;
        r2 = "low";
        goto L16
    L13:
        r2 = "ultralow";
        goto L16
    L14:
        r2 = r1;
        goto L16
    }

    public static a e() {
        String r0 = a;
        monitor-enter(r0);
        String[] r1 = CarUtils.a;     // Catch: Throwable -> L22
        String r2 = eac.a.a().getString("bytebench", "");     // Catch: Throwable -> L22
        if (TextUtils.equals(a, r2) == true) goto L11;
        a = r2;     // Catch: Throwable -> L22
        JSONObject r3 = new JSONObject(a);     // Catch: Exception -> L9 Throwable -> L22
        b = new a(r3.getDouble("cpu_score"), r3.getDouble("gpu_score"), r3.getDouble("io_score"), r3.getDouble("memory_score"), r3.getDouble("overall_score"));     // Catch: Exception -> L9 Throwable -> L22
    L9:
        e = move-exception;
        Log.e("DevicePerfUtils", "byte bench parse error!!", e, true);     // Catch: Throwable -> L22
    L11:
        a r4 = b;     // Catch: Throwable -> L22
        if (r4 != null) goto L14;
    L15:
        JSONObject r5 = c();     // Catch: Throwable -> L22
        if (r5.length() <= 0) goto L18;
        eac.a.a().putString("bytebench", r5.toString());     // Catch: Throwable -> L22
        a = r5.toString();     // Catch: Throwable -> L22
    L18:
        Log.i("DevicePerfUtils", "Local cal device score user default cpuScoreInLocal:8.0 memoryScoreInLocal:8.0 totalScoreLocal: 8.0");     // Catch: Throwable -> L22
        b = new a(8.0d, 8.0d, 8.0d, 8.0d, 8.0d);     // Catch: Throwable -> L22
    L19:
        a r6 = b;     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return r6;
    L14:
        if (r4.e > 0.0d) goto L19;
    L22:
        th = move-exception;
        throw th;
    }

    public static boolean f() {
        if (d().ordinal() < DevicePerfLevel.LOW.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(JSONObject r7) {
        boolean r1 = false;
        String r2 = (String) r7.get("device_perf_level");     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        JSONObject r8 = (JSONObject) r7.get("bytebench");     // Catch: Exception -> L14
        if (r8 != null) goto L9;
    L13:
        r1 = true;
    L16:
        Log.i("DevicePerfUtils", "checkSetting is : " + r1);
        return r1;
    L9:
        if (JSONObjectProtectorUtils.getDouble(r8, "overall_score") != 0.0d) goto L13;
        if (r2.contains("low") == false) goto L13;
    L14:
        e = move-exception;
        Log.w("DevicePerfUtils", "checkSetts exception!", e);
        goto L16
    }
}
