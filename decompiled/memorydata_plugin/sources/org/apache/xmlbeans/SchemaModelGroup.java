package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface SchemaModelGroup extends SchemaComponent {

    public static final class Ref extends SchemaComponent.Ref {
        public Ref(SchemaModelGroup r3) {
            super((SchemaModelGroup) ZeusTransformUtils.wrapperContextForParams(r3, SchemaModelGroup.class, "com.obric.memorydata.plugin"));
        }

        public Ref(SchemaTypeSystem r3, String r4) {
            super((SchemaTypeSystem) ZeusTransformUtils.wrapperContextForParams(r3, SchemaTypeSystem.class, "com.obric.memorydata.plugin"), r4);
        }
    }
}
