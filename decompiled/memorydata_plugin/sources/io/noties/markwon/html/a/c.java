package io.noties.markwon.html.a;

import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Block;
import org.commonmark.node.HtmlBlock;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0015B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lio/noties/markwon/html/customdata/CustomDataBlockParser;", "Lorg/commonmark/parser/block/AbstractBlockParser;", "closingPattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "block", "Lorg/commonmark/node/HtmlBlock;", Params.CONTENT, "Lio/noties/markwon/html/customdata/BlockContent;", "finished", "", "addLine", "", "line", "", "closeBlock", "getBlock", "tryContinue", "Lorg/commonmark/parser/block/BlockContinue;", "state", "Lorg/commonmark/parser/block/ParserState;", "Factory", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
public final class c extends AbstractBlockParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HtmlBlock f16554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f16555b;
    private io.noties.markwon.html.a.a c;
    private final Pattern d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lio/noties/markwon/html/customdata/CustomDataBlockParser$Factory;", "Lorg/commonmark/parser/block/AbstractBlockParserFactory;", "()V", "customBlockTags", "", "", "getCustomBlockTags", "()Ljava/util/Set;", "tryStart", "Lorg/commonmark/parser/block/BlockStart;", "state", "Lorg/commonmark/parser/block/ParserState;", "matchedBlockParser", "Lorg/commonmark/parser/block/MatchedBlockParser;", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
    public static final class a extends AbstractBlockParserFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<String> f16556a;

        public a() {
            this.f16556a = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        }

        public final Set<String> a() {
            return this.f16556a;
        }

        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState r8, MatchedBlockParser r9) {
            ParserState r10 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r8, ParserState.class, "com.obric.memorydata.plugin");
            MatchedBlockParser r11 = (MatchedBlockParser) ZeusTransformUtils.wrapperContextForParams(r9, MatchedBlockParser.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r10, "state");
            int r12 = r10.getNextNonSpaceIndex();
            CharSequence r0 = r10.getLine();
            if (r10.getIndent() >= 4) goto L14;
            if (r0.charAt(r12) != '<') goto L14;
            Iterator<String> r7 = this.f16556a.iterator();
        L8:
            if (r7.hasNext() == false) goto L14;
            String r2 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
            Pattern r3 = Pattern.compile("^<(?:" + r2 + ")(?:\\s|>|$)", 2);
            Pattern r4 = Pattern.compile("</(?:" + r2 + ")>", 2);
            if (r3.matcher(r0.subSequence(r12, r0.length())).find() == false) goto L8;
            return BlockStart.of(new BlockParser[]{(BlockParser) ZeusTransformUtils.preCheckCast(new c(r4, null), BlockParser.class, "com.obric.memorydata.plugin")}).atIndex(r10.getIndex());
        L14:
            return BlockStart.none();
        }
    }

    private c(Pattern r1) {
        this.d = r1;
        this.f16554a = new HtmlBlock();
        this.c = new io.noties.markwon.html.a.a();
    }

    public /* synthetic */ c(Pattern r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public HtmlBlock a() {
        return this.f16554a;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void addLine(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.c.a(r4);
        Pattern r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.matcher(r4).find() == false) goto L9;
        this.f16555b = true;
        return;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void closeBlock() {
        this.f16554a.setLiteral(this.c.a());
    }

    @Override // org.commonmark.parser.block.BlockParser
    public /* synthetic */ Block getBlock() {
        return (Block) ZeusTransformUtils.preCheckCast(a(), Block.class, "com.obric.memorydata.plugin");
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState r3) {
        ParserState r4 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r3, ParserState.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "state");
        if (this.f16555b == false) goto L7;
        return BlockContinue.none();
    L7:
        if (r4.isBlank() == false) goto L12;
        if (this.d != null) goto L12;
        return BlockContinue.none();
    L12:
        return BlockContinue.atIndex(r4.getIndex());
    }
}
