package com.obric.memorydata.memory.ui.address.edit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/edit/OuiSwipeDeleteAnimator;", "Lcom/obric/oui/orecyclerview/widget/DefaultItemAnimator;", "<init>", "()V", "pendingRemovals", "Ljava/util/ArrayList;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/collections/ArrayList;", "runningRemovals", "getRemoveDuration", "", "animateRemove", "", "holder", "runPendingAnimations", "", "animateRemoveImpl", "dispatchFinishedWhenDone", "isRunning", "endAnimation", "item", "endAnimations", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends h {
    private final ArrayList<RecyclerView.v> i;
    private final ArrayList<RecyclerView.v> j;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/memory/ui/address/edit/OuiSwipeDeleteAnimator$animateRemoveImpl$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f10587b;
        final /* synthetic */ ValueAnimator c;
        final /* synthetic */ View d;

        a(c r1, RecyclerView.v r2, ValueAnimator r3, View r4) {
            this.f10586a = r1;
            this.f10587b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            this.c.removeAllListeners();
            this.d.setClipBounds(null);
            View r4 = this.d;
            ViewGroup.LayoutParams r0 = r4.getLayoutParams();
            r0.height = -2;
            r4.setLayoutParams(r0);
            this.f10586a.i(this.f10587b);
            c.a(this.f10586a).remove(this.f10587b);
            c.b(this.f10586a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.f10586a.l(this.f10587b);
        }
    }

    public c() {
        this.i = new ArrayList();
        this.j = new ArrayList();
        a(300);
    }

    public static final /* synthetic */ ArrayList a(c r0) {
        return r0.j;
    }

    private static final void a(c r1, RecyclerView.v r2, View r3, ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "valueAnimator");
        if (r1.j.contains(r2) == true) goto L6;
        r4.cancel();
        return;
    L6:
        Object r5 = r4.getAnimatedValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin")).intValue();
        ViewGroup.LayoutParams r7 = r3.getLayoutParams();
        r7.height = r6;
        r3.setLayoutParams(r7);
        r3.setClipBounds(new Rect(0, 0, r3.getWidth(), r6));
    }

    public static final /* synthetic */ void b(c r0) {
        r0.l();
    }

    private final void l() {
        if (c() == true) goto L6;
        j();
        return;
    }

    public static /* synthetic */ void lambda$bgWISuX9aor3lyL9_eHpSbZ2dqE(c r0, RecyclerView.v r1, View r2, ValueAnimator r3) {
        a(r0, r1, r2, r3);
    }

    private final void u(final RecyclerView.v r6) {
        final View r0 = r6.c;
        Intrinsics.checkNotNullExpressionValue(r0, "itemView");
        this.j.add(r6);
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{r0.getHeight(), 0});
        r1.setDuration(g());
        r1.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new AccelerateDecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r1.addUpdateListener(new $$Lambda$c$bgWISuX9aor3lyL9_eHpSbZ2dqE(this, r6, r0));
        r1.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new a(this, r6, r1, r0), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        r1.start();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.e
    public long a() {
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.h, com.obric.oui.orecyclerview.widget.z
    public boolean a(RecyclerView.v r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        this.i.add(r2);
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.h, com.obric.oui.orecyclerview.widget.RecyclerView.e
    public void b() {
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.i, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L8;
        ArrayList r0 = new ArrayList((Collection) ZeusTransformUtils.preCheckCast(this.i, Collection.class, "com.obric.memorydata.plugin"));
        this.i.clear();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        u((RecyclerView.v) ZeusTransformUtils.preCheckCast(r1.next(), RecyclerView.v.class, "com.obric.memorydata.plugin"));
    L8:
        super.b();
    }

    @Override // com.obric.oui.orecyclerview.widget.h, com.obric.oui.orecyclerview.widget.RecyclerView.e
    public void b(RecyclerView.v r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        super.b(r2);
        if (this.i.remove(r2) == false) goto L6;
        i(r2);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.h, com.obric.oui.orecyclerview.widget.RecyclerView.e
    public boolean c() {
        if (super.c() == false) goto L5;
        return true;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.i, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L7;
        return true;
    L7:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.j, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.h, com.obric.oui.orecyclerview.widget.RecyclerView.e
    public void d() {
        super.d();
        this.i.clear();
        this.j.clear();
    }
}
