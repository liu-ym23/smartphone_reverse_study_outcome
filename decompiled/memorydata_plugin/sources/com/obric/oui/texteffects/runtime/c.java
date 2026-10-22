package com.obric.oui.texteffects.runtime;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\u0006\u0010\u0018\u001a\u00020\u0013J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/texteffects/runtime/ExternalViewLayerBinding;", "", "bindingKey", "", "view", "Landroid/view/View;", "initialTextWidthPx", "", "inactiveVisibility", "", "fallbackLayerWidthDp", "(Ljava/lang/String;Landroid/view/View;FIF)V", "getBindingKey", "()Ljava/lang/String;", "cachedTextWidthPx", "density", "getView", "()Landroid/view/View;", "apply", "", TypedValues.AttributesType.S_FRAME, "Lcom/obric/oui/texteffects/runtime/SampledLayerFrame;", "parentWidthPx", "getLayerWidthPx", "reset", "resolveDimension", EventBody.KEY_VALUE, "Lcom/obric/oui/texteffects/core/EffectValue;", "updateTextWidthPx", "textWidthPx", "Companion", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f14689a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14690b;
    private final View c;
    private final int d;
    private final float e;
    private final float f;
    private float g;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/texteffects/runtime/ExternalViewLayerBinding$Companion;", "", "()V", "Tag", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14689a = new a(null);
    }

    public c(String r2, View r3, float r4, int r5, float r6) {
        Intrinsics.checkNotNullParameter(r2, "bindingKey");
        Intrinsics.checkNotNullParameter(r3, "view");
        this.f14690b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        this.g = RangesKt.coerceAtLeast(r4, 0.0f);
    }

    public /* synthetic */ c(String r7, View r8, float r9, int r10, float r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = 0.0f;
    L5:
        float r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        r10 = 4;
    L8:
        int r4 = r10;
        if ((r12 & 16) == 0) goto L11;
        r11 = 248.0f;
    L11:
        this(r7, r8, r3, r4, r11);
    }

    private final float a(com.obric.oui.texteffects.core.m r4, float r5) {
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.texteffects.core.m.b.class) == false) goto L6;
        return ((com.obric.oui.texteffects.core.m.b) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.core.m.b.class, "com.obric.memorydata.plugin")).a();
    L6:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.texteffects.core.m.a.class) == false) goto L9;
        return this.f * ((com.obric.oui.texteffects.core.m.a) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.core.m.a.class, "com.obric.memorydata.plugin")).a();
    L9:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.texteffects.core.m.e.class) == false) goto L13;
        float r6 = ((com.obric.oui.texteffects.core.m.e) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.core.m.e.class, "com.obric.memorydata.plugin")).a();
    L30:
        return r5 + (r6 * this.f);
    L13:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.texteffects.core.m.d.class) == false) goto L16;
        r5 = -d();
        r6 = ((com.obric.oui.texteffects.core.m.d) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.core.m.d.class, "com.obric.memorydata.plugin")).a();
        goto L30
    L16:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.texteffects.core.m.g.class) == false) goto L20;
        float r3 = this.g;
        float r7 = ((com.obric.oui.texteffects.core.m.g) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.core.m.g.class, "com.obric.memorydata.plugin")).a();
    L31:
        return r3 * r7;
    L20:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.texteffects.core.m.f.class) == false) goto L23;
        r3 = this.c.getMeasuredWidth();
        r7 = ((com.obric.oui.texteffects.core.m.f) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.core.m.f.class, "com.obric.memorydata.plugin")).a();
        goto L31
    L23:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.texteffects.core.m.c.class) == false) goto L27;
        float r0 = a(((com.obric.oui.texteffects.core.m.c) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.core.m.c.class, "com.obric.memorydata.plugin")).a(), r5);
        return ((a(((com.obric.oui.texteffects.core.m.c) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.core.m.c.class, "com.obric.memorydata.plugin")).b(), r5) - r0) * RangesKt.coerceIn(((com.obric.oui.texteffects.core.m.c) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.core.m.c.class, "com.obric.memorydata.plugin")).c(), 0.0f, 1.0f)) + r0;
    L27:
        throw new NoWhenBranchMatchedException();
    }

    private final float d() {
        Integer r0 = Integer.valueOf(this.c.getMeasuredWidth());
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue();
        Integer r3 = Integer.valueOf(b().getWidth());
        boolean r5 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == true) goto L10;
        r3 = null;
    L10:
        if (r3 != null) goto L12;
        int r6 = 0;
    L13:
        if (r1 > r6) goto L16;
        r5 = false;
    L16:
        if (r5 == true) goto L19;
        r0 = null;
    L19:
        if (r0 != null) goto L21;
        int r2 = this.c.getWidth();
    L22:
        if (r2 <= 0) goto L25;
        return r2;
    L25:
        return ZeusTransformUtils.getResources(this.c, "com.obric.memorydata.plugin").getDisplayMetrics().density * this.e;
    L21:
        r2 = r0.intValue();
        goto L22
    L12:
        r6 = r3.intValue();
        goto L13
    L5:
        r4 = false;
        goto L7
    }

    public final String a() {
        return this.f14690b;
    }

    public final void a(g r5, float r6) {
        g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, TypedValues.AttributesType.S_FRAME);
        com.obric.oui.texteffects.core.m r0 = r7.h();
        if (r0 == null) goto L6;
        b().setTranslationX(a(r0, r6));
    L6:
        com.obric.oui.texteffects.core.m r1 = r7.i();
        if (r1 == null) goto L11;
        b().setTranslationY(a(r1, r6));
    L11:
        if (Float.isNaN(r7.e()) == true) goto L13;
        this.c.setAlpha(RangesKt.coerceIn(r7.e(), 0.0f, 1.0f));
    L13:
        View r8 = this.c;
        Float r9 = r7.j();
        int r2 = 0;
        if (r9 != null) goto L17;
    L20:
        r8.setVisibility(r2);
        com.obric.oui.texteffects.a r10 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == true) goto L23;
        return;
    L23:
        if (com.obric.oui.texteffects.a.b() == false) goto L27;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", "ExternalBinding"), "apply binding=" + a() + ", alpha=" + b().getAlpha() + ", visibility=" + b().getVisibility() + ", translationX=" + b().getTranslationX() + ", translationY=" + b().getTranslationY());
        return;
    L27:
        return;
    L17:
        if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).floatValue() > 0.001f) goto L20;
        r2 = this.d;
        goto L20
    }

    public final View b() {
        return this.c;
    }

    public final void c() {
        this.c.setVisibility(this.d);
        View r2 = this.c;
        r2.setTranslationX(-r2.getMeasuredWidth());
    }
}
