package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

/* JADX INFO: loaded from: classes.dex */
class FragmentViewLifecycleOwner implements HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ViewModelStoreOwner {
    private ViewModelProvider.Factory mDefaultFactory;
    private final Fragment mFragment;
    private LifecycleRegistry mLifecycleRegistry;
    private SavedStateRegistryController mSavedStateRegistryController;
    private final ViewModelStore mViewModelStore;

    FragmentViewLifecycleOwner(@NonNull Fragment r10, @NonNull ViewModelStore r11) {
        this.mLifecycleRegistry = null;
        this.mSavedStateRegistryController = null;
        this.mFragment = r10;
        this.mViewModelStore = r11;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        ViewModelProvider.Factory r10 = this.mFragment.getDefaultViewModelProviderFactory();
        if (r10.equals(this.mFragment.mDefaultFactory) == true) goto L7;
        this.mDefaultFactory = r10;
        return r10;
    L7:
        if (this.mDefaultFactory != null) goto L17;
        Application r11 = null;
        Context r12 = this.mFragment.requireContext().getApplicationContext();
    L10:
        if ((r12 instanceof ContextWrapper) == false) goto L15;
        if ((r12 instanceof Application) == true) goto L13;
        r12 = ((ContextWrapper) r12).getBaseContext();
        goto L10
    L13:
        r11 = (Application) r12;
    L15:
        this.mDefaultFactory = new SavedStateViewModelFactory(r11, this, this.mFragment.getArguments());
    L17:
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

    void handleLifecycleEvent(@NonNull Lifecycle.Event r10) {
        this.mLifecycleRegistry.handleLifecycleEvent(r10);
    }

    void initialize() {
        if (this.mLifecycleRegistry != null) goto L6;
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        return;
    }

    boolean isInitialized() {
        if (this.mLifecycleRegistry == null) goto L5;
        return true;
    L5:
        return false;
    }

    void performRestore(@Nullable Bundle r10) {
        this.mSavedStateRegistryController.performRestore(r10);
    }

    void performSave(@NonNull Bundle r10) {
        this.mSavedStateRegistryController.performSave(r10);
    }

    void setCurrentState(@NonNull Lifecycle.State r10) {
        this.mLifecycleRegistry.setCurrentState(r10);
    }
}
