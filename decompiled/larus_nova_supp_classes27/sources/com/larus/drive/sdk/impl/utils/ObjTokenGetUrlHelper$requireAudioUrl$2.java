package com.larus.drive.sdk.impl.utils;

import com.larus.bmhome.rc.GetVideoModelParam;
import com.larus.bmhome.rc.GetVideoModelRequest;
import com.larus.bmhome.rc.GetVideoModelResults;
import com.larus.bmhome.rc.ResourceApi;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/rc/GetVideoModelResults;", "Lcom/larus/bmhome/rc/ResourceApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.ObjTokenGetUrlHelper$requireAudioUrl$2", f = "ObjTokenGetUrlHelper.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
public final class ObjTokenGetUrlHelper$requireAudioUrl$2 extends SuspendLambda implements Function2<ResourceApi, Continuation<? super BizResponse<GetVideoModelResults>>, Object> {
    final /* synthetic */ String $objToken;
    private /* synthetic */ Object L$0;
    int label;

    public ObjTokenGetUrlHelper$requireAudioUrl$2(String r1, Continuation<? super ObjTokenGetUrlHelper$requireAudioUrl$2> r2) {
        this.$objToken = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ObjTokenGetUrlHelper$requireAudioUrl$2 r0 = new ObjTokenGetUrlHelper$requireAudioUrl$2(this.$objToken, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ResourceApi r1, Continuation<? super BizResponse<GetVideoModelResults>> r2) {
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
    L11:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        ResourceApi r9 = (ResourceApi) this.L$0;
        GetVideoModelRequest r2 = new GetVideoModelRequest(CollectionsKt.listOf(new GetVideoModelParam(this.$objToken, null, 2, null)));
        this.label = 1;
        r8 = r9.getVideoModel(r2, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
