package org.apache.xmlbeans.impl.xb.xmlconfig.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.xb.xmlconfig.Qnametargetenum;

/* JADX INFO: loaded from: classes7.dex */
public class QnametargetenumImpl extends JavaStringEnumerationHolderEx implements Qnametargetenum {
    private static final long serialVersionUID = 1;

    public QnametargetenumImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public QnametargetenumImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
