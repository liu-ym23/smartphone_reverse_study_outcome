package androidx.lifecycle;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {
    private final ClassesInfoCache.CallbackInfo mInfo;
    private final Object mWrapped;

    ReflectiveGenericLifecycleObserver(Object r10) {
        this.mWrapped = r10;
        this.mInfo = ClassesInfoCache.sInstance.getInfo(r10.getClass());
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner r10, @NonNull Lifecycle.Event r11) {
        this.mInfo.invokeCallbacks(r10, r11, this.mWrapped);
    }
}
