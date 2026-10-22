package com.obric.assistant.component.task;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class n {
    public final Context a;
    public final View b;
    public final LifecycleOwner c;
    public TaskPanelView d;
    public FrameLayout e;
    public TaskPanelView f;
    public PopupWindow g;
    public Job h;
    public final ConstraintLayout i;
    public boolean j;
    public boolean k;
    public List<com.obric.assistant.task.b> l;
    public boolean m;
    public final int n;

    public static final class a {
    }

    public static final class b implements Transition.TransitionListener {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ n b;
        public final /* synthetic */ c c;
        public final /* synthetic */ View d;
        public final /* synthetic */ int e;

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionPause(Transition r2) {
            Intrinsics.checkNotNullParameter(r2, "t");
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionResume(Transition r2) {
            Intrinsics.checkNotNullParameter(r2, "t");
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionCancel(Transition r6) {
            Intrinsics.checkNotNullParameter(r6, "t");
            n r7 = this.b;
            int r0 = 0;
            r7.k = false;
            r7.m = false;
            TaskPanelView r1 = r7.d;
            if (r1 != null) goto L5;
        L11:
            final n r8 = this.b;
            TaskPanelView r2 = r8.d;
            if (r2 == null) goto L15;
            final c r3 = this.c;
            final View r4 = this.d;
            final int r5 = this.e;
            r2.post(new o(r8, r3, r4, r5));
            return;
        L15:
            return;
        L5:
            if (r7.j == true) goto L7;
        L9:
            r0 = 8;
        L10:
            r1.setVisibility(r0);
            goto L11
        L7:
            if ((!r7.l.isEmpty()) == false) goto L9;
            goto L9
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionEnd(Transition r6) {
            Intrinsics.checkNotNullParameter(r6, "transition");
            n r7 = this.b;
            int r1 = 0;
            if (r7.j == false) goto L7;
            boolean r0 = true;
            if ((!r7.l.isEmpty()) == false) goto L7;
        L8:
            FLogger r8 = FLogger.a;
            if (r0 == false) goto L11;
            String r2 = "VISIBLE";
        L12:
            r8.i("TaskPanelController", "[TaskPanel-SM] collapseWithAnimation: END. Target CollapsedVisibility=".concat(r2));
            n r9 = this.b;
            r9.k = false;
            r9.m = false;
            TaskPanelView r10 = r9.d;
            if (r10 == null) goto L18;
            if (r0 == true) goto L17;
            r1 = 8;
        L17:
            r10.setVisibility(r1);
        L18:
            if (r0 == true) goto L22;
            TaskPanelView r11 = this.b.f;
            if (r11 == null) goto L22;
            r11.b(CollectionsKt.emptyList());
        L22:
            final n r12 = this.b;
            TaskPanelView r3 = r12.d;
            if (r3 == null) goto L26;
            final c r4 = this.c;
            final View r5 = this.d;
            final int r13 = this.e;
            r3.post(new p(r12, r4, r5, r13));
            return;
        L26:
            return;
        L11:
            r2 = "GONE";
        L7:
            r0 = false;
            goto L8
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionStart(Transition r2) {
            Intrinsics.checkNotNullParameter(r2, "t");
            this.a.element = true;
        }

        public b(Ref.BooleanRef r1, n r2, c r3, View r4, int r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class c implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ View b;
        public final /* synthetic */ n c;
        public final /* synthetic */ int d;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (this.a.element == true) goto L8;
            View r0 = this.b;
            if (r0 == null) goto L7;
            r0.setTranslationX(0.0f);
        L7:
            return true;
        L8:
            TaskPanelView r1 = this.c.f;
            int r2 = 0;
            if (r1 == null) goto L11;
            int r3 = r1.getLeft();
        L12:
            View r4 = this.b;
            if (r4 == null) goto L15;
            r2 = r4.getLeft();
        L15:
            View r5 = this.b;
            if (r5 == null) goto L18;
            r5.setTranslationX((this.d - r3) - r2);
        L18:
            return true;
        L11:
            r3 = 0;
            goto L12
        }

        public c(Ref.BooleanRef r1, View r2, n r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final void b() {
        this.j = false;
        c();
        Job r0 = this.h;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        TaskPanelView r1 = this.d;
        if (r1 == null) goto L10;
        ConstraintLayout r2 = this.i;
        if (r2 == null) goto L10;
        r2.removeView(r1);
    L10:
        PopupWindow r3 = this.g;
        if (r3 == null) goto L14;
        PopupWindowLancet.handleDismissBeforeOrigin(r3);
        r3.dismiss();
        return;
    }

    public final void a() {
        if (this.k == true) goto L5;
        return;
    L5:
        if (this.m == true) goto L51;
        FLogger.a.i("TaskPanelController", "[TaskPanel-SM] collapseWithAnimation: START");
        this.m = true;
        TaskPanelView r0 = this.d;
        if (r0 != null) goto L10;
        return;
    L10:
        int r8 = r0.getWidth();
        int r9 = r0.getHeight();
        int[] r1 = new int[2];
        this.b.getLocationInWindow(r1);
        int r12 = r1[0] + ((this.b.getWidth() - r8) / 2);
        FrameLayout r2 = this.e;
        if (r2 == null) goto L13;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        r3.height = r2.getHeight();
        r2.setLayoutParams(r3);
    L13:
        TaskPanelView r4 = this.f;
        if (r4 == null) goto L16;
        View r5 = r4.findViewById(2131366828);
    L17:
        if (r5 == null) goto L21;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L21;
        int r7 = r6.width;
    L23:
        if (r5 == null) goto L33;
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if (r10 == null) goto L33;
        r10.width = r8;
        if ((r10 instanceof LinearLayout.LayoutParams) == false) goto L30;
        ((LinearLayout.LayoutParams) r10).gravity = 8388659;
    L32:
        r5.setLayoutParams(r10);
        goto L33
    L30:
        if ((r10 instanceof FrameLayout.LayoutParams) == false) goto L32;
        ((FrameLayout.LayoutParams) r10).gravity = 8388659;
    L33:
        Ref.BooleanRef r11 = new Ref.BooleanRef();
        c r13 = new c(r11, r5, this, r12);
        TaskPanelView r14 = this.f;
        if (r14 == null) goto L38;
        ViewTreeObserver r15 = r14.getViewTreeObserver();
        if (r15 == null) goto L38;
        r15.addOnPreDrawListener(r13);
    L38:
        ChangeBounds r16 = new ChangeBounds();
        r16.excludeTarget(2131366828, true);
        r16.excludeTarget(2131384945, true);
        TransitionSet r17 = new TransitionSet().addTransition(r16).addTransition(new Fade()).setDuration(250);
        r17.addListener(new b(r11, this, r13, r5, r7));
        TransitionManager.beginDelayedTransition(this.e, r17);
        ObjectAnimator r18 = ObjectAnimator.ofFloat(this.f, "panelCornerRadius", new float[]{c7.b(20), c7.b(100)});
        r18.setDuration(250);
        r18.start();
        TaskPanelView r19 = this.f;
        if (r19 == null) goto L41;
        r19.setMode(TaskPanelView.State.COLLAPSED);
    L41:
        TaskPanelView r20 = this.f;
        if (r20 == null) goto L44;
        ViewGroup.LayoutParams r110 = r20.getLayoutParams();
    L45:
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r111 = (FrameLayout.LayoutParams) r110;
        r111.width = r8;
        r111.height = r9;
        r111.gravity = 8388659;
        r111.leftMargin = r12;
        int r21 = this.n;
        r111.topMargin = r21;
        r111.bottomMargin = r21;
        TaskPanelView r22 = this.f;
        if (r22 == null) goto L50;
        r22.setLayoutParams(r111);
        return;
    L50:
        return;
    L44:
        r110 = null;
    L21:
        r7 = -1;
        goto L23
    L16:
        r5 = null;
        goto L17
    }

    public final void c() {
        FLogger r0 = FLogger.a;
        r0.i("TaskPanelController", "[TaskPanel-SM] updatePanelState triggered. tasksCount=" + this.l.size() + ", isExpanded=" + this.k);
        if (this.j == true) goto L5;
    L23:
        r0.i("TaskPanelController", "[TaskPanel-SM] Action: Hide Panels & Trigger Collapse (Data Empty)");
        TaskPanelView r1 = this.d;
        if (r1 == null) goto L26;
        r1.b(CollectionsKt.emptyList());
    L26:
        TaskPanelView r2 = this.d;
        if (r2 == null) goto L29;
        r2.setVisibility(8);
    L29:
        a();
        return;
    L5:
        if ((!this.l.isEmpty()) == false) goto L23;
        if (this.d != null) goto L12;
        TaskPanelView r3 = new TaskPanelView(this.a, null);
        r3.setId(2131381263);
        r3.setMode(TaskPanelView.State.COLLAPSED);
        r3.setOnPanelClickListener(new i(this));
        this.d = r3;
        ConstraintLayout.LayoutParams r4 = new ConstraintLayout.LayoutParams(-2, -2);
        r4.startToStart = this.b.getId();
        r4.endToEnd = this.b.getId();
        r4.topToBottom = this.b.getId();
        ((ViewGroup.MarginLayoutParams) r4).topMargin = c7.b(0);
        ConstraintLayout r5 = this.i;
        if (r5 == null) goto L12;
        r5.addView(this.d, r4);
    L12:
        TaskPanelView r6 = this.d;
        if (r6 == null) goto L15;
        r6.b(this.l);
    L15:
        TaskPanelView r7 = this.f;
        if (r7 == null) goto L19;
        r7.b(this.l);
    L19:
        if (this.k == true) goto L31;
        r0.i("TaskPanelController", "[TaskPanel-SM] Action: Show Collapsed Panel");
        TaskPanelView r8 = this.d;
        if (r8 == null) goto L32;
        r8.setVisibility(0);
        return;
    L32:
        return;
    }

    public n(FragmentActivity r9, View r10, FragmentActivity r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "anchorView");
        this.a = r9;
        this.b = r10;
        this.c = r11;
        this.l = CollectionsKt.emptyList();
        this.n = c7.b(16);
        ConstraintLayout r12 = r10.getParent();
        Job r1 = null;
        if ((r12 instanceof ConstraintLayout) == false) goto L5;
        ConstraintLayout r13 = r12;
    L6:
        if (r13 == null) goto L17;
        this.i = r13;
        if (r10.getId() != (-1)) goto L10;
        r10.setId(View.generateViewId());
    L10:
        if (r11 == null) goto L14;
        LifecycleCoroutineScope r2 = LifecycleOwnerKt.getLifecycleScope(r11);
        if (r2 == null) goto L14;
        r1 = BuildersKt.launch$default(r2, null, null, new TaskPanelController$startObserving$1(this, null), 3, null);
    L14:
        this.h = r1;
        return;
    L17:
        throw new IllegalStateException("AnchorView must be inside a ConstraintLayout");
    L5:
        r13 = null;
        goto L6
    }
}
