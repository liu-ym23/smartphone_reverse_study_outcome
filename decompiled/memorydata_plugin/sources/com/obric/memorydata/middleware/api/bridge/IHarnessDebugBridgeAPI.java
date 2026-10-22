package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.obric.aikernel.sdk.ext.Params;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/IHarnessDebugBridgeAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "saveTrace", "", "data", "", "getLLMMock", Params.PROMPT, "collectLog", "prepareCase", "", "saveCaseInput", "saveCaseResult", "saveBridgeCall", "saveLLMCall", "saveEvent", "getBridgeReplay", "getLLMReplay", "getEventReplay", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IHarnessDebugBridgeAPI extends IService {
    void collectLog(String r1);

    String getBridgeReplay(String r1);

    String getEventReplay(String r1);

    String getLLMMock(String r1);

    String getLLMReplay(String r1);

    boolean prepareCase(String r1);

    boolean saveBridgeCall(String r1);

    boolean saveCaseInput(String r1);

    boolean saveCaseResult(String r1);

    boolean saveEvent(String r1);

    boolean saveLLMCall(String r1);

    void saveTrace(String r1);
}
