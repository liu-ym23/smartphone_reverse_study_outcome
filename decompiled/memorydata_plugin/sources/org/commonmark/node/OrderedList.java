package org.commonmark.node;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class OrderedList extends ListBlock {
    private char delimiter;
    private int originalStartNumber;
    private int startNumber;

    public OrderedList() {
    }

    @Override // org.commonmark.node.Node
    public void accept(Visitor r3) {
        ((Visitor) ZeusTransformUtils.wrapperContextForParams(r3, Visitor.class, "com.obric.memorydata.plugin")).visit(this);
    }

    public char getDelimiter() {
        return this.delimiter;
    }

    public int getOriginalStartNumber() {
        return this.originalStartNumber;
    }

    public int getStartNumber() {
        return this.startNumber;
    }

    public void setDelimiter(char r1) {
        this.delimiter = r1;
    }

    public void setOriginalStartNumber(int r1) {
        this.originalStartNumber = r1;
    }

    public void setStartNumber(int r1) {
        this.startNumber = r1;
    }
}
