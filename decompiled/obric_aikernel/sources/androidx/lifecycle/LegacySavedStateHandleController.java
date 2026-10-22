package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class LegacySavedStateHandleController {
    public static final LegacySavedStateHandleController INSTANCE = null;
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";

    public static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        public OnRecreation() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.AutoRecreated
        public void onRecreated(SavedStateRegistryOwner r10) {
            Intrinsics.checkNotNullParameter(r10, "owner");
            if ((r10 instanceof ViewModelStoreOwner) == false) goto L13;
            ViewModelStore r11 = ((ViewModelStoreOwner) r10).getViewModelStore();
            SavedStateRegistry r12 = r10.getSavedStateRegistry();
            Iterator<String> r13 = r11.keys().iterator();
        L6:
            if (r13.hasNext() == false) goto L9;
            ViewModel r14 = r11.get(r13.next());
            Intrinsics.checkNotNull(r14);
            LegacySavedStateHandleController.attachHandleIfNeeded(r14, r12, r10.getLifecycle());
            goto L6
        L9:
            if ((!r11.keys().isEmpty()) == false) goto L15;
            r12.runOnNextRecreation(OnRecreation.class);
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
    public static final void attachHandleIfNeeded(ViewModel r10, SavedStateRegistry r11, Lifecycle r12) {
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        Intrinsics.checkNotNullParameter(r11, "registry");
        Intrinsics.checkNotNullParameter(r12, "lifecycle");
        SavedStateHandleController r13 = (SavedStateHandleController) r10.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (r13 != null) goto L5;
        return;
    L5:
        if (r13.isAttached() == true) goto L9;
        r13.attachToLifecycle(r11, r12);
        INSTANCE.tryToAddRecreator(r11, r12);
        return;
    }

    @JvmStatic
    public static final SavedStateHandleController create(SavedStateRegistry r10, Lifecycle r11, String r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r10, "registry");
        Intrinsics.checkNotNullParameter(r11, "lifecycle");
        Intrinsics.checkNotNull(r12);
        Bundle r14 = r10.consumeRestoredStateForKey(r12);
        SavedStateHandleController r15 = new SavedStateHandleController(r12, SavedStateHandle.Companion.createHandle(r14, r13));
        r15.attachToLifecycle(r10, r11);
        INSTANCE.tryToAddRecreator(r10, r11);
        return r15;
    }

    private final void tryToAddRecreator(final SavedStateRegistry r10, final Lifecycle r11) {
        Lifecycle.State r12 = r11.getCurrentState();
        if (r12 != Lifecycle.State.INITIALIZED) goto L5;
    L8:
        r10.runOnNextRecreation(OnRecreation.class);
        return;
    L5:
        if (r12.isAtLeast(Lifecycle.State.STARTED) == true) goto L8;
        r11.addObserver(new AnonymousClass1(r11, r10));
    }
}
