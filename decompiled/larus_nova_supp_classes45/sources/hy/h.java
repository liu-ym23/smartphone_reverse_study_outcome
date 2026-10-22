package hy;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.multianchor.model.ListUserLinkmicContent;
import com.bytedance.android.livesdk.config.qd1;
import com.bytedance.android.livesdk.link.model.bridge.k1;
import com.bytedance.android.livesdk.link.model.bridge.m1;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h extends BaseMonitor {
    public final String a;
    public final Room b;
    public final boolean c;
    public final int d;
    public final g e;

    public final Map<String, Object> m() {
        LinkedHashMap r0 = new LinkedHashMap();
        Room r1 = this.b;
        if (r1 == null) goto L5;
        Long r2 = Long.valueOf(r1.id);
    L6:
        r0.put("room_id", Long.valueOf(r2.longValue()));
        Room r3 = this.b;
        if (r3 == null) goto L10;
        String r4 = r3.getOwnerUserIdString();
        if (r4 == null) goto L10;
    L11:
        r0.put("anchor_id", r4);
        return r0;
    L10:
        r4 = "0";
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public static void n(Map r4, List r5) {
        AnchorLinkUser r0 = null;
        if (r5 == null) goto L16;
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L16;
        AnchorLinkUser r1 = (AnchorLinkUser) r6.next();
        if (r1 == null) goto L6;
        k1 r2 = r1.getContent();
        if (r2 == null) goto L6;
        m1 r3 = r2.getLinkMicContent();
        if (r3 == null) goto L6;
        if (r3.getAnchorAuthRole() != ListUserLinkmicContent.AnchorAuthRole.AnchorAuthRoleOrganizer.ordinal()) goto L6;
        r0 = r1;
    L16:
        if (r0 == null) goto L18;
        boolean r7 = true;
    L19:
        r4.put("has_organizer", Boolean.valueOf(r7));
        if (r0 == null) goto L25;
        IBaseUser r8 = r0.getUser();
        if (r8 == null) goto L25;
        String r9 = r8.getIdString();
        if (r9 == null) goto L25;
    L26:
        r4.put("organizer_id", r9);
        return;
    L25:
        r9 = "";
        goto L26
    L18:
        r7 = false;
        goto L19
    }

    public final void o(String r14, Map<String, Object> r15) {
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r15, "params");
        JSONObject r2 = new JSONObject(r15);
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r2, "json");
        BaseMonitor.add(r2, "common", new JSONObject(m()));
        if (this.c == false) goto L5;
        String r16 = "anchor";
    L6:
        BaseMonitor.add(r2, "role_type", r16);
        BaseMonitor.add(r2, "channel_id", this.e.getChannelId());
        BaseMonitor.add(r2, "event", r14);
        b0 r17 = b0.o();
        r17.getClass();
        com.bytedance.android.live.core.log.g.i(this.a, "event: " + r14 + " params=" + r2);
        int r7 = r2.optInt(LiveSlardarConstants.EXTRA_KEY_ERROR_CODE);
        String r8 = r2.optString(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG);
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r2, "extra");
        HashMap r6 = new HashMap();
        LiveTracingMonitor.EventModule r5 = LiveTracingMonitor.b(this.d);
        dy.b r3 = dy.b.a;
        r6.put("android_event_key", r14);
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r5, "module");
        Intrinsics.checkNotNullParameter(r6, "index");
        Intrinsics.checkNotNullParameter(r2, "extra");
        if (((Boolean) qd1.a.getValue()).booleanValue() == true) goto L10;
        return;
    L10:
        if (dy.b.c(r14) == true) goto L15;
        dy.b.a(r2);
        com.bytedance.android.live.core.monitor.trace.e r18 = dy.b.b(r3, r14, r5, r6, r7, r8, null, 0, 96);
        a60.e r19 = com.bytedance.android.live.core.monitor.trace.c.a;
        Intrinsics.checkNotNullParameter(r18, "traceMeta");
        TraceMonitor.i(r18, null, null, r2);
        return;
    L15:
        return;
    L5:
        r16 = "audience";
        goto L6
    }

    public h(Room r2, boolean r3, g r4) {
        Intrinsics.checkNotNullParameter(r2, NewBroadcastMonitor.PAGE.ROOM);
        Intrinsics.checkNotNullParameter(r4, "channelIdGetter");
        this.b = r2;
        this.c = r3;
        this.d = 17;
        this.e = r4;
        this.a = "LinkUserCenterMonitor";
    }

    public final void l(String r3, List<AnchorLinkUser> r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r5, "logID");
        if (this.c == true) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        return;
    L7:
        if (r4.isEmpty() == false) goto L9;
        return;
    L9:
        if (d.a(r4) != null) goto L18;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("source", r3);
        String r6 = d.b(r4);
        if (r6 != null) goto L14;
        r6 = "null";
    L14:
        r1.put("online_list", r6);
        r1.put("log_id", r5);
        o("miss_multi_anchor_organizer", r1);
        return;
    }
}
