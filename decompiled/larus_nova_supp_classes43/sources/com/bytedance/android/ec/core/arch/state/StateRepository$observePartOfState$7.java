package com.bytedance.android.ec.core.arch.state;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\b\b\u0004\u0010\u0005*\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"A", "B", "C", "D", "Lcom/bytedance/android/ec/core/arch/state/b;", "S", "it", "Lcom/bytedance/android/ec/core/arch/state/i;", "invoke", "(Lcom/bytedance/android/ec/core/arch/state/b;)Lcom/bytedance/android/ec/core/arch/state/i;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class StateRepository$observePartOfState$7 extends Lambda implements Function1<b, i<Object, Object, Object, Object>> {
    final /* synthetic */ KProperty1 $prop1;
    final /* synthetic */ KProperty1 $prop2;
    final /* synthetic */ KProperty1 $prop3;
    final /* synthetic */ KProperty1 $prop4;

    public StateRepository$observePartOfState$7(KProperty1 r1, KProperty1 r10, KProperty1 r11, KProperty1 r12) {
        this.$prop1 = r1;
        this.$prop2 = r10;
        this.$prop3 = r11;
        this.$prop4 = r12;
        super(1);
    }

    public final i<Object, Object, Object, Object> invoke(b r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        return new i(this.$prop1.get(r10), this.$prop2.get(r10), this.$prop3.get(r10), this.$prop4.get(r10));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((b) r1);
    }
}
