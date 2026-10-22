package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.multianchor.ui.MultiAnchorRandomView;
import com.bytedance.android.livesdk.link.model.j8;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ MultiAnchorLinkUserInviteDialog a;

    public h(MultiAnchorLinkUserInviteDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        com.bytedance.android.live.revlink.impl.multianchor.match.c r7 = (com.bytedance.android.live.revlink.impl.multianchor.match.c) r6;
        if (r7.a == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L56;
        MultiAnchorRandomView r1 = (MultiAnchorRandomView) this.a.S90(2131362584);
        if (r1 != null) goto L19;
        return;
    L19:
        if ((r7 instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c) == false) goto L29;
        this.a.getClass();
        MultiPkMatchContext r8 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r8 == null) goto L26;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.link.model.b0> r9 = r8.getSelfAutoMatchInfo();
        if (r9 == null) goto L26;
        com.bytedance.android.livesdk.link.model.b0 r10 = (com.bytedance.android.livesdk.link.model.b0) r9.getValue();
        if (r10 == null) goto L26;
    L27:
        r1.V5(r10);
        return;
    L26:
        r10 = (com.bytedance.android.livesdk.link.model.b0) vh7.f.c(j8.class);
        goto L27
    L29:
        if (r7.d == false) goto L35;
        this.a.getClass();
        MultiPkMatchContext r2 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r2 == null) goto L40;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.link.model.b0> r3 = r2.getPassiveAutoMatchInfo();
        if (r3 == null) goto L40;
        com.bytedance.android.livesdk.link.model.b0 r4 = (com.bytedance.android.livesdk.link.model.b0) r3.getValue();
    L41:
        if (r4 != null) goto L43;
        r4 = vh7.f.c(j8.class);
    L43:
        this.a.getClass();
        MultiPkMatchContext r5 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r5 == null) goto L53;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revlink.impl.multianchor.match.c> r12 = r5.getLastMatchStatus();
        if (r12 == null) goto L53;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r13 = (com.bytedance.android.live.revlink.impl.multianchor.match.c) r12.getValue();
        if (r13 == null) goto L53;
        if ((r13 instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c) != true) goto L53;
        r1.Y5(r4.getWaitSec(), r4);
    L53:
        if (r7.c == false) goto L62;
        r1.Z5();
        return;
    L62:
        return;
    L40:
        r4 = null;
        goto L41
    L35:
        this.a.getClass();
        MultiPkMatchContext r14 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r14 == null) goto L40;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.link.model.b0> r15 = r14.getSelfAutoMatchInfo();
        if (r15 == null) goto L40;
        r4 = (com.bytedance.android.livesdk.link.model.b0) r15.getValue();
        goto L41
    L56:
        this.a.dismiss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r16 = DialogFragmentLancet.sLastShowStack;
        if (r16 == null) goto L58;
        com.bytedance.crash.d.d(r16, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L58:
        return;
    L5:
        if (com.bytedance.android.live.revlink.impl.multianchor.utils.x.d(r7.b) == false) goto L7;
        r0 = true;
        goto L8
    }
}
