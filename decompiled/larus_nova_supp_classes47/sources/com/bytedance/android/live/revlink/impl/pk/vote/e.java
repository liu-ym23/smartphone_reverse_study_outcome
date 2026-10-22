package com.bytedance.android.live.revlink.impl.pk.vote;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.link.model.aa;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ InteractVoteStartDialog a;

    public e(InteractVoteStartDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        aa r6 = vh7.f.c(aa.class);
        InteractVoteStartDialog.b r0 = this.a.g;
        if (r0 == null) goto L5;
        long r1 = r0.a;
    L6:
        r6.setVoteType(r1);
        InteractVoteStartDialog.b r2 = this.a.g;
        if (r2 == null) goto L10;
        String r3 = r2.b;
        if (r3 == null) goto L10;
    L11:
        r6.setVoteDes(r3);
        InteractVoteStartDialog r4 = this.a;
        InteractVoteStartDialog.c r7 = r4.i;
        if (r7 == null) goto L14;
        r7.a(r4.h, r6);
    L14:
        long r8 = this.a.h;
        com.bytedance.tools.kcp.spongepreference.runtime.a r9 = l51.a.B0;
        KProperty[] r10 = l51.a.a;
        r9.setValue(null, r10[89], Long.valueOf(r8));
        InteractVoteStartDialog.b r12 = this.a.g;
        if (r12 == null) goto L18;
        String r13 = r12.b;
        if (r13 == null) goto L18;
    L19:
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        l51.a.D0.setValue(null, r10[91], r13);
        InteractVoteStartDialog.b r14 = this.a.g;
        if (r14 == null) goto L22;
        long r15 = r14.a;
    L23:
        l51.a.G(r15);
        InteractVoteStartDialog.T90(this.a, "start");
        this.a.dismiss();     // Catch: Exception -> L26
        return;
    L26:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r16 = DialogFragmentLancet.sLastShowStack;
        if (r16 == null) goto L33;
        com.bytedance.crash.d.d(r16, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L33:
        return;
    L22:
        r15 = -1;
    L18:
        r13 = s1.B(2131918094);
    L10:
        r3 = "";
        goto L11
    L5:
        r1 = 0;
        goto L6
    }
}
