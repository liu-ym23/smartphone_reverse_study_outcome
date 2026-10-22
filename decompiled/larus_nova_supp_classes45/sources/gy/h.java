package gy;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h extends BaseMonitor {
    public static final /* synthetic */ int d = 0;
    public final HashMap<LiveTracingMonitor.EventModule, e> a;
    public final Room b;
    public final boolean c;

    public static final class a {
    }

    static {
    }

    public h(Room r2) {
        Intrinsics.checkNotNullParameter(r2, NewBroadcastMonitor.PAGE.ROOM);
        this.b = r2;
        this.c = false;
        this.a = new HashMap();
    }

    public final void l(JSONObject r6) {
        c.c2.getClass();
        c r0 = c.a.a();
        String r1 = "";
        if (r0 == null) goto L9;
        f r2 = r0.getRtcManager();
        if (r2 == null) goto L9;
        String r3 = r2.O();
        if (r3 == null) goto L9;
    L10:
        BaseMonitor.add(r6, "channel_id", r3);
        c r4 = c.a.a();
        if (r4 == null) goto L18;
        f r5 = r4.getRtcManager();
        if (r5 == null) goto L18;
        String r7 = r5.c0();
        if (r7 == null) goto L18;
        r1 = r7;
    L18:
        BaseMonitor.add(r6, "linker_session_id", r1);
        BaseMonitor.add(r6, "event_session_id", r3);
        Room r8 = this.b;
        IRoom.Companion r9 = IRoom.Companion;
        if (r9.isValid(r8) == true) goto L22;
        r8 = null;
    L22:
        if (r8 == null) goto L31;
        String r11 = "0";
        if (r9.isValid(this.b) == false) goto L26;
        String r12 = r8.getIdStr();
    L27:
        BaseMonitor.add(r6, "room_id", r12);
        if (r9.isValid(this.b) == false) goto L30;
        r11 = r8.getOwnerUserIdString();
    L30:
        BaseMonitor.add(r6, "anchor_id", r11);
        goto L31
    L26:
        r12 = "0";
    L31:
        c r13 = c.a.a();
        if (r13 == null) goto L41;
        f r14 = r13.getRtcManager();
        if (r14 != null) goto L36;
        return;
    L36:
        if (r14.F() != true) goto L38;
        long r15 = 1;
    L39:
        BaseMonitor.add(r6, "is_client_mixstream", r15);
        return;
    L38:
        r15 = 0;
        goto L39
    L41:
        return;
    L9:
        r3 = "";
        goto L10
    }

    public final void m(LiveTracingMonitor.EventModule r5, String r6, Map<String, ? extends Object> r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r5, "eventModule");
        Intrinsics.checkNotNullParameter(r6, "sdkApiName");
        dy.b r0 = dy.b.a;
        if (dy.b.c(r6) == false) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        BaseMonitor.add(r1, "sdk_api_name", r6);
        if (r7 == null) goto L11;
        Iterator<Map.Entry<String, ? extends Object>> r9 = r7.entrySet().iterator();
    L9:
        if (r9.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r2 = r9.next();
        r1.putOpt(r2.getKey(), r2.getValue());
    L11:
        if (r8 == true) goto L15;
        l(r1);
        e r11 = this.a.get(r5);
        if (r11 == null) goto L15;
        r11.b();
    L15:
        HashMap r12 = new HashMap();
        r12.put("sdk_api_name", r6);
        dy.b r13 = dy.b.a;
        r12.put("android_event_key", "rtc_".concat(r6));
        if (this.c == false) goto L18;
        String r14 = GamePromoteDataContext.GAME_TYPE_MINI;
    L19:
        r12.put("role_type", r14);
        dy.b.e("ttlive_interact_sdk_api_call", r5, r12, r1);
        return;
    L18:
        r14 = "3";
        goto L19
    }

    public final void n(LiveTracingMonitor.EventModule r9, String r11, String r12, Map<String, ? extends Object> r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r9, "eventModule");
        Intrinsics.checkNotNullParameter(r11, "rtcCallBackName");
        Intrinsics.checkNotNullParameter(r12, "linkmicId");
        Intrinsics.checkNotNullParameter(r15, "statusMsg");
        dy.b r0 = dy.b.a;
        if (dy.b.c(r11) == false) goto L5;
        return;
    L5:
        JSONObject r7 = new JSONObject();
        BaseMonitor.add(r7, "rtc_callback_name", r11);
        BaseMonitor.add(r7, "linkmic_id", r12);
        l(r7);
        if (r13 == null) goto L11;
        Iterator<Map.Entry<String, ? extends Object>> r16 = r13.entrySet().iterator();
    L9:
        if (r16.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r17 = r16.next();
        r7.putOpt(r17.getKey(), r17.getValue());
    L11:
        e r18 = this.a.get(r9);
        if (r18 == null) goto L14;
        r18.a();
    L14:
        HashMap r6 = new HashMap();
        r6.put("sdk_callback_name", r11);
        if (this.c == false) goto L17;
        String r19 = GamePromoteDataContext.GAME_TYPE_MINI;
    L18:
        r6.put("role_type", r19);
        dy.b r1 = dy.b.a;
        r6.put("android_event_key", "callback_".concat(r11));
        r1.d("ttlive_interact_sdk_callback", r9, r14, r15, r6, r7);
        return;
    L17:
        r19 = "3";
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void o(h r9, LiveTracingMonitor.EventModule r11, String r12, String r13, Map r14, int r15, int r16) {
        String r1 = null;
        if ((r16 & 8) == 0) goto L5;
        Map r6 = null;
    L7:
        if ((r16 & 16) == 0) goto L9;
        int r7 = 0;
    L11:
        if ((r16 & 32) == 0) goto L13;
        r1 = "";
    L13:
        r9.n(r11, r12, r13, r6, r7, r1);
        return;
    L9:
        r7 = r15;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }
}
