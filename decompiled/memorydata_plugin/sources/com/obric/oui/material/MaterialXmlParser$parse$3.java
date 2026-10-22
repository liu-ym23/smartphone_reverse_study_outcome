package com.obric.oui.material;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/oui/material/MaterialConfig;", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class MaterialXmlParser$parse$3 extends Lambda implements Function1<XmlPullParser, c> {
    public static final MaterialXmlParser$parse$3 INSTANCE = null;

    static {
        INSTANCE = new MaterialXmlParser$parse$3();
    }

    MaterialXmlParser$parse$3() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final c invoke2(XmlPullParser r2) {
        XmlPullParser r1 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r2, XmlPullParser.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "parser");
        return MaterialXmlParser.a(MaterialXmlParser.f13992a, r1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ c invoke(XmlPullParser r3) {
        return invoke2((XmlPullParser) ZeusTransformUtils.preCheckCast(r3, XmlPullParser.class, "com.obric.memorydata.plugin"));
    }
}
