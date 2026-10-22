package p82;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.model.message.q3;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.pin.ui.PinTipsDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v extends a {
    public final RoomContext e;

    @Override // p82.a
    public final int e() {
        return 2131567228;
    }

    public v(RoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        super(PanelItemSymbol.PIN_ROOMMESSAGE);
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
        if (r1 == true) goto L12;
        return false;
    L12:
        com.bytedance.android.live.base.model.message.t r9 = r8.b;
        if ((r9 instanceof q3) == true) goto L15;
        r9 = null;
    L15:
        q3 r10 = (q3) r9;
        if (r10 != null) goto L18;
    L20:
        return false;
    L18:
        if (r10.canPin() != true) goto L20;
        return true;
    L5:
        if (r0.enablePinComment != 1) goto L9;
        if (com.bytedance.android.livesdk.interactivity.common.utils.h.b(((Boolean) this.e.isAnchor().getValue()).booleanValue()) == false) goto L9;
        r1 = true;
        goto L10
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r13) {
        super.onClick(r13);
        com.bytedance.android.livesdk.interactivity.api.entity.l r14 = this.b;
        User r0 = null;
        if (r14 == null) goto L5;
        com.bytedance.android.live.base.model.message.t r15 = r14.b;
    L7:
        if ((r15 instanceof q3) == true) goto L9;
        r15 = null;
    L9:
        q3 r16 = (q3) r15;
        if (r16 != null) goto L12;
        return;
    L12:
        long r2 = r16.getPinBaseMessageId();
        long r4 = r16.getPinCommenterId();
        long r6 = r16.getPinMessageShowArea();
        Map r8 = r16.getBuriedPoint();
        User r17 = r16.getPinUser();
        if ((r17 instanceof User) == false) goto L16;
        r0 = r17;
    L16:
        h42.b r18 = new h42.b(new h42.a(r2, r4, r6, r8, r0));
        if (((Boolean) new com.bytedance.android.livesdk.sharedpref.e("has_show_pin_tips_dialog", Boolean.FALSE).getValue()).booleanValue() == true) goto L27;
        com.bytedance.android.livesdk.interactivity.api.entity.l r1 = this.b;
        if (r1 == null) goto L28;
        Context r3 = r1.getContext();
        if (r3 == null) goto L28;
        PinTipsDialog r5 = new PinTipsDialog(r3, r18);
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L33;
        DialogLancet.handleBlockedDialogShow(r5);
        goto L28
    L33:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L26:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
    L28:
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r19 = this.c;
        if (r19 == null) goto L35;
        r19.dismissDialog();
        return;
    L35:
        return;
    L27:
        k42.b.a(r18);
        goto L28
    L5:
        r15 = null;
        goto L7
    }
}
