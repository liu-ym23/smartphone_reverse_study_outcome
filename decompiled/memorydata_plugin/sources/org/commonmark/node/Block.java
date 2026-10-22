package org.commonmark.node;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Block extends Node {
    public Block() {
    }

    @Override // org.commonmark.node.Node
    public Block getParent() {
        return (Block) ZeusTransformUtils.preCheckCast(super.getParent(), Block.class, "com.obric.memorydata.plugin");
    }

    @Override // org.commonmark.node.Node
    public /* bridge */ /* synthetic */ Node getParent() {
        return getParent();
    }

    @Override // org.commonmark.node.Node
    public void setParent(Node r2) {
        if (ZeusTransformUtils.instanceOf(r2, Block.class) == false) goto L7;
        super.setParent(r2);
        return;
    L7:
        throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
    }
}
