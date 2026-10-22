package org.commonmark.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.commonmark.node.Block;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes7.dex */
public class ListItemParser extends AbstractBlockParser {
    private final ListItem block;
    private int contentIndent;
    private boolean hadBlankLine;

    public ListItemParser(int r2) {
        this.block = new ListItem();
        this.contentIndent = r2;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean canContain(Block r2) {
        if (this.hadBlankLine == false) goto L9;
        Block r1 = this.block.getParent();
        if (ZeusTransformUtils.instanceOf(r1, ListBlock.class) == false) goto L10;
        ((ListBlock) ZeusTransformUtils.preCheckCast(r1, ListBlock.class, "com.obric.memorydata.plugin")).setTight(false);
        return true;
    L10:
        return true;
    L9:
        return true;
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
        if (r4.isBlank() == false) goto L18;
        if (this.block.getFirstChild() == null) goto L7;
        Block r0 = r4.getActiveBlockParser().getBlock();
        if (ZeusTransformUtils.instanceOf(r0, Paragraph.class) == false) goto L11;
    L14:
        boolean r1 = true;
    L15:
        this.hadBlankLine = r1;
        return BlockContinue.atIndex(r4.getNextNonSpaceIndex());
    L11:
        if (ZeusTransformUtils.instanceOf(r0, ListItem.class) == true) goto L14;
        r1 = false;
        goto L15
    L7:
        return BlockContinue.none();
    L18:
        if (r4.getIndent() < this.contentIndent) goto L22;
        return BlockContinue.atColumn(r4.getColumn() + this.contentIndent);
    L22:
        return BlockContinue.none();
    }
}
