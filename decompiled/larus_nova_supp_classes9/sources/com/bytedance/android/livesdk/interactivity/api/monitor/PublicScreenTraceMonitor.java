package com.bytedance.android.livesdk.interactivity.api.monitor;

import android.util.Log;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import com.bytedance.android.livesdk.interactivity.service.monitor.f;
import com.bytedance.bdlocation.BuildConfig;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r52.w3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PublicScreenTraceMonitor implements f {
    public static final s0 a = null;
    public static final Map<String, String> b = null;
    public static final SimpleDateFormat c = null;
    public static final Map<String, String> d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final PublicScreenTraceMonitor h = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitor/PublicScreenTraceMonitor$AdjustStep;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "step", "Ljava/lang/String;", "getStep", "()Ljava/lang/String;", "REQUEST", "INTERCEPT", "CALCUATE", "DROP", "RESULT", "POST_PROCESSOR", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AdjustStep extends Enum<AdjustStep> {
        public static final AdjustStep CALCUATE = null;
        public static final AdjustStep DROP = null;
        public static final AdjustStep INTERCEPT = null;
        public static final AdjustStep POST_PROCESSOR = null;
        public static final AdjustStep REQUEST = null;
        public static final AdjustStep RESULT = null;
        public static final /* synthetic */ AdjustStep[] a = null;
        private final String step;

        static {
            AdjustStep r1 = new AdjustStep("REQUEST", 0, "request");
            REQUEST = r1;
            AdjustStep r2 = new AdjustStep("INTERCEPT", 1, "intercept");
            INTERCEPT = r2;
            AdjustStep r3 = new AdjustStep("CALCUATE", 2, "caculate");
            CALCUATE = r3;
            AdjustStep r4 = new AdjustStep("DROP", 3, "drop");
            DROP = r4;
            AdjustStep r5 = new AdjustStep("RESULT", 4, "result");
            RESULT = r5;
            AdjustStep r6 = new AdjustStep("POST_PROCESSOR", 5, "post_processor");
            POST_PROCESSOR = r6;
            a = new AdjustStep[]{r1, r2, r3, r4, r5, r6};
        }

        public static AdjustStep valueOf(String r1) {
            return (AdjustStep) r27.a.a(AdjustStep.class, r1);
        }

        public static AdjustStep[] values() {
            return (AdjustStep[]) a.clone();
        }

        public final String getStep() {
            return this.step;
        }

        public AdjustStep(String r1, int r2, String r3) {
            super(r1, r2);
            this.step = r3;
        }
    }

    public PublicScreenTraceMonitor() {
    }

    public static Queue b() {
        return (Queue) e.getValue();
    }

    public static Queue c() {
        return (Queue) f.getValue();
    }

    public static Queue d() {
        return (Queue) g.getValue();
    }

    static {
        h = new PublicScreenTraceMonitor();
        a = (s0) w3.a.getValue();
        b = new LinkedHashMap();
        c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
        d = new LinkedHashMap();
        e = LazyKt.lazy(PublicScreenTraceMonitor$fifoQueue$2.INSTANCE);
        f = LazyKt.lazy(PublicScreenTraceMonitor$giftMaskRecordQueue$2.INSTANCE);
        g = LazyKt.lazy(PublicScreenTraceMonitor$giftMessageRecordQueue$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.monitor.f
    public final void a() {
        if (a.monitorAdjustLayout == false) goto L13;
        if (b().isEmpty() == true) goto L13;
        String r0 = CollectionsKt.joinToString$default(b(), null, null, null, 0, null, null, 63, null);     // Catch: Exception -> L10
        LinkedHashMap r7 = new LinkedHashMap();     // Catch: Exception -> L10
        r7.put("info", r0);     // Catch: Exception -> L10
        Unit r1 = Unit.INSTANCE;     // Catch: Exception -> L10
        c r2 = new c(0, null, 0, r7, 7);     // Catch: Exception -> L10
        b().clear();     // Catch: Exception -> L10
        ALogger.i("ttlive_public_screen_adjust_layout", r2.toString());     // Catch: Exception -> L10
        r2.b(InteractivityTraceMonitor.Event.PublicScreenAdjustLayout);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        ALogger.e("ttlive_public_screen_adjust_layout_error", e);
    L13:
        if (a.monitorGiftTrayMask == false) goto L23;
        if (c().isEmpty() == true) goto L23;
        String r3 = CollectionsKt.joinToString$default(c(), null, null, null, 0, null, null, 63, null);     // Catch: Exception -> L20
        LinkedHashMap r8 = new LinkedHashMap();     // Catch: Exception -> L20
        r8.put("maskRecord", r3);     // Catch: Exception -> L20
        Unit r4 = Unit.INSTANCE;     // Catch: Exception -> L20
        c r5 = new c(0, null, 0, r8, 7);     // Catch: Exception -> L20
        c().clear();     // Catch: Exception -> L20
        ALogger.i("ttlive_public_screen_mask_event_record", r5.toString());     // Catch: Exception -> L20
        r5.b(InteractivityTraceMonitor.Event.PublicScreenMaskEvent);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        ALogger.e("ttlive_public_screen_record_mask_event", e);
    L23:
        if (a.monitorSelfGiftEvent == true) goto L26;
        return;
    L26:
        if (d().isEmpty() == true) goto L35;
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put("info", CollectionsKt.joinToString$default(d(), null, null, null, 0, null, null, 63, null));
        Unit r6 = Unit.INSTANCE;
        c r10 = new c(0, null, 0, r9, 7);
        d().clear();
        r10.b(InteractivityTraceMonitor.Event.PublicScreenSelfGiftEvent);
        return;
    }

    public static void e(String r8) {
        if (a.monitorAudioComment == true) goto L5;
        return;
    L5:
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("errorMsg", r8);
        Unit r9 = Unit.INSTANCE;
        new c(-1, null, 0, r6, 6).b(InteractivityTraceMonitor.Event.PublicScreenAudioPlayEvent);
    }

    public static void h(String r8) {
        Intrinsics.checkNotNullParameter(r8, "reason");
        if (a.monitorPSContextEmpty == true) goto L5;
        return;
    L5:
        new c(0, r8, 0, null, 13).b(InteractivityTraceMonitor.Event.PublicScreenContextEmpty);
    }

    @JvmStatic
    public static final void m(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        if (a.monitorPublicScreenLiftUp == true) goto L5;
        return;
    L5:
        d.put(r4, c.format(Long.valueOf(System.currentTimeMillis())));
    }

    @JvmStatic
    public static final void l(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (a.monitorFirstMessageDelay == true) goto L5;
        return;
    L5:
        b.put(r2, c.format(Long.valueOf(r3)));
    }

    @JvmStatic
    public static final void n(String r5, Function0<String> r6) {
        Intrinsics.checkNotNullParameter(r5, "step");
        Intrinsics.checkNotNullParameter(r6, "extra");
        s0 r0 = a;
        if (r0.monitorSelfGiftEvent == true) goto L5;
        return;
    L5:
        d().add(c.format(Long.valueOf(System.currentTimeMillis())) + ',' + r5 + ',' + ((String) r6.invoke()) + ';');
        if (d().size() <= r0.maxLogSize) goto L9;
        d().poll();
        return;
    }

    public static void f(long r11, String r13, long r14) {
        Intrinsics.checkNotNullParameter(r13, "status");
        if (a.monitorFirstMessageDelay == true) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder();
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((LinkedHashMap) b).entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        Map.Entry r3 = (Map.Entry) r2.next();
        r0.append((String) r3.getValue());
        r0.append(":");
        r0.append((String) r3.getKey());
        r1.add(r0.toString());
        StringsKt.clear(r0);
        goto L7
    L9:
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("timeStep", CollectionsKt.joinToString$default(r1, ",", null, null, 0, null, null, 62, null));
        r10.put("totalCnt", String.valueOf(r14));
        Unit r15 = Unit.INSTANCE;
        c r16 = new c(0, r13, r11, r10, 1);
        ALogger.i("ttlive_public_screen_first_message_show_delay", r16.toString());
        r16.b(InteractivityTraceMonitor.Event.FirstMessageShowDelay);
        ((LinkedHashMap) b).clear();
    }

    public static void j(String r9, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r9, "type");
        if (a.monitorEngineError == true) goto L5;
        return;
    L5:
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("type", r9);
        if (r10 == null) goto L8;
        String r13 = (String) r7.put("msg", r10);
    L8:
        if (r11 == null) goto L10;
        r7.put("error", Log.getStackTraceString(r11));
    L10:
        Unit r14 = Unit.INSTANCE;
        new c(0, null, 0, r7, 7).b(InteractivityTraceMonitor.Event.RichContentEngineError);
    }

    public static void k(long r8, String r10, Throwable r11) {
        if (a.monitorTopMsgBackendFail == true) goto L5;
        return;
    L5:
        int r2 = (int) r8;
        if (r10 != null) goto L8;
        String r3 = BuildConfig.FLAVOR;
    L9:
        LinkedHashMap r6 = new LinkedHashMap();
        if (r10 == null) goto L12;
        String r9 = (String) r6.put("errorMsg", r10);
    L12:
        if (r11 == null) goto L14;
        r6.put("throwable", Log.getStackTraceString(r11));
    L14:
        Unit r13 = Unit.INSTANCE;
        new c(r2, r3, 0, r6, 4).b(InteractivityTraceMonitor.Event.PublicScreenTopMsgEvent);
        return;
    L8:
        r3 = r10;
        goto L9
    }

    @JvmStatic
    public static final void i(String r9, String r10, boolean r11, String r13) {
        Intrinsics.checkNotNullParameter(r9, "layer");
        if (a.monitorPublicScreenVis == true) goto L6;
        return;
    L6:
        if (r11 == false) goto L8;
        String r1 = "Visiable";
    L9:
        String r4 = r1;
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("layer", r9);
        if (r10 == null) goto L12;
        String r14 = (String) r7.put("reason", r10);
    L12:
        if (r11 == false) goto L14;
        String r15 = "yes";
    L15:
        r7.put("visibility", r15);
        if (r13 == null) goto L18;
        r7.put("extra", r13);
    L18:
        Unit r16 = Unit.INSTANCE;
        c r17 = new c(0, r4, 0, r7, 5);
        r17.a(InteractivityMonitor.Event.PublicScreenVisibilityChange);
        r17.b(InteractivityTraceMonitor.Event.PublicScreenVisibilityChange);
        return;
    L14:
        r15 = "no";
        goto L15
    L8:
        r1 = "InVisiable";
        goto L9
    }

    @JvmStatic
    public static final void g(String r3, Boolean r4, Boolean r5, AdjustStep r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "status");
        s0 r0 = a;
        if (r0.monitorAdjustLayout == true) goto L5;
        return;
    L5:
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r5, r1) == false) goto L11;
        if (Intrinsics.areEqual(r4, r1) == false) goto L11;
        String r8 = "AdjustBoth";
    L17:
        String r9 = c.format(Long.valueOf(System.currentTimeMillis()));
        String r10 = r6.getStep();
        Intrinsics.checkNotNullParameter(r9, "timestamp");
        Intrinsics.checkNotNullParameter(r10, "step");
        Intrinsics.checkNotNullParameter(r8, "adjustType");
        if (b().size() < r0.maxLogSize) goto L20;
        b().poll();
    L20:
        b().offer("timeStamp:" + r9 + ",step:" + r10 + ",source:" + r3 + ",type:" + r8 + ",info:" + r7 + '\n');
        return;
    L11:
        if (Intrinsics.areEqual(r5, r1) == false) goto L14;
        r8 = "AdjustHeight";
        goto L17
    L14:
        if (Intrinsics.areEqual(r4, r1) == false) goto L16;
        r8 = "AdjustWidth";
        goto L17
    L16:
        r8 = "empty";
        goto L17
    }
}
