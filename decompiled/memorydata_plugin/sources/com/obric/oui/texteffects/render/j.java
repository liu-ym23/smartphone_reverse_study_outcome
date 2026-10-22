package com.obric.oui.texteffects.render;

import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.texteffects.core.BlendSpec;
import com.obric.oui.texteffects.core.TextSource;
import com.obric.oui.texteffects.core.s;
import com.obric.oui.texteffects.core.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002deB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020*H\u0002J*\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\r\u00103\u001a\u000204H\u0000¢\u0006\u0002\b5J\u001e\u00106\u001a\u00020'2\u0006\u0010,\u001a\u00020-2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:J(\u0010;\u001a\u00020'2\u0006\u0010,\u001a\u00020-2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u00109\u001a\u00020:H\u0002J \u0010@\u001a\u00020'2\u0006\u0010,\u001a\u00020-2\u0006\u0010A\u001a\u00020B2\u0006\u00109\u001a\u00020CH\u0002J(\u0010D\u001a\u00020'2\u0006\u0010,\u001a\u00020-2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u00109\u001a\u00020:H\u0002J\u000e\u0010E\u001a\u00020'2\u0006\u00107\u001a\u000208J\u0018\u0010F\u001a\u00020'2\u0006\u0010A\u001a\u00020B2\u0006\u0010G\u001a\u00020HH\u0002J\r\u0010I\u001a\u00020'H\u0000¢\u0006\u0002\bJJ\b\u0010K\u001a\u00020'H\u0002J*\u0010L\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?2\u0006\u0010M\u001a\u00020\t2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010N\u001a\u00020\u0015H\u0002J*\u0010O\u001a\u00020\u00132\u0006\u0010A\u001a\u00020B2\u0006\u0010M\u001a\u00020\t2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010N\u001a\u00020\u0015H\u0002J\u0018\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020R2\u0006\u0010N\u001a\u00020\u0015H\u0002J\"\u0010S\u001a\u00020\u00132\u0006\u0010<\u001a\u00020=2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010N\u001a\u00020\u0015H\u0002J \u0010T\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020V2\u0006\u00109\u001a\u00020C2\u0006\u0010Q\u001a\u00020RH\u0002J\f\u0010W\u001a\u00020'*\u00020 H\u0002J\u0016\u0010X\u001a\u00020/*\u00020C2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0002J\u001e\u0010[\u001a\u0004\u0018\u00010\\*\u00020:2\u0006\u0010M\u001a\u00020\t2\u0006\u0010]\u001a\u00020\tH\u0002J\u001b\u0010^\u001a\u0004\u0018\u00010H*\u00020:2\u0006\u0010M\u001a\u00020\tH\u0002¢\u0006\u0002\u0010_J\f\u0010`\u001a\u00020a*\u00020*H\u0002J\u000e\u0010b\u001a\u0004\u0018\u00010c*\u00020*H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/obric/oui/texteffects/render/TextEffectRenderEngine;", "", "host", "Lcom/obric/oui/texteffects/host/TextViewEffectHost;", "textRepository", "Lcom/obric/oui/texteffects/render/TextEffectTextRepository;", "shaderRepository", "Lcom/obric/oui/texteffects/render/TextEffectShaderRepository;", "logTag", "", "(Lcom/obric/oui/texteffects/host/TextViewEffectHost;Lcom/obric/oui/texteffects/render/TextEffectTextRepository;Lcom/obric/oui/texteffects/render/TextEffectShaderRepository;Ljava/lang/String;)V", "characterDirectDrawCount", "", "characterFrameBuffer", "Lcom/obric/oui/texteffects/runtime/TextEffectTimelineSampler$CharacterFrameBuffer;", "characterSampleReuseCount", "characterSampledCount", "characterSpanDrawCount", "collectCharacterSampleStatsForTest", "", "groupBounds", "Landroid/graphics/RectF;", "lastCharacterSampleBuffer", "lastCharacterSampleKey", "Lcom/obric/oui/texteffects/render/TextEffectRenderEngine$CharacterSampleKey;", "layerBounds", "layerRect", "porterDuffXfermodes", "", "Landroid/graphics/PorterDuffXfermode;", "[Landroid/graphics/PorterDuffXfermode;", "postMaskPaint", "Landroid/graphics/Paint;", "renderPaint", "Landroid/text/TextPaint;", "spareCharacterFrameBuffer", "stageBounds", "tempBounds", "applyBlend", "", "paint", "blend", "Lcom/obric/oui/texteffects/core/BlendSpec;", "applyPostMask", "canvas", "Landroid/graphics/Canvas;", "left", "", "right", "shader", "Landroid/graphics/Shader;", "characterSampleStatsForTest", "Lcom/obric/oui/texteffects/render/TextEffectRenderEngine$CharacterSampleStats;", "characterSampleStatsForTest$OUITextEffects_standardRelease", "draw", "spec", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", TypedValues.AttributesType.S_FRAME, "Lcom/obric/oui/texteffects/runtime/ReusableTextEffectFrame;", "drawGroup", "stage", "Lcom/obric/oui/texteffects/core/EffectStage;", "group", "Lcom/obric/oui/texteffects/core/EffectLayerGroupSpec;", "drawTextLayer", "layer", "Lcom/obric/oui/texteffects/core/EffectLayer$Text;", "Lcom/obric/oui/texteffects/runtime/SampledLayerFrame;", "drawTextLayers", "prewarm", "prewarmTextLayer", "stagePlayTimeMs", "", "resetCharacterSampleStatsForTest", "resetCharacterSampleStatsForTest$OUITextEffects_standardRelease", "resetFrameCaches", "resolveGroupTextBounds", "stageId", "out", "resolveLayerTextBounds", "resolveLiveLayoutHorizontalBounds", "cache", "Lcom/obric/oui/texteffects/render/TextLayoutCache;", "resolveStageTextBounds", "sampleCharacterFrame", "characterEffect", "Lcom/obric/oui/texteffects/core/CharacterEffectSpec;", "clearBlend", "dimensionPx", EventBody.KEY_VALUE, "Lcom/obric/oui/texteffects/core/EffectValue;", "findLayer", "Lcom/obric/oui/texteffects/runtime/ReusableLayerFrame;", "layerId", "findStagePlayTime", "(Lcom/obric/oui/texteffects/runtime/ReusableTextEffectFrame;Ljava/lang/String;)Ljava/lang/Long;", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "CharacterSampleKey", "CharacterSampleStats", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.oui.texteffects.a.b f14669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f14670b;
    private final k c;
    private final String d;
    private final TextPaint e;
    private final Paint f;
    private final RectF g;
    private final RectF h;
    private final RectF i;
    private final RectF j;
    private final RectF k;
    private final PorterDuffXfermode[] l;
    private final com.obric.oui.texteffects.runtime.m.a m;
    private final com.obric.oui.texteffects.runtime.m.a n;
    private a o;
    private com.obric.oui.texteffects.runtime.m.a p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ6\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/texteffects/render/TextEffectRenderEngine$CharacterSampleKey;", "", "effect", "Lcom/obric/oui/texteffects/core/CharacterEffectSpec;", "stagePlayTimeMs", "", "cache", "Lcom/obric/oui/texteffects/render/TextLayoutCache;", "characterCount", "", "textTotalWidthPx", "", "textSizePx", "(Lcom/obric/oui/texteffects/core/CharacterEffectSpec;JLcom/obric/oui/texteffects/render/TextLayoutCache;IFF)V", "matches", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.oui.texteffects.core.d f14671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f14672b;
        private final m c;
        private final int d;
        private final float e;
        private final float f;

        public a(com.obric.oui.texteffects.core.d r2, long r3, m r5, int r6, float r7, float r8) {
            Intrinsics.checkNotNullParameter(r2, "effect");
            Intrinsics.checkNotNullParameter(r5, "cache");
            this.f14671a = r2;
            this.f14672b = r3;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
        }

        public final boolean a(com.obric.oui.texteffects.core.d r5, long r6, m r8, int r9, float r10, float r11) {
            Intrinsics.checkNotNullParameter(r5, "effect");
            Intrinsics.checkNotNullParameter(r8, "cache");
            if (Intrinsics.areEqual(this.f14671a, r5) == false) goto L22;
            if (this.f14672b != r6) goto L22;
            if (this.c != r8) goto L22;
            if (this.d != r9) goto L22;
            if (this.e != r10) goto L13;
            boolean r7 = true;
        L14:
            if (r7 == false) goto L22;
            if (this.f != r11) goto L18;
            boolean r4 = true;
        L19:
            if (r4 == false) goto L22;
            return true;
        L18:
            r4 = false;
            goto L19
        L13:
            r7 = false;
        L22:
            return false;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14673a = null;

        static {
            int[] r0 = new int[BlendSpec.values().length];
            r0[BlendSpec.CLEAR.ordinal()] = 1;
            r0[BlendSpec.SRC.ordinal()] = 2;
            r0[BlendSpec.DST.ordinal()] = 3;
            r0[BlendSpec.SRC_OVER.ordinal()] = 4;
            r0[BlendSpec.DST_OVER.ordinal()] = 5;
            r0[BlendSpec.SRC_IN.ordinal()] = 6;
            r0[BlendSpec.DST_IN.ordinal()] = 7;
            r0[BlendSpec.SRC_OUT.ordinal()] = 8;
            r0[BlendSpec.DST_OUT.ordinal()] = 9;
            r0[BlendSpec.SRC_ATOP.ordinal()] = 10;
            r0[BlendSpec.DST_ATOP.ordinal()] = 11;
            r0[BlendSpec.XOR.ordinal()] = 12;
            r0[BlendSpec.PLUS.ordinal()] = 13;
            r0[BlendSpec.MODULATE.ordinal()] = 14;
            r0[BlendSpec.SCREEN.ordinal()] = 15;
            r0[BlendSpec.OVERLAY.ordinal()] = 16;
            r0[BlendSpec.DARKEN.ordinal()] = 17;
            r0[BlendSpec.LIGHTEN.ordinal()] = 18;
            r0[BlendSpec.COLOR_DODGE.ordinal()] = 19;
            r0[BlendSpec.COLOR_BURN.ordinal()] = 20;
            r0[BlendSpec.HARD_LIGHT.ordinal()] = 21;
            r0[BlendSpec.SOFT_LIGHT.ordinal()] = 22;
            r0[BlendSpec.DIFFERENCE.ordinal()] = 23;
            r0[BlendSpec.EXCLUSION.ordinal()] = 24;
            r0[BlendSpec.MULTIPLY.ordinal()] = 25;
            r0[BlendSpec.HUE.ordinal()] = 26;
            r0[BlendSpec.SATURATION.ordinal()] = 27;
            r0[BlendSpec.COLOR.ordinal()] = 28;
            r0[BlendSpec.LUMINOSITY.ordinal()] = 29;
            f14673a = r0;
        }
    }

    public j(com.obric.oui.texteffects.a.b r3, l r4, k r5, String r6) {
        com.obric.oui.texteffects.a.b r7 = (com.obric.oui.texteffects.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.texteffects.a.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "host");
        Intrinsics.checkNotNullParameter(r4, "textRepository");
        Intrinsics.checkNotNullParameter(r5, "shaderRepository");
        Intrinsics.checkNotNullParameter(r6, "logTag");
        this.f14669a = r7;
        this.f14670b = r4;
        this.c = r5;
        this.d = r6;
        this.e = new TextPaint();
        Paint r8 = new Paint();
        r8.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(new PorterDuffXfermode(PorterDuff.Mode.DST_IN), Xfermode.class, "com.obric.memorydata.plugin"));
        this.f = r8;
        this.g = new RectF();
        this.h = new RectF();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.l = new PorterDuffXfermode[BlendSpec.values().length];
        this.m = new com.obric.oui.texteffects.runtime.m.a(0, 1, null);
        this.n = new com.obric.oui.texteffects.runtime.m.a(0, 1, null);
    }

    private final float a(com.obric.oui.texteffects.runtime.g r3, com.obric.oui.texteffects.core.m r4) {
        com.obric.oui.texteffects.runtime.g r5 = (com.obric.oui.texteffects.runtime.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.texteffects.runtime.g.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.texteffects.core.m.a.class) == false) goto L6;
        return ((com.obric.oui.texteffects.core.m.a) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.core.m.a.class, "com.obric.memorydata.plugin")).a() * this.f14669a.i();
    L6:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.texteffects.core.m.b.class) == true) goto L11;
        return 0.0f;
    L11:
        return ((com.obric.oui.texteffects.core.m.b) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.core.m.b.class, "com.obric.memorydata.plugin")).a();
    }

    private final BlendMode a(BlendSpec r1) {
        switch(b.f14673a[r1.ordinal()]) {
            case 1: goto L35;
            case 2: goto L63;
            case 3: goto L62;
            case 4: goto L61;
            case 5: goto L60;
            case 6: goto L59;
            case 7: goto L58;
            case 8: goto L57;
            case 9: goto L56;
            case 10: goto L55;
            case 11: goto L54;
            case 12: goto L53;
            case 13: goto L52;
            case 14: goto L51;
            case 15: goto L50;
            case 16: goto L49;
            case 17: goto L48;
            case 18: goto L47;
            case 19: goto L46;
            case 20: goto L45;
            case 21: goto L44;
            case 22: goto L43;
            case 23: goto L42;
            case 24: goto L41;
            case 25: goto L40;
            case 26: goto L39;
            case 27: goto L38;
            case 28: goto L37;
            case 29: goto L36;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L36:
        return BlendMode.LUMINOSITY;
    L37:
        return BlendMode.COLOR;
    L38:
        return BlendMode.SATURATION;
    L39:
        return BlendMode.HUE;
    L40:
        return BlendMode.MULTIPLY;
    L41:
        return BlendMode.EXCLUSION;
    L42:
        return BlendMode.DIFFERENCE;
    L43:
        return BlendMode.SOFT_LIGHT;
    L44:
        return BlendMode.HARD_LIGHT;
    L45:
        return BlendMode.COLOR_BURN;
    L46:
        return BlendMode.COLOR_DODGE;
    L47:
        return BlendMode.LIGHTEN;
    L48:
        return BlendMode.DARKEN;
    L49:
        return BlendMode.OVERLAY;
    L50:
        return BlendMode.SCREEN;
    L51:
        return BlendMode.MODULATE;
    L52:
        return BlendMode.PLUS;
    L53:
        return BlendMode.XOR;
    L54:
        return BlendMode.DST_ATOP;
    L55:
        return BlendMode.SRC_ATOP;
    L56:
        return BlendMode.DST_OUT;
    L57:
        return BlendMode.SRC_OUT;
    L58:
        return BlendMode.DST_IN;
    L59:
        return BlendMode.SRC_IN;
    L60:
        return BlendMode.DST_OVER;
    L61:
        return BlendMode.SRC_OVER;
    L62:
        return BlendMode.DST;
    L63:
        return BlendMode.SRC;
    L35:
        return BlendMode.CLEAR;
    }

    private final com.obric.oui.texteffects.runtime.e a(com.obric.oui.texteffects.runtime.f r5, String r6, String r7) {
        int r4 = r5.b();
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L10;
        int r1 = r0 + 1;
        com.obric.oui.texteffects.runtime.e r2 = r5.a().get(r0);
        Intrinsics.checkNotNullExpressionValue(r2, "layers[index]");
        com.obric.oui.texteffects.runtime.e r3 = (com.obric.oui.texteffects.runtime.e) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.texteffects.runtime.e.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r3.a(), r6) == false) goto L9;
        if (Intrinsics.areEqual(r3.b(), r7) == false) goto L9;
        return r3;
    L9:
        r0 = r1;
        goto L3
    L10:
        return null;
    }

    private final com.obric.oui.texteffects.runtime.m.a a(com.obric.oui.texteffects.core.d r12, com.obric.oui.texteffects.runtime.g r13, m r14) {
        com.obric.oui.texteffects.runtime.g r15 = (com.obric.oui.texteffects.runtime.g) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.oui.texteffects.runtime.g.class, "com.obric.memorydata.plugin");
        a r0 = this.o;
        if (r0 == null) goto L15;
        if (r0.a(r12, r15.d(), r14, r14.c().length, r14.k(), r14.i()) == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L15;
        com.obric.oui.texteffects.runtime.m.a r1 = this.p;
        if (r1 != null) goto L24;
        Void r2 = (Void) ZeusTransformUtils.preCheckCast(null, Void.class, "com.obric.memorydata.plugin");
        goto L15
    L24:
        if (this.q == false) goto L26;
        this.s++;
    L26:
        com.obric.oui.texteffects.a r16 = com.obric.oui.texteffects.a.f14578a;
        String r11 = this.d;
        if (com.obric.oui.texteffects.a.a() == true) goto L29;
    L31:
        return r1;
    L29:
        if (com.obric.oui.texteffects.a.b() == false) goto L31;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", r11), "reuse character sample layer=" + r15.b() + ", count=" + r1.a() + ", time=" + r15.d());
    L15:
        if (Intrinsics.areEqual(this.p, this.m) == false) goto L17;
        com.obric.oui.texteffects.runtime.m.a r3 = this.n;
    L18:
        com.obric.oui.texteffects.runtime.m.f14709a.a(r12, r15.d(), r14.c().length, this.f14669a.i(), r14.k(), r14.d(), r14.i(), r3);
        if (this.q == false) goto L21;
        this.r++;
    L21:
        this.o = new a(r12, r15.d(), r14, r14.c().length, r14.k(), r14.i());
        this.p = r3;
        return r3;
    L17:
        r3 = this.m;
        goto L18
    }

    private final Long a(com.obric.oui.texteffects.runtime.f r5, String r6) {
        int r4 = r5.b();
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L9;
        int r1 = r0 + 1;
        com.obric.oui.texteffects.runtime.e r2 = r5.a().get(r0);
        Intrinsics.checkNotNullExpressionValue(r2, "layers[index]");
        com.obric.oui.texteffects.runtime.e r3 = (com.obric.oui.texteffects.runtime.e) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.texteffects.runtime.e.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r3.a(), r6) == true) goto L7;
        r0 = r1;
        goto L3
    L7:
        return Long.valueOf(r3.d());
    L9:
        return null;
    }

    private final void a() {
        this.o = null;
        this.p = null;
    }

    private final void a(Canvas r8, float r9, float r10, Shader r11) {
        if (r11 != null) goto L5;
    L19:
        com.obric.oui.texteffects.a r12 = com.obric.oui.texteffects.a.f14578a;
        String r7 = this.d;
        if (com.obric.oui.texteffects.a.a() == true) goto L22;
        return;
    L22:
        if (com.obric.oui.texteffects.a.b() == false) goto L32;
        String r13 = Intrinsics.stringPlus("OTextEff/frame/", r7);
        StringBuilder r14 = new StringBuilder().append("skip postMask left=").append(r9).append(" right=").append(r10).append(" hasShader=");
        if (r11 == null) goto L26;
        boolean r15 = true;
    L27:
        Log.d(r13, r14.append(r15).toString());
        return;
    L26:
        r15 = false;
        goto L27
    L32:
        return;
    L5:
        if (r10 <= r9) goto L19;
        com.obric.oui.texteffects.a r2 = com.obric.oui.texteffects.a.f14578a;
        String r3 = this.d;
        if (com.obric.oui.texteffects.a.a() == true) goto L10;
    L12:
        this.f.setShader(r11);
        r8.drawRect(r9, 0.0f, r10, this.f14669a.f(), this.f);     // Catch: Throwable -> L16
        this.f.setShader(null);
        return;
    L16:
        th = move-exception;
        this.f.setShader(null);
        throw th;
    L10:
        if (com.obric.oui.texteffects.a.b() == false) goto L12;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", r3), "applyPostMask left=" + r9 + " right=" + r10);
        goto L12
    }

    /* JADX WARN: Not initialized variable reg: 35, insn: 0x0564: MOVE (r12 I:??[OBJECT, ARRAY]) = (r35 I:??[OBJECT, ARRAY]), block:B:120:0x055e */
    /* JADX WARN: Not initialized variable reg: 36, insn: 0x0559: MOVE (r2 I:??[OBJECT, ARRAY]) = (r36 I:??[OBJECT, ARRAY]), block:B:118:0x0553 */
    /* JADX WARN: Not initialized variable reg: 36, insn: 0x0566: MOVE (r2 I:??[OBJECT, ARRAY]) = (r36 I:??[OBJECT, ARRAY]), block:B:120:0x055e */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 17241. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private final void a(android.graphics.Canvas r40, com.obric.oui.texteffects.core.j.b r41, com.obric.oui.texteffects.runtime.g r42) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: INVOKE (r0v1 ?? I:java.lang.Object) = 
              (r42v0 ?? I:java.lang.Object)
              (wrap java.lang.Class:0x0006: CONST_CLASS  A[WRAPPED] com.obric.oui.texteffects.runtime.g.class)
              ("com.obric.memorydata.plugin")
             STATIC call: com.volcengine.zeus.transform.ZeusTransformUtils.wrapperContextForParams(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object A[DECLARE_VAR, MD:(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object (m)] in method: com.obric.oui.texteffects.render.j.a(android.graphics.Canvas, com.obric.oui.texteffects.core.j$b, com.obric.oui.texteffects.runtime.g):void, file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1724
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.oui.texteffects.render.j.a(android.graphics.Canvas, com.obric.oui.texteffects.core.j$b, com.obric.oui.texteffects.runtime.g):void");
    }

    private final void a(Canvas r18, com.obric.oui.texteffects.core.l r19, com.obric.oui.texteffects.core.k r20, com.obric.oui.texteffects.runtime.f r21) {
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r20.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        Long r4 = null;
        if (r2.hasNext() == false) goto L10;
        com.obric.oui.texteffects.runtime.e r3 = a(r21, r19.a(), ((com.obric.oui.texteffects.core.j) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.oui.texteffects.core.j.class, "com.obric.memorydata.plugin")).a());
        if (r3 == null) goto L9;
        r4 = Long.valueOf(r3.d());
    L9:
        if (r4 == null) goto L3;
    L10:
        if (r4 != null) goto L12;
        return;
    L12:
        long r15 = r4.longValue();
        s r11 = r20.c();
        if (r11 == null) goto L41;
        if (a(r20, r19.a(), r21, this.h) == false) goto L41;
        com.obric.oui.texteffects.a r5 = com.obric.oui.texteffects.a.f14578a;
        String r6 = this.d;
        if (com.obric.oui.texteffects.a.a() == true) goto L20;
    L22:
        int r7 = r18.saveLayer(0.0f, 0.0f, this.f14669a.e(), this.f14669a.f(), null);
        b(r18, r19, r20, r21);     // Catch: Throwable -> L30 Exception -> L32
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f14578a;     // Catch: Throwable -> L30 Exception -> L32
        String r1 = this.d;     // Catch: Throwable -> L30 Exception -> L32
        if (com.obric.oui.texteffects.a.a() == true) goto L26;
    L28:
        a(r18, 0.0f, this.f14669a.e(), this.c.a(r11, this.h.left, this.h.right, this.h.width(), r15));     // Catch: Throwable -> L30 Exception -> L32
    L36:
        r18.restoreToCount(r7);
        return;
    L26:
        if (com.obric.oui.texteffects.a.b() == false) goto L28;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", r1), "apply group mask stage=" + r19.a() + ", group=" + r20.a() + ", bounds=" + this.h);     // Catch: Throwable -> L30 Exception -> L32
    L32:
        e = move-exception;
        com.obric.oui.texteffects.a r8 = com.obric.oui.texteffects.a.f14578a;     // Catch: Throwable -> L30
        String r9 = this.d;     // Catch: Throwable -> L30
        if (com.obric.oui.texteffects.a.a() == false) goto L36;
        Log.e(Intrinsics.stringPlus("OTextEff/", r9), Intrinsics.stringPlus("drawGroup error: ", e), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        r18.restoreToCount(r7);
        throw th;
    L20:
        if (com.obric.oui.texteffects.a.b() == false) goto L22;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", r6), "draw group stage=" + r19.a() + ", group=" + r20.a() + ", directDraw=false, bounds=" + this.h);
    L41:
        com.obric.oui.texteffects.a r10 = com.obric.oui.texteffects.a.f14578a;
        String r12 = this.d;
        if (com.obric.oui.texteffects.a.a() == true) goto L44;
    L50:
        b(r18, r19, r20, r21);
        return;
    L44:
        if (com.obric.oui.texteffects.a.b() == false) goto L50;
        String r13 = Intrinsics.stringPlus("OTextEff/frame/", r12);
        StringBuilder r14 = new StringBuilder().append("draw group stage=").append(r19.a()).append(", group=").append(r20.a()).append(", directDraw=true, hasMask=");
        if (r11 == null) goto L48;
        boolean r16 = true;
    L49:
        Log.d(r13, r14.append(r16).toString());
        goto L50
    L48:
        r16 = false;
        goto L49
    }

    private final void a(Paint r3) {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        r3.setBlendMode(null);
    L5:
        r3.setXfermode(null);
    }

    private final void a(Paint r4, BlendSpec r5) {
        if (r5 != BlendSpec.SRC_OVER) goto L7;
        a(r4);
        return;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        r4.setBlendMode(a(r5));
        return;
    L9:
        PorterDuff.Mode r0 = b(r5);
        if (r0 != null) goto L12;
        PorterDuffXfermode r3 = null;
    L16:
        r4.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(r3, Xfermode.class, "com.obric.memorydata.plugin"));
        return;
    L12:
        PorterDuffXfermode r1 = this.l[r5.ordinal()];
        if (r1 != null) goto L15;
        r1 = new PorterDuffXfermode(r0);
        this.l[r5.ordinal()] = r1;
    L15:
        r3 = r1;
        goto L16
    }

    private final void a(com.obric.oui.texteffects.core.j.b r14, long r15) {
        m r1 = this.f14670b.a(r14.c());
        boolean r3 = true;
        if (r1.c().length != 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L9;
    L38:
        com.obric.oui.texteffects.a r4 = com.obric.oui.texteffects.a.f14578a;
        String r0 = this.d;
        if (com.obric.oui.texteffects.a.a() == false) goto L43;
        Log.d(Intrinsics.stringPlus("OTextEff/", r0), "prewarm skip layer=" + r14.a() + ", emptyText");
        return;
    L43:
        return;
    L9:
        if (r1.k() <= 0.01f) goto L38;
        com.obric.oui.texteffects.a r5 = com.obric.oui.texteffects.a.f14578a;
        String r6 = this.d;
        if (com.obric.oui.texteffects.a.a() == false) goto L20;
        String r7 = Intrinsics.stringPlus("OTextEff/", r6);
        StringBuilder r8 = new StringBuilder().append("prewarm text layer=").append(r14.a()).append(", source=").append(r14.c()).append(", stagePlayTime=").append(r15).append(", character=");
        if (r14.g() != null) goto L17;
        r3 = false;
    L17:
        Log.d(r7, r8.append(r3).toString());
    L20:
        if (r14.g() == null) goto L33;
        this.m.a(r1.c().length);
        if (e.f14659a.a(r14.g()) == true) goto L24;
    L25:
        o.a(r1);
    L27:
        if (r1.m() == null) goto L33;
        if (r14.c() == TextSource.Current) goto L31;
    L32:
        o.b(r1);
        goto L33
    L31:
        if (this.f14669a.d() != null) goto L33;
    L24:
        if (r1.f() == true) goto L27;
    L33:
        this.c.a(r14.d(), r1, r15, this.f14669a.h());
        s r9 = r14.e();
        if (r9 == null) goto L42;
        this.c.a(r9, r1.l(), r1.l() + r1.k(), r1.k(), r15);
        return;
    L42:
        return;
    L5:
        r2 = false;
        goto L7
    }

    private final boolean a(com.obric.oui.texteffects.core.j.b r9, String r10, com.obric.oui.texteffects.runtime.f r11, RectF r12) {
        m r0 = this.f14670b.a(r9.c());
        if (r0.c().length != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L37:
        return false;
    L8:
        if (r0.k() <= 0.01f) goto L37;
        if (r9.c() == TextSource.Current) goto L13;
    L15:
        boolean r2 = false;
    L17:
        if (r2 == true) goto L19;
    L20:
        r12.set(r0.l(), 0.0f, r0.l() + r0.k(), this.f14669a.f());
    L21:
        if (r11 != null) goto L23;
        com.obric.oui.texteffects.runtime.e r13 = null;
    L24:
        if (r13 != null) goto L26;
        float r14 = 0.0f;
    L27:
        r12.offset(r14, 0.0f);
        com.obric.oui.texteffects.a r15 = com.obric.oui.texteffects.a.f14578a;
        String r8 = this.d;
        if (com.obric.oui.texteffects.a.a() == false) goto L33;
        if (com.obric.oui.texteffects.a.b() == false) goto L33;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", r8), "resolveLayerTextBounds stage=" + r10 + ", layer=" + r9.a() + ", source=" + r9.c() + ", usesLiveLayout=" + r2 + ", out=" + r12);
    L33:
        if (r12.width() <= 0.01f) goto L36;
        return true;
    L36:
        return false;
    L26:
        r14 = a((com.obric.oui.texteffects.runtime.g) ZeusTransformUtils.preCheckCast(r13, com.obric.oui.texteffects.runtime.g.class, "com.obric.memorydata.plugin"), r13.h());
        goto L27
    L23:
        r13 = a(r11, r10, r9.a());
        goto L24
    L19:
        if (a(r0, r12) == true) goto L21;
    L13:
        if (r9.g() == null) goto L15;
        r2 = true;
        goto L17
    L5:
        r1 = false;
        goto L6
    }

    private final boolean a(com.obric.oui.texteffects.core.k r6, String r7, com.obric.oui.texteffects.runtime.f r8, RectF r9) {
        Iterator<com.obric.oui.texteffects.core.j> r0 = r6.b().iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L13;
        com.obric.oui.texteffects.core.j r2 = (com.obric.oui.texteffects.core.j) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.oui.texteffects.core.j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.texteffects.core.j.b.class) == false) goto L4;
        if (a((com.obric.oui.texteffects.core.j.b) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.texteffects.core.j.b.class, "com.obric.memorydata.plugin"), r7, r8, this.j) == false) goto L4;
        if (r1 == false) goto L11;
        r9.union(this.j);
        goto L4
    L11:
        r9.set(this.j);
        r1 = true;
        goto L4
    L13:
        com.obric.oui.texteffects.a r10 = com.obric.oui.texteffects.a.f14578a;
        String r5 = this.d;
        if (com.obric.oui.texteffects.a.a() == true) goto L16;
    L18:
        return r1;
    L16:
        if (com.obric.oui.texteffects.a.b() == false) goto L18;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", r5), "resolveGroupTextBounds stage=" + r7 + ", group=" + r6.a() + ", hasBounds=" + r1 + ", out=" + r9);
        goto L18
    }

    private final boolean a(com.obric.oui.texteffects.core.l r6, com.obric.oui.texteffects.runtime.f r7, RectF r8) {
        Iterator<com.obric.oui.texteffects.core.k> r0 = r6.e().iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L11;
        if (a((com.obric.oui.texteffects.core.k) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.oui.texteffects.core.k.class, "com.obric.memorydata.plugin"), r6.a(), r7, this.i) == false) goto L4;
        if (r1 == false) goto L9;
        r8.union(this.i);
        goto L4
    L9:
        r8.set(this.i);
        r1 = true;
        goto L4
    L11:
        com.obric.oui.texteffects.a r9 = com.obric.oui.texteffects.a.f14578a;
        String r5 = this.d;
        if (com.obric.oui.texteffects.a.a() == true) goto L14;
    L16:
        return r1;
    L14:
        if (com.obric.oui.texteffects.a.b() == false) goto L16;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", r5), "resolveStageTextBounds stage=" + r6.a() + ", hasBounds=" + r1 + ", out=" + r8);
        goto L16
    }

    private final boolean a(m r11, RectF r12) {
        Layout r0 = this.f14669a.d();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.getLineCount() > 0) goto L8;
    L53:
        return false;
    L8:
        if (StringsKt.contentEquals(r0.getText(), r11.b()) == false) goto L53;
        float r2 = Float.POSITIVE_INFINITY;
        float r3 = Float.NEGATIVE_INFINITY;
        int r4 = r0.getLineCount();
        int r5 = 0;
    L11:
        boolean r6 = true;
        if (r5 >= r4) goto L31;
        int r7 = r5 + 1;
        float r8 = r0.getLineLeft(r5);
        float r9 = r0.getLineRight(r5);
        if (Float.isInfinite(r8) == false) goto L16;
    L18:
        boolean r10 = false;
    L19:
        if (r10 == false) goto L29;
        if (Float.isInfinite(r9) == false) goto L23;
    L25:
        r6 = false;
    L26:
        if (r6 == false) goto L29;
        r2 = Math.min(r2, Math.min(r8, r9));
        r3 = Math.max(r3, Math.max(r8, r9));
        goto L29
    L23:
        if (Float.isNaN(r9) == true) goto L25;
    L29:
        r5 = r7;
        goto L11
    L16:
        if (Float.isNaN(r8) == true) goto L18;
        r10 = true;
        goto L19
    L31:
        if (Float.isInfinite(r2) == false) goto L33;
    L35:
        boolean r1 = false;
    L36:
        if (r1 == false) goto L53;
        if (Float.isInfinite(r3) == false) goto L40;
    L42:
        boolean r13 = false;
    L43:
        if (r13 == false) goto L53;
        if ((r3 - r2) <= 0.01f) goto L53;
        float r14 = this.f14669a.a().getCompoundPaddingLeft();
        r12.set(r14 + r2, 0.0f, r14 + r3, this.f14669a.f());
        com.obric.oui.texteffects.a r15 = com.obric.oui.texteffects.a.f14578a;
        String r16 = this.d;
        if (com.obric.oui.texteffects.a.a() == true) goto L50;
    L52:
        return true;
    L50:
        if (com.obric.oui.texteffects.a.b() == false) goto L52;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", r16), "resolveLiveLayoutHorizontalBounds text=" + r11.b() + ", left=" + r2 + ", right=" + r3 + ", out=" + r12);
        goto L52
    L40:
        if (Float.isNaN(r3) == true) goto L42;
        r13 = true;
        goto L43
    L33:
        if (Float.isNaN(r2) == true) goto L35;
        r1 = true;
        goto L36
    }

    private final PorterDuff.Mode b(BlendSpec r2) {
        int r1 = b.f14673a[r2.ordinal()];
        if (r1 == 25) goto L29;
        switch(r1) {
            case 1: goto L23;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L24;
            case 5: goto L38;
            case 6: goto L37;
            case 7: goto L36;
            case 8: goto L35;
            case 9: goto L34;
            case 10: goto L33;
            case 11: goto L32;
            case 12: goto L31;
            case 13: goto L30;
            case 14: goto L29;
            case 15: goto L28;
            case 16: goto L27;
            case 17: goto L26;
            case 18: goto L25;
            default: goto L24;
        };
    L24:
        return null;
    L25:
        return PorterDuff.Mode.LIGHTEN;
    L26:
        return PorterDuff.Mode.DARKEN;
    L27:
        return PorterDuff.Mode.OVERLAY;
    L28:
        return PorterDuff.Mode.SCREEN;
    L30:
        return PorterDuff.Mode.ADD;
    L31:
        return PorterDuff.Mode.XOR;
    L32:
        return PorterDuff.Mode.DST_ATOP;
    L33:
        return PorterDuff.Mode.SRC_ATOP;
    L34:
        return PorterDuff.Mode.DST_OUT;
    L35:
        return PorterDuff.Mode.SRC_OUT;
    L36:
        return PorterDuff.Mode.DST_IN;
    L37:
        return PorterDuff.Mode.SRC_IN;
    L38:
        return PorterDuff.Mode.DST_OVER;
    L39:
        return PorterDuff.Mode.DST;
    L40:
        return PorterDuff.Mode.SRC;
    L23:
        return PorterDuff.Mode.CLEAR;
    L29:
        return PorterDuff.Mode.MULTIPLY;
    }

    private final void b(Canvas r7, com.obric.oui.texteffects.core.l r8, com.obric.oui.texteffects.core.k r9, com.obric.oui.texteffects.runtime.f r10) {
        Iterator<com.obric.oui.texteffects.core.j> r0 = r9.b().iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        com.obric.oui.texteffects.core.j r1 = (com.obric.oui.texteffects.core.j) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.oui.texteffects.core.j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.texteffects.core.j.b.class) == false) goto L4;
        com.obric.oui.texteffects.core.j.b r2 = (com.obric.oui.texteffects.core.j.b) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.texteffects.core.j.b.class, "com.obric.memorydata.plugin");
        com.obric.oui.texteffects.a r3 = com.obric.oui.texteffects.a.f14578a;
        String r4 = this.d;
        if (com.obric.oui.texteffects.a.a() == true) goto L10;
    L12:
        com.obric.oui.texteffects.runtime.e r5 = a(r10, r8.a(), r2.a());
        if (r5 == null) goto L4;
        a(r7, r2, (com.obric.oui.texteffects.runtime.g) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.texteffects.runtime.g.class, "com.obric.memorydata.plugin"));
        goto L4
    L10:
        if (com.obric.oui.texteffects.a.b() == false) goto L12;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", r4), "drawTextLayers stage=" + r8.a() + ", group=" + r9.a() + ", layer=" + r2.a());
        goto L12
    }

    public final void a(Canvas r25, u r26, com.obric.oui.texteffects.runtime.f r27) {
        Intrinsics.checkNotNullParameter(r25, "canvas");
        Intrinsics.checkNotNullParameter(r26, "spec");
        Intrinsics.checkNotNullParameter(r27, TypedValues.AttributesType.S_FRAME);
        com.obric.oui.texteffects.a r2 = com.obric.oui.texteffects.a.f14578a;
        String r3 = this.d;
        if (com.obric.oui.texteffects.a.a() == false) goto L5;
        Log.d(Intrinsics.stringPlus("OTextEff/", r3), "draw start spec=" + r26.a() + ", activeLayers=" + r27.b() + ", size=" + this.f14669a.e() + 'x' + this.f14669a.f());
    L5:
        a();
        this.f14669a.a(r25);
        int r13 = r25.saveLayer(0.0f, 0.0f, this.f14669a.e(), this.f14669a.f(), null);
        Iterator<com.obric.oui.texteffects.core.l> r14 = r26.d().iterator();     // Catch: Throwable -> L47
    L8:
        if (r14.hasNext() == false) goto L43;
        com.obric.oui.texteffects.core.l r15 = (com.obric.oui.texteffects.core.l) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.oui.texteffects.core.l.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        Long r4 = a(r27, r15.a());     // Catch: Throwable -> L47
        if (r4 == null) goto L8;
        long r6 = r4.longValue();     // Catch: Throwable -> L47
        if (r15.d() != null) goto L15;
    L17:
        boolean r5 = false;
    L18:
        boolean r7 = r5;
        com.obric.oui.texteffects.a r8 = com.obric.oui.texteffects.a.f14578a;     // Catch: Throwable -> L47
        String r9 = this.d;     // Catch: Throwable -> L47
        if (com.obric.oui.texteffects.a.a() == false) goto L25;
        if (com.obric.oui.texteffects.a.b() == false) goto L25;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", r9), "draw stage=" + r15.a() + ", playTime=" + r6 + ", groups=" + r15.e().size() + ", hasStageMask=" + r7 + ", stageBounds=" + this.g);     // Catch: Throwable -> L47
    L25:
        if (r7 == false) goto L27;
        int r10 = r25.saveLayer(0.0f, 0.0f, this.f14669a.e(), this.f14669a.f(), null);     // Catch: Throwable -> L47
    L52:
        Iterator<com.obric.oui.texteffects.core.k> r11 = r15.e().iterator();     // Catch: Throwable -> L40
    L30:
        if (r11.hasNext() == false) goto L32;
        a(r25, r15, (com.obric.oui.texteffects.core.k) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.oui.texteffects.core.k.class, "com.obric.memorydata.plugin"), r27);     // Catch: Throwable -> L40
        goto L30
    L32:
        if (r7 == false) goto L39;
        com.obric.oui.texteffects.a r12 = com.obric.oui.texteffects.a.f14578a;     // Catch: Throwable -> L40
        String r16 = this.d;     // Catch: Throwable -> L40
        if (com.obric.oui.texteffects.a.a() == true) goto L36;
    L38:
        float r17 = this.f14669a.e();     // Catch: Throwable -> L40
        k r18 = this.c;     // Catch: Throwable -> L40
        s r19 = r15.d();     // Catch: Throwable -> L40
        Intrinsics.checkNotNull(r19);     // Catch: Throwable -> L40
        a(r25, 0.0f, r17, r18.a(r19, this.g.left, this.g.right, this.g.width(), r6));     // Catch: Throwable -> L40
        goto L39
    L36:
        if (com.obric.oui.texteffects.a.b() == false) goto L38;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", r16), "apply stage mask stage=" + r15.a() + ", bounds=" + this.g);     // Catch: Throwable -> L40
    L39:
        r25.restoreToCount(r10);     // Catch: Throwable -> L47
    L40:
        th = move-exception;
        r25.restoreToCount(r10);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L27:
        r10 = r25.save();     // Catch: Throwable -> L47
        goto L52
    L15:
        if (a(r15, r27, this.g) == false) goto L17;
        r5 = true;
        goto L18
    L43:
        r25.restoreToCount(r13);
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f14578a;
        String r1 = this.d;
        if (com.obric.oui.texteffects.a.a() == false) goto L63;
        Log.d(Intrinsics.stringPlus("OTextEff/", r1), Intrinsics.stringPlus("draw end spec=", r26.a()));
        return;
    L63:
        return;
    L47:
        th = move-exception;
        r25.restoreToCount(r13);
        com.obric.oui.texteffects.a r20 = com.obric.oui.texteffects.a.f14578a;
        String r21 = this.d;
        if (com.obric.oui.texteffects.a.a() == false) goto L51;
        Log.d(Intrinsics.stringPlus("OTextEff/", r21), Intrinsics.stringPlus("draw end spec=", r26.a()));
    L51:
        throw th;
    }

    public final void a(u r22) {
        Intrinsics.checkNotNullParameter(r22, "spec");
        com.obric.oui.texteffects.a r1 = com.obric.oui.texteffects.a.f14578a;
        String r2 = this.d;
        if (com.obric.oui.texteffects.a.a() == false) goto L5;
        Log.d(Intrinsics.stringPlus("OTextEff/", r2), "prewarm start spec=" + r22.a() + ", stages=" + r22.d().size());
    L5:
        Iterator<com.obric.oui.texteffects.core.l> r3 = r22.d().iterator();
    L7:
        if (r3.hasNext() == false) goto L34;
        com.obric.oui.texteffects.core.l r4 = (com.obric.oui.texteffects.core.l) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.oui.texteffects.core.l.class, "com.obric.memorydata.plugin");
        com.obric.oui.texteffects.runtime.f r10 = null;
        if (r4.d() != null) goto L11;
    L16:
        Iterator<com.obric.oui.texteffects.core.k> r5 = r4.e().iterator();
    L18:
        if (r5.hasNext() == false) goto L7;
        com.obric.oui.texteffects.core.k r11 = (com.obric.oui.texteffects.core.k) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.oui.texteffects.core.k.class, "com.obric.memorydata.plugin");
        if (r11.c() != null) goto L22;
    L27:
        Iterator<com.obric.oui.texteffects.core.j> r12 = r11.b().iterator();
    L29:
        if (r12.hasNext() == false) goto L33;
        com.obric.oui.texteffects.core.j r13 = (com.obric.oui.texteffects.core.j) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.oui.texteffects.core.j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, com.obric.oui.texteffects.core.j.b.class) == false) goto L29;
        a((com.obric.oui.texteffects.core.j.b) ZeusTransformUtils.preCheckCast(r13, com.obric.oui.texteffects.core.j.b.class, "com.obric.memorydata.plugin"), 0);
        goto L29
    L33:
        r10 = null;
        goto L18
    L22:
        if (a(r11, r4.a(), r10, this.h) == false) goto L27;
        com.obric.oui.texteffects.a r14 = com.obric.oui.texteffects.a.f14578a;
        String r15 = this.d;
        if (com.obric.oui.texteffects.a.a() == false) goto L26;
        Log.d(Intrinsics.stringPlus("OTextEff/", r15), "prewarm group mask stage=" + r4.a() + ", group=" + r11.a() + ", bounds=" + this.h);
    L26:
        this.c.a(r11.c(), this.h.left, this.h.right, this.h.width(), 0);
        goto L27
    L11:
        if (a(r4, null, this.g) == false) goto L16;
        com.obric.oui.texteffects.a r6 = com.obric.oui.texteffects.a.f14578a;
        String r7 = this.d;
        if (com.obric.oui.texteffects.a.a() == false) goto L15;
        Log.d(Intrinsics.stringPlus("OTextEff/", r7), "prewarm stage mask stage=" + r4.a() + ", bounds=" + this.g);
    L15:
        this.c.a(r4.d(), this.g.left, this.g.right, this.g.width(), 0);
        goto L16
    L34:
        com.obric.oui.texteffects.a r8 = com.obric.oui.texteffects.a.f14578a;
        String r0 = this.d;
        if (com.obric.oui.texteffects.a.a() == false) goto L45;
        Log.d(Intrinsics.stringPlus("OTextEff/", r0), Intrinsics.stringPlus("prewarm end spec=", r22.a()));
        return;
    }
}
