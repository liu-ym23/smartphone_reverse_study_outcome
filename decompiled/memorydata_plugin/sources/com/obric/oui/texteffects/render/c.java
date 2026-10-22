package com.obric.oui.texteffects.render;

import android.graphics.BlendMode;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0094\u0001\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"J\u0094\u0001\u0010#\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"J\u009c\u0001\u0010$\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"J\u0006\u0010\u0003\u001a\u00020 J:\u0010)\u001a\u00020*2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020\"H\u0002J\u0014\u0010+\u001a\u00020\"*\u00020\u00192\u0006\u0010,\u001a\u00020*H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/oui/texteffects/render/CanvasTextLayerRenderer;", "", "()V", "multiplyXfermode", "Landroid/graphics/PorterDuffXfermode;", "reusableLayerPaint", "Landroid/graphics/Paint;", "buildLayerPaintForCurrentBlend", "sourcePaint", "drawCharacterEffectText", "", "canvas", "Landroid/graphics/Canvas;", "layerLeft", "", "layerRight", "layerPaint", "paint", "cache", "Lcom/obric/oui/texteffects/render/TextLayoutCache;", "drawX", "baselineY", "layerHeight", "blurPx", "characterFrameBuffer", "Lcom/obric/oui/texteffects/runtime/TextEffectTimelineSampler$CharacterFrameBuffer;", "blurMaskFilterProvider", "Lkotlin/Function1;", "Landroid/graphics/BlurMaskFilter;", "originalBlendMode", "Landroid/graphics/BlendMode;", "originalXfermode", "Landroid/graphics/Xfermode;", "useOwnLayer", "", "drawCharacterEffectTextDirectly", "drawCharacterEffectTextWithLiveLayout", "liveLayout", "Landroid/text/Layout;", "drawOriginX", "drawOriginY", "saveContentLayer", "", "hasEnoughSamplesFor", "characterCount", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f14655a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PorterDuffXfermode f14656b = null;
    private static final Paint c = null;

    static {
        f14655a = new c();
        f14656b = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
        c = new Paint();
    }

    private c() {
    }

    private final int a(Canvas r7, float r8, float r9, float r10, Paint r11, boolean r12) {
        if (r12 == false) goto L5;
        return r7.saveLayer(r8, 0.0f, r9, r10, r11);
    L5:
        return r7.save();
    }

    private final boolean a(com.obric.oui.texteffects.runtime.m.a r1, int r2) {
        if (r1.a() < r2) goto L5;
        return true;
    L5:
        return false;
    }

    public final Paint a(Paint r4) {
        Intrinsics.checkNotNullParameter(r4, "sourcePaint");
        Paint r3 = c;
        r3.reset();
        boolean r1 = true;
        if (Build.VERSION.SDK_INT < 29) goto L8;
        if (r4.getBlendMode() == null) goto L8;
        r3.setBlendMode(r4.getBlendMode());
    L11:
        if (r1 == true) goto L15;
        return null;
    L15:
        return r3;
    L8:
        if (r4.getXfermode() == null) goto L10;
        r3.setXfermode(r4.getXfermode());
        goto L11
    L10:
        r1 = false;
        goto L11
    }

    public final void a(Canvas r17, float r18, float r19, Paint r20, Paint r21, m r22, float r23, float r24, float r25, float r26, com.obric.oui.texteffects.runtime.m.a r27, Function1<? super Float, ? extends BlurMaskFilter> r28, BlendMode r29, Xfermode r30, boolean r31) {
        Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r28, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "canvas");
        Intrinsics.checkNotNullParameter(r21, "paint");
        Intrinsics.checkNotNullParameter(r22, "cache");
        Intrinsics.checkNotNullParameter(r27, "characterFrameBuffer");
        Intrinsics.checkNotNullParameter(r14, "blurMaskFilterProvider");
        StaticLayout r15 = o.b(r22);
        if (r15 != null) goto L5;
        return;
    L5:
        int r1 = a(r17, r18, r19, r25, r20, r31);
    L21:
        th = move-exception;
        r17.restoreToCount(r1);
        if (Build.VERSION.SDK_INT < 29) goto L25;
        r21.setBlendMode(r29);
    L25:
        r21.setXfermode(r30);
        throw th;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        r21.setBlendMode(null);     // Catch: Throwable -> L21
    L9:
        r21.setXfermode(null);     // Catch: Throwable -> L21
        r21.setMaskFilter((MaskFilter) ZeusTransformUtils.preCheckCast(r14.invoke(Float.valueOf(r26)), MaskFilter.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
        r22.n().set(r21);     // Catch: Throwable -> L21
        r22.a(r27);     // Catch: Throwable -> L21
        float r0 = r24 - r15.getLineBaseline(0);     // Catch: Throwable -> L21
        int r3 = r17.save();     // Catch: Throwable -> L21
        r17.translate(r23, r0);     // Catch: Throwable -> L18
        r15.draw(r17);     // Catch: Throwable -> L18
        r17.restoreToCount(r3);     // Catch: Throwable -> L21
        r22.a(null);     // Catch: Throwable -> L21
        r17.restoreToCount(r1);
        if (Build.VERSION.SDK_INT < 29) goto L16;
        r21.setBlendMode(r29);
    L16:
        r21.setXfermode(r30);
        return;
    L18:
        th = move-exception;
        r17.restoreToCount(r3);     // Catch: Throwable -> L21
        r22.a(null);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    }

    public final void a(Canvas r17, float r18, float r19, Paint r20, Paint r21, m r22, Layout r23, float r24, float r25, float r26, float r27, com.obric.oui.texteffects.runtime.m.a r28, Function1<? super Float, ? extends BlurMaskFilter> r29, BlendMode r30, Xfermode r31, boolean r32) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r29, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "canvas");
        Intrinsics.checkNotNullParameter(r21, "paint");
        Intrinsics.checkNotNullParameter(r22, "cache");
        Intrinsics.checkNotNullParameter(r23, "liveLayout");
        Intrinsics.checkNotNullParameter(r28, "characterFrameBuffer");
        Intrinsics.checkNotNullParameter(r15, "blurMaskFilterProvider");
        SpannableString r1 = o.a(r22);
        if (r1 != null) goto L6;
        return;
    L6:
        if (StringsKt.contentEquals(r23.getText(), (CharSequence) ZeusTransformUtils.preCheckCast(r1.toString(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L8;
        return;
    L8:
        int r2 = a(r17, r18, r19, r26, r20, r32);
    L24:
        th = move-exception;
        r17.restoreToCount(r2);
        if (Build.VERSION.SDK_INT < 29) goto L28;
        r21.setBlendMode(r30);
    L28:
        r21.setXfermode(r31);
        throw th;
    L10:
        if (Build.VERSION.SDK_INT < 29) goto L12;
        r21.setBlendMode(null);     // Catch: Throwable -> L24
    L12:
        r21.setXfermode(null);     // Catch: Throwable -> L24
        r21.setMaskFilter((MaskFilter) ZeusTransformUtils.preCheckCast(r15.invoke(Float.valueOf(r27)), MaskFilter.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L24
        r22.n().set(r21);     // Catch: Throwable -> L24
        r22.a(r28);     // Catch: Throwable -> L24
        int r3 = r17.save();     // Catch: Throwable -> L24
        r17.translate(r24, r25);     // Catch: Throwable -> L21
        r23.draw(r17);     // Catch: Throwable -> L21
        r17.restoreToCount(r3);     // Catch: Throwable -> L24
        r22.a(null);     // Catch: Throwable -> L24
        r17.restoreToCount(r2);
        if (Build.VERSION.SDK_INT < 29) goto L19;
        r21.setBlendMode(r30);
    L19:
        r21.setXfermode(r31);
        return;
    L21:
        th = move-exception;
        r17.restoreToCount(r3);     // Catch: Throwable -> L24
        r22.a(null);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    }

    public final boolean b(Canvas r19, float r20, float r21, Paint r22, Paint r23, m r24, float r25, float r26, float r27, float r28, com.obric.oui.texteffects.runtime.m.a r29, Function1<? super Float, ? extends BlurMaskFilter> r30, BlendMode r31, Xfermode r32, boolean r33) {
        Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r30, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r19, "canvas");
        Intrinsics.checkNotNullParameter(r23, "paint");
        Intrinsics.checkNotNullParameter(r24, "cache");
        Intrinsics.checkNotNullParameter(r29, "characterFrameBuffer");
        Intrinsics.checkNotNullParameter(r13, "blurMaskFilterProvider");
        int r15 = 0;
        if (r24.f() == true) goto L6;
        return false;
    L6:
        if (a(r29, r24.c().length) == true) goto L8;
        return false;
    L8:
        int r7 = a(r19, r20, r21, r27, r22, r33);
        int r6 = 29;
    L39:
        th = th;
        int r1 = r6;
        int r12 = r7;
    L41:
        r19.restoreToCount(r12);
        if (Build.VERSION.SDK_INT < r1) goto L44;
        r23.setBlendMode(r31);
    L44:
        r23.setXfermode(r32);
        throw th;
    L10:
        if (Build.VERSION.SDK_INT < 29) goto L12;
        r23.setBlendMode(null);     // Catch: Throwable -> L39
    L12:
        r23.setXfermode(null);     // Catch: Throwable -> L39
        r23.setMaskFilter((MaskFilter) ZeusTransformUtils.preCheckCast(r13.invoke(Float.valueOf(r28)), MaskFilter.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L39
        int r14 = r24.c().length;     // Catch: Throwable -> L39
        int r3 = 0;
    L14:
        if (r3 >= r14) goto L34;
        int r16 = r3 + 1;
        float r2 = r29.d()[r3];     // Catch: Throwable -> L32
        if (r2 > 0.001f) goto L19;
        int r17 = r14;
        r12 = r7;
    L29:
        r7 = r12;
        r3 = r16;
        r14 = r17;
        r6 = 29;
        r15 = 0;
        goto L14
    L19:
        int r5 = r23.getAlpha();     // Catch: Throwable -> L32
        if (r2 < 0.999f) goto L23;
    L24:
        r17 = r14;
        r12 = r7;
        r19.drawText(r24.c(), r3, 1, (r25 + r24.e()[r3]) + r29.e()[r3], r26 + r29.f()[r3], r23);     // Catch: Throwable -> L30
        if (r23.getAlpha() == r5) goto L29;
        r23.setAlpha(r5);     // Catch: Throwable -> L30
    L30:
        th = th;
        r1 = 29;
        goto L41
    L23:
        r23.setAlpha(RangesKt.coerceIn(MathKt.roundToInt(r5 * r2), r15, 255));     // Catch: Throwable -> L39
    L32:
        th = th;
        r12 = r7;
        r1 = r6;
        goto L41
    L34:
        r19.restoreToCount(r7);
        if (Build.VERSION.SDK_INT < 29) goto L37;
        r23.setBlendMode(r31);
    L37:
        r23.setXfermode(r32);
        return true;
    }
}
