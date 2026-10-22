package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateRegistryController {
    public static final Companion Companion = null;
    private boolean attached;
    private final SavedStateRegistryOwner owner;
    private final SavedStateRegistry savedStateRegistry;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @JvmStatic
        public final SavedStateRegistryController create(SavedStateRegistryOwner r10) {
            Intrinsics.checkNotNullParameter(r10, "owner");
            return new SavedStateRegistryController(r10, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private SavedStateRegistryController(SavedStateRegistryOwner r10) {
        this.owner = r10;
        this.savedStateRegistry = new SavedStateRegistry();
    }

    public /* synthetic */ SavedStateRegistryController(SavedStateRegistryOwner r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    @JvmStatic
    public static final SavedStateRegistryController create(SavedStateRegistryOwner r10) {
        return Companion.create(r10);
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistry;
    }

    @MainThread
    public final void performAttach() {
        Lifecycle r10 = this.owner.getLifecycle();
        if (r10.getCurrentState() != Lifecycle.State.INITIALIZED) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L10;
        r10.addObserver(new Recreator(this.owner));
        this.savedStateRegistry.performAttach$savedstate_release(r10);
        this.attached = true;
        return;
    L10:
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    L5:
        r11 = false;
        goto L6
    }

    @MainThread
    public final void performRestore(Bundle r10) {
        if (this.attached == true) goto L5;
        performAttach();
    L5:
        Lifecycle r11 = this.owner.getLifecycle();
        if ((!r11.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) == false) goto L10;
        this.savedStateRegistry.performRestore$savedstate_release(r10);
        return;
    L10:
        throw new IllegalStateException(("performRestore cannot be called when owner is " + r11.getCurrentState()).toString());
    }

    @MainThread
    public final void performSave(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "outBundle");
        this.savedStateRegistry.performSave(r10);
    }
}
