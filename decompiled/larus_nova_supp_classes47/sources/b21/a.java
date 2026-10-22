package b21;

import c21.f;
import c21.l;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.multianchor.vm.g;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import cy0.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;
import mz0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public a(LinkFakeGlobalService r1) {
        this.a = r1;
    }

    public final Map<String, String> a(c21.b r9) {
        Intrinsics.checkNotNullParameter(r9, "battleInviteParams");
        l r0 = r9.a;
        LinkedHashMap r1 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r2 = this.a;
        g r3 = null;
        if (r2 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r4 = r2.Q1();
    L6:
        if (r4 == null) goto L8;
        r1.putAll(r4.getCurrentSceneLogParam());
    L8:
        f r5 = r9.b;
        if ((r5 instanceof f.h) == false) goto L14;
        if (r9.a.c != 2) goto L14;
        String r6 = "team_pk";
    L44:
        r1.put("invite_mode", r6);
        if (r0.d == false) goto L47;
        String r7 = DataType.TRUE;
    L48:
        r1.put("is_oncemore", r7);
        r1.put("invite_type", "play");
        r1.put("invitee_room_status", "pk");
        com.bytedance.android.live.revlink.impl.global.c r8 = this.a;
        if (r8 == null) goto L51;
        w r10 = r8.getMultiLinkUtil();
    L52:
        if (r10 == null) goto L58;
        i11.b r12 = r10.a();
        if (r12 == null) goto L58;
        List<p> r13 = r12.getOnlineUserList();
        if (r13 == null) goto L58;
        Integer r14 = Integer.valueOf(r13.size());
    L59:
        r1.put("invitee_connect_cnt", String.valueOf(r14));
        com.bytedance.android.live.revlink.impl.global.c r15 = this.a;
        if (r15 == null) goto L62;
        d31.d r16 = r15.getRevLinkLogHelper();
    L63:
        String r17 = "";
        if (r16 == null) goto L67;
        String r18 = r16.a();
        if (r18 == null) goto L67;
    L68:
        r1.put("audience_connect_cnt", r18);
        r1.put("anchor_connection_type", "invite");
        com.bytedance.android.live.revlink.impl.global.c r19 = this.a;
        if (r19 == null) goto L71;
        d31.d r20 = r19.getRevLinkLogHelper();
    L72:
        boolean r22 = false;
        if (r20 == null) goto L84;
        com.bytedance.android.live.revlink.impl.global.c r23 = this.a;
        if (r23 == null) goto L77;
        r3 = r23.getMultiAnchorLinkContextObj();
    L77:
        if (r3 == null) goto L79;
        int r24 = r3.b();
    L80:
        String r25 = r20.p(r24);
        if (r25 == null) goto L84;
        r17 = r25;
        goto L84
    L79:
        r24 = 0;
    L84:
        r1.put("invitee_list", r17);
        r1.put("pk_time", String.valueOf(r0.b));
        f r26 = r9.b;
        if ((r26 instanceof f.l) == false) goto L87;
        int r27 = c0.a;
        c0.a(((f.l) r26).b, r1);
    L87:
        r1.put("list_num", DataType.FALSE);
        r1.put("stay_time", String.valueOf(r0.e / 1000));
        f r28 = r9.b;
        if ((r28 instanceof f.m) == false) goto L96;
        aa r29 = ((f.m) r28).b;
        if (r29 == null) goto L96;
        if (r29.getVoteDes().length() <= 0) goto L94;
        r22 = true;
    L94:
        if (r22 == false) goto L96;
        r1.put(FileUtils.PICTURE_THEME, r29.getVoteDes());
    L96:
        return r1;
    L71:
        r20 = null;
    L67:
        r18 = "";
        goto L68
    L62:
        r16 = null;
    L58:
        r14 = null;
        goto L59
    L51:
        r10 = null;
        goto L52
    L47:
        r7 = DataType.FALSE;
    L14:
        if ((r5 instanceof f.m) == false) goto L17;
        r6 = "vote";
        goto L44
    L17:
        if ((r5 instanceof f.d) == false) goto L20;
    L36:
        r6 = "customize_pk";
        goto L44
    L20:
        if ((r5 instanceof f.k) == false) goto L23;
        r6 = "compete";
        goto L44
    L23:
        if ((r5 instanceof f.l) == false) goto L26;
        r6 = "focus_gift";
        goto L44
    L26:
        if ((r5 instanceof f.a) == false) goto L29;
        r6 = "cooperation";
        goto L44
    L29:
        if ((r5 instanceof f.e) == false) goto L32;
        r6 = "activity_pk";
        goto L44
    L32:
        if ((r5 instanceof f.i) == false) goto L35;
        r6 = "c_position";
        goto L44
    L35:
        if ((r5 instanceof f.g) == true) goto L36;
        if ((r5 instanceof f.c) == false) goto L41;
        r6 = "cohostgame";
        goto L44
    L41:
        if ((r5 instanceof f.b) == false) goto L43;
        r6 = "link_screen";
        goto L44
    L43:
        r6 = "routine_pk";
        goto L44
    L5:
        r4 = null;
        goto L6
    }

    public final void b(Map<String, String> r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "logMap");
        Intrinsics.checkNotNullParameter(r5, "eventName");
        n r0 = new n();
        o r1 = new o(r0.a);
        r1.b(r4);
        com.bytedance.android.live.revlink.impl.global.c r6 = this.a;
        p0 r2 = null;
        if (r6 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r7 = r6.rb();
    L6:
        if (r7 == null) goto L10;
        com.bytedance.live.datacontext.n<p0> r8 = r7.getLaunchBattleAttachInfo();
        if (r8 == null) goto L10;
        r2 = (p0) r8.getValue();
    L10:
        e21.c.e(r1, r2);
        m r9 = new m();
        r9.b(LogCommon.ROOM);
        ((ArrayList) r0.b).addAll(r9.a);
        cy0.e.a.getClass();
        j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r12 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r12);
        ((i) ((f80.a) r12)).w3(r5, r0.a, r0.b);
        return;
    L5:
        r7 = null;
        goto L6
    }
}
