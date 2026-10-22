package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils;

import am2.x;
import com.bytedance.android.live.base.model.message.g3;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ra2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MatchLogHelper {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/utils/MatchLogHelper$Event;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "eventModule", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "getEventModule", "()Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", BuildConfig.FLAVOR, "extraALog", "Z", "getExtraALog", "()Z", "reportInLocalTest", "getReportInLocalTest", "ImgDownloadSuccess", "ImgDownloadFailed", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Event extends Enum<Event> {
        public static final Event ImgDownloadFailed = null;
        public static final Event ImgDownloadSuccess = null;
        public static final /* synthetic */ Event[] a = null;
        private final LiveTracingMonitor.EventModule eventModule;
        private final String eventName;
        private final boolean extraALog;
        private final boolean reportInLocalTest;

        static {
            LiveTracingMonitor.EventModule r15 = LiveTracingMonitor.EventModule.MATCH_TRAY;
            Event r10 = new Event("ImgDownloadSuccess", 0, "live_match_tray_download_success", r15, false, false, 12, null);
            ImgDownloadSuccess = r10;
            Event r1 = new Event("ImgDownloadFailed", 1, "live_match_tray_download_failed", r15, false, false, 12, null);
            ImgDownloadFailed = r1;
            a = new Event[]{r10, r1};
        }

        public Event() {
            throw null;
        }

        public static Event valueOf(String r1) {
            return (Event) r27.a.a(Event.class, r1);
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

        public Event(String r1, int r2, String r3, LiveTracingMonitor.EventModule r4, boolean r5, boolean r6, int r7, DefaultConstructorMarker r8) {
            if ((r7 & 4) == 0) goto L6;
            r5 = false;
        L6:
            if ((r7 & 8) == 0) goto L8;
            r6 = true;
        L8:
            super(r1, r2);
            this.eventName = r3;
            this.eventModule = r4;
            this.extraALog = r5;
            this.reportInLocalTest = r6;
        }
    }

    public MatchLogHelper() {
    }

    static {
    }

    public static void a(String r4, Map r5) {
        j0.l().sendLog(r4, r5, new Object[]{IRoom.class, x.class});
    }

    public static void b(HotMsgType r17, DataCenter r18, boolean r19, MatchHotMsgView r20, long r21) {
        Intrinsics.checkNotNullParameter(r17, "msg");
        Intrinsics.checkNotNullParameter(r18, "dataCenter");
        HotMsgType r2 = HotMsgType.ConfrontMsg;
        Long r9 = null;
        String r11 = BuildConfig.FLAVOR;
        if (r17 != r2) goto L49;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("sequence_type", "battle");
        r0.put("team_type", "home_team");
        g3 r13 = b.c;
        if (r13 == null) goto L7;
        Long r14 = Long.valueOf(r13.getSequenceId());
    L8:
        r0.put("sequence_id", String.valueOf(r14));
        IInteractivityInjectService r15 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r15 == null) goto L12;
        String r16 = r15.getMatchAgainstLeftName(r18);
        if (r16 == null) goto L12;
    L13:
        r0.put("team_name", r16);
        g3 r110 = b.c;
        if (r110 == null) goto L17;
        String r111 = r110.getContent();
        if (r111 == null) goto L17;
    L18:
        r0.put("prompt", r111);
        if (r19 == false) goto L21;
        a("livesdk_live_message_collection_show", r0);
    L26:
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("sequence_type", "battle");
        r1.put("team_type", "guest_team");
        g3 r3 = b.d;
        if (r3 == null) goto L29;
        Long r4 = Long.valueOf(r3.getSequenceId());
    L30:
        r1.put("sequence_id", String.valueOf(r4));
        IInteractivityInjectService r5 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r5 == null) goto L34;
        String r6 = r5.getMatchAgainstRightName(r18);
        if (r6 == null) goto L34;
    L35:
        r1.put("team_name", r6);
        g3 r7 = b.d;
        if (r7 == null) goto L41;
        String r8 = r7.getContent();
        if (r8 == null) goto L41;
        r11 = r8;
    L41:
        r1.put("prompt", r11);
        if (r19 == false) goto L44;
        a("livesdk_live_message_collection_show", r1);
        return;
    L44:
        r1.put("duration", String.valueOf(r21));
        g3 r10 = b.d;
        if (r10 == null) goto L47;
        r9 = Long.valueOf(r10.getCount());
    L47:
        r1.put("message_num", String.valueOf(r9));
        a("livesdk_live_message_collection_imp", r1);
        return;
    L34:
        r6 = BuildConfig.FLAVOR;
        goto L35
    L29:
        r4 = null;
        goto L30
    L21:
        r0.put("duration", String.valueOf(r21));
        g3 r112 = b.c;
        if (r112 == null) goto L24;
        Long r113 = Long.valueOf(r112.getCount());
    L25:
        r0.put("message_num", String.valueOf(r113));
        a("livesdk_live_message_collection_imp", r0);
        goto L26
    L24:
        r113 = null;
    L17:
        r111 = BuildConfig.FLAVOR;
    L12:
        r16 = BuildConfig.FLAVOR;
        goto L13
    L7:
        r14 = null;
        goto L8
    L49:
        if (r17 != HotMsgType.AggregateMsg) goto L77;
        LinkedHashMap r23 = new LinkedHashMap();
        if (r20 == null) goto L56;
        g3 r24 = r20.getCurShowMsg();
        if (r24 == null) goto L56;
        String r25 = r24.getContent();
        if (r25 == null) goto L56;
    L57:
        r23.put("prompt", r25);
        r23.put("sequence_type", "polymerize");
        if (r20 == null) goto L65;
        g3 r26 = r20.getCurShowMsg();
        if (r26 == null) goto L65;
        String r27 = String.valueOf(r26.getSequenceId());
        if (r27 == null) goto L65;
        r11 = r27;
    L65:
        r23.put("sequence_id", r11);
        if (r19 == false) goto L68;
        a("livesdk_live_message_collection_show", r23);
        return;
    L68:
        r23.put("duration", String.valueOf(r21));
        if (r20 == null) goto L73;
        g3 r28 = r20.getCurShowMsg();
        if (r28 == null) goto L73;
        r9 = Long.valueOf(r28.getCount());
    L73:
        r23.put("message_num", String.valueOf(r9));
        a("livesdk_live_message_collection_imp", r23);
        return;
    L56:
        r25 = BuildConfig.FLAVOR;
        goto L57
    }

    public static /* synthetic */ void c(HotMsgType r6, DataCenter r7, boolean r8, MatchHotMsgView r9, long r10, int r13) {
        if ((r13 & 8) == 0) goto L5;
        r9 = null;
    L5:
        MatchHotMsgView r3 = r9;
        if ((r13 & 16) == 0) goto L8;
        r10 = -1;
    L8:
        b(r6, r7, r8, r3, r10);
    }
}
