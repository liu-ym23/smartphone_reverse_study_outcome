package com.bytedance.als.utilis;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/als/utilis/LifecycleAdapter;", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "als_release"}, k = 1, mv = {1, 4, 1})
public final class LifecycleAdapter extends Lifecycle implements LifecycleOwner {
    public final LifecycleRegistry a;

    public final Lifecycle.State getCurrentState() {
        return this.a.getCurrentState();
    }

    public LifecycleAdapter() {
        this.a = new LifecycleRegistry(this);
    }

    public final Lifecycle getLifecycle() {
        return this.a;
    }

    public final void addObserver(LifecycleObserver r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        this.a.addObserver(r10);
    }

    public final void removeObserver(LifecycleObserver r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        this.a.removeObserver(r10);
    }
}
