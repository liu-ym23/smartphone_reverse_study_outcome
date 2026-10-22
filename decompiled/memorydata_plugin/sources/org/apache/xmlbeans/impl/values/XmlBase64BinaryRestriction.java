package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;

/* JADX INFO: loaded from: classes7.dex */
public class XmlBase64BinaryRestriction extends JavaBase64HolderEx implements XmlBase64Binary {
    public XmlBase64BinaryRestriction(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
