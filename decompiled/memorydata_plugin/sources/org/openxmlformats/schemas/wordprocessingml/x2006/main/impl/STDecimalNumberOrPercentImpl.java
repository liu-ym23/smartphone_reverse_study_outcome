package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.h;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ga;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.gp;

/* JADX INFO: loaded from: classes8.dex */
public class STDecimalNumberOrPercentImpl extends XmlUnionImpl implements h, ga, gp {
    private static final long serialVersionUID = 1;

    public STDecimalNumberOrPercentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STDecimalNumberOrPercentImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
