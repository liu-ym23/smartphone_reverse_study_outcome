package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ MultiAnchorTeamPkUserInviteDialog a;

    public i(MultiAnchorTeamPkUserInviteDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.dismiss();     // Catch: Exception -> L5
    L9:
        i11.b r5 = y.a();
        if (r5 == null) goto L12;
        List<IBaseUser> r6 = r5.getInviteeList();
    L13:
        List<IBaseUser> r7 = r6;
        if (r7 != null) goto L16;
    L19:
        boolean r8 = true;
    L20:
        if (r8 == false) goto L27;
        com.bytedance.android.live.revlink.impl.multianchor.service.c r9 = com.bytedance.android.live.revlink.impl.global.b.y();
        if (r9 == null) goto L28;
        com.bytedance.android.live.revlink.impl.multianchor.service.c.a.a(r9, 0, 0, null, 7);
        return;
    L28:
        return;
    L27:
        return;
    L16:
        if (r7.isEmpty() == true) goto L19;
        r8 = false;
        goto L20
    L12:
        r6 = null;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r10 = DialogFragmentLancet.sLastShowStack;
        if (r10 == null) goto L9;
        com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }
}
