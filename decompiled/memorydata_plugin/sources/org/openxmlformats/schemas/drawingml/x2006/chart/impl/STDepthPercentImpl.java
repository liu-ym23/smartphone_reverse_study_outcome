package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.da;
import org.openxmlformats.schemas.drawingml.x2006.chart.db;
import org.openxmlformats.schemas.drawingml.x2006.chart.dc;

/* JADX INFO: loaded from: classes7.dex */
public class STDepthPercentImpl extends XmlUnionImpl implements da, db, dc {
    private static final long serialVersionUID = 1;

    public STDepthPercentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STDepthPercentImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
