package com.larus.business.markdown.impl.widget;

import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.larus.business.markdown.api.depend.f;
import com.larus.business.markdown.api.depend.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fJH\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\bJN\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001eH\u0002JI\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\t2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/business/markdown/impl/widget/MarkdownMultiWidgetHelper;", "", "()V", "TAG", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "cutIntoNodeList", "", "Lorg/commonmark/node/Node;", "currentNode", "cutStrategy", "Lcom/larus/business/markdown/impl/widget/MarkdownMultiWidgetHelper$CutStrategy;", "generateMarkdownWidget", "", "context", "Landroid/content/Context;", "maxContentWidth", "", "isLastNode", "", "rootNode", "currentParentViewGroup", "Landroid/view/ViewGroup;", "lastRecordNode", "widgetHandlerList", "Lcom/larus/business/markdown/api/widget/IMarkdownWidgetHandler;", "generateWidgetFromNode", "node", "beforeUiRunnable", "Lkotlin/Function0;", "updateWidgetFromNode", "(Landroid/content/Context;ILorg/commonmark/node/Node;Ljava/util/List;Landroid/view/ViewGroup;Ljava/lang/Boolean;)V", "CutStrategy", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MarkdownMultiWidgetHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MarkdownMultiWidgetHelper f5267a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5268b = null;
    private static final al c = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/business/markdown/impl/widget/MarkdownMultiWidgetHelper$CutStrategy;", "", "(Ljava/lang/String;I)V", "DoubleCut", "LeftCut", "RightCut", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum CutStrategy extends Enum<CutStrategy> {
        private static final /* synthetic */ CutStrategy[] $VALUES = null;
        public static final CutStrategy DoubleCut = null;
        public static final CutStrategy LeftCut = null;
        public static final CutStrategy RightCut = null;

        private static final /* synthetic */ CutStrategy[] $values() {
            return new CutStrategy[]{DoubleCut, LeftCut, RightCut};
        }

        static {
            DoubleCut = new CutStrategy("DoubleCut", 0);
            LeftCut = new CutStrategy("LeftCut", 1);
            RightCut = new CutStrategy("RightCut", 2);
            $VALUES = $values();
        }

        private CutStrategy(String r1, int r2) {
            super(r1, r2);
        }

        public static CutStrategy valueOf(String r2) {
            return (CutStrategy) ZeusTransformUtils.preCheckCast(Enum.valueOf(CutStrategy.class, r2), CutStrategy.class, "com.obric.memorydata.plugin");
        }

        public static CutStrategy[] values() {
            return (CutStrategy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CutStrategy[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1})
    public static final class a<T> implements Comparator<T> {
        public a() {
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
        f5267a = new MarkdownMultiWidgetHelper();
        f5268b = "MarkdownMultiWidgetHelper";
        c = am.a();
    }

    private MarkdownMultiWidgetHelper() {
    }

    private final void a(Context r14, int r15, Node r16, List<? extends com.larus.business.markdown.api.d.b> r17, ViewGroup r18, Boolean r19) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        if (r18.getChildCount() >= 1) goto L38;
        return;
    L38:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L30
        Object r12 = null;
        if (r1 == null) goto L19;
        List r4 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L30
        if (r4 == null) goto L19;
        List r5 = CollectionsKt.reversed((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L30
        if (r5 == null) goto L19;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L30
    L13:
        if (r6.hasNext() == false) goto L17;
        Object r7 = r6.next();     // Catch: Throwable -> L30
        if (((com.larus.business.markdown.api.d.b) ZeusTransformUtils.preCheckCast(r7, com.larus.business.markdown.api.d.b.class, "com.obric.memorydata.plugin")).a(r16) == false) goto L13;
    L18:
        com.larus.business.markdown.api.d.b r8 = (com.larus.business.markdown.api.d.b) ZeusTransformUtils.preCheckCast(r7, com.larus.business.markdown.api.d.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
    L20:
        if (r8 == null) goto L22;
        com.larus.business.markdown.api.d.a r9 = com.larus.business.markdown.api.d.b.a.a(r8, r2, r15, 0, r18, r16, r19, null, 64, null);     // Catch: Throwable -> L30
    L24:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L26;
        r12 = i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MarkdownMultiWidgetHelper$updateWidgetFromNode$1$1(r9, r18, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L30
    L28:
        Object r0 = Result.m1421constructorimpl(r12);     // Catch: Throwable -> L30
    L32:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r0);
        if (r10 == null) goto L43;
        f r11 = g.a();
        if (r11 == null) goto L44;
        r11.i(f5268b, r10.toString());
        return;
    L44:
        return;
    L43:
        return;
    L26:
        if (r9 == null) goto L28;
        r9.a(0, r18);     // Catch: Throwable -> L30
        r12 = Unit.INSTANCE;     // Catch: Throwable -> L30
        goto L28
    L22:
        r9 = null;
        goto L24
    L17:
        r7 = null;
    L19:
        r8 = null;
    L30:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L32
    }

    private final void a(Context r14, int r15, Node r16, boolean r17, List<? extends com.larus.business.markdown.api.d.b> r18, final ViewGroup r19, Function0<Unit> r20) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        final Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r20, Function0.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L27;
        List r1 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L28;
        List r2 = CollectionsKt.reversed((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L29;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();
        if (((com.larus.business.markdown.api.d.b) ZeusTransformUtils.preCheckCast(r5, com.larus.business.markdown.api.d.b.class, "com.obric.memorydata.plugin")).a(r16) == false) goto L10;
    L15:
        com.larus.business.markdown.api.d.b r6 = (com.larus.business.markdown.api.d.b) ZeusTransformUtils.preCheckCast(r5, com.larus.business.markdown.api.d.b.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L30;
        final com.larus.business.markdown.api.d.a r7 = com.larus.business.markdown.api.d.b.a.a(r6, r3, r15, null, r16, Boolean.valueOf(r17), null, 32, null);
        if (r7 == null) goto L31;
        Runnable r8 = new $$Lambda$MarkdownMultiWidgetHelper$ITT8kX46wLNh6CsEaV6pMNZMJ_M(r11, r7, r19);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L22;
        i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MarkdownMultiWidgetHelper$generateWidgetFromNode$1(r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L22:
        r8.run();
        return;
    L31:
        return;
    L30:
        return;
    L14:
        r5 = null;
        goto L15
    L29:
        return;
    L28:
        return;
    }

    private static final void a(Function0 r2, com.larus.business.markdown.api.d.a r3, ViewGroup r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        com.larus.business.markdown.api.d.a r6 = (com.larus.business.markdown.api.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.larus.business.markdown.api.d.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "$beforeUiRunnable");
        Intrinsics.checkNotNullParameter(r6, "$callback");
        Intrinsics.checkNotNullParameter(r4, "$currentParentViewGroup");
        r5.invoke();
        r6.a(r4);
    }

    public static /* synthetic */ void lambda$ITT8kX46wLNh6CsEaV6pMNZMJ_M(Function0 r0, com.larus.business.markdown.api.d.a r1, ViewGroup r2) {
        a(r0, r1, r2);
    }

    public final void a(Context r9, int r10, boolean r11, Node r12, final ViewGroup r13, Node r14, List<? extends com.larus.business.markdown.api.d.b> r15) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        List<? extends com.larus.business.markdown.api.d.b> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r12, "rootNode");
        Intrinsics.checkNotNullParameter(r13, "currentParentViewGroup");
        if (r14 != null) goto L8;
        a(r2, r10, r12, r11, r5, r13, (Function0) ZeusTransformUtils.preCheckCast(new MarkdownMultiWidgetHelper$generateMarkdownWidget$1(r13), Function0.class, "com.obric.memorydata.plugin"));
        f r0 = g.a();
        if (r0 == null) goto L10;
        r0.d(f5268b, "lastNodeList == null , generateAllWidgets!!");
        return;
    L10:
        return;
    L8:
        a(r2, r10, r12, r5, r13, Boolean.valueOf(r11));
    }
}
