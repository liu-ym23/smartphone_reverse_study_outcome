package com.obric.memorydata.personalcontext.datausage.plugin.action.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.datausage.plugin.action.manager.PersonalContextFetchIntentExecutor", f = "PersonalContextFetchIntentExecutor.kt", i = {0, 0}, l = {88}, m = "fetchRawPhotoUploadUrls", n = {"rawPhotoByEntityId", "destination$iv$iv"}, s = {"L$0", "L$1"})
final class PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ h this$0;

    PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$1(h r3, Continuation<? super PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return h.a(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
