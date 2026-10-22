package androidx.fragment.app;

import ai.j0;
import android.annotation.SuppressLint;
import android.app.Activity;
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
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.R;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager implements FragmentResultOwner {
    private static boolean DEBUG = false;
    private static final String EXTRA_CREATED_FILLIN_INTENT = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    private static final String FRAGMENT_KEY_PREFIX = "fragment_";
    private static final String FRAGMENT_MANAGER_STATE_KEY = "state";
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    private static final String RESULT_KEY_PREFIX = "result_";
    private static final String SAVED_STATE_KEY = "android:support:fragments";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String TAG = "FragmentManager";
    ArrayList<BackStackRecord> mBackStack;
    private ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    private final AtomicInteger mBackStackIndex;
    private final Map<String, BackStackState> mBackStackStates;
    private FragmentContainer mContainer;
    private ArrayList<Fragment> mCreatedMenus;
    int mCurState;
    private SpecialEffectsControllerFactory mDefaultSpecialEffectsControllerFactory;
    private boolean mDestroyed;
    private Runnable mExecCommit;
    private boolean mExecutingActions;
    private FragmentFactory mFragmentFactory;
    private final FragmentStore mFragmentStore;
    private boolean mHavePendingDeferredStart;
    private FragmentHostCallback<?> mHost;
    private FragmentFactory mHostFragmentFactory;
    ArrayDeque<LaunchedFragmentInfo> mLaunchedFragments;
    private final FragmentLayoutInflaterFactory mLayoutInflaterFactory;
    private final FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher;
    private final MenuProvider mMenuProvider;
    private boolean mNeedMenuInvalidate;
    private FragmentManagerViewModel mNonConfig;
    private final CopyOnWriteArrayList<FragmentOnAttachListener> mOnAttachListeners;
    private final OnBackPressedCallback mOnBackPressedCallback;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final Consumer<Configuration> mOnConfigurationChangedListener;
    private final Consumer<MultiWindowModeChangedInfo> mOnMultiWindowModeChangedListener;
    private final Consumer<PictureInPictureModeChangedInfo> mOnPictureInPictureModeChangedListener;
    private final Consumer<Integer> mOnTrimMemoryListener;
    private Fragment mParent;
    private final ArrayList<OpGenerator> mPendingActions;

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
    private FragmentStrictMode.Policy mStrictModePolicy;
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

    public class ClearBackStackState implements OpGenerator {
        private final String mName;
        final /* synthetic */ FragmentManager this$0;

        public ClearBackStackState(@NonNull FragmentManager r5, String r10) {
            this.this$0 = r5;
            this.mName = r10;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(@NonNull ArrayList<BackStackRecord> r5, @NonNull ArrayList<Boolean> r10) {
            return this.this$0.clearBackStackState(r5, r10, this.mName);
        }
    }

    public static class FragmentIntentSenderContract extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        public FragmentIntentSenderContract() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context r5, IntentSenderRequest r10) {
            return createIntent2(r5, r10);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public /* bridge */ /* synthetic */ ActivityResult parseResult(int r5, @Nullable Intent r10) {
            return parseResult(r5, r10);
        }

        @NonNull
        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NonNull Context r5, IntentSenderRequest r10) {
            Intent r11 = new Intent(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST);
            Intent r12 = r10.getFillInIntent();
            if (r12 == null) goto L9;
            Bundle r13 = r12.getBundleExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            if (r13 == null) goto L9;
            r11.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r13);
            r12.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            if (r12.getBooleanExtra(FragmentManager.EXTRA_CREATED_FILLIN_INTENT, false) == false) goto L9;
            r10 = new IntentSenderRequest.Builder(r10.getIntentSender()).setFillInIntent(null).setFlags(r10.getFlagsValues(), r10.getFlagsMask()).build();
        L9:
            r11.putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST, r10);
            if (FragmentManager.isLoggingEnabled(2) == false) goto L12;
            Log.v(FragmentManager.TAG, "CreateIntent created the following intent: " + r11);
        L12:
            return r11;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public ActivityResult parseResult(int r5, @Nullable Intent r10) {
            return new ActivityResult(r5, r10);
        }
    }

    public static abstract class FragmentLifecycleCallbacks {
        public FragmentLifecycleCallbacks() {
        }

        @Deprecated
        public void onFragmentActivityCreated(@NonNull FragmentManager r5, @NonNull Fragment r10, @Nullable Bundle r11) {
        }

        public void onFragmentAttached(@NonNull FragmentManager r5, @NonNull Fragment r10, @NonNull Context r11) {
        }

        public void onFragmentCreated(@NonNull FragmentManager r5, @NonNull Fragment r10, @Nullable Bundle r11) {
        }

        public void onFragmentDestroyed(@NonNull FragmentManager r5, @NonNull Fragment r10) {
        }

        public void onFragmentDetached(@NonNull FragmentManager r5, @NonNull Fragment r10) {
        }

        public void onFragmentPaused(@NonNull FragmentManager r5, @NonNull Fragment r10) {
        }

        public void onFragmentPreAttached(@NonNull FragmentManager r5, @NonNull Fragment r10, @NonNull Context r11) {
        }

        public void onFragmentPreCreated(@NonNull FragmentManager r5, @NonNull Fragment r10, @Nullable Bundle r11) {
        }

        public void onFragmentResumed(@NonNull FragmentManager r5, @NonNull Fragment r10) {
        }

        public void onFragmentSaveInstanceState(@NonNull FragmentManager r5, @NonNull Fragment r10, @NonNull Bundle r11) {
        }

        public void onFragmentStarted(@NonNull FragmentManager r5, @NonNull Fragment r10) {
        }

        public void onFragmentStopped(@NonNull FragmentManager r5, @NonNull Fragment r10) {
        }

        public void onFragmentViewCreated(@NonNull FragmentManager r5, @NonNull Fragment r10, @NonNull View r11, @Nullable Bundle r12) {
        }

        public void onFragmentViewDestroyed(@NonNull FragmentManager r5, @NonNull Fragment r10) {
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = null;
        int mRequestCode;
        String mWho;

        static {
            CREATOR = new AnonymousClass1();
        }

        public LaunchedFragmentInfo(@NonNull String r5, int r10) {
            this.mWho = r5;
            this.mRequestCode = r10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            r5.writeString(this.mWho);
            r5.writeInt(this.mRequestCode);
        }

        public LaunchedFragmentInfo(@NonNull Parcel r5) {
            this.mWho = r5.readString();
            this.mRequestCode = r5.readInt();
        }
    }

    public static class LifecycleAwareResultListener implements FragmentResultListener {
        private final Lifecycle mLifecycle;
        private final FragmentResultListener mListener;
        private final LifecycleEventObserver mObserver;

        public LifecycleAwareResultListener(@NonNull Lifecycle r5, @NonNull FragmentResultListener r10, @NonNull LifecycleEventObserver r11) {
            this.mLifecycle = r5;
            this.mListener = r10;
            this.mObserver = r11;
        }

        public boolean isAtLeast(Lifecycle.State r5) {
            return this.mLifecycle.getCurrentState().isAtLeast(r5);
        }

        @Override // androidx.fragment.app.FragmentResultListener
        public void onFragmentResult(@NonNull String r5, @NonNull Bundle r10) {
            this.mListener.onFragmentResult(r5, r10);
        }

        public void removeObserver() {
            this.mLifecycle.removeObserver(this.mObserver);
        }
    }

    public interface OnBackStackChangedListener {
        @MainThread
        default void onBackStackChangeCommitted(@NonNull Fragment r5, boolean r10) {
        }

        @MainThread
        default void onBackStackChangeStarted(@NonNull Fragment r5, boolean r10) {
        }

        @MainThread
        void onBackStackChanged();
    }

    public interface OpGenerator {
        boolean generateOps(@NonNull ArrayList<BackStackRecord> r5, @NonNull ArrayList<Boolean> r10);
    }

    public class PopBackStackState implements OpGenerator {
        final int mFlags;
        final int mId;
        final String mName;
        final /* synthetic */ FragmentManager this$0;

        public PopBackStackState(@Nullable FragmentManager r5, String r10, int r11, int r12) {
            this.this$0 = r5;
            this.mName = r10;
            this.mId = r11;
            this.mFlags = r12;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(@NonNull ArrayList<BackStackRecord> r10, @NonNull ArrayList<Boolean> r11) {
            Fragment r5 = this.this$0.mPrimaryNav;
            if (r5 == null) goto L13;
            if (this.mId >= 0) goto L13;
            if (this.mName != null) goto L13;
            if (r5.getChildFragmentManager().popBackStackImmediate() == false) goto L13;
            return false;
        L13:
            return this.this$0.popBackStackState(r10, r11, this.mName, this.mId, this.mFlags);
        }
    }

    public class RestoreBackStackState implements OpGenerator {
        private final String mName;
        final /* synthetic */ FragmentManager this$0;

        public RestoreBackStackState(@NonNull FragmentManager r5, String r10) {
            this.this$0 = r5;
            this.mName = r10;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(@NonNull ArrayList<BackStackRecord> r5, @NonNull ArrayList<Boolean> r10) {
            return this.this$0.restoreBackStackState(r5, r10, this.mName);
        }
    }

    public class SaveBackStackState implements OpGenerator {
        private final String mName;
        final /* synthetic */ FragmentManager this$0;

        public SaveBackStackState(@NonNull FragmentManager r5, String r10) {
            this.this$0 = r5;
            this.mName = r10;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(@NonNull ArrayList<BackStackRecord> r5, @NonNull ArrayList<Boolean> r10) {
            return this.this$0.saveBackStackState(r5, r10, this.mName);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FragmentManager() {
        this.mPendingActions = new ArrayList();
        this.mFragmentStore = new FragmentStore();
        this.mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
        final boolean r5 = false;
        this.mOnBackPressedCallback = new AnonymousClass1(this, r5);
        this.mBackStackIndex = new AtomicInteger();
        this.mBackStackStates = Collections.synchronizedMap(new HashMap());
        this.mResults = Collections.synchronizedMap(new HashMap());
        this.mResultListeners = Collections.synchronizedMap(new HashMap());
        this.mLifecycleCallbacksDispatcher = new FragmentLifecycleCallbacksDispatcher(this);
        this.mOnAttachListeners = new CopyOnWriteArrayList();
        final Object[] r10 = 0 == true ? 1 : 0;
        this.mOnConfigurationChangedListener = new i(this, r10);
        final int r11 = 1;
        this.mOnTrimMemoryListener = new i(this, r11);
        final int r12 = 2;
        this.mOnMultiWindowModeChangedListener = new i(this, r12);
        final int r13 = 3;
        this.mOnPictureInPictureModeChangedListener = new i(this, r13);
        this.mMenuProvider = new AnonymousClass2(this);
        this.mCurState = -1;
        this.mFragmentFactory = null;
        this.mHostFragmentFactory = new AnonymousClass3(this);
        this.mSpecialEffectsControllerFactory = null;
        this.mDefaultSpecialEffectsControllerFactory = new AnonymousClass4(this);
        this.mLaunchedFragments = new ArrayDeque();
        this.mExecCommit = new AnonymousClass5(this);
    }

    public static /* synthetic */ void a(FragmentManager r5, Integer r10) {
        r5.lambda$new$1(r10);
    }

    public static /* synthetic */ Map access$000(FragmentManager r5) {
        return r5.mResults;
    }

    public static /* synthetic */ Map access$100(FragmentManager r5) {
        return r5.mResultListeners;
    }

    public static /* synthetic */ FragmentStore access$200(FragmentManager r5) {
        return r5.mFragmentStore;
    }

    public static /* synthetic */ Bundle b(FragmentManager r5) {
        return r5.lambda$attachController$4();
    }

    public static /* synthetic */ void c(FragmentManager r5, PictureInPictureModeChangedInfo r10) {
        r5.lambda$new$3(r10);
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

    private void clearBackStackStateViewModels() {
        FragmentHostCallback<?> r5 = this.mHost;
        if ((r5 instanceof ViewModelStoreOwner) == false) goto L6;
        boolean r10 = this.mFragmentStore.getNonConfig().isCleared();
    L9:
        if (r10 == false) goto L17;
        Iterator<BackStackState> r11 = this.mBackStackStates.values().iterator();
    L12:
        if (r11.hasNext() == false) goto L20;
        Iterator<String> r12 = r11.next().mFragments.iterator();
    L15:
        if (r12.hasNext() == false) goto L12;
        this.mFragmentStore.getNonConfig().clearNonConfigState(r12.next(), false);
        goto L15
    L20:
        return;
    L17:
        return;
    L6:
        if ((r5.getContext() instanceof Activity) == false) goto L8;
        r10 = !((Activity) this.mHost.getContext()).isChangingConfigurations();
        goto L9
    L8:
        r10 = true;
        goto L9
    }

    private Set<SpecialEffectsController> collectAllSpecialEffectsController() {
        HashSet r5 = new HashSet();
        Iterator<FragmentStateManager> r10 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        ViewGroup r11 = r10.next().getFragment().mContainer;
        if (r11 == null) goto L4;
        r5.add(SpecialEffectsController.getOrCreateController(r11, getSpecialEffectsControllerFactory()));
        goto L4
    L8:
        return r5;
    }

    private Set<SpecialEffectsController> collectChangedControllers(@NonNull ArrayList<BackStackRecord> r5, int r10, int r11) {
        HashSet r12 = new HashSet();
    L3:
        if (r10 >= r11) goto L13;
        Iterator<FragmentTransaction.Op> r13 = r5.get(r10).mOps.iterator();
    L6:
        if (r13.hasNext() == false) goto L12;
        Fragment r14 = r13.next().mFragment;
        if (r14 == null) goto L6;
        ViewGroup r15 = r14.mContainer;
        if (r15 == null) goto L6;
        r12.add(SpecialEffectsController.getOrCreateController(r15, this));
        goto L6
    L12:
        r10 = r10 + 1;
        goto L3
    L13:
        return r12;
    }

    public static /* synthetic */ void d(FragmentManager r5, MultiWindowModeChangedInfo r10) {
        r5.lambda$new$2(r10);
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(@Nullable Fragment r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.equals(findActiveFragment(r5.mWho)) == false) goto L8;
        r5.performPrimaryNavigationFragmentChanged();
        return;
    }

    private void dispatchStateChange(int r5) {
        this.mExecutingActions = true;     // Catch: Throwable -> L8
        this.mFragmentStore.dispatchStateChange(r5);     // Catch: Throwable -> L8
        moveToState(r5, false);     // Catch: Throwable -> L8
        Iterator<SpecialEffectsController> r10 = collectAllSpecialEffectsController().iterator();     // Catch: Throwable -> L8
    L5:
        if (r10.hasNext() == false) goto L10;
        r10.next().forceCompleteAllOperations();     // Catch: Throwable -> L8
        goto L5
    L10:
        this.mExecutingActions = false;
        execPendingActions(true);
        return;
    L8:
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

    public static /* synthetic */ void e(FragmentManager r5, Configuration r10) {
        r5.lambda$new$0(r10);
    }

    @Deprecated
    public static void enableDebugLogging(boolean r5) {
        DEBUG = r5;
    }

    private void endAnimatingAwayFragments() {
        Iterator<SpecialEffectsController> r5 = collectAllSpecialEffectsController().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().forceCompleteAllOperations();
        goto L4
    }

    private void ensureExecReady(boolean r5) {
        if (this.mExecutingActions == true) goto L23;
        if (this.mHost != null) goto L13;
        if (this.mDestroyed == false) goto L11;
        throw new IllegalStateException("FragmentManager has been destroyed");
    L11:
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    L13:
        if (Looper.myLooper() != this.mHost.getHandler().getLooper()) goto L21;
        if (r5 == true) goto L17;
        checkStateLoss();
    L17:
        if (this.mTmpRecords != null) goto L24;
        this.mTmpRecords = new ArrayList();
        this.mTmpIsPop = new ArrayList();
        return;
    L24:
        return;
    L21:
        throw new IllegalStateException("Must be called from main thread of fragment host");
    L23:
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    private static void executeOps(@NonNull ArrayList<BackStackRecord> r5, @NonNull ArrayList<Boolean> r10, int r11, int r12) {
    L2:
        if (r11 >= r12) goto L8;
        BackStackRecord r13 = r5.get(r11);
        if (r10.get(r11).booleanValue() == false) goto L6;
        r13.bumpBackStackNesting(-1);
        r13.executePopOps();
    L7:
        r11 = r11 + 1;
        goto L2
    L6:
        r13.bumpBackStackNesting(1);
        r13.executeOps();
        goto L7
    }

    private void executeOpsTogether(@NonNull ArrayList<BackStackRecord> r10, @NonNull ArrayList<Boolean> r11, int r12, int r13) {
        boolean r5 = r10.get(r12).mReorderingAllowed;
        ArrayList<Fragment> r14 = this.mTmpAddedFragments;
        if (r14 != null) goto L5;
        this.mTmpAddedFragments = new ArrayList();
    L6:
        this.mTmpAddedFragments.addAll(this.mFragmentStore.getFragments());
        Fragment r15 = getPrimaryNavigationFragment();
        int r16 = r12;
        boolean r17 = false;
    L8:
        if (r16 >= r13) goto L20;
        BackStackRecord r18 = r10.get(r16);
        if (r11.get(r16).booleanValue() == true) goto L12;
        r15 = r18.expandOps(this.mTmpAddedFragments, r15);
    L13:
        if (r17 == false) goto L15;
    L18:
        r17 = true;
    L19:
        r16 = r16 + 1;
        goto L8
    L15:
        if (r18.mAddToBackStack == true) goto L18;
        r17 = false;
        goto L19
    L12:
        r15 = r18.trackAddedFragmentsInPop(this.mTmpAddedFragments, r15);
        goto L13
    L20:
        this.mTmpAddedFragments.clear();
        if (r5 == false) goto L23;
    L35:
        executeOps(r10, r11, r12, r13);
        boolean r19 = r11.get(r13 - 1).booleanValue();
        if (r17 == false) goto L59;
        ArrayList<OnBackStackChangedListener> r20 = this.mBackStackChangeListeners;
        if (r20 == null) goto L59;
        if (r20.isEmpty() == true) goto L59;
        LinkedHashSet r21 = new LinkedHashSet();
        Iterator<BackStackRecord> r22 = r10.iterator();
    L43:
        if (r22.hasNext() == false) goto L45;
        r21.addAll(fragmentsFromRecord(r22.next()));
        goto L43
    L45:
        Iterator<OnBackStackChangedListener> r23 = this.mBackStackChangeListeners.iterator();
    L47:
        if (r23.hasNext() == false) goto L52;
        OnBackStackChangedListener r24 = r23.next();
        Iterator r25 = r21.iterator();
    L50:
        if (r25.hasNext() == false) goto L47;
        r24.onBackStackChangeStarted((Fragment) r25.next(), r19);
        goto L50
    L52:
        Iterator<OnBackStackChangedListener> r26 = this.mBackStackChangeListeners.iterator();
    L54:
        if (r26.hasNext() == false) goto L59;
        OnBackStackChangedListener r27 = r26.next();
        Iterator r28 = r21.iterator();
    L57:
        if (r28.hasNext() == false) goto L54;
        r27.onBackStackChangeCommitted((Fragment) r28.next(), r19);
    L59:
        int r29 = r12;
    L60:
        if (r29 >= r13) goto L76;
        BackStackRecord r30 = r10.get(r29);
        if (r19 == false) goto L69;
        int r31 = r30.mOps.size() - 1;
    L64:
        if (r31 < 0) goto L75;
        Fragment r32 = r30.mOps.get(r31).mFragment;
        if (r32 == null) goto L68;
        createOrGetFragmentStateManager(r32).moveToExpectedState();
    L68:
        r31 = r31 - 1;
    L75:
        r29 = r29 + 1;
        goto L60
    L69:
        Iterator<FragmentTransaction.Op> r33 = r30.mOps.iterator();
    L71:
        if (r33.hasNext() == false) goto L75;
        Fragment r34 = r33.next().mFragment;
        if (r34 == null) goto L71;
        createOrGetFragmentStateManager(r34).moveToExpectedState();
        goto L71
    L76:
        moveToState(this.mCurState, true);
        Iterator<SpecialEffectsController> r35 = collectChangedControllers(r10, r12, r13).iterator();
    L78:
        if (r35.hasNext() == false) goto L80;
        SpecialEffectsController r36 = r35.next();
        r36.updateOperationDirection(r19);
        r36.markPostponedState();
        r36.executePendingOperations();
    L80:
        if (r12 >= r13) goto L87;
        BackStackRecord r37 = r10.get(r12);
        if (r11.get(r12).booleanValue() == false) goto L86;
        if (r37.mIndex < 0) goto L86;
        r37.mIndex = -1;
    L86:
        r37.runOnCommitRunnables();
        r12 = r12 + 1;
        goto L80
    L87:
        if (r17 == false) goto L120;
        reportBackStackChanged();
        return;
    L120:
        return;
    L23:
        if (this.mCurState < 1) goto L35;
        int r38 = r12;
    L25:
        if (r38 >= r13) goto L35;
        Iterator<FragmentTransaction.Op> r39 = r10.get(r38).mOps.iterator();
    L28:
        if (r39.hasNext() == false) goto L34;
        Fragment r40 = r39.next().mFragment;
        if (r40 == null) goto L28;
        if (r40.mFragmentManager == null) goto L28;
        this.mFragmentStore.makeActive(createOrGetFragmentStateManager(r40));
        goto L28
    L34:
        r38 = r38 + 1;
        goto L25
    L5:
        r14.clear();
        goto L6
    }

    private int findBackStackIndex(@Nullable String r5, int r10, boolean r11) {
        ArrayList<BackStackRecord> r12 = this.mBackStack;
        if (r12 != null) goto L5;
    L43:
        return -1;
    L5:
        if (r12.isEmpty() == true) goto L43;
        if (r5 != null) goto L14;
        if (r10 >= 0) goto L14;
        if (r11 == false) goto L13;
        return 0;
    L13:
        return this.mBackStack.size() - 1;
    L14:
        int r13 = this.mBackStack.size() - 1;
    L15:
        if (r13 < 0) goto L26;
        BackStackRecord r14 = this.mBackStack.get(r13);
        if (r5 != null) goto L19;
    L21:
        if (r10 < 0) goto L25;
        if (r10 == r14.mIndex) goto L26;
    L25:
        r13 = r13 - 1;
        goto L15
    L19:
        if (r5.equals(r14.getName()) == false) goto L21;
    L26:
        if (r13 >= 0) goto L28;
        return r13;
    L28:
        if (r11 == false) goto L39;
    L29:
        if (r13 <= 0) goto L56;
        BackStackRecord r15 = this.mBackStack.get(r13 - 1);
        if (r5 != null) goto L33;
    L34:
        if (r10 < 0) goto L54;
        if (r10 == r15.mIndex) goto L37;
        return r13;
    L37:
        r13 = r13 - 1;
        goto L29
    L54:
        return r13;
    L33:
        if (r5.equals(r15.getName()) == true) goto L37;
    L56:
        return r13;
    L39:
        if (r13 != (this.mBackStack.size() - 1)) goto L42;
        return -1;
    L42:
        return r13 + 1;
    }

    @NonNull
    public static <F extends Fragment> F findFragment(@NonNull View r5) {
        F r10 = (F) findViewFragment(r5);
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("View " + r5 + " does not have a Fragment set");
    }

    @NonNull
    public static FragmentManager findFragmentManager(@NonNull View r5) {
        Fragment r10 = findViewFragment(r5);
        if (r10 != null) goto L5;
        Context r11 = r5.getContext();
    L11:
        if ((r11 instanceof ContextWrapper) == false) goto L16;
        if ((r11 instanceof FragmentActivity) == true) goto L14;
        r11 = ((ContextWrapper) r11).getBaseContext();
        goto L11
    L14:
        FragmentActivity r12 = (FragmentActivity) r11;
    L17:
        if (r12 == null) goto L21;
        return r12.getSupportFragmentManager();
    L21:
        throw new IllegalStateException("View " + r5 + " is not within a subclass of FragmentActivity.");
    L16:
        r12 = null;
        goto L17
    L5:
        if (r10.isAdded() == false) goto L8;
        return r10.getChildFragmentManager();
    L8:
        throw new IllegalStateException("The Fragment " + r10 + " that owns View " + r5 + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
    }

    @Nullable
    public static Fragment findViewFragment(@NonNull View r5) {
    L3:
        if (r5 == null) goto L11;
        Fragment r10 = getViewFragment(r5);
        if (r10 != null) goto L6;
        Object r11 = r5.getParent();
        if ((r11 instanceof View) == true) goto L9;
        r5 = null;
        goto L3
    L9:
        r5 = (View) r11;
        goto L3
    L6:
        return r10;
    L11:
        return null;
    }

    private void forcePostponedTransactions() {
        Iterator<SpecialEffectsController> r5 = collectAllSpecialEffectsController().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().forcePostponedExecutePendingOperations();
        goto L4
    }

    private Set<Fragment> fragmentsFromRecord(@NonNull BackStackRecord r5) {
        HashSet r10 = new HashSet();
        int r11 = 0;
    L4:
        if (r11 >= r5.mOps.size()) goto L11;
        Fragment r12 = r5.mOps.get(r11).mFragment;
        if (r12 == null) goto L10;
        if (r5.mAddToBackStack == false) goto L10;
        r10.add(r12);
    L10:
        r11 = r11 + 1;
        goto L4
    L11:
        return r10;
    }

    private boolean generateOpsForPendingActions(@NonNull ArrayList<BackStackRecord> r10, @NonNull ArrayList<Boolean> r11) {
        ArrayList<OpGenerator> r5 = this.mPendingActions;
        monitor-enter(r5);
        int r12 = 0;
        if (this.mPendingActions.isEmpty() == false) goto L23;
        monitor-exit(r5);     // Catch: Throwable -> L8
        return false;
    L23:
        int r13 = this.mPendingActions.size();     // Catch: Throwable -> L14
        boolean r14 = false;
    L11:
        if (r12 >= r13) goto L16;
        r14 = r14 | this.mPendingActions.get(r12).generateOps(r10, r11);
        r12 = r12 + 1;
        goto L11
    L16:
        this.mPendingActions.clear();     // Catch: Throwable -> L8
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
        return r14;
    L14:
        th = move-exception;
        this.mPendingActions.clear();     // Catch: Throwable -> L8
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @NonNull
    private FragmentManagerViewModel getChildNonConfig(@NonNull Fragment r5) {
        return this.mNonConfig.getChildNonConfig(r5);
    }

    private ViewGroup getFragmentContainer(@NonNull Fragment r5) {
        ViewGroup r10 = r5.mContainer;
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (r5.mContainerId > 0) goto L9;
        return null;
    L9:
        if (this.mContainer.onHasView() == false) goto L14;
        View r11 = this.mContainer.onFindViewById(r5.mContainerId);
        if ((r11 instanceof ViewGroup) == false) goto L14;
        return (ViewGroup) r11;
    L14:
        return null;
    }

    @Nullable
    public static Fragment getViewFragment(@NonNull View r5) {
        Object r10 = r5.getTag(R.id.fragment_container_view_tag);
        if ((r10 instanceof Fragment) == true) goto L5;
        return null;
    L5:
        return (Fragment) r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean isLoggingEnabled(int r5) {
        if (DEBUG == false) goto L5;
    L8:
        return true;
    L5:
        if (Log.isLoggable(TAG, r5) == true) goto L8;
        return false;
    }

    private boolean isMenuAvailable(@NonNull Fragment r5) {
        if (r5.mHasMenu == false) goto L7;
        if (r5.mMenuVisible == false) goto L7;
    L8:
        return true;
    L7:
        if (r5.mChildFragmentManager.checkForMenus() == true) goto L8;
        return false;
    }

    private boolean isParentAdded() {
        Fragment r5 = this.mParent;
        if (r5 != null) goto L6;
        return true;
    L6:
        if (r5.isAdded() == true) goto L8;
    L10:
        return false;
    L8:
        if (this.mParent.getParentFragmentManager().isParentAdded() == false) goto L10;
        return true;
    }

    private /* synthetic */ Bundle lambda$attachController$4() {
        return saveAllStateInternal();
    }

    private /* synthetic */ void lambda$new$0(Configuration r5) {
        if (isParentAdded() == false) goto L6;
        dispatchConfigurationChanged(r5, false);
        return;
    }

    private /* synthetic */ void lambda$new$1(Integer r5) {
        if (isParentAdded() == true) goto L5;
        return;
    L5:
        if (r5.intValue() != 80) goto L9;
        dispatchLowMemory(false);
        return;
    }

    private /* synthetic */ void lambda$new$2(MultiWindowModeChangedInfo r5) {
        if (isParentAdded() == false) goto L6;
        dispatchMultiWindowModeChanged(r5.isInMultiWindowMode(), false);
        return;
    }

    private /* synthetic */ void lambda$new$3(PictureInPictureModeChangedInfo r5) {
        if (isParentAdded() == false) goto L6;
        dispatchPictureInPictureModeChanged(r5.isInPictureInPictureMode(), false);
        return;
    }

    private void removeRedundantOperationsAndExecute(@NonNull ArrayList<BackStackRecord> r5, @NonNull ArrayList<Boolean> r10) {
        if (r5.isEmpty() == false) goto L6;
        return;
    L6:
        if (r5.size() != r10.size()) goto L27;
        int r11 = r5.size();
        int r12 = 0;
        int r13 = 0;
    L8:
        if (r12 >= r11) goto L23;
        if (r5.get(r12).mReorderingAllowed == true) goto L22;
        if (r13 == r12) goto L13;
        executeOpsTogether(r5, r10, r13, r12);
    L13:
        r13 = r12 + 1;
        if (r10.get(r12).booleanValue() == false) goto L21;
    L15:
        if (r13 >= r11) goto L21;
        if (r10.get(r13).booleanValue() == false) goto L21;
        if (r5.get(r13).mReorderingAllowed == true) goto L21;
        r13 = r13 + 1;
    L21:
        executeOpsTogether(r5, r10, r12, r13);
        r12 = r13 - 1;
    L22:
        r12 = r12 + 1;
        goto L8
    L23:
        if (r13 == r11) goto L34;
        executeOpsTogether(r5, r10, r13, r11);
        return;
    L34:
        return;
    L27:
        throw new IllegalStateException("Internal error with the back stack records");
    }

    private void reportBackStackChanged() {
        if (this.mBackStackChangeListeners == null) goto L8;
        int r5 = 0;
    L6:
        if (r5 >= this.mBackStackChangeListeners.size()) goto L10;
        this.mBackStackChangeListeners.get(r5).onBackStackChanged();
        r5 = r5 + 1;
        goto L6
    L10:
        return;
    }

    public static int reverseTransit(int r5) {
        int r10 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        if (r5 == 4097) goto L14;
        if (r5 == 8194) goto L17;
        r10 = FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE;
        if (r5 != 8197) goto L8;
        return FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN;
    L8:
        if (r5 == 4099) goto L13;
        if (r5 == 4100) goto L17;
        return 0;
    L13:
        return FragmentTransaction.TRANSIT_FRAGMENT_FADE;
    L17:
        return r10;
    L14:
        return 8194;
    }

    private void setVisibleRemovingFragment(@NonNull Fragment r5) {
        ViewGroup r10 = getFragmentContainer(r5);
        if (r10 == null) goto L11;
        int r11 = r5.getEnterAnim();
        int r12 = r5.getExitAnim() + r11;
        int r13 = r5.getPopEnterAnim() + r12;
        if ((r5.getPopExitAnim() + r13) > 0) goto L7;
        return;
    L7:
        if (r10.getTag(R.id.visible_removing_fragment_view_tag) != null) goto L9;
        r10.setTag(R.id.visible_removing_fragment_view_tag, r5);
    L9:
        ((Fragment) r10.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(r5.getPopDirection());
        return;
    }

    private void startPendingDeferredFragments() {
        Iterator<FragmentStateManager> r5 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        performPendingDeferredStart(r5.next());
        goto L4
    }

    private void throwException(RuntimeException r10) {
        Log.e(TAG, r10.getMessage());
        Log.e(TAG, "Activity state:");
        PrintWriter r5 = new PrintWriter(new LogWriter(TAG));
        FragmentHostCallback<?> r11 = this.mHost;
        if (r11 == null) goto L15;
        r11.onDump("  ", null, r5, new String[0]);     // Catch: Exception -> L6
        throw r10;
    L6:
        e = move-exception;
        Log.e(TAG, "Failed dumping state", e);
        throw r10;
    L15:
        dump("  ", null, r5, new String[0]);     // Catch: Exception -> L10
        throw r10;
    L10:
        e = move-exception;
        Log.e(TAG, "Failed dumping state", e);
        throw r10;
    }

    private void updateOnBackPressedCallbackEnabled() {
        ArrayList<OpGenerator> r5 = this.mPendingActions;
        monitor-enter(r5);
        boolean r10 = true;
        if (this.mPendingActions.isEmpty() == true) goto L11;
        this.mOnBackPressedCallback.setEnabled(true);     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(r5);     // Catch: Throwable -> L9
        OnBackPressedCallback r11 = this.mOnBackPressedCallback;
        if (getBackStackEntryCount() > 0) goto L15;
    L17:
        r10 = false;
    L18:
        r11.setEnabled(r10);
        return;
    L15:
        if (isPrimaryNavigation(this.mParent) == false) goto L17;
    L9:
        th = move-exception;
        throw th;
    }

    public void addBackStackState(BackStackRecord r5) {
        if (this.mBackStack != null) goto L5;
        this.mBackStack = new ArrayList();
    L5:
        this.mBackStack.add(r5);
    }

    public FragmentStateManager addFragment(@NonNull Fragment r5) {
        String r10 = r5.mPreviousWho;
        if (r10 == null) goto L6;
        FragmentStrictMode.onFragmentReuse(r5, r10);
    L6:
        if (isLoggingEnabled(2) == false) goto L8;
        Log.v(TAG, "add: " + r5);
    L8:
        FragmentStateManager r11 = createOrGetFragmentStateManager(r5);
        r5.mFragmentManager = this;
        this.mFragmentStore.makeActive(r11);
        if (r5.mDetached == true) goto L16;
        this.mFragmentStore.addFragment(r5);
        r5.mRemoving = false;
        if (r5.mView != null) goto L14;
        r5.mHiddenChanged = false;
    L14:
        if (isMenuAvailable(r5) == false) goto L16;
        this.mNeedMenuInvalidate = true;
    L16:
        return r11;
    }

    public void addFragmentOnAttachListener(@NonNull FragmentOnAttachListener r5) {
        this.mOnAttachListeners.add(r5);
    }

    public void addOnBackStackChangedListener(@NonNull OnBackStackChangedListener r5) {
        if (this.mBackStackChangeListeners != null) goto L5;
        this.mBackStackChangeListeners = new ArrayList();
    L5:
        this.mBackStackChangeListeners.add(r5);
    }

    public void addRetainedFragment(@NonNull Fragment r5) {
        this.mNonConfig.addRetainedFragment(r5);
    }

    public int allocBackStackIndex() {
        return this.mBackStackIndex.getAndIncrement();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    public void attachController(@NonNull FragmentHostCallback<?> r5, @NonNull FragmentContainer r10, @Nullable final Fragment r11) {
        if (this.mHost != null) goto L56;
        this.mHost = r5;
        this.mContainer = r10;
        this.mParent = r11;
        if (r11 == null) goto L8;
        addFragmentOnAttachListener(new AnonymousClass7(this, r11));
    L11:
        if (this.mParent == null) goto L14;
        updateOnBackPressedCallbackEnabled();
    L14:
        if ((r5 instanceof OnBackPressedDispatcherOwner) == false) goto L19;
        OnBackPressedDispatcherOwner r12 = (OnBackPressedDispatcherOwner) r5;
        OnBackPressedDispatcher r13 = r12.getOnBackPressedDispatcher();
        this.mOnBackPressedDispatcher = r13;
        LifecycleOwner r14 = r12;
        if (r11 == null) goto L18;
        r14 = r11;
    L18:
        r13.addCallback(r14, this.mOnBackPressedCallback);
    L19:
        if (r11 == null) goto L22;
        this.mNonConfig = r11.mFragmentManager.getChildNonConfig(r11);
    L25:
        this.mNonConfig.setIsStateSaved(isStateSaved());
        this.mFragmentStore.setNonConfig(this.mNonConfig);
        Object r15 = this.mHost;
        if ((r15 instanceof SavedStateRegistryOwner) == false) goto L31;
        if (r11 != null) goto L31;
        SavedStateRegistry r16 = ((SavedStateRegistryOwner) r15).getSavedStateRegistry();
        r16.registerSavedStateProvider(SAVED_STATE_KEY, new f(this, 1));
        Bundle r17 = r16.consumeRestoredStateForKey(SAVED_STATE_KEY);
        if (r17 == null) goto L31;
        restoreSaveStateInternal(r17);
    L31:
        Object r18 = this.mHost;
        if ((r18 instanceof ActivityResultRegistryOwner) == false) goto L38;
        ActivityResultRegistry r19 = ((ActivityResultRegistryOwner) r18).getActivityResultRegistry();
        if (r11 == null) goto L36;
        String r20 = j0.q(new StringBuilder(), r11.mWho, ":");
    L37:
        String r21 = j0.C("FragmentManager:", r20);
        this.mStartActivityForResult = r19.register(j0.j(r21, "StartActivityForResult"), new ActivityResultContracts.StartActivityForResult(), new AnonymousClass8(this));
        this.mStartIntentSenderForResult = r19.register(j0.j(r21, "StartIntentSenderForResult"), new FragmentIntentSenderContract(), new AnonymousClass9(this));
        this.mRequestPermissions = r19.register(j0.j(r21, "RequestPermissions"), new ActivityResultContracts.RequestMultiplePermissions(), new AnonymousClass10(this));
        goto L38
    L36:
        r20 = "";
    L38:
        Object r22 = this.mHost;
        if ((r22 instanceof OnConfigurationChangedProvider) == false) goto L41;
        ((OnConfigurationChangedProvider) r22).addOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
    L41:
        Object r23 = this.mHost;
        if ((r23 instanceof OnTrimMemoryProvider) == false) goto L44;
        ((OnTrimMemoryProvider) r23).addOnTrimMemoryListener(this.mOnTrimMemoryListener);
    L44:
        Object r24 = this.mHost;
        if ((r24 instanceof OnMultiWindowModeChangedProvider) == false) goto L47;
        ((OnMultiWindowModeChangedProvider) r24).addOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
    L47:
        Object r25 = this.mHost;
        if ((r25 instanceof OnPictureInPictureModeChangedProvider) == false) goto L50;
        ((OnPictureInPictureModeChangedProvider) r25).addOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
    L50:
        Object r26 = this.mHost;
        if ((r26 instanceof MenuHost) == false) goto L57;
        if (r11 != null) goto L58;
        ((MenuHost) r26).addMenuProvider(this.mMenuProvider);
        return;
    L58:
        return;
    L57:
        return;
    L22:
        if ((r5 instanceof ViewModelStoreOwner) == false) goto L24;
        this.mNonConfig = FragmentManagerViewModel.getInstance(((ViewModelStoreOwner) r5).getViewModelStore());
        goto L25
    L24:
        this.mNonConfig = new FragmentManagerViewModel(false);
        goto L25
    L8:
        if ((r5 instanceof FragmentOnAttachListener) == false) goto L11;
        addFragmentOnAttachListener((FragmentOnAttachListener) r5);
        goto L11
    L56:
        throw new IllegalStateException("Already attached");
    }

    public void attachFragment(@NonNull Fragment r5) {
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "attach: " + r5);
    L6:
        if (r5.mDetached == false) goto L16;
        r5.mDetached = false;
        if (r5.mAdded == true) goto L17;
        this.mFragmentStore.addFragment(r5);
        if (isLoggingEnabled(2) == false) goto L13;
        Log.v(TAG, "add from attach: " + r5);
    L13:
        if (isMenuAvailable(r5) == false) goto L18;
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

    public boolean checkForMenus() {
        Iterator<Fragment> r5 = this.mFragmentStore.getActiveFragments().iterator();
        boolean r10 = false;
    L4:
        if (r5.hasNext() == false) goto L11;
        Fragment r11 = r5.next();
        if (r11 == null) goto L8;
        r10 = isMenuAvailable(r11);
    L8:
        if (r10 == false) goto L4;
        return true;
    L11:
        return false;
    }

    public void clearBackStack(@NonNull String r5) {
        enqueueAction(new ClearBackStackState(this, r5), false);
    }

    public boolean clearBackStackState(@NonNull ArrayList<BackStackRecord> r10, @NonNull ArrayList<Boolean> r11, @NonNull String r12) {
        if (restoreBackStackState(r10, r11, r12) == true) goto L7;
        return false;
    L7:
        return popBackStackState(r10, r11, r12, -1, 1);
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResult(@NonNull String r5) {
        this.mResults.remove(r5);
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "Clearing fragment result with key " + r5);
        return;
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResultListener(@NonNull String r5) {
        LifecycleAwareResultListener r10 = this.mResultListeners.remove(r5);
        if (r10 == null) goto L6;
        r10.removeObserver();
    L6:
        if (isLoggingEnabled(2) == false) goto L9;
        Log.v(TAG, "Clearing FragmentResultListener for key " + r5);
        return;
    }

    @NonNull
    public FragmentStateManager createOrGetFragmentStateManager(@NonNull Fragment r5) {
        FragmentStateManager r10 = this.mFragmentStore.getFragmentStateManager(r5.mWho);
        if (r10 == null) goto L5;
        return r10;
    L5:
        FragmentStateManager r11 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r5);
        r11.restoreState(this.mHost.getContext().getClassLoader());
        r11.setFragmentManagerState(this.mCurState);
        return r11;
    }

    public void detachFragment(@NonNull Fragment r5) {
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "detach: " + r5);
    L6:
        if (r5.mDetached == true) goto L17;
        r5.mDetached = true;
        if (r5.mAdded == true) goto L10;
        return;
    L10:
        if (isLoggingEnabled(2) == false) goto L12;
        Log.v(TAG, "remove from detach: " + r5);
    L12:
        this.mFragmentStore.removeFragment(r5);
        if (isMenuAvailable(r5) == false) goto L15;
        this.mNeedMenuInvalidate = true;
    L15:
        setVisibleRemovingFragment(r5);
        return;
    }

    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(4);
    }

    public void dispatchAttach() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(0);
    }

    public void dispatchConfigurationChanged(@NonNull Configuration r5, boolean r10) {
        if (r10 == true) goto L4;
    L6:
        Iterator<Fragment> r11 = this.mFragmentStore.getFragments().iterator();
    L8:
        if (r11.hasNext() == false) goto L14;
        Fragment r12 = r11.next();
        if (r12 == null) goto L8;
        r12.performConfigurationChanged(r5);
        if (r10 == false) goto L8;
        r12.mChildFragmentManager.dispatchConfigurationChanged(r5, true);
        goto L8
    L14:
        return;
    L4:
        if ((this.mHost instanceof OnConfigurationChangedProvider) == false) goto L6;
        throwException(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        goto L6
    }

    public boolean dispatchContextItemSelected(@NonNull MenuItem r5) {
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r10 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r10.hasNext() == false) goto L13;
        Fragment r11 = r10.next();
        if (r11 == null) goto L7;
        if (r11.performContextItemSelected(r5) == false) goto L7;
        return true;
    L13:
        return false;
    }

    public void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(1);
    }

    public boolean dispatchCreateOptionsMenu(@NonNull Menu r10, @NonNull MenuInflater r11) {
        int r5 = 0;
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r12 = this.mFragmentStore.getFragments().iterator();
        ArrayList<Fragment> r13 = null;
        boolean r14 = false;
    L7:
        if (r12.hasNext() == false) goto L18;
        Fragment r15 = r12.next();
        if (r15 == null) goto L7;
        if (isParentMenuVisible(r15) == false) goto L7;
        if (r15.performCreateOptionsMenu(r10, r11) == false) goto L7;
        if (r13 != null) goto L16;
        r13 = new ArrayList();
    L16:
        r13.add(r15);
        r14 = true;
        goto L7
    L18:
        if (this.mCreatedMenus != null) goto L20;
    L27:
        this.mCreatedMenus = r13;
        return r14;
    L20:
        if (r5 >= this.mCreatedMenus.size()) goto L27;
        Fragment r16 = this.mCreatedMenus.get(r5);
        if (r13 != null) goto L24;
    L25:
        r16.onDestroyOptionsMenu();
    L26:
        r5 = r5 + 1;
        goto L20
    L24:
        if (r13.contains(r16) == true) goto L26;
        goto L25
    }

    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions(true);
        endAnimatingAwayFragments();
        clearBackStackStateViewModels();
        dispatchStateChange(-1);
        Object r5 = this.mHost;
        if ((r5 instanceof OnTrimMemoryProvider) == false) goto L5;
        ((OnTrimMemoryProvider) r5).removeOnTrimMemoryListener(this.mOnTrimMemoryListener);
    L5:
        Object r10 = this.mHost;
        if ((r10 instanceof OnConfigurationChangedProvider) == false) goto L8;
        ((OnConfigurationChangedProvider) r10).removeOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
    L8:
        Object r11 = this.mHost;
        if ((r11 instanceof OnMultiWindowModeChangedProvider) == false) goto L11;
        ((OnMultiWindowModeChangedProvider) r11).removeOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
    L11:
        Object r12 = this.mHost;
        if ((r12 instanceof OnPictureInPictureModeChangedProvider) == false) goto L14;
        ((OnPictureInPictureModeChangedProvider) r12).removeOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
    L14:
        Object r13 = this.mHost;
        if ((r13 instanceof MenuHost) == true) goto L17;
    L19:
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher == null) goto L22;
        this.mOnBackPressedCallback.remove();
        this.mOnBackPressedDispatcher = null;
    L22:
        ActivityResultLauncher<Intent> r14 = this.mStartActivityForResult;
        if (r14 == null) goto L26;
        r14.unregister();
        this.mStartIntentSenderForResult.unregister();
        this.mRequestPermissions.unregister();
        return;
    L26:
        return;
    L17:
        if (this.mParent != null) goto L19;
        ((MenuHost) r13).removeMenuProvider(this.mMenuProvider);
        goto L19
    }

    public void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    public void dispatchLowMemory(boolean r5) {
        if (r5 == true) goto L4;
    L6:
        Iterator<Fragment> r10 = this.mFragmentStore.getFragments().iterator();
    L8:
        if (r10.hasNext() == false) goto L14;
        Fragment r11 = r10.next();
        if (r11 == null) goto L8;
        r11.performLowMemory();
        if (r5 == false) goto L8;
        r11.mChildFragmentManager.dispatchLowMemory(true);
        goto L8
    L14:
        return;
    L4:
        if ((this.mHost instanceof OnTrimMemoryProvider) == false) goto L6;
        throwException(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        goto L6
    }

    public void dispatchMultiWindowModeChanged(boolean r5, boolean r10) {
        if (r10 == true) goto L4;
    L6:
        Iterator<Fragment> r11 = this.mFragmentStore.getFragments().iterator();
    L8:
        if (r11.hasNext() == false) goto L14;
        Fragment r12 = r11.next();
        if (r12 == null) goto L8;
        r12.performMultiWindowModeChanged(r5);
        if (r10 == false) goto L8;
        r12.mChildFragmentManager.dispatchMultiWindowModeChanged(r5, true);
        goto L8
    L14:
        return;
    L4:
        if ((this.mHost instanceof OnMultiWindowModeChangedProvider) == false) goto L6;
        throwException(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        goto L6
    }

    public void dispatchOnAttachFragment(@NonNull Fragment r5) {
        Iterator<FragmentOnAttachListener> r10 = this.mOnAttachListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onAttachFragment(this, r5);
        goto L4
    }

    public void dispatchOnHiddenChanged() {
        Iterator<Fragment> r5 = this.mFragmentStore.getActiveFragments().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Fragment r10 = r5.next();
        if (r10 == null) goto L4;
        r10.onHiddenChanged(r10.isHidden());
        r10.mChildFragmentManager.dispatchOnHiddenChanged();
        goto L4
    }

    public boolean dispatchOptionsItemSelected(@NonNull MenuItem r5) {
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r10 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r10.hasNext() == false) goto L13;
        Fragment r11 = r10.next();
        if (r11 == null) goto L7;
        if (r11.performOptionsItemSelected(r5) == false) goto L7;
        return true;
    L13:
        return false;
    }

    public void dispatchOptionsMenuClosed(@NonNull Menu r5) {
        if (this.mCurState >= 1) goto L5;
        return;
    L5:
        Iterator<Fragment> r10 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        Fragment r11 = r10.next();
        if (r11 == null) goto L7;
        r11.performOptionsMenuClosed(r5);
        goto L7
    }

    public void dispatchPause() {
        dispatchStateChange(5);
    }

    public void dispatchPictureInPictureModeChanged(boolean r5, boolean r10) {
        if (r10 == true) goto L4;
    L6:
        Iterator<Fragment> r11 = this.mFragmentStore.getFragments().iterator();
    L8:
        if (r11.hasNext() == false) goto L14;
        Fragment r12 = r11.next();
        if (r12 == null) goto L8;
        r12.performPictureInPictureModeChanged(r5);
        if (r10 == false) goto L8;
        r12.mChildFragmentManager.dispatchPictureInPictureModeChanged(r5, true);
        goto L8
    L14:
        return;
    L4:
        if ((this.mHost instanceof OnPictureInPictureModeChangedProvider) == false) goto L6;
        throwException(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        goto L6
    }

    public boolean dispatchPrepareOptionsMenu(@NonNull Menu r10) {
        boolean r5 = false;
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r11 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r11.hasNext() == false) goto L15;
        Fragment r12 = r11.next();
        if (r12 == null) goto L7;
        if (isParentMenuVisible(r12) == false) goto L7;
        if (r12.performPrepareOptionsMenu(r10) == false) goto L7;
        r5 = true;
        goto L7
    L15:
        return r5;
    }

    public void dispatchPrimaryNavigationFragmentChanged() {
        updateOnBackPressedCallbackEnabled();
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    public void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(7);
    }

    public void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(5);
    }

    public void dispatchStop() {
        this.mStopped = true;
        this.mNonConfig.setIsStateSaved(true);
        dispatchStateChange(4);
    }

    public void dispatchViewCreated() {
        dispatchStateChange(2);
    }

    public void dump(@NonNull String r5, @Nullable FileDescriptor r10, @NonNull PrintWriter r11, @Nullable String[] r12) {
        String r13 = j0.j(r5, "    ");
        this.mFragmentStore.dump(r5, r10, r11, r12);
        ArrayList<Fragment> r14 = this.mCreatedMenus;
        int r15 = 0;
        if (r14 == null) goto L9;
        int r16 = r14.size();
        if (r16 <= 0) goto L9;
        r11.print(r5);
        r11.println("Fragments Created Menus:");
        int r17 = 0;
    L7:
        if (r17 >= r16) goto L9;
        Fragment r18 = this.mCreatedMenus.get(r17);
        r11.print(r5);
        r11.print("  #");
        r11.print(r17);
        r11.print(": ");
        r11.println(r18.toString());
        r17 = r17 + 1;
    L9:
        ArrayList<BackStackRecord> r19 = this.mBackStack;
        if (r19 == null) goto L16;
        int r20 = r19.size();
        if (r20 <= 0) goto L16;
        r11.print(r5);
        r11.println("Back Stack:");
        int r21 = 0;
    L14:
        if (r21 >= r20) goto L16;
        BackStackRecord r22 = this.mBackStack.get(r21);
        r11.print(r5);
        r11.print("  #");
        r11.print(r21);
        r11.print(": ");
        r11.println(r22.toString());
        r22.dump(r13, r11);
        r21 = r21 + 1;
    L16:
        r11.print(r5);
        r11.println("Back Stack Index: " + this.mBackStackIndex.get());
        ArrayList<OpGenerator> r23 = this.mPendingActions;
        monitor-enter(r23);
        int r24 = this.mPendingActions.size();     // Catch: Throwable -> L23
        if (r24 <= 0) goto L25;
        r11.print(r5);     // Catch: Throwable -> L23
        r11.println("Pending Actions:");     // Catch: Throwable -> L23
    L21:
        if (r15 >= r24) goto L25;
        OpGenerator r25 = this.mPendingActions.get(r15);     // Catch: Throwable -> L23
        r11.print(r5);     // Catch: Throwable -> L23
        r11.print("  #");     // Catch: Throwable -> L23
        r11.print(r15);     // Catch: Throwable -> L23
        r11.print(": ");     // Catch: Throwable -> L23
        r11.println(r25);     // Catch: Throwable -> L23
        r15 = r15 + 1;     // Catch: Throwable -> L23
    L25:
        monitor-exit(r23);     // Catch: Throwable -> L23
        r11.print(r5);
        r11.println("FragmentManager misc state:");
        r11.print(r5);
        r11.print("  mHost=");
        r11.println(this.mHost);
        r11.print(r5);
        r11.print("  mContainer=");
        r11.println(this.mContainer);
        if (this.mParent == null) goto L29;
        r11.print(r5);
        r11.print("  mParent=");
        r11.println(this.mParent);
    L29:
        r11.print(r5);
        r11.print("  mCurState=");
        r11.print(this.mCurState);
        r11.print(" mStateSaved=");
        r11.print(this.mStateSaved);
        r11.print(" mStopped=");
        r11.print(this.mStopped);
        r11.print(" mDestroyed=");
        r11.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate == false) goto L40;
        r11.print(r5);
        r11.print("  mNeedMenuInvalidate=");
        r11.println(this.mNeedMenuInvalidate);
        return;
    L40:
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public void enqueueAction(@NonNull OpGenerator r5, boolean r10) {
        if (r10 == false) goto L4;
    L12:
        ArrayList<OpGenerator> r11 = this.mPendingActions;
        monitor-enter(r11);
    L19:
        th = move-exception;
        throw th;
    L15:
        if (this.mHost != null) goto L23;
        if (r10 == false) goto L22;
        monitor-exit(r11);     // Catch: Throwable -> L19
        return;
    L22:
        throw new IllegalStateException("Activity has been destroyed");     // Catch: Throwable -> L19
    L23:
        this.mPendingActions.add(r5);     // Catch: Throwable -> L19
        scheduleCommit();     // Catch: Throwable -> L19
        monitor-exit(r11);     // Catch: Throwable -> L19
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

    public boolean execPendingActions(boolean r5) {
        ensureExecReady(r5);
        boolean r10 = false;
    L4:
        if (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop) == false) goto L11;
        r10 = true;
        this.mExecutingActions = true;
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);     // Catch: Throwable -> L8
        cleanupExec();
    L8:
        th = move-exception;
        cleanupExec();
        throw th;
    L11:
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return r10;
    }

    public void execSingleAction(@NonNull OpGenerator r5, boolean r10) {
        if (r10 == true) goto L4;
    L8:
        ensureExecReady(r10);
        if (r5.generateOps(this.mTmpRecords, this.mTmpIsPop) == false) goto L16;
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

    @MainThread
    public boolean executePendingTransactions() {
        boolean r5 = execPendingActions(true);
        forcePostponedTransactions();
        return r5;
    }

    @Nullable
    public Fragment findActiveFragment(@NonNull String r5) {
        return this.mFragmentStore.findActiveFragment(r5);
    }

    @Nullable
    public Fragment findFragmentById(@IdRes int r5) {
        return this.mFragmentStore.findFragmentById(r5);
    }

    @Nullable
    public Fragment findFragmentByTag(@Nullable String r5) {
        return this.mFragmentStore.findFragmentByTag(r5);
    }

    public Fragment findFragmentByWho(@NonNull String r5) {
        return this.mFragmentStore.findFragmentByWho(r5);
    }

    public int getActiveFragmentCount() {
        return this.mFragmentStore.getActiveFragmentCount();
    }

    @NonNull
    public List<Fragment> getActiveFragments() {
        return this.mFragmentStore.getActiveFragments();
    }

    @NonNull
    public BackStackEntry getBackStackEntryAt(int r5) {
        return this.mBackStack.get(r5);
    }

    public int getBackStackEntryCount() {
        ArrayList<BackStackRecord> r5 = this.mBackStack;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.size();
    }

    @NonNull
    public FragmentContainer getContainer() {
        return this.mContainer;
    }

    @Nullable
    public Fragment getFragment(@NonNull Bundle r5, @NonNull String r10) {
        String r11 = r5.getString(r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        Fragment r12 = findActiveFragment(r11);
        if (r12 != null) goto L9;
        throwException(new IllegalStateException(androidx.constraintlayout.motion.widget.a.p("Fragment no longer exists for key ", r10, ": unique id ", r11)));
    L9:
        return r12;
    }

    @NonNull
    public FragmentFactory getFragmentFactory() {
        FragmentFactory r5 = this.mFragmentFactory;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Fragment r10 = this.mParent;
        if (r10 == null) goto L10;
        return r10.mFragmentManager.getFragmentFactory();
    L10:
        return this.mHostFragmentFactory;
    }

    @NonNull
    public FragmentStore getFragmentStore() {
        return this.mFragmentStore;
    }

    @NonNull
    public List<Fragment> getFragments() {
        return this.mFragmentStore.getFragments();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public FragmentHostCallback<?> getHost() {
        return this.mHost;
    }

    @NonNull
    public LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this.mLayoutInflaterFactory;
    }

    @NonNull
    public FragmentLifecycleCallbacksDispatcher getLifecycleCallbacksDispatcher() {
        return this.mLifecycleCallbacksDispatcher;
    }

    @Nullable
    public Fragment getParent() {
        return this.mParent;
    }

    @Nullable
    public Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    @NonNull
    public SpecialEffectsControllerFactory getSpecialEffectsControllerFactory() {
        SpecialEffectsControllerFactory r5 = this.mSpecialEffectsControllerFactory;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Fragment r10 = this.mParent;
        if (r10 == null) goto L10;
        return r10.mFragmentManager.getSpecialEffectsControllerFactory();
    L10:
        return this.mDefaultSpecialEffectsControllerFactory;
    }

    @Nullable
    public FragmentStrictMode.Policy getStrictModePolicy() {
        return this.mStrictModePolicy;
    }

    @NonNull
    public ViewModelStore getViewModelStore(@NonNull Fragment r5) {
        return this.mNonConfig.getViewModelStore(r5);
    }

    public void handleOnBackPressed() {
        execPendingActions(true);
        if (this.mOnBackPressedCallback.isEnabled() == false) goto L5;
        popBackStackImmediate();
        return;
    L5:
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    public void hideFragment(@NonNull Fragment r5) {
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "hide: " + r5);
    L6:
        if (r5.mHidden == true) goto L9;
        r5.mHidden = true;
        r5.mHiddenChanged = true ^ r5.mHiddenChanged;
        setVisibleRemovingFragment(r5);
        return;
    }

    public void invalidateMenuForFragment(@NonNull Fragment r5) {
        if (r5.mAdded == true) goto L5;
        return;
    L5:
        if (isMenuAvailable(r5) == false) goto L9;
        this.mNeedMenuInvalidate = true;
        return;
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public boolean isParentHidden(@Nullable Fragment r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        return r5.isHidden();
    }

    public boolean isParentMenuVisible(@Nullable Fragment r5) {
        if (r5 != null) goto L6;
        return true;
    L6:
        return r5.isMenuVisible();
    }

    public boolean isPrimaryNavigation(@Nullable Fragment r5) {
        if (r5 != null) goto L5;
        return true;
    L5:
        FragmentManager r10 = r5.mFragmentManager;
        if (r5.equals(r10.getPrimaryNavigationFragment()) == true) goto L8;
    L10:
        return false;
    L8:
        if (isPrimaryNavigation(r10.mParent) == false) goto L10;
        return true;
    }

    public boolean isStateAtLeast(int r5) {
        if (this.mCurState < r5) goto L5;
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

    public void launchRequestPermissions(@NonNull Fragment r5, @NonNull String[] r10, int r11) {
        if (this.mRequestPermissions == null) goto L5;
        LaunchedFragmentInfo r12 = new LaunchedFragmentInfo(r5.mWho, r11);
        this.mLaunchedFragments.addLast(r12);
        this.mRequestPermissions.launch(r10);
        return;
    L5:
        this.mHost.onRequestPermissionsFromFragment(r5, r10, r11);
    }

    public void launchStartActivityForResult(@NonNull Fragment r5, @NonNull Intent r10, int r11, @Nullable Bundle r12) {
        if (this.mStartActivityForResult == null) goto L8;
        LaunchedFragmentInfo r13 = new LaunchedFragmentInfo(r5.mWho, r11);
        this.mLaunchedFragments.addLast(r13);
        if (r12 == null) goto L7;
        r10.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r12);
    L7:
        this.mStartActivityForResult.launch(r10);
        return;
    L8:
        this.mHost.onStartActivityFromFragment(r5, r10, r11, r12);
    }

    public void launchStartIntentSenderForResult(@NonNull Fragment r11, @NonNull IntentSender r12, int r13, @Nullable Intent r14, int r15, int r16, int r17, @Nullable Bundle r18) throws IntentSender.SendIntentException {
        if (this.mStartIntentSenderForResult != null) goto L5;
        this.mHost.onStartIntentSenderFromFragment(r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    L5:
        if (r18 == null) goto L13;
        if (r14 != null) goto L8;
        Intent r5 = new Intent();
        r5.putExtra(EXTRA_CREATED_FILLIN_INTENT, true);
    L10:
        if (isLoggingEnabled(2) == false) goto L12;
        Log.v(TAG, "ActivityOptions " + r18 + " were added to fillInIntent " + r5 + " for fragment " + r11);
    L12:
        r5.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r18);
    L14:
        IntentSenderRequest r10 = new IntentSenderRequest.Builder(r12).setFillInIntent(r5).setFlags(r16, r15).build();
        this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(r11.mWho, r13));
        if (isLoggingEnabled(2) == false) goto L17;
        Log.v(TAG, "Fragment " + r11 + "is launching an IntentSender for result ");
    L17:
        this.mStartIntentSenderForResult.launch(r10);
        return;
    L8:
        r5 = r14;
        goto L10
    L13:
        r5 = r14;
        goto L14
    }

    public void moveToState(int r5, boolean r10) {
        if (this.mHost == null) goto L5;
    L9:
        if (r10 == false) goto L11;
    L13:
        this.mCurState = r5;
        this.mFragmentStore.moveToExpectedState();
        startPendingDeferredFragments();
        if (this.mNeedMenuInvalidate == false) goto L21;
        FragmentHostCallback<?> r11 = this.mHost;
        if (r11 != null) goto L18;
        return;
    L18:
        if (this.mCurState != 7) goto L23;
        r11.onSupportInvalidateOptionsMenu();
        this.mNeedMenuInvalidate = false;
        return;
    L23:
        return;
    L21:
        return;
    L11:
        if (r5 != this.mCurState) goto L13;
        return;
    L5:
        if (r5 == (-1)) goto L9;
        throw new IllegalStateException("No activity");
    }

    public void noteStateNotSaved() {
        if (this.mHost != null) goto L5;
        return;
    L5:
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        Iterator<Fragment> r5 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        Fragment r10 = r5.next();
        if (r10 == null) goto L7;
        r10.noteStateNotSaved();
        goto L7
    }

    public void onContainerAvailable(@NonNull FragmentContainerView r5) {
        Iterator<FragmentStateManager> r10 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L4:
        if (r10.hasNext() == false) goto L12;
        FragmentStateManager r11 = r10.next();
        Fragment r12 = r11.getFragment();
        if (r12.mContainerId != r5.getId()) goto L4;
        View r13 = r12.mView;
        if (r13 == null) goto L4;
        if (r13.getParent() != null) goto L4;
        r12.mContainer = r5;
        r11.addViewToContainer();
        goto L4
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    public void performPendingDeferredStart(@NonNull FragmentStateManager r5) {
        Fragment r10 = r5.getFragment();
        if (r10.mDeferStart == true) goto L5;
        return;
    L5:
        if (this.mExecutingActions == false) goto L8;
        this.mHavePendingDeferredStart = true;
        return;
    L8:
        r10.mDeferStart = false;
        r5.moveToExpectedState();
    }

    public void popBackStack() {
        enqueueAction(new PopBackStackState(this, null, -1, 0), false);
    }

    @MainThread
    public boolean popBackStackImmediate() {
        return popBackStackImmediate(null, -1, 0);
    }

    public boolean popBackStackState(@NonNull ArrayList<BackStackRecord> r5, @NonNull ArrayList<Boolean> r10, @Nullable String r11, int r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        boolean r14 = true;
    L6:
        int r15 = findBackStackIndex(r11, r12, r14);
        if (r15 >= 0) goto L9;
        return false;
    L9:
        int r16 = this.mBackStack.size() - 1;
    L10:
        if (r16 < r15) goto L12;
        r5.add(this.mBackStack.remove(r16));
        r10.add(Boolean.TRUE);
        r16 = r16 - 1;
        goto L10
    L12:
        return true;
    L5:
        r14 = false;
        goto L6
    }

    public void putFragment(@NonNull Bundle r5, @NonNull String r10, @NonNull Fragment r11) {
        if (r11.mFragmentManager == this) goto L5;
        throwException(new IllegalStateException(androidx.constraintlayout.motion.widget.a.o("Fragment ", r11, " is not currently in the FragmentManager")));
    L5:
        r5.putString(r10, r11.mWho);
    }

    public void registerFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks r5, boolean r10) {
        this.mLifecycleCallbacksDispatcher.registerFragmentLifecycleCallbacks(r5, r10);
    }

    public void removeFragment(@NonNull Fragment r5) {
        if (isLoggingEnabled(2) == false) goto L5;
        Log.v(TAG, "remove: " + r5 + " nesting=" + r5.mBackStackNesting);
    L5:
        boolean r10 = r5.isInBackStack();
        if (r5.mDetached == false) goto L8;
        if (r10 == false) goto L8;
        return;
    L8:
        this.mFragmentStore.removeFragment(r5);
        if (isMenuAvailable(r5) == false) goto L11;
        this.mNeedMenuInvalidate = true;
    L11:
        r5.mRemoving = true;
        setVisibleRemovingFragment(r5);
    }

    public void removeFragmentOnAttachListener(@NonNull FragmentOnAttachListener r5) {
        this.mOnAttachListeners.remove(r5);
    }

    public void removeOnBackStackChangedListener(@NonNull OnBackStackChangedListener r5) {
        ArrayList<OnBackStackChangedListener> r10 = this.mBackStackChangeListeners;
        if (r10 == null) goto L6;
        r10.remove(r5);
        return;
    }

    public void removeRetainedFragment(@NonNull Fragment r5) {
        this.mNonConfig.removeRetainedFragment(r5);
    }

    public void restoreAllState(@Nullable Parcelable r5, @Nullable FragmentManagerNonConfig r10) {
        if ((this.mHost instanceof ViewModelStoreOwner) == false) goto L5;
        throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
    L5:
        this.mNonConfig.restoreFromSnapshot(r10);
        restoreSaveStateInternal(r5);
    }

    public void restoreBackStack(@NonNull String r5) {
        enqueueAction(new RestoreBackStackState(this, r5), false);
    }

    public boolean restoreBackStackState(@NonNull ArrayList<BackStackRecord> r10, @NonNull ArrayList<Boolean> r11, @NonNull String r12) {
        BackStackState r13 = this.mBackStackStates.remove(r12);
        if (r13 != null) goto L5;
        return false;
    L5:
        HashMap r5 = new HashMap();
        Iterator<BackStackRecord> r14 = r10.iterator();
    L7:
        if (r14.hasNext() == false) goto L16;
        BackStackRecord r15 = r14.next();
        if (r15.mBeingSaved == false) goto L7;
        Iterator<FragmentTransaction.Op> r16 = r15.mOps.iterator();
    L12:
        if (r16.hasNext() == false) goto L7;
        Fragment r17 = r16.next().mFragment;
        if (r17 == null) goto L12;
        r5.put(r17.mWho, r17);
        goto L12
    L16:
        Iterator<BackStackRecord> r18 = r13.instantiate(this, r5).iterator();
    L17:
        boolean r19 = false;
    L19:
        if (r18.hasNext() == false) goto L24;
        if (r18.next().generateOps(r10, r11) == true) goto L23;
        if (r19 == false) goto L17;
    L23:
        r19 = true;
        goto L19
    L24:
        return r19;
    }

    public void restoreSaveState(@Nullable Parcelable r5) {
        if ((this.mHost instanceof SavedStateRegistryOwner) == false) goto L5;
        throwException(new IllegalStateException("You cannot use restoreSaveState when your FragmentHostCallback implements SavedStateRegistryOwner."));
    L5:
        restoreSaveStateInternal(r5);
    }

    public void restoreSaveStateInternal(@Nullable Parcelable r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        Bundle r16 = (Bundle) r15;
        Iterator<String> r5 = r16.keySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L12;
        String r10 = r5.next();
        if (r10.startsWith(RESULT_KEY_PREFIX) == false) goto L6;
        Bundle r11 = r16.getBundle(r10);
        if (r11 == null) goto L6;
        r11.setClassLoader(this.mHost.getContext().getClassLoader());
        this.mResults.put(r10.substring(7), r11);
        goto L6
    L12:
        HashMap<String, Bundle> r12 = new HashMap();
        Iterator<String> r13 = r16.keySet().iterator();
    L14:
        if (r13.hasNext() == false) goto L20;
        String r14 = r13.next();
        if (r14.startsWith(FRAGMENT_KEY_PREFIX) == false) goto L14;
        Bundle r17 = r16.getBundle(r14);
        if (r17 == null) goto L14;
        r17.setClassLoader(this.mHost.getContext().getClassLoader());
        r12.put(r14.substring(9), r17);
        goto L14
    L20:
        this.mFragmentStore.restoreSaveState(r12);
        FragmentManagerState r18 = (FragmentManagerState) r16.getParcelable("state");
        if (r18 != null) goto L23;
        return;
    L23:
        this.mFragmentStore.resetActiveFragments();
        Iterator<String> r19 = r18.mActive.iterator();
    L25:
        if (r19.hasNext() == false) goto L39;
        Bundle r20 = this.mFragmentStore.setSavedState(r19.next(), null);
        if (r20 == null) goto L25;
        Fragment r21 = this.mNonConfig.findRetainedFragmentByWho(((FragmentState) r20.getParcelable("state")).mWho);
        if (r21 != null) goto L31;
        FragmentStateManager r22 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.getContext().getClassLoader(), getFragmentFactory(), r20);
    L35:
        Fragment r23 = r22.getFragment();
        r23.mSavedFragmentState = r20;
        r23.mFragmentManager = this;
        if (isLoggingEnabled(2) == false) goto L38;
        Log.v(TAG, "restoreSaveState: active (" + r23.mWho + "): " + r23);
    L38:
        r22.restoreState(this.mHost.getContext().getClassLoader());
        this.mFragmentStore.makeActive(r22);
        r22.setFragmentManagerState(this.mCurState);
        goto L25
    L31:
        if (isLoggingEnabled(2) == false) goto L33;
        Log.v(TAG, "restoreSaveState: re-attaching retained " + r21);
    L33:
        r22 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r21, r20);
        goto L35
    L39:
        Iterator<Fragment> r24 = this.mNonConfig.getRetainedFragments().iterator();
    L41:
        if (r24.hasNext() == false) goto L48;
        Fragment r25 = r24.next();
        if (this.mFragmentStore.containsActiveFragment(r25.mWho) == true) goto L41;
        if (isLoggingEnabled(2) == false) goto L47;
        Log.v(TAG, "Discarding retained Fragment " + r25 + " that was not found in the set of active Fragments " + r18.mActive);
    L47:
        this.mNonConfig.removeRetainedFragment(r25);
        r25.mFragmentManager = this;
        FragmentStateManager r26 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r25);
        r26.setFragmentManagerState(1);
        r26.moveToExpectedState();
        r25.mRemoving = true;
        r26.moveToExpectedState();
        goto L41
    L48:
        this.mFragmentStore.restoreAddedFragments(r18.mAdded);
        int r27 = 0;
        if (r18.mBackStack == null) goto L57;
        this.mBackStack = new ArrayList(r18.mBackStack.length);
        int r28 = 0;
    L51:
        BackStackRecordState[] r29 = r18.mBackStack;
        if (r28 >= r29.length) goto L58;
        BackStackRecord r30 = r29[r28].instantiate(this);
        if (isLoggingEnabled(2) == false) goto L56;
        StringBuilder r31 = j0.s(r28, "restoreAllState: back stack #", " (index ");
        r31.append(r30.mIndex);
        r31.append("): ");
        r31.append(r30);
        Log.v(TAG, r31.toString());
        PrintWriter r32 = new PrintWriter(new LogWriter(TAG));
        r30.dump("  ", r32, false);
        r32.close();
    L56:
        this.mBackStack.add(r30);
        r28 = r28 + 1;
    L58:
        this.mBackStackIndex.set(r18.mBackStackIndex);
        String r33 = r18.mPrimaryNavActiveWho;
        if (r33 == null) goto L61;
        Fragment r34 = findActiveFragment(r33);
        this.mPrimaryNav = r34;
        dispatchParentPrimaryNavigationFragmentChanged(r34);
    L61:
        ArrayList<String> r35 = r18.mBackStackStateKeys;
        if (r35 != null) goto L64;
    L66:
        this.mLaunchedFragments = new ArrayDeque(r18.mLaunchedFragments);
        return;
    L64:
        if (r27 >= r35.size()) goto L66;
        this.mBackStackStates.put(r35.get(r27), r18.mBackStackStates.get(r27));
        r27 = r27 + 1;
        goto L64
    L57:
        this.mBackStack = null;
        goto L58
    }

    @Deprecated
    public FragmentManagerNonConfig retainNonConfig() {
        if ((this.mHost instanceof ViewModelStoreOwner) == false) goto L6;
        throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
    L6:
        return this.mNonConfig.getSnapshot();
    }

    public Parcelable saveAllState() {
        if ((this.mHost instanceof SavedStateRegistryOwner) == false) goto L5;
        throwException(new IllegalStateException("You cannot use saveAllState when your FragmentHostCallback implements SavedStateRegistryOwner."));
    L5:
        Bundle r5 = saveAllStateInternal();
        if (r5.isEmpty() == false) goto L9;
        return null;
    L9:
        return r5;
    }

    @NonNull
    public Bundle saveAllStateInternal() {
        Bundle r5 = new Bundle();
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.setIsStateSaved(true);
        ArrayList<String> r10 = this.mFragmentStore.saveActiveFragments();
        HashMap<String, Bundle> r11 = this.mFragmentStore.getAllSavedState();
        if (r11.isEmpty() == true) goto L5;
        ArrayList<String> r12 = this.mFragmentStore.saveAddedFragments();
        ArrayList<BackStackRecord> r13 = this.mBackStack;
        if (r13 == null) goto L17;
        int r14 = r13.size();
        if (r14 <= 0) goto L17;
        BackStackRecordState[] r15 = new BackStackRecordState[r14];
        int r16 = 0;
    L12:
        if (r16 >= r14) goto L18;
        r15[r16] = new BackStackRecordState(this.mBackStack.get(r16));
        if (isLoggingEnabled(2) == false) goto L16;
        StringBuilder r17 = j0.s(r16, "saveAllState: adding back stack #", ": ");
        r17.append(this.mBackStack.get(r16));
        Log.v(TAG, r17.toString());
    L16:
        r16 = r16 + 1;
    L18:
        FragmentManagerState r18 = new FragmentManagerState();
        r18.mActive = r10;
        r18.mAdded = r12;
        r18.mBackStack = r15;
        r18.mBackStackIndex = this.mBackStackIndex.get();
        Fragment r19 = this.mPrimaryNav;
        if (r19 == null) goto L21;
        r18.mPrimaryNavActiveWho = r19.mWho;
    L21:
        r18.mBackStackStateKeys.addAll(this.mBackStackStates.keySet());
        r18.mBackStackStates.addAll(this.mBackStackStates.values());
        r18.mLaunchedFragments = new ArrayList(this.mLaunchedFragments);
        r5.putParcelable("state", r18);
        Iterator<String> r20 = this.mResults.keySet().iterator();
    L23:
        if (r20.hasNext() == false) goto L25;
        String r21 = r20.next();
        r5.putBundle(j0.C(RESULT_KEY_PREFIX, r21), this.mResults.get(r21));
        goto L23
    L25:
        Iterator<String> r110 = r11.keySet().iterator();
    L27:
        if (r110.hasNext() == false) goto L29;
        String r22 = r110.next();
        r5.putBundle(j0.C(FRAGMENT_KEY_PREFIX, r22), r11.get(r22));
    L29:
        return r5;
    L17:
        r15 = null;
        goto L18
    L5:
        if (isLoggingEnabled(2) == false) goto L29;
        Log.v(TAG, "saveAllState: no fragments!");
        goto L29
    }

    public void saveBackStack(@NonNull String r5) {
        enqueueAction(new SaveBackStackState(this, r5), false);
    }

    public boolean saveBackStackState(@NonNull ArrayList<BackStackRecord> r17, @NonNull ArrayList<Boolean> r18, @NonNull String r19) {
        int r5 = findBackStackIndex(r19, -1, true);
        if (r5 >= 0) goto L6;
        return false;
    L6:
        int r10 = r5;
    L8:
        if (r10 >= this.mBackStack.size()) goto L13;
        BackStackRecord r11 = this.mBackStack.get(r10);
        if (r11.mReorderingAllowed == true) goto L12;
        throwException(new IllegalArgumentException("saveBackStack(\"" + r19 + "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found " + r11 + " that did not use setReorderingAllowed(true)."));
    L12:
        r10 = r10 + 1;
        goto L8
    L13:
        HashSet r12 = new HashSet();
        int r13 = r5;
    L15:
        if (r13 >= this.mBackStack.size()) goto L42;
        BackStackRecord r14 = this.mBackStack.get(r13);
        HashSet r15 = new HashSet();
        HashSet r16 = new HashSet();
        Iterator<FragmentTransaction.Op> r110 = r14.mOps.iterator();
    L18:
        if (r110.hasNext() == false) goto L34;
        FragmentTransaction.Op r111 = r110.next();
        Fragment r112 = r111.mFragment;
        if (r112 == null) goto L18;
        if (r111.mFromExpandedOp == false) goto L29;
        int r113 = r111.mCmd;
        if (r113 == 1) goto L29;
        if (r113 == 2) goto L29;
        if (r113 == 8) goto L29;
    L30:
        int r114 = r111.mCmd;
        if (r114 == 1) goto L33;
        if (r114 != 2) goto L18;
    L33:
        r16.add(r112);
    L29:
        r12.add(r112);
        r15.add(r112);
        goto L30
    L34:
        r15.removeAll(r16);
        if (r15.isEmpty() == true) goto L41;
        StringBuilder r115 = j0.x("saveBackStack(\"", r19, "\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
        if (r15.size() != 1) goto L39;
        String r20 = " " + r15.iterator().next();
    L40:
        r115.append(r20);
        r115.append(" in ");
        r115.append(r14);
        r115.append(" that were previously added to the FragmentManager through a separate FragmentTransaction.");
        throwException(new IllegalArgumentException(r115.toString()));
        goto L41
    L39:
        r20 = "s " + r15;
    L41:
        r13 = r13 + 1;
        goto L15
    L42:
        ArrayDeque r21 = new ArrayDeque(r12);
    L44:
        if (r21.isEmpty() == true) goto L58;
        Fragment r22 = (Fragment) r21.removeFirst();
        if (r22.mRetainInstance == false) goto L52;
        StringBuilder r23 = j0.x("saveBackStack(\"", r19, "\") must not contain retained fragments. Found ");
        if (r12.contains(r22) == false) goto L50;
        String r116 = "direct reference to retained ";
    L51:
        r23.append(r116);
        r23.append("fragment ");
        r23.append(r22);
        throwException(new IllegalArgumentException(r23.toString()));
        goto L52
    L50:
        r116 = "retained child ";
    L52:
        Iterator<Fragment> r24 = r22.mChildFragmentManager.getActiveFragments().iterator();
    L54:
        if (r24.hasNext() == false) goto L44;
        Fragment r25 = r24.next();
        if (r25 == null) goto L54;
        r21.addLast(r25);
        goto L54
    L58:
        ArrayList r26 = new ArrayList();
        Iterator r27 = r12.iterator();
    L60:
        if (r27.hasNext() == false) goto L62;
        r26.add(((Fragment) r27.next()).mWho);
        goto L60
    L62:
        ArrayList r28 = new ArrayList(this.mBackStack.size() - r5);
        int r29 = r5;
    L64:
        if (r29 >= this.mBackStack.size()) goto L66;
        r28.add(null);
        r29 = r29 + 1;
        goto L64
    L66:
        BackStackState r30 = new BackStackState(r26, r28);
        int r31 = this.mBackStack.size() - 1;
    L67:
        if (r31 < r5) goto L69;
        BackStackRecord r32 = this.mBackStack.remove(r31);
        BackStackRecord r33 = new BackStackRecord(r32);
        r33.collapseOps();
        r28.set(r31 - r5, new BackStackRecordState(r33));
        r32.mBeingSaved = true;
        r17.add(r32);
        r18.add(Boolean.TRUE);
        r31 = r31 - 1;
        goto L67
    L69:
        this.mBackStackStates.put(r19, r30);
        return true;
    }

    @Nullable
    public Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment r5) {
        FragmentStateManager r10 = this.mFragmentStore.getFragmentStateManager(r5.mWho);
        if (r10 != null) goto L5;
    L6:
        throwException(new IllegalStateException(androidx.constraintlayout.motion.widget.a.o("Fragment ", r5, " is not currently in the FragmentManager")));
    L8:
        return r10.saveInstanceState();
    L5:
        if (r10.getFragment().equals(r5) == true) goto L8;
        goto L6
    }

    public void scheduleCommit() {
        ArrayList<OpGenerator> r5 = this.mPendingActions;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingActions.size() != 1) goto L9;
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L7
        this.mHost.getHandler().post(this.mExecCommit);     // Catch: Throwable -> L7
        updateOnBackPressedCallbackEnabled();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r5);     // Catch: Throwable -> L7
    }

    public void setExitAnimationOrder(@NonNull Fragment r5, boolean r10) {
        ViewGroup r11 = getFragmentContainer(r5);
        if (r11 != null) goto L5;
        return;
    L5:
        if ((r11 instanceof FragmentContainerView) == false) goto L9;
        ((FragmentContainerView) r11).setDrawDisappearingViewsLast(!r10);
        return;
    }

    public void setFragmentFactory(@NonNull FragmentFactory r5) {
        this.mFragmentFactory = r5;
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void setFragmentResult(@NonNull String r5, @NonNull Bundle r10) {
        LifecycleAwareResultListener r11 = this.mResultListeners.get(r5);
        if (r11 != null) goto L5;
    L7:
        this.mResults.put(r5, r10);
    L9:
        if (isLoggingEnabled(2) == false) goto L12;
        Log.v(TAG, "Setting fragment result with key " + r5 + " and result " + r10);
        return;
    L12:
        return;
    L5:
        if (r11.isAtLeast(Lifecycle.State.STARTED) == false) goto L7;
        r11.onFragmentResult(r5, r10);
        goto L9
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    @SuppressLint({"SyntheticAccessor"})
    public final void setFragmentResultListener(@NonNull final String r5, @NonNull LifecycleOwner r10, @NonNull final FragmentResultListener r11) {
        final Lifecycle r12 = r10.getLifecycle();
        if (r12.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        LifecycleEventObserver r13 = new AnonymousClass6(this, r5, r11, r12);
        LifecycleAwareResultListener r14 = this.mResultListeners.put(r5, new LifecycleAwareResultListener(r12, r11, r13));
        if (r14 == null) goto L9;
        r14.removeObserver();
    L9:
        if (isLoggingEnabled(2) == false) goto L11;
        Log.v(TAG, "Setting FragmentResultListener with key " + r5 + " lifecycleOwner " + r12 + " and listener " + r11);
    L11:
        r12.addObserver(r13);
    }

    public void setMaxLifecycle(@NonNull Fragment r5, @NonNull Lifecycle.State r10) {
        if (r5.equals(findActiveFragment(r5.mWho)) == false) goto L11;
        if (r5.mHost != null) goto L7;
    L8:
        r5.mMaxState = r10;
        return;
    L7:
        if (r5.mFragmentManager == this) goto L8;
    L11:
        throw new IllegalArgumentException("Fragment " + r5 + " is not an active fragment of FragmentManager " + this);
    }

    public void setPrimaryNavigationFragment(@Nullable Fragment r5) {
        if (r5 != null) goto L4;
    L12:
        Fragment r10 = this.mPrimaryNav;
        this.mPrimaryNav = r5;
        dispatchParentPrimaryNavigationFragmentChanged(r10);
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
        return;
    L4:
        if (r5.equals(findActiveFragment(r5.mWho)) == false) goto L11;
        if (r5.mHost == null) goto L12;
        if (r5.mFragmentManager == this) goto L12;
    L11:
        throw new IllegalArgumentException("Fragment " + r5 + " is not an active fragment of FragmentManager " + this);
    }

    public void setSpecialEffectsControllerFactory(@NonNull SpecialEffectsControllerFactory r5) {
        this.mSpecialEffectsControllerFactory = r5;
    }

    public void setStrictModePolicy(@Nullable FragmentStrictMode.Policy r5) {
        this.mStrictModePolicy = r5;
    }

    public void showFragment(@NonNull Fragment r5) {
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "show: " + r5);
    L6:
        if (r5.mHidden == false) goto L9;
        r5.mHidden = false;
        r5.mHiddenChanged = !r5.mHiddenChanged;
        return;
    }

    @NonNull
    public String toString() {
        StringBuilder r5 = androidx.constraintlayout.motion.widget.a.x(128, "FragmentManager{");
        r5.append(Integer.toHexString(System.identityHashCode(this)));
        r5.append(" in ");
        Fragment r10 = this.mParent;
        if (r10 == null) goto L5;
        r5.append(r10.getClass().getSimpleName());
        r5.append("{");
        r5.append(Integer.toHexString(System.identityHashCode(this.mParent)));
        r5.append("}");
    L9:
        r5.append("}}");
        return r5.toString();
    L5:
        FragmentHostCallback<?> r11 = this.mHost;
        if (r11 == null) goto L8;
        r5.append(r11.getClass().getSimpleName());
        r5.append("{");
        r5.append(Integer.toHexString(System.identityHashCode(this.mHost)));
        r5.append("}");
        goto L9
    L8:
        r5.append("null");
        goto L9
    }

    public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks r5) {
        this.mLifecycleCallbacksDispatcher.unregisterFragmentLifecycleCallbacks(r5);
    }

    public void popBackStack(@Nullable String r5, int r10) {
        enqueueAction(new PopBackStackState(this, r5, -1, r10), false);
    }

    @MainThread
    public boolean popBackStackImmediate(@Nullable String r5, int r10) {
        return popBackStackImmediate(r5, -1, r10);
    }

    public void popBackStack(int r5, int r10) {
        popBackStack(r5, r10, false);
    }

    public boolean popBackStackImmediate(int r5, int r10) {
        if (r5 < 0) goto L6;
        return popBackStackImmediate(null, r5, r10);
    L6:
        throw new IllegalArgumentException(j0.g(r5, "Bad id: "));
    }

    public void popBackStack(int r5, int r10, boolean r11) {
        if (r5 < 0) goto L6;
        enqueueAction(new PopBackStackState(this, null, r5, r10), r11);
        return;
    L6:
        throw new IllegalArgumentException(j0.g(r5, "Bad id: "));
    }

    private boolean popBackStackImmediate(@Nullable String r10, int r11, int r12) {
        execPendingActions(false);
        ensureExecReady(true);
        Fragment r5 = this.mPrimaryNav;
        if (r5 == null) goto L9;
        if (r11 >= 0) goto L9;
        if (r10 != null) goto L9;
        if (r5.getChildFragmentManager().popBackStackImmediate() == false) goto L9;
        return true;
    L9:
        boolean r13 = popBackStackState(this.mTmpRecords, this.mTmpIsPop, r10, r11, r12);
        if (r13 == false) goto L17;
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
        return r13;
    }
}
