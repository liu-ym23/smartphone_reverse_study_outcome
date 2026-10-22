package com.bytedance.android.live.openplatform.impl.minigameanchor.widget;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.openplatform.impl.minigameanchor.context.PreviewAnchorMiniGameContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/widget/PreviewMiniGameWidgetDelegate;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "stateChanged", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewMiniGameWidgetDelegate implements LifecycleObserver {
    public final PreviewAnchorMiniGameContext a;

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    private final void stateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        this.a.dispatchLifecycleEvent(r3);
        if (r3 != Lifecycle.Event.ON_DESTROY) goto L6;
        r2.getLifecycle().removeObserver(this);
        return;
    }

    public PreviewMiniGameWidgetDelegate(Context r2, ViewGroup r3, PreviewSourceParam r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = new PreviewAnchorMiniGameContext(r2, r3, r4);
    }
}
