package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.RealGroup;

/* JADX INFO: loaded from: classes7.dex */
public class RealGroupImpl extends GroupImpl implements RealGroup {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://www.w3.org/2001/XMLSchema", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL), new QName("http://www.w3.org/2001/XMLSchema", "choice"), new QName("http://www.w3.org/2001/XMLSchema", "sequence")};
    }

    public RealGroupImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public All addNewAll() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        All r3 = (All) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), All.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public ExplicitGroup addNewChoice() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ExplicitGroup r3 = (ExplicitGroup) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), ExplicitGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public ExplicitGroup addNewSequence() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ExplicitGroup r3 = (ExplicitGroup) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), ExplicitGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public All getAllArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        All r3 = (All) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), All.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public All[] getAllArray() {
        return (All[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[0], new All[0]), All[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public List<All> getAllList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$I_oyzY3HmuX_YGnRAuBPjVXK9p8(this), new $$Lambda$VTyzyj5fI3pAcj_8oy8XHDTyO5s(this), new $$Lambda$uuB7aK6L7OUNHe15H_eVh3pQYN8(this), new $$Lambda$GKEwDWf1ciZA47rqq2e1ri2md5k(this), new $$Lambda$V9srlpaHMdDmtDUGlCt4QLsz2WM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public ExplicitGroup getChoiceArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        ExplicitGroup r3 = (ExplicitGroup) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), ExplicitGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public ExplicitGroup[] getChoiceArray() {
        return (ExplicitGroup[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[1], new ExplicitGroup[0]), ExplicitGroup[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public List<ExplicitGroup> getChoiceList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$H_tPPaAZYOBrRmVrn6Rb3PYVzw(this), new $$Lambda$qGE5k6meYVyYOkWYaDyP_oqoqM(this), new $$Lambda$LVX69b0XYYu50tIODUhWvMxquk(this), new $$Lambda$GuW3q5BO4g9zuK1Pvk6jNi91rE(this), new $$Lambda$UnGvZ302BtZ19LJ_7bfW00tiLds(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public ExplicitGroup getSequenceArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        ExplicitGroup r3 = (ExplicitGroup) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), ExplicitGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public ExplicitGroup[] getSequenceArray() {
        return (ExplicitGroup[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[2], new ExplicitGroup[0]), ExplicitGroup[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public List<ExplicitGroup> getSequenceList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Ibn9peaeO63Lc_PXUojVvkNIsRk(this), new $$Lambda$XYJ3sK5VXnWU7TFR9MpTWny7atI(this), new $$Lambda$ZZTNrgYPZ8kbJcwV3Tbbt6ii5k(this), new $$Lambda$lK5WcbWelRmJ91BNcFohwmJZHtA(this), new $$Lambda$Sw2Xk21SEIO6_SDPoTfC2sTf0ZY(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public All insertNewAll(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        All r3 = (All) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), All.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public ExplicitGroup insertNewChoice(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ExplicitGroup r3 = (ExplicitGroup) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[1], r4), ExplicitGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public ExplicitGroup insertNewSequence(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ExplicitGroup r3 = (ExplicitGroup) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[2], r4), ExplicitGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public void removeAll(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[0], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public void removeChoice(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[1], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public void removeSequence(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[2], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public void setAllArray(int r3, All r4) {
        generatedSetterHelperImpl((All) ZeusTransformUtils.wrapperContextForParams(r4, All.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], r3, 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public void setAllArray(All[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public void setChoiceArray(int r3, ExplicitGroup r4) {
        generatedSetterHelperImpl((ExplicitGroup) ZeusTransformUtils.wrapperContextForParams(r4, ExplicitGroup.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], r3, 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public void setChoiceArray(ExplicitGroup[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[1]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public void setSequenceArray(int r3, ExplicitGroup r4) {
        generatedSetterHelperImpl((ExplicitGroup) ZeusTransformUtils.wrapperContextForParams(r4, ExplicitGroup.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], r3, 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public void setSequenceArray(ExplicitGroup[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[2]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public int sizeOfAllArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[0]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public int sizeOfChoiceArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[1]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl
    public int sizeOfSequenceArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[2]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }
}
