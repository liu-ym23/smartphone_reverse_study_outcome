package com.bytedance.apm6.service.lifecycle;

import android.app.Activity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class DummyLifecycleListener implements IActivityLifecycleObserver {
    public DummyLifecycleListener() {
    }

    @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
    public void onActivityCreated(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
    public void onActivityPause(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
    public void onActivityResume(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
    public void onActivityStarted(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
    public void onBackground(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
    public void onFront(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }
}
