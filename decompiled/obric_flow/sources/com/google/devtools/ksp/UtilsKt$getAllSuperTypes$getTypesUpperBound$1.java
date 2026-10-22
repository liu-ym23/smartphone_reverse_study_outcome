package com.google.devtools.ksp;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import il.c;
import il.s;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lil/s;", ST.IMPLICIT_ARG_NAME, "Lkotlin/sequences/Sequence;", "Lil/c;", "invoke", "(Lil/s;)Lkotlin/sequences/Sequence;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class UtilsKt$getAllSuperTypes$getTypesUpperBound$1 extends Lambda implements Function1<s, Sequence<? extends c>> {
    public static final UtilsKt$getAllSuperTypes$getTypesUpperBound$1 INSTANCE = null;

    static {
        INSTANCE = new UtilsKt$getAllSuperTypes$getTypesUpperBound$1();
    }

    public UtilsKt$getAllSuperTypes$getTypesUpperBound$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Sequence<? extends c> invoke(s r5) {
        return invoke2(r5);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Sequence<c> invoke2(s r5) {
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
        r5.resolve();
        throw null;
    }
}
