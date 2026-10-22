package org.openxmlformats.schemas.drawingml.x2006.diagram.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.diagram.a;

/* JADX INFO: loaded from: classes7.dex */
public class CTRelIdsImpl extends XmlComplexContentImpl implements a {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "dm"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "lo"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "qs"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "cs")};
    }

    public CTRelIdsImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public String getCs() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[3]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        String r4 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    L7:
        r4 = r3.getStringValue();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.diagram.a
    public String getDm() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        String r4 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    L7:
        r4 = r3.getStringValue();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public String getLo() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        String r4 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    L7:
        r4 = r3.getStringValue();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public String getQs() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[2]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        String r4 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    L7:
        r4 = r3.getStringValue();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void setCs(String r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[3]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[3]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setStringValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setDm(String r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setStringValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setLo(String r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setStringValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setQs(String r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[2]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[2]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setStringValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public org.openxmlformats.schemas.officeDocument.x2006.relationships.a xgetCs() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        org.openxmlformats.schemas.officeDocument.x2006.relationships.a r3 = (org.openxmlformats.schemas.officeDocument.x2006.relationships.a) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[3]), org.openxmlformats.schemas.officeDocument.x2006.relationships.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public org.openxmlformats.schemas.officeDocument.x2006.relationships.a xgetDm() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        org.openxmlformats.schemas.officeDocument.x2006.relationships.a r3 = (org.openxmlformats.schemas.officeDocument.x2006.relationships.a) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[0]), org.openxmlformats.schemas.officeDocument.x2006.relationships.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public org.openxmlformats.schemas.officeDocument.x2006.relationships.a xgetLo() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        org.openxmlformats.schemas.officeDocument.x2006.relationships.a r3 = (org.openxmlformats.schemas.officeDocument.x2006.relationships.a) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[1]), org.openxmlformats.schemas.officeDocument.x2006.relationships.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public org.openxmlformats.schemas.officeDocument.x2006.relationships.a xgetQs() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        org.openxmlformats.schemas.officeDocument.x2006.relationships.a r3 = (org.openxmlformats.schemas.officeDocument.x2006.relationships.a) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[2]), org.openxmlformats.schemas.officeDocument.x2006.relationships.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetCs(org.openxmlformats.schemas.officeDocument.x2006.relationships.a r7) {
        org.openxmlformats.schemas.officeDocument.x2006.relationships.a r8 = (org.openxmlformats.schemas.officeDocument.x2006.relationships.a) ZeusTransformUtils.wrapperContextForParams(r7, org.openxmlformats.schemas.officeDocument.x2006.relationships.a.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        org.openxmlformats.schemas.officeDocument.x2006.relationships.a r3 = (org.openxmlformats.schemas.officeDocument.x2006.relationships.a) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[3]), org.openxmlformats.schemas.officeDocument.x2006.relationships.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (org.openxmlformats.schemas.officeDocument.x2006.relationships.a) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[3]), org.openxmlformats.schemas.officeDocument.x2006.relationships.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void xsetDm(org.openxmlformats.schemas.officeDocument.x2006.relationships.a r7) {
        org.openxmlformats.schemas.officeDocument.x2006.relationships.a r8 = (org.openxmlformats.schemas.officeDocument.x2006.relationships.a) ZeusTransformUtils.wrapperContextForParams(r7, org.openxmlformats.schemas.officeDocument.x2006.relationships.a.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        org.openxmlformats.schemas.officeDocument.x2006.relationships.a r3 = (org.openxmlformats.schemas.officeDocument.x2006.relationships.a) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), org.openxmlformats.schemas.officeDocument.x2006.relationships.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (org.openxmlformats.schemas.officeDocument.x2006.relationships.a) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[0]), org.openxmlformats.schemas.officeDocument.x2006.relationships.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void xsetLo(org.openxmlformats.schemas.officeDocument.x2006.relationships.a r7) {
        org.openxmlformats.schemas.officeDocument.x2006.relationships.a r8 = (org.openxmlformats.schemas.officeDocument.x2006.relationships.a) ZeusTransformUtils.wrapperContextForParams(r7, org.openxmlformats.schemas.officeDocument.x2006.relationships.a.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        org.openxmlformats.schemas.officeDocument.x2006.relationships.a r3 = (org.openxmlformats.schemas.officeDocument.x2006.relationships.a) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), org.openxmlformats.schemas.officeDocument.x2006.relationships.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (org.openxmlformats.schemas.officeDocument.x2006.relationships.a) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[1]), org.openxmlformats.schemas.officeDocument.x2006.relationships.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void xsetQs(org.openxmlformats.schemas.officeDocument.x2006.relationships.a r7) {
        org.openxmlformats.schemas.officeDocument.x2006.relationships.a r8 = (org.openxmlformats.schemas.officeDocument.x2006.relationships.a) ZeusTransformUtils.wrapperContextForParams(r7, org.openxmlformats.schemas.officeDocument.x2006.relationships.a.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        org.openxmlformats.schemas.officeDocument.x2006.relationships.a r3 = (org.openxmlformats.schemas.officeDocument.x2006.relationships.a) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[2]), org.openxmlformats.schemas.officeDocument.x2006.relationships.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (org.openxmlformats.schemas.officeDocument.x2006.relationships.a) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[2]), org.openxmlformats.schemas.officeDocument.x2006.relationships.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
