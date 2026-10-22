package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.dg;
import org.openxmlformats.schemas.drawingml.x2006.chart.dh;
import org.openxmlformats.schemas.drawingml.x2006.chart.di;

/* JADX INFO: loaded from: classes7.dex */
public class STHPercentImpl extends XmlUnionImpl implements dg, dh, di {
    private static final long serialVersionUID = 1;

    public STHPercentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STHPercentImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
