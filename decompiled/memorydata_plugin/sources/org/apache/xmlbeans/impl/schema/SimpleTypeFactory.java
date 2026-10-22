package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaTypeSystem;

/* JADX INFO: loaded from: classes7.dex */
public class SimpleTypeFactory<T> extends ElementFactory<T> {
    public SimpleTypeFactory(SchemaTypeSystem r3, String r4) {
        super((SchemaTypeSystem) ZeusTransformUtils.wrapperContextForParams(r3, SchemaTypeSystem.class, "com.obric.memorydata.plugin"), r4);
    }
}
