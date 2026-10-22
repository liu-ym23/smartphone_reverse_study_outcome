package com.obric.memorydata.debug;

import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.capabilitykit.entity.search.InAppSearchResult;
import com.obric.capabilitykit.search.IAppSearchCallback;
import com.obric.memorydata.personalcontext.search.entity.SearchRequest;
import com.obric.memorydata.personalcontext.search.entity.SearchType;
import com.obric.memorydata.personalcontext.search.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.debug.ReleaseAdbService$sendAppSearchRequest$1", f = "ReleaseAdbService.kt", i = {}, l = {1240}, m = "invokeSuspend", n = {}, s = {})
final class ReleaseAdbService$sendAppSearchRequest$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appPackage;
    final /* synthetic */ CountDownLatch $countDownLatch;
    final /* synthetic */ List<String> $errorString;
    final /* synthetic */ Boolean $isUseRanking;
    final /* synthetic */ String $query;
    final /* synthetic */ List<InAppSearchResult> $resultArray;
    int label;

    ReleaseAdbService$sendAppSearchRequest$1(Boolean r3, String r4, String r5, CountDownLatch r6, List<String> r7, List<InAppSearchResult> r8, Continuation<? super ReleaseAdbService$sendAppSearchRequest$1> r9) {
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List<InAppSearchResult> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$isUseRanking = r3;
        this.$query = r4;
        this.$appPackage = r5;
        this.$countDownLatch = r6;
        this.$errorString = r10;
        this.$resultArray = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ReleaseAdbService$sendAppSearchRequest$1(this.$isUseRanking, this.$query, this.$appPackage, this.$countDownLatch, this.$errorString, this.$resultArray, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ReleaseAdbService$sendAppSearchRequest$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ReleaseAdbService$sendAppSearchRequest$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        CopyOnWriteArrayList r3 = new CopyOnWriteArrayList();
        g r2 = g.INSTANCE;
        SearchType r15 = SearchType.IN_APP;
        Boolean r4 = this.$isUseRanking;
        if (r4 == null) goto L11;
        boolean r9 = r4.booleanValue();
    L12:
        InAppSearchRequest r5 = new InAppSearchRequest(this.$query, 5000000, false, r9, 0, 20, null);
        r5.setPackageName(this.$appPackage);
        Unit r6 = Unit.INSTANCE;
        SearchRequest r7 = new SearchRequest(r15, r5, this.$appPackage);
        final CountDownLatch r8 = this.$countDownLatch;
        final List<String> r10 = this.$errorString;
        final List<InAppSearchResult> r11 = this.$resultArray;
        final String r12 = this.$appPackage;
        IAppSearchCallback r13 = (IAppSearchCallback) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r8, r10, r11, r12), IAppSearchCallback.class, "com.obric.memorydata.plugin");
        Continuation r16 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (g.sendInAppSearchRequest$default(r2, r7, r3, r13, null, null, null, null, r16, 120, null) != r0) goto L16;
        return r0;
    L11:
        r9 = true;
        goto L12
    }
}
