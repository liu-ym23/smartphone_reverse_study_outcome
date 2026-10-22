package com.bytedance.als.ui.state;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "V", "STATE", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
final class StateContainer$getState$newLiveState$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ KProperty1 $property;
    final /* synthetic */ StateContainer this$0;

    public StateContainer$getState$newLiveState$1(StateContainer r1, KProperty1 r10) {
        this.this$0 = r1;
        this.$property = r10;
        super(0);
    }

    public final Object invoke() {
        return this.$property.get(this.this$0.a);
    }
}
