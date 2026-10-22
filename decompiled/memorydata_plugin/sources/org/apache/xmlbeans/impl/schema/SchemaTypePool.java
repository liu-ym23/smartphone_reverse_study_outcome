package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoaderException;

/* JADX INFO: loaded from: classes7.dex */
class SchemaTypePool {
    private final Map<SchemaComponent, String> _componentsToHandles;
    private final Map<String, SchemaComponent.Ref> _handlesToRefs;
    private boolean _started;
    private final SchemaTypeSystemImpl typeSystem;

    SchemaTypePool(SchemaTypeSystemImpl r2) {
        this._handlesToRefs = new LinkedHashMap();
        this._componentsToHandles = new LinkedHashMap();
        this.typeSystem = r2;
    }

    void readHandlePool(XsbReader r6) {
        if (this._handlesToRefs.size() != 0) goto L31;
        if (this._started == true) goto L31;
        int r0 = r6.readShort();
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L29;
        String r2 = r6.readString();
        int r3 = r6.readShort();
        if (r3 != 2) goto L11;
        SchemaComponent.Ref r4 = new SchemaType.Ref(this.typeSystem, r2);
    L28:
        this._handlesToRefs.put(r2, r4);
        r1 = r1 + 1;
        goto L7
    L11:
        if (r3 != 3) goto L13;
        r4 = new SchemaGlobalElement.Ref(this.typeSystem, r2);
        goto L28
    L13:
        if (r3 != 4) goto L15;
        r4 = new SchemaGlobalAttribute.Ref(this.typeSystem, r2);
        goto L28
    L15:
        if (r3 != 6) goto L17;
        r4 = new SchemaModelGroup.Ref(this.typeSystem, r2);
        goto L28
    L17:
        if (r3 != 7) goto L19;
        r4 = new SchemaAttributeGroup.Ref(this.typeSystem, r2);
        goto L28
    L19:
        if (r3 != 8) goto L22;
        r4 = new SchemaIdentityConstraint.Ref(this.typeSystem, r2);
        goto L28
    L22:
        throw new SchemaTypeLoaderException("Schema index has an unrecognized entry of type " + r3, this.typeSystem.getName(), r2, 5);
    L29:
        return;
    L31:
        throw new IllegalStateException("Nonempty handle set before read");
    }

    SchemaComponent.Ref refForHandle(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (SchemaComponent.Ref) ZeusTransformUtils.preCheckCast(this._handlesToRefs.get(r2), SchemaComponent.Ref.class, "com.obric.memorydata.plugin");
    }
}
