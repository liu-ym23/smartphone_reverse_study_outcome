package org.apache.poi.schemas.vmldrawing.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.vmldrawing.CTXML;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: classes7.dex */
public class CTXMLImpl extends XmlComplexContentImpl implements CTXML {
    private static final long serialVersionUID = 1;

    public CTXMLImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }
}
