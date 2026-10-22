package org.commonmark.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes7.dex */
public class BlockQuoteParser extends AbstractBlockParser {
    private final BlockQuote block;

    public static class Factory extends AbstractBlockParserFactory {
        public Factory() {
        }

        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState r2, MatchedBlockParser r3) {
            ParserState r1 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r2, ParserState.class, "com.obric.memorydata.plugin");
            MatchedBlockParser r4 = (MatchedBlockParser) ZeusTransformUtils.wrapperContextForParams(r3, MatchedBlockParser.class, "com.obric.memorydata.plugin");
            int r5 = r1.getNextNonSpaceIndex();
            if (BlockQuoteParser.access$000(r1, r5) == false) goto L10;
            int r6 = (r1.getColumn() + r1.getIndent()) + 1;
            if (Parsing.isSpaceOrTab(r1.getLine(), r5 + 1) == false) goto L8;
            r6 = r6 + 1;
        L8:
            return BlockStart.of(new BlockParser[]{new BlockQuoteParser()}).atColumn(r6);
        L10:
            return BlockStart.none();
        }
    }

    public BlockQuoteParser() {
        this.block = new BlockQuote();
    }

    static /* synthetic */ boolean access$000(ParserState r2, int r3) {
        return isMarker((ParserState) ZeusTransformUtils.wrapperContextForParams(r2, ParserState.class, "com.obric.memorydata.plugin"), r3);
    }

    private static boolean isMarker(ParserState r2, int r3) {
        ParserState r4 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r2, ParserState.class, "com.obric.memorydata.plugin");
        CharSequence r0 = r4.getLine();
        if (r4.getIndent() < Parsing.CODE_BLOCK_INDENT) goto L5;
    L9:
        return false;
    L5:
        if (r3 >= r0.length()) goto L9;
        if (r0.charAt(r3) != '>') goto L9;
        return true;
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
    public BlockQuote getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean isContainer() {
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState r3) {
        ParserState r2 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r3, ParserState.class, "com.obric.memorydata.plugin");
        int r4 = r2.getNextNonSpaceIndex();
        if (isMarker(r2, r4) == false) goto L10;
        int r0 = (r2.getColumn() + r2.getIndent()) + 1;
        if (Parsing.isSpaceOrTab(r2.getLine(), r4 + 1) == false) goto L8;
        r0 = r0 + 1;
    L8:
        return BlockContinue.atColumn(r0);
    L10:
        return BlockContinue.none();
    }
}
