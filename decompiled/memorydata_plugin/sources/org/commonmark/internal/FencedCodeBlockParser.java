package org.commonmark.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes7.dex */
public class FencedCodeBlockParser extends AbstractBlockParser {
    private final FencedCodeBlock block;
    private String firstLine;
    private StringBuilder otherLines;

    public static class Factory extends AbstractBlockParserFactory {
        public Factory() {
        }

        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState r2, MatchedBlockParser r3) {
            ParserState r1 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r2, ParserState.class, "com.obric.memorydata.plugin");
            MatchedBlockParser r4 = (MatchedBlockParser) ZeusTransformUtils.wrapperContextForParams(r3, MatchedBlockParser.class, "com.obric.memorydata.plugin");
            int r5 = r1.getIndent();
            if (r5 >= Parsing.CODE_BLOCK_INDENT) goto L5;
            int r6 = r1.getNextNonSpaceIndex();
            FencedCodeBlockParser r7 = FencedCodeBlockParser.access$000(r1.getLine(), r6, r5);
            if (r7 == null) goto L11;
            return BlockStart.of(new BlockParser[]{r7}).atIndex(r6 + FencedCodeBlockParser.access$100(r7).getFenceLength());
        L11:
            return BlockStart.none();
        L5:
            return BlockStart.none();
        }
    }

    public FencedCodeBlockParser(char r3, int r4, int r5) {
        FencedCodeBlock r0 = new FencedCodeBlock();
        this.block = r0;
        this.otherLines = new StringBuilder();
        r0.setFenceChar(r3);
        r0.setFenceLength(r4);
        r0.setFenceIndent(r5);
    }

    static /* synthetic */ FencedCodeBlockParser access$000(CharSequence r2, int r3, int r4) {
        return checkOpener((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    static /* synthetic */ FencedCodeBlock access$100(FencedCodeBlockParser r0) {
        return r0.block;
    }

    private static FencedCodeBlockParser checkOpener(CharSequence r7, int r8, int r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r10.length();
        int r1 = 0;
        int r3 = r8;
        int r2 = 0;
    L4:
        if (r3 >= r0) goto L13;
        char r6 = r10.charAt(r3);
        if (r6 == '`') goto L10;
        if (r6 != '~') goto L13;
        r2 = r2 + 1;
    L11:
        r3 = r3 + 1;
        goto L4
    L10:
        r1 = r1 + 1;
    L13:
        if (r1 < 3) goto L20;
        if (r2 != 0) goto L20;
        if (Parsing.find('`', r10, r8 + r1) == (-1)) goto L19;
        return null;
    L19:
        return new FencedCodeBlockParser('`', r1, r9);
    L20:
        if (r2 < 3) goto L24;
        if (r1 != 0) goto L24;
        return new FencedCodeBlockParser('~', r2, r9);
    L24:
        return null;
    }

    private boolean isClosing(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        char r0 = this.block.getFenceChar();
        int r2 = this.block.getFenceLength();
        int r1 = Parsing.skip(r0, r5, r4, r5.length()) - r4;
        if (r1 >= r2) goto L6;
        return false;
    L6:
        if (Parsing.skipSpaceTab(r5, r4 + r1, r5.length()) != r5.length()) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void addLine(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.firstLine != null) goto L5;
        this.firstLine = r4.toString();
        return;
    L5:
        this.otherLines.append(r4);
        this.otherLines.append('\n');
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void closeBlock() {
        this.block.setInfo(Escaping.unescapeString(this.firstLine.trim()));
        this.block.setLiteral(this.otherLines.toString());
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState r5) {
        ParserState r6 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r5, ParserState.class, "com.obric.memorydata.plugin");
        int r0 = r6.getNextNonSpaceIndex();
        int r1 = r6.getIndex();
        CharSequence r2 = r6.getLine();
        if (r6.getIndent() < Parsing.CODE_BLOCK_INDENT) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r7 == true) goto L10;
        int r4 = this.block.getFenceIndent();
        int r8 = r2.length();
    L12:
        if (r4 <= 0) goto L18;
        if (r1 >= r8) goto L18;
        if (r2.charAt(r1) != ' ') goto L18;
        r1 = r1 + 1;
        r4 = r4 - 1;
    L18:
        return BlockContinue.atIndex(r1);
    L10:
        return BlockContinue.finished();
    L5:
        if (isClosing(r2, r0) == false) goto L7;
        r7 = true;
        goto L8
    }
}
