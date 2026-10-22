package com.ctc.wstx.shaded.msv_core.grammar.xmlschema;

import com.ctc.wstx.shaded.msv_core.grammar.ChoiceExp;
import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.NameClass;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import com.ctc.wstx.shaded.msv_core.grammar.SimpleNameClass;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public class ElementDeclExp extends ReferenceExp {
    public static final int ALL = 7;
    public static final int EXTENSION = 2;
    public static final int RESTRICTION = 1;
    public static final int SUBSTITUTION = 4;
    private static final long serialVersionUID = 1;
    public int block;
    public final ReferenceExp body;
    private XSElementExp element;
    public int finalValue;
    public boolean isNillable;
    public final XMLSchemaSchema parent;
    public ElementDeclExp substitutionAffiliation;
    public final ReferenceExp substitutions;

    public class XSElementExp extends ElementExp {
        public final SimpleNameClass elementName;
        public final Vector identityConstraints;
        public final ElementDeclExp parent;
        final /* synthetic */ ElementDeclExp this$0;

        public XSElementExp(ElementDeclExp r2, SimpleNameClass r3, Expression r4) {
            this.this$0 = r2;
            super(r4, false);
            this.identityConstraints = new Vector();
            this.elementName = r3;
            this.parent = r2;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.ElementExp
        public final NameClass getNameClass() {
            return this.elementName;
        }
    }

    public ElementDeclExp(XMLSchemaSchema r3, String r4) {
        super(r4);
        this.body = new ReferenceExp(null);
        this.finalValue = 0;
        this.block = 0;
        this.parent = r3;
        ReferenceExp r5 = new ReferenceExp(r4 + ":substitutions");
        this.substitutions = r5;
        r5.exp = Expression.nullSet;
    }

    public Expression getContentModel() {
        return this.element.contentModel;
    }

    public XSElementExp getElementExp() {
        return this.element;
    }

    public final String getTargetNamespace() {
        return this.parent.targetNamespace;
    }

    public XMLSchemaTypeExp getTypeDefinition() {
        final RuntimeException r0 = new RuntimeException();
        final XMLSchemaTypeExp[] r1 = new XMLSchemaTypeExp[1];
        getContentModel().visit(new AnonymousClass1(this, r1, r0));     // Catch: RuntimeException -> L5
        throw new Error();     // Catch: RuntimeException -> L5
    L5:
        e = move-exception;
        if (e == r0) goto L8;
        throw e;
    L8:
        return r1[0];
    }

    public boolean isAbstract() {
        if (ZeusTransformUtils.instanceOf(this.exp, ChoiceExp.class) == false) goto L14;
        ChoiceExp r0 = (ChoiceExp) ZeusTransformUtils.preCheckCast(this.exp, ChoiceExp.class, "com.obric.memorydata.plugin");
        if (r0.exp1 != this.body) goto L7;
        return true;
    L7:
        if (r0.exp2 != this.body) goto L10;
        return true;
    L10:
        throw new Error();
    L14:
        if (this.exp != this.substitutions) goto L18;
        return false;
    L18:
        throw new Error();
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp
    public boolean isDefined() {
        if (super.isDefined() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.element == null) goto L7;
        return true;
    }

    public boolean isGlobal() {
        if (this.parent.elementDecls.get(this.name) != this) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isRestrictionBlocked() {
        if ((this.block & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isSubstitutionBlocked() {
        if ((this.block & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setAbstract(boolean r3) {
        if (r3 == false) goto L4;
        Expression r4 = this.substitutions;
    L5:
        this.exp = r4;
        return;
    L4:
        r4 = this.parent.pool.createChoice(this.substitutions, this.body);
        goto L5
    }

    public void setElementExp(XSElementExp r1) {
        this.element = r1;
        this.body.exp = r1;
    }
}
