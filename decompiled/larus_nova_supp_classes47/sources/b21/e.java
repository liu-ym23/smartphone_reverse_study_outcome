package b21;

import c21.l;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revenuelink.f;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.v3;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final /* synthetic */ int b = 0;
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public static final class a {
    }

    static {
    }

    public final LiveFullLinkPKMonitor c() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveFullLinkPKMonitor();
    }

    public e(LinkFakeGlobalService r1) {
        this.a = r1;
    }

    public final void b(HashMap<String, String> r6) {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = r0.Ig();
    L6:
        if (r1 == null) goto L25;
        PlayMode r2 = (PlayMode) r1.getTeamMode().getValue();
        String r3 = "";
        if (r2 == null) goto L11;
        String r4 = r2.toString();
        if (r4 == null) goto L11;
    L12:
        r6.put("pk_mode", r4);
        PkBaseStateMachine.c r5 = (PkBaseStateMachine.c) r1.getPkBaseState().getValue();
        if (r5 == null) goto L16;
        String r7 = r5.c;
        if (r7 == null) goto L16;
    L17:
        r6.put("pk_state", r7);
        r6.put("pk_id", String.valueOf(r1.getPkId()));
        IBaseBattleSetting r8 = r1.getBattleSettings();
        if (r8 == null) goto L23;
        String r9 = String.valueOf(r8.getDuration());
        if (r9 == null) goto L23;
        r3 = r9;
    L23:
        r6.put("pk_duration", r3);
        return;
    L16:
        r7 = "";
    L11:
        r4 = "";
        goto L12
    L25:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static void a(HashMap r3, c21.b r4) {
        l r0 = r4.a;
        r3.put("invite_type", String.valueOf(r0.a.getType()));
        r3.put("invite_duration", String.valueOf(r0.b));
        r3.put("invite_multiPkMode", String.valueOf(r0.c));
        r3.put("invite_isOnceMore", String.valueOf(r0.d));
        r3.put("invite_decideDuration", String.valueOf(r0.e));
        v3 r1 = r0.f;
        if (r1 == null) goto L6;
        String r2 = r1.getPointTag();
        if (r2 == null) goto L6;
    L7:
        r3.put("invite_pageSource", r2);
        r3.put("invite_battle_play_mode", r4.c);
        return;
    L6:
        r2 = "";
        goto L7
    }

    public static void i(e r9, String r10, Map r12) {
        Integer r1 = 1;
        JSONObject r6 = new JSONObject(new HashMap(r12));
        HashMap r5 = new HashMap();
        r5.put("android_event_key", r10);
        com.bytedance.android.live.revlink.impl.global.c r13 = r9.a;
        if (r13 == null) goto L5;
        f r14 = r13.getRevenueLinkTraceMonitor();
    L6:
        if (r14 == null) goto L15;
        if (r1 != null) goto L10;
    L12:
        LiveTracingMonitorKt.EventModule r15 = LiveTracingMonitorKt.EventModule.MULTI_LINKER;
    L13:
        f r0 = r14;
        r0.Y(r10, r15, 0, null, r5, r6, null, null);
        return;
    L10:
        if (r1.intValue() != 1) goto L12;
        r15 = LiveTracingMonitorKt.EventModule.PK;
        goto L13
    L15:
        return;
    L5:
        r14 = null;
        goto L6
    }

    public final void d(long r10, Throwable r12, long r13, int r15) {
        HashMap<String, String> r7 = new HashMap();
        b(r7);
        r7.put("channel_id", String.valueOf(r10));
        if (r12 != null) goto L7;
        LiveFullLinkPKMonitor r0 = c();
        if (r0 == null) goto L11;
        LiveFullLinkPKMonitor.s(r0, "linkmic/battle/end_punish", r13, 0, r15, r7, 4);
        return;
    L11:
        return;
    L7:
        LiveFullLinkPKMonitor r1 = c();
        if (r1 == null) goto L13;
        LiveFullLinkPKMonitor.r(r1, "linkmic/battle/end_punish", r12, r13, 0, r15, r7, 8);
        return;
    }

    public final void e(long r12, PkBaseStateMachine.Source r13, Throwable r14, long r15, int r17) {
        Intrinsics.checkNotNullParameter(r13, "stateSource");
        HashMap<String, String> r8 = new HashMap();
        b(r8);
        r8.put("channel_id", String.valueOf(r12));
        r8.put("state_source", r13.getReqSrc());
        if (r14 != null) goto L7;
        LiveFullLinkPKMonitor r1 = c();
        if (r1 == null) goto L11;
        LiveFullLinkPKMonitor.s(r1, "linkmic/battle/finish", r15, 0, r17, r8, 4);
        return;
    L11:
        return;
    L7:
        LiveFullLinkPKMonitor r2 = c();
        if (r2 == null) goto L13;
        LiveFullLinkPKMonitor.r(r2, "linkmic/battle/finish", r14, r15, 0, r17, r8, 8);
        return;
    }

    public final void h(String r10, int r12, Throwable r13, int r14, long r15) {
        HashMap<String, String> r7 = new HashMap();
        b(r7);
        r7.put("inviteUid", String.valueOf(r10));
        r7.put("reply_status", String.valueOf(r12));
        if (r13 != null) goto L7;
        LiveFullLinkPKMonitor r0 = c();
        if (r0 == null) goto L11;
        LiveFullLinkPKMonitor.s(r0, "linkmic/battle/reply", r15, 0, r14, r7, 4);
        return;
    L11:
        return;
    L7:
        LiveFullLinkPKMonitor r1 = c();
        if (r1 == null) goto L13;
        LiveFullLinkPKMonitor.r(r1, "linkmic/battle/reply", r13, r15, 0, r14, r7, 8);
        return;
    }

    public final void f(long r13, String r15, c21.e r16, long r17, int r19, Throwable r20) {
        Intrinsics.checkNotNullParameter(r15, "inviteeList");
        Intrinsics.checkNotNullParameter(r16, "battleOpenParams");
        HashMap<String, String> r10 = new HashMap();
        b(r10);
        r10.put("channel_id", String.valueOf(r13));
        r10.put("invitee_list", r15);
        c21.e.a r0 = r16.a;
        r10.put("open_duration", String.valueOf(r0.a));
        PlayMode r3 = r0.c;
        String r4 = "";
        if (r3 == null) goto L6;
        String r5 = r3.toString();
        if (r5 == null) goto L6;
    L7:
        r10.put("open_playMode", r5);
        r10.put("open_inviteType", String.valueOf(r0.d.getType()));
        List<String> r6 = r0.g;
        if (r6 == null) goto L13;
        String r7 = r6.toString();
        if (r7 == null) goto L13;
        r4 = r7;
    L13:
        r10.put("open_selectAnchorIds", r4);
        r10.put("open_anchorListSize", String.valueOf(r0.h));
        r10.put("open_battle_play_mode", r16.c);
        if (r20 != null) goto L18;
        LiveFullLinkPKMonitor r8 = c();
        if (r8 == null) goto L22;
        LiveFullLinkPKMonitor.s(r8, "linkmic/battle/open", r17, 0, r19, r10, 4);
        return;
    L22:
        return;
    L18:
        LiveFullLinkPKMonitor r9 = c();
        if (r9 == null) goto L24;
        LiveFullLinkPKMonitor.r(r9, "linkmic/battle/open", r20, r17, 0, r19, r10, 8);
        return;
    L24:
        return;
    L6:
        r5 = "";
        goto L7
    }

    public final void g(long r12, String r14, JSONObject r15, long r16, int r18, Throwable r19) {
        Intrinsics.checkNotNullParameter(r14, "inviteeList");
        HashMap<String, String> r9 = new HashMap();
        b(r9);
        r9.put("channel_id", String.valueOf(r12));
        r9.put("invitee_list", r14);
        if (r15 == null) goto L6;
        String r0 = r15.toString();
        if (r0 == null) goto L6;
    L7:
        r9.put("extra", r0);
        if (r19 != null) goto L12;
        LiveFullLinkPKMonitor r2 = c();
        if (r2 == null) goto L16;
        LiveFullLinkPKMonitor.s(r2, "linkmic/battle/open", r16, 0, r18, r9, 4);
        return;
    L16:
        return;
    L12:
        LiveFullLinkPKMonitor r3 = c();
        if (r3 == null) goto L18;
        LiveFullLinkPKMonitor.r(r3, "linkmic/battle/open", r19, r16, 0, r18, r9, 8);
        return;
    L18:
        return;
    L6:
        r0 = "";
        goto L7
    }
}
