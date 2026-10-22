package com.larus.business.markdown.impl.widget;

import android.content.Context;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.larus.business.markdown.api.depend.f;
import com.larus.business.markdown.api.depend.g;
import com.larus.business.markdown.api.model.c;
import com.larus.business.markdown.api.model.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;
import org.commonmark.node.Document;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0016\u0010\f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0002J8\u0010\u000f\u001a\u00020\b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u0017J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u008c\u0001\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000e2\u0006\u0010(\u001a\u00020\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0004JY\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010\n2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000e2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0002\u00101Jb\u00102\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\n2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010*2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001a05H\u0002J\u0018\u00106\u001a\u00020\b2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u000208H\u0002J]\u0010:\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010;\u001a\u00020\n2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010<\u001a\u00020 2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0002\u0010=R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/larus/business/markdown/impl/widget/MarkdownWidgetHelper;", "", "()V", "TAG", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "checkHTMLBlockSame", "", "lastNode", "Lorg/commonmark/node/Node;", "currentNode", "compositeNodeList", "nodeList", "", "currentNodeListContainsAllLastNodeList", "lastNodeList", "currentNodeList", "md", "Lio/noties/markwon/Markwon;", "enableOptimizeWidgetCompare", "cutIntoNodeListFromFirstDeep", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "generateFinalNodeList", "generateMarkdownWidgets", "", "markdownConfigManager", "Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;", "context", "Landroid/content/Context;", "maxContentWidth", "", "lastRecordNodeList", "finished", "lastFinishedStatus", "currentParentViewGroup", "Landroid/view/ViewGroup;", "widgetHandlerList", "Lcom/larus/business/markdown/api/widget/IMarkdownWidgetHandler;", "forceUpdateAndIgnoreNew", "markwonStructCache", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "originText", "generateWidgetFromNode", "Lcom/larus/business/markdown/api/widget/IMarkdownWidgetCallback;", "node", "prevNode", "isLastNode", "(Landroid/content/Context;ILorg/commonmark/node/Node;Lorg/commonmark/node/Node;Ljava/util/List;Ljava/lang/Boolean;Lcom/larus/business/markdown/api/model/IMarkwonStruct;)Lcom/larus/business/markdown/api/widget/IMarkdownWidgetCallback;", "generateWidgetFromNodeList", "preNode", "beforeUiRunnable", "Lkotlin/Function0;", "isSameSpannableString", "lastSpannedString", "Landroid/text/SpannableStringBuilder;", "currentSpannableString", "updateWidgetFromNode", "it", "index", "(Landroid/content/Context;ILorg/commonmark/node/Node;Ljava/util/List;Landroid/view/ViewGroup;ILjava/lang/Boolean;Lcom/larus/business/markdown/api/model/IMarkwonStruct;)V", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5269a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5270b = null;
    private static final al c = null;

    /* JADX INFO: renamed from: com.larus.business.markdown.impl.widget.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1})
    public static final class C0221a<T> implements Comparator<T> {
        public C0221a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.larus.business.markdown.api.d.b) ZeusTransformUtils.preCheckCast(r2, com.larus.business.markdown.api.d.b.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.larus.business.markdown.api.d.b) ZeusTransformUtils.preCheckCast(r3, com.larus.business.markdown.api.d.b.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1})
    public static final class b<T> implements Comparator<T> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.larus.business.markdown.api.d.b) ZeusTransformUtils.preCheckCast(r2, com.larus.business.markdown.api.d.b.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.larus.business.markdown.api.d.b) ZeusTransformUtils.preCheckCast(r3, com.larus.business.markdown.api.d.b.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f5269a = new a();
        f5270b = "MarkdownWidgetHelper";
        c = am.a();
    }

    private a() {
    }

    private final com.larus.business.markdown.api.d.a a(Context r9, int r10, Node r11, Node r12, List<? extends com.larus.business.markdown.api.d.b> r13, Boolean r14, e r15) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r15, e.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L22;
        List r16 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new C0221a(), Comparator.class, "com.obric.memorydata.plugin"));
        if (r16 == null) goto L23;
        List r17 = CollectionsKt.reversed((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"));
        if (r17 == null) goto L24;
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r18.hasNext() == false) goto L14;
        Object r19 = r18.next();
        if (((com.larus.business.markdown.api.d.b) ZeusTransformUtils.preCheckCast(r19, com.larus.business.markdown.api.d.b.class, "com.obric.memorydata.plugin")).a(r11) == false) goto L10;
    L15:
        com.larus.business.markdown.api.d.b r1 = (com.larus.business.markdown.api.d.b) ZeusTransformUtils.preCheckCast(r19, com.larus.business.markdown.api.d.b.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L18;
        return null;
    L18:
        return r1.a(r2, r10, r12, r11, r14, r7);
    L14:
        r19 = null;
        goto L15
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    }

    private final List<Node> a(List<? extends Node> r11, c r12) {
        List<? extends Node> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        List r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L16;
        Object r6 = r3.next();
        int r8 = r5 + 1;
        if (r5 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Node r7 = (Node) ZeusTransformUtils.preCheckCast(r6, Node.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, HtmlBlock.class) == false) goto L11;
    L14:
        r2.add(Integer.valueOf(r5));
        r7.unlink();
    L15:
        r5 = r8;
        goto L4
    L11:
        if (ZeusTransformUtils.instanceOf(r7, FencedCodeBlock.class) == false) goto L15;
        if (Intrinsics.areEqual(r12.A(), true) == false) goto L15;
    L16:
        int r14 = r13.size();
        if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L21;
    L18:
        r0.add(a(r13));
    L20:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L21:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r9.hasNext() == false) goto L35;
        int r10 = ((Number) ZeusTransformUtils.preCheckCast(r9.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r4 < r10) goto L26;
        if (r4 == r10) goto L28;
        if (r14 == r10) goto L30;
        if (r4 <= r10) goto L23;
        if (r10 >= r14) goto L23;
        Node r15 = f5269a.a(r13.subList(r10 + 1, r14));
    L31:
        r0.add(r15);
        goto L23
    L30:
        r15 = r13.get(r10);
        goto L31
    L28:
        r0.add(r13.get(r10));
        r4 = r4 + 1;
        goto L23
    L26:
        r0.add(f5269a.a(r13.subList(r4, r10)));
        r0.add(r13.get(r10));
        r4 = r10 + 1;
        goto L23
    L35:
        if (r4 > r14) goto L20;
        r13 = r13.subList(r4, r14);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        goto L18
    }

    private final Node a(List<? extends Node> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Document r5 = new Document();
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        r5.appendChild((Node) ZeusTransformUtils.preCheckCast(r6.next(), Node.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        return (Node) ZeusTransformUtils.preCheckCast(r5, Node.class, "com.obric.memorydata.plugin");
    }

    private final void a(Context r20, int r21, List<? extends Node> r22, Node r23, List<? extends com.larus.business.markdown.api.d.b> r24, final ViewGroup r25, e r26, Function0<Unit> r27) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        List<? extends com.larus.business.markdown.api.d.b> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        e r12 = (e) ZeusTransformUtils.wrapperContextForParams(r26, e.class, "com.obric.memorydata.plugin");
        final Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r27, Function0.class, "com.obric.memorydata.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r2.iterator();
        Node r6 = r23;
        int r3 = 0;
    L4:
        if (r15.hasNext() == false) goto L13;
        Object r4 = r15.next();
        int r17 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Node r9 = (Node) ZeusTransformUtils.preCheckCast(r4, Node.class, "com.obric.memorydata.plugin");
        a r5 = f5269a;
        boolean r7 = true;
        if (r10.indexOf(r9) == (r10.size() - 1)) goto L12;
        r7 = false;
    L12:
        r14.add(r5.a(r0, r21, r9, r6, r11, Boolean.valueOf(r7), r12));
        r3 = r17;
        r6 = r9;
        goto L4
    L13:
        final List r1 = CollectionsKt.filterNotNull((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        Runnable r8 = new $$Lambda$a$0kIQy70LaGGOVfm0Is4DlOfptVU(r13, r1, r25);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L16;
        i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MarkdownWidgetHelper$generateWidgetFromNodeList$1(r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L16:
        r8.run();
    }

    private final void a(Context r13, int r14, Node r15, List<? extends com.larus.business.markdown.api.d.b> r16, ViewGroup r17, int r18, Boolean r19, e r20) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        e r8 = (e) ZeusTransformUtils.wrapperContextForParams(r20, e.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L28
        Object r11 = null;
        if (r1 == null) goto L17;
        List r4 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L28
        if (r4 == null) goto L17;
        List r5 = CollectionsKt.reversed((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L28
        if (r5 == null) goto L17;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L28
    L11:
        if (r6.hasNext() == false) goto L15;
        Object r7 = r6.next();     // Catch: Throwable -> L28
        if (((com.larus.business.markdown.api.d.b) ZeusTransformUtils.preCheckCast(r7, com.larus.business.markdown.api.d.b.class, "com.obric.memorydata.plugin")).a(r15) == false) goto L11;
    L16:
        com.larus.business.markdown.api.d.b r9 = (com.larus.business.markdown.api.d.b) ZeusTransformUtils.preCheckCast(r7, com.larus.business.markdown.api.d.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
    L18:
        if (r9 == null) goto L20;
        com.larus.business.markdown.api.d.a r10 = r9.a(r2, r14, r18, r17, r15, r19, r8);     // Catch: Throwable -> L28
    L22:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L24;
        r11 = i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MarkdownWidgetHelper$updateWidgetFromNode$1$1(r10, r18, r17, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L28
    L26:
        Object r0 = Result.m1421constructorimpl(r11);     // Catch: Throwable -> L28
    L30:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r0);
        if (r12 == null) goto L41;
        f r21 = g.a();
        if (r21 == null) goto L42;
        r21.i(f5270b, r12.toString());
        return;
    L42:
        return;
    L41:
        return;
    L24:
        if (r10 == null) goto L26;
        r10.a(r18, r17);     // Catch: Throwable -> L28
        r11 = Unit.INSTANCE;     // Catch: Throwable -> L28
        goto L26
    L20:
        r10 = null;
        goto L22
    L15:
        r7 = null;
    L17:
        r9 = null;
    L28:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L30
    }

    private static final void a(Function0 r2, List r3, ViewGroup r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "$beforeUiRunnable");
        Intrinsics.checkNotNullParameter(r6, "$callbackList");
        Intrinsics.checkNotNullParameter(r4, "$currentParentViewGroup");
        r5.invoke();
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        ((com.larus.business.markdown.api.d.a) ZeusTransformUtils.preCheckCast(r7.next(), com.larus.business.markdown.api.d.a.class, "com.obric.memorydata.plugin")).a(r4);
        goto L4
    }

    private final boolean a(SpannableStringBuilder r7, SpannableStringBuilder r8) {
        if (Intrinsics.areEqual(r7.toString(), r8.toString()) == true) goto L5;
        return false;
    L5:
        Object[] r6 = ((Spanned) ZeusTransformUtils.preCheckCast(r7, Spanned.class, "com.obric.memorydata.plugin")).getSpans(0, r7.length(), Object.class);
        Intrinsics.checkExpressionValueIsNotNull(r6, "getSpans(start, end, T::class.java)");
        Object[] r1 = ((Spanned) ZeusTransformUtils.preCheckCast(r8, Spanned.class, "com.obric.memorydata.plugin")).getSpans(0, r8.length(), Object.class);
        Intrinsics.checkExpressionValueIsNotNull(r1, "getSpans(start, end, T::class.java)");
        f r2 = g.a();
        if (r2 == null) goto L9;
        r2.d(f5270b, "lastSpanCount = " + r6.length + " , currentSpanCount = " + r1.length);
    L9:
        if (r6.length != r1.length) goto L23;
        int r3 = r6.length;
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L21;
        if (r7.getSpanStart(r6[r4]) != r8.getSpanStart(r1[r4])) goto L20;
        if (r7.getSpanEnd(r6[r4]) != r8.getSpanEnd(r1[r4])) goto L20;
        if (r7.getSpanFlags(r6[r4]) != r8.getSpanFlags(r1[r4])) goto L20;
        r4 = r4 + 1;
    L20:
        return false;
    L21:
        return true;
    L23:
        return false;
    }

    private final boolean a(List<? extends Node> r9, List<? extends Node> r10, io.noties.markwon.g r11, boolean r12) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        f r14 = g.a();
        if (r14 == null) goto L14;
        String r2 = f5270b;
        StringBuilder r3 = new StringBuilder().append("currentNodeListContainsAllLastNodeList \n lastNodeList size ");
        if (r8 == null) goto L7;
        Integer r4 = Integer.valueOf(r8.size());
    L8:
        StringBuilder r5 = r3.append(r4).append(", currentNodeList size ");
        if (r13 == null) goto L11;
        Integer r6 = Integer.valueOf(r13.size());
    L12:
        r14.d(r2, r5.append(r6).toString());
        goto L14
    L11:
        r6 = null;
        goto L12
    L7:
        r4 = null;
    L14:
        if (r8 == null) goto L55;
        if (r13 == null) goto L55;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L19:
        if (r7.hasNext() == false) goto L50;
        int r15 = r8.indexOf((Node) ZeusTransformUtils.preCheckCast(r7.next(), Node.class, "com.obric.memorydata.plugin"));
        if (r12 == false) goto L23;
        boolean r16 = com.larus.business.markdown.impl.widget.b.f5271a.a((Node) ZeusTransformUtils.preCheckCast(r8.get(r15), Node.class, "com.obric.memorydata.plugin"), (Node) ZeusTransformUtils.preCheckCast(r13.get(r15), Node.class, "com.obric.memorydata.plugin"));
    L25:
        if (Intrinsics.areEqual(r8.get(r15).getClass(), r13.get(r15).getClass()) == false) goto L46;
        if (r16 == false) goto L46;
        Node r17 = (Node) ZeusTransformUtils.preCheckCast(r8.get(r15), Node.class, "com.obric.memorydata.plugin");
        Node r18 = (Node) ZeusTransformUtils.preCheckCast(r13.get(r15), Node.class, "com.obric.memorydata.plugin");
        a r19 = f5269a;
        if (r19.a(r17, r18) == false) goto L30;
        Node r20 = (Node) ZeusTransformUtils.preCheckCast(r8.get(r15), Node.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L36;
        Node r21 = r20.firstChild;
        if (r21 == null) goto L36;
        Node r22 = r21.firstChild;
    L37:
        Node r23 = (Node) ZeusTransformUtils.preCheckCast(r13.get(r15), Node.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L42;
        Node r24 = r23.firstChild;
        if (r24 == null) goto L42;
        Node r25 = r24.firstChild;
    L44:
        if (r19.a(r22, r25) == true) goto L19;
        return false;
    L42:
        r25 = null;
    L36:
        r22 = null;
        goto L37
    L30:
        return false;
    L46:
        f r110 = g.a();
        if (r110 == null) goto L49;
        r110.d(f5270b, "not equal node with : lastNodeList[index].javaClass = " + r8.get(r15).getClass() + " , currentNodeList[index].javaClass = " + r13.get(r15).getClass());
    L49:
        return false;
    L23:
        Spanned r26 = r11.a((Node) ZeusTransformUtils.preCheckCast(r8.get(r15), Node.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
        SpannableStringBuilder r27 = (SpannableStringBuilder) ZeusTransformUtils.preCheckCast(r26, SpannableStringBuilder.class, "com.obric.memorydata.plugin");
        Spanned r28 = r11.a((Node) ZeusTransformUtils.preCheckCast(r13.get(r15), Node.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
        r16 = f5269a.a(r27, (SpannableStringBuilder) ZeusTransformUtils.preCheckCast(r28, SpannableStringBuilder.class, "com.obric.memorydata.plugin"));
        goto L25
    L50:
        f r29 = g.a();
        if (r29 == null) goto L62;
        r29.d(f5270b, "size =  " + r8.size() + " contains all node list");
        return true;
    L62:
        return true;
    L55:
        return false;
    }

    private final boolean a(Node r2, Node r3) {
        if (ZeusTransformUtils.instanceOf(r2, HtmlBlock.class) == true) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, HtmlBlock.class) == true) goto L7;
        return true;
    L7:
        if (Intrinsics.areEqual(((HtmlBlock) ZeusTransformUtils.preCheckCast(r2, HtmlBlock.class, "com.obric.memorydata.plugin")).getLiteral(), ((HtmlBlock) ZeusTransformUtils.preCheckCast(r3, HtmlBlock.class, "com.obric.memorydata.plugin")).getLiteral()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static /* synthetic */ void lambda$0kIQy70LaGGOVfm0Is4DlOfptVU(Function0 r0, List r1, ViewGroup r2) {
        a(r0, r1, r2);
    }

    public final List<Node> a(Node r3, c r4) {
        Intrinsics.checkNotNullParameter(r4, "customMarkDownInfo");
        if (r3 == null) goto L13;
        List<? extends Node> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r3.firstChild == null) goto L11;
        Node r5 = r3.firstChild;
        Intrinsics.checkNotNullExpressionValue(r5, "childNode");
        r2.add(r5);
    L8:
        if (r5.next == null) goto L11;
        Node r0 = r5.next;
        Intrinsics.checkNotNullExpressionValue(r0, "childNode.next");
        r2.add(r0);
        r5 = r5.next;
    L11:
        return f5269a.a(r2, r4);
    L13:
        return CollectionsKt.emptyList();
    }

    public final void a(com.larus.business.markdown.impl.common.a r19, Context r20, int r21, List<? extends Node> r22, List<? extends Node> r23, boolean r24, boolean r25, c r26, final ViewGroup r27, List<? extends com.larus.business.markdown.api.d.b> r28, boolean r29, e r30, String r31) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        List<? extends com.larus.business.markdown.api.d.b> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.memorydata.plugin");
        e r13 = (e) ZeusTransformUtils.wrapperContextForParams(r30, e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r19, "markdownConfigManager");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r3, "currentNodeList");
        Intrinsics.checkNotNullParameter(r26, "customMarkDownInfo");
        Intrinsics.checkNotNullParameter(r27, "currentParentViewGroup");
        if (r13 != null) goto L8;
        if (r24 == false) goto L6;
        com.larus.business.markdown.impl.markwon.g r2 = com.larus.business.markdown.impl.markwon.f.a(r11, r19, null, r26, null);
    L7:
        e r5 = (e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.memorydata.plugin");
    L9:
        if (r4 == null) goto L11;
        final ArrayList r6 = new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin"));
    L12:
        ArrayList r14 = new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin"));
        int r15 = 1;
        boolean r8 = false;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L15;
        ((Node) ZeusTransformUtils.preCheckCast(r14.get(0), Node.class, "com.obric.memorydata.plugin")).originText = r31;
    L15:
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L18;
    L21:
        boolean r9 = true;
    L22:
        if (r9 == false) goto L27;
        a(r11, r21, (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), null, r12, r27, r13, (Function0) ZeusTransformUtils.preCheckCast(new MarkdownWidgetHelper$generateMarkdownWidgets$1(r27), Function0.class, "com.obric.memorydata.plugin"));
        f r0 = g.a();
        if (r0 == null) goto L83;
        r0.d(f5270b, "lastNodeList == null , generateAllWidgets!!");
        return;
    L83:
        return;
    L27:
        if (r29 == false) goto L44;
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r10 = 0;
    L30:
        if (r16.hasNext() == false) goto L42;
        Object r1 = r16.next();
        int r17 = r10 + 1;
        if (r10 >= 0) goto L34;
        CollectionsKt.throwIndexOverflow();
    L34:
        Node r18 = (Node) ZeusTransformUtils.preCheckCast(r1, Node.class, "com.obric.memorydata.plugin");
        if (r10 >= r27.getChildCount()) goto L41;
        a r32 = f5269a;
        if (r10 != (r14.size() - 1)) goto L39;
        boolean r33 = true;
    L40:
        r32.a(r11, r21, r18, r12, r27, r10, Boolean.valueOf(r33), r13);
        goto L41
    L39:
        r33 = r8;
    L41:
        r10 = r17;
        r8 = false;
        goto L30
    L42:
        return;
    L44:
        if (r14.size() != r6.size()) goto L54;
        if (r24 == false) goto L54;
        if (r25 == false) goto L54;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L54;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L54;
        int r34 = 0;
        if (a(r6.subList(0, RangesKt.coerceAtLeast(r6.size(), 0)), r14.subList(0, RangesKt.coerceAtLeast(r14.size(), 0)), r5.a(), r19.a().q()) == false) goto L56;
        return;
    L56:
        if (r14.size() != r6.size()) goto L66;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L66;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L66;
        if (a(r6.subList(r34, RangesKt.coerceAtLeast(r6.size() - 1, r34)), r14.subList(r34, RangesKt.coerceAtLeast(r14.size() - 1, r34)), r5.a(), r19.a().q()) == false) goto L66;
        a(r11, r21, (Node) ZeusTransformUtils.preCheckCast(CollectionsKt.last((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin")), Node.class, "com.obric.memorydata.plugin"), r12, r27, r14.size() - 1, true, r13);
        return;
    L66:
        if (r14.size() > r6.size()) goto L68;
    L78:
        a(r11, r21, (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), null, r12, r27, r13, (Function0) ZeusTransformUtils.preCheckCast(new MarkdownWidgetHelper$generateMarkdownWidgets$4(r27), Function0.class, "com.obric.memorydata.plugin"));
        return;
    L68:
        if (a(r6.subList(r34, RangesKt.coerceAtLeast(r6.size() - 1, r34)), (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), r5.a(), r19.a().q()) == false) goto L78;
        List<? extends Node> r35 = r14.subList(r6.size() - 1, r14.size());
        Intrinsics.checkNotNullExpressionValue(r35, "nodeList.subList(lastNod…size - 1 , nodeList.size)");
        Object r36 = CollectionsKt.getOrNull((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), r6.size() - 2);
        Node r37 = (Node) ZeusTransformUtils.preCheckCast(r36, Node.class, "com.obric.memorydata.plugin");
        if (r6.size() > 1) goto L73;
        r15 = r34;
    L73:
        if (r15 == 0) goto L75;
        Object r38 = r36;
    L76:
        a(r11, r21, r35, (Node) ZeusTransformUtils.preCheckCast(r38, Node.class, "com.obric.memorydata.plugin"), r12, r27, r13, (Function0) ZeusTransformUtils.preCheckCast(new MarkdownWidgetHelper$generateMarkdownWidgets$3(r27, r6), Function0.class, "com.obric.memorydata.plugin"));
        return;
    L75:
        r38 = null;
    L54:
        r34 = 0;
        goto L56
    L18:
        if (r7.isEmpty() == true) goto L21;
        r9 = false;
        goto L22
    L11:
        r6 = null;
        goto L12
    L6:
        r2 = com.larus.business.markdown.impl.markwon.f.b(r11, r19, null, r26, null);
        goto L7
    L8:
        r5 = r13;
        goto L9
    }
}
