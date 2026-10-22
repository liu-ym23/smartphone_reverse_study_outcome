package org.apache.xmlbeans.impl.xb.xmlconfig.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.xb.xmlconfig.Qnametargetlist;

/* JADX INFO: loaded from: classes7.dex */
public class QnametargetlistImpl extends XmlListImpl implements Qnametargetlist {
    private static final long serialVersionUID = 1;

    public QnametargetlistImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public QnametargetlistImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
