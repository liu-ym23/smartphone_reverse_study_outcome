package com.ss.android.lark.picker.config.condition;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [C] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u0012\u0004\u0012\u0002H\u00040\u0001\"\f\b\u0000\u0010\u0004*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0005\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "C", "it", "invoke", "(Lcom/ss/android/lark/picker/config/condition/Condition$Element;)Lkotlin/Pair;"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class FoldCondition$inter$3<C> extends Lambda implements Function1<C, Pair<? extends Condition.Key<? extends Condition.Element<?>>, ? extends C>> {
    public static final FoldCondition$inter$3 INSTANCE = null;

    static {
        INSTANCE = new FoldCondition$inter$3();
    }

    public FoldCondition$inter$3() {
        super(1);
    }

    /* JADX WARN: Incorrect types in method signature: (TC;)Lkotlin/Pair<Lcom/ss/android/lark/picker/config/condition/Condition$Key<+Lcom/ss/android/lark/picker/config/condition/Condition$Element<*>;>;TC;>; */
    public final Pair invoke(Condition.Element r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return TuplesKt.to(r2.getKey(), r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Condition.Element) r1);
    }
}
