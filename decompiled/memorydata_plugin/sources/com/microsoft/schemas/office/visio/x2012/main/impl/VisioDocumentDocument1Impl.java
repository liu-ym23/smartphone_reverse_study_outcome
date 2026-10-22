package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.y;
import com.microsoft.schemas.office.visio.x2012.main.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: classes3.dex */
public class VisioDocumentDocument1Impl extends XmlComplexContentImpl implements y {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.microsoft.com/office/visio/2012/main", "VisioDocument")};
    }

    public VisioDocumentDocument1Impl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public z addNewVisioDocument() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        z r3 = (z) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public z getVisioDocument() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        z r3 = (z) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void setVisioDocument(z r4) {
        generatedSetterHelperImpl((z) ZeusTransformUtils.wrapperContextForParams(r4, z.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }
}
