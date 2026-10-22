package com.bytedance.badger.collect.impl.network.impl;

import android.net.Network;
import com.bytedance.badger.collect.impl.constants.NetworkMethodEnum;
import com.bytedance.badger.collect.impl.model.TTRequest;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.network.interfaces.IChainHandler;
import com.bytedance.badger.collect.impl.network.interfaces.INetWorkService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class NetworkServiceImpl implements INetWorkService {
    private final List<IChainHandler> handlers;

    private Map<String, String> buildCommonHeader() {
        HashMap r0 = new HashMap();
        r0.put("Content-Type", "application/json; charset=utf-8");
        return r0;
    }

    public NetworkServiceImpl() {
        ArrayList r0 = new ArrayList();
        this.handlers = r0;
        r0.add(new RequestBuildHandler());
        r0.add(new RequestExecutorHandler());
    }

    private TTResponse execute(TTRequest r4) {
        return new ChainImpl(this.handlers, 0, r4).process(r4);
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.INetWorkService
    public TTResponse fetchMobilePseudoCodeSign(String r9, Map<String, String> r10, NetworkMethodEnum r12, Map<String, String> r13) throws Exception {
        return execute(new TTRequest(true, r9, r12, buildCommonHeader(), r10, r13));
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.INetWorkService
    public TTResponse fetchMobilePseudoCodeToken(Network r17, String r18, Map<String, String> r19, NetworkMethodEnum r20, Map<String, String> r22) throws Exception {
        if (r17 == null) goto L4;
        TTRequest r8 = new TTRequest(r18, true, r17, r20, buildCommonHeader(), r19, r22);
    L6:
        return execute(r8);
    L4:
        r8 = new TTRequest(true, r18, r20, buildCommonHeader(), r19, r22);
        goto L6
    }
}
