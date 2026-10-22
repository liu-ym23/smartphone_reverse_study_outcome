package com.ctc.wstx.shaded.msv_core.relaxns.grammar.relax;

import com.ctc.wstx.shaded.msv.org_isorelax.a.d;
import com.ctc.wstx.shaded.msv.org_isorelax.a.g;
import com.ctc.wstx.shaded.msv_core.grammar.ChoiceNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.Grammar;
import com.ctc.wstx.shaded.msv_core.grammar.NameClass;
import com.ctc.wstx.shaded.msv_core.grammar.NamespaceNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.NotNameClass;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.xml.sax.ErrorHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXParseException;

/* JADX INFO: loaded from: classes2.dex */
public class AnyOtherElementExp extends ElementExp implements d {
    public final String excludeNamespace;
    public final String includeNamespace;
    public NameClass nameClass;
    public transient Locator source;

    public AnyOtherElementExp(Locator r3, String r4, String r5) {
        Locator r6 = (Locator) ZeusTransformUtils.wrapperContextForParams(r3, Locator.class, "com.obric.memorydata.plugin");
        super(Expression.nullSet, true);
        this.source = r6;
        this.includeNamespace = r4;
        this.excludeNamespace = r5;
        if (r4 != null) goto L8;
        if (r5 != null) goto L8;
        throw new IllegalArgumentException();
    L8:
        if (r4 == null) goto L13;
        if (r5 != null) goto L12;
        return;
    L12:
        throw new IllegalArgumentException();
    }

    public boolean getFeature(String r1) {
        throw new SAXNotRecognizedException(r1);
    }

    @Override // com.ctc.wstx.shaded.msv.org_isorelax.a.d
    public String getName() {
        return "anyOtherElement:" + this.nameClass;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.ElementExp
    public NameClass getNameClass() {
        return this.nameClass;
    }

    public Object getProperty(String r1) {
        throw new SAXNotRecognizedException(r1);
    }

    public void wrapUp(Grammar r7, Expression r8, g r9, ErrorHandler r10) {
        Grammar r11 = (Grammar) ZeusTransformUtils.wrapperContextForParams(r7, Grammar.class, "com.obric.memorydata.plugin");
        g r12 = (g) ZeusTransformUtils.wrapperContextForParams(r9, g.class, "com.obric.memorydata.plugin");
        ErrorHandler r13 = (ErrorHandler) ZeusTransformUtils.wrapperContextForParams(r10, ErrorHandler.class, "com.obric.memorydata.plugin");
        if (this.includeNamespace == null) goto L5;
        StringTokenizer r0 = new StringTokenizer(this.includeNamespace);
    L6:
        NameClass r2 = null;
    L8:
        if (r0.hasMoreTokens() == false) goto L20;
        String r3 = r0.nextToken();
        if (r3.equals("##local") == false) goto L13;
        r3 = "";
    L13:
        if (r12.a(r3) != null) goto L14;
        NamespaceNameClass r4 = new NamespaceNameClass(r3);
        if (r2 == null) goto L17;
        r2 = new ChoiceNameClass(r2, r4);
        goto L8
    L17:
        r2 = r4;
        goto L8
    L14:
        r13.warning(new SAXParseException(b.a("AnyOtherElementExp.Warning.AnyOtherNamespaceIgnored", r3), this.source));
        goto L8
    L20:
        if (this.excludeNamespace == null) goto L29;
        Iterator r14 = r12.a();
    L23:
        if (r14.hasNext() == false) goto L28;
        NamespaceNameClass r15 = new NamespaceNameClass((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L26;
        r2 = new ChoiceNameClass(r2, r15);
        goto L23
    L26:
        r2 = r15;
        goto L23
    L28:
        r2 = new NotNameClass(r2);
    L29:
        this.nameClass = r2;
        this.contentModel = r11.getPool().createMixed(r11.getPool().createZeroOrMore(r11.getPool().createChoice(this, r8)));
        return;
    L5:
        r0 = new StringTokenizer(this.excludeNamespace);
        goto L6
    }
}
