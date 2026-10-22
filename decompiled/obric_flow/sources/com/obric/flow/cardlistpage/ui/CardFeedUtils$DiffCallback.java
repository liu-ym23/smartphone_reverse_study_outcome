package com.obric.flow.cardlistpage.ui;

import ai.j0;
import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/obric/flow/cardlistpage/ui/CardFeedUtils$DiffCallback", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CardFeedUtils$DiffCallback extends DiffUtil.Callback {
    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r5, int r10) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r5, int r10) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final Object getChangePayload(int r10, int r11) {
        String r5 = j0.f(r10, r11, "getChangePayload: oldItemPosition=", " newItemPosition=");
        Intrinsics.checkNotNullParameter("CardFeedUtils", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        org.koin.core.a r12 = su.a.f22013b;
        if (r12 == null) goto L7;
        ((ju.b) r12.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("CardFeedUtils", r5);
        return super.getChangePayload(r10, r11);
    L7:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        throw null;
    }
}
