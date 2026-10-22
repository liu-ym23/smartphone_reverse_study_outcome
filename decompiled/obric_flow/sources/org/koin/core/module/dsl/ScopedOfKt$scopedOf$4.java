package org.koin.core.module.dsl;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.koin.core.scope.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\u0006\b\u0003\u0010\u0003\u0018\u0001*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"R", "T1", "T2", "T3", "Lorg/koin/core/scope/a;", "Lvu/a;", ST.IMPLICIT_ARG_NAME, "invoke", "(Lorg/koin/core/scope/a;Lvu/a;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nScopedOf.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScopedOf.kt\norg/koin/core/module/dsl/ScopedOfKt$scopedOf$4\n+ 2 New.kt\norg/koin/core/module/dsl/NewKt\n+ 3 Scope.kt\norg/koin/core/scope/Scope\n*L\n1#1,224:1\n56#2:225\n132#3,5:226\n*S KotlinDebug\n*F\n+ 1 ScopedOf.kt\norg/koin/core/module/dsl/ScopedOfKt$scopedOf$4\n*L\n71#1:225\n71#1:226,5\n*E\n"})
public final class ScopedOfKt$scopedOf$4 extends Lambda implements Function2<a, vu.a, Object> {
    final /* synthetic */ Function3<Object, Object, Object, Object> $constructor;

    public ScopedOfKt$scopedOf$4(Function3<Object, Object, Object, Object> r5) {
        this.$constructor = r5;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(a r5, vu.a r10) {
        return invoke2(r5, r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(a r10, vu.a r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$scoped");
        Intrinsics.checkNotNullParameter(r11, ST.IMPLICIT_ARG_NAME);
        Function3<Object, Object, Object, Object> r5 = this.$constructor;
        Intrinsics.reifiedOperationMarker(4, "T1");
        Object r12 = r10.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        Object r13 = r10.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        return r5.invoke(r12, r13, r10.b(null, Reflection.getOrCreateKotlinClass(Object.class), null));
    }
}
