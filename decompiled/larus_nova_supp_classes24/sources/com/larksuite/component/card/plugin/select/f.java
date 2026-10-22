package com.larksuite.component.card.plugin.select;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ Function1<List<? extends UniversalCardShowSelectMenuPluginModel$OptionsItemModel>, Unit> a;
    public final /* synthetic */ List<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> b;
    public final /* synthetic */ UDDialog c;

    public f(com.larksuite.component.card.plugin.c r1, List r2, UDDialog r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [android.app.Dialog, com.larksuite.component.universe_design.dialog.UDDialog, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.invoke(this.b);
        ?? r5 = this.c;
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r5);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(r5));
    }
}
