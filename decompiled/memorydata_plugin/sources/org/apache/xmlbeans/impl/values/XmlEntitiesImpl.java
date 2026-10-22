package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlENTITIES;

/* JADX INFO: loaded from: classes7.dex */
public class XmlEntitiesImpl extends XmlListImpl implements XmlENTITIES {
    public XmlEntitiesImpl() {
        super(XmlENTITIES.type, false);
    }

    public XmlEntitiesImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
