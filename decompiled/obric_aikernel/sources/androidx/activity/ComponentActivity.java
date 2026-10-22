package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.ContextCompat;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.os.BuildCompat;
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
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements ContextAware, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, ActivityResultCaller, OnConfigurationChangedProvider, OnTrimMemoryProvider, OnNewIntentProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, MenuHost {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;

    @LayoutRes
    private int mContentLayoutId;
    final ContextAwareHelper mContextAwareHelper;
    private ViewModelProvider.Factory mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    private final LifecycleRegistry mLifecycleRegistry;
    private final MenuHostHelper mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<Consumer<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<Consumer<MultiWindowModeChangedInfo>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<Consumer<PictureInPictureModeChangedInfo>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Integer>> mOnTrimMemoryListeners;
    final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        static void cancelPendingInputEvents(View r10) {
            r10.cancelPendingInputEvents();
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity r10) {
            return r10.getOnBackInvokedDispatcher();
        }
    }

    static final class NonConfigurationInstances {
        Object custom;
        ViewModelStore viewModelStore;

        NonConfigurationInstances() {
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new ContextAwareHelper();
        this.mMenuHostHelper = new MenuHostHelper(new c(this));
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController r10 = SavedStateRegistryController.create(this);
        this.mSavedStateRegistryController = r10;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new AnonymousClass1(this));
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new AnonymousClass2(this);
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) goto L15;
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 19) goto L7;
        getLifecycle().addObserver(new AnonymousClass3(this));
    L7:
        getLifecycle().addObserver(new AnonymousClass4(this));
        getLifecycle().addObserver(new AnonymousClass5(this));
        r10.performAttach();
        SavedStateHandleSupport.enableSavedStateHandles(this);
        if (19 <= r11) goto L10;
    L12:
        getSavedStateRegistry().registerSavedStateProvider(ACTIVITY_RESULT_TAG, new b(this));
        addOnContextAvailableListener(new a(this));
        return;
    L10:
        if (r11 > 23) goto L12;
        getLifecycle().addObserver(new ImmLeaksCleaner(this));
        goto L12
    L15:
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    @ContentView
    public ComponentActivity(@LayoutRes int r10) {
        this();
        this.mContentLayoutId = r10;
    }

    public static /* synthetic */ void a(ComponentActivity r10, Context r11) {
        r10.lambda$new$1(r11);
    }

    static /* synthetic */ void access$001(ComponentActivity r10) {
        super.onBackPressed();
    }

    public static /* synthetic */ Bundle b(ComponentActivity r10) {
        return r10.lambda$new$0();
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.set(getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.set(getWindow().getDecorView(), this);
    }

    private /* synthetic */ Bundle lambda$new$0() {
        Bundle r10 = new Bundle();
        this.mActivityResultRegistry.onSaveInstanceState(r10);
        return r10;
    }

    private /* synthetic */ void lambda$new$1(Context r10) {
        Bundle r11 = getSavedStateRegistry().consumeRestoredStateForKey(ACTIVITY_RESULT_TAG);
        if (r11 == null) goto L6;
        this.mActivityResultRegistry.onRestoreInstanceState(r11);
        return;
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View r10, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams r11) {
        initViewTreeOwners();
        super.addContentView(r10, r11);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider r10) {
        this.mMenuHostHelper.addMenuProvider(r10);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider r10, @NonNull LifecycleOwner r11) {
        this.mMenuHostHelper.addMenuProvider(r10, r11);
    }

    @Override // androidx.core.view.MenuHost
    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull MenuProvider r10, @NonNull LifecycleOwner r11, @NonNull Lifecycle.State r12) {
        this.mMenuHostHelper.addMenuProvider(r10, r11, r12);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void addOnConfigurationChangedListener(@NonNull Consumer<Configuration> r10) {
        this.mOnConfigurationChangedListeners.add(r10);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void addOnContextAvailableListener(@NonNull OnContextAvailableListener r10) {
        this.mContextAwareHelper.addOnContextAvailableListener(r10);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void addOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> r10) {
        this.mOnMultiWindowModeChangedListeners.add(r10);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void addOnNewIntentListener(@NonNull Consumer<Intent> r10) {
        this.mOnNewIntentListeners.add(r10);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void addOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> r10) {
        this.mOnPictureInPictureModeChangedListeners.add(r10);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void addOnTrimMemoryListener(@NonNull Consumer<Integer> r10) {
        this.mOnTrimMemoryListeners.add(r10);
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore != null) goto L11;
        NonConfigurationInstances r10 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r10 == null) goto L8;
        this.mViewModelStore = r10.viewModelStore;
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
        MutableCreationExtras r10 = new MutableCreationExtras();
        if (getApplication() == null) goto L5;
        r10.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, getApplication());
    L5:
        r10.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        r10.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getIntent() != null) goto L8;
    L10:
        return r10;
    L8:
        if (getIntent().getExtras() == null) goto L10;
        r10.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getIntent().getExtras());
        goto L10
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory != null) goto L10;
        Application r10 = getApplication();
        if (getIntent() == null) goto L7;
        Bundle r11 = getIntent().getExtras();
    L8:
        this.mDefaultFactory = new SavedStateViewModelFactory(r10, this, r11);
        goto L10
    L7:
        r11 = null;
    L10:
        return this.mDefaultFactory;
    }

    @Nullable
    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances r10 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.custom;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    @NonNull
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
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

    @Override // androidx.core.view.MenuHost
    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    @CallSuper
    @Deprecated
    protected void onActivityResult(int r10, int r11, @Nullable Intent r12) {
        if (this.mActivityResultRegistry.dispatchResult(r10, r11, r12) == true) goto L6;
        super.onActivityResult(r10, r11, r12);
        return;
    }

    @Override // android.app.Activity
    @MainThread
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration r10) {
        super.onConfigurationChanged(r10);
        Iterator<Consumer<Configuration>> r11 = this.mOnConfigurationChangedListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().accept(r10);
        goto L4
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    protected void onCreate(@Nullable Bundle r10) {
        this.mSavedStateRegistryController.performRestore(r10);
        this.mContextAwareHelper.dispatchOnContextAvailable(this);
        super.onCreate(r10);
        ReportFragment.injectIfNeededIn(this);
        if (BuildCompat.isAtLeastT() == false) goto L5;
        this.mOnBackPressedDispatcher.setOnBackInvokedDispatcher(Api33Impl.getOnBackInvokedDispatcher(this));
    L5:
        int r11 = this.mContentLayoutId;
        if (r11 == 0) goto L9;
        setContentView(r11);
        return;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r10, @NonNull Menu r11) {
        if (r10 != 0) goto L6;
        super.onCreatePanelMenu(r10, r11);
        this.mMenuHostHelper.onCreateMenu(r11, getMenuInflater());
        return true;
    L6:
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r10, @NonNull MenuItem r11) {
        if (super.onMenuItemSelected(r10, r11) == false) goto L6;
        return true;
    L6:
        if (r10 == 0) goto L8;
        return false;
    L8:
        return this.mMenuHostHelper.onMenuItemSelected(r11);
    }

    @Override // android.app.Activity
    @CallSuper
    public void onMultiWindowModeChanged(boolean r10) {
        if (this.mDispatchingOnMultiWindowModeChanged == false) goto L5;
        return;
    L5:
        Iterator<Consumer<MultiWindowModeChangedInfo>> r11 = this.mOnMultiWindowModeChangedListeners.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r11.next().accept(new MultiWindowModeChangedInfo(r10));
        goto L7
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    @CallSuper
    public void onMultiWindowModeChanged(boolean r10, @NonNull Configuration r11) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        super.onMultiWindowModeChanged(r10, r11);     // Catch: Throwable -> L9
        this.mDispatchingOnMultiWindowModeChanged = false;
        Iterator<Consumer<MultiWindowModeChangedInfo>> r12 = this.mOnMultiWindowModeChangedListeners.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r12.next().accept(new MultiWindowModeChangedInfo(r10, r11));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnMultiWindowModeChanged = false;
        throw th;
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent r10) {
        super.onNewIntent(r10);
        Iterator<Consumer<Intent>> r11 = this.mOnNewIntentListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().accept(r10);
        goto L4
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r10, @NonNull Menu r11) {
        this.mMenuHostHelper.onMenuClosed(r11);
        super.onPanelClosed(r10, r11);
    }

    @Override // android.app.Activity
    @CallSuper
    public void onPictureInPictureModeChanged(boolean r10) {
        if (this.mDispatchingOnPictureInPictureModeChanged == false) goto L5;
        return;
    L5:
        Iterator<Consumer<PictureInPictureModeChangedInfo>> r11 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r11.next().accept(new PictureInPictureModeChangedInfo(r10));
        goto L7
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    @CallSuper
    public void onPictureInPictureModeChanged(boolean r10, @NonNull Configuration r11) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        super.onPictureInPictureModeChanged(r10, r11);     // Catch: Throwable -> L9
        this.mDispatchingOnPictureInPictureModeChanged = false;
        Iterator<Consumer<PictureInPictureModeChangedInfo>> r12 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r12.next().accept(new PictureInPictureModeChangedInfo(r10, r11));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        throw th;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r10, @Nullable View r11, @NonNull Menu r12) {
        if (r10 != 0) goto L6;
        super.onPreparePanel(r10, r11, r12);
        this.mMenuHostHelper.onPrepareMenu(r12);
        return true;
    L6:
        return true;
    }

    @Override // android.app.Activity
    @CallSuper
    @Deprecated
    public void onRequestPermissionsResult(int r10, @NonNull String[] r11, @NonNull int[] r12) {
        if (this.mActivityResultRegistry.dispatchResult(r10, -1, new Intent().putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS, r11).putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS, r12)) == false) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        super.onRequestPermissionsResult(r10, r11, r12);
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
        Object r10 = onRetainCustomNonConfigurationInstance();
        ViewModelStore r11 = this.mViewModelStore;
        if (r11 != null) goto L7;
        NonConfigurationInstances r12 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r12 == null) goto L7;
        r11 = r12.viewModelStore;
    L7:
        if (r11 != null) goto L11;
        if (r10 != null) goto L11;
        return null;
    L11:
        NonConfigurationInstances r13 = new NonConfigurationInstances();
        r13.custom = r10;
        r13.viewModelStore = r11;
        return r13;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    @CallSuper
    protected void onSaveInstanceState(@NonNull Bundle r10) {
        Lifecycle r11 = getLifecycle();
        if ((r11 instanceof LifecycleRegistry) == false) goto L5;
        ((LifecycleRegistry) r11).setCurrentState(Lifecycle.State.CREATED);
    L5:
        super.onSaveInstanceState(r10);
        this.mSavedStateRegistryController.performSave(r10);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    @CallSuper
    public void onTrimMemory(int r10) {
        super.onTrimMemory(r10);
        Iterator<Consumer<Integer>> r11 = this.mOnTrimMemoryListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().accept(Integer.valueOf(r10));
        goto L4
    }

    @Override // androidx.activity.contextaware.ContextAware
    @Nullable
    public Context peekAvailableContext() {
        return this.mContextAwareHelper.peekAvailableContext();
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> r10, @NonNull ActivityResultCallback<O> r11) {
        return registerForActivityResult(r10, this.mActivityResultRegistry, r11);
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> r10, @NonNull ActivityResultRegistry r11, @NonNull ActivityResultCallback<O> r12) {
        return r11.register("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, r10, r12);
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(@NonNull MenuProvider r10) {
        this.mMenuHostHelper.removeMenuProvider(r10);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void removeOnConfigurationChangedListener(@NonNull Consumer<Configuration> r10) {
        this.mOnConfigurationChangedListeners.remove(r10);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void removeOnContextAvailableListener(@NonNull OnContextAvailableListener r10) {
        this.mContextAwareHelper.removeOnContextAvailableListener(r10);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void removeOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> r10) {
        this.mOnMultiWindowModeChangedListeners.remove(r10);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void removeOnNewIntentListener(@NonNull Consumer<Intent> r10) {
        this.mOnNewIntentListeners.remove(r10);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void removeOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> r10) {
        this.mOnPictureInPictureModeChangedListeners.remove(r10);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void removeOnTrimMemoryListener(@NonNull Consumer<Integer> r10) {
        this.mOnTrimMemoryListeners.remove(r10);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
    L14:
        th = move-exception;
        Trace.endSection();
        throw th;
    L3:
        if (Trace.isEnabled() == false) goto L5;
        Trace.beginSection("reportFullyDrawn() for ComponentActivity");     // Catch: Throwable -> L14
    L5:
        int r10 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L14
        if (r10 <= 19) goto L8;
    L7:
        super.reportFullyDrawn();     // Catch: Throwable -> L14
    L12:
        Trace.endSection();
        return;
    L8:
        if (r10 != 19) goto L12;
        if (ContextCompat.checkSelfPermission(this, "android.permission.UPDATE_DEVICE_STATS") != 0) goto L12;
        goto L12
    }

    @Override // android.app.Activity
    public void setContentView(@LayoutRes int r10) {
        initViewTreeOwners();
        super.setContentView(r10);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View r10) {
        initViewTreeOwners();
        super.setContentView(r10);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View r10, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams r11) {
        initViewTreeOwners();
        super.setContentView(r10, r11);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@NonNull Intent r10, int r11) {
        super.startActivityForResult(r10, r11);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@NonNull Intent r10, int r11, @Nullable Bundle r12) {
        super.startActivityForResult(r10, r11, r12);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender r10, int r11, @Nullable Intent r12, int r13, int r14, int r15) {
        super.startIntentSenderForResult(r10, r11, r12, r13, r14, r15);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender r10, int r11, @Nullable Intent r12, int r13, int r14, int r15, @Nullable Bundle r16) {
        super.startIntentSenderForResult(r10, r11, r12, r13, r14, r15, r16);
    }
}
