package com.obric.memorydata.personalcontext.api;

import com.bytedance.news.common.service.manager.IService;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/IEntitySearchHelper;", "Lcom/bytedance/news/common/service/manager/IService;", "search", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "searchType", "", "quResult", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IEntitySearchHelper extends IService {
    Object search(String r1, String r2, Continuation<? super List<? extends AppEntity>> r3);
}
