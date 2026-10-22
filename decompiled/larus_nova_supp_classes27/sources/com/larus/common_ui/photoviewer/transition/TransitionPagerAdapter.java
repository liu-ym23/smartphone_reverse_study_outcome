package com.larus.common_ui.photoviewer.transition;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common_ui.photoviewer.transition.TransitionViewHolder;
import j19.e;
import j19.g;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l19.b;
import l19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e*\u00012\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J!\u00104\u001a\u0002052\u0006\u0010*\u001a\u00020)2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100H\u0000¢\u0006\u0002\b6J\u001d\u00104\u001a\u0002052\u0006\u00107\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020)H\u0000¢\u0006\u0002\b6J\u0010\u00108\u001a\u0002052\u0006\u0010\"\u001a\u00020#H\u0016J\u0015\u00109\u001a\u0002052\u0006\u0010:\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010;J\u0015\u0010<\u001a\u0002052\u0006\u0010:\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010;J\u000e\u0010=\u001a\u0002052\u0006\u00101\u001a\u00020\u000eJ\u000e\u0010>\u001a\u0002052\u0006\u00101\u001a\u00020\u000eJ\b\u0010?\u001a\u000205H\u0016J\u0010\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020\u001dH\u0016J\u0010\u0010B\u001a\u0002052\u0006\u0010A\u001a\u00020\u001dH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0014j\b\u0012\u0004\u0012\u00020\u000e`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R&\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020)8B@BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006C"}, d2 = {"Lcom/larus/common_ui/photoviewer/transition/TransitionPagerAdapter;", "T", "Lcom/larus/common_ui/photoviewer/transition/TransitionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "<init>", "()V", "needEnterAnimation", "", "isEnterAnimationRunning", "()Z", "setEnterAnimationRunning", "(Z)V", "internalTransitionListener", "Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "getInternalTransitionListener", "()Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "setInternalTransitionListener", "(Lcom/larus/common_ui/photoviewer/transition/TransitionListener;)V", "transitionListeners", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "restoreTransitionProvider", "Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "getRestoreTransitionProvider$common_ui_mainlandRelease", "()Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "setRestoreTransitionProvider$common_ui_mainlandRelease", "(Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;)V", "dismissAnimationType", "", "getDismissAnimationType$common_ui_mainlandRelease", "()I", "setDismissAnimationType$common_ui_mainlandRelease", "(I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "value", "Landroid/graphics/Rect;", "startRect", "getStartRect", "()Landroid/graphics/Rect;", "setStartRect", "(Landroid/graphics/Rect;)V", "endViewInfo", "Lcom/larus/common_ui/photoviewer/transition/TransitionEndViewInfo;", "transitionListener", "com/larus/common_ui/photoviewer/transition/TransitionPagerAdapter$transitionListener$1", "Lcom/larus/common_ui/photoviewer/transition/TransitionPagerAdapter$transitionListener$1;", "setEnterAnimationParams", "", "setEnterAnimationParams$common_ui_mainlandRelease", "position", "onAttachedToRecyclerView", "onViewAttachedToWindow", "holder", "(Lcom/larus/common_ui/photoviewer/transition/TransitionViewHolder;)V", "onViewDetachedFromWindow", "addTransitionListener", "removeTransitionListener", "onDestroy", "onPageSelected", "pos", "onPageUnselected", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class TransitionPagerAdapter<T extends TransitionViewHolder> extends RecyclerView.Adapter<T> implements g {
    public boolean a;
    public f b;
    public final ArrayList<f> c;
    public e d;
    public int e;
    public RecyclerView f;
    public final Rect g;
    public b h;
    public final a i;

    public static final class a implements f {
        public final /* synthetic */ TransitionPagerAdapter<T> a;

        public a(TransitionPagerAdapter<T> r1) {
            this.a = r1;
        }

        @Override // l19.f
        public final void onTransitionBegin(int r2) {
            f r0 = this.a.b;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("internalTransitionListener");
            r0 = null;
        L6:
            r0.onTransitionBegin(r2);
        }

        @Override // l19.f
        public final void onTransitionEnd(int r2) {
            f r0 = this.a.b;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("internalTransitionListener");
            r0 = null;
        L6:
            r0.onTransitionEnd(r2);
            if (r2 != 0) goto L10;
            this.a.getClass();
            return;
        }

        @Override // l19.f
        public final void onTransitionChanged(int r2, float r3) {
            f r0 = this.a.b;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("internalTransitionListener");
            r0 = null;
        L6:
            r0.onTransitionChanged(r2, r3);
        }
    }

    @Override // j19.g
    public void S80(int r1) {
    }

    @Override // j19.g
    public void onPageSelected(int r1) {
    }

    @Override // j19.g
    public final void onPageSelected(int r1, boolean r2) {
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    public TransitionPagerAdapter() {
        this.c = new ArrayList();
        this.g = new Rect();
        this.i = new a(this);
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r1) {
        y2((TransitionViewHolder) r1);
    }

    public /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder r1) {
        z2((TransitionViewHolder) r1);
    }

    public void y2(T r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewAttachedToWindow(r4);
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        f r1 = (f) r0.next();
        r4.T3().c(r1);
        goto L4
    L6:
        int r2 = getRecyclerView().getChildAdapterPosition(((RecyclerView.ViewHolder) r4).itemView);
        r4.T3().setPos(r2);
        r4.T3().setRestoreTransitionProvider(this.d);
        r4.T3().setDismissAnimationType(this.e);
        r4.T3().c(this.i);
        if (this.a == false) goto L20;
        this.a = false;
        final TransitionLayout r5 = r4.T3();
        final Rect r3 = this.g;
        b r6 = this.h;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r3, "startRect");
        if (r5.h.isRunning() == true) goto L21;
        r5.v = r6;
        if (r6 == null) goto L14;
        r5.g();
    L14:
        final View r7 = r5.a();
        if (r7 == null) goto L22;
        r7.setAlpha(0.0f);
        r5.post(new l19.e(r5, r3, r7));
        return;
    L22:
        return;
    L21:
        return;
    }

    public void z2(T r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewDetachedFromWindow(r4);
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        f r1 = (f) r0.next();
        r4.T3().e(r1);
        goto L4
    L6:
        r4.T3().e(this.i);
    }
}
