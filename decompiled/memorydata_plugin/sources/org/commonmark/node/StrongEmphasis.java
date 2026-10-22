package org.commonmark.node;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class StrongEmphasis extends Node {
    private String delimiter;

    public StrongEmphasis() {
    }

    public StrongEmphasis(String r1) {
        this.delimiter = r1;
    }

    @Override // org.commonmark.node.Node
    public void accept(Visitor r3) {
        ((Visitor) ZeusTransformUtils.wrapperContextForParams(r3, Visitor.class, "com.obric.memorydata.plugin")).visit(this);
    }

    public String getOpeningDelimiter() {
        return this.delimiter;
    }
}
