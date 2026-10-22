package com.bytedance.ai.debugscene;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.ai.debug.NativeDebugPanelType;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.utils.logger.FLogger;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w0 {
    public static final w0 a = null;

    public static final class a implements j0 {
        public final Activity a;
        public final NativeDebugPanelType b;
        public final String c;
        public final k0 d;
        public final Function0<Unit> e;
        public final Function0<Unit> f;
        public final AtomicBoolean g;
        public final Handler h;
        public final BottomSheetDialog i;
        public final LinearLayout j;
        public final FrameLayout k;
        public final ProgressBar l;
        public final View m;
        public LynxView n;
        public volatile boolean o;
        public String p;
        public int q;

        @Override // com.bytedance.ai.debugscene.j0
        public final void close() {
            if (this.g.get() == false) goto L5;
            return;
        L5:
            Window r0 = this.i.getWindow();
            if (r0 == null) goto L12;
            View r1 = r0.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L14;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r10 = ThreadMethodProxy.currentThread();
            if (r10 == com.larus.home.impl.utils.c.a) goto L14;
            com.larus.home.impl.utils.c.a(r10, "getDecorView");
        L14:
            if (this.i.isShowing() == false) goto L30;
            if (r1 == null) goto L19;
            boolean r11 = true;
            if (r1.isAttachedToWindow() != true) goto L19;
        L20:
            if (r11 == false) goto L30;
            Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L24
            c(this.i);     // Catch: Throwable -> L24
            Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
        L26:
            Throwable r14 = Result.exceptionOrNull-impl(r13);
            if (r14 == null) goto L34;
            com.bytedance.ai.utils.g.a.w("AIDebugPanelPopupLauncher", "dismiss panel failed, fallback to release, type:" + this.b + ", error:" + r14.getMessage());
            f();
            return;
        L34:
            return;
        L24:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            r13 = Result.constructor-impl(ResultKt.createFailure(th));
        L19:
            r11 = false;
        L30:
            com.bytedance.ai.utils.g.a.i("AIDebugPanelPopupLauncher", "release panel directly because dialog window is detached, type:" + this.b);
            f();
            return;
        L12:
            r1 = null;
            goto L14
        }

        /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.ai.debugscene.o0, java.lang.Object] */
        public final void e() {
            if (this.g.get() == false) goto L5;
            return;
        L5:
            final int r0 = this.q + 1;
            this.q = r0;
            this.o = false;
            this.l.setVisibility(0);
            this.m.setVisibility(8);
            View r10 = this.n;
            if (r10 == null) goto L8;
            this.k.removeView(r10);
            r10.destroy();
        L8:
            this.n = null;
            int r11 = b0.a;
            NativeDebugPanelType r12 = this.b;
            Intrinsics.checkNotNullParameter(r12, "type");
            int r13 = b0.a.a[r12.ordinal()];
            if (r13 != 1) goto L11;
            final String r1 = "builtin://debugInstancePanel/template.js";
        L16:
            ExecutorService r14 = z0.a;
            final Context r15 = this.a.getApplicationContext();
            final ?? r16 = new o0(this, r0, r1);
            Intrinsics.checkNotNullParameter(r15, "context");
            Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
            Intrinsics.checkNotNullParameter(r16, "callback");
            z0.a.execute(new y0(r16, r1, r15));
            return;
        L11:
            if (r13 != 2) goto L14;
            r1 = "builtin://agentTracePanel/template.js";
            goto L16
        L14:
            throw new NoWhenBranchMatchedException();
        }

        public final void f() {
            if (this.g.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            this.q++;
            this.o = false;
            LynxView r0 = this.n;
            if (r0 == null) goto L8;
            r0.destroy();
        L8:
            this.n = null;
            this.k.removeAllViews();
            com.bytedance.ai.utils.g.a.i("AIDebugPanelPopupLauncher", "release raw Lynx panel, type:" + this.b);
            this.f.invoke();
        }

        public final void i() {
            Resources r1 = this.a.getResources();
            float r10 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).heightPixels;
            int r11 = (int) (0.9f * r10);
            int r12 = (int) (r10 * 0.6f);
            this.j.setOrientation(1);
            LinearLayout r13 = this.j;
            GradientDrawable r14 = new GradientDrawable();
            r14.setColor(-1);
            r14.setCornerRadii(new float[]{d(16.0f), d(16.0f), d(16.0f), d(16.0f), 0.0f, 0.0f, 0.0f, 0.0f});
            r13.setBackground(r14);
            LinearLayout r15 = this.j;
            FrameLayout r16 = new FrameLayout(this.a);
            View r17 = new View(this.a);
            GradientDrawable r18 = new GradientDrawable();
            r18.setShape(0);
            r18.setCornerRadius(d(2.0f));
            r18.setColor(Color.rgb(196, 199, 204));
            r17.setBackground(r18);
            r16.addView(r17, new FrameLayout.LayoutParams((int) d(36.0f), (int) d(4.0f), 17));
            r15.addView(r16, new LinearLayout.LayoutParams(-1, (int) d(12.0f)));
            this.j.addView(this.k, new LinearLayout.LayoutParams(-1, 0, 1.0f));
            this.k.addView(this.l, new FrameLayout.LayoutParams(-2, -2, 17));
            this.k.addView(this.m, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout r19 = this.k;
            FrameLayout r20 = new FrameLayout(this.a);
            r20.setContentDescription(this.a.getString(2131896078));
            r20.setClickable(true);
            r20.setOnClickListener(new p0(this));
            ImageView r21 = new ImageView(this.a);
            GradientDrawable r110 = new GradientDrawable();
            r110.setShape(1);
            r110.setColor(Color.rgb(242, 243, 245));
            r21.setBackground(r110);
            r21.setScaleType(ImageView.ScaleType.CENTER);
            r21.setImageResource(2131235789);
            r20.addView(r21, new FrameLayout.LayoutParams((int) d(36.0f), (int) d(36.0f), 17));
            FrameLayout.LayoutParams r22 = new FrameLayout.LayoutParams((int) d(44.0f), (int) d(44.0f), 8388661);
            r22.setMarginEnd((int) d(8.0f));
            r19.addView(r20, r22);
            this.m.setVisibility(8);
            this.i.setContentView(this.j, new ViewGroup.LayoutParams(-1, r11));
            this.i.setCancelable(true);
            this.i.setCanceledOnTouchOutside(false);
            this.i.setOnDismissListener(new l0(this));
            BottomSheetDialog r23 = this.i;
            if (DialogLancet.shouldBlockDialogShow(r23) == false) goto L14;
            DialogLancet.handleBlockedDialogShow(r23);
        L7:
            View r24 = this.i.findViewById(2131368870);
            if (r24 == null) goto L12;
            r24.getLayoutParams().height = r11;
            r24.setBackground(null);
            BottomSheetBehavior r25 = BottomSheetBehavior.from(r24);
            r25.setPeekHeight(r12);
            r25.setHideable(true);
            r25.setSkipCollapsed(false);
            r25.setState(4);
            r25.setBottomSheetCallback(new v0(this));
            e();
            com.bytedance.ai.utils.g.a.i("AIDebugPanelPopupLauncher", "show raw Lynx panel, type:" + this.b);
            return;
        L12:
            throw new IllegalStateException("Material bottom sheet view is unavailable".toString());
        L14:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
        L6:
            DialogLancet.beforeDialogShow(r23);
            r23.show();
            DialogLancet.afterDialogShow(r23);
            goto L7
        }

        public static void c(BottomSheetDialog r10) {
            Handler r0 = DialogLancet.resolveDialogHandler(r10);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r10);
            r10.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L17:
            DialogLancet.afterDialogDismiss(r10);
            return;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L17;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r10);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r10));
        }

        @Override // com.bytedance.ai.debugscene.j0
        public final boolean a(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            if (this.a != r10) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.ai.debugscene.j0
        public final void b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "launchParamsJson");
            if (this.o == true) goto L6;
            this.p = r10;
            return;
        L6:
            h(r10);
        }

        public final float d(float r10) {
            Resources r0 = this.a.getResources();
            return r10 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
        }

        public final void h(String r10) {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
            LynxView r1 = this.n;     // Catch: Throwable -> L8
            if (r1 == null) goto L5;
            r1.sendGlobalEvent("panel.launchParamsChanged", JavaOnlyArray.of(new Object[]{r10}));     // Catch: Throwable -> L8
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L8
        L6:
            Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L8
        L10:
            Throwable r13 = Result.exceptionOrNull-impl(r12);
            if (r13 == null) goto L16;
            com.bytedance.ai.utils.g.a.e("AIDebugPanelPopupLauncher", "send panel params event failed, type:" + this.b + ", error:" + r13.getMessage());
            return;
        L16:
            return;
        L5:
            r11 = null;
        L8:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L10
        }

        public final void j(Throwable r10) {
            this.o = false;
            this.l.setVisibility(8);
            this.m.setVisibility(0);
            com.bytedance.ai.utils.g.a.e("AIDebugPanelPopupLauncher", "render panel template failed, type:" + this.b + ", error:" + r10.getMessage());
        }

        public final boolean g(String r10, String r11) {
            if (this.g.get() == false) goto L5;
        L22:
            return false;
        L5:
            if (this.o == false) goto L22;
            LynxView r12 = this.n;
            if (r12 != null) goto L23;
            return false;
        L23:
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L12
            r12.sendGlobalEvent(r10, JavaOnlyArray.of(new Object[]{r11}));     // Catch: Throwable -> L12
            com.bytedance.ai.utils.g.a.d("AIDebugPanelPopupLauncher", "send panel event, type:" + this.b + ", eventName:" + r10 + ", paramsLength:" + r11.length());     // Catch: Throwable -> L12
            Object r14 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L12
        L14:
            Throwable r15 = Result.exceptionOrNull-impl(r14);
            if (r15 == null) goto L17;
            com.bytedance.ai.utils.g.a.e("AIDebugPanelPopupLauncher", "send panel event failed, type:" + this.b + ", eventName:" + r10 + ", paramsLength:" + r11.length() + ", error:" + r15.getMessage());
        L17:
            Boolean r16 = Boolean.FALSE;
            if (Result.isFailure-impl(r14) == false) goto L21;
            r14 = r16;
        L21:
            return ((Boolean) r14).booleanValue();
        L12:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L14
        }

        @Override // com.bytedance.ai.debugscene.j0
        public final boolean sendEvent(final String r10, final String r11) {
            Intrinsics.checkNotNullParameter(r10, "eventName");
            Intrinsics.checkNotNullParameter(r11, "paramsJson");
            if (this.g.get() == false) goto L5;
        L13:
            com.bytedance.ai.utils.g.a.w("AIDebugPanelPopupLauncher", "send panel event rejected, type:" + this.b + ", eventName:" + r10 + ", loaded:" + this.o + ", released:" + this.g.get() + ", paramsLength:" + r11.length());
            return false;
        L5:
            if (this.o == false) goto L13;
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L10;
            this.a.runOnUiThread(new m0(this, r10, r11));
            return true;
        L10:
            return g(r10, r11);
        }

        public a(Activity r10, NativeDebugPanelType r11, String r12, f0.b r13, d0 r14, e0 r15) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            Intrinsics.checkNotNullParameter(r11, "type");
            Intrinsics.checkNotNullParameter(r12, "initialLaunchParamsJson");
            Intrinsics.checkNotNullParameter(r13, "messageDispatcher");
            Intrinsics.checkNotNullParameter(r14, "onLoaded");
            Intrinsics.checkNotNullParameter(r15, "onDismiss");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
            this.g = new AtomicBoolean(false);
            this.h = new Handler(Looper.getMainLooper());
            this.i = new BottomSheetDialog(r10);
            this.j = new LinearLayout(r10);
            this.k = new FrameLayout(r10);
            this.l = new ProgressBar(r10);
            LinearLayout r16 = new LinearLayout(r10);
            r16.setOrientation(1);
            r16.setGravity(17);
            r16.setBackgroundColor(-1);
            TextView r17 = new TextView(r10);
            r17.setText(r10.getString(2131896079));
            r17.setTextSize(16.0f);
            r17.setGravity(17);
            r17.setTextAlignment(4);
            r17.setTextColor(-12303292);
            r16.addView(r17);
            TextView r18 = new TextView(r10);
            r18.setText(r10.getString(2131896080));
            r18.setTextSize(16.0f);
            r18.setGravity(17);
            r18.setTextColor(-1);
            GradientDrawable r19 = new GradientDrawable();
            r19.setCornerRadius(d(8.0f));
            r19.setColor(Color.rgb(22, 100, 255));
            r18.setBackground(r19);
            r18.setOnClickListener(new n0(this));
            LinearLayout.LayoutParams r20 = new LinearLayout.LayoutParams((int) d(80.0f), (int) d(36.0f));
            r20.gravity = 1;
            r20.topMargin = (int) d(12.0f);
            Unit r21 = Unit.INSTANCE;
            r16.addView(r18, r20);
            this.m = r16;
        }
    }

    static {
        a = new w0();
    }

    public w0() {
    }

    public static j0 a(Activity r10, NativeDebugPanelType r11, String r12, f0.b r13, d0 r14, e0 r15) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r12, "launchParamsJson");
        Intrinsics.checkNotNullParameter(r13, "messageDispatcher");
        Intrinsics.checkNotNullParameter(r14, "onLoaded");
        Intrinsics.checkNotNullParameter(r15, "onDismiss");
        Object r1 = null;
        if (r10.isFinishing() == false) goto L5;
    L21:
        com.bytedance.ai.utils.g.a.e("AIDebugPanelPopupLauncher", "show panel failed because host Activity is unavailable");
        return null;
    L5:
        if (r10.isDestroyed() == true) goto L21;
        a r0 = new a(r10, r11, r12, r13, r14, r15);
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L10
        r0.i();     // Catch: Throwable -> L10
        Object r17 = Result.constructor-impl(r0);     // Catch: Throwable -> L10
    L12:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L16;
        r0.f();
        com.bytedance.ai.utils.g.a.e("AIDebugPanelPopupLauncher", "show panel failed, type:" + r11 + ", error:" + r18.getMessage());
    L16:
        if (Result.isFailure-impl(r17) == true) goto L20;
        r1 = r17;
    L20:
        return (j0) r1;
    L10:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
