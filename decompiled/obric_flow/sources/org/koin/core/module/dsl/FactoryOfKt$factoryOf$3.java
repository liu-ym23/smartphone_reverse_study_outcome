package org.koin.core.module.dsl;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.koin.core.scope.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"R", "T1", "T2", "Lorg/koin/core/scope/a;", "Lvu/a;", ST.IMPLICIT_ARG_NAME, "invoke", "(Lorg/koin/core/scope/a;Lvu/a;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nFactoryOf.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FactoryOf.kt\norg/koin/core/module/dsl/FactoryOfKt$factoryOf$3\n+ 2 New.kt\norg/koin/core/module/dsl/NewKt\n+ 3 Scope.kt\norg/koin/core/scope/Scope\n*L\n1#1,222:1\n49#2:223\n132#3,5:224\n*S KotlinDebug\n*F\n+ 1 FactoryOf.kt\norg/koin/core/module/dsl/FactoryOfKt$factoryOf$3\n*L\n60#1:223\n60#1:224,5\n*E\n"})
public final class FactoryOfKt$factoryOf$3 extends Lambda implements Function2<a, vu.a, Object> {
    final /* synthetic */ Function2<Object, Object, Object> $constructor;

    public FactoryOfKt$factoryOf$3(Function2<Object, Object, Object> r5) {
        this.$constructor = r5;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(a r5, vu.a r10) {
        return invoke2(r5, r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(a r5, vu.a r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$factory");
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        Function2<Object, Object, Object> r11 = this.$constructor;
        Intrinsics.reifiedOperationMarker(4, "T1");
        Object r12 = r5.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        return r11.mo2invoke(r12, r5.b(null, Reflection.getOrCreateKotlinClass(Object.class), null));
    }
}
