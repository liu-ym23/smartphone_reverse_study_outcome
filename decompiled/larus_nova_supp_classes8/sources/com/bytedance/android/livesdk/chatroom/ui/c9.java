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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c9 extends Dialog {
    public final Context a;
    public RelativeLayout b;
    public LiveRoundImageView c;
    public HSImageView d;
    public final View e;
    public TextView f;
    public TextView g;
    public Button h;
    public TextView i;
    public LinearLayout j;
    public Button k;
    public Button l;
    public Button m;
    public View n;

    public static class a {
        public final b a;

        public final void e() {
            b r1 = this.a;
            c9 r0 = new c9(r1.a, r1);
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
            DialogLancet.handleBlockedDialogShow(r0);
            return;
        L9:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
        }

        public a(Context r2) {
            b r0 = new b();
            this.a = r0;
            r0.a = r2;
            r0.b = 2;
        }

        public final void a(int r2) {
            this.a.f = this.a.a.getText(r2);
        }

        public final void d(int r2) {
            this.a.e = this.a.a.getText(r2);
        }

        public final void b(int r3, DialogInterface.OnClickListener r4) {
            b r0 = this.a;
            r0.j = r0.a.getText(r3);
            this.a.k = r4;
        }

        public final void c(int r3, DialogInterface.OnClickListener r4) {
            b r0 = this.a;
            r0.l = r0.a.getText(r3);
            this.a.m = r4;
        }
    }

    public static class b {
        public Context a;
        public int b;
        public int c;
        public Drawable d;
        public CharSequence e;
        public CharSequence f;
        public int g;
        public CharSequence h;
        public DialogInterface.OnClickListener i;
        public CharSequence j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public DialogInterface.OnClickListener m;
        public DialogInterface.OnCancelListener n;
        public DialogInterface.OnShowListener o;
        public boolean p;
        public boolean q;
        public int r;
        public int s;

        public b() {
            this.p = true;
            this.q = true;
            this.r = 0;
            this.s = 0;
        }
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
        r1.width = (int) this.a.getResources().getDimension(2131169097);
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

    public c9(Context r3) {
        super(r3, 2131954708);
        this.a = r3;
        View r4 = LayoutInflater.from(getContext()).inflate(2131565736, null);
        this.e = r4;
        setContentView(r4);
        b(1);
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

    public final void b(int r4) {
        this.b = (RelativeLayout) this.e.findViewById(2131389161);
        this.c = (LiveRoundImageView) this.e.findViewById(2131389160);
        this.d = this.e.findViewById(2131389137);
        this.f = (TextView) this.e.findViewById(2131384762);
        this.g = (TextView) this.e.findViewById(2131384757);
        this.h = (Button) this.e.findViewById(2131384752);
        this.i = (TextView) this.e.findViewById(2131384751);
        this.j = (LinearLayout) this.e.findViewById(2131384753);
        this.k = (Button) this.e.findViewById(2131384754);
        this.l = (Button) this.e.findViewById(2131384756);
        this.m = (Button) this.e.findViewById(2131384755);
        this.n = this.e.findViewById(2131380094);
        if (r4 != 1) goto L6;
        this.h.setVisibility(0);
        this.j.setVisibility(8);
        return;
    L6:
        if (r4 != 2) goto L11;
        this.h.setVisibility(8);
        this.j.setVisibility(0);
        Button r5 = this.m;
        if (r5 == null) goto L15;
        r5.setVisibility(8);
        this.n.setVisibility(8);
        return;
    L15:
        return;
    L11:
        if (r4 != 3) goto L17;
        this.h.setVisibility(8);
        this.j.setVisibility(0);
        return;
    }

    public final void c(CharSequence r2) {
        this.g.setText(r2);
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.g.setVisibility(0);
        return;
    }

    public final void d(CharSequence r2) {
        this.f.setText(r2);
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.f.setVisibility(0);
        return;
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent r7) {
        if (1 != r7.getAction()) goto L19;
        Context r0 = getContext();
        int r2 = (int) r7.getX();
        int r3 = (int) r7.getY();
        int r1 = ViewConfiguration.get(r0).getScaledWindowTouchSlop();
        if (getWindow() == null) goto L19;
        if (a(getWindow()) == null) goto L19;
        View r4 = a(getWindow());
        int r5 = -r1;
        if (r2 < r5) goto L19;
        if (r3 < r5) goto L19;
        if (r2 > (r4.getWidth() + r1)) goto L19;
        if (r3 > (r4.getHeight() + r1)) goto L19;
    L19:
        return super.onTouchEvent(r7);
    }

    public c9(Context r5, b r6) {
        super(r5, 2131954708);
        this.a = r5;
        int r7 = r6.c;
        if (r7 > 0) goto L6;
        r7 = 2131565736;
    L6:
        View r8 = LayoutInflater.from(getContext()).inflate(r7, null);
        this.e = r8;
        setContentView(r8);
        b(r6.b);
        this.f.setText(r6.e);
        if (TextUtils.isEmpty(r6.e) == false) goto L9;
        this.f.setVisibility(8);
    L10:
        this.g.setText(r6.f);
        this.g.setGravity(r6.g);
        if (TextUtils.isEmpty(r6.f) == false) goto L13;
        this.g.setVisibility(8);
    L14:
        int r9 = r6.b;
        if (r9 != 1) goto L18;
        this.h.setVisibility(0);
        this.j.setVisibility(8);
        this.h.setText(r6.h);
        this.h.setOnClickListener(new v8(this, r6));
    L39:
        if (r6.d == null) goto L42;
        this.b.setVisibility(0);
        this.c.setImageDrawable(r6.d);
        this.c.setOnClickListener(null);
        this.d.setOnClickListener(new b9(this));
    L42:
        if (TextUtils.isEmpty(null) == true) goto L44;
        this.i.setVisibility(0);
        this.i.setText(null);
        this.i.setOnClickListener(null);
    L44:
        setCanceledOnTouchOutside(r6.q);
        setCancelable(r6.p);
        setOnCancelListener(r6.n);
        setOnDismissListener(null);
        setOnShowListener(r6.o);
        return;
    L18:
        if (r9 != 2) goto L30;
        this.h.setVisibility(8);
        Button r10 = this.m;
        if (r10 == null) goto L22;
        r10.setVisibility(8);
        this.n.setVisibility(8);
    L22:
        this.j.setVisibility(0);
        this.k.setText(r6.j);
        if (r6.r == 0) goto L26;
        Button r11 = this.k;
        r11.setTextAppearance(r11.getContext(), r6.r);
    L26:
        if (r6.s == 0) goto L28;
        Button r12 = this.l;
        r12.setTextAppearance(r12.getContext(), r6.s);
    L28:
        this.l.setText(r6.l);
        this.k.setOnClickListener(new w8(this, r6));
        this.l.setOnClickListener(new x8(this, r6));
        goto L39
    L30:
        if (r9 != 3) goto L39;
        this.h.setVisibility(8);
        this.j.setVisibility(0);
        this.k.setText(r6.j);
        this.m.setText(null);
        this.l.setText(r6.l);
        if (r6.r == 0) goto L35;
        Button r13 = this.k;
        r13.setTextAppearance(r13.getContext(), r6.r);
    L35:
        if (r6.s == 0) goto L37;
        Button r14 = this.l;
        r14.setTextAppearance(r14.getContext(), r6.s);
    L37:
        this.k.setOnClickListener(new y8(this, r6));
        this.m.setOnClickListener(new z8(this, r6));
        this.l.setOnClickListener(new a9(this, r6));
        goto L39
    L13:
        this.g.setVisibility(0);
        goto L14
    L9:
        this.f.setVisibility(0);
        goto L10
    }
}
