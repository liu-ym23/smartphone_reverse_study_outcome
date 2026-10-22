package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.STScatterStyle;
import org.openxmlformats.schemas.drawingml.x2006.chart.ce;

/* JADX INFO: loaded from: classes7.dex */
public class CTScatterStyleImpl extends XmlComplexContentImpl implements ce {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("", "val")};
    }

    public CTScatterStyleImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public STScatterStyle.Enum getVal() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L12
        TypeStore r1 = get_store();     // Catch: Throwable -> L12
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L12
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L7:
        if (r3 != null) goto L9;
        STScatterStyle.Enum r6 = null;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r6;
    L9:
        r6 = (STScatterStyle.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STScatterStyle.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public boolean isSetVal() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        boolean r2 = false;
        if (get_store().find_attribute_user(PROPERTY_QNAME[0]) == null) goto L7;
        r2 = true;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public void setVal(STScatterStyle.Enum r7) {
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

    public void unsetVal() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_attribute(PROPERTY_QNAME[0]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public STScatterStyle xgetVal() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        TypeStore r1 = get_store();     // Catch: Throwable -> L9
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L9
        STScatterStyle r3 = (STScatterStyle) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), STScatterStyle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = (STScatterStyle) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[0]), STScatterStyle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void xsetVal(STScatterStyle r7) {
        STScatterStyle r8 = (STScatterStyle) ZeusTransformUtils.wrapperContextForParams(r7, STScatterStyle.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        STScatterStyle r3 = (STScatterStyle) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), STScatterStyle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (STScatterStyle) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[0]), STScatterStyle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
