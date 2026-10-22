package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class FragmentViewLifecycleOwner implements HasDefaultViewModelProviderFactory, ViewModelStoreOwner, SavedStateRegistryOwner {
    private ViewModelProvider.Factory mDefaultFactory;
    private final Fragment mFragment;
    private LifecycleRegistry mLifecycleRegistry;
    private SavedStateRegistryController mSavedStateRegistryController;
    private final ViewModelStore mViewModelStore;

    FragmentViewLifecycleOwner(Fragment r2, ViewModelStore r3) {
        this.mLifecycleRegistry = null;
        this.mSavedStateRegistryController = null;
        this.mFragment = r2;
        this.mViewModelStore = r3;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        Context r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mFragment.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext();
    L3:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, ContextWrapper.class) == false) goto L9;
        if (ZeusTransformUtils.instanceOf(r1, Application.class) == true) goto L7;
        r0 = ((ContextWrapper) ZeusTransformUtils.preCheckCast(r1, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext();
        goto L3
    L7:
        Application r2 = (Application) ZeusTransformUtils.preCheckCast(r1, Application.class, "com.obric.memorydata.plugin");
    L10:
        MutableCreationExtras r3 = new MutableCreationExtras();
        if (r2 == null) goto L13;
        r3.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, r2);
    L13:
        r3.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        r3.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (this.mFragment.getArguments() == null) goto L16;
        r3.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, this.mFragment.getArguments());
    L16:
        return r3;
    L9:
        r2 = null;
        goto L10
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        ViewModelProvider.Factory r0 = this.mFragment.getDefaultViewModelProviderFactory();
        if (r0.equals(this.mFragment.mDefaultFactory) == true) goto L7;
        this.mDefaultFactory = r0;
        return r0;
    L7:
        if (this.mDefaultFactory != null) goto L17;
        Application r1 = null;
        Context r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mFragment.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext();
    L9:
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ContextWrapper.class) == false) goto L15;
        if (ZeusTransformUtils.instanceOf(r3, Application.class) == true) goto L13;
        r2 = ((ContextWrapper) ZeusTransformUtils.preCheckCast(r3, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext();
        goto L9
    L13:
        r1 = (Application) ZeusTransformUtils.preCheckCast(r3, Application.class, "com.obric.memorydata.plugin");
    L15:
        this.mDefaultFactory = new SavedStateViewModelFactory(r1, this, this.mFragment.getArguments());
    L17:
        return this.mDefaultFactory;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        initialize();
        return this.mLifecycleRegistry;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        initialize();
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        initialize();
        return this.mViewModelStore;
    }

    void handleLifecycleEvent(Lifecycle.Event r1) {
        this.mLifecycleRegistry.handleLifecycleEvent(r1);
    }

    void initialize() {
        if (this.mLifecycleRegistry != null) goto L6;
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController r0 = SavedStateRegistryController.create(this);
        this.mSavedStateRegistryController = r0;
        r0.performAttach();
        SavedStateHandleSupport.enableSavedStateHandles(this);
        return;
    }

    boolean isInitialized() {
        if (this.mLifecycleRegistry == null) goto L5;
        return true;
    L5:
        return false;
    }

    void performRestore(Bundle r1) {
        this.mSavedStateRegistryController.performRestore(r1);
    }

    void performSave(Bundle r1) {
        this.mSavedStateRegistryController.performSave(r1);
    }

    void setCurrentState(Lifecycle.State r1) {
        this.mLifecycleRegistry.setCurrentState(r1);
    }
}
