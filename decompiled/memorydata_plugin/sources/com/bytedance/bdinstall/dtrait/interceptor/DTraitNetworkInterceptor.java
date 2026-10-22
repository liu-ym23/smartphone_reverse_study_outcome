package com.bytedance.bdinstall.dtrait.interceptor;

import android.text.TextUtils;
import com.bytedance.bdinstall.dtrait.DTraitApi;
import com.bytedance.bdinstall.dtrait.constant.DTraitRiskType;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DTraitNetworkInterceptor implements Interceptor {
    private final IHostConfig mConfig;

    public interface IHostConfig {
        boolean allow(String r1);

        DTraitRiskType getRiskType();

        int getTimeout();
    }

    public DTraitNetworkInterceptor(IHostConfig r3) {
        this.mConfig = (IHostConfig) ZeusTransformUtils.wrapperContextForParams(r3, IHostConfig.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse intercept(Interceptor.Chain r7) {
        Interceptor.Chain r8 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r7, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Request r0 = r8.request();
        ArrayList r2 = new ArrayList(r0.getHeaders());
        String r3 = r0.getUrl();
        if (this.mConfig.allow(r3) == false) goto L22;
        Map<String, String> r6 = DTraitApi.getDTrait(r0.getPath(), this.mConfig.getRiskType(), this.mConfig.getTimeout());
        if (r6 == null) goto L20;
        if (r6.isEmpty() == true) goto L20;
        Iterator<Map.Entry<String, String>> r9 = r6.entrySet().iterator();
    L10:
        if (r9.hasNext() == false) goto L20;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L10;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r5) == true) goto L10;
        if (TextUtils.isEmpty(r10) == true) goto L10;
        r2.add(new Header(r5, r10));
    L20:
        return r8.proceed(r0.newBuilder().headers(r2).build());
    L22:
        return r8.proceed(r0);
    }
}
