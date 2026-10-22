package com.bytedance.android.livesdk.gift.platform.business.effect.giftview;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends Dialog {
    public FrameLayout a;
    public GLSurfaceView b;
    public j50.a c;
    public k50.c d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.effect.giftview.a$a, reason: collision with other inner class name */
    public static final class C0052a {
    }

    static {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a("FlyMicDialog", "dismiss: dismiss dialog");
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k50.c r0 = this.d;
        if (r0 == null) goto L6;
        r0.b = true;
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L37;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r0 = getWindow();
        if (r0 == null) goto L10;
        WindowManager.LayoutParams r1 = r0.getAttributes();
    L11:
        if (r1 == null) goto L13;
        r1.width = -1;
    L13:
        if (r1 == null) goto L15;
        r1.height = s1.w() - s1.A();
    L15:
        Window r2 = getWindow();
        if (r2 == null) goto L24;
        View r3 = r2.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L22;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == com.larus.home.impl.utils.c.a) goto L22;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");
    L22:
        if (r3 == null) goto L24;
        r3.setPadding(0, 0, 0, 0);
    L24:
        Window r5 = getWindow();
        if (r5 == null) goto L28;
        r5.setGravity(80);
    L28:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.z.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[24])).booleanValue() == false) goto L32;
        Window r6 = getWindow();
        if (r6 == null) goto L32;
        r6.clearFlags(2);
    L32:
        Window r7 = getWindow();
        if (r7 == null) goto L39;
        r7.setAttributes(r1);
        return;
    L39:
        return;
    L10:
        r1 = null;
        goto L11
    L37:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public a(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super(r2);
        Window r3 = getWindow();
        if (r3 == null) goto L5;
        r3.setBackgroundDrawableResource(R.color.transparent);
    L5:
        Window r4 = getWindow();
        if (r4 == null) goto L9;
        r4.clearFlags(2);
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        setContentView(2131567008);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        Window r6 = getWindow();
        if (r6 == null) goto L5;
        r6.addFlags(16);
    L5:
        Window r7 = getWindow();
        if (r7 == null) goto L9;
        r7.addFlags(8);
    L9:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.f() == false) goto L13;
        Window r8 = getWindow();
        if (r8 == null) goto L13;
        r8.setType(1);
    L13:
        this.a = (FrameLayout) findViewById(2131373681);
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.E.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[29])).booleanValue() == false) goto L49;
        this.c = new j50.a();
        GLSurfaceView r9 = (GLSurfaceView) findViewById(2131381772);
        this.b = r9;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mGLFlyMicOverMP4View");
    L18:
        UtilityKotlinExtentionsKt.w(r9);
        j50.a r10 = this.c;
        if (r10 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mGLFlyMicOverMP4Scene");
    L21:
        GLSurfaceView r3 = this.b;
        if (r3 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mGLFlyMicOverMP4View");
    L24:
        r10.e = new j50.b(r3);
        GLSurfaceView r11 = this.b;
        if (r11 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mGLFlyMicOverMP4View");
    L27:
        Context r2 = getContext();
        j50.a r4 = this.c;
        if (r4 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mGLFlyMicOverMP4Scene");
    L30:
        v50.a.b(r11, r2, r4);
        GLSurfaceView r13 = this.b;
        if (r13 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mGLFlyMicOverMP4View");
    L33:
        this.d = new k50.c(r13);
        j50.a r14 = this.c;
        if (r14 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mGLFlyMicOverMP4Scene");
    L36:
        GLSurfaceView r1 = this.b;
        if (r1 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mGLFlyMicOverMP4View");
    L39:
        k50.e.c(r1, r14);
        k50.c r15 = this.d;
        if (r15 == null) goto L45;
        GLSurfaceView r16 = this.b;
        if (r16 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mGLFlyMicOverMP4View");
    L44:
        k50.e.b(r16, r15);
    L45:
        k50.c r17 = this.d;
        if (r17 == null) goto L50;
        r17.a();
        return;
    L50:
        return;
    }
}
