package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.openxmlformats.schemas.drawingml.x2006.chart.STRadarStyle;

/* JADX INFO: loaded from: classes7.dex */
public class STRadarStyleImpl extends JavaStringEnumerationHolderEx implements STRadarStyle {
    private static final long serialVersionUID = 1;

    public STRadarStyleImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STRadarStyleImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
