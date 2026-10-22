package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlUnsignedLong;

/* JADX INFO: loaded from: classes7.dex */
public class XmlUnsignedLongImpl extends JavaIntegerHolderEx implements XmlUnsignedLong {
    public XmlUnsignedLongImpl() {
        super(XmlUnsignedLong.type, false);
    }

    public XmlUnsignedLongImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
