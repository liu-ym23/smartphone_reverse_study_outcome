package com.ss.android.lark.forseti.node;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.ss.android.lark.api.bean.ForsetiMode;
import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.api.bean.NodePieceCustomState;
import com.ss.android.lark.api.ui.ForsetiPlaceHolderFragment;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.chain.ForsetiChainFragment;
import com.ss.android.lark.forseti.global.ForsetiActivityChainManager;
import com.ss.android.lark.forseti.node.piece.ForsetiNodePiece;
import com.ss.android.lark.forseti.widget.MinChildHeightFrameLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.insets.AndroidQInsetsDispatchCompat;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0001J\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0001J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u0011*\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u001e\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0#J\b\u0010$\u001a\u0004\u0018\u00010\u0011J\u0010\u0010%\u001a\u0004\u0018\u00010\u00112\u0006\u0010&\u001a\u00020\u0001J\u0006\u0010'\u001a\u00020\rJ\u0006\u0010(\u001a\u00020\rJ\b\u0010)\u001a\u00020\rH\u0016J\b\u0010*\u001a\u00020\rH\u0016J\b\u0010+\u001a\u00020 H\u0002J\b\u0010,\u001a\u00020\rH\u0016J\b\u0010-\u001a\u00020\rH\u0016J\b\u0010.\u001a\u00020\rH\u0016J\u0010\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\rH\u0016J\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u000104j\b\u0012\u0004\u0012\u00020\u0001`5J\b\u00106\u001a\u00020\u0016H\u0016R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R-\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001`\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00068"}, d2 = {"Lcom/ss/android/lark/forseti/node/ForsetiNodeFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "forsetiNodePieceStack", "", "Lcom/ss/android/lark/forseti/node/piece/ForsetiNodePiece;", "getForsetiNodePieceStack", "()Ljava/util/List;", "forsetiNodePieceTagHashMap", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "getForsetiNodePieceTagHashMap", "()Ljava/util/LinkedHashMap;", "putUniqueTag", "uniqueTag", "f", "removeTag", "findTopForsetiNodePiece", "pushForsetiNodePieceStack", "", "forsetiNodePiece", "commitFragment", "Lkotlin/Function0;", "popForsetiNodePieceStack", "prepareRemoveTargetFragment", "targetFragment", "topForsetiNodePieceMoveToOnResume", "topForsetiNodePieceMoveToOnStop", "onStart", "onResume", "dispatchOnResumeOrNot", "onPause", "onStop", "onDestroy", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "getBizFragments", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "toString", "Companion", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForsetiNodeFragment extends Fragment {
    public final List<ForsetiNodePiece> d;
    public final LinkedHashMap<String, Fragment> e;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        ForsetiNodePiece r2 = (ForsetiNodePiece) CollectionsKt.lastOrNull(this.d);     // Catch: Throwable -> L14
        if (r2 == null) goto L6;
        Fragment r3 = r2.g;     // Catch: Throwable -> L14
    L8:
        if ((r3 instanceof ForsetiPlaceHolderFragment) == true) goto L10;
    L12:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r4) == true) goto L21;
        r0 = r4;
    L21:
        return super.toString() + "->" + ((Fragment) r0);
    L10:
        if ((!((ForsetiPlaceHolderFragment) r3).getChildFragmentManager().getFragments().isEmpty()) == false) goto L12;
        r3 = (Fragment) CollectionsKt.last(((ForsetiPlaceHolderFragment) r3).getChildFragmentManager().getFragments());     // Catch: Throwable -> L14
        goto L12
    L6:
        r3 = null;
    L14:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public ForsetiNodeFragment() {
        this.d = new ArrayList();
        this.e = new LinkedHashMap();
    }

    public final void onDestroy() {
        super.onDestroy();
        cib.d.a("onDestroy");
        Iterator r0 = ((ArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ForsetiNodePiece) r0.next()).onDestroy();
        goto L4
    L6:
        ((ArrayList) this.d).clear();
        this.e.clear();
    }

    public final void onLowMemory() {
        super.onLowMemory();
        cib.d.a("onLowMemory");
        Iterator r0 = ((ArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ForsetiNodePiece) r0.next()).i().dispatchLowMemory();
        goto L4
    }

    public final void onPause() {
        super.onPause();
        cib.d.a("onPause");
        ForsetiNodePiece r0 = S90(this.d);
        if (r0 == null) goto L6;
        r0.onPause();
        return;
    }

    public final void onResume() {
        super.onResume();
        cib.d.a("onResume");
        int r0 = com.ss.android.lark.forseti.global.b.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.dispatch_resume_optimizeV2") == true) goto L47;
        sua.a r1 = (sua.a) ApiUtils.getApi(sua.a.class);
        FragmentActivity r2 = getContext();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        tua.b r3 = r1.tryGetChainManager(r2);
        ForsetiNodeFragment r4 = null;
        if (r3 == null) goto L7;
        ForsetiChainFragment r5 = r3.v();
    L9:
        if ((r5 instanceof ForsetiChainFragment) == true) goto L12;
        r5 = null;
    L12:
        if (r5 != null) goto L15;
    L42:
        boolean r6 = true;
    L43:
        if (r6 == false) goto L51;
        ForsetiNodePiece r7 = S90(this.d);
        if (r7 == null) goto L52;
        r7.onResume();
        return;
    L52:
        return;
    L51:
        return;
    L15:
        if (r3.T() != ForsetiMode.Compact) goto L20;
        ForsetiNode r8 = r5.aa0();
        if (r8 == null) goto L19;
        r4 = r8.f();
    L19:
        r6 = Intrinsics.areEqual(r4, this);
        goto L43
    L20:
        ForsetiNode r9 = r5.aa0();
        if (r9 == null) goto L23;
        ForsetiWidth r10 = r9.e();
    L25:
        if (r10 != ForsetiWidth.FULL) goto L27;
        r6 = Intrinsics.areEqual(r9.f(), this);
        goto L43
    L27:
        ForsetiNode r11 = r5.aa0();
        if (r11 == null) goto L30;
        ForsetiNodeFragment r12 = r11.f();
    L31:
        ForsetiNode r13 = r5.aa0();
        if (r13 == null) goto L37;
        ForsetiNode r14 = r13.d;
        if (r14 == null) goto L37;
        r4 = r14.f();
    L37:
        if (Intrinsics.areEqual(r4, this) == true) goto L42;
        if (Intrinsics.areEqual(r12, this) == true) goto L42;
        r6 = false;
        goto L43
    L30:
        r12 = null;
        goto L31
    L23:
        r10 = null;
        goto L25
    L7:
        r5 = null;
        goto L9
    L47:
        ForsetiNodePiece r15 = S90(this.d);
        if (r15 == null) goto L54;
        r15.onResume();
        return;
    }

    public final void onStart() {
        super.onStart();
        cib.d.a("onStart");
        ForsetiNodePiece r0 = S90(this.d);
        if (r0 == null) goto L6;
        r0.onStart();
        return;
    }

    public final void onStop() {
        super.onStop();
        cib.d.a("onStop");
        ForsetiNodePiece r0 = S90(this.d);
        if (r0 == null) goto L6;
        r0.onStop();
        return;
    }

    public static ForsetiNodePiece S90(List r0) {
        return (ForsetiNodePiece) CollectionsKt.lastOrNull(r0);
    }

    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        super.onConfigurationChanged(r5);
        cib.d.a("onConfigurationChanged");
        Iterator r1 = ((ArrayList) this.d).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ForsetiNodePiece r2 = (ForsetiNodePiece) r1.next();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        r2.i().noteStateNotSaved();
        r2.i().dispatchConfigurationChanged(r5);
        goto L4
    }

    public final void T90(ForsetiNodePiece r5, Function0 r6) {
        Intrinsics.checkNotNullParameter(r6, "commitFragment");
        ForsetiNodePiece r0 = (ForsetiNodePiece) CollectionsKt.lastOrNull(this.d);
        if (r5 == null) goto L10;
        r5.i().attachHost(r5.j);
        Fragment r1 = r5.l();
        int r2 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.slardar_crash_disabled") == false) goto L7;
    L8:
        r1.setArguments(r5.i);
    L9:
        r5.getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        r5.i().dispatchCreate();
        r5.i().dispatchActivityCreated();
        goto L10
    L7:
        if (r1.isStateSaved() == true) goto L9;
    L10:
        if (r5 == null) goto L12;
        r5.onStart();
    L12:
        if (r5 == null) goto L14;
        r5.onResume();
    L14:
        if (r5 == null) goto L16;
        ((ArrayList) this.d).add(r5);
    L16:
        r6.invoke();
        if (r0 == null) goto L19;
        r0.onPause();
    L19:
        if (r0 == null) goto L24;
        Intrinsics.checkNotNullParameter(NodePieceCustomState.COVERED_BY_FORSETI, "state");
        int r7 = ForsetiNodePiece.y;
        ForsetiActivityChainManager.b r8 = r0.p;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("forsetiStructureNotifier");
        r8 = null;
    L23:
        r8.a();
    L24:
        if (r0 == null) goto L27;
        r0.onStop();
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        Log.i("FST_NodeFragment", "onViewCreated.");
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        MinChildHeightFrameLayout r4 = new MinChildHeightFrameLayout(r1.getContext(), null);
        AndroidQInsetsDispatchCompat.a(r4);
        r4.setId(2131373231);
        return r4;
    }
}
