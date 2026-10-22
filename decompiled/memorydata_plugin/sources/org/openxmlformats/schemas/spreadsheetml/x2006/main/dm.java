package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface dm extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<dm> f19591a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19592b = null;

    static {
        DocumentFactory<dm> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctpivotcachedefinition575ctype");
        f19591a = r0;
        f19592b = r0.getType();
    }

    void setCreatedVersion(short r1);

    void setMinRefreshableVersion(short r1);

    void setRefreshOnLoad(boolean r1);

    void setRefreshedBy(String r1);

    void setRefreshedDate(double r1);

    void setRefreshedVersion(short r1);
}
