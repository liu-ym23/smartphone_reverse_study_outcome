package com.obric.flow.cardlistpage.domain.repository;

import com.obric.flow.cardlistpage.R$xml;
import com.obric.flow.cardlistpage.data.o;
import com.obric.flow.cardlistpage.data.r;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.d;
import td.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.domain.repository.CardFeedRepositoryImpl$checkFirstInstallOrUpgrade$2", f = "CardFeedRepositoryImpl.kt", i = {0, 1}, l = {66, 55}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
@SourceDebugExtension({"SMAP\nCardFeedRepositoryImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CardFeedRepositoryImpl.kt\ncom/obric/flow/cardlistpage/domain/repository/CardFeedRepositoryImpl$checkFirstInstallOrUpgrade$2\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,60:1\n116#2,11:61\n*S KotlinDebug\n*F\n+ 1 CardFeedRepositoryImpl.kt\ncom/obric/flow/cardlistpage/domain/repository/CardFeedRepositoryImpl$checkFirstInstallOrUpgrade$2\n*L\n52#1:61,11\n*E\n"})
final class CardFeedRepositoryImpl$checkFirstInstallOrUpgrade$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ b this$0;

    public CardFeedRepositoryImpl$checkFirstInstallOrUpgrade$2(b r5, Continuation<? super CardFeedRepositoryImpl$checkFirstInstallOrUpgrade$2> r10) {
        this.this$0 = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new CardFeedRepositoryImpl$checkFirstInstallOrUpgrade$2(this.this$0, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L14;
        if (r11 == 1) goto L13;
        if (r11 != 2) goto L12;
        kotlinx.coroutines.sync.a r12 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L9
        r12 = r12;
    L26:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L9
        ((d) r12).d(null);
        return Unit.INSTANCE;
    L9:
        Throwable th2 = th;
    L29:
        ((d) r12).d(null);
        throw th2;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        b r14 = (b) this.L$1;
        kotlinx.coroutines.sync.a r15 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.sync.a r16 = r15;
    L33:
    L23:
        th = move-exception;
        kotlinx.coroutines.sync.a r17 = r16;
        th2 = th;
        r12 = r17;
        goto L29
    L18:
        if (Intrinsics.areEqual(c.f(r14.f11511a), o.f11501b) == false) goto L25;
        r r18 = new r(r14.f11511a, r14.f11512b, r14.f11513c);     // Catch: Throwable -> L23
        int r19 = R$xml.default_minus_one_widgets;     // Catch: Throwable -> L23
        this.L$0 = r16;     // Catch: Throwable -> L23
        this.L$1 = null;     // Catch: Throwable -> L23
        this.label = 2;     // Catch: Throwable -> L23
        if (r18.a(r19, this) != r5) goto L25;
        return r5;
    L25:
        r12 = r16;
        goto L26
    L14:
        ResultKt.throwOnFailure(r10);
        d r20 = b.d;
        r14 = this.this$0;
        this.L$0 = r20;
        this.L$1 = r14;
        this.label = 1;
        Object r21 = r20.c(this);
        r16 = r20;
        if (r21 != r5) goto L33;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((CardFeedRepositoryImpl$checkFirstInstallOrUpgrade$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
