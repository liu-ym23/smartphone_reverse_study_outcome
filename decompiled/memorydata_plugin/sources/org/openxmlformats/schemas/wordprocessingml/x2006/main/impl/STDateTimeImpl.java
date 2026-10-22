package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaGDateHolderEx;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.fy;

/* JADX INFO: loaded from: classes8.dex */
public class STDateTimeImpl extends JavaGDateHolderEx implements fy {
    private static final long serialVersionUID = 1;

    public STDateTimeImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STDateTimeImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
