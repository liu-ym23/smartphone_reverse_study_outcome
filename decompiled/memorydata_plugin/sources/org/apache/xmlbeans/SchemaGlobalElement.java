package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface SchemaGlobalElement extends SchemaComponent, SchemaLocalElement {

    public static final class Ref extends SchemaComponent.Ref {
        public Ref(SchemaGlobalElement r3) {
            super((SchemaGlobalElement) ZeusTransformUtils.wrapperContextForParams(r3, SchemaGlobalElement.class, "com.obric.memorydata.plugin"));
        }

        public Ref(SchemaTypeSystem r3, String r4) {
            super((SchemaTypeSystem) ZeusTransformUtils.wrapperContextForParams(r3, SchemaTypeSystem.class, "com.obric.memorydata.plugin"), r4);
        }

        public final SchemaGlobalElement get() {
            return (SchemaGlobalElement) ZeusTransformUtils.preCheckCast(getComponent(), SchemaGlobalElement.class, "com.obric.memorydata.plugin");
        }
    }
}
