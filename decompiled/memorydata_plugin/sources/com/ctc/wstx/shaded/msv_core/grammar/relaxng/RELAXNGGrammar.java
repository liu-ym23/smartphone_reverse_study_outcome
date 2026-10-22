package com.ctc.wstx.shaded.msv_core.grammar.relaxng;

import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.trex.TREXGrammar;

/* JADX INFO: loaded from: classes2.dex */
public class RELAXNGGrammar extends TREXGrammar {
    private static final long serialVersionUID = 1;
    public boolean isAnnotationCompatible;
    public boolean isDefaultAttributeValueCompatible;
    public boolean isIDcompatible;

    public RELAXNGGrammar() {
        this.isIDcompatible = true;
        this.isDefaultAttributeValueCompatible = true;
        this.isAnnotationCompatible = true;
    }

    public RELAXNGGrammar(ExpressionPool r1) {
        super(r1);
        this.isIDcompatible = true;
        this.isDefaultAttributeValueCompatible = true;
        this.isAnnotationCompatible = true;
    }

    public RELAXNGGrammar(ExpressionPool r1, TREXGrammar r2) {
        super(r1, r2);
        this.isIDcompatible = true;
        this.isDefaultAttributeValueCompatible = true;
        this.isAnnotationCompatible = true;
    }
}
