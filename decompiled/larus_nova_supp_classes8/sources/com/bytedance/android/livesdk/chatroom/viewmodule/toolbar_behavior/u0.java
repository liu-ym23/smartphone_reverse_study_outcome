package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.ui.LittlePluginCloseDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u0 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public boolean a;
    public final Context b;
    public final com.bytedance.android.live.broadcastgame.api.model.e c;
    public final DataCenter d;
    public final Dialog e;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void p4(View r1, DataCenter r2) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [android.app.Dialog, com.bytedance.android.livesdk.chatroom.ui.LittlePluginCloseDialog, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.a == false) goto L28;
        ?? r5 = new LittlePluginCloseDialog(this.b, this.d, this.c);
        r5.setCancelable(false);
        r5.setCanceledOnTouchOutside(false);
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L35;
        DialogLancet.handleBlockedDialogShow(r5);
    L9:
        Dialog r6 = this.e;
        if (r6 == null) goto L38;
        Handler r0 = DialogLancet.resolveDialogHandler(r6);
        if (r0 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L25:
        DialogLancet.afterDialogDismiss(r6);
        return;
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r1 == null) goto L25;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
        goto L25
    L14:
        if (Looper.myLooper() == r0.getLooper()) goto L16;
        r0.post(DialogLancet.createDismissRunnable(r6));
        return;
    L38:
        return;
    L35:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L8:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        goto L9
    L28:
        DataCenter r7 = this.d;
        if (r7 == null) goto L41;
        r7.put("cmd_open_little_plugin", this.c);
        return;
    }

    public u0(boolean r2, Context r3, com.bytedance.android.live.broadcastgame.api.model.e r4, DataCenter r5, Dialog r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "item");
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.a = r2;
    }
}
