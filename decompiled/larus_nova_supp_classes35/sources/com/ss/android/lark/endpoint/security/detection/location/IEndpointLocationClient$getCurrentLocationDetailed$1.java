package com.ss.android.lark.endpoint.security.detection.location;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.location.dto.LarkLocation;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.endpoint.security.detection.location.IEndpointLocationClient$DefaultImpls", f = "IEndpointLocationClient.kt", i = {}, l = {MediaContent.COMPRESS_PROGRESS_PROPORTION}, m = "getCurrentLocationDetailed-IoAF18A", n = {}, s = {})
final class IEndpointLocationClient$getCurrentLocationDetailed$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public IEndpointLocationClient$getCurrentLocationDetailed$1(Continuation<? super IEndpointLocationClient$getCurrentLocationDetailed$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        int r5 = this.label | PluginList.LEVEL_NOT_SET;
        this.label = r5;
        if ((r5 & PluginList.LEVEL_NOT_SET) == 0) goto L5;
        this.label = r5 - PluginList.LEVEL_NOT_SET;
        IEndpointLocationClient$getCurrentLocationDetailed$1 r6 = this;
    L6:
        Object r0 = r6.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r6.label;
        if (r1 == 0) goto L20;
        if (r1 != 1) goto L19;
        ResultKt.throwOnFailure(r0);
        LarkLocation r2 = (LarkLocation) r0;
        if (r2 == null) goto L12;
        Object r7 = Result.constructor-impl(r2);
    L14:
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r7;
    L17:
        return Result.box-impl(r7);
    L12:
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(EndpointLocationFetchError.Unknown.INSTANCE));
        goto L14
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r0);
        r6.label = 1;
        throw null;
    L5:
        r6 = new IEndpointLocationClient$getCurrentLocationDetailed$1(this);
        goto L6
    }
}
