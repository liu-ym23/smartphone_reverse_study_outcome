package com.bytedance.android.live.core.activity;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.w0;
import com.bytedance.android.live.core.setting.x0;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import om0.c;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ActivityMonitor {
    public static final Boolean a = null;
    public static final Boolean b = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/core/activity/ActivityMonitor$ActivityStatusCode;", "", "", "code", "I", "getCode", "()I", "setCode", "(I)V", "SUCCESS", "UNKNOWN_CODE", "READY", "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ActivityStatusCode extends Enum<ActivityStatusCode> {
        public static final ActivityStatusCode READY = null;
        public static final ActivityStatusCode SUCCESS = null;
        public static final ActivityStatusCode UNKNOWN_CODE = null;
        public static final /* synthetic */ ActivityStatusCode[] a = null;
        private int code;

        static {
            ActivityStatusCode r1 = new ActivityStatusCode("SUCCESS", 0, 1);
            SUCCESS = r1;
            ActivityStatusCode r2 = new ActivityStatusCode("UNKNOWN_CODE", 1, -1);
            UNKNOWN_CODE = r2;
            ActivityStatusCode r3 = new ActivityStatusCode("READY", 2, 2);
            READY = r3;
            a = new ActivityStatusCode[]{r1, r2, r3};
        }

        public static ActivityStatusCode valueOf(String r1) {
            return (ActivityStatusCode) a.a(ActivityStatusCode.class, r1);
        }

        public static ActivityStatusCode[] values() {
            return (ActivityStatusCode[]) a.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public final void setCode(int r1) {
            this.code = r1;
        }

        public ActivityStatusCode(String r1, int r2, int r3) {
            super(r1, r2);
            this.code = r3;
        }
    }

    static {
        a = (Boolean) x0.a.getValue();
        b = (Boolean) w0.a.getValue();
    }

    @JvmStatic
    public static final boolean a() {
        return b.booleanValue();
    }

    @JvmStatic
    public static final void c(String r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r11, "serviceName");
        wm0.a r1 = c.h();
        if (r1 == null) goto L5;
        r1.g(r11, LiveTracingMonitor.EventModule.ACTIVITY.name(), LiveTracingMonitor.EventType.BUSSINESS_API_CALL.name(), r12, r13, r14);
    L6:
        String r15 = "ActivityMonitor_" + r11;
        StringBuilder r0 = new StringBuilder("Activity->");
        r0.append(r12);
        r0.append(":  serviceName= ");
        r0.append(r11);
        r0.append(",extraLog= ");
        if (r14 == null) goto L9;
        String r16 = r14.toString();
    L10:
        r0.append(r16);
        ALogger.i(r15, r0.toString());
        return;
    L9:
        r16 = null;
        goto L10
    L5:
        LiveTracingMonitor.e(r11, LiveTracingMonitor.EventModule.ACTIVITY, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r12, r13, r14);
        goto L6
    }

    @JvmStatic
    public static final void b(String r2, int r3, JSONObject r4, String r5, String r6, JSONObject r7, String r8) {
        LiveMonitor.a r0 = new LiveMonitor.a(r2, LiveTracingMonitor.EventModule.ACTIVITY);
        r0.l(r3);
        r0.e = r4;
        r0.k(r7);
        r0.c(r5);
        r0.d(r6);
        r0.i = true;
        r0.a().report();
        ALogger.i("ActivityMonitor_" + r5, "Activity->" + r5 + ":  serviceName= " + r2 + ", statusCode= " + r3 + ", extraLog= " + r4.toString() + ", categoryPrimary= " + r5 + ", alogJson = " + r8);
    }

    public static /* synthetic */ void d(String r9, int r11, JSONObject r12, String r13, String r14, String r15, int r16) {
        if ((r16 & 16) == 0) goto L5;
        String r6 = "";
    L7:
        if ((r16 & 64) == 0) goto L9;
        String r8 = "";
    L10:
        b(r9, r11, r12, r13, r6, null, r8);
        return;
    L9:
        r8 = r15;
        goto L10
    L5:
        r6 = r14;
        goto L7
    }
}
