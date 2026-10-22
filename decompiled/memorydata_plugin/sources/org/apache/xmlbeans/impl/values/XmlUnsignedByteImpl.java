package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlUnsignedByte;

/* JADX INFO: loaded from: classes7.dex */
public class XmlUnsignedByteImpl extends JavaIntHolderEx implements XmlUnsignedByte {
    public XmlUnsignedByteImpl() {
        super(XmlUnsignedByte.type, false);
    }

    public XmlUnsignedByteImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
