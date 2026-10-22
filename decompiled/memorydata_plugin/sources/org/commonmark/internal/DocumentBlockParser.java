package org.commonmark.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.commonmark.node.Block;
import org.commonmark.node.Document;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes7.dex */
public class DocumentBlockParser extends AbstractBlockParser {
    private final Document document;

    public DocumentBlockParser() {
        this.document = new Document();
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void addLine(CharSequence r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean canContain(Block r1) {
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public /* bridge */ /* synthetic */ Block getBlock() {
        return getBlock();
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Document getBlock() {
        return this.document;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean isContainer() {
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState r2) {
        return BlockContinue.atIndex(((ParserState) ZeusTransformUtils.wrapperContextForParams(r2, ParserState.class, "com.obric.memorydata.plugin")).getIndex());
    }
}
