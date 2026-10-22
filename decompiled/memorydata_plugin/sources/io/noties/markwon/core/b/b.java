package io.noties.markwon.core.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.internal.ListBlockParser;
import org.commonmark.internal.ListItemParser;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BulletList;
import org.commonmark.node.ListBlock;
import org.commonmark.node.OrderedList;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0004\t\n\u000b\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/noties/markwon/core/listblock/ListBlockParserV2;", "Lorg/commonmark/internal/ListBlockParser;", "block", "Lorg/commonmark/node/ListBlock;", "(Lorg/commonmark/node/ListBlock;)V", "tryContinue", "Lorg/commonmark/parser/block/BlockContinue;", "state", "Lorg/commonmark/parser/block/ParserState;", "Companion", "Factory", "ListData", "ListMarkerData", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b extends ListBlockParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16429a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ListBlock f16430b;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0002J2\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\"\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¨\u0006\u0017"}, d2 = {"Lio/noties/markwon/core/listblock/ListBlockParserV2$Companion;", "", "()V", "equals", "", "a", "b", "isSpaceTabOrEnd", "line", "", "index", "", "listsMatch", "Lorg/commonmark/node/ListBlock;", "parseList", "Lio/noties/markwon/core/listblock/ListBlockParserV2$ListData;", "markerIndex", "markerColumn", "inParagraph", "indent", "parseListMarker", "Lio/noties/markwon/core/listblock/ListBlockParserV2$ListMarkerData;", "parseOrderedList", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ c a(a r6, CharSequence r7, int r8, int r9, boolean r10, int r11) {
            return r6.a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
        }

        private final c a(CharSequence r7, int r8, int r9, boolean r10, int r11) {
            CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
            d r6 = a(r12, r8, r11);
            if (r6 != null) goto L5;
            return null;
        L5:
            ListBlock r0 = r6.a();
            int r13 = r6.b();
            int r14 = r9 + (r13 - r8);
            boolean r15 = false;
            int r1 = r12.length();
            int r2 = r14;
        L7:
            if (r13 >= r1) goto L16;
            char r4 = r12.charAt(r13);
            if (r4 != '\t') goto L12;
            r2 = r2 + Parsing.columnsToNextTabStop(r2);
        L14:
            r13 = r13 + 1;
            goto L7
        L12:
            if (r4 != ' ') goto L15;
            r2 = r2 + 1;
            goto L14
        L15:
            r15 = true;
        L16:
            if (r10 == false) goto L19;
            if (r15 == true) goto L19;
            return null;
        L19:
            if (r15 == true) goto L21;
        L22:
            r2 = r14 + 1;
        L24:
            return new c(r0, r2);
        L21:
            if ((r2 - r14) <= Parsing.CODE_BLOCK_INDENT) goto L24;
            goto L22
        }

        private final d a(CharSequence r6, int r7, int r8) {
            CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
            char r0 = r9.charAt(r7);
            boolean r2 = false;
            if (r0 != '-') goto L6;
        L4:
            boolean r4 = true;
        L9:
            if (r4 == false) goto L12;
        L10:
            r2 = true;
        L14:
            if (r2 == false) goto L20;
            int r10 = r7 + 1;
            if (a(r9, r10) == false) goto L22;
            BulletList r5 = new BulletList();
            r5.setBulletMarker(r0);
            io.noties.markwon.core.b.a.a((ListBlock) ZeusTransformUtils.preCheckCast(r5, ListBlock.class, "com.obric.memorydata.plugin"), r8);
            return new d((ListBlock) ZeusTransformUtils.preCheckCast(r5, ListBlock.class, "com.obric.memorydata.plugin"), r10);
        L22:
            return (d) ZeusTransformUtils.preCheckCast(null, d.class, "com.obric.memorydata.plugin");
        L20:
            return b(r9, r7, r8);
        L12:
            if (r0 != '*') goto L14;
        L6:
            if (r0 == '+') goto L4;
            r4 = false;
            goto L9
        }

        public static final /* synthetic */ boolean a(a r0, ListBlock r1, ListBlock r2) {
            return r0.a(r1, r2);
        }

        private final boolean a(CharSequence r3, int r4) {
            CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            if (r4 >= r2.length()) goto L13;
            char r5 = r2.charAt(r4);
            if (r5 != ' ') goto L8;
        L6:
            boolean r6 = true;
        L11:
            if (r6 == true) goto L13;
            return false;
        L8:
            if (r5 == '\t') goto L6;
            r6 = false;
        L13:
            return true;
        }

        private final boolean a(Object r1, Object r2) {
            if (r1 != null) goto L7;
            if (r2 != null) goto L5;
            return true;
        L5:
            return false;
        L7:
            return Intrinsics.areEqual(r1, r2);
        }

        private final boolean a(ListBlock r3, ListBlock r4) {
            if (ZeusTransformUtils.instanceOf(r3, BulletList.class) == false) goto L10;
            if (ZeusTransformUtils.instanceOf(r4, BulletList.class) == false) goto L10;
            Character r5 = Character.valueOf(((BulletList) ZeusTransformUtils.preCheckCast(r3, BulletList.class, "com.obric.memorydata.plugin")).getBulletMarker());
            char r6 = ((BulletList) ZeusTransformUtils.preCheckCast(r4, BulletList.class, "com.obric.memorydata.plugin")).getBulletMarker();
        L8:
            return a(r5, Character.valueOf(r6));
        L10:
            if (ZeusTransformUtils.instanceOf(r3, OrderedList.class) == true) goto L12;
            return false;
        L12:
            if (ZeusTransformUtils.instanceOf(r4, OrderedList.class) == false) goto L16;
            r5 = Character.valueOf(((OrderedList) ZeusTransformUtils.preCheckCast(r3, OrderedList.class, "com.obric.memorydata.plugin")).getDelimiter());
            r6 = ((OrderedList) ZeusTransformUtils.preCheckCast(r4, OrderedList.class, "com.obric.memorydata.plugin")).getDelimiter();
            goto L8
        L16:
            return false;
        }

        private final d b(CharSequence r10, int r11, int r12) {
            CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
            int r0 = r13.length();
            boolean r2 = false;
            int r3 = r11;
            int r4 = 0;
        L4:
            if (r3 >= r0) goto L78;
            char r6 = r13.charAt(r3);
            if (r6 != '0') goto L9;
        L7:
            boolean r7 = true;
        L12:
            if (r7 == false) goto L15;
        L13:
            boolean r8 = true;
        L18:
            if (r8 == false) goto L21;
        L19:
            boolean r9 = true;
        L24:
            if (r9 == false) goto L27;
        L25:
            boolean r14 = true;
        L30:
            if (r14 == false) goto L33;
        L31:
            boolean r15 = true;
        L36:
            if (r15 == false) goto L39;
        L37:
            boolean r16 = true;
        L42:
            if (r16 == false) goto L45;
        L43:
            boolean r17 = true;
        L48:
            if (r17 == false) goto L51;
        L49:
            boolean r18 = true;
        L54:
            if (r18 == false) goto L57;
        L55:
            boolean r19 = true;
        L60:
            if (r19 == false) goto L66;
            r4 = r4 + 1;
            if (r4 > 9) goto L63;
            r3 = r3 + 1;
            goto L4
        L63:
            return null;
        L66:
            if (r6 != '.') goto L69;
        L67:
            r2 = true;
        L71:
            if (r2 == false) goto L78;
            if (r4 < 1) goto L77;
            int r1 = r3 + 1;
            if (a(r13, r1) == false) goto L77;
            String r20 = r13.subSequence(r11, r3).toString();
            OrderedList r110 = new OrderedList();
            r110.setStartNumber(Integer.parseInt(r20));
            r110.setDelimiter(r6);
            io.noties.markwon.core.b.a.a((ListBlock) ZeusTransformUtils.preCheckCast(r110, ListBlock.class, "com.obric.memorydata.plugin"), r12);
            return new d((ListBlock) ZeusTransformUtils.preCheckCast(r110, ListBlock.class, "com.obric.memorydata.plugin"), r1);
        L77:
            return (d) ZeusTransformUtils.preCheckCast(null, d.class, "com.obric.memorydata.plugin");
        L69:
            if (r6 != ')') goto L71;
        L57:
            if (r6 == '9') goto L55;
            r19 = false;
            goto L60
        L51:
            if (r6 == '8') goto L49;
            r18 = false;
            goto L54
        L45:
            if (r6 == '7') goto L43;
            r17 = false;
            goto L48
        L39:
            if (r6 == '6') goto L37;
            r16 = false;
            goto L42
        L33:
            if (r6 == '5') goto L31;
            r15 = false;
            goto L36
        L27:
            if (r6 == '4') goto L25;
            r14 = false;
            goto L30
        L21:
            if (r6 == '3') goto L19;
            r9 = false;
            goto L24
        L15:
            if (r6 == '2') goto L13;
            r8 = false;
            goto L18
        L9:
            if (r6 == '1') goto L7;
            r7 = false;
        L78:
            return null;
        }
    }

    /* JADX INFO: renamed from: io.noties.markwon.core.b.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lio/noties/markwon/core/listblock/ListBlockParserV2$Factory;", "Lorg/commonmark/parser/block/AbstractBlockParserFactory;", "()V", "tryStart", "Lorg/commonmark/parser/block/BlockStart;", "state", "Lorg/commonmark/parser/block/ParserState;", "matchedBlockParser", "Lorg/commonmark/parser/block/MatchedBlockParser;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0860b extends AbstractBlockParserFactory {
        public C0860b() {
        }

        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState r10, MatchedBlockParser r11) {
            ParserState r9 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r10, ParserState.class, "com.obric.memorydata.plugin");
            MatchedBlockParser r12 = (MatchedBlockParser) ZeusTransformUtils.wrapperContextForParams(r11, MatchedBlockParser.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "state");
            Intrinsics.checkNotNullParameter(r12, "matchedBlockParser");
            BlockParser r13 = r12.getMatchedBlockParser();
            int r3 = r9.getNextNonSpaceIndex();
            int r4 = r9.getColumn() + r9.getIndent();
            if (r12.getParagraphContent() == null) goto L5;
            boolean r5 = true;
        L6:
            a r1 = b.f16429a;
            CharSequence r2 = r9.getLine();
            Intrinsics.checkNotNullExpressionValue(r2, "state.line");
            c r14 = a.a(r1, r2, r3, r4, r5, r9.getIndent());
            if (r14 == null) goto L9;
            int r6 = r14.b();
            ListItemParser r7 = new ListItemParser(r6 - r9.getColumn());
            if (ZeusTransformUtils.instanceOf(r13, b.class) == false) goto L16;
            a r15 = b.f16429a;
            Block r16 = r13.getBlock();
            Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type org.commonmark.node.ListBlock");
            if (a.a(r15, (ListBlock) ZeusTransformUtils.preCheckCast(r16, ListBlock.class, "com.obric.memorydata.plugin"), r14.a()) == false) goto L16;
            BlockStart r17 = BlockStart.of(new BlockParser[]{(BlockParser) ZeusTransformUtils.preCheckCast(r7, BlockParser.class, "com.obric.memorydata.plugin")});
        L18:
            return r17.atColumn(r6);
        L16:
            b r18 = new b(r14.a());
            r14.a().setTight(true);
            r17 = BlockStart.of(new BlockParser[]{(BlockParser) ZeusTransformUtils.preCheckCast(r18, BlockParser.class, "com.obric.memorydata.plugin"), (BlockParser) ZeusTransformUtils.preCheckCast(r7, BlockParser.class, "com.obric.memorydata.plugin")});
            goto L18
        L9:
            return BlockStart.none();
        L5:
            r5 = false;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/core/listblock/ListBlockParserV2$ListData;", "", "listBlock", "Lorg/commonmark/node/ListBlock;", "contentColumn", "", "(Lorg/commonmark/node/ListBlock;I)V", "getContentColumn", "()I", "getListBlock", "()Lorg/commonmark/node/ListBlock;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ListBlock f16431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f16432b;

        public c(ListBlock r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "listBlock");
            this.f16431a = r2;
            this.f16432b = r3;
        }

        public final ListBlock a() {
            return this.f16431a;
        }

        public final int b() {
            return this.f16432b;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/core/listblock/ListBlockParserV2$ListMarkerData;", "", "listBlock", "Lorg/commonmark/node/ListBlock;", "indexAfterMarker", "", "(Lorg/commonmark/node/ListBlock;I)V", "getIndexAfterMarker", "()I", "getListBlock", "()Lorg/commonmark/node/ListBlock;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ListBlock f16433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f16434b;

        public d(ListBlock r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "listBlock");
            this.f16433a = r2;
            this.f16434b = r3;
        }

        public final ListBlock a() {
            return this.f16433a;
        }

        public final int b() {
            return this.f16434b;
        }
    }

    static {
        f16429a = new a(null);
    }

    public b(ListBlock r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        super(r2);
        this.f16430b = r2;
    }

    @Override // org.commonmark.internal.ListBlockParser, org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState r3) {
        ParserState r4 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r3, ParserState.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "state");
        if (r4.getIndent() >= io.noties.markwon.core.b.a.a(this.f16430b)) goto L6;
        BlockContinue.none();
    L6:
        return super.tryContinue(r4);
    }
}
