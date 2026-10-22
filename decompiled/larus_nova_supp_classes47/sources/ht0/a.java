package ht0;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.ExtraInfo;
import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.core.util.h;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import gd0.v;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kc0.e;
import kotlin.jvm.internal.Intrinsics;
import os0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends ct0.a {
    public a() {
    }

    @Override // ct0.a, bt0.a
    public final void j(HonorWallElement r2) {
        Intrinsics.checkNotNullParameter(r2, "elementInfo");
        ExtraInfo r0 = r2.getExtraInfo();
        if (r0 == null) goto L5;
        r0.getShowEvent();
    L5:
        ExtraInfo r3 = r2.getExtraInfo();
        if (r3 == null) goto L9;
        Map<String, String> r4 = r3.getShowEventParams();
        if (r4 == null) goto L9;
    L10:
        s(r4, "livesdk_pk_season_card_show");
        return;
    L9:
        r4 = new HashMap();
        goto L10
    }

    public final void s(Map<String, String> r12, String r13) {
        boolean r0 = h.a;
        e r1 = ((ILinkService) h.d(ILinkService.class)).getRevLinkControlService();
        String r2 = null;
        if (r1 == null) goto L5;
        Map<? extends String, ? extends String> r3 = r1.h();
    L6:
        if (r3 == null) goto L8;
        r12.putAll(r3);
    L8:
        o r4 = b.a();
        if (r4 == null) goto L16;
        m r5 = r4.getRoom();
        if (r5 == null) goto L16;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L16;
        String r7 = r6.getOwnerUserIdString();
        if (r7 == null) goto L16;
    L17:
        if (r4 == null) goto L23;
        m r8 = r4.getRoom();
        if (r8 == null) goto L23;
        IRoom r9 = (IRoom) r8.getValue();
        if (r9 == null) goto L23;
        long r10 = r9.getRoomId();
    L24:
        r12.put("anchor_id", r7);
        r12.put("user_type", DataType.TRUE);
        r12.put("room_id", String.valueOf(r10));
        IMiddlewareUserService r14 = k.f(IMiddlewareUserService.class);
        if (r14 == null) goto L30;
        com.bytedance.android.livesdk.user.e r15 = r14.user();
        if (r15 == null) goto L30;
        String r16 = r15.n();
        if (r16 == null) goto L30;
    L32:
        if (Intrinsics.areEqual(r7, r16) == false) goto L36;
        o0.a.getClass();
        if (o0.a.b(r7) == false) goto L36;
        r12.put("is_anchor", DataType.TRUE);
    L37:
        String r17 = r12.get("pk_id");
        if (r17 == null) goto L40;
        int r18 = r17.length();
    L41:
        String r19 = "";
        if (r18 > 1) goto L44;
        r12.put("is_oncemore", "");
        r12.put("is_manager", "");
    L44:
        com.bytedance.android.live.profile.ui.base.h r20 = this.a;
        if (r20 == null) goto L47;
        Intrinsics.checkNotNullParameter(r20, "$this$targetUserId");
        String r22 = r20.getPageTypeUseCase().h;
    L48:
        String r23 = String.valueOf(r22);
        if (Intrinsics.areEqual(r23, r7) == false) goto L51;
        r12.put("user_type", DataType.TRUE);
    L63:
        com.bytedance.android.live.profile.ui.base.h r24 = this.a;
        if (r24 == null) goto L71;
        UserProfileEvent r25 = r24.getUserProfileEvent();
        if (r25 == null) goto L71;
        String r26 = r25.getClickUserPosition();
        if (r26 == null) goto L71;
        r19 = r26;
    L71:
        r12.put("click_user_position", r19);
        j0.l().sendLog(r13, r12, new Object[0]);
        return;
    L51:
        e r27 = ((ILinkService) h.d(ILinkService.class)).getRevLinkControlService();
        if (r27 == null) goto L55;
        r2 = r27.k();
    L55:
        if (Intrinsics.areEqual(r23, r2) == true) goto L62;
        p11.e r28 = ((ILinkService) h.d(ILinkService.class)).mo468getMultiAnchorService();
        if (r28 != null) goto L59;
    L61:
        r12.put("user_type", DataType.FALSE);
        goto L63
    L59:
        if (r28.a(r23) != true) goto L61;
    L62:
        r12.put("user_type", "32");
        goto L63
    L47:
        r22 = null;
        goto L48
    L40:
        r18 = 0;
    L36:
        r12.put("is_anchor", DataType.FALSE);
    L30:
        r16 = DataType.FALSE;
    L23:
        r10 = 0;
    L16:
        r7 = DataType.FALSE;
        goto L17
    L5:
        r3 = null;
        goto L6
    }

    @Override // ct0.a, bt0.a
    public final void d(Fragment r4, View r5, HonorWallElement r6, NewProfileUser r7, com.bytedance.android.live.profile.ui.base.h r8) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "honourCardView");
        Intrinsics.checkNotNullParameter(r6, "elementInfo");
        Intrinsics.checkNotNullParameter(r7, "user");
        Intrinsics.checkNotNullParameter(r8, "profileContext");
        ExtraInfo r9 = r6.getExtraInfo();
        if (r9 == null) goto L6;
        String r10 = r9.getScheme();
        if (r10 == null) goto L6;
    L7:
        IMiddlewareUserService r12 = k.f(IMiddlewareUserService.class);
        String r0 = DataType.FALSE;
        if (r12 == null) goto L13;
        com.bytedance.android.livesdk.user.e r13 = r12.user();
        if (r13 == null) goto L13;
        String r14 = r13.n();
        if (r14 == null) goto L13;
    L14:
        o r1 = b.a();
        if (r1 == null) goto L24;
        m r2 = r1.getRoom();
        if (r2 == null) goto L24;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L24;
        String r15 = r3.getOwnerUserIdString();
        if (r15 == null) goto L24;
        r0 = r15;
    L24:
        boolean r16 = h.a;
        e r17 = ((ILinkService) h.d(ILinkService.class)).getRevLinkControlService();
        if (r17 == null) goto L27;
        Integer r18 = Integer.valueOf(r17.getCurrentMode());
    L28:
        int r19 = r18.intValue();
        Intrinsics.checkNotNullParameter(r8, "$this$targetUserId");
        String r20 = r8.getPageTypeUseCase().h;
        if (v.a(r19, 4) == false) goto L31;
    L34:
        int r22 = 1;
    L35:
        String r23 = r10 + "&user_id=" + r14 + "&anchor_id=" + r0 + "&is_interacting=" + r22 + "&show_user_id=" + r20;
        IBaseLiveActionHandler r24 = k.f(IBaseLiveActionHandler.class);
        if (r24 == null) goto L38;
        r24.handle(r5.getContext(), r23);
    L38:
        ExtraInfo r25 = r6.getExtraInfo();
        if (r25 == null) goto L42;
        Map<String, String> r26 = r25.getShowEventParams();
        if (r26 == null) goto L42;
    L43:
        s(r26, "livesdk_pk_season_card_click");
        return;
    L42:
        r26 = new HashMap();
        goto L43
    L31:
        if (v.a(r19, 64) == true) goto L34;
        r22 = 0;
        goto L35
    L27:
        r18 = null;
    L13:
        r14 = DataType.FALSE;
    L6:
        r10 = "";
        goto L7
    }
}
