package com.obric.flow.cardlistpage.ui.component.feedlist;

import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.base.CardType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.obric.flow.cardlistpage.domain.usecase.e f11619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.flow.cardlistpage.domain.usecase.c f11620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mn.i f11621c;
    public final com.obric.flow.cardlistpage.domain.usecase.f d;
    public final com.obric.flow.cardlistpage.domain.usecase.a e;

    public u(com.obric.flow.cardlistpage.domain.usecase.e r5, com.obric.flow.cardlistpage.domain.usecase.c r10, mn.i r11, com.obric.flow.cardlistpage.domain.usecase.f r12, com.obric.flow.cardlistpage.domain.usecase.a r13) {
        Intrinsics.checkNotNullParameter(r5, "refreshFeedData");
        Intrinsics.checkNotNullParameter(r10, "checkWidgetProviders");
        Intrinsics.checkNotNullParameter(r11, "updateCard");
        Intrinsics.checkNotNullParameter(r12, "removeCard");
        Intrinsics.checkNotNullParameter(r13, "addCard");
        this.f11619a = r5;
        this.f11620b = r10;
        this.f11621c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final Object a(boolean r10, ArrayList r11, ContinuationImpl r12) {
        if ((r12 instanceof FeedListOwner$refreshCards$1) == false) goto L7;
        FeedListOwner$refreshCards$1 r5 = (FeedListOwner$refreshCards$1) r12;
        int r13 = r5.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r5.label;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        ResultKt.throwOnFailure(r14);
    L30:
        return (List) r14;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
    L29:
        return (List) r14;
    L16:
        ResultKt.throwOnFailure(r14);
        if (r10 == false) goto L19;
    L25:
        r5.label = 1;
        r14 = com.obric.flow.cardlistpage.domain.usecase.e.a(this.f11619a, r5);
        if (r14 != r15) goto L29;
        return r15;
    L19:
        if (r11.isEmpty() == true) goto L25;
        r5.label = 2;
        r14 = this.f11620b.a(r11, r5);
        if (r14 != r15) goto L30;
        return r15;
    L7:
        r5 = new FeedListOwner$refreshCards$1(this, r12);
        goto L8
    }

    public final Object b(List r5, String r10, int r11, ContinuationImpl r12) {
        if ((r12 instanceof FeedListOwner$removeCard$1) == false) goto L7;
        FeedListOwner$removeCard$1 r13 = (FeedListOwner$removeCard$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        r10 = (String) r13.L$1;
        r5 = (List) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L17:
        ArrayList r18 = new ArrayList();
        Iterator r19 = r5.iterator();
    L19:
        if (r19.hasNext() == false) goto L23;
        Object r20 = r19.next();
        if (Intrinsics.areEqual(((BaseCardModel) r20).getId(), r10) == true) goto L19;
        r18.add(r20);
        goto L19
    L23:
        return r18;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        r13.L$0 = r5;
        r13.L$1 = r10;
        r13.label = 1;
        if (com.obric.flow.cardlistpage.domain.usecase.f.a(this.d, r10, r11, r13) != r16) goto L17;
        return r16;
    L7:
        r13 = new FeedListOwner$removeCard$1(this, r12);
        goto L8
    }

    public final Object c(List r10, String r11, ContinuationImpl r12) {
        if ((r12 instanceof FeedListOwner$removeCardById$1) == false) goto L7;
        FeedListOwner$removeCardById$1 r5 = (FeedListOwner$removeCardById$1) r12;
        int r13 = r5.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r5.label;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        r11 = (String) r5.L$1;
        r10 = (List) r5.L$0;
        ResultKt.throwOnFailure(r14);
    L39:
        ArrayList r17 = new ArrayList();
        Iterator r18 = r10.iterator();
    L41:
        if (r18.hasNext() == false) goto L46;
        Object r19 = r18.next();
        if (Intrinsics.areEqual(((BaseCardModel) r19).getId(), r11) == true) goto L41;
        r17.add(r19);
        goto L41
    L46:
        return r17;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
    L52:
        return r14;
    L16:
        ResultKt.throwOnFailure(r14);
        Iterator r20 = r10.iterator();
    L18:
        if (r20.hasNext() == false) goto L22;
        Object r21 = r20.next();
        if (Intrinsics.areEqual(((BaseCardModel) r21).getId(), r11) == false) goto L18;
    L23:
        BaseCardModel r22 = (BaseCardModel) r21;
        if (r22 != null) goto L26;
        return r10;
    L26:
        CardType r23 = r22.getType();
        int r24 = t.f11618a[r23.ordinal()];
        if (r24 == 1) goto L47;
        if (r24 != 2) goto L62;
        r5.L$0 = r10;
        r5.L$1 = r11;
        r5.label = 2;
        com.obric.flow.cardlistpage.domain.repository.b r25 = this.d.f11525a;
        if (r25 == null) goto L36;
        Object r26 = r25.e(r11, r5);
        if (r26 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L37;
        r26 = Unit.INSTANCE;
    L37:
        if (r26 != r15) goto L39;
        return r15;
    L36:
        r26 = Unit.INSTANCE;
        goto L37
    L62:
        return r10;
    L47:
        Integer r27 = StringsKt.toIntOrNull(r22.getOriginalId());
        if (r27 == null) goto L53;
        int r28 = r27.intValue();
        r5.label = 1;
        r14 = b(r10, r11, r28, r5);
        if (r14 != r15) goto L52;
        return r15;
    L53:
        return r10;
    L22:
        r21 = null;
    L7:
        r5 = new FeedListOwner$removeCardById$1(this, r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
    public final Object d(ArrayList r5, BaseCardModel r10, ContinuationImpl r11) {
        if ((r11 instanceof FeedListOwner$updateCard$1) == false) goto L7;
        FeedListOwner$updateCard$1 r12 = (FeedListOwner$updateCard$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = (BaseCardModel) r12.L$1;
        r5 = (List) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L23:
        Iterator r17 = r5.iterator();
        int r18 = 0;
    L25:
        if (r17.hasNext() == false) goto L30;
        if (Intrinsics.areEqual(((BaseCardModel) r17.next()).getId(), r10.getId()) == true) goto L31;
        r18 = r18 + 1;
    L31:
        if (r18 != (-1)) goto L33;
        return r5;
    L33:
        List r19 = CollectionsKt.toMutableList(r5);
        r19.set(r18, r10);
        return r19;
    L30:
        r18 = -1;
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r12.L$0 = r5;
        r12.L$1 = r10;
        r12.label = 1;
        com.obric.flow.cardlistpage.domain.repository.b r20 = (com.obric.flow.cardlistpage.domain.repository.b) this.f11621c.f20153a;
        if (r20 == null) goto L20;
        Object r21 = r20.f(r10, r12);
        if (r21 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        r21 = Unit.INSTANCE;
    L21:
        if (r21 != r15) goto L23;
        return r15;
    L20:
        r21 = Unit.INSTANCE;
    L7:
        r12 = new FeedListOwner$updateCard$1(this, r11);
        goto L8
    }
}
