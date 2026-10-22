package com.bytedance.assem.arch.extensions;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/bytedance/assem/arch/extensions/AssembleExtKt$assemble$1$1", "Landroidx/lifecycle/LifecycleEventObserver;", "assem_release"}, k = 1, mv = {1, 4, 0})
public final class AssembleExtKt$assemble$$inlined$let$lambda$1 implements LifecycleEventObserver {
    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r5, Lifecycle.Event r10) {
        if (a.f3932a[r10.ordinal()] == 1) goto L6;
        return;
    L6:
        throw null;
    }
}
