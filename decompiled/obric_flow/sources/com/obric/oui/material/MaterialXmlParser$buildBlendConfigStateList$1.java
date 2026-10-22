package com.obric.oui.material;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
final /* synthetic */ class MaterialXmlParser$buildBlendConfigStateList$1 extends FunctionReferenceImpl implements Function2<com.obric.oui.color.a[], com.obric.oui.color.a[], Boolean> {
    public static final MaterialXmlParser$buildBlendConfigStateList$1 INSTANCE = null;

    static {
        INSTANCE = new MaterialXmlParser$buildBlendConfigStateList$1();
    }

    public MaterialXmlParser$buildBlendConfigStateList$1() {
        super(2, ArraysKt.class, "contentDeepEquals", "contentDeepEqualsNullable([Ljava/lang/Object;[Ljava/lang/Object;)Z", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(com.obric.oui.color.a[] r5, com.obric.oui.color.a[] r10) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        return Boolean.valueOf(ArraysKt.contentDeepEquals(r5, r10));
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Boolean mo2invoke(com.obric.oui.color.a[] r5, com.obric.oui.color.a[] r10) {
        return invoke2(r5, r10);
    }
}
