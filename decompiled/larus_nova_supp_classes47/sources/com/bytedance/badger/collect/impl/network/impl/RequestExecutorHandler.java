package com.bytedance.badger.collect.impl.network.impl;

import com.bytedance.badger.collect.impl.api.BadgerCollectApi;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.constants.ErrorPair;
import com.bytedance.badger.collect.impl.constants.NetworkMethodEnum;
import com.bytedance.badger.collect.impl.interfaces.INetworkApi;
import com.bytedance.badger.collect.impl.interfaces.IOperatorNetworkApi;
import com.bytedance.badger.collect.impl.model.TTRequest;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.network.interfaces.IChainHandler;
import com.bytedance.badger.collect.impl.utils.CommonUtils;
import com.bytedance.badger.collect.impl.utils.KLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class RequestExecutorHandler implements IChainHandler {

    /* JADX INFO: renamed from: com.bytedance.badger.collect.impl.network.impl.RequestExecutorHandler$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$badger$collect$impl$constants$NetworkMethodEnum = null;

        static {
            int[] r0 = new int[NetworkMethodEnum.values().length];
            $SwitchMap$com$bytedance$badger$collect$impl$constants$NetworkMethodEnum = r0;
            r0[NetworkMethodEnum.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$badger$collect$impl$constants$NetworkMethodEnum[NetworkMethodEnum.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public RequestExecutorHandler() {
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public final /* synthetic */ long getRetryDelay(int r3) {
        return IChainHandler.CC.$default$getRetryDelay(this, r3);
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public final /* synthetic */ boolean shouldRetry(TTResponse r1, int r2) {
        return IChainHandler.CC.$default$shouldRetry(this, r1, r2);
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public TTResponse handle(IChainHandler.IChain r4) {
        TTRequest r5 = r4.getRequest();
        TTResponse r6 = executeNetworkRequest(r5, r5.getBaseUrl());     // Catch: Exception -> L5
    L7:
        if (r6 != null) goto L10;
        r6 = TTResponse.failed();
    L10:
        if (r6.getHeaders() == null) goto L15;
        if (r6.getHeaders().containsKey(Constants.Keys.KEY_X_TT_LOGID) == false) goto L15;
        r6.setLogId(r6.getHeaders().get(Constants.Keys.KEY_X_TT_LOGID));
    L15:
        if (KLog.isDebug() == false) goto L17;
        KLog.d(Constants.TAGS.NETWORK, "RequestExecutorHandler# receive response --- " + r6);
    L17:
        return r6;
    L5:
        e = move-exception;
        TTResponse r1 = TTResponse.failed(e);
        KLog.e(Constants.TAGS.NETWORK, e);
        r6 = r1;
        goto L7
    }

    private TTResponse executeNetworkRequest(TTRequest r6, String r7) throws Exception {
        INetworkApi r0 = BadgerCollectApi.getNetworkApi();
        IOperatorNetworkApi r1 = BadgerCollectApi.getOperatorNetworkApi();
        if (r0 == null) goto L30;
        if (r1 == null) goto L30;
        if (r6.isEnableOperator() == true) goto L9;
        int r2 = AnonymousClass1.$SwitchMap$com$bytedance$badger$collect$impl$constants$NetworkMethodEnum[r6.getMethod().ordinal()];
        if (r2 == 1) goto L28;
        if (r2 == 2) goto L26;
        return TTResponse.failed();
    L26:
        return r0.post(r7, r6.getHeaders(), r6.getBodyMap());
    L28:
        return r0.get(r7, r6.getHeaders());
    L9:
        if (KLog.isDebug() == false) goto L11;
        KLog.d(Constants.TAGS.NETWORK, "RequestExecutorHandler# operator type request... ");
    L11:
        int r3 = AnonymousClass1.$SwitchMap$com$bytedance$badger$collect$impl$constants$NetworkMethodEnum[r6.getMethod().ordinal()];
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L15;
        byte[] r4 = CommonUtils.map2QueryString(r6.getBodyMap()).getBytes("UTF-8");
        return r1.post(r6.getNetwork(), r7, r6.getHeaders(), r4);
    L15:
        return TTResponse.failed();
    L19:
        return r1.get(r6.getNetwork(), r7, r6.getHeaders());
    L30:
        return TTResponse.failed(ErrorPair.ERROR_NET_NOT_IMPL);
    }
}
