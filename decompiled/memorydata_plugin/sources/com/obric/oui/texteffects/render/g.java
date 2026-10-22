package com.obric.oui.texteffects.render;

import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011JR\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001eJ\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J@\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/oui/texteffects/render/ShapeMappedGradientCache;", "", "stopCount", "", "colorMapper", "Lcom/obric/oui/texteffects/render/ShapeMappedGradientHelper$ColorMapper;", "(ILcom/obric/oui/texteffects/render/ShapeMappedGradientHelper$ColorMapper;)V", "cachedShader", "Landroid/graphics/LinearGradient;", "cachedShaderSignature", "cachedStops", "Lcom/obric/oui/texteffects/render/ShapeMappedGradientHelper$ShapeGradientParams;", "cachedStopsKey", "Lcom/obric/oui/texteffects/render/GradientStopsKey;", "reusableShaderMatrix", "Landroid/graphics/Matrix;", "clear", "", "resolve", "rect", "Landroid/graphics/RectF;", TypedValues.CycleType.S_WAVE_OFFSET, "Lcom/obric/oui/texteffects/core/CharacterOffsetSpec;", "shape", "Lcom/obric/oui/texteffects/core/CharacterShapeSpec;", "stagePlayTimeMs", "", "delayMs", "durationMs", "textWidthPx", "", "translationCompensationXPx", "translationCompensationYPx", "resolveStops", "updateShaderMatrix", "shader", "Landroid/graphics/Shader;", "offsetPx", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h.a f14662b;
    private f c;
    private h.b d;
    private int e;
    private LinearGradient f;
    private final Matrix g;

    public g(int r3, h.a r4) {
        h.a r5 = (h.a) ZeusTransformUtils.wrapperContextForParams(r4, h.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "colorMapper");
        this.f14661a = r3;
        this.f14662b = r5;
        this.e = Integer.MIN_VALUE;
        this.g = new Matrix();
    }

    public static /* synthetic */ LinearGradient a(g r16, RectF r17, com.obric.oui.texteffects.core.g r18, com.obric.oui.texteffects.core.h r19, long r20, long r22, long r24, float r26, float r27, float r28, int r29, Object r30) {
        if ((r29 & 128) == 0) goto L5;
        float r14 = 0.0f;
    L7:
        if ((r29 & 256) == 0) goto L9;
        float r15 = 0.0f;
    L11:
        return r16.a(r17, r18, r19, r20, r22, r24, r26, r14, r15);
    L9:
        r15 = r28;
        goto L11
    L5:
        r14 = r27;
        goto L7
    }

    private final h.b a(com.obric.oui.texteffects.core.h r8) {
        f r0 = new f(r8);
        f r1 = this.c;
        if (r1 != null) goto L6;
    L10:
        h.b r2 = h.a(r8.c(), this.f14661a, this.f14662b);
        this.c = r0;
        this.d = r2;
        this.e = Integer.MIN_VALUE;
        this.f = null;
        com.obric.oui.texteffects.a r7 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == true) goto L13;
    L15:
        Intrinsics.checkNotNullExpressionValue(r2, "buildParams(\n           …\"\n            }\n        }");
        return r2;
    L13:
        if (com.obric.oui.texteffects.a.b() == false) goto L15;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", "ShapeMappedCache"), Intrinsics.stringPlus("\t\t\tstops create shape=", r8));
        goto L15
    L6:
        if (Intrinsics.areEqual(r1, r0) == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L10;
        com.obric.oui.texteffects.a r3 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == true) goto L20;
    L22:
        h.b r9 = this.d;
        Intrinsics.checkNotNull(r9);
        return r9;
    L20:
        if (com.obric.oui.texteffects.a.b() == false) goto L22;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", "ShapeMappedCache"), Intrinsics.stringPlus("\t\t\tstops hit shape=", r8));
        goto L22
    }

    private final void a(Shader r2, RectF r3, com.obric.oui.texteffects.core.h r4, float r5, float r6, float r7, float r8) {
        float r9 = RangesKt.coerceAtLeast(h.a(r4, r5), 0.001f);
        this.g.reset();
        this.g.setScale(r9, 1.0f);
        this.g.postTranslate((r3.left + r6) + r7, r3.top + r8);
        com.obric.oui.texteffects.a r10 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == true) goto L5;
    L7:
        r2.setLocalMatrix(this.g);
        return;
    L5:
        if (com.obric.oui.texteffects.a.b() == false) goto L7;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", "ShapeMappedCache"), "\t\t\tupdateShaderMatrix rect=" + r3 + " offsetPx=" + r6 + " compensationX=" + r7 + " compensationY=" + r8);
        goto L7
    }

    public final LinearGradient a(RectF r29, com.obric.oui.texteffects.core.g r30, com.obric.oui.texteffects.core.h r31, long r32, long r34, long r36, float r38, float r39, float r40) {
        Intrinsics.checkNotNullParameter(r29, "rect");
        Intrinsics.checkNotNullParameter(r30, TypedValues.CycleType.S_WAVE_OFFSET);
        Intrinsics.checkNotNullParameter(r31, "shape");
        h.b r4 = a(r31);
        LinearGradient r1 = this.f;
        if (r1 != null) goto L6;
    L13:
        LinearGradient r3 = h.a(r4);
        this.e = r4.c;
        this.f = r3;
        Intrinsics.checkNotNullExpressionValue(r3, "shader");
        a((Shader) ZeusTransformUtils.preCheckCast(r3, Shader.class, "com.obric.memorydata.plugin"), r29, r31, r38, h.a(r30, r32, r34, r36, r38), r39, r40);
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == true) goto L16;
    L18:
        Intrinsics.checkNotNullExpressionValue(r3, "createNormalizedLinearGr…\"\n            }\n        }");
        return r3;
    L16:
        if (com.obric.oui.texteffects.a.b() == false) goto L18;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", "ShapeMappedCache"), "shader create signature=" + r4.c + " rectLeft=" + r29.left + " rectRight=" + r29.right + " textWidth=" + r38 + " compensationX=" + r39 + " compensationY=" + r40);
        goto L18
    L6:
        if (this.e != r4.c) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        LinearGradient r5 = r1;
    L12:
        if (r5 == null) goto L13;
        LinearGradient r16 = r5;
        a((Shader) ZeusTransformUtils.preCheckCast(r5, Shader.class, "com.obric.memorydata.plugin"), r29, r31, r38, h.a(r30, r32, r34, r36, r38), r39, r40);
        com.obric.oui.texteffects.a r6 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == true) goto L23;
    L25:
        return r16;
    L23:
        if (com.obric.oui.texteffects.a.b() == false) goto L25;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", "ShapeMappedCache"), "shader hit cache signature=" + r4.c + " rectLeft=" + r29.left + " rectRight=" + r29.right + " textWidth=" + r38 + " compensationX=" + r39 + " compensationY=" + r40);
        goto L25
    L11:
        r5 = null;
        goto L12
    L8:
        r2 = false;
        goto L9
    }
}
