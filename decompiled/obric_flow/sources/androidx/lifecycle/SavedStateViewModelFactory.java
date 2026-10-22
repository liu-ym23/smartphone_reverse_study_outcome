package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0019\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB#\b\u0017\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ%\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0015H\u0016¢\u0006\u0002\u0010\u0016J-\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u0019J+\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0015¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013H\u0017R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/lifecycle/SavedStateViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "()V", "application", "Landroid/app/Application;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;)V", "defaultArgs", "Landroid/os/Bundle;", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "factory", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", STGroup.DICT_KEY, "", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "onRequery", "", "viewModel", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    private Application application;
    private Bundle defaultArgs;
    private final ViewModelProvider.Factory factory;
    private Lifecycle lifecycle;
    private SavedStateRegistry savedStateRegistry;

    public SavedStateViewModelFactory() {
        this.factory = new ViewModelProvider.AndroidViewModelFactory();
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> r5, CreationExtras r10) {
        Intrinsics.checkNotNullParameter(r5, "modelClass");
        Intrinsics.checkNotNullParameter(r10, "extras");
        String r11 = (String) r10.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (r11 == null) goto L27;
        if (r10.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY) == null) goto L21;
        if (r10.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) == null) goto L21;
        Application r12 = (Application) r10.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
        boolean r13 = AndroidViewModel.class.isAssignableFrom(r5);
        if (r13 == false) goto L12;
        if (r12 == null) goto L12;
        Constructor r14 = SavedStateViewModelFactoryKt.findMatchingConstructor(r5, SavedStateViewModelFactoryKt.access$getANDROID_VIEWMODEL_SIGNATURE$p());
    L13:
        if (r14 == null) goto L15;
        if (r13 == false) goto L29;
        if (r12 == null) goto L29;
        return (T) SavedStateViewModelFactoryKt.newInstance(r5, r14, new Object[]{r12, SavedStateHandleSupport.createSavedStateHandle(r10)});
    L29:
        return (T) SavedStateViewModelFactoryKt.newInstance(r5, r14, new Object[]{SavedStateHandleSupport.createSavedStateHandle(r10)});
    L15:
        return (T) this.factory.create(r5, r10);
    L12:
        r14 = SavedStateViewModelFactoryKt.findMatchingConstructor(r5, SavedStateViewModelFactoryKt.access$getVIEWMODEL_SIGNATURE$p());
    L21:
        if (this.lifecycle == null) goto L25;
        return (T) create(r11, r5);
    L25:
        throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
    L27:
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(ViewModel r5) {
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        if (this.lifecycle == null) goto L6;
        SavedStateRegistry r10 = this.savedStateRegistry;
        Intrinsics.checkNotNull(r10);
        Lifecycle r11 = this.lifecycle;
        Intrinsics.checkNotNull(r11);
        LegacySavedStateHandleController.attachHandleIfNeeded(r5, r10, r11);
        return;
    }

    public SavedStateViewModelFactory(Application r5, SavedStateRegistryOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        this(r5, r10, null);
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(Application r5, SavedStateRegistryOwner r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        this.savedStateRegistry = r10.getSavedStateRegistry();
        this.lifecycle = r10.getLifecycle();
        this.defaultArgs = r11;
        this.application = r5;
        if (r5 == null) goto L5;
        ViewModelProvider.AndroidViewModelFactory r12 = ViewModelProvider.AndroidViewModelFactory.Companion.getInstance(r5);
    L6:
        this.factory = r12;
        return;
    L5:
        r12 = new ViewModelProvider.AndroidViewModelFactory();
        goto L6
    }

    public final <T extends ViewModel> T create(String r10, Class<T> r11) {
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r11, "modelClass");
        Lifecycle r5 = this.lifecycle;
        if (r5 == null) goto L25;
        boolean r12 = AndroidViewModel.class.isAssignableFrom(r11);
        if (r12 == true) goto L7;
    L9:
        Constructor r13 = SavedStateViewModelFactoryKt.findMatchingConstructor(r11, SavedStateViewModelFactoryKt.access$getVIEWMODEL_SIGNATURE$p());
    L10:
        if (r13 == null) goto L12;
        SavedStateRegistry r14 = this.savedStateRegistry;
        Intrinsics.checkNotNull(r14);
        SavedStateHandleController r15 = LegacySavedStateHandleController.create(r14, r5, r10, this.defaultArgs);
        if (r12 == false) goto L21;
        Application r16 = this.application;
        if (r16 == null) goto L21;
        Intrinsics.checkNotNull(r16);
        T r17 = (T) SavedStateViewModelFactoryKt.newInstance(r11, r13, new Object[]{r16, r15.getHandle()});
    L22:
        r17.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", r15);
        return r17;
    L21:
        r17 = (T) SavedStateViewModelFactoryKt.newInstance(r11, r13, new Object[]{r15.getHandle()});
        goto L22
    L12:
        if (this.application == null) goto L15;
        return (T) this.factory.create(r11);
    L15:
        return (T) ViewModelProvider.NewInstanceFactory.Companion.getInstance().create(r11);
    L7:
        if (this.application == null) goto L9;
        r13 = SavedStateViewModelFactoryKt.findMatchingConstructor(r11, SavedStateViewModelFactoryKt.access$getANDROID_VIEWMODEL_SIGNATURE$p());
        goto L10
    L25:
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "modelClass");
        String r10 = r5.getCanonicalName();
        if (r10 == null) goto L7;
        return (T) create(r10, r5);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
