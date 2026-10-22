package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.er;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.gp;

/* JADX INFO: loaded from: classes8.dex */
public class SingleXmlCellsDocumentImpl extends XmlComplexContentImpl implements gp {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "singleXmlCells")};
    }

    public SingleXmlCellsDocumentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public er addNewSingleXmlCells() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        er r3 = (er) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), er.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.gp
    public er getSingleXmlCells() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        er r3 = (er) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), er.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.gp
    public void setSingleXmlCells(er r4) {
        generatedSetterHelperImpl((er) ZeusTransformUtils.wrapperContextForParams(r4, er.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }
}
