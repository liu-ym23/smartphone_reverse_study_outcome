package androidx.lifecycle;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public interface DefaultLifecycleObserver extends LifecycleObserver {
    default void onCreate(LifecycleOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "owner");
    }

    default void onDestroy(LifecycleOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "owner");
    }

    default void onPause(LifecycleOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "owner");
    }

    default void onResume(LifecycleOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "owner");
    }

    default void onStart(LifecycleOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "owner");
    }

    default void onStop(LifecycleOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "owner");
    }
}
