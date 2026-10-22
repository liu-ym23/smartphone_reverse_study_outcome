package io.noties.markwon.inlineparser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* JADX INFO: loaded from: classes6.dex */
class p implements DelimiterProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f16637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16638b;
    private LinkedList<DelimiterProcessor> c;

    p(char r2) {
        this.f16638b = 0;
        this.c = new LinkedList();
        this.f16637a = r2;
    }

    private DelimiterProcessor a(int r5) {
        Iterator<DelimiterProcessor> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        DelimiterProcessor r1 = (DelimiterProcessor) ZeusTransformUtils.preCheckCast(r0.next(), DelimiterProcessor.class, "com.obric.memorydata.plugin");
        if (r1.getMinLength() > r5) goto L4;
        return r1;
    L9:
        return (DelimiterProcessor) ZeusTransformUtils.preCheckCast(this.c.getFirst(), DelimiterProcessor.class, "com.obric.memorydata.plugin");
    }

    void a(DelimiterProcessor r6) {
        DelimiterProcessor r7 = (DelimiterProcessor) ZeusTransformUtils.wrapperContextForParams(r6, DelimiterProcessor.class, "com.obric.memorydata.plugin");
        int r0 = r7.getMinLength();
        ListIterator<DelimiterProcessor> r2 = this.c.listIterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        int r3 = ((DelimiterProcessor) ZeusTransformUtils.preCheckCast(r2.next(), DelimiterProcessor.class, "com.obric.memorydata.plugin")).getMinLength();
        if (r0 > r3) goto L7;
        if (r0 != r3) goto L4;
        throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.f16637a + "' and minimum length " + r0);
    L7:
        r2.previous();
        r2.add(r7);
        boolean r1 = true;
    L13:
        if (r1 == true) goto L20;
        this.c.add(r7);
        this.f16638b = r0;
        return;
    L20:
        return;
    L12:
        r1 = false;
        goto L13
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getClosingCharacter() {
        return this.f16637a;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getDelimiterUse(DelimiterRun r3, DelimiterRun r4) {
        DelimiterRun r5 = (DelimiterRun) ZeusTransformUtils.wrapperContextForParams(r3, DelimiterRun.class, "com.obric.memorydata.plugin");
        DelimiterRun r6 = (DelimiterRun) ZeusTransformUtils.wrapperContextForParams(r4, DelimiterRun.class, "com.obric.memorydata.plugin");
        return a(r5.length()).getDelimiterUse(r5, r6);
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getMinLength() {
        return this.f16638b;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getOpeningCharacter() {
        return this.f16637a;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public void process(Text r1, Text r2, int r3) {
        a(r3).process(r1, r2, r3);
    }
}
