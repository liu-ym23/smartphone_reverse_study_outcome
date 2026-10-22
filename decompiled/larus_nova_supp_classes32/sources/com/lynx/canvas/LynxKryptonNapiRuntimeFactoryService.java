package com.lynx.canvas;

import com.lynx.canvas.worker.KryptonNapiRuntimeFactoryService;
import com.lynx.jsbridge.g;
import com.lynx.tasm.LynxBackgroundRuntime;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.q;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxKryptonNapiRuntimeFactoryService extends KryptonNapiRuntimeFactoryService {
    private static final String TAG = "LynxKryptonNapiRuntimeFactoryService";
    private WeakReference<KryptonApp> mAppWeakReference;

    public LynxKryptonNapiRuntimeFactoryService() {
    }

    @Override // com.lynx.canvas.worker.KryptonNapiRuntimeFactoryService
    public Object createNapiRuntime(final KryptonNapiRuntimeFactoryService.NapiRuntimeLifecycleListener r8) {
        WeakReference<KryptonApp> r0 = this.mAppWeakReference;
        if (r0 != null) goto L6;
        LLog.i(TAG, "[worker] create background runtime failed, mAppWeakReference == null");
        return null;
    L6:
        KryptonApp r1 = r0.get();
        if (r1 != null) goto L10;
        LLog.i(TAG, "[worker] create background runtime failed, app = null");
        return null;
    L10:
        q r2 = new q();
        LynxGroup.a r3 = new LynxGroup.a();
        r3.a = "-1";
        r3.e = true;
        Boolean r4 = Boolean.TRUE;
        r3.f = r4;
        r2.c = new LynxGroup(r3);
        r2.l = r4;
        LLog.i(TAG, "[worker] create background runtime ");
        final LynxBackgroundRuntime r5 = new LynxBackgroundRuntime(r1.getContext(), r2, false);
        if (LynxEnv.inst().isDevtoolEnabled() == false) goto L13;
        r5.c("krypton://worker-" + r5.e() + ".com", NameKeys.UnloadStrategy_No_Strategy);
    L13:
        g r6 = new AnonymousClass1(this, r5, r8);
        if (r5.f != 0) goto L16;
        LLog.w("LynxBackgroundRuntime", "add a null lifecycle listener or runtime has been destroy.");
    L17:
        return r5;
    L16:
        r5.c.a(r6);
        goto L17
    }

    @Override // com.lynx.canvas.worker.KryptonNapiRuntimeFactoryService
    public void destoryNapiRuntime(Object r2) {
        if ((r2 instanceof LynxBackgroundRuntime) == true) goto L6;
        LLog.i(TAG, "[worker] !object instanceof LynxBackgroundRuntime ");
        return;
    L6:
        ((LynxBackgroundRuntime) r2).b();
    }

    @Override // com.lynx.canvas.KryptonService
    public void onBootstrap(KryptonApp r2) {
        super.onBootstrap(r2);
        this.mAppWeakReference = new WeakReference(r2);
    }
}
