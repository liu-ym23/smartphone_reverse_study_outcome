package org.commonmark.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.Heading;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes7.dex */
public class HeadingParser extends AbstractBlockParser {
    private final Heading block;
    private final String content;

    public static class Factory extends AbstractBlockParserFactory {
        public Factory() {
        }

        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState r4, MatchedBlockParser r5) {
            ParserState r3 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r4, ParserState.class, "com.obric.memorydata.plugin");
            MatchedBlockParser r6 = (MatchedBlockParser) ZeusTransformUtils.wrapperContextForParams(r5, MatchedBlockParser.class, "com.obric.memorydata.plugin");
            if (r3.getIndent() >= Parsing.CODE_BLOCK_INDENT) goto L5;
            CharSequence r7 = r3.getLine();
            int r8 = r3.getNextNonSpaceIndex();
            HeadingParser r0 = HeadingParser.access$000(r7, r8);
            if (r0 != null) goto L9;
            int r9 = HeadingParser.access$100(r7, r8);
            if (r9 <= 0) goto L17;
            CharSequence r10 = r6.getParagraphContent();
            if (r10 == null) goto L17;
            return BlockStart.of(new BlockParser[]{new HeadingParser(r9, r10.toString())}).atIndex(r7.length()).replaceActiveBlockParser();
        L17:
            return BlockStart.none();
        L9:
            return BlockStart.of(new BlockParser[]{r0}).atIndex(r7.length());
        L5:
            return BlockStart.none();
        }
    }

    public HeadingParser(int r2, String r3) {
        Heading r0 = new Heading();
        this.block = r0;
        r0.setLevel(r2);
        this.content = r3;
    }

    static /* synthetic */ HeadingParser access$000(CharSequence r2, int r3) {
        return getAtxHeading((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3);
    }

    static /* synthetic */ int access$100(CharSequence r2, int r3) {
        return getSetextHeadingLevel((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3);
    }

    private static HeadingParser getAtxHeading(CharSequence r5, int r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = Parsing.skip('#', r7, r6, r7.length()) - r6;
        if (r0 != 0) goto L5;
    L22:
        return null;
    L5:
        if (r0 > 6) goto L22;
        int r8 = r6 + r0;
        if (r8 >= r7.length()) goto L10;
        char r3 = r7.charAt(r8);
        if (r3 != ' ') goto L14;
    L16:
        int r2 = Parsing.skipSpaceTabBackwards(r7, r7.length() - 1, r8);
        int r1 = Parsing.skipBackwards('#', r7, r2, r8);
        int r4 = Parsing.skipSpaceTabBackwards(r7, r1, r8);
        if (r4 == r1) goto L21;
        return new HeadingParser(r0, r7.subSequence(r8, r4 + 1).toString());
    L21:
        return new HeadingParser(r0, r7.subSequence(r8, r2 + 1).toString());
    L14:
        if (r3 == '\t') goto L16;
        return null;
    L10:
        return new HeadingParser(r0, "");
    }

    private static int getSetextHeadingLevel(CharSequence r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        char r0 = r6.charAt(r5);
        if (r0 == '-') goto L11;
        if (r0 == '=') goto L8;
        return 0;
    L8:
        if (isSetextHeadingRest(r6, r5 + 1, '=') == false) goto L11;
        return 1;
    L11:
        if (isSetextHeadingRest(r6, r5 + 1, '-') == false) goto L14;
        return 2;
    L14:
        return 0;
    }

    private static boolean isSetextHeadingRest(CharSequence r2, int r3, char r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (Parsing.skipSpaceTab(r5, Parsing.skip(r4, r5, r3, r5.length()), r5.length()) < r5.length()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void parseInlines(InlineParser r3) {
        ((InlineParser) ZeusTransformUtils.wrapperContextForParams(r3, InlineParser.class, "com.obric.memorydata.plugin")).parse(this.content, this.block);
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState r2) {
        ParserState r1 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r2, ParserState.class, "com.obric.memorydata.plugin");
        return BlockContinue.none();
    }
}
