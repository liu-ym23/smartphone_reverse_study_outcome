package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements View.OnClickListener {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        i11.b r5 = y.a();
        if (r5 == null) goto L5;
        List<IBaseUser> r6 = r5.getInviteeList();
    L6:
        List<IBaseUser> r7 = r6;
        if (r7 != null) goto L9;
    L12:
        boolean r8 = true;
    L13:
        if (r8 == false) goto L18;
        com.bytedance.android.live.revlink.impl.multianchor.service.c r9 = com.bytedance.android.live.revlink.impl.global.b.y();
        if (r9 == null) goto L19;
        com.bytedance.android.live.revlink.impl.multianchor.service.c.a.a(r9, 0, 0, null, 7);
        return;
    L19:
        return;
    L18:
        return;
    L9:
        if (r7.isEmpty() == true) goto L12;
        r8 = false;
        goto L13
    L5:
        r6 = null;
        goto L6
    }
}
