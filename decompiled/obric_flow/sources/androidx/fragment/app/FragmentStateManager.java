package androidx.fragment.app;

import ai.j0;
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
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ai.event.MessageIndication;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class FragmentStateManager {
    static final String ARGUMENTS_KEY = "arguments";
    static final String CHILD_FRAGMENT_MANAGER_KEY = "childFragmentManager";
    static final String FRAGMENT_STATE_KEY = "state";
    static final String REGISTRY_STATE_KEY = "registryState";
    static final String SAVED_INSTANCE_STATE_KEY = "savedInstanceState";
    private static final String TAG = "FragmentManager";
    static final String VIEW_REGISTRY_STATE_KEY = "viewRegistryState";
    static final String VIEW_STATE_KEY = "viewState";
    private final FragmentLifecycleCallbacksDispatcher mDispatcher;

    @NonNull
    private final Fragment mFragment;
    private int mFragmentManagerState;
    private final FragmentStore mFragmentStore;
    private boolean mMovingToState;

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentStateManager$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State = null;

        static {
            int[] r5 = new int[Lifecycle.State.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = r5;
            r5[Lifecycle.State.RESUMED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.CREATED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.INITIALIZED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher r5, @NonNull FragmentStore r10, @NonNull Fragment r11) {
        this.mMovingToState = false;
        this.mFragmentManagerState = -1;
        this.mDispatcher = r5;
        this.mFragmentStore = r10;
        this.mFragment = r11;
    }

    private boolean isFragmentViewChild(@NonNull View r5) {
        if (r5 != this.mFragment.mView) goto L5;
        return true;
    L5:
        ViewParent r10 = r5.getParent();
    L6:
        if (r10 == null) goto L11;
        if (r10 == this.mFragment.mView) goto L9;
        r10 = r10.getParent();
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    public void activityCreated() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.mFragment);
    L5:
        Bundle r5 = this.mFragment.mSavedFragmentState;
        if (r5 == null) goto L8;
        Bundle r10 = r5.getBundle(SAVED_INSTANCE_STATE_KEY);
    L9:
        this.mFragment.performActivityCreated(r10);
        this.mDispatcher.dispatchOnFragmentActivityCreated(this.mFragment, r10, false);
        return;
    L8:
        r10 = null;
        goto L9
    }

    public void addViewToContainer() {
        Fragment r5 = FragmentManager.findViewFragment(this.mFragment.mContainer);
        Fragment r10 = this.mFragment.getParentFragment();
        if (r5 != null) goto L5;
    L7:
        int r11 = this.mFragmentStore.findFragmentIndexInContainer(this.mFragment);
        Fragment r12 = this.mFragment;
        r12.mContainer.addView(r12.mView, r11);
        return;
    L5:
        if (r5.equals(r10) == true) goto L7;
        Fragment r13 = this.mFragment;
        FragmentStrictMode.onWrongNestedHierarchy(r13, r5, r13.mContainerId);
        goto L7
    }

    public void attach() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "moveto ATTACHED: " + this.mFragment);
    L5:
        Fragment r5 = this.mFragment;
        Fragment r10 = r5.mTarget;
        FragmentStateManager r11 = null;
        if (r10 == null) goto L12;
        FragmentStateManager r12 = this.mFragmentStore.getFragmentStateManager(r10.mWho);
        if (r12 == null) goto L11;
        Fragment r13 = this.mFragment;
        r13.mTargetWho = r13.mTarget.mWho;
        r13.mTarget = null;
        r11 = r12;
    L19:
        if (r11 == null) goto L21;
        r11.moveToExpectedState();
    L21:
        Fragment r14 = this.mFragment;
        r14.mHost = r14.mFragmentManager.getHost();
        Fragment r15 = this.mFragment;
        r15.mParentFragment = r15.mFragmentManager.getParent();
        this.mDispatcher.dispatchOnFragmentPreAttached(this.mFragment, false);
        this.mFragment.performAttach();
        this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, false);
        return;
    L11:
        throw new IllegalStateException("Fragment " + this.mFragment + " declared target fragment " + this.mFragment.mTarget + " that does not belong to this FragmentManager!");
    L12:
        String r16 = r5.mTargetWho;
        if (r16 == null) goto L19;
        r11 = this.mFragmentStore.getFragmentStateManager(r16);
        if (r11 != null) goto L19;
        StringBuilder r17 = new StringBuilder("Fragment ");
        r17.append(this.mFragment);
        r17.append(" declared target fragment ");
        throw new IllegalStateException(j0.q(r17, this.mFragment.mTargetWho, " that does not belong to this FragmentManager!"));
    }

    public int computeExpectedState() {
        Fragment r5 = this.mFragment;
        if (r5.mFragmentManager == null) goto L5;
        int r10 = this.mFragmentManagerState;
        int r11 = AnonymousClass2.$SwitchMap$androidx$lifecycle$Lifecycle$State[r5.mMaxState.ordinal()];
        if (r11 == 1) goto L15;
        if (r11 == 2) goto L14;
        if (r11 == 3) goto L13;
        if (r11 == 4) goto L12;
        r10 = Math.min(r10, -1);
        goto L15
    L12:
        r10 = Math.min(r10, 0);
        goto L15
    L13:
        r10 = Math.min(r10, 1);
        goto L15
    L14:
        r10 = Math.min(r10, 5);
    L15:
        Fragment r12 = this.mFragment;
        if (r12.mFromLayout == false) goto L29;
        if (r12.mInLayout == false) goto L25;
        r10 = Math.max(this.mFragmentManagerState, 2);
        View r13 = this.mFragment.mView;
        if (r13 == null) goto L29;
        if (r13.getParent() != null) goto L29;
        r10 = Math.min(r10, 2);
        goto L29
    L25:
        if (this.mFragmentManagerState >= 4) goto L27;
        r10 = Math.min(r10, r12.mState);
        goto L29
    L27:
        r10 = Math.min(r10, 1);
    L29:
        if (this.mFragment.mAdded == true) goto L31;
        r10 = Math.min(r10, 1);
    L31:
        Fragment r14 = this.mFragment;
        ViewGroup r15 = r14.mContainer;
        if (r15 == null) goto L34;
        SpecialEffectsController.Operation.LifecycleImpact r16 = SpecialEffectsController.getOrCreateController(r15, r14.getParentFragmentManager()).getAwaitingCompletionLifecycleImpact(this);
    L36:
        if (r16 != SpecialEffectsController.Operation.LifecycleImpact.ADDING) goto L39;
        r10 = Math.min(r10, 6);
    L47:
        Fragment r17 = this.mFragment;
        if (r17.mDeferStart == false) goto L53;
        if (r17.mState >= 5) goto L53;
        r10 = Math.min(r10, 4);
    L53:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L55;
        StringBuilder r18 = j0.s(r10, "computeExpectedState() of ", " for ");
        r18.append(this.mFragment);
        Log.v("FragmentManager", r18.toString());
    L55:
        return r10;
    L39:
        if (r16 != SpecialEffectsController.Operation.LifecycleImpact.REMOVING) goto L41;
        r10 = Math.max(r10, 3);
        goto L47
    L41:
        Fragment r19 = this.mFragment;
        if (r19.mRemoving == false) goto L47;
        if (r19.isInBackStack() == false) goto L46;
        r10 = Math.min(r10, 1);
        goto L47
    L46:
        r10 = Math.min(r10, -1);
        goto L47
    L34:
        r16 = null;
        goto L36
    L5:
        return r5.mState;
    }

    public void create() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "moveto CREATED: " + this.mFragment);
    L5:
        Bundle r5 = this.mFragment.mSavedFragmentState;
        if (r5 == null) goto L8;
        Bundle r10 = r5.getBundle(SAVED_INSTANCE_STATE_KEY);
    L9:
        Fragment r11 = this.mFragment;
        if (r11.mIsCreated == true) goto L12;
        this.mDispatcher.dispatchOnFragmentPreCreated(r11, r10, false);
        this.mFragment.performCreate(r10);
        this.mDispatcher.dispatchOnFragmentCreated(this.mFragment, r10, false);
        return;
    L12:
        r11.mState = 1;
        r11.restoreChildFragmentState();
        return;
    L8:
        r10 = null;
        goto L9
    }

    public void createView() {
        if (this.mFragment.mFromLayout == false) goto L6;
        return;
    L6:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L8;
        Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.mFragment);
    L8:
        Bundle r5 = this.mFragment.mSavedFragmentState;
        ViewGroup r10 = null;
        if (r5 == null) goto L11;
        Bundle r11 = r5.getBundle(SAVED_INSTANCE_STATE_KEY);
    L12:
        LayoutInflater r12 = this.mFragment.performGetLayoutInflater(r11);
        Fragment r13 = this.mFragment;
        ViewGroup r14 = r13.mContainer;
        if (r14 == null) goto L15;
        r10 = r14;
    L34:
        Fragment r15 = this.mFragment;
        r15.mContainer = r10;
        r15.performCreateView(r12, r10, r11);
        if (this.mFragment.mView != null) goto L37;
    L58:
        this.mFragment.mState = 2;
        return;
    L37:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L39;
        Log.d("FragmentManager", "moveto VIEW_CREATED: " + this.mFragment);
    L39:
        this.mFragment.mView.setSaveFromParentEnabled(false);
        Fragment r16 = this.mFragment;
        r16.mView.setTag(R.id.fragment_container_view_tag, r16);
        if (r10 == null) goto L42;
        addViewToContainer();
    L42:
        Fragment r17 = this.mFragment;
        if (r17.mHidden == false) goto L46;
        r17.mView.setVisibility(8);
    L46:
        if (ViewCompat.isAttachedToWindow(this.mFragment.mView) == false) goto L48;
        ViewCompat.requestApplyInsets(this.mFragment.mView);
    L49:
        this.mFragment.performViewCreated();
        FragmentLifecycleCallbacksDispatcher r18 = this.mDispatcher;
        Fragment r19 = this.mFragment;
        r18.dispatchOnFragmentViewCreated(r19, r19.mView, r11, false);
        int r20 = this.mFragment.mView.getVisibility();
        this.mFragment.setPostOnViewCreatedAlpha(this.mFragment.mView.getAlpha());
        Fragment r21 = this.mFragment;
        if (r21.mContainer == null) goto L58;
        if (r20 != 0) goto L58;
        View r22 = r21.mView.findFocus();
        if (r22 == null) goto L57;
        this.mFragment.setFocusedView(r22);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L57;
        Log.v("FragmentManager", "requestFocus: Saved focused view " + r22 + " for Fragment " + this.mFragment);
    L57:
        this.mFragment.mView.setAlpha(0.0f);
        goto L58
    L48:
        final View r23 = this.mFragment.mView;
        r23.addOnAttachStateChangeListener(new AnonymousClass1(this, r23));
        goto L49
    L15:
        int r24 = r13.mContainerId;
        if (r24 == 0) goto L34;
        if (r24 == (-1)) goto L33;
        r10 = (ViewGroup) r13.mFragmentManager.getContainer().onFindViewById(this.mFragment.mContainerId);
        if (r10 != null) goto L30;
        Fragment r25 = this.mFragment;
        if (r25.mRestored == true) goto L34;
        String r26 = r25.getResources().getResourceName(this.mFragment.mContainerId);     // Catch: Resources.NotFoundException -> L26
    L28:
        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.mFragment.mContainerId) + " (" + r26 + ") for fragment " + this.mFragment);
    L26:
        r26 = "unknown";
        goto L28
    L30:
        if ((r10 instanceof FragmentContainerView) == true) goto L34;
        FragmentStrictMode.onWrongFragmentContainer(this.mFragment, r10);
        goto L34
    L33:
        throw new IllegalArgumentException("Cannot create fragment " + this.mFragment + " for a container view with no id");
    L11:
        r11 = null;
        goto L12
    }

    public void destroy() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom CREATED: " + this.mFragment);
    L5:
        Fragment r5 = this.mFragment;
        boolean r10 = true;
        if (r5.mRemoving == true) goto L8;
    L10:
        boolean r11 = false;
    L12:
        if (r11 == false) goto L16;
        Fragment r12 = this.mFragment;
        if (r12.mBeingSaved == true) goto L16;
        this.mFragmentStore.setSavedState(r12.mWho, null);
    L16:
        if (r11 == false) goto L18;
    L28:
        FragmentHostCallback<?> r13 = this.mFragment.mHost;
        if ((r13 instanceof ViewModelStoreOwner) == false) goto L32;
        r10 = this.mFragmentStore.getNonConfig().isCleared();
    L34:
        if (r11 == true) goto L36;
    L37:
        if (r10 == false) goto L39;
    L38:
        this.mFragmentStore.getNonConfig().clearNonConfigState(this.mFragment, false);
    L39:
        this.mFragment.performDestroy();
        this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
        Iterator<FragmentStateManager> r14 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L41:
        if (r14.hasNext() == false) goto L47;
        FragmentStateManager r15 = r14.next();
        if (r15 == null) goto L41;
        Fragment r16 = r15.getFragment();
        if (this.mFragment.mWho.equals(r16.mTargetWho) == false) goto L41;
        r16.mTarget = this.mFragment;
        r16.mTargetWho = null;
        goto L41
    L47:
        Fragment r17 = this.mFragment;
        String r18 = r17.mTargetWho;
        if (r18 == null) goto L50;
        r17.mTarget = this.mFragmentStore.findActiveFragment(r18);
    L50:
        this.mFragmentStore.makeInactive(this);
        return;
    L36:
        if (this.mFragment.mBeingSaved == false) goto L38;
    L32:
        if ((r13.getContext() instanceof Activity) == false) goto L34;
        r10 = true ^ ((Activity) r13.getContext()).isChangingConfigurations();
        goto L34
    L18:
        if (this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment) == true) goto L28;
        String r19 = this.mFragment.mTargetWho;
        if (r19 == null) goto L27;
        Fragment r20 = this.mFragmentStore.findActiveFragment(r19);
        if (r20 == null) goto L27;
        if (r20.mRetainInstance == false) goto L27;
        this.mFragment.mTarget = r20;
    L27:
        this.mFragment.mState = 0;
        return;
    L8:
        if (r5.isInBackStack() == true) goto L10;
        r11 = true;
        goto L12
    }

    public void destroyFragmentView() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.mFragment);
    L5:
        Fragment r5 = this.mFragment;
        ViewGroup r10 = r5.mContainer;
        if (r10 == null) goto L10;
        View r11 = r5.mView;
        if (r11 == null) goto L10;
        r10.removeView(r11);
    L10:
        this.mFragment.performDestroyView();
        this.mDispatcher.dispatchOnFragmentViewDestroyed(this.mFragment, false);
        Fragment r12 = this.mFragment;
        r12.mContainer = null;
        r12.mView = null;
        r12.mViewLifecycleOwner = null;
        r12.mViewLifecycleOwnerLiveData.setValue(null);
        this.mFragment.mInLayout = false;
    }

    public void detach() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom ATTACHED: " + this.mFragment);
    L5:
        this.mFragment.performDetach();
        this.mDispatcher.dispatchOnFragmentDetached(this.mFragment, false);
        Fragment r5 = this.mFragment;
        r5.mState = -1;
        r5.mHost = null;
        r5.mParentFragment = null;
        r5.mFragmentManager = null;
        if (r5.mRemoving == false) goto L11;
        if (r5.isInBackStack() == true) goto L11;
    L13:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L15;
        Log.d("FragmentManager", "initState called for fragment: " + this.mFragment);
    L15:
        this.mFragment.initState();
        return;
    L11:
        if (this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment) == true) goto L13;
    }

    public void ensureInflatedView() {
        Fragment r5 = this.mFragment;
        if (r5.mFromLayout == true) goto L5;
        return;
    L5:
        if (r5.mInLayout == true) goto L7;
        return;
    L7:
        if (r5.mPerformedCreateView == false) goto L9;
        return;
    L9:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L11;
        Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.mFragment);
    L11:
        Bundle r10 = this.mFragment.mSavedFragmentState;
        if (r10 == null) goto L14;
        Bundle r11 = r10.getBundle(SAVED_INSTANCE_STATE_KEY);
    L15:
        Fragment r12 = this.mFragment;
        r12.performCreateView(r12.performGetLayoutInflater(r11), null, r11);
        View r13 = this.mFragment.mView;
        if (r13 == null) goto L25;
        r13.setSaveFromParentEnabled(false);
        Fragment r14 = this.mFragment;
        r14.mView.setTag(R.id.fragment_container_view_tag, r14);
        Fragment r15 = this.mFragment;
        if (r15.mHidden == false) goto L20;
        r15.mView.setVisibility(8);
    L20:
        this.mFragment.performViewCreated();
        FragmentLifecycleCallbacksDispatcher r16 = this.mDispatcher;
        Fragment r17 = this.mFragment;
        r16.dispatchOnFragmentViewCreated(r17, r17.mView, r11, false);
        this.mFragment.mState = 2;
        return;
    L25:
        return;
    L14:
        r11 = null;
        goto L15
    }

    @NonNull
    public Fragment getFragment() {
        return this.mFragment;
    }

    public void moveToExpectedState() {
        if (this.mMovingToState == false) goto L98;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L119;
        Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + getFragment());
        return;
    L119:
        return;
    L98:
        this.mMovingToState = true;     // Catch: Throwable -> L17
        boolean r5 = false;
    L10:
        int r10 = computeExpectedState();     // Catch: Throwable -> L17
        Fragment r11 = this.mFragment;     // Catch: Throwable -> L17
        int r12 = r11.mState;     // Catch: Throwable -> L17
        if (r10 == r12) goto L64;
        if (r10 <= r12) goto L32;
        switch((r12 + 1)) {
            case 0: goto L30;
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L22;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L16;
            default: goto L63;
        };     // Catch: Throwable -> L17
    L16:
        resume();     // Catch: Throwable -> L17
        goto L63
    L19:
        r11.mState = 6;     // Catch: Throwable -> L17
        goto L63
    L20:
        start();     // Catch: Throwable -> L17
        goto L63
    L27:
        activityCreated();     // Catch: Throwable -> L17
        goto L63
    L28:
        ensureInflatedView();     // Catch: Throwable -> L17
        createView();     // Catch: Throwable -> L17
        goto L63
    L29:
        create();     // Catch: Throwable -> L17
        goto L63
    L30:
        attach();     // Catch: Throwable -> L17
    L63:
        r5 = true;
        goto L10
    L22:
        if (r11.mView == null) goto L26;
        ViewGroup r13 = r11.mContainer;     // Catch: Throwable -> L17
        if (r13 == null) goto L26;
        SpecialEffectsController.getOrCreateController(r13, r11.getParentFragmentManager()).enqueueAdd(SpecialEffectsController.Operation.State.from(this.mFragment.mView.getVisibility()), this);     // Catch: Throwable -> L17
    L26:
        this.mFragment.mState = 4;     // Catch: Throwable -> L17
        goto L63
    L32:
        switch((r12 - 1)) {
            case -1: goto L62;
            case 0: goto L57;
            case 1: goto L55;
            case 2: goto L54;
            case 3: goto L38;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L34;
            default: goto L63;
        };     // Catch: Throwable -> L17
    L34:
        pause();     // Catch: Throwable -> L17
        goto L63
    L35:
        r11.mState = 5;     // Catch: Throwable -> L17
        goto L63
    L36:
        stop();     // Catch: Throwable -> L17
        goto L63
    L54:
        r11.mInLayout = false;     // Catch: Throwable -> L17
        r11.mState = 2;     // Catch: Throwable -> L17
        goto L63
    L55:
        destroyFragmentView();     // Catch: Throwable -> L17
        this.mFragment.mState = 1;     // Catch: Throwable -> L17
        goto L63
    L62:
        detach();     // Catch: Throwable -> L17
        goto L63
    L38:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L40;
        Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.mFragment);     // Catch: Throwable -> L17
    L40:
        Fragment r14 = this.mFragment;     // Catch: Throwable -> L17
        if (r14.mBeingSaved == false) goto L44;
        this.mFragmentStore.setSavedState(r14.mWho, saveState());     // Catch: Throwable -> L17
    L48:
        Fragment r15 = this.mFragment;     // Catch: Throwable -> L17
        if (r15.mView == null) goto L53;
        ViewGroup r16 = r15.mContainer;     // Catch: Throwable -> L17
        if (r16 == null) goto L53;
        SpecialEffectsController.getOrCreateController(r16, r15.getParentFragmentManager()).enqueueRemove(this);     // Catch: Throwable -> L17
    L53:
        this.mFragment.mState = 3;     // Catch: Throwable -> L17
        goto L63
    L44:
        if (r14.mView == null) goto L48;
        if (r14.mSavedViewState != null) goto L48;
        saveViewState();     // Catch: Throwable -> L17
        goto L48
    L57:
        if (r11.mBeingSaved == true) goto L59;
    L61:
        destroy();     // Catch: Throwable -> L17
        goto L63
    L59:
        if (this.mFragmentStore.getSavedState(r11.mWho) != null) goto L61;
        this.mFragmentStore.setSavedState(this.mFragment.mWho, saveState());     // Catch: Throwable -> L17
        goto L61
    L64:
        if (r5 == false) goto L66;
    L80:
        Fragment r17 = this.mFragment;     // Catch: Throwable -> L17
        if (r17.mHiddenChanged == true) goto L83;
    L94:
        this.mMovingToState = false;
        return;
    L83:
        if (r17.mView == null) goto L90;
        ViewGroup r18 = r17.mContainer;     // Catch: Throwable -> L17
        if (r18 == null) goto L90;
        SpecialEffectsController r19 = SpecialEffectsController.getOrCreateController(r18, r17.getParentFragmentManager());     // Catch: Throwable -> L17
        if (this.mFragment.mHidden == false) goto L89;
        r19.enqueueHide(this);     // Catch: Throwable -> L17
        goto L90
    L89:
        r19.enqueueShow(this);     // Catch: Throwable -> L17
    L90:
        Fragment r20 = this.mFragment;     // Catch: Throwable -> L17
        FragmentManager r21 = r20.mFragmentManager;     // Catch: Throwable -> L17
        if (r21 == null) goto L93;
        r21.invalidateMenuForFragment(r20);     // Catch: Throwable -> L17
    L93:
        Fragment r22 = this.mFragment;     // Catch: Throwable -> L17
        r22.mHiddenChanged = false;     // Catch: Throwable -> L17
        r22.onHiddenChanged(r22.mHidden);     // Catch: Throwable -> L17
        this.mFragment.mChildFragmentManager.dispatchOnHiddenChanged();     // Catch: Throwable -> L17
        goto L94
    L66:
        if (r12 != (-1)) goto L80;
        if (r11.mRemoving == false) goto L80;
        if (r11.isInBackStack() == true) goto L80;
        if (this.mFragment.mBeingSaved == true) goto L80;
        if (FragmentManager.isLoggingEnabled(3) == false) goto L76;
        Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.mFragment);     // Catch: Throwable -> L17
    L76:
        this.mFragmentStore.getNonConfig().clearNonConfigState(this.mFragment, true);     // Catch: Throwable -> L17
        this.mFragmentStore.makeInactive(this);     // Catch: Throwable -> L17
        if (FragmentManager.isLoggingEnabled(3) == false) goto L79;
        Log.d("FragmentManager", "initState called for fragment: " + this.mFragment);     // Catch: Throwable -> L17
    L79:
        this.mFragment.initState();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.mMovingToState = false;
        throw th;
    }

    public void pause() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom RESUMED: " + this.mFragment);
    L5:
        this.mFragment.performPause();
        this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
    }

    public void restoreState(@NonNull ClassLoader r5) {
        Bundle r10 = this.mFragment.mSavedFragmentState;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setClassLoader(r5);
        if (this.mFragment.mSavedFragmentState.getBundle(SAVED_INSTANCE_STATE_KEY) != null) goto L8;
        this.mFragment.mSavedFragmentState.putBundle(SAVED_INSTANCE_STATE_KEY, new Bundle());
    L8:
        Fragment r11 = this.mFragment;
        r11.mSavedViewState = r11.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_KEY);
        Fragment r12 = this.mFragment;
        r12.mSavedViewRegistryState = r12.mSavedFragmentState.getBundle(VIEW_REGISTRY_STATE_KEY);
        FragmentState r13 = (FragmentState) this.mFragment.mSavedFragmentState.getParcelable("state");
        if (r13 == null) goto L14;
        Fragment r14 = this.mFragment;
        r14.mTargetWho = r13.mTargetWho;
        r14.mTargetRequestCode = r13.mTargetRequestCode;
        Boolean r15 = r14.mSavedUserVisibleHint;
        if (r15 == null) goto L13;
        r14.mUserVisibleHint = r15.booleanValue();
        this.mFragment.mSavedUserVisibleHint = null;
        goto L14
    L13:
        r14.mUserVisibleHint = r13.mUserVisibleHint;
    L14:
        Fragment r16 = this.mFragment;
        if (r16.mUserVisibleHint == true) goto L18;
        r16.mDeferStart = true;
        return;
    }

    public void resume() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "moveto RESUMED: " + this.mFragment);
    L5:
        View r5 = this.mFragment.getFocusedView();
        if (r5 != null) goto L8;
    L16:
        this.mFragment.setFocusedView(null);
        this.mFragment.performResume();
        this.mDispatcher.dispatchOnFragmentResumed(this.mFragment, false);
        this.mFragmentStore.setSavedState(this.mFragment.mWho, null);
        Fragment r10 = this.mFragment;
        r10.mSavedFragmentState = null;
        r10.mSavedViewState = null;
        r10.mSavedViewRegistryState = null;
        return;
    L8:
        if (isFragmentViewChild(r5) == false) goto L16;
        boolean r11 = r5.requestFocus();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L16;
        StringBuilder r12 = new StringBuilder("requestFocus: Restoring focused view ");
        r12.append(r5);
        r12.append(" ");
        if (r11 == false) goto L14;
        String r13 = "succeeded";
    L15:
        r12.append(r13);
        r12.append(" on Fragment ");
        r12.append(this.mFragment);
        r12.append(" resulting in focused view ");
        r12.append(this.mFragment.mView.findFocus());
        Log.v("FragmentManager", r12.toString());
        goto L16
    L14:
        r13 = MessageIndication.STATUS_FAILED;
        goto L15
    }

    @Nullable
    public Fragment.SavedState saveInstanceState() {
        if (this.mFragment.mState > (-1)) goto L5;
        return null;
    L5:
        return new Fragment.SavedState(saveState());
    }

    @NonNull
    public Bundle saveState() {
        Bundle r5 = new Bundle();
        Fragment r10 = this.mFragment;
        if (r10.mState != (-1)) goto L7;
        Bundle r11 = r10.mSavedFragmentState;
        if (r11 == null) goto L7;
        r5.putAll(r11);
    L7:
        r5.putParcelable("state", new FragmentState(this.mFragment));
        if (this.mFragment.mState <= (-1)) goto L27;
        Bundle r12 = new Bundle();
        this.mFragment.performSaveInstanceState(r12);
        if (r12.isEmpty() == true) goto L12;
        r5.putBundle(SAVED_INSTANCE_STATE_KEY, r12);
    L12:
        this.mDispatcher.dispatchOnFragmentSaveInstanceState(this.mFragment, r12, false);
        Bundle r13 = new Bundle();
        this.mFragment.mSavedStateRegistryController.performSave(r13);
        if (r13.isEmpty() == true) goto L15;
        r5.putBundle(REGISTRY_STATE_KEY, r13);
    L15:
        Bundle r14 = this.mFragment.mChildFragmentManager.saveAllStateInternal();
        if (r14.isEmpty() == true) goto L19;
        r5.putBundle(CHILD_FRAGMENT_MANAGER_KEY, r14);
    L19:
        if (this.mFragment.mView == null) goto L21;
        saveViewState();
    L21:
        SparseArray<Parcelable> r15 = this.mFragment.mSavedViewState;
        if (r15 == null) goto L24;
        r5.putSparseParcelableArray(VIEW_STATE_KEY, r15);
    L24:
        Bundle r16 = this.mFragment.mSavedViewRegistryState;
        if (r16 == null) goto L27;
        r5.putBundle(VIEW_REGISTRY_STATE_KEY, r16);
    L27:
        Bundle r17 = this.mFragment.mArguments;
        if (r17 == null) goto L30;
        r5.putBundle(ARGUMENTS_KEY, r17);
    L30:
        return r5;
    }

    public void saveViewState() {
        if (this.mFragment.mView != null) goto L6;
        return;
    L6:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
        Log.v("FragmentManager", "Saving view state for fragment " + this.mFragment + " with view " + this.mFragment.mView);
    L8:
        SparseArray<Parcelable> r5 = new SparseArray();
        this.mFragment.mView.saveHierarchyState(r5);
        if (r5.size() <= 0) goto L11;
        this.mFragment.mSavedViewState = r5;
    L11:
        Bundle r10 = new Bundle();
        this.mFragment.mViewLifecycleOwner.performSave(r10);
        if (r10.isEmpty() == true) goto L15;
        this.mFragment.mSavedViewRegistryState = r10;
        return;
    }

    public void setFragmentManagerState(int r5) {
        this.mFragmentManagerState = r5;
    }

    public void start() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "moveto STARTED: " + this.mFragment);
    L5:
        this.mFragment.performStart();
        this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
    }

    public void stop() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom STARTED: " + this.mFragment);
    L5:
        this.mFragment.performStop();
        this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
    }

    public FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher r5, @NonNull FragmentStore r10, @NonNull ClassLoader r11, @NonNull FragmentFactory r12, @NonNull Bundle r13) {
        this.mMovingToState = false;
        this.mFragmentManagerState = -1;
        this.mDispatcher = r5;
        this.mFragmentStore = r10;
        Fragment r14 = ((FragmentState) r13.getParcelable("state")).instantiate(r12, r11);
        this.mFragment = r14;
        r14.mSavedFragmentState = r13;
        Bundle r15 = r13.getBundle(ARGUMENTS_KEY);
        if (r15 == null) goto L5;
        r15.setClassLoader(r11);
    L5:
        r14.setArguments(r15);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L9;
        Log.v("FragmentManager", "Instantiated fragment " + r14);
        return;
    }

    public FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher r5, @NonNull FragmentStore r10, @NonNull Fragment r11, @NonNull Bundle r12) {
        this.mMovingToState = false;
        this.mFragmentManagerState = -1;
        this.mDispatcher = r5;
        this.mFragmentStore = r10;
        this.mFragment = r11;
        r11.mSavedViewState = null;
        r11.mSavedViewRegistryState = null;
        r11.mBackStackNesting = 0;
        r11.mInLayout = false;
        r11.mAdded = false;
        Fragment r13 = r11.mTarget;
        if (r13 == null) goto L5;
        String r14 = r13.mWho;
    L6:
        r11.mTargetWho = r14;
        r11.mTarget = null;
        r11.mSavedFragmentState = r12;
        r11.mArguments = r12.getBundle(ARGUMENTS_KEY);
        return;
    L5:
        r14 = null;
        goto L6
    }
}
