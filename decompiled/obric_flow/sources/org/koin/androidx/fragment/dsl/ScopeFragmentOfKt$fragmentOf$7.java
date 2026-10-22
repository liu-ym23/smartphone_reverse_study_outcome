package org.koin.androidx.fragment.dsl;

import androidx.fragment.app.Fragment;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.koin.core.scope.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\r\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u0003\u0018\u0001\"\u0006\b\u0003\u0010\u0004\u0018\u0001\"\u0006\b\u0004\u0010\u0005\u0018\u0001\"\u0006\b\u0005\u0010\u0006\u0018\u0001\"\u0006\b\u0006\u0010\u0007\u0018\u0001*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/fragment/app/Fragment;", "R", "T1", "T2", "T3", "T4", "T5", "T6", "Lorg/koin/core/scope/a;", "Lvu/a;", ST.IMPLICIT_ARG_NAME, "invoke", "(Lorg/koin/core/scope/a;Lvu/a;)Landroidx/fragment/app/Fragment;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nScopeFragmentOf.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScopeFragmentOf.kt\norg/koin/androidx/fragment/dsl/ScopeFragmentOfKt$fragmentOf$7\n+ 2 New.kt\norg/koin/core/module/dsl/NewKt\n+ 3 Scope.kt\norg/koin/core/scope/Scope\n*L\n1#1,211:1\n77#2:212\n132#3,5:213\n*S KotlinDebug\n*F\n+ 1 ScopeFragmentOf.kt\norg/koin/androidx/fragment/dsl/ScopeFragmentOfKt$fragmentOf$7\n*L\n82#1:212\n82#1:213,5\n*E\n"})
public final class ScopeFragmentOfKt$fragmentOf$7 extends Lambda implements Function2<a, vu.a, Fragment> {
    final /* synthetic */ Function6<Object, Object, Object, Object, Object, Object, Fragment> $constructor;

    public ScopeFragmentOfKt$fragmentOf$7(Function6<Object, Object, Object, Object, Object, Object, Fragment> r5) {
        this.$constructor = r5;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Fragment invoke2(a r10, vu.a r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$fragment");
        Intrinsics.checkNotNullParameter(r11, ST.IMPLICIT_ARG_NAME);
        Function6<Object, Object, Object, Object, Object, Object, Fragment> r5 = this.$constructor;
        Intrinsics.reifiedOperationMarker(4, "T1");
        Object r12 = r10.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        Object r13 = r10.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        Object r14 = r10.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        Object r15 = r10.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        Object r16 = r10.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        return r5.invoke(r12, r13, r14, r15, r16, r10.b(null, Reflection.getOrCreateKotlinClass(Object.class), null));
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Fragment mo2invoke(a r5, vu.a r10) {
        return invoke2(r5, r10);
    }
}
