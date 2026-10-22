package com.bytedance.bdturing;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.bytedance.bdturing.setting.e;
import com.bytedance.crash.d;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.capabilitykit.entity.app.EntityType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import jc4.a;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.c0;
import qb4.f;
import qb4.n;
import qb4.o;
import qb4.p;
import qb4.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c extends Dialog implements t {
    public ac4.b a;
    public ImageView b;
    public VerifyWebView c;
    public CardView d;
    public ViewGroup e;
    public Button f;
    public Button g;
    public Context h;
    public FrameLayout i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public final String n;
    public f o;
    public p p;
    public DialogInterface.OnDismissListener q;
    public o r;
    public EventReport.CloseType s;
    public final int t;
    public final a u;
    public long v;
    public final b w;
    public final c x;
    public final d y;

    public final synchronized void o0() {
        monitor-enter(this);
        int r0 = n.a;     // Catch: Throwable -> L13
        if (this.h != null) goto L10;
        if (this.a != null) goto L10;
        monitor-exit(this);
        return;
    L10:
        this.h = null;     // Catch: Throwable -> L13
        this.a.b();     // Catch: Throwable -> L13
        this.a = null;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (this.c == null) goto L11;
        View r0 = getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L9:
        r0.post(new a(this));
        this.c = null;
    L11:
        if (this.l == false) goto L13;
        return;
    L13:
        this.l = true;
        if (isShowing() == false) goto L19;
        a(this);     // Catch: Exception -> L17
    L17:
        int r3 = n.a;
    L19:
        if (this.u.getActivity() == null) goto L21;
        this.u.getActivity().unregisterComponentCallbacks(this.y);
    L21:
        Application.ActivityLifecycleCallbacks r4 = this.r;
        if (r4 == null) goto L27;
        Activity r5 = ((o) r4).a;
        if (r5 == null) goto L26;
        r5.getApplication().unregisterActivityLifecycleCallbacks(r4);
    L26:
        this.r = null;
    L27:
        DialogInterface.OnDismissListener r6 = this.q;
        if (r6 == null) goto L30;
        r6.onDismiss(this);
    L30:
        c0 r7 = c0.a.a;
        c0.b r8 = r7.b;
        if (r8 == null) goto L33;
        Message r1 = r8.obtainMessage(1, this);
        r7.b.sendMessageDelayed(r1, 10000);
    L33:
        f r9 = this.o;
        if (r9 == null) goto L39;
        if (this.j == true) goto L39;
        r9.onFail(3, null);
        this.o = null;
    L39:
        if (this.k == true) goto L50;
        String r10 = this.s.getName();
        JSONObject r11 = new JSONObject();
        r11.put("style", r10);     // Catch: JSONException -> L43
    L45:
        String r12 = ac4.c.b("bytedcert.goToClose", r11, "bytedcert.goToClose");
        ac4.b r13 = this.a;
        if (r13 != null) goto L48;
        int r14 = n.a;
        goto L50
    L48:
        r13.a(r12);
    L43:
        e = move-exception;
        e.printStackTrace();
    L50:
        if (this.j == true) goto L52;
        EventReport.G(this.s, this.u);
        o0();
    L52:
        c0.a.a.c(3, null);
    }

    public final void n1() {
        f r0 = this.o;
        if (r0 == null) goto L5;
        r0.onFail(EntityType.CLOUD_DOCUMENT, null);
        this.o = null;
    L5:
        Handler r1 = DialogLancet.resolveDialogHandler(this);
        if (r1 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L15:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r2 == null) goto L19;
        d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L8:
        if (Looper.myLooper() == r1.getLooper()) goto L10;
        r1.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        this.v = System.currentTimeMillis();
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public static void a(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        super.dismiss();     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L11:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r1 == null) goto L10;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void b(c r2) {
        if (r2.u.c == false) goto L6;
        r2.b.clearAnimation();
        r2.b.setVisibility(8);
    L6:
        if (r2.u.b == false) goto L9;
        r2.i.setBackgroundColor(-2013265920);
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        setContentView(LayoutInflater.from(this.h).inflate(2131563421, null));
        WindowManager.LayoutParams r10 = getWindow().getAttributes();
        r10.width = -1;
        r10.height = -1;
        getWindow().setAttributes(r10);
        this.e = (ViewGroup) findViewById(2131392507);
        TextView r11 = (TextView) findViewById(2131388434);
        this.f = (Button) findViewById(2131364723);
        this.g = (Button) findViewById(2131364724);
        this.b = (ImageView) findViewById(2131378977);
        this.c = findViewById(2131392207);
        this.d = findViewById(2131393122);
        this.i = (FrameLayout) findViewById(2131368963);
        b r12 = new b(this);
        this.f.setOnClickListener(r12);
        this.g.setOnClickListener(r12);
        this.c.c(this.x);
        p r13 = new p(this.u.c());
        this.p = r13;
        this.c.setOnTouchListener(r13);
        if (this.u.c == false) goto L5;
        RotateAnimation r14 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r14.setDuration(1000);
        r14.setRepeatCount(-1);
        r14.setInterpolator(new LinearInterpolator());
        this.b.startAnimation(r14);
        this.i.setBackgroundColor(-2013265920);
    L7:
        if (this.u.getActivity() == null) goto L9;
        this.u.getActivity().registerComponentCallbacks(this.y);
        EventReport.K(hc4.f.g(this.u.getActivity()), this.u);
    L9:
        Application.ActivityLifecycleCallbacks r15 = this.r;
        Activity r0 = ((o) r15).a;
        if (r0 == null) goto L12;
        r0.getApplication().registerActivityLifecycleCallbacks(r15);
    L12:
        this.u.getClass();
        setCanceledOnTouchOutside(false);
        e r1 = e.a;
        setCancelable(e.i());
        this.a = new ac4.b(this.w, this.c);
        String r2 = this.n;
        int r3 = n.a;
        this.c.loadUrl(r2);
        if (this.u.d() == false) goto L16;
        Resources r4 = this.h.getResources();
        DisplayMetrics r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics());
        ViewGroup.LayoutParams r6 = this.c.getLayoutParams();
        r6.width = r5.widthPixels;
        r6.height = r5.heightPixels;
        this.c.setLayoutParams(r6);
        this.c.setVisibility(0);
        return;
    L16:
        return;
    L5:
        this.b.setVisibility(8);
        goto L7
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent r2) {
        this.p.a(r2);
        this.u.getClass();
        return super.onTouchEvent(r2);
    }

    @Override // android.app.Dialog
    public final void setOnDismissListener(DialogInterface.OnDismissListener r1) {
        this.q = r1;
    }

    public c(a r3, f r4) {
        super(r3.getActivity(), 2131953931);
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.p = null;
        this.s = EventReport.CloseType.CLOSE_REASON_APP;
        this.w = new b(this);
        this.x = new c(this);
        this.y = new d(this);
        this.u = r3;
        this.t = r3.getType();
        this.n = r3.f();
        this.o = r4;
        this.r = new o(r3.getActivity());
        this.h = r3.getActivity();
        setOnKeyListener(new d(this));
    }
}
