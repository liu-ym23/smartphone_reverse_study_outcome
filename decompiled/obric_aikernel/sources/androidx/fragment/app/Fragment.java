package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.UiThread;
import androidx.arch.core.util.Function;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ActivityResultCaller {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = null;
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    AnimationInfo mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;

    @NonNull
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;

    @LayoutRes
    private int mContentLayoutId;
    ViewModelProvider.Factory mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry;
    Lifecycle.State mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<OnPreAttachedListener> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    SavedStateRegistryController mSavedStateRegistryController;

    @Nullable
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;

    @Nullable
    FragmentViewLifecycleOwner mViewLifecycleOwner;
    MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData;

    @NonNull
    String mWho;

    static class AnimationInfo {
        Boolean mAllowEnterTransitionOverlap;
        Boolean mAllowReturnTransitionOverlap;
        View mAnimatingAway;
        Animator mAnimator;
        int mEnterAnim;
        Object mEnterTransition;
        SharedElementCallback mEnterTransitionCallback;
        boolean mEnterTransitionPostponed;
        int mExitAnim;
        Object mExitTransition;
        SharedElementCallback mExitTransitionCallback;
        View mFocusedView;
        boolean mIsHideReplaced;
        boolean mIsPop;
        int mNextTransition;
        int mPopEnterAnim;
        int mPopExitAnim;
        float mPostOnViewCreatedAlpha;
        Object mReenterTransition;
        Object mReturnTransition;
        Object mSharedElementEnterTransition;
        Object mSharedElementReturnTransition;
        ArrayList<String> mSharedElementSourceNames;
        ArrayList<String> mSharedElementTargetNames;
        OnStartEnterTransitionListener mStartEnterTransitionListener;

        AnimationInfo() {
            this.mEnterTransition = null;
            Object r10 = Fragment.USE_DEFAULT_TRANSITION;
            this.mReturnTransition = r10;
            this.mExitTransition = null;
            this.mReenterTransition = r10;
            this.mSharedElementEnterTransition = null;
            this.mSharedElementReturnTransition = r10;
            this.mEnterTransitionCallback = null;
            this.mExitTransitionCallback = null;
            this.mPostOnViewCreatedAlpha = 1.0f;
            this.mFocusedView = null;
        }
    }

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(@NonNull String r10, @Nullable Exception r11) {
            super(r10, r11);
        }
    }

    private static abstract class OnPreAttachedListener {
        private OnPreAttachedListener() {
        }

        /* synthetic */ OnPreAttachedListener(AnonymousClass1 r10) {
            this();
        }

        abstract void onPreAttached();
    }

    interface OnStartEnterTransitionListener {
        void onStartEnterTransition();

        void startListening();
    }

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements Parcelable {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        final Bundle mState;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Bundle r10) {
            this.mState = r10;
        }

        SavedState(@NonNull Parcel r10, @Nullable ClassLoader r11) {
            Bundle r12 = r10.readBundle();
            this.mState = r12;
            if (r11 == null) goto L7;
            if (r12 == null) goto L8;
            r12.setClassLoader(r11);
            return;
        L8:
            return;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            r10.writeBundle(this.mState);
        }
    }

    static {
        USE_DEFAULT_TRANSITION = new Object();
    }

    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new AnonymousClass1(this);
        this.mMaxState = Lifecycle.State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new MutableLiveData();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList();
        initLifecycle();
    }

    @ContentView
    public Fragment(@LayoutRes int r10) {
        this();
        this.mContentLayoutId = r10;
    }

    private AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo != null) goto L6;
        this.mAnimationInfo = new AnimationInfo();
    L6:
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        Lifecycle.State r10 = this.mMaxState;
        if (r10 == Lifecycle.State.INITIALIZED) goto L10;
        if (this.mParentFragment == null) goto L10;
        return Math.min(r10.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    L10:
        return r10.ordinal();
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        this.mDefaultFactory = null;
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context r10, @NonNull String r11) {
        return instantiate(r10, r11, null);
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context r10, @NonNull String r11, @Nullable Bundle r12) {
        Fragment r13 = FragmentFactory.loadFragmentClass(r10.getClassLoader(), r11).getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 java.lang.InstantiationException -> L16
        if (r12 == null) goto L6;
        r12.setClassLoader(r13.getClass().getClassLoader());     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 java.lang.InstantiationException -> L16
        r13.setArguments(r12);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 java.lang.InstantiationException -> L16
    L6:
        return r13;
    L13:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r11 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L16:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r11 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L10:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r11 + ": could not find Fragment constructor", e);
    L7:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r11 + ": calling Fragment constructor caused an exception", e);
    }

    @NonNull
    private <I, O> ActivityResultLauncher<I> prepareCallInternal(@NonNull final ActivityResultContract<I, O> r10, @NonNull final Function<Void, ActivityResultRegistry> r11, @NonNull final ActivityResultCallback<O> r12) {
        if (this.mState > 1) goto L7;
        final AtomicReference r13 = new AtomicReference();
        registerOnPreAttachListener(new AnonymousClass8(this, r11, r13, r10, r12));
        return new AnonymousClass9(this, r13, r10);
    L7:
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void registerOnPreAttachListener(@NonNull OnPreAttachedListener r10) {
        if (this.mState < 0) goto L5;
        r10.onPreAttached();
        return;
    L5:
        this.mOnPreAttachedListeners.add(r10);
    }

    private void restoreViewState() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
    L6:
        if (this.mView == null) goto L8;
        restoreViewState(this.mSavedFragmentState);
    L8:
        this.mSavedFragmentState = null;
    }

    void callStartTransitionListener(boolean r10) {
        AnimationInfo r11 = this.mAnimationInfo;
        OnStartEnterTransitionListener r12 = null;
        if (r11 == null) goto L6;
        r11.mEnterTransitionPostponed = false;
        OnStartEnterTransitionListener r13 = r11.mStartEnterTransitionListener;
        r11.mStartEnterTransitionListener = null;
        r12 = r13;
    L6:
        if (r12 == null) goto L9;
        r12.onStartEnterTransition();
        return;
    L9:
        if (FragmentManager.USE_STATE_MANAGER == true) goto L11;
        return;
    L11:
        if (this.mView == null) goto L23;
        ViewGroup r14 = this.mContainer;
        if (r14 == null) goto L24;
        FragmentManager r15 = this.mFragmentManager;
        if (r15 == null) goto L25;
        final SpecialEffectsController r16 = SpecialEffectsController.getOrCreateController(r14, r15);
        r16.markPostponedState();
        if (r10 == false) goto L19;
        this.mHost.getHandler().post(new AnonymousClass3(this, r16));
        return;
    L19:
        r16.executePendingOperations();
        return;
    L25:
        return;
    L24:
        return;
    }

    @NonNull
    FragmentContainer createFragmentContainer() {
        return new AnonymousClass4(this);
    }

    public void dump(@NonNull String r10, @Nullable FileDescriptor r11, @NonNull PrintWriter r12, @Nullable String[] r13) {
        r12.print(r10);
        r12.print("mFragmentId=#");
        r12.print(Integer.toHexString(this.mFragmentId));
        r12.print(" mContainerId=#");
        r12.print(Integer.toHexString(this.mContainerId));
        r12.print(" mTag=");
        r12.println(this.mTag);
        r12.print(r10);
        r12.print("mState=");
        r12.print(this.mState);
        r12.print(" mWho=");
        r12.print(this.mWho);
        r12.print(" mBackStackNesting=");
        r12.println(this.mBackStackNesting);
        r12.print(r10);
        r12.print("mAdded=");
        r12.print(this.mAdded);
        r12.print(" mRemoving=");
        r12.print(this.mRemoving);
        r12.print(" mFromLayout=");
        r12.print(this.mFromLayout);
        r12.print(" mInLayout=");
        r12.println(this.mInLayout);
        r12.print(r10);
        r12.print("mHidden=");
        r12.print(this.mHidden);
        r12.print(" mDetached=");
        r12.print(this.mDetached);
        r12.print(" mMenuVisible=");
        r12.print(this.mMenuVisible);
        r12.print(" mHasMenu=");
        r12.println(this.mHasMenu);
        r12.print(r10);
        r12.print("mRetainInstance=");
        r12.print(this.mRetainInstance);
        r12.print(" mUserVisibleHint=");
        r12.println(this.mUserVisibleHint);
        if (this.mFragmentManager == null) goto L6;
        r12.print(r10);
        r12.print("mFragmentManager=");
        r12.println(this.mFragmentManager);
    L6:
        if (this.mHost == null) goto L9;
        r12.print(r10);
        r12.print("mHost=");
        r12.println(this.mHost);
    L9:
        if (this.mParentFragment == null) goto L12;
        r12.print(r10);
        r12.print("mParentFragment=");
        r12.println(this.mParentFragment);
    L12:
        if (this.mArguments == null) goto L15;
        r12.print(r10);
        r12.print("mArguments=");
        r12.println(this.mArguments);
    L15:
        if (this.mSavedFragmentState == null) goto L18;
        r12.print(r10);
        r12.print("mSavedFragmentState=");
        r12.println(this.mSavedFragmentState);
    L18:
        if (this.mSavedViewState == null) goto L21;
        r12.print(r10);
        r12.print("mSavedViewState=");
        r12.println(this.mSavedViewState);
    L21:
        if (this.mSavedViewRegistryState == null) goto L23;
        r12.print(r10);
        r12.print("mSavedViewRegistryState=");
        r12.println(this.mSavedViewRegistryState);
    L23:
        Fragment r14 = getTargetFragment();
        if (r14 == null) goto L26;
        r12.print(r10);
        r12.print("mTarget=");
        r12.print(r14);
        r12.print(" mTargetRequestCode=");
        r12.println(this.mTargetRequestCode);
    L26:
        r12.print(r10);
        r12.print("mPopDirection=");
        r12.println(getPopDirection());
        if (getEnterAnim() == 0) goto L30;
        r12.print(r10);
        r12.print("getEnterAnim=");
        r12.println(getEnterAnim());
    L30:
        if (getExitAnim() == 0) goto L33;
        r12.print(r10);
        r12.print("getExitAnim=");
        r12.println(getExitAnim());
    L33:
        if (getPopEnterAnim() == 0) goto L36;
        r12.print(r10);
        r12.print("getPopEnterAnim=");
        r12.println(getPopEnterAnim());
    L36:
        if (getPopExitAnim() == 0) goto L39;
        r12.print(r10);
        r12.print("getPopExitAnim=");
        r12.println(getPopExitAnim());
    L39:
        if (this.mContainer == null) goto L42;
        r12.print(r10);
        r12.print("mContainer=");
        r12.println(this.mContainer);
    L42:
        if (this.mView == null) goto L45;
        r12.print(r10);
        r12.print("mView=");
        r12.println(this.mView);
    L45:
        if (getAnimatingAway() == null) goto L48;
        r12.print(r10);
        r12.print("mAnimatingAway=");
        r12.println(getAnimatingAway());
    L48:
        if (getContext() == null) goto L50;
        LoaderManager.getInstance(this).dump(r10, r11, r12, r13);
    L50:
        r12.print(r10);
        r12.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.dump(r10 + "  ", r11, r12, r13);
    }

    public final boolean equals(@Nullable Object r10) {
        return super.equals(r10);
    }

    @Nullable
    Fragment findFragmentByWho(@NonNull String r10) {
        if (r10.equals(this.mWho) == false) goto L6;
        return this;
    L6:
        return this.mChildFragmentManager.findFragmentByWho(r10);
    }

    @NonNull
    String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    @Nullable
    public final FragmentActivity getActivity() {
        FragmentHostCallback<?> r10 = this.mHost;
        if (r10 != null) goto L6;
        return null;
    L6:
        return (FragmentActivity) r10.getActivity();
    }

    public boolean getAllowEnterTransitionOverlap() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 == null) goto L8;
        Boolean r11 = r10.mAllowEnterTransitionOverlap;
        if (r11 == null) goto L8;
        return r11.booleanValue();
    L8:
        return true;
    }

    public boolean getAllowReturnTransitionOverlap() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 == null) goto L8;
        Boolean r11 = r10.mAllowReturnTransitionOverlap;
        if (r11 == null) goto L8;
        return r11.booleanValue();
    L8:
        return true;
    }

    View getAnimatingAway() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.mAnimatingAway;
    }

    Animator getAnimator() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.mAnimator;
    }

    @Nullable
    public final Bundle getArguments() {
        return this.mArguments;
    }

    @NonNull
    public final FragmentManager getChildFragmentManager() {
        if (this.mHost == null) goto L7;
        return this.mChildFragmentManager;
    L7:
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    @Nullable
    public Context getContext() {
        FragmentHostCallback<?> r10 = this.mHost;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.getContext();
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager == null) goto L21;
        if (this.mDefaultFactory != null) goto L19;
        Application r10 = null;
        Context r11 = requireContext().getApplicationContext();
    L8:
        if ((r11 instanceof ContextWrapper) == false) goto L13;
        if ((r11 instanceof Application) == true) goto L11;
        r11 = ((ContextWrapper) r11).getBaseContext();
        goto L8
    L11:
        r10 = (Application) r11;
    L13:
        if (r10 == null) goto L15;
    L17:
        this.mDefaultFactory = new SavedStateViewModelFactory(r10, this, getArguments());
        goto L19
    L15:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L17;
        Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
    L19:
        return this.mDefaultFactory;
    L21:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    int getEnterAnim() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.mEnterAnim;
    }

    @Nullable
    public Object getEnterTransition() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.mEnterTransition;
    }

    SharedElementCallback getEnterTransitionCallback() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.mEnterTransitionCallback;
    }

    int getExitAnim() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.mExitAnim;
    }

    @Nullable
    public Object getExitTransition() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.mExitTransition;
    }

    SharedElementCallback getExitTransitionCallback() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.mExitTransitionCallback;
    }

    View getFocusedView() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.mFocusedView;
    }

    @Nullable
    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    @Nullable
    public final Object getHost() {
        FragmentHostCallback<?> r10 = this.mHost;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.onGetHost();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    @NonNull
    public final LayoutInflater getLayoutInflater() {
        LayoutInflater r10 = this.mLayoutInflater;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return performGetLayoutInflater(null);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public LayoutInflater getLayoutInflater(@Nullable Bundle r10) {
        FragmentHostCallback<?> r11 = this.mHost;
        if (r11 == null) goto L7;
        LayoutInflater r12 = r11.onGetLayoutInflater();
        LayoutInflaterCompat.setFactory2(r12, this.mChildFragmentManager.getLayoutInflaterFactory());
        return r12;
    L7:
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @NonNull
    @Deprecated
    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    int getNextTransition() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.mNextTransition;
    }

    @Nullable
    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    @NonNull
    public final FragmentManager getParentFragmentManager() {
        FragmentManager r10 = this.mFragmentManager;
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    boolean getPopDirection() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.mIsPop;
    }

    int getPopEnterAnim() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.mPopEnterAnim;
    }

    int getPopExitAnim() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.mPopExitAnim;
    }

    float getPostOnViewCreatedAlpha() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return 1.0f;
    L7:
        return r10.mPostOnViewCreatedAlpha;
    }

    @Nullable
    public Object getReenterTransition() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L6;
        return null;
    L6:
        Object r11 = r10.mReenterTransition;
        if (r11 == USE_DEFAULT_TRANSITION) goto L9;
        return r11;
    L9:
        return getExitTransition();
    }

    @NonNull
    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    @Nullable
    public Object getReturnTransition() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L6;
        return null;
    L6:
        Object r11 = r10.mReturnTransition;
        if (r11 == USE_DEFAULT_TRANSITION) goto L9;
        return r11;
    L9:
        return getEnterTransition();
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @NonNull
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @Nullable
    public Object getSharedElementEnterTransition() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.mSharedElementEnterTransition;
    }

    @Nullable
    public Object getSharedElementReturnTransition() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L6;
        return null;
    L6:
        Object r11 = r10.mSharedElementReturnTransition;
        if (r11 == USE_DEFAULT_TRANSITION) goto L9;
        return r11;
    L9:
        return getSharedElementEnterTransition();
    }

    @NonNull
    ArrayList<String> getSharedElementSourceNames() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 == null) goto L9;
        ArrayList<String> r11 = r10.mSharedElementSourceNames;
        if (r11 == null) goto L9;
        return r11;
    L9:
        return new ArrayList();
    }

    @NonNull
    ArrayList<String> getSharedElementTargetNames() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 == null) goto L9;
        ArrayList<String> r11 = r10.mSharedElementTargetNames;
        if (r11 == null) goto L9;
        return r11;
    L9:
        return new ArrayList();
    }

    @NonNull
    public final String getString(@StringRes int r10) {
        return getResources().getString(r10);
    }

    @NonNull
    public final String getString(@StringRes int r10, @Nullable Object... r11) {
        return getResources().getString(r10, r11);
    }

    @Nullable
    public final String getTag() {
        return this.mTag;
    }

    @Nullable
    @Deprecated
    public final Fragment getTargetFragment() {
        Fragment r10 = this.mTarget;
        if (r10 == null) goto L5;
        return r10;
    L5:
        FragmentManager r11 = this.mFragmentManager;
        if (r11 == null) goto L11;
        String r12 = this.mTargetWho;
        if (r12 != null) goto L10;
        return null;
    L10:
        return r11.findActiveFragment(r12);
    L11:
        return null;
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    @NonNull
    public final CharSequence getText(@StringRes int r10) {
        return getResources().getText(r10);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @Nullable
    public View getView() {
        return this.mView;
    }

    @NonNull
    @MainThread
    public LifecycleOwner getViewLifecycleOwner() {
        FragmentViewLifecycleOwner r10 = this.mViewLifecycleOwner;
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    @NonNull
    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        if (this.mFragmentManager == null) goto L11;
        if (getMinimumMaxLifecycleState() == Lifecycle.State.INITIALIZED.ordinal()) goto L9;
        return this.mFragmentManager.getViewModelStore(this);
    L9:
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    L11:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        if (this.mHost != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mAdded == false) goto L7;
        return true;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    boolean isHideReplaced() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.mIsHideReplaced;
    }

    final boolean isInBackStack() {
        if (this.mBackStackNesting <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean isMenuVisible() {
        if (this.mMenuVisible == false) goto L9;
        FragmentManager r10 = this.mFragmentManager;
        if (r10 != null) goto L7;
    L8:
        return true;
    L7:
        if (r10.isParentMenuVisible(this.mParentFragment) == true) goto L8;
    L9:
        return false;
    }

    boolean isPostponed() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.mEnterTransitionPostponed;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    final boolean isRemovingParent() {
        Fragment r10 = getParentFragment();
        if (r10 != null) goto L5;
    L9:
        return false;
    L5:
        if (r10.isRemoving() == false) goto L7;
    L8:
        return true;
    L7:
        if (r10.isRemovingParent() == false) goto L9;
        goto L8
    }

    public final boolean isResumed() {
        if (this.mState < 7) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isStateSaved() {
        FragmentManager r10 = this.mFragmentManager;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.isStateSaved();
    }

    public final boolean isVisible() {
        if (isAdded() == true) goto L5;
    L13:
        return false;
    L5:
        if (isHidden() == true) goto L13;
        View r10 = this.mView;
        if (r10 == null) goto L13;
        if (r10.getWindowToken() == null) goto L13;
        if (this.mView.getVisibility() != 0) goto L13;
        return true;
    }

    void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onActivityCreated(@Nullable Bundle r10) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int r10, int r11, @Nullable Intent r12) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
        Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + r10 + " resultCode: " + r11 + " data: " + r12);
        return;
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onAttach(@NonNull Activity r10) {
        this.mCalled = true;
    }

    @CallSuper
    @MainThread
    public void onAttach(@NonNull Context r10) {
        this.mCalled = true;
        FragmentHostCallback<?> r11 = this.mHost;
        if (r11 != null) goto L5;
        Activity r12 = null;
    L6:
        if (r12 == null) goto L9;
        this.mCalled = false;
        onAttach(r12);
        return;
    L9:
        return;
    L5:
        r12 = r11.getActivity();
        goto L6
    }

    @MainThread
    @Deprecated
    public void onAttachFragment(@NonNull Fragment r10) {
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration r10) {
        this.mCalled = true;
    }

    @MainThread
    public boolean onContextItemSelected(@NonNull MenuItem r10) {
        return false;
    }

    @CallSuper
    @MainThread
    public void onCreate(@Nullable Bundle r10) {
        this.mCalled = true;
        restoreChildFragmentState(r10);
        if (this.mChildFragmentManager.isStateAtLeast(1) == true) goto L6;
        this.mChildFragmentManager.dispatchCreate();
        return;
    }

    @Nullable
    @MainThread
    public Animation onCreateAnimation(int r10, boolean r11, int r12) {
        return null;
    }

    @Nullable
    @MainThread
    public Animator onCreateAnimator(int r10, boolean r11, int r12) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    @MainThread
    public void onCreateContextMenu(@NonNull ContextMenu r10, @NonNull View r11, @Nullable ContextMenu.ContextMenuInfo r12) {
        requireActivity().onCreateContextMenu(r10, r11, r12);
    }

    @MainThread
    public void onCreateOptionsMenu(@NonNull Menu r10, @NonNull MenuInflater r11) {
    }

    @Nullable
    @MainThread
    public View onCreateView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12) {
        int r13 = this.mContentLayoutId;
        if (r13 != 0) goto L5;
        return null;
    L5:
        return r10.inflate(r13, r11, false);
    }

    @CallSuper
    @MainThread
    public void onDestroy() {
        this.mCalled = true;
    }

    @MainThread
    public void onDestroyOptionsMenu() {
    }

    @CallSuper
    @MainThread
    public void onDestroyView() {
        this.mCalled = true;
    }

    @CallSuper
    @MainThread
    public void onDetach() {
        this.mCalled = true;
    }

    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle r10) {
        return getLayoutInflater(r10);
    }

    @MainThread
    public void onHiddenChanged(boolean r10) {
    }

    @CallSuper
    @UiThread
    @Deprecated
    public void onInflate(@NonNull Activity r10, @NonNull AttributeSet r11, @Nullable Bundle r12) {
        this.mCalled = true;
    }

    @CallSuper
    @UiThread
    public void onInflate(@NonNull Context r10, @NonNull AttributeSet r11, @Nullable Bundle r12) {
        this.mCalled = true;
        FragmentHostCallback<?> r13 = this.mHost;
        if (r13 != null) goto L5;
        Activity r14 = null;
    L6:
        if (r14 == null) goto L9;
        this.mCalled = false;
        onInflate(r14, r11, r12);
        return;
    L9:
        return;
    L5:
        r14 = r13.getActivity();
        goto L6
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    @MainThread
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean r10) {
    }

    @MainThread
    public boolean onOptionsItemSelected(@NonNull MenuItem r10) {
        return false;
    }

    @MainThread
    public void onOptionsMenuClosed(@NonNull Menu r10) {
    }

    @CallSuper
    @MainThread
    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean r10) {
    }

    @MainThread
    public void onPrepareOptionsMenu(@NonNull Menu r10) {
    }

    @MainThread
    public void onPrimaryNavigationFragmentChanged(boolean r10) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int r10, @NonNull String[] r11, @NonNull int[] r12) {
    }

    @CallSuper
    @MainThread
    public void onResume() {
        this.mCalled = true;
    }

    @MainThread
    public void onSaveInstanceState(@NonNull Bundle r10) {
    }

    @CallSuper
    @MainThread
    public void onStart() {
        this.mCalled = true;
    }

    @CallSuper
    @MainThread
    public void onStop() {
        this.mCalled = true;
    }

    @MainThread
    public void onViewCreated(@NonNull View r10, @Nullable Bundle r11) {
    }

    @CallSuper
    @MainThread
    public void onViewStateRestored(@Nullable Bundle r10) {
        this.mCalled = true;
    }

    void performActivityCreated(Bundle r10) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(r10);
        if (this.mCalled == false) goto L7;
        restoreViewState();
        this.mChildFragmentManager.dispatchActivityCreated();
        return;
    L7:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    void performAttach() {
        Iterator<OnPreAttachedListener> r10 = this.mOnPreAttachedListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onPreAttached();
        goto L4
    L6:
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.attachController(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.getContext());
        if (this.mCalled == false) goto L11;
        this.mFragmentManager.dispatchOnAttachFragment(this);
        this.mChildFragmentManager.dispatchAttach();
        return;
    L11:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
    }

    void performConfigurationChanged(@NonNull Configuration r10) {
        onConfigurationChanged(r10);
        this.mChildFragmentManager.dispatchConfigurationChanged(r10);
    }

    boolean performContextItemSelected(@NonNull MenuItem r10) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (onContextItemSelected(r10) == false) goto L9;
        return true;
    L9:
        return this.mChildFragmentManager.dispatchContextItemSelected(r10);
    }

    void performCreate(Bundle r10) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 1;
        this.mCalled = false;
        if (Build.VERSION.SDK_INT < 19) goto L5;
        this.mLifecycleRegistry.addObserver(new AnonymousClass5(this));
    L5:
        this.mSavedStateRegistryController.performRestore(r10);
        onCreate(r10);
        this.mIsCreated = true;
        if (this.mCalled == false) goto L10;
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    boolean performCreateOptionsMenu(@NonNull Menu r10, @NonNull MenuInflater r11) {
        boolean r12 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        r12 = true;
        onCreateOptionsMenu(r10, r11);
    L10:
        return r12 | this.mChildFragmentManager.dispatchCreateOptionsMenu(r10, r11);
    }

    void performCreateView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new FragmentViewLifecycleOwner(this, getViewModelStore());
        View r13 = onCreateView(r10, r11, r12);
        this.mView = r13;
        if (r13 == null) goto L6;
        this.mViewLifecycleOwner.initialize();
        ViewTreeLifecycleOwner.set(this.mView, this.mViewLifecycleOwner);
        ViewTreeViewModelStoreOwner.set(this.mView, this.mViewLifecycleOwner);
        ViewTreeSavedStateRegistryOwner.set(this.mView, this.mViewLifecycleOwner);
        this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
        return;
    L6:
        if (this.mViewLifecycleOwner.isInitialized() == true) goto L10;
        this.mViewLifecycleOwner = null;
        return;
    L10:
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    void performDestroy() {
        this.mChildFragmentManager.dispatchDestroy();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled == false) goto L6;
        return;
    L6:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void performDestroyView() {
        this.mChildFragmentManager.dispatchDestroyView();
        if (this.mView != null) goto L5;
    L7:
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled == false) goto L12;
        LoaderManager.getInstance(this).markForRedelivery();
        this.mPerformedCreateView = false;
        return;
    L12:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    L5:
        if (this.mViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        goto L7
    }

    void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled == false) goto L9;
        if (this.mChildFragmentManager.isDestroyed() == true) goto L10;
        this.mChildFragmentManager.dispatchDestroy();
        this.mChildFragmentManager = new FragmentManagerImpl();
        return;
    L10:
        return;
    L9:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    }

    @NonNull
    LayoutInflater performGetLayoutInflater(@Nullable Bundle r10) {
        LayoutInflater r11 = onGetLayoutInflater(r10);
        this.mLayoutInflater = r11;
        return r11;
    }

    void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.dispatchLowMemory();
    }

    void performMultiWindowModeChanged(boolean r10) {
        onMultiWindowModeChanged(r10);
        this.mChildFragmentManager.dispatchMultiWindowModeChanged(r10);
    }

    boolean performOptionsItemSelected(@NonNull MenuItem r10) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L13;
        if (this.mMenuVisible == false) goto L13;
        if (onOptionsItemSelected(r10) == false) goto L13;
        return true;
    L13:
        return this.mChildFragmentManager.dispatchOptionsItemSelected(r10);
    }

    void performOptionsMenuClosed(@NonNull Menu r10) {
        if (this.mHidden == false) goto L5;
        return;
    L5:
        if (this.mHasMenu == true) goto L7;
    L9:
        this.mChildFragmentManager.dispatchOptionsMenuClosed(r10);
        return;
    L7:
        if (this.mMenuVisible == false) goto L9;
        onOptionsMenuClosed(r10);
        goto L9
    }

    void performPause() {
        this.mChildFragmentManager.dispatchPause();
        if (this.mView == null) goto L5;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    L5:
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled == false) goto L9;
        return;
    L9:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    void performPictureInPictureModeChanged(boolean r10) {
        onPictureInPictureModeChanged(r10);
        this.mChildFragmentManager.dispatchPictureInPictureModeChanged(r10);
    }

    boolean performPrepareOptionsMenu(@NonNull Menu r10) {
        boolean r11 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        r11 = true;
        onPrepareOptionsMenu(r10);
    L10:
        return r11 | this.mChildFragmentManager.dispatchPrepareOptionsMenu(r10);
    }

    void performPrimaryNavigationFragmentChanged() {
        boolean r10 = this.mFragmentManager.isPrimaryNavigation(this);
        Boolean r11 = this.mIsPrimaryNavigationFragment;
        if (r11 != null) goto L5;
    L6:
        this.mIsPrimaryNavigationFragment = Boolean.valueOf(r10);
        onPrimaryNavigationFragmentChanged(r10);
        this.mChildFragmentManager.dispatchPrimaryNavigationFragmentChanged();
        return;
    L5:
        if (r11.booleanValue() != r10) goto L6;
    }

    void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (this.mCalled == false) goto L10;
        LifecycleRegistry r10 = this.mLifecycleRegistry;
        Lifecycle.Event r11 = Lifecycle.Event.ON_RESUME;
        r10.handleLifecycleEvent(r11);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(r11);
    L7:
        this.mChildFragmentManager.dispatchResume();
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    void performSaveInstanceState(Bundle r10) {
        onSaveInstanceState(r10);
        this.mSavedStateRegistryController.performSave(r10);
        Parcelable r11 = this.mChildFragmentManager.saveAllState();
        if (r11 == null) goto L6;
        r10.putParcelable("android:support:fragments", r11);
        return;
    }

    void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (this.mCalled == false) goto L10;
        LifecycleRegistry r10 = this.mLifecycleRegistry;
        Lifecycle.Event r11 = Lifecycle.Event.ON_START;
        r10.handleLifecycleEvent(r11);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(r11);
    L7:
        this.mChildFragmentManager.dispatchStart();
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    void performStop() {
        this.mChildFragmentManager.dispatchStop();
        if (this.mView == null) goto L5;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    L5:
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled == false) goto L9;
        return;
    L9:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.dispatchViewCreated();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    public final void postponeEnterTransition(long r10, @NonNull TimeUnit r11) {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
        FragmentManager r12 = this.mFragmentManager;
        if (r12 == null) goto L5;
        Handler r13 = r12.getHost().getHandler();
    L6:
        r13.removeCallbacks(this.mPostponedDurationRunnable);
        r13.postDelayed(this.mPostponedDurationRunnable, r11.toMillis(r10));
        return;
    L5:
        r13 = new Handler(Looper.getMainLooper());
        goto L6
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    @MainThread
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> r10, @NonNull ActivityResultCallback<O> r11) {
        return prepareCallInternal(r10, new AnonymousClass6(this), r11);
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    @MainThread
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> r10, @NonNull final ActivityResultRegistry r11, @NonNull ActivityResultCallback<O> r12) {
        return prepareCallInternal(r10, new AnonymousClass7(this, r11), r12);
    }

    public void registerForContextMenu(@NonNull View r10) {
        r10.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(@NonNull String[] r10, int r11) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().launchRequestPermissions(this, r10, r11);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @NonNull
    public final FragmentActivity requireActivity() {
        FragmentActivity r10 = getActivity();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @NonNull
    public final Bundle requireArguments() {
        Bundle r10 = getArguments();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    @NonNull
    public final Context requireContext() {
        Context r10 = getContext();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @NonNull
    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    @NonNull
    public final Object requireHost() {
        Object r10 = getHost();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    @NonNull
    public final Fragment requireParentFragment() {
        Fragment r10 = getParentFragment();
        if (r10 == null) goto L5;
        return r10;
    L5:
        if (getContext() != null) goto L9;
        throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
    L9:
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    @NonNull
    public final View requireView() {
        View r10 = getView();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    void restoreChildFragmentState(@Nullable Bundle r10) {
        if (r10 == null) goto L7;
        Parcelable r11 = r10.getParcelable("android:support:fragments");
        if (r11 == null) goto L8;
        this.mChildFragmentManager.restoreSaveState(r11);
        this.mChildFragmentManager.dispatchCreate();
        return;
    L8:
        return;
    }

    final void restoreViewState(Bundle r10) {
        SparseArray<Parcelable> r11 = this.mSavedViewState;
        if (r11 == null) goto L6;
        this.mView.restoreHierarchyState(r11);
        this.mSavedViewState = null;
    L6:
        if (this.mView == null) goto L8;
        this.mViewLifecycleOwner.performRestore(this.mSavedViewRegistryState);
        this.mSavedViewRegistryState = null;
    L8:
        this.mCalled = false;
        onViewStateRestored(r10);
        if (this.mCalled == false) goto L15;
        if (this.mView == null) goto L16;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L16:
        return;
    L15:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public void setAllowEnterTransitionOverlap(boolean r10) {
        AnimationInfo r11 = ensureAnimationInfo();
        r11.mAllowEnterTransitionOverlap = Boolean.valueOf(r10);
    }

    public void setAllowReturnTransitionOverlap(boolean r10) {
        AnimationInfo r11 = ensureAnimationInfo();
        r11.mAllowReturnTransitionOverlap = Boolean.valueOf(r10);
    }

    void setAnimatingAway(View r10) {
        ensureAnimationInfo().mAnimatingAway = r10;
    }

    void setAnimations(int r10, int r11, int r12, int r13) {
        if (this.mAnimationInfo != null) goto L9;
        if (r10 != 0) goto L9;
        if (r11 != 0) goto L9;
        if (r12 != 0) goto L9;
        if (r13 != 0) goto L9;
        return;
    L9:
        ensureAnimationInfo().mEnterAnim = r10;
        ensureAnimationInfo().mExitAnim = r11;
        ensureAnimationInfo().mPopEnterAnim = r12;
        ensureAnimationInfo().mPopExitAnim = r13;
    }

    void setAnimator(Animator r10) {
        ensureAnimationInfo().mAnimator = r10;
    }

    public void setArguments(@Nullable Bundle r10) {
        if (this.mFragmentManager != null) goto L5;
    L9:
        this.mArguments = r10;
        return;
    L5:
        if (isStateSaved() == false) goto L9;
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback r10) {
        ensureAnimationInfo().mEnterTransitionCallback = r10;
    }

    public void setEnterTransition(@Nullable Object r10) {
        ensureAnimationInfo().mEnterTransition = r10;
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback r10) {
        ensureAnimationInfo().mExitTransitionCallback = r10;
    }

    public void setExitTransition(@Nullable Object r10) {
        ensureAnimationInfo().mExitTransition = r10;
    }

    void setFocusedView(View r10) {
        ensureAnimationInfo().mFocusedView = r10;
    }

    public void setHasOptionsMenu(boolean r10) {
        if (this.mHasMenu == r10) goto L10;
        this.mHasMenu = r10;
        if (isAdded() == true) goto L7;
        return;
    L7:
        if (isHidden() == true) goto L12;
        this.mHost.onSupportInvalidateOptionsMenu();
        return;
    L12:
        return;
    }

    void setHideReplaced(boolean r10) {
        ensureAnimationInfo().mIsHideReplaced = r10;
    }

    public void setInitialSavedState(@Nullable SavedState r10) {
        if (this.mFragmentManager != null) goto L12;
        if (r10 == null) goto L8;
        Bundle r11 = r10.mState;
        if (r11 == null) goto L8;
    L9:
        this.mSavedFragmentState = r11;
        return;
    L8:
        r11 = null;
        goto L9
    L12:
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean r10) {
        if (this.mMenuVisible == r10) goto L12;
        this.mMenuVisible = r10;
        if (this.mHasMenu == true) goto L7;
        return;
    L7:
        if (isAdded() == true) goto L9;
        return;
    L9:
        if (isHidden() == true) goto L15;
        this.mHost.onSupportInvalidateOptionsMenu();
        return;
    L15:
        return;
    }

    void setNextTransition(int r10) {
        if (this.mAnimationInfo != null) goto L6;
        if (r10 != 0) goto L6;
        return;
    L6:
        ensureAnimationInfo();
        this.mAnimationInfo.mNextTransition = r10;
    }

    void setOnStartEnterTransitionListener(OnStartEnterTransitionListener r10) {
        ensureAnimationInfo();
        AnimationInfo r11 = this.mAnimationInfo;
        OnStartEnterTransitionListener r12 = r11.mStartEnterTransitionListener;
        if (r10 != r12) goto L5;
        return;
    L5:
        if (r10 == null) goto L11;
        if (r12 == null) goto L11;
        throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
    L11:
        if (r11.mEnterTransitionPostponed == false) goto L13;
        r11.mStartEnterTransitionListener = r10;
    L13:
        if (r10 == null) goto L16;
        r10.startListening();
        return;
    }

    void setPopDirection(boolean r10) {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        ensureAnimationInfo().mIsPop = r10;
    }

    void setPostOnViewCreatedAlpha(float r10) {
        ensureAnimationInfo().mPostOnViewCreatedAlpha = r10;
    }

    public void setReenterTransition(@Nullable Object r10) {
        ensureAnimationInfo().mReenterTransition = r10;
    }

    @Deprecated
    public void setRetainInstance(boolean r10) {
        this.mRetainInstance = r10;
        FragmentManager r11 = this.mFragmentManager;
        if (r11 == null) goto L7;
        if (r10 == false) goto L6;
        r11.addRetainedFragment(this);
        return;
    L6:
        r11.removeRetainedFragment(this);
        return;
    L7:
        this.mRetainInstanceChangedWhileDetached = true;
    }

    public void setReturnTransition(@Nullable Object r10) {
        ensureAnimationInfo().mReturnTransition = r10;
    }

    public void setSharedElementEnterTransition(@Nullable Object r10) {
        ensureAnimationInfo().mSharedElementEnterTransition = r10;
    }

    void setSharedElementNames(@Nullable ArrayList<String> r10, @Nullable ArrayList<String> r11) {
        ensureAnimationInfo();
        AnimationInfo r12 = this.mAnimationInfo;
        r12.mSharedElementSourceNames = r10;
        r12.mSharedElementTargetNames = r11;
    }

    public void setSharedElementReturnTransition(@Nullable Object r10) {
        ensureAnimationInfo().mSharedElementReturnTransition = r10;
    }

    @Deprecated
    public void setTargetFragment(@Nullable Fragment r10, int r11) {
        FragmentManager r12 = this.mFragmentManager;
        if (r10 == null) goto L5;
        FragmentManager r13 = r10.mFragmentManager;
    L6:
        if (r12 == null) goto L12;
        if (r13 == null) goto L12;
        if (r12 == r13) goto L12;
        throw new IllegalArgumentException("Fragment " + r10 + " must share the same FragmentManager to be set as a target fragment");
    L12:
        Fragment r14 = r10;
    L13:
        if (r14 == null) goto L19;
        if (r14.equals(this) == true) goto L18;
        r14 = r14.getTargetFragment();
        goto L13
    L18:
        throw new IllegalArgumentException("Setting " + r10 + " as the target of " + this + " would create a target cycle");
    L19:
        if (r10 != null) goto L23;
        this.mTargetWho = null;
    L21:
        this.mTarget = null;
    L28:
        this.mTargetRequestCode = r11;
        return;
    L23:
        if (this.mFragmentManager != null) goto L25;
    L27:
        this.mTargetWho = null;
        this.mTarget = r10;
        goto L28
    L25:
        if (r10.mFragmentManager == null) goto L27;
        this.mTargetWho = r10.mWho;
        goto L21
    L5:
        r13 = null;
        goto L6
    }

    @Deprecated
    public void setUserVisibleHint(boolean r10) {
        if (this.mUserVisibleHint == true) goto L14;
        if (r10 == false) goto L14;
        if (this.mState >= 5) goto L14;
        if (this.mFragmentManager == null) goto L14;
        if (isAdded() == false) goto L14;
        if (this.mIsCreated == false) goto L14;
        FragmentManager r11 = this.mFragmentManager;
        r11.performPendingDeferredStart(r11.createOrGetFragmentStateManager(this));
    L14:
        this.mUserVisibleHint = r10;
        if (this.mState >= 5) goto L18;
        if (r10 == true) goto L18;
        boolean r12 = true;
    L19:
        this.mDeferStart = r12;
        if (this.mSavedFragmentState == null) goto L23;
        this.mSavedUserVisibleHint = Boolean.valueOf(r10);
        return;
    L23:
        return;
    L18:
        r12 = false;
        goto L19
    }

    public boolean shouldShowRequestPermissionRationale(@NonNull String r10) {
        FragmentHostCallback<?> r11 = this.mHost;
        if (r11 != null) goto L5;
        return false;
    L5:
        return r11.onShouldShowRequestPermissionRationale(r10);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent r10) {
        startActivity(r10, null);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent r10, @Nullable Bundle r11) {
        FragmentHostCallback<?> r12 = this.mHost;
        if (r12 == null) goto L7;
        r12.onStartActivityFromFragment(this, r10, -1, r11);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent r10, int r11) {
        startActivityForResult(r10, r11, null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent r10, int r11, @Nullable Bundle r12) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().launchStartActivityForResult(this, r10, r11, r12);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender r10, int r11, @Nullable Intent r12, int r13, int r14, int r15, @Nullable Bundle r16) {
        if (this.mHost == null) goto L11;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
        Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + r11 + " IntentSender: " + r10 + " fillInIntent: " + r12 + " options: " + r16);
    L8:
        getParentFragmentManager().launchStartIntentSenderForResult(this, r10, r11, r12, r13, r14, r15, r16);
        return;
    L11:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        if (ensureAnimationInfo().mEnterTransitionPostponed == true) goto L8;
        return;
    L8:
        if (this.mHost != null) goto L11;
        ensureAnimationInfo().mEnterTransitionPostponed = false;
        return;
    L11:
        if (Looper.myLooper() == this.mHost.getHandler().getLooper()) goto L13;
        this.mHost.getHandler().postAtFrontOfQueue(new AnonymousClass2(this));
        return;
    L13:
        callStartTransitionListener(true);
    }

    @NonNull
    public String toString() {
        StringBuilder r10 = new StringBuilder(128);
        r10.append(getClass().getSimpleName());
        r10.append("{");
        r10.append(Integer.toHexString(System.identityHashCode(this)));
        r10.append("}");
        r10.append(" (");
        r10.append(this.mWho);
        if (this.mFragmentId == 0) goto L6;
        r10.append(" id=0x");
        r10.append(Integer.toHexString(this.mFragmentId));
    L6:
        if (this.mTag == null) goto L8;
        r10.append(" tag=");
        r10.append(this.mTag);
    L8:
        r10.append(")");
        return r10.toString();
    }

    public void unregisterForContextMenu(@NonNull View r10) {
        r10.setOnCreateContextMenuListener(null);
    }
}
