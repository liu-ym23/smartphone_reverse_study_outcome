package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlDate;

/* JADX INFO: loaded from: classes7.dex */
public class XmlDateImpl extends JavaGDateHolderEx implements XmlDate {
    public XmlDateImpl() {
        super(XmlDate.type, false);
    }

    public XmlDateImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
