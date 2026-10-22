package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataRefs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataConsolidateFunction;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.at;

/* JADX INFO: loaded from: classes8.dex */
public class CTDataConsolidateImpl extends XmlComplexContentImpl implements at {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dataRefs"), new QName("", "function"), new QName("", "startLabels"), new QName("", "leftLabels"), new QName("", "topLabels"), new QName("", "link")};
    }

    public CTDataConsolidateImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public CTDataRefs addNewDataRefs() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTDataRefs r3 = (CTDataRefs) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), CTDataRefs.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTDataRefs getDataRefs() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        CTDataRefs r3 = (CTDataRefs) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), CTDataRefs.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public STDataConsolidateFunction.Enum getFunction() {
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
        STDataConsolidateFunction.Enum r6 = null;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r6;
    L9:
        r6 = (STDataConsolidateFunction.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STDataConsolidateFunction.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public boolean getLeftLabels() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L12
        TypeStore r1 = get_store();     // Catch: Throwable -> L12
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L12
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[3]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[3]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L7:
        if (r3 != null) goto L9;
        boolean r6 = false;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r6;
    L9:
        r6 = r3.getBooleanValue();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public boolean getLink() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L12
        TypeStore r1 = get_store();     // Catch: Throwable -> L12
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L12
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[5]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[5]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L7:
        if (r3 != null) goto L9;
        boolean r6 = false;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r6;
    L9:
        r6 = r3.getBooleanValue();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public boolean getStartLabels() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L12
        TypeStore r1 = get_store();     // Catch: Throwable -> L12
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L12
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[2]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[2]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L7:
        if (r3 != null) goto L9;
        boolean r6 = false;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r6;
    L9:
        r6 = r3.getBooleanValue();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public boolean getTopLabels() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L12
        TypeStore r1 = get_store();     // Catch: Throwable -> L12
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L12
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[4]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[4]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L7:
        if (r3 != null) goto L9;
        boolean r6 = false;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r6;
    L9:
        r6 = r3.getBooleanValue();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public boolean isSetDataRefs() {
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

    public boolean isSetFunction() {
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

    public boolean isSetLeftLabels() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().find_attribute_user(PROPERTY_QNAME[3]) == null) goto L7;
        boolean r3 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L7:
        r3 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean isSetLink() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().find_attribute_user(PROPERTY_QNAME[5]) == null) goto L7;
        boolean r3 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L7:
        r3 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean isSetStartLabels() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().find_attribute_user(PROPERTY_QNAME[2]) == null) goto L7;
        boolean r3 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L7:
        r3 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean isSetTopLabels() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().find_attribute_user(PROPERTY_QNAME[4]) == null) goto L7;
        boolean r3 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L7:
        r3 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public void setDataRefs(CTDataRefs r4) {
        generatedSetterHelperImpl((CTDataRefs) ZeusTransformUtils.wrapperContextForParams(r4, CTDataRefs.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }

    public void setFunction(STDataConsolidateFunction.Enum r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setEnumValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setLeftLabels(boolean r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[3]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[3]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setBooleanValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setLink(boolean r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[5]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[5]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setBooleanValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setStartLabels(boolean r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[2]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[2]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setBooleanValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setTopLabels(boolean r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[4]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[4]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setBooleanValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void unsetDataRefs() {
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

    public void unsetFunction() {
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

    public void unsetLeftLabels() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_attribute(PROPERTY_QNAME[3]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetLink() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_attribute(PROPERTY_QNAME[5]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetStartLabels() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_attribute(PROPERTY_QNAME[2]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetTopLabels() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_attribute(PROPERTY_QNAME[4]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public STDataConsolidateFunction xgetFunction() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        TypeStore r1 = get_store();     // Catch: Throwable -> L9
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L9
        STDataConsolidateFunction r3 = (STDataConsolidateFunction) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), STDataConsolidateFunction.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = (STDataConsolidateFunction) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[1]), STDataConsolidateFunction.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public XmlBoolean xgetLeftLabels() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        TypeStore r1 = get_store();     // Catch: Throwable -> L9
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L9
        XmlBoolean r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[3]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[3]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public XmlBoolean xgetLink() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        TypeStore r1 = get_store();     // Catch: Throwable -> L9
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L9
        XmlBoolean r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[5]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[5]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public XmlBoolean xgetStartLabels() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        TypeStore r1 = get_store();     // Catch: Throwable -> L9
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L9
        XmlBoolean r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[2]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[2]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public XmlBoolean xgetTopLabels() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        TypeStore r1 = get_store();     // Catch: Throwable -> L9
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L9
        XmlBoolean r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[4]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[4]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void xsetFunction(STDataConsolidateFunction r7) {
        STDataConsolidateFunction r8 = (STDataConsolidateFunction) ZeusTransformUtils.wrapperContextForParams(r7, STDataConsolidateFunction.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        STDataConsolidateFunction r3 = (STDataConsolidateFunction) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), STDataConsolidateFunction.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (STDataConsolidateFunction) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[1]), STDataConsolidateFunction.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void xsetLeftLabels(XmlBoolean r7) {
        XmlBoolean r8 = (XmlBoolean) ZeusTransformUtils.wrapperContextForParams(r7, XmlBoolean.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        XmlBoolean r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[3]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[3]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void xsetLink(XmlBoolean r7) {
        XmlBoolean r8 = (XmlBoolean) ZeusTransformUtils.wrapperContextForParams(r7, XmlBoolean.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        XmlBoolean r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[5]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[5]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void xsetStartLabels(XmlBoolean r7) {
        XmlBoolean r8 = (XmlBoolean) ZeusTransformUtils.wrapperContextForParams(r7, XmlBoolean.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        XmlBoolean r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[2]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[2]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void xsetTopLabels(XmlBoolean r7) {
        XmlBoolean r8 = (XmlBoolean) ZeusTransformUtils.wrapperContextForParams(r7, XmlBoolean.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        XmlBoolean r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[4]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[4]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
