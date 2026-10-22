package com.obric.oui.material;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* synthetic */ class MaterialXmlParser$buildBlendConfigStateList$1 extends FunctionReferenceImpl implements Function2<com.obric.oui.color.a[], com.obric.oui.color.a[], Boolean> {
    public static final MaterialXmlParser$buildBlendConfigStateList$1 INSTANCE = null;

    static {
        INSTANCE = new MaterialXmlParser$buildBlendConfigStateList$1();
    }

    MaterialXmlParser$buildBlendConfigStateList$1() {
        super(2, ArraysKt.class, "contentDeepEquals", "contentDeepEqualsNullable([Ljava/lang/Object;[Ljava/lang/Object;)Z", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(com.obric.oui.color.a[] r1, com.obric.oui.color.a[] r2) {
        Intrinsics.checkNotNullParameter(r1, "p0");
        return Boolean.valueOf(ArraysKt.contentDeepEquals(r1, r2));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Boolean invoke(com.obric.oui.color.a[] r3, com.obric.oui.color.a[] r4) {
        return invoke2((com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.color.a[].class, "com.obric.memorydata.plugin"), (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.color.a[].class, "com.obric.memorydata.plugin"));
    }
}
