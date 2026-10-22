package io.noties.markwon.maybe;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.internal.FencedCodeBlockParser;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lio/noties/markwon/maybe/MaybeFencedCodeBlockParser;", "Lorg/commonmark/internal/FencedCodeBlockParser;", "fenceChar", "", "fenceLength", "", "fenceIndent", "(CII)V", "lastMatchedLine", "", "addLine", "", "line", "isClosing", "", "index", "tryContinue", "Lorg/commonmark/parser/block/BlockContinue;", "state", "Lorg/commonmark/parser/block/ParserState;", "Companion", "Factory", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
public final class b extends FencedCodeBlockParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16648a = null;
    private static final Pattern c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CharSequence f16649b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/noties/markwon/maybe/MaybeFencedCodeBlockParser$Companion;", "", "()V", XSDatatype.FACET_PATTERN, "Ljava/util/regex/Pattern;", "pattern$annotations", "getPattern", "()Ljava/util/regex/Pattern;", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: io.noties.markwon.maybe.b$b, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lio/noties/markwon/maybe/MaybeFencedCodeBlockParser$Factory;", "Lorg/commonmark/parser/block/AbstractBlockParserFactory;", "()V", "tryStart", "Lorg/commonmark/parser/block/BlockStart;", "state", "Lorg/commonmark/parser/block/ParserState;", "matchedBlockParser", "Lorg/commonmark/parser/block/MatchedBlockParser;", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
    public static final class C0869b extends AbstractBlockParserFactory {
        public C0869b() {
        }

        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState r4, MatchedBlockParser r5) {
            ParserState r3 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r4, ParserState.class, "com.obric.memorydata.plugin");
            MatchedBlockParser r6 = (MatchedBlockParser) ZeusTransformUtils.wrapperContextForParams(r5, MatchedBlockParser.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r3, "state");
            Intrinsics.checkParameterIsNotNull(r6, "matchedBlockParser");
            int r7 = r3.getIndent();
            if (r7 >= Parsing.CODE_BLOCK_INDENT) goto L5;
            int r8 = r3.getNextNonSpaceIndex();
            CharSequence r9 = r3.getLine();
            Intrinsics.checkExpressionValueIsNotNull(r9, "state.line");
            b r10 = c.a(r9, r8, r7);
            if (r10 == null) goto L14;
            BlockStart r11 = BlockStart.of(new BlockParser[]{(BlockParser) ZeusTransformUtils.preCheckCast(r10, BlockParser.class, "com.obric.memorydata.plugin")});
            Block r12 = r10.getBlock();
            if (r12 == null) goto L12;
            return r11.atIndex(r8 + ((FencedCodeBlock) ZeusTransformUtils.preCheckCast(r12, FencedCodeBlock.class, "com.obric.memorydata.plugin")).getFenceLength());
        L12:
            throw new TypeCastException("null cannot be cast to non-null type org.commonmark.node.FencedCodeBlock");
        L14:
            return BlockStart.none();
        L5:
            return BlockStart.none();
        }
    }

    static {
        f16648a = new a(null);
        Pattern r0 = Pattern.compile("^`{1,2}$");
        Intrinsics.checkExpressionValueIsNotNull(r0, "Pattern.compile(\"^`{1,2}$\")");
        c = r0;
    }

    public b(char r1, int r2, int r3) {
        super(r1, r2, r3);
    }

    private final boolean a(CharSequence r5, int r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Block r0 = getBlock();
        if (r0 == null) goto L16;
        char r1 = ((FencedCodeBlock) ZeusTransformUtils.preCheckCast(r0, FencedCodeBlock.class, "com.obric.memorydata.plugin")).getFenceChar();
        Block r4 = getBlock();
        if (r4 == null) goto L14;
        int r8 = ((FencedCodeBlock) ZeusTransformUtils.preCheckCast(r4, FencedCodeBlock.class, "com.obric.memorydata.plugin")).getFenceLength();
        int r2 = Parsing.skip(r1, r7, r6, r7.length()) - r6;
        if (r2 >= r8) goto L10;
        return false;
    L10:
        if (Parsing.skipSpaceTab(r7, r6 + r2, r7.length()) != r7.length()) goto L17;
        return true;
    L17:
        return false;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type org.commonmark.node.FencedCodeBlock");
    L16:
        throw new TypeCastException("null cannot be cast to non-null type org.commonmark.node.FencedCodeBlock");
    }

    @Override // org.commonmark.internal.FencedCodeBlockParser, org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void addLine(CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r7, "line");
        CharSequence r0 = this.f16649b;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        super.addLine(this.f16649b);
        this.f16649b = (CharSequence) ZeusTransformUtils.preCheckCast(null, CharSequence.class, "com.obric.memorydata.plugin");
    L12:
        if (c.matcher(StringsKt.trim(r7, new char[]{' '})).matches() == false) goto L15;
        this.f16649b = r7;
        return;
    L15:
        super.addLine(r7);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // org.commonmark.internal.FencedCodeBlockParser, org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState r8) {
        ParserState r9 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r8, ParserState.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r9, "state");
        CharSequence r0 = r9.getLine();
        int r2 = r9.getNextNonSpaceIndex();
        boolean r5 = true;
        if (r9.getIndent() >= Parsing.CODE_BLOCK_INDENT) goto L7;
        Intrinsics.checkExpressionValueIsNotNull(r0, "line");
        if (a(r0, r2) == false) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L20;
        CharSequence r10 = this.f16649b;
        if (r10 == null) goto L18;
        if (r10.length() > 0) goto L15;
        r5 = false;
    L15:
        if (r5 == false) goto L18;
        addLine(r10);
        this.f16649b = (CharSequence) ZeusTransformUtils.preCheckCast(null, CharSequence.class, "com.obric.memorydata.plugin");
    L18:
        return BlockContinue.finished();
    L20:
        return super.tryContinue(r9);
    L7:
        r1 = false;
        goto L8
    }
}
