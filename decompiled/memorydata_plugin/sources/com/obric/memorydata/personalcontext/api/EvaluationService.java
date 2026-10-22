package com.obric.memorydata.personalcontext.api;

import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0017\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0096\u0001J\t\u0010\u0011\u001a\u00020\rH\u0096\u0001J\t\u0010\u0012\u001a\u00020\tH\u0096\u0001J\t\u0010\u0013\u001a\u00020\tH\u0096\u0001J\t\u0010\u0014\u001a\u00020\tH\u0096\u0001J\u0013\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\u0017\u001a\u00020\rH\u0096\u0001¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/EvaluationService;", "Lcom/obric/memorydata/personalcontext/api/IEvaluationService;", "<init>", "()V", "getFreezeIndexTaskFreezeTime", "", "getSearchControlParams", "", "handleIndexEntity", "", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "importEvaluateData", "", "shortEntity", "", "", "initFlavor", "isAutoEvaluationMode", "isCqcEvaluationMode", "isFreezeIndexTask", "setChangeEntityRule", "ruleString", "sleepUntilFreezeIndexTaskEnd", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EvaluationService implements IEvaluationService {
    public static final EvaluationService INSTANCE = null;
    private final /* synthetic */ IEvaluationService $$delegate_0;

    static {
        INSTANCE = new EvaluationService();
    }

    private EvaluationService() {
        IEvaluationService r0 = (IEvaluationService) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IEvaluationService.class)), IEvaluationService.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = (IEvaluationService) ZeusTransformUtils.preCheckCast(EmptyEvaluationService.INSTANCE, IEvaluationService.class, "com.obric.memorydata.plugin");
    L5:
        this.$$delegate_0 = r0;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public long getFreezeIndexTaskFreezeTime() {
        return this.$$delegate_0.getFreezeIndexTaskFreezeTime();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public String getSearchControlParams() {
        return this.$$delegate_0.getSearchControlParams();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public boolean handleIndexEntity(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "appEntity");
        return this.$$delegate_0.handleIndexEntity(r2);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public void importEvaluateData(List<? extends Object> r3) {
        List<? extends Object> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "shortEntity");
        this.$$delegate_0.importEvaluateData(r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public void initFlavor() {
        this.$$delegate_0.initFlavor();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public boolean isAutoEvaluationMode() {
        return this.$$delegate_0.isAutoEvaluationMode();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public boolean isCqcEvaluationMode() {
        return this.$$delegate_0.isCqcEvaluationMode();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public boolean isFreezeIndexTask() {
        return this.$$delegate_0.isFreezeIndexTask();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public void setChangeEntityRule(String r1) {
        this.$$delegate_0.setChangeEntityRule(r1);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEvaluationService
    public void sleepUntilFreezeIndexTaskEnd() {
        this.$$delegate_0.sleepUntilFreezeIndexTaskEnd();
    }
}
