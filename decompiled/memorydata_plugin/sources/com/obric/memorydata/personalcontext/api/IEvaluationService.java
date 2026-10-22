package com.obric.memorydata.personalcontext.api;

import com.bytedance.news.common.service.manager.IService;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\r\u001a\u00020\u000bH&J\u0016\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&J\b\u0010\u0012\u001a\u00020\u0005H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u000bH&¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/IEvaluationService;", "Lcom/bytedance/news/common/service/manager/IService;", "getSearchControlParams", "", "handleIndexEntity", "", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isAutoEvaluationMode", "isCqcEvaluationMode", "setChangeEntityRule", "", "ruleString", "initFlavor", "importEvaluateData", "shortEntity", "", "", "isFreezeIndexTask", "getFreezeIndexTaskFreezeTime", "", "sleepUntilFreezeIndexTaskEnd", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IEvaluationService extends IService {
    long getFreezeIndexTaskFreezeTime();

    String getSearchControlParams();

    boolean handleIndexEntity(AppEntity r1);

    void importEvaluateData(List<? extends Object> r1);

    void initFlavor();

    boolean isAutoEvaluationMode();

    boolean isCqcEvaluationMode();

    boolean isFreezeIndexTask();

    void setChangeEntityRule(String r1);

    void sleepUntilFreezeIndexTaskEnd();
}
