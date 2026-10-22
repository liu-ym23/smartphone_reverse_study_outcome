package com.bytedance.android.live.cloudgrouplive.rtc;

import android.view.SurfaceView;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamPushTargetType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class CloudGroupLiveRTCManager {
    public static final /* synthetic */ int k = 0;
    public final Room a;
    public final d b;
    public ei6.a c;
    public c d;
    public String e;
    public String f;
    public SurfaceView g;
    public boolean h;
    public AnchorGroupLiveStatus i;
    public final Lazy j;

    public static final class a {
    }

    static {
    }

    public final String e() {
        return String.valueOf(this.e) + "wtn" + String.valueOf(this.f);
    }

    public CloudGroupLiveRTCManager() {
        RoomContext.a r0 = RoomContext.Companion;
        d r1 = null;
        RoomContext r5 = RoomContext.a.c(r0, null, 0, 3);
        if (r5 == null) goto L7;
        m r6 = r5.getRoom();
        if (r6 == null) goto L7;
        Room r7 = (Room) r6.getValue();
    L8:
        this.a = r7;
        RoomContext r2 = RoomContext.a.c(r0, null, 0, 3);
        if (r2 == null) goto L13;
        j r3 = r2.getLiveStream();
        if (r3 == null) goto L13;
        r1 = (d) r3.getValue();
    L13:
        this.b = r1;
        this.i = AnchorGroupLiveStatus.DEFAULT;
        this.j = LazyKt.lazy(new CloudGroupLiveRTCManager$linkListener$2(this));
        return;
    L7:
        r7 = null;
        goto L8
    }

    public final void f(String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        ALogger.i("CloudGroupLiveRTCManager", "stopLink reason " + r6);
        int r0 = f40.a.a;
        CloudGroupLiveTraceEvent r1 = CloudGroupLiveTraceEvent.RTC_MANAGER;
        f40.a.d(r1, "stopLink", 0, "reason " + r6, 20);
        ALogger.i("CloudGroupLiveRTCManager", "stopWTNTask wtnStreamID " + e());
        f40.a.d(r1, "stopWTNTask", 0, "stopWTNTask " + e(), 20);
        ei6.a r7 = this.c;
        if (r7 == null) goto L9;
        ui6.d r8 = r7.l();
        if (r8 == null) goto L9;
        mi6.a r9 = r8.b();
        if (r9 == null) goto L9;
        r9.p(e(), LiveWrappedMixedStreamPushTargetType.PUSH_TO_WTN);
    L9:
        ei6.a r11 = this.c;
        if (r11 == null) goto L12;
        r11.a("group live stop link");
    L12:
        this.g = null;
        this.h = false;
        this.c = null;
    }

    public static final void d(CloudGroupLiveRTCManager r5, AnchorGroupLiveStatus r6) {
        if (r5.i == r6) goto L9;
        ALogger.i("CloudGroupLiveRTCManager", "notifyAnchorLiveStatusChanged " + r6.getDes());
        int r0 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.RTC_MANAGER, "notifyAnchorLiveStatusChanged", 0, "status " + r6.getDes(), 20);
        c r1 = r5.d;
        if (r1 == null) goto L7;
        r1.d(r6);
    L7:
        r5.i = r6;
        return;
    }

    public static final void a(final CloudGroupLiveRTCManager r11, final RTSMessage r12, final JSONObject r13) {
        r11.getClass();
        ALogger.i("CloudGroupLiveRTCManager", "handleAnchorGroupLiveStatusUpdate rts msg " + r13);
        int r0 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.RTC_MANAGER, "HandleAnchorGroupLiveStatusUpdate", 0, "rts msg " + r13, 20);
        UtilityKotlinExtentionsKt.s(0, false, false, new CloudGroupLiveRTCManager$handleAnchorGroupLiveStatusUpdate$1(r11, r12, r13), 7);
    }

    public static final void b(final CloudGroupLiveRTCManager r8, final RTSMessage r9, final JSONObject r11) {
        r8.getClass();
        ALogger.i("CloudGroupLiveRTCManager", "handleGroupLiveStreamStatusChange rts msg " + r11);
        UtilityKotlinExtentionsKt.s(0, false, false, new CloudGroupLiveRTCManager$handleGroupLiveStreamStatusChange$1(r8, r9, r11), 7);
    }

    public static final void c(CloudGroupLiveRTCManager r21, RTSMessage r22, JSONObject r23) {
        r21.getClass();
        ALogger.i("CloudGroupLiveRTCManager", "handleRemoteAudioChange rts msg " + r23);
        int r2 = b.d[r22.ordinal()];
        boolean r7 = true;
        if (r2 != 1) goto L5;
        boolean r3 = r23.optBoolean("mute", true);
        String r1 = r23.optString("rtc_uid", "");
        if ((true ^ StringsKt.isBlank(r1)) == false) goto L50;
        ALogger.i("CloudGroupLiveRTCManager", "handleRemoteAudioChange " + r1 + ' ' + r3);
        ei6.a r4 = r21.c;
        if (r4 == null) goto L37;
        ri6.b r11 = r4.r();
        if (r11 == null) goto L37;
        r11.l(String.valueOf(r21.e), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, r1, r3, "handleRemoteAudioChange by UPDATE_AUDIO");
    L37:
        int r0 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.RTC_MANAGER, "handleRemoteAudioChange", 0, "UPDATE_AUDIO " + r1 + ' ' + r3, 20);
        return;
    L50:
        return;
    L5:
        if (r2 != 2) goto L51;
        JSONArray r5 = r23.optJSONArray("view_displays");
        if (r5 != null) goto L10;
        return;
    L10:
        if (r5.length() <= 0) goto L47;
        int r6 = r5.length();
        int r12 = 0;
    L12:
        if (r12 >= r6) goto L52;
        JSONObject r13 = JSONArrayProtectorUtils.getJSONObject(r5, r12);
        if (Intrinsics.areEqual(r13.optString("view", ""), "group_view") == true) goto L15;
        r12 = r12 + 1;
        r7 = true;
        goto L12
    L15:
        JSONArray r8 = r13.optJSONArray("sources");
        if (r8 != null) goto L18;
        return;
    L18:
        if (r8.length() <= 0) goto L49;
        int r9 = r8.length();
        int r14 = 0;
    L20:
        if (r14 >= r9) goto L53;
        JSONObject r15 = JSONArrayProtectorUtils.getJSONObject(r8, r14);
        boolean r16 = r15.optBoolean("use_audio", false);
        String r17 = r15.optString("rtc_uid", "");
        if ((StringsKt.isBlank(r17) ^ r7) == false) goto L28;
        ALogger.i("CloudGroupLiveRTCManager", "handleRemoteAudioChange by SYNC_VIEW_DISPLAY " + r17 + ' ' + r16);
        int r18 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.RTC_MANAGER, "handleRemoteAudioChange", 0, "SYNC_VIEW_DISPLAY " + r17 + ' ' + r16, 20);
        ei6.a r19 = r21.c;
        if (r19 == null) goto L28;
        ri6.b r110 = r19.r();
        if (r110 == null) goto L28;
        r110.l(String.valueOf(r21.e), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, r17, !r16, "handleRemoteAudioChange by SYNC_VIEW_DISPLAY");
    L28:
        r14 = r14 + 1;
        r7 = true;
        goto L20
    L53:
        return;
    L49:
        return;
    L52:
        return;
    L47:
        return;
    }
}
