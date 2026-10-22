package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.aa;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.af;

/* JADX INFO: loaded from: classes8.dex */
public class CTColsImpl extends XmlComplexContentImpl implements af {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "col")};
    }

    public CTColsImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.af
    public aa addNewCol() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        aa r3 = (aa) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), aa.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public aa getColArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        aa r3 = (aa) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), aa.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.af
    public aa[] getColArray() {
        return (aa[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[0], new aa[0]), aa[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.af
    public List<aa> getColList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$YTqEj_yzMhUrRU8MghfROEyjdoU(this), new $$Lambda$bYaeI43BUc7zIiwEs4oO4O4dyA(this), new $$Lambda$n9rB04bRIvr7cQX2J69rKwzIxZ8(this), new $$Lambda$0VpMLUmiHoL77uNjWg07t6hV3NE(this), new $$Lambda$W4XfXnlUCm0G6GEw4GtMpTqiI5M(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.af
    public aa insertNewCol(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        aa r3 = (aa) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), aa.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeCol(int r4) {
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

    public void setColArray(int r3, aa r4) {
        generatedSetterHelperImpl((aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], r3, 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.af
    public void setColArray(aa[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.af
    public int sizeOfColArray() {
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
