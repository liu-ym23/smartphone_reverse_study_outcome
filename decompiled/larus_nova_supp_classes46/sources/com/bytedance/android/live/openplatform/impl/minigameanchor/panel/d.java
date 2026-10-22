package com.bytedance.android.live.openplatform.impl.minigameanchor.panel;

import com.bytedance.android.live.core.utils.f2;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ MiniGameFeaturePanelDialog a;

    public d(MiniGameFeaturePanelDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == true) goto L14;
        f2.b(2131920999, 0);
        return;
    L14:
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L7
    L11:
        f2.b(2131920985, 0);
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L11;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L11
    }
}
