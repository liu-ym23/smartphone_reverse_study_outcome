package androidx.activity;

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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements OnBackPressedDispatcherOwner, ContextAware, ActivityResultCaller, ActivityResultRegistryOwner, OnMultiWindowModeChangedProvider, OnNewIntentProvider, OnPictureInPictureModeChangedProvider, OnConfigurationChangedProvider, OnTrimMemoryProvider, MenuHost, HasDefaultViewModelProviderFactory, LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
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

    static class Api19Impl {
        private Api19Impl() {
        }

        static void cancelPendingInputEvents(View r0) {
            r0.cancelPendingInputEvents();
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity r2) {
            return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).getOnBackInvokedDispatcher();
        }
    }

    static final class NonConfigurationInstances {
        Object custom;
        ViewModelStore viewModelStore;

        NonConfigurationInstances() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentActivity() {
        this.mContextAwareHelper = new ContextAwareHelper();
        this.mMenuHostHelper = new MenuHostHelper(new $$Lambda$6vUCJMIem6_TsIeNg4KPj4HWSJA(this));
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController r0 = SavedStateRegistryController.create(this);
        this.mSavedStateRegistryController = r0;
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
        if (Build.VERSION.SDK_INT < 19) goto L7;
        getLifecycle().addObserver(new AnonymousClass3(this));
    L7:
        getLifecycle().addObserver(new AnonymousClass4(this));
        getLifecycle().addObserver(new AnonymousClass5(this));
        r0.performAttach();
        SavedStateHandleSupport.enableSavedStateHandles(this);
        if (19 <= Build.VERSION.SDK_INT) goto L10;
    L12:
        getSavedStateRegistry().registerSavedStateProvider(ACTIVITY_RESULT_TAG, new $$Lambda$ComponentActivity$uMG6y9sMaPUFZmnRrSgWpORKiAI(this));
        addOnContextAvailableListener(new $$Lambda$ComponentActivity$Mg7hF6_XzI8jXHyb9wZTvbC5nA(this));
        return;
    L10:
        if (Build.VERSION.SDK_INT > 23) goto L12;
        getLifecycle().addObserver(new ImmLeaksCleaner(this));
        goto L12
    L15:
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public ComponentActivity(int r1) {
        this();
        this.mContentLayoutId = r1;
    }

    static /* synthetic */ void access$001(ComponentActivity r2) {
        super.onBackPressed();
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.set(getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.set(getWindow().getDecorView(), this);
    }

    public void addContentView(View r1, ViewGroup.LayoutParams r2) {
        initViewTreeOwners();
        super.addContentView(r1, r2);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider r3) {
        MenuProvider r4 = (MenuProvider) ZeusTransformUtils.wrapperContextForParams(r3, MenuProvider.class, "com.obric.memorydata.plugin");
        this.mMenuHostHelper.addMenuProvider(r4);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider r3, LifecycleOwner r4) {
        MenuProvider r5 = (MenuProvider) ZeusTransformUtils.wrapperContextForParams(r3, MenuProvider.class, "com.obric.memorydata.plugin");
        LifecycleOwner r6 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
        this.mMenuHostHelper.addMenuProvider(r5, r6);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider r3, LifecycleOwner r4, Lifecycle.State r5) {
        MenuProvider r6 = (MenuProvider) ZeusTransformUtils.wrapperContextForParams(r3, MenuProvider.class, "com.obric.memorydata.plugin");
        LifecycleOwner r7 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
        this.mMenuHostHelper.addMenuProvider(r6, r7, r5);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void addOnConfigurationChangedListener(Consumer<Configuration> r3) {
        Consumer<Configuration> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        this.mOnConfigurationChangedListeners.add(r4);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void addOnContextAvailableListener(OnContextAvailableListener r3) {
        OnContextAvailableListener r4 = (OnContextAvailableListener) ZeusTransformUtils.wrapperContextForParams(r3, OnContextAvailableListener.class, "com.obric.memorydata.plugin");
        this.mContextAwareHelper.addOnContextAvailableListener(r4);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void addOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> r3) {
        Consumer<MultiWindowModeChangedInfo> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        this.mOnMultiWindowModeChangedListeners.add(r4);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void addOnNewIntentListener(Consumer<Intent> r3) {
        Consumer<Intent> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        this.mOnNewIntentListeners.add(r4);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void addOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> r3) {
        Consumer<PictureInPictureModeChangedInfo> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        this.mOnPictureInPictureModeChangedListeners.add(r4);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void addOnTrimMemoryListener(Consumer<Integer> r3) {
        Consumer<Integer> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        this.mOnTrimMemoryListeners.add(r4);
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore != null) goto L11;
        NonConfigurationInstances r0 = (NonConfigurationInstances) ZeusTransformUtils.preCheckCast(getLastNonConfigurationInstance(), NonConfigurationInstances.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        this.mViewModelStore = r0.viewModelStore;
    L8:
        if (this.mViewModelStore != null) goto L12;
        this.mViewModelStore = new ViewModelStore();
        return;
    L12:
        return;
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras r0 = new MutableCreationExtras();
        if (((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")) == null) goto L5;
        r0.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"));
    L5:
        r0.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        r0.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getIntent() != null) goto L8;
    L10:
        return r0;
    L8:
        if (getIntent().getExtras() == null) goto L10;
        r0.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getIntent().getExtras());
        goto L10
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory != null) goto L10;
        Application r1 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        if (getIntent() == null) goto L7;
        Bundle r2 = getIntent().getExtras();
    L8:
        this.mDefaultFactory = new SavedStateViewModelFactory(r1, this, r2);
        goto L10
    L7:
        r2 = null;
    L10:
        return this.mDefaultFactory;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances r2 = (NonConfigurationInstances) ZeusTransformUtils.preCheckCast(getLastNonConfigurationInstance(), NonConfigurationInstances.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.custom;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")) == null) goto L7;
        ensureViewModelStore();
        return this.mViewModelStore;
    L7:
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // androidx.core.view.MenuHost
    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    public /* synthetic */ Bundle lambda$new$0$ComponentActivity() {
        Bundle r0 = new Bundle();
        this.mActivityResultRegistry.onSaveInstanceState(r0);
        return r0;
    }

    public /* synthetic */ void lambda$new$1$ComponentActivity(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Bundle r5 = getSavedStateRegistry().consumeRestoredStateForKey(ACTIVITY_RESULT_TAG);
        if (r5 == null) goto L6;
        this.mActivityResultRegistry.onRestoreInstanceState(r5);
        return;
    }

    @Deprecated
    public void onActivityResult(int r2, int r3, Intent r4) {
        if (this.mActivityResultRegistry.dispatchResult(r2, r3, r4) == true) goto L6;
        super.onActivityResult(r2, r3, r4);
        return;
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    public void onConfigurationChanged(Configuration r4) {
        super.onConfigurationChanged(r4);
        Iterator<Consumer<Configuration>> r3 = this.mOnConfigurationChangedListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Consumer) ZeusTransformUtils.preCheckCast(r3.next(), Consumer.class, "com.obric.memorydata.plugin")).accept(r4);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.core.app.ComponentActivity
    public void onCreate(Bundle r2) {
        this.mSavedStateRegistryController.performRestore(r2);
        this.mContextAwareHelper.dispatchOnContextAvailable(this);
        super.onCreate(r2);
        ReportFragment.injectIfNeededIn(this);
        if (BuildCompat.isAtLeastT() == false) goto L5;
        this.mOnBackPressedDispatcher.setOnBackInvokedDispatcher(Api33Impl.getOnBackInvokedDispatcher(this));
    L5:
        int r3 = this.mContentLayoutId;
        if (r3 == 0) goto L9;
        setContentView(r3);
        return;
    }

    public boolean onCreatePanelMenu(int r3, Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
        if (r3 != 0) goto L7;
        super.onCreatePanelMenu(r3, r5);
        this.mMenuHostHelper.onCreateMenu(r5, getMenuInflater());
        return true;
    L7:
        return true;
    }

    public boolean onMenuItemSelected(int r3, MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.memorydata.plugin");
        if (super.onMenuItemSelected(r3, r5) == false) goto L6;
        return true;
    L6:
        if (r3 == 0) goto L8;
        return false;
    L8:
        return this.mMenuHostHelper.onMenuItemSelected(r5);
    }

    public void onMultiWindowModeChanged(boolean r4) {
        if (this.mDispatchingOnMultiWindowModeChanged == false) goto L5;
        return;
    L5:
        Iterator<Consumer<MultiWindowModeChangedInfo>> r3 = this.mOnMultiWindowModeChangedListeners.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((Consumer) ZeusTransformUtils.preCheckCast(r3.next(), Consumer.class, "com.obric.memorydata.plugin")).accept(new MultiWindowModeChangedInfo(r4));
        goto L7
    }

    public void onMultiWindowModeChanged(boolean r4, Configuration r5) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        super.onMultiWindowModeChanged(r4, r5);     // Catch: Throwable -> L9
        this.mDispatchingOnMultiWindowModeChanged = false;
        Iterator<Consumer<MultiWindowModeChangedInfo>> r3 = this.mOnMultiWindowModeChangedListeners.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        ((Consumer) ZeusTransformUtils.preCheckCast(r3.next(), Consumer.class, "com.obric.memorydata.plugin")).accept(new MultiWindowModeChangedInfo(r4, r5));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnMultiWindowModeChanged = false;
        throw th;
    }

    public void onNewIntent(Intent r4) {
        super.onNewIntent(r4);
        Iterator<Consumer<Intent>> r3 = this.mOnNewIntentListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Consumer) ZeusTransformUtils.preCheckCast(r3.next(), Consumer.class, "com.obric.memorydata.plugin")).accept(r4);
        goto L4
    }

    public void onPanelClosed(int r3, Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
        this.mMenuHostHelper.onMenuClosed(r5);
        super.onPanelClosed(r3, r5);
    }

    public void onPictureInPictureModeChanged(boolean r4) {
        if (this.mDispatchingOnPictureInPictureModeChanged == false) goto L5;
        return;
    L5:
        Iterator<Consumer<PictureInPictureModeChangedInfo>> r3 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((Consumer) ZeusTransformUtils.preCheckCast(r3.next(), Consumer.class, "com.obric.memorydata.plugin")).accept(new PictureInPictureModeChangedInfo(r4));
        goto L7
    }

    public void onPictureInPictureModeChanged(boolean r4, Configuration r5) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        super.onPictureInPictureModeChanged(r4, r5);     // Catch: Throwable -> L9
        this.mDispatchingOnPictureInPictureModeChanged = false;
        Iterator<Consumer<PictureInPictureModeChangedInfo>> r3 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        ((Consumer) ZeusTransformUtils.preCheckCast(r3.next(), Consumer.class, "com.obric.memorydata.plugin")).accept(new PictureInPictureModeChangedInfo(r4, r5));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        throw th;
    }

    public boolean onPreparePanel(int r3, View r4, Menu r5) {
        Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.memorydata.plugin");
        if (r3 != 0) goto L7;
        super.onPreparePanel(r3, r4, r6);
        this.mMenuHostHelper.onPrepareMenu(r6);
        return true;
    L7:
        return true;
    }

    @Deprecated
    public void onRequestPermissionsResult(int r4, String[] r5, int[] r6) {
        if (this.mActivityResultRegistry.dispatchResult(r4, -1, new Intent().putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS, r5).putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS, r6)) == false) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        super.onRequestPermissionsResult(r4, r5, r6);
        return;
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        Object r0 = onRetainCustomNonConfigurationInstance();
        ViewModelStore r1 = this.mViewModelStore;
        if (r1 != null) goto L7;
        NonConfigurationInstances r4 = (NonConfigurationInstances) ZeusTransformUtils.preCheckCast(getLastNonConfigurationInstance(), NonConfigurationInstances.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        r1 = r4.viewModelStore;
    L7:
        if (r1 != null) goto L11;
        if (r0 != null) goto L11;
        return null;
    L11:
        NonConfigurationInstances r5 = new NonConfigurationInstances();
        r5.custom = r0;
        r5.viewModelStore = r1;
        return r5;
    }

    @Override // androidx.core.app.ComponentActivity
    public void onSaveInstanceState(Bundle r4) {
        Lifecycle r0 = getLifecycle();
        if (ZeusTransformUtils.instanceOf(r0, LifecycleRegistry.class) == false) goto L5;
        ((LifecycleRegistry) ZeusTransformUtils.preCheckCast(r0, LifecycleRegistry.class, "com.obric.memorydata.plugin")).setCurrentState(Lifecycle.State.CREATED);
    L5:
        super.onSaveInstanceState(r4);
        this.mSavedStateRegistryController.performSave(r4);
    }

    public void onTrimMemory(int r4) {
        super.onTrimMemory(r4);
        Iterator<Consumer<Integer>> r3 = this.mOnTrimMemoryListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Consumer) ZeusTransformUtils.preCheckCast(r3.next(), Consumer.class, "com.obric.memorydata.plugin")).accept(Integer.valueOf(r4));
        goto L4
    }

    @Override // androidx.activity.contextaware.ContextAware
    public Context peekAvailableContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mContextAwareHelper.peekAvailableContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r3, ActivityResultCallback<O> r4) {
        ActivityResultCallback<O> r5 = (ActivityResultCallback) ZeusTransformUtils.wrapperContextForParams(r4, ActivityResultCallback.class, "com.obric.memorydata.plugin");
        return registerForActivityResult(r3, this.mActivityResultRegistry, r5);
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r3, ActivityResultRegistry r4, ActivityResultCallback<O> r5) {
        return r4.register("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, r3, (ActivityResultCallback) ZeusTransformUtils.wrapperContextForParams(r5, ActivityResultCallback.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(MenuProvider r3) {
        MenuProvider r4 = (MenuProvider) ZeusTransformUtils.wrapperContextForParams(r3, MenuProvider.class, "com.obric.memorydata.plugin");
        this.mMenuHostHelper.removeMenuProvider(r4);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void removeOnConfigurationChangedListener(Consumer<Configuration> r3) {
        Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        this.mOnConfigurationChangedListeners.remove(r4);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void removeOnContextAvailableListener(OnContextAvailableListener r3) {
        OnContextAvailableListener r4 = (OnContextAvailableListener) ZeusTransformUtils.wrapperContextForParams(r3, OnContextAvailableListener.class, "com.obric.memorydata.plugin");
        this.mContextAwareHelper.removeOnContextAvailableListener(r4);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void removeOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> r3) {
        Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        this.mOnMultiWindowModeChangedListeners.remove(r4);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void removeOnNewIntentListener(Consumer<Intent> r3) {
        Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        this.mOnNewIntentListeners.remove(r4);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void removeOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> r3) {
        Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        this.mOnPictureInPictureModeChangedListeners.remove(r4);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void removeOnTrimMemoryListener(Consumer<Integer> r3) {
        Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        this.mOnTrimMemoryListeners.remove(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reportFullyDrawn() {
    L15:
        th = move-exception;
        Trace.endSection();
        throw th;
    L3:
        if (Trace.isEnabled() == false) goto L6;
        Trace.beginSection("reportFullyDrawn() for ComponentActivity");     // Catch: Throwable -> L15
    L6:
        if (Build.VERSION.SDK_INT <= 19) goto L9;
    L7:
        super.reportFullyDrawn();     // Catch: Throwable -> L15
    L13:
        Trace.endSection();
        return;
    L9:
        if (Build.VERSION.SDK_INT != 19) goto L13;
        if (ContextCompat.checkSelfPermission(this, "android.permission.UPDATE_DEVICE_STATS") != 0) goto L13;
        goto L13
    }

    public void setContentView(int r1) {
        initViewTreeOwners();
        super.setContentView(r1);
    }

    public void setContentView(View r1) {
        initViewTreeOwners();
        super.setContentView(r1);
    }

    public void setContentView(View r1, ViewGroup.LayoutParams r2) {
        initViewTreeOwners();
        super.setContentView(r1, r2);
    }

    @Deprecated
    public void startActivityForResult(Intent r1, int r2) {
        super.startActivityForResult(r1, r2);
    }

    @Deprecated
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender r1, int r2, Intent r3, int r4, int r5, int r6) {
        super.startIntentSenderForResult(r1, r2, r3, r4, r5, r6);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender r1, int r2, Intent r3, int r4, int r5, int r6, Bundle r7) {
        super.startIntentSenderForResult(r1, r2, r3, r4, r5, r6, r7);
    }
}
