package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class FragmentStateManager {
    private static final String TAG = "FragmentManager";
    private static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    private static final String TARGET_STATE_TAG = "android:target_state";
    private static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    private static final String VIEW_REGISTRY_STATE_TAG = "android:view_registry_state";
    private static final String VIEW_STATE_TAG = "android:view_state";
    private final FragmentLifecycleCallbacksDispatcher mDispatcher;

    @NonNull
    private final Fragment mFragment;
    private int mFragmentManagerState;
    private final FragmentStore mFragmentStore;
    private boolean mMovingToState;

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentStateManager$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State = null;

        static {
            int[] r10 = new int[Lifecycle.State.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = r10;
            r10[Lifecycle.State.RESUMED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.CREATED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.INITIALIZED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher r10, @NonNull FragmentStore r11, @NonNull Fragment r12) {
        this.mMovingToState = false;
        this.mFragmentManagerState = -1;
        this.mDispatcher = r10;
        this.mFragmentStore = r11;
        this.mFragment = r12;
    }

    FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher r10, @NonNull FragmentStore r11, @NonNull Fragment r12, @NonNull FragmentState r13) {
        this.mMovingToState = false;
        this.mFragmentManagerState = -1;
        this.mDispatcher = r10;
        this.mFragmentStore = r11;
        this.mFragment = r12;
        r12.mSavedViewState = null;
        r12.mSavedViewRegistryState = null;
        r12.mBackStackNesting = 0;
        r12.mInLayout = false;
        r12.mAdded = false;
        Fragment r14 = r12.mTarget;
        if (r14 == null) goto L5;
        String r15 = r14.mWho;
    L6:
        r12.mTargetWho = r15;
        r12.mTarget = null;
        Bundle r16 = r13.mSavedFragmentState;
        if (r16 != null) goto L10;
        r16 = new Bundle();
    L10:
        r12.mSavedFragmentState = r16;
        return;
    L5:
        r15 = null;
        goto L6
    }

    FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher r10, @NonNull FragmentStore r11, @NonNull ClassLoader r12, @NonNull FragmentFactory r13, @NonNull FragmentState r14) {
        this.mMovingToState = false;
        this.mFragmentManagerState = -1;
        this.mDispatcher = r10;
        this.mFragmentStore = r11;
        Fragment r15 = r13.instantiate(r12, r14.mClassName);
        this.mFragment = r15;
        Bundle r16 = r14.mArguments;
        if (r16 == null) goto L5;
        r16.setClassLoader(r12);
    L5:
        r15.setArguments(r14.mArguments);
        r15.mWho = r14.mWho;
        r15.mFromLayout = r14.mFromLayout;
        r15.mRestored = true;
        r15.mFragmentId = r14.mFragmentId;
        r15.mContainerId = r14.mContainerId;
        r15.mTag = r14.mTag;
        r15.mRetainInstance = r14.mRetainInstance;
        r15.mRemoving = r14.mRemoving;
        r15.mDetached = r14.mDetached;
        r15.mHidden = r14.mHidden;
        r15.mMaxState = Lifecycle.State.values()[r14.mMaxLifecycleState];
        Bundle r17 = r14.mSavedFragmentState;
        if (r17 != null) goto L9;
        r17 = new Bundle();
    L9:
        r15.mSavedFragmentState = r17;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L13;
        Log.v(TAG, "Instantiated fragment " + r15);
        return;
    }

    private boolean isFragmentViewChild(@NonNull View r10) {
        if (r10 != this.mFragment.mView) goto L5;
        return true;
    L5:
        ViewParent r11 = r10.getParent();
    L6:
        if (r11 == null) goto L11;
        if (r11 == this.mFragment.mView) goto L9;
        r11 = r11.getParent();
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    private Bundle saveBasicState() {
        Bundle r10 = new Bundle();
        this.mFragment.performSaveInstanceState(r10);
        this.mDispatcher.dispatchOnFragmentSaveInstanceState(this.mFragment, r10, false);
        if (r10.isEmpty() == false) goto L6;
        r10 = null;
    L6:
        if (this.mFragment.mView == null) goto L9;
        saveViewState();
    L9:
        if (this.mFragment.mSavedViewState == null) goto L14;
        if (r10 != null) goto L12;
        r10 = new Bundle();
    L12:
        r10.putSparseParcelableArray(VIEW_STATE_TAG, this.mFragment.mSavedViewState);
    L14:
        if (this.mFragment.mSavedViewRegistryState == null) goto L19;
        if (r10 != null) goto L17;
        r10 = new Bundle();
    L17:
        r10.putBundle(VIEW_REGISTRY_STATE_TAG, this.mFragment.mSavedViewRegistryState);
    L19:
        if (this.mFragment.mUserVisibleHint == true) goto L23;
        if (r10 != null) goto L22;
        r10 = new Bundle();
    L22:
        r10.putBoolean(USER_VISIBLE_HINT_TAG, this.mFragment.mUserVisibleHint);
    L23:
        return r10;
    }

    void activityCreated() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "moveto ACTIVITY_CREATED: " + this.mFragment);
    L5:
        Fragment r10 = this.mFragment;
        r10.performActivityCreated(r10.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher r11 = this.mDispatcher;
        Fragment r12 = this.mFragment;
        r11.dispatchOnFragmentActivityCreated(r12, r12.mSavedFragmentState, false);
    }

    void addViewToContainer() {
        int r10 = this.mFragmentStore.findFragmentIndexInContainer(this.mFragment);
        Fragment r11 = this.mFragment;
        r11.mContainer.addView(r11.mView, r10);
    }

    void attach() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "moveto ATTACHED: " + this.mFragment);
    L5:
        Fragment r10 = this.mFragment;
        Fragment r11 = r10.mTarget;
        FragmentStateManager r12 = null;
        if (r11 == null) goto L12;
        FragmentStateManager r13 = this.mFragmentStore.getFragmentStateManager(r11.mWho);
        if (r13 == null) goto L11;
        Fragment r14 = this.mFragment;
        r14.mTargetWho = r14.mTarget.mWho;
        r14.mTarget = null;
        r12 = r13;
    L19:
        if (r12 != null) goto L21;
    L25:
        Fragment r15 = this.mFragment;
        r15.mHost = r15.mFragmentManager.getHost();
        Fragment r16 = this.mFragment;
        r16.mParentFragment = r16.mFragmentManager.getParent();
        this.mDispatcher.dispatchOnFragmentPreAttached(this.mFragment, false);
        this.mFragment.performAttach();
        this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, false);
        return;
    L21:
        if (FragmentManager.USE_STATE_MANAGER == false) goto L23;
    L24:
        r12.moveToExpectedState();
        goto L25
    L23:
        if (r12.getFragment().mState >= 1) goto L25;
    L11:
        throw new IllegalStateException("Fragment " + this.mFragment + " declared target fragment " + this.mFragment.mTarget + " that does not belong to this FragmentManager!");
    L12:
        String r17 = r10.mTargetWho;
        if (r17 == null) goto L19;
        r12 = this.mFragmentStore.getFragmentStateManager(r17);
        if (r12 != null) goto L19;
        throw new IllegalStateException("Fragment " + this.mFragment + " declared target fragment " + this.mFragment.mTargetWho + " that does not belong to this FragmentManager!");
    }

    int computeExpectedState() {
        Fragment r10 = this.mFragment;
        if (r10.mFragmentManager == null) goto L5;
        int r11 = this.mFragmentManagerState;
        int r12 = AnonymousClass2.$SwitchMap$androidx$lifecycle$Lifecycle$State[r10.mMaxState.ordinal()];
        if (r12 == 1) goto L15;
        if (r12 == 2) goto L14;
        if (r12 == 3) goto L13;
        if (r12 == 4) goto L12;
        r11 = Math.min(r11, -1);
        goto L15
    L12:
        r11 = Math.min(r11, 0);
        goto L15
    L13:
        r11 = Math.min(r11, 1);
        goto L15
    L14:
        r11 = Math.min(r11, 5);
    L15:
        Fragment r13 = this.mFragment;
        if (r13.mFromLayout == false) goto L29;
        if (r13.mInLayout == false) goto L25;
        r11 = Math.max(this.mFragmentManagerState, 2);
        View r14 = this.mFragment.mView;
        if (r14 == null) goto L29;
        if (r14.getParent() != null) goto L29;
        r11 = Math.min(r11, 2);
        goto L29
    L25:
        if (this.mFragmentManagerState >= 4) goto L27;
        r11 = Math.min(r11, r13.mState);
        goto L29
    L27:
        r11 = Math.min(r11, 1);
    L29:
        if (this.mFragment.mAdded == true) goto L31;
        r11 = Math.min(r11, 1);
    L31:
        SpecialEffectsController.Operation.LifecycleImpact r15 = null;
        if (FragmentManager.USE_STATE_MANAGER == false) goto L37;
        Fragment r16 = this.mFragment;
        ViewGroup r17 = r16.mContainer;
        if (r17 == null) goto L37;
        r15 = SpecialEffectsController.getOrCreateController(r17, r16.getParentFragmentManager()).getAwaitingCompletionLifecycleImpact(this);
    L37:
        if (r15 != SpecialEffectsController.Operation.LifecycleImpact.ADDING) goto L40;
        r11 = Math.min(r11, 6);
    L48:
        Fragment r18 = this.mFragment;
        if (r18.mDeferStart == false) goto L54;
        if (r18.mState >= 5) goto L54;
        r11 = Math.min(r11, 4);
    L54:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L56;
        Log.v(TAG, "computeExpectedState() of " + r11 + " for " + this.mFragment);
    L56:
        return r11;
    L40:
        if (r15 != SpecialEffectsController.Operation.LifecycleImpact.REMOVING) goto L42;
        r11 = Math.max(r11, 3);
        goto L48
    L42:
        Fragment r19 = this.mFragment;
        if (r19.mRemoving == false) goto L48;
        if (r19.isInBackStack() == false) goto L47;
        r11 = Math.min(r11, 1);
        goto L48
    L47:
        r11 = Math.min(r11, -1);
        goto L48
    L5:
        return r10.mState;
    }

    void create() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "moveto CREATED: " + this.mFragment);
    L5:
        Fragment r10 = this.mFragment;
        if (r10.mIsCreated == true) goto L8;
        this.mDispatcher.dispatchOnFragmentPreCreated(r10, r10.mSavedFragmentState, false);
        Fragment r11 = this.mFragment;
        r11.performCreate(r11.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher r12 = this.mDispatcher;
        Fragment r13 = this.mFragment;
        r12.dispatchOnFragmentCreated(r13, r13.mSavedFragmentState, false);
        return;
    L8:
        r10.restoreChildFragmentState(r10.mSavedFragmentState);
        this.mFragment.mState = 1;
    }

    void createView() {
        if (this.mFragment.mFromLayout == false) goto L6;
        return;
    L6:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L8;
        Log.d(TAG, "moveto CREATE_VIEW: " + this.mFragment);
    L8:
        Fragment r10 = this.mFragment;
        LayoutInflater r11 = r10.performGetLayoutInflater(r10.mSavedFragmentState);
        ViewGroup r12 = null;
        Fragment r13 = this.mFragment;
        ViewGroup r14 = r13.mContainer;
        if (r14 == null) goto L11;
        r12 = r14;
    L27:
        Fragment r15 = this.mFragment;
        r15.mContainer = r12;
        r15.performCreateView(r11, r12, r15.mSavedFragmentState);
        View r16 = this.mFragment.mView;
        if (r16 == null) goto L56;
        boolean r17 = false;
        r16.setSaveFromParentEnabled(false);
        Fragment r18 = this.mFragment;
        r18.mView.setTag(R.id.fragment_container_view_tag, r18);
        if (r12 == null) goto L32;
        addViewToContainer();
    L32:
        Fragment r19 = this.mFragment;
        if (r19.mHidden == false) goto L36;
        r19.mView.setVisibility(8);
    L36:
        if (ViewCompat.isAttachedToWindow(this.mFragment.mView) == false) goto L38;
        ViewCompat.requestApplyInsets(this.mFragment.mView);
    L39:
        this.mFragment.performViewCreated();
        FragmentLifecycleCallbacksDispatcher r20 = this.mDispatcher;
        Fragment r21 = this.mFragment;
        r20.dispatchOnFragmentViewCreated(r21, r21.mView, r21.mSavedFragmentState, false);
        int r22 = this.mFragment.mView.getVisibility();
        float r23 = this.mFragment.mView.getAlpha();
        if (FragmentManager.USE_STATE_MANAGER == false) goto L50;
        this.mFragment.setPostOnViewCreatedAlpha(r23);
        Fragment r24 = this.mFragment;
        if (r24.mContainer == null) goto L56;
        if (r22 != 0) goto L56;
        View r25 = r24.mView.findFocus();
        if (r25 == null) goto L49;
        this.mFragment.setFocusedView(r25);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L49;
        Log.v(TAG, "requestFocus: Saved focused view " + r25 + " for Fragment " + this.mFragment);
    L49:
        this.mFragment.mView.setAlpha(0.0f);
        goto L56
    L50:
        Fragment r26 = this.mFragment;
        if (r22 == 0) goto L53;
    L55:
        r26.mIsNewlyAdded = r17;
        goto L56
    L53:
        if (r26.mContainer == null) goto L55;
        r17 = true;
        goto L55
    L38:
        final View r27 = this.mFragment.mView;
        r27.addOnAttachStateChangeListener(new AnonymousClass1(this, r27));
    L56:
        this.mFragment.mState = 2;
        return;
    L11:
        int r28 = r13.mContainerId;
        if (r28 == 0) goto L27;
        if (r28 == (-1)) goto L26;
        r12 = (ViewGroup) r13.mFragmentManager.getContainer().onFindViewById(this.mFragment.mContainerId);
        if (r12 != null) goto L27;
        Fragment r29 = this.mFragment;
        if (r29.mRestored == true) goto L27;
        String r30 = r29.getResources().getResourceName(this.mFragment.mContainerId);     // Catch: Resources.NotFoundException -> L22
    L24:
        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.mFragment.mContainerId) + " (" + r30 + ") for fragment " + this.mFragment);
    L22:
        r30 = "unknown";
        goto L24
    L26:
        throw new IllegalArgumentException("Cannot create fragment " + this.mFragment + " for a container view with no id");
    }

    void destroy() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "movefrom CREATED: " + this.mFragment);
    L5:
        Fragment r10 = this.mFragment;
        boolean r11 = true;
        if (r10.mRemoving == true) goto L8;
    L10:
        boolean r12 = false;
    L11:
        if (r12 == false) goto L13;
    L16:
        boolean r13 = true;
    L17:
        if (r13 == false) goto L39;
        FragmentHostCallback<?> r14 = this.mFragment.mHost;
        if ((r14 instanceof ViewModelStoreOwner) == false) goto L22;
        r11 = this.mFragmentStore.getNonConfig().isCleared();
    L24:
        if (r12 == true) goto L26;
        if (r11 == true) goto L26;
    L27:
        this.mFragment.performDestroy();
        this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
        Iterator<FragmentStateManager> r15 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L29:
        if (r15.hasNext() == false) goto L35;
        FragmentStateManager r16 = r15.next();
        if (r16 == null) goto L29;
        Fragment r17 = r16.getFragment();
        if (this.mFragment.mWho.equals(r17.mTargetWho) == false) goto L29;
        r17.mTarget = this.mFragment;
        r17.mTargetWho = null;
        goto L29
    L35:
        Fragment r18 = this.mFragment;
        String r19 = r18.mTargetWho;
        if (r19 == null) goto L38;
        r18.mTarget = this.mFragmentStore.findActiveFragment(r19);
    L38:
        this.mFragmentStore.makeInactive(this);
        return;
    L26:
        this.mFragmentStore.getNonConfig().clearNonConfigState(this.mFragment);
        goto L27
    L22:
        if ((r14.getContext() instanceof Activity) == false) goto L24;
        r11 = true ^ ((Activity) r14.getContext()).isChangingConfigurations();
        goto L24
    L39:
        String r20 = this.mFragment.mTargetWho;
        if (r20 == null) goto L46;
        Fragment r21 = this.mFragmentStore.findActiveFragment(r20);
        if (r21 == null) goto L46;
        if (r21.mRetainInstance == false) goto L46;
        this.mFragment.mTarget = r21;
    L46:
        this.mFragment.mState = 0;
        return;
    L13:
        if (this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment) == true) goto L16;
        r13 = false;
        goto L17
    L8:
        if (r10.isInBackStack() == true) goto L10;
        r12 = true;
        goto L11
    }

    void destroyFragmentView() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "movefrom CREATE_VIEW: " + this.mFragment);
    L5:
        Fragment r10 = this.mFragment;
        ViewGroup r11 = r10.mContainer;
        if (r11 == null) goto L10;
        View r12 = r10.mView;
        if (r12 == null) goto L10;
        r11.removeView(r12);
    L10:
        this.mFragment.performDestroyView();
        this.mDispatcher.dispatchOnFragmentViewDestroyed(this.mFragment, false);
        Fragment r13 = this.mFragment;
        r13.mContainer = null;
        r13.mView = null;
        r13.mViewLifecycleOwner = null;
        r13.mViewLifecycleOwnerLiveData.setValue(null);
        this.mFragment.mInLayout = false;
    }

    void detach() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "movefrom ATTACHED: " + this.mFragment);
    L5:
        this.mFragment.performDetach();
        boolean r10 = false;
        this.mDispatcher.dispatchOnFragmentDetached(this.mFragment, false);
        Fragment r11 = this.mFragment;
        r11.mState = -1;
        r11.mHost = null;
        r11.mParentFragment = null;
        r11.mFragmentManager = null;
        if (r11.mRemoving == true) goto L8;
    L10:
        if (r10 == true) goto L14;
        if (this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment) == true) goto L14;
        return;
    L14:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L16;
        Log.d(TAG, "initState called for fragment: " + this.mFragment);
    L16:
        this.mFragment.initState();
        return;
    L8:
        if (r11.isInBackStack() == true) goto L10;
        r10 = true;
        goto L10
    }

    void ensureInflatedView() {
        Fragment r10 = this.mFragment;
        if (r10.mFromLayout == true) goto L5;
        return;
    L5:
        if (r10.mInLayout == true) goto L7;
        return;
    L7:
        if (r10.mPerformedCreateView == false) goto L9;
        return;
    L9:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L11;
        Log.d(TAG, "moveto CREATE_VIEW: " + this.mFragment);
    L11:
        Fragment r11 = this.mFragment;
        r11.performCreateView(r11.performGetLayoutInflater(r11.mSavedFragmentState), null, this.mFragment.mSavedFragmentState);
        View r12 = this.mFragment.mView;
        if (r12 == null) goto L21;
        r12.setSaveFromParentEnabled(false);
        Fragment r13 = this.mFragment;
        r13.mView.setTag(R.id.fragment_container_view_tag, r13);
        Fragment r14 = this.mFragment;
        if (r14.mHidden == false) goto L16;
        r14.mView.setVisibility(8);
    L16:
        this.mFragment.performViewCreated();
        FragmentLifecycleCallbacksDispatcher r15 = this.mDispatcher;
        Fragment r16 = this.mFragment;
        r15.dispatchOnFragmentViewCreated(r16, r16.mView, r16.mSavedFragmentState, false);
        this.mFragment.mState = 2;
        return;
    }

    @NonNull
    Fragment getFragment() {
        return this.mFragment;
    }

    void moveToExpectedState() {
        if (this.mMovingToState == false) goto L74;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L116;
        Log.v(TAG, "Ignoring re-entrant call to moveToExpectedState() for " + getFragment());
        return;
    L116:
        return;
    L74:
        this.mMovingToState = true;     // Catch: Throwable -> L71
    L10:
        int r10 = computeExpectedState();     // Catch: Throwable -> L71
        Fragment r11 = this.mFragment;     // Catch: Throwable -> L71
        int r12 = r11.mState;     // Catch: Throwable -> L71
        if (r10 == r12) goto L54;
        if (r10 > r12) goto L14;
        switch((r12 - 1)) {
            case -1: goto L52;
            case 0: goto L51;
            case 1: goto L50;
            case 2: goto L49;
            case 3: goto L36;
            case 4: goto L34;
            case 5: goto L33;
            case 6: goto L32;
            default: goto L10;
        };     // Catch: Throwable -> L71
    L32:
        pause();     // Catch: Throwable -> L71
        goto L10
    L33:
        r11.mState = 5;     // Catch: Throwable -> L71
        goto L10
    L34:
        stop();     // Catch: Throwable -> L71
        goto L10
    L36:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L38;
        Log.d(TAG, "movefrom ACTIVITY_CREATED: " + this.mFragment);     // Catch: Throwable -> L71
    L38:
        Fragment r13 = this.mFragment;     // Catch: Throwable -> L71
        if (r13.mView != null) goto L41;
    L43:
        Fragment r14 = this.mFragment;     // Catch: Throwable -> L71
        if (r14.mView == null) goto L48;
        ViewGroup r15 = r14.mContainer;     // Catch: Throwable -> L71
        if (r15 == null) goto L48;
        SpecialEffectsController.getOrCreateController(r15, r14.getParentFragmentManager()).enqueueRemove(this);     // Catch: Throwable -> L71
    L48:
        this.mFragment.mState = 3;     // Catch: Throwable -> L71
        goto L10
    L41:
        if (r13.mSavedViewState != null) goto L43;
        saveViewState();     // Catch: Throwable -> L71
        goto L43
    L49:
        r11.mInLayout = false;     // Catch: Throwable -> L71
        r11.mState = 2;     // Catch: Throwable -> L71
        goto L10
    L50:
        destroyFragmentView();     // Catch: Throwable -> L71
        this.mFragment.mState = 1;     // Catch: Throwable -> L71
        goto L10
    L51:
        destroy();     // Catch: Throwable -> L71
        goto L10
    L52:
        detach();     // Catch: Throwable -> L71
        goto L10
    L14:
        switch((r12 + 1)) {
            case 0: goto L28;
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            default: goto L10;
        };     // Catch: Throwable -> L71
    L16:
        resume();     // Catch: Throwable -> L71
        goto L10
    L17:
        r11.mState = 6;     // Catch: Throwable -> L71
        goto L10
    L18:
        start();     // Catch: Throwable -> L71
        goto L10
    L20:
        if (r11.mView == null) goto L24;
        ViewGroup r16 = r11.mContainer;     // Catch: Throwable -> L71
        if (r16 == null) goto L24;
        SpecialEffectsController.getOrCreateController(r16, r11.getParentFragmentManager()).enqueueAdd(SpecialEffectsController.Operation.State.from(this.mFragment.mView.getVisibility()), this);     // Catch: Throwable -> L71
    L24:
        this.mFragment.mState = 4;     // Catch: Throwable -> L71
        goto L10
    L25:
        activityCreated();     // Catch: Throwable -> L71
        goto L10
    L26:
        ensureInflatedView();     // Catch: Throwable -> L71
        createView();     // Catch: Throwable -> L71
        goto L10
    L27:
        create();     // Catch: Throwable -> L71
        goto L10
    L28:
        attach();     // Catch: Throwable -> L71
        goto L10
    L54:
        if (FragmentManager.USE_STATE_MANAGER == true) goto L56;
    L69:
        this.mMovingToState = false;
        return;
    L56:
        if (r11.mHiddenChanged == false) goto L69;
        if (r11.mView == null) goto L65;
        ViewGroup r17 = r11.mContainer;     // Catch: Throwable -> L71
        if (r17 == null) goto L65;
        SpecialEffectsController r18 = SpecialEffectsController.getOrCreateController(r17, r11.getParentFragmentManager());     // Catch: Throwable -> L71
        if (this.mFragment.mHidden == false) goto L64;
        r18.enqueueHide(this);     // Catch: Throwable -> L71
        goto L65
    L64:
        r18.enqueueShow(this);     // Catch: Throwable -> L71
    L65:
        Fragment r19 = this.mFragment;     // Catch: Throwable -> L71
        FragmentManager r20 = r19.mFragmentManager;     // Catch: Throwable -> L71
        if (r20 == null) goto L68;
        r20.invalidateMenuForFragment(r19);     // Catch: Throwable -> L71
    L68:
        Fragment r21 = this.mFragment;     // Catch: Throwable -> L71
        r21.mHiddenChanged = false;     // Catch: Throwable -> L71
        r21.onHiddenChanged(r21.mHidden);     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        this.mMovingToState = false;
        throw th;
    }

    void pause() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "movefrom RESUMED: " + this.mFragment);
    L5:
        this.mFragment.performPause();
        this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
    }

    void restoreState(@NonNull ClassLoader r10) {
        Bundle r11 = this.mFragment.mSavedFragmentState;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.setClassLoader(r10);
        Fragment r12 = this.mFragment;
        r12.mSavedViewState = r12.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
        Fragment r13 = this.mFragment;
        r13.mSavedViewRegistryState = r13.mSavedFragmentState.getBundle(VIEW_REGISTRY_STATE_TAG);
        Fragment r14 = this.mFragment;
        r14.mTargetWho = r14.mSavedFragmentState.getString(TARGET_STATE_TAG);
        Fragment r15 = this.mFragment;
        if (r15.mTargetWho == null) goto L8;
        r15.mTargetRequestCode = r15.mSavedFragmentState.getInt(TARGET_REQUEST_CODE_STATE_TAG, 0);
    L8:
        Fragment r16 = this.mFragment;
        Boolean r17 = r16.mSavedUserVisibleHint;
        if (r17 == null) goto L11;
        r16.mUserVisibleHint = r17.booleanValue();
        this.mFragment.mSavedUserVisibleHint = null;
    L12:
        Fragment r18 = this.mFragment;
        if (r18.mUserVisibleHint == true) goto L16;
        r18.mDeferStart = true;
        return;
    L16:
        return;
    L11:
        r16.mUserVisibleHint = r16.mSavedFragmentState.getBoolean(USER_VISIBLE_HINT_TAG, true);
        goto L12
    }

    void resume() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "moveto RESUMED: " + this.mFragment);
    L5:
        View r10 = this.mFragment.getFocusedView();
        if (r10 != null) goto L8;
    L16:
        this.mFragment.setFocusedView(null);
        this.mFragment.performResume();
        this.mDispatcher.dispatchOnFragmentResumed(this.mFragment, false);
        Fragment r11 = this.mFragment;
        r11.mSavedFragmentState = null;
        r11.mSavedViewState = null;
        r11.mSavedViewRegistryState = null;
        return;
    L8:
        if (isFragmentViewChild(r10) == false) goto L16;
        boolean r12 = r10.requestFocus();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L16;
        StringBuilder r13 = new StringBuilder();
        r13.append("requestFocus: Restoring focused view ");
        r13.append(r10);
        r13.append(" ");
        if (r12 == false) goto L14;
        String r14 = "succeeded";
    L15:
        r13.append(r14);
        r13.append(" on Fragment ");
        r13.append(this.mFragment);
        r13.append(" resulting in focused view ");
        r13.append(this.mFragment.mView.findFocus());
        Log.v(TAG, r13.toString());
        goto L16
    L14:
        r14 = "failed";
        goto L15
    }

    @Nullable
    Fragment.SavedState saveInstanceState() {
        if (this.mFragment.mState <= (-1)) goto L8;
        Bundle r10 = saveBasicState();
        if (r10 != null) goto L7;
        return null;
    L7:
        return new Fragment.SavedState(r10);
    L8:
        return null;
    }

    @NonNull
    FragmentState saveState() {
        FragmentState r10 = new FragmentState(this.mFragment);
        Fragment r11 = this.mFragment;
        if (r11.mState > (-1)) goto L5;
    L13:
        r10.mSavedFragmentState = r11.mSavedFragmentState;
    L14:
        return r10;
    L5:
        if (r10.mSavedFragmentState != null) goto L13;
        Bundle r12 = saveBasicState();
        r10.mSavedFragmentState = r12;
        if (this.mFragment.mTargetWho == null) goto L14;
        if (r12 != null) goto L10;
        r10.mSavedFragmentState = new Bundle();
    L10:
        r10.mSavedFragmentState.putString(TARGET_STATE_TAG, this.mFragment.mTargetWho);
        int r13 = this.mFragment.mTargetRequestCode;
        if (r13 == 0) goto L14;
        r10.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, r13);
        goto L14
    }

    void saveViewState() {
        if (this.mFragment.mView != null) goto L5;
        return;
    L5:
        SparseArray<Parcelable> r10 = new SparseArray();
        this.mFragment.mView.saveHierarchyState(r10);
        if (r10.size() <= 0) goto L8;
        this.mFragment.mSavedViewState = r10;
    L8:
        Bundle r11 = new Bundle();
        this.mFragment.mViewLifecycleOwner.performSave(r11);
        if (r11.isEmpty() == true) goto L12;
        this.mFragment.mSavedViewRegistryState = r11;
        return;
    }

    void setFragmentManagerState(int r10) {
        this.mFragmentManagerState = r10;
    }

    void start() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "moveto STARTED: " + this.mFragment);
    L5:
        this.mFragment.performStart();
        this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
    }

    void stop() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "movefrom STARTED: " + this.mFragment);
    L5:
        this.mFragment.performStop();
        this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
    }
}
