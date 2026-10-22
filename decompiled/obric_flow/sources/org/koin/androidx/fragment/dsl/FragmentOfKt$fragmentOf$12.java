package org.koin.androidx.fragment.dsl;

import androidx.fragment.app.Fragment;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.koin.core.scope.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0012\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u0003\u0018\u0001\"\u0006\b\u0003\u0010\u0004\u0018\u0001\"\u0006\b\u0004\u0010\u0005\u0018\u0001\"\u0006\b\u0005\u0010\u0006\u0018\u0001\"\u0006\b\u0006\u0010\u0007\u0018\u0001\"\u0006\b\u0007\u0010\b\u0018\u0001\"\u0006\b\b\u0010\t\u0018\u0001\"\u0006\b\t\u0010\n\u0018\u0001\"\u0006\b\n\u0010\u000b\u0018\u0001\"\u0006\b\u000b\u0010\f\u0018\u0001*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eH\n¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Landroidx/fragment/app/Fragment;", "R", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "Lorg/koin/core/scope/a;", "Lvu/a;", ST.IMPLICIT_ARG_NAME, "invoke", "(Lorg/koin/core/scope/a;Lvu/a;)Landroidx/fragment/app/Fragment;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nFragmentOf.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FragmentOf.kt\norg/koin/androidx/fragment/dsl/FragmentOfKt$fragmentOf$12\n+ 2 New.kt\norg/koin/core/module/dsl/NewKt\n+ 3 Scope.kt\norg/koin/core/scope/Scope\n*L\n1#1,212:1\n112#2:213\n132#3,5:214\n*S KotlinDebug\n*F\n+ 1 FragmentOf.kt\norg/koin/androidx/fragment/dsl/FragmentOfKt$fragmentOf$12\n*L\n123#1:213\n123#1:214,5\n*E\n"})
public final class FragmentOfKt$fragmentOf$12 extends Lambda implements Function2<a, vu.a, Fragment> {
    final /* synthetic */ Function11<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Fragment> $constructor;

    public FragmentOfKt$fragmentOf$12(Function11<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Fragment> r5) {
        this.$constructor = r5;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Fragment invoke2(a r14, vu.a r15) {
        Intrinsics.checkNotNullParameter(r14, "$this$fragment");
        Intrinsics.checkNotNullParameter(r15, ST.IMPLICIT_ARG_NAME);
        Function11<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Fragment> r5 = this.$constructor;
        Intrinsics.reifiedOperationMarker(4, "T1");
        Object r10 = r14.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        Object r11 = r14.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        Object r12 = r14.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        Object r13 = r14.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        Object r16 = r14.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        Object r17 = r14.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        Object r18 = r14.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        Object r19 = r14.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        Object r110 = r14.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        Object r111 = r14.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T11");
        return r5.invoke(r10, r11, r12, r13, r16, r17, r18, r19, r110, r111, r14.b(null, Reflection.getOrCreateKotlinClass(Object.class), null));
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Fragment mo2invoke(a r5, vu.a r10) {
        return invoke2(r5, r10);
    }
}
