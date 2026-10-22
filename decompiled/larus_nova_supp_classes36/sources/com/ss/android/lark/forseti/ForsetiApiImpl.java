package com.ss.android.lark.forseti;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.api.ui.e;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.chain.ForsetiChainFragment;
import com.ss.android.lark.forseti.global.ForsetiActivityChainManager;
import com.ss.android.lark.forseti.global.ForsetiViewModel;
import com.ss.android.lark.forseti.node.ForsetiNodeFragment;
import com.ss.android.lark.forseti.util.animation.ForsetiAnimatorLauncher;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tua.b;
import tua.d;
import yua.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(sua.a.class)
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u001b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016¨\u0006#"}, d2 = {"Lcom/ss/android/lark/forseti/ForsetiApiImpl;", "Lcom/ss/android/lark/api/IForsetiApi;", "<init>", "()V", "getChainManager", "Lcom/ss/android/lark/api/api/IForsetiActivityChainManager;", "activity", "Landroidx/fragment/app/FragmentActivity;", "tryGetChainManager", "isRunningInForseti", "", "initChainManager", "", "releaseChainManager", "getFragmentLifecycleOwnerInForseti", "Landroidx/lifecycle/ViewModelStoreOwner;", "fragment", "Landroidx/fragment/app/Fragment;", "getFragmentManagerInForseti", "Landroidx/fragment/app/FragmentManager;", "getResumedChainRootFragmentContainerId", "", "(Landroidx/fragment/app/FragmentActivity;)Ljava/lang/Integer;", "getScreenOrientationHandle", "Lcom/ss/android/lark/api/api/IScreenOrientationHandle;", "getBizFragmentFromNodeFragment", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getForegroundForsetiNodePieceFragment", "addNodeSwitchAnimListener", "listener", "Lcom/ss/android/lark/api/ui/IForsetiNodeSwitchAnimListener;", "removeNodeSwitchAnimListener", "Companion", "ScreenOrientationHandleImpl", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForsetiApiImpl implements sua.a {
    public static final a Companion = null;
    private static final String TAG = "FST_ForsetiApiImpl";

    public static final class ScreenOrientationHandleImpl implements d {
        public final Fragment a;
        public final WeakReference<Fragment> b;

        public final int a() {
            Fragment r0 = this.b.get();
            if (r0 != null) goto L5;
            return -1;
        L5:
            gib.a r2 = r0.getActivity();
            if ((r2 instanceof gib.a) == false) goto L8;
            gib.a r3 = r2;
        L9:
            if (r3 != null) goto L15;
            FragmentActivity r1 = r0.getActivity();
            if (r1 != null) goto L14;
            return -1;
        L14:
            return r1.getRequestedOrientation();
        L15:
            return r3.getExternalRequestedOrientation(r0);
        L8:
            r3 = null;
            goto L9
        }

        public ScreenOrientationHandleImpl(Fragment r3) {
            Intrinsics.checkNotNullParameter(r3, "fragment");
            this.a = r3;
            this.b = new WeakReference(this.a);
            r3.getLifecycle().addObserver(new AnonymousClass1(this));
        }

        public final void b(int r4) {
            Fragment r0 = this.b.get();
            if (r0 != null) goto L5;
            return;
        L5:
            gib.a r1 = r0.getActivity();
            if ((r1 instanceof gib.a) == false) goto L8;
            gib.a r2 = r1;
        L9:
            if (r2 == null) goto L12;
            r2.setExternalRequestedOrientation(r0, r4);
            return;
        L12:
            return;
        L8:
            r2 = null;
            goto L9
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ForsetiApiImpl() {
    }

    public void addNodeSwitchAnimListener(e r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Lazy r1 = ForsetiAnimatorLauncher.a;
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ArrayList) ForsetiAnimatorLauncher.b).add(r3);
    }

    public ArrayList<Fragment> getBizFragmentFromNodeFragment(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        if ((r5 instanceof ForsetiNodeFragment) == false) goto L6;
        ForsetiNodeFragment r6 = (ForsetiNodeFragment) r5;
        r6.getClass();
        return new ArrayList(r6.e.values());
    L6:
        if ((r5 instanceof ForsetiChainFragment) == false) goto L21;
        List r7 = ((ForsetiChainFragment) r5).getChildFragmentManager().getFragments();
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L28;
        Fragment r2 = (Fragment) r8.next();
        if ((r2 instanceof ForsetiNodeFragment) == false) goto L13;
        ForsetiNodeFragment r3 = (ForsetiNodeFragment) r2;
    L14:
        if (r3 == null) goto L16;
        ArrayList r4 = new ArrayList(r3.e.values());
    L17:
        if (r4 == null) goto L9;
        r0.add(r4);
        goto L9
    L16:
        r4 = null;
        goto L17
    L13:
        r3 = null;
        goto L14
    L28:
        return new ArrayList(CollectionsKt.flatten(r0));
    L21:
        return null;
    }

    public b getChainManager(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        b r3 = ((ForsetiViewModel) new ViewModelProvider(r2).get(ForsetiViewModel.class)).getForsetiGlobalChainManager();
        if (r3 == null) goto L6;
        return r3;
    L6:
        throw new IllegalStateException("should be initialized before use");
    }

    public Fragment getForegroundForsetiNodePieceFragment(FragmentActivity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        yua.a r5 = getChainManager(r4).q().a();
        if (r5 != null) goto L6;
        Log.e(TAG, "No topFragmentChain found.");
        return null;
    L6:
        c r6 = (c) CollectionsKt.lastOrNull(r5.a());
        if (r6 == null) goto L11;
        List r7 = r6.getPieces();
        if (r7 == null) goto L11;
        yua.b r8 = (yua.b) CollectionsKt.lastOrNull(r7);
    L12:
        if (r8 != null) goto L15;
        Log.e(TAG, "No ForsetiNodePiece found.");
        return null;
    L15:
        int r0 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.node_piece_disabled") == false) goto L21;
        Fragment r9 = r8.a();
        if ((r9 instanceof ForsetiNodeFragment) == true) goto L23;
        return null;
    L23:
        return (ForsetiNodeFragment) r9;
    L21:
        return r8.b();
    L11:
        r8 = null;
        goto L12
    }

    public Integer getResumedChainRootFragmentContainerId(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        yua.a r3 = getChainManager(r2).q().a();
        if (r3 == null) goto L15;
        List r4 = r3.a();
        if (r4 == null) goto L15;
        c r5 = (c) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L15;
        List r6 = r5.getPieces();
        if (r6 == null) goto L15;
        yua.b r7 = (yua.b) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L15;
        Fragment r8 = r7.getFragment();
        if (r8 == null) goto L15;
        return Integer.valueOf(r8.getId());
    L15:
        return null;
    }

    public d getScreenOrientationHandle(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return new ScreenOrientationHandleImpl(r2);
    }

    public void initChainManager(FragmentActivity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        ForsetiViewModel r0 = (ForsetiViewModel) new ViewModelProvider(r4).get(ForsetiViewModel.class);
        b r1 = r0.getForsetiGlobalChainManager();
        if (r1 == null) goto L5;
        r1.clear();
    L5:
        StringBuilder r2 = new StringBuilder("init vm=");
        r2.append(r0.hashCode());
        r2.append(" and clear?=");
        if (r0.getForsetiGlobalChainManager() == null) goto L8;
        boolean r3 = true;
    L9:
        r2.append(r3);
        Log.i(TAG, r2.toString());
        r0.setForsetiGlobalChainManager(new ForsetiActivityChainManager(r4));
        return;
    L8:
        r3 = false;
        goto L9
    }

    public boolean isRunningInForseti(FragmentActivity r1) {
        if (tryGetChainManager(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void releaseChainManager(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        ForsetiViewModel r4 = (ForsetiViewModel) new ViewModelProvider(r3).get(ForsetiViewModel.class);
        b r0 = r4.getForsetiGlobalChainManager();
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        StringBuilder r1 = new StringBuilder("release vm=");
        r1.append(r4.hashCode());
        r1.append(" and clear?=");
        if (r4.getForsetiGlobalChainManager() == null) goto L8;
        boolean r2 = true;
    L9:
        r1.append(r2);
        Log.i(TAG, r1.toString());
        r4.setForsetiGlobalChainManager(null);
        return;
    L8:
        r2 = false;
        goto L9
    }

    public void removeNodeSwitchAnimListener(e r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Lazy r1 = ForsetiAnimatorLauncher.a;
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ArrayList) ForsetiAnimatorLauncher.b).remove(r3);
    }

    public b tryGetChainManager(FragmentActivity r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((ForsetiViewModel) new ViewModelProvider(r2).get(ForsetiViewModel.class)).getForsetiGlobalChainManager();
    }

    public ViewModelStoreOwner getFragmentLifecycleOwnerInForseti(FragmentActivity r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        if (ForsetiConfig.a(r2) == true) goto L6;
        return r2;
    L6:
        return getChainManager(r2).q().b(r2, r3);
    }

    public FragmentManager getFragmentManagerInForseti(FragmentActivity r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        if (ForsetiConfig.a(r2) == true) goto L7;
        return r2.getSupportFragmentManager();
    L7:
        return getChainManager(r2).q().c(r2, r3);
    }
}
