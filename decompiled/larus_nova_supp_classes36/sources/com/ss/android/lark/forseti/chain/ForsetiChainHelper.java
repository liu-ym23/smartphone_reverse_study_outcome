package com.ss.android.lark.forseti.chain;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.api.bean.ForsetiChainType;
import com.ss.android.lark.api.bean.ForsetiMode;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.api.bean.config.ForsetiPageType;
import com.ss.android.lark.api.ui.ForsetiPlaceHolderFragment;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.global.ForsetiAttachInfo;
import com.ss.android.lark.forseti.node.ForsetiNode;
import com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingHelper;
import com.ss.android.lark.forseti.widget.ForsetiNodeViewGroup;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroup;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroupCompat;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.ContextsKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForsetiChainHelper {
    public static final /* synthetic */ int p = 0;
    public final FragmentManager a;
    public final ViewGroup b;
    public final com.ss.android.lark.forseti.global.e c;
    public final ForsetiChainType d;
    public final ForsetiAttachInfo e;
    public final ForsetiColumnsDraggingHelper f;
    public final ForsetiNode g;
    public Function2<? super ForsetiNode, ? super Integer, Unit> h;
    public ForsetiNode i;
    public ForsetiNode j;
    public ForsetiWidth k;
    public boolean l;
    public boolean m;
    public final boolean n;
    public final Lazy o;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        ForsetiNode r0 = this.i;
        boolean r2 = true;
        boolean r3 = false;
        if (r0.j == false) goto L5;
    L7:
        com.ss.android.lark.forsetiutils.c r1 = (Fragment) CollectionsKt.lastOrNull(r0.i);
        ForsetiNode r5 = null;
        if ((r1 instanceof com.ss.android.lark.forsetiutils.c) == false) goto L10;
        com.ss.android.lark.forsetiutils.c r4 = r1;
    L11:
        if (r4 != null) goto L13;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == true) goto L63;
        Fragment r7 = (Fragment) CollectionsKt.lastOrNull(r0.i);
        if (r7 == null) goto L42;
        com.ss.android.lark.api.bean.config.a r8 = r0.a.f;
        if (r8 == null) goto L23;
        com.ss.android.lark.api.bean.config.b r9 = r8.f;
    L25:
        if ((r7 instanceof ForsetiPlaceHolderFragment) == true) goto L27;
    L43:
        if (r9 != null) goto L45;
    L47:
        boolean r10 = false;
    L48:
        if (r10 == false) goto L59;
        ForsetiNode r11 = r0.d;
        if (r11 == null) goto L52;
        r5 = r11.d;
    L52:
        if (r5 != null) goto L54;
        boolean r12 = true;
    L55:
        if (r12 == false) goto L59;
        Log.i("FST_Node", "exitSplitWindow, " + cib.e.a(r7));
        com.ss.android.lark.api.ui.k r13 = r9.g;
        if (r13 == null) goto L59;
        r13.exitSplitWindow(r0.a.getActivity(), r7, "");
        goto L59
    L54:
        r12 = false;
    L59:
        r0.h(r7);
        boolean r14 = true;
    L60:
        if (r14 == true) goto L63;
    L62:
        boolean r15 = false;
    L64:
        if (r15 == true) goto L74;
        ForsetiMode r16 = this.e.a;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        if (r16 == ForsetiMode.Regular) goto L69;
        r2 = false;
    L69:
        if (r2 == true) goto L73;
        r3 = f();
    L73:
        return r3;
    L74:
        return r15;
    L45:
        if (r9.f != true) goto L47;
        r10 = true;
        goto L48
    L27:
        if (fib.a.a() == true) goto L29;
    L40:
        boolean r17 = true;
    L41:
        if (r17 == false) goto L43;
    L29:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti_back_specify_fragment_disabled") == true) goto L40;
        if (r9 == null) goto L36;
        com.ss.android.lark.api.ui.k r18 = r9.g;
        if (r18 == null) goto L36;
        if (r18.isInSplitWindowState() != true) goto L36;
        boolean r19 = true;
    L37:
        if (r19 == false) goto L40;
        r17 = false;
    L36:
        r19 = false;
        goto L37
    L23:
        r9 = null;
    L42:
        r14 = false;
    L63:
        r15 = true;
        goto L64
    L13:
        if (r4.B60() != true) goto L15;
        r6 = true;
        goto L16
    L10:
        r4 = null;
        goto L11
    L5:
        if (((ArrayList) r0.i).size() > 1) goto L7;
        goto L7
    }

    public final int e() {
        final Ref.IntRef r0 = new Ref.IntRef();
        Function1<ForsetiNode, Unit> r1 = new ForsetiChainHelper$getNodeCount$1(r0);
        Intrinsics.checkNotNullParameter(r1, "callback");
        ForsetiNode r2 = this.g.e;
    L3:
        if (r2 == null) goto L6;
        r1.invoke(r2);
        r2 = r2.e;
        goto L3
    L6:
        return r0.element;
    }

    public final boolean f() {
        if (Intrinsics.areEqual(this.g.e, this.i) == false) goto L6;
        return false;
    L6:
        g(this.i.d);
        int r0 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.clear_top_callback_disabled") == true) goto L15;
        ForsetiNode r1 = this.i.d;
        if (r1 == null) goto L16;
        Function2<? super ForsetiNode, ? super Integer, Unit> r2 = this.h;
        if (r2 == null) goto L17;
        r2.invoke(r1, Integer.valueOf(e()));
        return true;
    L17:
        return true;
    L16:
        return true;
    L15:
        return true;
    }

    public static ForsetiWidth d(ForsetiNode r2) {
        if (r2 == null) goto L7;
        ForsetiNodeViewGroup r3 = r2.h;
        if (r3 == null) goto L7;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
    L9:
        if ((r4 instanceof ForsetiNormalChainViewGroup.b) == false) goto L11;
        ForsetiNormalChainViewGroup.b r5 = (ForsetiNormalChainViewGroup.b) r4;
    L12:
        if (r5 != null) goto L14;
        return null;
    L14:
        return r5.a;
    L11:
        r5 = null;
    L7:
        r4 = null;
        goto L9
    }

    public final ForsetiNode c(final Fragment r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        Function1<ForsetiNode, Boolean> r1 = new ForsetiChainHelper$findForsetiNode$1(r4);
        Intrinsics.checkNotNullParameter(r1, "action");
        ForsetiNode r5 = this.g.e;
    L6:
        if (r5 == null) goto L14;
        if (((Boolean) r1.invoke(r5)).booleanValue() == true) goto L11;
        r5 = r5.e;
        goto L6
    L11:
        return r5;
    L14:
        return null;
    }

    public final void g(ForsetiNode r5) {
        StringBuilder r0 = new StringBuilder("removeNodeUntilAnchor, anchor: ");
        if (r5 == null) goto L5;
        int r1 = r5.hashCode();
    L6:
        r0.append(r1);
        Log.i("FST_ChainHelper", r0.toString());
        if (r5 != null) goto L9;
        return;
    L9:
        ForsetiNode r2 = this.i;
    L10:
        if (r2 == null) goto L20;
        if (Intrinsics.areEqual(r2, r5) == true) goto L20;
        ForsetiNode r3 = r2.d;
        if (r3 == null) goto L16;
        r3.e = null;
    L16:
        r2.d = null;
        r2.g(this.a);
        if (Intrinsics.areEqual(r2, this.j) == false) goto L19;
        this.j = null;
    L19:
        r2 = r3;
    L20:
        this.i = r5;
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final boolean a(Integer r7, boolean r8) {
        if (r7 == null) goto L4;
        int r9 = r7.intValue();
    L5:
        ViewGroup r0 = this.b;
        ForsetiViewMode r2 = null;
        if ((r0 instanceof ForsetiNormalChainViewGroupCompat) == false) goto L8;
        ForsetiNormalChainViewGroupCompat r1 = (ForsetiNormalChainViewGroupCompat) r0;
    L9:
        boolean r3 = true;
        if (r1 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r8 == false) goto L36;
        com.ss.android.lark.api.bean.config.a r10 = this.c.f;
        if (r10 == null) goto L23;
        com.ss.android.lark.api.bean.config.b r5 = r10.f;
        if (r5 == null) goto L23;
        if (r5.c == true) goto L23;
        boolean r6 = true;
    L25:
        if ((!r6) == false) goto L34;
        if (r10 == null) goto L28;
        ForsetiPageType r11 = r10.c;
    L30:
        if (r11 != ForsetiPageType.ALL_PAGES_FULLSCREEN) goto L32;
        boolean r12 = true;
    L33:
        if (r12 == false) goto L36;
    L32:
        r12 = false;
        goto L33
    L28:
        r11 = null;
    L34:
        return false;
    L23:
        r6 = false;
    L36:
        if (((Boolean) this.o.getValue()).booleanValue() == true) goto L50;
        sua.a r13 = (sua.a) ApiUtils.getApi(sua.a.class);
        FragmentActivity r14 = ContextsKt.findActivity(this.b);
        if ((r14 instanceof FragmentActivity) == false) goto L40;
        FragmentActivity r15 = r14;
    L41:
        tua.b r16 = r13.tryGetChainManager(r15);
        if (r16 == null) goto L45;
        r2 = r16.H();
    L45:
        if (r2 != ForsetiViewMode.EXPAND) goto L48;
        if (r9 < 2) goto L48;
    L49:
        Log.i("FST_ChainHelper", "shouldSupportDragging: " + r3);
        return r3;
    L48:
        r3 = false;
        goto L49
    L40:
        r15 = null;
        goto L41
    L50:
        if (r4 == true) goto L53;
        if (r9 < 2) goto L53;
        return true;
    L53:
        return false;
    L12:
        if (r1.a != true) goto L14;
        r4 = true;
        goto L15
    L8:
        r1 = null;
        goto L9
    L4:
        r9 = this.b.getChildCount();
        goto L5
    }

    public ForsetiChainHelper(FragmentManager r2, ViewGroup r3, com.ss.android.lark.forseti.global.e r4, ForsetiChainType r5) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "parentViewGroup");
        Intrinsics.checkNotNullParameter(r4, "forsetiContext");
        Intrinsics.checkNotNullParameter(r5, "chainType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r4.b;
        this.f = r4.d;
        ForsetiNode r6 = new ForsetiNode(r4, r5);
        this.g = r6;
        this.i = r6;
        this.l = true;
        this.n = true;
        this.o = LazyKt.lazy(ForsetiChainHelper$draggingViewDisabled$2.INSTANCE);
    }
}
