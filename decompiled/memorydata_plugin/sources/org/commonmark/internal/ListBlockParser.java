package org.commonmark.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BulletList;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes7.dex */
public class ListBlockParser extends AbstractBlockParser {
    private final ListBlock block;
    private boolean hadBlankLine;
    private int linesAfterBlank;

    public static class Factory extends AbstractBlockParserFactory {
        public Factory() {
        }

        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState r7, MatchedBlockParser r8) {
            ParserState r6 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r7, ParserState.class, "com.obric.memorydata.plugin");
            MatchedBlockParser r9 = (MatchedBlockParser) ZeusTransformUtils.wrapperContextForParams(r8, MatchedBlockParser.class, "com.obric.memorydata.plugin");
            BlockParser r10 = r9.getMatchedBlockParser();
            if (r6.getIndent() >= Parsing.CODE_BLOCK_INDENT) goto L5;
            int r1 = r6.getNextNonSpaceIndex();
            int r2 = r6.getColumn() + r6.getIndent();
            if (r9.getParagraphContent() == null) goto L9;
            boolean r11 = true;
        L10:
            ListData r12 = ListBlockParser.access$000(r6.getLine(), r1, r2, r11);
            if (r12 == null) goto L13;
            int r3 = r12.contentColumn;
            ListItemParser r4 = new ListItemParser(r3 - r6.getColumn());
            if (ZeusTransformUtils.instanceOf(r10, ListBlockParser.class) == true) goto L17;
        L22:
            ListBlockParser r13 = new ListBlockParser(r12.listBlock);
            r12.listBlock.setTight(true);
            BlockStart r14 = BlockStart.of(new BlockParser[]{r13, r4});
        L21:
            return r14.atColumn(r3);
        L17:
            if (ListBlockParser.access$100((ListBlock) ZeusTransformUtils.preCheckCast(r10.getBlock(), ListBlock.class, "com.obric.memorydata.plugin"), r12.listBlock) == false) goto L22;
            r14 = BlockStart.of(new BlockParser[]{r4});
            goto L21
        L13:
            return BlockStart.none();
        L9:
            r11 = false;
            goto L10
        L5:
            return BlockStart.none();
        }
    }

    private static class ListData {
        final int contentColumn;
        final ListBlock listBlock;

        ListData(ListBlock r1, int r2) {
            this.listBlock = r1;
            this.contentColumn = r2;
        }
    }

    private static class ListMarkerData {
        final int indexAfterMarker;
        final ListBlock listBlock;

        ListMarkerData(ListBlock r1, int r2) {
            this.listBlock = r1;
            this.indexAfterMarker = r2;
        }
    }

    public ListBlockParser(ListBlock r1) {
        this.block = r1;
    }

    static /* synthetic */ ListData access$000(CharSequence r2, int r3, int r4, boolean r5) {
        return parseList((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3, r4, r5);
    }

    static /* synthetic */ boolean access$100(ListBlock r0, ListBlock r1) {
        return listsMatch(r0, r1);
    }

    private static boolean equals(Object r0, Object r1) {
        if (r0 != null) goto L7;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r0.equals(r1);
    }

    private static boolean isSpaceTabOrEnd(CharSequence r2, int r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 >= r4.length()) goto L10;
        char r5 = r4.charAt(r3);
        if (r5 == '\t') goto L10;
        if (r5 == ' ') goto L10;
        return false;
    L10:
        return true;
    }

    private static boolean listsMatch(ListBlock r2, ListBlock r3) {
        if (ZeusTransformUtils.instanceOf(r2, BulletList.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, BulletList.class) == false) goto L10;
        Character r4 = Character.valueOf(((BulletList) ZeusTransformUtils.preCheckCast(r2, BulletList.class, "com.obric.memorydata.plugin")).getBulletMarker());
        char r5 = ((BulletList) ZeusTransformUtils.preCheckCast(r3, BulletList.class, "com.obric.memorydata.plugin")).getBulletMarker();
    L8:
        return equals(r4, Character.valueOf(r5));
    L10:
        if (ZeusTransformUtils.instanceOf(r2, OrderedList.class) == true) goto L12;
        return false;
    L12:
        if (ZeusTransformUtils.instanceOf(r3, OrderedList.class) == false) goto L16;
        r4 = Character.valueOf(((OrderedList) ZeusTransformUtils.preCheckCast(r2, OrderedList.class, "com.obric.memorydata.plugin")).getDelimiter());
        r5 = ((OrderedList) ZeusTransformUtils.preCheckCast(r3, OrderedList.class, "com.obric.memorydata.plugin")).getDelimiter();
        goto L8
    L16:
        return false;
    }

    private static ListData parseList(CharSequence r9, int r10, int r11, boolean r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        ListMarkerData r0 = parseListMarker(r13, r10);
        if (r0 != null) goto L5;
        return null;
    L5:
        ListBlock r3 = r0.listBlock;
        int r1 = r0.indexAfterMarker;
        int r14 = r11 + (r1 - r10);
        boolean r15 = false;
        int r4 = r13.length();
        int r5 = r14;
    L7:
        if (r1 >= r4) goto L16;
        char r7 = r13.charAt(r1);
        if (r7 != '\t') goto L12;
        r5 = r5 + Parsing.columnsToNextTabStop(r5);
    L14:
        r1 = r1 + 1;
        goto L7
    L12:
        if (r7 != ' ') goto L15;
        r5 = r5 + 1;
        goto L14
    L15:
        r15 = true;
    L16:
        if (r12 == true) goto L18;
    L24:
        if (r15 == true) goto L26;
    L27:
        r5 = r14 + 1;
    L29:
        return new ListData(r3, r5);
    L26:
        if ((r5 - r14) <= Parsing.CODE_BLOCK_INDENT) goto L29;
    L18:
        if (ZeusTransformUtils.instanceOf(r3, OrderedList.class) == true) goto L20;
    L22:
        if (r15 == true) goto L24;
        return null;
    L20:
        if (((OrderedList) ZeusTransformUtils.preCheckCast(r3, OrderedList.class, "com.obric.memorydata.plugin")).getStartNumber() == 1) goto L22;
        return null;
    }

    private static ListMarkerData parseListMarker(CharSequence r2, int r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        char r0 = r4.charAt(r3);
        if (r0 != '*') goto L5;
    L10:
        int r5 = r3 + 1;
        if (isSpaceTabOrEnd(r4, r5) == false) goto L14;
        BulletList r6 = new BulletList();
        r6.setBulletMarker(r0);
        return new ListMarkerData(r6, r5);
    L14:
        return null;
    L5:
        if (r0 == '+') goto L10;
        if (r0 == '-') goto L10;
        return parseOrderedList(r4, r3);
    }

    private static ListMarkerData parseOrderedList(CharSequence r6, int r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r8.length();
        int r1 = 0;
        int r2 = r7;
    L4:
        if (r2 >= r0) goto L21;
        char r4 = r8.charAt(r2);
        if (r4 == ')') goto L16;
        if (r4 == '.') goto L16;
        switch(r4) {
            case 48: goto L11;
            case 49: goto L11;
            case 50: goto L11;
            case 51: goto L11;
            case 52: goto L11;
            case 53: goto L11;
            case 54: goto L11;
            case 55: goto L11;
            case 56: goto L11;
            case 57: goto L11;
            default: goto L10;
        };
    L11:
        r1 = r1 + 1;
        if (r1 > 9) goto L13;
        r2 = r2 + 1;
        goto L4
    L13:
        return null;
    L10:
        return null;
    L16:
        if (r1 < 1) goto L21;
        int r3 = r2 + 1;
        if (isSpaceTabOrEnd(r8, r3) == false) goto L21;
        String r9 = r8.subSequence(r7, r2).toString();
        OrderedList r10 = new OrderedList();
        r10.setStartNumber(Integer.parseInt(r9));
        r10.setOriginalStartNumber(Integer.parseInt(r9));
        r10.setDelimiter(r4);
        return new ListMarkerData(r10, r3);
    L21:
        return null;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean canContain(Block r3) {
        if (ZeusTransformUtils.instanceOf(r3, ListItem.class) == true) goto L5;
        return false;
    L5:
        if (this.hadBlankLine == true) goto L7;
    L9:
        return true;
    L7:
        if (this.linesAfterBlank != 1) goto L9;
        this.block.setTight(false);
        this.hadBlankLine = false;
        goto L9
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean isContainer() {
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState r3) {
        ParserState r4 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r3, ParserState.class, "com.obric.memorydata.plugin");
        if (r4.isBlank() == false) goto L7;
        this.hadBlankLine = true;
        int r0 = 0;
    L5:
        this.linesAfterBlank = r0;
    L10:
        return BlockContinue.atIndex(r4.getIndex());
    L7:
        if (this.hadBlankLine == false) goto L10;
        r0 = this.linesAfterBlank + 1;
        goto L5
    }
}
