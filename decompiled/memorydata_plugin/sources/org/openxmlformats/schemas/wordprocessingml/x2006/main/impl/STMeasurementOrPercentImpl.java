package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.n;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ga;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.gg;

/* JADX INFO: loaded from: classes8.dex */
public class STMeasurementOrPercentImpl extends XmlUnionImpl implements n, ga, gg {
    private static final long serialVersionUID = 1;

    public STMeasurementOrPercentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STMeasurementOrPercentImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
