package com.bytedance.als.ui.state;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.als.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LiveState<T> extends g<T> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/als/ui/state/LiveState$CallbackWithLifecycle;", "Landroidx/lifecycle/LifecycleEventObserver;", "als_release"}, k = 1, mv = {1, 4, 1})
    public final class CallbackWithLifecycle implements LifecycleEventObserver {
        public final void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
            Intrinsics.checkNotNullParameter(r10, "source");
            Intrinsics.checkNotNullParameter(r11, "event");
            throw null;
        }
    }
}
