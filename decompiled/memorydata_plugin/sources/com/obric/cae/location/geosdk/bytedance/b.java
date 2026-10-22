package com.obric.cae.location.geosdk.bytedance;

import com.bytedance.bdlocation.network.ICustomNetworkApi;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ICustomNetworkApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f7161a;

    public b(a r1) {
        this.f7161a = r1;
    }

    @Override // com.bytedance.bdlocation.network.ICustomNetworkApi
    public final SsResponse<String> doPost(String r8, String r9, Map<String, String> r10, Map<String, String> r11, List<Header> r12, boolean r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L31;
    L20:
        String r0 = r8;
    L21:
        if (r14 != null) goto L23;
        r14 = new HashMap();     // Catch: Exception -> L18
    L23:
        r14.put("device_id", MatrixDidUtils.getDid());     // Catch: Exception -> L18
        r14.put("aid", "941134");     // Catch: Exception -> L18
        r14.put("channel", "cae_release");     // Catch: Exception -> L18
        r14.put("device_platform", "android");     // Catch: Exception -> L18
        if (r16 != null) goto L26;
        ArrayList r17 = new ArrayList();     // Catch: Exception -> L18
    L27:
        com.obric.cae.log.a.d("StarLocation-BdLM", "doPost: baseUrl=" + r8 + ", relativePath=" + r9 + "\n, queryMap=" + r14 + "\n, fieldMap=" + r15 + "\n, headerList=" + r17 + "\n, addCommonPara=" + r13);     // Catch: Exception -> L18
        SsResponse<String> r7 = a.a(this.f7161a, r0, r14, r15, r17);     // Catch: Exception -> L18
        com.obric.cae.log.a.d("StarLocation-BdLM", "doHttpPostForm response=" + ((String) ZeusTransformUtils.preCheckCast(r7.body(), String.class, "com.obric.memorydata.plugin")));     // Catch: Exception -> L18
        return r7;
    L18:
        e = move-exception;
        com.obric.cae.log.a.j("StarLocation-BdLM", "doPost exception: " + e.toString());
        e.printStackTrace();
        return null;
    L26:
        r17 = new ArrayList(r16);     // Catch: Exception -> L18
        goto L27
    L31:
        if (r9.isEmpty() == true) goto L20;
        if (r8.endsWith("/") == false) goto L13;
        if (r9.startsWith("/") == false) goto L13;
        StringBuilder r1 = new StringBuilder().append(r8).append(r9.substring(1));     // Catch: Exception -> L18
    L11:
        r0 = r1.toString();     // Catch: Exception -> L18
    L13:
        if (r8.endsWith("/") == false) goto L15;
    L17:
        r0 = r8.concat(r9);     // Catch: Exception -> L18
        goto L21
    L15:
        if (r9.startsWith("/") == true) goto L17;
        r1 = new StringBuilder().append(r8).append("/").append(r9);     // Catch: Exception -> L18
        goto L11
    }

    @Override // com.bytedance.bdlocation.network.ICustomNetworkApi
    public final String doPostJson(String r2, String r3, Map<String, String> r4, TypedOutput r5, List<Header> r6, boolean r7) {
        com.obric.cae.log.a.d("StarLocation-BdLM", "doPostJson: baseUrl=" + r2 + ", relativePath=" + r3 + ", queryMap=" + ((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")) + ", fieldMap=" + ((TypedOutput) ZeusTransformUtils.wrapperContextForParams(r5, TypedOutput.class, "com.obric.memorydata.plugin")) + ", headerList=" + ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")) + ", addCommonPara=" + r7);
        return "";
    }
}
