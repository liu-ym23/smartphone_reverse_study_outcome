package com.ss.android.lark.compose.foundation.toast;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements g {
    public final Activity a;
    public int b;
    public final WindowManager c;
    public final i d;
    public final UDShadowLayout e;
    public int f;
    public int g;
    public int h;
    public long i;
    public UDToast.c j;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.foundation.toast.b$b, reason: collision with other inner class name */
    public static final class C0145b extends AnimatorListenerAdapter {
        public final /* synthetic */ b a;
        public final /* synthetic */ Function0<Unit> b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.b();
            this.b.invoke();
        }

        public C0145b(b r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final void b() {
        this.b = 0;
        i r0 = this.d;
        ViewPropertyAnimator r1 = r0.c;
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        r0.c = null;
        if (this.e.isAttachedToWindow() == false) goto L8;
        this.c.removeView(this.e);
    L8:
        UDToast.c r2 = this.j;
        if (r2 == null) goto L12;
        r2.a();
        return;
    }

    public final void cancel() {
        if (this.b >= 1) goto L5;
        return;
    L5:
        Handler r0 = FlowActionToastManager.a;
        Intrinsics.checkNotNullParameter(this, "toast");
        if (FlowActionToastManager.a != null) goto L9;
        FlowActionToastManager.a = new Handler(Looper.getMainLooper(), e.a);
    L9:
        Handler r1 = FlowActionToastManager.a;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
        r1 = null;
    L12:
        r1.post(new FlowActionToastManager$remove$1(this));
    }

    public final boolean isShowing() {
        if (this.b != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final void show() {
        boolean r1 = true;
        if (this.b < 1) goto L5;
        return;
    L5:
        this.b = 1;
        Handler r0 = FlowActionToastManager.a;
        Intrinsics.checkNotNullParameter(this, "toast");
        if (this.a.isDestroyed() == false) goto L8;
    L15:
        r1 = false;
    L16:
        if (r1 == true) goto L21;
        this.b = 0;
        UDToast.c r2 = this.j;
        if (r2 == null) goto L22;
        r2.a();
        return;
    L22:
        return;
    L21:
        return;
    L8:
        if (this.a.isFinishing() == true) goto L15;
        if (FlowActionToastManager.a != null) goto L14;
        FlowActionToastManager.a = new Handler(Looper.getMainLooper(), e.a);
    L14:
        FlowActionToastManager.a r3 = new FlowActionToastManager.a(this);
        FlowActionToastManager.b.addLast(r3);
        this.a.getApplication().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) FlowActionToastManager.c.getValue());
        FlowActionToastManager.b();
        goto L16
    }

    public b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r0 = com.ss.android.lark.compose.foundation.toast.a.a;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Activity r1 = com.ss.android.lark.compose.foundation.toast.a.a(r4);
        if (r1 == null) goto L7;
        this.a = r1;
        Object r2 = r4.getSystemService("window");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.WindowManager");
        this.c = (WindowManager) r2;
        i r3 = new i(r4);
        this.d = r3;
        this.i = 4000;
        this.e = r3.b.a;
        return;
    L7:
        throw new IllegalArgumentException((r4 + " is not an Activity!").toString());
    }

    public final void a(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "onDismissed");
        final i r0 = this.d;
        C0145b r1 = new C0145b(this, r5);
        ViewPropertyAnimator r6 = r0.b.a.animate().setDuration(200).alpha(0.0f).setListener(new j(r1, r0, new FlowToastViewController$startDismissAnimate$1(r0)));
        r6.start();
        r0.c = r6;
    }

    public final void setIcon(int r3) {
        i r0 = this.d;
        r0.a(UDIconUtils.getIconDrawable(r0.a, r3));
    }

    public final void setText(CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "s");
        i r1 = this.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "s");
        r1.b.e.setText(r3);
    }

    public final void setIcon(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.d.a(r2);
    }
}
