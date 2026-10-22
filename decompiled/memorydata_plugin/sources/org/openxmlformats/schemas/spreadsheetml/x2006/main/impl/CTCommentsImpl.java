package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.a;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ah;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ai;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bf;

/* JADX INFO: loaded from: classes8.dex */
public class CTCommentsImpl extends XmlComplexContentImpl implements ai {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "authors"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "commentList"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst")};
    }

    public CTCommentsImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.ai
    public a addNewAuthors() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        a r3 = (a) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.ai
    public ah addNewCommentList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ah r3 = (ah) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), ah.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bf addNewExtLst() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bf r3 = (bf) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), bf.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public a getAuthors() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        a r3 = (a) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.ai
    public ah getCommentList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        ah r3 = (ah) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], 0), ah.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public bf getExtLst() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        bf r3 = (bf) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], 0), bf.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isSetExtLst() {
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

    public void setAuthors(a r4) {
        generatedSetterHelperImpl((a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }

    public void setCommentList(ah r4) {
        generatedSetterHelperImpl((ah) ZeusTransformUtils.wrapperContextForParams(r4, ah.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], 0, 1);
    }

    public void setExtLst(bf r4) {
        generatedSetterHelperImpl((bf) ZeusTransformUtils.wrapperContextForParams(r4, bf.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], 0, 1);
    }

    public void unsetExtLst() {
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
}
