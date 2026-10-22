package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@JvmName(name = "SavedStateHandleSupport")
@SourceDebugExtension({"SMAP\nSavedStateHandleSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandleSupport.kt\nandroidx/lifecycle/SavedStateHandleSupport\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactoryKt\n*L\n1#1,225:1\n1#2:226\n31#3:227\n63#3,2:228\n*S KotlinDebug\n*F\n+ 1 SavedStateHandleSupport.kt\nandroidx/lifecycle/SavedStateHandleSupport\n*L\n109#1:227\n110#1:228,2\n*E\n"})
public final class SavedStateHandleSupport {

    @JvmField
    public static final CreationExtras.Key<Bundle> DEFAULT_ARGS_KEY = null;
    private static final String SAVED_STATE_KEY = "androidx.lifecycle.internal.SavedStateHandlesProvider";

    @JvmField
    public static final CreationExtras.Key<SavedStateRegistryOwner> SAVED_STATE_REGISTRY_OWNER_KEY = null;
    private static final String VIEWMODEL_KEY = "androidx.lifecycle.internal.SavedStateHandlesVM";

    @JvmField
    public static final CreationExtras.Key<ViewModelStoreOwner> VIEW_MODEL_STORE_OWNER_KEY = null;

    static {
        SAVED_STATE_REGISTRY_OWNER_KEY = new SavedStateHandleSupport$SAVED_STATE_REGISTRY_OWNER_KEY$1();
        VIEW_MODEL_STORE_OWNER_KEY = new SavedStateHandleSupport$VIEW_MODEL_STORE_OWNER_KEY$1();
        DEFAULT_ARGS_KEY = new SavedStateHandleSupport$DEFAULT_ARGS_KEY$1();
    }

    @MainThread
    public static final SavedStateHandle createSavedStateHandle(CreationExtras r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        SavedStateRegistryOwner r11 = (SavedStateRegistryOwner) r10.get(SAVED_STATE_REGISTRY_OWNER_KEY);
        if (r11 == null) goto L15;
        ViewModelStoreOwner r12 = (ViewModelStoreOwner) r10.get(VIEW_MODEL_STORE_OWNER_KEY);
        if (r12 == null) goto L13;
        Bundle r13 = (Bundle) r10.get(DEFAULT_ARGS_KEY);
        String r14 = (String) r10.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (r14 == null) goto L11;
        return createSavedStateHandle(r11, r12, r14, r13);
    L11:
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    L13:
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
    L15:
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    private static final SavedStateHandle createSavedStateHandle(SavedStateRegistryOwner r10, ViewModelStoreOwner r11, String r12, Bundle r13) {
        SavedStateHandlesProvider r14 = getSavedStateHandlesProvider(r10);
        SavedStateHandlesVM r15 = getSavedStateHandlesVM(r11);
        SavedStateHandle r16 = r15.getHandles().get(r12);
        if (r16 != null) goto L6;
        SavedStateHandle r17 = SavedStateHandle.Companion.createHandle(r14.consumeRestoredStateForKey(r12), r13);
        r15.getHandles().put(r12, r17);
        return r17;
    L6:
        return r16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @MainThread
    public static final <T extends SavedStateRegistryOwner & ViewModelStoreOwner> void enableSavedStateHandles(T r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Lifecycle.State r11 = r10.getLifecycle().getCurrentState();
        if (r11 != Lifecycle.State.INITIALIZED) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L15;
        if (r10.getSavedStateRegistry().getSavedStateProvider(SAVED_STATE_KEY) != null) goto L16;
        SavedStateHandlesProvider r13 = new SavedStateHandlesProvider(r10.getSavedStateRegistry(), r10);
        r10.getSavedStateRegistry().registerSavedStateProvider(SAVED_STATE_KEY, r13);
        r10.getLifecycle().addObserver(new SavedStateHandleAttacher(r13));
        return;
    L16:
        return;
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r11 == Lifecycle.State.CREATED) goto L8;
        r12 = false;
        goto L9
    }

    public static final SavedStateHandlesProvider getSavedStateHandlesProvider(SavedStateRegistryOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        SavedStateRegistry.SavedStateProvider r11 = r10.getSavedStateRegistry().getSavedStateProvider(SAVED_STATE_KEY);
        if ((r11 instanceof SavedStateHandlesProvider) == false) goto L5;
        SavedStateHandlesProvider r12 = (SavedStateHandlesProvider) r11;
    L6:
        if (r12 == null) goto L9;
        return r12;
    L9:
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    L5:
        r12 = null;
        goto L6
    }

    public static final SavedStateHandlesVM getSavedStateHandlesVM(ViewModelStoreOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        InitializerViewModelFactoryBuilder r11 = new InitializerViewModelFactoryBuilder();
        SavedStateHandleSupport$savedStateHandlesVM$1$1 r12 = SavedStateHandleSupport$savedStateHandlesVM$1$1.INSTANCE;
        r11.addInitializer(Reflection.getOrCreateKotlinClass(SavedStateHandlesVM.class), r12);
        return (SavedStateHandlesVM) new ViewModelProvider(r10, r11.build()).get(VIEWMODEL_KEY, SavedStateHandlesVM.class);
    }
}
