package org.commonmark.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.Document;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.InlineParserFactory;
import org.commonmark.parser.Parser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockParserFactory;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* JADX INFO: loaded from: classes7.dex */
public class DocumentParser implements ParserState {
    private static final Set<Class<? extends Block>> CORE_FACTORY_TYPES = null;
    private static final Map<Class<? extends Block>, BlockParserFactory> NODES_TO_CORE_FACTORIES = null;
    private List<BlockParser> activeBlockParsers;
    private Set<BlockParser> allBlockParsers;
    private boolean blank;
    private final List<BlockParserFactory> blockParserFactories;
    private int column;
    private boolean columnIsInTab;
    private final Map<String, LinkReferenceDefinition> definitions;
    private final List<DelimiterProcessor> delimiterProcessors;
    private final DocumentBlockParser documentBlockParser;
    private int indent;
    private int index;
    private final InlineParserFactory inlineParserFactory;
    private CharSequence line;
    private final Parser.LinkReferenceChecker linkReferenceChecker;
    private int nextNonSpace;
    private int nextNonSpaceColumn;

    private static class MatchedBlockParserImpl implements MatchedBlockParser {
        private final BlockParser matchedBlockParser;

        public MatchedBlockParserImpl(BlockParser r3) {
            this.matchedBlockParser = (BlockParser) ZeusTransformUtils.wrapperContextForParams(r3, BlockParser.class, "com.obric.memorydata.plugin");
        }

        @Override // org.commonmark.parser.block.MatchedBlockParser
        public BlockParser getMatchedBlockParser() {
            return this.matchedBlockParser;
        }

        @Override // org.commonmark.parser.block.MatchedBlockParser
        public CharSequence getParagraphContent() {
            if (ZeusTransformUtils.instanceOf(this.matchedBlockParser, ParagraphParser.class) == false) goto L8;
            CharSequence r3 = ((ParagraphParser) ZeusTransformUtils.preCheckCast(this.matchedBlockParser, ParagraphParser.class, "com.obric.memorydata.plugin")).getContentString();
            if (r3.length() != 0) goto L7;
            return null;
        L7:
            return r3;
        L8:
            return null;
        }
    }

    static {
        CORE_FACTORY_TYPES = new LinkedHashSet(Arrays.asList(new Class[]{BlockQuote.class, Heading.class, FencedCodeBlock.class, HtmlBlock.class, ThematicBreak.class, ListBlock.class, IndentedCodeBlock.class}));
        HashMap r0 = new HashMap();
        r0.put(BlockQuote.class, new BlockQuoteParser.Factory());
        r0.put(Heading.class, new HeadingParser.Factory());
        r0.put(FencedCodeBlock.class, new FencedCodeBlockParser.Factory());
        r0.put(HtmlBlock.class, new HtmlBlockParser.Factory());
        r0.put(ThematicBreak.class, new ThematicBreakParser.Factory());
        r0.put(ListBlock.class, new ListBlockParser.Factory());
        r0.put(IndentedCodeBlock.class, new IndentedCodeBlockParser.Factory());
        NODES_TO_CORE_FACTORIES = Collections.unmodifiableMap(r0);
    }

    public DocumentParser(List<BlockParserFactory> r3, InlineParserFactory r4, List<DelimiterProcessor> r5, Parser.LinkReferenceChecker r6) {
        List<BlockParserFactory> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        InlineParserFactory r8 = (InlineParserFactory) ZeusTransformUtils.wrapperContextForParams(r4, InlineParserFactory.class, "com.obric.memorydata.plugin");
        List<DelimiterProcessor> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Parser.LinkReferenceChecker r10 = (Parser.LinkReferenceChecker) ZeusTransformUtils.wrapperContextForParams(r6, Parser.LinkReferenceChecker.class, "com.obric.memorydata.plugin");
        this.index = 0;
        this.column = 0;
        this.nextNonSpace = 0;
        this.nextNonSpaceColumn = 0;
        this.indent = 0;
        this.definitions = new LinkedHashMap();
        this.activeBlockParsers = new ArrayList();
        this.allBlockParsers = new LinkedHashSet();
        this.blockParserFactories = r7;
        this.inlineParserFactory = r8;
        this.delimiterProcessors = r9;
        this.linkReferenceChecker = r10;
        DocumentBlockParser r11 = new DocumentBlockParser();
        this.documentBlockParser = r11;
        activateBlockParser(r11);
    }

    private void activateBlockParser(BlockParser r3) {
        BlockParser r4 = (BlockParser) ZeusTransformUtils.wrapperContextForParams(r3, BlockParser.class, "com.obric.memorydata.plugin");
        this.activeBlockParsers.add(r4);
        this.allBlockParsers.add(r4);
    }

    private <T extends BlockParser> T addChild(T r3) {
        T r4 = (T) ZeusTransformUtils.wrapperContextForParams(r3, BlockParser.class, "com.obric.memorydata.plugin");
    L4:
        if (getActiveBlockParser().canContain(r4.getBlock()) == true) goto L6;
        finalize(getActiveBlockParser());
        goto L4
    L6:
        getActiveBlockParser().getBlock().appendChild(r4.getBlock());
        activateBlockParser(r4);
        return r4;
    }

    private void addDefinitionsFrom(ParagraphParser r5) {
        Iterator<LinkReferenceDefinition> r0 = r5.getDefinitions().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        LinkReferenceDefinition r1 = (LinkReferenceDefinition) ZeusTransformUtils.preCheckCast(r0.next(), LinkReferenceDefinition.class, "com.obric.memorydata.plugin");
        r5.getBlock().insertBefore(r1);
        String r2 = r1.getLabel();
        if (this.definitions.containsKey(r2) == true) goto L4;
        this.definitions.put(r2, r1);
        goto L4
    }

    private void addLine() {
        if (this.columnIsInTab == false) goto L8;
        int r0 = this.index + 1;
        CharSequence r1 = this.line;
        CharSequence r2 = r1.subSequence(r0, r1.length());
        int r3 = Parsing.columnsToNextTabStop(this.column);
        StringBuilder r4 = new StringBuilder(r2.length() + r3);
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L7;
        r4.append(' ');
        r5 = r5 + 1;
        goto L5
    L7:
        r4.append(r2);
        CharSequence r6 = r4.toString();
    L9:
        getActiveBlockParser().addLine(r6);
        return;
    L8:
        CharSequence r7 = this.line;
        r6 = r7.subSequence(this.index, r7.length());
        goto L9
    }

    private void advance() {
        if (this.line.charAt(this.index) != '\t') goto L5;
        this.index++;
        int r0 = this.column;
        int r1 = r0 + Parsing.columnsToNextTabStop(r0);
    L6:
        this.column = r1;
        return;
    L5:
        this.index++;
        r1 = this.column + 1;
        goto L6
    }

    public static List<BlockParserFactory> calculateBlockParserFactories(List<BlockParserFactory> r3, Set<Class<? extends Block>> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        r0.addAll(r5);
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Class r8 = (Class) ZeusTransformUtils.preCheckCast(r7.next(), Class.class, "com.obric.memorydata.plugin");
        r0.add(NODES_TO_CORE_FACTORIES.get(r8));
        goto L4
    L6:
        return r0;
    }

    private void deactivateBlockParser() {
        List<BlockParser> r1 = this.activeBlockParsers;
        r1.remove(r1.size() - 1);
    }

    private void finalize(BlockParser r3) {
        BlockParser r4 = (BlockParser) ZeusTransformUtils.wrapperContextForParams(r3, BlockParser.class, "com.obric.memorydata.plugin");
        if (getActiveBlockParser() != r4) goto L6;
        deactivateBlockParser();
    L6:
        if (ZeusTransformUtils.instanceOf(r4, ParagraphParser.class) == false) goto L8;
        addDefinitionsFrom((ParagraphParser) ZeusTransformUtils.preCheckCast(r4, ParagraphParser.class, "com.obric.memorydata.plugin"));
    L8:
        r4.closeBlock();
    }

    private Document finalizeAndProcess() {
        finalizeBlocks(this.activeBlockParsers);
        processInlines();
        return this.documentBlockParser.getBlock();
    }

    private void finalizeBlocks(List<BlockParser> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        int r0 = r6.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        finalize((BlockParser) ZeusTransformUtils.preCheckCast(r6.get(r0), BlockParser.class, "com.obric.memorydata.plugin"));
        r0 = r0 - 1;
        goto L3
    }

    private BlockStartImpl findBlockStart(BlockParser r5) {
        MatchedBlockParserImpl r0 = new MatchedBlockParserImpl((BlockParser) ZeusTransformUtils.wrapperContextForParams(r5, BlockParser.class, "com.obric.memorydata.plugin"));
        Iterator<BlockParserFactory> r6 = this.blockParserFactories.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        BlockStart r2 = ((BlockParserFactory) ZeusTransformUtils.preCheckCast(r6.next(), BlockParserFactory.class, "com.obric.memorydata.plugin")).tryStart(this, r0);
        if (ZeusTransformUtils.instanceOf(r2, BlockStartImpl.class) == false) goto L4;
        return (BlockStartImpl) ZeusTransformUtils.preCheckCast(r2, BlockStartImpl.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    }

    private void findNextNonSpace() {
        int r0 = this.index;
        int r1 = this.column;
        this.blank = true;
        int r2 = this.line.length();
    L3:
        if (r0 >= r2) goto L11;
        char r3 = this.line.charAt(r0);
        if (r3 != '\t') goto L7;
        r0 = r0 + 1;
        r1 = r1 + (4 - (r1 % 4));
        goto L3
    L7:
        if (r3 != ' ') goto L8;
        r0 = r0 + 1;
        r1 = r1 + 1;
        goto L3
    L8:
        this.blank = false;
    L11:
        this.nextNonSpace = r0;
        this.nextNonSpaceColumn = r1;
        this.indent = r1 - this.column;
    }

    public static Set<Class<? extends Block>> getDefaultBlockParserTypes() {
        return CORE_FACTORY_TYPES;
    }

    private void incorporateLine(CharSequence r11) {
        this.line = Parsing.prepareLine((CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin"));
        this.index = 0;
        this.column = 0;
        this.columnIsInTab = false;
        List<BlockParser> r0 = this.activeBlockParsers;
        Iterator<BlockParser> r1 = r0.subList(1, r0.size()).iterator();
        int r2 = 1;
    L4:
        if (r1.hasNext() == false) goto L18;
        BlockParser r4 = (BlockParser) ZeusTransformUtils.preCheckCast(r1.next(), BlockParser.class, "com.obric.memorydata.plugin");
        findNextNonSpace();
        BlockContinue r6 = r4.tryContinue(this);
        if (ZeusTransformUtils.instanceOf(r6, BlockContinueImpl.class) == false) goto L18;
        BlockContinueImpl r7 = (BlockContinueImpl) ZeusTransformUtils.preCheckCast(r6, BlockContinueImpl.class, "com.obric.memorydata.plugin");
        if (r7.isFinalize() == true) goto L9;
        if (r7.getNewIndex() == (-1)) goto L15;
        setNewIndex(r7.getNewIndex());
    L17:
        r2 = r2 + 1;
        goto L4
    L15:
        if (r7.getNewColumn() == (-1)) goto L17;
        setNewColumn(r7.getNewColumn());
        goto L17
    L9:
        finalize(r4);
        return;
    L18:
        List<BlockParser> r5 = this.activeBlockParsers;
        ArrayList r3 = new ArrayList(r5.subList(r2, r5.size()));
        BlockParser r8 = (BlockParser) ZeusTransformUtils.preCheckCast(this.activeBlockParsers.get(r2 - 1), BlockParser.class, "com.obric.memorydata.plugin");
        boolean r9 = r3.isEmpty();
        if (ZeusTransformUtils.instanceOf(r8.getBlock(), Paragraph.class) == false) goto L21;
    L24:
        boolean r10 = true;
    L25:
        if (r10 == false) goto L51;
        findNextNonSpace();
        if (isBlank() == true) goto L50;
        if (this.indent < Parsing.CODE_BLOCK_INDENT) goto L31;
    L33:
        BlockStartImpl r12 = findBlockStart(r8);
        if (r12 == null) goto L50;
        if (r9 == true) goto L39;
        finalizeBlocks(r3);
        r9 = true;
    L39:
        if (r12.getNewIndex() == (-1)) goto L42;
        setNewIndex(r12.getNewIndex());
    L45:
        if (r12.isReplaceActiveBlockParser() == false) goto L47;
        prepareActiveBlockParserForReplacement();
    L47:
        BlockParser[] r13 = r12.getBlockParsers();
        int r14 = r13.length;
        int r15 = 0;
    L48:
        if (r15 >= r14) goto L25;
        BlockParser r16 = r13[r15];
        BlockParser r17 = addChild(r16);
        r15 = r15 + 1;
        r10 = r16.isContainer();
        r8 = r17;
        goto L48
    L42:
        if (r12.getNewColumn() == (-1)) goto L45;
        setNewColumn(r12.getNewColumn());
        goto L45
    L31:
        if (Parsing.isLetter(this.line, this.nextNonSpace) == false) goto L33;
    L50:
        setNewIndex(this.nextNonSpace);
    L51:
        if (r9 == false) goto L53;
    L57:
        if (r9 == true) goto L60;
        finalizeBlocks(r3);
    L60:
        if (r8.isContainer() == true) goto L63;
    L61:
        addLine();
        return;
    L63:
        if (isBlank() == true) goto L80;
        addChild(new ParagraphParser(this.linkReferenceChecker));
        goto L61
    L80:
        return;
    L53:
        if (isBlank() == true) goto L57;
        if (getActiveBlockParser().canHaveLazyContinuationLines() == false) goto L57;
    L21:
        if (r8.isContainer() == true) goto L24;
        r10 = false;
        goto L25
    }

    private void prepareActiveBlockParserForReplacement() {
        BlockParser r0 = getActiveBlockParser();
        deactivateBlockParser();
        this.allBlockParsers.remove(r0);
        if (ZeusTransformUtils.instanceOf(r0, ParagraphParser.class) == false) goto L5;
        addDefinitionsFrom((ParagraphParser) ZeusTransformUtils.preCheckCast(r0, ParagraphParser.class, "com.obric.memorydata.plugin"));
    L5:
        r0.getBlock().unlink();
    }

    private void processInlines() {
        InlineParserContextImpl r0 = new InlineParserContextImpl(this.delimiterProcessors, this.definitions);
        InlineParser r1 = this.inlineParserFactory.create(r0);
        Iterator<BlockParser> r4 = this.allBlockParsers.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((BlockParser) ZeusTransformUtils.preCheckCast(r4.next(), BlockParser.class, "com.obric.memorydata.plugin")).parseInlines(r1);
        goto L4
    }

    private void setNewColumn(int r4) {
        int r0 = this.nextNonSpaceColumn;
        if (r4 < r0) goto L5;
        this.index = this.nextNonSpace;
        this.column = r0;
    L5:
        int r1 = this.line.length();
    L6:
        int r2 = this.column;
        if (r2 >= r4) goto L11;
        if (this.index == r1) goto L11;
        advance();
    L11:
        if (r2 <= r4) goto L13;
        this.index--;
        this.column = r4;
        this.columnIsInTab = true;
        return;
    L13:
        this.columnIsInTab = false;
    }

    private void setNewIndex(int r3) {
        int r0 = this.nextNonSpace;
        if (r3 < r0) goto L5;
        this.index = r0;
        this.column = this.nextNonSpaceColumn;
    L5:
        int r1 = this.line.length();
    L6:
        int r2 = this.index;
        if (r2 >= r3) goto L10;
        if (r2 == r1) goto L10;
        advance();
    L10:
        this.columnIsInTab = false;
    }

    @Override // org.commonmark.parser.block.ParserState
    public BlockParser getActiveBlockParser() {
        List<BlockParser> r2 = this.activeBlockParsers;
        return (BlockParser) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), BlockParser.class, "com.obric.memorydata.plugin");
    }

    @Override // org.commonmark.parser.block.ParserState
    public int getColumn() {
        return this.column;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int getIndent() {
        return this.indent;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int getIndex() {
        return this.index;
    }

    @Override // org.commonmark.parser.block.ParserState
    public CharSequence getLine() {
        return this.line;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int getNextNonSpaceIndex() {
        return this.nextNonSpace;
    }

    @Override // org.commonmark.parser.block.ParserState
    public boolean isBlank() {
        return this.blank;
    }

    public Document parse(String r5) {
        int r0 = 0;
    L3:
        int r1 = Parsing.findLineBreak(r5, r0);
        if (r1 == (-1)) goto L13;
        incorporateLine(r5.substring(r0, r1));
        r0 = r1 + 1;
        if (r0 >= r5.length()) goto L3;
        if (r5.charAt(r1) != '\r') goto L3;
        if (r5.charAt(r0) != '\n') goto L3;
        r0 = r1 + 2;
        goto L3
    L13:
        if (r5.length() <= 0) goto L19;
        if (r0 != 0) goto L16;
    L17:
        incorporateLine(r5.substring(r0));
        goto L19
    L16:
        if (r0 < r5.length()) goto L17;
    L19:
        return finalizeAndProcess();
    }
}
