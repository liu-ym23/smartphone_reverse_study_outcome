package com.larus.utils.lifecycle;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/larus/utils/lifecycle/SafeLifecycleObserver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "()V", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStart", "onResume", "onPause", "onStop", "onDestroy", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public abstract class SafeLifecycleObserver implements DefaultLifecycleObserver {
    public SafeLifecycleObserver() {
    }

    public void onCreate(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
    }

    public void onDestroy(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
    }

    public void onPause(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
    }

    public void onResume(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
    }

    public final void onStart(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
    }

    public void onStop(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
    }
}
