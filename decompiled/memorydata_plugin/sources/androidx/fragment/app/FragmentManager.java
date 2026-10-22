package androidx.fragment.app;

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
import android.view.ViewParent;
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
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager implements FragmentResultOwner {
    private static boolean DEBUG = false;
    private static final String EXTRA_CREATED_FILLIN_INTENT = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    static final String FRAGMENT_MANAGER_STATE_TAG = "state";
    static final String FRAGMENT_NAME_PREFIX = "fragment_";
    static final String FRAGMENT_STATE_TAG = "state";
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    static final String RESULT_NAME_PREFIX = "result_";
    static final String SAVED_STATE_TAG = "android:support:fragments";
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
        @Deprecated
        CharSequence getBreadCrumbShortTitle();

        @Deprecated
        int getBreadCrumbShortTitleRes();

        @Deprecated
        CharSequence getBreadCrumbTitle();

        @Deprecated
        int getBreadCrumbTitleRes();

        int getId();

        String getName();
    }

    private class ClearBackStackState implements OpGenerator {
        private final String mName;
        final /* synthetic */ FragmentManager this$0;

        ClearBackStackState(FragmentManager r1, String r2) {
            this.this$0 = r1;
            this.mName = r2;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> r2, ArrayList<Boolean> r3) {
            return this.this$0.clearBackStackState(r2, r3, this.mName);
        }
    }

    static class FragmentIntentSenderContract extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        FragmentIntentSenderContract() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r3, IntentSenderRequest r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intent r5 = new Intent(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST);
            Intent r6 = r4.getFillInIntent();
            if (r6 == null) goto L9;
            Bundle r1 = r6.getBundleExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            if (r1 == null) goto L9;
            r5.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r1);
            r6.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            if (r6.getBooleanExtra(FragmentManager.EXTRA_CREATED_FILLIN_INTENT, false) == false) goto L9;
            r4 = new IntentSenderRequest.Builder(r4.getIntentSender()).setFillInIntent(null).setFlags(r4.getFlagsValues(), r4.getFlagsMask()).build();
        L9:
            r5.putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST, r4);
            if (FragmentManager.isLoggingEnabled(2) == false) goto L12;
            Log.v(FragmentManager.TAG, "CreateIntent created the following intent: " + r5);
        L12:
            return r5;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* synthetic */ Intent createIntent(Context r3, IntentSenderRequest r4) {
            return createIntent2((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (IntentSenderRequest) ZeusTransformUtils.preCheckCast(r4, IntentSenderRequest.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public ActivityResult parseResult(int r1, Intent r2) {
            return new ActivityResult(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResult parseResult(int r1, Intent r2) {
            return parseResult(r1, r2);
        }
    }

    public static abstract class FragmentLifecycleCallbacks {
        public FragmentLifecycleCallbacks() {
        }

        @Deprecated
        public void onFragmentActivityCreated(FragmentManager r1, Fragment r2, Bundle r3) {
        }

        public void onFragmentAttached(FragmentManager r1, Fragment r2, Context r3) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        }

        public void onFragmentCreated(FragmentManager r1, Fragment r2, Bundle r3) {
        }

        public void onFragmentDestroyed(FragmentManager r1, Fragment r2) {
        }

        public void onFragmentDetached(FragmentManager r1, Fragment r2) {
        }

        public void onFragmentPaused(FragmentManager r1, Fragment r2) {
        }

        public void onFragmentPreAttached(FragmentManager r1, Fragment r2, Context r3) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        }

        public void onFragmentPreCreated(FragmentManager r1, Fragment r2, Bundle r3) {
        }

        public void onFragmentResumed(FragmentManager r1, Fragment r2) {
        }

        public void onFragmentSaveInstanceState(FragmentManager r1, Fragment r2, Bundle r3) {
        }

        public void onFragmentStarted(FragmentManager r1, Fragment r2) {
        }

        public void onFragmentStopped(FragmentManager r1, Fragment r2) {
        }

        public void onFragmentViewCreated(FragmentManager r1, Fragment r2, View r3, Bundle r4) {
        }

        public void onFragmentViewDestroyed(FragmentManager r1, Fragment r2) {
        }
    }

    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = null;
        int mRequestCode;
        String mWho;

        static {
            CREATOR = new AnonymousClass1();
        }

        LaunchedFragmentInfo(Parcel r2) {
            this.mWho = r2.readString();
            this.mRequestCode = r2.readInt();
        }

        LaunchedFragmentInfo(String r1, int r2) {
            this.mWho = r1;
            this.mRequestCode = r2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeString(this.mWho);
            r1.writeInt(this.mRequestCode);
        }
    }

    private static class LifecycleAwareResultListener implements FragmentResultListener {
        private final Lifecycle mLifecycle;
        private final FragmentResultListener mListener;
        private final LifecycleEventObserver mObserver;

        LifecycleAwareResultListener(Lifecycle r3, FragmentResultListener r4, LifecycleEventObserver r5) {
            FragmentResultListener r6 = (FragmentResultListener) ZeusTransformUtils.wrapperContextForParams(r4, FragmentResultListener.class, "com.obric.memorydata.plugin");
            LifecycleEventObserver r7 = (LifecycleEventObserver) ZeusTransformUtils.wrapperContextForParams(r5, LifecycleEventObserver.class, "com.obric.memorydata.plugin");
            this.mLifecycle = r3;
            this.mListener = r6;
            this.mObserver = r7;
        }

        public boolean isAtLeast(Lifecycle.State r1) {
            return this.mLifecycle.getCurrentState().isAtLeast(r1);
        }

        @Override // androidx.fragment.app.FragmentResultListener
        public void onFragmentResult(String r1, Bundle r2) {
            this.mListener.onFragmentResult(r1, r2);
        }

        public void removeObserver() {
            this.mLifecycle.removeObserver(this.mObserver);
        }
    }

    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    interface OpGenerator {
        boolean generateOps(ArrayList<BackStackRecord> r1, ArrayList<Boolean> r2);
    }

    private class PopBackStackState implements OpGenerator {
        final int mFlags;
        final int mId;
        final String mName;
        final /* synthetic */ FragmentManager this$0;

        PopBackStackState(FragmentManager r1, String r2, int r3, int r4) {
            this.this$0 = r1;
            this.mName = r2;
            this.mId = r3;
            this.mFlags = r4;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> r7, ArrayList<Boolean> r8) {
            if (this.this$0.mPrimaryNav == null) goto L13;
            if (this.mId >= 0) goto L13;
            if (this.mName != null) goto L13;
            if (this.this$0.mPrimaryNav.getChildFragmentManager().popBackStackImmediate() == false) goto L13;
            return false;
        L13:
            return this.this$0.popBackStackState(r7, r8, this.mName, this.mId, this.mFlags);
        }
    }

    private class RestoreBackStackState implements OpGenerator {
        private final String mName;
        final /* synthetic */ FragmentManager this$0;

        RestoreBackStackState(FragmentManager r1, String r2) {
            this.this$0 = r1;
            this.mName = r2;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> r2, ArrayList<Boolean> r3) {
            return this.this$0.restoreBackStackState(r2, r3, this.mName);
        }
    }

    private class SaveBackStackState implements OpGenerator {
        private final String mName;
        final /* synthetic */ FragmentManager this$0;

        SaveBackStackState(FragmentManager r1, String r2) {
            this.this$0 = r1;
            this.mName = r2;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> r2, ArrayList<Boolean> r3) {
            return this.this$0.saveBackStackState(r2, r3, this.mName);
        }
    }

    static {
    }

    public FragmentManager() {
        this.mPendingActions = new ArrayList();
        this.mFragmentStore = new FragmentStore();
        this.mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
        final boolean r1 = false;
        this.mOnBackPressedCallback = new AnonymousClass1(this, r1);
        this.mBackStackIndex = new AtomicInteger();
        this.mBackStackStates = Collections.synchronizedMap(new HashMap());
        this.mResults = Collections.synchronizedMap(new HashMap());
        this.mResultListeners = Collections.synchronizedMap(new HashMap());
        this.mLifecycleCallbacksDispatcher = new FragmentLifecycleCallbacksDispatcher(this);
        this.mOnAttachListeners = new CopyOnWriteArrayList();
        this.mOnConfigurationChangedListener = new $$Lambda$FragmentManager$fsqPmeLyp8R2NG2vLmIMKnwX3q4(this);
        this.mOnTrimMemoryListener = new $$Lambda$FragmentManager$OSbytOFWiBhgJuC68xxqeOPrI(this);
        this.mOnMultiWindowModeChangedListener = new $$Lambda$FragmentManager$VJusBxtSf6gkO7njmGWkIPixRc(this);
        this.mOnPictureInPictureModeChangedListener = new $$Lambda$FragmentManager$RBeuZ6iM1FSdhmZNBJJQnbWnePM(this);
        this.mMenuProvider = new AnonymousClass2(this);
        this.mCurState = -1;
        this.mFragmentFactory = null;
        this.mHostFragmentFactory = new AnonymousClass3(this);
        this.mSpecialEffectsControllerFactory = null;
        this.mDefaultSpecialEffectsControllerFactory = new AnonymousClass4(this);
        this.mLaunchedFragments = new ArrayDeque();
        this.mExecCommit = new AnonymousClass5(this);
    }

    static /* synthetic */ Map access$000(FragmentManager r0) {
        return r0.mResults;
    }

    static /* synthetic */ Map access$100(FragmentManager r0) {
        return r0.mResultListeners;
    }

    static /* synthetic */ FragmentStore access$200(FragmentManager r0) {
        return r0.mFragmentStore;
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
        boolean r1 = true;
        if (ZeusTransformUtils.instanceOf(this.mHost, ViewModelStoreOwner.class) == false) goto L6;
        r1 = this.mFragmentStore.getNonConfig().isCleared();
    L8:
        if (r1 == false) goto L16;
        Iterator<BackStackState> r0 = this.mBackStackStates.values().iterator();
    L11:
        if (r0.hasNext() == false) goto L19;
        Iterator<String> r2 = ((BackStackState) ZeusTransformUtils.preCheckCast(r0.next(), BackStackState.class, "com.obric.memorydata.plugin")).mFragments.iterator();
    L14:
        if (r2.hasNext() == false) goto L11;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        this.mFragmentStore.getNonConfig().clearNonConfigState(r3);
        goto L14
    L19:
        return;
    L16:
        return;
    L6:
        if (ZeusTransformUtils.instanceOf((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mHost.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), Activity.class) == false) goto L8;
        r1 = true ^ ((Activity) ZeusTransformUtils.preCheckCast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mHost.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")).isChangingConfigurations();
        goto L8
    }

    private Set<SpecialEffectsController> collectAllSpecialEffectsController() {
        HashSet r0 = new HashSet();
        Iterator<FragmentStateManager> r1 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        ViewGroup r2 = ((FragmentStateManager) ZeusTransformUtils.preCheckCast(r1.next(), FragmentStateManager.class, "com.obric.memorydata.plugin")).getFragment().mContainer;
        if (r2 == null) goto L4;
        r0.add(SpecialEffectsController.getOrCreateController(r2, getSpecialEffectsControllerFactory()));
        goto L4
    L8:
        return r0;
    }

    private Set<SpecialEffectsController> collectChangedControllers(ArrayList<BackStackRecord> r6, int r7, int r8) {
        HashSet r0 = new HashSet();
    L3:
        if (r7 >= r8) goto L13;
        Iterator<FragmentTransaction.Op> r1 = ((BackStackRecord) ZeusTransformUtils.preCheckCast(r6.get(r7), BackStackRecord.class, "com.obric.memorydata.plugin")).mOps.iterator();
    L6:
        if (r1.hasNext() == false) goto L12;
        Fragment r2 = ((FragmentTransaction.Op) ZeusTransformUtils.preCheckCast(r1.next(), FragmentTransaction.Op.class, "com.obric.memorydata.plugin")).mFragment;
        if (r2 == null) goto L6;
        ViewGroup r3 = r2.mContainer;
        if (r3 == null) goto L6;
        r0.add(SpecialEffectsController.getOrCreateController(r3, this));
        goto L6
    L12:
        r7 = r7 + 1;
        goto L3
    L13:
        return r0;
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(Fragment r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.equals(findActiveFragment(r2.mWho)) == false) goto L8;
        r2.performPrimaryNavigationFragmentChanged();
        return;
    }

    private void dispatchStateChange(int r6) {
        this.mExecutingActions = true;     // Catch: Throwable -> L10
        this.mFragmentStore.dispatchStateChange(r6);     // Catch: Throwable -> L10
        moveToState(r6, false);     // Catch: Throwable -> L10
        Iterator<SpecialEffectsController> r7 = collectAllSpecialEffectsController().iterator();     // Catch: Throwable -> L10
    L5:
        if (r7.hasNext() == false) goto L8;
        ((SpecialEffectsController) ZeusTransformUtils.preCheckCast(r7.next(), SpecialEffectsController.class, "com.obric.memorydata.plugin")).forceCompleteAllOperations();     // Catch: Throwable -> L10
        goto L5
    L8:
        this.mExecutingActions = false;
        execPendingActions(true);
        return;
    L10:
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
    public static void enableDebugLogging(boolean r0) {
        DEBUG = r0;
    }

    private void endAnimatingAwayFragments() {
        Iterator<SpecialEffectsController> r3 = collectAllSpecialEffectsController().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((SpecialEffectsController) ZeusTransformUtils.preCheckCast(r3.next(), SpecialEffectsController.class, "com.obric.memorydata.plugin")).forceCompleteAllOperations();
        goto L4
    }

    private void ensureExecReady(boolean r3) {
        if (this.mExecutingActions == true) goto L23;
        if (this.mHost != null) goto L13;
        if (this.mDestroyed == false) goto L11;
        throw new IllegalStateException("FragmentManager has been destroyed");
    L11:
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    L13:
        if (Looper.myLooper() != this.mHost.getHandler().getLooper()) goto L21;
        if (r3 == true) goto L17;
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

    private static void executeOps(ArrayList<BackStackRecord> r4, ArrayList<Boolean> r5, int r6, int r7) {
    L2:
        if (r6 >= r7) goto L8;
        BackStackRecord r0 = (BackStackRecord) ZeusTransformUtils.preCheckCast(r4.get(r6), BackStackRecord.class, "com.obric.memorydata.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5.get(r6), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
        r0.bumpBackStackNesting(-1);
        r0.executePopOps();
    L7:
        r6 = r6 + 1;
        goto L2
    L6:
        r0.bumpBackStackNesting(1);
        r0.executeOps();
        goto L7
    }

    private void executeOpsTogether(ArrayList<BackStackRecord> r11, ArrayList<Boolean> r12, int r13, int r14) {
        boolean r0 = ((BackStackRecord) ZeusTransformUtils.preCheckCast(r11.get(r13), BackStackRecord.class, "com.obric.memorydata.plugin")).mReorderingAllowed;
        ArrayList<Fragment> r1 = this.mTmpAddedFragments;
        if (r1 != null) goto L5;
        this.mTmpAddedFragments = new ArrayList();
    L6:
        this.mTmpAddedFragments.addAll(this.mFragmentStore.getFragments());
        Fragment r2 = getPrimaryNavigationFragment();
        int r4 = r13;
        boolean r5 = false;
    L8:
        if (r4 >= r14) goto L20;
        BackStackRecord r7 = (BackStackRecord) ZeusTransformUtils.preCheckCast(r11.get(r4), BackStackRecord.class, "com.obric.memorydata.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r12.get(r4), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L12;
        r2 = r7.expandOps(this.mTmpAddedFragments, r2);
    L13:
        if (r5 == false) goto L15;
    L18:
        r5 = true;
    L19:
        r4 = r4 + 1;
        goto L8
    L15:
        if (r7.mAddToBackStack == true) goto L18;
        r5 = false;
        goto L19
    L12:
        r2 = r7.trackAddedFragmentsInPop(this.mTmpAddedFragments, r2);
        goto L13
    L20:
        this.mTmpAddedFragments.clear();
        if (r0 == false) goto L23;
    L35:
        executeOps(r11, r12, r13, r14);
        boolean r3 = ((Boolean) ZeusTransformUtils.preCheckCast(r12.get(r14 - 1), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        int r6 = r13;
    L36:
        if (r6 >= r14) goto L52;
        BackStackRecord r8 = (BackStackRecord) ZeusTransformUtils.preCheckCast(r11.get(r6), BackStackRecord.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L45;
        int r9 = r8.mOps.size() - 1;
    L40:
        if (r9 < 0) goto L51;
        Fragment r10 = ((FragmentTransaction.Op) ZeusTransformUtils.preCheckCast(r8.mOps.get(r9), FragmentTransaction.Op.class, "com.obric.memorydata.plugin")).mFragment;
        if (r10 == null) goto L44;
        createOrGetFragmentStateManager(r10).moveToExpectedState();
    L44:
        r9 = r9 - 1;
    L51:
        r6 = r6 + 1;
        goto L36
    L45:
        Iterator<FragmentTransaction.Op> r15 = r8.mOps.iterator();
    L47:
        if (r15.hasNext() == false) goto L51;
        Fragment r16 = ((FragmentTransaction.Op) ZeusTransformUtils.preCheckCast(r15.next(), FragmentTransaction.Op.class, "com.obric.memorydata.plugin")).mFragment;
        if (r16 == null) goto L47;
        createOrGetFragmentStateManager(r16).moveToExpectedState();
        goto L47
    L52:
        moveToState(this.mCurState, true);
        Iterator<SpecialEffectsController> r17 = collectChangedControllers(r11, r13, r14).iterator();
    L54:
        if (r17.hasNext() == false) goto L56;
        SpecialEffectsController r18 = (SpecialEffectsController) ZeusTransformUtils.preCheckCast(r17.next(), SpecialEffectsController.class, "com.obric.memorydata.plugin");
        r18.updateOperationDirection(r3);
        r18.markPostponedState();
        r18.executePendingOperations();
    L56:
        if (r13 >= r14) goto L63;
        BackStackRecord r19 = (BackStackRecord) ZeusTransformUtils.preCheckCast(r11.get(r13), BackStackRecord.class, "com.obric.memorydata.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r12.get(r13), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L62;
        if (r19.mIndex < 0) goto L62;
        r19.mIndex = -1;
    L62:
        r19.runOnCommitRunnables();
        r13 = r13 + 1;
        goto L56
    L63:
        if (r5 == false) goto L91;
        reportBackStackChanged();
        return;
    L91:
        return;
    L23:
        if (this.mCurState < 1) goto L35;
        int r20 = r13;
    L25:
        if (r20 >= r14) goto L35;
        Iterator<FragmentTransaction.Op> r21 = ((BackStackRecord) ZeusTransformUtils.preCheckCast(r11.get(r20), BackStackRecord.class, "com.obric.memorydata.plugin")).mOps.iterator();
    L28:
        if (r21.hasNext() == false) goto L34;
        Fragment r22 = ((FragmentTransaction.Op) ZeusTransformUtils.preCheckCast(r21.next(), FragmentTransaction.Op.class, "com.obric.memorydata.plugin")).mFragment;
        if (r22 == null) goto L28;
        if (r22.mFragmentManager == null) goto L28;
        this.mFragmentStore.makeActive(createOrGetFragmentStateManager(r22));
        goto L28
    L34:
        r20 = r20 + 1;
        goto L25
    L5:
        r1.clear();
        goto L6
    }

    private int findBackStackIndex(String r6, int r7, boolean r8) {
        ArrayList<BackStackRecord> r0 = this.mBackStack;
        if (r0 != null) goto L5;
    L44:
        return -1;
    L5:
        if (r0.isEmpty() == true) goto L44;
        if (r6 != null) goto L14;
        if (r7 >= 0) goto L14;
        if (r8 == false) goto L13;
        return 0;
    L13:
        return this.mBackStack.size() - 1;
    L14:
        int r1 = this.mBackStack.size();
    L15:
        r1 = r1 - 1;
        if (r1 < 0) goto L27;
        BackStackRecord r3 = (BackStackRecord) ZeusTransformUtils.preCheckCast(this.mBackStack.get(r1), BackStackRecord.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L20;
    L22:
        if (r7 < 0) goto L15;
        if (r7 != r3.mIndex) goto L15;
    L20:
        if (r6.equals(r3.getName()) == false) goto L22;
    L27:
        if (r1 >= 0) goto L29;
        return r1;
    L29:
        if (r8 == false) goto L40;
    L30:
        if (r1 <= 0) goto L57;
        BackStackRecord r9 = (BackStackRecord) ZeusTransformUtils.preCheckCast(this.mBackStack.get(r1 - 1), BackStackRecord.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L34;
    L35:
        if (r7 < 0) goto L55;
        if (r7 == r9.mIndex) goto L38;
        return r1;
    L38:
        r1 = r1 - 1;
        goto L30
    L55:
        return r1;
    L34:
        if (r6.equals(r9.getName()) == true) goto L38;
    L57:
        return r1;
    L40:
        if (r1 != (this.mBackStack.size() - 1)) goto L43;
        return -1;
    L43:
        return r1 + 1;
    }

    public static <F extends Fragment> F findFragment(View r3) {
        F r0 = (F) findViewFragment(r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("View " + r3 + " does not have a Fragment set");
    }

    static FragmentManager findFragmentManager(View r4) {
        Fragment r0 = findViewFragment(r4);
        if (r0 != null) goto L5;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        FragmentActivity r2 = null;
    L11:
        if (ZeusTransformUtils.instanceOf(r1, ContextWrapper.class) == false) goto L16;
        if (ZeusTransformUtils.instanceOf(r1, FragmentActivity.class) == true) goto L14;
        r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r1, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        goto L11
    L14:
        r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(r1, FragmentActivity.class, "com.obric.memorydata.plugin");
    L16:
        if (r2 == null) goto L20;
        return r2.getSupportFragmentManager();
    L20:
        throw new IllegalStateException("View " + r4 + " is not within a subclass of FragmentActivity.");
    L5:
        if (r0.isAdded() == false) goto L8;
        return r0.getChildFragmentManager();
    L8:
        throw new IllegalStateException("The Fragment " + r0 + " that owns View " + r4 + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
    }

    private static Fragment findViewFragment(View r2) {
    L3:
        if (r2 == null) goto L11;
        Fragment r1 = getViewFragment(r2);
        if (r1 != null) goto L6;
        ViewParent r3 = r2.getParent();
        if (ZeusTransformUtils.instanceOf(r3, View.class) == true) goto L9;
        r2 = null;
        goto L3
    L9:
        r2 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");
        goto L3
    L6:
        return r1;
    L11:
        return null;
    }

    private void forcePostponedTransactions() {
        Iterator<SpecialEffectsController> r3 = collectAllSpecialEffectsController().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((SpecialEffectsController) ZeusTransformUtils.preCheckCast(r3.next(), SpecialEffectsController.class, "com.obric.memorydata.plugin")).forcePostponedExecutePendingOperations();
        goto L4
    }

    private boolean generateOpsForPendingActions(ArrayList<BackStackRecord> r8, ArrayList<Boolean> r9) {
        ArrayList<OpGenerator> r0 = this.mPendingActions;
        monitor-enter(r0);
        int r2 = 0;
        if (this.mPendingActions.isEmpty() == false) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return false;
    L21:
        int r1 = this.mPendingActions.size();     // Catch: Throwable -> L15
        boolean r3 = false;
    L9:
        if (r2 >= r1) goto L12;
        r3 = r3 | ((OpGenerator) ZeusTransformUtils.preCheckCast(this.mPendingActions.get(r2), OpGenerator.class, "com.obric.memorydata.plugin")).generateOps(r8, r9);
        r2 = r2 + 1;
        goto L9
    L12:
        this.mPendingActions.clear();     // Catch: Throwable -> L18
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r3;
    L15:
        th = move-exception;
        this.mPendingActions.clear();     // Catch: Throwable -> L18
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private FragmentManagerViewModel getChildNonConfig(Fragment r1) {
        return this.mNonConfig.getChildNonConfig(r1);
    }

    private ViewGroup getFragmentContainer(Fragment r3) {
        if (r3.mContainer == null) goto L7;
        return r3.mContainer;
    L7:
        if (r3.mContainerId > 0) goto L10;
        return null;
    L10:
        if (this.mContainer.onHasView() == false) goto L15;
        View r2 = this.mContainer.onFindViewById(r3.mContainerId);
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L15;
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin");
    L15:
        return null;
    }

    static Fragment getViewFragment(View r3) {
        Object r4 = r3.getTag(ZeusTransformUtils.mapRes(R.id.fragment_container_view_tag, OaidModel.KEY_ID, "fragment_container_view_tag"));
        if (ZeusTransformUtils.instanceOf(r4, Fragment.class) == true) goto L5;
        return null;
    L5:
        return (Fragment) ZeusTransformUtils.preCheckCast(r4, Fragment.class, "com.obric.memorydata.plugin");
    }

    public static boolean isLoggingEnabled(int r1) {
        if (DEBUG == false) goto L5;
    L8:
        return true;
    L5:
        if (Log.isLoggable(TAG, r1) == true) goto L8;
        return false;
    }

    private boolean isMenuAvailable(Fragment r1) {
        if (r1.mHasMenu == false) goto L7;
        if (r1.mMenuVisible == false) goto L7;
    L8:
        return true;
    L7:
        if (r1.mChildFragmentManager.checkForMenus() == true) goto L8;
        return false;
    }

    private boolean popBackStackImmediate(String r9, int r10, int r11) {
        execPendingActions(false);
        ensureExecReady(true);
        Fragment r1 = this.mPrimaryNav;
        if (r1 == null) goto L9;
        if (r10 >= 0) goto L9;
        if (r9 != null) goto L9;
        if (r1.getChildFragmentManager().popBackStackImmediate() == false) goto L9;
        return true;
    L9:
        boolean r12 = popBackStackState(this.mTmpRecords, this.mTmpIsPop, r9, r10, r11);
        if (r12 == false) goto L17;
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
        return r12;
    }

    private void removeRedundantOperationsAndExecute(ArrayList<BackStackRecord> r7, ArrayList<Boolean> r8) {
        if (r7.isEmpty() == false) goto L6;
        return;
    L6:
        if (r7.size() != r8.size()) goto L27;
        int r0 = r7.size();
        int r1 = 0;
        int r2 = 0;
    L8:
        if (r1 >= r0) goto L23;
        if (((BackStackRecord) ZeusTransformUtils.preCheckCast(r7.get(r1), BackStackRecord.class, "com.obric.memorydata.plugin")).mReorderingAllowed == true) goto L22;
        if (r2 == r1) goto L13;
        executeOpsTogether(r7, r8, r2, r1);
    L13:
        r2 = r1 + 1;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.get(r1), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L21;
    L15:
        if (r2 >= r0) goto L21;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.get(r2), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L21;
        if (((BackStackRecord) ZeusTransformUtils.preCheckCast(r7.get(r2), BackStackRecord.class, "com.obric.memorydata.plugin")).mReorderingAllowed == true) goto L21;
        r2 = r2 + 1;
    L21:
        executeOpsTogether(r7, r8, r1, r2);
        r1 = r2 - 1;
    L22:
        r1 = r1 + 1;
        goto L8
    L23:
        if (r2 == r0) goto L34;
        executeOpsTogether(r7, r8, r2, r0);
        return;
    L34:
        return;
    L27:
        throw new IllegalStateException("Internal error with the back stack records");
    }

    private void reportBackStackChanged() {
        if (this.mBackStackChangeListeners == null) goto L8;
        int r0 = 0;
    L6:
        if (r0 >= this.mBackStackChangeListeners.size()) goto L10;
        ((OnBackStackChangedListener) ZeusTransformUtils.preCheckCast(this.mBackStackChangeListeners.get(r0), OnBackStackChangedListener.class, "com.obric.memorydata.plugin")).onBackStackChanged();
        r0 = r0 + 1;
        goto L6
    L10:
        return;
    }

    static int reverseTransit(int r5) {
        if (r5 == 4097) goto L13;
        if (r5 == 8194) goto L18;
        if (r5 == 8197) goto L14;
        if (r5 == 4099) goto L17;
        if (r5 == 4100) goto L16;
        return 0;
    L16:
        return FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE;
    L17:
        return FragmentTransaction.TRANSIT_FRAGMENT_FADE;
    L14:
        return FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN;
    L18:
        return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
    L13:
        return 8194;
    }

    private void setVisibleRemovingFragment(Fragment r4) {
        ViewGroup r3 = getFragmentContainer(r4);
        if (r3 != null) goto L5;
        return;
    L5:
        if ((((r4.getEnterAnim() + r4.getExitAnim()) + r4.getPopEnterAnim()) + r4.getPopExitAnim()) > 0) goto L7;
        return;
    L7:
        if (r3.getTag(ZeusTransformUtils.mapRes(R.id.visible_removing_fragment_view_tag, OaidModel.KEY_ID, "visible_removing_fragment_view_tag")) != null) goto L9;
        r3.setTag(ZeusTransformUtils.mapRes(R.id.visible_removing_fragment_view_tag, OaidModel.KEY_ID, "visible_removing_fragment_view_tag"), r4);
    L9:
        ((Fragment) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.visible_removing_fragment_view_tag, OaidModel.KEY_ID, "visible_removing_fragment_view_tag")), Fragment.class, "com.obric.memorydata.plugin")).setPopDirection(r4.getPopDirection());
    }

    private void startPendingDeferredFragments() {
        Iterator<FragmentStateManager> r0 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        performPendingDeferredStart((FragmentStateManager) ZeusTransformUtils.preCheckCast(r0.next(), FragmentStateManager.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    private void throwException(RuntimeException r8) {
        Log.e(TAG, r8.getMessage());
        Log.e(TAG, "Activity state:");
        PrintWriter r2 = new PrintWriter(new LogWriter(TAG));
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 == null) goto L5;
        r0.onDump("  ", null, r2, new String[0]);     // Catch: Exception -> L7
    L10:
        throw r8;
    L5:
        dump("  ", null, r2, new String[0]);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        Log.e(TAG, "Failed dumping state", e);
        throw r8;
    }

    private void updateOnBackPressedCallbackEnabled() {
        ArrayList<OpGenerator> r0 = this.mPendingActions;
        monitor-enter(r0);
        boolean r2 = true;
        if (this.mPendingActions.isEmpty() == true) goto L9;
        this.mOnBackPressedCallback.setEnabled(true);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L18
        OnBackPressedCallback r1 = this.mOnBackPressedCallback;
        if (getBackStackEntryCount() > 0) goto L13;
    L15:
        r2 = false;
    L16:
        r1.setEnabled(r2);
        return;
    L13:
        if (isPrimaryNavigation(this.mParent) == false) goto L15;
    L18:
        th = move-exception;
        throw th;
    }

    void addBackStackState(BackStackRecord r2) {
        if (this.mBackStack != null) goto L5;
        this.mBackStack = new ArrayList();
    L5:
        this.mBackStack.add(r2);
    }

    FragmentStateManager addFragment(Fragment r4) {
        if (r4.mPreviousWho == null) goto L6;
        FragmentStrictMode.onFragmentReuse(r4, r4.mPreviousWho);
    L6:
        if (isLoggingEnabled(2) == false) goto L8;
        Log.v(TAG, "add: " + r4);
    L8:
        FragmentStateManager r0 = createOrGetFragmentStateManager(r4);
        r4.mFragmentManager = this;
        this.mFragmentStore.makeActive(r0);
        if (r4.mDetached == true) goto L16;
        this.mFragmentStore.addFragment(r4);
        r4.mRemoving = false;
        if (r4.mView != null) goto L14;
        r4.mHiddenChanged = false;
    L14:
        if (isMenuAvailable(r4) == false) goto L16;
        this.mNeedMenuInvalidate = true;
    L16:
        return r0;
    }

    public void addFragmentOnAttachListener(FragmentOnAttachListener r3) {
        FragmentOnAttachListener r4 = (FragmentOnAttachListener) ZeusTransformUtils.wrapperContextForParams(r3, FragmentOnAttachListener.class, "com.obric.memorydata.plugin");
        this.mOnAttachListeners.add(r4);
    }

    public void addOnBackStackChangedListener(OnBackStackChangedListener r3) {
        OnBackStackChangedListener r4 = (OnBackStackChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, OnBackStackChangedListener.class, "com.obric.memorydata.plugin");
        if (this.mBackStackChangeListeners != null) goto L5;
        this.mBackStackChangeListeners = new ArrayList();
    L5:
        this.mBackStackChangeListeners.add(r4);
    }

    void addRetainedFragment(Fragment r1) {
        this.mNonConfig.addRetainedFragment(r1);
    }

    int allocBackStackIndex() {
        return this.mBackStackIndex.getAndIncrement();
    }

    void attachController(FragmentHostCallback<?> r5, FragmentContainer r6, final Fragment r7) {
        if (this.mHost != null) goto L58;
        this.mHost = r5;
        this.mContainer = r6;
        this.mParent = r7;
        if (r7 == null) goto L9;
        FragmentOnAttachListener r0 = new AnonymousClass7(this, r7);
    L7:
        addFragmentOnAttachListener(r0);
    L12:
        if (this.mParent == null) goto L15;
        updateOnBackPressedCallbackEnabled();
    L15:
        if (ZeusTransformUtils.instanceOf(r5, OnBackPressedDispatcherOwner.class) == false) goto L20;
        OnBackPressedDispatcherOwner r1 = (OnBackPressedDispatcherOwner) ZeusTransformUtils.preCheckCast(r5, OnBackPressedDispatcherOwner.class, "com.obric.memorydata.plugin");
        OnBackPressedDispatcher r2 = r1.getOnBackPressedDispatcher();
        this.mOnBackPressedDispatcher = r2;
        LifecycleOwner r3 = r1;
        if (r7 == null) goto L19;
        r3 = r7;
    L19:
        r2.addCallback(r3, this.mOnBackPressedCallback);
    L20:
        if (r7 == null) goto L24;
        FragmentManagerViewModel r8 = r7.mFragmentManager.getChildNonConfig(r7);
    L22:
        this.mNonConfig = r8;
        this.mNonConfig.setIsStateSaved(isStateSaved());
        this.mFragmentStore.setNonConfig(this.mNonConfig);
        if (ZeusTransformUtils.instanceOf(this.mHost, SavedStateRegistryOwner.class) == false) goto L34;
        if (r7 != null) goto L34;
        SavedStateRegistry r9 = ((SavedStateRegistryOwner) ZeusTransformUtils.preCheckCast(this.mHost, SavedStateRegistryOwner.class, "com.obric.memorydata.plugin")).getSavedStateRegistry();
        r9.registerSavedStateProvider(SAVED_STATE_TAG, new $$Lambda$FragmentManager$sido8p6zuWx0PQxIkv4qMBRiGM(this));
        Bundle r10 = r9.consumeRestoredStateForKey(SAVED_STATE_TAG);
        if (r10 == null) goto L34;
        restoreSaveStateInternal(r10);
    L34:
        if (ZeusTransformUtils.instanceOf(this.mHost, ActivityResultRegistryOwner.class) == false) goto L41;
        ActivityResultRegistry r11 = ((ActivityResultRegistryOwner) ZeusTransformUtils.preCheckCast(this.mHost, ActivityResultRegistryOwner.class, "com.obric.memorydata.plugin")).getActivityResultRegistry();
        if (r7 == null) goto L38;
        String r4 = r7.mWho + ParameterizedMessage.ERROR_MSG_SEPARATOR;
    L39:
        String r12 = "FragmentManager:" + r4;
        this.mStartActivityForResult = r11.register(r12 + "StartActivityForResult", new ActivityResultContracts.StartActivityForResult(), new AnonymousClass8(this));
        this.mStartIntentSenderForResult = r11.register(r12 + "StartIntentSenderForResult", new FragmentIntentSenderContract(), new AnonymousClass9(this));
        this.mRequestPermissions = r11.register(r12 + "RequestPermissions", new ActivityResultContracts.RequestMultiplePermissions(), new AnonymousClass10(this));
        goto L41
    L38:
        r4 = "";
    L41:
        if (ZeusTransformUtils.instanceOf(this.mHost, OnConfigurationChangedProvider.class) == false) goto L44;
        ((OnConfigurationChangedProvider) ZeusTransformUtils.preCheckCast(this.mHost, OnConfigurationChangedProvider.class, "com.obric.memorydata.plugin")).addOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
    L44:
        if (ZeusTransformUtils.instanceOf(this.mHost, OnTrimMemoryProvider.class) == false) goto L47;
        ((OnTrimMemoryProvider) ZeusTransformUtils.preCheckCast(this.mHost, OnTrimMemoryProvider.class, "com.obric.memorydata.plugin")).addOnTrimMemoryListener(this.mOnTrimMemoryListener);
    L47:
        if (ZeusTransformUtils.instanceOf(this.mHost, OnMultiWindowModeChangedProvider.class) == false) goto L50;
        ((OnMultiWindowModeChangedProvider) ZeusTransformUtils.preCheckCast(this.mHost, OnMultiWindowModeChangedProvider.class, "com.obric.memorydata.plugin")).addOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
    L50:
        if (ZeusTransformUtils.instanceOf(this.mHost, OnPictureInPictureModeChangedProvider.class) == false) goto L53;
        ((OnPictureInPictureModeChangedProvider) ZeusTransformUtils.preCheckCast(this.mHost, OnPictureInPictureModeChangedProvider.class, "com.obric.memorydata.plugin")).addOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
    L53:
        if (ZeusTransformUtils.instanceOf(this.mHost, MenuHost.class) == false) goto L59;
        if (r7 != null) goto L60;
        ((MenuHost) ZeusTransformUtils.preCheckCast(this.mHost, MenuHost.class, "com.obric.memorydata.plugin")).addMenuProvider(this.mMenuProvider);
        return;
    L60:
        return;
    L59:
        return;
    L24:
        if (ZeusTransformUtils.instanceOf(r5, ViewModelStoreOwner.class) == false) goto L26;
        r8 = FragmentManagerViewModel.getInstance(((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r5, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).getViewModelStore());
        goto L22
    L26:
        r8 = new FragmentManagerViewModel(false);
        goto L22
    L9:
        if (ZeusTransformUtils.instanceOf(r5, FragmentOnAttachListener.class) == false) goto L12;
        r0 = (FragmentOnAttachListener) ZeusTransformUtils.preCheckCast(r5, FragmentOnAttachListener.class, "com.obric.memorydata.plugin");
        goto L7
    L58:
        throw new IllegalStateException("Already attached");
    }

    void attachFragment(Fragment r5) {
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

    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    boolean checkForMenus() {
        Iterator<Fragment> r0 = this.mFragmentStore.getActiveFragments().iterator();
        boolean r2 = false;
    L4:
        if (r0.hasNext() == false) goto L11;
        Fragment r3 = (Fragment) ZeusTransformUtils.preCheckCast(r0.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L8;
        r2 = isMenuAvailable(r3);
    L8:
        if (r2 == false) goto L4;
        return true;
    L11:
        return false;
    }

    public void clearBackStack(String r2) {
        enqueueAction(new ClearBackStackState(this, r2), false);
    }

    boolean clearBackStackState(ArrayList<BackStackRecord> r7, ArrayList<Boolean> r8, String r9) {
        if (restoreBackStackState(r7, r8, r9) == true) goto L7;
        return false;
    L7:
        return popBackStackState(r7, r8, r9, -1, 1);
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResult(String r2) {
        this.mResults.remove(r2);
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "Clearing fragment result with key " + r2);
        return;
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResultListener(String r3) {
        LifecycleAwareResultListener r2 = (LifecycleAwareResultListener) ZeusTransformUtils.preCheckCast(this.mResultListeners.remove(r3), LifecycleAwareResultListener.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r2.removeObserver();
    L6:
        if (isLoggingEnabled(2) == false) goto L9;
        Log.v(TAG, "Clearing FragmentResultListener for key " + r3);
        return;
    }

    FragmentStateManager createOrGetFragmentStateManager(Fragment r4) {
        FragmentStateManager r0 = this.mFragmentStore.getFragmentStateManager(r4.mWho);
        if (r0 == null) goto L5;
        return r0;
    L5:
        FragmentStateManager r1 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r4);
        r1.restoreState(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mHost.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getClassLoader());
        r1.setFragmentManagerState(this.mCurState);
        return r1;
    }

    void detachFragment(Fragment r5) {
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

    void dispatchConfigurationChanged(Configuration r4) {
        Iterator<Fragment> r3 = this.mFragmentStore.getFragments().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r3.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L4;
        r0.performConfigurationChanged(r4);
        goto L4
    }

    boolean dispatchContextItemSelected(MenuItem r6) {
        MenuItem r7 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r6, MenuItem.class, "com.obric.memorydata.plugin");
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r5 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r5.hasNext() == false) goto L13;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r5.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        if (r0.performContextItemSelected(r7) == false) goto L7;
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

    boolean dispatchCreateOptionsMenu(Menu r9, MenuInflater r10) {
        Menu r11 = (Menu) ZeusTransformUtils.wrapperContextForParams(r9, Menu.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        ArrayList<Fragment> r0 = null;
        Iterator<Fragment> r4 = this.mFragmentStore.getFragments().iterator();
        boolean r5 = false;
    L7:
        if (r4.hasNext() == false) goto L18;
        Fragment r6 = (Fragment) ZeusTransformUtils.preCheckCast(r4.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L7;
        if (isParentMenuVisible(r6) == false) goto L7;
        if (r6.performCreateOptionsMenu(r11, r10) == false) goto L7;
        if (r0 != null) goto L16;
        r0 = new ArrayList();
    L16:
        r0.add(r6);
        r5 = true;
        goto L7
    L18:
        if (this.mCreatedMenus != null) goto L20;
    L27:
        this.mCreatedMenus = r0;
        return r5;
    L20:
        if (r2 >= this.mCreatedMenus.size()) goto L27;
        Fragment r12 = (Fragment) ZeusTransformUtils.preCheckCast(this.mCreatedMenus.get(r2), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L24;
    L25:
        r12.onDestroyOptionsMenu();
    L26:
        r2 = r2 + 1;
        goto L20
    L24:
        if (r0.contains(r12) == true) goto L26;
        goto L25
    }

    void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions(true);
        endAnimatingAwayFragments();
        clearBackStackStateViewModels();
        dispatchStateChange(-1);
        if (ZeusTransformUtils.instanceOf(this.mHost, OnTrimMemoryProvider.class) == false) goto L6;
        ((OnTrimMemoryProvider) ZeusTransformUtils.preCheckCast(this.mHost, OnTrimMemoryProvider.class, "com.obric.memorydata.plugin")).removeOnTrimMemoryListener(this.mOnTrimMemoryListener);
    L6:
        if (ZeusTransformUtils.instanceOf(this.mHost, OnConfigurationChangedProvider.class) == false) goto L9;
        ((OnConfigurationChangedProvider) ZeusTransformUtils.preCheckCast(this.mHost, OnConfigurationChangedProvider.class, "com.obric.memorydata.plugin")).removeOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
    L9:
        if (ZeusTransformUtils.instanceOf(this.mHost, OnMultiWindowModeChangedProvider.class) == false) goto L12;
        ((OnMultiWindowModeChangedProvider) ZeusTransformUtils.preCheckCast(this.mHost, OnMultiWindowModeChangedProvider.class, "com.obric.memorydata.plugin")).removeOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
    L12:
        if (ZeusTransformUtils.instanceOf(this.mHost, OnPictureInPictureModeChangedProvider.class) == false) goto L15;
        ((OnPictureInPictureModeChangedProvider) ZeusTransformUtils.preCheckCast(this.mHost, OnPictureInPictureModeChangedProvider.class, "com.obric.memorydata.plugin")).removeOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
    L15:
        if (ZeusTransformUtils.instanceOf(this.mHost, MenuHost.class) == false) goto L17;
        ((MenuHost) ZeusTransformUtils.preCheckCast(this.mHost, MenuHost.class, "com.obric.memorydata.plugin")).removeMenuProvider(this.mMenuProvider);
    L17:
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher == null) goto L20;
        this.mOnBackPressedCallback.remove();
        this.mOnBackPressedDispatcher = null;
    L20:
        ActivityResultLauncher<Intent> r0 = this.mStartActivityForResult;
        if (r0 == null) goto L24;
        r0.unregister();
        this.mStartIntentSenderForResult.unregister();
        this.mRequestPermissions.unregister();
        return;
    }

    void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    void dispatchLowMemory() {
        Iterator<Fragment> r3 = this.mFragmentStore.getFragments().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r3.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L4;
        r0.performLowMemory();
        goto L4
    }

    void dispatchMultiWindowModeChanged(boolean r4) {
        Iterator<Fragment> r3 = this.mFragmentStore.getFragments().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r3.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L4;
        r0.performMultiWindowModeChanged(r4);
        goto L4
    }

    void dispatchOnAttachFragment(Fragment r5) {
        Iterator<FragmentOnAttachListener> r0 = this.mOnAttachListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((FragmentOnAttachListener) ZeusTransformUtils.preCheckCast(r0.next(), FragmentOnAttachListener.class, "com.obric.memorydata.plugin")).onAttachFragment(this, r5);
        goto L4
    }

    void dispatchOnHiddenChanged() {
        Iterator<Fragment> r3 = this.mFragmentStore.getActiveFragments().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r3.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L4;
        r0.onHiddenChanged(r0.isHidden());
        r0.mChildFragmentManager.dispatchOnHiddenChanged();
        goto L4
    }

    boolean dispatchOptionsItemSelected(MenuItem r6) {
        MenuItem r7 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r6, MenuItem.class, "com.obric.memorydata.plugin");
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r5 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r5.hasNext() == false) goto L13;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r5.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        if (r0.performOptionsItemSelected(r7) == false) goto L7;
        return true;
    L13:
        return false;
    }

    void dispatchOptionsMenuClosed(Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
        if (this.mCurState >= 1) goto L5;
        return;
    L5:
        Iterator<Fragment> r3 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r3.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        r0.performOptionsMenuClosed(r5);
        goto L7
    }

    void dispatchPause() {
        dispatchStateChange(5);
    }

    void dispatchPictureInPictureModeChanged(boolean r4) {
        Iterator<Fragment> r3 = this.mFragmentStore.getFragments().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r3.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L4;
        r0.performPictureInPictureModeChanged(r4);
        goto L4
    }

    boolean dispatchPrepareOptionsMenu(Menu r7) {
        Menu r8 = (Menu) ZeusTransformUtils.wrapperContextForParams(r7, Menu.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r0 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        Fragment r4 = (Fragment) ZeusTransformUtils.preCheckCast(r0.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        if (isParentMenuVisible(r4) == false) goto L7;
        if (r4.performPrepareOptionsMenu(r8) == false) goto L7;
        r2 = true;
        goto L7
    L15:
        return r2;
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

    public void dump(String r6, FileDescriptor r7, PrintWriter r8, String[] r9) {
        String r0 = r6 + "    ";
        this.mFragmentStore.dump(r6, r7, r8, r9);
        ArrayList<Fragment> r10 = this.mCreatedMenus;
        int r11 = 0;
        if (r10 == null) goto L9;
        int r12 = r10.size();
        if (r12 <= 0) goto L9;
        r8.print(r6);
        r8.println("Fragments Created Menus:");
        int r1 = 0;
    L7:
        if (r1 >= r12) goto L9;
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(this.mCreatedMenus.get(r1), Fragment.class, "com.obric.memorydata.plugin");
        r8.print(r6);
        r8.print("  #");
        r8.print(r1);
        r8.print(": ");
        r8.println(r2.toString());
        r1 = r1 + 1;
    L9:
        ArrayList<BackStackRecord> r13 = this.mBackStack;
        if (r13 == null) goto L16;
        int r14 = r13.size();
        if (r14 <= 0) goto L16;
        r8.print(r6);
        r8.println("Back Stack:");
        int r3 = 0;
    L14:
        if (r3 >= r14) goto L16;
        BackStackRecord r4 = (BackStackRecord) ZeusTransformUtils.preCheckCast(this.mBackStack.get(r3), BackStackRecord.class, "com.obric.memorydata.plugin");
        r8.print(r6);
        r8.print("  #");
        r8.print(r3);
        r8.print(": ");
        r8.println(r4.toString());
        r4.dump(r0, r8);
        r3 = r3 + 1;
    L16:
        r8.print(r6);
        r8.println("Back Stack Index: " + this.mBackStackIndex.get());
        ArrayList<OpGenerator> r15 = this.mPendingActions;
        monitor-enter(r15);
        int r5 = this.mPendingActions.size();     // Catch: Throwable -> L31
        if (r5 <= 0) goto L23;
        r8.print(r6);     // Catch: Throwable -> L31
        r8.println("Pending Actions:");     // Catch: Throwable -> L31
    L21:
        if (r11 >= r5) goto L23;
        OpGenerator r16 = (OpGenerator) ZeusTransformUtils.preCheckCast(this.mPendingActions.get(r11), OpGenerator.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        r8.print(r6);     // Catch: Throwable -> L31
        r8.print("  #");     // Catch: Throwable -> L31
        r8.print(r11);     // Catch: Throwable -> L31
        r8.print(": ");     // Catch: Throwable -> L31
        r8.println(r16);     // Catch: Throwable -> L31
        r11 = r11 + 1;     // Catch: Throwable -> L31
    L23:
        monitor-exit(r15);     // Catch: Throwable -> L31
        r8.print(r6);
        r8.println("FragmentManager misc state:");
        r8.print(r6);
        r8.print("  mHost=");
        r8.println(this.mHost);
        r8.print(r6);
        r8.print("  mContainer=");
        r8.println(this.mContainer);
        if (this.mParent == null) goto L27;
        r8.print(r6);
        r8.print("  mParent=");
        r8.println(this.mParent);
    L27:
        r8.print(r6);
        r8.print("  mCurState=");
        r8.print(this.mCurState);
        r8.print(" mStateSaved=");
        r8.print(this.mStateSaved);
        r8.print(" mStopped=");
        r8.print(this.mStopped);
        r8.print(" mDestroyed=");
        r8.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate == false) goto L39;
        r8.print(r6);
        r8.print("  mNeedMenuInvalidate=");
        r8.println(this.mNeedMenuInvalidate);
        return;
    L39:
        return;
    L31:
        th = move-exception;
        throw th;
    }

    void enqueueAction(OpGenerator r3, boolean r4) {
        OpGenerator r5 = (OpGenerator) ZeusTransformUtils.wrapperContextForParams(r3, OpGenerator.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L5;
    L13:
        ArrayList<OpGenerator> r0 = this.mPendingActions;
        monitor-enter(r0);
    L25:
        th = move-exception;
        throw th;
    L16:
        if (this.mHost != null) goto L22;
        if (r4 == false) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L25
        return;
    L21:
        throw new IllegalStateException("Activity has been destroyed");     // Catch: Throwable -> L25
    L22:
        this.mPendingActions.add(r5);     // Catch: Throwable -> L25
        scheduleCommit();     // Catch: Throwable -> L25
        monitor-exit(r0);     // Catch: Throwable -> L25
        return;
    L5:
        if (this.mHost == null) goto L7;
        checkStateLoss();
        goto L13
    L7:
        if (this.mDestroyed == false) goto L11;
        throw new IllegalStateException("FragmentManager has been destroyed");
    L11:
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    }

    boolean execPendingActions(boolean r4) {
        ensureExecReady(r4);
        boolean r0 = false;
    L4:
        if (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop) == false) goto L11;
        this.mExecutingActions = true;
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);     // Catch: Throwable -> L8
        cleanupExec();
        r0 = true;
    L8:
        th = move-exception;
        cleanupExec();
        throw th;
    L11:
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return r0;
    }

    void execSingleAction(OpGenerator r3, boolean r4) {
        OpGenerator r5 = (OpGenerator) ZeusTransformUtils.wrapperContextForParams(r3, OpGenerator.class, "com.obric.memorydata.plugin");
        if (r4 == true) goto L5;
    L9:
        ensureExecReady(r4);
        if (r5.generateOps(this.mTmpRecords, this.mTmpIsPop) == false) goto L17;
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
        return;
    L5:
        if (this.mHost != null) goto L7;
        return;
    L7:
        if (this.mDestroyed == false) goto L9;
    }

    public boolean executePendingTransactions() {
        boolean r0 = execPendingActions(true);
        forcePostponedTransactions();
        return r0;
    }

    Fragment findActiveFragment(String r1) {
        return this.mFragmentStore.findActiveFragment(r1);
    }

    public Fragment findFragmentById(int r1) {
        return this.mFragmentStore.findFragmentById(r1);
    }

    public Fragment findFragmentByTag(String r1) {
        return this.mFragmentStore.findFragmentByTag(r1);
    }

    Fragment findFragmentByWho(String r1) {
        return this.mFragmentStore.findFragmentByWho(r1);
    }

    int getActiveFragmentCount() {
        return this.mFragmentStore.getActiveFragmentCount();
    }

    List<Fragment> getActiveFragments() {
        return this.mFragmentStore.getActiveFragments();
    }

    public BackStackEntry getBackStackEntryAt(int r2) {
        return (BackStackEntry) ZeusTransformUtils.preCheckCast(this.mBackStack.get(r2), BackStackEntry.class, "com.obric.memorydata.plugin");
    }

    public int getBackStackEntryCount() {
        ArrayList<BackStackRecord> r0 = this.mBackStack;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    FragmentContainer getContainer() {
        return this.mContainer;
    }

    public Fragment getFragment(Bundle r5, String r6) {
        String r7 = r5.getString(r6);
        if (r7 != null) goto L6;
        return null;
    L6:
        Fragment r0 = findActiveFragment(r7);
        if (r0 != null) goto L9;
        throwException(new IllegalStateException("Fragment no longer exists for key " + r6 + ": unique id " + r7));
    L9:
        return r0;
    }

    public FragmentFactory getFragmentFactory() {
        FragmentFactory r0 = this.mFragmentFactory;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Fragment r1 = this.mParent;
        if (r1 == null) goto L10;
        return r1.mFragmentManager.getFragmentFactory();
    L10:
        return this.mHostFragmentFactory;
    }

    FragmentStore getFragmentStore() {
        return this.mFragmentStore;
    }

    public List<Fragment> getFragments() {
        return this.mFragmentStore.getFragments();
    }

    public FragmentHostCallback<?> getHost() {
        return this.mHost;
    }

    LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this.mLayoutInflaterFactory;
    }

    FragmentLifecycleCallbacksDispatcher getLifecycleCallbacksDispatcher() {
        return this.mLifecycleCallbacksDispatcher;
    }

    Fragment getParent() {
        return this.mParent;
    }

    public Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    SpecialEffectsControllerFactory getSpecialEffectsControllerFactory() {
        SpecialEffectsControllerFactory r0 = this.mSpecialEffectsControllerFactory;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Fragment r1 = this.mParent;
        if (r1 == null) goto L10;
        return r1.mFragmentManager.getSpecialEffectsControllerFactory();
    L10:
        return this.mDefaultSpecialEffectsControllerFactory;
    }

    public FragmentStrictMode.Policy getStrictModePolicy() {
        return this.mStrictModePolicy;
    }

    ViewModelStore getViewModelStore(Fragment r1) {
        return this.mNonConfig.getViewModelStore(r1);
    }

    void handleOnBackPressed() {
        execPendingActions(true);
        if (this.mOnBackPressedCallback.isEnabled() == false) goto L5;
        popBackStackImmediate();
        return;
    L5:
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    void hideFragment(Fragment r3) {
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "hide: " + r3);
    L6:
        if (r3.mHidden == true) goto L9;
        r3.mHidden = true;
        r3.mHiddenChanged = true ^ r3.mHiddenChanged;
        setVisibleRemovingFragment(r3);
        return;
    }

    void invalidateMenuForFragment(Fragment r2) {
        if (r2.mAdded == true) goto L5;
        return;
    L5:
        if (isMenuAvailable(r2) == false) goto L9;
        this.mNeedMenuInvalidate = true;
        return;
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    boolean isParentHidden(Fragment r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.isHidden();
    }

    boolean isParentMenuVisible(Fragment r1) {
        if (r1 != null) goto L6;
        return true;
    L6:
        return r1.isMenuVisible();
    }

    boolean isPrimaryNavigation(Fragment r4) {
        if (r4 != null) goto L5;
        return true;
    L5:
        FragmentManager r1 = r4.mFragmentManager;
        if (r4.equals(r1.getPrimaryNavigationFragment()) == true) goto L8;
    L10:
        return false;
    L8:
        if (isPrimaryNavigation(r1.mParent) == false) goto L10;
        return true;
    }

    boolean isStateAtLeast(int r1) {
        if (this.mCurState < r1) goto L5;
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

    public /* synthetic */ Bundle lambda$attachController$4$FragmentManager() {
        return saveAllStateInternal();
    }

    public /* synthetic */ void lambda$new$0$FragmentManager(Configuration r1) {
        dispatchConfigurationChanged(r1);
    }

    public /* synthetic */ void lambda$new$1$FragmentManager(Integer r2) {
        if (r2.intValue() != 80) goto L6;
        dispatchLowMemory();
        return;
    }

    public /* synthetic */ void lambda$new$2$FragmentManager(MultiWindowModeChangedInfo r1) {
        dispatchMultiWindowModeChanged(r1.isInMultiWindowMode());
    }

    public /* synthetic */ void lambda$new$3$FragmentManager(PictureInPictureModeChangedInfo r1) {
        dispatchPictureInPictureModeChanged(r1.isInPictureInPictureMode());
    }

    void launchRequestPermissions(Fragment r2, String[] r3, int r4) {
        if (this.mRequestPermissions == null) goto L5;
        LaunchedFragmentInfo r0 = new LaunchedFragmentInfo(r2.mWho, r4);
        this.mLaunchedFragments.addLast(r0);
        this.mRequestPermissions.launch(r3);
        return;
    L5:
        this.mHost.onRequestPermissionsFromFragment(r2, r3, r4);
    }

    void launchStartActivityForResult(Fragment r2, Intent r3, int r4, Bundle r5) {
        if (this.mStartActivityForResult == null) goto L9;
        LaunchedFragmentInfo r0 = new LaunchedFragmentInfo(r2.mWho, r4);
        this.mLaunchedFragments.addLast(r0);
        if (r3 == null) goto L8;
        if (r5 == null) goto L8;
        r3.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r5);
    L8:
        this.mStartActivityForResult.launch(r3);
        return;
    L9:
        this.mHost.onStartActivityFromFragment(r2, r3, r4, r5);
    }

    void launchStartIntentSenderForResult(Fragment r11, IntentSender r12, int r13, Intent r14, int r15, int r16, int r17, Bundle r18) {
        if (this.mStartIntentSenderForResult != null) goto L5;
        this.mHost.onStartIntentSenderFromFragment(r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    L5:
        if (r18 == null) goto L13;
        if (r14 != null) goto L8;
        Intent r4 = new Intent();
        r4.putExtra(EXTRA_CREATED_FILLIN_INTENT, true);
    L10:
        if (isLoggingEnabled(2) == false) goto L12;
        Log.v(TAG, "ActivityOptions " + r18 + " were added to fillInIntent " + r4 + " for fragment " + r11);
    L12:
        r4.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r18);
    L14:
        IntentSenderRequest r5 = new IntentSenderRequest.Builder(r12).setFillInIntent(r4).setFlags(r16, r15).build();
        this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(r11.mWho, r13));
        if (isLoggingEnabled(2) == false) goto L17;
        Log.v(TAG, "Fragment " + r11 + "is launching an IntentSender for result ");
    L17:
        this.mStartIntentSenderForResult.launch(r5);
        return;
    L8:
        r4 = r14;
        goto L10
    L13:
        r4 = r14;
        goto L14
    }

    void moveToState(int r2, boolean r3) {
        if (this.mHost == null) goto L5;
    L9:
        if (r3 == false) goto L11;
    L13:
        this.mCurState = r2;
        this.mFragmentStore.moveToExpectedState();
        startPendingDeferredFragments();
        if (this.mNeedMenuInvalidate == false) goto L21;
        FragmentHostCallback<?> r4 = this.mHost;
        if (r4 != null) goto L18;
        return;
    L18:
        if (this.mCurState != 7) goto L23;
        r4.onSupportInvalidateOptionsMenu();
        this.mNeedMenuInvalidate = false;
        return;
    L23:
        return;
    L21:
        return;
    L11:
        if (r2 != this.mCurState) goto L13;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        throw new IllegalStateException("No activity");
    }

    void noteStateNotSaved() {
        if (this.mHost != null) goto L5;
        return;
    L5:
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        Iterator<Fragment> r3 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r3.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        r0.noteStateNotSaved();
        goto L7
    }

    void onContainerAvailable(FragmentContainerView r5) {
        Iterator<FragmentStateManager> r4 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        FragmentStateManager r0 = (FragmentStateManager) ZeusTransformUtils.preCheckCast(r4.next(), FragmentStateManager.class, "com.obric.memorydata.plugin");
        Fragment r1 = r0.getFragment();
        if (r1.mContainerId != r5.getId()) goto L4;
        if (r1.mView == null) goto L4;
        if (r1.mView.getParent() != null) goto L4;
        r1.mContainer = r5;
        r0.addViewToContainer();
        goto L4
    }

    @Deprecated
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    void performPendingDeferredStart(FragmentStateManager r3) {
        Fragment r0 = r3.getFragment();
        if (r0.mDeferStart == true) goto L5;
        return;
    L5:
        if (this.mExecutingActions == false) goto L8;
        this.mHavePendingDeferredStart = true;
        return;
    L8:
        r0.mDeferStart = false;
        r3.moveToExpectedState();
    }

    public void popBackStack() {
        enqueueAction(new PopBackStackState(this, null, -1, 0), false);
    }

    public void popBackStack(int r2, int r3) {
        popBackStack(r2, r3, false);
    }

    void popBackStack(int r3, int r4, boolean r5) {
        if (r3 < 0) goto L6;
        enqueueAction(new PopBackStackState(this, null, r3, r4), r5);
        return;
    L6:
        throw new IllegalArgumentException("Bad id: " + r3);
    }

    public void popBackStack(String r3, int r4) {
        enqueueAction(new PopBackStackState(this, r3, -1, r4), false);
    }

    public boolean popBackStackImmediate() {
        return popBackStackImmediate(null, -1, 0);
    }

    public boolean popBackStackImmediate(int r2, int r3) {
        if (r2 < 0) goto L6;
        return popBackStackImmediate(null, r2, r3);
    L6:
        throw new IllegalArgumentException("Bad id: " + r2);
    }

    public boolean popBackStackImmediate(String r2, int r3) {
        return popBackStackImmediate(r2, -1, r3);
    }

    boolean popBackStackState(ArrayList<BackStackRecord> r4, ArrayList<Boolean> r5, String r6, int r7, int r8) {
        if ((r8 & 1) == 0) goto L5;
        boolean r9 = true;
    L6:
        int r10 = findBackStackIndex(r6, r7, r9);
        if (r10 >= 0) goto L9;
        return false;
    L9:
        int r11 = this.mBackStack.size() - 1;
    L10:
        if (r11 < r10) goto L12;
        r4.add((BackStackRecord) ZeusTransformUtils.preCheckCast(this.mBackStack.remove(r11), BackStackRecord.class, "com.obric.memorydata.plugin"));
        r5.add(true);
        r11 = r11 - 1;
        goto L10
    L12:
        return true;
    L5:
        r9 = false;
        goto L6
    }

    public void putFragment(Bundle r4, String r5, Fragment r6) {
        if (r6.mFragmentManager == this) goto L5;
        throwException(new IllegalStateException("Fragment " + r6 + " is not currently in the FragmentManager"));
    L5:
        r4.putString(r5, r6.mWho);
    }

    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks r1, boolean r2) {
        this.mLifecycleCallbacksDispatcher.registerFragmentLifecycleCallbacks(r1, r2);
    }

    void removeFragment(Fragment r4) {
        if (isLoggingEnabled(2) == false) goto L5;
        Log.v(TAG, "remove: " + r4 + " nesting=" + r4.mBackStackNesting);
    L5:
        boolean r0 = !r4.isInBackStack();
        if (r4.mDetached == false) goto L8;
        if (r0 == true) goto L8;
        return;
    L8:
        this.mFragmentStore.removeFragment(r4);
        if (isMenuAvailable(r4) == false) goto L11;
        this.mNeedMenuInvalidate = true;
    L11:
        r4.mRemoving = true;
        setVisibleRemovingFragment(r4);
    }

    public void removeFragmentOnAttachListener(FragmentOnAttachListener r3) {
        FragmentOnAttachListener r4 = (FragmentOnAttachListener) ZeusTransformUtils.wrapperContextForParams(r3, FragmentOnAttachListener.class, "com.obric.memorydata.plugin");
        this.mOnAttachListeners.remove(r4);
    }

    public void removeOnBackStackChangedListener(OnBackStackChangedListener r3) {
        OnBackStackChangedListener r4 = (OnBackStackChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, OnBackStackChangedListener.class, "com.obric.memorydata.plugin");
        ArrayList<OnBackStackChangedListener> r2 = this.mBackStackChangeListeners;
        if (r2 == null) goto L6;
        r2.remove(r4);
        return;
    }

    void removeRetainedFragment(Fragment r1) {
        this.mNonConfig.removeRetainedFragment(r1);
    }

    void restoreAllState(Parcelable r3, FragmentManagerNonConfig r4) {
        Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(this.mHost, ViewModelStoreOwner.class) == false) goto L5;
        throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
    L5:
        this.mNonConfig.restoreFromSnapshot(r4);
        restoreSaveStateInternal(r5);
    }

    public void restoreBackStack(String r2) {
        enqueueAction(new RestoreBackStackState(this, r2), false);
    }

    boolean restoreBackStackState(ArrayList<BackStackRecord> r8, ArrayList<Boolean> r9, String r10) {
        BackStackState r11 = (BackStackState) ZeusTransformUtils.preCheckCast(this.mBackStackStates.remove(r10), BackStackState.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L5;
        return false;
    L5:
        HashMap r2 = new HashMap();
        Iterator<BackStackRecord> r3 = r8.iterator();
    L7:
        if (r3.hasNext() == false) goto L16;
        BackStackRecord r4 = (BackStackRecord) ZeusTransformUtils.preCheckCast(r3.next(), BackStackRecord.class, "com.obric.memorydata.plugin");
        if (r4.mBeingSaved == false) goto L7;
        Iterator<FragmentTransaction.Op> r5 = r4.mOps.iterator();
    L12:
        if (r5.hasNext() == false) goto L7;
        FragmentTransaction.Op r6 = (FragmentTransaction.Op) ZeusTransformUtils.preCheckCast(r5.next(), FragmentTransaction.Op.class, "com.obric.memorydata.plugin");
        if (r6.mFragment == null) goto L12;
        r2.put(r6.mFragment.mWho, r6.mFragment);
        goto L12
    L16:
        Iterator<BackStackRecord> r7 = r11.instantiate(this, r2).iterator();
    L17:
        boolean r12 = false;
    L19:
        if (r7.hasNext() == false) goto L24;
        if (((BackStackRecord) ZeusTransformUtils.preCheckCast(r7.next(), BackStackRecord.class, "com.obric.memorydata.plugin")).generateOps(r8, r9) == true) goto L23;
        if (r12 == false) goto L17;
    L23:
        r12 = true;
        goto L19
    L24:
        return r12;
    }

    void restoreSaveState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(this.mHost, SavedStateRegistryOwner.class) == false) goto L5;
        throwException(new IllegalStateException("You cannot use restoreSaveState when your FragmentHostCallback implements SavedStateRegistryOwner."));
    L5:
        restoreSaveStateInternal(r4);
    }

    void restoreSaveStateInternal(Parcelable r15) {
        Parcelable r16 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r15, Parcelable.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L5;
        return;
    L5:
        Bundle r17 = (Bundle) ZeusTransformUtils.preCheckCast(r16, Bundle.class, "com.obric.memorydata.plugin");
        Iterator<String> r0 = r17.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (r2.startsWith(RESULT_NAME_PREFIX) == false) goto L7;
        Bundle r3 = r17.getBundle(r2);
        if (r3 == null) goto L7;
        r3.setClassLoader(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mHost.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getClassLoader());
        this.mResults.put(r2.substring(7), r3);
        goto L7
    L13:
        ArrayList<FragmentState> r1 = new ArrayList();
        Iterator<String> r4 = r17.keySet().iterator();
    L15:
        if (r4.hasNext() == false) goto L21;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        if (r5.startsWith(FRAGMENT_NAME_PREFIX) == false) goto L15;
        Bundle r6 = r17.getBundle(r5);
        if (r6 == null) goto L15;
        r6.setClassLoader(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mHost.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getClassLoader());
        r1.add((FragmentState) ZeusTransformUtils.preCheckCast(r6.getParcelable("state"), FragmentState.class, "com.obric.memorydata.plugin"));
        goto L15
    L21:
        this.mFragmentStore.restoreSaveState(r1);
        FragmentManagerState r18 = (FragmentManagerState) ZeusTransformUtils.preCheckCast(r17.getParcelable("state"), FragmentManagerState.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L24;
        return;
    L24:
        this.mFragmentStore.resetActiveFragments();
        Iterator<String> r7 = r18.mActive.iterator();
    L26:
        if (r7.hasNext() == false) goto L40;
        FragmentState r13 = this.mFragmentStore.setSavedState((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"), null);
        if (r13 == null) goto L26;
        Fragment r8 = this.mNonConfig.findRetainedFragmentByWho(r13.mWho);
        if (r8 != null) goto L32;
        FragmentStateManager r9 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mHost.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getClassLoader(), getFragmentFactory(), r13);
    L36:
        Fragment r10 = r9.getFragment();
        r10.mFragmentManager = this;
        if (isLoggingEnabled(2) == false) goto L39;
        Log.v(TAG, "restoreSaveState: active (" + r10.mWho + "): " + r10);
    L39:
        r9.restoreState(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mHost.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getClassLoader());
        this.mFragmentStore.makeActive(r9);
        r9.setFragmentManagerState(this.mCurState);
        goto L26
    L32:
        if (isLoggingEnabled(2) == false) goto L34;
        Log.v(TAG, "restoreSaveState: re-attaching retained " + r8);
    L34:
        r9 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r8, r13);
        goto L36
    L40:
        Iterator<Fragment> r11 = this.mNonConfig.getRetainedFragments().iterator();
    L42:
        if (r11.hasNext() == false) goto L49;
        Fragment r12 = (Fragment) ZeusTransformUtils.preCheckCast(r11.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (this.mFragmentStore.containsActiveFragment(r12.mWho) == true) goto L42;
        if (isLoggingEnabled(2) == false) goto L48;
        Log.v(TAG, "Discarding retained Fragment " + r12 + " that was not found in the set of active Fragments " + r18.mActive);
    L48:
        this.mNonConfig.removeRetainedFragment(r12);
        r12.mFragmentManager = this;
        FragmentStateManager r14 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r12);
        r14.setFragmentManagerState(1);
        r14.moveToExpectedState();
        r12.mRemoving = true;
        r14.moveToExpectedState();
        goto L42
    L49:
        this.mFragmentStore.restoreAddedFragments(r18.mAdded);
        int r19 = 0;
        if (r18.mBackStack == null) goto L58;
        this.mBackStack = new ArrayList(r18.mBackStack.length);
        int r20 = 0;
    L53:
        if (r20 >= r18.mBackStack.length) goto L59;
        BackStackRecord r21 = r18.mBackStack[r20].instantiate(this);
        if (isLoggingEnabled(2) == false) goto L57;
        Log.v(TAG, "restoreAllState: back stack #" + r20 + " (index " + r21.mIndex + "): " + r21);
        PrintWriter r22 = new PrintWriter(new LogWriter(TAG));
        r21.dump("  ", r22, false);
        r22.close();
    L57:
        this.mBackStack.add(r21);
        r20 = r20 + 1;
    L59:
        this.mBackStackIndex.set(r18.mBackStackIndex);
        if (r18.mPrimaryNavActiveWho == null) goto L62;
        Fragment r23 = findActiveFragment(r18.mPrimaryNavActiveWho);
        this.mPrimaryNav = r23;
        dispatchParentPrimaryNavigationFragmentChanged(r23);
    L62:
        ArrayList<String> r24 = r18.mBackStackStateKeys;
        if (r24 != null) goto L65;
    L67:
        this.mLaunchedFragments = new ArrayDeque(r18.mLaunchedFragments);
        return;
    L65:
        if (r19 >= r24.size()) goto L67;
        this.mBackStackStates.put((String) ZeusTransformUtils.preCheckCast(r24.get(r19), String.class, "com.obric.memorydata.plugin"), (BackStackState) ZeusTransformUtils.preCheckCast(r18.mBackStackStates.get(r19), BackStackState.class, "com.obric.memorydata.plugin"));
        r19 = r19 + 1;
        goto L65
    L58:
        this.mBackStack = null;
        goto L59
    }

    @Deprecated
    FragmentManagerNonConfig retainNonConfig() {
        if (ZeusTransformUtils.instanceOf(this.mHost, ViewModelStoreOwner.class) == false) goto L6;
        throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
    L6:
        return this.mNonConfig.getSnapshot();
    }

    Parcelable saveAllState() {
        if (ZeusTransformUtils.instanceOf(this.mHost, SavedStateRegistryOwner.class) == false) goto L5;
        throwException(new IllegalStateException("You cannot use saveAllState when your FragmentHostCallback implements SavedStateRegistryOwner."));
    L5:
        Bundle r2 = saveAllStateInternal();
        if (r2.isEmpty() == false) goto L9;
        return null;
    L9:
        return r2;
    }

    Bundle saveAllStateInternal() {
        Bundle r0 = new Bundle();
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.setIsStateSaved(true);
        ArrayList<String> r1 = this.mFragmentStore.saveActiveFragments();
        ArrayList<FragmentState> r2 = this.mFragmentStore.getAllSavedState();
        if (r2.isEmpty() == true) goto L5;
        ArrayList<String> r3 = this.mFragmentStore.saveAddedFragments();
        BackStackRecordState[] r6 = null;
        ArrayList<BackStackRecord> r7 = this.mBackStack;
        if (r7 == null) goto L17;
        int r8 = r7.size();
        if (r8 <= 0) goto L17;
        r6 = new BackStackRecordState[r8];
        int r9 = 0;
    L12:
        if (r9 >= r8) goto L17;
        r6[r9] = new BackStackRecordState((BackStackRecord) ZeusTransformUtils.preCheckCast(this.mBackStack.get(r9), BackStackRecord.class, "com.obric.memorydata.plugin"));
        if (isLoggingEnabled(2) == false) goto L16;
        Log.v(TAG, "saveAllState: adding back stack #" + r9 + ": " + this.mBackStack.get(r9));
    L16:
        r9 = r9 + 1;
    L17:
        FragmentManagerState r4 = new FragmentManagerState();
        r4.mActive = r1;
        r4.mAdded = r3;
        r4.mBackStack = r6;
        r4.mBackStackIndex = this.mBackStackIndex.get();
        Fragment r5 = this.mPrimaryNav;
        if (r5 == null) goto L20;
        r4.mPrimaryNavActiveWho = r5.mWho;
    L20:
        r4.mBackStackStateKeys.addAll(this.mBackStackStates.keySet());
        r4.mBackStackStates.addAll(this.mBackStackStates.values());
        r4.mLaunchedFragments = new ArrayList(this.mLaunchedFragments);
        r0.putParcelable("state", r4);
        Iterator<String> r10 = this.mResults.keySet().iterator();
    L22:
        if (r10.hasNext() == false) goto L24;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        r0.putBundle(RESULT_NAME_PREFIX + r11, (Bundle) ZeusTransformUtils.preCheckCast(this.mResults.get(r11), Bundle.class, "com.obric.memorydata.plugin"));
        goto L22
    L24:
        Iterator<FragmentState> r13 = r2.iterator();
    L26:
        if (r13.hasNext() == false) goto L28;
        FragmentState r12 = (FragmentState) ZeusTransformUtils.preCheckCast(r13.next(), FragmentState.class, "com.obric.memorydata.plugin");
        Bundle r14 = new Bundle();
        r14.putParcelable("state", r12);
        r0.putBundle(FRAGMENT_NAME_PREFIX + r12.mWho, r14);
    L28:
        return r0;
    L5:
        if (isLoggingEnabled(2) == false) goto L28;
        Log.v(TAG, "saveAllState: no fragments!");
        goto L28
    }

    public void saveBackStack(String r2) {
        enqueueAction(new SaveBackStackState(this, r2), false);
    }

    boolean saveBackStackState(ArrayList<BackStackRecord> r17, ArrayList<Boolean> r18, String r19) {
        int r2 = findBackStackIndex(r19, -1, true);
        if (r2 >= 0) goto L6;
        return false;
    L6:
        int r4 = r2;
    L8:
        if (r4 >= this.mBackStack.size()) goto L13;
        BackStackRecord r5 = (BackStackRecord) ZeusTransformUtils.preCheckCast(this.mBackStack.get(r4), BackStackRecord.class, "com.obric.memorydata.plugin");
        if (r5.mReorderingAllowed == true) goto L12;
        throwException(new IllegalArgumentException("saveBackStack(\"" + r19 + "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found " + r5 + " that did not use setReorderingAllowed(true)."));
    L12:
        r4 = r4 + 1;
        goto L8
    L13:
        HashSet r6 = new HashSet();
        int r7 = r2;
    L15:
        if (r7 >= this.mBackStack.size()) goto L44;
        BackStackRecord r8 = (BackStackRecord) ZeusTransformUtils.preCheckCast(this.mBackStack.get(r7), BackStackRecord.class, "com.obric.memorydata.plugin");
        HashSet r9 = new HashSet();
        HashSet r10 = new HashSet();
        Iterator<FragmentTransaction.Op> r11 = r8.mOps.iterator();
    L18:
        if (r11.hasNext() == false) goto L36;
        FragmentTransaction.Op r12 = (FragmentTransaction.Op) ZeusTransformUtils.preCheckCast(r11.next(), FragmentTransaction.Op.class, "com.obric.memorydata.plugin");
        Fragment r13 = r12.mFragment;
        if (r13 == null) goto L18;
        if (r12.mFromExpandedOp == true) goto L25;
    L30:
        r6.add(r13);
        r9.add(r13);
    L32:
        if (r12.mCmd == 1) goto L35;
        if (r12.mCmd != 2) goto L18;
    L35:
        r10.add(r13);
        goto L18
    L25:
        if (r12.mCmd == 1) goto L30;
        if (r12.mCmd == 2) goto L30;
        if (r12.mCmd != 8) goto L32;
    L36:
        r9.removeAll(r10);
        if (r9.isEmpty() == true) goto L43;
        StringBuilder r14 = new StringBuilder().append("saveBackStack(\"").append(r19).append("\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
        if (r9.size() != 1) goto L41;
        StringBuilder r15 = new StringBuilder().append(" ");
        Object r16 = r9.iterator().next();
        StringBuilder r110 = r15;
    L42:
        throwException(new IllegalArgumentException(r14.append(r110.append(r16).toString()).append(" in ").append(r8).append(" that were previously added to the FragmentManager through a separate FragmentTransaction.").toString()));
        goto L43
    L41:
        r16 = r9;
        r110 = new StringBuilder().append("s ");
    L43:
        r7 = r7 + 1;
        goto L15
    L44:
        ArrayDeque r20 = new ArrayDeque(r6);
    L46:
        if (r20.isEmpty() == true) goto L60;
        Fragment r21 = (Fragment) ZeusTransformUtils.preCheckCast(r20.removeFirst(), Fragment.class, "com.obric.memorydata.plugin");
        if (r21.mRetainInstance == false) goto L54;
        StringBuilder r111 = new StringBuilder().append("saveBackStack(\"").append(r19).append("\") must not contain retained fragments. Found ");
        if (r6.contains(r21) == false) goto L52;
        String r112 = "direct reference to retained ";
    L53:
        throwException(new IllegalArgumentException(r111.append(r112).append("fragment ").append(r21).toString()));
        goto L54
    L52:
        r112 = "retained child ";
    L54:
        Iterator<Fragment> r22 = r21.mChildFragmentManager.getActiveFragments().iterator();
    L56:
        if (r22.hasNext() == false) goto L46;
        Fragment r23 = (Fragment) ZeusTransformUtils.preCheckCast(r22.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L56;
        r20.addLast(r23);
        goto L56
    L60:
        ArrayList r24 = new ArrayList();
        Iterator r25 = r6.iterator();
    L62:
        if (r25.hasNext() == false) goto L64;
        r24.add(((Fragment) ZeusTransformUtils.preCheckCast(r25.next(), Fragment.class, "com.obric.memorydata.plugin")).mWho);
        goto L62
    L64:
        ArrayList r26 = new ArrayList(this.mBackStack.size() - r2);
        int r27 = r2;
    L66:
        if (r27 >= this.mBackStack.size()) goto L68;
        r26.add(null);
        r27 = r27 + 1;
        goto L66
    L68:
        BackStackState r28 = new BackStackState(r24, r26);
        int r29 = this.mBackStack.size() - 1;
    L69:
        if (r29 < r2) goto L71;
        BackStackRecord r30 = (BackStackRecord) ZeusTransformUtils.preCheckCast(this.mBackStack.remove(r29), BackStackRecord.class, "com.obric.memorydata.plugin");
        BackStackRecord r31 = new BackStackRecord(r30);
        r31.collapseOps();
        r26.set(r29 - r2, new BackStackRecordState(r31));
        r30.mBeingSaved = true;
        r17.add(r30);
        r18.add(true);
        r29 = r29 - 1;
        goto L69
    L71:
        this.mBackStackStates.put(r19, r28);
        return true;
    }

    public Fragment.SavedState saveFragmentInstanceState(Fragment r5) {
        FragmentStateManager r0 = this.mFragmentStore.getFragmentStateManager(r5.mWho);
        if (r0 != null) goto L5;
    L6:
        throwException(new IllegalStateException("Fragment " + r5 + " is not currently in the FragmentManager"));
    L8:
        return r0.saveInstanceState();
    L5:
        if (r0.getFragment().equals(r5) == true) goto L8;
        goto L6
    }

    void scheduleCommit() {
        ArrayList<OpGenerator> r0 = this.mPendingActions;
        monitor-enter(r0);
        boolean r2 = true;
        if (this.mPendingActions.size() == 1) goto L8;
        r2 = false;
    L8:
        if (r2 == false) goto L10;
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L12
        this.mHost.getHandler().post(this.mExecCommit);     // Catch: Throwable -> L12
        updateOnBackPressedCallbackEnabled();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void setExitAnimationOrder(Fragment r2, boolean r3) {
        ViewGroup r1 = getFragmentContainer(r2);
        if (r1 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, FragmentContainerView.class) == false) goto L9;
        ((FragmentContainerView) ZeusTransformUtils.preCheckCast(r1, FragmentContainerView.class, "com.obric.memorydata.plugin")).setDrawDisappearingViewsLast(!r3);
        return;
    }

    public void setFragmentFactory(FragmentFactory r1) {
        this.mFragmentFactory = r1;
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void setFragmentResult(String r4, Bundle r5) {
        LifecycleAwareResultListener r0 = (LifecycleAwareResultListener) ZeusTransformUtils.preCheckCast(this.mResultListeners.get(r4), LifecycleAwareResultListener.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L7:
        this.mResults.put(r4, r5);
    L9:
        if (isLoggingEnabled(2) == false) goto L12;
        Log.v(TAG, "Setting fragment result with key " + r4 + " and result " + r5);
        return;
    L12:
        return;
    L5:
        if (r0.isAtLeast(Lifecycle.State.STARTED) == false) goto L7;
        r0.onFragmentResult(r4, r5);
        goto L9
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void setFragmentResultListener(final String r4, LifecycleOwner r5, FragmentResultListener r6) {
        LifecycleOwner r7 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r5, LifecycleOwner.class, "com.obric.memorydata.plugin");
        final FragmentResultListener r8 = (FragmentResultListener) ZeusTransformUtils.wrapperContextForParams(r6, FragmentResultListener.class, "com.obric.memorydata.plugin");
        final Lifecycle r9 = r7.getLifecycle();
        if (r9.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        LifecycleEventObserver r0 = new AnonymousClass6(this, r4, r8, r9);
        r9.addObserver(r0);
        LifecycleAwareResultListener r3 = (LifecycleAwareResultListener) ZeusTransformUtils.preCheckCast(this.mResultListeners.put(r4, new LifecycleAwareResultListener(r9, r8, r0)), LifecycleAwareResultListener.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.removeObserver();
    L9:
        if (isLoggingEnabled(2) == false) goto L12;
        Log.v(TAG, "Setting FragmentResultListener with key " + r4 + " lifecycleOwner " + r9 + " and listener " + r8);
        return;
    }

    void setMaxLifecycle(Fragment r3, Lifecycle.State r4) {
        if (r3.equals(findActiveFragment(r3.mWho)) == false) goto L11;
        if (r3.mHost != null) goto L7;
    L8:
        r3.mMaxState = r4;
        return;
    L7:
        if (r3.mFragmentManager == this) goto L8;
    L11:
        throw new IllegalArgumentException("Fragment " + r3 + " is not an active fragment of FragmentManager " + this);
    }

    void setPrimaryNavigationFragment(Fragment r4) {
        if (r4 != null) goto L4;
    L12:
        Fragment r0 = this.mPrimaryNav;
        this.mPrimaryNav = r4;
        dispatchParentPrimaryNavigationFragmentChanged(r0);
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
        return;
    L4:
        if (r4.equals(findActiveFragment(r4.mWho)) == false) goto L11;
        if (r4.mHost == null) goto L12;
        if (r4.mFragmentManager == this) goto L12;
    L11:
        throw new IllegalArgumentException("Fragment " + r4 + " is not an active fragment of FragmentManager " + this);
    }

    void setSpecialEffectsControllerFactory(SpecialEffectsControllerFactory r3) {
        this.mSpecialEffectsControllerFactory = (SpecialEffectsControllerFactory) ZeusTransformUtils.wrapperContextForParams(r3, SpecialEffectsControllerFactory.class, "com.obric.memorydata.plugin");
    }

    public void setStrictModePolicy(FragmentStrictMode.Policy r1) {
        this.mStrictModePolicy = r1;
    }

    void showFragment(Fragment r2) {
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "show: " + r2);
    L6:
        if (r2.mHidden == false) goto L9;
        r2.mHidden = false;
        r2.mHiddenChanged = !r2.mHiddenChanged;
        return;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append("FragmentManager{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        r0.append(" in ");
        Fragment r1 = this.mParent;
        if (r1 == null) goto L6;
        r0.append(r1.getClass().getSimpleName());
        r0.append("{");
        Object r4 = this.mParent;
    L5:
        r0.append(Integer.toHexString(System.identityHashCode(r4)));
        r0.append("}");
    L10:
        r0.append("}}");
        return r0.toString();
    L6:
        FragmentHostCallback<?> r2 = this.mHost;
        if (r2 == null) goto L9;
        r0.append(r2.getClass().getSimpleName());
        r0.append("{");
        r4 = this.mHost;
        goto L5
    L9:
        r0.append("null");
        goto L10
    }

    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks r1) {
        this.mLifecycleCallbacksDispatcher.unregisterFragmentLifecycleCallbacks(r1);
    }
}
