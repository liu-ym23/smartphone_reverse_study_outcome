package com.larus.business.markdown.impl.markwon;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J,\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J2\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J:\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u0004\u0018\u00010\u0006*\u00020\u001cH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/JumpAnalyzer;", "", "()V", "lastBuilder", "Landroid/text/SpannableStringBuilder;", "lastMessageId", "", "lastNode", "Lorg/commonmark/node/Node;", "analysisJump", "", Params.CONTENT, "Lcom/larus/business/markdown/api/model/MarkdownContent;", CozeCloudExt.API_KEY_HTTP_STREAM_METHOD, "", "messageId", "listener", "Lcom/larus/business/markdown/api/view/text/JumpListener;", "analysisJumpContent", "preContent", "currContent", "preNode", "currNode", "analysisNode", CommonConsts.COUNT_TYPE, "", "clear", "toHex", "", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5242a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Class<? extends Node>, String> f5243b = null;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u000b\u001a\u00020\f*\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000eJ\n\u0010\u000f\u001a\u00020\u0006*\u00020\nJ\u0011\u0010\u0010\u001a\u00020\u0006*\u00020\nH\u0000¢\u0006\u0002\b\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/JumpAnalyzer$Companion;", "", "()V", "INVALID", "", "TAG", "", "map", "", "Ljava/lang/Class;", "Lorg/commonmark/node/Node;", "compare", "", "other", "compare$markdown_impl_release", "getReportName", ActivityLifecycle.NAME, "name$markdown_impl_release", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final String a(Node r4) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            String r0 = (String) ZeusTransformUtils.preCheckCast(d.a().get(r4.getClass()), String.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L5;
            return r0;
        L5:
            return b(r4);
        }

        public final String b(Node r1) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            String r0 = r1.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(r0, "this::class.java.simpleName");
            String r2 = r0.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(r2, "(this as java.lang.String).toLowerCase()");
            return r2;
        }
    }

    static {
        f5242a = new a(null);
        Map<Class<? extends Node>, String> r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ThematicBreak.class, "thematic"), TuplesKt.to(Heading.class, "heading"), TuplesKt.to(FencedCodeBlock.class, "code_block"), TuplesKt.to(IndentedCodeBlock.class, "code_block"), TuplesKt.to(HtmlBlock.class, "html"), TuplesKt.to(HtmlInline.class, "html"), TuplesKt.to(LinkReferenceDefinition.class, "link_ref_def"), TuplesKt.to(Paragraph.class, "paragraph"), TuplesKt.to(TableBlock.class, "table"), TuplesKt.to(TableCell.class, "table_cell"), TuplesKt.to(TableBody.class, "table_body"), TuplesKt.to(TableRow.class, "table_row"), TuplesKt.to(TableHead.class, "table_header"), TuplesKt.to(BlockQuote.class, "block_quote"), TuplesKt.to(OrderedList.class, Constants.KEY_LIST), TuplesKt.to(BulletList.class, Constants.KEY_LIST), TuplesKt.to(ListItem.class, "list_item"), TuplesKt.to(Code.class, "inline_code"), TuplesKt.to(Emphasis.class, "emphasis"), TuplesKt.to(StrongEmphasis.class, "strong"), TuplesKt.to(Link.class, "link"), TuplesKt.to(Image.class, "image"), TuplesKt.to(Text.class, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT)});
        com.larus.business.markdown.api.extplugin.latex.a r1 = com.larus.business.markdown.api.extplugin.latex.b.a();
        if (r1 == null) goto L6;
        Map<Class<? extends Node>, String> r2 = r1.a();
        if (r2 == null) goto L6;
    L7:
        r0.putAll(r2);
        f5243b = r0;
        return;
    L6:
        r2 = MapsKt.emptyMap();
        goto L7
    }

    public static final /* synthetic */ Map a() {
        return f5243b;
    }
}
