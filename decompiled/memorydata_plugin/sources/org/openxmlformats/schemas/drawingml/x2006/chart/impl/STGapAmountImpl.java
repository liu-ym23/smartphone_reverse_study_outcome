package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.dd;
import org.openxmlformats.schemas.drawingml.x2006.chart.de;
import org.openxmlformats.schemas.drawingml.x2006.chart.df;

/* JADX INFO: loaded from: classes7.dex */
public class STGapAmountImpl extends XmlUnionImpl implements dd, de, df {
    private static final long serialVersionUID = 1;

    public STGapAmountImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STGapAmountImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
