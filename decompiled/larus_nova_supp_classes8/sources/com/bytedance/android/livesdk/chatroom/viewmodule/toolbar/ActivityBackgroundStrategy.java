package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ActivityBackgroundStrategy;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/b0;", "Landroidx/lifecycle/LifecycleObserver;", "", "onStart", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActivityBackgroundStrategy implements b0, LifecycleObserver {
    public a0<?> a;

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private final void onStart() {
        a0<?> r0 = this.a;
        if (r0 == null) goto L6;
        r0.tryStartNextBubble();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b0
    public final boolean a(a0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        return Lifecycle.State.RESUMED.isAtLeast(Lifecycle.State.STARTED);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b0
    public final void b(a0<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b0
    public final void c(a0<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        this.a = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b0
    public final void d(ToolbarBubbleManager.BubbleInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r2, "info");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b0
    public final void e(ToolbarBubbleManager.BubbleInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r2, "info");
    }
}
