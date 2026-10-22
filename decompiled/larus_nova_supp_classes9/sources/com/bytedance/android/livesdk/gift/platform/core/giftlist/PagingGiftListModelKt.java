package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.model.h1;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PagingGiftListModelKt {
    public static final k a(k r9, final Function1<? super h1, Boolean> r10, final Function1<? super Long, ? extends h1> r11) {
        Intrinsics.checkNotNullParameter(r9, "$this$toFilterModel");
        Intrinsics.checkNotNullParameter(r10, "filter");
        Intrinsics.checkNotNullParameter(r11, "transform");
        return new k(r9.a, SequencesKt.toMutableList(SequencesKt.filter(CollectionsKt.asSequence(r9.b), new PagingGiftListModelKt$toFilterModel$2(r11, r10))), r9.c, r9.d, SequencesKt.toList(SequencesKt.filter(CollectionsKt.asSequence(r9.e), new PagingGiftListModelKt$toFilterModel$3(r11, r10))));
    }
}
