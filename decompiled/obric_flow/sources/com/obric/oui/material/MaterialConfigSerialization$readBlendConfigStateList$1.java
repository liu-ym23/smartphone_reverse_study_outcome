package com.obric.oui.material;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/obric/oui/color/a;", "first", "second", "", "invoke", "([Lcom/obric/oui/color/a;[Lcom/obric/oui/color/a;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class MaterialConfigSerialization$readBlendConfigStateList$1 extends Lambda implements Function2<com.obric.oui.color.a[], com.obric.oui.color.a[], Boolean> {
    public static final MaterialConfigSerialization$readBlendConfigStateList$1 INSTANCE = null;

    static {
        INSTANCE = new MaterialConfigSerialization$readBlendConfigStateList$1();
    }

    public MaterialConfigSerialization$readBlendConfigStateList$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(com.obric.oui.color.a[] r5, com.obric.oui.color.a[] r10) {
        Intrinsics.checkNotNullParameter(r5, "first");
        Intrinsics.checkNotNullParameter(r10, "second");
        return Boolean.valueOf(ArraysKt.contentDeepEquals(r5, r10));
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Boolean mo2invoke(com.obric.oui.color.a[] r5, com.obric.oui.color.a[] r10) {
        return invoke2(r5, r10);
    }
}
