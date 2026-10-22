package com.obric.assistant.component.task;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class q implements Transition.TransitionListener {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ n b;
    public final /* synthetic */ View c;
    public final /* synthetic */ r d;

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
        this.b.m = false;
        View r3 = this.c;
        if (r3 == null) goto L5;
        r3.setTranslationX(0.0f);
    L5:
        TaskPanelView r4 = this.b.f;
        if (r4 == null) goto L11;
        ViewTreeObserver r5 = r4.getViewTreeObserver();
        if (r5 == null) goto L12;
        r5.removeOnPreDrawListener(this.d);
        return;
    L12:
        return;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition r3) {
        Intrinsics.checkNotNullParameter(r3, "transition");
        FLogger.a.i("TaskPanelController", "[TaskPanel-SM] expandWithAnimation: END");
        this.b.m = false;
        View r4 = this.c;
        if (r4 == null) goto L5;
        r4.setTranslationX(0.0f);
    L5:
        TaskPanelView r5 = this.b.f;
        if (r5 == null) goto L10;
        ViewTreeObserver r6 = r5.getViewTreeObserver();
        if (r6 == null) goto L10;
        r6.removeOnPreDrawListener(this.d);
    L10:
        TaskPanelView r7 = this.b.f;
        if (r7 == null) goto L13;
        RecyclerView r8 = (RecyclerView) r7.findViewById(2131384945);
    L14:
        if (r8 == null) goto L19;
        RecyclerView.Adapter r9 = r8.getAdapter();
        if (r9 == null) goto L20;
        r9.notifyDataSetChanged();
        return;
    L20:
        return;
    L19:
        return;
    L13:
        r8 = null;
        goto L14
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
        this.a.element = true;
    }

    public q(Ref.BooleanRef r1, n r2, View r3, r r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
