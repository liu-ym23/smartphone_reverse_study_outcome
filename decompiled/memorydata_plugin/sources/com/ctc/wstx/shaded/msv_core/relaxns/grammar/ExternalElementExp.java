package com.ctc.wstx.shaded.msv_core.relaxns.grammar;

import com.ctc.wstx.shaded.msv.org_isorelax.a.d;
import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.NameClass;
import com.ctc.wstx.shaded.msv_core.grammar.NamespaceNameClass;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xml.sax.Locator;

/* JADX INFO: loaded from: classes2.dex */
public class ExternalElementExp extends ElementExp {
    private final NamespaceNameClass nameClass;
    public final String namespaceURI;
    public d rule;
    public final String ruleName;
    public transient Locator source;

    public ExternalElementExp(ExpressionPool r3, String r4, String r5, Locator r6) {
        Locator r7 = (Locator) ZeusTransformUtils.wrapperContextForParams(r6, Locator.class, "com.obric.memorydata.plugin");
        super(Expression.nullSet, false);
        this.ruleName = r5;
        this.namespaceURI = r4;
        NamespaceNameClass r8 = new NamespaceNameClass(r4);
        this.nameClass = r8;
        this.source = r7;
        this.contentModel = r3.createZeroOrMore(r3.createMixed(r3.createChoice(r3.createAttribute(r8), this)));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.ElementExp
    public NameClass getNameClass() {
        return this.nameClass;
    }
}
