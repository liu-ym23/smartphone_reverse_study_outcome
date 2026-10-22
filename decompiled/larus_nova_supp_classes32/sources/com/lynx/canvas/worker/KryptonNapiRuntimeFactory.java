package com.lynx.canvas.worker;

import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonNapiRuntimeFactory {
    private String TAG;
    private WeakReference<KryptonApp> mApp;

    private native void nativeOnNapiRuntimeAttach(long r1, long r3, String r5);

    private native void nativeOnNapiRuntimeDetach(long r1);

    private KryptonNapiRuntimeFactoryService getService() {
        KryptonApp r0 = this.mApp.get();
        if (r0 != null) goto L6;
        KryptonLLog.i(this.TAG, "[worker] app == null");
        return null;
    L6:
        KryptonNapiRuntimeFactoryService r1 = (KryptonNapiRuntimeFactoryService) r0.getService(KryptonNapiRuntimeFactoryService.class);
        if (r1 != null) goto L10;
        KryptonLLog.i(this.TAG, "[worker] service == null");
        return null;
    L10:
        return r1;
    }

    public KryptonNapiRuntimeFactory(KryptonApp r2) {
        this.TAG = "KryptonNapiRuntimeFactory";
        this.mApp = new WeakReference(r2);
    }

    public static /* synthetic */ String access$000(KryptonNapiRuntimeFactory r0) {
        return r0.TAG;
    }

    public Object createNapiRuntime(final long r4) {
        KryptonNapiRuntimeFactoryService r0 = getService();
        if (r0 != null) goto L6;
        return null;
    L6:
        KryptonLLog.i(this.TAG, "[worker] create napi runtime");
        return r0.createNapiRuntime(new AnonymousClass1(this, r4));
    }

    public void destroyNapiRuntime(Object r4) {
        KryptonNapiRuntimeFactoryService r0 = getService();
        if (r0 != null) goto L5;
        return;
    L5:
        KryptonLLog.i(this.TAG, "[worker] destory napi runtime");
        r0.destoryNapiRuntime(r4);
    }

    public static /* synthetic */ void access$200(KryptonNapiRuntimeFactory r0, long r1) {
        r0.nativeOnNapiRuntimeDetach(r1);
    }

    public static /* synthetic */ void access$100(KryptonNapiRuntimeFactory r0, long r1, long r3, String r5) {
        r0.nativeOnNapiRuntimeAttach(r1, r3, r5);
    }
}
