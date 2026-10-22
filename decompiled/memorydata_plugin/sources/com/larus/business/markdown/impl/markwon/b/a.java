package com.larus.business.markdown.impl.markwon.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.internal.HeadingParser;
import org.commonmark.internal.util.Parsing;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/parser/HeadingParserFactory2;", "Lorg/commonmark/internal/HeadingParser$Factory;", "()V", "tryStart", "Lorg/commonmark/parser/block/BlockStart;", "state", "Lorg/commonmark/parser/block/ParserState;", "matchedBlockParser", "Lorg/commonmark/parser/block/MatchedBlockParser;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a extends HeadingParser.Factory {
    public a() {
    }

    @Override // org.commonmark.internal.HeadingParser.Factory, org.commonmark.parser.block.BlockParserFactory
    public BlockStart tryStart(ParserState r3, MatchedBlockParser r4) {
        ParserState r5 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r3, ParserState.class, "com.obric.memorydata.plugin");
        MatchedBlockParser r6 = (MatchedBlockParser) ZeusTransformUtils.wrapperContextForParams(r4, MatchedBlockParser.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r5);
        if (r5.getIndent() >= Parsing.CODE_BLOCK_INDENT) goto L5;
        CharSequence r0 = r5.getLine();
        if (r0 != null) goto L11;
        return BlockStart.none();
    L11:
        if (StringsKt.trim(r0).length() > 1) goto L15;
        return BlockStart.none();
    L15:
        return super.tryStart(r5, r6);
    L5:
        return BlockStart.none();
    }
}
