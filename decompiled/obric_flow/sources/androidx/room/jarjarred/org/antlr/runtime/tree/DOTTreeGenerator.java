package androidx.room.jarjarred.org.antlr.runtime.tree;

import androidx.room.jarjarred.org.antlr.stringtemplate.StringTemplate;
import com.bytedance.ai.event.MessageIndication;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class DOTTreeGenerator {
    public static StringTemplate _edgeST;
    public static StringTemplate _nodeST;
    public static StringTemplate _treeST;
    int nodeNumber;
    HashMap<Object, Integer> nodeToNumberMap;

    static {
        _treeST = new StringTemplate("digraph {\n\n\tordering=out;\n\tranksep=.4;\n\tbgcolor=\"lightgrey\"; node [shape=box, fixedsize=false, fontsize=12, fontname=\"Helvetica-bold\", fontcolor=\"blue\"\n\t\twidth=.25, height=.25, color=\"black\", fillcolor=\"white\", style=\"filled, solid, bold\"];\n\tedge [arrowsize=.5, color=\"black\", style=\"bold\"]\n\n  $nodes$\n  $edges$\n}\n");
        _nodeST = new StringTemplate("$name$ [label=\"$text$\"];\n");
        _edgeST = new StringTemplate("$parent$ -> $child$ // \"$parentText$\" -> \"$childText$\"\n");
    }

    public DOTTreeGenerator() {
        this.nodeToNumberMap = new HashMap();
        this.nodeNumber = 0;
    }

    public String fixString(String r5) {
        if (r5 == null) goto L7;
        String r10 = r5.replaceAll("\"", "\\\\\"").replaceAll("\\t", "    ").replaceAll("\\n", "\\\\n").replaceAll("\\r", "\\\\r");
        if (r10.length() > 20) goto L6;
        return r10;
    L6:
        return r10.substring(0, 8) + "..." + r10.substring(r10.length() - 8);
    L7:
        return r5;
    }

    public int getNodeNumber(Object r5) {
        Integer r10 = this.nodeToNumberMap.get(r5);
        if (r10 != null) goto L5;
        this.nodeToNumberMap.put(r5, Integer.valueOf(this.nodeNumber));
        int r11 = this.nodeNumber;
        this.nodeNumber = r11 + 1;
        return r11;
    L5:
        return r10.intValue();
    }

    public StringTemplate getNodeST(TreeAdaptor r5, Object r10) {
        String r11 = r5.getText(r10);
        StringTemplate r12 = _nodeST.getInstanceOf();
        r12.setAttribute("name", "n" + getNodeNumber(r10));
        r12.setAttribute(MessageIndication.CONTENT_TYPE_TEXT, fixString(r11));
        return r12;
    }

    public StringTemplate toDOT(Object r5, TreeAdaptor r10, StringTemplate r11, StringTemplate r12) {
        StringTemplate r13 = r11.getInstanceOf();
        this.nodeNumber = 0;
        toDOTDefineNodes(r5, r10, r13);
        this.nodeNumber = 0;
        toDOTDefineEdges(r5, r10, r13);
        return r13;
    }

    public void toDOTDefineEdges(Object r11, TreeAdaptor r12, StringTemplate r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        int r5 = r12.getChildCount(r11);
        if (r5 != 0) goto L7;
        return;
    L7:
        String r10 = "n" + getNodeNumber(r11);
        String r14 = r12.getText(r11);
        int r15 = 0;
    L8:
        if (r15 >= r5) goto L10;
        Object r16 = r12.getChild(r11, r15);
        String r17 = r12.getText(r16);
        String r18 = "n" + getNodeNumber(r16);
        StringTemplate r19 = _edgeST.getInstanceOf();
        r19.setAttribute("parent", r10);
        r19.setAttribute("child", r18);
        r19.setAttribute("parentText", fixString(r14));
        r19.setAttribute("childText", fixString(r17));
        r13.setAttribute("edges", r19);
        toDOTDefineEdges(r16, r12, r13);
        r15 = r15 + 1;
        goto L8
    }

    public void toDOTDefineNodes(Object r10, TreeAdaptor r11, StringTemplate r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r5 = r11.getChildCount(r10);
        if (r5 != 0) goto L7;
        return;
    L7:
        r12.setAttribute("nodes", getNodeST(r11, r10));
        int r13 = 0;
    L8:
        if (r13 >= r5) goto L10;
        Object r14 = r11.getChild(r10, r13);
        r12.setAttribute("nodes", getNodeST(r11, r14));
        toDOTDefineNodes(r14, r11, r12);
        r13 = r13 + 1;
        goto L8
    }

    public StringTemplate toDOT(Object r5, TreeAdaptor r10) {
        return toDOT(r5, r10, _treeST, _edgeST);
    }

    public StringTemplate toDOT(Tree r5) {
        return toDOT(r5, new CommonTreeAdaptor());
    }
}
