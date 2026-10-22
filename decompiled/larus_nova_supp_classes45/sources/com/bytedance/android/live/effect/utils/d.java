package com.bytedance.android.live.effect.utils;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.ss.android.ugc.effectmanager.common.EffectRequest;
import com.ss.android.ugc.effectmanager.common.listener.IEffectNetWorker;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class d implements IEffectNetWorker {
    public final IHostNetwork a;

    public d() {
        this.a = jc1.k.f(IHostNetwork.class);
    }

    public InputStream execute(EffectRequest r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r6.getHttpMethod()) == false) goto L8;
        return null;
    L8:
        if ("GET".equals(r6.getHttpMethod()) == true) goto L10;
        String r1 = r6.getUrl();
        String r2 = r6.getContentType();
        Map r3 = r6.getHeaders();
        Map r7 = r6.getParams();
        return this.a.doPost(r1, r2, r3, r7);
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    L10:
        return a(r6.getUrl(), r6.getHeaders());
    }

    public InputStream a(String r5, Map<String, String> r6) {
        ArrayList r0 = new ArrayList();
        if (r6 != null) goto L5;
    L20:
        LiveCall r7 = this.a.get(r5, r0);     // Catch: Throwable -> L16
        if (r7 == null) goto L26;
        return new ByteArrayInputStream(((HttpResponse) r7.execute()).getBody());
    L26:
        return null;
    L16:
        th = move-exception;
        th.printStackTrace();
        return null;
    L5:
        if (r6.size() <= 0) goto L20;
        Iterator<Map.Entry<String, String>> r8 = r6.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L20;
        Map.Entry<String, String> r1 = r8.next();
        if (r1 == null) goto L8;
        r0.add(new NameValuePair(r1.getKey(), r1.getValue()));
        goto L8
    }
}
