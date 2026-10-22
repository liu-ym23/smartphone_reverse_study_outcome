package com.ss.android.cert.manager.api;

import android.content.Context;
import com.ss.android.cert.manager.callback.CertCallback;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IAliyunCert extends IPlugin {
    void doFaceLiveness(Context r1, Map<String, String> r2, CertCallback r3);

    String getMetaInfos(Context r1);

    JSONObject getSession();

    void init(Context r1);
}
