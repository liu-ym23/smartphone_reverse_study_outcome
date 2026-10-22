package com.ss.android.lark.forseti.node.piece;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.api.bean.ForsetiMode;
import com.ss.android.lark.api.bean.NodePieceCustomState;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.global.ForsetiActivityChainManager;
import com.ss.android.lark.forseti.node.ForsetiNodeFragment;
import com.ss.android.lark.forseti.widget.MinChildHeightFrameLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.insets.AndroidQInsetsDispatchCompat;
import com.ss.android.lark.log.Log;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000é\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001V\u0018\u0000 \u0086\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\b\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010Z\u001a\u00020\u0007H\u0002J\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00070\\J\u001c\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010b\u001a\u00020cH\u0016J\u0012\u0010d\u001a\u00020c2\b\u0010e\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010f\u001a\u00020c2\u0006\u0010g\u001a\u00020\u000e2\u0006\u0010h\u001a\u00020\u0007H\u0002J\u0010\u0010i\u001a\u00020c2\u0006\u0010g\u001a\u00020\u000eH\u0002J\u0010\u0010j\u001a\u00020c2\u0006\u0010k\u001a\u00020\u0017H\u0016J\b\u0010l\u001a\u00020cH\u0002J\u0018\u0010m\u001a\u00020*2\u0006\u0010n\u001a\u00020@2\u0006\u0010o\u001a\u00020pH\u0002J\u0010\u0010q\u001a\u00020c2\u0006\u0010r\u001a\u00020\u000eH\u0002J\b\u0010s\u001a\u00020*H\u0002J\b\u0010t\u001a\u00020cH\u0016J\b\u0010u\u001a\u00020cH\u0016J\b\u0010v\u001a\u00020cH\u0016J\b\u0010w\u001a\u00020cH\u0016J\b\u0010x\u001a\u00020cH\u0016J\b\u0010y\u001a\u00020cH\u0016J\u0010\u0010z\u001a\u00020c2\u0006\u0010{\u001a\u00020\u0017H\u0016J\u0010\u0010|\u001a\u00020c2\u0006\u0010}\u001a\u00020~H\u0016J\u0011\u0010\u007f\u001a\u00020c2\u0007\u0010\u0080\u0001\u001a\u00020*H\u0016J\t\u0010\u0081\u0001\u001a\u00020cH\u0016J\t\u0010\u0082\u0001\u001a\u00020*H\u0016J\u0010\u0010\u0083\u0001\u001a\u00020c2\u0007\u0010o\u001a\u00030\u0084\u0001J\t\u0010\u0085\u0001\u001a\u00020cH\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR9\u0010\f\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103R\u001b\u00106\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u00105\u001a\u0004\b7\u0010\u000bR\u000e\u00109\u001a\u00020:X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u00105\u001a\u0004\bA\u0010BR\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020F0EX\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010G\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I0Hj\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I`KX\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010L\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0I0Hj\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0I`KX\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010N\u001a6\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0O0I0Hj\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0O0I`KX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010P\u001a\u0004\u0018\u00010Q@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0010\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0004\n\u0002\u0010WR\u000e\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008a\u0001"}, d2 = {"Lcom/ss/android/lark/forseti/node/piece/ForsetiNodePiece;", "Lcom/ss/android/lark/forseti/node/piece/ForsetiNodeBasePiece;", "Lcom/ss/android/lark/forseti/node/piece/IForsetiPieceLifecycle;", "Lcom/ss/android/lark/api/util/IForsetiNodePieceCustomStateMonitor;", "context", "Landroid/content/Context;", "rootFragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;)V", "getRootFragment", "()Landroidx/fragment/app/Fragment;", "rootFragmentFactory", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "className", "getRootFragmentFactory", "()Lkotlin/jvm/functions/Function1;", "setRootFragmentFactory", "(Lkotlin/jvm/functions/Function1;)V", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "setArguments", "(Landroid/os/Bundle;)V", "forsetiNodeFragment", "Lcom/ss/android/lark/forseti/node/ForsetiNodeFragment;", "getForsetiNodeFragment", "()Lcom/ss/android/lark/forseti/node/ForsetiNodeFragment;", "setForsetiNodeFragment", "(Lcom/ss/android/lark/forseti/node/ForsetiNodeFragment;)V", "fragmentRemovingListener", "", "Lcom/ss/android/lark/api/ui/IForsetiFragmentRemovingListener;", "getFragmentRemovingListener", "()Ljava/util/List;", "setFragmentRemovingListener", "(Ljava/util/List;)V", "isDestroyed", "", "usePageTransformAnimation", "getUsePageTransformAnimation", "()Z", "setUsePageTransformAnimation", "(Z)V", "fragmentController", "Landroidx/fragment/app/FragmentController;", "getFragmentController", "()Landroidx/fragment/app/FragmentController;", "fragmentController$delegate", "Lkotlin/Lazy;", "forsetiNodePieceFragment", "getForsetiNodePieceFragment", "forsetiNodePieceFragment$delegate", "forsetiStructureNotifier", "Lcom/ss/android/lark/forseti/global/ForsetiActivityChainManager$ForsetiStructureNotifier;", "placeMode", "Lcom/ss/android/lark/api/bean/ForsetiMode;", "notifyUserLifecycleChangedCallbacks", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "fragmentManager$delegate", "mLaunchedFragments", "Ljava/util/ArrayDeque;", "Lcom/ss/android/lark/forseti/node/piece/ForsetiNodePiece$ForsetiLaunchFragmentInfos;", "mStartActivityForResults", "Ljava/util/HashMap;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "Lkotlin/collections/HashMap;", "mStartIntentSenderForResults", "Landroidx/activity/result/IntentSenderRequest;", "mRequestPermissions", "", "value", "Lcom/ss/android/lark/api/bean/ForsetiInnerOptions;", "options", "getOptions", "()Lcom/ss/android/lark/api/bean/ForsetiInnerOptions;", "fragmentLifecycleCallback", "com/ss/android/lark/forseti/node/piece/ForsetiNodePiece$fragmentLifecycleCallback$1", "Lcom/ss/android/lark/forseti/node/piece/ForsetiNodePiece$fragmentLifecycleCallback$1;", "dispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "requireFragment", "getBizFragments", "", "createView", "Landroid/view/View;", "containerId", "", "tag", "removeAllViews", "", "onCreate", "savedInstanceState", "registerStartActivityForResult", "who", "fragment", "unregisterStartActivityForResult", "onSaveInstanceState", "outState", "markFragmentsCreated", "markState", "manager", "state", "Landroidx/lifecycle/Lifecycle$State;", "dispatchedFragmentLogger", "lifeCycleEvent", "executeLifecycleAction", "onStart", "onResume", "onPause", "onStop", "onDestroy", "onActivityResult", "onNewIntent", "bundle", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMultiWindowModeChanged", "isInMultiWindowMode", "onLowMemory", "isCoveredByForsetiNode", "setNodePieceCustomState", "Lcom/ss/android/lark/api/bean/NodePieceCustomState;", "clearCache", "Companion", "ForsetiNodePieceFragment", "ForsetiNodePieceHostCallBacks", "ForsetiLaunchFragmentInfos", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForsetiNodePiece extends ForsetiNodeBasePiece {
    public static final /* synthetic */ int y = 0;
    public final Fragment g;
    public Function1<? super String, ? extends Fragment> h;
    public Bundle i;
    public ForsetiNodeFragment j;
    public final List<com.ss.android.lark.api.ui.a> k;
    public boolean l;
    public boolean m;
    public final Lazy n;
    public final Lazy o;
    public ForsetiActivityChainManager.b p;
    public final Lazy q;
    public final ArrayDeque<b> r;
    public final HashMap<String, ActivityResultLauncher<Intent>> s;
    public final HashMap<String, ActivityResultLauncher<IntentSenderRequest>> t;
    public final HashMap<String, ActivityResultLauncher<String[]>> u;
    public uua.a v;
    public final ForsetiNodePiece$fragmentLifecycleCallback$1 w;
    public final OnBackPressedDispatcher x;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/forseti/node/piece/ForsetiNodePiece$ForsetiNodePieceFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ForsetiNodePieceFragment extends Fragment {

        public static final class a implements View.OnClickListener {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                Log.i("ForsetiNodePiece", "intercept click.");
            }
        }

        public ForsetiNodePieceFragment() {
        }

        public final void onViewCreated(View r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super.onViewCreated(r2, r3);
            r2.setOnClickListener(a.a);
        }

        public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r1, "inflater");
            MinChildHeightFrameLayout r4 = new MinChildHeightFrameLayout(r1.getContext(), null);
            AndroidQInsetsDispatchCompat.a(r4);
            r4.setId(View.generateViewId());
            return r4;
        }
    }

    @Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ,\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016JN\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0017J+\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0013\u001a\u00020\nH\u0017¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\nH\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u00101\u001a\u0002022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u0002022\u0006\u00106\u001a\u00020\u001fH\u0016J\b\u00107\u001a\u000202H\u0016J\b\u00108\u001a\u00020\nH\u0016J\b\u00109\u001a\u000202H\u0016R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006:"}, d2 = {"Lcom/ss/android/lark/forseti/node/piece/ForsetiNodePiece$ForsetiNodePieceHostCallBacks;", "Landroidx/fragment/app/FragmentHostCallback;", "Landroid/app/Activity;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "context", "Landroid/content/Context;", "handler", "Landroid/os/Handler;", "windowAnimations", "", "<init>", "(Lcom/ss/android/lark/forseti/node/piece/ForsetiNodePiece;Landroid/content/Context;Landroid/os/Handler;I)V", "onStartActivityFromFragment", "", "fragment", "Landroidx/fragment/app/Fragment;", "intent", "Landroid/content/Intent;", "requestCode", "options", "Landroid/os/Bundle;", "onStartIntentSenderFromFragment", "Landroid/content/IntentSender;", "fillInIntent", "flagsMask", "flagsValues", "extraFlags", "onRequestPermissionsFromFragment", "permissions", "", "", "(Landroidx/fragment/app/Fragment;[Ljava/lang/String;I)V", "onFindViewById", "Landroid/view/View;", "id", "onGetHost", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "getOnBackPressedDispatcher", "()Landroidx/activity/OnBackPressedDispatcher;", "onShouldSaveFragmentState", "", "onGetLayoutInflater", "Landroid/view/LayoutInflater;", "onShouldShowRequestPermissionRationale", "permission", "onHasWindowAnimations", "onGetWindowAnimations", "onHasView", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public final class ForsetiNodePieceHostCallBacks extends FragmentHostCallback<Activity> implements ViewModelStoreOwner, OnBackPressedDispatcherOwner {
        public final /* synthetic */ ForsetiNodePiece a;

        public final Lifecycle getLifecycle() {
            return this.a.getLifecycleRegistry();
        }

        public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return this.a.x;
        }

        public final ViewModelStore getViewModelStore() {
            return this.a.getViewModelStore();
        }

        public final Object onGetHost() {
            return this.a.getActivity();
        }

        public final LayoutInflater onGetLayoutInflater() {
            LayoutInflater r0 = this.a.d;
            if (r0 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("layoutInflater");
            r0 = null;
        L7:
            return r0.cloneInContext(this.a.b());
        }

        public final int onGetWindowAnimations() {
            FragmentActivity r0 = this.a.getActivity();
            if (r0 == null) goto L9;
            Window r1 = r0.getWindow();
            if (r1 == null) goto L9;
            WindowManager.LayoutParams r2 = r1.getAttributes();
            if (r2 == null) goto L9;
            return r2.windowAnimations;
        L9:
            return 0;
        }

        public final boolean onHasView() {
            FragmentActivity r0 = this.a.getActivity();
            View r1 = null;
            if (r0 == null) goto L5;
            Window r2 = r0.getWindow();
        L6:
            if (r2 == null) goto L8;
            r1 = r2.peekDecorView();
        L8:
            if (r1 == null) goto L10;
            return true;
        L10:
            return false;
        L5:
            r2 = null;
            goto L6
        }

        public final boolean onHasWindowAnimations() {
            FragmentActivity r0 = this.a.getActivity();
            if (r0 == null) goto L5;
            Window r1 = r0.getWindow();
        L6:
            if (r1 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r1 = null;
            goto L6
        }

        public final View onFindViewById(int r2) {
            ForsetiNodeFragment r0 = this.a.j;
            if (r0 == null) goto L7;
            View r1 = r0.getView();
            if (r1 == null) goto L7;
            return r1.findViewById(r2);
        L7:
            return null;
        }

        public final boolean onShouldSaveFragmentState(Fragment r2) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            return this.a.l;
        }

        public final boolean onShouldShowRequestPermissionRationale(String r2) {
            Intrinsics.checkNotNullParameter(r2, "permission");
            return ActivityCompat.shouldShowRequestPermissionRationale(this.a.b(), r2);
        }

        public ForsetiNodePieceHostCallBacks(ForsetiNodePiece r2, FragmentActivity r3, Handler r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "handler");
            this.a = r2;
            super(r3, r4, 0);
        }

        @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "super.onRequestPermissionsFromFragment(fragment, permissions, requestCode)", imports = {"androidx.fragment.app.FragmentHostCallback"}))
        public final void onRequestPermissionsFromFragment(Fragment r4, String[] r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, "fragment");
            Intrinsics.checkNotNullParameter(r5, "permissions");
            String r0 = UUID.randomUUID().toString();
            ForsetiNodePiece.c(this.a, r0, r4);
            this.a.r.addLast(new b("RequestMultiplePermissions: " + r0, r6));
            ActivityResultLauncher<String[]> r7 = this.a.u.get(r0);
            if (r7 == null) goto L6;
            r7.launch(r5);
            return;
        }

        public final void onStartActivityFromFragment(Fragment r4, Intent r5, int r6, Bundle r7) {
            Intrinsics.checkNotNullParameter(r4, "fragment");
            String r0 = UUID.randomUUID().toString();
            ForsetiNodePiece.c(this.a, r0, r4);
            this.a.r.addLast(new b("StartActivityForResult: " + r0, r6));
            if (r5 == null) goto L6;
            if (r7 == null) goto L6;
            r5.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", r7);
        L6:
            ActivityResultLauncher<Intent> r8 = this.a.s.get(r0);
            if (r8 == null) goto L10;
            r8.launch(r5);
            return;
        }

        @Deprecated(message = "Deprecated in Java")
        public final void onStartIntentSenderFromFragment(Fragment r3, IntentSender r4, int r5, Intent r6, int r7, int r8, int r9, Bundle r10) {
            Intrinsics.checkNotNullParameter(r3, "fragment");
            String r11 = UUID.randomUUID().toString();
            ForsetiNodePiece.c(this.a, r11, r3);
            if (r10 == null) goto L8;
            if (r6 != null) goto L6;
            Intent r12 = new Intent();
            r12.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
        L7:
            r12.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", r10);
            goto L8
        L6:
            r12 = r6;
        L8:
            Intrinsics.checkNotNull(r4);
            IntentSenderRequest r13 = new IntentSenderRequest.Builder(r4).setFillInIntent(r6).setFlags(r8, r7).build();
            this.a.r.addLast(new b("StartIntentSenderForResult: " + r11, r5));
            ActivityResultLauncher<IntentSenderRequest> r14 = this.a.t.get(r11);
            if (r14 == null) goto L12;
            r14.launch(r13);
            return;
        }
    }

    public static final class a {
        @JvmStatic
        public static ForsetiNodePiece a(FragmentActivity r1, Fragment r2, Bundle r3, Function1 r4, ForsetiNodeFragment r5, ForsetiActivityChainManager.b r6, ForsetiMode r7, uua.a r8) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "rootFragment");
            Intrinsics.checkNotNullParameter(r6, "forsetiStructureNotifier");
            Intrinsics.checkNotNullParameter(r7, "placeMode");
            ForsetiNodePiece r9 = new ForsetiNodePiece(r1, r2);
            r9.i = r3;
            r9.h = r4;
            r9.j = r5;
            r9.p = r6;
            r9.v = r8;
            return r9;
        }
    }

    public static final class b {
        public final String a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "ForsetiLaunchFragmentInfos(mWho=" + this.a + ", mRequestCode=" + this.b + ')';
        }

        public b(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "mWho");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        NodePieceCustomState r0 = NodePieceCustomState.NORMAL;
    }

    public final FragmentController i() {
        return (FragmentController) this.n.getValue();
    }

    public final FragmentManager j() {
        return (FragmentManager) this.q.getValue();
    }

    public final Fragment l() {
        Fragment r0 = this.g;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final boolean h() {
        if (j().isDestroyed() == true) goto L6;
        return true;
    L6:
        Log.e("ForsetiNodePiece", "Fragment host is destroyed or null.");
        return false;
    }

    public final void onDestroy() {
        if (h() == true) goto L5;
        return;
    L5:
        g("onDestroy");
        this.l = true;
        Fragment r0 = l();     // Catch: Exception -> L8
        j().beginTransaction().remove(r0).commitNowAllowingStateLoss();     // Catch: Exception -> L8
        i().dispatchDestroy();     // Catch: Exception -> L8
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);     // Catch: Exception -> L8
    L10:
        j().unregisterFragmentLifecycleCallbacks(this.w);
        Iterator<Map.Entry<String, ActivityResultLauncher<Intent>>> r1 = this.s.entrySet().iterator();
    L12:
        if (r1.hasNext() == false) goto L14;
        r1.next().getValue().unregister();
        goto L12
    L14:
        Iterator<Map.Entry<String, ActivityResultLauncher<IntentSenderRequest>>> r2 = this.t.entrySet().iterator();
    L16:
        if (r2.hasNext() == false) goto L18;
        r2.next().getValue().unregister();
        goto L16
    L18:
        Iterator<Map.Entry<String, ActivityResultLauncher<String[]>>> r3 = this.u.entrySet().iterator();
    L20:
        if (r3.hasNext() == false) goto L22;
        r3.next().getValue().unregister();
        goto L20
    L22:
        this.s.clear();
        this.t.clear();
        this.u.clear();
        ((ArrayList) this.k).clear();
        return;
    L8:
        e = move-exception;
        Log.e("ForsetiNodePiece", "onDestroy: ", e);
        goto L10
    }

    public final void onPause() {
        if (h() == true) goto L5;
        return;
    L5:
        g("onPause");
        if (this.g.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L8;
        i().dispatchPause();
    L8:
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    public final void onResume() {
        if (h() == true) goto L5;
        return;
    L5:
        g("onResume");
        i().noteStateNotSaved();
        i().execPendingActions();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        i().dispatchResume();
    }

    public final void onStart() {
        if (h() == true) goto L5;
        return;
    L5:
        g("onStart");
        Intrinsics.checkNotNullParameter(NodePieceCustomState.NORMAL, "state");
        ForsetiActivityChainManager.b r0 = this.p;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("forsetiStructureNotifier");
        r0 = null;
    L8:
        r0.a();
        i().noteStateNotSaved();
        i().execPendingActions();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_START);
        i().dispatchStart();
    }

    public final void onStop() {
        if (h() == true) goto L5;
        return;
    L5:
        g("onStop");
    L7:
        if (k(j(), Lifecycle.State.CREATED) == true) goto L7;
        int r0 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.slardar_crash_disabled") == false) goto L17;
        i().dispatchStop();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        return;
    L17:
        i().dispatchStop();     // Catch: Exception -> L12
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_STOP);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        Log.e("ForsetiNodePiece", "onStop: ", e);
    }

    public final void g(String r2) {
        Log.i("ForsetiNodePiece", r2 + ", " + cib.e.a(l()));
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [com.ss.android.lark.forseti.node.piece.ForsetiNodePiece$fragmentLifecycleCallback$1] */
    public ForsetiNodePiece(final FragmentActivity r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rootFragment");
        this.g = r3;
        this.k = new ArrayList();
        this.m = true;
        this.n = LazyKt.lazy(new ForsetiNodePiece$fragmentController$2(this));
        this.o = LazyKt.lazy(ForsetiNodePiece$forsetiNodePieceFragment$2.INSTANCE);
        ForsetiMode.a r4 = ForsetiMode.CREATOR;
        this.q = LazyKt.lazy(new ForsetiNodePiece$fragmentManager$2(this));
        this.r = new ArrayDeque();
        this.s = new HashMap();
        this.t = new HashMap();
        this.u = new HashMap();
        this.w = new ForsetiNodePiece$fragmentLifecycleCallback$1(this, r2);
        this.x = new OnBackPressedDispatcher(new com.ss.android.lark.forseti.node.piece.a(this));
    }

    public static final void e(ForsetiNodePiece r1, String r2) {
        ActivityResultLauncher<Intent> r0 = r1.s.get(r2);
        if (r0 == null) goto L5;
        r0.unregister();
    L5:
        ActivityResultLauncher<IntentSenderRequest> r3 = r1.t.get(r2);
        if (r3 == null) goto L8;
        r3.unregister();
    L8:
        ActivityResultLauncher<String[]> r4 = r1.u.get(r2);
        if (r4 == null) goto L11;
        r4.unregister();
    L11:
        r1.s.remove(r2);
        r1.t.remove(r2);
        r1.u.remove(r2);
    }

    public static boolean k(FragmentManager r4, Lifecycle.State r5) {
        Iterator r6 = r4.getFragments().iterator();
        boolean r0 = false;
    L4:
        if (r6.hasNext() == false) goto L11;
        Fragment r1 = (Fragment) r6.next();
        if (r1.getHost() == null) goto L9;
        r0 = r0 | k(r1.getChildFragmentManager(), r5);
    L9:
        if (r1.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L4;
        LifecycleRegistry r2 = r1.getLifecycle();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
        r2.setCurrentState(r5);
        r0 = true;
        goto L4
    L11:
        return r0;
    }

    public final void f(int r7, String r8) {
        Fragment r0 = l();
        if (r8 != null) goto L5;
        String r2 = "root_fragment";
    L7:
        if (r8 != null) goto L9;
        r8 = "root_fragment";
    L9:
        String r9 = "fst_node_piece_".concat(r8);
        Log.i("ForsetiNodePiece", "isAttached = " + l().isAdded() + ", fragment = " + cib.e.a(r0));
    L25:
        e = move-exception;
        Log.e("ForsetiNodePiece", "createView error", e);
    L27:
        r0.getView();
        return;
    L11:
        if (j().findFragmentByTag(r9) != null) goto L18;
        FragmentTransaction r1 = j().beginTransaction();     // Catch: Exception -> L25
        Fragment r4 = (Fragment) this.o.getValue();     // Catch: Exception -> L25
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r9, r7) == true) goto L16;
        r1.add(r7, r4, r9);     // Catch: Exception -> L25
    L16:
        r1.commitNowAllowingStateLoss();     // Catch: Exception -> L25
    L18:
        if (j().findFragmentByTag(r2) != null) goto L27;
        FragmentTransaction r10 = j().beginTransaction();     // Catch: Exception -> L25
        int r11 = ((Fragment) this.o.getValue()).requireView().getId();     // Catch: Exception -> L25
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r2, r11) == true) goto L23;
        r10.add(r11, r0, r2);     // Catch: Exception -> L25
    L23:
        r10.commitNowAllowingStateLoss();     // Catch: Exception -> L25
        goto L27
    L5:
        r2 = r8;
        goto L7
    }

    public static final void c(ForsetiNodePiece r5, String r6, Fragment r7) {
        r5.s.put(r6, r5.b().getActivityResultRegistry().register("StartActivityForResult: " + r6, new ActivityResultContracts.StartActivityForResult(), new com.ss.android.lark.forseti.node.piece.b(r5, r7, r6)));
        r5.t.put(r6, r5.b().getActivityResultRegistry().register("StartIntentSenderForResult: " + r6, new ActivityResultContracts.StartIntentSenderForResult(), new c(r5, r7, r6)));
        r5.u.put(r6, r5.b().getActivityResultRegistry().register("RequestMultiplePermissions: " + r6, new ActivityResultContracts.RequestMultiplePermissions(), new d(r5, r7, r6)));
    }
}
