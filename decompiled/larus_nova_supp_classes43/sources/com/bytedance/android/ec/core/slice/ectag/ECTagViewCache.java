package com.bytedance.android.ec.core.slice.ectag;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/core/slice/ectag/ECTagViewCache;", "Landroidx/lifecycle/LifecycleEventObserver;", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTagViewCache implements LifecycleEventObserver {

    public static final class a {
    }

    static {
        new ConcurrentHashMap();
    }

    public final void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "event");
        if (r10.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L6;
        return;
    L6:
        throw null;
    }
}
