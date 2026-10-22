package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlDateTime;

/* JADX INFO: loaded from: classes7.dex */
public class XmlDateTimeImpl extends JavaGDateHolderEx implements XmlDateTime {
    public XmlDateTimeImpl() {
        super(XmlDateTime.type, false);
    }

    public XmlDateTimeImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
