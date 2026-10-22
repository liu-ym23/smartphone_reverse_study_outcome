package androidx.fragment.app;

import android.animation.Animator;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, ActivityResultCaller, HasDefaultViewModelProviderFactory, LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner {
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
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
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
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    private final OnPreAttachedListener mSavedStateAttachListener;
    SavedStateRegistryController mSavedStateRegistryController;
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
    FragmentViewLifecycleOwner mViewLifecycleOwner;
    MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData;
    String mWho;

    static class AnimationInfo {
        Boolean mAllowEnterTransitionOverlap;
        Boolean mAllowReturnTransitionOverlap;
        View mAnimatingAway;
        int mEnterAnim;
        Object mEnterTransition;
        SharedElementCallback mEnterTransitionCallback;
        boolean mEnterTransitionPostponed;
        int mExitAnim;
        Object mExitTransition;
        SharedElementCallback mExitTransitionCallback;
        View mFocusedView;
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

        AnimationInfo() {
            this.mEnterTransition = null;
            this.mReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
            this.mExitTransition = null;
            this.mReenterTransition = Fragment.USE_DEFAULT_TRANSITION;
            this.mSharedElementEnterTransition = null;
            this.mSharedElementReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
            this.mEnterTransitionCallback = null;
            this.mExitTransitionCallback = null;
            this.mPostOnViewCreatedAlpha = 1.0f;
            this.mFocusedView = null;
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static void cancelPendingInputEvents(View r0) {
            r0.cancelPendingInputEvents();
        }
    }

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String r1, Exception r2) {
            super(r1, r2);
        }
    }

    private static abstract class OnPreAttachedListener {
        private OnPreAttachedListener() {
        }

        /* synthetic */ OnPreAttachedListener(AnonymousClass1 r1) {
            this();
        }

        abstract void onPreAttached();
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        final Bundle mState;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Bundle r1) {
            this.mState = r1;
        }

        SavedState(Parcel r1, ClassLoader r2) {
            Bundle r3 = r1.readBundle();
            this.mState = r3;
            if (r2 == null) goto L7;
            if (r3 == null) goto L8;
            r3.setClassLoader(r2);
            return;
        L8:
            return;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeBundle(this.mState);
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

    public Fragment(int r1) {
        this();
        this.mContentLayoutId = r1;
    }

    private AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo != null) goto L6;
        this.mAnimationInfo = new AnimationInfo();
    L6:
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        if (this.mMaxState == Lifecycle.State.INITIALIZED) goto L10;
        if (this.mParentFragment == null) goto L10;
        return Math.min(this.mMaxState.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    L10:
        return this.mMaxState.ordinal();
    }

    private Fragment getTargetFragment(boolean r1) {
        if (r1 == false) goto L4;
        FragmentStrictMode.onGetTargetFragmentUsage(this);
    L4:
        Fragment r2 = this.mTarget;
        if (r2 == null) goto L7;
        return r2;
    L7:
        FragmentManager r3 = this.mFragmentManager;
        if (r3 == null) goto L13;
        String r0 = this.mTargetWho;
        if (r0 != null) goto L12;
        return null;
    L12:
        return r3.findActiveFragment(r0);
    L13:
        return null;
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener) == true) goto L6;
        registerOnPreAttachListener(this.mSavedStateAttachListener);
        return;
    }

    @Deprecated
    public static Fragment instantiate(Context r2, String r3) {
        return instantiate((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, null);
    }

    @Deprecated
    public static Fragment instantiate(Context r5, String r6, Bundle r7) {
        Fragment r8 = (Fragment) ZeusTransformUtils.preCheckCast(FragmentFactory.loadFragmentClass(((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin")).getClassLoader(), r6).getConstructor(new Class[0]).newInstance(new Object[0]), Fragment.class, "com.obric.memorydata.plugin");     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 java.lang.InstantiationException -> L16
        if (r7 == null) goto L6;
        r7.setClassLoader(r8.getClass().getClassLoader());     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 java.lang.InstantiationException -> L16
        r8.setArguments(r7);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 java.lang.InstantiationException -> L16
    L6:
        return r8;
    L13:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r6 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L16:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r6 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L10:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r6 + ": could not find Fragment constructor", e);
    L7:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r6 + ": calling Fragment constructor caused an exception", e);
    }

    private <I, O> ActivityResultLauncher<I> prepareCallInternal(final ActivityResultContract<I, O> r9, Function<Void, ActivityResultRegistry> r10, ActivityResultCallback<O> r11) {
        final Function r4 = (Function) ZeusTransformUtils.wrapperContextForParams(r10, Function.class, "com.obric.memorydata.plugin");
        final ActivityResultCallback r7 = (ActivityResultCallback) ZeusTransformUtils.wrapperContextForParams(r11, ActivityResultCallback.class, "com.obric.memorydata.plugin");
        if (this.mState > 1) goto L7;
        final AtomicReference r12 = new AtomicReference();
        registerOnPreAttachListener(new AnonymousClass9(this, r4, r12, r9, r7));
        return new AnonymousClass10(this, r12, r9);
    L7:
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void registerOnPreAttachListener(OnPreAttachedListener r2) {
        if (this.mState < 0) goto L5;
        r2.onPreAttached();
        return;
    L5:
        this.mOnPreAttachedListeners.add(r2);
    }

    private void restoreViewState() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        Log.d(FragmentManager.TAG, "moveto RESTORE_VIEW_STATE: " + this);
    L6:
        if (this.mView == null) goto L8;
        restoreViewState(this.mSavedFragmentState);
    L8:
        this.mSavedFragmentState = null;
    }

    void callStartTransitionListener(boolean r3) {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 == null) goto L6;
        r0.mEnterTransitionPostponed = false;
    L6:
        if (this.mView == null) goto L16;
        ViewGroup r1 = this.mContainer;
        if (r1 == null) goto L17;
        FragmentManager r2 = this.mFragmentManager;
        if (r2 == null) goto L18;
        final SpecialEffectsController r4 = SpecialEffectsController.getOrCreateController(r1, r2);
        r4.markPostponedState();
        if (r3 == false) goto L14;
        this.mHost.getHandler().post(new AnonymousClass4(this, r4));
        return;
    L14:
        r4.executePendingOperations();
        return;
    L18:
        return;
    L17:
        return;
    }

    FragmentContainer createFragmentContainer() {
        return new AnonymousClass5(this);
    }

    public void dump(String r4, FileDescriptor r5, PrintWriter r6, String[] r7) {
        r6.print(r4);
        r6.print("mFragmentId=#");
        r6.print(Integer.toHexString(this.mFragmentId));
        r6.print(" mContainerId=#");
        r6.print(Integer.toHexString(this.mContainerId));
        r6.print(" mTag=");
        r6.println(this.mTag);
        r6.print(r4);
        r6.print("mState=");
        r6.print(this.mState);
        r6.print(" mWho=");
        r6.print(this.mWho);
        r6.print(" mBackStackNesting=");
        r6.println(this.mBackStackNesting);
        r6.print(r4);
        r6.print("mAdded=");
        r6.print(this.mAdded);
        r6.print(" mRemoving=");
        r6.print(this.mRemoving);
        r6.print(" mFromLayout=");
        r6.print(this.mFromLayout);
        r6.print(" mInLayout=");
        r6.println(this.mInLayout);
        r6.print(r4);
        r6.print("mHidden=");
        r6.print(this.mHidden);
        r6.print(" mDetached=");
        r6.print(this.mDetached);
        r6.print(" mMenuVisible=");
        r6.print(this.mMenuVisible);
        r6.print(" mHasMenu=");
        r6.println(this.mHasMenu);
        r6.print(r4);
        r6.print("mRetainInstance=");
        r6.print(this.mRetainInstance);
        r6.print(" mUserVisibleHint=");
        r6.println(this.mUserVisibleHint);
        if (this.mFragmentManager == null) goto L6;
        r6.print(r4);
        r6.print("mFragmentManager=");
        r6.println(this.mFragmentManager);
    L6:
        if (this.mHost == null) goto L9;
        r6.print(r4);
        r6.print("mHost=");
        r6.println(this.mHost);
    L9:
        if (this.mParentFragment == null) goto L12;
        r6.print(r4);
        r6.print("mParentFragment=");
        r6.println(this.mParentFragment);
    L12:
        if (this.mArguments == null) goto L15;
        r6.print(r4);
        r6.print("mArguments=");
        r6.println(this.mArguments);
    L15:
        if (this.mSavedFragmentState == null) goto L18;
        r6.print(r4);
        r6.print("mSavedFragmentState=");
        r6.println(this.mSavedFragmentState);
    L18:
        if (this.mSavedViewState == null) goto L21;
        r6.print(r4);
        r6.print("mSavedViewState=");
        r6.println(this.mSavedViewState);
    L21:
        if (this.mSavedViewRegistryState == null) goto L23;
        r6.print(r4);
        r6.print("mSavedViewRegistryState=");
        r6.println(this.mSavedViewRegistryState);
    L23:
        Fragment r0 = getTargetFragment(false);
        if (r0 == null) goto L26;
        r6.print(r4);
        r6.print("mTarget=");
        r6.print(r0);
        r6.print(" mTargetRequestCode=");
        r6.println(this.mTargetRequestCode);
    L26:
        r6.print(r4);
        r6.print("mPopDirection=");
        r6.println(getPopDirection());
        if (getEnterAnim() == 0) goto L30;
        r6.print(r4);
        r6.print("getEnterAnim=");
        r6.println(getEnterAnim());
    L30:
        if (getExitAnim() == 0) goto L33;
        r6.print(r4);
        r6.print("getExitAnim=");
        r6.println(getExitAnim());
    L33:
        if (getPopEnterAnim() == 0) goto L36;
        r6.print(r4);
        r6.print("getPopEnterAnim=");
        r6.println(getPopEnterAnim());
    L36:
        if (getPopExitAnim() == 0) goto L39;
        r6.print(r4);
        r6.print("getPopExitAnim=");
        r6.println(getPopExitAnim());
    L39:
        if (this.mContainer == null) goto L42;
        r6.print(r4);
        r6.print("mContainer=");
        r6.println(this.mContainer);
    L42:
        if (this.mView == null) goto L45;
        r6.print(r4);
        r6.print("mView=");
        r6.println(this.mView);
    L45:
        if (getAnimatingAway() == null) goto L48;
        r6.print(r4);
        r6.print("mAnimatingAway=");
        r6.println(getAnimatingAway());
    L48:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L50;
        LoaderManager.getInstance(this).dump(r4, r5, r6, r7);
    L50:
        r6.print(r4);
        r6.println("Child " + this.mChildFragmentManager + ParameterizedMessage.ERROR_MSG_SEPARATOR);
        this.mChildFragmentManager.dump(r4 + "  ", r5, r6, r7);
    }

    public final boolean equals(Object r1) {
        return super.equals(r1);
    }

    Fragment findFragmentByWho(String r2) {
        if (r2.equals(this.mWho) == false) goto L6;
        return this;
    L6:
        return this.mChildFragmentManager.findFragmentByWho(r2);
    }

    String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final FragmentActivity getActivity() {
        FragmentHostCallback<?> r2 = this.mHost;
        if (r2 != null) goto L6;
        return null;
    L6:
        return (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getActivity(r2, "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
    }

    public boolean getAllowEnterTransitionOverlap() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.mAllowEnterTransitionOverlap == null) goto L8;
        return this.mAnimationInfo.mAllowEnterTransitionOverlap.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.mAllowReturnTransitionOverlap == null) goto L8;
        return this.mAnimationInfo.mAllowReturnTransitionOverlap.booleanValue();
    }

    View getAnimatingAway() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mAnimatingAway;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mHost == null) goto L7;
        return this.mChildFragmentManager;
    L7:
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Context getContext() {
        FragmentHostCallback<?> r2 = this.mHost;
        if (r2 != null) goto L6;
        return null;
    L6:
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        Context r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext();
    L3:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, ContextWrapper.class) == false) goto L9;
        if (ZeusTransformUtils.instanceOf(r1, Application.class) == true) goto L7;
        r0 = ((ContextWrapper) ZeusTransformUtils.preCheckCast(r1, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext();
        goto L3
    L7:
        Application r2 = (Application) ZeusTransformUtils.preCheckCast(r1, Application.class, "com.obric.memorydata.plugin");
    L10:
        if (r2 == null) goto L12;
    L14:
        MutableCreationExtras r3 = new MutableCreationExtras();
        if (r2 == null) goto L17;
        r3.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, r2);
    L17:
        r3.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        r3.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getArguments() == null) goto L20;
        r3.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getArguments());
    L20:
        return r3;
    L12:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L14;
        Log.d(FragmentManager.TAG, "Could not find Application instance from Context " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        goto L14
    L9:
        r2 = null;
        goto L10
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager == null) goto L21;
        if (this.mDefaultFactory != null) goto L19;
        Application r0 = null;
        Context r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext();
    L7:
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, ContextWrapper.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r2, Application.class) == true) goto L11;
        r1 = ((ContextWrapper) ZeusTransformUtils.preCheckCast(r2, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext();
        goto L7
    L11:
        r0 = (Application) ZeusTransformUtils.preCheckCast(r2, Application.class, "com.obric.memorydata.plugin");
    L13:
        if (r0 == null) goto L15;
    L17:
        this.mDefaultFactory = new SavedStateViewModelFactory(r0, this, getArguments());
        goto L19
    L15:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L17;
        Log.d(FragmentManager.TAG, "Could not find Application instance from Context " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
    L19:
        return this.mDefaultFactory;
    L21:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    int getEnterAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mEnterAnim;
    }

    public Object getEnterTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mEnterTransition;
    }

    SharedElementCallback getEnterTransitionCallback() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mEnterTransitionCallback;
    }

    int getExitAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mExitAnim;
    }

    public Object getExitTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mExitTransition;
    }

    SharedElementCallback getExitTransitionCallback() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mExitTransitionCallback;
    }

    View getFocusedView() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mFocusedView;
    }

    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.onGetHost();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater r0 = this.mLayoutInflater;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return performGetLayoutInflater(null);
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle r1) {
        FragmentHostCallback<?> r2 = this.mHost;
        if (r2 == null) goto L7;
        LayoutInflater r3 = r2.onGetLayoutInflater();
        LayoutInflaterCompat.setFactory2(r3, this.mChildFragmentManager.getLayoutInflaterFactory());
        return r3;
    L7:
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    int getNextTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mNextTransition;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final FragmentManager getParentFragmentManager() {
        FragmentManager r0 = this.mFragmentManager;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    boolean getPopDirection() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.mIsPop;
    }

    int getPopEnterAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mPopEnterAnim;
    }

    int getPopExitAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mPopExitAnim;
    }

    float getPostOnViewCreatedAlpha() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 1.0f;
    L7:
        return r0.mPostOnViewCreatedAlpha;
    }

    public Object getReenterTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        if (r0.mReenterTransition != USE_DEFAULT_TRANSITION) goto L10;
        return getExitTransition();
    L10:
        return this.mAnimationInfo.mReenterTransition;
    }

    public final Resources getResources() {
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    @Deprecated
    public final boolean getRetainInstance() {
        FragmentStrictMode.onGetRetainInstanceUsage(this);
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        if (r0.mReturnTransition != USE_DEFAULT_TRANSITION) goto L10;
        return getEnterTransition();
    L10:
        return this.mAnimationInfo.mReturnTransition;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    public Object getSharedElementEnterTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mSharedElementEnterTransition;
    }

    public Object getSharedElementReturnTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        if (r0.mSharedElementReturnTransition != USE_DEFAULT_TRANSITION) goto L10;
        return getSharedElementEnterTransition();
    L10:
        return this.mAnimationInfo.mSharedElementReturnTransition;
    }

    ArrayList<String> getSharedElementSourceNames() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 == null) goto L10;
        if (r0.mSharedElementSourceNames == null) goto L10;
        return this.mAnimationInfo.mSharedElementSourceNames;
    L10:
        return new ArrayList();
    }

    ArrayList<String> getSharedElementTargetNames() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 == null) goto L10;
        if (r0.mSharedElementTargetNames == null) goto L10;
        return this.mAnimationInfo.mSharedElementTargetNames;
    L10:
        return new ArrayList();
    }

    public final String getString(int r2) {
        return ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(r2);
    }

    public final String getString(int r2, Object... r3) {
        return ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(r2, r3);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        return getTargetFragment(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        FragmentStrictMode.onGetTargetFragmentRequestCodeUsage(this);
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int r2) {
        return ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getText(r2);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public LifecycleOwner getViewLifecycleOwner() {
        FragmentViewLifecycleOwner r1 = this.mViewLifecycleOwner;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (this.mFragmentManager == null) goto L11;
        if (getMinimumMaxLifecycleState() == Lifecycle.State.INITIALIZED.ordinal()) goto L9;
        return this.mFragmentManager.getViewModelStore(this);
    L9:
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    L11:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    void initState() {
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
        FragmentManager r0 = this.mFragmentManager;
        if (r0 != null) goto L7;
    L9:
        return false;
    L7:
        if (r0.isParentHidden(this.mParentFragment) == false) goto L9;
    L10:
        return true;
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

    public final boolean isMenuVisible() {
        if (this.mMenuVisible == false) goto L9;
        FragmentManager r0 = this.mFragmentManager;
        if (r0 != null) goto L7;
    L8:
        return true;
    L7:
        if (r0.isParentMenuVisible(this.mParentFragment) == true) goto L8;
    L9:
        return false;
    }

    boolean isPostponed() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.mEnterTransitionPostponed;
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
        FragmentManager r0 = this.mFragmentManager;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isStateSaved();
    }

    public final boolean isVisible() {
        if (isAdded() == true) goto L5;
    L13:
        return false;
    L5:
        if (isHidden() == true) goto L13;
        View r0 = this.mView;
        if (r0 == null) goto L13;
        if (r0.getWindowToken() == null) goto L13;
        if (this.mView.getVisibility() != 0) goto L13;
        return true;
    }

    void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
    }

    @Deprecated
    public void onActivityCreated(Bundle r1) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int r3, int r4, Intent r5) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
        Log.v(FragmentManager.TAG, "Fragment " + this + " received the following in onActivityResult(): requestCode: " + r3 + " resultCode: " + r4 + " data: " + r5);
        return;
    }

    @Deprecated
    public void onAttach(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        this.mCalled = true;
    }

    public void onAttach(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mCalled = true;
        FragmentHostCallback<?> r5 = this.mHost;
        if (r5 != null) goto L5;
        Activity r6 = null;
    L6:
        if (r6 == null) goto L9;
        this.mCalled = false;
        onAttach(r6);
        return;
    L9:
        return;
    L5:
        r6 = ZeusTransformUtils.getActivity(r5, "com.obric.memorydata.plugin");
        goto L6
    }

    @Deprecated
    public void onAttachFragment(Fragment r1) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem r2) {
        MenuItem r1 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        return false;
    }

    public void onCreate(Bundle r2) {
        this.mCalled = true;
        restoreChildFragmentState(r2);
        if (this.mChildFragmentManager.isStateAtLeast(1) == true) goto L6;
        this.mChildFragmentManager.dispatchCreate();
        return;
    }

    public Animation onCreateAnimation(int r1, boolean r2, int r3) {
        return null;
    }

    public Animator onCreateAnimator(int r1, boolean r2, int r3) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu r3, View r4, ContextMenu.ContextMenuInfo r5) {
        ContextMenu r6 = (ContextMenu) ZeusTransformUtils.wrapperContextForParams(r3, ContextMenu.class, "com.obric.memorydata.plugin");
        ContextMenu.ContextMenuInfo r7 = (ContextMenu.ContextMenuInfo) ZeusTransformUtils.wrapperContextForParams(r5, ContextMenu.ContextMenuInfo.class, "com.obric.memorydata.plugin");
        ((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")).onCreateContextMenu(r6, r4, r7);
    }

    @Deprecated
    public void onCreateOptionsMenu(Menu r1, MenuInflater r2) {
        Menu r0 = (Menu) ZeusTransformUtils.wrapperContextForParams(r1, Menu.class, "com.obric.memorydata.plugin");
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        int r1 = this.mContentLayoutId;
        if (r1 != 0) goto L5;
        return null;
    L5:
        return ZeusTransformUtils.inflate(r2, r1, r3, false, "com.obric.memorydata.plugin");
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle r1) {
        return getLayoutInflater(r1);
    }

    public void onHiddenChanged(boolean r1) {
    }

    @Deprecated
    public void onInflate(Activity r2, AttributeSet r3, Bundle r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        this.mCalled = true;
    }

    public void onInflate(Context r3, AttributeSet r4, Bundle r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        this.mCalled = true;
        FragmentHostCallback<?> r8 = this.mHost;
        if (r8 != null) goto L5;
        Activity r9 = null;
    L6:
        if (r9 == null) goto L9;
        this.mCalled = false;
        onInflate(r9, r7, r5);
        return;
    L9:
        return;
    L5:
        r9 = ZeusTransformUtils.getActivity(r8, "com.obric.memorydata.plugin");
        goto L6
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean r1) {
    }

    @Deprecated
    public boolean onOptionsItemSelected(MenuItem r2) {
        MenuItem r1 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        return false;
    }

    @Deprecated
    public void onOptionsMenuClosed(Menu r2) {
        Menu r1 = (Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.memorydata.plugin");
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean r1) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu r2) {
        Menu r1 = (Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.memorydata.plugin");
    }

    public void onPrimaryNavigationFragmentChanged(boolean r1) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int r1, String[] r2, int[] r3) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle r1) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View r1, Bundle r2) {
    }

    public void onViewStateRestored(Bundle r1) {
        this.mCalled = true;
    }

    void performActivityCreated(Bundle r3) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(r3);
        if (this.mCalled == false) goto L7;
        restoreViewState();
        this.mChildFragmentManager.dispatchActivityCreated();
        return;
    L7:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    void performAttach() {
        Iterator<OnPreAttachedListener> r0 = this.mOnPreAttachedListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((OnPreAttachedListener) ZeusTransformUtils.preCheckCast(r0.next(), OnPreAttachedListener.class, "com.obric.memorydata.plugin")).onPreAttached();
        goto L4
    L6:
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.attachController(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mHost.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (this.mCalled == false) goto L11;
        this.mFragmentManager.dispatchOnAttachFragment(this);
        this.mChildFragmentManager.dispatchAttach();
        return;
    L11:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
    }

    void performConfigurationChanged(Configuration r1) {
        onConfigurationChanged(r1);
        this.mChildFragmentManager.dispatchConfigurationChanged(r1);
    }

    boolean performContextItemSelected(MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin");
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (onContextItemSelected(r4) == false) goto L9;
        return true;
    L9:
        return this.mChildFragmentManager.dispatchContextItemSelected(r4);
    }

    void performCreate(Bundle r4) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 1;
        this.mCalled = false;
        if (Build.VERSION.SDK_INT < 19) goto L5;
        this.mLifecycleRegistry.addObserver(new AnonymousClass6(this));
    L5:
        this.mSavedStateRegistryController.performRestore(r4);
        onCreate(r4);
        this.mIsCreated = true;
        if (this.mCalled == false) goto L10;
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    boolean performCreateOptionsMenu(Menu r3, MenuInflater r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        r1 = true;
        onCreateOptionsMenu(r5, r4);
    L10:
        return r1 | this.mChildFragmentManager.dispatchCreateOptionsMenu(r5, r4);
    }

    void performCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new FragmentViewLifecycleOwner(this, getViewModelStore());
        View r6 = onCreateView(r3, r4, r5);
        this.mView = r6;
        if (r6 == null) goto L6;
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

    LayoutInflater performGetLayoutInflater(Bundle r1) {
        LayoutInflater r2 = onGetLayoutInflater(r1);
        this.mLayoutInflater = r2;
        return r2;
    }

    void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.dispatchLowMemory();
    }

    void performMultiWindowModeChanged(boolean r1) {
        onMultiWindowModeChanged(r1);
        this.mChildFragmentManager.dispatchMultiWindowModeChanged(r1);
    }

    boolean performOptionsItemSelected(MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin");
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L13;
        if (this.mMenuVisible == false) goto L13;
        if (onOptionsItemSelected(r4) == false) goto L13;
        return true;
    L13:
        return this.mChildFragmentManager.dispatchOptionsItemSelected(r4);
    }

    void performOptionsMenuClosed(Menu r3) {
        Menu r4 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.memorydata.plugin");
        if (this.mHidden == false) goto L5;
        return;
    L5:
        if (this.mHasMenu == true) goto L7;
    L9:
        this.mChildFragmentManager.dispatchOptionsMenuClosed(r4);
        return;
    L7:
        if (this.mMenuVisible == false) goto L9;
        onOptionsMenuClosed(r4);
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

    void performPictureInPictureModeChanged(boolean r1) {
        onPictureInPictureModeChanged(r1);
        this.mChildFragmentManager.dispatchPictureInPictureModeChanged(r1);
    }

    boolean performPrepareOptionsMenu(Menu r3) {
        Menu r4 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        r1 = true;
        onPrepareOptionsMenu(r4);
    L10:
        return r1 | this.mChildFragmentManager.dispatchPrepareOptionsMenu(r4);
    }

    void performPrimaryNavigationFragmentChanged() {
        boolean r0 = this.mFragmentManager.isPrimaryNavigation(this);
        Boolean r1 = this.mIsPrimaryNavigationFragment;
        if (r1 != null) goto L5;
    L6:
        this.mIsPrimaryNavigationFragment = Boolean.valueOf(r0);
        onPrimaryNavigationFragmentChanged(r0);
        this.mChildFragmentManager.dispatchPrimaryNavigationFragmentChanged();
        return;
    L5:
        if (r1.booleanValue() != r0) goto L6;
    }

    void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (this.mCalled == false) goto L10;
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    L7:
        this.mChildFragmentManager.dispatchResume();
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    void performSaveInstanceState(Bundle r2) {
        onSaveInstanceState(r2);
        this.mSavedStateRegistryController.performSave(r2);
        Bundle r1 = this.mChildFragmentManager.saveAllStateInternal();
        if (r1 == null) goto L6;
        r2.putParcelable("android:support:fragments", r1);
        return;
    }

    void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (this.mCalled == false) goto L10;
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_START);
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

    public final void postponeEnterTransition(long r3, TimeUnit r5) {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
        FragmentManager r0 = this.mFragmentManager;
        if (r0 == null) goto L5;
        Handler r1 = r0.getHost().getHandler();
    L6:
        r1.removeCallbacks(this.mPostponedDurationRunnable);
        r1.postDelayed(this.mPostponedDurationRunnable, r5.toMillis(r3));
        return;
    L5:
        r1 = new Handler(Looper.getMainLooper());
        goto L6
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r3, ActivityResultCallback<O> r4) {
        ActivityResultCallback<O> r5 = (ActivityResultCallback) ZeusTransformUtils.wrapperContextForParams(r4, ActivityResultCallback.class, "com.obric.memorydata.plugin");
        return prepareCallInternal(r3, new AnonymousClass7(this), r5);
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r3, final ActivityResultRegistry r4, ActivityResultCallback<O> r5) {
        ActivityResultCallback<O> r6 = (ActivityResultCallback) ZeusTransformUtils.wrapperContextForParams(r5, ActivityResultCallback.class, "com.obric.memorydata.plugin");
        return prepareCallInternal(r3, new AnonymousClass8(this, r4), r6);
    }

    public void registerForContextMenu(View r1) {
        r1.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] r2, int r3) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().launchRequestPermissions(this, r2, r3);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Bundle requireArguments() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final Context requireContext() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object r0 = getHost();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Fragment requireParentFragment() {
        Fragment r0 = getParentFragment();
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) != null) goto L9;
        throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
    L9:
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
    }

    public final View requireView() {
        View r0 = getView();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    void restoreChildFragmentState(Bundle r2) {
        if (r2 == null) goto L7;
        Parcelable r3 = r2.getParcelable("android:support:fragments");
        if (r3 == null) goto L8;
        this.mChildFragmentManager.restoreSaveStateInternal(r3);
        this.mChildFragmentManager.dispatchCreate();
        return;
    L8:
        return;
    }

    final void restoreViewState(Bundle r4) {
        SparseArray<Parcelable> r0 = this.mSavedViewState;
        if (r0 == null) goto L6;
        this.mView.restoreHierarchyState(r0);
        this.mSavedViewState = null;
    L6:
        if (this.mView == null) goto L8;
        this.mViewLifecycleOwner.performRestore(this.mSavedViewRegistryState);
        this.mSavedViewRegistryState = null;
    L8:
        this.mCalled = false;
        onViewStateRestored(r4);
        if (this.mCalled == false) goto L15;
        if (this.mView == null) goto L16;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L16:
        return;
    L15:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public void setAllowEnterTransitionOverlap(boolean r1) {
        AnimationInfo r0 = ensureAnimationInfo();
        r0.mAllowEnterTransitionOverlap = Boolean.valueOf(r1);
    }

    public void setAllowReturnTransitionOverlap(boolean r1) {
        AnimationInfo r0 = ensureAnimationInfo();
        r0.mAllowReturnTransitionOverlap = Boolean.valueOf(r1);
    }

    void setAnimations(int r2, int r3, int r4, int r5) {
        if (this.mAnimationInfo != null) goto L9;
        if (r2 != 0) goto L9;
        if (r3 != 0) goto L9;
        if (r4 != 0) goto L9;
        if (r5 != 0) goto L9;
        return;
    L9:
        ensureAnimationInfo().mEnterAnim = r2;
        ensureAnimationInfo().mExitAnim = r3;
        ensureAnimationInfo().mPopEnterAnim = r4;
        ensureAnimationInfo().mPopExitAnim = r5;
    }

    public void setArguments(Bundle r2) {
        if (this.mFragmentManager != null) goto L5;
    L9:
        this.mArguments = r2;
        return;
    L5:
        if (isStateSaved() == false) goto L9;
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public void setEnterSharedElementCallback(SharedElementCallback r1) {
        ensureAnimationInfo().mEnterTransitionCallback = r1;
    }

    public void setEnterTransition(Object r1) {
        ensureAnimationInfo().mEnterTransition = r1;
    }

    public void setExitSharedElementCallback(SharedElementCallback r1) {
        ensureAnimationInfo().mExitTransitionCallback = r1;
    }

    public void setExitTransition(Object r1) {
        ensureAnimationInfo().mExitTransition = r1;
    }

    void setFocusedView(View r1) {
        ensureAnimationInfo().mFocusedView = r1;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean r2) {
        if (this.mHasMenu == r2) goto L10;
        this.mHasMenu = r2;
        if (isAdded() == true) goto L7;
        return;
    L7:
        if (isHidden() == true) goto L12;
        this.mHost.onSupportInvalidateOptionsMenu();
        return;
    L12:
        return;
    }

    public void setInitialSavedState(SavedState r2) {
        if (this.mFragmentManager != null) goto L12;
        if (r2 != null) goto L6;
    L8:
        Bundle r3 = null;
    L9:
        this.mSavedFragmentState = r3;
        return;
    L6:
        if (r2.mState == null) goto L8;
        r3 = r2.mState;
        goto L9
    L12:
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean r2) {
        if (this.mMenuVisible == r2) goto L12;
        this.mMenuVisible = r2;
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

    void setNextTransition(int r2) {
        if (this.mAnimationInfo != null) goto L6;
        if (r2 != 0) goto L6;
        return;
    L6:
        ensureAnimationInfo();
        this.mAnimationInfo.mNextTransition = r2;
    }

    void setPopDirection(boolean r2) {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        ensureAnimationInfo().mIsPop = r2;
    }

    void setPostOnViewCreatedAlpha(float r1) {
        ensureAnimationInfo().mPostOnViewCreatedAlpha = r1;
    }

    public void setReenterTransition(Object r1) {
        ensureAnimationInfo().mReenterTransition = r1;
    }

    @Deprecated
    public void setRetainInstance(boolean r2) {
        FragmentStrictMode.onSetRetainInstanceUsage(this);
        this.mRetainInstance = r2;
        FragmentManager r0 = this.mFragmentManager;
        if (r0 == null) goto L7;
        if (r2 == false) goto L6;
        r0.addRetainedFragment(this);
        return;
    L6:
        r0.removeRetainedFragment(this);
        return;
    L7:
        this.mRetainInstanceChangedWhileDetached = true;
    }

    public void setReturnTransition(Object r1) {
        ensureAnimationInfo().mReturnTransition = r1;
    }

    public void setSharedElementEnterTransition(Object r1) {
        ensureAnimationInfo().mSharedElementEnterTransition = r1;
    }

    void setSharedElementNames(ArrayList<String> r2, ArrayList<String> r3) {
        ensureAnimationInfo();
        this.mAnimationInfo.mSharedElementSourceNames = r2;
        this.mAnimationInfo.mSharedElementTargetNames = r3;
    }

    public void setSharedElementReturnTransition(Object r1) {
        ensureAnimationInfo().mSharedElementReturnTransition = r1;
    }

    @Deprecated
    public void setTargetFragment(Fragment r4, int r5) {
        if (r4 == null) goto L4;
        FragmentStrictMode.onSetTargetFragmentUsage(this, r4, r5);
    L4:
        FragmentManager r0 = this.mFragmentManager;
        if (r4 == null) goto L7;
        FragmentManager r2 = r4.mFragmentManager;
    L8:
        if (r0 == null) goto L14;
        if (r2 == null) goto L14;
        if (r0 == r2) goto L14;
        throw new IllegalArgumentException("Fragment " + r4 + " must share the same FragmentManager to be set as a target fragment");
    L14:
        Fragment r1 = r4;
    L15:
        if (r1 == null) goto L21;
        if (r1.equals(this) == true) goto L20;
        r1 = r1.getTargetFragment(false);
        goto L15
    L20:
        throw new IllegalArgumentException("Setting " + r4 + " as the target of " + this + " would create a target cycle");
    L21:
        if (r4 != null) goto L25;
        this.mTargetWho = null;
    L23:
        this.mTarget = null;
    L30:
        this.mTargetRequestCode = r5;
        return;
    L25:
        if (this.mFragmentManager != null) goto L27;
    L29:
        this.mTargetWho = null;
        this.mTarget = r4;
        goto L30
    L27:
        if (r4.mFragmentManager == null) goto L29;
        this.mTargetWho = r4.mWho;
        goto L23
    L7:
        r2 = null;
        goto L8
    }

    @Deprecated
    public void setUserVisibleHint(boolean r4) {
        FragmentStrictMode.onSetUserVisibleHint(this, r4);
        if (this.mUserVisibleHint == true) goto L14;
        if (r4 == false) goto L14;
        if (this.mState >= 5) goto L14;
        if (this.mFragmentManager == null) goto L14;
        if (isAdded() == false) goto L14;
        if (this.mIsCreated == false) goto L14;
        FragmentManager r0 = this.mFragmentManager;
        r0.performPendingDeferredStart(r0.createOrGetFragmentStateManager(this));
    L14:
        this.mUserVisibleHint = r4;
        if (this.mState >= 5) goto L18;
        if (r4 == true) goto L18;
        boolean r1 = true;
    L19:
        this.mDeferStart = r1;
        if (this.mSavedFragmentState == null) goto L23;
        this.mSavedUserVisibleHint = Boolean.valueOf(r4);
        return;
    L23:
        return;
    L18:
        r1 = false;
        goto L19
    }

    public boolean shouldShowRequestPermissionRationale(String r1) {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.onShouldShowRequestPermissionRationale(r1);
    }

    public void startActivity(Intent r3) {
        ZeusTransformUtils.startActivity(this, r3, null, "com.obric.memorydata.plugin");
    }

    public void startActivity(Intent r3, Bundle r4) {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 == null) goto L7;
        r0.onStartActivityFromFragment(this, r3, -1, r4);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(Intent r3, int r4) {
        ZeusTransformUtils.startActivityForResult(this, r3, r4, null, "com.obric.memorydata.plugin");
    }

    @Deprecated
    public void startActivityForResult(Intent r2, int r3, Bundle r4) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().launchStartActivityForResult(this, r2, r3, r4);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender r10, int r11, Intent r12, int r13, int r14, int r15, Bundle r16) {
        if (this.mHost == null) goto L11;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
        Log.v(FragmentManager.TAG, "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + r11 + " IntentSender: " + r10 + " fillInIntent: " + r12 + " options: " + r16);
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
        this.mHost.getHandler().postAtFrontOfQueue(new AnonymousClass3(this));
        return;
    L13:
        callStartTransitionListener(true);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append(getClass().getSimpleName());
        r0.append("{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        r0.append("}");
        r0.append(" (");
        r0.append(this.mWho);
        if (this.mFragmentId == 0) goto L6;
        r0.append(" id=0x");
        r0.append(Integer.toHexString(this.mFragmentId));
    L6:
        if (this.mTag == null) goto L8;
        r0.append(" tag=");
        r0.append(this.mTag);
    L8:
        r0.append(")");
        return r0.toString();
    }

    public void unregisterForContextMenu(View r1) {
        r1.setOnCreateContextMenuListener(null);
    }
}
