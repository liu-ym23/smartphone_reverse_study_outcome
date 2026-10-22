package io.noties.markwon.g;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.n;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
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
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\bH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lio/noties/markwon/utils/TrackerUtils;", "", "()V", "nodeClassNameMap", "", "", "nodeNameMap", "Ljava/lang/Class;", "Lorg/commonmark/node/Node;", "addTracker", "", "node", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "needTracker", "", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f16546a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Class<? extends Node>, String> f16547b = null;
    private static final Map<String, String> c = null;

    static {
        f16546a = new g();
        f16547b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ThematicBreak.class, "thematic"), TuplesKt.to(Heading.class, "heading"), TuplesKt.to(FencedCodeBlock.class, "code_block"), TuplesKt.to(IndentedCodeBlock.class, "code_block"), TuplesKt.to(HtmlBlock.class, "html"), TuplesKt.to(HtmlInline.class, "html"), TuplesKt.to(LinkReferenceDefinition.class, "link_ref_def"), TuplesKt.to(Paragraph.class, "paragraph"), TuplesKt.to(BlockQuote.class, "block_quote"), TuplesKt.to(OrderedList.class, Constants.KEY_LIST), TuplesKt.to(BulletList.class, Constants.KEY_LIST), TuplesKt.to(ListItem.class, "list_item"), TuplesKt.to(Code.class, "inline_code"), TuplesKt.to(Emphasis.class, "emphasis"), TuplesKt.to(StrongEmphasis.class, "strong"), TuplesKt.to(Link.class, "link"), TuplesKt.to(Image.class, "image"), TuplesKt.to(Text.class, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT)});
        c = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("org.commonmark.ext.gfm.tables.TableBlock", "table"), TuplesKt.to("org.commonmark.ext.gfm.tables.TableCell", "table_cell"), TuplesKt.to("org.commonmark.ext.gfm.tables.TableBody", "table_body"), TuplesKt.to("org.commonmark.ext.gfm.tables.TableCell", "table_row"), TuplesKt.to("org.commonmark.ext.gfm.tables.TableHead", "table_header")});
    }

    private g() {
    }

    private final boolean a(Node r1) {
        if (ZeusTransformUtils.instanceOf(r1, ListBlock.class) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r1.getClass().getName(), "org.commonmark.ext.gfm.tables.TableBlock") == true) goto L8;
        return false;
    }

    public final void a(Node r3, n r4) {
        n r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "node");
        Intrinsics.checkParameterIsNotNull(r5, "visitor");
        if (a(r3) == false) goto L20;
        HashMap r2 = (HashMap) ZeusTransformUtils.preCheckCast(CoreProps.j.a(r5.b()), HashMap.class, "com.obric.memorydata.plugin");
        Class<?> r6 = r3.getClass();
        String r7 = (String) ZeusTransformUtils.preCheckCast(f16547b.get(r6), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L8;
        r7 = (String) ZeusTransformUtils.preCheckCast(c.get(r6.getName()), String.class, "com.obric.memorydata.plugin");
    L8:
        if (r7 != null) goto L11;
        r7 = r6.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(r7, "clazz.simpleName");
    L11:
        if (r2 == null) goto L15;
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r2.get(r7), Integer.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L15;
    L16:
        int r9 = r8.intValue() + 1;
        if (r2 == null) goto L21;
        Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(r2.put(r7, Integer.valueOf(r9)), Integer.class, "com.obric.memorydata.plugin");
        return;
    L21:
        return;
    L15:
        r8 = 0;
        goto L16
    }
}
