package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlGYearMonth;

/* JADX INFO: loaded from: classes7.dex */
public class XmlGYearMonthImpl extends JavaGDateHolderEx implements XmlGYearMonth {
    public XmlGYearMonthImpl() {
        super(XmlGYearMonth.type, false);
    }

    public XmlGYearMonthImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
