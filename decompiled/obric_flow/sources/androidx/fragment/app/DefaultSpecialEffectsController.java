package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0003*+,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J(\u0010\t\u001a\u00020\u00062\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u001e\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\f0\u00162\u0006\u0010\u000e\u001a\u00020\fH\u0002J@\u0010\u0018\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\u0006\u0010\u001d\u001a\u00020\u00132\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u001fH\u0002JL\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010$\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010%\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0002J&\u0010&\u001a\u00020\u0006*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\f0'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170)H\u0002¨\u0006-"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController;", "Landroidx/fragment/app/SpecialEffectsController;", "container", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "applyContainerChanges", "", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "captureTransitioningViews", "transitioningViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "view", "executeOperations", "operations", "", "isPop", "", "findNamedViews", "namedViews", "", "", "startAnimations", "animationInfos", "Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "awaitingContainerChanges", "", "startedAnyTransition", "startedTransitions", "", "startTransitions", "transitionInfos", "Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "firstOut", "lastIn", "syncAnimations", "retainMatchingViews", "Landroidx/collection/ArrayMap;", "names", "", "AnimationInfo", "SpecialEffectsInfo", "TransitionInfo", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDefaultSpecialEffectsController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultSpecialEffectsController.kt\nandroidx/fragment/app/DefaultSpecialEffectsController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,877:1\n288#2,2:878\n533#2,6:880\n819#2:886\n847#2,2:887\n766#2:889\n857#2,2:890\n1789#2,3:892\n819#2:895\n847#2,2:896\n1855#2,2:898\n*S KotlinDebug\n*F\n+ 1 DefaultSpecialEffectsController.kt\nandroidx/fragment/app/DefaultSpecialEffectsController\n*L\n47#1:878,2\n53#1:880,6\n312#1:886\n312#1:887,2\n315#1:889\n315#1:890,2\n317#1:892,3\n629#1:895\n629#1:896,2\n632#1:898,2\n*E\n"})
public final class DefaultSpecialEffectsController extends SpecialEffectsController {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "signal", "Landroidx/core/os/CancellationSignal;", "isPop", "", "(Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/core/os/CancellationSignal;Z)V", "animation", "Landroidx/fragment/app/FragmentAnim$AnimationOrAnimator;", "isAnimLoaded", "getAnimation", "context", "Landroid/content/Context;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnimationInfo extends SpecialEffectsInfo {
        private FragmentAnim.AnimationOrAnimator animation;
        private boolean isAnimLoaded;
        private final boolean isPop;

        public AnimationInfo(SpecialEffectsController.Operation r5, CancellationSignal r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r5, "operation");
            Intrinsics.checkNotNullParameter(r10, "signal");
            super(r5, r10);
            this.isPop = r11;
        }

        public final FragmentAnim.AnimationOrAnimator getAnimation(Context r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            if (this.isAnimLoaded == true) goto L11;
            Fragment r10 = getOperation().getFragment();
            if (getOperation().getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L8;
            boolean r11 = true;
        L9:
            FragmentAnim.AnimationOrAnimator r12 = FragmentAnim.loadAnimation(r5, r10, r11, this.isPop);
            this.animation = r12;
            this.isAnimLoaded = true;
            return r12;
        L8:
            r11 = false;
            goto L9
        L11:
            return this.animation;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "signal", "Landroidx/core/os/CancellationSignal;", "(Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/core/os/CancellationSignal;)V", "isVisibilityUnchanged", "", "()Z", "getOperation", "()Landroidx/fragment/app/SpecialEffectsController$Operation;", "getSignal", "()Landroidx/core/os/CancellationSignal;", "completeSpecialEffect", "", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class SpecialEffectsInfo {
        private final SpecialEffectsController.Operation operation;
        private final CancellationSignal signal;

        public SpecialEffectsInfo(SpecialEffectsController.Operation r5, CancellationSignal r10) {
            Intrinsics.checkNotNullParameter(r5, "operation");
            Intrinsics.checkNotNullParameter(r10, "signal");
            this.operation = r5;
            this.signal = r10;
        }

        public final void completeSpecialEffect() {
            this.operation.completeSpecialEffect(this.signal);
        }

        public final SpecialEffectsController.Operation getOperation() {
            return this.operation;
        }

        public final CancellationSignal getSignal() {
            return this.signal;
        }

        public final boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State r5 = SpecialEffectsController.Operation.State.Companion.asOperationState(this.operation.getFragment().mView);
            SpecialEffectsController.Operation.State r10 = this.operation.getFinalState();
            if (r5 == r10) goto L9;
            SpecialEffectsController.Operation.State r11 = SpecialEffectsController.Operation.State.VISIBLE;
            if (r5 == r11) goto L8;
            if (r10 != r11) goto L9;
        L8:
            return false;
        L9:
            return true;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0002J\u0006\u0010\u0016\u001a\u00020\u0007R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0017"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "signal", "Landroidx/core/os/CancellationSignal;", "isPop", "", "providesSharedElementTransition", "(Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/core/os/CancellationSignal;ZZ)V", "handlingImpl", "Landroidx/fragment/app/FragmentTransitionImpl;", "getHandlingImpl", "()Landroidx/fragment/app/FragmentTransitionImpl;", "isOverlapAllowed", "()Z", "sharedElementTransition", "", "getSharedElementTransition", "()Ljava/lang/Object;", "transition", "getTransition", "hasSharedElementTransition", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TransitionInfo extends SpecialEffectsInfo {
        private final boolean isOverlapAllowed;
        private final Object sharedElementTransition;
        private final Object transition;

        public TransitionInfo(SpecialEffectsController.Operation r5, CancellationSignal r10, boolean r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r5, "operation");
            Intrinsics.checkNotNullParameter(r10, "signal");
            super(r5, r10);
            SpecialEffectsController.Operation.State r13 = r5.getFinalState();
            SpecialEffectsController.Operation.State r14 = SpecialEffectsController.Operation.State.VISIBLE;
            if (r13 != r14) goto L8;
            Fragment r15 = r5.getFragment();
            if (r11 == false) goto L7;
            Object r16 = r15.getReenterTransition();
        L12:
            this.transition = r16;
            if (r5.getFinalState() != r14) goto L17;
            if (r11 == false) goto L16;
            boolean r17 = r5.getFragment().getAllowReturnTransitionOverlap();
        L18:
            this.isOverlapAllowed = r17;
            if (r12 == false) goto L23;
            if (r11 == false) goto L22;
            Object r18 = r5.getFragment().getSharedElementReturnTransition();
        L24:
            this.sharedElementTransition = r18;
            return;
        L22:
            r18 = r5.getFragment().getSharedElementEnterTransition();
            goto L24
        L23:
            r18 = null;
            goto L24
        L16:
            r17 = r5.getFragment().getAllowEnterTransitionOverlap();
            goto L18
        L17:
            r17 = true;
            goto L18
        L7:
            r16 = r15.getEnterTransition();
            goto L12
        L8:
            Fragment r19 = r5.getFragment();
            if (r11 == false) goto L11;
            r16 = r19.getReturnTransition();
            goto L12
        L11:
            r16 = r19.getExitTransition();
            goto L12
        }

        public final FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl r5 = getHandlingImpl(this.transition);
            FragmentTransitionImpl r10 = getHandlingImpl(this.sharedElementTransition);
            if (r5 == null) goto L9;
            if (r10 == null) goto L9;
            if (r5 == r10) goto L9;
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.transition + " which uses a different Transition  type than its shared element transition " + this.sharedElementTransition).toString());
        L9:
            if (r5 == null) goto L11;
            return r5;
        L11:
            return r10;
        }

        public final Object getSharedElementTransition() {
            return this.sharedElementTransition;
        }

        public final Object getTransition() {
            return this.transition;
        }

        public final boolean hasSharedElementTransition() {
            if (this.sharedElementTransition == null) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isOverlapAllowed() {
            return this.isOverlapAllowed;
        }

        private final FragmentTransitionImpl getHandlingImpl(Object r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            FragmentTransitionImpl r10 = FragmentTransition.PLATFORM_IMPL;
            if (r10 != null) goto L8;
        L10:
            FragmentTransitionImpl r11 = FragmentTransition.SUPPORT_IMPL;
            if (r11 == null) goto L16;
            if (r11.canHandle(r5) == false) goto L16;
            return r11;
        L16:
            throw new IllegalArgumentException("Transition " + r5 + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        L8:
            if (r10.canHandle(r5) == false) goto L10;
            return r10;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$startAnimations$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"androidx/fragment/app/DefaultSpecialEffectsController$startAnimations$3", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass3 implements Animation.AnimationListener {
        final /* synthetic */ AnimationInfo $animationInfo;
        final /* synthetic */ SpecialEffectsController.Operation $operation;
        final /* synthetic */ View $viewToAnimate;
        final /* synthetic */ DefaultSpecialEffectsController this$0;

        public AnonymousClass3(SpecialEffectsController.Operation r5, DefaultSpecialEffectsController r10, View r11, AnimationInfo r12) {
            this.$operation = r5;
            this.this$0 = r10;
            this.$viewToAnimate = r11;
            this.$animationInfo = r12;
        }

        public static /* synthetic */ void a(DefaultSpecialEffectsController r5, View r10, AnimationInfo r11) {
            onAnimationEnd$lambda$0(r5, r10, r11);
        }

        private static final void onAnimationEnd$lambda$0(DefaultSpecialEffectsController r5, View r10, AnimationInfo r11) {
            Intrinsics.checkNotNullParameter(r5, "this$0");
            Intrinsics.checkNotNullParameter(r11, "$animationInfo");
            r5.getContainer().endViewTransition(r10);
            r11.completeSpecialEffect();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            this.this$0.getContainer().post(new e(this.this$0, this.$viewToAnimate, this.$animationInfo, 0));
            if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
            Log.v(FragmentManager.TAG, "Animation from operation " + this.$operation + " has ended.");
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
            Log.v(FragmentManager.TAG, "Animation from operation " + this.$operation + " has reached onAnimationStart.");
            return;
        }
    }

    public DefaultSpecialEffectsController(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "container");
        super(r5);
    }

    private final void applyContainerChanges(SpecialEffectsController.Operation r5) {
        View r10 = r5.getFragment().mView;
        r5.getFinalState().applyState(r10);
    }

    public static /* synthetic */ void c(List r5, SpecialEffectsController.Operation r10, DefaultSpecialEffectsController r11) {
        executeOperations$lambda$2(r5, r10, r11);
    }

    private final void captureTransitioningViews(ArrayList<View> r5, View r10) {
        if ((r10 instanceof ViewGroup) == false) goto L16;
        ViewGroup r11 = (ViewGroup) r10;
        if (ViewGroupCompat.isTransitionGroup(r11) == true) goto L7;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L25;
        View r14 = r11.getChildAt(r13);
        if (r14.getVisibility() != 0) goto L14;
        captureTransitioningViews(r5, r14);
    L14:
        r13 = r13 + 1;
        goto L10
    L25:
        return;
    L7:
        if (r5.contains(r10) == true) goto L22;
        r5.add(r10);
        return;
    L22:
        return;
    L16:
        if (r5.contains(r10) == true) goto L24;
        r5.add(r10);
        return;
    }

    public static /* synthetic */ void d(SpecialEffectsController.Operation r5, SpecialEffectsController.Operation r10, boolean r11, ArrayMap r12) {
        startTransitions$lambda$9(r5, r10, r11, r12);
    }

    public static /* synthetic */ void e(Animator r5, SpecialEffectsController.Operation r10) {
        startAnimations$lambda$3(r5, r10);
    }

    private static final void executeOperations$lambda$2(List r5, SpecialEffectsController.Operation r10, DefaultSpecialEffectsController r11) {
        Intrinsics.checkNotNullParameter(r5, "$awaitingContainerChanges");
        Intrinsics.checkNotNullParameter(r10, "$operation");
        Intrinsics.checkNotNullParameter(r11, "this$0");
        if (r5.contains(r10) == false) goto L6;
        r5.remove(r10);
        r11.applyContainerChanges(r10);
        return;
    }

    public static /* synthetic */ void f(View r5, DefaultSpecialEffectsController r10, AnimationInfo r11, SpecialEffectsController.Operation r12) {
        startAnimations$lambda$4(r5, r10, r11, r12);
    }

    private final void findNamedViews(Map<String, View> r5, View r10) {
        String r11 = ViewCompat.getTransitionName(r10);
        if (r11 == null) goto L6;
        r5.put(r11, r10);
    L6:
        if ((r10 instanceof ViewGroup) == false) goto L13;
        ViewGroup r12 = (ViewGroup) r10;
        int r13 = r12.getChildCount();
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L17;
        View r15 = r12.getChildAt(r14);
        if (r15.getVisibility() != 0) goto L12;
        findNamedViews(r5, r15);
    L12:
        r14 = r14 + 1;
        goto L8
    L17:
        return;
    }

    public static /* synthetic */ void g(ArrayList r5) {
        startTransitions$lambda$11(r5);
    }

    public static /* synthetic */ void h(TransitionInfo r5, SpecialEffectsController.Operation r10) {
        startTransitions$lambda$14$lambda$13(r5, r10);
    }

    public static /* synthetic */ void i(FragmentTransitionImpl r5, View r10, Rect r11) {
        startTransitions$lambda$10(r5, r10, r11);
    }

    private final void retainMatchingViews(ArrayMap<String, View> r5, final Collection<String> r10) {
        CollectionsKt.C(r5.entrySet(), new AnonymousClass1(r10));
    }

    private final void startAnimations(List<AnimationInfo> r19, List<SpecialEffectsController.Operation> r20, boolean r21, Map<SpecialEffectsController.Operation, Boolean> r22) {
        Context r10 = getContainer().getContext();
        ArrayList r11 = new ArrayList();
        Iterator<AnimationInfo> r12 = r19.iterator();
        boolean r5 = false;
    L4:
        if (r12.hasNext() == false) goto L32;
        final AnimationInfo r14 = r12.next();
        if (r14.isVisibilityUnchanged() == true) goto L7;
        FragmentAnim.AnimationOrAnimator r13 = r14.getAnimation(r10);
        if (r13 == null) goto L11;
        final Animator r15 = r13.animator;
        if (r15 == null) goto L14;
        final SpecialEffectsController.Operation r16 = r14.getOperation();
        Fragment r17 = r16.getFragment();
        if (Intrinsics.areEqual(r22.get(r16), Boolean.TRUE) == true) goto L18;
        if (r16.getFinalState() != SpecialEffectsController.Operation.State.GONE) goto L24;
        final boolean r18 = true;
    L26:
        if (r18 == false) goto L28;
        r20.remove(r16);
    L28:
        final View r23 = r17.mView;
        getContainer().startViewTransition(r23);
        r15.addListener(new C00821(this, r23, r18, r16, r14));
        r15.setTarget(r23);
        r15.start();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L31;
        Log.v(FragmentManager.TAG, "Animator from operation " + r16 + " has started.");
    L31:
        r14.getSignal().setOnCancelListener(new a(r15, r16));
        r5 = true;
        goto L4
    L24:
        r18 = false;
        goto L26
    L18:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L20;
        Log.v(FragmentManager.TAG, "Ignoring Animator set on " + r17 + " as this Fragment was involved in a Transition.");
    L20:
        r14.completeSpecialEffect();
        goto L4
    L14:
        r11.add(r14);
        goto L4
    L11:
        r14.completeSpecialEffect();
        goto L4
    L7:
        r14.completeSpecialEffect();
        goto L4
    L32:
        Iterator r24 = r11.iterator();
    L34:
        if (r24.hasNext() == false) goto L61;
        final AnimationInfo r25 = (AnimationInfo) r24.next();
        final SpecialEffectsController.Operation r26 = r25.getOperation();
        Fragment r27 = r26.getFragment();
        if (r21 == true) goto L38;
        if (r5 == true) goto L43;
        final View r28 = r27.mView;
        FragmentAnim.AnimationOrAnimator r29 = r25.getAnimation(r10);
        if (r29 == null) goto L60;
        Animation r30 = r29.animation;
        if (r30 == null) goto L58;
        if (r26.getFinalState() == SpecialEffectsController.Operation.State.REMOVED) goto L53;
        r28.startAnimation(r30);
        r25.completeSpecialEffect();
    L56:
        r25.getSignal().setOnCancelListener(new b(r28, this, r25, r26));
        goto L34
    L53:
        getContainer().startViewTransition(r28);
        FragmentAnim.EndViewTransitionAnimation r31 = new FragmentAnim.EndViewTransitionAnimation(r30, getContainer(), r28);
        r31.setAnimationListener(new AnonymousClass3(r26, this, r28, r25));
        r28.startAnimation(r31);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L56;
        Log.v(FragmentManager.TAG, "Animation from operation " + r26 + " has started.");
        goto L56
    L58:
        throw new IllegalStateException("Required value was null.");
    L60:
        throw new IllegalStateException("Required value was null.");
    L43:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L45;
        Log.v(FragmentManager.TAG, "Ignoring Animation set on " + r27 + " as Animations cannot run alongside Animators.");
    L45:
        r25.completeSpecialEffect();
        goto L34
    L38:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L40;
        Log.v(FragmentManager.TAG, "Ignoring Animation set on " + r27 + " as Animations cannot run alongside Transitions.");
    L40:
        r25.completeSpecialEffect();
        goto L34
    }

    private static final void startAnimations$lambda$3(Animator r5, SpecialEffectsController.Operation r10) {
        Intrinsics.checkNotNullParameter(r10, "$operation");
        r5.end();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
        Log.v(FragmentManager.TAG, "Animator from operation " + r10 + " has been canceled.");
        return;
    }

    private static final void startAnimations$lambda$4(View r5, DefaultSpecialEffectsController r10, AnimationInfo r11, SpecialEffectsController.Operation r12) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "$animationInfo");
        Intrinsics.checkNotNullParameter(r12, "$operation");
        r5.clearAnimation();
        r10.getContainer().endViewTransition(r5);
        r11.completeSpecialEffect();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
        Log.v(FragmentManager.TAG, "Animation from operation " + r12 + " has been cancelled.");
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<SpecialEffectsController.Operation, Boolean> startTransitions(List<TransitionInfo> r35, List<SpecialEffectsController.Operation> r36, final boolean r37, final SpecialEffectsController.Operation r38, final SpecialEffectsController.Operation r39) {
        DefaultSpecialEffectsController r5 = this;
        LinkedHashMap r10 = new LinkedHashMap();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r35.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (((TransitionInfo) r13).isVisibilityUnchanged() == true) goto L4;
        r11.add(r13);
        goto L4
    L8:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r11.iterator();
    L10:
        if (r15.hasNext() == false) goto L14;
        Object r16 = r15.next();
        if (((TransitionInfo) r16).getHandlingImpl() == null) goto L10;
        r14.add(r16);
        goto L10
    L14:
        Iterator r17 = r14.iterator();
        FragmentTransitionImpl r18 = null;
    L16:
        if (r17.hasNext() == false) goto L24;
        TransitionInfo r19 = (TransitionInfo) r17.next();
        FragmentTransitionImpl r20 = r19.getHandlingImpl();
        if (r18 == null) goto L23;
        if (r20 == r18) goto L23;
        throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + r19.getOperation().getFragment() + " returned Transition " + r19.getTransition() + " which uses a different Transition type than other Fragments.").toString());
    L23:
        r18 = r20;
        goto L16
    L24:
        if (r18 != null) goto L30;
        Iterator<TransitionInfo> r21 = r35.iterator();
    L27:
        if (r21.hasNext() == false) goto L29;
        TransitionInfo r22 = r21.next();
        r10.put(r22.getOperation(), Boolean.FALSE);
        r22.completeSpecialEffect();
        goto L27
    L29:
        return r10;
    L30:
        View r23 = new View(getContainer().getContext());
        Rect r110 = new Rect();
        ArrayList<View> r111 = new ArrayList();
        ArrayList<View> r112 = new ArrayList();
        ArrayMap r113 = new ArrayMap();
        Iterator<TransitionInfo> r114 = r35.iterator();
        View r24 = null;
        Object r25 = null;
        boolean r115 = false;
    L31:
        boolean r26 = r114.hasNext();
        String r116 = FragmentManager.TAG;
        if (r26 == false) goto L118;
        TransitionInfo r27 = r114.next();
        if (r27.hasSharedElementTransition() == false) goto L117;
        if (r38 == null) goto L117;
        if (r39 == null) goto L117;
        Object r28 = r18.wrapTransitionInSet(r18.cloneTransition(r27.getSharedElementTransition()));
        ArrayList<String> r29 = r39.getFragment().getSharedElementSourceNames();
        ArrayList<String> r30 = r38.getFragment().getSharedElementSourceNames();
        View r210 = r24;
        ArrayList<String> r31 = r38.getFragment().getSharedElementTargetNames();
        LinkedHashMap r211 = r10;
        int r32 = r31.size();
        View r212 = r23;
        Rect r213 = r110;
        int r33 = 0;
    L39:
        if (r33 >= r32) goto L44;
        int r214 = r32;
        int r34 = r29.indexOf(r31.get(r33));
        if (r34 == (-1)) goto L43;
        r29.set(r34, r30.get(r33));
    L43:
        r33 = r33 + 1;
        r32 = r214;
        goto L39
    L44:
        ArrayList<String> r40 = r39.getFragment().getSharedElementTargetNames();
        if (r37 == true) goto L47;
        Pair r41 = TuplesKt.to(r38.getFragment().getExitTransitionCallback(), r39.getFragment().getEnterTransitionCallback());
    L48:
        SharedElementCallback r42 = (SharedElementCallback) r41.component1();
        SharedElementCallback r43 = (SharedElementCallback) r41.component2();
        int r44 = r29.size();
        int r117 = 0;
    L49:
        if (r117 >= r44) goto L51;
        r113.put(r29.get(r117), r40.get(r117));
        r117 = r117 + 1;
        r44 = r44;
        r28 = r28;
        goto L49
    L51:
        Object r215 = r28;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L61;
        Log.v(FragmentManager.TAG, ">>> entering view names <<<");
        Iterator<String> r45 = r40.iterator();
    L55:
        if (r45.hasNext() == false) goto L57;
        Log.v(FragmentManager.TAG, "Name: " + r45.next());
        r45 = r45;
        goto L55
    L57:
        Log.v(FragmentManager.TAG, ">>> exiting view names <<<");
        Iterator<String> r46 = r29.iterator();
    L59:
        if (r46.hasNext() == false) goto L61;
        Log.v(FragmentManager.TAG, "Name: " + r46.next());
        r46 = r46;
    L61:
        ArrayMap<String, View> r47 = new ArrayMap();
        r5.findNamedViews(r47, r38.getFragment().mView);
        r47.retainAll(r29);
        if (r42 != null) goto L64;
        FragmentTransitionImpl r216 = r18;
        r113.retainAll(r47.keySet());
    L79:
        final ArrayMap<String, View> r48 = new ArrayMap();
        r5.findNamedViews(r48, r39.getFragment().mView);
        r48.retainAll(r40);
        r48.retainAll(r113.values());
        if (r43 != null) goto L82;
        FragmentTransition.retainValues(r113, r48);
    L100:
        r5.retainMatchingViews(r47, r113.keySet());
        r5.retainMatchingViews(r48, r113.values());
        if (r113.isEmpty() == true) goto L102;
        FragmentTransition.callSharedElementStartEnd(r39.getFragment(), r38.getFragment(), r37, r47, true);
        OneShotPreDrawListener.add(getContainer(), new c(r39, r38, r37, r48));
        r111.addAll(r47.values());
        if (r29.isEmpty() == true) goto L106;
        View r49 = (View) r47.get(r29.get(0));
        FragmentTransitionImpl r118 = r216;
        Object r50 = r215;
        r118.setEpicenter(r50, r49);
    L107:
        r112.addAll(r48.values());
        if (r40.isEmpty() == true) goto L113;
        boolean r119 = false;
        View r51 = r48.get(r40.get(0));
        if (r51 == null) goto L115;
        r213 = r213;
        OneShotPreDrawListener.add(getContainer(), new e(r118, r51, r213, 2));
        r115 = true;
    L115:
        r118.setSharedElementTargets(r50, r212, r111);
        Object r217 = r50;
        ArrayList<View> r120 = r112;
        Rect r52 = r213;
        r18 = r118;
        r118.scheduleRemoveTargets(r50, null, null, null, null, r217, r120);
        Boolean r53 = Boolean.TRUE;
        r211.put(r38, r53);
        r211.put(r39, r53);
        r24 = r49;
        r112 = r120;
        r25 = r217;
        r113 = r113;
        r111 = r111;
        r23 = r212;
        r10 = r211;
    L116:
        r110 = r52;
        goto L31
    L113:
        r119 = false;
        goto L115
    L106:
        r118 = r216;
        r50 = r215;
        r49 = r210;
        goto L107
    L102:
        r111.clear();
        r112.clear();
        r10 = r211;
        r24 = r210;
        r23 = r212;
        r110 = r213;
        r18 = r216;
        r25 = null;
        goto L31
    L82:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L84;
        Log.v(FragmentManager.TAG, "Executing enter callback for operation " + r39);
    L84:
        r43.onMapSharedElements(r40, r48);
        int r54 = r40.size() - 1;
        if (r54 < 0) goto L100;
    L86:
        int r55 = r54 - 1;
        String r56 = r40.get(r54);
        View r121 = r48.get(r56);
        if (r121 != null) goto L92;
        String r57 = FragmentTransition.findKeyForValue(r113, r56);
        if (r57 == null) goto L96;
        r113.remove(r57);
    L96:
        if (r55 < 0) goto L100;
        r54 = r55;
        goto L86
    L92:
        if (Intrinsics.areEqual(r56, ViewCompat.getTransitionName(r121)) == true) goto L96;
        String r58 = FragmentTransition.findKeyForValue(r113, r56);
        if (r58 == null) goto L96;
        r113.put(r58, ViewCompat.getTransitionName(r121));
        goto L96
    L64:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L66;
        Log.v(FragmentManager.TAG, "Executing exit callback for operation " + r38);
    L66:
        r42.onMapSharedElements(r29, r47);
        int r59 = r29.size() - 1;
        if (r59 < 0) goto L77;
    L68:
        int r60 = r59 - 1;
        String r61 = r29.get(r59);
        View r122 = (View) r47.get(r61);
        if (r122 != null) goto L71;
        r113.remove(r61);
        r216 = r18;
    L74:
        if (r60 < 0) goto L79;
        r59 = r60;
        r18 = r216;
        goto L68
    L71:
        r216 = r18;
        if (Intrinsics.areEqual(r61, ViewCompat.getTransitionName(r122)) == true) goto L74;
        r113.put(ViewCompat.getTransitionName(r122), (String) r113.remove(r61));
        goto L74
    L77:
        r216 = r18;
        goto L79
    L47:
        r41 = TuplesKt.to(r38.getFragment().getEnterTransitionCallback(), r39.getFragment().getExitTransitionCallback());
    L117:
        r52 = r110;
        r23 = r23;
        r10 = r10;
        r112 = r112;
        r24 = r24;
        r113 = r113;
        r111 = r111;
        goto L116
    L118:
        View r218 = r24;
        ArrayMap r219 = r113;
        ArrayList<View> r123 = r112;
        ArrayList<View> r220 = r111;
        Rect r62 = r110;
        LinkedHashMap r124 = r10;
        View r63 = r23;
        ArrayList r64 = new ArrayList();
        Iterator<TransitionInfo> r65 = r35.iterator();
        Object r125 = null;
        Object r126 = null;
    L120:
        if (r65.hasNext() == false) goto L156;
        TransitionInfo r127 = r65.next();
        if (r127.isVisibilityUnchanged() == true) goto L123;
        Object r128 = r18.cloneTransition(r127.getTransition());
        SpecialEffectsController.Operation r66 = r127.getOperation();
        if (r25 == null) goto L129;
        if (r66 == r38) goto L128;
        if (r66 != r39) goto L129;
    L128:
        boolean r67 = true;
    L130:
        if (r128 == null) goto L131;
        LinkedHashMap r221 = r124;
        ArrayList<View> r129 = new ArrayList();
        Iterator<TransitionInfo> r310 = r65;
        r5.captureTransitioningViews(r129, r66.getFragment().mView);
        if (r67 == false) goto L139;
        if (r66 != r38) goto L137;
        r129.removeAll(CollectionsKt.toSet(r220));
        goto L139
    L137:
        r129.removeAll(CollectionsKt.toSet(r123));
    L139:
        if (r129.isEmpty() == false) goto L141;
        r18.addTarget(r128, r63);
        Object r311 = r25;
        String r312 = r116;
        Object r68 = r125;
        Object r313 = r126;
        LinkedHashMap r69 = r221;
        View r222 = r218;
        View r223 = r63;
        ArrayList<View> r70 = r129;
    L146:
        if (r66.getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L151;
        r64.addAll(r70);
        if (r115 == false) goto L150;
        r18.setEpicenter(r128, r62);
    L150:
        View r71 = r222;
    L152:
        r69.put(r66, Boolean.TRUE);
        if (r127.isOverlapAllowed() == true) goto L154;
        r126 = r313;
        r125 = r18.mergeTransitionsTogether(r68, r128, null);
        r65 = r310;
        r124 = r69;
        r218 = r71;
        r63 = r223;
        r25 = r311;
        r116 = r312;
        r5 = this;
        goto L120
    L154:
        r126 = r18.mergeTransitionsTogether(r313, r128, null);
        r124 = r69;
        r218 = r71;
        r125 = r68;
        r63 = r223;
        r25 = r311;
        r116 = r312;
        r5 = this;
        r65 = r310;
        goto L120
    L151:
        r71 = r222;
        r18.setEpicenter(r128, r71);
        goto L152
    L141:
        r18.addTargets(r128, r129);
        r222 = r218;
        r311 = r25;
        r312 = r116;
        r68 = r125;
        r313 = r126;
        r69 = r221;
        r223 = r63;
        r70 = r129;
        r18.scheduleRemoveTargets(r128, r128, r129, null, null, null, null);
        if (r66.getFinalState() != SpecialEffectsController.Operation.State.GONE) goto L144;
        r66 = r66;
        r36.remove(r66);
        ArrayList<View> r72 = new ArrayList(r70);
        r72.remove(r66.getFragment().mView);
        r128 = r128;
        r18.scheduleHideFragmentView(r128, r66.getFragment().mView, r72);
        OneShotPreDrawListener.add(getContainer(), new d(r70, 0));
        goto L146
    L144:
        r66 = r66;
        r128 = r128;
        goto L146
    L131:
        if (r67 == true) goto L120;
        r124.put(r66, Boolean.FALSE);
        r127.completeSpecialEffect();
    L129:
        r67 = false;
        goto L130
    L123:
        r124.put(r127.getOperation(), Boolean.FALSE);
        r127.completeSpecialEffect();
        goto L120
    L156:
        String r314 = r116;
        LinkedHashMap r73 = r124;
        Object r74 = r18.mergeTransitionsInSequence(r126, r125, r25);
        if (r74 != null) goto L159;
        return r73;
    L159:
        ArrayList r75 = new ArrayList();
        Iterator<T> r76 = r35.iterator();
    L161:
        if (r76.hasNext() == false) goto L165;
        Object r77 = r76.next();
        if (((TransitionInfo) r77).isVisibilityUnchanged() == true) goto L161;
        r75.add(r77);
        goto L161
    L165:
        Iterator r78 = r75.iterator();
    L167:
        if (r78.hasNext() == false) goto L187;
        TransitionInfo r79 = (TransitionInfo) r78.next();
        Object r80 = r79.getTransition();
        SpecialEffectsController.Operation r81 = r79.getOperation();
        if (r25 == null) goto L173;
        if (r81 == r38) goto L172;
        if (r81 != r39) goto L173;
    L172:
        boolean r130 = true;
    L174:
        if (r80 != null) goto L179;
        if (r130 == true) goto L179;
        String r131 = r314;
    L186:
        r314 = r131;
    L179:
        if (ViewCompat.isLaidOut(getContainer()) == false) goto L181;
        r131 = r314;
        r18.setListenerForTransitionEnd(r79.getOperation().getFragment(), r74, r79.getSignal(), new j(r79, r81, 2));
        goto L186
    L181:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L183;
        r131 = r314;
        Log.v(r131, "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + r81);
    L184:
        r79.completeSpecialEffect();
        goto L186
    L183:
        r131 = r314;
    L173:
        r130 = false;
        goto L174
    L187:
        String r132 = r314;
        if (ViewCompat.isLaidOut(getContainer()) == true) goto L190;
        return r73;
    L190:
        FragmentTransition.setViewVisibility(r64, 4);
        ArrayList<String> r82 = r18.prepareSetNameOverridesReordered(r123);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L200;
        Log.v(r132, ">>>>> Beginning transition <<<<<");
        Log.v(r132, ">>>>> SharedElementFirstOutViews <<<<<");
        Iterator<View> r83 = r220.iterator();
    L194:
        if (r83.hasNext() == false) goto L196;
        View r84 = r83.next();
        Log.v(r132, "View: " + r84 + " Name: " + ViewCompat.getTransitionName(r84));
        goto L194
    L196:
        Log.v(r132, ">>>>> SharedElementLastInViews <<<<<");
        Iterator<View> r85 = r123.iterator();
    L198:
        if (r85.hasNext() == false) goto L200;
        View r86 = r85.next();
        Log.v(r132, "View: " + r86 + " Name: " + ViewCompat.getTransitionName(r86));
    L200:
        r18.beginDelayedTransition(getContainer(), r74);
        r18.setNameOverridesReordered(getContainer(), r220, r123, r82, r219);
        FragmentTransition.setViewVisibility(r64, 0);
        r18.swapSharedElementTargets(r25, r220, r123);
        return r73;
    }

    private static final void startTransitions$lambda$10(FragmentTransitionImpl r5, View r10, Rect r11) {
        Intrinsics.checkNotNullParameter(r5, "$impl");
        Intrinsics.checkNotNullParameter(r11, "$lastInEpicenterRect");
        r5.getBoundsOnScreen(r10, r11);
    }

    private static final void startTransitions$lambda$11(ArrayList r5) {
        Intrinsics.checkNotNullParameter(r5, "$transitioningViews");
        FragmentTransition.setViewVisibility(r5, 4);
    }

    private static final void startTransitions$lambda$14$lambda$13(TransitionInfo r5, SpecialEffectsController.Operation r10) {
        Intrinsics.checkNotNullParameter(r5, "$transitionInfo");
        Intrinsics.checkNotNullParameter(r10, "$operation");
        r5.completeSpecialEffect();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
        Log.v(FragmentManager.TAG, "Transition for operation " + r10 + " has completed");
        return;
    }

    private static final void startTransitions$lambda$9(SpecialEffectsController.Operation r5, SpecialEffectsController.Operation r10, boolean r11, ArrayMap r12) {
        Intrinsics.checkNotNullParameter(r12, "$lastInViews");
        FragmentTransition.callSharedElementStartEnd(r5.getFragment(), r10.getFragment(), r11, r12, false);
    }

    private final void syncAnimations(List<? extends SpecialEffectsController.Operation> r5) {
        Fragment r10 = ((SpecialEffectsController.Operation) CollectionsKt.last(r5)).getFragment();
        Iterator<? extends SpecialEffectsController.Operation> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        SpecialEffectsController.Operation r12 = r11.next();
        Fragment.AnimationInfo r13 = r12.getFragment().mAnimationInfo;
        r13.mEnterAnim = r10.mAnimationInfo.mEnterAnim;
        Fragment.AnimationInfo r14 = r12.getFragment().mAnimationInfo;
        r14.mExitAnim = r10.mAnimationInfo.mExitAnim;
        Fragment.AnimationInfo r15 = r12.getFragment().mAnimationInfo;
        r15.mPopEnterAnim = r10.mAnimationInfo.mPopEnterAnim;
        Fragment.AnimationInfo r16 = r12.getFragment().mAnimationInfo;
        r16.mPopExitAnim = r10.mAnimationInfo.mPopExitAnim;
        goto L4
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    public void executeOperations(List<? extends SpecialEffectsController.Operation> r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "operations");
        Iterator<T> r5 = r14.iterator();
    L3:
        SpecialEffectsController.Operation r10 = null;
        if (r5.hasNext() == false) goto L10;
        Object r11 = r5.next();
        SpecialEffectsController.Operation r12 = (SpecialEffectsController.Operation) r11;
        SpecialEffectsController.Operation.State r13 = SpecialEffectsController.Operation.State.Companion.asOperationState(r12.getFragment().mView);
        SpecialEffectsController.Operation.State r16 = SpecialEffectsController.Operation.State.VISIBLE;
        if (r13 != r16) goto L3;
        if (r12.getFinalState() == r16) goto L3;
    L11:
        SpecialEffectsController.Operation r17 = (SpecialEffectsController.Operation) r11;
        ListIterator<? extends SpecialEffectsController.Operation> r18 = r14.listIterator(r14.size());
    L13:
        if (r18.hasPrevious() == false) goto L19;
        SpecialEffectsController.Operation r19 = r18.previous();
        SpecialEffectsController.Operation r20 = r19;
        SpecialEffectsController.Operation.State r21 = SpecialEffectsController.Operation.State.Companion.asOperationState(r20.getFragment().mView);
        SpecialEffectsController.Operation.State r22 = SpecialEffectsController.Operation.State.VISIBLE;
        if (r21 == r22) goto L13;
        if (r20.getFinalState() != r22) goto L13;
        r10 = r19;
    L19:
        SpecialEffectsController.Operation r23 = r10;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L22;
        Log.v(FragmentManager.TAG, "Executing operations from " + r17 + " to " + r23);
    L22:
        ArrayList r110 = new ArrayList();
        ArrayList r24 = new ArrayList();
        List<SpecialEffectsController.Operation> r111 = CollectionsKt.toMutableList(r14);
        syncAnimations(r14);
        Iterator<? extends SpecialEffectsController.Operation> r112 = r14.iterator();
    L24:
        if (r112.hasNext() == false) goto L32;
        SpecialEffectsController.Operation r25 = r112.next();
        CancellationSignal r26 = new CancellationSignal();
        r25.markStartedSpecialEffect(r26);
        r110.add(new AnimationInfo(r25, r26, r15));
        CancellationSignal r27 = new CancellationSignal();
        r25.markStartedSpecialEffect(r27);
        boolean r28 = false;
        if (r15 == false) goto L29;
        if (r25 != r17) goto L31;
    L28:
        r28 = true;
    L31:
        r24.add(new TransitionInfo(r25, r27, r15, r28));
        r25.addCompletionListener(new e(r111, r25, this));
        goto L24
    L29:
        if (r25 != r23) goto L31;
    L32:
        Map<SpecialEffectsController.Operation, Boolean> r113 = startTransitions(r24, r111, r15, r17, r23);
        startAnimations(r110, r111, r113.containsValue(Boolean.TRUE), r113);
        Iterator<SpecialEffectsController.Operation> r114 = r111.iterator();
    L34:
        if (r114.hasNext() == false) goto L36;
        applyContainerChanges(r114.next());
        goto L34
    L36:
        r111.clear();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L57;
        Log.v(FragmentManager.TAG, "Completed executing operations from " + r17 + " to " + r23);
        return;
    L57:
        return;
    L10:
        r11 = null;
        goto L11
    }
}
