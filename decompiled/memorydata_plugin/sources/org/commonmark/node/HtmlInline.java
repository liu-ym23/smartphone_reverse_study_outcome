package org.commonmark.node;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class HtmlInline extends Node {
    private String literal;

    public HtmlInline() {
    }

    @Override // org.commonmark.node.Node
    public void accept(Visitor r3) {
        ((Visitor) ZeusTransformUtils.wrapperContextForParams(r3, Visitor.class, "com.obric.memorydata.plugin")).visit(this);
    }

    public String getLiteral() {
        return this.literal;
    }

    public void setLiteral(String r1) {
        this.literal = r1;
    }
}
