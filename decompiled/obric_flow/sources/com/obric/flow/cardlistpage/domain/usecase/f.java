package com.obric.flow.cardlistpage.domain.usecase;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.obric.flow.cardlistpage.domain.repository.b f11525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fq.a f11526b;

    public f(com.obric.flow.cardlistpage.domain.repository.b r5, fq.a r10) {
        this.f11525a = r5;
        this.f11526b = r10;
    }

    public static Object a(f r5, String r10, int r11, ContinuationImpl r12) {
        if ((r12 instanceof RemoveCardUseCase$invoke$2) == false) goto L7;
        RemoveCardUseCase$invoke$2 r13 = (RemoveCardUseCase$invoke$2) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        r11 = r13.I$0;
        r5 = (f) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L19:
        fq.a r18 = r5.f11526b;
        if (r18 == null) goto L23;
        r18.f16974b.deleteAppWidgetId(r11);
    L23:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        com.obric.flow.cardlistpage.domain.repository.b r19 = r5.f11525a;
        if (r19 == null) goto L19;
        r13.L$0 = r5;
        r13.I$0 = r11;
        r13.label = 1;
        if (r19.e(r10, r13) != r16) goto L19;
        return r16;
    L7:
        r13 = new RemoveCardUseCase$invoke$2(r5, r12);
        goto L8
    }
}
