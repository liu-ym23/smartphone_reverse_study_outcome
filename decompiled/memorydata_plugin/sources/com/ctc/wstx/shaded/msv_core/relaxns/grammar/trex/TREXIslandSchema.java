package com.ctc.wstx.shaded.msv_core.relaxns.grammar.trex;

import com.ctc.wstx.shaded.msv.org_isorelax.a.g;
import com.ctc.wstx.shaded.msv_core.grammar.Grammar;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import com.ctc.wstx.shaded.msv_core.grammar.trex.TREXGrammar;
import com.ctc.wstx.shaded.msv_core.relaxns.grammar.DeclImpl;
import com.ctc.wstx.shaded.msv_core.relaxns.verifier.IslandSchemaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xml.sax.ErrorHandler;

/* JADX INFO: loaded from: classes2.dex */
public class TREXIslandSchema extends IslandSchemaImpl {
    protected final TREXGrammar grammar;

    public TREXIslandSchema(TREXGrammar r6) {
        this.grammar = r6;
        ReferenceExp[] r7 = r6.namedPatterns.getAll();
        int r0 = 0;
    L4:
        if (r0 >= r7.length) goto L6;
        this.elementDecls.put(r7[r0].name, new DeclImpl(r7[r0]));
        r0 = r0 + 1;
        goto L4
    }

    public void bind(g r3, ErrorHandler r4) {
        IslandSchemaImpl.a r0 = new IslandSchemaImpl.a((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin"), (ErrorHandler) ZeusTransformUtils.wrapperContextForParams(r4, ErrorHandler.class, "com.obric.memorydata.plugin"), this.grammar.pool);
        bind(this.grammar.namedPatterns, r0);
    }

    @Override // com.ctc.wstx.shaded.msv_core.relaxns.verifier.IslandSchemaImpl
    public Grammar getGrammar() {
        return this.grammar;
    }
}
