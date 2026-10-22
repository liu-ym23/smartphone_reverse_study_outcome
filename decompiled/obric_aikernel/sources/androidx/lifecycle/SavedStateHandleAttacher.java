package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleAttacher implements LifecycleEventObserver {
    private final SavedStateHandlesProvider provider;

    public SavedStateHandleAttacher(SavedStateHandlesProvider r10) {
        Intrinsics.checkNotNullParameter(r10, "provider");
        this.provider = r10;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_EVENT);
        if (r11 != Lifecycle.Event.ON_CREATE) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        r10.getLifecycle().removeObserver(this);
        this.provider.performRestore();
        return;
    L10:
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + r11).toString());
    L5:
        r12 = false;
        goto L6
    }
}
