package com.larus.bmhome.rc;

import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/bmhome/rc/ResourceApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.rc.ResourceCenter$deleteResource$2", f = "ResourceCenter.kt", i = {}, l = {350}, m = "invokeSuspend", n = {}, s = {})
public final class ResourceCenter$deleteResource$2 extends SuspendLambda implements Function2<ResourceApi, Continuation<? super BizResponse<String>>, Object> {
    final /* synthetic */ List<String> $resourceIds;
    private /* synthetic */ Object L$0;
    int label;

    public ResourceCenter$deleteResource$2(List<String> r1, Continuation<? super ResourceCenter$deleteResource$2> r2) {
        this.$resourceIds = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResourceCenter$deleteResource$2 r0 = new ResourceCenter$deleteResource$2(this.$resourceIds, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ResourceApi r1, Continuation<? super BizResponse<String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ResourceApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        ResourceApi r8 = (ResourceApi) this.L$0;
        ResourceDeleteRequest r2 = new ResourceDeleteRequest(ResourceCenter.b, this.$resourceIds);
        FLogger.a.i("ResourceCenter", "[deleteResource] request=" + r2);
        this.label = 1;
        r7 = r8.delete(r2, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
