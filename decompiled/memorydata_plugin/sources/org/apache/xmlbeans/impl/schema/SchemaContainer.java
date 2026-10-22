package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;

/* JADX INFO: loaded from: classes7.dex */
class SchemaContainer {
    private final List<SchemaAnnotation> _annotations;
    private final List<SchemaAttributeGroup.Ref> _attributeGroups;
    private final List<SchemaType.Ref> _attributeTypes;
    private final List<SchemaType.Ref> _documentTypes;
    private final List<SchemaGlobalAttribute.Ref> _globalAttributes;
    private final List<SchemaGlobalElement.Ref> _globalElements;
    private final List<SchemaType.Ref> _globalTypes;
    private final List<SchemaIdentityConstraint.Ref> _identityConstraints;
    boolean _immutable;
    private final List<SchemaModelGroup.Ref> _modelGroups;
    private final String _namespace;
    private final List<SchemaAttributeGroup.Ref> _redefinedAttributeGroups;
    private final List<SchemaType.Ref> _redefinedGlobalTypes;
    private final List<SchemaModelGroup.Ref> _redefinedModelGroups;
    private SchemaTypeSystem _typeSystem;

    SchemaContainer(String r2) {
        this._globalElements = new ArrayList();
        this._globalAttributes = new ArrayList();
        this._modelGroups = new ArrayList();
        this._redefinedModelGroups = new ArrayList();
        this._attributeGroups = new ArrayList();
        this._redefinedAttributeGroups = new ArrayList();
        this._globalTypes = new ArrayList();
        this._redefinedGlobalTypes = new ArrayList();
        this._documentTypes = new ArrayList();
        this._attributeTypes = new ArrayList();
        this._identityConstraints = new ArrayList();
        this._annotations = new ArrayList();
        this._namespace = r2;
    }

    private void check_immutable() {
        if (this._immutable == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot add components to immutable SchemaContainer");
    }

    void addAnnotation(SchemaAnnotation r3) {
        SchemaAnnotation r4 = (SchemaAnnotation) ZeusTransformUtils.wrapperContextForParams(r3, SchemaAnnotation.class, "com.obric.memorydata.plugin");
        check_immutable();
        this._annotations.add(r4);
    }

    void addAttributeGroup(SchemaAttributeGroup.Ref r1) {
        check_immutable();
        this._attributeGroups.add(r1);
    }

    void addAttributeType(SchemaType.Ref r1) {
        check_immutable();
        this._attributeTypes.add(r1);
    }

    void addGlobalAttribute(SchemaGlobalAttribute.Ref r1) {
        check_immutable();
        this._globalAttributes.add(r1);
    }

    void addGlobalElement(SchemaGlobalElement.Ref r1) {
        check_immutable();
        this._globalElements.add(r1);
    }

    void addGlobalType(SchemaType.Ref r1) {
        check_immutable();
        this._globalTypes.add(r1);
    }

    void addIdentityConstraint(SchemaIdentityConstraint.Ref r1) {
        check_immutable();
        this._identityConstraints.add(r1);
    }

    void addModelGroup(SchemaModelGroup.Ref r1) {
        check_immutable();
        this._modelGroups.add(r1);
    }

    void addRedefinedAttributeGroup(SchemaAttributeGroup.Ref r1) {
        check_immutable();
        this._redefinedAttributeGroups.add(r1);
    }

    void addRedefinedModelGroup(SchemaModelGroup.Ref r1) {
        check_immutable();
        this._redefinedModelGroups.add(r1);
    }

    void addRedefinedType(SchemaType.Ref r1) {
        check_immutable();
        this._redefinedGlobalTypes.add(r1);
    }

    synchronized SchemaTypeSystem getTypeSystem() {
        monitor-enter(this);
        SchemaTypeSystem r0 = this._typeSystem;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void setImmutable() {
        monitor-enter(this);
        this._immutable = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    synchronized void setTypeSystem(SchemaTypeSystem r3) {
        monitor-enter(this);
        this._typeSystem = (SchemaTypeSystem) ZeusTransformUtils.wrapperContextForParams(r3, SchemaTypeSystem.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
