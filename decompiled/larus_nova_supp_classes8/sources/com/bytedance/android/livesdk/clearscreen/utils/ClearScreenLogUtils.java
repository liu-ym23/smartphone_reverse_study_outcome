package com.bytedance.android.livesdk.clearscreen.utils;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ClearScreenLogUtils {
    public static final Companion a = null;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/clearscreen/utils/ClearScreenLogUtils$Companion$Event;", "", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "moduleName", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "getModuleName", "()Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "GoneInClearNotShow", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum Event extends Enum<Event> {
            public static final Event GoneInClearNotShow = null;
            public static final /* synthetic */ Event[] a = null;
            private final String eventName;
            private final LiveTracingMonitor.EventModule moduleName;

            static {
                Event r1 = new Event(LiveTracingMonitor.EventModule.CLEAR_SCREEN);
                GoneInClearNotShow = r1;
                a = new Event[]{r1};
            }

            public static Event valueOf(String r1) {
                return (Event) r27.a.a(Event.class, r1);
            }

            public static Event[] values() {
                return (Event[]) a.clone();
            }

            public final String getEventName() {
                return this.eventName;
            }

            public final LiveTracingMonitor.EventModule getModuleName() {
                return this.moduleName;
            }

            public Event(LiveTracingMonitor.EventModule r3) {
                super("GoneInClearNotShow", 0);
                this.eventName = "ttlive_clear_widget_not_show";
                this.moduleName = r3;
            }
        }

        public Companion() {
        }

        public static String a() {
            RoomContext.a r0 = RoomContext.Companion;
            RoomContext r5 = RoomContext.a.c(r0, null, 0, 3);
            if (r5 == null) goto L8;
            m r6 = r5.getCleanMode();
            if (r6 == null) goto L8;
            if (((Number) r6.getValue()).intValue() != 3) goto L8;
        L14:
            return "1";
        L8:
            RoomContext r1 = RoomContext.a.c(r0, null, 0, 3);
            if (r1 == null) goto L15;
            m r2 = r1.getCleanMode();
            if (r2 == null) goto L15;
            if (((Number) r2.getValue()).intValue() == 13) goto L14;
        L15:
            return "0";
        }

        public static String b() {
            RoomContext.a r0 = RoomContext.Companion;
            RoomContext r5 = RoomContext.a.c(r0, null, 0, 3);
            if (r5 == null) goto L9;
            m r6 = r5.getCleanMode();
            if (r6 == null) goto L9;
            if (((Number) r6.getValue()).intValue() != 2) goto L9;
            return "2";
        L9:
            RoomContext r7 = RoomContext.a.c(r0, null, 0, 3);
            if (r7 == null) goto L15;
            m r8 = r7.getCleanMode();
            if (r8 == null) goto L15;
            if (((Number) r8.getValue()).intValue() != 3) goto L15;
        L21:
            return "1";
        L15:
            RoomContext r1 = RoomContext.a.c(r0, null, 0, 3);
            if (r1 == null) goto L22;
            m r2 = r1.getCleanMode();
            if (r2 == null) goto L22;
            if (((Number) r2.getValue()).intValue() == 13) goto L21;
        L22:
            return "0";
        }

        public static void e(String r4) {
            Intrinsics.checkNotNullParameter(r4, "toolbarIcon");
            HashMap r0 = new HashMap();
            r0.put("tool_bar", r4);
            r0.put("if_pop_up_card", "1");
            u.l().sendLog("livesdk_clear_mode_simple_type_enter", r0, new Object[]{new x(), Room.class});
        }

        public static void g(ArrayList r9) {
            Intrinsics.checkNotNullParameter(r9, "list");
            Iterator r10 = r9.iterator();
        L4:
            if (r10.hasNext() == false) goto L22;
            String r0 = (String) r10.next();
            ALogger.e("ClearScreenManager", "ClearScreen error!! not show is " + r0 + " .");
            Event r1 = Event.GoneInClearNotShow;
            Intrinsics.checkNotNullParameter(r1, "event");
            Intrinsics.checkNotNullParameter(r0, "widgetName");
            RoomContext r3 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r3 == null) goto L10;
            m r4 = r3.getRoom();
            if (r4 == null) goto L10;
            Room r5 = (Room) r4.getValue();
        L11:
            Intrinsics.checkNotNullParameter(r1, "event");
            String r2 = r1.getEventName();
            LiveTracingMonitor.EventModule r6 = r1.getModuleName();
            if (r5 == null) goto L16;
            String r7 = String.valueOf(r5.getRoomId());
            JSONObject r8 = new JSONObject();
            r8.put("room_id", r7);     // Catch: JSONException -> L23
        L17:
            String r11 = String.valueOf(0);
            JSONObject r12 = new JSONObject();
            r12.put("status", r11);     // Catch: JSONException -> L24
        L30:
            r12.put("widget_name", r0);     // Catch: JSONException -> L25
        L21:
            LiveMonitor r13 = new LiveMonitor();
            r13.mCategory = r12;
            r13.mEventModule = r6;
            r13.mServiceName = r2;
            r13.mExtraLog = r8;
            r13.mMetrics = null;
            LiveMonitor.access$002(r13, false);
            LiveMonitor.access$102(r13, false);
            LiveMonitor.access$202(r13, true);
            LiveMonitor.access$302(r13, false);
            LiveMonitor.access$402(r13, false);
            r13.report();
            goto L4
        L16:
            r8 = null;
        L10:
            r5 = null;
            goto L11
        }

        public static void c(String r4, HashMap r5) {
            Intrinsics.checkNotNullParameter(r4, "event");
            Intrinsics.checkNotNullParameter(r5, "logMap");
            u.l().sendLog(r4, r5, new Object[]{new x(), Room.class});
        }

        @JvmStatic
        public static void d(DataCenter r4, String r5, Map r6) {
            Intrinsics.checkNotNullParameter(r5, "clearType");
            HashMap r0 = new HashMap();
            if (r6 == null) goto L5;
            r0.putAll(r6);
        L5:
            r0.put("clear_type", r5);
            RoomContext r7 = RoomContext.a.c(RoomContext.Companion, r4, 0, 2);
            if (r7 == null) goto L10;
            m r8 = r7.getEnterClearType();
            if (r8 == null) goto L10;
            r8.setValue(r5);
        L10:
            u.l().sendLog("livesdk_screen_clear", r0, new Object[]{x.class, Room.class});
        }

        @JvmStatic
        public static void f(DataCenter r4, String r5, Map r6) {
            Intrinsics.checkNotNullParameter(r5, "clearType");
            HashMap r0 = new HashMap();
            if (r6 == null) goto L5;
            r0.putAll(r6);
        L5:
            r0.put("clear_type", r5);
            RoomContext r7 = RoomContext.a.c(RoomContext.Companion, r4, 0, 2);
            if (r7 == null) goto L10;
            m r8 = r7.getEnterClearType();
            if (r8 == null) goto L10;
            r8.setValue(r5);
        L10:
            u.l().sendLog("livesdk_screen_clear_cancel", r0, new Object[]{x.class, Room.class});
        }
    }

    static {
        a = new Companion();
    }
}
