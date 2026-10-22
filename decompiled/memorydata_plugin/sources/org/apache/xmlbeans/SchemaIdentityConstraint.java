package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface SchemaIdentityConstraint extends SchemaComponent {

    public static final class Ref extends SchemaComponent.Ref {
        public Ref(SchemaIdentityConstraint r3) {
            super((SchemaIdentityConstraint) ZeusTransformUtils.wrapperContextForParams(r3, SchemaIdentityConstraint.class, "com.obric.memorydata.plugin"));
        }

        public Ref(SchemaTypeSystem r3, String r4) {
            super((SchemaTypeSystem) ZeusTransformUtils.wrapperContextForParams(r3, SchemaTypeSystem.class, "com.obric.memorydata.plugin"), r4);
        }

        public final SchemaIdentityConstraint get() {
            return (SchemaIdentityConstraint) ZeusTransformUtils.preCheckCast(getComponent(), SchemaIdentityConstraint.class, "com.obric.memorydata.plugin");
        }
    }

    int getConstraintCategory();

    Object getFieldPath(int r1);

    String[] getFields();

    SchemaIdentityConstraint getReferencedKey();

    Object getSelectorPath();
}
