package org.chromium.diagnosis;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.a.a;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.chromium.CronetClient;

/* JADX INFO: loaded from: classes7.dex */
public class CronetDiagnosisRequestImpl implements a {
    private static final String TAG = "CronetDiagnosisRequestImpl";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static CronetEngine sCronetEngine;
    private a.InterfaceC0126a mCallback;
    private CallbackImpl mCronetCallback;
    private TTNetDiagnosisRequest mRequest;

    class CallbackImpl implements TTNetDiagnosisRequest.Callback {
        final /* synthetic */ CronetDiagnosisRequestImpl this$0;

        CallbackImpl(CronetDiagnosisRequestImpl r1) {
            this.this$0 = r1;
        }

        @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Callback
        public void onNetDiagnosisRequestComplete(TTNetDiagnosisRequest r1, String r2) {
            CronetDiagnosisRequestImpl.access$000(this.this$0).a(r2);
        }
    }

    static {
    }

    public CronetDiagnosisRequestImpl(a.InterfaceC0126a r3, int r4, List<String> r5, int r6, int r7, int r8) {
        a.InterfaceC0126a r9 = (a.InterfaceC0126a) ZeusTransformUtils.wrapperContextForParams(r3, a.InterfaceC0126a.class, "com.obric.memorydata.plugin");
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.mRequest = null;
        this.mCronetCallback = new CallbackImpl(this);
        this.mCallback = r9;
        if (sCronetEngine != null) goto L5;
        sCronetEngine = getCronetEngine();
    L5:
        CronetEngine r11 = sCronetEngine;
        if (r11 == null) goto L10;
        TTNetDiagnosisRequest.Builder r12 = r11.newNetDiagnosisRequestBuilder(this.mCronetCallback, null);
        r12.setRequestType(r4).setTargets(r10).setNetDetectType(r6).setMultiNetAction(r7).setTimeout(r8);
        this.mRequest = r12.build();
        return;
    L10:
        throw new UnsupportedOperationException("Can not get cronet engine.");
    }

    static /* synthetic */ a.InterfaceC0126a access$000(CronetDiagnosisRequestImpl r0) {
        return r0.mCallback;
    }

    private CronetEngine getCronetEngine() {
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "Init cronet engine");
    L13:
        loadCronetKernel();     // Catch: Throwable -> L7
    L12:
        return CronetClient.getCronetEngine();
    L7:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "TTNet init failed, cronet engine is null.");
        goto L12
    }

    private static void loadCronetKernel() {
        Reflect.on(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.memorydata.plugin").newInstance()).call("preInitCronetKernel");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.a.a
    public void cancel() {
        TTNetDiagnosisRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.a.a
    public void doExtraCommand(String r1, String r2) {
        TTNetDiagnosisRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.doExtraCommand(r1, r2);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.a.a
    public void start() {
        TTNetDiagnosisRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.start();
        return;
    }
}
