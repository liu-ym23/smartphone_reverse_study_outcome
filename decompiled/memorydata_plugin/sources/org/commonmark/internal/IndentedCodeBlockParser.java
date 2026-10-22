package org.commonmark.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes7.dex */
public class IndentedCodeBlockParser extends AbstractBlockParser {
    private final IndentedCodeBlock block;
    private final List<CharSequence> lines;

    public static class Factory extends AbstractBlockParserFactory {
        public Factory() {
        }

        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState r2, MatchedBlockParser r3) {
            ParserState r1 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r2, ParserState.class, "com.obric.memorydata.plugin");
            MatchedBlockParser r4 = (MatchedBlockParser) ZeusTransformUtils.wrapperContextForParams(r3, MatchedBlockParser.class, "com.obric.memorydata.plugin");
            if (r1.getIndent() < Parsing.CODE_BLOCK_INDENT) goto L11;
            if (r1.isBlank() == true) goto L11;
            if (ZeusTransformUtils.instanceOf(r1.getActiveBlockParser().getBlock(), Paragraph.class) == true) goto L11;
            return BlockStart.of(new BlockParser[]{new IndentedCodeBlockParser()}).atColumn(r1.getColumn() + Parsing.CODE_BLOCK_INDENT);
        L11:
            return BlockStart.none();
        }
    }

    public IndentedCodeBlockParser() {
        this.block = new IndentedCodeBlock();
        this.lines = new ArrayList();
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void addLine(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.lines.add(r4);
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void closeBlock() {
        int r0 = this.lines.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L9;
        if (Parsing.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(this.lines.get(r0), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L3;
    L9:
        StringBuilder r2 = new StringBuilder();
        int r3 = 0;
    L11:
        if (r3 >= (r0 + 1)) goto L13;
        r2.append((CharSequence) ZeusTransformUtils.preCheckCast(this.lines.get(r3), CharSequence.class, "com.obric.memorydata.plugin"));
        r2.append('\n');
        r3 = r3 + 1;
        goto L11
    L13:
        this.block.setLiteral(r2.toString());
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState r2) {
        ParserState r1 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r2, ParserState.class, "com.obric.memorydata.plugin");
        if (r1.getIndent() < Parsing.CODE_BLOCK_INDENT) goto L7;
        return BlockContinue.atColumn(r1.getColumn() + Parsing.CODE_BLOCK_INDENT);
    L7:
        if (r1.isBlank() == false) goto L11;
        return BlockContinue.atIndex(r1.getNextNonSpaceIndex());
    L11:
        return BlockContinue.none();
    }
}
