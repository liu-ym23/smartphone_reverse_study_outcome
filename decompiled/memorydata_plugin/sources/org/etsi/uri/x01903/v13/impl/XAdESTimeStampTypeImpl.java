package org.etsi.uri.x01903.v13.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.etsi.uri.x01903.v13.ak;

/* JADX INFO: loaded from: classes7.dex */
public class XAdESTimeStampTypeImpl extends GenericTimeStampTypeImpl implements ak {
    private static final long serialVersionUID = 1;

    public XAdESTimeStampTypeImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }
}
