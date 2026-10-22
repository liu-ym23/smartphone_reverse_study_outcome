package com.obric.oui.material;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "first", "", "Lcom/obric/oui/color/BlendConfig;", "second", "invoke", "([Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class MaterialConfigSerialization$readBlendConfigStateList$1 extends Lambda implements Function2<com.obric.oui.color.a[], com.obric.oui.color.a[], Boolean> {
    public static final MaterialConfigSerialization$readBlendConfigStateList$1 INSTANCE = null;

    static {
        INSTANCE = new MaterialConfigSerialization$readBlendConfigStateList$1();
    }

    MaterialConfigSerialization$readBlendConfigStateList$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(com.obric.oui.color.a[] r1, com.obric.oui.color.a[] r2) {
        Intrinsics.checkNotNullParameter(r1, "first");
        Intrinsics.checkNotNullParameter(r2, "second");
        return Boolean.valueOf(ArraysKt.contentDeepEquals(r1, r2));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Boolean invoke(com.obric.oui.color.a[] r3, com.obric.oui.color.a[] r4) {
        return invoke2((com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.color.a[].class, "com.obric.memorydata.plugin"), (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.color.a[].class, "com.obric.memorydata.plugin"));
    }
}
