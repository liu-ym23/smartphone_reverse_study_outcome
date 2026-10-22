package com.ss.android.lark.movable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedance.lark.lark_markdown_render_android.Lark_markdown_renderKt;
import com.bytedance.lark.lark_markdown_render_android.MovableDocumentInfo;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.island.MovableIslandsOpsApplier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00015B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010!\u001a\u00020\"2\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\"0$¢\u0006\u0002\b&J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0014J\u0012\u0010*\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010\u001cH\u0007J$\u0010*\u001a\u00020\"2\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-J\b\u0010.\u001a\u00020\"H\u0016J\u0017\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u000201H\u0002¢\u0006\u0004\b2\u00103J\b\u00104\u001a\u00020\"H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013RT\u0010\u0014\u001aF\b\u0001\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/ss/android/lark/movable/MarkdownMovableView;", "Lcom/ss/android/lark/movable/MovableView;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ownedParsedDocumentReleaseHandle", "Lcom/ss/android/lark/movable/MovableDocumentReleaseHandle;", "markdownRenderScope", "Lkotlinx/coroutines/CoroutineScope;", "currentMarkdown", "", "renderConfig", "Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderConfig;", "getRenderConfig$movable_release", "()Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderConfig;", "setRenderConfig$movable_release", "(Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderConfig;)V", "markParser", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "markdown", "", "widthDp", "Lkotlin/coroutines/Continuation;", "Lcom/ss/android/lark/movable/ParsedMovableDocument;", "", "Lkotlin/jvm/functions/Function3;", "manualHandleReleasing", "", "setupMarkdown", "", "block", "Lkotlin/Function1;", "Lcom/ss/android/lark/movable/MarkdownMovableView$Config;", "Lkotlin/ExtensionFunctionType;", "applyConfig", "config", "Lcom/ss/android/lark/movable/MovableView$Config;", "renderMarkdown", "parsedDocument", "urlPreviewInlines", "Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderUrlPreviewInlines;", "onRecycled", "releaseOwnedParsedDocumentIfNeed", "documentId", "Lkotlin/UInt;", "releaseOwnedParsedDocumentIfNeed-WZ4Q5Ns", "(I)V", "releaseOwnedParsedDocument", "Config", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MarkdownMovableView extends MovableView {
    public d B;
    public final CoroutineScope C;
    public String D;
    public MovableRenderConfig E;
    public Function3<? super String, ? super Float, ? super Continuation<? super h>, ? extends Object> F;
    public boolean G;

    public static final class a extends MovableView.b {
        public boolean g;
        public MovableRenderConfig h;
        public Function3<? super String, ? super Float, ? super Continuation<? super h>, ? extends Object> i;

        public a() {
        }
    }

    @Override // com.ss.android.lark.movable.MovableView
    public final void d() {
        if (this.G == true) goto L9;
        d r0 = this.B;
        if (r0 == null) goto L8;
        r0.a();
    L8:
        this.B = null;
    L9:
        this.D = null;
        this.E = null;
        this.F = null;
        JobKt.cancelChildren$default(this.C.getCoroutineContext(), null, 1, null);
        super.d();
    }

    public final MovableRenderConfig getRenderConfig$movable_release() {
        return this.E;
    }

    public MarkdownMovableView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // com.ss.android.lark.movable.MovableView
    public final void b(MovableView.b r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        final Function2<? super Integer, ? super Integer, Unit> r0 = r3.e;
        r3.e = new MarkdownMovableView$applyConfig$1(this, r0);
        super.b(r3);
        if ((r3 instanceof a) == false) goto L6;
        a r4 = (a) r3;
        this.G = r4.g;
        this.E = r4.h;
        this.F = r4.i;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.view.View, android.widget.FrameLayout, com.ss.android.lark.movable.MarkdownMovableView, com.ss.android.lark.movable.MovableView] */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final void j(h r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.G == true) goto L11;
        d r0 = this.B;
        if (r0 == null) goto L10;
        r0.a();
    L10:
        this.B = null;
    L11:
        this.B = r11.b;
        int r1 = r11.a.getDocumentId-pVg5ArA();
        d r2 = this.B;
        if (r2 != null) goto L15;
    L22:
        MovableDocumentInfo r12 = r11.a;
        Intrinsics.checkNotNullParameter(r12, "originDocumentInfo");
        Context r3 = getContext();
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r3, "context");
        MovableDocumentInfo r4 = MovableDocumentInfo.copy-SOCY_n4$default(r12, 0, 0, com.ss.android.lark.movable.utils.b.d(r12.getWidth(), r3), com.ss.android.lark.movable.utils.b.d(r12.getHeight(), r3), 3, null);
        int r5 = r4.getDocumentId-pVg5ArA();
        MovableDocumentInfo r6 = getMovableDocumentInfo();
        if (r6 == null) goto L25;
        UInt r7 = UInt.box-impl(r6.getDocumentId-pVg5ArA());
    L26:
        boolean r8 = UInt.equals-impl(r5, r7);
        boolean r9 = false;
        if (r8 == false) goto L39;
        int r10 = r4.getDocumentVersion-pVg5ArA();
        MovableDocumentInfo r13 = getMovableDocumentInfo();
        if (r13 == null) goto L31;
        int r14 = r13.getDocumentVersion-pVg5ArA();
    L33:
        if (Integer.compare(r10 ^ Target.SIZE_ORIGINAL, r14 ^ Target.SIZE_ORIGINAL) > 0) goto L39;
        StringBuilder r15 = new StringBuilder("receive lower document version, ignore，curVersion:");
        MovableDocumentInfo r16 = getMovableDocumentInfo();
        if (r16 == null) goto L37;
        int r17 = r16.getDocumentVersion-pVg5ArA();
    L38:
        r15.append(UInt.toString-impl(r17));
        r15.append(", newVersion:");
        r15.append(UInt.toString-impl(r4.getDocumentVersion-pVg5ArA()));
        Log.i("MovableView", r15.toString());
        MovableView.c r18 = null;
    L52:
        if (r18 == null) goto L100;
        this.h++;
    L85:
        e = move-exception;
        Log.e("MovableView", "render failed: " + e.getMessage(), e);
        return;
    L56:
        if (this.i == false) goto L58;
        byte[] r19 = Lark_markdown_renderKt.ffiRequestRenderStream-feOb9K0(r18.c, r18.d);     // Catch: Exception -> L85
    L59:
        byte[] r20 = Lark_markdown_renderKt.ffiMovableRequestAttachmentsDiff-zly0blg(r18.d, 0, r18.c);     // Catch: Exception -> L85
        byte[] r21 = Lark_markdown_renderKt.ffiMovableRequestIslandsDiff-zly0blg(r18.d, 0, r18.c);     // Catch: Exception -> L85
        Log.i("MovableView", "render main fetched: doc=" + r18.b.toString() + ", sizes(common=" + r19.length + ", attach=" + r20.length + ", islands=" + r21.length + ')');     // Catch: Exception -> L85
        i(r19, r18.a);     // Catch: Exception -> L85
        g(r20);     // Catch: Exception -> L85
        h(r18.e);     // Catch: Exception -> L85
        if (Arrays.equals(this.f, r21) == false) goto L62;
        List r110 = null;
    L64:
        if (r110 == null) goto L69;
        ?? r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));     // Catch: Exception -> L85
        Iterator r23 = r110.iterator();     // Catch: Exception -> L85
    L67:
        if (r23.hasNext() == false) goto L70;
        r22.add(Integer.valueOf(((jsb.a) ((Pair) r23.next()).getSecond()).a));     // Catch: Exception -> L85
    L70:
        Iterable r24 = (Iterable) r22;     // Catch: Exception -> L85
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));     // Catch: Exception -> L85
        Iterator r26 = r24.iterator();     // Catch: Exception -> L85
    L72:
        if (r26.hasNext() == false) goto L83;
        int r27 = ((Number) r26.next()).intValue();     // Catch: Exception -> L85
        if (this.i == false) goto L77;
        byte[] r28 = Lark_markdown_renderKt.ffiRequestIslandRenderStream-zly0blg(r18.c, r18.d, UInt.constructor-impl(r27));     // Catch: Exception -> L80
    L78:
        Pair r29 = TuplesKt.to(Integer.valueOf(r27), r28);     // Catch: Exception -> L80
    L82:
        r25.add(r29);     // Catch: Exception -> L85
        goto L72
    L77:
        r28 = Lark_markdown_renderKt.ffiRequestIslandRenderStreamInTextApi-zly0blg(r18.c, r18.d, UInt.constructor-impl(r27));     // Catch: Exception -> L80
        goto L78
    L80:
        e = move-exception;
        Log.e("MovableView", "Failed to request island " + r27 + ": " + e.getMessage());     // Catch: Exception -> L85
        r29 = TuplesKt.to(Integer.valueOf(r27), null);     // Catch: Exception -> L85
        goto L82
    L83:
        c(r18, r25, r9, r110);     // Catch: Exception -> L85
        return;
    L69:
        r22 = CollectionsKt.emptyList();     // Catch: Exception -> L85
        goto L70
    L62:
        this.f = r21;     // Catch: Exception -> L85
        int r111 = MovableIslandsOpsApplier.c;     // Catch: Exception -> L85
        r110 = MovableIslandsOpsApplier.a.a(r21, getContext());     // Catch: Exception -> L85
        r9 = true;
        goto L64
    L58:
        r19 = Lark_markdown_renderKt.ffiRequestRenderStreamInTextApi-feOb9K0(r18.c, r18.d);     // Catch: Exception -> L85
        goto L59
    L100:
        return;
    L37:
        r17 = 0;
        goto L38
    L31:
        r14 = 0;
    L39:
        this.t = r12;
        StringBuilder r30 = new StringBuilder("updateMovableDocumentInfo called: documentId =");
        MovableDocumentInfo r31 = this.t;
        if (r31 == null) goto L42;
        UInt r32 = UInt.box-impl(r31.getDocumentId-pVg5ArA());
    L43:
        r30.append(r32);
        r30.append(", documentVersion = ");
        MovableDocumentInfo r33 = this.t;
        if (r33 == null) goto L46;
        UInt r34 = UInt.box-impl(r33.getDocumentVersion-pVg5ArA());
    L47:
        r30.append(r34);
        Log.d("MovableView", r30.toString());
        Log.i("MovableView", "hashCode: " + hashCode() + ", start render MovableView: " + r12.toString() + ", inStreaming: false");
        float r35 = r4.getWidth();
        float r36 = r4.getHeight();
        int r37 = getLayoutParams().height;
        int r38 = (int) r36;
        ViewGroup.LayoutParams r39 = getLayoutParams();
        if (r39 == null) goto L91;
        r39.width = (int) r35;
        setLayoutParams(r39);
        ViewGroup.LayoutParams r40 = getLayoutParams();
        if (r40 == null) goto L89;
        r40.height = r38;
        setLayoutParams(r40);
        r18 = new MovableView.c(r12, r4, r4.getDocumentVersion-pVg5ArA(), r4.getDocumentId-pVg5ArA());
        goto L52
    L89:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L91:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L46:
        r34 = null;
        goto L47
    L42:
        r32 = null;
        goto L43
    L25:
        r7 = null;
        goto L26
    L15:
        if (r2.a == r1) goto L22;
        if (this.G == true) goto L22;
        if (r2 == null) goto L21;
        r2.a();
    L21:
        this.B = null;
        goto L22
    }

    public final void setRenderConfig$movable_release(MovableRenderConfig r1) {
        this.E = r1;
    }

    public final void setupMarkdown(Function1<? super a, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        a r0 = new a();
        r2.invoke(r0);
        setupWithConfig(r0);
    }

    public MarkdownMovableView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.C = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static void k(MarkdownMovableView r11, String r12, float r13) {
        if (r12 != null) goto L5;
        r11.getClass();
        return;
    L5:
        r11.D = r12;
        BuildersKt.launch$default(r11.C, null, null, new MarkdownMovableView$renderMarkdown$1(r11, r12, r13, null, null), 3, null);
    }
}
