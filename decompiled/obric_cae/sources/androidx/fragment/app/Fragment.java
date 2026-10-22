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
import androidx.activity.result.IntentSenderRequest;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.l0;
import com.obric.cae.R;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.m, l0, androidx.lifecycle.f, z0.c {
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
    i mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    androidx.lifecycle.i0.b mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    r<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    androidx.lifecycle.n mLifecycleRegistry;
    androidx.lifecycle.h.b mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<k> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    z0.b mSavedStateRegistryController;
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
    g0 mViewLifecycleOwner;
    androidx.lifecycle.t<androidx.lifecycle.m> mViewLifecycleOwnerLiveData;
    String mWho;

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f1823a;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r8) {
                return new SavedState(r8, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r8) {
                return new SavedState[r8];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r8, ClassLoader r10) {
                return new SavedState(r8, r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r8, ClassLoader r10) {
            Bundle r11 = r8.readBundle();
            this.f1823a = r11;
            if (r10 == null) goto L7;
            if (r11 == null) goto L8;
            r11.setClassLoader(r10);
            return;
        L8:
            return;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeBundle(this.f1823a);
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f1824a;

        public a(Fragment r8) {
            this.f1824a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f1824a.startPostponedEnterTransition();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f1825a;

        public b(Fragment r8) {
            this.f1825a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f1825a.callStartTransitionListener(false);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f1826a;

        public c(i0 r8) {
            this.f1826a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f1826a.c();
        }
    }

    public class d extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f1827a;

        public d(Fragment r8) {
            this.f1827a = r8;
        }

        @Override // androidx.fragment.app.o
        public final View b(int r8) {
            Fragment r10 = this.f1827a;
            View r11 = r10.mView;
            if (r11 == null) goto L7;
            return r11.findViewById(r8);
        L7:
            throw new IllegalStateException("Fragment " + r10 + " does not have a view");
        }

        @Override // androidx.fragment.app.o
        public final boolean c() {
            if (this.f1827a.mView == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public class e implements k.a<Void, androidx.activity.result.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f1828a;

        public e(Fragment r8) {
            this.f1828a = r8;
        }

        @Override // k.a
        public final androidx.activity.result.e apply(Void r8) {
            Fragment r10 = this.f1828a;
            Object r11 = r10.mHost;
            if ((r11 instanceof androidx.activity.result.f) == false) goto L6;
            return ((androidx.activity.result.f) r11).getActivityResultRegistry();
        L6:
            return r10.requireActivity().getActivityResultRegistry();
        }
    }

    public class f implements k.a<Void, androidx.activity.result.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.activity.result.e f1829a;

        public f(androidx.activity.result.e r8) {
            this.f1829a = r8;
        }

        @Override // k.a
        public final androidx.activity.result.e apply(Void r8) {
            return this.f1829a;
        }
    }

    public class g extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k.a f1830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f1831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b.a f1832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ androidx.activity.result.a f1833d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Fragment f1834e;

        public g(Fragment r8, k.a r10, AtomicReference r11, b.a r12, androidx.activity.result.a r13) {
            this.f1834e = r8;
            this.f1830a = r10;
            this.f1831b = r11;
            this.f1832c = r12;
            this.f1833d = r13;
        }

        @Override // androidx.fragment.app.Fragment.k
        public final void a() {
            Fragment r8 = this.f1834e;
            String r10 = r8.generateActivityResultKey();
            androidx.activity.result.c r11 = ((androidx.activity.result.e) this.f1830a.apply(null)).c(r10, r8, this.f1832c, this.f1833d);
            this.f1831b.set(r11);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    public class h<I> extends androidx.activity.result.b<I> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f1835a;

        public h(AtomicReference r8) {
            this.f1835a = r8;
        }

        @Override // androidx.activity.result.b
        public final void a(Object r8) {
            androidx.activity.result.b r10 = (androidx.activity.result.b) this.f1835a.get();
            if (r10 == null) goto L7;
            r10.a(r8);
            return;
        L7:
            throw new IllegalStateException("Operation cannot be started before fragment is in created state");
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f1836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Animator f1837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1840e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1841f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1842g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1843h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ArrayList<String> f1844i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ArrayList<String> f1845j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f1846k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f1847l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f1848m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f1849n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f1850o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Object f1851p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Boolean f1852q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Boolean f1853r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f1854s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public View f1855t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f1856u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f1857v;

        public i() {
            this.f1846k = null;
            Object r8 = Fragment.USE_DEFAULT_TRANSITION;
            this.f1847l = r8;
            this.f1848m = null;
            this.f1849n = r8;
            this.f1850o = null;
            this.f1851p = r8;
            this.f1854s = 1.0f;
            this.f1855t = null;
        }
    }

    public static class j extends RuntimeException {
        public j(String r8, Exception r10) {
            super(r8, r10);
        }
    }

    public static abstract class k {
        public k() {
        }

        public abstract void a();
    }

    public interface l {
    }

    static {
        USE_DEFAULT_TRANSITION = new Object();
    }

    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new u();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new a(this);
        this.mMaxState = androidx.lifecycle.h.b.f2161o;
        this.mViewLifecycleOwnerLiveData = new androidx.lifecycle.t();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList();
        initLifecycle();
    }

    private i ensureAnimationInfo() {
        if (this.mAnimationInfo != null) goto L6;
        this.mAnimationInfo = new i();
    L6:
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        androidx.lifecycle.h.b r8 = this.mMaxState;
        if (r8 == androidx.lifecycle.h.b.f2158b) goto L10;
        if (this.mParentFragment == null) goto L10;
        return Math.min(r8.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    L10:
        return r8.ordinal();
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new androidx.lifecycle.n(this);
        this.mSavedStateRegistryController = z0.b.a.a(this);
        this.mDefaultFactory = null;
    }

    @Deprecated
    public static Fragment instantiate(Context r8, String r10) {
        return instantiate(r8, r10, null);
    }

    private <I, O> androidx.activity.result.b<I> prepareCallInternal(b.a<I, O> r10, k.a<Void, androidx.activity.result.e> r11, androidx.activity.result.a<O> r12) {
        if (this.mState > 1) goto L7;
        AtomicReference r8 = new AtomicReference();
        registerOnPreAttachListener(new g(this, r11, r8, r10, r12));
        return new h(r8);
    L7:
        throw new IllegalStateException(android.aimedia.a.e("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
    }

    private void registerOnPreAttachListener(k r8) {
        if (this.mState < 0) goto L5;
        r8.a();
        return;
    L5:
        this.mOnPreAttachedListeners.add(r8);
    }

    private void restoreViewState() {
        if (FragmentManager.G(3) == false) goto L6;
        Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
    L6:
        if (this.mView == null) goto L8;
        restoreViewState(this.mSavedFragmentState);
    L8:
        this.mSavedFragmentState = null;
    }

    public void callStartTransitionListener(boolean r8) {
        i r10 = this.mAnimationInfo;
        if (r10 == null) goto L7;
        r10.f1856u = false;
        r10.getClass();
        r10.getClass();
    L7:
        if (this.mView == null) goto L17;
        ViewGroup r11 = this.mContainer;
        if (r11 == null) goto L18;
        FragmentManager r12 = this.mFragmentManager;
        if (r12 == null) goto L19;
        i0 r13 = i0.g(r11, r12.E());
        r13.h();
        if (r8 == false) goto L15;
        this.mHost.f2044m.post(new c(r13));
        return;
    L15:
        r13.c();
        return;
    L19:
        return;
    L18:
        return;
    }

    public o createFragmentContainer() {
        return new d(this);
    }

    public void dump(String r8, FileDescriptor r10, PrintWriter r11, String[] r12) {
        r11.print(r8);
        r11.print("mFragmentId=#");
        r11.print(Integer.toHexString(this.mFragmentId));
        r11.print(" mContainerId=#");
        r11.print(Integer.toHexString(this.mContainerId));
        r11.print(" mTag=");
        r11.println(this.mTag);
        r11.print(r8);
        r11.print("mState=");
        r11.print(this.mState);
        r11.print(" mWho=");
        r11.print(this.mWho);
        r11.print(" mBackStackNesting=");
        r11.println(this.mBackStackNesting);
        r11.print(r8);
        r11.print("mAdded=");
        r11.print(this.mAdded);
        r11.print(" mRemoving=");
        r11.print(this.mRemoving);
        r11.print(" mFromLayout=");
        r11.print(this.mFromLayout);
        r11.print(" mInLayout=");
        r11.println(this.mInLayout);
        r11.print(r8);
        r11.print("mHidden=");
        r11.print(this.mHidden);
        r11.print(" mDetached=");
        r11.print(this.mDetached);
        r11.print(" mMenuVisible=");
        r11.print(this.mMenuVisible);
        r11.print(" mHasMenu=");
        r11.println(this.mHasMenu);
        r11.print(r8);
        r11.print("mRetainInstance=");
        r11.print(this.mRetainInstance);
        r11.print(" mUserVisibleHint=");
        r11.println(this.mUserVisibleHint);
        if (this.mFragmentManager == null) goto L6;
        r11.print(r8);
        r11.print("mFragmentManager=");
        r11.println(this.mFragmentManager);
    L6:
        if (this.mHost == null) goto L9;
        r11.print(r8);
        r11.print("mHost=");
        r11.println(this.mHost);
    L9:
        if (this.mParentFragment == null) goto L12;
        r11.print(r8);
        r11.print("mParentFragment=");
        r11.println(this.mParentFragment);
    L12:
        if (this.mArguments == null) goto L15;
        r11.print(r8);
        r11.print("mArguments=");
        r11.println(this.mArguments);
    L15:
        if (this.mSavedFragmentState == null) goto L18;
        r11.print(r8);
        r11.print("mSavedFragmentState=");
        r11.println(this.mSavedFragmentState);
    L18:
        if (this.mSavedViewState == null) goto L21;
        r11.print(r8);
        r11.print("mSavedViewState=");
        r11.println(this.mSavedViewState);
    L21:
        if (this.mSavedViewRegistryState == null) goto L23;
        r11.print(r8);
        r11.print("mSavedViewRegistryState=");
        r11.println(this.mSavedViewRegistryState);
    L23:
        Fragment r13 = getTargetFragment();
        if (r13 == null) goto L26;
        r11.print(r8);
        r11.print("mTarget=");
        r11.print(r13);
        r11.print(" mTargetRequestCode=");
        r11.println(this.mTargetRequestCode);
    L26:
        r11.print(r8);
        r11.print("mPopDirection=");
        r11.println(getPopDirection());
        if (getEnterAnim() == 0) goto L30;
        r11.print(r8);
        r11.print("getEnterAnim=");
        r11.println(getEnterAnim());
    L30:
        if (getExitAnim() == 0) goto L33;
        r11.print(r8);
        r11.print("getExitAnim=");
        r11.println(getExitAnim());
    L33:
        if (getPopEnterAnim() == 0) goto L36;
        r11.print(r8);
        r11.print("getPopEnterAnim=");
        r11.println(getPopEnterAnim());
    L36:
        if (getPopExitAnim() == 0) goto L39;
        r11.print(r8);
        r11.print("getPopExitAnim=");
        r11.println(getPopExitAnim());
    L39:
        if (this.mContainer == null) goto L42;
        r11.print(r8);
        r11.print("mContainer=");
        r11.println(this.mContainer);
    L42:
        if (this.mView == null) goto L45;
        r11.print(r8);
        r11.print("mView=");
        r11.println(this.mView);
    L45:
        if (getAnimatingAway() == null) goto L48;
        r11.print(r8);
        r11.print("mAnimatingAway=");
        r11.println(getAnimatingAway());
    L48:
        if (getContext() == null) goto L50;
        u0.a.a(this).b(r8, r11);
    L50:
        r11.print(r8);
        r11.println("Child " + this.mChildFragmentManager + BdimCategoryConstants.SEPARATOR_COLON);
        this.mChildFragmentManager.u(defpackage.a.e(r8, "  "), r10, r11, r12);
    }

    public final boolean equals(Object r8) {
        return super.equals(r8);
    }

    public Fragment findFragmentByWho(String r8) {
        if (r8.equals(this.mWho) == false) goto L6;
        return this;
    L6:
        return this.mChildFragmentManager.f1864c.c(r8);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final m getActivity() {
        r<?> r8 = this.mHost;
        if (r8 != null) goto L6;
        return null;
    L6:
        return (m) r8.f2042a;
    }

    public boolean getAllowEnterTransitionOverlap() {
        i r8 = this.mAnimationInfo;
        if (r8 == null) goto L8;
        Boolean r10 = r8.f1853r;
        if (r10 == null) goto L8;
        return r10.booleanValue();
    L8:
        return true;
    }

    public boolean getAllowReturnTransitionOverlap() {
        i r8 = this.mAnimationInfo;
        if (r8 == null) goto L8;
        Boolean r10 = r8.f1852q;
        if (r10 == null) goto L8;
        return r10.booleanValue();
    L8:
        return true;
    }

    public View getAnimatingAway() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f1836a;
    }

    public Animator getAnimator() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f1837b;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mHost == null) goto L7;
        return this.mChildFragmentManager;
    L7:
        throw new IllegalStateException(android.aimedia.a.e("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        r<?> r8 = this.mHost;
        if (r8 != null) goto L6;
        return null;
    L6:
        return r8.f2043b;
    }

    public androidx.lifecycle.i0.b getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager == null) goto L22;
        if (this.mDefaultFactory != null) goto L20;
        Context r8 = requireContext().getApplicationContext();
    L8:
        if ((r8 instanceof ContextWrapper) == false) goto L13;
        if ((r8 instanceof Application) == true) goto L11;
        r8 = ((ContextWrapper) r8).getBaseContext();
        goto L8
    L11:
        Application r10 = (Application) r8;
    L14:
        if (r10 == null) goto L16;
    L18:
        this.mDefaultFactory = new androidx.lifecycle.e0(r10, this, getArguments());
        goto L20
    L16:
        if (FragmentManager.G(3) == false) goto L18;
        Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        goto L18
    L13:
        r10 = null;
    L20:
        return this.mDefaultFactory;
    L22:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public int getEnterAnim() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return r8.f1839d;
    }

    public Object getEnterTransition() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f1846k;
    }

    public androidx.core.app.r getEnterTransitionCallback() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L5;
        return null;
    L5:
        r8.getClass();
        return null;
    }

    public int getExitAnim() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return r8.f1840e;
    }

    public Object getExitTransition() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f1848m;
    }

    public androidx.core.app.r getExitTransitionCallback() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L5;
        return null;
    L5:
        r8.getClass();
        return null;
    }

    public View getFocusedView() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f1855t;
    }

    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        r<?> r8 = this.mHost;
        if (r8 != null) goto L6;
        return null;
    L6:
        return r8.d();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater r8 = this.mLayoutInflater;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return performGetLayoutInflater(null);
    }

    @Override // androidx.lifecycle.m
    public androidx.lifecycle.h getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public u0.a getLoaderManager() {
        return u0.a.a(this);
    }

    int getNextTransition() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return r8.f1843h;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final FragmentManager getParentFragmentManager() {
        FragmentManager r8 = this.mFragmentManager;
        if (r8 == null) goto L6;
        return r8;
    L6:
        throw new IllegalStateException(android.aimedia.a.e("Fragment ", this, " not associated with a fragment manager."));
    }

    public boolean getPopDirection() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L7;
        return false;
    L7:
        return r8.f1838c;
    }

    public int getPopEnterAnim() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return r8.f1841f;
    }

    public int getPopExitAnim() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return r8.f1842g;
    }

    public float getPostOnViewCreatedAlpha() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L7;
        return 1.0f;
    L7:
        return r8.f1854s;
    }

    public Object getReenterTransition() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L6;
        return null;
    L6:
        Object r10 = r8.f1849n;
        if (r10 == USE_DEFAULT_TRANSITION) goto L9;
        return r10;
    L9:
        return getExitTransition();
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L6;
        return null;
    L6:
        Object r10 = r8.f1847l;
        if (r10 == USE_DEFAULT_TRANSITION) goto L9;
        return r10;
    L9:
        return getEnterTransition();
    }

    @Override // z0.c
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f14170b;
    }

    public Object getSharedElementEnterTransition() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f1850o;
    }

    public Object getSharedElementReturnTransition() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L6;
        return null;
    L6:
        Object r10 = r8.f1851p;
        if (r10 == USE_DEFAULT_TRANSITION) goto L9;
        return r10;
    L9:
        return getSharedElementEnterTransition();
    }

    public ArrayList<String> getSharedElementSourceNames() {
        i r8 = this.mAnimationInfo;
        if (r8 == null) goto L9;
        ArrayList<String> r10 = r8.f1844i;
        if (r10 == null) goto L9;
        return r10;
    L9:
        return new ArrayList();
    }

    public ArrayList<String> getSharedElementTargetNames() {
        i r8 = this.mAnimationInfo;
        if (r8 == null) goto L9;
        ArrayList<String> r10 = r8.f1845j;
        if (r10 == null) goto L9;
        return r10;
    L9:
        return new ArrayList();
    }

    public final String getString(int r8) {
        return getResources().getString(r8);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        Fragment r8 = this.mTarget;
        if (r8 == null) goto L5;
        return r8;
    L5:
        FragmentManager r10 = this.mFragmentManager;
        if (r10 == null) goto L11;
        String r11 = this.mTargetWho;
        if (r11 != null) goto L10;
        return null;
    L10:
        return r10.A(r11);
    L11:
        return null;
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int r8) {
        return getResources().getText(r8);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public androidx.lifecycle.m getViewLifecycleOwner() {
        g0 r8 = this.mViewLifecycleOwner;
        if (r8 == null) goto L6;
        return r8;
    L6:
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<androidx.lifecycle.m> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.l0
    public androidx.lifecycle.k0 getViewModelStore() {
        if (this.mFragmentManager == null) goto L13;
        int r8 = getMinimumMaxLifecycleState();
        androidx.lifecycle.h.b r10 = androidx.lifecycle.h.b.f2157a;
        if (r8 == 1) goto L11;
        HashMap<String, androidx.lifecycle.k0> r11 = this.mFragmentManager.H.f2054f;
        androidx.lifecycle.k0 r12 = r11.get(this.mWho);
        if (r12 != null) goto L14;
        androidx.lifecycle.k0 r13 = new androidx.lifecycle.k0();
        r11.put(this.mWho, r13);
        return r13;
    L14:
        return r12;
    L11:
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    L13:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    @SuppressLint({"KotlinPropertyAccess"})
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
        this.mChildFragmentManager = new u();
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
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L7;
        return false;
    L7:
        return r8.f1857v;
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
        if (this.mMenuVisible == true) goto L5;
    L12:
        return false;
    L5:
        if (this.mFragmentManager == null) goto L14;
        Fragment r8 = this.mParentFragment;
        if (r8 != null) goto L9;
        boolean r10 = true;
    L10:
        if (r10 == false) goto L12;
        return true;
    L9:
        r10 = r8.isMenuVisible();
        goto L10
    L14:
        return true;
    }

    boolean isPostponed() {
        i r8 = this.mAnimationInfo;
        if (r8 != null) goto L7;
        return false;
    L7:
        return r8.f1856u;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isRemovingParent() {
        Fragment r8 = getParentFragment();
        if (r8 != null) goto L5;
    L9:
        return false;
    L5:
        if (r8.isRemoving() == false) goto L7;
    L8:
        return true;
    L7:
        if (r8.isRemovingParent() == false) goto L9;
        goto L8
    }

    public final boolean isResumed() {
        if (this.mState < 7) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isStateSaved() {
        FragmentManager r8 = this.mFragmentManager;
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r8.A == false) goto L8;
    L9:
        return true;
    L8:
        if (r8.B == true) goto L9;
        return false;
    }

    public final boolean isVisible() {
        if (isAdded() == true) goto L5;
    L13:
        return false;
    L5:
        if (isHidden() == true) goto L13;
        View r8 = this.mView;
        if (r8 == null) goto L13;
        if (r8.getWindowToken() == null) goto L13;
        if (this.mView.getVisibility() != 0) goto L13;
        return true;
    }

    void noteStateNotSaved() {
        this.mChildFragmentManager.K();
    }

    @Deprecated
    public void onActivityCreated(Bundle r8) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int r8, int r10, Intent r11) {
        if (FragmentManager.G(2) == false) goto L6;
        Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + r8 + " resultCode: " + r10 + " data: " + r11);
        return;
    }

    @Deprecated
    public void onAttach(Activity r8) {
        this.mCalled = true;
    }

    @Deprecated
    public void onAttachFragment(Fragment r8) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r8) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem r8) {
        return false;
    }

    public void onCreate(Bundle r8) {
        this.mCalled = true;
        restoreChildFragmentState(r8);
        FragmentManager r10 = this.mChildFragmentManager;
        if (r10.f1876o < 1) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L9;
        r10.A = false;
        r10.B = false;
        r10.H.f2057i = false;
        r10.t(1);
        return;
    L9:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public Animation onCreateAnimation(int r8, boolean r10, int r11) {
        return null;
    }

    public Animator onCreateAnimator(int r8, boolean r10, int r11) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu r8, View r10, ContextMenu.ContextMenuInfo r11) {
        requireActivity().onCreateContextMenu(r8, r10, r11);
    }

    public void onCreateOptionsMenu(Menu r8, MenuInflater r10) {
    }

    public View onCreateView(LayoutInflater r8, ViewGroup r10, Bundle r11) {
        int r12 = this.mContentLayoutId;
        if (r12 != 0) goto L5;
        return null;
    L5:
        return r8.inflate(r12, r10, false);
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle r8) {
        return getLayoutInflater(r8);
    }

    public void onHiddenChanged(boolean r8) {
    }

    @Deprecated
    public void onInflate(Activity r8, AttributeSet r10, Bundle r11) {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean r8) {
    }

    public boolean onOptionsItemSelected(MenuItem r8) {
        return false;
    }

    public void onOptionsMenuClosed(Menu r8) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean r8) {
    }

    public void onPrepareOptionsMenu(Menu r8) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean r8) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int r8, String[] r10, int[] r11) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle r8) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View r8, Bundle r10) {
    }

    public void onViewStateRestored(Bundle r8) {
        this.mCalled = true;
    }

    void performActivityCreated(Bundle r8) {
        this.mChildFragmentManager.K();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(r8);
        if (this.mCalled == false) goto L7;
        restoreViewState();
        FragmentManager r10 = this.mChildFragmentManager;
        r10.A = false;
        r10.B = false;
        r10.H.f2057i = false;
        r10.t(4);
        return;
    L7:
        throw new k0(android.aimedia.a.e("Fragment ", this, " did not call through to super.onActivityCreated()"));
    }

    public void performAttach() {
        Iterator<k> r8 = this.mOnPreAttachedListeners.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r8.next().a();
        goto L4
    L6:
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.c(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.f2043b);
        if (this.mCalled == false) goto L15;
        Iterator<w> r10 = this.mFragmentManager.f1875n.iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        r10.next().a(this);
        goto L10
    L12:
        FragmentManager r11 = this.mChildFragmentManager;
        r11.A = false;
        r11.B = false;
        r11.H.f2057i = false;
        r11.t(0);
        return;
    L15:
        throw new k0(android.aimedia.a.e("Fragment ", this, " did not call through to super.onAttach()"));
    }

    void performConfigurationChanged(Configuration r8) {
        onConfigurationChanged(r8);
        this.mChildFragmentManager.i(r8);
    }

    boolean performContextItemSelected(MenuItem r8) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (onContextItemSelected(r8) == false) goto L9;
        return true;
    L9:
        return this.mChildFragmentManager.j(r8);
    }

    void performCreate(Bundle r8) {
        this.mChildFragmentManager.K();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new AnonymousClass5(this));
        this.mSavedStateRegistryController.b(r8);
        onCreate(r8);
        this.mIsCreated = true;
        if (this.mCalled == false) goto L7;
        this.mLifecycleRegistry.f(androidx.lifecycle.h.a.ON_CREATE);
        return;
    L7:
        throw new k0(android.aimedia.a.e("Fragment ", this, " did not call through to super.onCreate()"));
    }

    boolean performCreateOptionsMenu(Menu r8, MenuInflater r10) {
        boolean r11 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        onCreateOptionsMenu(r8, r10);
        r11 = true;
    L10:
        return r11 | this.mChildFragmentManager.k(r8, r10);
    }

    public void performCreateView(LayoutInflater r8, ViewGroup r10, Bundle r11) {
        this.mChildFragmentManager.K();
        boolean r12 = true;
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new g0(getViewModelStore());
        View r13 = onCreateView(r8, r10, r11);
        this.mView = r13;
        if (r13 == null) goto L6;
        this.mViewLifecycleOwner.b();
        View r14 = this.mView;
        g0 r15 = this.mViewLifecycleOwner;
        he.i.f(r14, "<this>");
        r14.setTag(R.id.view_tree_lifecycle_owner, r15);
        View r16 = this.mView;
        g0 r17 = this.mViewLifecycleOwner;
        he.i.f(r16, "<this>");
        r16.setTag(R.id.view_tree_view_model_store_owner, r17);
        View r18 = this.mView;
        g0 r19 = this.mViewLifecycleOwner;
        he.i.f(r18, "<this>");
        r18.setTag(R.id.view_tree_saved_state_registry_owner, r19);
        this.mViewLifecycleOwnerLiveData.i(this.mViewLifecycleOwner);
        return;
    L6:
        if (this.mViewLifecycleOwner.f1965b != null) goto L9;
        r12 = false;
    L9:
        if (r12 == true) goto L13;
        this.mViewLifecycleOwner = null;
        return;
    L13:
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    void performDestroy() {
        this.mChildFragmentManager.l();
        this.mLifecycleRegistry.f(androidx.lifecycle.h.a.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled == false) goto L6;
        return;
    L6:
        throw new k0(android.aimedia.a.e("Fragment ", this, " did not call through to super.onDestroy()"));
    }

    void performDestroyView() {
        this.mChildFragmentManager.t(1);
        if (this.mView == null) goto L10;
        g0 r8 = this.mViewLifecycleOwner;
        r8.b();
        if (r8.f1965b.f2178c.compareTo(androidx.lifecycle.h.b.f2159m) < 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == false) goto L10;
        this.mViewLifecycleOwner.a(androidx.lifecycle.h.a.ON_DESTROY);
        goto L10
    L7:
        r10 = false;
    L10:
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled == false) goto L18;
        n.i<u0.b.a> r11 = u0.a.a(this).f12417b.f12419d;
        int r12 = r11.f9405m;
        int r13 = 0;
    L13:
        if (r13 >= r12) goto L15;
        ((u0.b.a) r11.f9404b[r13]).getClass();
        r13 = r13 + 1;
        goto L13
    L15:
        this.mPerformedCreateView = false;
        return;
    L18:
        throw new k0(android.aimedia.a.e("Fragment ", this, " did not call through to super.onDestroyView()"));
    }

    void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled == false) goto L9;
        FragmentManager r8 = this.mChildFragmentManager;
        if (r8.C == true) goto L10;
        r8.l();
        this.mChildFragmentManager = new u();
        return;
    L10:
        return;
    L9:
        throw new k0(android.aimedia.a.e("Fragment ", this, " did not call through to super.onDetach()"));
    }

    LayoutInflater performGetLayoutInflater(Bundle r8) {
        LayoutInflater r10 = onGetLayoutInflater(r8);
        this.mLayoutInflater = r10;
        return r10;
    }

    void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.m();
    }

    void performMultiWindowModeChanged(boolean r8) {
        onMultiWindowModeChanged(r8);
        this.mChildFragmentManager.n(r8);
    }

    boolean performOptionsItemSelected(MenuItem r8) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L13;
        if (this.mMenuVisible == false) goto L13;
        if (onOptionsItemSelected(r8) == false) goto L13;
        return true;
    L13:
        return this.mChildFragmentManager.o(r8);
    }

    void performOptionsMenuClosed(Menu r8) {
        if (this.mHidden == false) goto L5;
        return;
    L5:
        if (this.mHasMenu == true) goto L7;
    L9:
        this.mChildFragmentManager.p(r8);
        return;
    L7:
        if (this.mMenuVisible == false) goto L9;
        onOptionsMenuClosed(r8);
        goto L9
    }

    void performPause() {
        this.mChildFragmentManager.t(5);
        if (this.mView == null) goto L5;
        this.mViewLifecycleOwner.a(androidx.lifecycle.h.a.ON_PAUSE);
    L5:
        this.mLifecycleRegistry.f(androidx.lifecycle.h.a.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled == false) goto L9;
        return;
    L9:
        throw new k0(android.aimedia.a.e("Fragment ", this, " did not call through to super.onPause()"));
    }

    void performPictureInPictureModeChanged(boolean r8) {
        onPictureInPictureModeChanged(r8);
        this.mChildFragmentManager.r(r8);
    }

    boolean performPrepareOptionsMenu(Menu r8) {
        boolean r10 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        onPrepareOptionsMenu(r8);
        r10 = true;
    L10:
        return r10 | this.mChildFragmentManager.s(r8);
    }

    public void performPrimaryNavigationFragmentChanged() {
        this.mFragmentManager.getClass();
        boolean r8 = FragmentManager.I(this);
        Boolean r10 = this.mIsPrimaryNavigationFragment;
        if (r10 != null) goto L5;
    L6:
        this.mIsPrimaryNavigationFragment = Boolean.valueOf(r8);
        onPrimaryNavigationFragmentChanged(r8);
        FragmentManager r11 = this.mChildFragmentManager;
        r11.Y();
        r11.q(r11.f1880s);
        return;
    L5:
        if (r10.booleanValue() != r8) goto L6;
    }

    void performResume() {
        this.mChildFragmentManager.K();
        this.mChildFragmentManager.x(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (this.mCalled == false) goto L10;
        androidx.lifecycle.n r8 = this.mLifecycleRegistry;
        androidx.lifecycle.h.a r10 = androidx.lifecycle.h.a.ON_RESUME;
        r8.f(r10);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.f1965b.f(r10);
    L7:
        FragmentManager r11 = this.mChildFragmentManager;
        r11.A = false;
        r11.B = false;
        r11.H.f2057i = false;
        r11.t(7);
        return;
    L10:
        throw new k0(android.aimedia.a.e("Fragment ", this, " did not call through to super.onResume()"));
    }

    void performSaveInstanceState(Bundle r8) {
        onSaveInstanceState(r8);
        this.mSavedStateRegistryController.c(r8);
        Parcelable r10 = this.mChildFragmentManager.Q();
        if (r10 == null) goto L6;
        r8.putParcelable("android:support:fragments", r10);
        return;
    }

    void performStart() {
        this.mChildFragmentManager.K();
        this.mChildFragmentManager.x(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (this.mCalled == false) goto L10;
        androidx.lifecycle.n r8 = this.mLifecycleRegistry;
        androidx.lifecycle.h.a r10 = androidx.lifecycle.h.a.ON_START;
        r8.f(r10);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.f1965b.f(r10);
    L7:
        FragmentManager r11 = this.mChildFragmentManager;
        r11.A = false;
        r11.B = false;
        r11.H.f2057i = false;
        r11.t(5);
        return;
    L10:
        throw new k0(android.aimedia.a.e("Fragment ", this, " did not call through to super.onStart()"));
    }

    void performStop() {
        FragmentManager r8 = this.mChildFragmentManager;
        r8.B = true;
        r8.H.f2057i = true;
        r8.t(4);
        if (this.mView == null) goto L5;
        this.mViewLifecycleOwner.a(androidx.lifecycle.h.a.ON_STOP);
    L5:
        this.mLifecycleRegistry.f(androidx.lifecycle.h.a.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled == false) goto L9;
        return;
    L9:
        throw new k0(android.aimedia.a.e("Fragment ", this, " did not call through to super.onStop()"));
    }

    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.t(2);
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().f1856u = true;
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(b.a<I, O> r8, androidx.activity.result.a<O> r10) {
        return prepareCallInternal(r8, new e(this), r10);
    }

    public void registerForContextMenu(View r8) {
        r8.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] r8, int r10) {
        if (this.mHost == null) goto L10;
        FragmentManager r11 = getParentFragmentManager();
        if (r11.f1885x == null) goto L7;
        FragmentManager.LaunchedFragmentInfo r12 = new FragmentManager.LaunchedFragmentInfo(this.mWho, r10);
        r11.f1886y.addLast(r12);
        r11.f1885x.a(r8);
        return;
    L7:
        r11.f1877p.getClass();
        return;
    L10:
        throw new IllegalStateException(android.aimedia.a.e("Fragment ", this, " not attached to Activity"));
    }

    public final m requireActivity() {
        m r8 = getActivity();
        if (r8 == null) goto L6;
        return r8;
    L6:
        throw new IllegalStateException(android.aimedia.a.e("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle requireArguments() {
        Bundle r8 = getArguments();
        if (r8 == null) goto L6;
        return r8;
    L6:
        throw new IllegalStateException(android.aimedia.a.e("Fragment ", this, " does not have any arguments."));
    }

    public final Context requireContext() {
        Context r8 = getContext();
        if (r8 == null) goto L6;
        return r8;
    L6:
        throw new IllegalStateException(android.aimedia.a.e("Fragment ", this, " not attached to a context."));
    }

    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object r8 = getHost();
        if (r8 == null) goto L6;
        return r8;
    L6:
        throw new IllegalStateException(android.aimedia.a.e("Fragment ", this, " not attached to a host."));
    }

    public final Fragment requireParentFragment() {
        Fragment r8 = getParentFragment();
        if (r8 == null) goto L5;
        return r8;
    L5:
        if (getContext() != null) goto L9;
        throw new IllegalStateException(android.aimedia.a.e("Fragment ", this, " is not attached to any Fragment or host"));
    L9:
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View r8 = getView();
        if (r8 == null) goto L6;
        return r8;
    L6:
        throw new IllegalStateException(android.aimedia.a.e("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState(Bundle r8) {
        if (r8 == null) goto L7;
        Parcelable r10 = r8.getParcelable("android:support:fragments");
        if (r10 == null) goto L8;
        this.mChildFragmentManager.P(r10);
        FragmentManager r11 = this.mChildFragmentManager;
        r11.A = false;
        r11.B = false;
        r11.H.f2057i = false;
        r11.t(1);
        return;
    L8:
        return;
    }

    public void setAllowEnterTransitionOverlap(boolean r8) {
        i r10 = ensureAnimationInfo();
        r10.f1853r = Boolean.valueOf(r8);
    }

    public void setAllowReturnTransitionOverlap(boolean r8) {
        i r10 = ensureAnimationInfo();
        r10.f1852q = Boolean.valueOf(r8);
    }

    public void setAnimatingAway(View r8) {
        ensureAnimationInfo().f1836a = r8;
    }

    public void setAnimations(int r8, int r10, int r11, int r12) {
        if (this.mAnimationInfo != null) goto L9;
        if (r8 != 0) goto L9;
        if (r10 != 0) goto L9;
        if (r11 != 0) goto L9;
        if (r12 != 0) goto L9;
        return;
    L9:
        ensureAnimationInfo().f1839d = r8;
        ensureAnimationInfo().f1840e = r10;
        ensureAnimationInfo().f1841f = r11;
        ensureAnimationInfo().f1842g = r12;
    }

    public void setAnimator(Animator r8) {
        ensureAnimationInfo().f1837b = r8;
    }

    public void setArguments(Bundle r8) {
        if (this.mFragmentManager != null) goto L5;
    L9:
        this.mArguments = r8;
        return;
    L5:
        if (isStateSaved() == false) goto L9;
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public void setEnterSharedElementCallback(androidx.core.app.r r8) {
        ensureAnimationInfo().getClass();
    }

    public void setEnterTransition(Object r8) {
        ensureAnimationInfo().f1846k = r8;
    }

    public void setExitSharedElementCallback(androidx.core.app.r r8) {
        ensureAnimationInfo().getClass();
    }

    public void setExitTransition(Object r8) {
        ensureAnimationInfo().f1848m = r8;
    }

    public void setFocusedView(View r8) {
        ensureAnimationInfo().f1855t = r8;
    }

    public void setHasOptionsMenu(boolean r8) {
        if (this.mHasMenu == r8) goto L10;
        this.mHasMenu = r8;
        if (isAdded() == true) goto L7;
        return;
    L7:
        if (isHidden() == true) goto L12;
        this.mHost.g();
        return;
    L12:
        return;
    }

    void setHideReplaced(boolean r8) {
        ensureAnimationInfo().f1857v = r8;
    }

    public void setInitialSavedState(SavedState r8) {
        if (this.mFragmentManager != null) goto L12;
        if (r8 == null) goto L8;
        Bundle r10 = r8.f1823a;
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

    public void setMenuVisibility(boolean r8) {
        if (this.mMenuVisible == r8) goto L12;
        this.mMenuVisible = r8;
        if (this.mHasMenu == true) goto L7;
        return;
    L7:
        if (isAdded() == true) goto L9;
        return;
    L9:
        if (isHidden() == true) goto L15;
        this.mHost.g();
        return;
    L15:
        return;
    }

    public void setNextTransition(int r8) {
        if (this.mAnimationInfo != null) goto L6;
        if (r8 != 0) goto L6;
        return;
    L6:
        ensureAnimationInfo();
        this.mAnimationInfo.f1843h = r8;
    }

    public void setOnStartEnterTransitionListener(l r8) {
        ensureAnimationInfo();
        i r10 = this.mAnimationInfo;
        r10.getClass();
        if (r8 != null) goto L6;
        return;
    L6:
        if (r10.f1856u == false) goto L8;
        r10.getClass();
    L8:
        if (r8 == null) goto L11;
        ((FragmentManager.m) r8).f1900a++;
        return;
    }

    public void setPopDirection(boolean r8) {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        ensureAnimationInfo().f1838c = r8;
    }

    public void setPostOnViewCreatedAlpha(float r8) {
        ensureAnimationInfo().f1854s = r8;
    }

    public void setReenterTransition(Object r8) {
        ensureAnimationInfo().f1849n = r8;
    }

    @Deprecated
    public void setRetainInstance(boolean r8) {
        this.mRetainInstance = r8;
        FragmentManager r10 = this.mFragmentManager;
        if (r10 == null) goto L7;
        if (r8 == false) goto L6;
        r10.H.c(this);
        return;
    L6:
        r10.H.d(this);
        return;
    L7:
        this.mRetainInstanceChangedWhileDetached = true;
    }

    public void setReturnTransition(Object r8) {
        ensureAnimationInfo().f1847l = r8;
    }

    public void setSharedElementEnterTransition(Object r8) {
        ensureAnimationInfo().f1850o = r8;
    }

    public void setSharedElementNames(ArrayList<String> r8, ArrayList<String> r10) {
        ensureAnimationInfo();
        i r11 = this.mAnimationInfo;
        r11.f1844i = r8;
        r11.f1845j = r10;
    }

    public void setSharedElementReturnTransition(Object r8) {
        ensureAnimationInfo().f1851p = r8;
    }

    @Deprecated
    public void setTargetFragment(Fragment r8, int r10) {
        FragmentManager r11 = this.mFragmentManager;
        if (r8 == null) goto L5;
        FragmentManager r12 = r8.mFragmentManager;
    L6:
        if (r11 == null) goto L12;
        if (r12 == null) goto L12;
        if (r11 == r12) goto L12;
        throw new IllegalArgumentException(android.aimedia.a.e("Fragment ", r8, " must share the same FragmentManager to be set as a target fragment"));
    L12:
        Fragment r13 = r8;
    L13:
        if (r13 == null) goto L19;
        if (r13.equals(this) == true) goto L18;
        r13 = r13.getTargetFragment();
        goto L13
    L18:
        throw new IllegalArgumentException("Setting " + r8 + " as the target of " + this + " would create a target cycle");
    L19:
        if (r8 != null) goto L22;
        this.mTargetWho = null;
    L26:
        this.mTarget = null;
    L28:
        this.mTargetRequestCode = r10;
        return;
    L22:
        if (this.mFragmentManager != null) goto L24;
    L27:
        this.mTargetWho = null;
        this.mTarget = r8;
        goto L28
    L24:
        if (r8.mFragmentManager == null) goto L27;
        this.mTargetWho = r8.mWho;
        goto L26
    L5:
        r12 = null;
        goto L6
    }

    @Deprecated
    public void setUserVisibleHint(boolean r8) {
        boolean r10 = true;
        if (this.mUserVisibleHint == true) goto L19;
        if (r8 == false) goto L19;
        if (this.mState >= 5) goto L19;
        if (this.mFragmentManager == null) goto L19;
        if (isAdded() == false) goto L19;
        if (this.mIsCreated == false) goto L19;
        FragmentManager r11 = this.mFragmentManager;
        x r12 = r11.g(this);
        Fragment r13 = r12.f2060c;
        if (r13.mDeferStart == false) goto L19;
        if (r11.f1863b == false) goto L18;
        r11.D = true;
        goto L19
    L18:
        r13.mDeferStart = false;
        r12.k();
    L19:
        this.mUserVisibleHint = r8;
        if (this.mState >= 5) goto L23;
        if (r8 == true) goto L23;
    L24:
        this.mDeferStart = r10;
        if (this.mSavedFragmentState == null) goto L28;
        this.mSavedUserVisibleHint = Boolean.valueOf(r8);
        return;
    L28:
        return;
    L23:
        r10 = false;
        goto L24
    }

    public boolean shouldShowRequestPermissionRationale(String r8) {
        r<?> r10 = this.mHost;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.f(r8);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent r8) {
        startActivity(r8, null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent r8, int r10) {
        startActivityForResult(r8, r10, null);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender r12, int r13, Intent r14, int r15, int r16, int r17, Bundle r18) {
        Intent r8 = r14;
        if (this.mHost == null) goto L27;
        if (FragmentManager.G(2) == false) goto L7;
        Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + r13 + " IntentSender: " + r12 + " fillInIntent: " + r14 + " options: " + r18);
    L7:
        FragmentManager r10 = getParentFragmentManager();
        if (r10.f1884w == null) goto L20;
        if (r18 == null) goto L16;
        if (r8 != null) goto L13;
        r8 = new Intent();
        r8.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
    L13:
        if (FragmentManager.G(2) == false) goto L15;
        Log.v("FragmentManager", "ActivityOptions " + r18 + " were added to fillInIntent " + r8 + " for fragment " + this);
    L15:
        r8.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", r18);
    L16:
        IntentSenderRequest r11 = new IntentSenderRequest(new IntentSenderRequest.a(r12).f515a, r8, r15, r16);
        r10.f1886y.addLast(new FragmentManager.LaunchedFragmentInfo(this.mWho, r13));
        if (FragmentManager.G(2) == false) goto L19;
        Log.v("FragmentManager", "Fragment " + this + "is launching an IntentSender for result ");
    L19:
        r10.f1884w.a(r11);
        return;
    L20:
        r<?> r19 = r10.f1877p;
        if (r13 != (-1)) goto L24;
        Activity r20 = r19.f2042a;
        int r21 = androidx.core.app.a.f1587c;
        androidx.core.app.a.C0010a.c(r20, r12, r13, r14, r15, r16, r17, r18);
        return;
    L24:
        r19.getClass();
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    L27:
        throw new IllegalStateException(android.aimedia.a.e("Fragment ", this, " not attached to Activity"));
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        if (ensureAnimationInfo().f1856u == true) goto L8;
        return;
    L8:
        if (this.mHost != null) goto L11;
        ensureAnimationInfo().f1856u = false;
        return;
    L11:
        if (Looper.myLooper() == this.mHost.f2044m.getLooper()) goto L13;
        this.mHost.f2044m.postAtFrontOfQueue(new b(this));
        return;
    L13:
        callStartTransitionListener(true);
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder(128);
        r8.append(getClass().getSimpleName());
        r8.append("{");
        r8.append(Integer.toHexString(System.identityHashCode(this)));
        r8.append("} (");
        r8.append(this.mWho);
        if (this.mFragmentId == 0) goto L6;
        r8.append(" id=0x");
        r8.append(Integer.toHexString(this.mFragmentId));
    L6:
        if (this.mTag == null) goto L8;
        r8.append(" tag=");
        r8.append(this.mTag);
    L8:
        r8.append(")");
        return r8.toString();
    }

    public void unregisterForContextMenu(View r8) {
        r8.setOnCreateContextMenuListener(null);
    }

    public Fragment(int r8) {
        this();
        this.mContentLayoutId = r8;
    }

    @Deprecated
    public static Fragment instantiate(Context r8, String r10, Bundle r11) {
        Fragment r12 = q.b(r8.getClassLoader(), r10).getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 InstantiationException -> L16
        if (r11 == null) goto L6;
        r11.setClassLoader(r12.getClass().getClassLoader());     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 InstantiationException -> L16
        r12.setArguments(r11);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 InstantiationException -> L16
    L6:
        return r12;
    L13:
        e = move-exception;
        throw new j(defpackage.b.d("Unable to instantiate fragment ", r10, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
    L16:
        e = move-exception;
        throw new j(defpackage.b.d("Unable to instantiate fragment ", r10, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
    L10:
        e = move-exception;
        throw new j(defpackage.b.d("Unable to instantiate fragment ", r10, ": could not find Fragment constructor"), e);
    L7:
        e = move-exception;
        throw new j(defpackage.b.d("Unable to instantiate fragment ", r10, ": calling Fragment constructor caused an exception"), e);
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle r8) {
        r<?> r10 = this.mHost;
        if (r10 == null) goto L7;
        LayoutInflater r11 = r10.e();
        r11.setFactory2(this.mChildFragmentManager.f1867f);
        return r11;
    L7:
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public final String getString(int r8, Object... r10) {
        return getResources().getString(r8, r10);
    }

    public void onAttach(Context r8) {
        this.mCalled = true;
        r<?> r10 = this.mHost;
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
        r11 = r10.f2042a;
        goto L6
    }

    public void onInflate(Context r8, AttributeSet r10, Bundle r11) {
        this.mCalled = true;
        r<?> r12 = this.mHost;
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
        r13 = r12.f2042a;
        goto L6
    }

    public final void postponeEnterTransition(long r8, TimeUnit r10) {
        ensureAnimationInfo().f1856u = true;
        FragmentManager r11 = this.mFragmentManager;
        if (r11 == null) goto L5;
        Handler r12 = r11.f1877p.f2044m;
    L6:
        r12.removeCallbacks(this.mPostponedDurationRunnable);
        r12.postDelayed(this.mPostponedDurationRunnable, r10.toMillis(r8));
        return;
    L5:
        r12 = new Handler(Looper.getMainLooper());
        goto L6
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(b.a<I, O> r8, androidx.activity.result.e r10, androidx.activity.result.a<O> r11) {
        return prepareCallInternal(r8, new f(r10), r11);
    }

    final void restoreViewState(Bundle r8) {
        SparseArray<Parcelable> r10 = this.mSavedViewState;
        if (r10 == null) goto L6;
        this.mView.restoreHierarchyState(r10);
        this.mSavedViewState = null;
    L6:
        if (this.mView == null) goto L8;
        g0 r11 = this.mViewLifecycleOwner;
        Bundle r12 = this.mSavedViewRegistryState;
        r11.f1966m.b(r12);
        this.mSavedViewRegistryState = null;
    L8:
        this.mCalled = false;
        onViewStateRestored(r8);
        if (this.mCalled == false) goto L15;
        if (this.mView == null) goto L16;
        this.mViewLifecycleOwner.a(androidx.lifecycle.h.a.ON_CREATE);
        return;
    L16:
        return;
    L15:
        throw new k0(android.aimedia.a.e("Fragment ", this, " did not call through to super.onViewStateRestored()"));
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent r8, Bundle r10) {
        r<?> r11 = this.mHost;
        if (r11 == null) goto L7;
        Object r12 = androidx.core.content.a.f1674a;
        androidx.core.content.a.C0011a.b(r11.f2043b, r8, r10);
        return;
    L7:
        throw new IllegalStateException(android.aimedia.a.e("Fragment ", this, " not attached to Activity"));
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent r8, int r10, Bundle r11) {
        if (this.mHost == null) goto L18;
        FragmentManager r12 = getParentFragmentManager();
        if (r12.f1883v == null) goto L11;
        FragmentManager.LaunchedFragmentInfo r13 = new FragmentManager.LaunchedFragmentInfo(this.mWho, r10);
        r12.f1886y.addLast(r13);
        if (r8 == null) goto L10;
        if (r11 == null) goto L10;
        r8.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", r11);
    L10:
        r12.f1883v.a(r8);
        return;
    L11:
        r<?> r14 = r12.f1877p;
        r14.getClass();
        if (r10 != (-1)) goto L16;
        Object r15 = androidx.core.content.a.f1674a;
        androidx.core.content.a.C0011a.b(r14.f2043b, r8, r11);
        return;
    L16:
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    L18:
        throw new IllegalStateException(android.aimedia.a.e("Fragment ", this, " not attached to Activity"));
    }
}
