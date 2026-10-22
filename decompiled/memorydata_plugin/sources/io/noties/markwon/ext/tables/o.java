package io.noties.markwon.ext.tables;

import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.parser.Parser;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockParserFactory;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;
import org.commonmark.renderer.html.HtmlRenderer$HtmlRendererExtension;
import org.commonmark.renderer.text.TextContentRenderer$TextContentRendererExtension;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u000eB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/noties/markwon/ext/tables/TablesExtension2;", "Lorg/commonmark/parser/Parser$ParserExtension;", "Lorg/commonmark/renderer/html/HtmlRenderer$HtmlRendererExtension;", "Lorg/commonmark/renderer/text/TextContentRenderer$TextContentRendererExtension;", "tableOptions", "Lio/noties/markwon/ext/tables/TableOptions;", "(Lio/noties/markwon/ext/tables/TableOptions;)V", CozeCloudExt.API_KEY_CLOUD_EXTEND_MAP, "", "parserBuilder", "Lorg/commonmark/parser/Parser$Builder;", "rendererBuilder", "Lorg/commonmark/renderer/html/HtmlRenderer$Builder;", "Lorg/commonmark/renderer/text/TextContentRenderer$Builder;", "Factory", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
public class o implements Parser.ParserExtension, HtmlRenderer$HtmlRendererExtension, TextContentRenderer$TextContentRendererExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f16527a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/ext/tables/TablesExtension2$Factory;", "Lio/noties/markwon/ext/tables/TableBlockParser$Factory;", "tableOptions", "Lio/noties/markwon/ext/tables/TableOptions;", "(Lio/noties/markwon/ext/tables/TableOptions;)V", "tryStart", "Lorg/commonmark/parser/block/BlockStart;", "state", "Lorg/commonmark/parser/block/ParserState;", "matchedBlockParser", "Lorg/commonmark/parser/block/MatchedBlockParser;", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
    public static class a extends f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g f16528a;

        public a(g r2) {
            Intrinsics.checkParameterIsNotNull(r2, "tableOptions");
            this.f16528a = r2;
        }

        @Override // io.noties.markwon.ext.tables.f.a, org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState r12, MatchedBlockParser r13) {
            ParserState r14 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r12, ParserState.class, "com.obric.memorydata.plugin");
            MatchedBlockParser r15 = (MatchedBlockParser) ZeusTransformUtils.wrapperContextForParams(r13, MatchedBlockParser.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r14, "state");
            Intrinsics.checkParameterIsNotNull(r15, "matchedBlockParser");
            CharSequence r0 = r14.getLine();
            CharSequence r8 = r15.getParagraphContent();
            if (r8 == null) goto L34;
            if (ZeusTransformUtils.instanceOf(r8, StringBuilder.class) == true) goto L7;
            CharSequence r2 = null;
        L8:
            StringBuilder r10 = (StringBuilder) ZeusTransformUtils.preCheckCast(r2, StringBuilder.class, "com.obric.memorydata.plugin");
            if (r10 == null) goto L32;
            String r16 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.last(StringsKt.split$default(r8, new String[]{"\n"}, false, 0, 6, null)), String.class, "com.obric.memorydata.plugin");
            if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L30;
            List<TableCell.Alignment> r1 = f.b(r0.subSequence(r14.getIndex(), r0.length()));
            Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L15;
        L18:
            boolean r4 = true;
        L19:
            if (r4 == true) goto L30;
            List<String> r5 = f.a((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin"));
            Intrinsics.checkExpressionValueIsNotNull(r5, "TableBlockParser.split(paragraph)");
            if (r1.size() < r5.size()) goto L30;
            int r6 = r10.length();
            int r7 = r6 - r16.length();
            if (r7 > 0) goto L25;
        L27:
            r10.delete(r7, r6);
            return BlockStart.of(new BlockParser[]{(BlockParser) ZeusTransformUtils.preCheckCast(new f(r1, r5, r16, this.f16528a.a()), BlockParser.class, "com.obric.memorydata.plugin")}).atIndex(r14.getIndex());
        L25:
            if (r8.charAt(r7 - 1) != '\n') goto L27;
            r7 = r7 - 1;
            goto L27
        L15:
            if (r3.isEmpty() == true) goto L18;
            r4 = false;
        L30:
            return BlockStart.none();
        L32:
            return super.tryStart(r14, r15);
        L7:
            r2 = r8;
            goto L8
        L34:
            return BlockStart.none();
        }
    }

    public o(g r2) {
        Intrinsics.checkParameterIsNotNull(r2, "tableOptions");
        this.f16527a = r2;
    }

    @Override // org.commonmark.parser.Parser.ParserExtension
    public void extend(Parser.Builder r3) {
        Intrinsics.checkParameterIsNotNull(r3, "parserBuilder");
        r3.customBlockParserFactory((BlockParserFactory) ZeusTransformUtils.preCheckCast(new a(this.f16527a), BlockParserFactory.class, "com.obric.memorydata.plugin"));
    }
}
