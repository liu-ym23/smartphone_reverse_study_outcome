package com.google.devtools.ksp;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Byte;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class UtilsKt$createInvocationHandler$1$value$4 extends Lambda implements Function0<Byte> {
    final /* synthetic */ Object $result;

    public UtilsKt$createInvocationHandler$1$value$4(Object r5) {
        this.$result = r5;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Byte invoke() {
        Object r5 = this.$result;
        if ((r5 instanceof Integer) == false) goto L5;
        byte r10 = (byte) ((Number) r5).intValue();
    L7:
        return Byte.valueOf(r10);
    L5:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Byte");
        r10 = ((Byte) r5).byteValue();
        goto L7
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Byte invoke() {
        return invoke();
    }
}
