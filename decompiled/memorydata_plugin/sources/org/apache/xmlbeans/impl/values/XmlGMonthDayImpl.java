package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlGMonthDay;

/* JADX INFO: loaded from: classes7.dex */
public class XmlGMonthDayImpl extends JavaGDateHolderEx implements XmlGMonthDay {
    public XmlGMonthDayImpl() {
        super(XmlGMonthDay.type, false);
    }

    public XmlGMonthDayImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
