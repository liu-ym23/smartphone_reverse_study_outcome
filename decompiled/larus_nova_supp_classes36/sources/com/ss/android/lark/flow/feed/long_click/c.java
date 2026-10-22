package com.ss.android.lark.flow.feed.long_click;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements View.OnTouchListener {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ FlowFeedDialogBuilder b;
    public final /* synthetic */ UDDialog c;

    public c(Ref.BooleanRef r1, FlowFeedDialogBuilder r2, UDDialog r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        int r6 = r5.getAction();
        if (r6 != 0) goto L5;
        Ref.BooleanRef r7 = this.a;
        r7.element = FlowFeedDialogBuilder.b(this.b, r5.getRawX(), r5.getRawY());
        return this.a.element;
    L5:
        if (r6 != 1) goto L7;
        boolean r8 = FlowFeedDialogBuilder.b(this.b, r5.getRawX(), r5.getRawY());
        if (this.a.element == false) goto L30;
        if (r8 == false) goto L30;
        UDDialog r9 = this.c;
        Handler r10 = DialogLancet.resolveDialogHandler(r9);
        if (r10 != null) goto L16;
    L18:
        DialogLancet.beforeDialogDismiss(r9);
        r9.dismiss();     // Catch: Throwable -> L21 Exception -> L23
    L27:
        DialogLancet.afterDialogDismiss(r9);
        goto L30
    L21:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r9);
        throw th;
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L21
        Throwable r11 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L21
        if (r11 == null) goto L27;
        com.bytedance.crash.d.d(r11, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L21
        goto L27
    L16:
        if (Looper.myLooper() == r10.getLooper()) goto L18;
        r10.post(DialogLancet.createDismissRunnable(r9));
    L30:
        Ref.BooleanRef r12 = this.a;
        boolean r13 = r12.element;
        r12.element = false;
        return r13;
    L7:
        if (r6 != 3) goto L36;
        this.a.element = false;
        return false;
    L36:
        return this.a.element;
    }
}
