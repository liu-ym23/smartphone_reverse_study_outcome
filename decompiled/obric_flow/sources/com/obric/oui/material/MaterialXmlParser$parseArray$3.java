package com.obric.oui.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lorg/xmlpull/v1/XmlPullParser;", "parser", "", "Lcom/obric/oui/material/c;", "invoke", "(Lorg/xmlpull/v1/XmlPullParser;)[Lcom/obric/oui/material/c;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class MaterialXmlParser$parseArray$3 extends Lambda implements Function1<XmlPullParser, c[]> {
    public static final MaterialXmlParser$parseArray$3 INSTANCE = null;

    static {
        INSTANCE = new MaterialXmlParser$parseArray$3();
    }

    public MaterialXmlParser$parseArray$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ c[] invoke(XmlPullParser r5) {
        return invoke2(r5);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final c[] invoke2(XmlPullParser r5) {
        Intrinsics.checkNotNullParameter(r5, "parser");
        h r10 = h.f13658a;
        if (Intrinsics.areEqual(h.h(r5.getName()), "material_configs") == false) goto L6;
        return h.a(r5);
    L6:
        return new c[]{r10.p(r5)};
    }
}
