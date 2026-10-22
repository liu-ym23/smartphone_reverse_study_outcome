package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlShort;

/* JADX INFO: loaded from: classes7.dex */
public class XmlShortImpl extends JavaIntHolderEx implements XmlShort {
    public XmlShortImpl() {
        super(XmlShort.type, false);
    }

    public XmlShortImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
