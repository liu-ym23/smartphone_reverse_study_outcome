package org.chromium.diagnosis;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.ttnet.TTNetInit;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import java.util.List;
import org.chromium.CronetClient;
import q2.a;

/* JADX INFO: loaded from: classes3.dex */
public class CronetDiagnosisRequestImpl implements a {
    private static final String TAG = "CronetDiagnosisRequestImpl";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static CronetEngine sCronetEngine;
    private a.InterfaceC0281a mCallback;
    private CallbackImpl mCronetCallback;
    private TTNetDiagnosisRequest mRequest;

    class CallbackImpl implements TTNetDiagnosisRequest.Callback {
        final /* synthetic */ CronetDiagnosisRequestImpl this$0;

        CallbackImpl(CronetDiagnosisRequestImpl r10) {
            this.this$0 = r10;
        }

        @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Callback
        public void onNetDiagnosisRequestComplete(TTNetDiagnosisRequest r10, String r11) {
            CronetDiagnosisRequestImpl.access$000(this.this$0).a(r11);
        }
    }

    static {
    }

    public CronetDiagnosisRequestImpl(a.InterfaceC0281a r10, int r11, List<String> r12, int r13, int r14, int r15) {
        this.mRequest = null;
        this.mCronetCallback = new CallbackImpl(this);
        this.mCallback = r10;
        if (sCronetEngine != null) goto L5;
        sCronetEngine = getCronetEngine();
    L5:
        CronetEngine r16 = sCronetEngine;
        if (r16 == null) goto L10;
        TTNetDiagnosisRequest.Builder r17 = r16.newNetDiagnosisRequestBuilder(this.mCronetCallback, null);
        r17.setRequestType(r11).setTargets(r12).setNetDetectType(r13).setMultiNetAction(r14).setTimeout(r15);
        this.mRequest = r17.build();
        return;
    L10:
        throw new UnsupportedOperationException("Can not get cronet engine.");
    }

    static /* synthetic */ a.InterfaceC0281a access$000(CronetDiagnosisRequestImpl r10) {
        return r10.mCallback;
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
        String r10 = TTNetInit.DOMAIN_HTTPDNS_KEY;
        Reflect.on(TTNetInit.class.newInstance()).call("preInitCronetKernel");
    }

    @Override // q2.a
    public void cancel() {
        TTNetDiagnosisRequest r10 = this.mRequest;
        if (r10 == null) goto L6;
        r10.cancel();
        return;
    }

    @Override // q2.a
    public void doExtraCommand(String r10, String r11) {
        TTNetDiagnosisRequest r12 = this.mRequest;
        if (r12 == null) goto L6;
        r12.doExtraCommand(r10, r11);
        return;
    }

    @Override // q2.a
    public void start() {
        TTNetDiagnosisRequest r10 = this.mRequest;
        if (r10 == null) goto L6;
        r10.start();
        return;
    }
}
