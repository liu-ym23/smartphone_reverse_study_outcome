package org.commonmark.node;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class Image extends Node {
    private String destination;
    private String title;

    public Image() {
    }

    public Image(String r1, String r2) {
        this.destination = r1;
        this.title = r2;
    }

    @Override // org.commonmark.node.Node
    public void accept(Visitor r3) {
        ((Visitor) ZeusTransformUtils.wrapperContextForParams(r3, Visitor.class, "com.obric.memorydata.plugin")).visit(this);
    }

    public String getDestination() {
        return this.destination;
    }

    public String getTitle() {
        return this.title;
    }

    @Override // org.commonmark.node.Node
    public String toStringAttributes() {
        return "destination=" + this.destination + ", title=" + this.title;
    }
}
