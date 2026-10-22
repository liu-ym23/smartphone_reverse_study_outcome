package com.obric.memorydata.personalcontext.api;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0016\u0010\u0010\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/EmptyEvaluationService;", "Lcom/obric/memorydata/personalcontext/api/IEvaluationService;", "<init>", "()V", "getSearchControlParams", "", "handleIndexEntity", "", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isAutoEvaluationMode", "isCqcEvaluationMode", "setChangeEntityRule", "", "ruleString", "initFlavor", "importEvaluateData", "shortEntity", "", "", "isFreezeIndexTask", "getFreezeIndexTaskFreezeTime", "", "sleepUntilFreezeIndexTaskEnd", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EmptyEvaluationService implements IEvaluationService {
    public static final EmptyEvaluationService INSTANCE = null;

    static {
        INSTANCE = new EmptyEvaluationService();
    }

    private EmptyEvaluationService() {
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public long getFreezeIndexTaskFreezeTime() {
        return 0;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public String getSearchControlParams() {
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public boolean handleIndexEntity(AppEntity r1) {
        Intrinsics.checkNotNullParameter(r1, "appEntity");
        return false;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public void importEvaluateData(List<? extends Object> r2) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), "shortEntity");
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public void initFlavor() {
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public boolean isAutoEvaluationMode() {
        return false;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public boolean isCqcEvaluationMode() {
        return false;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public boolean isFreezeIndexTask() {
        return false;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public void setChangeEntityRule(String r1) {
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public void sleepUntilFreezeIndexTaskEnd() {
    }
}
