package com.obric.flow.cardlistpage.domain.usecase;

import com.obric.flow.cardlistpage.base.BaseCardModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/obric/flow/cardlistpage/base/BaseCardModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.domain.usecase.CheckWidgetProvidersUseCase$invoke$2", f = "CheckWidgetProvidersUseCase.kt", i = {0, 0, 0, 1, 1, 2}, l = {39, 44, 45}, m = "invokeSuspend", n = {"result", "card", "validator", "result", "card", "result"}, s = {"L$0", "L$4", "L$5", "L$0", "L$4", "L$0"})
@SourceDebugExtension({"SMAP\nCheckWidgetProvidersUseCase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckWidgetProvidersUseCase.kt\ncom/obric/flow/cardlistpage/domain/usecase/CheckWidgetProvidersUseCase$invoke$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,126:1\n1863#2:127\n295#2,2:128\n1864#2:130\n*S KotlinDebug\n*F\n+ 1 CheckWidgetProvidersUseCase.kt\ncom/obric/flow/cardlistpage/domain/usecase/CheckWidgetProvidersUseCase$invoke$2\n*L\n37#1:127\n38#1:128,2\n37#1:130\n*E\n"})
final class CheckWidgetProvidersUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<BaseCardModel>>, Object> {
    final /* synthetic */ List<BaseCardModel> $currentCards;
    final /* synthetic */ com.obric.flow.cardlistpage.domain.repository.a $repository;
    final /* synthetic */ List<g> $validators;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CheckWidgetProvidersUseCase$invoke$2(List<? extends BaseCardModel> r5, List<? extends g> r10, com.obric.flow.cardlistpage.domain.repository.a r11, Continuation<? super CheckWidgetProvidersUseCase$invoke$2> r12) {
        this.$currentCards = r5;
        this.$validators = r10;
        this.$repository = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new CheckWidgetProvidersUseCase$invoke$2(this.$currentCards, this.$validators, this.$repository, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super List<BaseCardModel>> r10) {
        return invoke2(r5, r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0102 -> B:40:0x0107). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L12;
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L10;
        if (r10 != 3) goto L9;
        Iterator r11 = (Iterator) this.L$3;
        com.obric.flow.cardlistpage.domain.repository.a r12 = (com.obric.flow.cardlistpage.domain.repository.a) this.L$2;
        List<g> r13 = (List) this.L$1;
        List r14 = (List) this.L$0;
        ResultKt.throwOnFailure(r15);
    L40:
        com.obric.flow.cardlistpage.domain.repository.a r16 = r12;
        List<g> r17 = r13;
        List r18 = r14;
    L13:
        Iterator r19 = r11;
    L15:
        if (r19.hasNext() == false) goto L42;
        BaseCardModel r20 = (BaseCardModel) r19.next();
        Iterator<T> r21 = r17.iterator();
    L18:
        if (r21.hasNext() == false) goto L22;
        Object r22 = r21.next();
        if (((g) r22).a(r20) == false) goto L18;
    L23:
        g r23 = (g) r22;
        if (r23 == null) goto L41;
        r18.add(r20);
        goto L15
    L25:
        this.L$0 = r18;
        this.L$1 = r17;
        this.L$2 = r16;
        this.L$3 = r19;
        this.L$4 = r20;
        this.L$5 = r23;
        this.label = 1;
        Object r24 = r23.b(r20, this);
        if (r24 != r5) goto L28;
        return r5;
    L28:
        Iterator r110 = r19;
        com.obric.flow.cardlistpage.domain.repository.a r25 = r16;
        r15 = r24;
        Iterator r26 = r110;
        BaseCardModel r27 = r20;
        g r28 = r23;
    L30:
        if (((Boolean) r15).booleanValue() == true) goto L32;
        r16 = r25;
        r19 = r26;
    L41:
        r18.add(r27);
        goto L15
    L32:
        this.L$0 = r18;
        this.L$1 = r17;
        this.L$2 = r25;
        this.L$3 = r26;
        this.L$4 = r27;
        this.L$5 = null;
        this.label = 2;
        if (r28.c(r27) != r5) goto L35;
        return r5;
    L35:
        BaseCardModel r29 = r27;
        Iterator r30 = r26;
        List<g> r31 = r17;
        List r32 = r18;
    L36:
        String r111 = r29.getId();
        this.L$0 = r32;
        this.L$1 = r31;
        this.L$2 = r25;
        this.L$3 = r30;
        this.L$4 = null;
        this.label = 3;
        com.obric.flow.cardlistpage.domain.repository.b r33 = (com.obric.flow.cardlistpage.domain.repository.b) r25;
        if (r33.e(r111, this) != r5) goto L39;
        return r5;
    L39:
        r13 = r31;
        r14 = r32;
        Iterator r112 = r30;
        r12 = r33;
        r11 = r112;
        goto L40
    L22:
        r22 = null;
        goto L23
    L42:
        return r18;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r29 = (BaseCardModel) this.L$4;
        r30 = (Iterator) this.L$3;
        r25 = (com.obric.flow.cardlistpage.domain.repository.a) this.L$2;
        r31 = (List) this.L$1;
        r32 = (List) this.L$0;
        ResultKt.throwOnFailure(r15);
        goto L36
    L11:
        r28 = (g) this.L$5;
        r27 = (BaseCardModel) this.L$4;
        Iterator r34 = (Iterator) this.L$3;
        com.obric.flow.cardlistpage.domain.repository.a r35 = (com.obric.flow.cardlistpage.domain.repository.a) this.L$2;
        r17 = (List) this.L$1;
        r18 = (List) this.L$0;
        ResultKt.throwOnFailure(r15);
        r26 = r34;
        r25 = r35;
        goto L30
    L12:
        ResultKt.throwOnFailure(r15);
        ArrayList r113 = new ArrayList();
        List<BaseCardModel> r36 = this.$currentCards;
        List<g> r37 = this.$validators;
        com.obric.flow.cardlistpage.domain.repository.a r38 = this.$repository;
        r11 = r36.iterator();
        r18 = r113;
        r17 = r37;
        r16 = r38;
        goto L13
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super List<BaseCardModel>> r10) {
        return ((CheckWidgetProvidersUseCase$invoke$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
