package com.bytedance.sdk.xbridge.cn.system;

import android.annotation.SuppressLint;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mj.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u000b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/sdk/xbridge/cn/system/XOpenPermissionSettingsMethod$handle$lifeCycleMonitorListener$1", "Landroidx/lifecycle/GenericLifecycleObserver;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SuppressLint({"RestrictedApi"})
public final class XOpenPermissionSettingsMethod$handle$lifeCycleMonitorListener$1 implements GenericLifecycleObserver {
    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r5, Lifecycle.Event r10) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r10, "event");
        if (r10 != Lifecycle.Event.ON_RESUME) goto L5;
    L7:
        int r11 = b.f20111a;
        throw null;
    L5:
        if (r10 == Lifecycle.Event.ON_PAUSE) goto L7;
    }
}
