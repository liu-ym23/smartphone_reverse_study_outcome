package androidx.lifecycle;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0018H\u0007\u001a\u001f\u0010\u0019\u001a\u00020\u001a\"\f\b\u0000\u0010\u001b*\u00020\u0006*\u00020\t*\u0002H\u001bH\u0007¢\u0006\u0002\u0010\u001c\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"DEFAULT_ARGS_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "Landroid/os/Bundle;", "SAVED_STATE_KEY", "", "SAVED_STATE_REGISTRY_OWNER_KEY", "Landroidx/savedstate/SavedStateRegistryOwner;", "VIEWMODEL_KEY", "VIEW_MODEL_STORE_OWNER_KEY", "Landroidx/lifecycle/ViewModelStoreOwner;", "savedStateHandlesProvider", "Landroidx/lifecycle/SavedStateHandlesProvider;", "getSavedStateHandlesProvider", "(Landroidx/savedstate/SavedStateRegistryOwner;)Landroidx/lifecycle/SavedStateHandlesProvider;", "savedStateHandlesVM", "Landroidx/lifecycle/SavedStateHandlesVM;", "getSavedStateHandlesVM", "(Landroidx/lifecycle/ViewModelStoreOwner;)Landroidx/lifecycle/SavedStateHandlesVM;", "createSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "savedStateRegistryOwner", "viewModelStoreOwner", "key", "defaultArgs", "Landroidx/lifecycle/viewmodel/CreationExtras;", "enableSavedStateHandles", "", ExifInterface.GPS_DIRECTION_TRUE, "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "lifecycle-viewmodel-savedstate_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SavedStateHandleSupport {
    public static final CreationExtras.Key<Bundle> DEFAULT_ARGS_KEY = null;
    private static final String SAVED_STATE_KEY = "androidx.lifecycle.internal.SavedStateHandlesProvider";
    public static final CreationExtras.Key<SavedStateRegistryOwner> SAVED_STATE_REGISTRY_OWNER_KEY = null;
    private static final String VIEWMODEL_KEY = "androidx.lifecycle.internal.SavedStateHandlesVM";
    public static final CreationExtras.Key<ViewModelStoreOwner> VIEW_MODEL_STORE_OWNER_KEY = null;

    static {
        SAVED_STATE_REGISTRY_OWNER_KEY = (CreationExtras.Key) ZeusTransformUtils.preCheckCast(new SavedStateHandleSupport$SAVED_STATE_REGISTRY_OWNER_KEY$1(), CreationExtras.Key.class, "com.obric.memorydata.plugin");
        VIEW_MODEL_STORE_OWNER_KEY = (CreationExtras.Key) ZeusTransformUtils.preCheckCast(new SavedStateHandleSupport$VIEW_MODEL_STORE_OWNER_KEY$1(), CreationExtras.Key.class, "com.obric.memorydata.plugin");
        DEFAULT_ARGS_KEY = (CreationExtras.Key) ZeusTransformUtils.preCheckCast(new SavedStateHandleSupport$DEFAULT_ARGS_KEY$1(), CreationExtras.Key.class, "com.obric.memorydata.plugin");
    }

    public static final SavedStateHandle createSavedStateHandle(CreationExtras r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        SavedStateRegistryOwner r0 = (SavedStateRegistryOwner) ZeusTransformUtils.preCheckCast(r5.get(SAVED_STATE_REGISTRY_OWNER_KEY), SavedStateRegistryOwner.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L15;
        ViewModelStoreOwner r1 = (ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r5.get(VIEW_MODEL_STORE_OWNER_KEY), ViewModelStoreOwner.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L13;
        Bundle r3 = (Bundle) ZeusTransformUtils.preCheckCast(r5.get(DEFAULT_ARGS_KEY), Bundle.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY), String.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L11;
        return createSavedStateHandle(r0, r1, r6, r3);
    L11:
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    L13:
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
    L15:
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    private static final SavedStateHandle createSavedStateHandle(SavedStateRegistryOwner r3, ViewModelStoreOwner r4, String r5, Bundle r6) {
        SavedStateRegistryOwner r7 = (SavedStateRegistryOwner) ZeusTransformUtils.wrapperContextForParams(r3, SavedStateRegistryOwner.class, "com.obric.memorydata.plugin");
        ViewModelStoreOwner r8 = (ViewModelStoreOwner) ZeusTransformUtils.wrapperContextForParams(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin");
        SavedStateHandlesProvider r9 = getSavedStateHandlesProvider(r7);
        SavedStateHandlesVM r10 = getSavedStateHandlesVM(r8);
        SavedStateHandle r0 = (SavedStateHandle) ZeusTransformUtils.preCheckCast(r10.getHandles().get(r5), SavedStateHandle.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        SavedStateHandle r1 = SavedStateHandle.Companion.createHandle(r9.consumeRestoredStateForKey(r5), r6);
        r10.getHandles().put(r5, r1);
        return r1;
    L6:
        return r0;
    }

    public static final <T extends SavedStateRegistryOwner & ViewModelStoreOwner> void enableSavedStateHandles(T r5) {
        SavedStateRegistryOwner r6 = (SavedStateRegistryOwner) ZeusTransformUtils.wrapperContextForParams(r5, SavedStateRegistryOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Lifecycle.State r0 = r6.getLifecycle().getCurrentState();
        if (r0 != Lifecycle.State.INITIALIZED) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L15;
        if (r6.getSavedStateRegistry().getSavedStateProvider(SAVED_STATE_KEY) != null) goto L16;
        SavedStateHandlesProvider r2 = new SavedStateHandlesProvider(r6.getSavedStateRegistry(), (ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r6, ViewModelStoreOwner.class, "com.obric.memorydata.plugin"));
        r6.getSavedStateRegistry().registerSavedStateProvider(SAVED_STATE_KEY, (SavedStateRegistry.SavedStateProvider) ZeusTransformUtils.preCheckCast(r2, SavedStateRegistry.SavedStateProvider.class, "com.obric.memorydata.plugin"));
        r6.getLifecycle().addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(new SavedStateHandleAttacher(r2), LifecycleObserver.class, "com.obric.memorydata.plugin"));
        return;
    L16:
        return;
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r0 == Lifecycle.State.CREATED) goto L8;
        r1 = false;
        goto L9
    }

    public static final SavedStateHandlesProvider getSavedStateHandlesProvider(SavedStateRegistryOwner r2) {
        SavedStateRegistryOwner r3 = (SavedStateRegistryOwner) ZeusTransformUtils.wrapperContextForParams(r2, SavedStateRegistryOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        SavedStateRegistry.SavedStateProvider r4 = r3.getSavedStateRegistry().getSavedStateProvider(SAVED_STATE_KEY);
        if (ZeusTransformUtils.instanceOf(r4, SavedStateHandlesProvider.class) == false) goto L5;
        SavedStateHandlesProvider r5 = (SavedStateHandlesProvider) ZeusTransformUtils.preCheckCast(r4, SavedStateHandlesProvider.class, "com.obric.memorydata.plugin");
    L6:
        if (r5 == null) goto L9;
        return r5;
    L9:
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    L5:
        r5 = null;
        goto L6
    }

    public static final SavedStateHandlesVM getSavedStateHandlesVM(ViewModelStoreOwner r4) {
        ViewModelStoreOwner r5 = (ViewModelStoreOwner) ZeusTransformUtils.wrapperContextForParams(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        InitializerViewModelFactoryBuilder r0 = new InitializerViewModelFactoryBuilder();
        Function1 r2 = (Function1) ZeusTransformUtils.preCheckCast(SavedStateHandleSupport$savedStateHandlesVM$1$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        r0.addInitializer(Reflection.getOrCreateKotlinClass(SavedStateHandlesVM.class), r2);
        return (SavedStateHandlesVM) ZeusTransformUtils.preCheckCast(new ViewModelProvider(r5, r0.build()).get(VIEWMODEL_KEY, SavedStateHandlesVM.class), SavedStateHandlesVM.class, "com.obric.memorydata.plugin");
    }
}
