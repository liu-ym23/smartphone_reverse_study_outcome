package org.commonmark.node;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class ListItem extends Block {
    public ListItem() {
    }

    @Override // org.commonmark.node.Node
    public void accept(Visitor r3) {
        ((Visitor) ZeusTransformUtils.wrapperContextForParams(r3, Visitor.class, "com.obric.memorydata.plugin")).visit(this);
    }
}
