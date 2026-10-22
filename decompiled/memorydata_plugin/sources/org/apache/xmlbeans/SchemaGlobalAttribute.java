package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface SchemaGlobalAttribute extends SchemaComponent, SchemaLocalAttribute {

    public static final class Ref extends SchemaComponent.Ref {
        public Ref(SchemaGlobalAttribute r3) {
            super((SchemaGlobalAttribute) ZeusTransformUtils.wrapperContextForParams(r3, SchemaGlobalAttribute.class, "com.obric.memorydata.plugin"));
        }

        public Ref(SchemaTypeSystem r3, String r4) {
            super((SchemaTypeSystem) ZeusTransformUtils.wrapperContextForParams(r3, SchemaTypeSystem.class, "com.obric.memorydata.plugin"), r4);
        }

        public final SchemaGlobalAttribute get() {
            return (SchemaGlobalAttribute) ZeusTransformUtils.preCheckCast(getComponent(), SchemaGlobalAttribute.class, "com.obric.memorydata.plugin");
        }
    }
}
