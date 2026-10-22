package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlENTITY;

/* JADX INFO: loaded from: classes7.dex */
public class XmlEntityImpl extends JavaStringHolderEx implements XmlENTITY {
    public XmlEntityImpl() {
        super(XmlENTITY.type, false);
    }

    public XmlEntityImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
