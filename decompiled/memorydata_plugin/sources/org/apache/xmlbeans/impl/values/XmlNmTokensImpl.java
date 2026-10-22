package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNMTOKENS;

/* JADX INFO: loaded from: classes7.dex */
public class XmlNmTokensImpl extends XmlListImpl implements XmlNMTOKENS {
    public XmlNmTokensImpl() {
        super(XmlNMTOKENS.type, false);
    }

    public XmlNmTokensImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
