package com.bytedance.android.live.openplatform.impl.miniappanchor.widget;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.openplatform.impl.miniappanchor.context.PreviewAnchorMiniAppContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/widget/PreviewMiniAppWidgetDelegate;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "stateChanged", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewMiniAppWidgetDelegate implements LifecycleObserver {
    public final PreviewAnchorMiniAppContext a;

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    private final void stateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        this.a.dispatchLifecycleEvent(r3);
        if (r3 != Lifecycle.Event.ON_DESTROY) goto L6;
        r2.getLifecycle().removeObserver(this);
        return;
    }

    public PreviewMiniAppWidgetDelegate(Context r9, ViewGroup r10, PreviewSourceParam r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r12, "shootWay");
        Intrinsics.checkNotNullParameter(null, "previewMiniAppWidget");
        this.a = new PreviewAnchorMiniAppContext(r9, r10, r11, r12, null);
    }
}
