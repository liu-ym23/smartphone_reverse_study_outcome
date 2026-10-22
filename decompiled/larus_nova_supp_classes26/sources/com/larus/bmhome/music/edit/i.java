package com.larus.bmhome.music.edit;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.larus.common_ui.dialog.l0;
import com.larus.platform.api.ModifiedUserCreationMusic;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i implements a {
    public final /* synthetic */ MusicEditDialogFragment a;

    @Override // com.larus.bmhome.music.edit.a
    public final void b(ModifiedUserCreationMusic r1) {
    }

    @Override // com.larus.bmhome.music.edit.a
    public final j c() {
        MusicEditDialogFragment r1 = this.a;
        return new j(r1.f, r1.d);
    }

    public i(MusicEditDialogFragment r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.music.edit.a
    public final void a(v r5) {
        Intrinsics.checkNotNullParameter(r5, "status");
        MusicEditDialogFragment r0 = this.a;
        int r1 = MusicEditDialogFragment.t;
        l0 r2 = r0.U90();
        if (r2 == null) goto L7;
        boolean r3 = true;
        if (r2.isShowing() != true) goto L7;
    L8:
        if (r3 == false) goto L29;
        l0 r4 = this.a.U90();
        if (r4 == null) goto L29;
        Handler r6 = DialogLancet.resolveDialogHandler(r4);
        if (r6 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(r4);
        r4.dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L25:
        DialogLancet.afterDialogDismiss(r4);
        goto L29
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r4);
        throw th;
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r7 == null) goto L25;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
        goto L25
    L14:
        if (Looper.myLooper() == r6.getLooper()) goto L16;
        r6.post(DialogLancet.createDismissRunnable(r4));
    L29:
        if ((r5 instanceof v.a) == false) goto L35;
        t19.s r8 = t19.s.a;
        Context r9 = this.a.getContext();
        String r10 = ((v.a) r5).a;
        r8.getClass();
        t19.s.c(r9, r10);
        return;
    L35:
        return;
    L7:
        r3 = false;
        goto L8
    }
}
