package p82;

import android.view.View;
import com.bytedance.android.live.base.model.message.h0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemShowArea;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdk.message.model.e2;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z extends a {
    public z() {
        super(PanelItemSymbol.REPLY);
    }

    @Override // p82.a
    public final int e() {
        if (this.d.getArea() != PanelItemShowArea.TOP) goto L6;
        return 2131567231;
    L6:
        return 2131567233;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.l r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        com.bytedance.android.live.base.model.message.t r0 = r6.b;
        IBaseUser r2 = null;
        if ((r0 instanceof h0) == true) goto L5;
        r0 = null;
    L5:
        e2 r1 = (h0) r0;
        if ((r1 instanceof e2) == true) goto L8;
    L10:
        String r7 = r6.b.getMessageMethod();
        if (r7 != null) goto L13;
    L15:
        if (r1 == null) goto L17;
        r2 = r1.getChatUserInfo();
    L17:
        if (r2 == null) goto L20;
        return true;
    L20:
        return false;
    L13:
        if (r7.equals("WebcastSecretChatMessage") != true) goto L15;
        return false;
    L8:
        if (r1.isFromOtherIntercomRoom() == false) goto L10;
        return false;
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r18) {
        super.onClick(r18);
        com.bytedance.android.livesdk.interactivity.api.entity.l r1 = this.b;
        if (r1 == null) goto L36;
        com.bytedance.android.live.base.model.message.t r2 = r1.b;
        if (r2 != null) goto L8;
        return;
    L8:
        if ((r2 instanceof h0) == true) goto L10;
        return;
    L10:
        o32.a.a("reply user");
        h0 r3 = (h0) r2;
        String r9 = gm2.q.b(r3.getChatUserInfo());
        xs2.b r4 = xs2.b.a();
        u22.m r13 = new u22.m(r9);
        IBaseUser r5 = r3.getChatUserInfo();
        if ((r5 instanceof User) == true) goto L13;
        r5 = null;
    L13:
        User r6 = (User) r5;
        if (r6 == null) goto L16;
        String r7 = r6.getIdStr();
    L17:
        Room r8 = jc1.k.n(IRoomService.class).getCurrentRoom();
        if (r8 == null) goto L20;
        String r10 = r8.getOwnerUserIdString();
    L21:
        o0.a.getClass();
        boolean r15 = o0.a.a(r7, r10);
        u22.m.a r14 = new u22.m.a("anchor_reply", r15, r7, 4, r9, r3.getPinBaseMessageId(), r3.getChatUserInfo().getWebcastUid());
        if (r15 == false) goto L24;
        String r11 = "anchor";
    L25:
        ((HashMap) r14.g).put("user_type", r11);
        if ((r2 instanceof BaseMessage) == true) goto L28;
        r2 = null;
    L28:
        BaseMessage r16 = (BaseMessage) r2;
        if (r16 == null) goto L31;
        boolean r17 = r16.isFromOtherIntercomRoom();
    L32:
        r14.k = r17;
        r14.j = r3.getChatUserInfo();
        Unit r19 = Unit.INSTANCE;
        r13.e = r14;
        r13.l = OpenInputSource.PSDialogReply;
        r4.post(r13);
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r20 = this.c;
        if (r20 == null) goto L37;
        r20.dismissDialog();
        return;
    L37:
        return;
    L31:
        r17 = false;
        goto L32
    L24:
        r11 = "admin";
        goto L25
    L20:
        r10 = null;
        goto L21
    L16:
        r7 = null;
        goto L17
    }
}
