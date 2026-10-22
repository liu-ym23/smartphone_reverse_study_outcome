package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.savedstate.SavedStateRegistry;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nSavedStateHandleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandleController.kt\nandroidx/lifecycle/SavedStateHandleController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n1#2:42\n*E\n"})
public final class SavedStateHandleController implements LifecycleEventObserver {
    private final SavedStateHandle handle;
    private boolean isAttached;
    private final String key;

    public SavedStateHandleController(String r10, SavedStateHandle r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "handle");
        this.key = r10;
        this.handle = r11;
    }

    public final void attachToLifecycle(SavedStateRegistry r10, Lifecycle r11) {
        Intrinsics.checkNotNullParameter(r10, "registry");
        Intrinsics.checkNotNullParameter(r11, "lifecycle");
        if ((!this.isAttached) == false) goto L7;
        this.isAttached = true;
        r11.addObserver(this);
        r10.registerSavedStateProvider(this.key, this.handle.savedStateProvider());
        return;
    L7:
        throw new IllegalStateException("Already attached to lifecycleOwner".toString());
    }

    public final SavedStateHandle getHandle() {
        return this.handle;
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_EVENT);
        if (r11 != Lifecycle.Event.ON_DESTROY) goto L6;
        this.isAttached = false;
        r10.getLifecycle().removeObserver(this);
        return;
    }
}
