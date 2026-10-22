package org.commonmark.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Pattern;
import org.commonmark.node.Block;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes7.dex */
public class HtmlBlockParser extends AbstractBlockParser {
    private static final Pattern[][] BLOCK_PATTERNS = null;
    private final HtmlBlock block;
    private final Pattern closingPattern;
    private BlockContent content;
    private boolean finished;

    /* JADX INFO: renamed from: org.commonmark.internal.HtmlBlockParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Factory extends AbstractBlockParserFactory {
        public Factory() {
        }

        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState r8, MatchedBlockParser r9) {
            ParserState r7 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r8, ParserState.class, "com.obric.memorydata.plugin");
            MatchedBlockParser r10 = (MatchedBlockParser) ZeusTransformUtils.wrapperContextForParams(r9, MatchedBlockParser.class, "com.obric.memorydata.plugin");
            int r11 = r7.getNextNonSpaceIndex();
            CharSequence r0 = r7.getLine();
            if (r7.getIndent() >= 4) goto L19;
            if (r0.charAt(r11) != '<') goto L19;
            int r2 = 1;
        L8:
            if (r2 > 7) goto L19;
            if (r2 == 7) goto L11;
        L13:
            Pattern r3 = HtmlBlockParser.access$000()[r2][0];
            Pattern r5 = HtmlBlockParser.access$000()[r2][1];
            if (r3.matcher(r0.subSequence(r11, r0.length())).find() == false) goto L17;
            return BlockStart.of(new BlockParser[]{new HtmlBlockParser(r5, null)}).atIndex(r7.getIndex());
        L17:
            r2 = r2 + 1;
            goto L8
        L11:
            if (ZeusTransformUtils.instanceOf(r10.getMatchedBlockParser().getBlock(), Paragraph.class) == false) goto L13;
        L19:
            return BlockStart.none();
        }
    }

    static {
        BLOCK_PATTERNS = new Pattern[][]{new Pattern[]{null, null}, new Pattern[]{Pattern.compile("^<(?:script|pre|style)(?:\\s|>|$)", 2), Pattern.compile("</(?:script|pre|style)>", 2)}, new Pattern[]{Pattern.compile("^<!--"), Pattern.compile("-->")}, new Pattern[]{Pattern.compile("^<[?]"), Pattern.compile("\\?>")}, new Pattern[]{Pattern.compile("^<![A-Z]"), Pattern.compile(">")}, new Pattern[]{Pattern.compile("^<!\\[CDATA\\["), Pattern.compile("\\]\\]>")}, new Pattern[]{Pattern.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|nav|noframes|ol|optgroup|option|p|param|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-_]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-_]*\\s*[>])\\s*$", 2), null}};
    }

    private HtmlBlockParser(Pattern r2) {
        this.block = new HtmlBlock();
        this.finished = false;
        this.content = new BlockContent();
        this.closingPattern = r2;
    }

    /* synthetic */ HtmlBlockParser(Pattern r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ Pattern[][] access$000() {
        return BLOCK_PATTERNS;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void addLine(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.content.add(r4);
        Pattern r0 = this.closingPattern;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.matcher(r4).find() == false) goto L9;
        this.finished = true;
        return;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void closeBlock() {
        this.block.setLiteral(this.content.getString());
        this.content = null;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState r3) {
        ParserState r4 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r3, ParserState.class, "com.obric.memorydata.plugin");
        if (this.finished == false) goto L7;
        return BlockContinue.none();
    L7:
        if (r4.isBlank() == false) goto L13;
        if (this.closingPattern != null) goto L13;
        return BlockContinue.none();
    L13:
        return BlockContinue.atIndex(r4.getIndex());
    }
}
