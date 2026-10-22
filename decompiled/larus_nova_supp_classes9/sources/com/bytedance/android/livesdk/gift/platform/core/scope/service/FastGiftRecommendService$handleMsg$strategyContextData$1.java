package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import androidx.collection.LongSparseArray;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/collection/LongSparseArray;", "Lcom/bytedance/android/livesdk/gift/platform/core/model/o;", "sa", "Lkotlin/sequences/Sequence;", "kotlin.jvm.PlatformType", "invoke", "(Landroidx/collection/LongSparseArray;)Lkotlin/sequences/Sequence;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class FastGiftRecommendService$handleMsg$strategyContextData$1 extends Lambda implements Function1<LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o>, Sequence<? extends com.bytedance.android.livesdk.gift.platform.core.model.o>> {
    public static final FastGiftRecommendService$handleMsg$strategyContextData$1 INSTANCE = null;

    public static final class a implements Sequence<Integer> {
        public final /* synthetic */ LongSparseArray a;

        public final Iterator<Integer> iterator() {
            return RangesKt.until(0, this.a.size()).iterator();
        }

        public a(LongSparseArray r1) {
            this.a = r1;
        }
    }

    static {
        INSTANCE = new FastGiftRecommendService$handleMsg$strategyContextData$1();
    }

    public FastGiftRecommendService$handleMsg$strategyContextData$1() {
        super(1);
    }

    public final Sequence<com.bytedance.android.livesdk.gift.platform.core.model.o> invoke(final LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o> r3) {
        Intrinsics.checkNotNullParameter(r3, "sa");
        return SequencesKt.map(new a(r3), new AnonymousClass2(r3));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((LongSparseArray) r1);
    }
}
