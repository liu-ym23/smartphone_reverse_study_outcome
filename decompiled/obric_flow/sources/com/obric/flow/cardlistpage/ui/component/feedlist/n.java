package com.obric.flow.cardlistpage.ui.component.feedlist;

import ai.j0;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseCardModel f11593a;

    public n(BaseCardModel r5) {
        Intrinsics.checkNotNullParameter(r5, "card");
        this.f11593a = r5;
    }

    @Override // com.obric.flow.cardlistpage.mvi.e
    public final String a() {
        BaseCardModel r5 = this.f11593a;
        return j0.l("UpdateCardData(cardId=", r5.getId(), ", widgetId=", r5.getOriginalId(), ")");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f11593a, ((n) r5).f11593a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f11593a.hashCode();
    }

    public final String toString() {
        return "UpdateCardData(card=" + this.f11593a + ")";
    }
}
