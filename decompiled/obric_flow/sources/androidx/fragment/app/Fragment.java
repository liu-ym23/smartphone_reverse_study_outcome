package androidx.fragment.app;

import ai.j0;
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
import androidx.annotation.AnimRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.UiThread;
import androidx.arch.core.util.Function;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
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
    boolean mBeingSaved;
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
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry;
    Lifecycle.State mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<OnPreAttachedListener> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    Runnable mPostponedDurationRunnable;
    Handler mPostponedHandler;

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    private final OnPreAttachedListener mSavedStateAttachListener;
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

    public static class AnimationInfo {
        Boolean mAllowEnterTransitionOverlap;
        Boolean mAllowReturnTransitionOverlap;
        View mAnimatingAway;

        @AnimRes
        int mEnterAnim;
        Object mEnterTransition;
        SharedElementCallback mEnterTransitionCallback;
        boolean mEnterTransitionPostponed;

        @AnimRes
        int mExitAnim;
        Object mExitTransition;
        SharedElementCallback mExitTransitionCallback;
        View mFocusedView;
        boolean mIsPop;
        int mNextTransition;

        @AnimRes
        int mPopEnterAnim;

        @AnimRes
        int mPopExitAnim;
        float mPostOnViewCreatedAlpha;
        Object mReenterTransition;
        Object mReturnTransition;
        Object mSharedElementEnterTransition;
        Object mSharedElementReturnTransition;
        ArrayList<String> mSharedElementSourceNames;
        ArrayList<String> mSharedElementTargetNames;

        public AnimationInfo() {
            this.mEnterTransition = null;
            Object r5 = Fragment.USE_DEFAULT_TRANSITION;
            this.mReturnTransition = r5;
            this.mExitTransition = null;
            this.mReenterTransition = r5;
            this.mSharedElementEnterTransition = null;
            this.mSharedElementReturnTransition = r5;
            this.mEnterTransitionCallback = null;
            this.mExitTransitionCallback = null;
            this.mPostOnViewCreatedAlpha = 1.0f;
            this.mFocusedView = null;
        }
    }

    @RequiresApi(19)
    public static class Api19Impl {
        private Api19Impl() {
        }

        public static void cancelPendingInputEvents(@NonNull View r5) {
            r5.cancelPendingInputEvents();
        }
    }

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(@NonNull String r5, @Nullable Exception r10) {
            super(r5, r10);
        }
    }

    public static abstract class OnPreAttachedListener {
        private OnPreAttachedListener() {
        }

        public abstract void onPreAttached();

        public /* synthetic */ OnPreAttachedListener(AnonymousClass1 r5) {
            this();
        }
    }

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements Parcelable {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        final Bundle mState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Bundle r5) {
            this.mState = r5;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r5, int r10) {
            r5.writeBundle(this.mState);
        }

        public SavedState(@NonNull Parcel r5, @Nullable ClassLoader r10) {
            Bundle r11 = r5.readBundle();
            this.mState = r11;
            if (r10 == null) goto L7;
            if (r11 == null) goto L8;
            r11.setClassLoader(r10);
            return;
        L8:
            return;
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
        this.mSavedStateAttachListener = new AnonymousClass2(this);
        initLifecycle();
    }

    public static /* synthetic */ void a(Fragment r5) {
        r5.lambda$performCreateView$0();
    }

    private AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo != null) goto L6;
        this.mAnimationInfo = new AnimationInfo();
    L6:
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        Lifecycle.State r5 = this.mMaxState;
        if (r5 == Lifecycle.State.INITIALIZED) goto L10;
        if (this.mParentFragment == null) goto L10;
        return Math.min(r5.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    L10:
        return r5.ordinal();
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener) == true) goto L6;
        registerOnPreAttachListener(this.mSavedStateAttachListener);
        return;
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context r5, @NonNull String r10) {
        return instantiate(r5, r10, null);
    }

    private /* synthetic */ void lambda$performCreateView$0() {
        this.mViewLifecycleOwner.performRestore(this.mSavedViewRegistryState);
        this.mSavedViewRegistryState = null;
    }

    @NonNull
    private <I, O> ActivityResultLauncher<I> prepareCallInternal(@NonNull final ActivityResultContract<I, O> r10, @NonNull final Function<Void, ActivityResultRegistry> r11, @NonNull final ActivityResultCallback<O> r12) {
        if (this.mState > 1) goto L7;
        final AtomicReference r5 = new AtomicReference();
        registerOnPreAttachListener(new AnonymousClass9(this, r11, r5, r10, r12));
        return new AnonymousClass10(this, r5, r10);
    L7:
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
    }

    private void registerOnPreAttachListener(@NonNull OnPreAttachedListener r5) {
        if (this.mState < 0) goto L5;
        r5.onPreAttached();
        return;
    L5:
        this.mOnPreAttachedListeners.add(r5);
    }

    public void callStartTransitionListener(boolean r5) {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 == null) goto L6;
        r10.mEnterTransitionPostponed = false;
    L6:
        if (this.mView == null) goto L19;
        ViewGroup r11 = this.mContainer;
        if (r11 == null) goto L20;
        FragmentManager r12 = this.mFragmentManager;
        if (r12 == null) goto L21;
        final SpecialEffectsController r13 = SpecialEffectsController.getOrCreateController(r11, r12);
        r13.markPostponedState();
        if (r5 == false) goto L14;
        this.mHost.getHandler().post(new AnonymousClass4(this, r13));
    L15:
        Handler r14 = this.mPostponedHandler;
        if (r14 == null) goto L22;
        r14.removeCallbacks(this.mPostponedDurationRunnable);
        this.mPostponedHandler = null;
        return;
    L22:
        return;
    L14:
        r13.executePendingOperations();
        goto L15
    L21:
        return;
    L20:
        return;
    }

    @NonNull
    public FragmentContainer createFragmentContainer() {
        return new AnonymousClass5(this);
    }

    public void dump(@NonNull String r5, @Nullable FileDescriptor r10, @NonNull PrintWriter r11, @Nullable String[] r12) {
        r11.print(r5);
        r11.print("mFragmentId=#");
        r11.print(Integer.toHexString(this.mFragmentId));
        r11.print(" mContainerId=#");
        r11.print(Integer.toHexString(this.mContainerId));
        r11.print(" mTag=");
        r11.println(this.mTag);
        r11.print(r5);
        r11.print("mState=");
        r11.print(this.mState);
        r11.print(" mWho=");
        r11.print(this.mWho);
        r11.print(" mBackStackNesting=");
        r11.println(this.mBackStackNesting);
        r11.print(r5);
        r11.print("mAdded=");
        r11.print(this.mAdded);
        r11.print(" mRemoving=");
        r11.print(this.mRemoving);
        r11.print(" mFromLayout=");
        r11.print(this.mFromLayout);
        r11.print(" mInLayout=");
        r11.println(this.mInLayout);
        r11.print(r5);
        r11.print("mHidden=");
        r11.print(this.mHidden);
        r11.print(" mDetached=");
        r11.print(this.mDetached);
        r11.print(" mMenuVisible=");
        r11.print(this.mMenuVisible);
        r11.print(" mHasMenu=");
        r11.println(this.mHasMenu);
        r11.print(r5);
        r11.print("mRetainInstance=");
        r11.print(this.mRetainInstance);
        r11.print(" mUserVisibleHint=");
        r11.println(this.mUserVisibleHint);
        if (this.mFragmentManager == null) goto L6;
        r11.print(r5);
        r11.print("mFragmentManager=");
        r11.println(this.mFragmentManager);
    L6:
        if (this.mHost == null) goto L9;
        r11.print(r5);
        r11.print("mHost=");
        r11.println(this.mHost);
    L9:
        if (this.mParentFragment == null) goto L12;
        r11.print(r5);
        r11.print("mParentFragment=");
        r11.println(this.mParentFragment);
    L12:
        if (this.mArguments == null) goto L15;
        r11.print(r5);
        r11.print("mArguments=");
        r11.println(this.mArguments);
    L15:
        if (this.mSavedFragmentState == null) goto L18;
        r11.print(r5);
        r11.print("mSavedFragmentState=");
        r11.println(this.mSavedFragmentState);
    L18:
        if (this.mSavedViewState == null) goto L21;
        r11.print(r5);
        r11.print("mSavedViewState=");
        r11.println(this.mSavedViewState);
    L21:
        if (this.mSavedViewRegistryState == null) goto L23;
        r11.print(r5);
        r11.print("mSavedViewRegistryState=");
        r11.println(this.mSavedViewRegistryState);
    L23:
        Fragment r13 = getTargetFragment(false);
        if (r13 == null) goto L26;
        r11.print(r5);
        r11.print("mTarget=");
        r11.print(r13);
        r11.print(" mTargetRequestCode=");
        r11.println(this.mTargetRequestCode);
    L26:
        r11.print(r5);
        r11.print("mPopDirection=");
        r11.println(getPopDirection());
        if (getEnterAnim() == 0) goto L30;
        r11.print(r5);
        r11.print("getEnterAnim=");
        r11.println(getEnterAnim());
    L30:
        if (getExitAnim() == 0) goto L33;
        r11.print(r5);
        r11.print("getExitAnim=");
        r11.println(getExitAnim());
    L33:
        if (getPopEnterAnim() == 0) goto L36;
        r11.print(r5);
        r11.print("getPopEnterAnim=");
        r11.println(getPopEnterAnim());
    L36:
        if (getPopExitAnim() == 0) goto L39;
        r11.print(r5);
        r11.print("getPopExitAnim=");
        r11.println(getPopExitAnim());
    L39:
        if (this.mContainer == null) goto L42;
        r11.print(r5);
        r11.print("mContainer=");
        r11.println(this.mContainer);
    L42:
        if (this.mView == null) goto L45;
        r11.print(r5);
        r11.print("mView=");
        r11.println(this.mView);
    L45:
        if (getAnimatingAway() == null) goto L48;
        r11.print(r5);
        r11.print("mAnimatingAway=");
        r11.println(getAnimatingAway());
    L48:
        if (getContext() == null) goto L50;
        LoaderManager.getInstance(this).dump(r5, r10, r11, r12);
    L50:
        r11.print(r5);
        r11.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.dump(j0.j(r5, "  "), r10, r11, r12);
    }

    public final boolean equals(@Nullable Object r5) {
        return super.equals(r5);
    }

    @Nullable
    public Fragment findFragmentByWho(@NonNull String r5) {
        if (r5.equals(this.mWho) == false) goto L6;
        return this;
    L6:
        return this.mChildFragmentManager.findFragmentByWho(r5);
    }

    @NonNull
    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    @Nullable
    public final FragmentActivity getActivity() {
        FragmentHostCallback<?> r5 = this.mHost;
        if (r5 != null) goto L6;
        return null;
    L6:
        return (FragmentActivity) r5.getActivity();
    }

    public boolean getAllowEnterTransitionOverlap() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 == null) goto L8;
        Boolean r10 = r5.mAllowEnterTransitionOverlap;
        if (r10 == null) goto L8;
        return r10.booleanValue();
    L8:
        return true;
    }

    public boolean getAllowReturnTransitionOverlap() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 == null) goto L8;
        Boolean r10 = r5.mAllowReturnTransitionOverlap;
        if (r10 == null) goto L8;
        return r10.booleanValue();
    L8:
        return true;
    }

    public View getAnimatingAway() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.mAnimatingAway;
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
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " has not been attached yet."));
    }

    @Nullable
    public Context getContext() {
        FragmentHostCallback<?> r5 = this.mHost;
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5.getContext();
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    @CallSuper
    public CreationExtras getDefaultViewModelCreationExtras() {
        Context r5 = requireContext().getApplicationContext();
    L4:
        if ((r5 instanceof ContextWrapper) == false) goto L9;
        if ((r5 instanceof Application) == true) goto L7;
        r5 = ((ContextWrapper) r5).getBaseContext();
        goto L4
    L7:
        Application r10 = (Application) r5;
    L10:
        if (r10 == null) goto L12;
    L14:
        MutableCreationExtras r11 = new MutableCreationExtras();
        if (r10 == null) goto L17;
        r11.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, r10);
    L17:
        r11.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        r11.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getArguments() == null) goto L20;
        r11.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getArguments());
    L20:
        return r11;
    L12:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L14;
        Log.d(FragmentManager.TAG, "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        goto L14
    L9:
        r10 = null;
        goto L10
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager == null) goto L22;
        if (this.mDefaultFactory != null) goto L20;
        Context r5 = requireContext().getApplicationContext();
    L8:
        if ((r5 instanceof ContextWrapper) == false) goto L13;
        if ((r5 instanceof Application) == true) goto L11;
        r5 = ((ContextWrapper) r5).getBaseContext();
        goto L8
    L11:
        Application r10 = (Application) r5;
    L14:
        if (r10 == null) goto L16;
    L18:
        this.mDefaultFactory = new SavedStateViewModelFactory(r10, this, getArguments());
        goto L20
    L16:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L18;
        Log.d(FragmentManager.TAG, "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
        goto L18
    L13:
        r10 = null;
    L20:
        return this.mDefaultFactory;
    L22:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    @AnimRes
    public int getEnterAnim() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.mEnterAnim;
    }

    @Nullable
    public Object getEnterTransition() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.mEnterTransition;
    }

    public SharedElementCallback getEnterTransitionCallback() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.mEnterTransitionCallback;
    }

    @AnimRes
    public int getExitAnim() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.mExitAnim;
    }

    @Nullable
    public Object getExitTransition() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.mExitTransition;
    }

    public SharedElementCallback getExitTransitionCallback() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.mExitTransitionCallback;
    }

    public View getFocusedView() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.mFocusedView;
    }

    @Nullable
    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    @Nullable
    public final Object getHost() {
        FragmentHostCallback<?> r5 = this.mHost;
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5.onGetHost();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    @NonNull
    public final LayoutInflater getLayoutInflater() {
        LayoutInflater r5 = this.mLayoutInflater;
        if (r5 == null) goto L5;
        return r5;
    L5:
        return performGetLayoutInflater(null);
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

    public int getNextTransition() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.mNextTransition;
    }

    @Nullable
    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    @NonNull
    public final FragmentManager getParentFragmentManager() {
        FragmentManager r5 = this.mFragmentManager;
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " not associated with a fragment manager."));
    }

    public boolean getPopDirection() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L7;
        return false;
    L7:
        return r5.mIsPop;
    }

    @AnimRes
    public int getPopEnterAnim() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.mPopEnterAnim;
    }

    @AnimRes
    public int getPopExitAnim() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.mPopExitAnim;
    }

    public float getPostOnViewCreatedAlpha() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L7;
        return 1.0f;
    L7:
        return r5.mPostOnViewCreatedAlpha;
    }

    @Nullable
    public Object getReenterTransition() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L6;
        return null;
    L6:
        Object r10 = r5.mReenterTransition;
        if (r10 == USE_DEFAULT_TRANSITION) goto L9;
        return r10;
    L9:
        return getExitTransition();
    }

    @NonNull
    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        FragmentStrictMode.onGetRetainInstanceUsage(this);
        return this.mRetainInstance;
    }

    @Nullable
    public Object getReturnTransition() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L6;
        return null;
    L6:
        Object r10 = r5.mReturnTransition;
        if (r10 == USE_DEFAULT_TRANSITION) goto L9;
        return r10;
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
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.mSharedElementEnterTransition;
    }

    @Nullable
    public Object getSharedElementReturnTransition() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L6;
        return null;
    L6:
        Object r10 = r5.mSharedElementReturnTransition;
        if (r10 == USE_DEFAULT_TRANSITION) goto L9;
        return r10;
    L9:
        return getSharedElementEnterTransition();
    }

    @NonNull
    public ArrayList<String> getSharedElementSourceNames() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 == null) goto L9;
        ArrayList<String> r10 = r5.mSharedElementSourceNames;
        if (r10 == null) goto L9;
        return r10;
    L9:
        return new ArrayList();
    }

    @NonNull
    public ArrayList<String> getSharedElementTargetNames() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 == null) goto L9;
        ArrayList<String> r10 = r5.mSharedElementTargetNames;
        if (r10 == null) goto L9;
        return r10;
    L9:
        return new ArrayList();
    }

    @NonNull
    public final String getString(@StringRes int r5) {
        return getResources().getString(r5);
    }

    @Nullable
    public final String getTag() {
        return this.mTag;
    }

    @Nullable
    @Deprecated
    public final Fragment getTargetFragment() {
        return getTargetFragment(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        FragmentStrictMode.onGetTargetFragmentRequestCodeUsage(this);
        return this.mTargetRequestCode;
    }

    @NonNull
    public final CharSequence getText(@StringRes int r5) {
        return getResources().getText(r5);
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
        FragmentViewLifecycleOwner r5 = this.mViewLifecycleOwner;
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.o("Can't access the Fragment View's LifecycleOwner for ", this, " when getView() is null i.e., before onCreateView() or after onDestroyView()"));
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

    public void initState() {
        initLifecycle();
        this.mPreviousWho = this.mWho;
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
        if (this.mHidden == true) goto L10;
        FragmentManager r5 = this.mFragmentManager;
        if (r5 != null) goto L7;
    L9:
        return false;
    L7:
        if (r5.isParentHidden(this.mParentFragment) == false) goto L9;
    L10:
        return true;
    }

    public final boolean isInBackStack() {
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
        FragmentManager r5 = this.mFragmentManager;
        if (r5 != null) goto L7;
    L8:
        return true;
    L7:
        if (r5.isParentMenuVisible(this.mParentFragment) == true) goto L8;
    L9:
        return false;
    }

    public boolean isPostponed() {
        AnimationInfo r5 = this.mAnimationInfo;
        if (r5 != null) goto L7;
        return false;
    L7:
        return r5.mEnterTransitionPostponed;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        if (this.mState < 7) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isStateSaved() {
        FragmentManager r5 = this.mFragmentManager;
        if (r5 != null) goto L7;
        return false;
    L7:
        return r5.isStateSaved();
    }

    public final boolean isVisible() {
        if (isAdded() == true) goto L5;
    L13:
        return false;
    L5:
        if (isHidden() == true) goto L13;
        View r5 = this.mView;
        if (r5 == null) goto L13;
        if (r5.getWindowToken() == null) goto L13;
        if (this.mView.getVisibility() != 0) goto L13;
        return true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onActivityCreated(@Nullable Bundle r5) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int r5, int r10, @Nullable Intent r11) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
        Log.v(FragmentManager.TAG, "Fragment " + this + " received the following in onActivityResult(): requestCode: " + r5 + " resultCode: " + r10 + " data: " + r11);
        return;
    }

    @CallSuper
    @MainThread
    public void onAttach(@NonNull Context r5) {
        this.mCalled = true;
        FragmentHostCallback<?> r10 = this.mHost;
        if (r10 != null) goto L5;
        Activity r11 = null;
    L6:
        if (r11 == null) goto L9;
        this.mCalled = false;
        onAttach(r11);
        return;
    L9:
        return;
    L5:
        r11 = r10.getActivity();
        goto L6
    }

    @MainThread
    @Deprecated
    public void onAttachFragment(@NonNull Fragment r5) {
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration r5) {
        this.mCalled = true;
    }

    @MainThread
    public boolean onContextItemSelected(@NonNull MenuItem r5) {
        return false;
    }

    @CallSuper
    @MainThread
    public void onCreate(@Nullable Bundle r5) {
        this.mCalled = true;
        restoreChildFragmentState();
        if (this.mChildFragmentManager.isStateAtLeast(1) == true) goto L6;
        this.mChildFragmentManager.dispatchCreate();
        return;
    }

    @Nullable
    @MainThread
    public Animation onCreateAnimation(int r5, boolean r10, int r11) {
        return null;
    }

    @Nullable
    @MainThread
    public Animator onCreateAnimator(int r5, boolean r10, int r11) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    @MainThread
    public void onCreateContextMenu(@NonNull ContextMenu r5, @NonNull View r10, @Nullable ContextMenu.ContextMenuInfo r11) {
        requireActivity().onCreateContextMenu(r5, r10, r11);
    }

    @MainThread
    @Deprecated
    public void onCreateOptionsMenu(@NonNull Menu r5, @NonNull MenuInflater r10) {
    }

    @Nullable
    @MainThread
    public View onCreateView(@NonNull LayoutInflater r5, @Nullable ViewGroup r10, @Nullable Bundle r11) {
        int r12 = this.mContentLayoutId;
        if (r12 != 0) goto L5;
        return null;
    L5:
        return r5.inflate(r12, r10, false);
    }

    @CallSuper
    @MainThread
    public void onDestroy() {
        this.mCalled = true;
    }

    @MainThread
    @Deprecated
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
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle r5) {
        return getLayoutInflater(r5);
    }

    @MainThread
    public void onHiddenChanged(boolean r5) {
    }

    @CallSuper
    @UiThread
    public void onInflate(@NonNull Context r5, @NonNull AttributeSet r10, @Nullable Bundle r11) {
        this.mCalled = true;
        FragmentHostCallback<?> r12 = this.mHost;
        if (r12 != null) goto L5;
        Activity r13 = null;
    L6:
        if (r13 == null) goto L9;
        this.mCalled = false;
        onInflate(r13, r10, r11);
        return;
    L9:
        return;
    L5:
        r13 = r12.getActivity();
        goto L6
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    @MainThread
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean r5) {
    }

    @MainThread
    @Deprecated
    public boolean onOptionsItemSelected(@NonNull MenuItem r5) {
        return false;
    }

    @MainThread
    @Deprecated
    public void onOptionsMenuClosed(@NonNull Menu r5) {
    }

    @CallSuper
    @MainThread
    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean r5) {
    }

    @MainThread
    @Deprecated
    public void onPrepareOptionsMenu(@NonNull Menu r5) {
    }

    @MainThread
    public void onPrimaryNavigationFragmentChanged(boolean r5) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int r5, @NonNull String[] r10, @NonNull int[] r11) {
    }

    @CallSuper
    @MainThread
    public void onResume() {
        this.mCalled = true;
    }

    @MainThread
    public void onSaveInstanceState(@NonNull Bundle r5) {
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
    public void onViewCreated(@NonNull View r5, @Nullable Bundle r10) {
    }

    @CallSuper
    @MainThread
    public void onViewStateRestored(@Nullable Bundle r5) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle r5) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(r5);
        if (this.mCalled == false) goto L7;
        restoreViewState();
        this.mChildFragmentManager.dispatchActivityCreated();
        return;
    L7:
        throw new SuperNotCalledException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " did not call through to super.onActivityCreated()"));
    }

    public void performAttach() {
        Iterator<OnPreAttachedListener> r5 = this.mOnPreAttachedListeners.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().onPreAttached();
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
        throw new SuperNotCalledException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " did not call through to super.onAttach()"));
    }

    public void performConfigurationChanged(@NonNull Configuration r5) {
        onConfigurationChanged(r5);
    }

    public boolean performContextItemSelected(@NonNull MenuItem r5) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (onContextItemSelected(r5) == false) goto L9;
        return true;
    L9:
        return this.mChildFragmentManager.dispatchContextItemSelected(r5);
    }

    public void performCreate(Bundle r5) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.addObserver(new AnonymousClass6(this));
        onCreate(r5);
        this.mIsCreated = true;
        if (this.mCalled == false) goto L7;
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L7:
        throw new SuperNotCalledException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " did not call through to super.onCreate()"));
    }

    public boolean performCreateOptionsMenu(@NonNull Menu r5, @NonNull MenuInflater r10) {
        boolean r11 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        onCreateOptionsMenu(r5, r10);
        r11 = true;
    L10:
        return r11 | this.mChildFragmentManager.dispatchCreateOptionsMenu(r5, r10);
    }

    public void performCreateView(@NonNull LayoutInflater r5, @Nullable ViewGroup r10, @Nullable Bundle r11) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new FragmentViewLifecycleOwner(this, getViewModelStore(), new d(this, 1));
        View r12 = onCreateView(r5, r10, r11);
        this.mView = r12;
        if (r12 == null) goto L9;
        this.mViewLifecycleOwner.initialize();
        if (FragmentManager.isLoggingEnabled(3) == false) goto L7;
        Log.d(FragmentManager.TAG, "Setting ViewLifecycleOwner on View " + this.mView + " for Fragment " + this);
    L7:
        ViewTreeLifecycleOwner.set(this.mView, this.mViewLifecycleOwner);
        ViewTreeViewModelStoreOwner.set(this.mView, this.mViewLifecycleOwner);
        ViewTreeSavedStateRegistryOwner.set(this.mView, this.mViewLifecycleOwner);
        this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
        return;
    L9:
        if (this.mViewLifecycleOwner.isInitialized() == true) goto L13;
        this.mViewLifecycleOwner = null;
        return;
    L13:
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    public void performDestroy() {
        this.mChildFragmentManager.dispatchDestroy();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled == false) goto L6;
        return;
    L6:
        throw new SuperNotCalledException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " did not call through to super.onDestroy()"));
    }

    public void performDestroyView() {
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
        throw new SuperNotCalledException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " did not call through to super.onDestroyView()"));
    L5:
        if (this.mViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        goto L7
    }

    public void performDetach() {
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
        throw new SuperNotCalledException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " did not call through to super.onDetach()"));
    }

    @NonNull
    public LayoutInflater performGetLayoutInflater(@Nullable Bundle r5) {
        LayoutInflater r10 = onGetLayoutInflater(r5);
        this.mLayoutInflater = r10;
        return r10;
    }

    public void performLowMemory() {
        onLowMemory();
    }

    public void performMultiWindowModeChanged(boolean r5) {
        onMultiWindowModeChanged(r5);
    }

    public boolean performOptionsItemSelected(@NonNull MenuItem r5) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L13;
        if (this.mMenuVisible == false) goto L13;
        if (onOptionsItemSelected(r5) == false) goto L13;
        return true;
    L13:
        return this.mChildFragmentManager.dispatchOptionsItemSelected(r5);
    }

    public void performOptionsMenuClosed(@NonNull Menu r5) {
        if (this.mHidden == false) goto L5;
        return;
    L5:
        if (this.mHasMenu == true) goto L7;
    L9:
        this.mChildFragmentManager.dispatchOptionsMenuClosed(r5);
        return;
    L7:
        if (this.mMenuVisible == false) goto L9;
        onOptionsMenuClosed(r5);
        goto L9
    }

    public void performPause() {
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
        throw new SuperNotCalledException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " did not call through to super.onPause()"));
    }

    public void performPictureInPictureModeChanged(boolean r5) {
        onPictureInPictureModeChanged(r5);
    }

    public boolean performPrepareOptionsMenu(@NonNull Menu r5) {
        boolean r10 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        onPrepareOptionsMenu(r5);
        r10 = true;
    L10:
        return r10 | this.mChildFragmentManager.dispatchPrepareOptionsMenu(r5);
    }

    public void performPrimaryNavigationFragmentChanged() {
        boolean r5 = this.mFragmentManager.isPrimaryNavigation(this);
        Boolean r10 = this.mIsPrimaryNavigationFragment;
        if (r10 != null) goto L5;
    L6:
        this.mIsPrimaryNavigationFragment = Boolean.valueOf(r5);
        onPrimaryNavigationFragmentChanged(r5);
        this.mChildFragmentManager.dispatchPrimaryNavigationFragmentChanged();
        return;
    L5:
        if (r10.booleanValue() != r5) goto L6;
    }

    public void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (this.mCalled == false) goto L10;
        LifecycleRegistry r5 = this.mLifecycleRegistry;
        Lifecycle.Event r10 = Lifecycle.Event.ON_RESUME;
        r5.handleLifecycleEvent(r10);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(r10);
    L7:
        this.mChildFragmentManager.dispatchResume();
        return;
    L10:
        throw new SuperNotCalledException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " did not call through to super.onResume()"));
    }

    public void performSaveInstanceState(Bundle r5) {
        onSaveInstanceState(r5);
    }

    public void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (this.mCalled == false) goto L10;
        LifecycleRegistry r5 = this.mLifecycleRegistry;
        Lifecycle.Event r10 = Lifecycle.Event.ON_START;
        r5.handleLifecycleEvent(r10);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(r10);
    L7:
        this.mChildFragmentManager.dispatchStart();
        return;
    L10:
        throw new SuperNotCalledException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " did not call through to super.onStart()"));
    }

    public void performStop() {
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
        throw new SuperNotCalledException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " did not call through to super.onStop()"));
    }

    public void performViewCreated() {
        Bundle r5 = this.mSavedFragmentState;
        if (r5 == null) goto L5;
        Bundle r10 = r5.getBundle("savedInstanceState");
    L6:
        onViewCreated(this.mView, r10);
        this.mChildFragmentManager.dispatchViewCreated();
        return;
    L5:
        r10 = null;
        goto L6
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    @MainThread
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> r5, @NonNull ActivityResultCallback<O> r10) {
        return prepareCallInternal(r5, new AnonymousClass7(this), r10);
    }

    public void registerForContextMenu(@NonNull View r5) {
        r5.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(@NonNull String[] r5, int r10) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().launchRequestPermissions(this, r5, r10);
        return;
    L7:
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " not attached to Activity"));
    }

    @NonNull
    public final FragmentActivity requireActivity() {
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " not attached to an activity."));
    }

    @NonNull
    public final Bundle requireArguments() {
        Bundle r5 = getArguments();
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " does not have any arguments."));
    }

    @NonNull
    public final Context requireContext() {
        Context r5 = getContext();
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " not attached to a context."));
    }

    @NonNull
    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    @NonNull
    public final Object requireHost() {
        Object r5 = getHost();
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " not attached to a host."));
    }

    @NonNull
    public final Fragment requireParentFragment() {
        Fragment r5 = getParentFragment();
        if (r5 == null) goto L5;
        return r5;
    L5:
        if (getContext() != null) goto L9;
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " is not attached to any Fragment or host"));
    L9:
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    @NonNull
    public final View requireView() {
        View r5 = getView();
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState() {
        Bundle r5 = this.mSavedFragmentState;
        if (r5 == null) goto L8;
        Bundle r10 = r5.getBundle("childFragmentManager");
        if (r10 == null) goto L9;
        this.mChildFragmentManager.restoreSaveStateInternal(r10);
        this.mChildFragmentManager.dispatchCreate();
        return;
    L9:
        return;
    }

    public final void restoreViewState(Bundle r5) {
        SparseArray<Parcelable> r10 = this.mSavedViewState;
        if (r10 == null) goto L5;
        this.mView.restoreHierarchyState(r10);
        this.mSavedViewState = null;
    L5:
        this.mCalled = false;
        onViewStateRestored(r5);
        if (this.mCalled == false) goto L12;
        if (this.mView == null) goto L13;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L13:
        return;
    L12:
        throw new SuperNotCalledException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " did not call through to super.onViewStateRestored()"));
    }

    public void setAllowEnterTransitionOverlap(boolean r5) {
        AnimationInfo r10 = ensureAnimationInfo();
        r10.mAllowEnterTransitionOverlap = Boolean.valueOf(r5);
    }

    public void setAllowReturnTransitionOverlap(boolean r5) {
        AnimationInfo r10 = ensureAnimationInfo();
        r10.mAllowReturnTransitionOverlap = Boolean.valueOf(r5);
    }

    public void setAnimations(@AnimRes int r5, @AnimRes int r10, @AnimRes int r11, @AnimRes int r12) {
        if (this.mAnimationInfo != null) goto L9;
        if (r5 != 0) goto L9;
        if (r10 != 0) goto L9;
        if (r11 != 0) goto L9;
        if (r12 != 0) goto L9;
        return;
    L9:
        ensureAnimationInfo().mEnterAnim = r5;
        ensureAnimationInfo().mExitAnim = r10;
        ensureAnimationInfo().mPopEnterAnim = r11;
        ensureAnimationInfo().mPopExitAnim = r12;
    }

    public void setArguments(@Nullable Bundle r5) {
        if (this.mFragmentManager != null) goto L5;
    L9:
        this.mArguments = r5;
        return;
    L5:
        if (isStateSaved() == false) goto L9;
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback r5) {
        ensureAnimationInfo().mEnterTransitionCallback = r5;
    }

    public void setEnterTransition(@Nullable Object r5) {
        ensureAnimationInfo().mEnterTransition = r5;
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback r5) {
        ensureAnimationInfo().mExitTransitionCallback = r5;
    }

    public void setExitTransition(@Nullable Object r5) {
        ensureAnimationInfo().mExitTransition = r5;
    }

    public void setFocusedView(View r5) {
        ensureAnimationInfo().mFocusedView = r5;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean r5) {
        if (this.mHasMenu == r5) goto L10;
        this.mHasMenu = r5;
        if (isAdded() == true) goto L7;
        return;
    L7:
        if (isHidden() == true) goto L12;
        this.mHost.onSupportInvalidateOptionsMenu();
        return;
    L12:
        return;
    }

    public void setInitialSavedState(@Nullable SavedState r5) {
        if (this.mFragmentManager != null) goto L12;
        if (r5 == null) goto L8;
        Bundle r10 = r5.mState;
        if (r10 == null) goto L8;
    L9:
        this.mSavedFragmentState = r10;
        return;
    L8:
        r10 = null;
        goto L9
    L12:
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean r5) {
        if (this.mMenuVisible == r5) goto L12;
        this.mMenuVisible = r5;
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

    public void setNextTransition(int r5) {
        if (this.mAnimationInfo != null) goto L6;
        if (r5 != 0) goto L6;
        return;
    L6:
        ensureAnimationInfo();
        this.mAnimationInfo.mNextTransition = r5;
    }

    public void setPopDirection(boolean r5) {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        ensureAnimationInfo().mIsPop = r5;
    }

    public void setPostOnViewCreatedAlpha(float r5) {
        ensureAnimationInfo().mPostOnViewCreatedAlpha = r5;
    }

    public void setReenterTransition(@Nullable Object r5) {
        ensureAnimationInfo().mReenterTransition = r5;
    }

    @Deprecated
    public void setRetainInstance(boolean r5) {
        FragmentStrictMode.onSetRetainInstanceUsage(this);
        this.mRetainInstance = r5;
        FragmentManager r10 = this.mFragmentManager;
        if (r10 == null) goto L7;
        if (r5 == false) goto L6;
        r10.addRetainedFragment(this);
        return;
    L6:
        r10.removeRetainedFragment(this);
        return;
    L7:
        this.mRetainInstanceChangedWhileDetached = true;
    }

    public void setReturnTransition(@Nullable Object r5) {
        ensureAnimationInfo().mReturnTransition = r5;
    }

    public void setSharedElementEnterTransition(@Nullable Object r5) {
        ensureAnimationInfo().mSharedElementEnterTransition = r5;
    }

    public void setSharedElementNames(@Nullable ArrayList<String> r5, @Nullable ArrayList<String> r10) {
        ensureAnimationInfo();
        AnimationInfo r11 = this.mAnimationInfo;
        r11.mSharedElementSourceNames = r5;
        r11.mSharedElementTargetNames = r10;
    }

    public void setSharedElementReturnTransition(@Nullable Object r5) {
        ensureAnimationInfo().mSharedElementReturnTransition = r5;
    }

    @Deprecated
    public void setTargetFragment(@Nullable Fragment r5, int r10) {
        if (r5 == null) goto L4;
        FragmentStrictMode.onSetTargetFragmentUsage(this, r5, r10);
    L4:
        FragmentManager r11 = this.mFragmentManager;
        if (r5 == null) goto L7;
        FragmentManager r12 = r5.mFragmentManager;
    L8:
        if (r11 == null) goto L14;
        if (r12 == null) goto L14;
        if (r11 == r12) goto L14;
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.o("Fragment ", r5, " must share the same FragmentManager to be set as a target fragment"));
    L14:
        Fragment r13 = r5;
    L15:
        if (r13 == null) goto L21;
        if (r13.equals(this) == true) goto L20;
        r13 = r13.getTargetFragment(false);
        goto L15
    L20:
        throw new IllegalArgumentException("Setting " + r5 + " as the target of " + this + " would create a target cycle");
    L21:
        if (r5 != null) goto L24;
        this.mTargetWho = null;
        this.mTarget = null;
    L29:
        this.mTargetRequestCode = r10;
        return;
    L24:
        if (this.mFragmentManager != null) goto L26;
    L28:
        this.mTargetWho = null;
        this.mTarget = r5;
        goto L29
    L26:
        if (r5.mFragmentManager == null) goto L28;
        this.mTargetWho = r5.mWho;
        this.mTarget = null;
        goto L29
    L7:
        r12 = null;
        goto L8
    }

    @Deprecated
    public void setUserVisibleHint(boolean r5) {
        FragmentStrictMode.onSetUserVisibleHint(this, r5);
        if (this.mUserVisibleHint == true) goto L14;
        if (r5 == false) goto L14;
        if (this.mState >= 5) goto L14;
        if (this.mFragmentManager == null) goto L14;
        if (isAdded() == false) goto L14;
        if (this.mIsCreated == false) goto L14;
        FragmentManager r10 = this.mFragmentManager;
        r10.performPendingDeferredStart(r10.createOrGetFragmentStateManager(this));
    L14:
        this.mUserVisibleHint = r5;
        if (this.mState >= 5) goto L18;
        if (r5 == true) goto L18;
        boolean r11 = true;
    L19:
        this.mDeferStart = r11;
        if (this.mSavedFragmentState == null) goto L23;
        this.mSavedUserVisibleHint = Boolean.valueOf(r5);
        return;
    L23:
        return;
    L18:
        r11 = false;
        goto L19
    }

    public boolean shouldShowRequestPermissionRationale(@NonNull String r5) {
        FragmentHostCallback<?> r10 = this.mHost;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.onShouldShowRequestPermissionRationale(r5);
    }

    public void startActivity(@NonNull Intent r5) {
        startActivity(r5, null);
    }

    @Deprecated
    public void startActivityForResult(@NonNull Intent r5, int r10) {
        startActivityForResult(r5, r10, null);
    }

    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender r10, int r11, @Nullable Intent r12, int r13, int r14, int r15, @Nullable Bundle r16) throws IntentSender.SendIntentException {
        if (this.mHost == null) goto L11;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
        Log.v(FragmentManager.TAG, "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + r11 + " IntentSender: " + r10 + " fillInIntent: " + r12 + " options: " + r16);
    L8:
        getParentFragmentManager().launchStartIntentSenderForResult(this, r10, r11, r12, r13, r14, r15, r16);
        return;
    L11:
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " not attached to Activity"));
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
        this.mHost.getHandler().postAtFrontOfQueue(new AnonymousClass3(this));
        return;
    L13:
        callStartTransitionListener(true);
    }

    @NonNull
    public String toString() {
        StringBuilder r5 = new StringBuilder(128);
        r5.append(getClass().getSimpleName());
        r5.append("{");
        r5.append(Integer.toHexString(System.identityHashCode(this)));
        r5.append("} (");
        r5.append(this.mWho);
        if (this.mFragmentId == 0) goto L6;
        r5.append(" id=0x");
        r5.append(Integer.toHexString(this.mFragmentId));
    L6:
        if (this.mTag == null) goto L8;
        r5.append(" tag=");
        r5.append(this.mTag);
    L8:
        r5.append(")");
        return r5.toString();
    }

    public void unregisterForContextMenu(@NonNull View r5) {
        r5.setOnCreateContextMenuListener(null);
    }

    @Nullable
    private Fragment getTargetFragment(boolean r5) {
        if (r5 == false) goto L4;
        FragmentStrictMode.onGetTargetFragmentUsage(this);
    L4:
        Fragment r10 = this.mTarget;
        if (r10 == null) goto L7;
        return r10;
    L7:
        FragmentManager r11 = this.mFragmentManager;
        if (r11 == null) goto L13;
        String r12 = this.mTargetWho;
        if (r12 != null) goto L12;
        return null;
    L12:
        return r11.findActiveFragment(r12);
    L13:
        return null;
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context r5, @NonNull String r10, @Nullable Bundle r11) {
        Fragment r12 = FragmentFactory.loadFragmentClass(r5.getClassLoader(), r10).getConstructor(null).newInstance(null);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L9 IllegalAccessException -> L11 java.lang.InstantiationException -> L13
        if (r11 == null) goto L15;
        r11.setClassLoader(r12.getClass().getClassLoader());     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L9 IllegalAccessException -> L11 java.lang.InstantiationException -> L13
        r12.setArguments(r11);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L9 IllegalAccessException -> L11 java.lang.InstantiationException -> L13
    L15:
        return r12;
    L11:
        e = move-exception;
        throw new InstantiationException(j0.k("Unable to instantiate fragment ", r10, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
    L13:
        e = move-exception;
        throw new InstantiationException(j0.k("Unable to instantiate fragment ", r10, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
    L9:
        e = move-exception;
        throw new InstantiationException(j0.k("Unable to instantiate fragment ", r10, ": could not find Fragment constructor"), e);
    L7:
        e = move-exception;
        throw new InstantiationException(j0.k("Unable to instantiate fragment ", r10, ": calling Fragment constructor caused an exception"), e);
    }

    @NonNull
    public final String getString(@StringRes int r5, @Nullable Object... r10) {
        return getResources().getString(r5, r10);
    }

    public final void postponeEnterTransition(long r5, @NonNull TimeUnit r10) {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
        Handler r11 = this.mPostponedHandler;
        if (r11 == null) goto L5;
        r11.removeCallbacks(this.mPostponedDurationRunnable);
    L5:
        FragmentManager r12 = this.mFragmentManager;
        if (r12 == null) goto L8;
        this.mPostponedHandler = r12.getHost().getHandler();
    L9:
        this.mPostponedHandler.removeCallbacks(this.mPostponedDurationRunnable);
        this.mPostponedHandler.postDelayed(this.mPostponedDurationRunnable, r10.toMillis(r5));
        return;
    L8:
        this.mPostponedHandler = new Handler(Looper.getMainLooper());
        goto L9
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    @MainThread
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> r5, @NonNull final ActivityResultRegistry r10, @NonNull ActivityResultCallback<O> r11) {
        return prepareCallInternal(r5, new AnonymousClass8(this, r10), r11);
    }

    public void startActivity(@NonNull Intent r5, @Nullable Bundle r10) {
        FragmentHostCallback<?> r11 = this.mHost;
        if (r11 == null) goto L7;
        r11.onStartActivityFromFragment(this, r5, -1, r10);
        return;
    L7:
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " not attached to Activity"));
    }

    @Deprecated
    public void startActivityForResult(@NonNull Intent r5, int r10, @Nullable Bundle r11) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().launchStartActivityForResult(this, r5, r10, r11);
        return;
    L7:
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.o("Fragment ", this, " not attached to Activity"));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public LayoutInflater getLayoutInflater(@Nullable Bundle r5) {
        FragmentHostCallback<?> r10 = this.mHost;
        if (r10 == null) goto L7;
        LayoutInflater r11 = r10.onGetLayoutInflater();
        LayoutInflaterCompat.setFactory2(r11, this.mChildFragmentManager.getLayoutInflaterFactory());
        return r11;
    L7:
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onAttach(@NonNull Activity r5) {
        this.mCalled = true;
    }

    @CallSuper
    @UiThread
    @Deprecated
    public void onInflate(@NonNull Activity r5, @NonNull AttributeSet r10, @Nullable Bundle r11) {
        this.mCalled = true;
    }

    @ContentView
    public Fragment(@LayoutRes int r5) {
        this();
        this.mContentLayoutId = r5;
    }

    private void restoreViewState() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        Log.d(FragmentManager.TAG, "moveto RESTORE_VIEW_STATE: " + this);
    L6:
        if (this.mView == null) goto L12;
        Bundle r5 = this.mSavedFragmentState;
        if (r5 == null) goto L10;
        Bundle r10 = r5.getBundle("savedInstanceState");
    L11:
        restoreViewState(r10);
        goto L12
    L10:
        r10 = null;
    L12:
        this.mSavedFragmentState = null;
    }
}
