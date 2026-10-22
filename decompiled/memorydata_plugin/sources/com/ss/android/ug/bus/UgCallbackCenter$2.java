package com.ss.android.ug.bus;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
class UgCallbackCenter$2 implements LifecycleObserver {
    final /* synthetic */ a.InterfaceC0838a val$callback;
    final /* synthetic */ Type val$eventType;
    final /* synthetic */ ConcurrentHashMap val$finalObservers;

    UgCallbackCenter$2(ConcurrentHashMap r3, a.InterfaceC0838a r4, Type r5) {
        a.InterfaceC0838a r6 = (a.InterfaceC0838a) ZeusTransformUtils.wrapperContextForParams(r4, a.InterfaceC0838a.class, "com.obric.memorydata.plugin");
        Type r7 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin");
        this.val$finalObservers = r3;
        this.val$callback = r6;
        this.val$eventType = r7;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        this.val$finalObservers.remove(this.val$callback);
        if (this.val$finalObservers.isEmpty() == false) goto L6;
        a.a().remove(this.val$eventType);
        return;
    }
}
