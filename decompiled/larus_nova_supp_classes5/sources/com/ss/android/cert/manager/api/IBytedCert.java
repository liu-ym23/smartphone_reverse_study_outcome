package com.ss.android.cert.manager.api;

import android.app.Activity;
import android.content.Context;
import com.ss.android.cert.manager.ablity.IEventParamsInterceptor;
import com.ss.android.cert.manager.ablity.IRequestExtraInterceptor;
import com.ss.android.cert.manager.callback.CertResultCallback;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IBytedCert extends IPlugin {
    IEventParamsInterceptor getEventParamsInterceptor();

    IRequestExtraInterceptor getExtraInterceptor();

    void init(Context r1);

    void startCertFlow(Activity r1, Map<String, String> r2, CertResultCallback r3);

    void startFaceLiveness(Activity r1, Map<String, String> r2, CertResultCallback r3);
}
