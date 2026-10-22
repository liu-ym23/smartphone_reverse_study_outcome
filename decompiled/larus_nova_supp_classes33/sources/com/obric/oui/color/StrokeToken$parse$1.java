package com.obric.oui.color;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "isLight", "Lcom/obric/oui/color/i0;", "invoke", "(Z)Lcom/obric/oui/color/i0;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class StrokeToken$parse$1 extends Lambda implements Function1<Boolean, i0> {
    final /* synthetic */ Function1<Boolean, j0> $provider;

    public StrokeToken$parse$1(Function1<Boolean, j0> r1) {
        this.$provider = r1;
        super(1);
    }

    public final i0 invoke(boolean r2) {
        return k0.a((j0) this.$provider.invoke(Boolean.valueOf(r2)));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Boolean) r1).booleanValue());
    }
}
