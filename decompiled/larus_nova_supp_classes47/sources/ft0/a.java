package ft0;

import am2.x;
import android.view.View;
import androidx.fragment.app.Fragment;
import ca0.j;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.ExtraInfo;
import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.base.i;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import mv0.b0;
import mv0.k;
import os0.b;
import qs0.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends ct0.a {
    public a() {
    }

    @Override // ct0.a, bt0.a
    public final void j(HonorWallElement r15) {
        Intrinsics.checkNotNullParameter(r15, "elementInfo");
        u r16 = b.c().getIPkAudienceLinkOutServiceProxy();
        Object r0 = null;
        if (r16 == null) goto L5;
        b0.a r17 = r16.getPkLinkUserInfoCenter();
    L6:
        k.d r1 = b.c().getIInteractService().getLinkUserInfoCenter();
        HashMap r2 = new HashMap();
        r2.put("card_type", "old");
        h r3 = this.a;
        if (r3 != null) goto L9;
    L11:
        String r4 = "nabob_sponsor";
    L12:
        r2.put("giftwall_entrance_type", r4);
        IMiddlewareUserService r5 = jc1.k.f(IMiddlewareUserService.class);
        String r7 = "group_member";
        if (r5 == null) goto L54;
        e r6 = r5.user();
        if (r6 == null) goto L54;
        String r8 = r6.n();
        if (r8 == null) goto L54;
        if (r17 == null) goto L20;
        Integer r12 = Integer.valueOf(r17.k(r8));
    L23:
        if (r12 == null) goto L25;
        int r13 = r12.intValue();
    L26:
        o r14 = b.a();
        if (r14 == null) goto L33;
        m r18 = r14.getRoom();
        if (r18 == null) goto L33;
        IRoom r19 = (IRoom) r18.getValue();
        if (r19 == null) goto L33;
        String r110 = r19.getOwnerUserIdString();
    L35:
        if (Intrinsics.areEqual(r110, r8) == false) goto L37;
        Object r9 = "anchor";
    L53:
        r2.put("user_type", r9);
        goto L54
    L37:
        if (r13 == (-1)) goto L39;
        r9 = "guest";
        goto L53
    L39:
        boolean r111 = com.bytedance.android.live.revenue.core.util.h.a;
        List r112 = com.bytedance.android.live.revenue.core.util.h.d(j.class).getGroupMemberList();
        if (r112 == null) goto L49;
        Iterator r113 = r112.iterator();
    L43:
        if (r113.hasNext() == false) goto L47;
        Object r114 = r113.next();
        if (Intrinsics.areEqual(((IBaseUser) r114).getIdString(), r8) == false) goto L43;
    L48:
        IBaseUser r115 = (IBaseUser) r114;
    L50:
        if (r115 == null) goto L52;
        r9 = "group_member";
        goto L53
    L52:
        r9 = "user";
        goto L53
    L47:
        r114 = null;
        goto L48
    L49:
        r115 = null;
    L33:
        r110 = null;
        goto L35
    L25:
        r13 = -1;
        goto L26
    L20:
        if (r1 == null) goto L22;
        r12 = Integer.valueOf(r1.o(r8));
        goto L23
    L22:
        r12 = null;
    L54:
        h r10 = this.a;
        if (r10 == null) goto L61;
        NewProfileUser r20 = r10.getTargetUser();
        if (r20 == null) goto L61;
        BaseProfileInfo r22 = r20.baseProfileInfo;
        if (r22 == null) goto L61;
        String r23 = r22.getIdStr();
    L62:
        String r24 = String.valueOf(r23);
        if (r17 == null) goto L65;
        Integer r116 = Integer.valueOf(r17.k(r24));
    L68:
        if (r116 == null) goto L70;
        int r117 = r116.intValue();
    L71:
        o r25 = b.a();
        if (r25 == null) goto L78;
        m r26 = r25.getRoom();
        if (r26 == null) goto L78;
        IRoom r27 = (IRoom) r26.getValue();
        if (r27 == null) goto L78;
        String r28 = r27.getOwnerUserIdString();
    L80:
        if (Intrinsics.areEqual(r28, r24) == false) goto L82;
        r7 = "anchor";
    L96:
        r2.put("to_user_type", r7);
        h r118 = this.a;
        if (r118 != null) goto L99;
    L101:
        String r119 = DataType.Normal;
    L102:
        r2.put("show_from", r119);
        m r120 = b.a().getRoom();
        if (r120 == null) goto L113;
        IRoom r121 = (IRoom) r120.getValue();
        if (r121 == null) goto L113;
        IRoomOthersData r122 = r121.getRoomOthers();
        if (r122 == null) goto L113;
        IGroupLiveData r123 = r122.getGroupData();
        if (r123 == null) goto L113;
        if (r123.isGroupLive() != 1) goto L113;
        r2.put("is_grouped_lived", DataType.TRUE);
    L113:
        r2.put("entry_from", "old");
        boolean r124 = com.bytedance.android.live.revenue.core.util.h.a;
        ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).mo471getRevenueLinkDataHolder();
        h r125 = this.a;
        if (r125 == null) goto L123;
        r125.sendLog("livesdk_giftwall_profile_card_show", r2, new Object[]{xs0.a.a(), IRoom.class, x.class});
        return;
    L123:
        return;
    L99:
        if (i.h(r118) != true) goto L101;
        r119 = "open_package";
        goto L102
    L82:
        if (r117 == (-1)) goto L84;
        r7 = "guest";
        goto L96
    L84:
        boolean r126 = com.bytedance.android.live.revenue.core.util.h.a;
        List r127 = com.bytedance.android.live.revenue.core.util.h.d(j.class).getGroupMemberList();
        if (r127 == null) goto L93;
        Iterator r128 = r127.iterator();
    L88:
        if (r128.hasNext() == false) goto L92;
        Object r29 = r128.next();
        if (Intrinsics.areEqual(((IBaseUser) r29).getIdString(), r24) == false) goto L88;
        r0 = r29;
    L92:
        r0 = (IBaseUser) r0;
    L93:
        if (r0 == null) goto L95;
        r2.put("group_member_id", r24);
        goto L96
    L95:
        r7 = "user";
    L78:
        r28 = null;
        goto L80
    L70:
        r117 = -1;
        goto L71
    L65:
        if (r1 == null) goto L67;
        r116 = Integer.valueOf(r1.o(r24));
        goto L68
    L67:
        r116 = null;
    L61:
        r23 = null;
        goto L62
    L9:
        if (i.l(r3) != true) goto L11;
        r4 = "normal_entrance";
        goto L12
    L5:
        r17 = null;
        goto L6
    }

    @Override // ct0.a, bt0.a
    public final void d(Fragment r8, View r9, HonorWallElement r10, NewProfileUser r12, h r13) {
        Intrinsics.checkNotNullParameter(r8, "fragment");
        Intrinsics.checkNotNullParameter(r9, "honourCardView");
        Intrinsics.checkNotNullParameter(r10, "elementInfo");
        String r3 = "user";
        Intrinsics.checkNotNullParameter(r12, "user");
        Intrinsics.checkNotNullParameter(r13, "profileContext");
        Intrinsics.checkNotNullParameter(r8, "fragment");
        Intrinsics.checkNotNullParameter(r9, "honourCardView");
        Intrinsics.checkNotNullParameter(r10, "elementInfo");
        Intrinsics.checkNotNullParameter(r12, "user");
        Intrinsics.checkNotNullParameter(r13, "profileContext");
        Object r14 = null;
        ExtraInfo r15 = r10.getExtraInfo();     // Catch: Exception -> L12
        if (r15 == null) goto L18;
        String r16 = r15.getScheme();     // Catch: Exception -> L12
        if (r16 == null) goto L18;
        IBaseLiveActionHandler r17 = jc1.k.f(IBaseLiveActionHandler.class);     // Catch: Exception -> L12
        if (r17 == null) goto L18;
        r17.handle(r9.getContext(), r16);     // Catch: Exception -> L12
    L18:
        LinkedHashMap r18 = new LinkedHashMap();
        IMiddlewareUserService r19 = jc1.k.f(IMiddlewareUserService.class);
        if (r19 == null) goto L24;
        e r110 = r19.user();
        if (r110 == null) goto L24;
        String r111 = r110.n();
        if (r111 == null) goto L24;
    L25:
        r18.put("user_id", r111);
        IMiddlewareUserService r112 = jc1.k.f(IMiddlewareUserService.class);
        if (r112 == null) goto L31;
        e r113 = r112.user();
        if (r113 == null) goto L31;
        String r114 = r113.n();
        if (r114 == null) goto L31;
    L32:
        u r115 = b.c().getIPkAudienceLinkOutServiceProxy();
        if (r115 == null) goto L35;
        b0.a r116 = r115.getPkLinkUserInfoCenter();
    L37:
        if (r116 == null) goto L39;
        int r0 = r116.k(r114);
    L45:
        o r1 = b.a();
        if (r1 == null) goto L52;
        m r2 = r1.getRoom();
        if (r2 == null) goto L52;
        IRoom r4 = (IRoom) r2.getValue();
        if (r4 == null) goto L52;
        String r5 = r4.getOwnerUserIdString();
    L54:
        if (Intrinsics.areEqual(r5, r114) == false) goto L56;
        Object r6 = "anchor";
    L72:
        r18.put("user_type", r6);
        h r7 = this.a;
        if (r7 == null) goto L79;
        NewProfileUser r20 = r7.getTargetUser();
        if (r20 == null) goto L79;
        BaseProfileInfo r22 = r20.baseProfileInfo;
        if (r22 == null) goto L79;
        String r23 = r22.getIdStr();
    L80:
        String r24 = String.valueOf(r23);
        if (r116 == null) goto L83;
        int r117 = r116.k(r24);
    L89:
        o r25 = b.a();
        if (r25 == null) goto L96;
        m r26 = r25.getRoom();
        if (r26 == null) goto L96;
        IRoom r27 = (IRoom) r26.getValue();
        if (r27 == null) goto L96;
        String r28 = r27.getOwnerUserIdString();
    L98:
        if (Intrinsics.areEqual(r28, r24) == false) goto L100;
        r3 = "anchor";
    L113:
        r18.put("to_user_type", r3);
        m r29 = b.a().getRoom();
        if (r29 == null) goto L124;
        IRoom r30 = (IRoom) r29.getValue();
        if (r30 == null) goto L124;
        IRoomOthersData r32 = r30.getRoomOthers();
        if (r32 == null) goto L124;
        IGroupLiveData r33 = r32.getGroupData();
        if (r33 == null) goto L124;
        if (r33.isGroupLive() != 1) goto L124;
        r18.put("is_grouped_lived", DataType.TRUE);
    L124:
        r18.put("entry_from", "old");
        h r34 = this.a;
        if (r34 == null) goto L136;
        r34.sendLog("livesdk_giftwall_profile_card_click", r18, new Object[]{x.class, IRoom.class});
        return;
    L136:
        return;
    L100:
        if (r117 == (-1)) goto L102;
        r3 = "guest";
        goto L113
    L102:
        boolean r118 = com.bytedance.android.live.revenue.core.util.h.a;
        List r119 = com.bytedance.android.live.revenue.core.util.h.d(j.class).getGroupMemberList();
        if (r119 == null) goto L111;
        Iterator r120 = r119.iterator();
    L106:
        if (r120.hasNext() == false) goto L110;
        Object r121 = r120.next();
        if (Intrinsics.areEqual(((IBaseUser) r121).getIdString(), r114) == false) goto L106;
        r14 = r121;
    L110:
        r14 = (IBaseUser) r14;
    L111:
        if (r14 == null) goto L113;
        r18.put("group_member_id", r114);
        r3 = "group_member";
    L96:
        r28 = null;
        goto L98
    L83:
        qs0.i r122 = b.c().getIInteractService();
        if (r122 == null) goto L88;
        k.d r123 = r122.getLinkUserInfoCenter();
        if (r123 == null) goto L88;
        r117 = r123.o(r24);
    L88:
        r117 = -1;
    L79:
        r23 = null;
        goto L80
    L56:
        if (r0 == (-1)) goto L58;
        r6 = "guest";
        goto L72
    L58:
        boolean r35 = com.bytedance.android.live.revenue.core.util.h.a;
        List r36 = com.bytedance.android.live.revenue.core.util.h.d(j.class).getGroupMemberList();
        if (r36 == null) goto L68;
        Iterator r37 = r36.iterator();
    L62:
        if (r37.hasNext() == false) goto L66;
        Object r38 = r37.next();
        if (Intrinsics.areEqual(((IBaseUser) r38).getIdString(), r114) == false) goto L62;
    L67:
        IBaseUser r39 = (IBaseUser) r38;
    L69:
        if (r39 == null) goto L71;
        r6 = "group_member";
        goto L72
    L71:
        r6 = "user";
        goto L72
    L66:
        r38 = null;
        goto L67
    L68:
        r39 = null;
    L52:
        r5 = null;
        goto L54
    L39:
        qs0.i r40 = b.c().getIInteractService();
        if (r40 == null) goto L44;
        k.d r42 = r40.getLinkUserInfoCenter();
        if (r42 == null) goto L44;
        r0 = r42.o(r114);
    L44:
        r0 = -1;
        goto L45
    L35:
        r116 = null;
    L31:
        r114 = DataType.FALSE;
    L24:
        r111 = "";
    L12:
        e = move-exception;
        StringBuilder r124 = new StringBuilder("handle schame: ");
        ExtraInfo r125 = r10.getExtraInfo();
        if (r125 == null) goto L16;
        String r126 = r125.getScheme();
    L17:
        r124.append(r126);
        r124.append(", error: ");
        r124.append(e.getMessage());
        ALogger.e("StandardHonourCardItem", r124.toString());
        SafetyGuard.a(null, e, null);
        goto L18
    L16:
        r126 = null;
        goto L17
    }
}
