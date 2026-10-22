package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.ej;
import org.openxmlformats.schemas.drawingml.x2006.main.el;
import org.openxmlformats.schemas.drawingml.x2006.main.et;

/* JADX INFO: loaded from: classes8.dex */
public class STAdjCoordinateImpl extends XmlUnionImpl implements ej, el, et {
    private static final long serialVersionUID = 1;

    public STAdjCoordinateImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STAdjCoordinateImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
