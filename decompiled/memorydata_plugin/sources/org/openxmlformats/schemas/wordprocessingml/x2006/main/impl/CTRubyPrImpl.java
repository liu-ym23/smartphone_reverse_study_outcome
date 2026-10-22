package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ay;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bu;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.cy;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.da;

/* JADX INFO: loaded from: classes8.dex */
public class CTRubyPrImpl extends XmlComplexContentImpl implements da {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rubyAlign"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hps"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hpsRaise"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hpsBaseText"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lid"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dirty")};
    }

    public CTRubyPrImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public bu addNewDirty() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ay addNewHps() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ay r3 = (ay) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), ay.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ay addNewHpsBaseText() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ay r3 = (ay) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), ay.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ay addNewHpsRaise() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ay r3 = (ay) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), ay.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bd addNewLid() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bd r3 = (bd) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), bd.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public cy addNewRubyAlign() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        cy r3 = (cy) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), cy.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getDirty() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], 0), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public ay getHps() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        ay r3 = (ay) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], 0), ay.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public ay getHpsBaseText() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        ay r3 = (ay) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], 0), ay.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public ay getHpsRaise() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        ay r3 = (ay) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], 0), ay.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public bd getLid() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        bd r3 = (bd) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], 0), bd.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public cy getRubyAlign() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        cy r3 = (cy) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), cy.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isSetDirty() {
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

    public void setDirty(bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[5], 0, 1);
    }

    public void setHps(ay r4) {
        generatedSetterHelperImpl((ay) ZeusTransformUtils.wrapperContextForParams(r4, ay.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], 0, 1);
    }

    public void setHpsBaseText(ay r4) {
        generatedSetterHelperImpl((ay) ZeusTransformUtils.wrapperContextForParams(r4, ay.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[3], 0, 1);
    }

    public void setHpsRaise(ay r4) {
        generatedSetterHelperImpl((ay) ZeusTransformUtils.wrapperContextForParams(r4, ay.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], 0, 1);
    }

    public void setLid(bd r4) {
        generatedSetterHelperImpl((bd) ZeusTransformUtils.wrapperContextForParams(r4, bd.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[4], 0, 1);
    }

    public void setRubyAlign(cy r4) {
        generatedSetterHelperImpl((cy) ZeusTransformUtils.wrapperContextForParams(r4, cy.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }

    public void unsetDirty() {
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
}
