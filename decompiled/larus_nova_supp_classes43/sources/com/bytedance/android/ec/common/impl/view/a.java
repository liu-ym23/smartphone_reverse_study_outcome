package com.bytedance.android.ec.common.impl.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.model.promotion.ECResultDialogContentVO;
import com.bytedance.crash.d;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends Dialog {
    public TextView a;
    public TextView b;
    public ConstraintLayout c;
    public TextView d;
    public TextView e;
    public TextView f;
    public final ECResultDialogContentVO g;
    public final int h;
    public final Function0<Unit> i;
    public final Function0<Unit> j;
    public final Function0<Unit> k;
    public final Function0<Unit> l;

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        Function0<Unit> r0 = this.j;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke();
    L5:
        Handler r10 = DialogLancet.resolveDialogHandler(this);
        if (r10 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L15:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r11 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r11 == null) goto L19;
        d.d(r11, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L8:
        if (Looper.myLooper() == r10.getLooper()) goto L10;
        r10.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Function0<Unit> r0 = this.i;
        if (r0 == null) goto L14;
        Unit r1 = (Unit) r0.invoke();
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        setContentView(2131564704);
        this.b = (TextView) findViewById(2131390944);
        this.a = (TextView) findViewById(2131391606);
        this.f = (TextView) findViewById(2131390381);
        this.c = findViewById(2131380535);
        this.d = (TextView) findViewById(2131367647);
        this.e = (TextView) findViewById(2131365123);
        getContext();
        Window r11 = getWindow();
        if (r11 == null) goto L10;
        WindowManager.LayoutParams r1 = r11.getAttributes();
        r1.width = -1;
        r1.height = -2;
        r11.setAttributes(r1);
        View r12 = r11.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r13 = ThreadMethodProxy.currentThread();
        if (r13 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r13, "getDecorView");
    L9:
        r12.setPadding(0, 0, 0, 0);
        r11.setBackgroundDrawableResource(2131106784);
    L10:
        final ECResultDialogContentVO r14 = this.g;
        if (r14 == null) goto L43;
        TextView r15 = this.a;
        if (r15 == null) goto L15;
        r15.setText(r14.getTitle());
    L15:
        TextView r16 = this.b;
        if (r16 == null) goto L19;
        r16.setText(r14.getContent());
    L19:
        if (this.h != 0) goto L26;
        ConstraintLayout r17 = this.c;
        if (r17 == null) goto L23;
        r17.setVisibility(8);
    L23:
        TextView r18 = this.f;
        if (r18 == null) goto L43;
        r18.setVisibility(0);
        r18.setText(r14.getConfirm());
        f.c(r18, null, null, new ECShowResultDialog$configSingleOption$$inlined$apply$lambda$1(this, r14), 3);
        goto L43
    L26:
        ConstraintLayout r19 = this.c;
        if (r19 == null) goto L40;
        r19.setVisibility(0);
        TextView r20 = this.d;
        if (r20 == null) goto L31;
        r20.setText(r14.getConfirm());
    L31:
        TextView r21 = this.e;
        if (r21 == null) goto L34;
        r21.setText(r14.getCancel());
    L34:
        TextView r22 = this.d;
        if (r22 == null) goto L37;
        f.c(r22, null, null, new ECShowResultDialog$configMultiOption$$inlined$apply$lambda$1(this, r14), 3);
    L37:
        TextView r23 = this.e;
        if (r23 == null) goto L40;
        f.c(r23, null, null, new ECShowResultDialog$configMultiOption$$inlined$apply$lambda$2(this, r14), 3);
    L40:
        TextView r24 = this.f;
        if (r24 == null) goto L43;
        r24.setVisibility(8);
    L43:
        setCanceledOnTouchOutside(false);
    }

    public a(Context r10, ECResultDialogContentVO r11, int r12, Function0<Unit> r13, Function0<Unit> r14, Function0<Unit> r15, Function0<Unit> r16) {
        Intrinsics.checkNotNullParameter(r10, "mContext");
        super(r10);
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r16;
    }
}
