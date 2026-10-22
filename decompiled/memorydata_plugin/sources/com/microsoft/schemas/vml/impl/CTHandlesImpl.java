package com.microsoft.schemas.vml.impl;

import com.loc.o;
import com.microsoft.schemas.vml.f;
import com.microsoft.schemas.vml.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: classes3.dex */
public class CTHandlesImpl extends XmlComplexContentImpl implements g {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("urn:schemas-microsoft-com:vml", o.g)};
    }

    public CTHandlesImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public f addNewH() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        f r3 = (f) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public f getHArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        f r3 = (f) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public f[] getHArray() {
        return (f[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[0], new f[0]), f[].class, "com.obric.memorydata.plugin");
    }

    public List<f> getHList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$cXU1cl5VoZwp6RrVjVnNv7nSwk(this), new $$Lambda$MiaUmKMoRB1XFM2yaNp1ePTlbAA(this), new $$Lambda$wj_xSv0iIHkoFS_nZ0PletQoB_k(this), new $$Lambda$waC3PUxsik19JqjsG7KUN9t0ugw(this), new $$Lambda$gPBBwmibpGhi8y5qF4ElZAeIwa8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public f insertNewH(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        f r3 = (f) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeH(int r4) {
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

    public void setHArray(int r3, f r4) {
        generatedSetterHelperImpl((f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], r3, 2);
    }

    public void setHArray(f[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[0]);
    }

    public int sizeOfHArray() {
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
}
