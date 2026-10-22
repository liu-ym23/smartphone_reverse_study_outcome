package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ SelfDisciplineManagerDialogV2 a;

    public g(SelfDisciplineManagerDialogV2 r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog.SelfDisciplineManagerDialogV2, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        ?? r6 = this.a;
        int r0 = SelfDisciplineManagerDialogV2.o;
        r6.getClass();
        SelfDisciplineDurationSelectDialog r1 = new SelfDisciplineDurationSelectDialog(r6.getContext(), r6, (int) r6.m);
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }
}
