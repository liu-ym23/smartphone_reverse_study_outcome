package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.gl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.gm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.gn;

/* JADX INFO: loaded from: classes8.dex */
public class STTextScaleImpl extends XmlUnionImpl implements gl, gm, gn {
    private static final long serialVersionUID = 1;

    public STTextScaleImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STTextScaleImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
