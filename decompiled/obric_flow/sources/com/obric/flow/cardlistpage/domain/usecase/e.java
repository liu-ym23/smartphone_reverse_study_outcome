package com.obric.flow.cardlistpage.domain.usecase;

import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.base.CardType;
import com.obric.flow.cardlistpage.data.HeaderWidgetCardModel;
import com.obric.flow.cardlistpage.data.TravelCardModel;
import com.obric.flow.cardlistpage.data.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.obric.flow.cardlistpage.domain.repository.b f11522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fq.a f11523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11524c;

    public e(com.obric.flow.cardlistpage.domain.repository.b r5, fq.a r10, int r11) {
        this.f11522a = r5;
        this.f11523b = r10;
        this.f11524c = r11;
    }

    public static Object a(e r10, ContinuationImpl r11) {
        if ((r11 instanceof RefreshFeedDataUseCase$invoke$1) == false) goto L7;
        RefreshFeedDataUseCase$invoke$1 r5 = (RefreshFeedDataUseCase$invoke$1) r11;
        int r12 = r5.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.label;
        if (r15 == 0) goto L18;
        if (r15 == 1) goto L17;
        if (r15 == 2) goto L16;
        if (r15 != 3) goto L15;
        Iterator r16 = (Iterator) r5.L$2;
        List r17 = (List) r5.L$1;
        e r18 = (e) r5.L$0;
        ResultKt.throwOnFailure(r13);
    L32:
        boolean r19 = false;
        if (r16.hasNext() == false) goto L63;
        BaseCardModel r110 = (BaseCardModel) r16.next();
        CardType r20 = r110.getType();
        CardType r21 = CardType.WIDGET;
        if (r20 != r21) goto L37;
        Integer r22 = StringsKt.toIntOrNull(r110.getOriginalId());
    L39:
        if (r110.getType() != r21) goto L62;
        if (r22 == null) goto L62;
        if (r22.intValue() == (-1)) goto L61;
        if (r22.intValue() == Integer.parseInt("-100")) goto L61;
        if (r22.intValue() == 0) goto L61;
        fq.a r23 = r18.f11523b;
        if (r23 == null) goto L51;
        r19 = r23.a(r22.intValue());
    L51:
        if (r19 == true) goto L52;
        fq.a r24 = r18.f11523b;
        if (r24 == null) goto L56;
        r24.f16974b.deleteAppWidgetId(r22.intValue());
    L56:
        com.obric.flow.cardlistpage.domain.repository.b r25 = r18.f11522a;
        if (r25 == null) goto L32;
        String r111 = r110.getId();
        r5.L$0 = r18;
        r5.L$1 = r17;
        r5.L$2 = r16;
        r5.label = 3;
        if (r25.e(r111, r5) != r14) goto L32;
        return r14;
    L52:
        r17.add(r110);
    L61:
        r17.add(r110);
    L62:
        r17.add(r110);
        goto L32
    L37:
        r22 = null;
        goto L39
    L63:
        r17.add(0, new HeaderWidgetCardModel(4, r18.f11524c));
        if (r17.isEmpty() == false) goto L66;
    L65:
        r19 = true;
    L71:
        if (r19 == false) goto L73;
        TravelCardModel.Companion.getClass();
        r17.add(1, s.a());
    L73:
        return r17;
    L66:
        Iterator r112 = r17.iterator();
    L68:
        if (r112.hasNext() == false) goto L65;
        if ((((BaseCardModel) r112.next()) instanceof TravelCardModel) == false) goto L68;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r10 = (e) r5.L$0;
        ResultKt.throwOnFailure(r13);
    L28:
        List r113 = (List) r13;
        if (r113 != null) goto L31;
    L30:
        r113 = CollectionsKt.emptyList();
    L31:
        r17 = new ArrayList();
        r18 = r10;
        r16 = r113.iterator();
        goto L32
    L17:
        r10 = (e) r5.L$0;
        ResultKt.throwOnFailure(r13);
    L23:
        com.obric.flow.cardlistpage.domain.repository.b r114 = r10.f11522a;
        if (r114 == null) goto L30;
        r5.L$0 = r10;
        r5.label = 2;
        r13 = r114.d(r5);
        if (r13 != r14) goto L28;
        return r14;
    L18:
        ResultKt.throwOnFailure(r13);
        com.obric.flow.cardlistpage.domain.repository.b r115 = r10.f11522a;
        if (r115 == null) goto L23;
        r5.L$0 = r10;
        r5.label = 1;
        if (r115.c(r5) != r14) goto L23;
        return r14;
    L7:
        r5 = new RefreshFeedDataUseCase$invoke$1(r10, r11);
        goto L8
    }
}
