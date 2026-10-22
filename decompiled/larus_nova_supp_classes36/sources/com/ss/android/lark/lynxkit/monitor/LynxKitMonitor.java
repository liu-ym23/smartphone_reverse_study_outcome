package com.ss.android.lark.lynxkit.monitor;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LynxKitMonitor {
    public static final LynxKitMonitor a = null;
    public static final Set<String> b = null;
    public static final Set<String> c = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/lynxkit/monitor/LynxKitMonitor$MonitorCode;", "", "status", "", "eventCode", INotificationHitPoint.NoticeType.MESSAGE, "", "<init>", "(Ljava/lang/String;IIILjava/lang/String;)V", "getStatus", "()I", "getEventCode", "getMessage", "()Ljava/lang/String;", "LYNX_PAGE_START", "LYNX_LOAD_SUCCESS", "LYNX_FIRST_SCREEN_SUCCESS", "LYNX_ERROR", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum MonitorCode extends Enum<MonitorCode> {
        public static final MonitorCode LYNX_ERROR = null;
        public static final MonitorCode LYNX_FIRST_SCREEN_SUCCESS = null;
        public static final MonitorCode LYNX_LOAD_SUCCESS = null;
        public static final MonitorCode LYNX_PAGE_START = null;
        public static final /* synthetic */ MonitorCode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int eventCode;
        private final String message;
        private final int status;

        public static EnumEntries<MonitorCode> getEntries() {
            return b;
        }

        static {
            MonitorCode r6 = new MonitorCode("LYNX_PAGE_START", 0, 1, 10001, "lynx container start load");
            LYNX_PAGE_START = r6;
            MonitorCode r0 = new MonitorCode("LYNX_LOAD_SUCCESS", 1, 2, 10002, "lynx load success");
            LYNX_LOAD_SUCCESS = r0;
            MonitorCode r1 = new MonitorCode("LYNX_FIRST_SCREEN_SUCCESS", 2, 3, 10003, "lynx first screen render success");
            LYNX_FIRST_SCREEN_SUCCESS = r1;
            MonitorCode r2 = new MonitorCode("LYNX_ERROR", 3, 4, 10004, "lynx load failed");
            LYNX_ERROR = r2;
            MonitorCode[] r3 = {r6, r0, r1, r2};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static MonitorCode[] values() {
            return (MonitorCode[]) a.clone();
        }

        public final int getEventCode() {
            return this.eventCode;
        }

        public final String getMessage() {
            return this.message;
        }

        public final int getStatus() {
            return this.status;
        }

        public static MonitorCode valueOf(String r1) {
            return (MonitorCode) r27.a.a(MonitorCode.class, r1);
        }

        public MonitorCode(String r1, int r2, int r3, int r4, String r5) {
            super(r1, r2);
            this.status = r3;
            this.eventCode = r4;
            this.message = r5;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/lynxkit/monitor/LynxKitMonitor$TimingType;", "", "<init>", "(Ljava/lang/String;I)V", "SETUP_TIMING", "UPDATE_TIMING", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum TimingType extends Enum<TimingType> {
        public static final TimingType SETUP_TIMING = null;
        public static final TimingType UPDATE_TIMING = null;
        public static final /* synthetic */ TimingType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<TimingType> getEntries() {
            return b;
        }

        static {
            TimingType r0 = new TimingType("SETUP_TIMING", 0);
            SETUP_TIMING = r0;
            TimingType r1 = new TimingType("UPDATE_TIMING", 1);
            UPDATE_TIMING = r1;
            TimingType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static TimingType[] values() {
            return (TimingType[]) a.clone();
        }

        public static TimingType valueOf(String r1) {
            return (TimingType) r27.a.a(TimingType.class, r1);
        }

        public TimingType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public LynxKitMonitor() {
    }

    static {
        a = new LynxKitMonitor();
        b = SetsKt.setOf(new String[]{"trace_id", "container_type", "timing_type", "timing", "error_code", "error_msg", "monitor_domain", INotificationHitPoint.NoticeType.MESSAGE, "event_code", "template_url", "template_path", "page_url", "render_source", "tag_for_template_loader", "tag_for_js_module", "tag_for_bridge_method_dispatcher", "tag_for_bridge_method_group", "tag_for_custom_component"});
        c = SetsKt.setOf(new String[]{"biz", "biz_id", "biz_name", "biz_type", "business", "business_id", "business_name", "scene", "source", "module", "feature", "app_id", "app_type"});
    }

    public static boolean a(Number r2) {
        if ((r2 instanceof Double) == false) goto L10;
        if (Double.isNaN(r2.doubleValue()) == false) goto L7;
    L16:
        return false;
    L7:
        if (Double.isInfinite(r2.doubleValue()) == true) goto L16;
    L17:
        return true;
    L10:
        if ((r2 instanceof Float) == false) goto L17;
        if (Float.isNaN(r2.floatValue()) == true) goto L16;
        if (Float.isInfinite(r2.floatValue()) == true) goto L16;
        goto L16
    }

    public static JSONObject k(Map r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) r4.next();
        if (r1.getValue() == null) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
        r0.put(r1.getKey(), r1.getValue());
        goto L4
    L8:
        r2 = false;
        goto L9
    L12:
        if (r0.isEmpty() == false) goto L19;
        return null;
    L19:
        return new JSONObject(r0);
    L16:
        th = move-exception;
        Log.e("LynxKitMonitor", "build monitor json failed", th);
        return null;
    }

    public static Map l(b r6) {
        Pair[] r0 = new Pair[9];
        String r1 = null;
        if (r6 == null) goto L7;
        String r2 = r6.a;
        if (r2 == null) goto L7;
        String r3 = m(r2);
    L8:
        r0[0] = TuplesKt.to("template_url", r3);
        if (r6 == null) goto L13;
        String r4 = r6.b;
        if (r4 == null) goto L13;
        String r5 = m(r4);
    L14:
        r0[1] = TuplesKt.to("template_path", r5);
        if (r6 == null) goto L19;
        String r7 = r6.c;
        if (r7 == null) goto L19;
        String r8 = m(r7);
    L20:
        r0[2] = TuplesKt.to("page_url", r8);
        if (r6 == null) goto L23;
        String r9 = r6.d;
    L24:
        r0[3] = TuplesKt.to("render_source", r9);
        if (r6 == null) goto L27;
        String r10 = r6.e;
    L28:
        r0[4] = TuplesKt.to("tag_for_template_loader", r10);
        if (r6 == null) goto L31;
        String r11 = r6.f;
    L32:
        r0[5] = TuplesKt.to("tag_for_js_module", r11);
        if (r6 == null) goto L35;
        String r12 = r6.g;
    L36:
        r0[6] = TuplesKt.to("tag_for_bridge_method_dispatcher", r12);
        if (r6 == null) goto L39;
        String r13 = r6.h;
    L40:
        r0[7] = TuplesKt.to("tag_for_bridge_method_group", r13);
        if (r6 == null) goto L43;
        r1 = r6.i;
    L43:
        r0[8] = TuplesKt.to("tag_for_custom_component", r1);
        Map r14 = MapsKt.mapOf(r0);
        LinkedHashMap r15 = new LinkedHashMap();
        Iterator r16 = r14.entrySet().iterator();
    L45:
        if (r16.hasNext() == false) goto L52;
        Map.Entry r17 = (Map.Entry) r16.next();
        if (((String) r17.getValue()) == null) goto L49;
        boolean r18 = true;
    L50:
        if (r18 == false) goto L45;
        r15.put(r17.getKey(), r17.getValue());
        goto L45
    L49:
        r18 = false;
        goto L50
    L52:
        return r15;
    L39:
        r13 = null;
        goto L40
    L35:
        r12 = null;
        goto L36
    L31:
        r11 = null;
        goto L32
    L27:
        r10 = null;
        goto L28
    L23:
        r9 = null;
    L19:
        r8 = null;
    L13:
        r5 = null;
    L7:
        r3 = null;
        goto L8
    }

    public static String m(String r11) {
        Integer r0 = Integer.valueOf(StringsKt.indexOf$default(r11, '?', 0, false, 6, null));
        boolean r3 = true;
        if (r0.intValue() < 0) goto L5;
        boolean r1 = true;
    L6:
        Integer r4 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        int r2 = r0.intValue();
    L13:
        Integer r5 = Integer.valueOf(StringsKt.indexOf$default(r11, '#', 0, false, 6, null));
        if (r5.intValue() >= 0) goto L17;
        r3 = false;
    L17:
        if (r3 == false) goto L19;
        r4 = r5;
    L19:
        if (r4 == null) goto L21;
        int r6 = r4.intValue();
    L23:
        return r11.substring(0, Math.min(r2, r6));
    L21:
        r6 = r11.length();
        goto L23
    L12:
        r2 = r11.length();
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    public static void f(Map r3, JSONObject r4) {
        Iterator r5 = r3.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L26;
        Map.Entry r0 = (Map.Entry) r5.next();
        Object r1 = r0.getKey();
        Object r2 = r0.getValue();
        if (r1 == null) goto L4;
        String r6 = r1.toString();
        if (r6 == null) goto L4;
        if (r6.length() <= 0) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == true) goto L16;
        r6 = null;
    L16:
        if (r6 == null) goto L4;
        if (Intrinsics.areEqual(r6, "count") == true) goto L4;
        if ((r2 instanceof Number) == false) goto L4;
        if (a((Number) r2) == false) goto L4;
        r4.put(r6, r2);
        goto L4
    L12:
        r7 = false;
        goto L13
    }

    public static void g(Map r3, JSONObject r4) {
        Iterator r5 = r3.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        Map.Entry r0 = (Map.Entry) r5.next();
        String r1 = (String) r0.getKey();
        Object r2 = r0.getValue();
        if (Intrinsics.areEqual(r1, "count") == true) goto L4;
        if ((r2 instanceof Number) == false) goto L4;
        if (a((Number) r2) == false) goto L4;
        r4.put(r1, r2);
        goto L4
    }

    public static void h(Map r4, Map r5) {
        Iterator r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L28;
        Map.Entry r0 = (Map.Entry) r6.next();
        String r1 = (String) r0.getKey();
        Object r2 = r0.getValue();
        if (Intrinsics.areEqual(r1, "trace_id") == true) goto L4;
        if (c.contains(r1) == false) goto L4;
        if ((r2 instanceof String) == false) goto L13;
    L14:
        boolean r3 = true;
    L19:
        if (r3 == false) goto L4;
        if (b.contains(r1) == true) goto L27;
        if (r4.containsKey(r1) == true) goto L27;
        r4.put(r1, r2);
    L27:
        r4.put("biz_" + r1, r2);
        goto L4
    L13:
        if ((r2 instanceof Boolean) == true) goto L14;
        if ((r2 instanceof Number) == false) goto L18;
        r3 = a((Number) r2);
        goto L19
    L18:
        r3 = false;
        goto L19
    }

    public final void d(ILynxContainerContext r7, b r8) {
        j(this, MonitorCode.LYNX_LOAD_SUCCESS, r7, r8, null, 24);
    }

    public final void e(ILynxContainerContext r7, b r8) {
        j(this, MonitorCode.LYNX_PAGE_START, r7, r8, null, 24);
    }

    public static void c(ILynxContainerContext r3, TimingType r4, Map r5, b r6) {
        Intrinsics.checkNotNullParameter(r4, "timingType");
        MonitorCode r0 = MonitorCode.LYNX_FIRST_SCREEN_SUCCESS;
        Map r7 = MapsKt.mapOf(new Pair[]{TuplesKt.to("timing_type", Integer.valueOf(r4.ordinal())), TuplesKt.to("timing", r5)});
        if (r5 != null) goto L5;
        r5 = MapsKt.emptyMap();
    L5:
        i(r0, r3, r6, r7, r5);
    }

    public final void b(ILynxContainerContext r7, Integer r8, String r9, b r10) {
        j(this, MonitorCode.LYNX_ERROR, r7, r10, MapsKt.mapOf(new Pair[]{TuplesKt.to("error_code", r8), TuplesKt.to("error_msg", r9)}), 16);
    }

    public static void i(MonitorCode r9, ILynxContainerContext r10, b r11, Map r12, Map r13) {
        JSONObject r1 = null;
        if (r10 != null) goto L53;
        Map<String, Object> r3 = null;
    L8:
        if (r3 != null) goto L12;
        r3 = MapsKt.emptyMap();     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        Log.e("LynxKitMonitor", "get biz extra failed", th);     // Catch: Throwable -> L47
        r3 = MapsKt.emptyMap();     // Catch: Throwable -> L47
    L12:
        Pair[] r4 = new Pair[4];     // Catch: Throwable -> L47
        boolean r6 = false;
        r4[0] = TuplesKt.to("monitor_domain", "lynx_container_load");     // Catch: Throwable -> L47
        r4[1] = TuplesKt.to(INotificationHitPoint.NoticeType.MESSAGE, r9.getMessage());     // Catch: Throwable -> L47
        r4[2] = TuplesKt.to("event_code", Integer.valueOf(r9.getEventCode()));     // Catch: Throwable -> L47
        if (r10 != null) goto L50;
    L18:
        String r14 = null;
    L19:
        r4[3] = TuplesKt.to("container_type", r14);     // Catch: Throwable -> L47
        Map r15 = MapsKt.mutableMapOf(r4);     // Catch: Throwable -> L47
        Object r5 = r3.get("trace_id");     // Catch: Throwable -> L47
        if ((r5 instanceof String) == false) goto L23;
    L24:
        r6 = true;
    L28:
        if (r6 == false) goto L30;
        r15.put("trace_id", r5);     // Catch: Throwable -> L47
    L30:
        h(r15, r3);     // Catch: Throwable -> L47
        r15.putAll(l(r11));     // Catch: Throwable -> L47
        r15.putAll(r12);     // Catch: Throwable -> L47
        ILynxKitMonitorReporter r16 = c.a;     // Catch: Throwable -> L47
        int r17 = r9.getStatus();     // Catch: Throwable -> L47
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L39
        r18.put("count", 1);     // Catch: Throwable -> L39
        Object r0 = r13.get("metrics");     // Catch: Throwable -> L39
        if ((r0 instanceof Map) == false) goto L34;
        Map r2 = (Map) r0;     // Catch: Throwable -> L39
    L35:
        if (r2 == null) goto L37;
        f(r2, r18);     // Catch: Throwable -> L39
    L38:
        r1 = r18;
    L55:
        c.a.report("lark_lynx_kit_container_lifecycle", r17, r1, k(r15));     // Catch: Throwable -> L44
    L58:
        return;
    L44:
        th = move-exception;
        Log.e("LynxKitMonitorReporterRegistry", "report failed", th);     // Catch: Throwable -> L47
        return;
    L37:
        g(r13, r18);     // Catch: Throwable -> L39
        goto L38
    L34:
        r2 = null;
    L39:
        th = move-exception;
        Log.e("LynxKitMonitor", "build monitor duration failed", th);     // Catch: Throwable -> L47
        goto L55
    L23:
        if ((r5 instanceof Boolean) == true) goto L24;
        if ((r5 instanceof Number) == false) goto L28;
        r6 = a((Number) r5);     // Catch: Throwable -> L47
        goto L28
    L50:
        r14 = r10.getContainerType();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Log.e("LynxKitMonitor", "get container type failed", th);     // Catch: Throwable -> L47
        goto L18
    L53:
        r3 = r10.getBizExtra();     // Catch: Throwable -> L5
    L47:
        th = move-exception;
        Log.e("LynxKitMonitor", "report monitor failed", th);
    }

    public static /* synthetic */ void j(LynxKitMonitor r1, MonitorCode r2, ILynxContainerContext r3, b r4, Map r5, int r6) {
        if ((r6 & 8) == 0) goto L6;
        r5 = MapsKt.emptyMap();
    L6:
        if ((r6 & 16) == 0) goto L8;
        Map r7 = MapsKt.emptyMap();
    L9:
        r1.getClass();
        i(r2, r3, r4, r5, r7);
        return;
    L8:
        r7 = null;
        goto L9
    }
}
