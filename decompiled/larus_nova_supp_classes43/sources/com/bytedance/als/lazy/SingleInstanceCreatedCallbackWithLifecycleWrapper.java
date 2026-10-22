package com.bytedance.als.lazy;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.als.LogicComponent;
import com.bytedance.als.b;
import com.bytedance.objectcontainer.InstanceCreatedCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00032\u00020\u0005J\b\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/als/lazy/SingleInstanceCreatedCallbackWithLifecycleWrapper;", "Lcom/bytedance/als/b;", "T", "Lcom/bytedance/objectcontainer/InstanceCreatedCallback;", "Lcom/bytedance/als/LogicComponent;", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroy", "als_release"}, k = 1, mv = {1, 4, 1})
public final class SingleInstanceCreatedCallbackWithLifecycleWrapper<T extends b> implements InstanceCreatedCallback<LogicComponent<T>>, LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        throw null;
    }

    public final void a(Class r10, Object r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Intrinsics.checkNotNullParameter((LogicComponent) r11, "instance");
        if (r12 == false) goto L6;
        return;
    L6:
        throw null;
    }
}
