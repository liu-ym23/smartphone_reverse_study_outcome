package org.commonmark.internal.inline;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.commonmark.node.Emphasis;
import org.commonmark.node.Node;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* JADX INFO: loaded from: classes7.dex */
public abstract class EmphasisDelimiterProcessor implements DelimiterProcessor {
    private final char delimiterChar;

    public EmphasisDelimiterProcessor(char r1) {
        this.delimiterChar = r1;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getClosingCharacter() {
        return this.delimiterChar;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getDelimiterUse(DelimiterRun r2, DelimiterRun r3) {
        DelimiterRun r1 = (DelimiterRun) ZeusTransformUtils.wrapperContextForParams(r2, DelimiterRun.class, "com.obric.memorydata.plugin");
        DelimiterRun r4 = (DelimiterRun) ZeusTransformUtils.wrapperContextForParams(r3, DelimiterRun.class, "com.obric.memorydata.plugin");
        if (r1.canClose() == true) goto L7;
        if (r4.canOpen() == true) goto L7;
    L13:
        if (r1.length() >= 2) goto L15;
        return 1;
    L15:
        if (r4.length() < 2) goto L19;
        return 2;
    L19:
        return 1;
    L7:
        if ((r4.originalLength() % 3) == 0) goto L13;
        if (((r1.originalLength() + r4.originalLength()) % 3) != 0) goto L13;
        return 0;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getMinLength() {
        return 1;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getOpeningCharacter() {
        return this.delimiterChar;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public void process(Text r2, Text r3, int r4) {
        String r1 = String.valueOf(getOpeningCharacter());
        if (r4 != 1) goto L5;
        Node r5 = new Emphasis(r1);
    L6:
        Node r6 = r2.getNext();
    L7:
        if (r6 == null) goto L10;
        if (r6 == r3) goto L10;
        Node r0 = r6.getNext();
        r5.appendChild(r6);
        r6 = r0;
    L10:
        r2.insertAfter(r5);
        return;
    L5:
        r5 = new StrongEmphasis(r1 + r1);
        goto L6
    }
}
