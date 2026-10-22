package com.obric.oui.material;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"com/obric/oui/material/MaterialXmlParser$MaterialState", "", "Lcom/obric/oui/material/MaterialXmlParser$MaterialState;", "", "xmlName", "Ljava/lang/String;", "getXmlName", "()Ljava/lang/String;", "nodeName", "getNodeName", "NORMAL", "PRESS", "HOVER", "CHECKED", "SELECTED", "DISABLE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
final enum MaterialXmlParser$MaterialState extends Enum<MaterialXmlParser$MaterialState> {
    public static final MaterialXmlParser$MaterialState CHECKED = null;
    public static final MaterialXmlParser$MaterialState DISABLE = null;
    public static final MaterialXmlParser$MaterialState HOVER = null;
    public static final MaterialXmlParser$MaterialState NORMAL = null;
    public static final MaterialXmlParser$MaterialState PRESS = null;
    public static final MaterialXmlParser$MaterialState SELECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MaterialXmlParser$MaterialState[] f13605a = null;
    private final String nodeName;
    private final String xmlName;

    static {
        MaterialXmlParser$MaterialState r10 = new MaterialXmlParser$MaterialState("NORMAL", 0, "normal", null, 2, null);
        NORMAL = r10;
        MaterialXmlParser$MaterialState r5 = new MaterialXmlParser$MaterialState("PRESS", 1, "press", null, 2, null);
        PRESS = r5;
        MaterialXmlParser$MaterialState r11 = new MaterialXmlParser$MaterialState("HOVER", 2, "hover", null, 2, null);
        HOVER = r11;
        MaterialXmlParser$MaterialState r12 = new MaterialXmlParser$MaterialState("CHECKED", 3, "checked", null, 2, null);
        CHECKED = r12;
        MaterialXmlParser$MaterialState r13 = new MaterialXmlParser$MaterialState("SELECTED", 4, "selected", null, 2, null);
        SELECTED = r13;
        MaterialXmlParser$MaterialState r14 = new MaterialXmlParser$MaterialState("DISABLE", 5, "disable", null, 2, null);
        DISABLE = r14;
        f13605a = new MaterialXmlParser$MaterialState[]{r10, r5, r11, r12, r13, r14};
    }

    public MaterialXmlParser$MaterialState(String r5, int r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = r11;
    L5:
        super(r5, r10);
        this.xmlName = r11;
        this.nodeName = r12;
    }

    public static MaterialXmlParser$MaterialState valueOf(String r5) {
        return (MaterialXmlParser$MaterialState) Enum.valueOf(MaterialXmlParser$MaterialState.class, r5);
    }

    public static MaterialXmlParser$MaterialState[] values() {
        return (MaterialXmlParser$MaterialState[]) f13605a.clone();
    }

    public final String getNodeName() {
        return this.nodeName;
    }

    public final String getXmlName() {
        return this.xmlName;
    }
}
