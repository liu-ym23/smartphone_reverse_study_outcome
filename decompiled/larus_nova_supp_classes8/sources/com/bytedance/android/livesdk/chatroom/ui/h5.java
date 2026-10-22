package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h5 extends Dialog {
    public final Context a;
    public final View b;
    public TextView c;
    public TextView d;
    public Button e;
    public Button f;

    public static final class a {
    }

    public static final class b {
        public Context a;
        public int b;
        public int c;
        public CharSequence d;
        public CharSequence e;
        public int f;
        public CharSequence g;
        public DialogInterface.OnClickListener h;
        public CharSequence i;
        public DialogInterface.OnClickListener j;
        public boolean k;

        public b() {
            this.k = true;
        }
    }

    static {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r0 = getWindow();
        if (r0 == null) goto L14;
        WindowManager.LayoutParams r1 = new WindowManager.LayoutParams();
        r1.copyFrom(r0.getAttributes());
        Context r2 = this.a;
        Intrinsics.checkNotNull(r2);
        r1.width = (int) r2.getResources().getDimension(2131169097);
        r1.height = -2;
        r0.setAttributes(r1);
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
    public final void onBackPressed() {
        super.onBackPressed();
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if (1 != r7.getAction()) goto L30;
        Context r0 = getContext();
        int r2 = (int) r7.getX();
        int r3 = (int) r7.getY();
        int r1 = ViewConfiguration.get(r0).getScaledWindowTouchSlop();
        if (getWindow() == null) goto L30;
        Window r4 = getWindow();
        View r5 = null;
        if (r4 == null) goto L9;
        View r6 = a(r4);
    L10:
        if (r6 == null) goto L30;
        Window r8 = getWindow();
        if (r8 == null) goto L15;
        r5 = a(r8);
    L15:
        int r9 = -r1;
        if (r2 < r9) goto L30;
        if (r3 < r9) goto L30;
        if (r5 == null) goto L20;
        int r10 = r5.getWidth();
    L21:
        if (r2 > r10) goto L30;
        if (r5 == null) goto L25;
        int r11 = r5.getHeight();
    L26:
        if (r3 <= r11) goto L30;
        goto L30
    L25:
        r11 = r1 + 0;
        goto L26
    L20:
        r10 = r1 + 0;
        goto L21
    L9:
        r6 = null;
    L30:
        return super.onTouchEvent(r7);
    }

    public h5(Context r4, b r5) {
        super(r4, 2131954708);
        this.a = r4;
        int r6 = r5.c;
        if (r6 > 0) goto L6;
        r6 = 2131565809;
    L6:
        View r7 = LayoutInflater.from(getContext()).inflate(r6, null);
        this.b = r7;
        setContentView(r7);
        int r0 = r5.b;
        this.c = (TextView) r7.findViewById(2131384762);
        this.d = (TextView) r7.findViewById(2131384757);
        LinearLayout r2 = (LinearLayout) r7.findViewById(2131384753);
        this.e = (Button) r7.findViewById(2131384754);
        this.f = (Button) r7.findViewById(2131384756);
        if (r0 != 1) goto L17;
        TextView r1 = this.d;
        if (r1 == null) goto L11;
        r1.setTextColor(com.bytedance.android.live.core.utils.s1.h(2131108238));
    L11:
        Drawable r3 = com.bytedance.android.live.core.utils.s1.m(2131251696);
        TextView r8 = this.d;
        if (r8 == null) goto L14;
        r8.setCompoundDrawablesWithIntrinsicBounds(null, null, r3, null);
    L14:
        TextView r9 = this.d;
        if (r9 == null) goto L20;
        r9.setCompoundDrawablePadding(com.bytedance.android.live.core.utils.s1.f(3.6f));
    L20:
        TextView r10 = this.c;
        Intrinsics.checkNotNull(r10);
        r10.setText(r5.d);
        TextView r11 = this.d;
        Intrinsics.checkNotNull(r11);
        r11.setText(r5.e);
        TextView r12 = this.d;
        Intrinsics.checkNotNull(r12);
        r12.setGravity(r5.f);
        Button r13 = this.e;
        Intrinsics.checkNotNull(r13);
        r13.setText(r5.g);
        Button r14 = this.f;
        Intrinsics.checkNotNull(r14);
        r14.setText(r5.i);
        TextView r15 = this.d;
        Intrinsics.checkNotNull(r15);
        r15.setText(r5.e);
        TextView r16 = this.d;
        Intrinsics.checkNotNull(r16);
        r16.setGravity(r5.f);
        if (TextUtils.isEmpty(r5.e) == false) goto L23;
        TextView r17 = this.d;
        Intrinsics.checkNotNull(r17);
        r17.setVisibility(8);
    L25:
        if (r5.b != 1) goto L29;
        TextView r18 = this.d;
        if (r18 == null) goto L29;
        r18.setOnClickListener(new i5(this, r5));
    L29:
        Button r19 = this.e;
        if (r19 == null) goto L32;
        r19.setOnClickListener(new j5(this, r5));
    L32:
        Button r20 = this.f;
        if (r20 == null) goto L35;
        r20.setOnClickListener(new k5(this, r5));
    L35:
        setCanceledOnTouchOutside(r5.k);
        setCancelable(true);
        setOnCancelListener(null);
        setOnDismissListener(null);
        setOnShowListener(null);
        return;
    L23:
        TextView r21 = this.d;
        Intrinsics.checkNotNull(r21);
        r21.setVisibility(0);
        goto L25
    L17:
        TextView r22 = this.d;
        if (r22 == null) goto L20;
        r22.setTextColor(com.bytedance.android.live.core.utils.s1.h(2131108243));
        goto L20
    }
}
