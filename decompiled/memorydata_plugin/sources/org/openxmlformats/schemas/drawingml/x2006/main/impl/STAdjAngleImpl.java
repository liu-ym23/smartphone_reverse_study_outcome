package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.ei;
import org.openxmlformats.schemas.drawingml.x2006.main.ek;
import org.openxmlformats.schemas.drawingml.x2006.main.et;

/* JADX INFO: loaded from: classes8.dex */
public class STAdjAngleImpl extends XmlUnionImpl implements ei, ek, et {
    private static final long serialVersionUID = 1;

    public STAdjAngleImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STAdjAngleImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
