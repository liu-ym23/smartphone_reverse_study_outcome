package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.fi;
import org.openxmlformats.schemas.drawingml.x2006.main.fj;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.h;

/* JADX INFO: loaded from: classes8.dex */
public class STTextFontScalePercentOrPercentStringImpl extends XmlUnionImpl implements fi, fj, h {
    private static final long serialVersionUID = 1;

    public STTextFontScalePercentOrPercentStringImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STTextFontScalePercentOrPercentStringImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
