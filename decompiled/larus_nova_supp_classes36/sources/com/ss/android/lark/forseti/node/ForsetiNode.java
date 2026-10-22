package com.ss.android.lark.forseti.node;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.ForsetiStackChainBottomSheetBehavior;
import com.google.android.material.bottomsheet.ForsetiStackChainBottomSheetBehaviorV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.api.bean.ForsetiChainType;
import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.chain.ForsetiChainFragment;
import com.ss.android.lark.forseti.chain.ForsetiStackChainAdapter;
import com.ss.android.lark.forseti.chain.ForsetiStackChainStatus;
import com.ss.android.lark.forseti.chain.s;
import com.ss.android.lark.forseti.node.piece.ForsetiNodePiece;
import com.ss.android.lark.forseti.util.animation.ForsetiAnimatorLauncher;
import com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingHelper;
import com.ss.android.lark.forseti.widget.ForsetiNodeViewGroup;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroup;
import com.ss.android.lark.forseti.widget.ForsetiStackChainViewGroup;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForsetiNode {
    public final com.ss.android.lark.forseti.global.e a;
    public final ForsetiChainType b;
    public ForsetiNodeFragment c;
    public ForsetiNode d;
    public ForsetiNode e;
    public Function2<? super Fragment, ? super Integer, Unit> f;
    public Function2<? super Fragment, ? super Integer, Unit> g;
    public final ForsetiNodeViewGroup h;
    public final List<Fragment> i;
    public boolean j;
    public FragmentActivity k;
    public ForsetiNodePiece l;
    public final Map<String, ForsetiNodePiece> m;
    public final CopyOnWriteArrayList<Function0<Unit>> n;
    public boolean o;
    public com.ss.android.lark.forseti.node.a p;
    public final Lazy q;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Log.i("FST_Node", "intercept ForsetiNode click event");
        }
    }

    static {
    }

    public final ForsetiWidth e() {
        ViewGroup.LayoutParams r0 = this.h.getLayoutParams();
        if (r0 != null) goto L5;
        return null;
    L5:
        if ((r0 instanceof ForsetiNormalChainViewGroup.b) == true) goto L7;
        return null;
    L7:
        return ((ForsetiNormalChainViewGroup.b) r0).a;
    }

    public final ForsetiNodeFragment f() {
        ForsetiNodeFragment r0 = this.c;
        if (r0 == null) goto L7;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
        goto L7
    L8:
        return r0;
    L7:
        return null;
    }

    public final FragmentActivity getActivity() {
        return this.k;
    }

    public static final void a(ForsetiNode r2) {
        r2.getClass();
        Log.i("FST_Node", "executeRemovalQueue, size = " + r2.n.size());
        Iterator<Function0<Unit>> r0 = r2.n.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        r0.next().invoke();
        goto L4
    L7:
        if (((Boolean) r2.q.getValue()).booleanValue() == false) goto L11;
        r2.n.clear();
        return;
    }

    public final boolean c(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "f");
    L3:
        boolean r0 = false;
        if (r5 == null) goto L26;
        if ((r5 instanceof ForsetiNodeFragment) == true) goto L26;
        Iterator r1 = ((ArrayList) this.i).iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (Intrinsics.areEqual((Fragment) r1.next(), r5) == false) goto L9;
    L12:
        r0 = true;
    L23:
        if (r0 == true) goto L24;
        r5 = r5.getParentFragment();
        goto L3
    L24:
        return true;
    L13:
        ForsetiNodePiece r2 = this.l;
        if (r2 == null) goto L23;
        List r3 = r2.j().getFragments();
        if (r3 == null) goto L23;
        Iterator r4 = r3.iterator();
    L19:
        if (r4.hasNext() == false) goto L23;
        if (Intrinsics.areEqual((Fragment) r4.next(), r5) == false) goto L19;
    L26:
        return false;
    }

    public final void g(FragmentManager r4) {
        Intrinsics.checkNotNullParameter(r4, "parentFragmentManager");
        Log.i("FST_Node", "removeFromChain, " + cib.e.a((Fragment) CollectionsKt.lastOrNull(this.i)));
        ForsetiNodePiece r0 = this.l;
        if (r0 == null) goto L9;
        List r1 = r0.j().getFragments();
        FragmentTransaction r2 = r0.j().beginTransaction();
        Iterator r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r2.remove((Fragment) r3.next());
        goto L6
    L8:
        r2.commitAllowingStateLoss();
    L9:
        com.ss.android.lark.forseti.node.a r5 = this.p;
        if (r5 == null) goto L13;
        ForsetiNodeViewGroup r6 = this.h;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "listener");
        ((ArrayList) r6.b).remove(r5);
    L13:
        FragmentTransaction r7 = r4.beginTransaction();
        ForsetiNodeFragment r8 = this.c;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
        r8 = null;
    L16:
        r7.remove(r8);
        r7.runOnCommit(new c(this));
        r7.commitAllowingStateLoss();
    }

    public final void h(final Fragment r11) {
        Intrinsics.checkNotNullParameter(r11, "anchorFragment");
        boolean r1 = false;
        ForsetiNodeFragment r2 = null;
        Float r3 = null;
        r3 = null;
        if (((ArrayList) this.i).size() != 1) goto L53;
        if (this.b == ForsetiChainType.TYPE_NORMAL) goto L53;
        com.ss.android.lark.forseti.global.e r0 = this.a;
        s r4 = r0.g;
        if ((r4 instanceof ForsetiStackChainAdapter) == false) goto L9;
        ForsetiStackChainAdapter r5 = (ForsetiStackChainAdapter) r4;
    L10:
        ForsetiChainFragment r6 = r0.h;
        ForsetiStackChainStatus r7 = ForsetiStackChainStatus.DELETING;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r6.C = r7;
        if (r5 != null) goto L13;
        boolean r8 = false;
    L50:
        if (r8 == false) goto L53;
        return;
    L13:
        if (((Boolean) r5.i.getValue()).booleanValue() == true) goto L23;
        BottomSheetBehavior<ForsetiStackChainViewGroup> r9 = r5.g;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        r9 = null;
    L18:
        if ((r9 instanceof ForsetiStackChainBottomSheetBehaviorV2) == false) goto L20;
        ForsetiStackChainBottomSheetBehaviorV2 r10 = (ForsetiStackChainBottomSheetBehaviorV2) r9;
    L21:
        if (r10 == null) goto L32;
        r10.lockToHidden();
    L32:
        View r12 = r5.h;
        if (r12 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("stack");
        r12 = null;
    L36:
        if (r12.isLayoutRequested() == true) goto L44;
        View r13 = r5.h;
        if (r13 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("stack");
        r13 = null;
    L40:
        r13.requestLayout();
        BottomSheetBehavior<ForsetiStackChainViewGroup> r14 = r5.g;
        if (r14 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        r14 = null;
    L43:
        r14.setState(5);
    L48:
        r8 = true;
        goto L50
    L44:
        BottomSheetBehavior<ForsetiStackChainViewGroup> r15 = r5.g;
        if (r15 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        r15 = null;
    L47:
        r15.setState(5);
        goto L48
    L20:
        r10 = null;
        goto L21
    L23:
        BottomSheetBehavior<ForsetiStackChainViewGroup> r16 = r5.g;
        if (r16 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        r16 = null;
    L27:
        if ((r16 instanceof ForsetiStackChainBottomSheetBehavior) == false) goto L29;
        ForsetiStackChainBottomSheetBehavior r17 = (ForsetiStackChainBottomSheetBehavior) r16;
    L30:
        if (r17 == null) goto L32;
        r17.lockToHidden();
        goto L32
    L29:
        r17 = null;
        goto L30
    L9:
        r5 = null;
    L53:
        if (((Boolean) this.q.getValue()).booleanValue() == true) goto L61;
        if (this.o == true) goto L57;
    L64:
        this.m.remove(cib.e.a(r11));
        ForsetiNodeFragment r18 = this.c;
        if (r18 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
        r18 = null;
    L67:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r11, "f");
        Iterator<T> r19 = r18.e.entrySet().iterator();
    L69:
        if (r19.hasNext() == false) goto L73;
        Object r20 = r19.next();
        if (Intrinsics.areEqual(((Map.Entry) r20).getValue(), r11) == false) goto L69;
    L74:
        Map.Entry r21 = (Map.Entry) r20;
        if (r21 == null) goto L77;
        Fragment r22 = r18.e.remove(r21.getKey());
    L77:
        Fragment r23 = (Fragment) CollectionsKt.lastOrNull(this.i);
        Map<String, ForsetiNodePiece> r24 = this.m;
        if (r23 == null) goto L80;
        String r25 = cib.e.a(r23);
    L81:
        ForsetiNodePiece r26 = (ForsetiNodePiece) ((LinkedHashMap) r24).get(r25);
        this.l = r26;
        if (r26 == null) goto L88;
        FragmentActivity r27 = this.k;
        if (r27 == null) goto L87;
        r26.a(r27);
        goto L88
    L87:
        throw new IllegalArgumentException("Required value was null.".toString());
    L88:
        ForsetiNodeFragment r28 = this.c;
        if (r28 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
        r28 = null;
    L91:
        r28.getClass();
        Intrinsics.checkNotNullParameter(r11, "targetFragment");
        cib.d.a("prepareRemoveTargetFragment");
        Iterator r29 = ((ArrayList) r28.d).iterator();
    L93:
        if (r29.hasNext() == false) goto L97;
        ForsetiNodePiece r30 = (ForsetiNodePiece) r29.next();
        if (Intrinsics.areEqual(r30.g, r11) == false) goto L93;
        r30.onPause();
        r30.onStop();
        cib.d.a("prepareRemoveTargetFragment: removeTargetFragment");
        ((ArrayList) r28.d).remove(r30);
    L98:
        ((ArrayList) this.i).remove(r11);
        if (((Boolean) this.q.getValue()).booleanValue() == false) goto L101;
    L103:
        if (r30 == null) goto L146;
        uua.a r110 = r30.v;
        if (r110 != null) goto L107;
    L109:
        if (r1 == false) goto L134;
        Function2<? super Fragment, ? super Integer, Unit> r111 = this.g;
        Bundle r31 = r30.g.getArguments();
        if (r31 == null) goto L113;
        r31.putBoolean("isRemoving", true);
    L113:
        ForsetiNodeFragment r32 = this.c;
        if (r32 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
        r32 = null;
    L116:
        int r33 = ((ArrayList) r32.d).size();
        d r34 = new d(this, r111, r30, r33);
        e r35 = new e(this, r111, r30, r33);
        Lazy r112 = ForsetiAnimatorLauncher.a;
        if (((Boolean) ForsetiAnimatorLauncher.a.getValue()).booleanValue() == false) goto L130;
        FragmentActivity r113 = this.a.getActivity();
        int r36 = ForsetiNodePiece.y;
        Intrinsics.checkNotNullParameter(r30, "<this>");
        View r37 = r30.l().getView();
        Float r38 = Float.valueOf(0.0f);
        Window r39 = this.a.getActivity().getWindow();
        if (r39 == null) goto L128;
        View r40 = r39.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L125;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r41 = ThreadMethodProxy.currentThread();
        if (r41 == com.larus.home.impl.utils.c.a) goto L125;
        com.larus.home.impl.utils.c.a(r41, "getDecorView");
    L125:
        if (r40 == null) goto L128;
        r3 = Float.valueOf(r40.getWidth());
    L128:
        if (ForsetiAnimatorLauncher.a(r113, r37, r38, r3, r35) == true) goto L147;
        d(r30, r33);
        return;
    L147:
        return;
    L130:
        int r114 = ForsetiNodePiece.y;
        Intrinsics.checkNotNullParameter(r30, "<this>");
        View r115 = r30.l().getView();
        if (r115 != null) goto L133;
        d(r30, r33);
        return;
    L133:
        FragmentActivity r42 = this.a.getActivity();
        Intrinsics.checkNotNullParameter(r42, "context");
        Intrinsics.checkNotNullParameter(r115, "view");
        Animation r43 = AnimationUtils.loadAnimation(r42, 2130772284);
        r43.setInterpolator(PathInterpolatorCompat.create(0.34f, 0.69f, 0.1f, 1.0f));
        r43.setAnimationListener(r34);
        r115.startAnimation(r43);
        return;
    L134:
        ForsetiNodeFragment r116 = this.c;
        if (r116 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
    L138:
        d(r30, ((ArrayList) r2.d).size());
        return;
    L137:
        r2 = r116;
        goto L138
    L107:
        if (r110.a != true) goto L109;
        r1 = true;
        goto L109
    L146:
        return;
    L101:
        if (((ArrayList) this.i).size() != 0) goto L103;
        this.n.clear();
        goto L103
    L97:
        r30 = null;
        goto L98
    L80:
        r25 = null;
        goto L81
    L73:
        r20 = null;
        goto L74
    L57:
        if (((ArrayList) this.i).contains(r11) == false) goto L64;
        Log.i("FST_Node", "Animation in progress, delaying fragment removal(clearDelayQueueTimingFG disable).");
        this.n.add(new ForsetiNode$removeBizFragment$1(this, r11));
        return;
    L61:
        if (this.o == false) goto L64;
        Log.i("FST_Node", "Animation in progress, delaying fragment removal(clearDelayQueueTimingFG enable).");
        this.n.add(new ForsetiNode$removeBizFragment$2(this, r11));
    }

    public ForsetiNode(com.ss.android.lark.forseti.global.e r2, ForsetiChainType r3) {
        Intrinsics.checkNotNullParameter(r2, "forsetiContext");
        Intrinsics.checkNotNullParameter(r3, "chainType");
        this.a = r2;
        this.b = r3;
        ForsetiColumnsDraggingHelper r4 = r2.d;
        ForsetiNodeViewGroup r5 = new ForsetiNodeViewGroup(r2.getActivity(), null);
        r5.setId(View.generateViewId());
        r5.setOnClickListener(b.a);
        this.h = r5;
        this.i = new ArrayList();
        this.j = true;
        this.m = new LinkedHashMap();
        this.n = new CopyOnWriteArrayList();
        this.q = LazyKt.lazy(ForsetiNode$clearDelayQueueTimingFG$2.INSTANCE);
    }

    public final void d(ForsetiNodePiece r2, int r3) {
        r2.onDestroy();
        Function2<? super Fragment, ? super Integer, Unit> r0 = this.f;
        if (r0 == null) goto L5;
        r0.invoke(r2.g, Integer.valueOf(r3));
    L5:
        ForsetiNodeFragment r4 = this.c;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
        r4 = null;
    L8:
        ForsetiNodePiece r5 = (ForsetiNodePiece) CollectionsKt.lastOrNull(r4.d);
        if (r5 == null) goto L12;
        r5.onResume();
        return;
    }

    public final void i(FragmentActivity r4, ForsetiWidth r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        ViewGroup.LayoutParams r0 = this.h.getLayoutParams();
        if (r5 != null) goto L7;
        Log.e("FST_Node", "updateContentViewWidth failed, forsetiWidth should not be null.");
        return;
    L7:
        if (r0 != null) goto L9;
    L17:
        ForsetiNormalChainViewGroup.b r1 = new ForsetiNormalChainViewGroup.b(r4, -1, -1);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r1.a = r5;
        this.h.setLayoutParams(r1);
        return;
    L9:
        if ((r0 instanceof ForsetiNormalChainViewGroup.b) == false) goto L17;
        if (((ForsetiNormalChainViewGroup.b) r0).a == r5) goto L19;
        ForsetiNodeViewGroup r6 = this.h;
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        if (r2 == null) goto L16;
        ForsetiNormalChainViewGroup.b r3 = (ForsetiNormalChainViewGroup.b) r2;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.a = r5;
        r6.setLayoutParams(r3);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroup.ForsetiChainLayoutParams");
    }

    public final void b(Fragment r17, final String r18, uua.a r19) {
        Intrinsics.checkNotNullParameter(r17, "f");
        Intrinsics.checkNotNullParameter(r18, "tag");
        Intrinsics.checkNotNullParameter(r19, "options");
        Log.i("FST_Node", "addFragment, " + cib.e.a(r17));
        int r1 = ForsetiNodePiece.y;
        FragmentActivity r2 = this.a.getActivity();
        Bundle r3 = r17.getArguments();
        ForsetiNodeFragment r4 = this.c;
        ForsetiNodeFragment r14 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
        ForsetiNodeFragment r5 = null;
    L6:
        com.ss.android.lark.forseti.global.e r6 = this.a;
        ForsetiNodePiece r7 = ForsetiNodePiece.a.a(r2, r17, r3, null, r5, r6.e, r6.b.a, r19);
        r7.m = r19.b;
        this.l = r7;
        this.m.put(cib.e.a(r17), this.l);
        ForsetiNodePiece r8 = this.l;
        if (r8 == null) goto L13;
        FragmentActivity r9 = this.k;
        if (r9 == null) goto L12;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "hostActivity");
        r8.a(r9);
        Log.i("ForsetiNodePiece", "forsetiNodePiece attach");
        goto L13
    L12:
        throw new IllegalArgumentException("Required value was null.".toString());
    L13:
        Log.i("FST_Node", "uniqueFragmentTag = " + r18 + ", fragment = " + r17.getClass().getName());
        ForsetiNodeFragment r10 = this.c;
        if (r10 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
        r10 = null;
    L16:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r18, "uniqueTag");
        Intrinsics.checkNotNullParameter(r17, "f");
        r10.e.put(r18, r17);
        int r11 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.delete_placeholder_disabled") == true) goto L24;
        ((ArrayList) this.i).add(r17);
        ForsetiNodeFragment r12 = this.c;
        if (r12 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
    L22:
        r14.T90(this.l, new ForsetiNode$addFragment$2(this, r18));
        return;
    L21:
        r14 = r12;
        goto L22
    L24:
        ForsetiNodeFragment r13 = this.c;
        if (r13 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
    L28:
        r14.T90(this.l, new ForsetiNode$addFragment$3(this, r18));
        ((ArrayList) this.i).add(r17);
        return;
    L27:
        r14 = r13;
        goto L28
    L5:
        r5 = r4;
        goto L6
    }
}
