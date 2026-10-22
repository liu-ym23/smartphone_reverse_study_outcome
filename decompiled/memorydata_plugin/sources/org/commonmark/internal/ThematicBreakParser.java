package org.commonmark.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.commonmark.node.Block;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes7.dex */
public class ThematicBreakParser extends AbstractBlockParser {
    private final ThematicBreak block;

    public static class Factory extends AbstractBlockParserFactory {
        public Factory() {
        }

        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState r2, MatchedBlockParser r3) {
            ParserState r1 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r2, ParserState.class, "com.obric.memorydata.plugin");
            MatchedBlockParser r4 = (MatchedBlockParser) ZeusTransformUtils.wrapperContextForParams(r3, MatchedBlockParser.class, "com.obric.memorydata.plugin");
            if (r1.getIndent() >= 4) goto L5;
            int r5 = r1.getNextNonSpaceIndex();
            CharSequence r6 = r1.getLine();
            if (ThematicBreakParser.access$000(r6, r5) == false) goto L11;
            return BlockStart.of(new BlockParser[]{new ThematicBreakParser()}).atIndex(r6.length());
        L11:
            return BlockStart.none();
        L5:
            return BlockStart.none();
        }
    }

    public ThematicBreakParser() {
        this.block = new ThematicBreak();
    }

    static /* synthetic */ boolean access$000(CharSequence r2, int r3) {
        return isThematicBreak((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3);
    }

    private static boolean isThematicBreak(CharSequence r7, int r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r9.length();
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r8 >= r0) goto L20;
        char r5 = r9.charAt(r8);
        if (r5 == '\t') goto L18;
        if (r5 == ' ') goto L18;
        if (r5 != '*') goto L11;
        r4 = r4 + 1;
        goto L18
    L11:
        if (r5 != '-') goto L13;
        r2 = r2 + 1;
        goto L18
    L13:
        if (r5 != '_') goto L14;
        r3 = r3 + 1;
        goto L18
    L14:
        return false;
    L18:
        r8 = r8 + 1;
        goto L3
    L20:
        if (r2 < 3) goto L23;
        if (r3 != 0) goto L23;
        if (r4 != 0) goto L23;
    L29:
        return true;
    L23:
        if (r3 < 3) goto L26;
        if (r2 != 0) goto L26;
        if (r4 == 0) goto L29;
    L26:
        if (r4 < 3) goto L38;
        if (r2 != 0) goto L39;
        if (r3 == 0) goto L29;
        return false;
    L39:
        return false;
    L38:
        return false;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState r2) {
        ParserState r1 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r2, ParserState.class, "com.obric.memorydata.plugin");
        return BlockContinue.none();
    }
}
