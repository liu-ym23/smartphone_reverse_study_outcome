package com.obric.flow.cardlistpage.ui.component.feedlist;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11630a;

    public z(List r5) {
        Intrinsics.checkNotNullParameter(r5, "cards");
        this.f11630a = r5;
    }

    @Override // com.obric.flow.cardlistpage.mvi.j
    public final String a() {
        int r5 = this.f11630a.size();
        List r10 = this.f11630a;
        Intrinsics.checkNotNullParameter(r10, "cards");
        return "ReplaceCards(size=" + r5 + ", cards=" + CollectionsKt.q(r10, null, "[", "]", 8, "...", FeedListContractKt$summarizeFeedListCardsForLog$1.INSTANCE, 1) + ")";
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof z) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f11630a, ((z) r5).f11630a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f11630a.hashCode();
    }

    public final String toString() {
        return "ReplaceCards(cards=" + this.f11630a + ")";
    }
}
