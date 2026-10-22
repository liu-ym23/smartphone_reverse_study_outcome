package com.bytedance.android.live.revlink.impl.pk.vote;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ InteractVoteStartDialog a;

    public f(InteractVoteStartDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        long r0 = this.a.h;
        com.bytedance.tools.kcp.spongepreference.runtime.a r6 = l51.a.B0;
        KProperty[] r2 = l51.a.a;
        r6.setValue(null, r2[89], Long.valueOf(r0));
        InteractVoteStartDialog.b r7 = this.a.g;
        if (r7 == null) goto L6;
        String r8 = r7.b;
        if (r8 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        l51.a.D0.setValue(null, r2[91], r8);
        InteractVoteStartDialog.b r9 = this.a.g;
        if (r9 == null) goto L10;
        long r3 = r9.a;
    L11:
        l51.a.G(r3);
        InteractVoteStartDialog.T90(this.a, "save");
        com.bytedance.android.live.revlink.impl.multianchor.service.c r10 = com.bytedance.android.live.revlink.impl.global.b.y();
        if (r10 == null) goto L22;
        com.bytedance.android.live.revlink.impl.multianchor.service.c.a.a(r10, 0, 0, null, 7);
    L22:
        this.a.dismiss();     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r12 = DialogFragmentLancet.sLastShowStack;
        if (r12 == null) goto L24;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L24:
        return;
    L10:
        r3 = -1;
    L6:
        r8 = s1.B(2131918094);
        goto L7
    }
}
