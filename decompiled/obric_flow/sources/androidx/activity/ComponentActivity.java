package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.DoNotInline;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements ContextAware, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, ActivityResultCaller, OnConfigurationChangedProvider, OnTrimMemoryProvider, OnNewIntentProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, MenuHost, FullyDrawnReporterOwner {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;

    @LayoutRes
    private int mContentLayoutId;
    final ContextAwareHelper mContextAwareHelper;
    private ViewModelProvider.Factory mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;

    @NonNull
    final FullyDrawnReporter mFullyDrawnReporter;
    private final LifecycleRegistry mLifecycleRegistry;
    private final MenuHostHelper mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<Consumer<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<Consumer<MultiWindowModeChangedInfo>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<Consumer<PictureInPictureModeChangedInfo>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Integer>> mOnTrimMemoryListeners;
    final ReportFullyDrawnExecutor mReportFullyDrawnExecutor;
    final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    @RequiresApi(19)
    public static class Api19Impl {
        private Api19Impl() {
        }

        public static void cancelPendingInputEvents(View r5) {
            r5.cancelPendingInputEvents();
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity r5) {
            return r5.getOnBackInvokedDispatcher();
        }
    }

    public static final class NonConfigurationInstances {
        Object custom;
        ViewModelStore viewModelStore;

        public NonConfigurationInstances() {
        }
    }

    public interface ReportFullyDrawnExecutor extends Executor {
        void activityDestroyed();

        void viewCreated(@NonNull View r5);
    }

    public static class ReportFullyDrawnExecutorApi1 implements ReportFullyDrawnExecutor {
        final Handler mHandler;

        public ReportFullyDrawnExecutorApi1() {
            this.mHandler = createHandler();
        }

        @NonNull
        private Handler createHandler() {
            Looper r5 = Looper.myLooper();
            if (r5 != null) goto L6;
            r5 = Looper.getMainLooper();
        L6:
            return new Handler(r5);
        }

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public void activityDestroyed() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r5) {
            this.mHandler.postAtFrontOfQueue(r5);
        }

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public void viewCreated(@NonNull View r5) {
        }
    }

    @RequiresApi(16)
    public class ReportFullyDrawnExecutorApi16Impl implements ReportFullyDrawnExecutor, ViewTreeObserver.OnDrawListener, Runnable {
        final long mEndWatchTimeMillis;
        boolean mOnDrawScheduled;
        Runnable mRunnable;
        final /* synthetic */ ComponentActivity this$0;

        public ReportFullyDrawnExecutorApi16Impl(ComponentActivity r5) {
            this.this$0 = r5;
            this.mEndWatchTimeMillis = SystemClock.uptimeMillis() + 10000;
            this.mOnDrawScheduled = false;
        }

        public static /* synthetic */ void a(ReportFullyDrawnExecutorApi16Impl r5) {
            r5.lambda$execute$0();
        }

        private /* synthetic */ void lambda$execute$0() {
            Runnable r5 = this.mRunnable;
            if (r5 == null) goto L6;
            r5.run();
            this.mRunnable = null;
            return;
        }

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public void activityDestroyed() {
            this.this$0.getWindow().getDecorView().removeCallbacks(this);
            this.this$0.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r5) {
            this.mRunnable = r5;
            View r10 = this.this$0.getWindow().getDecorView();
            if (this.mOnDrawScheduled == true) goto L5;
            r10.postOnAnimation(new d(this, 0));
            return;
        L5:
            if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
            r10.invalidate();
            return;
        L7:
            r10.postInvalidate();
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable r5 = this.mRunnable;
            if (r5 == null) goto L8;
            r5.run();
            this.mRunnable = null;
            if (this.this$0.mFullyDrawnReporter.isFullyDrawnReported() == false) goto L11;
            this.mOnDrawScheduled = false;
            this.this$0.getWindow().getDecorView().post(this);
            return;
        L11:
            return;
        L8:
            if (SystemClock.uptimeMillis() <= this.mEndWatchTimeMillis) goto L13;
            this.mOnDrawScheduled = false;
            this.this$0.getWindow().getDecorView().post(this);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public void viewCreated(@NonNull View r5) {
            if (this.mOnDrawScheduled == true) goto L6;
            this.mOnDrawScheduled = true;
            r5.getViewTreeObserver().addOnDrawListener(this);
            return;
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new ContextAwareHelper();
        this.mMenuHostHelper = new MenuHostHelper(new d(this, 1));
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController r5 = SavedStateRegistryController.create(this);
        this.mSavedStateRegistryController = r5;
        this.mOnBackPressedDispatcher = null;
        ReportFullyDrawnExecutor r10 = createFullyDrawnExecutor();
        this.mReportFullyDrawnExecutor = r10;
        this.mFullyDrawnReporter = new FullyDrawnReporter(r10, new a(this));
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new AnonymousClass1(this);
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) goto L7;
        getLifecycle().addObserver(new AnonymousClass2(this));
        getLifecycle().addObserver(new AnonymousClass3(this));
        getLifecycle().addObserver(new AnonymousClass4(this));
        r5.performAttach();
        SavedStateHandleSupport.enableSavedStateHandles(this);
        getSavedStateRegistry().registerSavedStateProvider(ACTIVITY_RESULT_TAG, new b(this));
        addOnContextAvailableListener(new c(this));
        return;
    L7:
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public static /* synthetic */ void a(ComponentActivity r5, Context r10) {
        r5.lambda$new$2(r10);
    }

    public static /* synthetic */ void access$001(ComponentActivity r5) {
        super.onBackPressed();
    }

    public static /* synthetic */ OnBackPressedDispatcher access$100(ComponentActivity r5) {
        return r5.mOnBackPressedDispatcher;
    }

    public static /* synthetic */ Bundle b(ComponentActivity r5) {
        return r5.lambda$new$1();
    }

    public static /* synthetic */ Unit c(ComponentActivity r5) {
        return r5.lambda$new$0();
    }

    private ReportFullyDrawnExecutor createFullyDrawnExecutor() {
        return new ReportFullyDrawnExecutorApi16Impl(this);
    }

    private /* synthetic */ Unit lambda$new$0() {
        reportFullyDrawn();
        return null;
    }

    private /* synthetic */ Bundle lambda$new$1() {
        Bundle r5 = new Bundle();
        this.mActivityResultRegistry.onSaveInstanceState(r5);
        return r5;
    }

    private /* synthetic */ void lambda$new$2(Context r5) {
        Bundle r10 = getSavedStateRegistry().consumeRestoredStateForKey(ACTIVITY_RESULT_TAG);
        if (r10 == null) goto L6;
        this.mActivityResultRegistry.onRestoreInstanceState(r10);
        return;
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View r5, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams r10) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.addContentView(r5, r10);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider r5) {
        this.mMenuHostHelper.addMenuProvider(r5);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void addOnConfigurationChangedListener(@NonNull Consumer<Configuration> r5) {
        this.mOnConfigurationChangedListeners.add(r5);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void addOnContextAvailableListener(@NonNull OnContextAvailableListener r5) {
        this.mContextAwareHelper.addOnContextAvailableListener(r5);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void addOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> r5) {
        this.mOnMultiWindowModeChangedListeners.add(r5);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void addOnNewIntentListener(@NonNull Consumer<Intent> r5) {
        this.mOnNewIntentListeners.add(r5);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void addOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> r5) {
        this.mOnPictureInPictureModeChangedListeners.add(r5);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void addOnTrimMemoryListener(@NonNull Consumer<Integer> r5) {
        this.mOnTrimMemoryListeners.add(r5);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore != null) goto L11;
        NonConfigurationInstances r5 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r5 == null) goto L8;
        this.mViewModelStore = r5.viewModelStore;
    L8:
        if (this.mViewModelStore != null) goto L12;
        this.mViewModelStore = new ViewModelStore();
        return;
    L12:
        return;
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    @NonNull
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    @CallSuper
    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras r5 = new MutableCreationExtras();
        if (getApplication() == null) goto L5;
        r5.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, getApplication());
    L5:
        r5.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        r5.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getIntent() != null) goto L8;
    L10:
        return r5;
    L8:
        if (getIntent().getExtras() == null) goto L10;
        r5.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getIntent().getExtras());
        goto L10
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory != null) goto L10;
        Application r5 = getApplication();
        if (getIntent() == null) goto L7;
        Bundle r10 = getIntent().getExtras();
    L8:
        this.mDefaultFactory = new SavedStateViewModelFactory(r5, this, r10);
        goto L10
    L7:
        r10 = null;
    L10:
        return this.mDefaultFactory;
    }

    @Override // androidx.activity.FullyDrawnReporterOwner
    @NonNull
    public FullyDrawnReporter getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Nullable
    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances r5 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.custom;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    @NonNull
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher != null) goto L6;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new AnonymousClass5(this));
        getLifecycle().addObserver(new AnonymousClass6(this));
    L6:
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @NonNull
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        if (getApplication() == null) goto L7;
        ensureViewModelStore();
        return this.mViewModelStore;
    L7:
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @CallSuper
    public void initializeViewTreeOwners() {
        ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.set(getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.set(getWindow().getDecorView(), this);
        ViewTreeFullyDrawnReporterOwner.set(getWindow().getDecorView(), this);
    }

    @Override // androidx.core.view.MenuHost
    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    @CallSuper
    @Deprecated
    public void onActivityResult(int r5, int r10, @Nullable Intent r11) {
        if (this.mActivityResultRegistry.dispatchResult(r5, r10, r11) == true) goto L6;
        super.onActivityResult(r5, r10, r11);
        return;
    }

    @Override // android.app.Activity
    @CallSuper
    @MainThread
    @Deprecated
    public void onBackPressed() {
        getOnBackPressedDispatcher().onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration r5) {
        super.onConfigurationChanged(r5);
        Iterator<Consumer<Configuration>> r10 = this.mOnConfigurationChangedListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().accept(r5);
        goto L4
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle r5) {
        this.mSavedStateRegistryController.performRestore(r5);
        this.mContextAwareHelper.dispatchOnContextAvailable(this);
        super.onCreate(r5);
        ReportFragment.injectIfNeededIn(this);
        int r10 = this.mContentLayoutId;
        if (r10 == 0) goto L6;
        setContentView(r10);
        return;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r5, @NonNull Menu r10) {
        if (r5 != 0) goto L6;
        super.onCreatePanelMenu(r5, r10);
        this.mMenuHostHelper.onCreateMenu(r10, getMenuInflater());
        return true;
    L6:
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r5, @NonNull MenuItem r10) {
        if (super.onMenuItemSelected(r5, r10) == false) goto L6;
        return true;
    L6:
        if (r5 == 0) goto L8;
        return false;
    L8:
        return this.mMenuHostHelper.onMenuItemSelected(r10);
    }

    @Override // android.app.Activity
    @CallSuper
    public void onMultiWindowModeChanged(boolean r5) {
        if (this.mDispatchingOnMultiWindowModeChanged == false) goto L5;
        return;
    L5:
        Iterator<Consumer<MultiWindowModeChangedInfo>> r10 = this.mOnMultiWindowModeChangedListeners.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r10.next().accept(new MultiWindowModeChangedInfo(r5));
        goto L7
    }

    @Override // android.app.Activity
    @CallSuper
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent r5) {
        super.onNewIntent(r5);
        Iterator<Consumer<Intent>> r10 = this.mOnNewIntentListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().accept(r5);
        goto L4
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r5, @NonNull Menu r10) {
        this.mMenuHostHelper.onMenuClosed(r10);
        super.onPanelClosed(r5, r10);
    }

    @Override // android.app.Activity
    @CallSuper
    public void onPictureInPictureModeChanged(boolean r5) {
        if (this.mDispatchingOnPictureInPictureModeChanged == false) goto L5;
        return;
    L5:
        Iterator<Consumer<PictureInPictureModeChangedInfo>> r10 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r10.next().accept(new PictureInPictureModeChangedInfo(r5));
        goto L7
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r5, @Nullable View r10, @NonNull Menu r11) {
        if (r5 != 0) goto L6;
        super.onPreparePanel(r5, r10, r11);
        this.mMenuHostHelper.onPrepareMenu(r11);
        return true;
    L6:
        return true;
    }

    @Override // android.app.Activity
    @CallSuper
    @Deprecated
    public void onRequestPermissionsResult(int r5, @NonNull String[] r10, @NonNull int[] r11) {
        if (this.mActivityResultRegistry.dispatchResult(r5, -1, new Intent().putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS, r10).putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS, r11)) == true) goto L6;
        super.onRequestPermissionsResult(r5, r10, r11);
        return;
    }

    @Nullable
    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    @Nullable
    public final Object onRetainNonConfigurationInstance() {
        Object r5 = onRetainCustomNonConfigurationInstance();
        ViewModelStore r10 = this.mViewModelStore;
        if (r10 != null) goto L7;
        NonConfigurationInstances r11 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r11 == null) goto L7;
        r10 = r11.viewModelStore;
    L7:
        if (r10 != null) goto L11;
        if (r5 != null) goto L11;
        return null;
    L11:
        NonConfigurationInstances r12 = new NonConfigurationInstances();
        r12.custom = r5;
        r12.viewModelStore = r10;
        return r12;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    @CallSuper
    public void onSaveInstanceState(@NonNull Bundle r5) {
        Lifecycle r10 = getLifecycle();
        if ((r10 instanceof LifecycleRegistry) == false) goto L5;
        ((LifecycleRegistry) r10).setCurrentState(Lifecycle.State.CREATED);
    L5:
        super.onSaveInstanceState(r5);
        this.mSavedStateRegistryController.performSave(r5);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    @CallSuper
    public void onTrimMemory(int r5) {
        super.onTrimMemory(r5);
        Iterator<Consumer<Integer>> r10 = this.mOnTrimMemoryListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().accept(Integer.valueOf(r5));
        goto L4
    }

    @Override // androidx.activity.contextaware.ContextAware
    @Nullable
    public Context peekAvailableContext() {
        return this.mContextAwareHelper.peekAvailableContext();
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> r5, @NonNull ActivityResultRegistry r10, @NonNull ActivityResultCallback<O> r11) {
        return r10.register("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, r5, r11);
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(@NonNull MenuProvider r5) {
        this.mMenuHostHelper.removeMenuProvider(r5);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void removeOnConfigurationChangedListener(@NonNull Consumer<Configuration> r5) {
        this.mOnConfigurationChangedListeners.remove(r5);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void removeOnContextAvailableListener(@NonNull OnContextAvailableListener r5) {
        this.mContextAwareHelper.removeOnContextAvailableListener(r5);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void removeOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> r5) {
        this.mOnMultiWindowModeChangedListeners.remove(r5);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void removeOnNewIntentListener(@NonNull Consumer<Intent> r5) {
        this.mOnNewIntentListeners.remove(r5);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void removeOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> r5) {
        this.mOnPictureInPictureModeChangedListeners.remove(r5);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void removeOnTrimMemoryListener(@NonNull Consumer<Integer> r5) {
        this.mOnTrimMemoryListeners.remove(r5);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
    L5:
        th = move-exception;
        Trace.endSection();
        throw th;
    L3:
        if (Trace.isEnabled() == false) goto L7;
        Trace.beginSection("reportFullyDrawn() for ComponentActivity");     // Catch: Throwable -> L5
    L7:
        super.reportFullyDrawn();     // Catch: Throwable -> L5
        this.mFullyDrawnReporter.fullyDrawnReported();     // Catch: Throwable -> L5
        Trace.endSection();
    }

    @Override // android.app.Activity
    public void setContentView(@LayoutRes int r5) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(r5);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@NonNull Intent r5, int r10) {
        super.startActivityForResult(r5, r10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender r5, int r10, @Nullable Intent r11, int r12, int r13, int r14) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(r5, r10, r11, r12, r13, r14);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider r5, @NonNull LifecycleOwner r10) {
        this.mMenuHostHelper.addMenuProvider(r5, r10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@NonNull Intent r5, int r10, @Nullable Bundle r11) {
        super.startActivityForResult(r5, r10, r11);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender r5, int r10, @Nullable Intent r11, int r12, int r13, int r14, @Nullable Bundle r15) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(r5, r10, r11, r12, r13, r14, r15);
    }

    @Override // androidx.core.view.MenuHost
    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull MenuProvider r5, @NonNull LifecycleOwner r10, @NonNull Lifecycle.State r11) {
        this.mMenuHostHelper.addMenuProvider(r5, r10, r11);
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    @CallSuper
    public void onMultiWindowModeChanged(boolean r5, @NonNull Configuration r10) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        super.onMultiWindowModeChanged(r5, r10);     // Catch: Throwable -> L9
        this.mDispatchingOnMultiWindowModeChanged = false;
        Iterator<Consumer<MultiWindowModeChangedInfo>> r11 = this.mOnMultiWindowModeChangedListeners.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r11.next().accept(new MultiWindowModeChangedInfo(r5, r10));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnMultiWindowModeChanged = false;
        throw th;
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    @CallSuper
    public void onPictureInPictureModeChanged(boolean r5, @NonNull Configuration r10) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        super.onPictureInPictureModeChanged(r5, r10);     // Catch: Throwable -> L9
        this.mDispatchingOnPictureInPictureModeChanged = false;
        Iterator<Consumer<PictureInPictureModeChangedInfo>> r11 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r11.next().accept(new PictureInPictureModeChangedInfo(r5, r10));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        throw th;
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> r5, @NonNull ActivityResultCallback<O> r10) {
        return registerForActivityResult(r5, this.mActivityResultRegistry, r10);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View r5) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(r5);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View r5, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams r10) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(r5, r10);
    }

    @ContentView
    public ComponentActivity(@LayoutRes int r5) {
        this();
        this.mContentLayoutId = r5;
    }
}
