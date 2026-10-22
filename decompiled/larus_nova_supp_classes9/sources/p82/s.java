package p82;

import android.view.View;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.d4;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s extends a {
    public final Boolean e;

    @Override // p82.a
    public final int e() {
        return 2131567225;
    }

    public s() {
        super(PanelItemSymbol.OPEN_PROFILE_SYMBOL);
        this.e = (Boolean) d4.a.getValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.l r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        com.bytedance.android.live.base.model.message.t r4 = r3.b;
        IBaseUser r1 = null;
        if ((r4 instanceof u3) == true) goto L5;
        r4 = null;
    L5:
        u3 r5 = (u3) r4;
        if (r5 == null) goto L8;
        r1 = r5.getUserInMessage();
    L8:
        if (r1 == null) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r3) {
        super.onClick(r3);
        com.bytedance.android.livesdk.interactivity.api.entity.l r4 = this.b;
        com.bytedance.android.live.base.model.message.t r0 = null;
        if (r4 == null) goto L5;
        com.bytedance.android.live.base.model.message.t r5 = r4.b;
    L7:
        if ((r5 instanceof u3) == false) goto L10;
        r0 = r5;
    L10:
        u3 r1 = (u3) r0;
        if (r1 == null) goto L27;
        IBaseUser r6 = r1.getUserInMessage();
        if (r6 != null) goto L16;
        return;
    L16:
        if (this.e.booleanValue() == false) goto L22;
        com.bytedance.android.livesdk.interactivity.api.entity.l r2 = this.b;
        if (r2 == null) goto L23;
        com.bytedance.android.live.base.model.message.t r7 = r2.b;
        if (r7 == null) goto L23;
        xs2.b.a().post(com.bytedance.android.livesdk.interactivity.textmessage.utils.e.a(r7, r6, false));
    L23:
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r8 = this.c;
        if (r8 == null) goto L28;
        r8.dismissDialog();
        return;
    L28:
        return;
    L22:
        UserProfileEvent r9 = new UserProfileEvent(r6);
        r9.mSource = "personal_profile";
        r9.setClickUserPosition("personal_profile");
        xs2.b.a().post(r9);
        goto L23
    L27:
        return;
    L5:
        r5 = null;
        goto L7
    }
}
