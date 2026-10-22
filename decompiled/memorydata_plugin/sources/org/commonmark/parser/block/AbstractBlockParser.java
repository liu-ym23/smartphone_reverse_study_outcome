package org.commonmark.parser.block;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.commonmark.node.Block;
import org.commonmark.parser.InlineParser;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractBlockParser implements BlockParser {
    public AbstractBlockParser() {
    }

    @Override // org.commonmark.parser.block.BlockParser
    public void addLine(CharSequence r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
    }

    @Override // org.commonmark.parser.block.BlockParser
    public boolean canContain(Block r1) {
        return false;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public boolean canHaveLazyContinuationLines() {
        return false;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public void closeBlock() {
    }

    @Override // org.commonmark.parser.block.BlockParser
    public boolean isContainer() {
        return false;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public void parseInlines(InlineParser r2) {
        InlineParser r1 = (InlineParser) ZeusTransformUtils.wrapperContextForParams(r2, InlineParser.class, "com.obric.memorydata.plugin");
    }
}
