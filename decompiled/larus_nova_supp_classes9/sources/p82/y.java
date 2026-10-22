package p82;

import android.view.View;
import com.bytedance.android.live.base.model.message.h0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y extends a {
    public final RoomContext e;

    @Override // p82.a
    public final int e() {
        return 2131567232;
    }

    public y(RoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        super(PanelItemSymbol.REPLY_AND_PIN_SYMBOL);
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
        com.bytedance.android.live.base.model.message.t r9 = r8.b;
        IBaseUser r4 = null;
        if ((r9 instanceof h0) == true) goto L13;
        r9 = null;
    L13:
        h0 r10 = (h0) r9;
        if (r1 == false) goto L19;
        if (r10 == null) goto L17;
        r4 = r10.getChatUserInfo();
    L17:
        if (r4 == null) goto L19;
        return true;
    L19:
        return false;
    L5:
        if (r0.enablePinComment != 1) goto L9;
        if (com.bytedance.android.livesdk.interactivity.common.utils.h.b(((Boolean) this.e.isAnchor().getValue()).booleanValue()) == false) goto L9;
        r1 = true;
        goto L10
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r9) {
        super.onClick(r9);
        com.bytedance.android.livesdk.interactivity.api.entity.l r10 = this.b;
        if (r10 == null) goto L22;
        h0 r11 = r10.b;
        if (r11 != null) goto L8;
        return;
    L8:
        if ((r11 instanceof h0) == true) goto L10;
        return;
    L10:
        xs2.b r0 = xs2.b.a();
        h0 r13 = r11;
        long r2 = r13.getPinBaseMessageId();
        String r4 = r13.getChatUserInfo().getNickName();
        IBaseUser r1 = r13.getChatUserInfo();
        if ((r1 instanceof User) == true) goto L13;
        r1 = null;
    L13:
        User r3 = (User) r1;
        if (r3 == null) goto L17;
        String r5 = r3.getIdStr();
        if (r5 == null) goto L17;
    L18:
        r0.post(new j42.b(r2, r4, r5, r13.getChatContent()));
        o32.a.a("click reply and pin comment: msgId=" + r13.getPinBaseMessageId());
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r14 = this.c;
        if (r14 == null) goto L23;
        r14.dismissDialog();
        return;
    L23:
        return;
    L17:
        r5 = "0";
        goto L18
    }
}
