package com.google.devtools.ksp;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import il.d;
import il.s;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lil/s;", ST.IMPLICIT_ARG_NAME, "Lil/d;", "invoke", "(Lil/s;)Lil/d;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class UtilsKt$getAllSuperTypes$2 extends Lambda implements Function1<s, d> {
    public static final UtilsKt$getAllSuperTypes$2 INSTANCE = null;

    static {
        INSTANCE = new UtilsKt$getAllSuperTypes$2();
    }

    public UtilsKt$getAllSuperTypes$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d invoke2(s r5) {
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
        r5.resolve();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d invoke(s r5) {
        invoke2(r5);
        return null;
    }
}
