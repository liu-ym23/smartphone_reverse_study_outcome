package com.bytedance.android.ec.core.slice.ectaggroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.slice.ectag.ECTagViewWrapper;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.p;
import com.bytedance.android.ecom.arch.slice.render.r;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/slice/ectaggroup/ECTagGroupViewWrapper;", "Landroid/widget/FrameLayout;", "", "serverTimeSecond", "", "setServerTime", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTagGroupViewWrapper extends FrameLayout {
    public static final Lazy c = null;
    public final SlcRenderContext a;
    public final r b;

    public static final class a {
    }

    public ECTagGroupViewWrapper(Context r10) {
        this(r10, null, 0, 14);
    }

    public ECTagGroupViewWrapper(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 12);
    }

    public ECTagGroupViewWrapper(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 8);
    }

    static {
        c = LazyKt.lazy(ECTagGroupViewWrapper$Companion$ecTagGroupElement$2.INSTANCE);
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

    public ECTagGroupViewWrapper(Context r10, AttributeSet r11, int r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        ECTagViewWrapper.f.getClass();
        SlcRenderContext r14 = ECTagViewWrapper.a.a(r10, null);
        this.a = r14;
        if (r14 != null) goto L11;
        nq.a.c(null, AnonymousClass1.INSTANCE, 1);
        return;
    L11:
        SliceRender r15 = SliceRender.o;
        SlcElement r16 = ((SlcElement) c.getValue()).deepClone();
        p r17 = new p("native_ectag_group_url", "native_ectag_group", null, null, 124);
        r15.getClass();
        r.d.getClass();
        r r18 = r.a.a(r14, r16, r17);
        addView(r18.c, 0);
        r18.b(new com.bytedance.android.ec.core.slice.ectaggroup.a(this));
        Unit r19 = Unit.INSTANCE;
        this.b = r18;
    }
}
