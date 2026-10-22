package p82;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.h0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.pin.utils.PinAppLogger;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o extends a {
    public Boolean e;
    public TextView f;
    public boolean g;
    public final RoomContext h;

    @Override // p82.a
    public final int e() {
        return 2131567222;
    }

    public o(RoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        super(PanelItemSymbol.LINK_MIC);
        this.h = r2;
        this.g = true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.l r13) {
        Intrinsics.checkNotNullParameter(r13, "event");
        com.bytedance.android.live.base.model.message.t r14 = r13.b;
        String r1 = null;
        if ((r14 instanceof h0) == true) goto L5;
        r14 = null;
    L5:
        h0 r15 = (h0) r14;
        if (r15 == null) goto L8;
        IBaseUser r16 = r15.getChatUserInfo();
    L10:
        if ((r16 instanceof User) == true) goto L12;
        r16 = null;
    L12:
        User r17 = (User) r16;
        if (r17 == null) goto L110;
        boolean r2 = ((Boolean) this.h.isAnchor().getValue()).booleanValue();
        if (r2 == false) goto L18;
    L21:
        boolean r4 = true;
    L22:
        RoomContext.a r5 = RoomContext.Companion;
        RoomContext r9 = RoomContext.a.c(r5, null, 0, 3);
        if (r9 == null) goto L31;
        com.bytedance.live.datacontext.m r10 = r9.getRoom();
        if (r10 == null) goto L31;
        Room r11 = (Room) r10.getValue();
        if (r11 == null) goto L31;
        Map r18 = r11.anchorAbMap;
        if (r18 == null) goto L31;
        String r19 = (String) r18.get("enable_comment_extension_for_interaction");
    L33:
        if (Intrinsics.areEqual(r19, "0") == true) goto L107;
        if (r4 == false) goto L111;
        RoomContext r6 = RoomContext.a.c(r5, null, 0, 3);
        if (r6 == null) goto L41;
        com.bytedance.live.datacontext.j r7 = r6.getVideoTalkRoomSubScene();
        if (r7 == null) goto L41;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r8 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r7.getValue();
    L42:
        RoomContext r20 = RoomContext.a.c(r5, null, 0, 3);
        if (r20 == null) goto L47;
        com.bytedance.live.datacontext.j r21 = r20.getVoiceTalkRoomSubScene();
        if (r21 == null) goto L47;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r23 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r21.getValue();
    L48:
        if (r8 != null) goto L50;
    L51:
        if (r23 != null) goto L53;
    L55:
        int r24 = 0;
    L56:
        int r25 = jc1.k.n(ILinkServiceExternal.class).getControlServiceExternal().getCurrentMode();
        RoomContext r110 = RoomContext.a.c(r5, null, 0, 3);
        if (r110 == null) goto L61;
        com.bytedance.live.datacontext.i r111 = r110.getLiveMode();
        if (r111 == null) goto L61;
        LiveMode r112 = (LiveMode) r111.getValue();
    L63:
        if (r112 != LiveMode.VIDEO) goto L65;
        boolean r113 = true;
    L66:
        if (r24 != 0) goto L71;
        if (r25 != 0) goto L71;
        if (r2 == false) goto L71;
        if (r113 == false) goto L71;
        boolean r3 = true;
    L72:
        if (r24 != 0) goto L74;
        if (r3 == true) goto L74;
        return false;
    L74:
        IInteractService r26 = jc1.k.f(IInteractService.class);
        if (r26 == null) goto L79;
        com.bytedance.android.live.liveinteract.plantform.base.i r27 = r26.getLinkUserInfoCenter();
        if (r27 == null) goto L79;
        Boolean r28 = r27.Z4();
    L81:
        if (Intrinsics.areEqual(r28, Boolean.TRUE) == true) goto L109;
        IInteractService r29 = jc1.k.f(IInteractService.class);
        if (r29 == null) goto L87;
        com.bytedance.android.live.liveinteract.plantform.base.i r30 = r29.getLinkUserInfoCenter();
        if (r30 == null) goto L87;
        int r31 = r30.O4(r17.getIdString());
    L88:
        if (r31 <= 0) goto L91;
        return false;
    L91:
        if (jc1.k.n(IUserService.class).user().c() == false) goto L102;
        String r33 = r17.getIdString();
        RoomContext r34 = RoomContext.a.c(r5, null, 0, 3);
        if (r34 == null) goto L100;
        com.bytedance.live.datacontext.m r35 = r34.getRoom();
        if (r35 == null) goto L100;
        Room r36 = (Room) r35.getValue();
        if (r36 == null) goto L100;
        r1 = r36.getOwnerUserIdString();
    L100:
        if (Intrinsics.areEqual(r33, r1) == false) goto L102;
        return false;
    L102:
        int r0 = r24 ^ 1;
        IInteractService r37 = jc1.k.f(IInteractService.class);
        if (r37 == null) goto L105;
        r37.getUserWaitingInfo(r17.getIdString(), r0, new n(this, r17));
    L105:
        return true;
    L87:
        r31 = -1;
        goto L88
    L109:
        return false;
    L79:
        r28 = null;
    L71:
        r3 = false;
        goto L72
    L65:
        r113 = false;
    L61:
        r112 = null;
        goto L63
    L53:
        if (r23.t().a <= 0) goto L55;
    L54:
        r24 = 1;
        goto L56
    L50:
        if (r8.t().a > 0) goto L54;
    L47:
        r23 = null;
    L41:
        r8 = null;
        goto L42
    L111:
        return false;
    L107:
        return false;
    L31:
        r19 = null;
        goto L33
    L18:
        if (jc1.k.n(IUserService.class).user().c() == true) goto L21;
        r4 = false;
        goto L22
    L110:
        return false;
    L8:
        r16 = null;
        goto L10
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r11) {
        super.onClick(r11);
        boolean r0 = false;
        if (this.g == true) goto L6;
        f2.c(s1.B(2131921790), 0);
        return;
    L6:
        boolean r13 = Intrinsics.areEqual(this.e, Boolean.TRUE);
        com.bytedance.android.livesdk.interactivity.api.entity.l r1 = this.b;
        Room r2 = null;
        if (r1 == null) goto L9;
        com.bytedance.android.live.base.model.message.t r3 = r1.b;
    L11:
        if ((r3 instanceof h0) == true) goto L13;
        r3 = null;
    L13:
        h0 r4 = (h0) r3;
        if (r4 == null) goto L16;
        IBaseUser r5 = r4.getChatUserInfo();
    L18:
        if ((r5 instanceof User) == true) goto L20;
        r5 = null;
    L20:
        User r6 = (User) r5;
        RoomContext.a r7 = RoomContext.Companion;
        RoomContext r8 = RoomContext.a.c(r7, null, 0, 3);
        if (r8 == null) goto L25;
        com.bytedance.live.datacontext.j r9 = r8.getVideoTalkRoomSubScene();
        if (r9 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r10 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r9.getValue();
    L26:
        RoomContext r14 = RoomContext.a.c(r7, null, 0, 3);
        if (r14 == null) goto L31;
        com.bytedance.live.datacontext.j r15 = r14.getVoiceTalkRoomSubScene();
        if (r15 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r16 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r15.getValue();
    L33:
        if (r10 != null) goto L35;
    L36:
        if (r16 != null) goto L38;
    L40:
        if (r0 == false) goto L44;
        if (r13 == false) goto L43;
        jc1.k.n(IInteractService.class).permit(r6, "public_screen_area");
    L61:
        if (r6 != null) goto L63;
        return;
    L63:
        PinAppLogger.c(r6.getIdString(), !r13);
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r17 = this.c;
        if (r17 == null) goto L67;
        r17.dismissDialog();
        return;
    L67:
        return;
    L43:
        xs2.b.a().post(new o42.g(r6));
        goto L61
    L44:
        if (r13 == false) goto L53;
        RoomContext r18 = RoomContext.a.c(r7, null, 0, 3);
        if (r18 == null) goto L50;
        com.bytedance.live.datacontext.m r19 = r18.getRoom();
        if (r19 == null) goto L50;
        r2 = (Room) r19.getValue();
    L50:
        if (r2 == null) goto L61;
        if (r6 == null) goto L61;
        jc1.k.n(IInteractService.class).permitPrepareApply(r2.getRoomId(), r6.getIdString());
        goto L61
    L53:
        RoomContext r20 = RoomContext.a.c(r7, null, 0, 3);
        if (r20 == null) goto L58;
        com.bytedance.live.datacontext.m r21 = r20.getRoom();
        if (r21 == null) goto L58;
        r2 = (Room) r21.getValue();
    L58:
        if (r2 == null) goto L61;
        if (r6 == null) goto L61;
        jc1.k.n(IInteractService.class).prepareInvite(r2.getRoomId(), r6, "associated_invite");
        goto L61
    L38:
        if (r16.t().a <= 0) goto L40;
    L39:
        r0 = true;
        goto L40
    L35:
        if (r10.t().a > 0) goto L39;
    L31:
        r16 = null;
    L25:
        r10 = null;
        goto L26
    L16:
        r5 = null;
        goto L18
    L9:
        r3 = null;
        goto L11
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void c(com.bytedance.android.livesdk.interactivity.api.entity.l r4, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r5) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r5, "bridge");
        super.c(r4, r5);
        com.bytedance.android.live.base.model.message.t r6 = r4.b;
        TextView r1 = null;
        if ((r6 instanceof h0) == true) goto L5;
        r6 = null;
    L5:
        h0 r7 = (h0) r6;
        if (r7 == null) goto L8;
        IBaseUser r8 = r7.getChatUserInfo();
    L10:
        if ((r8 instanceof User) == true) goto L12;
        r8 = null;
    L12:
        User r9 = (User) r8;
        if (r9 != null) goto L15;
        return;
    L15:
        String r10 = r9.getIdString();
        Boolean r0 = this.e;
        Boolean r2 = Boolean.TRUE;
        PinAppLogger.d(r10, !Intrinsics.areEqual(r0, r2));
        View r11 = getView(r4.getContext());
        if (r11 == null) goto L18;
        r1 = (TextView) r11.findViewById(2131390877);
    L18:
        this.f = r1;
        if (Intrinsics.areEqual(this.e, r2) == false) goto L23;
        TextView r13 = this.f;
        if (r13 == null) goto L27;
        r13.setText(2131915871);
        return;
    L27:
        return;
    L23:
        TextView r14 = this.f;
        if (r14 == null) goto L29;
        r14.setText(2131915880);
        return;
    L29:
        return;
    L8:
        r8 = null;
        goto L10
    }
}
