package com.larus.avlink.env.event.detail;

import com.larus.avlink.env.event.DoraEnvObserveEventViewModel;
import com.larus.avlink.env.event.model.EnvObserveMemoryEvent;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e implements p0 {
    public final /* synthetic */ Ref.ObjectRef<CommonDialog> a;
    public final /* synthetic */ DoraEnvObserveEventDetailFragment b;

    public final void confirm() {
        CommonDialog r0 = (CommonDialog) this.a.element;
        if (r0 != null) goto L16;
    L10:
        EnvObserveMemoryEvent r1 = this.b.g;
        if (r1 == null) goto L18;
        String r2 = r1.getId();
        if (r2 == null) goto L19;
        ((DoraEnvObserveEventViewModel) this.b.f.getValue()).deleteMemory(r2);
        return;
    L19:
        return;
    L18:
        return;
    L16:
        r0.dismiss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L10;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public e(Ref.ObjectRef<CommonDialog> r1, DoraEnvObserveEventDetailFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
