package com.lynx.canvas.worker;

import com.lynx.canvas.KryptonService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class KryptonNapiRuntimeFactoryService extends KryptonService {

    public interface NapiRuntimeLifecycleListener {
        void onRuntimeAttach(long r1, String r3);

        void onRuntimeDetach();
    }

    public abstract Object createNapiRuntime(NapiRuntimeLifecycleListener r1);

    public abstract void destoryNapiRuntime(Object r1);

    public KryptonNapiRuntimeFactoryService() {
    }
}
