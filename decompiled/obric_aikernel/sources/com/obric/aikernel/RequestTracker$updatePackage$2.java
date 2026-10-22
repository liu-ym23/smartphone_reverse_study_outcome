package com.obric.aikernel;

import android.os.Bundle;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.RequestTracker$updatePackage$2", f = "RequestTracker.kt", i = {0}, l = {74}, m = "invokeSuspend", n = {"destination$iv$iv"}, s = {"L$2"})
final class RequestTracker$updatePackage$2 extends SuspendLambda implements Function1<Continuation<? super com.obric.aikernel.request.b>, Object> {
    final /* synthetic */ List<String> $bizs;
    final /* synthetic */ b $callback;
    final /* synthetic */ RequestParams $params;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ RequestTracker this$0;

    RequestTracker$updatePackage$2(List<String> r10, RequestTracker r11, RequestParams r12, b r13, Continuation<? super RequestTracker$updatePackage$2> r14) {
        this.$bizs = r10;
        this.this$0 = r11;
        this.$params = r12;
        this.$callback = r13;
        super(1, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        return new RequestTracker$updatePackage$2(this.$bizs, this.this$0, this.$params, this.$callback, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super com.obric.aikernel.request.b> r10) {
        return invoke2(r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super com.obric.aikernel.request.b> r10) {
        return ((RequestTracker$updatePackage$2) create(r10)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0066 -> B:15:0x0067). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        Collection r13 = (Collection) this.L$4;
        Iterator r14 = (Iterator) this.L$3;
        Collection r15 = (Collection) this.L$2;
        RequestParams r16 = (RequestParams) this.L$1;
        RequestTracker r17 = (RequestTracker) this.L$0;
        ResultKt.throwOnFailure(r10);
    L15:
        r13.add((PackageResource) r10);
        r13 = r15;
    L10:
        if (r14.hasNext() == false) goto L16;
        String r18 = (String) r14.next();
        this.L$0 = r17;
        this.L$1 = r16;
        this.L$2 = r13;
        this.L$3 = r14;
        this.L$4 = r13;
        this.label = 1;
        r10 = r17.b(r18, r16, this);
        if (r10 != r11) goto L14;
        return r11;
    L14:
        r15 = r13;
        goto L15
    L16:
        final List r19 = (List) r13;
        Bundle r20 = e8.a.G(new Bundle(), 0, new AnonymousClass1(r19), 1, null);
        e8.a.r(this.$callback, r20);
        return new com.obric.aikernel.request.b(true, r20);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        List<String> r21 = this.$bizs;
        RequestTracker r22 = this.this$0;
        RequestParams r23 = this.$params;
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        r17 = r22;
        r16 = r23;
        r13 = r24;
        r14 = r21.iterator();
        goto L10
    }
}
