package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    private Application application;
    private Bundle defaultArgs;
    private final ViewModelProvider.Factory factory;
    private Lifecycle lifecycle;
    private SavedStateRegistry savedStateRegistry;

    public SavedStateViewModelFactory() {
        this.factory = new ViewModelProvider.AndroidViewModelFactory();
    }

    public SavedStateViewModelFactory(Application r10, SavedStateRegistryOwner r11) {
        Intrinsics.checkNotNullParameter(r11, "owner");
        this(r10, r11, null);
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(Application r10, SavedStateRegistryOwner r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "owner");
        this.savedStateRegistry = r11.getSavedStateRegistry();
        this.lifecycle = r11.getLifecycle();
        this.defaultArgs = r12;
        this.application = r10;
        if (r10 == null) goto L5;
        ViewModelProvider.AndroidViewModelFactory r13 = ViewModelProvider.AndroidViewModelFactory.Companion.getInstance(r10);
    L6:
        this.factory = r13;
        return;
    L5:
        r13 = new ViewModelProvider.AndroidViewModelFactory();
        goto L6
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "modelClass");
        String r11 = r10.getCanonicalName();
        if (r11 == null) goto L7;
        return (T) create(r11, r10);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> r10, CreationExtras r11) {
        Intrinsics.checkNotNullParameter(r10, "modelClass");
        Intrinsics.checkNotNullParameter(r11, "extras");
        String r12 = (String) r11.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (r12 == null) goto L29;
        if (r11.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY) == null) goto L23;
        if (r11.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) == null) goto L23;
        Application r13 = (Application) r11.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
        boolean r14 = AndroidViewModel.class.isAssignableFrom(r10);
        if (r14 == false) goto L12;
        if (r13 == null) goto L12;
        List r15 = SavedStateViewModelFactoryKt.access$getANDROID_VIEWMODEL_SIGNATURE$p();
    L13:
        Constructor r16 = SavedStateViewModelFactoryKt.findMatchingConstructor(r10, r15);
        if (r16 != null) goto L18;
        return (T) this.factory.create(r10, r11);
    L18:
        if (r14 == false) goto L31;
        if (r13 == null) goto L31;
        return (T) SavedStateViewModelFactoryKt.newInstance(r10, r16, new Object[]{r13, SavedStateHandleSupport.createSavedStateHandle(r11)});
    L31:
        return (T) SavedStateViewModelFactoryKt.newInstance(r10, r16, new Object[]{SavedStateHandleSupport.createSavedStateHandle(r11)});
    L12:
        r15 = SavedStateViewModelFactoryKt.access$getVIEWMODEL_SIGNATURE$p();
    L23:
        if (this.lifecycle == null) goto L27;
        return (T) create(r12, r10);
    L27:
        throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
    L29:
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    public final <T extends ViewModel> T create(String r10, Class<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "modelClass");
        Lifecycle r12 = this.lifecycle;
        if (r12 == null) goto L26;
        boolean r13 = AndroidViewModel.class.isAssignableFrom(r11);
        if (r13 == true) goto L7;
    L9:
        List r14 = SavedStateViewModelFactoryKt.access$getVIEWMODEL_SIGNATURE$p();
    L10:
        Constructor r15 = SavedStateViewModelFactoryKt.findMatchingConstructor(r11, r14);
        if (r15 == null) goto L13;
        SavedStateRegistry r16 = this.savedStateRegistry;
        Intrinsics.checkNotNull(r16);
        SavedStateHandleController r17 = LegacySavedStateHandleController.create(r16, r12, r10, this.defaultArgs);
        if (r13 == false) goto L22;
        Application r18 = this.application;
        if (r18 == null) goto L22;
        Intrinsics.checkNotNull(r18);
        T r19 = (T) SavedStateViewModelFactoryKt.newInstance(r11, r15, new Object[]{r18, r17.getHandle()});
    L23:
        r19.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", r17);
        return r19;
    L22:
        r19 = (T) SavedStateViewModelFactoryKt.newInstance(r11, r15, new Object[]{r17.getHandle()});
        goto L23
    L13:
        if (this.application == null) goto L16;
        return (T) this.factory.create(r11);
    L16:
        return (T) ViewModelProvider.NewInstanceFactory.Companion.getInstance().create(r11);
    L7:
        if (this.application == null) goto L9;
        r14 = SavedStateViewModelFactoryKt.access$getANDROID_VIEWMODEL_SIGNATURE$p();
        goto L10
    L26:
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(ViewModel r10) {
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        if (this.lifecycle == null) goto L6;
        SavedStateRegistry r11 = this.savedStateRegistry;
        Intrinsics.checkNotNull(r11);
        Lifecycle r12 = this.lifecycle;
        Intrinsics.checkNotNull(r12);
        LegacySavedStateHandleController.attachHandleIfNeeded(r10, r11, r12);
        return;
    }
}
