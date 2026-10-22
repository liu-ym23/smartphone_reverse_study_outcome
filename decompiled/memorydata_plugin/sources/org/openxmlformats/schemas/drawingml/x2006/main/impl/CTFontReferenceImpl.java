package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.STFontCollectionIndex;
import org.openxmlformats.schemas.drawingml.x2006.main.ab;
import org.openxmlformats.schemas.drawingml.x2006.main.ap;
import org.openxmlformats.schemas.drawingml.x2006.main.ca;
import org.openxmlformats.schemas.drawingml.x2006.main.cf;
import org.openxmlformats.schemas.drawingml.x2006.main.cg;
import org.openxmlformats.schemas.drawingml.x2006.main.ci;
import org.openxmlformats.schemas.drawingml.x2006.main.cq;

/* JADX INFO: loaded from: classes8.dex */
public class CTFontReferenceImpl extends XmlComplexContentImpl implements ab {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "scrgbClr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "srgbClr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hslClr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "sysClr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "schemeClr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "prstClr"), new QName("", "idx")};
    }

    public CTFontReferenceImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public ap addNewHslClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ap r3 = (ap) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), ap.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ca addNewPrstClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ca r3 = (ca) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), ca.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ci addNewSchemeClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ci r3 = (ci) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), ci.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public cg addNewScrgbClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        cg r3 = (cg) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), cg.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public cf addNewSrgbClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        cf r3 = (cf) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), cf.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public cq addNewSysClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        cq r3 = (cq) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), cq.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ap getHslClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        ap r3 = (ap) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], 0), ap.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public STFontCollectionIndex.Enum getIdx() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[6]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        STFontCollectionIndex.Enum r4 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    L7:
        r4 = (STFontCollectionIndex.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STFontCollectionIndex.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public ca getPrstClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        ca r3 = (ca) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], 0), ca.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public ci getSchemeClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        ci r3 = (ci) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], 0), ci.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public cg getScrgbClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        cg r3 = (cg) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), cg.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public cf getSrgbClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        cf r3 = (cf) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], 0), cf.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public cq getSysClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        cq r3 = (cq) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], 0), cq.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isSetHslClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().count_elements(PROPERTY_QNAME[2]) == 0) goto L7;
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

    public boolean isSetPrstClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().count_elements(PROPERTY_QNAME[5]) == 0) goto L7;
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

    public boolean isSetSchemeClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().count_elements(PROPERTY_QNAME[4]) == 0) goto L7;
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

    public boolean isSetScrgbClr() {
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

    public boolean isSetSrgbClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        boolean r2 = true;
        if (get_store().count_elements(PROPERTY_QNAME[1]) != 0) goto L8;
        r2 = false;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean isSetSysClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().count_elements(PROPERTY_QNAME[3]) == 0) goto L7;
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

    public void setHslClr(ap r4) {
        generatedSetterHelperImpl((ap) ZeusTransformUtils.wrapperContextForParams(r4, ap.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], 0, 1);
    }

    public void setIdx(STFontCollectionIndex.Enum r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[6]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[6]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setEnumValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setPrstClr(ca r4) {
        generatedSetterHelperImpl((ca) ZeusTransformUtils.wrapperContextForParams(r4, ca.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[5], 0, 1);
    }

    public void setSchemeClr(ci r4) {
        generatedSetterHelperImpl((ci) ZeusTransformUtils.wrapperContextForParams(r4, ci.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[4], 0, 1);
    }

    public void setScrgbClr(cg r4) {
        generatedSetterHelperImpl((cg) ZeusTransformUtils.wrapperContextForParams(r4, cg.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }

    public void setSrgbClr(cf r4) {
        generatedSetterHelperImpl((cf) ZeusTransformUtils.wrapperContextForParams(r4, cf.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], 0, 1);
    }

    public void setSysClr(cq r4) {
        generatedSetterHelperImpl((cq) ZeusTransformUtils.wrapperContextForParams(r4, cq.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[3], 0, 1);
    }

    public void unsetHslClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[2], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetPrstClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[5], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetSchemeClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[4], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetScrgbClr() {
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

    public void unsetSrgbClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[1], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetSysClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[3], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public STFontCollectionIndex xgetIdx() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STFontCollectionIndex r3 = (STFontCollectionIndex) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[6]), STFontCollectionIndex.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetIdx(STFontCollectionIndex r7) {
        STFontCollectionIndex r8 = (STFontCollectionIndex) ZeusTransformUtils.wrapperContextForParams(r7, STFontCollectionIndex.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        STFontCollectionIndex r3 = (STFontCollectionIndex) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[6]), STFontCollectionIndex.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (STFontCollectionIndex) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[6]), STFontCollectionIndex.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
