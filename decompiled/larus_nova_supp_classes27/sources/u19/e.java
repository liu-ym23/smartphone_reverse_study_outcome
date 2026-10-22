package u19;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.utils.logger.FLogger;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public class e extends a<Balloon> {
    public final boolean a;
    public int b;
    public final AtomicBoolean c;

    public boolean b() {
        return false;
    }

    public e() {
        this.a = true;
        this.b = 3500;
        this.c = new AtomicBoolean(false);
    }

    @Override // u19.a, u19.f
    public final void dismiss() {
        super.dismiss();
        FLogger.a.d("ToastLogger", "balloon holder dismiss, instance: " + getInstance() + '.');
        clear();
        Balloon r0 = getInstance();
        if (r0 == null) goto L5;
        r0.h();
    L5:
        setInstance(null);
        this.c.set(true);
    }

    @Override // u19.a
    public final int getDisplayDuration() {
        return this.b;
    }

    @Override // u19.a
    public final boolean getSupportLottie() {
        return this.a;
    }

    public static View a(Window r3) {
        if (r3 == null) goto L16;
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L8;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L8;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L8:
        if (r4 == null) goto L20;
        ViewParent r1 = r4.getParent();
    L11:
        if (r1 == null) goto L15;
        if ((r1 instanceof View) == false) goto L15;
        r4 = r1;
        r1 = r4.getParent();
    L15:
        return r4;
    L20:
        return null;
    L16:
        return null;
    }

    @Override // u19.a
    public final void setDisplayDuration(int r1) {
        this.b = r1;
    }

    @Override // u19.f
    public final void setDuration(int r1) {
        if (r1 != 0) goto L4;
        r1 = 3500;
    L4:
        this.b = r1;
    }

    @Override // u19.a
    public final void show(Activity r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        if (this.c.get() == false) goto L6;
        dismiss();
        return;
    L6:
        LifecycleOwner r1 = null;
        if (b() == false) goto L42;
        View r0 = null;
    L21:
        if (r0 != null) goto L23;
        r0 = a(r7.getWindow());
    L31:
        if (r0 != null) goto L35;
        dismiss();
        FLogger.a.d("ToastLogger", "balloon holder show interrupt, because find anchor from activity" + r7 + " view failed!");
        return;
    L35:
        if (b() == false) goto L37;
        FLogger.a.i("ToastLogger", "action toast use activity decor anchor activity=" + r7.getClass().getSimpleName() + " identity=" + System.identityHashCode(r7));
    L37:
        super.show(r7, r8);
        FLogger.a.d("ToastLogger", "show balloon holder from activity");
        if ((r7 instanceof LifecycleOwner) == false) goto L40;
        r1 = (LifecycleOwner) r7;
    L40:
        c(r7, r1, r0, r8);
        return;
    L23:
        Rect r2 = new Rect();
        if (r0.getLocalVisibleRect(r2) == true) goto L26;
    L29:
        r0 = a(r7.getWindow());
        goto L31
    L26:
        if (r2.width() == 0) goto L29;
        if (r2.height() != 0) goto L31;
    L42:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        if ((r7 instanceof FragmentActivity) == false) goto L12;
        View r4 = ((Fragment) CollectionsKt.last(((FragmentActivity) r7).getSupportFragmentManager().getFragments())).getView();     // Catch: Throwable -> L15
    L13:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r5) == false) goto L20;
        r5 = null;
    L20:
        r0 = (View) r5;
        goto L21
    L12:
        r4 = null;
    L15:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    @Override // u19.a, u19.f
    public final void show(Fragment r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "fragment");
        if (this.c.get() == false) goto L6;
        dismiss();
        return;
    L6:
        Context r0 = r6.getContext();
        if (r0 != null) goto L9;
        return;
    L9:
        FragmentActivity r1 = r6.getActivity();
        if (r1 == null) goto L12;
        Window r2 = r1.getWindow();
    L13:
        View r3 = a(r2);
        if (r3 != null) goto L17;
        dismiss();
        FLogger.a.d("ToastLogger", "balloon holder show interrupt, because find anchor from fragment" + r6 + " view failed!");
        return;
    L17:
        LifecycleOwner r4 = (LifecycleOwner) r6.getViewLifecycleOwnerLiveData().getValue();
        if (r4 != null) goto L20;
        return;
    L20:
        super.show(r6, r7);
        FLogger.a.d("ToastLogger", "show balloon holder from fragment");
        c(r0, r4, r3, r7);
        return;
    L12:
        r2 = null;
        goto L13
    }

    @Override // u19.a, u19.f
    public final void show(Context r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (this.c.get() == false) goto L7;
        dismiss();
        return;
    L7:
        if ((r3 instanceof Activity) == false) goto L9;
        show((Activity) r3, r4);
        return;
    L9:
        FLogger.a.d("ToastLogger", "balloon holder show interrupt, because passing context is not a valid Activity instance: " + r3 + '.');
    }

    public final void c(Context r5, LifecycleOwner r6, View r7, boolean r8) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("balloon holder show, disable: ");
        r1.append(this.c.get());
        r1.append(",duration: ");
        r1.append(this.b);
        r1.append(", lifecycle state: ");
        Lifecycle.State r2 = null;
        if (r6 == null) goto L7;
        Lifecycle r3 = r6.getLifecycle();
        if (r3 == null) goto L7;
        Lifecycle.State r4 = r3.getCurrentState();
    L8:
        r1.append(r4);
        r0.d("ToastLogger", r1.toString());
        if (this.c.get() == false) goto L11;
    L26:
        r0.d("ToastLogger", "balloon holder show interrupt.");
        dismiss();
        return;
    L11:
        if (this.b == 0) goto L26;
        if (r6 == null) goto L17;
        Lifecycle r9 = r6.getLifecycle();
        if (r9 == null) goto L17;
        r2 = r9.getCurrentState();
    L17:
        if (r2 == Lifecycle.State.DESTROYED) goto L26;
        if (this.c.get() == false) goto L22;
    L24:
        r0.d("ToastLogger", "balloon holder show interrupt, because anchor view is detached or holder is prohibited from being displayed.");
        dismiss();
        return;
    L22:
        if (r7.isAttachedToWindow() == false) goto L24;
        Balloon.w(ensureInstance(r5, r6, this.b, r8), r7, 0, 6);
        r0.d("ToastLogger", "balloon holder show.");
        return;
    L7:
        r4 = null;
        goto L8
    }

    @Override // u19.a
    public final Balloon newInstance(Context r4, LifecycleOwner r5, int r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Balloon.a r0 = new Balloon.a(r4);
        r0.n(Integer.MIN_VALUE);
        r0.j(Integer.MIN_VALUE);
        r0.z = 16.0f;
        r0.e(ArrowPositionRules.ALIGN_BALLOON);
        boolean r1 = false;
        r0.f(0);
        r0.p = 0.5f;
        r0.v = 0;
        r0.g(BalloonAnimation.FADE);
        r0.g0 = false;
        r0.W = r5;
        if (getShouldAutoDisappear() == false) goto L7;
        if (r6 <= 0) goto L7;
        r0.V = r6;
    L7:
        if (getShouldAutoDisappear() == true) goto L9;
    L11:
        r0.h(r1);
        r0.T = true;
        r0.l(new d(this));
        ConstraintLayout r8 = buildLayout(r4, r7);
        Intrinsics.checkNotNullParameter(r8, "layout");
        r0.I = r8;
        return r0.b();
    L9:
        if (this.b <= 0) goto L11;
        r1 = true;
        goto L11
    }
}
