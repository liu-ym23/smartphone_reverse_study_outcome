package com.ctc.wstx.shaded.msv_core.relaxns.verifier;

import com.ctc.wstx.shaded.msv.org_isorelax.a.e;
import com.ctc.wstx.shaded.msv.org_isorelax.a.f;
import com.ctc.wstx.shaded.msv.org_isorelax.a.g;
import com.ctc.wstx.shaded.msv_core.grammar.AttributeExp;
import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.Grammar;
import com.ctc.wstx.shaded.msv_core.grammar.OtherExp;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import com.ctc.wstx.shaded.msv_core.relaxns.grammar.DeclImpl;
import com.ctc.wstx.shaded.msv_core.relaxns.grammar.ExternalAttributeExp;
import com.ctc.wstx.shaded.msv_core.relaxns.grammar.ExternalElementExp;
import com.ctc.wstx.shaded.msv_core.verifier.a.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class IslandSchemaImpl implements e, Serializable {
    protected final Map attributesDecls;
    protected final Map elementDecls;

    public static class a extends com.ctc.wstx.shaded.msv_core.grammar.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final g f3632b;
        protected final ErrorHandler c;
        private final Set d;

        public a(g r3, ErrorHandler r4, ExpressionPool r5) {
            g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
            ErrorHandler r7 = (ErrorHandler) ZeusTransformUtils.wrapperContextForParams(r4, ErrorHandler.class, "com.obric.memorydata.plugin");
            super(r5);
            this.d = new HashSet();
            this.f3632b = r6;
            this.c = r7;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.e
        public Expression a(AttributeExp r1) {
            return r1;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.e
        public Expression a(ElementExp r6) {
            if (ZeusTransformUtils.instanceOf(r6, ExternalElementExp.class) == false) goto L6;
            ExternalElementExp r1 = (ExternalElementExp) ZeusTransformUtils.preCheckCast(r6, ExternalElementExp.class, "com.obric.memorydata.plugin");     // Catch: SAXException -> L23
            e r2 = this.f3632b.a(r1.namespaceURI);     // Catch: SAXException -> L23
            if (r2 != null) goto L14;
            this.c.error(new SAXParseException(a("IslandSchemaImpl.UndefinedNamespace", r1.namespaceURI), r1.source));     // Catch: SAXException -> L23
            return r6;
        L14:
            r1.rule = r2.getElementDeclByName(r1.ruleName);     // Catch: SAXException -> L23
            if (r1.rule != null) goto L19;
            this.c.error(new SAXParseException(a("IslandSchemaImpl.UnexportedElementDecl", r1.ruleName), r1.source));     // Catch: SAXException -> L23
            return r6;
        L19:
            if (ZeusTransformUtils.instanceOf(r1.rule, DeclImpl.class) == false) goto L22;
            return ((DeclImpl) ZeusTransformUtils.preCheckCast(r1.rule, DeclImpl.class, "com.obric.memorydata.plugin")).exp;
        L6:
            if (this.d.contains(r6) == false) goto L8;
            return r6;
        L8:
            this.d.add(r6);     // Catch: SAXException -> L23
            r6.contentModel = r6.contentModel.visit(this);     // Catch: SAXException -> L23
            return r6;
        L22:
            return r6;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.e
        public Expression a(OtherExp r6) {
        L21:
            return r6;
        L4:
            if (ZeusTransformUtils.instanceOf(r6, ExternalAttributeExp.class) == false) goto L20;
            ExternalAttributeExp r1 = (ExternalAttributeExp) ZeusTransformUtils.preCheckCast(r6, ExternalAttributeExp.class, "com.obric.memorydata.plugin");     // Catch: SAXException -> L21
            e r2 = this.f3632b.a(r1.namespaceURI);     // Catch: SAXException -> L21
            if (r2 != null) goto L9;
            this.c.error(new SAXParseException(a("IslandSchemaImpl.UndefinedNamespace", r1.namespaceURI), r1.source));     // Catch: SAXException -> L21
            return r6;
        L9:
            com.ctc.wstx.shaded.msv.org_isorelax.a.a r3 = r2.getAttributesDeclByName(r1.role);     // Catch: SAXException -> L21
            if (r3 != null) goto L14;
            this.c.error(new SAXParseException(a("IslandSchemaImpl.UnexportedAttributeDecl", r1.role), r1.source));     // Catch: SAXException -> L21
            return r6;
        L14:
            if (ZeusTransformUtils.instanceOf(r3, DeclImpl.class) == true) goto L18;
            this.c.error(new SAXParseException(a("IslandSchemaImpl.UnsupportedAttributesImport"), r1.source));     // Catch: SAXException -> L21
            return r6;
        L18:
            return ((DeclImpl) ZeusTransformUtils.preCheckCast(r3, DeclImpl.class, "com.obric.memorydata.plugin")).exp;
        L20:
            return r6.exp.visit(this);
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.e
        public Expression a(ReferenceExp r1) {
            return r1.exp.visit(this);
        }

        public String a(String r2) {
            return a(r2, null);
        }

        public String a(String r3, Object r4) {
            return a(r3, new Object[]{r4});
        }

        public String a(String r1, Object[] r2) {
            return MessageFormat.format(ResourceBundle.getBundle("com.ctc.wstx.shaded.msv_core.relaxns.verifier.Messages").getString(r1), r2);
        }
    }

    public IslandSchemaImpl() {
        this.elementDecls = new HashMap();
        this.attributesDecls = new HashMap();
    }

    public void bind(ReferenceContainer r3, a r4) {
        ReferenceExp[] r2 = r3.getAll();
        int r5 = 0;
    L4:
        if (r5 >= r2.length) goto L6;
        ReferenceExp r0 = r2[r5];
        r0.exp = r2[r5].exp.visit(r4);
        r5 = r5 + 1;
        goto L4
    }

    public com.ctc.wstx.shaded.msv.org_isorelax.a.b createNewAttributesVerifier(String r1, com.ctc.wstx.shaded.msv.org_isorelax.a.a[] r2) {
        throw new Error("not implemented");
    }

    @Override // com.ctc.wstx.shaded.msv.org_isorelax.a.e
    public f createNewVerifier(String r3, com.ctc.wstx.shaded.msv.org_isorelax.a.d[] r4) {
        DeclImpl[] r5 = new DeclImpl[r4.length];
        System.arraycopy(r4, 0, r5, 0, r4.length);
        return new d(new c(new p(getGrammar()), r5));
    }

    @Override // com.ctc.wstx.shaded.msv.org_isorelax.a.e
    public com.ctc.wstx.shaded.msv.org_isorelax.a.a getAttributesDeclByName(String r2) {
        return (com.ctc.wstx.shaded.msv.org_isorelax.a.a) ZeusTransformUtils.preCheckCast(this.attributesDecls.get(r2), com.ctc.wstx.shaded.msv.org_isorelax.a.a.class, "com.obric.memorydata.plugin");
    }

    public com.ctc.wstx.shaded.msv.org_isorelax.a.a[] getAttributesDecls() {
        DeclImpl[] r0 = new DeclImpl[this.attributesDecls.size()];
        this.attributesDecls.values().toArray(r0);
        return r0;
    }

    @Override // com.ctc.wstx.shaded.msv.org_isorelax.a.e
    public com.ctc.wstx.shaded.msv.org_isorelax.a.d getElementDeclByName(String r2) {
        return (com.ctc.wstx.shaded.msv.org_isorelax.a.d) ZeusTransformUtils.preCheckCast(this.elementDecls.get(r2), com.ctc.wstx.shaded.msv.org_isorelax.a.d.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ctc.wstx.shaded.msv.org_isorelax.a.e
    public com.ctc.wstx.shaded.msv.org_isorelax.a.d[] getElementDecls() {
        DeclImpl[] r0 = new DeclImpl[this.elementDecls.size()];
        this.elementDecls.values().toArray(r0);
        return r0;
    }

    public abstract Grammar getGrammar();

    public Iterator iterateAttributesDecls() {
        return this.attributesDecls.values().iterator();
    }

    public Iterator iterateElementDecls() {
        return this.elementDecls.values().iterator();
    }
}
