package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.ui.PlaySettingDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m4 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;
    public final Context b;

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
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        com.bytedance.android.livesdk.reddot.a r0 = up2.a.a;
        return up2.a.h;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.j0.getValue()).booleanValue() == false) goto L5;
    L9:
        return false;
    L5:
        if (com.bytedance.android.livesdk.floatview.p.c() == false) goto L7;
    L8:
        return true;
    L7:
        if (com.bytedance.android.livesdk.floatview.p.e() == false) goto L9;
        goto L8
    }

    public final Context getContext() {
        return this.b;
    }

    public m4(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.b.j0;
        if (((Boolean) r5.getValue()).booleanValue() == false) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == false) goto L15;
        com.bytedance.android.livesdk.sharedpref.f.d(r5, Boolean.TRUE);
        DataCenter r6 = this.a;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L14:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(r6).b(ToolbarButton.MORE, new pp1.j(false));
    L15:
        PlaySettingDialog r7 = new PlaySettingDialog(this.b);
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(r7);
        return;
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L19:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
        return;
    L5:
        if (com.bytedance.android.livesdk.floatview.p.c() == false) goto L7;
    L8:
        r0 = true;
        goto L10
    L7:
        if (com.bytedance.android.livesdk.floatview.p.e() == false) goto L9;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r3;
    }
}
