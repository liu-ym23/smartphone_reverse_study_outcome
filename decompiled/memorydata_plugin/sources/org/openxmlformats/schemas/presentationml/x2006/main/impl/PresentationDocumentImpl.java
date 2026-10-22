package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.af;
import org.openxmlformats.schemas.presentationml.x2006.main.bh;

/* JADX INFO: loaded from: classes8.dex */
public class PresentationDocumentImpl extends XmlComplexContentImpl implements bh {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "presentation")};
    }

    public PresentationDocumentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public af addNewPresentation() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        af r3 = (af) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), af.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.bh
    public af getPresentation() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        af r3 = (af) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), af.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void setPresentation(af r4) {
        generatedSetterHelperImpl((af) ZeusTransformUtils.wrapperContextForParams(r4, af.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }
}
