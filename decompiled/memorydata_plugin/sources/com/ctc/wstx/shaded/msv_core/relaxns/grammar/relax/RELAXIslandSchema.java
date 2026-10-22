package com.ctc.wstx.shaded.msv_core.relaxns.grammar.relax;

import com.ctc.wstx.shaded.msv.org_isorelax.a.d;
import com.ctc.wstx.shaded.msv.org_isorelax.a.g;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.Grammar;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import com.ctc.wstx.shaded.msv_core.grammar.relax.AttPoolClause;
import com.ctc.wstx.shaded.msv_core.grammar.relax.ElementRules;
import com.ctc.wstx.shaded.msv_core.grammar.relax.HedgeRules;
import com.ctc.wstx.shaded.msv_core.grammar.relax.RELAXModule;
import com.ctc.wstx.shaded.msv_core.relaxns.grammar.DeclImpl;
import com.ctc.wstx.shaded.msv_core.relaxns.grammar.ExternalElementExp;
import com.ctc.wstx.shaded.msv_core.relaxns.verifier.IslandSchemaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Set;
import org.xml.sax.ErrorHandler;

/* JADX INFO: loaded from: classes2.dex */
public class RELAXIslandSchema extends IslandSchemaImpl {
    protected final RELAXModule module;
    protected Set pendingAnyOtherElements;

    public RELAXIslandSchema(RELAXModule r9, Set r10) {
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        this.module = r9;
        this.pendingAnyOtherElements = r11;
        ReferenceExp[] r12 = r9.elementRules.getAll();
        int r0 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r12.length) goto L9;
        if (((ElementRules) ZeusTransformUtils.preCheckCast(r12[r2], ElementRules.class, "com.obric.memorydata.plugin")).exported == false) goto L8;
        this.elementDecls.put(r12[r2].name, new DeclImpl(r12[r2]));
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        ReferenceExp[] r13 = r9.hedgeRules.getAll();
        int r3 = 0;
    L11:
        if (r3 >= r13.length) goto L16;
        if (((HedgeRules) ZeusTransformUtils.preCheckCast(r13[r3], HedgeRules.class, "com.obric.memorydata.plugin")).exported == false) goto L15;
        this.elementDecls.put(r13[r3].name, new DeclImpl(r13[r3]));
    L15:
        r3 = r3 + 1;
        goto L11
    L16:
        a r14 = new a(r9.pool);
        ReferenceExp[] r4 = r9.attPools.getAll();
    L18:
        if (r0 >= r4.length) goto L23;
        if (((AttPoolClause) ZeusTransformUtils.preCheckCast(r4[r0], AttPoolClause.class, "com.obric.memorydata.plugin")).exported == false) goto L22;
        this.attributesDecls.put(r4[r0].name, new DeclImpl(r4[r0].name, r14.a(r9, r4[r0].exp)));
    L22:
        r0 = r0 + 1;
        goto L18
    }

    private Expression createChoiceOfAllExportedRules(g r12) {
        g r13 = (g) ZeusTransformUtils.wrapperContextForParams(r12, g.class, "com.obric.memorydata.plugin");
        Expression r0 = Expression.nullSet;
        Iterator r2 = r13.a();
    L4:
        if (r2.hasNext() == false) goto L9;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        d[] r4 = r13.a(r3).getElementDecls();
        int r5 = 0;
    L7:
        if (r5 >= r4.length) goto L4;
        r0 = this.module.pool.createChoice(r0, new ExternalElementExp(this.module.pool, r3, r4[r5].getName(), null));
        r5 = r5 + 1;
        goto L7
    L9:
        return r0;
    }

    public void bind(g r6, ErrorHandler r7) {
        g r8 = (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.memorydata.plugin");
        ErrorHandler r9 = (ErrorHandler) ZeusTransformUtils.wrapperContextForParams(r7, ErrorHandler.class, "com.obric.memorydata.plugin");
        Expression r0 = createChoiceOfAllExportedRules(r8);
        Iterator r2 = this.pendingAnyOtherElements.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((AnyOtherElementExp) ZeusTransformUtils.preCheckCast(r2.next(), AnyOtherElementExp.class, "com.obric.memorydata.plugin")).wrapUp(this.module, r0, r8, r9);
        goto L4
    L6:
        this.pendingAnyOtherElements = null;
        IslandSchemaImpl.a r1 = new IslandSchemaImpl.a(r8, r9, this.module.pool);
        bind(this.module.elementRules, r1);
        bind(this.module.hedgeRules, r1);
        bind(this.module.attPools, r1);
        bind(this.module.tags, r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.relaxns.verifier.IslandSchemaImpl
    public Grammar getGrammar() {
        return this.module;
    }
}
