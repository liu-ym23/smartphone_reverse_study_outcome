package com.larus.avlink.env.event.detail;

import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.u;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements u {
    public final /* synthetic */ Ref.ObjectRef<CommonDialog> a;

    public final void cancel() {
        CommonDialog r0 = (CommonDialog) this.a.element;
        if (r0 == null) goto L13;
        r0.dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L14;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    public f(Ref.ObjectRef<CommonDialog> r1) {
        this.a = r1;
    }
}
