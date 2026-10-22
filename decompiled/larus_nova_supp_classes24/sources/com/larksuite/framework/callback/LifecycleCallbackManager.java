package com.larksuite.framework.callback;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LifecycleCallbackManager implements DefaultLifecycleObserver {
    public final /* synthetic */ void onCreate(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onCreate(this, r1);
    }

    public final /* synthetic */ void onPause(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onPause(this, r1);
    }

    public final /* synthetic */ void onResume(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onResume(this, r1);
    }

    public final /* synthetic */ void onStart(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStart(this, r1);
    }

    public final /* synthetic */ void onStop(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStop(this, r1);
    }

    private LifecycleCallbackManager() {
    }

    public final void onDestroy(LifecycleOwner r1) {
        r1.getLifecycle().removeObserver(this);
    }
}
