package com.microsoft.schemas.vml;

import com.microsoft.schemas.office.office.STConnectType;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalse;

/* JADX INFO: loaded from: classes3.dex */
public interface k extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<k> f5795a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5796b = null;

    static {
        DocumentFactory<k> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctpath5963type");
        f5795a = r0;
        f5796b = r0.getType();
    }

    void setConnecttype(STConnectType.Enum r1);

    void setGradientshapeok(STTrueFalse.Enum r1);
}
