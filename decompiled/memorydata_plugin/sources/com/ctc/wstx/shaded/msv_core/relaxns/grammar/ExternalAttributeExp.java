package com.ctc.wstx.shaded.msv_core.relaxns.grammar;

import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.OtherExp;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xml.sax.Locator;

/* JADX INFO: loaded from: classes2.dex */
public class ExternalAttributeExp extends OtherExp {
    public final String namespaceURI;
    public final String role;
    public transient Locator source;

    public ExternalAttributeExp(ExpressionPool r2, String r3, String r4, Locator r5) {
        this.source = (Locator) ZeusTransformUtils.wrapperContextForParams(r5, Locator.class, "com.obric.memorydata.plugin");
        this.namespaceURI = r3;
        this.role = r4;
        this.exp = Expression.epsilon;
    }
}
