package p82;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.message.h0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.pin.ui.PinTipsDialog;
import com.bytedance.android.livesdk.interactivity.pin.utils.PinAppLogger;
import com.bytedance.android.livesdk.message.model.bd;
import com.bytedance.android.livesdk.message.model.fn;
import com.bytedance.android.livesdkapi.depend.model.live.CommentPinContent;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.bdlocation.BuildConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u extends a {
    public final RoomContext e;

    @Override // p82.a
    public final int e() {
        return 2131567227;
    }

    public u(RoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        super(PanelItemSymbol.PIN_COMMENT_SYMBOL);
        this.e = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.l r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        RoomAuthStatus r0 = ((Room) this.e.getRoom().getValue()).getMRoomAuthStatus();
        if (r0 != null) goto L5;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L13;
        return false;
    L13:
        if (com.bytedance.android.livesdk.interactivity.utils.s.c(r8) == false) goto L23;
        int r9 = com.bytedance.android.livesdk.interactivity.common.utils.g.a;
        String r3 = null;
        RoomContext r10 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r10 == null) goto L22;
        com.bytedance.live.datacontext.m r11 = r10.getRoom();
        if (r11 == null) goto L22;
        Room r13 = (Room) r11.getValue();
        if (r13 == null) goto L22;
        r3 = r13.getAnchorAbValue("live_video_on_wall");
    L22:
        return TextUtils.equals("1", r3);
    L23:
        com.bytedance.android.livesdk.interactivity.utils.s.a(r8);
        return true;
    L5:
        if (r0.enablePinComment != 1) goto L9;
        if (com.bytedance.android.livesdk.interactivity.common.utils.h.b(((Boolean) this.e.isAnchor().getValue()).booleanValue()) == false) goto L9;
        r1 = true;
        goto L10
    }

    public final void f(g42.h<?> r4) {
        if (((Boolean) new com.bytedance.android.livesdk.sharedpref.e("has_show_pin_tips_dialog", Boolean.FALSE).getValue()).booleanValue() == true) goto L13;
        com.bytedance.android.livesdk.interactivity.api.entity.l r0 = this.b;
        if (r0 == null) goto L18;
        Context r1 = r0.getContext();
        if (r1 == null) goto L19;
        PinTipsDialog r2 = new PinTipsDialog(r1, r4);
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(r2);
        return;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L12:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
        return;
    L19:
        return;
    L18:
        return;
    L13:
        k42.b.a(r4);
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r13) {
        super.onClick(r13);
        com.bytedance.android.livesdk.interactivity.api.entity.l r14 = this.b;
        if (r14 == null) goto L86;
        h0 r0 = r14.b;
        if (r0 == null) goto L88;
        boolean r1 = r0 instanceof h0;
        if (r1 == true) goto L10;
        return;
    L10:
        String r4 = null;
        if (com.bytedance.android.livesdk.interactivity.utils.s.c(r14) == false) goto L37;
        if ((r0 instanceof fn) == true) goto L15;
        h0 r2 = null;
    L16:
        fn r3 = (fn) r2;
        if (r3 == null) goto L19;
        long r5 = r3.getItemId();
    L20:
        long r6 = r5;
        h0 r7 = r0;
        long r8 = r7.getPinBaseMessageId();
        String r9 = r7.getChatUserInfo().getRealNickName();
        if (r9 != null) goto L23;
        String r10 = BuildConfig.FLAVOR;
    L24:
        String r11 = r7.getChatUserInfo();
        if ((r11 instanceof User) == false) goto L28;
        r4 = r11;
    L28:
        User r15 = (User) r4;
        if (r15 == null) goto L34;
        String r16 = r15.getIdString();
        if (r16 == null) goto L34;
        String r17 = r16;
    L35:
        k42.e r18 = new k42.e(r6, r8, r10, r17);
        PinAppLogger.e(r18.b, "pin_video");
        o32.a.a("click pin video. msgId=" + r18.c);
        f(new k42.a(r18));
    L81:
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r19 = this.c;
        if (r19 == null) goto L87;
        r19.dismissDialog();
        return;
    L87:
        return;
    L34:
        r17 = BuildConfig.FLAVOR;
        goto L35
    L23:
        r10 = r9;
        goto L24
    L19:
        r5 = 0;
        goto L20
    L15:
        r2 = r0;
        goto L16
    L37:
        if (com.bytedance.android.livesdk.interactivity.utils.s.a(r14) == false) goto L67;
        h0 r20 = r0;
        long r21 = r20.getPinBaseMessageId();
        IBaseUser r23 = r20.getChatUserInfo();
        if ((r23 instanceof User) == true) goto L41;
        r23 = null;
    L41:
        User r24 = (User) r23;
        if (r24 == null) goto L45;
        String r25 = r24.getIdString();
        if (r25 == null) goto L45;
    L46:
        String r26 = r25;
        boolean r27 = r0 instanceof bd;
        if (r27 == true) goto L49;
        h0 r28 = null;
    L50:
        bd r29 = (bd) r28;
        if (r29 == null) goto L55;
        com.bytedance.android.live.base.model.data.m r30 = r29.itemStyle;
        if (r30 == null) goto L55;
        String r31 = r30.itemId;
    L56:
        if (r27 == true) goto L58;
        r0 = null;
    L58:
        bd r33 = (bd) r0;
        if (r33 == null) goto L63;
        com.bytedance.android.live.base.model.data.m r34 = r33.itemStyle;
        if (r34 == null) goto L63;
        r4 = r34.schema;
    L63:
        i42.a r110 = new i42.a(r21, r26, r31, r4);
        o32.a.a("click micro app share msgId=" + r20.getPinBaseMessageId());
        f(new i42.c(r110));
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r111 = this.c;
        if (r111 == null) goto L85;
        r111.dismissDialog();
        return;
    L85:
        return;
    L55:
        r31 = null;
        goto L56
    L49:
        r28 = r0;
    L45:
        r25 = "0";
        goto L46
    L67:
        CommentPinContent r112 = new CommentPinContent();
        h0 r35 = r0;
        r112.setContent(r35.getChatContent());
        r112.setCommentMsgId(r35.getPinBaseMessageId());
        r112.setNickName(r35.getChatUserInfo().getRealNickName());
        if (r1 == true) goto L70;
        r0 = null;
    L70:
        h0 r36 = r0;
        if (r36 == null) goto L73;
        IBaseUser r37 = r36.getChatUserInfo();
    L75:
        if ((r37 instanceof User) == true) goto L77;
        r37 = null;
    L77:
        User r38 = (User) r37;
        if (r38 == null) goto L80;
        r4 = r38.getIdString();
    L80:
        r112.setCommenterId(r4);
        r112.setScene(BuildConfig.FLAVOR);
        r112.setContentType(BuildConfig.FLAVOR);
        o32.a.a("click pin comment msgId=" + r112.getCommentMsgId());
        f(new e42.a(r112));
        goto L81
    L73:
        r37 = null;
        goto L75
    L88:
        return;
    }
}
