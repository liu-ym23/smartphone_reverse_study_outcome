package com.bytedance.android.ec.core.arch.state;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a,\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\b\b\u0007\u0010\b*\u00020\u00072\u0006\u0010\t\u001a\u00028\u0007H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"A", "B", "C", "D", "E", "F", "G", "Lcom/bytedance/android/ec/core/arch/state/b;", "S", "it", "Lcom/bytedance/android/ec/core/arch/state/l;", "invoke", "(Lcom/bytedance/android/ec/core/arch/state/b;)Lcom/bytedance/android/ec/core/arch/state/l;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class StateRepository$observePartOfState$13 extends Lambda implements Function1<b, l<Object, Object, Object, Object, Object, Object, Object>> {
    final /* synthetic */ KProperty1 $prop1;
    final /* synthetic */ KProperty1 $prop2;
    final /* synthetic */ KProperty1 $prop3;
    final /* synthetic */ KProperty1 $prop4;
    final /* synthetic */ KProperty1 $prop5;
    final /* synthetic */ KProperty1 $prop6;
    final /* synthetic */ KProperty1 $prop7;

    public StateRepository$observePartOfState$13(KProperty1 r1, KProperty1 r10, KProperty1 r11, KProperty1 r12, KProperty1 r13, KProperty1 r14, KProperty1 r15) {
        this.$prop1 = r1;
        this.$prop2 = r10;
        this.$prop3 = r11;
        this.$prop4 = r12;
        this.$prop5 = r13;
        this.$prop6 = r14;
        this.$prop7 = r15;
        super(1);
    }

    public final l<Object, Object, Object, Object, Object, Object, Object> invoke(b r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        return new l(this.$prop1.get(r10), this.$prop2.get(r10), this.$prop3.get(r10), this.$prop4.get(r10), this.$prop5.get(r10), this.$prop6.get(r10), this.$prop7.get(r10));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((b) r1);
    }
}
