package com.bytedance.bdinstall;

import android.util.Pair;
import com.bytedance.bdinstall.network.TTResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DefaultClient implements INetworkClient {
    private final DefaultClientWrapper defaultTicketClient;

    public DefaultClient() {
        this.defaultTicketClient = new DefaultClientWrapper();
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String get(String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        TTResponse r2 = this.defaultTicketClient.get(r3, r5);
        if (r2 != null) goto L5;
        return "";
    L5:
        return r2.getBody();
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r3, List<Pair<String, String>> r4) {
        List<Pair<String, String>> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        TTResponse r2 = this.defaultTicketClient.post(r3, r5);
        if (r2 != null) goto L5;
        return "";
    L5:
        return r2.getBody();
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r1, byte[] r2, String r3) {
        TTResponse r0 = this.defaultTicketClient.post(r1, r2, r3);
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.getBody();
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r3, byte[] r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        TTResponse r2 = this.defaultTicketClient.post(r3, r4, r6);
        if (r2 != null) goto L5;
        return "";
    L5:
        return r2.getBody();
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public byte[] postStream(String r3, byte[] r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        return this.defaultTicketClient.postStream(r3, r4, r6);
    }
}
