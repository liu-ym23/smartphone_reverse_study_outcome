package com.bytedance.android.livesdk.dynamicstrategy.api.utils;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class DynamicStrategyMonitor {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/api/utils/DynamicStrategyMonitor$Event;", "", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "eventModule", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "getEventModule", "()Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "", "extraALog", "Z", "getExtraALog", "()Z", "reportInLocalTest", "getReportInLocalTest", "StrategyFetchAll", "StrategyFetchError", "StrategyCheckError", "StrategyExecuteError", "StrategyContextInitContext", "StrategyExecuteCost", "CloudFactorFetchAll", "CloudFactorFetchError", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Event extends Enum<Event> {
        public static final Event CloudFactorFetchAll = null;
        public static final Event CloudFactorFetchError = null;
        public static final Event StrategyCheckError = null;
        public static final Event StrategyContextInitContext = null;
        public static final Event StrategyExecuteCost = null;
        public static final Event StrategyExecuteError = null;
        public static final Event StrategyFetchAll = null;
        public static final Event StrategyFetchError = null;
        public static final /* synthetic */ Event[] a = null;
        private final LiveTracingMonitor.EventModule eventModule;
        private final String eventName;
        private final boolean extraALog;
        private final boolean reportInLocalTest;

        public Event() {
            throw null;
        }

        public static Event valueOf(String r1) {
            return (Event) a.a(Event.class, r1);
        }

        public static Event[] values() {
            return (Event[]) a.clone();
        }

        static {
            LiveTracingMonitor.EventModule r20 = LiveTracingMonitor.EventModule.DYNAMIC_STRATEGY;
            Event r10 = new Event("StrategyFetchAll", 0, "ttlive_dynamic_strategy_fetch_all", r20, false, false, 8, null);
            StrategyFetchAll = r10;
            Event r1 = new Event("StrategyFetchError", 1, "ttlive_dynamic_strategy_fetch_error", r20, true, false, 8, null);
            StrategyFetchError = r1;
            Event r2 = new Event("StrategyCheckError", 2, "ttlive_dynamic_strategy_check_error", r20, true, false, 8, null);
            StrategyCheckError = r2;
            Event r3 = new Event("StrategyExecuteError", 3, "ttlive_dynamic_strategy_execute_error", r20, true, false, 8, null);
            StrategyExecuteError = r3;
            Event r4 = new Event("StrategyContextInitContext", 4, "ttlive_dynamic_strategy_context_init_cost", r20, true, false, 8, null);
            StrategyContextInitContext = r4;
            Event r5 = new Event("StrategyExecuteCost", 5, "ttlive_dynamic_strategy_execute_cost", r20, true, false, 8, null);
            StrategyExecuteCost = r5;
            Event r6 = new Event("CloudFactorFetchAll", 6, "ttlive_dynamic_strategy_cloud_factor_fetch_all", r20, false, false, 8, null);
            CloudFactorFetchAll = r6;
            Event r7 = new Event("CloudFactorFetchError", 7, "ttlive_dynamic_strategy_cloud_factor_fetch_error", r20, true, false, 8, null);
            CloudFactorFetchError = r7;
            a = new Event[]{r10, r1, r2, r3, r4, r5, r6, r7};
        }

        public final LiveTracingMonitor.EventModule getEventModule() {
            return this.eventModule;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final boolean getExtraALog() {
            return this.extraALog;
        }

        public final boolean getReportInLocalTest() {
            return this.reportInLocalTest;
        }

        public Event(String r2, int r3, String r4, LiveTracingMonitor.EventModule r5, boolean r6, boolean r7, int r8, DefaultConstructorMarker r9) {
            if ((r8 & 4) == 0) goto L6;
            r6 = true;
        L6:
            if ((r8 & 8) == 0) goto L8;
            r7 = true;
        L8:
            super(r2, r3);
            this.eventName = r4;
            this.eventModule = r5;
            this.extraALog = r6;
            this.reportInLocalTest = r7;
        }
    }

    static {
    }

    public static LiveMonitor.a a(Event r3) {
        LiveMonitor.a r0 = new LiveMonitor.a(r3.getEventName(), r3.getEventModule());
        r0.f = r3.getExtraALog();
        r0.h = r3.getReportInLocalTest();
        return r0;
    }

    public static void c(int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "version");
        JSONObject r1 = new JSONObject();
        r1.put("requestScene", r5);
        r1.put("is_success", true);
        LiveMonitor.a r3 = a(Event.CloudFactorFetchAll);
        r3.b(r1);
        r3.i("requestScene", Integer.valueOf(r5));
        r3.i("version", r6);
        r3.a().report();
    }

    public static void b(int r6, String r7, int r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "version");
        Intrinsics.checkNotNullParameter(r9, "errorInfo");
        LiveMonitor.a r2 = a(Event.CloudFactorFetchError);
        r2.i("requestScene", Integer.valueOf(r6));
        r2.i("version", r7);
        r2.i("errorCode", Integer.valueOf(r8));
        r2.i("errorInfo", r9);
        r2.a().report();
        JSONObject r10 = new JSONObject();
        r10.put("requestScene", r6);
        r10.put("is_success", false);
        r10.put("errorCode", r8);
        LiveMonitor.a r11 = a(Event.CloudFactorFetchAll);
        r11.b(r10);
        r11.i("requestScene", Integer.valueOf(r6));
        r11.i("version", r7);
        r11.a().report();
    }

    public static void d(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "strategyName");
        Intrinsics.checkNotNullParameter(r4, "strategyType");
        Intrinsics.checkNotNullParameter(r5, "executeInfo");
        Intrinsics.checkNotNullParameter(r6, "errorInfo");
        JSONObject r7 = new JSONObject();
        r7.put(LiveEndPageData.TAG_NAME, r3);
        r7.put("type", r4);
        LiveMonitor.a r2 = a(Event.StrategyExecuteError);
        r2.b(r7);
        r2.i(LiveEndPageData.TAG_NAME, r3);
        r2.i("type", r4);
        r2.i("error_info", r6);
        r2.a().report();
    }

    public static void e(int r7, String r8, int r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "version");
        Intrinsics.checkNotNullParameter(r10, "errorInfo");
        LiveMonitor.a r2 = a(Event.StrategyFetchError);
        r2.i("requestScene", Integer.valueOf(r7));
        r2.i("version", r8);
        r2.i("errorCode", Integer.valueOf(r9));
        r2.i("errorInfo", r10);
        r2.a().report();
        JSONObject r3 = new JSONObject();
        r3.put("requestScene", r7);
        r3.put("is_success", false);
        r3.put("errorCode", r9);
        LiveMonitor.a r4 = a(Event.StrategyFetchAll);
        r4.b(r3);
        r4.i("requestScene", Integer.valueOf(r7));
        r4.i("version", r8);
        r4.i("errorCode", Integer.valueOf(r9));
        r4.i("errorInfo", r10);
        r4.a().report();
    }
}
