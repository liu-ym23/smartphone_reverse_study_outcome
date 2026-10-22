package com.google.devtools.ksp;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import il.c;
import il.d;
import il.p;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lil/d;", ST.IMPLICIT_ARG_NAME, "Lkotlin/sequences/Sequence;", "Lil/p;", "invoke", "(Lil/d;)Lkotlin/sequences/Sequence;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class UtilsKt$getAllSuperTypes$3 extends Lambda implements Function1<d, Sequence<? extends p>> {
    public static final UtilsKt$getAllSuperTypes$3 INSTANCE = null;

    /* JADX INFO: renamed from: com.google.devtools.ksp.UtilsKt$getAllSuperTypes$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lil/c;", ST.IMPLICIT_ARG_NAME, "Lkotlin/sequences/Sequence;", "Lil/p;", "invoke", "(Lil/c;)Lkotlin/sequences/Sequence;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class AnonymousClass1 extends Lambda implements Function1<c, Sequence<? extends p>> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Sequence<? extends p> invoke(c r5) {
            j0.A(r5);
            return invoke2(null);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Sequence<p> invoke2(c r5) {
            Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
            Intrinsics.checkNotNullParameter(null, "<this>");
            throw null;
        }
    }

    static {
        INSTANCE = new UtilsKt$getAllSuperTypes$3();
    }

    public UtilsKt$getAllSuperTypes$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Sequence<? extends p> invoke(d r5) {
        j0.A(r5);
        return invoke2(null);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Sequence<p> invoke2(d r5) {
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
        throw new IllegalStateException("unhandled super type kind, please file a bug at https://github.com/google/ksp/issues/new");
    }
}
