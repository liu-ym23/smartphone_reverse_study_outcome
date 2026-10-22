package org.commonmark.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.commonmark.node.Block;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.Parser;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes7.dex */
public class ParagraphParser extends AbstractBlockParser {
    private final Paragraph block;
    private LinkReferenceDefinitionParser linkReferenceDefinitionParser;

    public ParagraphParser() {
        this(null);
    }

    public ParagraphParser(Parser.LinkReferenceChecker r3) {
        Parser.LinkReferenceChecker r4 = (Parser.LinkReferenceChecker) ZeusTransformUtils.wrapperContextForParams(r3, Parser.LinkReferenceChecker.class, "com.obric.memorydata.plugin");
        this.block = new Paragraph();
        this.linkReferenceDefinitionParser = new LinkReferenceDefinitionParser(r4);
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void addLine(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.linkReferenceDefinitionParser.parse(r4);
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean canHaveLazyContinuationLines() {
        return true;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void closeBlock() {
        if (this.linkReferenceDefinitionParser.getParagraphContent().length() != 0) goto L6;
        this.block.unlink();
        return;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    public CharSequence getContentString() {
        return this.linkReferenceDefinitionParser.getParagraphContent();
    }

    public List<LinkReferenceDefinition> getDefinitions() {
        return this.linkReferenceDefinitionParser.getDefinitions();
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void parseInlines(InlineParser r3) {
        InlineParser r4 = (InlineParser) ZeusTransformUtils.wrapperContextForParams(r3, InlineParser.class, "com.obric.memorydata.plugin");
        CharSequence r0 = this.linkReferenceDefinitionParser.getParagraphContent();
        if (r0.length() <= 0) goto L6;
        r4.parse(r0.toString(), this.block);
        return;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState r2) {
        ParserState r1 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r2, ParserState.class, "com.obric.memorydata.plugin");
        if (r1.isBlank() == true) goto L7;
        return BlockContinue.atIndex(r1.getIndex());
    L7:
        return BlockContinue.none();
    }
}
