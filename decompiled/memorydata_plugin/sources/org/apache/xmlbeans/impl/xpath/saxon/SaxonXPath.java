package org.apache.xmlbeans.impl.xpath.saxon;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import net.sf.saxon.Configuration;
import net.sf.saxon.dom.DOMNodeWrapper;
import net.sf.saxon.om.Item;
import net.sf.saxon.om.NodeInfo;
import net.sf.saxon.om.SequenceTool;
import net.sf.saxon.sxpath.IndependentContext;
import net.sf.saxon.sxpath.XPathDynamicContext;
import net.sf.saxon.sxpath.XPathEvaluator;
import net.sf.saxon.sxpath.XPathExpression;
import net.sf.saxon.sxpath.XPathVariable;
import net.sf.saxon.tree.wrapper.VirtualNode;
import net.sf.saxon.value.DateTimeValue;
import net.sf.saxon.value.GDateValue;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.xpath.Path;
import org.apache.xmlbeans.impl.xpath.XPathEngine;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes7.dex */
public class SaxonXPath implements Path {
    private String contextVar;
    private String defaultNS;
    private final Map<String, String> namespaceMap;
    private String path;

    public SaxonXPath(String r4, String r5, Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        this.namespaceMap = r0;
        this.path = r4;
        this.contextVar = r5;
        this.defaultNS = (String) ZeusTransformUtils.preCheckCast(r7.get("$xmlbeans!default_uri"), String.class, "com.obric.memorydata.plugin");
        r0.putAll(r7);
        r0.remove("$xmlbeans!default_uri");
    }

    private static Node getUnderlyingNode(VirtualNode r2) {
        Object r3 = (VirtualNode) ZeusTransformUtils.wrapperContextForParams(r2, VirtualNode.class, "com.obric.memorydata.plugin");
    L4:
        if (ZeusTransformUtils.instanceOf(r3, VirtualNode.class) == false) goto L7;
        r3 = ((VirtualNode) ZeusTransformUtils.preCheckCast(r3, VirtualNode.class, "com.obric.memorydata.plugin")).getUnderlyingNode();
        goto L4
    L7:
        return (Node) ZeusTransformUtils.preCheckCast(r3, Node.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void lambda$Dz97WNaNpqHgF1gbDyqDaMJ3FGs(IndependentContext r0, String r1, String r2) {
        r0.declareNamespace(r1, r2);
    }

    @Override // org.apache.xmlbeans.impl.xpath.Path
    public XPathEngine execute(Cur r1, XmlOptions r2) {
        return new SaxonXPathEngine(this, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v14, types: [org.w3c.dom.Node] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object, net.sf.saxon.om.Item] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object] */
    public List selectNodes(Object r6) {
        Node r7 = (Node) ZeusTransformUtils.preCheckCast(r6, Node.class, "com.obric.memorydata.plugin");     // Catch: TransformerException -> L25
        Configuration r1 = new Configuration();     // Catch: TransformerException -> L25
        final IndependentContext r2 = new IndependentContext(r1);     // Catch: TransformerException -> L25
        String r3 = this.defaultNS;     // Catch: TransformerException -> L25
        if (r3 == null) goto L6;
        r2.setDefaultElementNamespace(r3);     // Catch: TransformerException -> L25
    L6:
        this.namespaceMap.forEach(new $$Lambda$SaxonXPath$Dz97WNaNpqHgF1gbDyqDaMJ3FGs(r2));     // Catch: TransformerException -> L25
        NodeInfo r8 = r1.unravel(new DOMSource(r7));     // Catch: TransformerException -> L25
        XPathEvaluator r4 = new XPathEvaluator(r1);     // Catch: TransformerException -> L25
        r4.setStaticContext(r2);     // Catch: TransformerException -> L25
        XPathVariable r5 = r2.declareVariable("", this.contextVar);     // Catch: TransformerException -> L25
        XPathExpression r9 = r4.createExpression(this.path);     // Catch: TransformerException -> L25
        XPathDynamicContext r10 = r9.createDynamicContext(null);     // Catch: TransformerException -> L25
        r10.setContextItem(r8);     // Catch: TransformerException -> L25
        r10.setVariable(r5, r8);     // Catch: TransformerException -> L25
        List r11 = r9.evaluate(r10);     // Catch: TransformerException -> L25
        ArrayList r12 = new ArrayList(r11.size());     // Catch: TransformerException -> L25
        Iterator r13 = r11.iterator();     // Catch: TransformerException -> L25
    L7:
        if (r13.hasNext() == false) goto L24;
        ?? r14 = (Item) ZeusTransformUtils.preCheckCast(r13.next(), Item.class, "com.obric.memorydata.plugin");     // Catch: TransformerException -> L25
        if (ZeusTransformUtils.instanceOf(r14, DOMNodeWrapper.class) == false) goto L14;
        r14 = getUnderlyingNode((DOMNodeWrapper) ZeusTransformUtils.preCheckCast(r14, DOMNodeWrapper.class, "com.obric.memorydata.plugin"));     // Catch: TransformerException -> L25
    L12:
        r12.add(r14);     // Catch: TransformerException -> L25
        goto L7
    L14:
        if (ZeusTransformUtils.instanceOf(r14, NodeInfo.class) == false) goto L17;
        r14 = r14.getStringValue();     // Catch: TransformerException -> L25
        goto L12
    L17:
        if (ZeusTransformUtils.instanceOf(r14, GDateValue.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r14, DateTimeValue.class) == true) goto L12;
        r14 = SequenceTool.convertToJava(r14);     // Catch: TransformerException -> L25
        goto L12
    L24:
        return r12;
    L25:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public List selectPath(Object r1) {
        return selectNodes(r1);
    }
}
