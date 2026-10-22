package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

/* JADX INFO: loaded from: classes.dex */
class FragmentViewLifecycleOwner implements HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ViewModelStoreOwner {
    private ViewModelProvider.Factory mDefaultFactory;
    private final Fragment mFragment;
    private LifecycleRegistry mLifecycleRegistry;
    private final Runnable mRestoreViewSavedStateRunnable;
    private SavedStateRegistryController mSavedStateRegistryController;
    private final ViewModelStore mViewModelStore;

    public FragmentViewLifecycleOwner(@NonNull Fragment r5, @NonNull ViewModelStore r10, @NonNull Runnable r11) {
        this.mLifecycleRegistry = null;
        this.mSavedStateRegistryController = null;
        this.mFragment = r5;
        this.mViewModelStore = r10;
        this.mRestoreViewSavedStateRunnable = r11;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    @CallSuper
    public CreationExtras getDefaultViewModelCreationExtras() {
        Context r5 = this.mFragment.requireContext().getApplicationContext();
    L4:
        if ((r5 instanceof ContextWrapper) == false) goto L9;
        if ((r5 instanceof Application) == true) goto L7;
        r5 = ((ContextWrapper) r5).getBaseContext();
        goto L4
    L7:
        Application r10 = (Application) r5;
    L10:
        MutableCreationExtras r11 = new MutableCreationExtras();
        if (r10 == null) goto L13;
        r11.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, r10);
    L13:
        r11.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this.mFragment);
        r11.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (this.mFragment.getArguments() == null) goto L16;
        r11.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, this.mFragment.getArguments());
    L16:
        return r11;
    L9:
        r10 = null;
        goto L10
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        ViewModelProvider.Factory r5 = this.mFragment.getDefaultViewModelProviderFactory();
        if (r5.equals(this.mFragment.mDefaultFactory) == true) goto L7;
        this.mDefaultFactory = r5;
        return r5;
    L7:
        if (this.mDefaultFactory != null) goto L18;
        Context r10 = this.mFragment.requireContext().getApplicationContext();
    L10:
        if ((r10 instanceof ContextWrapper) == false) goto L15;
        if ((r10 instanceof Application) == true) goto L13;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L10
    L13:
        Application r11 = (Application) r10;
    L16:
        Fragment r12 = this.mFragment;
        this.mDefaultFactory = new SavedStateViewModelFactory(r11, r12, r12.getArguments());
        goto L18
    L15:
        r11 = null;
    L18:
        return this.mDefaultFactory;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        initialize();
        return this.mLifecycleRegistry;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @NonNull
    public SavedStateRegistry getSavedStateRegistry() {
        initialize();
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        initialize();
        return this.mViewModelStore;
    }

    public void handleLifecycleEvent(@NonNull Lifecycle.Event r5) {
        this.mLifecycleRegistry.handleLifecycleEvent(r5);
    }

    public void initialize() {
        if (this.mLifecycleRegistry != null) goto L6;
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController r5 = SavedStateRegistryController.create(this);
        this.mSavedStateRegistryController = r5;
        r5.performAttach();
        this.mRestoreViewSavedStateRunnable.run();
        return;
    }

    public boolean isInitialized() {
        if (this.mLifecycleRegistry == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void performRestore(@Nullable Bundle r5) {
        this.mSavedStateRegistryController.performRestore(r5);
    }

    public void performSave(@NonNull Bundle r5) {
        this.mSavedStateRegistryController.performSave(r5);
    }

    public void setCurrentState(@NonNull Lifecycle.State r5) {
        this.mLifecycleRegistry.setCurrentState(r5);
    }
}
