package com.ctc.wstx.shaded.msv_core.grammar.relax;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.Grammar;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class RELAXModule implements Grammar {
    private static final long serialVersionUID = 1;
    public final AttPoolContainer attPools;
    public final a datatypes;
    public final ElementRulesContainer elementRules;
    public final HedgeRulesContainer hedgeRules;
    public final ExpressionPool pool;
    public final TagContainer tags;
    public final String targetNamespace;
    public Expression topLevel;

    public final class AttPoolContainer extends ReferenceContainer {
        final /* synthetic */ RELAXModule this$0;

        public AttPoolContainer(RELAXModule r1) {
            this.this$0 = r1;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer
        public ReferenceExp createReference(String r1) {
            return new AttPoolClause(r1);
        }

        public AttPoolClause get(String r2) {
            return (AttPoolClause) ZeusTransformUtils.preCheckCast(super._get(r2), AttPoolClause.class, "com.obric.memorydata.plugin");
        }

        public AttPoolClause getOrCreate(String r2) {
            return (AttPoolClause) ZeusTransformUtils.preCheckCast(super._getOrCreate(r2), AttPoolClause.class, "com.obric.memorydata.plugin");
        }
    }

    public final class ElementRulesContainer extends ReferenceContainer {
        final /* synthetic */ RELAXModule this$0;

        public ElementRulesContainer(RELAXModule r1) {
            this.this$0 = r1;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer
        public ReferenceExp createReference(String r2) {
            return new ElementRules(r2, this.this$0);
        }

        public ElementRules get(String r2) {
            return (ElementRules) ZeusTransformUtils.preCheckCast(super._get(r2), ElementRules.class, "com.obric.memorydata.plugin");
        }

        public ElementRules getOrCreate(String r2) {
            return (ElementRules) ZeusTransformUtils.preCheckCast(super._getOrCreate(r2), ElementRules.class, "com.obric.memorydata.plugin");
        }
    }

    public final class HedgeRulesContainer extends ReferenceContainer {
        final /* synthetic */ RELAXModule this$0;

        public HedgeRulesContainer(RELAXModule r1) {
            this.this$0 = r1;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer
        public ReferenceExp createReference(String r2) {
            return new HedgeRules(r2, this.this$0);
        }

        public HedgeRules get(String r2) {
            return (HedgeRules) ZeusTransformUtils.preCheckCast(super._get(r2), HedgeRules.class, "com.obric.memorydata.plugin");
        }

        public HedgeRules getOrCreate(String r2) {
            return (HedgeRules) ZeusTransformUtils.preCheckCast(super._getOrCreate(r2), HedgeRules.class, "com.obric.memorydata.plugin");
        }
    }

    public final class TagContainer extends ReferenceContainer {
        final /* synthetic */ RELAXModule this$0;

        public TagContainer(RELAXModule r1) {
            this.this$0 = r1;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer
        public ReferenceExp createReference(String r1) {
            return new TagClause(r1);
        }

        public TagClause get(String r2) {
            return (TagClause) ZeusTransformUtils.preCheckCast(super._get(r2), TagClause.class, "com.obric.memorydata.plugin");
        }

        public TagClause getOrCreate(String r2) {
            return (TagClause) ZeusTransformUtils.preCheckCast(super._getOrCreate(r2), TagClause.class, "com.obric.memorydata.plugin");
        }
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RELAXModule f3594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f3595b;

        public a(RELAXModule r1) {
            this.f3594a = r1;
            this.f3595b = new HashMap();
        }

        public void a(XSDatatype r3) {
            XSDatatype r4 = (XSDatatype) ZeusTransformUtils.wrapperContextForParams(r3, XSDatatype.class, "com.obric.memorydata.plugin");
            if (r4.getName() == null) goto L7;
            this.f3595b.put(r4.getName(), r4);
            return;
        L7:
            throw new IllegalArgumentException();
        }
    }

    public RELAXModule(ExpressionPool r2, String r3) {
        this.elementRules = new ElementRulesContainer(this);
        this.hedgeRules = new HedgeRulesContainer(this);
        this.tags = new TagContainer(this);
        this.attPools = new AttPoolContainer(this);
        a r0 = new a(this);
        this.datatypes = r0;
        Objects.requireNonNull(r3);
        this.pool = r2;
        this.targetNamespace = r3;
        r0.a(EmptyStringType.theInstance);
        r0.a(NoneType.theInstance);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Grammar
    public ExpressionPool getPool() {
        return this.pool;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Grammar
    public Expression getTopLevel() {
        return this.topLevel;
    }
}
