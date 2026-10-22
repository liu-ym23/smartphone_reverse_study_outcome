package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.dj;
import org.openxmlformats.schemas.drawingml.x2006.chart.dk;
import org.openxmlformats.schemas.drawingml.x2006.chart.dl;

/* JADX INFO: loaded from: classes7.dex */
public class STHoleSizeImpl extends XmlUnionImpl implements dj, dk, dl {
    private static final long serialVersionUID = 1;

    public STHoleSizeImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STHoleSizeImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
