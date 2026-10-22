package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.eq;
import org.openxmlformats.schemas.drawingml.x2006.main.er;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.b;

/* JADX INFO: loaded from: classes8.dex */
public class STFixedPercentageImpl extends XmlUnionImpl implements eq, er, b {
    private static final long serialVersionUID = 1;

    public STFixedPercentageImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STFixedPercentageImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
