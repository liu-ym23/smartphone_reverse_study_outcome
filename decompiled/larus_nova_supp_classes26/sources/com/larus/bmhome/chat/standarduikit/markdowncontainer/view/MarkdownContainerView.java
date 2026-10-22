package com.larus.bmhome.chat.standarduikit.markdowncontainer.view;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.larus.bmhome.chat.layout.widget.v0;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import fh8.f;
import fh8.g;
import fh8.h;
import fh8.l;
import fh8.t;
import fm8.b;
import fm8.c;
import fm8.d;
import fm8.e;
import fm8.i;
import fm8.j;
import fm8.k;
import fm8.n;
import fm8.o;
import fm8.p;
import fm8.q;
import fm8.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vg8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000  2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001 B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0002J\u0016\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0002J\u0006\u0010\u001b\u001a\u00020\u0012J\b\u0010\u001c\u001a\u00020\u0012H\u0003J\b\u0010\u001d\u001a\u00020\u0012H\u0003J\b\u0010\u001e\u001a\u00020\u0012H\u0014J\b\u0010\u001f\u001a\u00020\u0012H\u0014R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/markdowncontainer/view/MarkdownContainerView;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/markdowncontainer/view/MarkdownTextContainerInput;", "Lcom/larus/bmhome/chat/standarduikit/markdowncontainer/view/MarkdownTextContainerOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "markdownRenderHelper", "Lcom/larus/bmhome/chat/list/cell/text/markdown/MarkdownRenderHelper;", "lastMarginRectF", "Landroid/graphics/RectF;", "commonInputData", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "bindData", "", "input", "output", "tryCreateMarkdownRenderHelper", "resetMarkdownWidgetsIfMarginRectFChanged", "marginRectF", "sameValueAs", "", "other", "onViewRecycled", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownContainerView extends LinearLayout {
    public static final /* synthetic */ int d = 0;
    public m a;
    public RectF b;
    public f c;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        m r0 = this.a;
        if (r0 == null) goto L8;
        v0 r1 = r0.g;
        if (r1 == null) goto L9;
        r1.b();
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m r0 = this.a;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    public MarkdownContainerView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public MarkdownContainerView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.c = new g().a();
        setOrientation(1);
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [fm8.f] */
    /* JADX WARN: Type inference failed for: r12v1, types: [fm8.g] */
    /* JADX WARN: Type inference failed for: r14v1, types: [fm8.h] */
    /* JADX WARN: Type inference failed for: r15v1, types: [fm8.n] */
    /* JADX WARN: Type inference failed for: r2v9, types: [fm8.o] */
    /* JADX WARN: Type inference failed for: r3v11, types: [fm8.j] */
    /* JADX WARN: Type inference failed for: r4v6, types: [fm8.i] */
    /* JADX WARN: Type inference failed for: r5v2, types: [fm8.p] */
    /* JADX WARN: Type inference failed for: r6v1, types: [fm8.b] */
    /* JADX WARN: Type inference failed for: r7v1, types: [fm8.c] */
    /* JADX WARN: Type inference failed for: r8v1, types: [fm8.d] */
    /* JADX WARN: Type inference failed for: r9v1, types: [fm8.e] */
    public final void a(final q r30, final r r31) {
        Intrinsics.checkNotNullParameter(r30, "input");
        Intrinsics.checkNotNullParameter(r31, "output");
        FLogger.a.d("MarkdownContainerView", "bindData, input: " + r30);
        if (this.a != null) goto L6;
        this.a = new m("text_block" + r30.m);
    L6:
        t.a r2 = new t.a();
        r2.a = r30.a;
        r2.b = r30.b;
        r2.c = r30.c;
        r2.d = r30.d;
        r2.e = r30.e;
        r2.f = r30.f;
        r2.h = r30.g;
        r2.i = r30.v;
        t r3 = r2.a();
        String r4 = r30.l;
        if (r4 != null) goto L9;
        r4 = r30.k;
    L9:
        g r5 = h.a(r30.u);
        r5.j = r4;
        r5.i = new fm8.a(this, r30, r31);
        this.c = r5.a();
        l r6 = new l(r30.i, r30.j, r30.k, r30.m, r4, r30.n, false, r30.o, r30.p, r30.q, r30.t, 192);
        if (ObricFeatureServiceDelegate.b.a() == false) goto L44;
        z2 r7 = z2.a;
        RectF r8 = r30.v;
        RectF r9 = this.b;
        if (r9 == null) goto L40;
        boolean r10 = false;
        if (r8 != null) goto L16;
    L36:
        if (r10 == true) goto L40;
        m r11 = this.a;
        if (r11 == null) goto L40;
        r11.d(this);
        goto L40
    L16:
        if (r9.left != r8.left) goto L18;
        boolean r12 = true;
    L19:
        if (r12 == false) goto L36;
        if (r9.top != r8.top) goto L23;
        boolean r13 = true;
    L24:
        if (r13 == false) goto L36;
        if (r9.right != r8.right) goto L28;
        boolean r14 = true;
    L29:
        if (r14 == false) goto L36;
        if (r9.bottom != r8.bottom) goto L33;
        boolean r15 = true;
    L34:
        if (r15 == false) goto L36;
        r10 = true;
        goto L36
    L33:
        r15 = false;
        goto L34
    L28:
        r14 = false;
        goto L29
    L23:
        r13 = false;
        goto L24
    L18:
        r12 = false;
    L40:
        if (r8 == null) goto L42;
        RectF r16 = new RectF(r8);
    L43:
        this.b = r16;
        goto L44
    L42:
        r16 = null;
    L44:
        fh8.r r17 = new fh8.r(new n(r31), new o(r31), new p(r31), new b(r31), new c(r31), new d(r31), new e(r31), new fm8.f(r31), new fm8.g(r31), new fm8.h(r31), new i(r31), new j(r31));
        m r18 = this.a;
        if (r18 == null) goto L48;
        fh8.e.a(r18, this, r30.r, r3, r6, new k(r31, this), new fm8.l(r31, this), new fm8.m(r31, this), null, this.c, r30.s, r17, 128);
        return;
    }
}
