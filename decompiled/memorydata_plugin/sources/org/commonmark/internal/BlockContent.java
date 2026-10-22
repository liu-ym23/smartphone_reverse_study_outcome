package org.commonmark.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
class BlockContent {
    private int lineCount;
    private final StringBuilder sb;

    public BlockContent() {
        this.lineCount = 0;
        this.sb = new StringBuilder();
    }

    public void add(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.lineCount == 0) goto L5;
        this.sb.append('\n');
    L5:
        this.sb.append(r4);
        this.lineCount++;
    }

    public String getString() {
        return this.sb.toString();
    }
}
