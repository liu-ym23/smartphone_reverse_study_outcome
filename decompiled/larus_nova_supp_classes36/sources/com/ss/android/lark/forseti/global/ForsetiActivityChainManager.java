package com.ss.android.lark.forseti.global;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.api.api.ForsetiBaseChainFragment;
import com.ss.android.lark.api.bean.ForsetiChainType;
import com.ss.android.lark.api.bean.ForsetiMode;
import com.ss.android.lark.api.bean.ForsetiPageViewType;
import com.ss.android.lark.api.bean.ForsetiScreenMode;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.ForsetiPlugin;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.chain.ForsetiChainFragment;
import com.ss.android.lark.forseti.chain.ForsetiChainFragment$setClickInterceptor$1;
import com.ss.android.lark.forseti.chain.ForsetiChainHelper;
import com.ss.android.lark.forseti.chain.ForsetiChainState;
import com.ss.android.lark.forseti.chain.ForsetiStackChainStatus;
import com.ss.android.lark.forseti.chain.k;
import com.ss.android.lark.forseti.chain.l;
import com.ss.android.lark.forseti.chain.m;
import com.ss.android.lark.forseti.chain.n;
import com.ss.android.lark.forseti.chain.o;
import com.ss.android.lark.forseti.chain.p;
import com.ss.android.lark.forseti.chain.r;
import com.ss.android.lark.forseti.node.ForsetiNode;
import com.ss.android.lark.forseti.node.ForsetiNodeFragment;
import com.ss.android.lark.forseti.node.piece.ForsetiNodePiece;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainDraggingLayout;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainDraggingView;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.insets.AndroidQInsetsDispatchCompat;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForsetiActivityChainManager implements tua.b {
    public static final /* synthetic */ int v = 0;
    public final FragmentActivity a;
    public final ViewGroup b;
    public final LinkedHashMap<String, ForsetiChainFragment> c;
    public ForsetiChainFragment d;
    public ForsetiChainFragment e;
    public final ForsetiAttachInfo f;
    public final CopyOnWriteArrayList<Function1<ForsetiMode, Unit>> g;
    public final CopyOnWriteArrayList<FragmentManager.FragmentLifecycleCallbacks> h;
    public final CopyOnWriteArrayList<Function1<Boolean, Unit>> i;
    public final CopyOnWriteArrayList<com.ss.android.lark.api.ui.j> j;
    public final CopyOnWriteArrayList<Function1<ForsetiScreenMode, Unit>> k;
    public final ArrayDeque<String> l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final com.ss.android.lark.forseti.global.c r;
    public final ForsetiActivityChainManager$backPressedCallback$1 s;
    public final f t;
    public final g u;

    public static final class a {
    }

    public static final class b extends c<yua.d> {
        public b(MutableLiveData<yua.d> r2, Function0<? extends yua.d> r3) {
            Intrinsics.checkNotNullParameter(r2, "liveData");
            Intrinsics.checkNotNullParameter(r3, "onChanged");
            super(r2, r3);
        }
    }

    public static class c<T> {
        public final MutableLiveData<T> a;
        public final Function0<T> b;

        public final void a() {
            this.a.setValue(this.b.invoke());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(MutableLiveData<T> r2, Function0<? extends T> r3) {
            Intrinsics.checkNotNullParameter(r2, "liveData");
            Intrinsics.checkNotNullParameter(r3, "onChanged");
            this.a = r2;
            this.b = r3;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ForsetiChainType.values().length];
            r0[ForsetiChainType.TYPE_NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L16:
            r0[ForsetiChainType.TYPE_STACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            r0[ForsetiChainType.TYPE_HALF_STACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L7:
            a = r0;
            int[] r1 = new int[ForsetiViewMode.values().length];
            r1[ForsetiViewMode.MEDIUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L18:
            r1[ForsetiViewMode.EXPAND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ ForsetiActivityChainManager a;
        public final /* synthetic */ ForsetiBaseChainFragment b;

        public e(ForsetiActivityChainManager r1, ForsetiChainFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.M(this.b);
        }
    }

    public static final class f implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ ForsetiActivityChainManager a;

        public f(ForsetiActivityChainManager r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            ForsetiChainFragment r0 = this.a.e0();
            Integer r1 = null;
            if (r0 == null) goto L5;
            ForsetiChainType r2 = r0.S90();
        L7:
            if (r2 == ForsetiChainType.TYPE_NORMAL) goto L25;
            Iterator r3 = CollectionsKt.reversed(this.a.f0().entrySet()).iterator();
        L10:
            if (r3.hasNext() == false) goto L17;
            Object r4 = r3.next();
            if (((ForsetiChainFragment) ((Map.Entry) r4).getValue()).S90() != ForsetiChainType.TYPE_NORMAL) goto L14;
            boolean r5 = true;
        L15:
            if (r5 == false) goto L10;
        L18:
            Map.Entry r6 = (Map.Entry) r4;
            if (r6 == null) goto L30;
            ForsetiChainFragment r7 = (ForsetiChainFragment) r6.getValue();
            if (r7 == null) goto L30;
            ViewGroup r8 = r7.f;
            if (r8 == null) goto L30;
            Integer r9 = Integer.valueOf(r8.getWidth());
        L31:
            ForsetiChainFragment r10 = this.a.e0();
            if (r10 == null) goto L34;
            ForsetiChainType r11 = r10.S90();
        L36:
            if (r11 == ForsetiChainType.TYPE_NORMAL) goto L54;
            Iterator r12 = CollectionsKt.reversed(this.a.f0().entrySet()).iterator();
        L39:
            if (r12.hasNext() == false) goto L46;
            Object r13 = r12.next();
            if (((ForsetiChainFragment) ((Map.Entry) r13).getValue()).S90() != ForsetiChainType.TYPE_NORMAL) goto L43;
            boolean r14 = true;
        L44:
            if (r14 == false) goto L39;
        L47:
            Map.Entry r15 = (Map.Entry) r13;
            if (r15 == null) goto L60;
            ForsetiChainFragment r16 = (ForsetiChainFragment) r15.getValue();
            if (r16 == null) goto L60;
            ViewGroup r17 = r16.f;
            if (r17 == null) goto L60;
            r1 = Integer.valueOf(r17.getHeight());
        L60:
            if (fib.a.a() == false) goto L63;
            if (r9 == null) goto L63;
            int r18 = cib.c.a;
            ForsetiMode r19 = cib.c.a(this.a.a, r9);
        L73:
            if (fib.a.a() == false) goto L77;
            if (r9 == null) goto L77;
            if (r1 == null) goto L77;
            ForsetiViewMode r20 = ForsetiActivityChainManager.W(this.a.a, r9, r1);
        L79:
            if (r19 == this.a.f.a) goto L98;
            Log.i("FST_ChainManager", "mode changed, cur is: " + r19);
            ForsetiAttachInfo r21 = this.a.f;
            r21.getClass();
            Intrinsics.checkNotNullParameter(r19, "<set-?>");
            r21.a = r19;
            Iterator<Function1<ForsetiMode, Unit>> r22 = this.a.g.iterator();
        L82:
            if (r22.hasNext() == false) goto L84;
            r22.next().invoke(r19);
            goto L82
        L84:
            ForsetiActivityChainManager r23 = this.a;
            Iterator<Map.Entry<String, ForsetiChainFragment>> r24 = r23.c.entrySet().iterator();
        L86:
            if (r24.hasNext() == false) goto L98;
            Map.Entry<String, ForsetiChainFragment> r25 = r24.next();
            ForsetiMode r26 = r23.f.a;
            Intrinsics.checkNotNullParameter(r26, "<this>");
            if (r26 != ForsetiMode.Compact) goto L90;
            boolean r27 = true;
        L91:
            if (r27 == false) goto L86;
            ForsetiChainHelper r28 = r25.getValue().j;
            if (r28 == null) goto L86;
            if (r28.n == true) goto L86;
            r28.g(r28.g.e);
            goto L86
        L90:
            r27 = false;
        L98:
            if (r20 == this.a.r.a) goto L103;
            Log.i("FST_ChainManager", "viewMode changed, cur is: " + r20);
            com.ss.android.lark.forseti.global.c r29 = this.a.r;
            r29.getClass();
            Intrinsics.checkNotNullParameter(r20, "<set-?>");
            r29.a = r20;
            Iterator<com.ss.android.lark.api.ui.j> r30 = this.a.j.iterator();
        L101:
            if (r30.hasNext() == false) goto L103;
            r30.next().a(r20);
        L103:
            int r31 = cib.c.a;
            ForsetiActivityChainManager r32 = this.a;
            FragmentActivity r33 = r32.a;
            Integer r34 = Integer.valueOf(r32.b.getWidth());
            Integer r35 = Integer.valueOf(this.a.b.getHeight());
            if (r33 == null) goto L126;
            if (r34 == null) goto L126;
            if (r35 == null) goto L126;
            int r36 = fib.a.a;
            if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.placeholder_exit_enabled") == false) goto L120;
            com.ss.android.lark.base.embedded.e r37 = cib.c.b(r33, r34.intValue());
            if (r34.intValue() >= UIUtils.dp2px(r33, 636.0f)) goto L113;
        L118:
            ForsetiScreenMode r38 = ForsetiScreenMode.COMPACT;
        L128:
            if (this.a.r.b == r38) goto L133;
            Log.i("FST_ChainManager", "screenMode changed, cur is: " + r38);
            com.ss.android.lark.forseti.global.c r39 = this.a.r;
            r39.getClass();
            Intrinsics.checkNotNullParameter(r38, "<set-?>");
            r39.b = r38;
            Iterator<Function1<ForsetiScreenMode, Unit>> r40 = this.a.k.iterator();
        L131:
            if (r40.hasNext() == false) goto L133;
            r40.next().invoke(r38);
        L133:
            return true;
        L113:
            if (Math.min(r34.intValue(), r35.intValue()) < r37.b) goto L118;
            if (r34.intValue() < UIUtils.dp2px(r33, 840.0f)) goto L117;
            r38 = ForsetiScreenMode.EXPAND;
            goto L128
        L117:
            r38 = ForsetiScreenMode.MEDIUM;
            goto L128
        L120:
            if (r34.intValue() >= UIUtils.dp2px(r33, 636.0f)) goto L123;
            r38 = ForsetiScreenMode.COMPACT;
            goto L128
        L123:
            if (r34.intValue() >= UIUtils.dp2px(r33, 840.0f)) goto L125;
            r38 = ForsetiScreenMode.MEDIUM;
            goto L128
        L125:
            r38 = ForsetiScreenMode.EXPAND;
        L126:
            Log.e("ForsetiModeUtils", "calculateScreenMode: activity is null, returns ForsetiScreenMode.UNKNOWN");
            r38 = ForsetiScreenMode.UNKNOWN;
        L77:
            ForsetiActivityChainManager r41 = this.a;
            r20 = ForsetiActivityChainManager.W(r41.a, Integer.valueOf(r41.b.getWidth()), Integer.valueOf(this.a.b.getHeight()));
        L63:
            int r42 = cib.c.a;
            ForsetiActivityChainManager r43 = this.a;
            FragmentActivity r44 = r43.a;
            int r45 = r43.b.getWidth();
            int r46 = this.a.b.getHeight();
            if (r44 != null) goto L66;
            r19 = ForsetiMode.Unknown;
            goto L73
        L66:
            com.ss.android.lark.base.embedded.e r47 = cib.c.b(r44, r45);
            if (r45 >= r47.a) goto L69;
        L71:
            r19 = ForsetiMode.Compact;
            goto L73
        L69:
            if (Math.min(r45, r46) < r47.b) goto L71;
            r19 = ForsetiMode.Regular;
            goto L73
        L43:
            r14 = false;
            goto L44
        L46:
            r13 = null;
            goto L47
        L54:
            ForsetiChainFragment r48 = this.a.e0();
            if (r48 == null) goto L60;
            ViewGroup r49 = r48.f;
            if (r49 == null) goto L60;
            r1 = Integer.valueOf(r49.getHeight());
            goto L60
        L34:
            r11 = null;
        L30:
            r9 = null;
            goto L31
        L14:
            r5 = false;
            goto L15
        L17:
            r4 = null;
            goto L18
        L25:
            ForsetiChainFragment r50 = this.a.e0();
            if (r50 == null) goto L30;
            ViewGroup r51 = r50.f;
            if (r51 == null) goto L30;
            r9 = Integer.valueOf(r51.getWidth());
            goto L31
        L5:
            r2 = null;
            goto L7
        }
    }

    public static final class g implements View.OnLayoutChangeListener {
        public final /* synthetic */ ForsetiActivityChainManager a;

        public g(ForsetiActivityChainManager r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            int r10 = r4 - r2;
            if (r10 == (r8 - r6)) goto L8;
            Log.i("FST_ChainManager", "width changed, cur is: " + r10);
            Iterator<T> r11 = this.a.i.iterator();
        L6:
            if (r11.hasNext() == false) goto L10;
            ((Function1) r11.next()).invoke(Boolean.TRUE);
            goto L6
        L10:
            return;
        }
    }

    static {
    }

    public final ForsetiViewMode H() {
        return this.r.a;
    }

    public final String N() {
        String r0 = (String) this.l.lastOrNull();
        if (r0 != null) goto L6;
        return "nav_route_float_chain";
    L6:
        return r0;
    }

    public final ForsetiMode T() {
        return this.f.a;
    }

    public final void X() {
    L3:
        if ((!this.l.isEmpty()) == false) goto L8;
        ForsetiChainFragment r0 = a0(N());
        if (r0 != null) goto L6;
        this.l.removeLastOrNull();
        goto L3
    L6:
        M(r0);
        goto L3
    }

    public final void clear() {
        Log.i("FST_ChainManager", "FST_ChainManager calls clear.");
        this.b.getViewTreeObserver().removeOnPreDrawListener(this.t);
        this.b.removeOnLayoutChangeListener(this.u);
        setEnabled(false);
        remove();
        X();
        ForsetiChainFragment r0 = a0("nav_route_float_chain");
        if (r0 == null) goto L5;
        M(r0);
    L5:
        this.c.clear();
        f0().clear();
        j0(null);
        this.e = null;
        this.g.clear();
        this.i.clear();
        this.j.clear();
        this.h.clear();
        com.ss.android.lark.forseti.chain.a.a.clear();
    }

    public final LinkedHashMap<String, ForsetiChainFragment> f0() {
        return (LinkedHashMap) this.q.getValue();
    }

    public final boolean g0() {
        return ((Boolean) this.o.getValue()).booleanValue();
    }

    public final ForsetiScreenMode k() {
        return this.r.b;
    }

    public final h k0() {
        LinkedHashMap<String, ForsetiChainFragment> r0 = this.c;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, ForsetiChainFragment>> r2 = r0.entrySet().iterator();
    L3:
        boolean r3 = true;
        if (r2.hasNext() == false) goto L8;
        Map.Entry<String, ForsetiChainFragment> r4 = r2.next();
        if ((true ^ Intrinsics.areEqual(r4.getValue(), e0())) == false) goto L3;
        r1.put(r4.getKey(), r4.getValue());
        goto L3
    L8:
        ArrayList r5 = new ArrayList(r1.size());
        Iterator r6 = r1.entrySet().iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        Map.Entry r7 = (Map.Entry) r6.next();
        int r8 = r.a;
        r5.add(r.a((ForsetiChainFragment) r7.getValue()));
        goto L10
    L12:
        List r9 = CollectionsKt.toMutableList(r5);
        ForsetiChainFragment r10 = e0();
        if (r10 == null) goto L16;
        ListProtector.add(r9, 0, r.a(r10));
    L16:
        if (e0() != null) goto L20;
        r3 = false;
    L20:
        return new h(r9, r3);
    }

    public final yua.d q() {
        yua.d r0 = (yua.d) ((b) this.m.getValue()).a.getValue();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new h(CollectionsKt.emptyList(), false);
    }

    public final void C() {
        ForsetiChainFragment r0 = e0();
        if (r0 == null) goto L6;
        r0.X90(r0.m, new o(r0));
        return;
    }

    public final Fragment E() {
        ForsetiChainFragment r0 = e0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ba0();
    }

    public final String U() {
        String r0 = "nav_route_float_chain_" + System.currentTimeMillis();
        this.l.addLast(r0);
        return r0;
    }

    public final ForsetiChainFragment d0() {
        if (g0() == true) goto L6;
        return (ForsetiChainFragment) CollectionsKt.getOrNull(CollectionsKt.reversed(f0().values()), 1);
    L6:
        return this.e;
    }

    public final ForsetiChainFragment e0() {
        if (g0() == true) goto L6;
        return (ForsetiChainFragment) CollectionsKt.lastOrNull(f0().values());
    L6:
        return this.d;
    }

    public final ForsetiNormalChainDraggingView m() {
        ForsetiChainFragment r0 = e0();
        if (r0 == null) goto L17;
        View r1 = r0.h;
        if ((r1 instanceof ForsetiNormalChainDraggingLayout) == false) goto L7;
        ForsetiNormalChainDraggingLayout r2 = (ForsetiNormalChainDraggingLayout) r1;
    L8:
        if (r2 == null) goto L12;
        Sequence r3 = ViewGroupKt.getChildren(r2);
        if (r3 == null) goto L12;
        View r4 = (View) SequencesKt.firstOrNull(r3);
    L14:
        if ((r4 instanceof ForsetiNormalChainDraggingView) == true) goto L16;
        return null;
    L16:
        return (ForsetiNormalChainDraggingView) r4;
    L12:
        r4 = null;
        goto L14
    L7:
        r2 = null;
        goto L8
    L17:
        return null;
    }

    public final void p() {
        ForsetiChainFragment r0 = e0();
        if (r0 == null) goto L6;
        r0.X90(r0.m, new n(r0));
        return;
    }

    public final ForsetiChainFragment v() {
        return e0();
    }

    public final ArrayDeque<String> s() {
        return this.l;
    }

    /* JADX WARN: Type inference failed for: r1v19, types: [androidx.activity.OnBackPressedCallback, com.ss.android.lark.forseti.global.ForsetiActivityChainManager$backPressedCallback$1] */
    public ForsetiActivityChainManager(FragmentActivity r6) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        this.a = r6;
        ViewGroup r0 = (ViewGroup) r6.findViewById(R.id.content);
        this.b = r0;
        this.c = new LinkedHashMap();
        this.f = new ForsetiAttachInfo();
        this.g = new CopyOnWriteArrayList();
        this.h = new CopyOnWriteArrayList();
        this.i = new CopyOnWriteArrayList();
        this.j = new CopyOnWriteArrayList();
        this.k = new CopyOnWriteArrayList();
        this.l = new ArrayDeque();
        this.m = LazyKt.lazy(new ForsetiActivityChainManager$forsetiStructureNotifier$2(this));
        this.n = LazyKt.lazy(ForsetiActivityChainManager$multiStackDisableFG$2.INSTANCE);
        this.o = LazyKt.lazy(ForsetiActivityChainManager$resumedChainOptDisableFG$2.INSTANCE);
        this.p = LazyKt.lazy(ForsetiActivityChainManager$clearFloatChainDisabledFG$2.INSTANCE);
        this.q = LazyKt.lazy(ForsetiActivityChainManager$resumedChainHistory$2.INSTANCE);
        this.r = new com.ss.android.lark.forseti.global.c(ForsetiViewMode.UNKNOWN, ForsetiScreenMode.UNKNOWN);
        ?? r1 = new ForsetiActivityChainManager$backPressedCallback$1(this);
        this.s = r1;
        f r2 = new f(this);
        this.t = r2;
        g r3 = new g(this);
        this.u = r3;
        r0.getViewTreeObserver().addOnPreDrawListener(r2);
        r0.addOnLayoutChangeListener(r3);
        r6.getOnBackPressedDispatcher().addCallback(r6, r1);
        AndroidQInsetsDispatchCompat.a(r0);
    }

    public static void i0(ForsetiNodePiece r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getLifecycleRegistry().getCurrentState() != Lifecycle.State.CREATED) goto L8;
        r2.onStart();
    L8:
        if (r2.getLifecycleRegistry().getCurrentState() != Lifecycle.State.STARTED) goto L11;
        r2.onResume();
        return;
    }

    public final Fragment A(ForsetiBaseChainFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "chain");
        return ((ForsetiChainFragment) r2).ba0();
    }

    public final void B(FragmentManager.FragmentLifecycleCallbacks r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        CopyOnWriteArrayList<FragmentManager.FragmentLifecycleCallbacks> r1 = com.ss.android.lark.forseti.chain.a.a;
        Intrinsics.checkNotNullParameter(r3, "callback");
        com.ss.android.lark.forseti.chain.a.a.remove(r3);
    }

    public final void D(Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        r2.invoke(this.r.b);
        this.k.add(r2);
    }

    public final ForsetiWidth F(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "bizFragment");
        ForsetiNode r3 = b0(r2);
        if (r3 == null) goto L7;
        ForsetiWidth r4 = r3.e();
        if (r4 == null) goto L7;
        return r4;
    L7:
        return ForsetiWidth.AVERAGE_LEVEL;
    }

    public final ForsetiBaseChainFragment I(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "f");
        return Z(r2);
    }

    public final void M(final ForsetiBaseChainFragment r8) {
        Intrinsics.checkNotNullParameter(r8, "chain");
        Log.i("FST_ChainManager", "remove stack chain, chain: " + cib.e.a(r8));
        CollectionsKt.removeAll(this.c.entrySet(), new ForsetiActivityChainManager$removeForsetiStackChain$1(r8));
        if (Intrinsics.areEqual(d0(), r8) == true) goto L53;
        ForsetiChainFragment r0 = d0();
        if (r0 == null) goto L53;
        if (((Boolean) this.n.getValue()).booleanValue() == true) goto L10;
        CollectionsKt.removeAll(f0().entrySet(), new ForsetiActivityChainManager$removeForsetiStackChain$2$1(r8));
    L10:
        if (((Boolean) ForsetiConfig.f.getValue()).booleanValue() == true) goto L12;
        l0(r0);
        goto L53
    L12:
        if (((Boolean) this.n.getValue()).booleanValue() == true) goto L50;
        List r1 = CollectionsKt.reversed(f0().entrySet());
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L14:
        boolean r4 = false;
        if (r3.hasNext() == false) goto L21;
        Object r5 = r3.next();
        if (((ForsetiChainFragment) ((Map.Entry) r5).getValue()).z == ForsetiChainState.STOPPED) goto L19;
        r4 = true;
    L19:
        if (r4 == false) goto L14;
        r2.add(r5);
        goto L14
    L21:
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r7 = r2.iterator();
    L23:
        if (r7.hasNext() == false) goto L25;
        r6.add((ForsetiChainFragment) ((Map.Entry) r7.next()).getValue());
        goto L23
    L25:
        ForsetiChainFragment r9 = (ForsetiChainFragment) CollectionsKt.getOrNull(r6, 0);
        if (r9 == null) goto L49;
        Log.i("FST_ChainManager", "Found last valid chain: " + cib.e.a(r9) + ", updating resumedChain.");
        ForsetiChainFragment r10 = e0();
        if (r10 == null) goto L30;
        r10.U90(ForsetiChainState.STOPPED);
    L30:
        r9.U90(ForsetiChainState.RESUMED);
        this.e = e0();
        j0(r9);
        Iterator<T> r11 = this.c.entrySet().iterator();
    L31:
        String r12 = null;
        if (r11.hasNext() == false) goto L36;
        Object r13 = r11.next();
        if (Intrinsics.areEqual(((Map.Entry) r13).getValue(), e0()) == false) goto L31;
    L37:
        Map.Entry r14 = (Map.Entry) r13;
        if (r14 == null) goto L40;
        r12 = (String) r14.getKey();
    L40:
        if (r12 == null) goto L45;
        f0().put(r12, r9);
        if (g0() == true) goto L44;
        h0(r12);
    L44:
        Log.i("FST_ChainManager", "updateResumedChain: " + cib.e.a(r9) + ", added to history, key: " + r12);
    L45:
        k0();
        this.l.removeLastOrNull();
        Iterator r15 = xua.a.a.iterator();
    L47:
        if (r15.hasNext() == false) goto L53;
        ((xua.a.a) r15.next()).a();
        goto L47
    L36:
        r13 = null;
        goto L37
    L49:
        Log.i("FST_ChainManager", "No valid chain found in resumedChainHistory.");
        goto L53
    L50:
        m0(r0);
    L53:
        if (((Boolean) this.n.getValue()).booleanValue() == false) goto L55;
        CollectionsKt.removeAll(f0().entrySet(), new ForsetiActivityChainManager$removeForsetiStackChain$3(r8));
    L55:
        FragmentTransaction r16 = this.a.getSupportFragmentManager().beginTransaction();
        r16.remove(r8);
        r16.commitAllowingStateLoss();
    }

    public final void O(com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModel.b r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        ForsetiChainFragment r0 = e0();
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r4, "listener");
        r0.X90(r0.k, new com.ss.android.lark.forseti.chain.b(r0, r4));
        return;
    }

    public final void P(com.ss.android.lark.api.ui.j r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        r2.a(this.r.a);
        this.j.add(r2);
    }

    public final void Q(final Function0<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r4, "interceptor");
        final ForsetiChainFragment r0 = e0();
        if (r0 == null) goto L6;
        r0.X90(r0.m, new ForsetiChainFragment$setClickInterceptor$1(r0, r4));
        return;
    }

    public final void S(FragmentManager.FragmentLifecycleCallbacks r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        CopyOnWriteArrayList<FragmentManager.FragmentLifecycleCallbacks> r1 = com.ss.android.lark.forseti.chain.a.a;
        Intrinsics.checkNotNullParameter(r3, "callback");
        com.ss.android.lark.forseti.chain.a.a.addIfAbsent(r3);
    }

    public final ForsetiBaseChainFragment Z(Fragment r4) {
        Iterator<Map.Entry<String, ForsetiChainFragment>> r0 = this.c.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<String, ForsetiChainFragment> r1 = r0.next();
        if (r1.getValue().Y90(r4) == null) goto L4;
        return r1.getValue();
    L9:
        return null;
    }

    public final boolean a(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "f");
        ForsetiBaseChainFragment r4 = Z(r3);
        if ((r4 instanceof ForsetiChainFragment) == false) goto L5;
        ForsetiChainFragment r5 = (ForsetiChainFragment) r4;
    L7:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r5.W90() != true) goto L13;
        return true;
    L13:
        return false;
    L5:
        r5 = null;
        goto L7
    }

    public final ForsetiChainFragment a0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chainKey");
        return this.c.get(r2);
    }

    public final void b(int r4) {
        ForsetiChainFragment r0 = e0();
        if (r0 == null) goto L6;
        r0.X90(r0.m, new m(r0, r4));
        return;
    }

    public final ForsetiNode b0(Fragment r3) {
        Iterator<Map.Entry<String, ForsetiChainFragment>> r0 = this.c.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ForsetiNode r1 = r0.next().getValue().Y90(r3);
        if (r1 == null) goto L4;
        return r1;
    L8:
        return null;
    }

    public final void c(boolean r4) {
        ForsetiChainFragment r0 = e0();
        if (r0 == null) goto L6;
        r0.X90(r0.m, new l(r0, r4));
        return;
    }

    public final void d(int r4) {
        ForsetiChainFragment r0 = e0();
        if (r0 == null) goto L6;
        r0.X90(r0.m, new p(r0, r4));
        return;
    }

    public final void e(com.ss.android.lark.api.ui.j r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.j.remove(r2);
    }

    public final tua.c g(Fragment r4) {
        Intrinsics.checkNotNullParameter(r4, "f");
        ForsetiBaseChainFragment r0 = Z(r4);
        if ((r0 instanceof ForsetiChainFragment) == false) goto L5;
        ForsetiChainFragment r1 = (ForsetiChainFragment) r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.ea0(r4);
    L5:
        r1 = null;
        goto L6
    }

    public final void h0(String r3) {
        ForsetiChainFragment r0 = f0().get(r3);
        if (r0 == null) goto L6;
        f0().remove(r3);
        f0().put(r3, r0);
        return;
    }

    public final void j(Function1<? super ForsetiScreenMode, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.k.remove(r2);
    }

    public final void j0(ForsetiChainFragment r5) {
        if (g0() == true) goto L17;
        Iterator<T> r0 = this.c.entrySet().iterator();
    L5:
        String r2 = null;
        if (r0.hasNext() == false) goto L10;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((Map.Entry) r1).getValue(), r5) == false) goto L5;
    L11:
        Map.Entry r3 = (Map.Entry) r1;
        if (r3 == null) goto L14;
        r2 = (String) r3.getKey();
    L14:
        if (r2 == null) goto L22;
        if (r5 == null) goto L23;
        f0().put(r2, r5);
        h0(r2);
        return;
    L23:
        return;
    L22:
        return;
    L10:
        r1 = null;
        goto L11
    L17:
        this.d = r5;
    }

    public final void l(com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModel.b r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        ForsetiChainFragment r0 = e0();
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r4, "listener");
        r0.X90(r0.k, new com.ss.android.lark.forseti.chain.i(r0, r4));
        return;
    }

    public final void l0(ForsetiChainFragment r7) {
        if (r7.S90() != ForsetiChainType.TYPE_STACK) goto L5;
    L8:
        ForsetiChainState r0 = ForsetiChainState.STARTED;
    L10:
        if (fib.a.a() == true) goto L12;
    L14:
        ForsetiChainFragment r1 = e0();
        if (r1 == null) goto L17;
        r1.U90(r0);
    L17:
        r7.U90(ForsetiChainState.RESUMED);
        this.e = e0();
        j0(r7);
        Iterator<T> r2 = this.c.entrySet().iterator();
    L18:
        ForsetiNodePiece r3 = null;
        if (r2.hasNext() == false) goto L23;
        Object r4 = r2.next();
        if (Intrinsics.areEqual(((Map.Entry) r4).getValue(), e0()) == false) goto L18;
    L24:
        Map.Entry r5 = (Map.Entry) r4;
        if (r5 == null) goto L27;
        String r6 = (String) r5.getKey();
    L28:
        if (r6 == null) goto L33;
        f0().put(r6, r7);
        if (g0() == true) goto L32;
        h0(r6);
    L32:
        Log.i("FST_ChainManager", "updateResumedChain: " + cib.e.a(r7) + ", added to history, key: " + r6);
    L33:
        k0();
        Iterator r8 = xua.a.a.iterator();
    L35:
        if (r8.hasNext() == false) goto L37;
        ((xua.a.a) r8.next()).a();
        goto L35
    L37:
        int r9 = com.ss.android.lark.forseti.global.b.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.dispatch_resume_optimizeV2") == true) goto L86;
        if (this.f.a != ForsetiMode.Compact) goto L50;
        ForsetiNode r10 = r7.aa0();
        if (r10 == null) goto L44;
        ForsetiNodeFragment r11 = r10.f();
    L45:
        if (r11 == null) goto L49;
        List<ForsetiNodePiece> r12 = r11.d;
        if (r12 == null) goto L49;
        r3 = (ForsetiNodePiece) CollectionsKt.lastOrNull(r12);
    L49:
        i0(r3);
        goto L86
    L44:
        r11 = null;
        goto L45
    L50:
        ForsetiNode r13 = r7.aa0();
        if (r13 == null) goto L53;
        ForsetiWidth r14 = r13.e();
    L55:
        if (r14 != ForsetiWidth.FULL) goto L65;
        ForsetiNode r15 = r7.aa0();
        if (r15 == null) goto L59;
        ForsetiNodeFragment r16 = r15.f();
    L60:
        if (r16 == null) goto L64;
        List<ForsetiNodePiece> r17 = r16.d;
        if (r17 == null) goto L64;
        r3 = (ForsetiNodePiece) CollectionsKt.lastOrNull(r17);
    L64:
        i0(r3);
        goto L86
    L59:
        r16 = null;
        goto L60
    L65:
        ForsetiNode r18 = r7.aa0();
        if (r18 == null) goto L68;
        ForsetiNodeFragment r19 = r18.f();
    L69:
        if (r19 == null) goto L73;
        List<ForsetiNodePiece> r20 = r19.d;
        if (r20 == null) goto L73;
        ForsetiNodePiece r21 = (ForsetiNodePiece) CollectionsKt.lastOrNull(r20);
    L74:
        ForsetiNode r22 = r7.aa0();
        if (r22 == null) goto L79;
        ForsetiNode r23 = r22.d;
        if (r23 == null) goto L79;
        ForsetiNodeFragment r24 = r23.f();
    L80:
        if (r24 == null) goto L84;
        List<ForsetiNodePiece> r25 = r24.d;
        if (r25 == null) goto L84;
        r3 = (ForsetiNodePiece) CollectionsKt.lastOrNull(r25);
    L84:
        i0(r21);
        i0(r3);
    L79:
        r24 = null;
    L73:
        r21 = null;
        goto L74
    L68:
        r19 = null;
        goto L69
    L53:
        r14 = null;
    L86:
        if (((Boolean) this.p.getValue()).booleanValue() == false) goto L88;
        return;
    L88:
        if (r7.S90() != ForsetiChainType.TYPE_NORMAL) goto L98;
        X();
        ForsetiChainFragment r26 = a0("nav_route_float_chain");
        if (r26 == null) goto L99;
        M(r26);
        return;
    L99:
        return;
    L98:
        return;
    L27:
        r6 = null;
        goto L28
    L23:
        r4 = null;
        goto L24
    L12:
        if (((com.ss.android.lark.api.bean.config.a) r7.y.getValue()).f.f == false) goto L14;
        Log.d("FST_ChainManager", "not dispatch previous resumed chain in split window chain");
        goto L17
    L5:
        if (r7.S90() == ForsetiChainType.TYPE_HALF_STACK) goto L8;
        r0 = ForsetiChainState.STOPPED;
        goto L10
    }

    public final void m0(ForsetiChainFragment r7) {
        int r0 = d.a[r7.S90().ordinal()];
        if (r0 != 1) goto L5;
        Log.i("FST_ChainManager", "previousResumedChain is Normal type, updating resumedChain directly.");
        l0(r7);
        return;
    L5:
        if (r0 != 2) goto L7;
    L9:
        Log.i("FST_ChainManager", "previousResumedChain is Stack type, attempting to find last valid chain in history.");
        Iterator r8 = CollectionsKt.reversed(f0().entrySet()).iterator();
    L10:
        ForsetiChainFragment r3 = null;
        if (r8.hasNext() == false) goto L18;
        Object r1 = r8.next();
        if (((ForsetiChainFragment) ((Map.Entry) r1).getValue()).C == ForsetiStackChainStatus.DELETING) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L10;
    L19:
        Map.Entry r2 = (Map.Entry) r1;
        if (r2 == null) goto L22;
        r3 = (ForsetiChainFragment) r2.getValue();
    L22:
        if (r3 == null) goto L24;
        Log.i("FST_ChainManager", "Found last valid chain: " + cib.e.a(r3) + ", updating resumedChain.");
        l0(r3);
        return;
    L24:
        Log.i("FST_ChainManager", "No valid chain found in resumedChainHistory.");
        return;
    L15:
        r4 = false;
        goto L16
    L18:
        r1 = null;
        goto L19
    L7:
        if (r0 == 3) goto L9;
        Log.e("FST_ChainManager", "previousResumedChain type is unknown or unsupported, no action taken.");
    }

    public final /* bridge */ /* synthetic */ ForsetiChainFragment o(String r1) {
        return a0(r1);
    }

    public final boolean t(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "bizFragment");
        ForsetiNode r3 = b0(r2);
        if (r3 == null) goto L11;
        ForsetiNode r4 = r3.d;
        if (r4 == null) goto L7;
        ForsetiNode r5 = r4.d;
    L8:
        if (r5 == null) goto L10;
        return false;
    L10:
        return true;
    L7:
        r5 = null;
        goto L8
    L11:
        return false;
    }

    public final ForsetiPageViewType w(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        ForsetiBaseChainFragment r3 = Z(r2);
        if ((r3 instanceof ForsetiChainFragment) == false) goto L5;
        ForsetiChainFragment r4 = (ForsetiChainFragment) r3;
    L6:
        if (r4 == null) goto L13;
        if (r4.V90(r4.m) == false) goto L10;
        ForsetiPageViewType r5 = r4.ca0().n();
    L11:
        if (r5 == null) goto L13;
        return r5;
    L10:
        r5 = ForsetiPageViewType.UNKNOWN_VIEW;
    L13:
        return ForsetiPageViewType.UNKNOWN_VIEW;
    L5:
        r4 = null;
        goto L6
    }

    public final void x(Function1<? super ForsetiMode, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.g.remove(r2);
    }

    public final void y(final Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "f");
        c0(r2, new ForsetiActivityChainManager$removeBizFragment$1(r2));
    }

    public final com.ss.android.lark.forseti.global.a K(Function1 r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.g.add(r2);
        if (r3 == false) goto L8;
        ForsetiMode r4 = this.f.a;
        if (r4 == ForsetiMode.Unknown) goto L8;
        r2.invoke(r4);
    L8:
        return new com.ss.android.lark.forseti.global.a(this, r2);
    }

    public final void R(Fragment r2, com.ss.android.lark.api.ui.a r3) {
        Intrinsics.checkNotNullParameter(r2, "f");
        Intrinsics.checkNotNullParameter(r3, "callback");
        ForsetiNode r4 = b0(r2);
        if (r4 == null) goto L10;
        ForsetiNodePiece r5 = r4.l;
        if (r5 == null) goto L11;
        List<com.ss.android.lark.api.ui.a> r6 = r5.k;
        if (r6 == null) goto L12;
        ((ArrayList) r6).clear();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void c0(Fragment r2, Function1<? super ForsetiChainFragment, Unit> r3) {
        ForsetiBaseChainFragment r4 = Z(r2);
        if ((r4 instanceof ForsetiChainFragment) == false) goto L5;
        ForsetiChainFragment r5 = (ForsetiChainFragment) r4;
    L6:
        if (r5 == null) goto L9;
        r3.invoke(r5);
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final Fragment h(Fragment r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "sourceFragment");
        Intrinsics.checkNotNullParameter(r5, "tag");
        ForsetiBaseChainFragment r6 = Z(r4);
        ForsetiChainHelper r1 = null;
        if ((r6 instanceof ForsetiChainFragment) == false) goto L5;
        ForsetiChainFragment r7 = (ForsetiChainFragment) r6;
    L6:
        if (r7 != null) goto L8;
        return null;
    L8:
        Fragment r8 = r7.Z90(r5);
        if (r8 != null) goto L11;
        return null;
    L11:
        Intrinsics.checkNotNullParameter(r8, "bizFragment");
        ForsetiChainHelper r9 = r7.j;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
    L15:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "bizFragment");
        ForsetiNode r10 = r1.c(r8);
        if (r10 == null) goto L27;
        Intrinsics.checkNotNullParameter(r8, "anchorFragment");
        if (r10.c(r8) == false) goto L27;
        Iterator r0 = com.larksuite.framework.utils.p.a(r10.i).iterator();
    L22:
        if (r0.hasNext() == false) goto L27;
        Fragment r2 = (Fragment) r0.next();
        if (Intrinsics.areEqual(r2, r8) == true) goto L25;
        r10.h(r2);
        goto L22
    L25:
        r10.h(r2);
    L27:
        return r8;
    L14:
        r1 = r9;
        goto L15
    L5:
        r7 = null;
        goto L6
    }

    public final void i(Fragment r3, ForsetiPlugin.b r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "callback");
        ForsetiBaseChainFragment r5 = Z(r3);
        if ((r5 instanceof ForsetiChainFragment) == false) goto L5;
        ForsetiChainFragment r6 = (ForsetiChainFragment) r5;
    L6:
        if (r6 == null) goto L9;
        Intrinsics.checkNotNullParameter(r4, "listener");
        r6.X90(r6.m, new k(r6, r4));
        return;
    L9:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void r(final ForsetiBaseChainFragment r4, FragmentManager r5) {
        Intrinsics.checkNotNullParameter(r4, "chain");
        Log.i("FST_ChainManager", "remove normal chain, chain: " + cib.e.a(r4));
        CollectionsKt.removeAll(this.c.entrySet(), new ForsetiActivityChainManager$removeForsetiNormalChain$1(r4));
        int r0 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.update_resumed_chain_in_tem_area_disabled") == false) goto L8;
        ForsetiChainFragment r1 = d0();
        if (r1 == null) goto L20;
        l0(r1);
    L20:
        CollectionsKt.removeAll(f0().entrySet(), new ForsetiActivityChainManager$removeForsetiNormalChain$4(r4));
        if (r5 == null) goto L24;
        r5.beginTransaction().remove(r4).commitAllowingStateLoss();
        Log.i("FST_ChainManager", "remove normal chain by outside fm.");
        return;
    L24:
        FragmentTransaction r6 = this.a.getSupportFragmentManager().beginTransaction();
        r6.remove(r4);
        r6.commitAllowingStateLoss();
        return;
    L8:
        if (Intrinsics.areEqual(d0(), r4) == true) goto L20;
        if ((r4 instanceof ForsetiChainFragment) == false) goto L12;
        ForsetiChainFragment r2 = (ForsetiChainFragment) r4;
    L13:
        if (r2 != null) goto L15;
    L17:
        ForsetiChainFragment r3 = d0();
        if (r3 == null) goto L20;
        Log.i("FST_ChainManager", "remove normal chain, chain is resumed, updateResumedChainSafely.");
        m0(r3);
        goto L20
    L15:
        if (r2.z == ForsetiChainState.RESUMED) goto L17;
        Log.i("FST_ChainManager", "remove normal chain, chain is not resumed, return.");
        goto L20
    L12:
        r2 = null;
        goto L13
    }

    public final void u(Fragment r2, com.ss.android.lark.api.ui.a r3) {
        Intrinsics.checkNotNullParameter(r2, "f");
        Intrinsics.checkNotNullParameter(r3, "callback");
        ForsetiNode r4 = b0(r2);
        if (r4 == null) goto L10;
        Intrinsics.checkNotNullParameter(r3, "callback");
        ForsetiNodePiece r5 = r4.l;
        if (r5 == null) goto L11;
        List<com.ss.android.lark.api.ui.a> r6 = r5.k;
        if (r6 == null) goto L12;
        ((ArrayList) r6).add(r3);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void z(Fragment r3, ForsetiPlugin.b r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "callback");
        ForsetiBaseChainFragment r5 = Z(r3);
        if ((r5 instanceof ForsetiChainFragment) == false) goto L5;
        ForsetiChainFragment r6 = (ForsetiChainFragment) r5;
    L6:
        if (r6 == null) goto L9;
        Intrinsics.checkNotNullParameter(r4, "listener");
        r6.X90(r6.m, new com.ss.android.lark.forseti.chain.d(r6, r4));
        return;
    L9:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public static ForsetiViewMode W(FragmentActivity r4, Integer r5, Integer r6) {
        int r0 = cib.c.a;
        if (r4 == null) goto L25;
        if (r5 == null) goto L25;
        if (r6 == null) goto L25;
        int r1 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.placeholder_exit_enabled") == false) goto L19;
        com.ss.android.lark.base.embedded.e r2 = cib.c.b(r4, r5.intValue());
        if (r5.intValue() < UIUtils.dp2px(r4, 636.0f)) goto L29;
        if (Math.min(r5.intValue(), r6.intValue()) < r2.b) goto L29;
        if (r5.intValue() < UIUtils.dp2px(r4, 840.0f)) goto L28;
        return ForsetiViewMode.EXPAND;
    L28:
        return ForsetiViewMode.MEDIUM;
    L29:
        return ForsetiViewMode.COMPACT;
    L19:
        if (r5.intValue() >= UIUtils.dp2px(r4, 636.0f)) goto L22;
        return ForsetiViewMode.COMPACT;
    L22:
        if (r5.intValue() >= UIUtils.dp2px(r4, 840.0f)) goto L32;
        return ForsetiViewMode.MEDIUM;
    L32:
        return ForsetiViewMode.EXPAND;
    L25:
        Log.e("ForsetiModeUtils", "calculateViewMode: activity is null, returns ForsetiViewMode.UNKNOWN");
        return ForsetiViewMode.UNKNOWN;
    }

    public final ForsetiBaseChainFragment G(final Fragment r10, final String r11, final Fragment r12, final uua.a r13) {
        Intrinsics.checkNotNullParameter(r10, "f");
        Intrinsics.checkNotNullParameter(r11, "tag");
        Intrinsics.checkNotNullParameter(r12, "prefixFragment");
        Intrinsics.checkNotNullParameter(r13, "options");
        Log.i("FST_ChainManager", "append fragment, f: " + cib.e.a(r10) + ", prefix: " + cib.e.a(r12));
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        c0(r12, new ForsetiActivityChainManager$appendBizFragmentWithNewForsetiNode$1(r0, r10, r11, r12, r13));
        if (r0.element != null) goto L6;
        Log.e("FST_ChainManager", "cann't find ForsetiChain with the prefixFragment:".concat(r12.getClass().getSimpleName()));
    L6:
        return (ForsetiBaseChainFragment) r0.element;
    }

    public final ForsetiChainFragment J(String r9, Fragment r10, String r11, com.ss.android.lark.api.bean.config.a r12) {
        Intrinsics.checkNotNullParameter(r9, "chainKey");
        Intrinsics.checkNotNullParameter(r10, "f");
        Intrinsics.checkNotNullParameter(r11, "tag");
        Intrinsics.checkNotNullParameter(r12, "forsetiChainConfig");
        return Y(r9, r10, r11, ForsetiChainType.TYPE_NORMAL, new uua.a(), r12);
    }

    public final ForsetiChainFragment f(String r9, Fragment r10, String r11, com.ss.android.lark.api.bean.config.a r12) {
        Intrinsics.checkNotNullParameter(r9, "chainKey");
        Intrinsics.checkNotNullParameter(r10, "f");
        Intrinsics.checkNotNullParameter(r11, "tag");
        Intrinsics.checkNotNullParameter(r12, "forsetiChainConfig");
        return Y(r9, r10, r11, ForsetiChainType.TYPE_NORMAL, new uua.a(), r12);
    }

    public final ForsetiBaseChainFragment n(final Fragment r10, final String r11, final Fragment r12, final uua.a r13) {
        Intrinsics.checkNotNullParameter(r10, "f");
        Intrinsics.checkNotNullParameter(r11, "tag");
        Intrinsics.checkNotNullParameter(r12, "prefixFragment");
        Intrinsics.checkNotNullParameter(r13, "options");
        Log.i("FST_ChainManager", "append fragment, f: " + cib.e.a(r10) + ", prefix: " + cib.e.a(r12));
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        c0(r12, new ForsetiActivityChainManager$appendBizFragmentWithNewFullForsetiNode$1(r0, r10, r11, r12, r13));
        if (r0.element != null) goto L6;
        Log.e("FST_ChainManager", "cann't find ForsetiChain with the prefixFragment:".concat(r12.getClass().getSimpleName()));
    L6:
        return (ForsetiBaseChainFragment) r0.element;
    }

    public final boolean L(String r18, Fragment r19, String r20, boolean r21, uua.a r22) {
        Intrinsics.checkNotNullParameter(r18, "chainKey");
        Intrinsics.checkNotNullParameter(r19, "f");
        Intrinsics.checkNotNullParameter(r20, "tag");
        Intrinsics.checkNotNullParameter(r22, "options");
        vua.a r0 = r22.c;
        if (r0 == null) goto L5;
        boolean r1 = r0.e;
    L6:
        ForsetiChainFragment r4 = a0(r18);
        StringBuilder r8 = new StringBuilder("openWithNewChain: ");
        r8.append(r1);
        r8.append(", existedStackChain:  ");
        if (r4 == null) goto L9;
        String r10 = cib.e.a(r4);
    L10:
        r8.append(r10);
        r8.append(", with chainKey = ");
        r8.append(r18);
        r8.append('.');
        Log.i("FST_ChainManager", r8.toString());
        if (r4 != null) goto L13;
    L20:
        r22.a = false;
        if (r21 == false) goto L23;
        ForsetiChainType r2 = ForsetiChainType.TYPE_HALF_STACK;
    L24:
        ForsetiChainFragment r3 = Y(r18, r19, r20, r2, r22, new com.ss.android.lark.api.bean.config.a(null, null, null, null, 63));
        Log.i("FST_ChainManager", "creates new stack chain: " + cib.e.a(r3));
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.forseti.chain.ForsetiChainFragment");
        r3.o = new e(this, r3);
        FragmentTransaction r5 = this.a.getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.content) == true) goto L28;
        r5.add(R.id.content, r3);
    L28:
        r5.commitAllowingStateLoss();
        KeyboardUtils.hideKeyboard(this.a);
        return true;
    L23:
        r2 = ForsetiChainType.TYPE_STACK;
        goto L24
    L13:
        if (r4.C == ForsetiStackChainStatus.DELETING) goto L20;
        Log.i("FST_ChainManager", "existedStackChain is not null, ready to append new node directly.");
        Fragment r11 = r4.ba0();
        if (r1 == true) goto L19;
        if (r11 == null) goto L19;
        r22.a = true;
        V(r19, r20, r11, r21, r22);
        return false;
    L19:
        Log.i("FST_ChainManager", "prefixFragment is null, creates new stack chain with chain key: " + r18 + ", and creates mock chain key for existedStackChain.");
        this.c.put("removeChainKey_".concat(r18), r4);
        this.c.remove(r18);
        goto L20
    L9:
        r10 = null;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public final void V(final Fragment r8, final String r9, final Fragment r10, final boolean r11, final uua.a r12) {
        Intrinsics.checkNotNullParameter(r8, "f");
        Intrinsics.checkNotNullParameter(r9, "tag");
        Intrinsics.checkNotNullParameter(r10, "anchorFragment");
        Intrinsics.checkNotNullParameter(r12, "options");
        c0(r10, new ForsetiActivityChainManager$addBizFragmentInExistedForsetiNode$1(r8, r9, r10, r11, r12));
    }

    public final ForsetiChainFragment Y(String r16, Fragment r17, String r18, ForsetiChainType r19, uua.a r20, com.ss.android.lark.api.bean.config.a r21) {
        int r2 = ForsetiChainFragment.E;
        ForsetiAttachInfo r3 = this.f;
        b r4 = (b) this.m.getValue();
        Intrinsics.checkNotNullParameter(r3, "attachInfo");
        Intrinsics.checkNotNullParameter(r19, "chainType");
        Intrinsics.checkNotNullParameter(r4, "forsetiStructureNotifier");
        Intrinsics.checkNotNullParameter(r21, "forsetiChainConfig");
        Intrinsics.checkNotNullParameter(r20, "forsetiInnerOptions");
        final ForsetiChainFragment r12 = new ForsetiChainFragment();
        Bundle r5 = new Bundle();
        r5.putParcelable("key_attach_info", r3);
        r5.putParcelable("chain_type", r19);
        r12.setArguments(r5);
        r12.t = r4;
        r12.u = r21;
        r12.v = r20;
        ForsetiChainType r13 = ForsetiChainType.TYPE_STACK;
        if (r19 != r13) goto L5;
    L6:
        Function0<Unit> r6 = new ForsetiActivityChainManager$createForsetiChainFragment$1(this, r12);
        Intrinsics.checkNotNullParameter(r6, "handler");
        r12.B = r6;
    L7:
        this.c.put(r16, r12);
        ForsetiChainType r14 = ForsetiChainType.TYPE_HALF_STACK;
        if (r19 != r14) goto L10;
        boolean r7 = true;
    L11:
        ForsetiChainFragment.T90(r12, r17, r18, null, false, r7, false, r20, 76);
        if (r21.f.a == false) goto L14;
        l0(r12);
    L14:
        if (r19 == r13) goto L16;
        if (r19 == r14) goto L16;
    L17:
        return r12;
    L16:
        Function2<ForsetiNode, Integer, Unit> r1 = new ForsetiActivityChainManager$createForsetiChainFragment$2(this, r12);
        Intrinsics.checkNotNullParameter(r1, "listener");
        ((ArrayList) r12.r).add(r1);
        goto L17
    L10:
        r7 = false;
        goto L11
    L5:
        if (r19 != ForsetiChainType.TYPE_HALF_STACK) goto L7;
        goto L6
    }
}
