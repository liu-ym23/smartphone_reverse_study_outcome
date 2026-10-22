package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0018H\u0007\u001a\u001f\u0010\u0019\u001a\u00020\u001a\"\f\b\u0000\u0010\u001b*\u00020\u0006*\u00020\t*\u0002H\u001bH\u0007¢\u0006\u0002\u0010\u001c\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"DEFAULT_ARGS_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "Landroid/os/Bundle;", "SAVED_STATE_KEY", "", "SAVED_STATE_REGISTRY_OWNER_KEY", "Landroidx/savedstate/SavedStateRegistryOwner;", "VIEWMODEL_KEY", "VIEW_MODEL_STORE_OWNER_KEY", "Landroidx/lifecycle/ViewModelStoreOwner;", "savedStateHandlesProvider", "Landroidx/lifecycle/SavedStateHandlesProvider;", "getSavedStateHandlesProvider", "(Landroidx/savedstate/SavedStateRegistryOwner;)Landroidx/lifecycle/SavedStateHandlesProvider;", "savedStateHandlesVM", "Landroidx/lifecycle/SavedStateHandlesVM;", "getSavedStateHandlesVM", "(Landroidx/lifecycle/ViewModelStoreOwner;)Landroidx/lifecycle/SavedStateHandlesVM;", "createSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "savedStateRegistryOwner", "viewModelStoreOwner", STGroup.DICT_KEY, "defaultArgs", "Landroidx/lifecycle/viewmodel/CreationExtras;", "enableSavedStateHandles", "", ExifInterface.GPS_DIRECTION_TRUE, "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "lifecycle-viewmodel-savedstate_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
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

    private static final SavedStateHandle createSavedStateHandle(SavedStateRegistryOwner r5, ViewModelStoreOwner r10, String r11, Bundle r12) {
        SavedStateHandlesProvider r13 = getSavedStateHandlesProvider(r5);
        SavedStateHandlesVM r14 = getSavedStateHandlesVM(r10);
        SavedStateHandle r15 = r14.getHandles().get(r11);
        if (r15 != null) goto L6;
        SavedStateHandle r16 = SavedStateHandle.Companion.createHandle(r13.consumeRestoredStateForKey(r11), r12);
        r14.getHandles().put(r11, r16);
        return r16;
    L6:
        return r15;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @MainThread
    public static final <T extends SavedStateRegistryOwner & ViewModelStoreOwner> void enableSavedStateHandles(T r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Lifecycle.State r10 = r5.getLifecycle().getCurrentState();
        if (r10 == Lifecycle.State.INITIALIZED) goto L10;
        if (r10 == Lifecycle.State.CREATED) goto L10;
        throw new IllegalArgumentException("Failed requirement.");
    L10:
        if (r5.getSavedStateRegistry().getSavedStateProvider(SAVED_STATE_KEY) != null) goto L13;
        SavedStateHandlesProvider r11 = new SavedStateHandlesProvider(r5.getSavedStateRegistry(), r5);
        r5.getSavedStateRegistry().registerSavedStateProvider(SAVED_STATE_KEY, r11);
        r5.getLifecycle().addObserver(new SavedStateHandleAttacher(r11));
        return;
    }

    public static final SavedStateHandlesProvider getSavedStateHandlesProvider(SavedStateRegistryOwner r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        SavedStateRegistry.SavedStateProvider r10 = r5.getSavedStateRegistry().getSavedStateProvider(SAVED_STATE_KEY);
        if ((r10 instanceof SavedStateHandlesProvider) == false) goto L5;
        SavedStateHandlesProvider r11 = (SavedStateHandlesProvider) r10;
    L6:
        if (r11 == null) goto L9;
        return r11;
    L9:
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    L5:
        r11 = null;
        goto L6
    }

    public static final SavedStateHandlesVM getSavedStateHandlesVM(ViewModelStoreOwner r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        InitializerViewModelFactoryBuilder r10 = new InitializerViewModelFactoryBuilder();
        SavedStateHandleSupport$savedStateHandlesVM$1$1 r11 = SavedStateHandleSupport$savedStateHandlesVM$1$1.INSTANCE;
        r10.addInitializer(Reflection.getOrCreateKotlinClass(SavedStateHandlesVM.class), r11);
        return (SavedStateHandlesVM) new ViewModelProvider(r5, r10.build()).get(VIEWMODEL_KEY, SavedStateHandlesVM.class);
    }

    @MainThread
    public static final SavedStateHandle createSavedStateHandle(CreationExtras r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        SavedStateRegistryOwner r10 = (SavedStateRegistryOwner) r5.get(SAVED_STATE_REGISTRY_OWNER_KEY);
        if (r10 == null) goto L15;
        ViewModelStoreOwner r11 = (ViewModelStoreOwner) r5.get(VIEW_MODEL_STORE_OWNER_KEY);
        if (r11 == null) goto L13;
        Bundle r12 = (Bundle) r5.get(DEFAULT_ARGS_KEY);
        String r13 = (String) r5.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (r13 == null) goto L11;
        return createSavedStateHandle(r10, r11, r13, r12);
    L11:
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    L13:
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
    L15:
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }
}
