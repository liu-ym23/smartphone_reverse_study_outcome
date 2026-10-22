package com.bytedance.android.live.broadcastgame.xplay;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r0 implements i.b {
    public final /* synthetic */ XplayMoreDialog a;

    public r0(XplayMoreDialog r1) {
        this.a = r1;
    }

    public static void b(CommonStandardBottomDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.i.b
    public final void a(CommonStandardBottomDialog r9, View r11, i r12) {
        Intrinsics.checkNotNullParameter(r9, "pluginMoreDialog");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "item");
        String r13 = com.bytedance.android.live.broadcastgame.opengame.service.e.a;
        com.bytedance.android.live.broadcastgame.api.xplay.p r14 = this.a.D;
        com.bytedance.android.live.broadcastgame.opengame.service.e.f(0L, r14.h.c, r12.b, "barrage", Boolean.valueOf(r14.d), this.a.D.h.b);
        boolean r0 = false;
        switch(r12.a) {
            case 13: goto L14;
            case 14: goto L14;
            case 15: goto L13;
            case 16: goto L9;
            case 17: goto L5;
            default: goto L22;
        };
    L5:
        com.bytedance.live.datacontext.m<Boolean> r15 = this.a.E.getShowFloatWindow();
        Boolean r1 = Boolean.FALSE;
        r15.setValue(r1);
        b(r9);
        XplayMoreDialog r16 = this.a;
        int r17 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        XplayMoreDialog.W0(r16, r12);
        XplayExternalContext r18 = XplayExternalContext.Companion.getContext();
        if (r18 == null) goto L8;
        r18.getClearScreen().setValue(r1);
    L8:
        f2.c("悬浮窗已关闭，恢复直播间展示", 0);
        return;
    L9:
        com.bytedance.live.datacontext.m<Boolean> r19 = this.a.E.getShowFloatWindow();
        Boolean r2 = Boolean.TRUE;
        r19.setValue(r2);
        b(r9);
        XplayMoreDialog r21 = this.a;
        int r110 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        XplayMoreDialog.W0(r21, r12);
        XplayExternalContext r22 = XplayExternalContext.Companion.getContext();
        if (r22 == null) goto L12;
        r22.getClearScreen().setValue(r2);
    L12:
        f2.c("悬浮窗已开启", 0);
        return;
    L13:
        this.a.E.getShowKeyBoard().post(Unit.INSTANCE);
        XplayMoreDialog r111 = this.a;
        int r3 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        XplayMoreDialog.W0(r111, r12);
        b(r9);
        return;
    L14:
        com.bytedance.live.datacontext.m<Boolean> r112 = this.a.E.getOpenCapture();
        if (((Boolean) this.a.E.getOpenCapture().getValue()).booleanValue() == true) goto L17;
        r0 = true;
    L17:
        r112.setValue(Boolean.valueOf(r0));
        XplayMoreDialog r113 = this.a;
        int r4 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        XplayMoreDialog.W0(r113, r12);
        b(r9);
        return;
    }
}
