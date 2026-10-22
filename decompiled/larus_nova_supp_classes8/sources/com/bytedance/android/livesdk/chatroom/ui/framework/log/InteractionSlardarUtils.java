package com.bytedance.android.livesdk.chatroom.ui.framework.log;

import am2.x;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class InteractionSlardarUtils {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/log/InteractionSlardarUtils$Event;", "", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "eventModule", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "getEventModule", "()Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "", "extraALog", "Z", "getExtraALog", "()Z", "reportInLocalTest", "getReportInLocalTest", "INTERACTION_LOAD_ERROR", "INTERACTION_CORE_PROCESS_COST", "INTERACTION_CORE_WIDGET_COST", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Event extends Enum<Event> {
        public static final Event INTERACTION_CORE_PROCESS_COST = null;
        public static final Event INTERACTION_CORE_WIDGET_COST = null;
        public static final Event INTERACTION_LOAD_ERROR = null;
        public static final /* synthetic */ Event[] a = null;
        private final LiveTracingMonitor.EventModule eventModule;
        private final String eventName;
        private final boolean extraALog;
        private final boolean reportInLocalTest;

        static {
            LiveTracingMonitor.EventModule r20 = LiveTracingMonitor.EventModule.INTERACTION;
            Event r10 = new Event("INTERACTION_LOAD_ERROR", 0, "ttlive_interaction_load_error", r20, true, false, 8, null);
            INTERACTION_LOAD_ERROR = r10;
            Event r1 = new Event("INTERACTION_CORE_PROCESS_COST", 1, "ttlive_interaction_core_process_cost", r20, true, false, 8, null);
            INTERACTION_CORE_PROCESS_COST = r1;
            Event r2 = new Event("INTERACTION_CORE_WIDGET_COST", 2, "ttlive_interaction_core_widget_cost", r20, true, false, 8, null);
            INTERACTION_CORE_WIDGET_COST = r2;
            a = new Event[]{r10, r1, r2};
        }

        public Event() {
            throw null;
        }

        public static Event valueOf(String r1) {
            return (Event) a.a(Event.class, r1);
        }

        public static Event[] values() {
            return (Event[]) a.clone();
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

    public static LiveMonitor.a b(Event r3) {
        LiveMonitor.a r0 = new LiveMonitor.a(r3.getEventName(), r3.getEventModule());
        r0.f = r3.getExtraALog();
        r0.h = r3.getReportInLocalTest();
        return r0;
    }

    public static void a(LiveMonitor.a r4, com.bytedance.android.livesdk.chatroom.ui.framework.base.a r5) {
        if ((!r5.r) == false) goto L5;
        String r0 = SourceType.ANCHOR;
    L6:
        r4.e("interaction_type", r0);
        if (r5.a == false) goto L9;
        String r1 = "portrait";
    L10:
        r4.e("orientation_type", r1);
        r4.e("live_mode", LiveMode.Companion.convertLiveModeToString(r5.i));
        o r2 = j0.l().c(x.class);
        String r3 = "null";
        if (r2 == null) goto L16;
        Map r6 = r2.getMap();
        if (r6 == null) goto L16;
        String r7 = (String) r6.get("action_type");
        if (r7 == null) goto L16;
    L17:
        r4.e("action_type", r7);
        if (r2 == null) goto L23;
        Map r8 = r2.getMap();
        if (r8 == null) goto L23;
        String r9 = (String) r8.get("enter_from_merge");
        if (r9 == null) goto L23;
    L24:
        r4.e("enter_from_merge", r9);
        if (r2 == null) goto L32;
        Map r10 = r2.getMap();
        if (r10 == null) goto L32;
        String r11 = (String) r10.get("enter_method");
        if (r11 == null) goto L32;
        r3 = r11;
    L32:
        r4.e("enter_method", r3);
        r4.i("room_id", Long.valueOf(r5.c().id));
        User r12 = r5.c().getOwner();
        if (r12 == null) goto L36;
        Object r13 = r12.getUserId();
        if (r13 == null) goto L36;
    L37:
        r4.i("anchor_id", r13);
        return;
    L36:
        r13 = 0L;
    L23:
        r9 = "null";
    L16:
        r7 = "null";
        goto L17
    L9:
        r1 = "landscape";
        goto L10
    L5:
        r0 = SourceType.DEFAULT;
        goto L6
    }

    public static void c(com.bytedance.android.livesdk.chatroom.ui.framework.base.a r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "errorScene");
        Intrinsics.checkNotNullParameter(r3, "errorType");
        LiveMonitor.a r0 = b(Event.INTERACTION_LOAD_ERROR);
        a(r0, r1);
        r0.e("error_scene", r2);
        r0.e("error_type", r3);
        r0.a().report();
    }
}
