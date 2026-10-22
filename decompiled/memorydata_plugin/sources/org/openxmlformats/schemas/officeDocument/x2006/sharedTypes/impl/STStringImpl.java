package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.l;

/* JADX INFO: loaded from: classes8.dex */
public class STStringImpl extends JavaStringHolderEx implements l {
    private static final long serialVersionUID = 1;

    public STStringImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STStringImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
