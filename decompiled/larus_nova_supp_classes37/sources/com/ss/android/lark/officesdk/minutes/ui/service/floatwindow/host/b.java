package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public Application a;
    public hwb.c b;
    public WeakReference<Activity> c;
    public WeakReference<Activity> d;
    public MutableContextWrapper e;
    public iwb.a f;
    public hwb.a g;
    public boolean h;
    public boolean i;
    public final a j;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public final /* synthetic */ b a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public a(b r1) {
            this.a = r1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r11) {
            Intrinsics.checkNotNullParameter(r11, "activity");
            b r0 = this.a;
            hwb.c r1 = r0.b;
            WeakReference<Activity> r2 = r0.c;
            if (r2 == null) goto L5;
            Activity r3 = r2.get();
        L6:
            boolean r4 = true;
            if (r1 == null) goto L17;
            b r5 = this.a;
            String r6 = r1.a;
            r5.getClass();
            if (((ViewGroup) ((FrameLayout) b.a(r11.getWindow()).findViewById(R.id.content)).findViewWithTag(r6)) != null) goto L16;
            if (r3 == r11) goto L16;
            MutableContextWrapper r7 = this.a.e;
            if (r7 == null) goto L14;
            Context r8 = r7.getBaseContext();
        L15:
            if (r8 != r11) goto L17;
        L14:
            r8 = null;
        L16:
            boolean r9 = true;
        L19:
            if (r9 == false) goto L59;
            if (r1 == null) goto L59;
            int r10 = bwb.b.a;
            MmUiLogScene r12 = MmUiLogScene.FLOAT;
            StringBuilder r13 = new StringBuilder("cleanup destroyed activity float, activity=");
            r13.append(r11.getClass().getName());
            r13.append(", recordingId=");
            r13.append(r1.a);
            r13.append(", attached=");
            if (r3 != r11) goto L24;
            boolean r14 = true;
        L25:
            r13.append(r14);
            r13.append(", baseContext=");
            MutableContextWrapper r15 = this.a.e;
            if (r15 == null) goto L28;
            Context r16 = r15.getBaseContext();
        L29:
            if (r16 == r11) goto L32;
            r4 = false;
        L32:
            r13.append(r4);
            bwb.b.g(r12, "onActivityDestroyed", r13.toString(), null, 8);
            b r17 = this.a;
            iwb.a r18 = r17.f;
            if (r18 == null) goto L41;
            ViewParent r19 = r18.getParent();
            if ((r19 instanceof ViewGroup) == false) goto L38;
            ViewGroup r20 = (ViewGroup) r19;
        L39:
            if (r20 == null) goto L41;
            r20.removeView(r18);
            goto L41
        L38:
            r20 = null;
        L41:
            iwb.a r21 = r17.f;
            if (r21 == null) goto L44;
            r21.c.removeAllViews();
            r21.k = null;
        L44:
            iwb.a r22 = r17.f;
            if (r22 == null) goto L47;
            r22.setOnFirstPositioned$officesdk_minutes_base_ui_release(null);
        L47:
            iwb.a r23 = r17.f;
            if (r23 == null) goto L50;
            r23.setOnLayoutStateChanged$officesdk_minutes_base_ui_release(null);
        L50:
            MutableContextWrapper r24 = r17.e;
            if (r24 == null) goto L53;
            r24.setBaseContext(yub.d.a.getContext());
        L53:
            r1.e.d(r1.a, false);
            WeakReference<Activity> r25 = r17.c;
            if (r25 == null) goto L56;
            Activity r26 = r25.get();
        L57:
            if (r26 != r11) goto L59;
            r17.c = null;
            goto L59
        L56:
            r26 = null;
            goto L57
        L28:
            r16 = null;
            goto L29
        L24:
            r14 = false;
        L59:
            if (r3 != r11) goto L61;
            int r27 = bwb.b.a;
            bwb.b.g(MmUiLogScene.FLOAT, "onActivityDestroyed", "clear attached activity, activity=".concat(r11.getClass().getName()), null, 8);
            this.a.c = null;
        L61:
            WeakReference<Activity> r28 = this.a.d;
            if (r28 == null) goto L64;
            Activity r29 = r28.get();
        L65:
            if (r29 != r11) goto L68;
            this.a.d = null;
            return;
        L68:
            return;
        L64:
            r29 = null;
        L17:
            r9 = false;
            goto L19
        L5:
            r3 = null;
            goto L6
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r9) {
            Intrinsics.checkNotNullParameter(r9, "activity");
            b r0 = this.a;
            hwb.c r1 = r0.b;
            if (r1 != null) goto L5;
            return;
        L5:
            WeakReference<Activity> r2 = r0.c;
            if (r2 == null) goto L8;
            Activity r3 = r2.get();
        L9:
            int r4 = bwb.b.a;
            MmUiLogScene r5 = MmUiLogScene.FLOAT;
            StringBuilder r6 = new StringBuilder("activity=");
            r6.append(r9.getClass().getName());
            r6.append(", attached=");
            if (r3 != r9) goto L12;
            boolean r7 = true;
        L13:
            r6.append(r7);
            r6.append(", recordingId=");
            r6.append(r1.a);
            bwb.b.g(r5, "onActivityPaused", r6.toString(), null, 8);
            if (r3 != r9) goto L16;
            this.a.c = null;
            r1.e.d(r1.a, false);
        L16:
            WeakReference<Activity> r8 = this.a.d;
            if (r8 == null) goto L19;
            Activity r10 = r8.get();
        L20:
            if (r10 != r9) goto L23;
            this.a.d = null;
            return;
        L23:
            return;
        L19:
            r10 = null;
            goto L20
        L12:
            r7 = false;
            goto L13
        L8:
            r3 = null;
            goto L9
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r8) {
            Intrinsics.checkNotNullParameter(r8, "activity");
            this.a.d = new WeakReference(r8);
            hwb.c r3 = this.a.b;
            if (r3 != null) goto L5;
            return;
        L5:
            int r0 = bwb.b.a;
            bwb.b.g(MmUiLogScene.FLOAT, "onActivityResumed", "attach, activity=" + r8.getClass().getName() + ", recordingId=" + r3.a, null, 8);
            b r1 = this.a;
            r1.b(r8, r3, r3.c.b(), r1.i ^ true, false);
        }
    }

    public final void d() {
        iwb.a r0 = this.f;
        if (r0 == null) goto L11;
        ViewParent r2 = r0.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L8;
        ViewGroup r3 = (ViewGroup) r2;
    L9:
        if (r3 == null) goto L11;
        r3.removeView(r0);
        goto L11
    L8:
        r3 = null;
    L11:
        iwb.a r1 = this.f;
        if (r1 == null) goto L14;
        r1.c.removeAllViews();
        r1.k = null;
    L14:
        MutableContextWrapper r4 = this.e;
        if (r4 == null) goto L17;
        r4.setBaseContext(yub.d.a.getContext());
    L17:
        this.f = null;
        this.g = null;
        this.e = null;
    }

    public final void e() {
        if (this.h == true) goto L5;
        return;
    L5:
        Application r0 = this.a;
        if (r0 == null) goto L8;
        r0.unregisterActivityLifecycleCallbacks(this.j);
    L8:
        this.a = null;
        this.h = false;
        int r1 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FLOAT, "unregister", "unregistered lifecycle callbacks", null, 8);
    }

    public b() {
        this.j = new a(this);
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

    public final void c(iwb.a r7, Activity r8, hwb.c r9) {
        MutableContextWrapper r0 = this.e;
        if (r0 == null) goto L5;
        r0.setBaseContext(r8);
    L5:
        r7.setTag(r9.a);
        r7.setContent(r9.b.a(r8, new hwb.b(r9.a, r9.f, r9.g, new com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host.a(r9))));
    }

    public final void b(final Activity r8, final hwb.c r9, hwb.a r10, final boolean r11, boolean r12) {
        if (r8.isFinishing() == false) goto L5;
    L36:
        int r13 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FLOAT, "attachToActivity", "skip destroyed activity=" + r8.getClass().getName() + ", recordingId=" + r9.a, null, 8);
        return;
    L5:
        if (r8.isDestroyed() == true) goto L36;
        iwb.a r0 = this.f;
        if (r0 != null) goto L10;
    L13:
        MutableContextWrapper r1 = new MutableContextWrapper(r8);
        this.e = r1;
        this.g = r10;
        iwb.a r5 = new iwb.a(r1, r10);
        r5.setTag(r9.a);
        hwb.d r14 = r9.d;
        Intrinsics.checkNotNullParameter(r14, "state");
        r5.l = r14.e;
        iwb.d r6 = r5.i;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r14, "state");
        r6.j = r14;
        this.f = r5;
        r0 = r5;
    L14:
        ViewParent r15 = r0.getParent();
        if ((r15 instanceof ViewGroup) == false) goto L17;
        ViewGroup r16 = (ViewGroup) r15;
    L18:
        FrameLayout r7 = (FrameLayout) a(r8.getWindow()).findViewById(R.id.content);
        MutableContextWrapper r17 = this.e;
        if (r17 == null) goto L21;
        r17.setBaseContext(r8);
    L21:
        r0.setTag(r9.a);
        r0.setOnLayoutStateChanged$officesdk_minutes_base_ui_release(new MmActivityRecordingFloatHost$configureContainerCallbacks$1(r9));
        r0.setOnFirstPositioned$officesdk_minutes_base_ui_release(new MmActivityRecordingFloatHost$configureContainerCallbacks$2(r8, r11, r9, this));
        if (r16 != r7) goto L32;
        if (r12 == false) goto L25;
        c(r0, r8, r9);
    L25:
        this.c = new WeakReference(r8);
        r9.e.d(r9.a, true);
        if (r11 == true) goto L28;
    L31:
        int r18 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FLOAT, "attachToActivity", "reuse attached container, activity=" + r8.getClass().getName() + ", recordingId=" + r9.a, null, 8);
        return;
    L28:
        if (this.i == true) goto L31;
        this.i = true;
        r9.e.f(r9.a);
        goto L31
    L32:
        if (r16 == null) goto L34;
        int r19 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FLOAT, "attachToActivity", "move container from parent=" + r16.getClass().getName() + ", current=" + r8.getClass().getName() + ", recordingId=" + r9.a, null, 8);
        r16.removeView(r0);
    L34:
        c(r0, r8, r9);
        this.c = new WeakReference(r8);
        r7.addView(r0, new FrameLayout.LayoutParams(-1, -1));
        int r110 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FLOAT, "attachToActivity", "container attached, activity=" + r8.getClass().getName() + ", recordingId=" + r9.a, null, 8);
        return;
    L17:
        r16 = null;
        goto L18
    L10:
        if (Intrinsics.areEqual(this.g, r10) == true) goto L14;
        d();
        goto L13
    }
}
