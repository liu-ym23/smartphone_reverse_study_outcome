package org.commonmark.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* JADX INFO: loaded from: classes7.dex */
class StaggeredDelimiterProcessor implements DelimiterProcessor {
    private final char delim;
    private int minLength;
    private LinkedList<DelimiterProcessor> processors;

    StaggeredDelimiterProcessor(char r2) {
        this.minLength = 0;
        this.processors = new LinkedList();
        this.delim = r2;
    }

    private DelimiterProcessor findProcessor(int r5) {
        Iterator<DelimiterProcessor> r0 = this.processors.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        DelimiterProcessor r1 = (DelimiterProcessor) ZeusTransformUtils.preCheckCast(r0.next(), DelimiterProcessor.class, "com.obric.memorydata.plugin");
        if (r1.getMinLength() > r5) goto L4;
        return r1;
    L9:
        return (DelimiterProcessor) ZeusTransformUtils.preCheckCast(this.processors.getFirst(), DelimiterProcessor.class, "com.obric.memorydata.plugin");
    }

    void add(DelimiterProcessor r6) {
        DelimiterProcessor r7 = (DelimiterProcessor) ZeusTransformUtils.wrapperContextForParams(r6, DelimiterProcessor.class, "com.obric.memorydata.plugin");
        int r0 = r7.getMinLength();
        ListIterator<DelimiterProcessor> r2 = this.processors.listIterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        int r3 = ((DelimiterProcessor) ZeusTransformUtils.preCheckCast(r2.next(), DelimiterProcessor.class, "com.obric.memorydata.plugin")).getMinLength();
        if (r0 > r3) goto L7;
        if (r0 != r3) goto L4;
        throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.delim + "' and minimum length " + r0);
    L7:
        r2.previous();
        r2.add(r7);
        boolean r1 = true;
    L13:
        if (r1 == true) goto L20;
        this.processors.add(r7);
        this.minLength = r0;
        return;
    L20:
        return;
    L12:
        r1 = false;
        goto L13
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getClosingCharacter() {
        return this.delim;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getDelimiterUse(DelimiterRun r3, DelimiterRun r4) {
        DelimiterRun r5 = (DelimiterRun) ZeusTransformUtils.wrapperContextForParams(r3, DelimiterRun.class, "com.obric.memorydata.plugin");
        DelimiterRun r6 = (DelimiterRun) ZeusTransformUtils.wrapperContextForParams(r4, DelimiterRun.class, "com.obric.memorydata.plugin");
        return findProcessor(r5.length()).getDelimiterUse(r5, r6);
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getMinLength() {
        return this.minLength;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getOpeningCharacter() {
        return this.delim;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public void process(Text r1, Text r2, int r3) {
        findProcessor(r3).process(r1, r2, r3);
    }
}
