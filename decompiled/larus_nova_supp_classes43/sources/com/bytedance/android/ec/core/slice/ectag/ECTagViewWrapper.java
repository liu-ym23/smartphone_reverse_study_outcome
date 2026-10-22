package com.bytedance.android.ec.core.slice.ectag;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.b;
import com.bytedance.android.ecom.arch.slice.render.p;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.render.util.h;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcDefaultTemplateProvider;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.ecom.slice.ext.template.gecko.c;
import com.bytedance.android.ecom.slice.ext.template.gecko.g;
import com.bytedance.android.ecom.slice.ext.template.gecko.j;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/slice/ectag/ECTagViewWrapper;", "Landroid/widget/FrameLayout;", "", "serverTimeSecond", "", "setServerTime", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTagViewWrapper extends FrameLayout {
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static volatile boolean e;
    public static final a f = null;
    public final SlcRenderContext a;
    public final r b;

    public static final class a {
        public a() {
        }

        public static SlcRenderContext a(Context r10, b r11) {
            Intrinsics.checkNotNullParameter("native_ectag", "biz");
            Intrinsics.checkNotNullParameter(r10, "context");
            Activity r12 = h.getActivity(r10);
            if (r12 != null) goto L6;
            nq.a.c(null, ECTagViewWrapper$Companion$getSlcRenderContext$1.INSTANCE, 1);
            return null;
        L6:
            Object r13 = mq.a.a(r12).getTag(2131380617);
            if ((r13 instanceof SlcRenderContext) == true) goto L10;
            r13 = null;
        L10:
            SlcRenderContext r14 = (SlcRenderContext) r13;
            if (r14 != null) goto L23;
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r10, "context");
            if (ECTagViewWrapper.e == true) goto L16;
            final g r0 = new g(CollectionsKt.listOf((j) ECTagViewWrapper.c.getValue()), 6);
            SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.l, "native_ectag_template_loader_id", "ecom_pdp_card_template", wh.a.b(r10), new ECTagViewWrapper$Companion$initBiz$1(r0));
            ECTagViewWrapper.e = true;
        L16:
            SlcGeckoTemplateMgr.l.getClass();
            c r1 = SlcGeckoTemplateMgr.e("native_ectag_template_loader_id", "native_ectag_template_loader_id");
            com.bytedance.android.ecom.arch.slice.expr.b r15 = r1.c();
            if (r15 != null) goto L19;
            r15 = new com.bytedance.android.ecom.arch.slice.expr.b(null);
        L19:
            r14 = new SlcRenderContext(r10, "native_ectag", new SlcExprContext(r15));
            if (r11 == null) goto L22;
            r14.f = r11;
        L22:
            r14.a0 = new SlcDefaultTemplateProvider(r1);
            r14.g = true;
            Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            mq.a.a(r12).setTag(2131380617, r14);
        L23:
            return r14;
        }
    }

    public ECTagViewWrapper(Context r10) {
        this(r10, null, 0, 14);
    }

    public ECTagViewWrapper(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 12);
    }

    public ECTagViewWrapper(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 8);
    }

    static {
        f = new a();
        c = LazyKt.lazy(ECTagViewWrapper$Companion$ectagPreloadInfo$2.INSTANCE);
        d = LazyKt.lazy(ECTagViewWrapper$Companion$ecTagElement$2.INSTANCE);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams r10) {
        if (r10 == null) goto L8;
        r r0 = this.b;
        if (r0 == null) goto L8;
        View r1 = r0.c;
        if (r1 == null) goto L8;
        r1.setLayoutParams(new FrameLayout.LayoutParams(r10.width, r10.height));
    L8:
        super.setLayoutParams(r10);
    }

    public final void setServerTime(long r10) {
        SlcRenderContext r0 = this.a;
        if (r0 == null) goto L6;
        r0.r(r10);
        return;
    }

    public ECTagViewWrapper(Context r10, AttributeSet r11, int r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        f.getClass();
        SlcRenderContext r14 = a.a(r10, null);
        this.a = r14;
        if (r14 != null) goto L11;
        nq.a.c(null, AnonymousClass1.INSTANCE, 1);
        return;
    L11:
        SliceRender r15 = SliceRender.o;
        SlcElement r16 = ((SlcElement) d.getValue()).deepClone();
        Lazy r1 = c;
        p r17 = new p(((j) r1.getValue()).c(), ((j) r1.getValue()).a(), null, null, 124);
        r15.getClass();
        r.d.getClass();
        r r18 = r.a.a(r14, r16, r17);
        addView(r18.c, 0);
        r18.b(new com.bytedance.android.ec.core.slice.ectag.a(this));
        Unit r19 = Unit.INSTANCE;
        this.b = r18;
    }
}
