package org.commonmark.node;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class LinkReferenceDefinition extends Node {
    private String destination;
    private String label;
    private String title;

    public LinkReferenceDefinition() {
    }

    public LinkReferenceDefinition(String r1, String r2, String r3) {
        this.label = r1;
        this.destination = r2;
        this.title = r3;
    }

    @Override // org.commonmark.node.Node
    public void accept(Visitor r3) {
        ((Visitor) ZeusTransformUtils.wrapperContextForParams(r3, Visitor.class, "com.obric.memorydata.plugin")).visit(this);
    }

    public String getDestination() {
        return this.destination;
    }

    public String getLabel() {
        return this.label;
    }

    public String getTitle() {
        return this.title;
    }
}
