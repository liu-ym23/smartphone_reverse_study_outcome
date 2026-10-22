package com.bytedance.android.livesdk.interactivity.publicscreen.panel.item;

import android.view.View;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AudiencePanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends b {
    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b
    public final int c() {
        return 2131565177;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final boolean canShow() {
        return true;
    }

    public g() {
        super(AudiencePanelItemSymbol.PROFILE);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void onClick(View r3) {
        super.onClick(r3);
        t r4 = this.c;
        if ((r4 instanceof u3) == true) goto L5;
        r4 = null;
    L5:
        u3 r5 = (u3) r4;
        if (r5 == null) goto L17;
        IBaseUser r6 = r5.getUserInMessage();
        if (r6 == null) goto L19;
        t r0 = this.c;
        if (r0 == null) goto L13;
        UserProfileEvent r7 = com.bytedance.android.livesdk.interactivity.textmessage.utils.e.a(r0, r6, true);
        xs2.b.a().post(r7);
    L13:
        v r8 = this.d;
        if (r8 == null) goto L18;
        r8.l20(false);
        return;
    L18:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void b(t r2, v r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "bridge");
        super.b(r2, r3);
    }
}
