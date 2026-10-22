package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAutonumberScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.dd;
import org.openxmlformats.schemas.drawingml.x2006.main.fh;

/* JADX INFO: loaded from: classes8.dex */
public class CTTextAutonumberBulletImpl extends XmlComplexContentImpl implements dd {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("", "type"), new QName("", "startAt")};
    }

    public CTTextAutonumberBulletImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.dd
    public int getStartAt() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L12
        TypeStore r1 = get_store();     // Catch: Throwable -> L12
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L12
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L7:
        if (r3 != null) goto L9;
        int r6 = 0;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r6;
    L9:
        r6 = r3.getIntValue();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.dd
    public STTextAutonumberScheme.Enum getType() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        STTextAutonumberScheme.Enum r4 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    L7:
        r4 = (STTextAutonumberScheme.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTextAutonumberScheme.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.dd
    public boolean isSetStartAt() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        boolean r2 = true;
        if (get_store().find_attribute_user(PROPERTY_QNAME[1]) != null) goto L8;
        r2 = false;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    public void setStartAt(int r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setIntValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setType(STTextAutonumberScheme.Enum r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setEnumValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void unsetStartAt() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_attribute(PROPERTY_QNAME[1]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public fh xgetStartAt() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        TypeStore r1 = get_store();     // Catch: Throwable -> L9
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L9
        fh r3 = (fh) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), fh.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = (fh) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[1]), fh.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public STTextAutonumberScheme xgetType() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTextAutonumberScheme r3 = (STTextAutonumberScheme) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[0]), STTextAutonumberScheme.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetStartAt(fh r7) {
        fh r8 = (fh) ZeusTransformUtils.wrapperContextForParams(r7, fh.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        fh r3 = (fh) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), fh.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (fh) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[1]), fh.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void xsetType(STTextAutonumberScheme r7) {
        STTextAutonumberScheme r8 = (STTextAutonumberScheme) ZeusTransformUtils.wrapperContextForParams(r7, STTextAutonumberScheme.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        STTextAutonumberScheme r3 = (STTextAutonumberScheme) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), STTextAutonumberScheme.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (STTextAutonumberScheme) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[0]), STTextAutonumberScheme.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
