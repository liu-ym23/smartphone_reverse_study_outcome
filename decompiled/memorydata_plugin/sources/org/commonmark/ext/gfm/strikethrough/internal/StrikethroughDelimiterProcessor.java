package org.commonmark.ext.gfm.strikethrough.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* JADX INFO: loaded from: classes7.dex */
public class StrikethroughDelimiterProcessor implements DelimiterProcessor {
    public StrikethroughDelimiterProcessor() {
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getClosingCharacter() {
        return '~';
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getDelimiterUse(DelimiterRun r2, DelimiterRun r3) {
        DelimiterRun r1 = (DelimiterRun) ZeusTransformUtils.wrapperContextForParams(r2, DelimiterRun.class, "com.obric.memorydata.plugin");
        DelimiterRun r4 = (DelimiterRun) ZeusTransformUtils.wrapperContextForParams(r3, DelimiterRun.class, "com.obric.memorydata.plugin");
        if (r1.length() >= 2) goto L5;
        return 0;
    L5:
        if (r4.length() < 2) goto L9;
        return 2;
    L9:
        return 0;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getMinLength() {
        return 2;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getOpeningCharacter() {
        return '~';
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public void process(Text r2, Text r3, int r4) {
        Strikethrough r1 = new Strikethrough();
        Node r5 = r2.getNext();
    L3:
        if (r5 == null) goto L6;
        if (r5 == r3) goto L6;
        Node r0 = r5.getNext();
        r1.appendChild(r5);
        r5 = r0;
    L6:
        r2.insertAfter(r1);
    }
}
