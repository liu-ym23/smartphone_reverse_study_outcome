package com.obric.oui.swipeaction;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.common.oea.foundation.animation.builder.c;
import com.obric.common.oea.foundation.animation.d.d;
import com.obric.common.oea.foundation.animation.spec.b;
import com.obric.common.oea.foundation.animation.token.Token;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0010H\u0002J\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0010H\u0002J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0010H\u0016J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010(\u001a\u00020\u0018H\u0016J:\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00180.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001800H\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeDeleteAnimator;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "()V", "pendingMoves", "Ljava/util/ArrayList;", "Lcom/obric/oui/swipeaction/OSwipeDeleteAnimator$MoveInfo;", "Lkotlin/collections/ArrayList;", "pendingRemovals", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "runningAnimators", "Ljava/util/HashMap;", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "Lkotlin/collections/HashMap;", "runningMoves", "runningRemovals", "animateMove", "", "holder", "fromX", "", "fromY", "toX", "toY", "animateMoveImpl", "", "moveInfo", "animateRemove", "animateRemoveImpl", "dispatchFinishedWhenDone", "endAnimation", "item", "endAnimations", "finishMove", "clearAnimator", "finishRemove", "getRemoveDuration", "", "isRunning", "resetMoveView", "resetRemoveView", "runPendingAnimations", "startOeaAnimation", "initialValue", "", "targetValue", "onUpdate", "Lkotlin/Function1;", "onEnd", "Lkotlin/Function0;", "MoveInfo", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSwipeDeleteAnimator extends DefaultItemAnimator {
    private final ArrayList<a> pendingMoves;
    private final ArrayList<RecyclerView.ViewHolder> pendingRemovals;
    private final HashMap<RecyclerView.ViewHolder, d> runningAnimators;
    private final ArrayList<a> runningMoves;
    private final ArrayList<RecyclerView.ViewHolder> runningRemovals;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeDeleteAnimator$MoveInfo;", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "deltaX", "", "deltaY", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;II)V", "getDeltaX", "()I", "getDeltaY", "getHolder", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RecyclerView.ViewHolder f14504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14505b;
        private final int c;

        public a(RecyclerView.ViewHolder r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "holder");
            this.f14504a = r2;
            this.f14505b = r3;
            this.c = r4;
        }

        public final RecyclerView.ViewHolder a() {
            return this.f14504a;
        }

        public final int b() {
            return this.f14505b;
        }

        public final int c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f14504a, r6.f14504a) == true) goto L12;
            return false;
        L12:
            if (this.f14505b == r6.f14505b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f14504a.hashCode() * 31) + Integer.hashCode(this.f14505b)) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "MoveInfo(holder=" + this.f14504a + ", deltaX=" + this.f14505b + ", deltaY=" + this.c + ')';
        }
    }

    public OSwipeDeleteAnimator() {
        this.pendingRemovals = new ArrayList();
        this.runningRemovals = new ArrayList();
        this.pendingMoves = new ArrayList();
        this.runningMoves = new ArrayList();
        this.runningAnimators = new HashMap();
        setMoveDuration(300);
    }

    public static final /* synthetic */ void access$finishMove(OSwipeDeleteAnimator r0, a r1, boolean r2) {
        r0.finishMove(r1, r2);
    }

    public static final /* synthetic */ void access$finishRemove(OSwipeDeleteAnimator r0, RecyclerView.ViewHolder r1, boolean r2) {
        r0.finishRemove(r1, r2);
    }

    public static final /* synthetic */ ArrayList access$getRunningMoves$p(OSwipeDeleteAnimator r0) {
        return r0.runningMoves;
    }

    public static final /* synthetic */ ArrayList access$getRunningRemovals$p(OSwipeDeleteAnimator r0) {
        return r0.runningRemovals;
    }

    private final void animateMoveImpl(final a r6) {
        RecyclerView.ViewHolder r0 = r6.a();
        final View r1 = r0.itemView;
        Intrinsics.checkNotNullExpressionValue(r1, "holder.itemView");
        this.runningMoves.add(r6);
        dispatchMoveStarting(r0);
        ((Map) ZeusTransformUtils.preCheckCast(this.runningAnimators, Map.class, "com.obric.memorydata.plugin")).put(r0, startOeaAnimation(1.0f, 0.0f, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r6, r1), Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r6), Function0.class, "com.obric.memorydata.plugin")));
    }

    private final void animateRemoveImpl(final RecyclerView.ViewHolder r7) {
        final View r0 = r7.itemView;
        Intrinsics.checkNotNullExpressionValue(r0, "holder.itemView");
        this.runningRemovals.add(r7);
        final int r1 = r0.getHeight();
        dispatchRemoveStarting(r7);
        ((Map) ZeusTransformUtils.preCheckCast(this.runningAnimators, Map.class, "com.obric.memorydata.plugin")).put(r7, startOeaAnimation(r1, 0.0f, (Function1) ZeusTransformUtils.preCheckCast(new C12341(this, r7, r1, r0), Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new C12352(this, r7), Function0.class, "com.obric.memorydata.plugin")));
    }

    private final void dispatchFinishedWhenDone() {
        if (isRunning() == true) goto L6;
        dispatchAnimationsFinished();
        return;
    }

    private final void finishMove(a r2, boolean r3) {
        if (this.runningMoves.remove(r2) == true) goto L5;
        return;
    L5:
        RecyclerView.ViewHolder r4 = r2.a();
        if (r3 == false) goto L8;
        this.runningAnimators.remove(r4);
    L8:
        resetMoveView(r4);
        dispatchMoveFinished(r4);
        dispatchFinishedWhenDone();
    }

    private final void finishRemove(RecyclerView.ViewHolder r2, boolean r3) {
        if (this.runningRemovals.remove(r2) == true) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        this.runningAnimators.remove(r2);
    L7:
        resetRemoveView(r2);
        dispatchRemoveFinished(r2);
        dispatchFinishedWhenDone();
    }

    private final void resetMoveView(RecyclerView.ViewHolder r2) {
        r2.itemView.setTranslationX(0.0f);
        r2.itemView.setTranslationY(0.0f);
    }

    private final void resetRemoveView(RecyclerView.ViewHolder r2) {
        View r1 = r2.itemView;
        Intrinsics.checkNotNullExpressionValue(r1, "holder.itemView");
        r1.setClipBounds(null);
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        r3.height = -2;
        r1.setLayoutParams(r3);
    }

    private final d startOeaAnimation(float r9, float r10, Function1<? super Float, Unit> r11, Function0<Unit> r12) {
        final Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        final Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        return c.a.a(new c.a(), r9, r10, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 8, null).a((Function3) ZeusTransformUtils.preCheckCast(new C12361(r8), Function3.class, "com.obric.memorydata.plugin")).a((Function2) ZeusTransformUtils.preCheckCast(new C12372(r13), Function2.class, "com.obric.memorydata.plugin")).a().a();
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView.ViewHolder r3, int r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        View r0 = r3.itemView;
        Intrinsics.checkNotNullExpressionValue(r0, "holder.itemView");
        int r8 = MathKt.roundToInt(r4 + r0.getTranslationX());
        int r9 = MathKt.roundToInt(r5 + r0.getTranslationY());
        endAnimation(r3);
        int r10 = r8 - r6;
        int r11 = r9 - r7;
        if (r10 != 0) goto L7;
        if (r11 != 0) goto L7;
        dispatchMoveFinished(r3);
        return false;
    L7:
        r0.setTranslationX(r10);
        r0.setTranslationY(r11);
        this.pendingMoves.add(new a(r3, r10, r11));
        return true;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        endAnimation(r2);
        this.pendingRemovals.add(r2);
        return true;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder r7) {
        Intrinsics.checkNotNullParameter(r7, "item");
        super.endAnimation(r7);
        if (this.pendingRemovals.remove(r7) == false) goto L5;
        dispatchRemoveFinished(r7);
    L5:
        Iterator<a> r0 = this.pendingMoves.iterator();
        Intrinsics.checkNotNullExpressionValue(r0, "pendingMoves.iterator()");
    L7:
        if (r0.hasNext() == false) goto L11;
        a r1 = r0.next();
        Intrinsics.checkNotNullExpressionValue(r1, "pendingMoveIterator.next()");
        if (Intrinsics.areEqual(((a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin")).a(), r7) == false) goto L7;
        resetMoveView(r7);
        r0.remove();
        dispatchMoveFinished(r7);
        goto L7
    L11:
        d r2 = (d) ZeusTransformUtils.preCheckCast(this.runningAnimators.remove(r7), d.class, "com.obric.memorydata.plugin");
        Object r3 = null;
        if (r2 == null) goto L16;
        d.a(r2, false, 1, null);
    L16:
        if (this.runningRemovals.contains(r7) == false) goto L18;
        finishRemove(r7, false);
    L18:
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.runningMoves, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r4.hasNext() == false) goto L24;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin")).a(), r7) == false) goto L20;
        r3 = r5;
    L24:
        a r8 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L27;
        finishMove(r8, false);
    L27:
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        super.endAnimations();
        LinkedHashSet r0 = new LinkedHashSet();
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(this.pendingRemovals, Collection.class, "com.obric.memorydata.plugin"));
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(this.runningRemovals, Collection.class, "com.obric.memorydata.plugin"));
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(this.pendingMoves, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(((a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.memorydata.plugin")).a());
        goto L4
    L6:
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.runningMoves, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r5.add(((a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.memorydata.plugin")).a());
        goto L8
    L10:
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        endAnimation((RecyclerView.ViewHolder) ZeusTransformUtils.preCheckCast(r7.next(), RecyclerView.ViewHolder.class, "com.obric.memorydata.plugin"));
        goto L12
    L14:
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public long getRemoveDuration() {
        return 0;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        if (super.isRunning() == false) goto L5;
        return true;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.pendingRemovals, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L7;
        return true;
    L7:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.runningRemovals, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        return true;
    L9:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.pendingMoves, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L11;
        return true;
    L11:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.runningMoves, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L19;
        return false;
    L19:
        return true;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        ArrayList r0 = new ArrayList((Collection) ZeusTransformUtils.preCheckCast(this.pendingRemovals, Collection.class, "com.obric.memorydata.plugin"));
        ArrayList r1 = new ArrayList((Collection) ZeusTransformUtils.preCheckCast(this.pendingMoves, Collection.class, "com.obric.memorydata.plugin"));
        this.pendingRemovals.clear();
        this.pendingMoves.clear();
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        RecyclerView.ViewHolder r3 = (RecyclerView.ViewHolder) ZeusTransformUtils.preCheckCast(r2.next(), RecyclerView.ViewHolder.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "holder");
        animateRemoveImpl(r3);
        goto L4
    L6:
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "moveInfo");
        animateMoveImpl(r5);
        goto L8
    L10:
        super.runPendingAnimations();
    }
}
