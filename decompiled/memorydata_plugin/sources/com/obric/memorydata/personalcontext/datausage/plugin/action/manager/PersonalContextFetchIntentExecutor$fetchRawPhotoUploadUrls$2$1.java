package com.obric.memorydata.personalcontext.datausage.plugin.action.manager;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.entity.hb;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.datausage.plugin.action.manager.PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1", f = "PersonalContextFetchIntentExecutor.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
final class PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends String>>, Object> {
    final /* synthetic */ List<AppEntity> $chunk;
    final /* synthetic */ Map<String, hb> $rawPhotoByEntityId;
    private /* synthetic */ Object L$0;
    int label;

    PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1(List<? extends AppEntity> r3, Map<String, hb> r4, Continuation<? super PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1> r5) {
        List<AppEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Map<String, hb> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$chunk = r6;
        this.$rawPhotoByEntityId = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1 r0 = new PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1(this.$chunk, this.$rawPhotoByEntityId, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends String>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super List<String>> r4) {
        return ((PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L15:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        al r14 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.$chunk, Iterable.class, "com.obric.memorydata.plugin");
        Map<String, hb> r10 = this.$rawPhotoByEntityId;
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        r11.add(kotlinx.coroutines.i.b(r14, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1$1$1(r10, (AppEntity) ZeusTransformUtils.preCheckCast(r3.next(), AppEntity.class, "com.obric.memorydata.plugin"), null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
        goto L10
    L12:
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r13 = kotlinx.coroutines.f.a(r15, r4);
        if (r13 != r0) goto L15;
        return r0;
    }
}
