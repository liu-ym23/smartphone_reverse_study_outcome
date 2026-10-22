package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: loaded from: classes7.dex */
public class XmlAnyTypeImpl extends XmlComplexContentImpl implements XmlObject {
    public XmlAnyTypeImpl() {
        super(type);
    }

    public XmlAnyTypeImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }
}
