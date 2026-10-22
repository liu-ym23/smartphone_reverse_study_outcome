package com.bytedance.android.livesdk.dslservice.view;

import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import fu1.e;
import fu1.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import yt1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/bytedance/android/ecom/arch/slice/render/elements/BaseSlcViewManager;", "it", "Lcom/bytedance/android/ecom/arch/slice/render/context/SlcTemplateContext;", "invoke"}, k = 3, mv = {1, 4, 3})
final class DSLCustomViewMap$register2Slice$1 extends Lambda implements Function1<SlcTemplateContext, BaseSlcViewManager<?>> {
    final /* synthetic */ f $provider;

    public DSLCustomViewMap$register2Slice$1(f r1) {
        this.$provider = r1;
        super(1);
    }

    public final BaseSlcViewManager<?> invoke(SlcTemplateContext r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        int r0 = this.$provider.getType();
        if (r0 == 1) goto L20;
        if (r0 != 2) goto L7;
        f r1 = this.$provider;
        if (r1 == null) goto L18;
        return new fu1.f(r3, r1);
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.dsl.api.DSLCustomViewInterface<out android.view.ViewGroup>");
    L7:
        if (r0 != 3) goto L21;
        f r2 = this.$provider;
        if (r2 == null) goto L13;
        return new e(r3, r2);
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.dsl.api.DSLCustomViewInterface<out com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView>");
    L21:
        return new g(r3, this.$provider);
    L20:
        return new g(r3, this.$provider);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((SlcTemplateContext) r1);
    }
}
