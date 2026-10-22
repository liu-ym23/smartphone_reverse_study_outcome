package com.obric.oui.material;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Lcom/obric/oui/material/MaterialConfig;", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "invoke", "(Lorg/xmlpull/v1/XmlPullParser;)[Lcom/obric/oui/material/MaterialConfig;"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class MaterialXmlParser$parseArray$1 extends Lambda implements Function1<XmlPullParser, c[]> {
    public static final MaterialXmlParser$parseArray$1 INSTANCE = null;

    static {
        INSTANCE = new MaterialXmlParser$parseArray$1();
    }

    MaterialXmlParser$parseArray$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ c[] invoke(XmlPullParser r3) {
        return invoke2((XmlPullParser) ZeusTransformUtils.preCheckCast(r3, XmlPullParser.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final c[] invoke2(XmlPullParser r3) {
        XmlPullParser r2 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "parser");
        MaterialXmlParser r4 = MaterialXmlParser.f13992a;
        String r0 = r2.getName();
        Intrinsics.checkNotNullExpressionValue(r0, "parser.name");
        if (Intrinsics.areEqual(MaterialXmlParser.a(r4, r0), "material_configs") == false) goto L6;
        return MaterialXmlParser.b(MaterialXmlParser.f13992a, r2);
    L6:
        return new c[]{MaterialXmlParser.a(MaterialXmlParser.f13992a, r2)};
    }
}
