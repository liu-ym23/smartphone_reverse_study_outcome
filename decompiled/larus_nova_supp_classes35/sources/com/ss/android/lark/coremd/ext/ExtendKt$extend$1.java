package com.ss.android.lark.coremd.ext;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "T", "it", "Lcom/ss/android/lark/coremd/ext/Extendable;", "invoke", "(Lcom/ss/android/lark/coremd/ext/Extendable;)Ljava/lang/Object;"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class ExtendKt$extend$1 extends Lambda implements Function1<j, Object> {
    final /* synthetic */ Object $constDefault;

    public ExtendKt$extend$1(Object r1) {
        this.$constDefault = r1;
        super(1);
    }

    public final Object invoke(j r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return this.$constDefault;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((j) r1);
    }
}
