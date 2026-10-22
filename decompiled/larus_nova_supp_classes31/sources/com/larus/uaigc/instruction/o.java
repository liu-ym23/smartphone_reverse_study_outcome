package com.larus.uaigc.instruction;

import android.view.ViewTreeObserver;
import com.larus.uaigc.impl.databinding.LarusItemActionBarAvatarInstructionBinding;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o implements ViewTreeObserver.OnDrawListener {
    public boolean a;
    public final /* synthetic */ AvatarTemplateWidget b;

    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.uaigc.instruction.l] */
    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
    L16:
        th = move-exception;
        FLogger.a.w("avatar_template_widget", th.getLocalizedMessage());
        return;
    L3:
        if (this.a == false) goto L5;
        return;
    L5:
        final AvatarTemplateWidget r0 = this.b;     // Catch: Throwable -> L16
        final ?? r1 = new l(this, r0);     // Catch: Throwable -> L16
        LarusItemActionBarAvatarInstructionBinding r2 = r0.g;     // Catch: Throwable -> L16
        String r3 = null;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");     // Catch: Throwable -> L16
        r2 = null;
    L8:
        CharSequence r4 = r2.b.getText();     // Catch: Throwable -> L16
        if (r4 == null) goto L12;
        r3 = r4.toString();     // Catch: Throwable -> L16
    L12:
        if (o0.d(r3) == false) goto L14;
        r1.invoke();     // Catch: Throwable -> L16
        return;
    L14:
        this.b.postDelayed(new m(r1), 1000);     // Catch: Throwable -> L16
    }

    public o(AvatarTemplateWidget r1) {
        this.b = r1;
    }
}
