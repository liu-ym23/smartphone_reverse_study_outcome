package androidx.lifecycle;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {
    private final ClassesInfoCache.CallbackInfo mInfo;
    private final Object mWrapped;

    public ReflectiveGenericLifecycleObserver(Object r5) {
        this.mWrapped = r5;
        this.mInfo = ClassesInfoCache.sInstance.getInfo(r5.getClass());
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner r5, @NonNull Lifecycle.Event r10) {
        this.mInfo.invokeCallbacks(r5, r10, this.mWrapped);
    }
}
