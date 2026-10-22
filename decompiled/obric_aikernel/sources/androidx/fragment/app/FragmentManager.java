package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.collection.ArraySet;
import androidx.core.os.CancellationSignal;
import androidx.fragment.R;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager implements FragmentResultOwner {
    private static boolean DEBUG = false;
    private static final String EXTRA_CREATED_FILLIN_INTENT = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    static final String TAG = "FragmentManager";
    static boolean USE_STATE_MANAGER = true;
    ArrayList<BackStackRecord> mBackStack;
    private ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    private final AtomicInteger mBackStackIndex;
    private FragmentContainer mContainer;
    private ArrayList<Fragment> mCreatedMenus;
    int mCurState;
    private SpecialEffectsControllerFactory mDefaultSpecialEffectsControllerFactory;
    private boolean mDestroyed;
    private Runnable mExecCommit;
    private boolean mExecutingActions;
    private Map<Fragment, HashSet<CancellationSignal>> mExitAnimationCancellationSignals;
    private FragmentFactory mFragmentFactory;
    private final FragmentStore mFragmentStore;
    private final FragmentTransition.Callback mFragmentTransitionCallback;
    private boolean mHavePendingDeferredStart;
    private FragmentHostCallback<?> mHost;
    private FragmentFactory mHostFragmentFactory;
    ArrayDeque<LaunchedFragmentInfo> mLaunchedFragments;
    private final FragmentLayoutInflaterFactory mLayoutInflaterFactory;
    private final FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher;
    private boolean mNeedMenuInvalidate;
    private FragmentManagerViewModel mNonConfig;
    private final CopyOnWriteArrayList<FragmentOnAttachListener> mOnAttachListeners;
    private final OnBackPressedCallback mOnBackPressedCallback;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private Fragment mParent;
    private final ArrayList<OpGenerator> mPendingActions;
    private ArrayList<StartEnterTransitionListener> mPostponedTransactions;

    @Nullable
    Fragment mPrimaryNav;
    private ActivityResultLauncher<String[]> mRequestPermissions;
    private final Map<String, LifecycleAwareResultListener> mResultListeners;
    private final Map<String, Bundle> mResults;
    private SpecialEffectsControllerFactory mSpecialEffectsControllerFactory;
    private ActivityResultLauncher<Intent> mStartActivityForResult;
    private ActivityResultLauncher<IntentSenderRequest> mStartIntentSenderForResult;
    private boolean mStateSaved;
    private boolean mStopped;
    private ArrayList<Fragment> mTmpAddedFragments;
    private ArrayList<Boolean> mTmpIsPop;
    private ArrayList<BackStackRecord> mTmpRecords;

    public interface BackStackEntry {
        @Nullable
        @Deprecated
        CharSequence getBreadCrumbShortTitle();

        @StringRes
        @Deprecated
        int getBreadCrumbShortTitleRes();

        @Nullable
        @Deprecated
        CharSequence getBreadCrumbTitle();

        @StringRes
        @Deprecated
        int getBreadCrumbTitleRes();

        int getId();

        @Nullable
        String getName();
    }

    static class FragmentIntentSenderContract extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        FragmentIntentSenderContract() {
        }

        @NonNull
        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NonNull Context r10, IntentSenderRequest r11) {
            Intent r12 = new Intent(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST);
            Intent r13 = r11.getFillInIntent();
            if (r13 == null) goto L9;
            Bundle r14 = r13.getBundleExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            if (r14 == null) goto L9;
            r12.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r14);
            r13.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            if (r13.getBooleanExtra(FragmentManager.EXTRA_CREATED_FILLIN_INTENT, false) == false) goto L9;
            r11 = new IntentSenderRequest.Builder(r11.getIntentSender()).setFillInIntent(null).setFlags(r11.getFlagsValues(), r11.getFlagsMask()).build();
        L9:
            r12.putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST, r11);
            if (FragmentManager.isLoggingEnabled(2) == false) goto L12;
            Log.v(FragmentManager.TAG, "CreateIntent created the following intent: " + r12);
        L12:
            return r12;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context r10, IntentSenderRequest r11) {
            return createIntent2(r10, r11);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public ActivityResult parseResult(int r10, @Nullable Intent r11) {
            return new ActivityResult(r10, r11);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public /* bridge */ /* synthetic */ ActivityResult parseResult(int r10, @Nullable Intent r11) {
            return parseResult(r10, r11);
        }
    }

    public static abstract class FragmentLifecycleCallbacks {
        public FragmentLifecycleCallbacks() {
        }

        @Deprecated
        public void onFragmentActivityCreated(@NonNull FragmentManager r10, @NonNull Fragment r11, @Nullable Bundle r12) {
        }

        public void onFragmentAttached(@NonNull FragmentManager r10, @NonNull Fragment r11, @NonNull Context r12) {
        }

        public void onFragmentCreated(@NonNull FragmentManager r10, @NonNull Fragment r11, @Nullable Bundle r12) {
        }

        public void onFragmentDestroyed(@NonNull FragmentManager r10, @NonNull Fragment r11) {
        }

        public void onFragmentDetached(@NonNull FragmentManager r10, @NonNull Fragment r11) {
        }

        public void onFragmentPaused(@NonNull FragmentManager r10, @NonNull Fragment r11) {
        }

        public void onFragmentPreAttached(@NonNull FragmentManager r10, @NonNull Fragment r11, @NonNull Context r12) {
        }

        public void onFragmentPreCreated(@NonNull FragmentManager r10, @NonNull Fragment r11, @Nullable Bundle r12) {
        }

        public void onFragmentResumed(@NonNull FragmentManager r10, @NonNull Fragment r11) {
        }

        public void onFragmentSaveInstanceState(@NonNull FragmentManager r10, @NonNull Fragment r11, @NonNull Bundle r12) {
        }

        public void onFragmentStarted(@NonNull FragmentManager r10, @NonNull Fragment r11) {
        }

        public void onFragmentStopped(@NonNull FragmentManager r10, @NonNull Fragment r11) {
        }

        public void onFragmentViewCreated(@NonNull FragmentManager r10, @NonNull Fragment r11, @NonNull View r12, @Nullable Bundle r13) {
        }

        public void onFragmentViewDestroyed(@NonNull FragmentManager r10, @NonNull Fragment r11) {
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = null;
        int mRequestCode;
        String mWho;

        static {
            CREATOR = new AnonymousClass1();
        }

        LaunchedFragmentInfo(@NonNull Parcel r10) {
            this.mWho = r10.readString();
            this.mRequestCode = r10.readInt();
        }

        LaunchedFragmentInfo(@NonNull String r10, int r11) {
            this.mWho = r10;
            this.mRequestCode = r11;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeString(this.mWho);
            r10.writeInt(this.mRequestCode);
        }
    }

    private static class LifecycleAwareResultListener implements FragmentResultListener {
        private final Lifecycle mLifecycle;
        private final FragmentResultListener mListener;
        private final LifecycleEventObserver mObserver;

        LifecycleAwareResultListener(@NonNull Lifecycle r10, @NonNull FragmentResultListener r11, @NonNull LifecycleEventObserver r12) {
            this.mLifecycle = r10;
            this.mListener = r11;
            this.mObserver = r12;
        }

        public boolean isAtLeast(Lifecycle.State r10) {
            return this.mLifecycle.getCurrentState().isAtLeast(r10);
        }

        @Override // androidx.fragment.app.FragmentResultListener
        public void onFragmentResult(@NonNull String r10, @NonNull Bundle r11) {
            this.mListener.onFragmentResult(r10, r11);
        }

        public void removeObserver() {
            this.mLifecycle.removeObserver(this.mObserver);
        }
    }

    public interface OnBackStackChangedListener {
        @MainThread
        void onBackStackChanged();
    }

    interface OpGenerator {
        boolean generateOps(@NonNull ArrayList<BackStackRecord> r10, @NonNull ArrayList<Boolean> r11);
    }

    private class PopBackStackState implements OpGenerator {
        final int mFlags;
        final int mId;
        final String mName;
        final /* synthetic */ FragmentManager this$0;

        PopBackStackState(@Nullable FragmentManager r10, String r11, int r12, int r13) {
            this.this$0 = r10;
            this.mName = r11;
            this.mId = r12;
            this.mFlags = r13;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(@NonNull ArrayList<BackStackRecord> r10, @NonNull ArrayList<Boolean> r11) {
            Fragment r12 = this.this$0.mPrimaryNav;
            if (r12 == null) goto L13;
            if (this.mId >= 0) goto L13;
            if (this.mName != null) goto L13;
            if (r12.getChildFragmentManager().popBackStackImmediate() == false) goto L13;
            return false;
        L13:
            return this.this$0.popBackStackState(r10, r11, this.mName, this.mId, this.mFlags);
        }
    }

    static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {
        final boolean mIsBack;
        private int mNumPostponed;
        final BackStackRecord mRecord;

        StartEnterTransitionListener(@NonNull BackStackRecord r10, boolean r11) {
            this.mIsBack = r11;
            this.mRecord = r10;
        }

        void cancelTransaction() {
            BackStackRecord r10 = this.mRecord;
            r10.mManager.completeExecute(r10, this.mIsBack, false, false);
        }

        void completeTransaction() {
            if (this.mNumPostponed <= 0) goto L5;
            boolean r10 = true;
        L6:
            Iterator<Fragment> r11 = this.mRecord.mManager.getFragments().iterator();
        L8:
            if (r11.hasNext() == false) goto L14;
            Fragment r12 = r11.next();
            r12.setOnStartEnterTransitionListener(null);
            if (r10 == false) goto L8;
            if (r12.isPostponed() == false) goto L8;
            r12.startPostponedEnterTransition();
            goto L8
        L14:
            BackStackRecord r13 = this.mRecord;
            r13.mManager.completeExecute(r13, this.mIsBack, !r10, true);
            return;
        L5:
            r10 = false;
            goto L6
        }

        public boolean isReady() {
            if (this.mNumPostponed != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.fragment.app.Fragment.OnStartEnterTransitionListener
        public void onStartEnterTransition() {
            int r10 = this.mNumPostponed - 1;
            this.mNumPostponed = r10;
            if (r10 == 0) goto L5;
            return;
        L5:
            this.mRecord.mManager.scheduleCommit();
        }

        @Override // androidx.fragment.app.Fragment.OnStartEnterTransitionListener
        public void startListening() {
            this.mNumPostponed++;
        }
    }

    static {
    }

    public FragmentManager() {
        this.mPendingActions = new ArrayList();
        this.mFragmentStore = new FragmentStore();
        this.mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
        final boolean r10 = false;
        this.mOnBackPressedCallback = new AnonymousClass1(this, r10);
        this.mBackStackIndex = new AtomicInteger();
        this.mResults = Collections.synchronizedMap(new HashMap());
        this.mResultListeners = Collections.synchronizedMap(new HashMap());
        this.mExitAnimationCancellationSignals = Collections.synchronizedMap(new HashMap());
        this.mFragmentTransitionCallback = new AnonymousClass2(this);
        this.mLifecycleCallbacksDispatcher = new FragmentLifecycleCallbacksDispatcher(this);
        this.mOnAttachListeners = new CopyOnWriteArrayList();
        this.mCurState = -1;
        this.mFragmentFactory = null;
        this.mHostFragmentFactory = new AnonymousClass3(this);
        this.mSpecialEffectsControllerFactory = null;
        this.mDefaultSpecialEffectsControllerFactory = new AnonymousClass4(this);
        this.mLaunchedFragments = new ArrayDeque();
        this.mExecCommit = new AnonymousClass5(this);
    }

    static /* synthetic */ Map access$000(FragmentManager r10) {
        return r10.mResults;
    }

    static /* synthetic */ Map access$100(FragmentManager r10) {
        return r10.mResultListeners;
    }

    static /* synthetic */ FragmentStore access$200(FragmentManager r10) {
        return r10.mFragmentStore;
    }

    private void addAddedFragments(@NonNull ArraySet<Fragment> r10) {
        int r11 = this.mCurState;
        if (r11 >= 1) goto L5;
        return;
    L5:
        int r12 = Math.min(r11, 5);
        Iterator<Fragment> r13 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r13.hasNext() == false) goto L17;
        Fragment r14 = r13.next();
        if (r14.mState >= r12) goto L7;
        moveToState(r14, r12);
        if (r14.mView == null) goto L7;
        if (r14.mHidden == true) goto L7;
        if (r14.mIsNewlyAdded == false) goto L7;
        r10.add(r14);
        goto L7
    }

    private void cancelExitAnimation(@NonNull Fragment r10) {
        HashSet<CancellationSignal> r11 = this.mExitAnimationCancellationSignals.get(r10);
        if (r11 == null) goto L11;
        Iterator<CancellationSignal> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r12.next().cancel();
        goto L6
    L8:
        r11.clear();
        destroyFragmentView(r10);
        this.mExitAnimationCancellationSignals.remove(r10);
        return;
    }

    private void checkStateLoss() {
        if (isStateSaved() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    private Set<SpecialEffectsController> collectAllSpecialEffectsController() {
        HashSet r10 = new HashSet();
        Iterator<FragmentStateManager> r11 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        ViewGroup r12 = r11.next().getFragment().mContainer;
        if (r12 == null) goto L4;
        r10.add(SpecialEffectsController.getOrCreateController(r12, getSpecialEffectsControllerFactory()));
        goto L4
    L8:
        return r10;
    }

    private Set<SpecialEffectsController> collectChangedControllers(@NonNull ArrayList<BackStackRecord> r10, int r11, int r12) {
        HashSet r13 = new HashSet();
    L3:
        if (r11 >= r12) goto L13;
        Iterator<FragmentTransaction.Op> r14 = r10.get(r11).mOps.iterator();
    L6:
        if (r14.hasNext() == false) goto L12;
        Fragment r15 = r14.next().mFragment;
        if (r15 == null) goto L6;
        ViewGroup r16 = r15.mContainer;
        if (r16 == null) goto L6;
        r13.add(SpecialEffectsController.getOrCreateController(r16, this));
        goto L6
    L12:
        r11 = r11 + 1;
        goto L3
    L13:
        return r13;
    }

    private void completeShowHideFragment(@NonNull final Fragment r10) {
        if (r10.mView == null) goto L27;
        FragmentAnim.AnimationOrAnimator r11 = FragmentAnim.loadAnimation(this.mHost.getContext(), r10, !r10.mHidden, r10.getPopDirection());
        if (r11 == null) goto L16;
        Animator r12 = r11.animator;
        if (r12 == null) goto L16;
        r12.setTarget(r10.mView);
        if (r10.mHidden == true) goto L11;
        r10.mView.setVisibility(0);
    L15:
        r11.animator.start();
        goto L27
    L11:
        if (r10.isHideReplaced() == false) goto L13;
        r10.setHideReplaced(false);
        goto L15
    L13:
        final ViewGroup r13 = r10.mContainer;
        final View r14 = r10.mView;
        r13.startViewTransition(r14);
        r11.animator.addListener(new AnonymousClass7(this, r13, r14, r10));
    L16:
        if (r11 == null) goto L19;
        r10.mView.startAnimation(r11.animation);
        r11.animation.start();
    L19:
        if (r10.mHidden == true) goto L21;
    L23:
        int r15 = 0;
    L24:
        r10.mView.setVisibility(r15);
        if (r10.isHideReplaced() == false) goto L27;
        r10.setHideReplaced(false);
        goto L27
    L21:
        if (r10.isHideReplaced() == true) goto L23;
        r15 = 8;
    L27:
        invalidateMenuForFragment(r10);
        r10.mHiddenChanged = false;
        r10.onHiddenChanged(r10.mHidden);
    }

    private void destroyFragmentView(@NonNull Fragment r10) {
        r10.performDestroyView();
        this.mLifecycleCallbacksDispatcher.dispatchOnFragmentViewDestroyed(r10, false);
        r10.mContainer = null;
        r10.mView = null;
        r10.mViewLifecycleOwner = null;
        r10.mViewLifecycleOwnerLiveData.setValue(null);
        r10.mInLayout = false;
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(@Nullable Fragment r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.equals(findActiveFragment(r10.mWho)) == false) goto L8;
        r10.performPrimaryNavigationFragmentChanged();
        return;
    }

    private void dispatchStateChange(int r10) {
        this.mExecutingActions = true;     // Catch: Throwable -> L12
        this.mFragmentStore.dispatchStateChange(r10);     // Catch: Throwable -> L12
        moveToState(r10, false);     // Catch: Throwable -> L12
        if (USE_STATE_MANAGER == false) goto L10;
        Iterator<SpecialEffectsController> r11 = collectAllSpecialEffectsController().iterator();     // Catch: Throwable -> L12
    L7:
        if (r11.hasNext() == false) goto L10;
        r11.next().forceCompleteAllOperations();     // Catch: Throwable -> L12
    L10:
        this.mExecutingActions = false;
        execPendingActions(true);
        return;
    L12:
        th = move-exception;
        this.mExecutingActions = false;
        throw th;
    }

    private void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart == false) goto L6;
        this.mHavePendingDeferredStart = false;
        startPendingDeferredFragments();
        return;
    }

    @Deprecated
    public static void enableDebugLogging(boolean r10) {
        DEBUG = r10;
    }

    @FragmentStateManagerControl
    public static void enableNewStateManager(boolean r10) {
        USE_STATE_MANAGER = r10;
    }

    private void endAnimatingAwayFragments() {
        if (USE_STATE_MANAGER == false) goto L9;
        Iterator<SpecialEffectsController> r10 = collectAllSpecialEffectsController().iterator();
    L6:
        if (r10.hasNext() == false) goto L17;
        r10.next().forceCompleteAllOperations();
        goto L6
    L17:
        return;
    L9:
        if (this.mExitAnimationCancellationSignals.isEmpty() == true) goto L14;
        Iterator<Fragment> r11 = this.mExitAnimationCancellationSignals.keySet().iterator();
    L12:
        if (r11.hasNext() == false) goto L18;
        Fragment r12 = r11.next();
        cancelExitAnimation(r12);
        moveToState(r12);
        goto L12
    L18:
        return;
    }

    private void ensureExecReady(boolean r10) {
        if (this.mExecutingActions == true) goto L29;
        if (this.mHost != null) goto L13;
        if (this.mDestroyed == false) goto L11;
        throw new IllegalStateException("FragmentManager has been destroyed");
    L11:
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    L13:
        if (Looper.myLooper() != this.mHost.getHandler().getLooper()) goto L27;
        if (r10 == true) goto L17;
        checkStateLoss();
    L17:
        if (this.mTmpRecords != null) goto L19;
        this.mTmpRecords = new ArrayList();
        this.mTmpIsPop = new ArrayList();
    L19:
        this.mExecutingActions = true;
        executePostponedTransaction(null, null);     // Catch: Throwable -> L23
        this.mExecutingActions = false;
        return;
    L23:
        th = move-exception;
        this.mExecutingActions = false;
        throw th;
    L27:
        throw new IllegalStateException("Must be called from main thread of fragment host");
    L29:
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    private static void executeOps(@NonNull ArrayList<BackStackRecord> r10, @NonNull ArrayList<Boolean> r11, int r12, int r13) {
    L2:
        if (r12 >= r13) goto L12;
        BackStackRecord r14 = r10.get(r12);
        boolean r15 = true;
        if (r11.get(r12).booleanValue() == false) goto L10;
        r14.bumpBackStackNesting(-1);
        if (r12 == (r13 - 1)) goto L9;
        r15 = false;
    L9:
        r14.executePopOps(r15);
    L11:
        r12 = r12 + 1;
        goto L2
    L10:
        r14.bumpBackStackNesting(1);
        r14.executeOps();
        goto L11
    }

    /* JADX WARN: Failed to calculate best type for var: r17v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v0 'this'  ??, new type: androidx.fragment.app.FragmentManager
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v10 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v10 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v11 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v12 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v13 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r17v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v0 'this'  ??, new type: androidx.fragment.app.FragmentManager
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v10 ??, new type: int
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    private void executeOpsTogether(@androidx.annotation.NonNull java.util.ArrayList<androidx.fragment.app.BackStackRecord> r18, @androidx.annotation.NonNull java.util.ArrayList<java.lang.Boolean> r19, int r20, int r21) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00de: INVOKE (r8v10 ?? I:int) = (r8v9 java.util.ArrayList<androidx.fragment.app.FragmentTransaction$Op>) VIRTUAL call: java.util.ArrayList.size():int A[DECLARE_VAR, MD:():int (c)] in method: androidx.fragment.app.FragmentManager.executeOpsTogether(java.util.ArrayList<androidx.fragment.app.BackStackRecord>, java.util.ArrayList<java.lang.Boolean>, int, int):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.executeOpsTogether(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    private void executePostponedTransaction(@Nullable ArrayList<BackStackRecord> r10, @Nullable ArrayList<Boolean> r11) {
        ArrayList<StartEnterTransitionListener> r12 = this.mPostponedTransactions;
        if (r12 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L36;
        StartEnterTransitionListener r15 = this.mPostponedTransactions.get(r14);
        if (r10 == null) goto L20;
        if (r15.mIsBack == true) goto L20;
        int r16 = r10.indexOf(r15.mRecord);
        if (r16 == (-1)) goto L20;
        if (r11 == null) goto L20;
        if (r11.get(r16).booleanValue() == false) goto L20;
        this.mPostponedTransactions.remove(r14);
        r14 = r14 - 1;
        r13 = r13 - 1;
    L18:
        r15.cancelTransaction();
    L35:
        r14 = r14 + 1;
    L20:
        if (r15.isReady() == true) goto L24;
        if (r10 == null) goto L35;
        if (r15.mRecord.interactsWith(r10, 0, r10.size()) == false) goto L35;
    L24:
        this.mPostponedTransactions.remove(r14);
        r14 = r14 - 1;
        r13 = r13 - 1;
        if (r10 != null) goto L27;
    L34:
        r15.completeTransaction();
        goto L35
    L27:
        if (r15.mIsBack == true) goto L34;
        int r17 = r10.indexOf(r15.mRecord);
        if (r17 == (-1)) goto L34;
        if (r11 == null) goto L34;
        if (r11.get(r17).booleanValue() == false) goto L34;
    L36:
        return;
    L5:
        r13 = r12.size();
        goto L6
    }

    @NonNull
    public static <F extends Fragment> F findFragment(@NonNull View r10) {
        F r11 = (F) findViewFragment(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IllegalStateException("View " + r10 + " does not have a Fragment set");
    }

    @NonNull
    static FragmentManager findFragmentManager(@NonNull View r10) {
        Fragment r11 = findViewFragment(r10);
        if (r11 != null) goto L5;
        Context r12 = r10.getContext();
        FragmentActivity r13 = null;
    L11:
        if ((r12 instanceof ContextWrapper) == false) goto L16;
        if ((r12 instanceof FragmentActivity) == true) goto L14;
        r12 = ((ContextWrapper) r12).getBaseContext();
        goto L11
    L14:
        r13 = (FragmentActivity) r12;
    L16:
        if (r13 == null) goto L20;
        return r13.getSupportFragmentManager();
    L20:
        throw new IllegalStateException("View " + r10 + " is not within a subclass of FragmentActivity.");
    L5:
        if (r11.isAdded() == false) goto L8;
        return r11.getChildFragmentManager();
    L8:
        throw new IllegalStateException("The Fragment " + r11 + " that owns View " + r10 + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
    }

    @Nullable
    private static Fragment findViewFragment(@NonNull View r10) {
    L3:
        if (r10 == null) goto L11;
        Fragment r11 = getViewFragment(r10);
        if (r11 != null) goto L6;
        Object r12 = r10.getParent();
        if ((r12 instanceof View) == true) goto L9;
        r10 = null;
        goto L3
    L9:
        r10 = (View) r12;
        goto L3
    L6:
        return r11;
    L11:
        return null;
    }

    private void forcePostponedTransactions() {
        if (USE_STATE_MANAGER == false) goto L9;
        Iterator<SpecialEffectsController> r10 = collectAllSpecialEffectsController().iterator();
    L6:
        if (r10.hasNext() == false) goto L16;
        r10.next().forcePostponedExecutePendingOperations();
        goto L6
    L16:
        return;
    L9:
        if (this.mPostponedTransactions != null) goto L11;
        return;
    L11:
        if (this.mPostponedTransactions.isEmpty() == true) goto L17;
        this.mPostponedTransactions.remove(0).completeTransaction();
        goto L11
    }

    private boolean generateOpsForPendingActions(@NonNull ArrayList<BackStackRecord> r10, @NonNull ArrayList<Boolean> r11) {
        ArrayList<OpGenerator> r12 = this.mPendingActions;
        monitor-enter(r12);
        int r13 = 0;
        if (this.mPendingActions.isEmpty() == false) goto L8;
        monitor-exit(r12);     // Catch: Throwable -> L14
        return false;
    L8:
        int r14 = this.mPendingActions.size();     // Catch: Throwable -> L14
        boolean r15 = false;
    L9:
        if (r13 >= r14) goto L11;
        r15 = r15 | this.mPendingActions.get(r13).generateOps(r10, r11);     // Catch: Throwable -> L14
        r13 = r13 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        this.mPendingActions.clear();     // Catch: Throwable -> L14
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
        return r15;
    L14:
        th = move-exception;
        throw th;
    }

    @NonNull
    private FragmentManagerViewModel getChildNonConfig(@NonNull Fragment r10) {
        return this.mNonConfig.getChildNonConfig(r10);
    }

    private ViewGroup getFragmentContainer(@NonNull Fragment r10) {
        ViewGroup r11 = r10.mContainer;
        if (r11 == null) goto L6;
        return r11;
    L6:
        if (r10.mContainerId > 0) goto L9;
        return null;
    L9:
        if (this.mContainer.onHasView() == false) goto L14;
        View r12 = this.mContainer.onFindViewById(r10.mContainerId);
        if ((r12 instanceof ViewGroup) == false) goto L14;
        return (ViewGroup) r12;
    L14:
        return null;
    }

    @Nullable
    static Fragment getViewFragment(@NonNull View r10) {
        Object r11 = r10.getTag(R.id.fragment_container_view_tag);
        if ((r11 instanceof Fragment) == true) goto L5;
        return null;
    L5:
        return (Fragment) r11;
    }

    static boolean isLoggingEnabled(int r10) {
        if (DEBUG == false) goto L5;
    L8:
        return true;
    L5:
        if (Log.isLoggable(TAG, r10) == true) goto L8;
        return false;
    }

    private boolean isMenuAvailable(@NonNull Fragment r10) {
        if (r10.mHasMenu == false) goto L7;
        if (r10.mMenuVisible == false) goto L7;
    L8:
        return true;
    L7:
        if (r10.mChildFragmentManager.checkForMenus() == true) goto L8;
        return false;
    }

    private void makeRemovedFragmentsInvisible(@NonNull ArraySet<Fragment> r10) {
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        Fragment r13 = r10.valueAt(r12);
        if (r13.mAdded == true) goto L7;
        View r14 = r13.requireView();
        r13.mPostponedAlpha = r14.getAlpha();
        r14.setAlpha(0.0f);
    L7:
        r12 = r12 + 1;
        goto L3
    }

    private boolean popBackStackImmediate(@Nullable String r10, int r11, int r12) {
        execPendingActions(false);
        ensureExecReady(true);
        Fragment r13 = this.mPrimaryNav;
        if (r13 == null) goto L9;
        if (r11 >= 0) goto L9;
        if (r10 != null) goto L9;
        if (r13.getChildFragmentManager().popBackStackImmediate() == false) goto L9;
        return true;
    L9:
        boolean r14 = popBackStackState(this.mTmpRecords, this.mTmpIsPop, r10, r11, r12);
        if (r14 == false) goto L17;
        this.mExecutingActions = true;
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);     // Catch: Throwable -> L14
        cleanupExec();
    L14:
        th = move-exception;
        cleanupExec();
        throw th;
    L17:
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return r14;
    }

    private int postponePostponableTransactions(@NonNull ArrayList<BackStackRecord> r10, @NonNull ArrayList<Boolean> r11, int r12, int r13, @NonNull ArraySet<Fragment> r14) {
        int r15 = r13 - 1;
        int r16 = r13;
    L3:
        if (r15 < r12) goto L23;
        BackStackRecord r17 = r10.get(r15);
        boolean r18 = r11.get(r15).booleanValue();
        if (r17.isPostponed() == true) goto L7;
    L9:
        boolean r19 = false;
    L10:
        if (r19 == false) goto L22;
        if (this.mPostponedTransactions != null) goto L14;
        this.mPostponedTransactions = new ArrayList();
    L14:
        StartEnterTransitionListener r20 = new StartEnterTransitionListener(r17, r18);
        this.mPostponedTransactions.add(r20);
        r17.setOnStartPostponedListener(r20);
        if (r18 == false) goto L17;
        r17.executeOps();
    L18:
        r16 = r16 - 1;
        if (r15 == r16) goto L21;
        r10.remove(r15);
        r10.add(r16, r17);
    L21:
        addAddedFragments(r14);
        goto L22
    L17:
        r17.executePopOps(false);
    L22:
        r15 = r15 - 1;
        goto L3
    L7:
        if (r17.interactsWith(r10, r15 + 1, r13) == true) goto L9;
        r19 = true;
        goto L10
    L23:
        return r16;
    }

    private void removeRedundantOperationsAndExecute(@NonNull ArrayList<BackStackRecord> r10, @NonNull ArrayList<Boolean> r11) {
        if (r10.isEmpty() == false) goto L6;
        return;
    L6:
        if (r10.size() != r11.size()) goto L27;
        executePostponedTransaction(r10, r11);
        int r12 = r10.size();
        int r13 = 0;
        int r14 = 0;
    L8:
        if (r13 >= r12) goto L23;
        if (r10.get(r13).mReorderingAllowed == true) goto L22;
        if (r14 == r13) goto L13;
        executeOpsTogether(r10, r11, r14, r13);
    L13:
        r14 = r13 + 1;
        if (r11.get(r13).booleanValue() == false) goto L21;
    L15:
        if (r14 >= r12) goto L21;
        if (r11.get(r14).booleanValue() == false) goto L21;
        if (r10.get(r14).mReorderingAllowed == true) goto L21;
        r14 = r14 + 1;
    L21:
        executeOpsTogether(r10, r11, r13, r14);
        r13 = r14 - 1;
    L22:
        r13 = r13 + 1;
        goto L8
    L23:
        if (r14 == r12) goto L34;
        executeOpsTogether(r10, r11, r14, r12);
        return;
    L34:
        return;
    L27:
        throw new IllegalStateException("Internal error with the back stack records");
    }

    private void reportBackStackChanged() {
        if (this.mBackStackChangeListeners == null) goto L8;
        int r10 = 0;
    L6:
        if (r10 >= this.mBackStackChangeListeners.size()) goto L10;
        this.mBackStackChangeListeners.get(r10).onBackStackChanged();
        r10 = r10 + 1;
        goto L6
    L10:
        return;
    }

    static int reverseTransit(int r10) {
        if (r10 == 4097) goto L10;
        if (r10 == 4099) goto L9;
        if (r10 == 8194) goto L12;
        return 0;
    L12:
        return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
    L9:
        return FragmentTransaction.TRANSIT_FRAGMENT_FADE;
    L10:
        return 8194;
    }

    private void setVisibleRemovingFragment(@NonNull Fragment r10) {
        ViewGroup r11 = getFragmentContainer(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if ((((r10.getEnterAnim() + r10.getExitAnim()) + r10.getPopEnterAnim()) + r10.getPopExitAnim()) <= 0) goto L12;
        int r12 = R.id.visible_removing_fragment_view_tag;
        if (r11.getTag(r12) != null) goto L9;
        r11.setTag(r12, r10);
    L9:
        ((Fragment) r11.getTag(r12)).setPopDirection(r10.getPopDirection());
        return;
    }

    private void startPendingDeferredFragments() {
        Iterator<FragmentStateManager> r10 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        performPendingDeferredStart(r10.next());
        goto L4
    }

    private void throwException(RuntimeException r10) {
        Log.e(TAG, r10.getMessage());
        Log.e(TAG, "Activity state:");
        PrintWriter r11 = new PrintWriter(new LogWriter(TAG));
        FragmentHostCallback<?> r12 = this.mHost;
        if (r12 == null) goto L5;
        r12.onDump("  ", null, r11, new String[0]);     // Catch: Exception -> L7
    L10:
        throw r10;
    L5:
        dump("  ", null, r11, new String[0]);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        Log.e(TAG, "Failed dumping state", e);
        throw r10;
    }

    private void updateOnBackPressedCallbackEnabled() {
        ArrayList<OpGenerator> r10 = this.mPendingActions;
        monitor-enter(r10);
        boolean r11 = true;
        if (this.mPendingActions.isEmpty() == true) goto L9;
        this.mOnBackPressedCallback.setEnabled(true);     // Catch: Throwable -> L18
        monitor-exit(r10);     // Catch: Throwable -> L18
        return;
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L18
        OnBackPressedCallback r12 = this.mOnBackPressedCallback;
        if (getBackStackEntryCount() > 0) goto L13;
    L15:
        r11 = false;
    L16:
        r12.setEnabled(r11);
        return;
    L13:
        if (isPrimaryNavigation(this.mParent) == false) goto L15;
    L18:
        th = move-exception;
        throw th;
    }

    void addBackStackState(BackStackRecord r10) {
        if (this.mBackStack != null) goto L5;
        this.mBackStack = new ArrayList();
    L5:
        this.mBackStack.add(r10);
    }

    void addCancellationSignal(@NonNull Fragment r10, @NonNull CancellationSignal r11) {
        if (this.mExitAnimationCancellationSignals.get(r10) != null) goto L5;
        this.mExitAnimationCancellationSignals.put(r10, new HashSet());
    L5:
        this.mExitAnimationCancellationSignals.get(r10).add(r11);
    }

    FragmentStateManager addFragment(@NonNull Fragment r10) {
        if (isLoggingEnabled(2) == false) goto L5;
        Log.v(TAG, "add: " + r10);
    L5:
        FragmentStateManager r11 = createOrGetFragmentStateManager(r10);
        r10.mFragmentManager = this;
        this.mFragmentStore.makeActive(r11);
        if (r10.mDetached == true) goto L13;
        this.mFragmentStore.addFragment(r10);
        r10.mRemoving = false;
        if (r10.mView != null) goto L11;
        r10.mHiddenChanged = false;
    L11:
        if (isMenuAvailable(r10) == false) goto L13;
        this.mNeedMenuInvalidate = true;
    L13:
        return r11;
    }

    public void addFragmentOnAttachListener(@NonNull FragmentOnAttachListener r10) {
        this.mOnAttachListeners.add(r10);
    }

    public void addOnBackStackChangedListener(@NonNull OnBackStackChangedListener r10) {
        if (this.mBackStackChangeListeners != null) goto L5;
        this.mBackStackChangeListeners = new ArrayList();
    L5:
        this.mBackStackChangeListeners.add(r10);
    }

    void addRetainedFragment(@NonNull Fragment r10) {
        this.mNonConfig.addRetainedFragment(r10);
    }

    int allocBackStackIndex() {
        return this.mBackStackIndex.getAndIncrement();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    void attachController(@NonNull FragmentHostCallback<?> r10, @NonNull FragmentContainer r11, @Nullable final Fragment r12) {
        if (this.mHost != null) goto L36;
        this.mHost = r10;
        this.mContainer = r11;
        this.mParent = r12;
        if (r12 == null) goto L9;
        FragmentOnAttachListener r13 = new AnonymousClass8(this, r12);
    L7:
        addFragmentOnAttachListener(r13);
    L12:
        if (this.mParent == null) goto L15;
        updateOnBackPressedCallbackEnabled();
    L15:
        if ((r10 instanceof OnBackPressedDispatcherOwner) == false) goto L20;
        OnBackPressedDispatcherOwner r14 = (OnBackPressedDispatcherOwner) r10;
        OnBackPressedDispatcher r15 = r14.getOnBackPressedDispatcher();
        this.mOnBackPressedDispatcher = r15;
        LifecycleOwner r16 = r14;
        if (r12 == null) goto L19;
        r16 = r12;
    L19:
        r15.addCallback(r16, this.mOnBackPressedCallback);
    L20:
        if (r12 == null) goto L24;
        FragmentManagerViewModel r17 = r12.mFragmentManager.getChildNonConfig(r12);
    L22:
        this.mNonConfig = r17;
        this.mNonConfig.setIsStateSaved(isStateSaved());
        this.mFragmentStore.setNonConfig(this.mNonConfig);
        Object r18 = this.mHost;
        if ((r18 instanceof ActivityResultRegistryOwner) == false) goto L37;
        ActivityResultRegistry r19 = ((ActivityResultRegistryOwner) r18).getActivityResultRegistry();
        if (r12 == null) goto L32;
        String r20 = r12.mWho + ":";
    L33:
        String r21 = "FragmentManager:" + r20;
        this.mStartActivityForResult = r19.register(r21 + "StartActivityForResult", new ActivityResultContracts.StartActivityForResult(), new AnonymousClass9(this));
        this.mStartIntentSenderForResult = r19.register(r21 + "StartIntentSenderForResult", new FragmentIntentSenderContract(), new AnonymousClass10(this));
        this.mRequestPermissions = r19.register(r21 + "RequestPermissions", new ActivityResultContracts.RequestMultiplePermissions(), new AnonymousClass11(this));
        return;
    L32:
        r20 = "";
        goto L33
    L37:
        return;
    L24:
        if ((r10 instanceof ViewModelStoreOwner) == false) goto L26;
        r17 = FragmentManagerViewModel.getInstance(((ViewModelStoreOwner) r10).getViewModelStore());
        goto L22
    L26:
        r17 = new FragmentManagerViewModel(false);
        goto L22
    L9:
        if ((r10 instanceof FragmentOnAttachListener) == false) goto L12;
        r13 = (FragmentOnAttachListener) r10;
        goto L7
    L36:
        throw new IllegalStateException("Already attached");
    }

    void attachFragment(@NonNull Fragment r10) {
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "attach: " + r10);
    L6:
        if (r10.mDetached == false) goto L16;
        r10.mDetached = false;
        if (r10.mAdded == true) goto L17;
        this.mFragmentStore.addFragment(r10);
        if (isLoggingEnabled(2) == false) goto L13;
        Log.v(TAG, "add from attach: " + r10);
    L13:
        if (isMenuAvailable(r10) == false) goto L18;
        this.mNeedMenuInvalidate = true;
        return;
    L18:
        return;
    L17:
        return;
    }

    @NonNull
    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    boolean checkForMenus() {
        Iterator<Fragment> r10 = this.mFragmentStore.getActiveFragments().iterator();
        boolean r11 = false;
    L4:
        if (r10.hasNext() == false) goto L11;
        Fragment r12 = r10.next();
        if (r12 == null) goto L8;
        r11 = isMenuAvailable(r12);
    L8:
        if (r11 == false) goto L4;
        return true;
    L11:
        return false;
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResult(@NonNull String r10) {
        this.mResults.remove(r10);
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResultListener(@NonNull String r10) {
        LifecycleAwareResultListener r11 = this.mResultListeners.remove(r10);
        if (r11 == null) goto L6;
        r11.removeObserver();
        return;
    }

    void completeExecute(@NonNull BackStackRecord r10, boolean r11, boolean r12, boolean r13) {
        if (r11 == false) goto L4;
        r10.executePopOps(r13);
    L5:
        ArrayList r14 = new ArrayList(1);
        ArrayList r15 = new ArrayList(1);
        r14.add(r10);
        r15.add(Boolean.valueOf(r11));
        if (r12 == true) goto L8;
    L10:
        if (r13 == false) goto L12;
        moveToState(this.mCurState, true);
    L12:
        Iterator<Fragment> r16 = this.mFragmentStore.getActiveFragments().iterator();
    L14:
        if (r16.hasNext() == false) goto L29;
        Fragment r17 = r16.next();
        if (r17 == null) goto L14;
        if (r17.mView == null) goto L14;
        if (r17.mIsNewlyAdded == false) goto L14;
        if (r10.interactsWith(r17.mContainerId) == false) goto L14;
        float r18 = r17.mPostponedAlpha;
        if (r18 <= 0.0f) goto L26;
        r17.mView.setAlpha(r18);
    L26:
        if (r13 == true) goto L27;
        r17.mPostponedAlpha = -1.0f;
        r17.mIsNewlyAdded = false;
        goto L14
    L27:
        r17.mPostponedAlpha = 0.0f;
        goto L14
    L29:
        return;
    L8:
        if (this.mCurState < 1) goto L10;
        FragmentTransition.startTransitions(this.mHost.getContext(), this.mContainer, r14, r15, 0, 1, true, this.mFragmentTransitionCallback);
        goto L10
    L4:
        r10.executeOps();
        goto L5
    }

    @NonNull
    FragmentStateManager createOrGetFragmentStateManager(@NonNull Fragment r10) {
        FragmentStateManager r11 = this.mFragmentStore.getFragmentStateManager(r10.mWho);
        if (r11 == null) goto L5;
        return r11;
    L5:
        FragmentStateManager r12 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r10);
        r12.restoreState(this.mHost.getContext().getClassLoader());
        r12.setFragmentManagerState(this.mCurState);
        return r12;
    }

    void detachFragment(@NonNull Fragment r10) {
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "detach: " + r10);
    L6:
        if (r10.mDetached == true) goto L17;
        r10.mDetached = true;
        if (r10.mAdded == true) goto L10;
        return;
    L10:
        if (isLoggingEnabled(2) == false) goto L12;
        Log.v(TAG, "remove from detach: " + r10);
    L12:
        this.mFragmentStore.removeFragment(r10);
        if (isMenuAvailable(r10) == false) goto L15;
        this.mNeedMenuInvalidate = true;
    L15:
        setVisibleRemovingFragment(r10);
        return;
    }

    void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(4);
    }

    void dispatchAttach() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(0);
    }

    void dispatchConfigurationChanged(@NonNull Configuration r10) {
        Iterator<Fragment> r11 = this.mFragmentStore.getFragments().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Fragment r12 = r11.next();
        if (r12 == null) goto L4;
        r12.performConfigurationChanged(r10);
        goto L4
    }

    boolean dispatchContextItemSelected(@NonNull MenuItem r10) {
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r11 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        Fragment r12 = r11.next();
        if (r12 == null) goto L7;
        if (r12.performContextItemSelected(r10) == false) goto L7;
        return true;
    L13:
        return false;
    }

    void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(1);
    }

    boolean dispatchCreateOptionsMenu(@NonNull Menu r10, @NonNull MenuInflater r11) {
        int r12 = 0;
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        ArrayList<Fragment> r13 = null;
        Iterator<Fragment> r14 = this.mFragmentStore.getFragments().iterator();
        boolean r15 = false;
    L7:
        if (r14.hasNext() == false) goto L18;
        Fragment r16 = r14.next();
        if (r16 == null) goto L7;
        if (isParentMenuVisible(r16) == false) goto L7;
        if (r16.performCreateOptionsMenu(r10, r11) == false) goto L7;
        if (r13 != null) goto L16;
        r13 = new ArrayList();
    L16:
        r13.add(r16);
        r15 = true;
        goto L7
    L18:
        if (this.mCreatedMenus != null) goto L20;
    L27:
        this.mCreatedMenus = r13;
        return r15;
    L20:
        if (r12 >= this.mCreatedMenus.size()) goto L27;
        Fragment r17 = this.mCreatedMenus.get(r12);
        if (r13 != null) goto L24;
    L25:
        r17.onDestroyOptionsMenu();
    L26:
        r12 = r12 + 1;
        goto L20
    L24:
        if (r13.contains(r17) == true) goto L26;
        goto L25
    }

    void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions(true);
        endAnimatingAwayFragments();
        dispatchStateChange(-1);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher == null) goto L5;
        this.mOnBackPressedCallback.remove();
        this.mOnBackPressedDispatcher = null;
    L5:
        ActivityResultLauncher<Intent> r10 = this.mStartActivityForResult;
        if (r10 == null) goto L9;
        r10.unregister();
        this.mStartIntentSenderForResult.unregister();
        this.mRequestPermissions.unregister();
        return;
    }

    void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    void dispatchLowMemory() {
        Iterator<Fragment> r10 = this.mFragmentStore.getFragments().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Fragment r11 = r10.next();
        if (r11 == null) goto L4;
        r11.performLowMemory();
        goto L4
    }

    void dispatchMultiWindowModeChanged(boolean r10) {
        Iterator<Fragment> r11 = this.mFragmentStore.getFragments().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Fragment r12 = r11.next();
        if (r12 == null) goto L4;
        r12.performMultiWindowModeChanged(r10);
        goto L4
    }

    void dispatchOnAttachFragment(@NonNull Fragment r10) {
        Iterator<FragmentOnAttachListener> r11 = this.mOnAttachListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onAttachFragment(this, r10);
        goto L4
    }

    boolean dispatchOptionsItemSelected(@NonNull MenuItem r10) {
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r11 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        Fragment r12 = r11.next();
        if (r12 == null) goto L7;
        if (r12.performOptionsItemSelected(r10) == false) goto L7;
        return true;
    L13:
        return false;
    }

    void dispatchOptionsMenuClosed(@NonNull Menu r10) {
        if (this.mCurState >= 1) goto L5;
        return;
    L5:
        Iterator<Fragment> r11 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        Fragment r12 = r11.next();
        if (r12 == null) goto L7;
        r12.performOptionsMenuClosed(r10);
        goto L7
    }

    void dispatchPause() {
        dispatchStateChange(5);
    }

    void dispatchPictureInPictureModeChanged(boolean r10) {
        Iterator<Fragment> r11 = this.mFragmentStore.getFragments().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Fragment r12 = r11.next();
        if (r12 == null) goto L4;
        r12.performPictureInPictureModeChanged(r10);
        goto L4
    }

    boolean dispatchPrepareOptionsMenu(@NonNull Menu r10) {
        boolean r11 = false;
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r12 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r12.hasNext() == false) goto L15;
        Fragment r13 = r12.next();
        if (r13 == null) goto L7;
        if (isParentMenuVisible(r13) == false) goto L7;
        if (r13.performPrepareOptionsMenu(r10) == false) goto L7;
        r11 = true;
        goto L7
    L15:
        return r11;
    }

    void dispatchPrimaryNavigationFragmentChanged() {
        updateOnBackPressedCallbackEnabled();
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(7);
    }

    void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(5);
    }

    void dispatchStop() {
        this.mStopped = true;
        this.mNonConfig.setIsStateSaved(true);
        dispatchStateChange(4);
    }

    void dispatchViewCreated() {
        dispatchStateChange(2);
    }

    public void dump(@NonNull String r10, @Nullable FileDescriptor r11, @NonNull PrintWriter r12, @Nullable String[] r13) {
        String r14 = r10 + "    ";
        this.mFragmentStore.dump(r10, r11, r12, r13);
        ArrayList<Fragment> r15 = this.mCreatedMenus;
        int r16 = 0;
        if (r15 == null) goto L9;
        int r17 = r15.size();
        if (r17 <= 0) goto L9;
        r12.print(r10);
        r12.println("Fragments Created Menus:");
        int r18 = 0;
    L7:
        if (r18 >= r17) goto L9;
        Fragment r19 = this.mCreatedMenus.get(r18);
        r12.print(r10);
        r12.print("  #");
        r12.print(r18);
        r12.print(": ");
        r12.println(r19.toString());
        r18 = r18 + 1;
    L9:
        ArrayList<BackStackRecord> r20 = this.mBackStack;
        if (r20 == null) goto L16;
        int r21 = r20.size();
        if (r21 <= 0) goto L16;
        r12.print(r10);
        r12.println("Back Stack:");
        int r22 = 0;
    L14:
        if (r22 >= r21) goto L16;
        BackStackRecord r23 = this.mBackStack.get(r22);
        r12.print(r10);
        r12.print("  #");
        r12.print(r22);
        r12.print(": ");
        r12.println(r23.toString());
        r23.dump(r14, r12);
        r22 = r22 + 1;
    L16:
        r12.print(r10);
        r12.println("Back Stack Index: " + this.mBackStackIndex.get());
        ArrayList<OpGenerator> r24 = this.mPendingActions;
        monitor-enter(r24);
        int r25 = this.mPendingActions.size();     // Catch: Throwable -> L31
        if (r25 <= 0) goto L23;
        r12.print(r10);     // Catch: Throwable -> L31
        r12.println("Pending Actions:");     // Catch: Throwable -> L31
    L21:
        if (r16 >= r25) goto L23;
        OpGenerator r26 = this.mPendingActions.get(r16);     // Catch: Throwable -> L31
        r12.print(r10);     // Catch: Throwable -> L31
        r12.print("  #");     // Catch: Throwable -> L31
        r12.print(r16);     // Catch: Throwable -> L31
        r12.print(": ");     // Catch: Throwable -> L31
        r12.println(r26);     // Catch: Throwable -> L31
        r16 = r16 + 1;     // Catch: Throwable -> L31
    L23:
        monitor-exit(r24);     // Catch: Throwable -> L31
        r12.print(r10);
        r12.println("FragmentManager misc state:");
        r12.print(r10);
        r12.print("  mHost=");
        r12.println(this.mHost);
        r12.print(r10);
        r12.print("  mContainer=");
        r12.println(this.mContainer);
        if (this.mParent == null) goto L27;
        r12.print(r10);
        r12.print("  mParent=");
        r12.println(this.mParent);
    L27:
        r12.print(r10);
        r12.print("  mCurState=");
        r12.print(this.mCurState);
        r12.print(" mStateSaved=");
        r12.print(this.mStateSaved);
        r12.print(" mStopped=");
        r12.print(this.mStopped);
        r12.print(" mDestroyed=");
        r12.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate == false) goto L39;
        r12.print(r10);
        r12.print("  mNeedMenuInvalidate=");
        r12.println(this.mNeedMenuInvalidate);
        return;
    L39:
        return;
    L31:
        th = move-exception;
        throw th;
    }

    void enqueueAction(@NonNull OpGenerator r10, boolean r11) {
        if (r11 == false) goto L4;
    L12:
        ArrayList<OpGenerator> r12 = this.mPendingActions;
        monitor-enter(r12);
    L24:
        th = move-exception;
        throw th;
    L15:
        if (this.mHost != null) goto L21;
        if (r11 == false) goto L20;
        monitor-exit(r12);     // Catch: Throwable -> L24
        return;
    L20:
        throw new IllegalStateException("Activity has been destroyed");     // Catch: Throwable -> L24
    L21:
        this.mPendingActions.add(r10);     // Catch: Throwable -> L24
        scheduleCommit();     // Catch: Throwable -> L24
        monitor-exit(r12);     // Catch: Throwable -> L24
        return;
    L4:
        if (this.mHost == null) goto L6;
        checkStateLoss();
        goto L12
    L6:
        if (this.mDestroyed == false) goto L10;
        throw new IllegalStateException("FragmentManager has been destroyed");
    L10:
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    }

    boolean execPendingActions(boolean r10) {
        ensureExecReady(r10);
        boolean r11 = false;
    L4:
        if (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop) == false) goto L11;
        this.mExecutingActions = true;
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);     // Catch: Throwable -> L8
        cleanupExec();
        r11 = true;
    L8:
        th = move-exception;
        cleanupExec();
        throw th;
    L11:
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return r11;
    }

    void execSingleAction(@NonNull OpGenerator r10, boolean r11) {
        if (r11 == true) goto L4;
    L8:
        ensureExecReady(r11);
        if (r10.generateOps(this.mTmpRecords, this.mTmpIsPop) == false) goto L16;
        this.mExecutingActions = true;
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);     // Catch: Throwable -> L13
        cleanupExec();
    L13:
        th = move-exception;
        cleanupExec();
        throw th;
    L16:
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return;
    L4:
        if (this.mHost != null) goto L6;
        return;
    L6:
        if (this.mDestroyed == false) goto L8;
    }

    public boolean executePendingTransactions() {
        boolean r10 = execPendingActions(true);
        forcePostponedTransactions();
        return r10;
    }

    @Nullable
    Fragment findActiveFragment(@NonNull String r10) {
        return this.mFragmentStore.findActiveFragment(r10);
    }

    @Nullable
    public Fragment findFragmentById(@IdRes int r10) {
        return this.mFragmentStore.findFragmentById(r10);
    }

    @Nullable
    public Fragment findFragmentByTag(@Nullable String r10) {
        return this.mFragmentStore.findFragmentByTag(r10);
    }

    Fragment findFragmentByWho(@NonNull String r10) {
        return this.mFragmentStore.findFragmentByWho(r10);
    }

    int getActiveFragmentCount() {
        return this.mFragmentStore.getActiveFragmentCount();
    }

    @NonNull
    List<Fragment> getActiveFragments() {
        return this.mFragmentStore.getActiveFragments();
    }

    @NonNull
    public BackStackEntry getBackStackEntryAt(int r10) {
        return this.mBackStack.get(r10);
    }

    public int getBackStackEntryCount() {
        ArrayList<BackStackRecord> r10 = this.mBackStack;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.size();
    }

    @NonNull
    FragmentContainer getContainer() {
        return this.mContainer;
    }

    @Nullable
    public Fragment getFragment(@NonNull Bundle r10, @NonNull String r11) {
        String r12 = r10.getString(r11);
        if (r12 != null) goto L6;
        return null;
    L6:
        Fragment r13 = findActiveFragment(r12);
        if (r13 != null) goto L9;
        throwException(new IllegalStateException("Fragment no longer exists for key " + r11 + ": unique id " + r12));
    L9:
        return r13;
    }

    @NonNull
    public FragmentFactory getFragmentFactory() {
        FragmentFactory r10 = this.mFragmentFactory;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Fragment r11 = this.mParent;
        if (r11 == null) goto L10;
        return r11.mFragmentManager.getFragmentFactory();
    L10:
        return this.mHostFragmentFactory;
    }

    @NonNull
    FragmentStore getFragmentStore() {
        return this.mFragmentStore;
    }

    @NonNull
    public List<Fragment> getFragments() {
        return this.mFragmentStore.getFragments();
    }

    @NonNull
    FragmentHostCallback<?> getHost() {
        return this.mHost;
    }

    @NonNull
    LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this.mLayoutInflaterFactory;
    }

    @NonNull
    FragmentLifecycleCallbacksDispatcher getLifecycleCallbacksDispatcher() {
        return this.mLifecycleCallbacksDispatcher;
    }

    @Nullable
    Fragment getParent() {
        return this.mParent;
    }

    @Nullable
    public Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    @NonNull
    SpecialEffectsControllerFactory getSpecialEffectsControllerFactory() {
        SpecialEffectsControllerFactory r10 = this.mSpecialEffectsControllerFactory;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Fragment r11 = this.mParent;
        if (r11 == null) goto L10;
        return r11.mFragmentManager.getSpecialEffectsControllerFactory();
    L10:
        return this.mDefaultSpecialEffectsControllerFactory;
    }

    @NonNull
    ViewModelStore getViewModelStore(@NonNull Fragment r10) {
        return this.mNonConfig.getViewModelStore(r10);
    }

    void handleOnBackPressed() {
        execPendingActions(true);
        if (this.mOnBackPressedCallback.isEnabled() == false) goto L5;
        popBackStackImmediate();
        return;
    L5:
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    void hideFragment(@NonNull Fragment r10) {
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "hide: " + r10);
    L6:
        if (r10.mHidden == true) goto L9;
        r10.mHidden = true;
        r10.mHiddenChanged = true ^ r10.mHiddenChanged;
        setVisibleRemovingFragment(r10);
        return;
    }

    void invalidateMenuForFragment(@NonNull Fragment r10) {
        if (r10.mAdded == true) goto L5;
        return;
    L5:
        if (isMenuAvailable(r10) == false) goto L9;
        this.mNeedMenuInvalidate = true;
        return;
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    boolean isParentMenuVisible(@Nullable Fragment r10) {
        if (r10 != null) goto L6;
        return true;
    L6:
        return r10.isMenuVisible();
    }

    boolean isPrimaryNavigation(@Nullable Fragment r10) {
        if (r10 != null) goto L5;
        return true;
    L5:
        FragmentManager r11 = r10.mFragmentManager;
        if (r10.equals(r11.getPrimaryNavigationFragment()) == true) goto L8;
    L10:
        return false;
    L8:
        if (isPrimaryNavigation(r11.mParent) == false) goto L10;
        return true;
    }

    boolean isStateAtLeast(int r10) {
        if (this.mCurState < r10) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isStateSaved() {
        if (this.mStateSaved == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mStopped == true) goto L8;
        return false;
    }

    void launchRequestPermissions(@NonNull Fragment r10, @NonNull String[] r11, int r12) {
        if (this.mRequestPermissions == null) goto L5;
        LaunchedFragmentInfo r13 = new LaunchedFragmentInfo(r10.mWho, r12);
        this.mLaunchedFragments.addLast(r13);
        this.mRequestPermissions.launch(r11);
        return;
    L5:
        this.mHost.onRequestPermissionsFromFragment(r10, r11, r12);
    }

    void launchStartActivityForResult(@NonNull Fragment r10, @SuppressLint({"UnknownNullness"}) Intent r11, int r12, @Nullable Bundle r13) {
        if (this.mStartActivityForResult == null) goto L9;
        LaunchedFragmentInfo r14 = new LaunchedFragmentInfo(r10.mWho, r12);
        this.mLaunchedFragments.addLast(r14);
        if (r11 == null) goto L8;
        if (r13 == null) goto L8;
        r11.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r13);
    L8:
        this.mStartActivityForResult.launch(r11);
        return;
    L9:
        this.mHost.onStartActivityFromFragment(r10, r11, r12, r13);
    }

    void launchStartIntentSenderForResult(@NonNull Fragment r11, @SuppressLint({"UnknownNullness"}) IntentSender r12, int r13, @Nullable Intent r14, int r15, int r16, int r17, @Nullable Bundle r18) {
        if (this.mStartIntentSenderForResult != null) goto L5;
        this.mHost.onStartIntentSenderFromFragment(r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    L5:
        if (r18 == null) goto L13;
        if (r14 != null) goto L8;
        Intent r10 = new Intent();
        r10.putExtra(EXTRA_CREATED_FILLIN_INTENT, true);
    L10:
        if (isLoggingEnabled(2) == false) goto L12;
        Log.v(TAG, "ActivityOptions " + r18 + " were added to fillInIntent " + r10 + " for fragment " + r11);
    L12:
        r10.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r18);
    L14:
        IntentSenderRequest r19 = new IntentSenderRequest.Builder(r12).setFillInIntent(r10).setFlags(r16, r15).build();
        this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(r11.mWho, r13));
        if (isLoggingEnabled(2) == false) goto L17;
        Log.v(TAG, "Fragment " + r11 + "is launching an IntentSender for result ");
    L17:
        this.mStartIntentSenderForResult.launch(r19);
        return;
    L8:
        r10 = r14;
        goto L10
    L13:
        r10 = r14;
        goto L14
    }

    void moveFragmentToExpectedState(@NonNull Fragment r10) {
        if (this.mFragmentStore.containsActiveFragment(r10.mWho) == false) goto L5;
        moveToState(r10);
        View r11 = r10.mView;
        if (r11 == null) goto L24;
        if (r10.mIsNewlyAdded == false) goto L24;
        if (r10.mContainer == null) goto L24;
        float r12 = r10.mPostponedAlpha;
        if (r12 <= 0.0f) goto L17;
        r11.setAlpha(r12);
    L17:
        r10.mPostponedAlpha = 0.0f;
        r10.mIsNewlyAdded = false;
        FragmentAnim.AnimationOrAnimator r13 = FragmentAnim.loadAnimation(this.mHost.getContext(), r10, true, r10.getPopDirection());
        if (r13 == null) goto L24;
        Animation r14 = r13.animation;
        if (r14 == null) goto L22;
        r10.mView.startAnimation(r14);
        goto L24
    L22:
        r13.animator.setTarget(r10.mView);
        r13.animator.start();
    L24:
        if (r10.mHiddenChanged == false) goto L28;
        completeShowHideFragment(r10);
        return;
    L28:
        return;
    L5:
        if (isLoggingEnabled(3) == false) goto L27;
        Log.d(TAG, "Ignoring moving " + r10 + " to state " + this.mCurState + "since it is not added to " + this);
        return;
    }

    void moveToState(int r10, boolean r11) {
        if (this.mHost == null) goto L5;
    L9:
        if (r11 == false) goto L11;
    L13:
        this.mCurState = r10;
        if (USE_STATE_MANAGER == false) goto L16;
        this.mFragmentStore.moveToExpectedState();
    L34:
        startPendingDeferredFragments();
        if (this.mNeedMenuInvalidate == false) goto L48;
        FragmentHostCallback<?> r12 = this.mHost;
        if (r12 != null) goto L39;
        return;
    L39:
        if (this.mCurState != 7) goto L50;
        r12.onSupportInvalidateOptionsMenu();
        this.mNeedMenuInvalidate = false;
        return;
    L50:
        return;
    L48:
        return;
    L16:
        Iterator<Fragment> r13 = this.mFragmentStore.getFragments().iterator();
    L18:
        if (r13.hasNext() == false) goto L20;
        moveFragmentToExpectedState(r13.next());
        goto L18
    L20:
        Iterator<FragmentStateManager> r14 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L22:
        if (r14.hasNext() == false) goto L34;
        FragmentStateManager r15 = r14.next();
        Fragment r16 = r15.getFragment();
        if (r16.mIsNewlyAdded == true) goto L27;
        moveFragmentToExpectedState(r16);
    L27:
        if (r16.mRemoving == true) goto L29;
    L31:
        boolean r17 = false;
    L32:
        if (r17 == false) goto L22;
        this.mFragmentStore.makeInactive(r15);
        goto L22
    L29:
        if (r16.isInBackStack() == true) goto L31;
        r17 = true;
        goto L32
    L11:
        if (r10 != this.mCurState) goto L13;
        return;
    L5:
        if (r10 == (-1)) goto L9;
        throw new IllegalStateException("No activity");
    }

    void moveToState(@NonNull Fragment r10) {
        moveToState(r10, this.mCurState);
    }

    void moveToState(@NonNull Fragment r11, int r12) {
        FragmentStateManager r10 = this.mFragmentStore.getFragmentStateManager(r11.mWho);
        int r13 = 1;
        if (r10 != null) goto L6;
        r10 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r11);
        r10.setFragmentManagerState(1);
    L6:
        if (r11.mFromLayout == true) goto L8;
    L12:
        int r14 = Math.min(r12, r10.computeExpectedState());
        int r15 = r11.mState;
        if (r15 > r14) goto L40;
        if (r15 < r14) goto L16;
    L18:
        int r16 = r11.mState;
        if (r16 == (-1)) goto L26;
        if (r16 == 0) goto L28;
        if (r16 == 1) goto L30;
        if (r16 == 2) goto L34;
        if (r16 == 4) goto L36;
        if (r16 != 5) goto L102;
    L38:
        if (r14 <= 5) goto L102;
        r10.resume();
    L102:
        if (r11.mState != r14) goto L104;
        return;
    L104:
        if (isLoggingEnabled(3) == false) goto L106;
        Log.d(TAG, "moveToState: Fragment state for " + r11 + " not updated inline; expected state " + r14 + " found " + r11.mState);
    L106:
        r11.mState = r14;
        return;
    L36:
        if (r14 <= 4) goto L38;
        r10.start();
    L34:
        if (r14 <= 2) goto L36;
        r10.activityCreated();
    L30:
        if (r14 <= (-1)) goto L32;
        r10.ensureInflatedView();
    L32:
        if (r14 <= 1) goto L34;
        r10.createView();
    L28:
        if (r14 <= 0) goto L30;
        r10.create();
        goto L30
    L26:
        if (r14 <= (-1)) goto L28;
        r10.attach();
        goto L28
    L16:
        if (this.mExitAnimationCancellationSignals.isEmpty() == true) goto L18;
        cancelExitAnimation(r11);
        goto L18
    L40:
        if (r15 <= r14) goto L102;
        if (r15 == 0) goto L97;
        if (r15 == 1) goto L92;
        if (r15 == 2) goto L64;
        if (r15 == 4) goto L53;
        if (r15 != 5) goto L47;
    L51:
        if (r14 >= 5) goto L53;
        r10.stop();
        goto L53
    L47:
        if (r15 != 7) goto L102;
        if (r14 >= 7) goto L51;
        r10.pause();
    L53:
        if (r14 >= 4) goto L64;
        if (isLoggingEnabled(3) == false) goto L58;
        Log.d(TAG, "movefrom ACTIVITY_CREATED: " + r11);
    L58:
        if (r11.mView == null) goto L64;
        if (this.mHost.onShouldSaveFragmentState(r11) == false) goto L64;
        if (r11.mSavedViewState != null) goto L64;
        r10.saveViewState();
    L64:
        if (r14 >= 2) goto L92;
        FragmentAnim.AnimationOrAnimator r17 = null;
        View r18 = r11.mView;
        if (r18 == null) goto L90;
        ViewGroup r19 = r11.mContainer;
        if (r19 == null) goto L90;
        r19.endViewTransition(r18);
        r11.mView.clearAnimation();
        if (r11.isRemovingParent() == true) goto L90;
        if (this.mCurState > (-1)) goto L74;
    L80:
        r11.mPostponedAlpha = 0.0f;
        ViewGroup r20 = r11.mContainer;
        View r21 = r11.mView;
        if (r17 == null) goto L83;
        FragmentAnim.animateRemoveFragment(r11, r17, this.mFragmentTransitionCallback);
    L83:
        r20.removeView(r21);
        if (isLoggingEnabled(2) == false) goto L87;
        Log.v(TAG, "Removing view " + r21 + " for fragment " + r11 + " from container " + r20);
    L87:
        if (r20 == r11.mContainer) goto L90;
        return;
    L74:
        if (this.mDestroyed == true) goto L80;
        if (r11.mView.getVisibility() != 0) goto L80;
        if (r11.mPostponedAlpha < 0.0f) goto L80;
        r17 = FragmentAnim.loadAnimation(this.mHost.getContext(), r11, false, r11.getPopDirection());
    L90:
        if (this.mExitAnimationCancellationSignals.get(r11) != null) goto L92;
        r10.destroyFragmentView();
    L92:
        if (r14 >= 1) goto L97;
        if (this.mExitAnimationCancellationSignals.get(r11) != null) goto L98;
        r10.destroy();
    L98:
        if (r13 >= 0) goto L100;
        r10.detach();
    L100:
        r14 = r13;
    L97:
        r13 = r14;
        goto L98
    L8:
        if (r11.mInLayout == false) goto L12;
        if (r11.mState != 2) goto L12;
        r12 = Math.max(r12, 2);
        goto L12
    }

    void noteStateNotSaved() {
        if (this.mHost != null) goto L5;
        return;
    L5:
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        Iterator<Fragment> r10 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        Fragment r11 = r10.next();
        if (r11 == null) goto L7;
        r11.noteStateNotSaved();
        goto L7
    }

    void onContainerAvailable(@NonNull FragmentContainerView r10) {
        Iterator<FragmentStateManager> r11 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        FragmentStateManager r12 = r11.next();
        Fragment r13 = r12.getFragment();
        if (r13.mContainerId != r10.getId()) goto L4;
        View r14 = r13.mView;
        if (r14 == null) goto L4;
        if (r14.getParent() != null) goto L4;
        r13.mContainer = r10;
        r12.addViewToContainer();
        goto L4
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    void performPendingDeferredStart(@NonNull FragmentStateManager r10) {
        Fragment r11 = r10.getFragment();
        if (r11.mDeferStart == true) goto L5;
        return;
    L5:
        if (this.mExecutingActions == false) goto L8;
        this.mHavePendingDeferredStart = true;
        return;
    L8:
        r11.mDeferStart = false;
        if (USE_STATE_MANAGER == false) goto L11;
        r10.moveToExpectedState();
        return;
    L11:
        moveToState(r11);
    }

    public void popBackStack() {
        enqueueAction(new PopBackStackState(this, null, -1, 0), false);
    }

    public void popBackStack(int r10, int r11) {
        if (r10 < 0) goto L6;
        enqueueAction(new PopBackStackState(this, null, r10, r11), false);
        return;
    L6:
        throw new IllegalArgumentException("Bad id: " + r10);
    }

    public void popBackStack(@Nullable String r10, int r11) {
        enqueueAction(new PopBackStackState(this, r10, -1, r11), false);
    }

    public boolean popBackStackImmediate() {
        return popBackStackImmediate(null, -1, 0);
    }

    public boolean popBackStackImmediate(int r10, int r11) {
        if (r10 < 0) goto L6;
        return popBackStackImmediate(null, r10, r11);
    L6:
        throw new IllegalArgumentException("Bad id: " + r10);
    }

    public boolean popBackStackImmediate(@Nullable String r10, int r11) {
        return popBackStackImmediate(r10, -1, r11);
    }

    boolean popBackStackState(@NonNull ArrayList<BackStackRecord> r10, @NonNull ArrayList<Boolean> r11, @Nullable String r12, int r13, int r14) {
        ArrayList<BackStackRecord> r15 = this.mBackStack;
        if (r15 != null) goto L6;
        return false;
    L6:
        if (r12 != null) goto L14;
        if (r13 >= 0) goto L14;
        if ((r14 & 1) != 0) goto L14;
        int r16 = r15.size() - 1;
        if (r16 >= 0) goto L13;
        return false;
    L13:
        r10.add(this.mBackStack.remove(r16));
        r11.add(Boolean.TRUE);
    L51:
        return true;
    L14:
        if (r12 != null) goto L18;
        if (r13 >= 0) goto L18;
        int r17 = -1;
    L46:
        if (r17 != (this.mBackStack.size() - 1)) goto L48;
        return false;
    L48:
        int r18 = this.mBackStack.size() - 1;
    L49:
        if (r18 <= r17) goto L51;
        r10.add(this.mBackStack.remove(r18));
        r11.add(Boolean.TRUE);
        r18 = r18 - 1;
    L18:
        int r19 = r15.size() - 1;
    L19:
        if (r19 < 0) goto L30;
        BackStackRecord r20 = this.mBackStack.get(r19);
        if (r12 != null) goto L23;
    L25:
        if (r13 < 0) goto L29;
        if (r13 == r20.mIndex) goto L30;
    L29:
        r19 = r19 - 1;
        goto L19
    L23:
        if (r12.equals(r20.getName()) == false) goto L25;
    L30:
        if (r19 >= 0) goto L33;
        return false;
    L33:
        if ((r14 & 1) == 0) goto L44;
    L34:
        r19 = r19 - 1;
        if (r19 < 0) goto L44;
        BackStackRecord r110 = this.mBackStack.get(r19);
        if (r12 == null) goto L40;
        if (r12.equals(r110.getName()) == true) goto L34;
    L40:
        if (r13 < 0) goto L44;
        if (r13 == r110.mIndex) goto L34;
    L44:
        r17 = r19;
        goto L46
    }

    public void putFragment(@NonNull Bundle r10, @NonNull String r11, @NonNull Fragment r12) {
        if (r12.mFragmentManager == this) goto L5;
        throwException(new IllegalStateException("Fragment " + r12 + " is not currently in the FragmentManager"));
    L5:
        r10.putString(r11, r12.mWho);
    }

    public void registerFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks r10, boolean r11) {
        this.mLifecycleCallbacksDispatcher.registerFragmentLifecycleCallbacks(r10, r11);
    }

    void removeCancellationSignal(@NonNull Fragment r10, @NonNull CancellationSignal r11) {
        HashSet<CancellationSignal> r12 = this.mExitAnimationCancellationSignals.get(r10);
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.remove(r11) == true) goto L7;
        return;
    L7:
        if (r12.isEmpty() == false) goto L14;
        this.mExitAnimationCancellationSignals.remove(r10);
        if (r10.mState >= 5) goto L15;
        destroyFragmentView(r10);
        moveToState(r10);
        return;
    L15:
        return;
    }

    void removeFragment(@NonNull Fragment r10) {
        if (isLoggingEnabled(2) == false) goto L5;
        Log.v(TAG, "remove: " + r10 + " nesting=" + r10.mBackStackNesting);
    L5:
        boolean r11 = !r10.isInBackStack();
        if (r10.mDetached == false) goto L8;
        if (r11 == true) goto L8;
        return;
    L8:
        this.mFragmentStore.removeFragment(r10);
        if (isMenuAvailable(r10) == false) goto L11;
        this.mNeedMenuInvalidate = true;
    L11:
        r10.mRemoving = true;
        setVisibleRemovingFragment(r10);
    }

    public void removeFragmentOnAttachListener(@NonNull FragmentOnAttachListener r10) {
        this.mOnAttachListeners.remove(r10);
    }

    public void removeOnBackStackChangedListener(@NonNull OnBackStackChangedListener r10) {
        ArrayList<OnBackStackChangedListener> r11 = this.mBackStackChangeListeners;
        if (r11 == null) goto L6;
        r11.remove(r10);
        return;
    }

    void removeRetainedFragment(@NonNull Fragment r10) {
        this.mNonConfig.removeRetainedFragment(r10);
    }

    void restoreAllState(@Nullable Parcelable r10, @Nullable FragmentManagerNonConfig r11) {
        if ((this.mHost instanceof ViewModelStoreOwner) == false) goto L5;
        throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
    L5:
        this.mNonConfig.restoreFromSnapshot(r11);
        restoreSaveState(r10);
    }

    void restoreSaveState(@Nullable Parcelable r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        FragmentManagerState r13 = (FragmentManagerState) r12;
        if (r13.mActive != null) goto L7;
        return;
    L7:
        this.mFragmentStore.resetActiveFragments();
        Iterator<FragmentState> r10 = r13.mActive.iterator();
    L9:
        if (r10.hasNext() == false) goto L23;
        FragmentState r11 = r10.next();
        if (r11 == null) goto L9;
        Fragment r14 = this.mNonConfig.findRetainedFragmentByWho(r11.mWho);
        if (r14 != null) goto L15;
        FragmentStateManager r15 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.getContext().getClassLoader(), getFragmentFactory(), r11);
    L19:
        Fragment r16 = r15.getFragment();
        r16.mFragmentManager = this;
        if (isLoggingEnabled(2) == false) goto L22;
        Log.v(TAG, "restoreSaveState: active (" + r16.mWho + "): " + r16);
    L22:
        r15.restoreState(this.mHost.getContext().getClassLoader());
        this.mFragmentStore.makeActive(r15);
        r15.setFragmentManagerState(this.mCurState);
        goto L9
    L15:
        if (isLoggingEnabled(2) == false) goto L17;
        Log.v(TAG, "restoreSaveState: re-attaching retained " + r14);
    L17:
        r15 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r14, r11);
        goto L19
    L23:
        Iterator<Fragment> r17 = this.mNonConfig.getRetainedFragments().iterator();
    L25:
        if (r17.hasNext() == false) goto L32;
        Fragment r18 = r17.next();
        if (this.mFragmentStore.containsActiveFragment(r18.mWho) == true) goto L25;
        if (isLoggingEnabled(2) == false) goto L31;
        Log.v(TAG, "Discarding retained Fragment " + r18 + " that was not found in the set of active Fragments " + r13.mActive);
    L31:
        this.mNonConfig.removeRetainedFragment(r18);
        r18.mFragmentManager = this;
        FragmentStateManager r19 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r18);
        r19.setFragmentManagerState(1);
        r19.moveToExpectedState();
        r18.mRemoving = true;
        r19.moveToExpectedState();
        goto L25
    L32:
        this.mFragmentStore.restoreAddedFragments(r13.mAdded);
        int r20 = 0;
        if (r13.mBackStack == null) goto L41;
        this.mBackStack = new ArrayList(r13.mBackStack.length);
        int r21 = 0;
    L35:
        BackStackState[] r22 = r13.mBackStack;
        if (r21 >= r22.length) goto L42;
        BackStackRecord r23 = r22[r21].instantiate(this);
        if (isLoggingEnabled(2) == false) goto L40;
        Log.v(TAG, "restoreAllState: back stack #" + r21 + " (index " + r23.mIndex + "): " + r23);
        PrintWriter r24 = new PrintWriter(new LogWriter(TAG));
        r23.dump("  ", r24, false);
        r24.close();
    L40:
        this.mBackStack.add(r23);
        r21 = r21 + 1;
    L42:
        this.mBackStackIndex.set(r13.mBackStackIndex);
        String r25 = r13.mPrimaryNavActiveWho;
        if (r25 == null) goto L45;
        Fragment r26 = findActiveFragment(r25);
        this.mPrimaryNav = r26;
        dispatchParentPrimaryNavigationFragmentChanged(r26);
    L45:
        ArrayList<String> r27 = r13.mResultKeys;
        if (r27 != null) goto L48;
    L50:
        this.mLaunchedFragments = new ArrayDeque(r13.mLaunchedFragments);
        return;
    L48:
        if (r20 >= r27.size()) goto L50;
        Bundle r28 = r13.mResults.get(r20);
        r28.setClassLoader(this.mHost.getContext().getClassLoader());
        this.mResults.put(r27.get(r20), r28);
        r20 = r20 + 1;
        goto L48
    L41:
        this.mBackStack = null;
        goto L42
    }

    @Deprecated
    FragmentManagerNonConfig retainNonConfig() {
        if ((this.mHost instanceof ViewModelStoreOwner) == false) goto L6;
        throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
    L6:
        return this.mNonConfig.getSnapshot();
    }

    Parcelable saveAllState() {
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.setIsStateSaved(true);
        ArrayList<FragmentState> r10 = this.mFragmentStore.saveActiveFragments();
        BackStackState[] r11 = null;
        if (r10.isEmpty() == true) goto L5;
        ArrayList<String> r12 = this.mFragmentStore.saveAddedFragments();
        ArrayList<BackStackRecord> r13 = this.mBackStack;
        if (r13 == null) goto L18;
        int r14 = r13.size();
        if (r14 <= 0) goto L18;
        r11 = new BackStackState[r14];
        int r15 = 0;
    L13:
        if (r15 >= r14) goto L18;
        r11[r15] = new BackStackState(this.mBackStack.get(r15));
        if (isLoggingEnabled(2) == false) goto L17;
        Log.v(TAG, "saveAllState: adding back stack #" + r15 + ": " + this.mBackStack.get(r15));
    L17:
        r15 = r15 + 1;
    L18:
        FragmentManagerState r16 = new FragmentManagerState();
        r16.mActive = r10;
        r16.mAdded = r12;
        r16.mBackStack = r11;
        r16.mBackStackIndex = this.mBackStackIndex.get();
        Fragment r17 = this.mPrimaryNav;
        if (r17 == null) goto L21;
        r16.mPrimaryNavActiveWho = r17.mWho;
    L21:
        r16.mResultKeys.addAll(this.mResults.keySet());
        r16.mResults.addAll(this.mResults.values());
        r16.mLaunchedFragments = new ArrayList(this.mLaunchedFragments);
        return r16;
    L5:
        if (isLoggingEnabled(2) == false) goto L7;
        Log.v(TAG, "saveAllState: no fragments!");
    L7:
        return null;
    }

    @Nullable
    public Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment r10) {
        FragmentStateManager r11 = this.mFragmentStore.getFragmentStateManager(r10.mWho);
        if (r11 != null) goto L5;
    L6:
        throwException(new IllegalStateException("Fragment " + r10 + " is not currently in the FragmentManager"));
    L8:
        return r11.saveInstanceState();
    L5:
        if (r11.getFragment().equals(r10) == true) goto L8;
        goto L6
    }

    void scheduleCommit() {
        ArrayList<OpGenerator> r10 = this.mPendingActions;
        monitor-enter(r10);
        ArrayList<StartEnterTransitionListener> r11 = this.mPostponedTransactions;     // Catch: Throwable -> L18
        boolean r12 = false;
        if (r11 != null) goto L7;
    L9:
        boolean r13 = false;
    L11:
        if (this.mPendingActions.size() != 1) goto L13;
        r12 = true;
    L13:
        if (r13 == true) goto L15;
        if (r12 == true) goto L15;
    L16:
        monitor-exit(r10);     // Catch: Throwable -> L18
        return;
    L15:
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L18
        this.mHost.getHandler().post(this.mExecCommit);     // Catch: Throwable -> L18
        updateOnBackPressedCallbackEnabled();     // Catch: Throwable -> L18
        goto L16
    L7:
        if (r11.isEmpty() == true) goto L9;
        r13 = true;
    L18:
        th = move-exception;
        throw th;
    }

    void setExitAnimationOrder(@NonNull Fragment r10, boolean r11) {
        ViewGroup r12 = getFragmentContainer(r10);
        if (r12 != null) goto L5;
        return;
    L5:
        if ((r12 instanceof FragmentContainerView) == false) goto L9;
        ((FragmentContainerView) r12).setDrawDisappearingViewsLast(!r11);
        return;
    }

    public void setFragmentFactory(@NonNull FragmentFactory r10) {
        this.mFragmentFactory = r10;
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void setFragmentResult(@NonNull String r10, @NonNull Bundle r11) {
        LifecycleAwareResultListener r12 = this.mResultListeners.get(r10);
        if (r12 != null) goto L5;
    L7:
        this.mResults.put(r10, r11);
        return;
    L5:
        if (r12.isAtLeast(Lifecycle.State.STARTED) == false) goto L7;
        r12.onFragmentResult(r10, r11);
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    @SuppressLint({"SyntheticAccessor"})
    public final void setFragmentResultListener(@NonNull final String r10, @NonNull LifecycleOwner r11, @NonNull final FragmentResultListener r12) {
        final Lifecycle r13 = r11.getLifecycle();
        if (r13.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        LifecycleEventObserver r14 = new AnonymousClass6(this, r10, r12, r13);
        r13.addObserver(r14);
        LifecycleAwareResultListener r15 = this.mResultListeners.put(r10, new LifecycleAwareResultListener(r13, r12, r14));
        if (r15 == null) goto L9;
        r15.removeObserver();
        return;
    }

    void setMaxLifecycle(@NonNull Fragment r10, @NonNull Lifecycle.State r11) {
        if (r10.equals(findActiveFragment(r10.mWho)) == false) goto L11;
        if (r10.mHost != null) goto L7;
    L8:
        r10.mMaxState = r11;
        return;
    L7:
        if (r10.mFragmentManager == this) goto L8;
    L11:
        throw new IllegalArgumentException("Fragment " + r10 + " is not an active fragment of FragmentManager " + this);
    }

    void setPrimaryNavigationFragment(@Nullable Fragment r10) {
        if (r10 != null) goto L4;
    L12:
        Fragment r11 = this.mPrimaryNav;
        this.mPrimaryNav = r10;
        dispatchParentPrimaryNavigationFragmentChanged(r11);
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
        return;
    L4:
        if (r10.equals(findActiveFragment(r10.mWho)) == false) goto L11;
        if (r10.mHost == null) goto L12;
        if (r10.mFragmentManager == this) goto L12;
    L11:
        throw new IllegalArgumentException("Fragment " + r10 + " is not an active fragment of FragmentManager " + this);
    }

    void setSpecialEffectsControllerFactory(@NonNull SpecialEffectsControllerFactory r10) {
        this.mSpecialEffectsControllerFactory = r10;
    }

    void showFragment(@NonNull Fragment r10) {
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "show: " + r10);
    L6:
        if (r10.mHidden == false) goto L9;
        r10.mHidden = false;
        r10.mHiddenChanged = !r10.mHiddenChanged;
        return;
    }

    @NonNull
    public String toString() {
        StringBuilder r10 = new StringBuilder(128);
        r10.append("FragmentManager{");
        r10.append(Integer.toHexString(System.identityHashCode(this)));
        r10.append(" in ");
        Fragment r11 = this.mParent;
        if (r11 == null) goto L6;
        r10.append(r11.getClass().getSimpleName());
        r10.append("{");
        Object r12 = this.mParent;
    L5:
        r10.append(Integer.toHexString(System.identityHashCode(r12)));
        r10.append("}");
    L10:
        r10.append("}}");
        return r10.toString();
    L6:
        FragmentHostCallback<?> r13 = this.mHost;
        if (r13 == null) goto L9;
        r10.append(r13.getClass().getSimpleName());
        r10.append("{");
        r12 = this.mHost;
        goto L5
    L9:
        r10.append("null");
        goto L10
    }

    public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks r10) {
        this.mLifecycleCallbacksDispatcher.unregisterFragmentLifecycleCallbacks(r10);
    }
}
