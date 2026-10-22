package com.ctc.wstx.shaded.msv_core.grammar.xmlschema;

import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.Grammar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class XMLSchemaGrammar implements Grammar {
    private static final long serialVersionUID = 1;
    protected final ExpressionPool pool;
    protected final Map schemata;
    public Expression topLevel;

    public XMLSchemaGrammar() {
        this(new ExpressionPool());
    }

    public XMLSchemaGrammar(ExpressionPool r2) {
        this.schemata = new HashMap();
        this.pool = r2;
    }

    public XMLSchemaSchema getByNamespace(String r2) {
        return (XMLSchemaSchema) ZeusTransformUtils.preCheckCast(this.schemata.get(r2), XMLSchemaSchema.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Grammar
    public final ExpressionPool getPool() {
        return this.pool;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Grammar
    public final Expression getTopLevel() {
        return this.topLevel;
    }

    public Iterator iterateSchemas() {
        return this.schemata.values().iterator();
    }
}
