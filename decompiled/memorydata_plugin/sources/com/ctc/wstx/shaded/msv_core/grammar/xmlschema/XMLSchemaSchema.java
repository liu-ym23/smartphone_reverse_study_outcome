package com.ctc.wstx.shaded.msv_core.grammar.xmlschema;

import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class XMLSchemaSchema implements Serializable {
    public static final String XMLSchemaInstanceNamespace = "http://www.w3.org/2001/XMLSchema-instance";
    private static final long serialVersionUID = 1;
    public final AttributeDeclContainer attributeDecls;
    public final AttributeGroupContainer attributeGroups;
    public final ComplexTypeContainer complexTypes;
    public final ElementDeclContainer elementDecls;
    public final GroupDeclContainer groupDecls;
    public final IdentityConstraintContainer identityConstraints;
    public final ExpressionPool pool;
    public final SimpleTypeContainer simpleTypes;
    public final String targetNamespace;
    public Expression topLevel;

    public final class AttributeDeclContainer extends ReferenceContainer {
        final /* synthetic */ XMLSchemaSchema this$0;

        public AttributeDeclContainer(XMLSchemaSchema r1) {
            this.this$0 = r1;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer
        public ReferenceExp createReference(String r1) {
            return new AttributeDeclExp(r1);
        }

        public AttributeDeclExp get(String r2) {
            return (AttributeDeclExp) ZeusTransformUtils.preCheckCast(super._get(r2), AttributeDeclExp.class, "com.obric.memorydata.plugin");
        }

        public AttributeDeclExp getOrCreate(String r2) {
            return (AttributeDeclExp) ZeusTransformUtils.preCheckCast(super._getOrCreate(r2), AttributeDeclExp.class, "com.obric.memorydata.plugin");
        }
    }

    public final class AttributeGroupContainer extends ReferenceContainer {
        final /* synthetic */ XMLSchemaSchema this$0;

        public AttributeGroupContainer(XMLSchemaSchema r1) {
            this.this$0 = r1;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer
        public ReferenceExp createReference(String r1) {
            return new AttributeGroupExp(r1);
        }

        public AttributeGroupExp get(String r2) {
            return (AttributeGroupExp) ZeusTransformUtils.preCheckCast(super._get(r2), AttributeGroupExp.class, "com.obric.memorydata.plugin");
        }

        public AttributeGroupExp getOrCreate(String r2) {
            return (AttributeGroupExp) ZeusTransformUtils.preCheckCast(super._getOrCreate(r2), AttributeGroupExp.class, "com.obric.memorydata.plugin");
        }
    }

    public final class ComplexTypeContainer extends ReferenceContainer {
        final /* synthetic */ XMLSchemaSchema this$0;

        public ComplexTypeContainer(XMLSchemaSchema r1) {
            this.this$0 = r1;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer
        public ReferenceExp createReference(String r2) {
            return new ComplexTypeExp(this.this$0, r2);
        }

        public ComplexTypeExp get(String r2) {
            return (ComplexTypeExp) ZeusTransformUtils.preCheckCast(super._get(r2), ComplexTypeExp.class, "com.obric.memorydata.plugin");
        }

        public ComplexTypeExp getOrCreate(String r2) {
            return (ComplexTypeExp) ZeusTransformUtils.preCheckCast(super._getOrCreate(r2), ComplexTypeExp.class, "com.obric.memorydata.plugin");
        }
    }

    public final class ElementDeclContainer extends ReferenceContainer {
        final /* synthetic */ XMLSchemaSchema this$0;

        public ElementDeclContainer(XMLSchemaSchema r1) {
            this.this$0 = r1;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer
        public ReferenceExp createReference(String r2) {
            return new ElementDeclExp(this.this$0, r2);
        }

        public ElementDeclExp get(String r2) {
            return (ElementDeclExp) ZeusTransformUtils.preCheckCast(super._get(r2), ElementDeclExp.class, "com.obric.memorydata.plugin");
        }

        public ElementDeclExp getOrCreate(String r2) {
            return (ElementDeclExp) ZeusTransformUtils.preCheckCast(super._getOrCreate(r2), ElementDeclExp.class, "com.obric.memorydata.plugin");
        }
    }

    public final class GroupDeclContainer extends ReferenceContainer {
        final /* synthetic */ XMLSchemaSchema this$0;

        public GroupDeclContainer(XMLSchemaSchema r1) {
            this.this$0 = r1;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer
        public ReferenceExp createReference(String r1) {
            return new GroupDeclExp(r1);
        }

        public GroupDeclExp get(String r2) {
            return (GroupDeclExp) ZeusTransformUtils.preCheckCast(super._get(r2), GroupDeclExp.class, "com.obric.memorydata.plugin");
        }

        public GroupDeclExp getOrCreate(String r2) {
            return (GroupDeclExp) ZeusTransformUtils.preCheckCast(super._getOrCreate(r2), GroupDeclExp.class, "com.obric.memorydata.plugin");
        }
    }

    public final class IdentityConstraintContainer implements Serializable {
        private final Map storage;
        final /* synthetic */ XMLSchemaSchema this$0;

        public IdentityConstraintContainer(XMLSchemaSchema r1) {
            this.this$0 = r1;
            this.storage = new HashMap();
        }

        public void add(String r1, IdentityConstraint r2) {
            this.storage.put(r1, r2);
        }

        public IdentityConstraint get(String r2) {
            return (IdentityConstraint) ZeusTransformUtils.preCheckCast(this.storage.get(r2), IdentityConstraint.class, "com.obric.memorydata.plugin");
        }
    }

    public final class SimpleTypeContainer extends ReferenceContainer {
        final /* synthetic */ XMLSchemaSchema this$0;

        public SimpleTypeContainer(XMLSchemaSchema r1) {
            this.this$0 = r1;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer
        public ReferenceExp createReference(String r1) {
            return new SimpleTypeExp(r1);
        }

        public SimpleTypeExp get(String r2) {
            return (SimpleTypeExp) ZeusTransformUtils.preCheckCast(super._get(r2), SimpleTypeExp.class, "com.obric.memorydata.plugin");
        }

        public SimpleTypeExp getOrCreate(String r2) {
            return (SimpleTypeExp) ZeusTransformUtils.preCheckCast(super._getOrCreate(r2), SimpleTypeExp.class, "com.obric.memorydata.plugin");
        }
    }

    public XMLSchemaSchema(String r2, XMLSchemaGrammar r3) {
        this.simpleTypes = new SimpleTypeContainer(this);
        this.complexTypes = new ComplexTypeContainer(this);
        this.attributeGroups = new AttributeGroupContainer(this);
        this.attributeDecls = new AttributeDeclContainer(this);
        this.elementDecls = new ElementDeclContainer(this);
        this.groupDecls = new GroupDeclContainer(this);
        this.identityConstraints = new IdentityConstraintContainer(this);
        this.pool = r3.pool;
        this.targetNamespace = r2;
        r3.schemata.put(r2, this);
    }
}
