package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: loaded from: classes7.dex */
public class ElementFactory<T> {
    private final SchemaType type;
    private final SchemaTypeSystem typeSystem;

    public ElementFactory(SchemaTypeSystem r3, String r4) {
        SchemaTypeSystem r5 = (SchemaTypeSystem) ZeusTransformUtils.wrapperContextForParams(r3, SchemaTypeSystem.class, "com.obric.memorydata.plugin");
        this.typeSystem = r5;
        this.type = (SchemaType) ZeusTransformUtils.preCheckCast(r5.resolveHandle(r4), SchemaType.class, "com.obric.memorydata.plugin");
    }

    public SchemaType getType() {
        return this.type;
    }

    public SchemaTypeSystem getTypeLoader() {
        return this.typeSystem;
    }

    public T newInstance() {
        return (T) getTypeLoader().newInstance(this.type, null);
    }

    public T newInstance(XmlOptions r2) {
        return (T) getTypeLoader().newInstance(this.type, r2);
    }
}
