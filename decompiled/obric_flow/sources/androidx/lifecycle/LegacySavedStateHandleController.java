package androidx.lifecycle;

import android.os.Bundle;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J,\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/lifecycle/LegacySavedStateHandleController;", "", "()V", "TAG_SAVED_STATE_HANDLE_CONTROLLER", "", "attachHandleIfNeeded", "", "viewModel", "Landroidx/lifecycle/ViewModel;", "registry", "Landroidx/savedstate/SavedStateRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "create", "Landroidx/lifecycle/SavedStateHandleController;", STGroup.DICT_KEY, "defaultArgs", "Landroid/os/Bundle;", "tryToAddRecreator", "OnRecreation", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LegacySavedStateHandleController {
    public static final LegacySavedStateHandleController INSTANCE = null;
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Landroidx/lifecycle/LegacySavedStateHandleController$OnRecreation;", "Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "()V", "onRecreated", "", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        public OnRecreation() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.AutoRecreated
        public void onRecreated(SavedStateRegistryOwner r5) {
            Intrinsics.checkNotNullParameter(r5, "owner");
            if ((r5 instanceof ViewModelStoreOwner) == false) goto L13;
            ViewModelStore r10 = ((ViewModelStoreOwner) r5).getViewModelStore();
            SavedStateRegistry r11 = r5.getSavedStateRegistry();
            Iterator<String> r12 = r10.keys().iterator();
        L6:
            if (r12.hasNext() == false) goto L9;
            ViewModel r13 = r10.get(r12.next());
            Intrinsics.checkNotNull(r13);
            LegacySavedStateHandleController.attachHandleIfNeeded(r13, r11, r5.getLifecycle());
            goto L6
        L9:
            if (r10.keys().isEmpty() == true) goto L15;
            r11.runOnNextRecreation(OnRecreation.class);
            return;
        L15:
            return;
        L13:
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
        }
    }

    static {
        INSTANCE = new LegacySavedStateHandleController();
    }

    private LegacySavedStateHandleController() {
    }

    @JvmStatic
    public static final void attachHandleIfNeeded(ViewModel r5, SavedStateRegistry r10, Lifecycle r11) {
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        Intrinsics.checkNotNullParameter(r10, "registry");
        Intrinsics.checkNotNullParameter(r11, "lifecycle");
        SavedStateHandleController r12 = (SavedStateHandleController) r5.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.isAttached() == true) goto L9;
        r12.attachToLifecycle(r10, r11);
        INSTANCE.tryToAddRecreator(r10, r11);
        return;
    }

    @JvmStatic
    public static final SavedStateHandleController create(SavedStateRegistry r5, Lifecycle r10, String r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r5, "registry");
        Intrinsics.checkNotNullParameter(r10, "lifecycle");
        Intrinsics.checkNotNull(r11);
        Bundle r13 = r5.consumeRestoredStateForKey(r11);
        SavedStateHandleController r14 = new SavedStateHandleController(r11, SavedStateHandle.Companion.createHandle(r13, r12));
        r14.attachToLifecycle(r5, r10);
        INSTANCE.tryToAddRecreator(r5, r10);
        return r14;
    }

    private final void tryToAddRecreator(final SavedStateRegistry r5, final Lifecycle r10) {
        Lifecycle.State r11 = r10.getCurrentState();
        if (r11 != Lifecycle.State.INITIALIZED) goto L5;
    L8:
        r5.runOnNextRecreation(OnRecreation.class);
        return;
    L5:
        if (r11.isAtLeast(Lifecycle.State.STARTED) == true) goto L8;
        r10.addObserver(new AnonymousClass1(r10, r5));
    }
}
