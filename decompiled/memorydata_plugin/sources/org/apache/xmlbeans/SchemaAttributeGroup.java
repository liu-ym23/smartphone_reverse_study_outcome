package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface SchemaAttributeGroup extends SchemaComponent {

    public static final class Ref extends SchemaComponent.Ref {
        public Ref(SchemaAttributeGroup r3) {
            super((SchemaAttributeGroup) ZeusTransformUtils.wrapperContextForParams(r3, SchemaAttributeGroup.class, "com.obric.memorydata.plugin"));
        }

        public Ref(SchemaTypeSystem r3, String r4) {
            super((SchemaTypeSystem) ZeusTransformUtils.wrapperContextForParams(r3, SchemaTypeSystem.class, "com.obric.memorydata.plugin"), r4);
        }
    }
}
