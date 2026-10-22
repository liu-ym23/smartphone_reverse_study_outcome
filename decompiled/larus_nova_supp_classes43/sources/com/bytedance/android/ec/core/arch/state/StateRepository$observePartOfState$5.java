package com.bytedance.android.ec.core.arch.state;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\b\b\u0003\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"A", "B", "C", "Lcom/bytedance/android/ec/core/arch/state/b;", "S", "it", "Lcom/bytedance/android/ec/core/arch/state/h;", "invoke", "(Lcom/bytedance/android/ec/core/arch/state/b;)Lcom/bytedance/android/ec/core/arch/state/h;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class StateRepository$observePartOfState$5 extends Lambda implements Function1<b, h<Object, Object, Object>> {
    final /* synthetic */ KProperty1 $prop1;
    final /* synthetic */ KProperty1 $prop2;
    final /* synthetic */ KProperty1 $prop3;

    public StateRepository$observePartOfState$5(KProperty1 r1, KProperty1 r10, KProperty1 r11) {
        this.$prop1 = r1;
        this.$prop2 = r10;
        this.$prop3 = r11;
        super(1);
    }

    public final h<Object, Object, Object> invoke(b r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        return new h(this.$prop1.get(r10), this.$prop2.get(r10), this.$prop3.get(r10));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((b) r1);
    }
}
