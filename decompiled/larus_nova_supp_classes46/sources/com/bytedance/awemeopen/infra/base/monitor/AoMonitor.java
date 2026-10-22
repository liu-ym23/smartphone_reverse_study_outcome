package com.bytedance.awemeopen.infra.base.monitor;

import com.bytedance.awemeopen.infra.base.debug.AoDebug;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AoMonitor {
    public static volatile o64.a a;
    public static volatile LinkedList<b> b;

    public static final enum MonitorType extends Enum<MonitorType> {
        public static final MonitorType CommonLog = null;
        public static final MonitorType Duration = null;
        public static final MonitorType Event = null;
        public static final MonitorType StatusDuration = null;
        public static final MonitorType StatusRate = null;
        public static final /* synthetic */ MonitorType[] a = null;

        static {
            MonitorType r0 = new MonitorType("StatusDuration", 0);
            StatusDuration = r0;
            MonitorType r1 = new MonitorType("StatusRate", 1);
            StatusRate = r1;
            MonitorType r3 = new MonitorType("Duration", 2);
            Duration = r3;
            MonitorType r5 = new MonitorType("CommonLog", 3);
            CommonLog = r5;
            MonitorType r7 = new MonitorType("Event", 4);
            Event = r7;
            a = new MonitorType[]{r0, r1, r3, r5, r7};
        }

        public static MonitorType[] values() {
            return (MonitorType[]) a.clone();
        }

        public static MonitorType valueOf(String r1) {
            return (MonitorType) r27.a.a(MonitorType.class, r1);
        }

        public MonitorType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MonitorType.values().length];
            a = r0;
            r0[MonitorType.StatusDuration.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[MonitorType.StatusRate.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[MonitorType.Duration.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[MonitorType.CommonLog.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[MonitorType.Event.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static class b {
        public final MonitorType a;
        public final String b;
        public final int c;
        public final JSONObject d;
        public final JSONObject e;
        public final String f;
        public final JSONObject g;
        public final JSONObject h;

        public b(MonitorType r1, String r2, int r3, JSONObject r4, JSONObject r5, String r6, JSONObject r7, JSONObject r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            System.currentTimeMillis();
        }
    }

    static {
        b = new LinkedList();
    }

    public static boolean b() {
        if (a != null) goto L5;
    L7:
        return false;
    L5:
        if (b != null) goto L7;
        return true;
    }

    public static void d() {
        if (b() == false) goto L7;
        o64.a r0 = a;
        JSONObject r1 = c(null);
        SDKMonitor r2 = ((g64.a) r0).a;
        if (r2 == null) goto L14;
        r2.monitorStatusRate("ao_special_error", 8, r1);
    L14:
        if (AoDebug.b() == false) goto L17;
        AoLogger.b("AoAppMonitor", new Object[]{"ao_special_error", 8, null});
        return;
    L17:
        return;
    L7:
        AoPool.f(new com.bytedance.awemeopen.infra.base.monitor.a());
        if (b() == false) goto L12;
        o64.a r3 = a;
        JSONObject r4 = c(null);
        SDKMonitor r5 = ((g64.a) r3).a;
        if (r5 == null) goto L14;
        r5.monitorStatusRate("ao_special_error", 8, r4);
        goto L14
    L12:
        AoPool.f(new c(MonitorType.StatusRate, "ao_special_error", 8, c(null), null, null));
        goto L14
    }

    public static JSONObject c(JSONObject r3) {
        JSONObject r0 = new JSONObject();
        r0.put("extra", r3);     // Catch: Exception -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        AoLogger.b("AoAppMonitor", new Object[]{e.getMessage()});
        goto L7
    }

    public static void a(JSONObject r9, JSONObject r10, JSONObject r11) {
        if (b() == false) goto L7;
        o64.a r0 = a;
        JSONObject r1 = c(r11);
        SDKMonitor r2 = ((g64.a) r0).a;
        if (r2 == null) goto L14;
        r2.monitorEvent("ao_settings_write_failed", r9, r10, r1);
    L14:
        if (AoDebug.b() == false) goto L17;
        AoLogger.b("AoAppMonitor", new Object[]{"ao_settings_write_failed", r9, r10, r11});
        return;
    L17:
        return;
    L7:
        AoPool.f(new com.bytedance.awemeopen.infra.base.monitor.a());
        if (b() == false) goto L12;
        o64.a r3 = a;
        JSONObject r4 = c(r11);
        SDKMonitor r5 = ((g64.a) r3).a;
        if (r5 == null) goto L14;
        r5.monitorEvent("ao_settings_write_failed", r9, r10, r4);
        goto L14
    L12:
        AoPool.f(new c(MonitorType.Event, "ao_settings_write_failed", 0, c(r11), r9, r10));
        goto L14
    }
}
