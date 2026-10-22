package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import android.view.View;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.live.ui.PkInviteUserListRefreshLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o implements PkInviteUserListRefreshLayout.k {
    public final /* synthetic */ MultiAnchorLinkUserInviteDialog a;

    public final void onFinish() {
        MultiAnchorLinkUserInviteDialog r0 = this.a;
        r0.g = Boolean.TRUE;
        PkItemExposeRecyclerView r1 = (PkItemExposeRecyclerView) r0.S90(2131384076);
        if (r1 == null) goto L6;
        r1.t();
        return;
    }

    public final void onRefresh() {
        MultiAnchorLinkUserInviteDialog r0 = this.a;
        int r1 = MultiAnchorLinkUserInviteDialog.w;
        r0.U90().getPersonalPkService().a();
        d31.e r2 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r2 == null) goto L6;
        r2.c++;
        return;
    }

    public final void y0() {
        View r0 = this.a.h;
        if (r0 == null) goto L6;
        r0.setVisibility(4);
        return;
    }

    public final void z1() {
        if (Intrinsics.areEqual(this.a.g, Boolean.TRUE) == false) goto L8;
        View r0 = this.a.h;
        if (r0 == null) goto L7;
        r0.setVisibility(0);
    L7:
        this.a.g = Boolean.FALSE;
        return;
    L8:
        PkInviteUserListRefreshLayout r1 = this.a.S90(2131392080);
        Integer r3 = null;
        if (r1 == null) goto L11;
        Integer r2 = Integer.valueOf(r1.i);
    L13:
        if (r2.intValue() != 0) goto L17;
        View r4 = this.a.h;
        if (r4 == null) goto L27;
        r4.setVisibility(4);
        return;
    L27:
        return;
    L17:
        PkInviteUserListRefreshLayout r5 = this.a.S90(2131392080);
        if (r5 == null) goto L21;
        r3 = Integer.valueOf(r5.i);
    L21:
        if (r3.intValue() == 0) goto L29;
        View r6 = this.a.h;
        if (r6 == null) goto L30;
        r6.setVisibility(0);
        return;
    L30:
        return;
    L29:
        return;
    L11:
        r2 = null;
        goto L13
    }

    public o(MultiAnchorLinkUserInviteDialog r1) {
        this.a = r1;
    }
}
