package com.bytedance.bdlocation.network;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ICustomNetworkApi {
    SsResponse<String> doPost(String r8, String r10, Map<String, String> r11, Map<String, String> r12, List<Header> r13, boolean r14);

    String doPostJson(String r8, String r10, Map<String, String> r11, TypedOutput r12, List<Header> r13, boolean r14);
}
