package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlUnsignedInt;

/* JADX INFO: loaded from: classes7.dex */
public class XmlUnsignedIntImpl extends JavaLongHolderEx implements XmlUnsignedInt {
    public XmlUnsignedIntImpl() {
        super(XmlUnsignedInt.type, false);
    }

    public XmlUnsignedIntImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
