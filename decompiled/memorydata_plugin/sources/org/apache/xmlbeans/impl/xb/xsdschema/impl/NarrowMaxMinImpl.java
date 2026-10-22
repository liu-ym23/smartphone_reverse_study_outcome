package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.impl.values.JavaIntegerHolderEx;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.xb.xsdschema.NarrowMaxMin;

/* JADX INFO: loaded from: classes7.dex */
public class NarrowMaxMinImpl extends LocalElementImpl implements NarrowMaxMin {
    private static final long serialVersionUID = 1;

    public static class MaxOccursImpl extends XmlUnionImpl implements XmlNonNegativeInteger, AllNNI.Member, NarrowMaxMin.MaxOccurs {
        private static final long serialVersionUID = 1;

        public MaxOccursImpl(SchemaType r3) {
            super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
        }

        public MaxOccursImpl(SchemaType r3, boolean r4) {
            super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    public static class MinOccursImpl extends JavaIntegerHolderEx implements NarrowMaxMin.MinOccurs {
        private static final long serialVersionUID = 1;

        public MinOccursImpl(SchemaType r3) {
            super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
        }

        public MinOccursImpl(SchemaType r3, boolean r4) {
            super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    public NarrowMaxMinImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }
}
