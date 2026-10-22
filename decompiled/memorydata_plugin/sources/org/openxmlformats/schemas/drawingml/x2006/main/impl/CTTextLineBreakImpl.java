package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.dn;
import org.openxmlformats.schemas.drawingml.x2006.main.dq;

/* JADX INFO: loaded from: classes8.dex */
public class CTTextLineBreakImpl extends XmlComplexContentImpl implements dq {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "rPr")};
    }

    public CTTextLineBreakImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public dn addNewRPr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        dn r3 = (dn) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), dn.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.dq
    public dn getRPr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        dn r3 = (dn) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), dn.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isSetRPr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        boolean r2 = false;
        if (get_store().count_elements(PROPERTY_QNAME[0]) == 0) goto L7;
        r2 = true;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public void setRPr(dn r4) {
        generatedSetterHelperImpl((dn) ZeusTransformUtils.wrapperContextForParams(r4, dn.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }

    public void unsetRPr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[0], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
