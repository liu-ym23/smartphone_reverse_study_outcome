package org.chromium.diagnosis;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.ttnet.TTNetInit;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import java.util.List;
import org.chromium.CronetClient;

/* JADX INFO: loaded from: classes2.dex */
public class CronetDiagnosisRequestImpl implements z6.a {
    private static final String TAG = "CronetDiagnosisRequestImpl";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static CronetEngine sCronetEngine;
    private z6.a.InterfaceC0204a mCallback;
    private a mCronetCallback;
    private TTNetDiagnosisRequest mRequest;

    public class a implements TTNetDiagnosisRequest.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetDiagnosisRequestImpl f9799a;

        public a(CronetDiagnosisRequestImpl r8) {
            this.f9799a = r8;
        }

        @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Callback
        public final void onNetDiagnosisRequestComplete(TTNetDiagnosisRequest r8, String r10) {
            CronetDiagnosisRequestImpl.access$000(this.f9799a).a(r10);
        }
    }

    public CronetDiagnosisRequestImpl(z6.a.InterfaceC0204a r8, int r10, List<String> r11, int r12, int r13) {
        this.mRequest = null;
        this.mCronetCallback = new a(this);
        this.mCallback = r8;
        if (sCronetEngine != null) goto L5;
        sCronetEngine = getCronetEngine();
    L5:
        CronetEngine r14 = sCronetEngine;
        if (r14 == null) goto L11;
        if (r14 == null) goto L12;
        TTNetDiagnosisRequest.Builder r15 = r14.newNetDiagnosisRequestBuilder(this.mCronetCallback, null);
        r15.setRequestType(r10).setTargets(r11).setNetDetectType(r12).setTimeout(r13);
        this.mRequest = r15.build();
        return;
    L12:
        return;
    L11:
        throw new UnsupportedOperationException("Can not get cronet engine.");
    }

    public static /* synthetic */ z6.a.InterfaceC0204a access$000(CronetDiagnosisRequestImpl r8) {
        return r8.mCallback;
    }

    private CronetEngine getCronetEngine() {
        Logger.d(TAG, "Init cronet engine");
        loadCronetKernel();     // Catch: Throwable -> L5
    L8:
        return CronetClient.getCronetEngine();
    L5:
        th = move-exception;
        th.printStackTrace();
        Logger.d(TAG, "TTNet init failed, cronet engine is null.");
        goto L8
    }

    private static void loadCronetKernel() {
        String r8 = TTNetInit.DOMAIN_HTTPDNS_KEY;
        Reflect.on(TTNetInit.class.newInstance()).call("preInitCronetKernel");
    }

    @Override // z6.a
    public void cancel() {
        TTNetDiagnosisRequest r8 = this.mRequest;
        if (r8 == null) goto L6;
        r8.cancel();
        return;
    }

    @Override // z6.a
    public void doExtraCommand(String r8, String r10) {
        TTNetDiagnosisRequest r11 = this.mRequest;
        if (r11 == null) goto L6;
        r11.doExtraCommand(r8, r10);
        return;
    }

    @Override // z6.a
    public void start() {
        TTNetDiagnosisRequest r8 = this.mRequest;
        if (r8 == null) goto L6;
        r8.start();
        return;
    }
}
