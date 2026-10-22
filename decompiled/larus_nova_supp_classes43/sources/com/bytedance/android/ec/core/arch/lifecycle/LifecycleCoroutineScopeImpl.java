package com.bytedance.android.ec.core.arch.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/arch/lifecycle/LifecycleCoroutineScopeImpl;", "Lcom/bytedance/android/ec/core/arch/lifecycle/d;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleObserver;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LifecycleCoroutineScopeImpl extends d implements LifecycleEventObserver, LifecycleObserver {
    public final Lifecycle a;
    public final CoroutineContext b;

    @Override // com.bytedance.android.ec.core.arch.lifecycle.d
    public final Lifecycle a() {
        return this.a;
    }

    public final CoroutineContext getCoroutineContext() {
        return this.b;
    }

    public LifecycleCoroutineScopeImpl(Lifecycle r10, CoroutineContext r11) {
        Intrinsics.checkNotNullParameter(r10, "lifecycle");
        Intrinsics.checkNotNullParameter(r11, "coroutineContext");
        this.a = r10;
        this.b = r11;
        if (r10.getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
        JobKt.cancel$default(r11, null, 1, null);
        return;
    }

    public final void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "event");
        if (this.a.getCurrentState().compareTo(Lifecycle.State.DESTROYED) > 0) goto L6;
        this.a.removeObserver(this);
        JobKt.cancel$default(this.b, null, 1, null);
        return;
    }
}
