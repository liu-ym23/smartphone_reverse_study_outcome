package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0019\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB#\b\u0017\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ%\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0015H\u0016¢\u0006\u0002\u0010\u0016J-\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u0019J+\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0015¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013H\u0017R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/lifecycle/SavedStateViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "()V", "application", "Landroid/app/Application;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;)V", "defaultArgs", "Landroid/os/Bundle;", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "factory", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "key", "", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "onRequery", "", "viewModel", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    private Application application;
    private Bundle defaultArgs;
    private final ViewModelProvider.Factory factory;
    private Lifecycle lifecycle;
    private SavedStateRegistry savedStateRegistry;

    public SavedStateViewModelFactory() {
        this.factory = (ViewModelProvider.Factory) ZeusTransformUtils.preCheckCast(new ViewModelProvider.AndroidViewModelFactory(), ViewModelProvider.Factory.class, "com.obric.memorydata.plugin");
    }

    public SavedStateViewModelFactory(Application r3, SavedStateRegistryOwner r4) {
        Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        SavedStateRegistryOwner r6 = (SavedStateRegistryOwner) ZeusTransformUtils.wrapperContextForParams(r4, SavedStateRegistryOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "owner");
        this(r5, r6, null);
    }

    public SavedStateViewModelFactory(Application r3, SavedStateRegistryOwner r4, Bundle r5) {
        Application r6 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        SavedStateRegistryOwner r7 = (SavedStateRegistryOwner) ZeusTransformUtils.wrapperContextForParams(r4, SavedStateRegistryOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "owner");
        this.savedStateRegistry = r7.getSavedStateRegistry();
        this.lifecycle = r7.getLifecycle();
        this.defaultArgs = r5;
        this.application = r6;
        if (r6 == null) goto L5;
        ViewModelProvider.AndroidViewModelFactory r8 = ViewModelProvider.AndroidViewModelFactory.Companion.getInstance(r6);
    L6:
        this.factory = (ViewModelProvider.Factory) ZeusTransformUtils.preCheckCast(r8, ViewModelProvider.Factory.class, "com.obric.memorydata.plugin");
        return;
    L5:
        r8 = new ViewModelProvider.AndroidViewModelFactory();
        goto L6
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "modelClass");
        String r0 = r2.getCanonicalName();
        if (r0 == null) goto L7;
        return (T) create(r0, r2);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> r5, CreationExtras r6) {
        Intrinsics.checkNotNullParameter(r5, "modelClass");
        Intrinsics.checkNotNullParameter(r6, "extras");
        String r0 = (String) ZeusTransformUtils.preCheckCast(r6.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L29;
        if (r6.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY) == null) goto L23;
        if (r6.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) == null) goto L23;
        Application r1 = (Application) ZeusTransformUtils.preCheckCast(r6.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY), Application.class, "com.obric.memorydata.plugin");
        boolean r2 = AndroidViewModel.class.isAssignableFrom(r5);
        if (r2 == false) goto L12;
        if (r1 == null) goto L12;
        List r3 = SavedStateViewModelFactoryKt.access$getANDROID_VIEWMODEL_SIGNATURE$p();
    L13:
        Constructor r4 = SavedStateViewModelFactoryKt.findMatchingConstructor(r5, r3);
        if (r4 != null) goto L18;
        return (T) this.factory.create(r5, r6);
    L18:
        if (r2 == false) goto L31;
        if (r1 == null) goto L31;
        return (T) SavedStateViewModelFactoryKt.newInstance(r5, r4, new Object[]{r1, SavedStateHandleSupport.createSavedStateHandle(r6)});
    L31:
        return (T) SavedStateViewModelFactoryKt.newInstance(r5, r4, new Object[]{SavedStateHandleSupport.createSavedStateHandle(r6)});
    L12:
        r3 = SavedStateViewModelFactoryKt.access$getVIEWMODEL_SIGNATURE$p();
    L23:
        if (this.lifecycle == null) goto L27;
        return (T) create(r0, r5);
    L27:
        throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
    L29:
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    public final <T extends ViewModel> T create(String r6, Class<T> r7) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, "modelClass");
        Lifecycle r0 = this.lifecycle;
        if (r0 == null) goto L26;
        boolean r1 = AndroidViewModel.class.isAssignableFrom(r7);
        if (r1 == true) goto L7;
    L9:
        List r2 = SavedStateViewModelFactoryKt.access$getVIEWMODEL_SIGNATURE$p();
    L10:
        Constructor r3 = SavedStateViewModelFactoryKt.findMatchingConstructor(r7, r2);
        if (r3 == null) goto L13;
        SavedStateRegistry r4 = this.savedStateRegistry;
        Intrinsics.checkNotNull(r4);
        SavedStateHandleController r8 = LegacySavedStateHandleController.create(r4, r0, r6, this.defaultArgs);
        if (r1 == false) goto L22;
        Application r5 = this.application;
        if (r5 == null) goto L22;
        Intrinsics.checkNotNull(r5);
        T r9 = (T) SavedStateViewModelFactoryKt.newInstance(r7, r3, new Object[]{r5, r8.getHandle()});
    L23:
        r9.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", r8);
        return r9;
    L22:
        r9 = (T) SavedStateViewModelFactoryKt.newInstance(r7, r3, new Object[]{r8.getHandle()});
        goto L23
    L13:
        if (this.application == null) goto L16;
        return (T) this.factory.create(r7);
    L16:
        return (T) ViewModelProvider.NewInstanceFactory.Companion.getInstance().create(r7);
    L7:
        if (this.application == null) goto L9;
        r2 = SavedStateViewModelFactoryKt.access$getANDROID_VIEWMODEL_SIGNATURE$p();
        goto L10
    L26:
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    public void onRequery(ViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        if (this.lifecycle == null) goto L6;
        SavedStateRegistry r0 = this.savedStateRegistry;
        Intrinsics.checkNotNull(r0);
        Lifecycle r1 = this.lifecycle;
        Intrinsics.checkNotNull(r1);
        LegacySavedStateHandleController.attachHandleIfNeeded(r2, r0, r1);
        return;
    }
}
