package com.bytedance.apm.core;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public interface ILifecycle {
    void onActivityCreated(Activity r10, Bundle r11);

    void onActivityDestroyed(Activity r10);

    void onActivityResumed(Activity r10);

    void onBackground(Activity r10);

    void onFront(Activity r10);
}
