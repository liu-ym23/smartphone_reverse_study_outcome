package com.obric.flow.cardlistpage.domain.usecase;

import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.base.CardType;
import com.obric.flow.cardlistpage.data.HeaderWidgetCardModel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fq.a f11516a;

    public b(fq.a r5) {
        Intrinsics.checkNotNullParameter(r5, "widgetInfoProvider");
        this.f11516a = r5;
    }

    @Override // com.obric.flow.cardlistpage.domain.usecase.g
    public final boolean a(BaseCardModel r5) {
        Intrinsics.checkNotNullParameter(r5, "card");
        if (r5.getType() == CardType.WIDGET) goto L5;
    L7:
        return false;
    L5:
        if ((r5 instanceof HeaderWidgetCardModel) == true) goto L7;
        return true;
    }

    @Override // com.obric.flow.cardlistpage.domain.usecase.g
    public final Object b(BaseCardModel r5, Continuation r10) {
        Integer r11 = StringsKt.toIntOrNull(r5.getOriginalId());
        if (r11 == null) goto L7;
        return Boxing.boxBoolean(!this.f11516a.a(r11.intValue()));
    L7:
        return Boxing.boxBoolean(false);
    }

    @Override // com.obric.flow.cardlistpage.domain.usecase.g
    public final Unit c(BaseCardModel r5) {
        Integer r10 = StringsKt.toIntOrNull(r5.getOriginalId());
        if (r10 == null) goto L7;
        int r11 = r10.intValue();
        this.f11516a.f16974b.deleteAppWidgetId(r11);
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    }
}
