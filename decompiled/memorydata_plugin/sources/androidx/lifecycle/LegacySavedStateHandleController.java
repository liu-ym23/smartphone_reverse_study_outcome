package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J,\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/lifecycle/LegacySavedStateHandleController;", "", "()V", "TAG_SAVED_STATE_HANDLE_CONTROLLER", "", "attachHandleIfNeeded", "", "viewModel", "Landroidx/lifecycle/ViewModel;", "registry", "Landroidx/savedstate/SavedStateRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "create", "Landroidx/lifecycle/SavedStateHandleController;", "key", "defaultArgs", "Landroid/os/Bundle;", "tryToAddRecreator", "OnRecreation", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LegacySavedStateHandleController {
    public static final LegacySavedStateHandleController INSTANCE = null;
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Landroidx/lifecycle/LegacySavedStateHandleController$OnRecreation;", "Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "()V", "onRecreated", "", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        public OnRecreation() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.AutoRecreated
        public void onRecreated(SavedStateRegistryOwner r6) {
            SavedStateRegistryOwner r5 = (SavedStateRegistryOwner) ZeusTransformUtils.wrapperContextForParams(r6, SavedStateRegistryOwner.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "owner");
            if (ZeusTransformUtils.instanceOf(r5, ViewModelStoreOwner.class) == false) goto L13;
            ViewModelStore r7 = ((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r5, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).getViewModelStore();
            SavedStateRegistry r1 = r5.getSavedStateRegistry();
            Iterator<String> r2 = r7.keys().iterator();
        L6:
            if (r2.hasNext() == false) goto L9;
            ViewModel r3 = r7.get((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin"));
            Intrinsics.checkNotNull(r3);
            LegacySavedStateHandleController.attachHandleIfNeeded(r3, r1, r5.getLifecycle());
            goto L6
        L9:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r7.keys(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L15;
            r1.runOnNextRecreation(OnRecreation.class);
            return;
        L15:
            return;
        L13:
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
        }
    }

    static {
        INSTANCE = new LegacySavedStateHandleController();
    }

    private LegacySavedStateHandleController() {
    }

    @JvmStatic
    public static final void attachHandleIfNeeded(ViewModel r2, SavedStateRegistry r3, Lifecycle r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "registry");
        Intrinsics.checkNotNullParameter(r4, "lifecycle");
        SavedStateHandleController r5 = (SavedStateHandleController) ZeusTransformUtils.preCheckCast(r2.getTag("androidx.lifecycle.savedstate.vm.tag"), SavedStateHandleController.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isAttached() == true) goto L9;
        r5.attachToLifecycle(r3, r4);
        INSTANCE.tryToAddRecreator(r3, r4);
        return;
    }

    @JvmStatic
    public static final SavedStateHandleController create(SavedStateRegistry r2, Lifecycle r3, String r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r2, "registry");
        Intrinsics.checkNotNullParameter(r3, "lifecycle");
        Intrinsics.checkNotNull(r4);
        Bundle r0 = r2.consumeRestoredStateForKey(r4);
        SavedStateHandleController r1 = new SavedStateHandleController(r4, SavedStateHandle.Companion.createHandle(r0, r5));
        r1.attachToLifecycle(r2, r3);
        INSTANCE.tryToAddRecreator(r2, r3);
        return r1;
    }

    private final void tryToAddRecreator(final SavedStateRegistry r2, final Lifecycle r3) {
        Lifecycle.State r1 = r3.getCurrentState();
        if (r1 != Lifecycle.State.INITIALIZED) goto L5;
    L8:
        r2.runOnNextRecreation(OnRecreation.class);
        return;
    L5:
        if (r1.isAtLeast(Lifecycle.State.STARTED) == true) goto L8;
        r3.addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3, r2), LifecycleObserver.class, "com.obric.memorydata.plugin"));
    }
}
