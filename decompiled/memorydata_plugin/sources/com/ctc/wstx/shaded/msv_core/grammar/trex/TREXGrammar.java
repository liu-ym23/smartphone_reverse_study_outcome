package com.ctc.wstx.shaded.msv_core.grammar.trex;

import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.Grammar;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import com.ctc.wstx.shaded.msv_core.reader.datatype.DataTypeVocabularyMap;

/* JADX INFO: loaded from: classes2.dex */
public class TREXGrammar extends ReferenceExp implements Grammar {
    private static final long serialVersionUID = 1;
    public final DataTypeVocabularyMap dataTypes;
    public final RefContainer namedPatterns;
    protected final TREXGrammar parentGrammar;
    public final ExpressionPool pool;

    public static final class RefContainer extends ReferenceContainer {
        public RefContainer() {
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer
        public ReferenceExp createReference(String r1) {
            return new ReferenceExp(r1);
        }

        public ReferenceExp getOrCreate(String r1) {
            return super._getOrCreate(r1);
        }
    }

    public TREXGrammar() {
        this(new ExpressionPool(), null);
    }

    public TREXGrammar(ExpressionPool r2) {
        this(r2, null);
    }

    public TREXGrammar(ExpressionPool r2, TREXGrammar r3) {
        super(null);
        this.namedPatterns = new RefContainer();
        this.dataTypes = new DataTypeVocabularyMap();
        this.pool = r2;
        this.parentGrammar = r3;
    }

    public final TREXGrammar getParentGrammar() {
        return this.parentGrammar;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Grammar
    public ExpressionPool getPool() {
        return this.pool;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Grammar
    public Expression getTopLevel() {
        return this.exp;
    }
}
