package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.k;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.m;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.o;

/* JADX INFO: loaded from: classes8.dex */
public class STTwipsMeasureImpl extends XmlUnionImpl implements k, m, o {
    private static final long serialVersionUID = 1;

    public STTwipsMeasureImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STTwipsMeasureImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
