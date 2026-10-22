package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.dq;
import org.openxmlformats.schemas.drawingml.x2006.chart.dr;
import org.openxmlformats.schemas.drawingml.x2006.chart.ds;

/* JADX INFO: loaded from: classes7.dex */
public class STSecondPieSizeImpl extends XmlUnionImpl implements dq, dr, ds {
    private static final long serialVersionUID = 1;

    public STSecondPieSizeImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STSecondPieSizeImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
