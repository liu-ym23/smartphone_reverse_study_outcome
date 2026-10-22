package com.ss.android.bytedcert;

import android.app.Activity;
import android.content.Context;
import com.ss.android.bytedcert.flow.cert.BytedCertFlowParams;
import com.ss.android.bytedcert.flow.face.FaceDetectFlowParams;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.cert.manager.ablity.IEventParamsInterceptor;
import com.ss.android.cert.manager.ablity.IRequestExtraInterceptor;
import com.ss.android.cert.manager.api.IBytedCert;
import com.ss.android.cert.manager.callback.CertResultCallback;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class BytedCertImpl implements IBytedCert {
    public BytedCertImpl() {
    }

    @Override // com.ss.android.cert.manager.api.IBytedCert
    public IEventParamsInterceptor getEventParamsInterceptor() {
        return null;
    }

    @Override // com.ss.android.cert.manager.api.IBytedCert
    public IRequestExtraInterceptor getExtraInterceptor() {
        return null;
    }

    @Override // com.ss.android.cert.manager.api.IBytedCert
    public void init(Context r1) {
    }

    @Override // com.ss.android.cert.manager.api.IPlugin
    public boolean installPlugin(Context r1) {
        return true;
    }

    private static String resolveLanguage(Map<String, String> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.isEmpty() == true) goto L16;
        String r3 = r2.get("byted_cert_language");
        if (r3 != null) goto L10;
        return null;
    L10:
        if (r3.trim().isEmpty() == false) goto L13;
        return null;
    L13:
        return r3;
    L16:
        return null;
    }

    @Override // com.ss.android.cert.manager.api.IBytedCert
    public void startCertFlow(Activity r3, Map<String, String> r4, CertResultCallback r5) {
        BytedCertManager.getInstance().startBytedCert(new BytedCertFlowParams.Builder(r3).setCertInfo(r4).setLanguage(resolveLanguage(r4)).setCertInfo("use_new_api", "true").setCertResultCallback(r5).build());
    }

    @Override // com.ss.android.cert.manager.api.IBytedCert
    public void startFaceLiveness(Activity r3, Map<String, String> r4, CertResultCallback r5) {
        BytedCertManager.getInstance().doFaceLive(new FaceDetectFlowParams.Builder(r3).setCertInfo(r4).setLanguage(resolveLanguage(r4)).setCertInfo("use_new_api", "true").setFaceLiveCallback(new 1(this, r5)).build());
    }
}
