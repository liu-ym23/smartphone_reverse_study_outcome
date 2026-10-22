package com.larus.bmhome.rc;

import com.google.gson.Gson;
import com.larus.network.bean.BizResponse;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0018\u00010\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "", "Lcom/larus/bmhome/rc/ResourceRegisterData;", "Lcom/larus/bmhome/rc/ResourceApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.rc.ResourceCenter$register$2", f = "ResourceCenter.kt", i = {}, l = {207}, m = "invokeSuspend", n = {}, s = {})
public final class ResourceCenter$register$2 extends SuspendLambda implements Function2<ResourceApi, Continuation<? super BizResponse<Map<String, ? extends ResourceRegisterData>>>, Object> {
    final /* synthetic */ ResourceAttachmentExtra $extra;
    final /* synthetic */ String $finalSceneId;
    final /* synthetic */ List<FlowResource> $resourceList;
    private /* synthetic */ Object L$0;
    int label;

    public ResourceCenter$register$2(String r1, List<FlowResource> r2, ResourceAttachmentExtra r3, Continuation<? super ResourceCenter$register$2> r4) {
        this.$finalSceneId = r1;
        this.$resourceList = r2;
        this.$extra = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ResourceCenter$register$2 r0 = new ResourceCenter$register$2(this.$finalSceneId, this.$resourceList, this.$extra, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(ResourceApi r1, Continuation<? super BizResponse<Map<String, ResourceRegisterData>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ResourceApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L14:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        ResourceApi r9 = (ResourceApi) this.L$0;
        String r3 = ResourceCenter.b;
        String r4 = this.$finalSceneId;
        List<FlowResource> r5 = this.$resourceList;
        Gson r6 = z.a;
        String r7 = z.c(this.$extra);
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        ResourceRegisterRequest r2 = new ResourceRegisterRequest(r3, r4, r5, r7);
        FLogger.a.i("ResourceCenter", "[register] request=" + r2);
        this.label = 1;
        r8 = r9.register(r2, this);
        if (r8 != r0) goto L14;
        return r0;
    }
}
