package com.obric.memorydata.middleware.api.phoneassistant;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/api/phoneassistant/IPhoneAssistantHelper;", "Lcom/bytedance/news/common/service/manager/IService;", "addAssistantExitListener", "", "listener", "Lkotlin/Function0;", "removeAssistantExitListener", "addAssistantInvokeListener", "removeAssistantInvokeListener", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IPhoneAssistantHelper extends IService {
    void addAssistantExitListener(Function0<Unit> r1);

    void addAssistantInvokeListener(Function0<Unit> r1);

    void removeAssistantExitListener(Function0<Unit> r1);

    void removeAssistantInvokeListener(Function0<Unit> r1);
}
