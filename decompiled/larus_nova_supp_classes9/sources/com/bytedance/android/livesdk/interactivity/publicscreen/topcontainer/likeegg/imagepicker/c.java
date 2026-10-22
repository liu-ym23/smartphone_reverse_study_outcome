package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepicker;

import android.view.View;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ LikeEggImagePickerDialog a;

    public c(LikeEggImagePickerDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Function0<Unit> r3 = this.a.e;
        if (r3 == null) goto L13;
        Unit r4 = (Unit) r3.invoke();
    L13:
        this.a.dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L15;
        d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
