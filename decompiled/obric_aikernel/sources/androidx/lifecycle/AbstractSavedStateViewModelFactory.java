package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractSavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    public static final Companion Companion = null;
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    private Bundle defaultArgs;
    private Lifecycle lifecycle;
    private SavedStateRegistry savedStateRegistry;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AbstractSavedStateViewModelFactory() {
    }

    public AbstractSavedStateViewModelFactory(SavedStateRegistryOwner r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        this.savedStateRegistry = r10.getSavedStateRegistry();
        this.lifecycle = r10.getLifecycle();
        this.defaultArgs = r11;
    }

    private final <T extends ViewModel> T create(String r10, Class<T> r11) {
        SavedStateRegistry r12 = this.savedStateRegistry;
        Intrinsics.checkNotNull(r12);
        Lifecycle r13 = this.lifecycle;
        Intrinsics.checkNotNull(r13);
        SavedStateHandleController r14 = LegacySavedStateHandleController.create(r12, r13, r10, this.defaultArgs);
        T r15 = (T) create(r10, r11, r14.getHandle());
        r15.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", r14);
        return r15;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "modelClass");
        String r11 = r10.getCanonicalName();
        if (r11 == null) goto L11;
        if (this.lifecycle == null) goto L9;
        return (T) create(r11, r10);
    L9:
        throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    L11:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> r10, CreationExtras r11) {
        Intrinsics.checkNotNullParameter(r10, "modelClass");
        Intrinsics.checkNotNullParameter(r11, "extras");
        String r12 = (String) r11.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (r12 == null) goto L10;
        if (this.savedStateRegistry == null) goto L8;
        return (T) create(r12, r10);
    L8:
        return (T) create(r12, r10, SavedStateHandleSupport.createSavedStateHandle(r11));
    L10:
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    protected abstract <T extends ViewModel> T create(String r10, Class<T> r11, SavedStateHandle r12);

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(ViewModel r10) {
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        SavedStateRegistry r11 = this.savedStateRegistry;
        if (r11 == null) goto L6;
        Intrinsics.checkNotNull(r11);
        Lifecycle r12 = this.lifecycle;
        Intrinsics.checkNotNull(r12);
        LegacySavedStateHandleController.attachHandleIfNeeded(r10, r11, r12);
        return;
    }
}
