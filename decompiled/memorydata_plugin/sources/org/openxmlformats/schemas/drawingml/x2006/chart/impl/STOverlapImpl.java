package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.Cdo;
import org.openxmlformats.schemas.drawingml.x2006.chart.dn;
import org.openxmlformats.schemas.drawingml.x2006.chart.dp;

/* JADX INFO: loaded from: classes7.dex */
public class STOverlapImpl extends XmlUnionImpl implements dn, Cdo, dp {
    private static final long serialVersionUID = 1;

    public STOverlapImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STOverlapImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
