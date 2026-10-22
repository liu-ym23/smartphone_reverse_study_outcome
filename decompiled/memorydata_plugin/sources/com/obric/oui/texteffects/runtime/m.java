package com.obric.oui.texteffects.runtime;

import android.util.Log;
import android.util.LruCache;
import android.view.animation.PathInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.dumper.Scraps;
import com.obric.oui.texteffects.core.CharacterOrder;
import com.obric.oui.texteffects.core.CharacterRangeUnit;
import com.obric.oui.texteffects.core.EffectProperty;
import com.obric.oui.texteffects.core.q;
import com.obric.oui.texteffects.core.r;
import com.obric.oui.texteffects.core.t;
import com.obric.oui.texteffects.core.u;
import com.obric.oui.texteffects.core.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\rH\u0002J \u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J2\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020!H\u0002J\u0016\u0010&\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018J\u001e\u0010&\u001a\u00020(2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010%\u001a\u00020(J \u0010)\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020*2\u0006\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010+\u001a\u00020\rJP\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020\r2\u0006\u0010$\u001a\u00020\rH\u0002JJ\u00107\u001a\u0002082\u0006\u0010\u0019\u001a\u0002092\u0006\u0010:\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010<\u001a\u00020\r2\u0006\u0010%\u001a\u000208JH\u0010=\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020\r2\u0006\u0010$\u001a\u00020\rH\u0002J(\u0010>\u001a\u00020\r2\u0006\u0010?\u001a\u00020\r2\u0006\u00106\u001a\u00020\r2\u0006\u0010@\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020E2\u0006\u0010:\u001a\u00020\u0018H\u0002J(\u0010A\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020E2\u0006\u0010:\u001a\u00020\u00182\u0006\u0010%\u001a\u00020FH\u0002J \u0010G\u001a\u00020\r2\u0006\u00100\u001a\u0002012\u0006\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u0018H\u0002J\u0018\u0010H\u001a\u00020\u00122\u0006\u0010I\u001a\u00020J2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0018\u0010K\u001a\u00020\r2\u0006\u0010I\u001a\u00020J2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0018\u0010L\u001a\u00020\u001d2\u0006\u0010%\u001a\u0002082\u0006\u0010\u001e\u001a\u00020\u001fH\u0002JH\u0010M\u001a\u00020\u001d2\u0006\u0010%\u001a\u0002082\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\r2\u0006\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020\r2\u0006\u0010Q\u001a\u00020\r2\u0006\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020\rH\u0002J\f\u0010T\u001a\u00020\b*\u00020\u0007H\u0002J\u0014\u0010U\u001a\u00020\r*\u00020\u00122\u0006\u0010+\u001a\u00020\rH\u0002J\f\u0010V\u001a\u00020\u001f*\u00020\u001aH\u0002J\u0014\u0010W\u001a\u00020\u0018*\u00020\u00182\u0006\u0010X\u001a\u00020\u0018H\u0002J\f\u0010Y\u001a\u00020Z*\u00020[H\u0002J\f\u0010\\\u001a\u00020Z*\u00020]H\u0002J\f\u0010^\u001a\u00020Z*\u00020\u0012H\u0002J\f\u0010_\u001a\u00020Z*\u00020\u0012H\u0002J\u001a\u0010`\u001a\u00020\u001f*\b\u0012\u0004\u0012\u00020\u00140a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\f\u0010b\u001a\u00020\u000b*\u00020\nH\u0002J.\u0010c\u001a\u00020\r*\u00020\u00122\u0006\u0010d\u001a\u00020e2\u0006\u0010;\u001a\u00020\r2\b\b\u0002\u0010f\u001a\u00020\r2\u0006\u0010$\u001a\u00020\rH\u0002J\u001c\u0010g\u001a\u00020\r*\u00020\r2\u0006\u0010d\u001a\u00020e2\u0006\u0010$\u001a\u00020\rH\u0002J\u001c\u0010h\u001a\u00020\r*\u00020[2\u0006\u0010$\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0002J$\u0010i\u001a\u00020\r*\u00020]2\u0006\u0010;\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010<\u001a\u00020\rH\u0002J$\u0010j\u001a\u00020\r*\u0002012\u0006\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\rH\u0002J\u0014\u0010k\u001a\u00020\r*\u00020\u00122\u0006\u0010;\u001a\u00020\rH\u0002J\u0014\u0010l\u001a\u00020\r*\u00020[2\u0006\u0010$\u001a\u00020\rH\u0002J$\u0010m\u001a\u00020\r*\u00020]2\u0006\u0010;\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010<\u001a\u00020\rH\u0002J\u0014\u0010n\u001a\u00020\r*\u0002032\u0006\u0010$\u001a\u00020\rH\u0002J\u0014\u0010o\u001a\u00020\r*\u00020[2\u0006\u0010$\u001a\u00020\rH\u0002J$\u0010p\u001a\u00020\r*\u00020]2\u0006\u0010;\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010<\u001a\u00020\rH\u0002J\f\u0010q\u001a\u00020Z*\u00020]H\u0002J\f\u0010q\u001a\u00020Z*\u00020[H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Lcom/obric/oui/texteffects/runtime/TextEffectTimelineSampler;", "", "()V", "Tag", "", "aeShapeInterpolatorCache", "Landroid/util/LruCache;", "Lcom/obric/oui/texteffects/core/EasingSpec$AeShape;", "Lcom/obric/oui/texteffects/runtime/AeShapeInterpolator;", "interpolatorCache", "Lcom/obric/oui/texteffects/core/EasingSpec$CubicBezier;", "Landroid/view/animation/PathInterpolator;", "applyEasing", "", "easing", "Lcom/obric/oui/texteffects/core/EasingSpec;", "progress", "interpolate", "Lcom/obric/oui/texteffects/core/EffectValue;", "from", "Lcom/obric/oui/texteffects/core/Keyframe;", TypedValues.TransitionType.S_TO, "lerp", "normalizePlayTime", "", "spec", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "playTimeMs", "resolveCharacterAxisPositions", "", "characterCount", "", "characterWidths", "", "order", "Lcom/obric/oui/texteffects/core/CharacterOrder;", "textTotalWidthPx", "out", "sample", "Lcom/obric/oui/texteffects/runtime/TextEffectFrame;", "Lcom/obric/oui/texteffects/runtime/ReusableTextEffectFrame;", "sampleAnimatedFloat", "Lcom/obric/oui/texteffects/core/AnimatedFloatSpec;", "defaultValue", "sampleCharacterDimensionPropertyPx", "orderedIndex", CommonConsts.APM_INNER_EVENT_COST_START, "end", TypedValues.CycleType.S_WAVE_OFFSET, "Lcom/obric/oui/texteffects/core/CharacterOffsetSpec;", "shape", "Lcom/obric/oui/texteffects/core/CharacterShapeSpec;", "localTimeMs", "durationMs", "characterAxis", "sampleCharacterEffect", "Lcom/obric/oui/texteffects/runtime/TextEffectTimelineSampler$CharacterFrameBuffer;", "Lcom/obric/oui/texteffects/core/CharacterEffectSpec;", "stagePlayTimeMs", "density", "textSizePx", "sampleCharacterFloatProperty", "sampleCharacterShapeProgress", "currentOffset", "shapeRange", "sampleLayerFrame", "Lcom/obric/oui/texteffects/runtime/LayerFrame;", "stageId", "layer", "Lcom/obric/oui/texteffects/core/EffectLayer;", "Lcom/obric/oui/texteffects/runtime/ReusableLayerFrame;", "sampleOffsetProgress", "sampleTrack", "track", "Lcom/obric/oui/texteffects/core/PropertyTrack;", "sampleTrackAsFloat", "writeDefaultCharacterFrame", "writeStaticCharacterFrame", "alpha", "trackingX", "trackingY", "positionX", "positionY", "scale", "aeAnimatorInterpolator", "asFloat", "estimatedLayerCount", "floorMod", "other", "isConstantOne", "", "Lcom/obric/oui/texteffects/core/CharacterFloatPropertySpec;", "isConstantZero", "Lcom/obric/oui/texteffects/core/CharacterDimensionPropertySpec;", "isDimensionLike", "isZeroDimension", "nextFrameIndex", "", "pathInterpolator", "resolveCharacterDimensionPx", Scraps.INNER_UNIT, "Lcom/obric/oui/texteffects/core/CharacterRangeUnit;", "fontScale", "resolveCharacterFloat", "resolveConstantOrDefault", "resolveConstantPxOrZero", "resolveCurrentOffsetPx", "resolveDimensionPx", "resolveEnd", "resolveEndPx", "resolveRangePx", "resolveStart", "resolveStartPx", "samplesCharacterAxis", "CharacterFrameBuffer", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f14709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LruCache<com.obric.oui.texteffects.core.i.b, PathInterpolator> f14710b = null;
    private static final LruCache<com.obric.oui.texteffects.core.i.a, com.obric.oui.texteffects.runtime.a> c = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0003R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u001e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/texteffects/runtime/TextEffectTimelineSampler$CharacterFrameBuffer;", "", "initialCapacity", "", "(I)V", "<set-?>", "", "alpha", "getAlpha", "()[F", "axisPositions", "getAxisPositions$OUITextEffects_standardRelease", "progress", "getProgress", "scale", "getScale", "size", "getSize", "()I", "translationX", "getTranslationX", "translationY", "getTranslationY", "ensureCapacity", "", "capacity", "reset", "newSize", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f14711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float[] f14712b;
        private float[] c;
        private float[] d;
        private float[] e;
        private float[] f;
        private float[] g;

        public a() {
            this(0, 1, null);
        }

        public a(int r2) {
            this.f14712b = new float[r2];
            this.c = new float[r2];
            this.d = new float[r2];
            this.e = new float[r2];
            this.f = new float[r2];
            this.g = new float[r2];
        }

        public /* synthetic */ a(int r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = 0;
        L5:
            this(r1);
        }

        public final int a() {
            return this.f14711a;
        }

        public final void a(int r4) {
            if (this.f14712b.length < r4) goto L5;
            return;
        L5:
            com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f14578a;
            if (com.obric.oui.texteffects.a.a() == false) goto L8;
            Log.d(Intrinsics.stringPlus("OTextEff/", "TimelineSampler"), "create CharacterFrameBuffer arrays oldCapacity=" + b().length + " newCapacity=" + r4);
        L8:
            float[] r1 = Arrays.copyOf(this.f14712b, r4);
            Intrinsics.checkNotNullExpressionValue(r1, "copyOf(this, newSize)");
            this.f14712b = r1;
            float[] r2 = Arrays.copyOf(this.c, r4);
            Intrinsics.checkNotNullExpressionValue(r2, "copyOf(this, newSize)");
            this.c = r2;
            float[] r3 = Arrays.copyOf(this.d, r4);
            Intrinsics.checkNotNullExpressionValue(r3, "copyOf(this, newSize)");
            this.d = r3;
            float[] r5 = Arrays.copyOf(this.e, r4);
            Intrinsics.checkNotNullExpressionValue(r5, "copyOf(this, newSize)");
            this.e = r5;
            float[] r6 = Arrays.copyOf(this.f, r4);
            Intrinsics.checkNotNullExpressionValue(r6, "copyOf(this, newSize)");
            this.f = r6;
            float[] r7 = Arrays.copyOf(this.g, r4);
            Intrinsics.checkNotNullExpressionValue(r7, "copyOf(this, newSize)");
            this.g = r7;
        }

        public final void b(int r1) {
            a(r1);
            this.f14711a = r1;
        }

        public final float[] b() {
            return this.f14712b;
        }

        public final float[] c() {
            return this.c;
        }

        public final float[] d() {
            return this.d;
        }

        public final float[] e() {
            return this.e;
        }

        public final float[] f() {
            return this.f;
        }

        public final float[] g() {
            return this.g;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14713a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f14714b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[EffectProperty.values().length];
            r0[EffectProperty.Alpha.ordinal()] = 1;
            r0[EffectProperty.Visibility.ordinal()] = 2;
            r0[EffectProperty.BlurRadius.ordinal()] = 3;
            r0[EffectProperty.TranslationX.ordinal()] = 4;
            r0[EffectProperty.TranslationY.ordinal()] = 5;
            f14713a = r0;
            int[] r1 = new int[CharacterRangeUnit.values().length];
            r1[CharacterRangeUnit.Absolute.ordinal()] = 1;
            r1[CharacterRangeUnit.TextWidthPercent.ordinal()] = 2;
            f14714b = r1;
            int[] r2 = new int[CharacterOrder.values().length];
            r2[CharacterOrder.StartToEnd.ordinal()] = 1;
            r2[CharacterOrder.EndToStart.ordinal()] = 2;
            r2[CharacterOrder.CenterOut.ordinal()] = 3;
            c = r2;
        }
    }

    static {
        f14709a = new m();
        f14710b = new LruCache(16);
        c = new LruCache(16);
    }

    private m() {
    }

    private final float a(float r1, float r2, float r3) {
        return r1 + ((r2 - r1) * r3);
    }

    private final float a(float r2, float r3, float r4, com.obric.oui.texteffects.core.i r5) {
        float r6 = r3 - r2;
        return a(r5, 1.0f - RangesKt.coerceIn(r6 / RangesKt.coerceAtLeast(r4, 1.0E-4f), 0.0f, 1.0f));
    }

    private final float a(float r11, float r12, com.obric.oui.texteffects.core.g r13, com.obric.oui.texteffects.core.h r14, long r15, long r17, float r19, float r20) {
        if (r11 != r12) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return r11;
    L9:
        return a(r11, r12, a(a(r13, r15, r17, r20), r19, a(r14, r20), r14.c()));
    L5:
        r0 = false;
        goto L6
    }

    private final float a(float r1, CharacterRangeUnit r2, float r3) {
        int r0 = b.f14714b[r2.ordinal()];
        if (r0 != 1) goto L5;
        return r1;
    L5:
        if (r0 != 2) goto L8;
        return r1 * r3;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private final float a(int r12, float r13, float r14, com.obric.oui.texteffects.core.g r15, com.obric.oui.texteffects.core.h r16, long r17, long r19, float r21, float r22) {
        boolean r2 = true;
        if (r13 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L14;
        if (r14 != 0.0f) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        return 0.0f;
    L10:
        r3 = false;
    L14:
        if (r13 == r14) goto L17;
        r2 = false;
    L17:
        if (r2 == false) goto L19;
        return r13;
    L19:
        float r0 = a(a(r15, r17, r19, r22), r21, a(r16, r22), r16.c());
        float r4 = a(r13, r14, r0);
        com.obric.oui.texteffects.a r5 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == true) goto L22;
    L24:
        return r4;
    L22:
        if (com.obric.oui.texteffects.a.b() == false) goto L24;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", "TimelineSampler"), "sampleCharacterPropertyPx index=" + r12 + ", result=" + r4 + ", shapeProgress=" + r0 + ", characterAxis=" + r21);
        goto L24
    L5:
        r1 = false;
        goto L6
    }

    private final float a(com.obric.oui.texteffects.core.b r9, float r10, float r11, float r12) {
        com.obric.oui.texteffects.core.f r0 = r9.b();
        if (r0 != null) goto L5;
        com.obric.oui.texteffects.core.c r13 = r9.a();
        if (r13 != null) goto L11;
        return 0.0f;
    L11:
        return a(this, r13.a(), r13.c(), r10, 0.0f, r11, 4, null);
    L5:
        return a(r0.a(), r0.c(), r11) * r12;
    }

    private final float a(com.obric.oui.texteffects.core.e r2, float r3) {
        return a(r2.a().a(), r2.a().c(), r3);
    }

    private final float a(com.obric.oui.texteffects.core.e r4, float r5, float r6) {
        if (r4.a().c() != CharacterRangeUnit.Absolute) goto L16;
        boolean r1 = true;
        if (r4.a().a() != r6) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L16;
        if (r4.a().b() == r6) goto L13;
        r1 = false;
    L13:
        if (r1 == false) goto L16;
        return r6;
    L7:
        r0 = false;
    L16:
        return a(r4.a().a(), r4.a().c(), r5);
    }

    private final float a(com.obric.oui.texteffects.core.g r1, long r2, long r4) {
        return a(r1.c(), RangesKt.coerceIn(r2 / r4, 0.0f, 1.0f));
    }

    private final float a(com.obric.oui.texteffects.core.g r1, long r2, long r4, float r6) {
        float r3 = a(r1, r2, r4);
        return a(r1.a() * r6, r6 * r1.b(), r3);
    }

    private final float a(com.obric.oui.texteffects.core.h r2, float r3) {
        CharacterRangeUnit r1 = r2.b();
        int r4 = b.f14714b[r1.ordinal()];
        if (r4 == 1) goto L10;
        if (r4 != 2) goto L8;
        return r3 * r2.a();
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return r2.a();
    }

    private final float a(com.obric.oui.texteffects.core.i r3, float r4) {
        if (Intrinsics.areEqual(r3, com.obric.oui.texteffects.core.i.c.f14603a) == false) goto L6;
        return r4;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.texteffects.core.i.b.class) == false) goto L9;
        return a((com.obric.oui.texteffects.core.i.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.texteffects.core.i.b.class, "com.obric.memorydata.plugin")).getInterpolation(r4);
    L9:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.texteffects.core.i.a.class) == false) goto L13;
        return a((com.obric.oui.texteffects.core.i.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.texteffects.core.i.a.class, "com.obric.memorydata.plugin")).getInterpolation(r4);
    L13:
        throw new NoWhenBranchMatchedException();
    }

    private final float a(com.obric.oui.texteffects.core.m r2, float r3) {
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.texteffects.core.m.b.class) == false) goto L6;
        return ((com.obric.oui.texteffects.core.m.b) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.texteffects.core.m.b.class, "com.obric.memorydata.plugin")).a();
    L6:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.texteffects.core.m.a.class) == true) goto L8;
        return r3;
    L8:
        return ((com.obric.oui.texteffects.core.m.a) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.texteffects.core.m.a.class, "com.obric.memorydata.plugin")).a();
    }

    private final float a(com.obric.oui.texteffects.core.m r2, CharacterRangeUnit r3, float r4, float r5, float r6) {
        int r7 = b.f14714b[r3.ordinal()];
        if (r7 == 1) goto L17;
        if (r7 != 2) goto L15;
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.texteffects.core.m.a.class) == false) goto L11;
        float r1 = ((com.obric.oui.texteffects.core.m.a) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.texteffects.core.m.a.class, "com.obric.memorydata.plugin")).a();
    L18:
        return r6 * r1;
    L11:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.texteffects.core.m.b.class) == false) goto L13;
        r1 = ((com.obric.oui.texteffects.core.m.b) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.texteffects.core.m.b.class, "com.obric.memorydata.plugin")).a();
        goto L18
    L13:
        return 0.0f;
    L15:
        throw new NoWhenBranchMatchedException();
    L17:
        return b(r2, r4) * r5;
    }

    public static /* synthetic */ float a(m r0, com.obric.oui.texteffects.core.a r1, long r2, float r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r4 = 1.0f;
    L6:
        return r0.a(r1, r2, r4);
    }

    static /* synthetic */ float a(m r6, com.obric.oui.texteffects.core.m r7, CharacterRangeUnit r8, float r9, float r10, float r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r10 = 1.0f;
    L6:
        return r6.a(r7, r8, r9, r10, r11);
    }

    private final int a(u r1) {
        return v.a(r1);
    }

    private final int a(List<q> r6, long r7) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r8 = CollectionsKt.getLastIndex(r5);
        int r1 = 0;
    L4:
        if (r1 >= r8) goto L10;
        int r2 = (r1 + r8) >>> 1;
        if (((q) ZeusTransformUtils.preCheckCast(r5.get(r2), q.class, "com.obric.memorydata.plugin")).a() >= r7) goto L7;
        r1 = r2 + 1;
        goto L4
    L7:
        r8 = r2;
        goto L4
    L10:
        return RangesKt.coerceAtLeast(r1, 1);
    }

    private final long a(long r3, long r5) {
        long r4 = r3 % r5;
        if (r4 < 0) goto L5;
        return r4;
    L5:
        return r4 + r5;
    }

    private final PathInterpolator a(com.obric.oui.texteffects.core.i.b r6) {
        LruCache<com.obric.oui.texteffects.core.i.b, PathInterpolator> r5 = f14710b;
        PathInterpolator r0 = (PathInterpolator) ZeusTransformUtils.preCheckCast(r5.get(r6), PathInterpolator.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        PathInterpolator r1 = new PathInterpolator(r6.a(), r6.b(), r6.c(), r6.d());
        r5.put(r6, r1);
        return r1;
    L6:
        return r0;
    }

    private final com.obric.oui.texteffects.core.m a(q r4, q r5, float r6) {
        com.obric.oui.texteffects.core.m r7 = r4.b();
        com.obric.oui.texteffects.core.m r8 = r5.b();
        if (ZeusTransformUtils.instanceOf(r7, com.obric.oui.texteffects.core.m.b.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r8, com.obric.oui.texteffects.core.m.b.class) == false) goto L10;
        Object r0 = new com.obric.oui.texteffects.core.m.b(a(((com.obric.oui.texteffects.core.m.b) ZeusTransformUtils.preCheckCast(r7, com.obric.oui.texteffects.core.m.b.class, "com.obric.memorydata.plugin")).a(), ((com.obric.oui.texteffects.core.m.b) ZeusTransformUtils.preCheckCast(r8, com.obric.oui.texteffects.core.m.b.class, "com.obric.memorydata.plugin")).a(), r6));
    L7:
        Object r3 = ZeusTransformUtils.preCheckCast(r0, com.obric.oui.texteffects.core.m.class, "com.obric.memorydata.plugin");
    L24:
        return (com.obric.oui.texteffects.core.m) r3;
    L10:
        if (ZeusTransformUtils.instanceOf(r7, com.obric.oui.texteffects.core.m.a.class) == false) goto L15;
        if (ZeusTransformUtils.instanceOf(r8, com.obric.oui.texteffects.core.m.a.class) == false) goto L15;
        r0 = new com.obric.oui.texteffects.core.m.a(a(((com.obric.oui.texteffects.core.m.a) ZeusTransformUtils.preCheckCast(r7, com.obric.oui.texteffects.core.m.a.class, "com.obric.memorydata.plugin")).a(), ((com.obric.oui.texteffects.core.m.a) ZeusTransformUtils.preCheckCast(r8, com.obric.oui.texteffects.core.m.a.class, "com.obric.memorydata.plugin")).a(), r6));
    L15:
        if (a(r7) == false) goto L20;
        if (a(r8) == false) goto L20;
        r3 = ZeusTransformUtils.preCheckCast(new com.obric.oui.texteffects.core.m.c(r7, r8, r6), com.obric.oui.texteffects.core.m.class, "com.obric.memorydata.plugin");
    L20:
        if (r6 >= 1.0f) goto L23;
        return r7;
    L23:
        return r8;
    }

    private final com.obric.oui.texteffects.core.m a(t r10, long r11) {
        List<q> r0 = r10.b();
        if (r0.isEmpty() == false) goto L7;
        return (com.obric.oui.texteffects.core.m) ZeusTransformUtils.preCheckCast(new com.obric.oui.texteffects.core.m.b(0.0f), com.obric.oui.texteffects.core.m.class, "com.obric.memorydata.plugin");
    L7:
        if (r11 > ((q) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r0), q.class, "com.obric.memorydata.plugin")).a()) goto L11;
        return ((q) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r0), q.class, "com.obric.memorydata.plugin")).b();
    L11:
        if (r11 >= ((q) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r0), q.class, "com.obric.memorydata.plugin")).a()) goto L13;
        int r1 = a(r0, r11);
        q r4 = (q) ZeusTransformUtils.preCheckCast(r0.get(r1 - 1), q.class, "com.obric.memorydata.plugin");
        q r2 = (q) ZeusTransformUtils.preCheckCast(r0.get(r1), q.class, "com.obric.memorydata.plugin");
        return a(r4, r2, a(r10.c(), RangesKt.coerceIn((r11 - r4.a()) / RangesKt.coerceAtLeast(r2.a() - r4.a(), 1), 0.0f, 1.0f)));
    L13:
        return ((q) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r0), q.class, "com.obric.memorydata.plugin")).b();
    }

    private final com.obric.oui.texteffects.runtime.a a(com.obric.oui.texteffects.core.i.a r5) {
        LruCache<com.obric.oui.texteffects.core.i.a, com.obric.oui.texteffects.runtime.a> r4 = c;
        com.obric.oui.texteffects.runtime.a r0 = (com.obric.oui.texteffects.runtime.a) ZeusTransformUtils.preCheckCast(r4.get(r5), com.obric.oui.texteffects.runtime.a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        com.obric.oui.texteffects.runtime.a r1 = new com.obric.oui.texteffects.runtime.a(r5.a(), r5.b(), r5.c());
        r4.put(r5, r1);
        return r1;
    L6:
        return r0;
    }

    private final d a(String r17, com.obric.oui.texteffects.core.j r18, long r19) {
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r18.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        float r7 = Float.NaN;
        float r8 = Float.NaN;
        com.obric.oui.texteffects.core.m r9 = null;
        com.obric.oui.texteffects.core.m r10 = null;
        com.obric.oui.texteffects.core.m r11 = null;
    L3:
        boolean r12 = true;
        if (r1.hasNext() == false) goto L21;
        t r2 = (t) ZeusTransformUtils.preCheckCast(r1.next(), t.class, "com.obric.memorydata.plugin");
        int r13 = b.f14713a[r2.a().ordinal()];
        if (r13 != 1) goto L8;
        r7 = f14709a.b(r2, r19);
        goto L3
    L8:
        if (r13 != 2) goto L10;
        r8 = f14709a.b(r2, r19);
        goto L3
    L10:
        if (r13 != 3) goto L12;
        r9 = f14709a.a(r2, r19);
        goto L3
    L12:
        if (r13 != 4) goto L14;
        r10 = f14709a.a(r2, r19);
        goto L3
    L14:
        if (r13 != 5) goto L3;
        r11 = f14709a.a(r2, r19);
        goto L3
    L21:
        com.obric.oui.texteffects.a r3 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L49;
        if (com.obric.oui.texteffects.a.b() == false) goto L49;
        String r4 = Intrinsics.stringPlus("OTextEff/frame/", "TimelineSampler");
        StringBuilder r5 = new StringBuilder().append("sampleLayer stage=").append(r17).append(", layer=").append(r18.a()).append(", type=").append(r18.getClass().getSimpleName()).append(", stagePlayTime=").append(r19).append(", alpha=").append(r7).append(", visibility=").append(r8).append(", hasBlur=");
        if (r9 == null) goto L28;
        boolean r15 = true;
    L29:
        StringBuilder r6 = r5.append(r15).append(", hasTranslationX=");
        if (r10 == null) goto L32;
        boolean r16 = true;
    L33:
        StringBuilder r14 = r6.append(r16).append(", hasTranslationY=");
        if (r11 == null) goto L36;
        boolean r110 = true;
    L37:
        StringBuilder r20 = r14.append(r110).append(", hasCharacterEffect=");
        if (ZeusTransformUtils.instanceOf(r18, com.obric.oui.texteffects.core.j.b.class) == false) goto L40;
        com.obric.oui.texteffects.core.j.b r111 = (com.obric.oui.texteffects.core.j.b) ZeusTransformUtils.preCheckCast(r18, com.obric.oui.texteffects.core.j.b.class, "com.obric.memorydata.plugin");
    L41:
        if (r111 != null) goto L43;
        com.obric.oui.texteffects.core.d r112 = null;
    L44:
        if (r112 != null) goto L47;
        r12 = false;
    L47:
        Log.d(r4, r20.append(r12).toString());
        goto L49
    L43:
        r112 = r111.g();
        goto L44
    L40:
        r111 = null;
        goto L41
    L36:
        r110 = false;
        goto L37
    L32:
        r16 = false;
        goto L33
    L28:
        r15 = false;
    L49:
        String r21 = r18.a();
        if (ZeusTransformUtils.instanceOf(r18, com.obric.oui.texteffects.core.j.a.class) == false) goto L52;
        com.obric.oui.texteffects.core.j.a r0 = (com.obric.oui.texteffects.core.j.a) ZeusTransformUtils.preCheckCast(r18, com.obric.oui.texteffects.core.j.a.class, "com.obric.memorydata.plugin");
    L53:
        if (r0 != null) goto L55;
        String r22 = null;
    L57:
        return new d(r17, r21, r22, r19, r7, r8, r9, r10, r11);
    L55:
        r22 = r0.c();
        goto L57
    L52:
        r0 = null;
        goto L53
    }

    private final void a(int r8, float[] r9, CharacterOrder r10, float r11, float[] r12) {
        if (r8 > 0) goto L4;
        return;
    L4:
        int r1 = 0;
        if (r9 != null) goto L7;
    L11:
        float r13 = r11 / r8;
        int r2 = 0;
    L12:
        if (r2 >= r8) goto L14;
        r12[r2] = (r2 * r13) + (r13 * 0.5f);
        r2 = r2 + 1;
    L14:
        int r14 = b.c[r10.ordinal()];
        if (r14 != 2) goto L17;
    L22:
        if (r1 >= r8) goto L30;
        r12[r1] = RangesKt.coerceIn(r11 - r12[r1], 0.0f, r11);
        r1 = r1 + 1;
        goto L22
    L30:
        return;
    L17:
        if (r14 != 3) goto L24;
        float r15 = r11 * 0.5f;
    L20:
        if (r1 >= r8) goto L29;
        r12[r1] = Math.abs(r12[r1] - r15);
        r1 = r1 + 1;
        goto L20
    L29:
        return;
    L24:
        return;
    L7:
        if (r9.length < r8) goto L11;
        float r3 = 0.0f;
        int r4 = 0;
    L9:
        if (r4 >= r8) goto L14;
        float r5 = RangesKt.coerceAtLeast(r9[r4], 0.0f);
        r12[r4] = (r5 * 0.5f) + r3;
        r3 = r3 + r5;
        r4 = r4 + 1;
        goto L9
    }

    private final void a(a r4, int r5) {
        ArraysKt.fill(r4.d(), 1.0f, 0, r5);
        ArraysKt.fill(r4.e(), 0.0f, 0, r5);
        ArraysKt.fill(r4.f(), 0.0f, 0, r5);
        ArraysKt.fill(r4.g(), 1.0f, 0, r5);
    }

    private final void a(a r6, int r7, float r8, float r9, float r10, float r11, float r12, float r13) {
        float r5 = 0.0f;
        float r14 = RangesKt.coerceIn(r8, 0.0f, 1.0f);
        float r15 = RangesKt.coerceAtLeast(r13, 0.001f);
        boolean r1 = true;
        int r2 = 0;
        if (r9 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L24:
        float r3 = 0.0f;
    L25:
        if (r2 >= r7) goto L27;
        r6.d()[r2] = r14;
        r5 = r5 + r9;
        r6.e()[r2] = r5 + r11;
        r3 = r3 + r10;
        r6.f()[r2] = r3 + r12;
        r6.g()[r2] = r15;
        r2 = r2 + 1;
        goto L25
    L27:
        return;
    L8:
        if (r10 != 0.0f) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L24;
        if (r11 != 0.0f) goto L15;
        boolean r16 = true;
    L16:
        if (r16 == false) goto L24;
        if (r12 == 0.0f) goto L21;
        r1 = false;
    L21:
        if (r1 == false) goto L24;
        ArraysKt.fill(r6.d(), r14, 0, r7);
        ArraysKt.fill(r6.e(), 0.0f, 0, r7);
        ArraysKt.fill(r6.f(), 0.0f, 0, r7);
        ArraysKt.fill(r6.g(), r15, 0, r7);
        return;
    L15:
        r16 = false;
        goto L16
    L10:
        r4 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    private final void a(String r17, com.obric.oui.texteffects.core.j r18, long r19, e r21) {
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r18.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        float r7 = Float.NaN;
        float r8 = Float.NaN;
        com.obric.oui.texteffects.core.m r9 = null;
        com.obric.oui.texteffects.core.m r10 = null;
        com.obric.oui.texteffects.core.m r11 = null;
    L3:
        boolean r12 = true;
        if (r1.hasNext() == false) goto L21;
        t r2 = (t) ZeusTransformUtils.preCheckCast(r1.next(), t.class, "com.obric.memorydata.plugin");
        int r13 = b.f14713a[r2.a().ordinal()];
        if (r13 != 1) goto L8;
        r7 = f14709a.b(r2, r19);
        goto L3
    L8:
        if (r13 != 2) goto L10;
        r8 = f14709a.b(r2, r19);
        goto L3
    L10:
        if (r13 != 3) goto L12;
        r9 = f14709a.a(r2, r19);
        goto L3
    L12:
        if (r13 != 4) goto L14;
        r10 = f14709a.a(r2, r19);
        goto L3
    L14:
        if (r13 != 5) goto L3;
        r11 = f14709a.a(r2, r19);
        goto L3
    L21:
        com.obric.oui.texteffects.a r3 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L49;
        if (com.obric.oui.texteffects.a.b() == false) goto L49;
        String r4 = Intrinsics.stringPlus("OTextEff/frame/", "TimelineSampler");
        StringBuilder r5 = new StringBuilder().append("\tsampleLayerReusable stage=").append(r17).append(", layer=").append(r18.a()).append(", type=").append(r18.getClass().getSimpleName()).append(", stagePlayTime=").append(r19).append(", alpha=").append(r7).append(", visibility=").append(r8).append(", hasBlur=");
        if (r9 == null) goto L28;
        boolean r15 = true;
    L29:
        StringBuilder r6 = r5.append(r15).append(", hasTranslationX=");
        if (r10 == null) goto L32;
        boolean r16 = true;
    L33:
        StringBuilder r14 = r6.append(r16).append(", hasTranslationY=");
        if (r11 == null) goto L36;
        boolean r110 = true;
    L37:
        StringBuilder r20 = r14.append(r110).append(", hasCharacterEffect=");
        if (ZeusTransformUtils.instanceOf(r18, com.obric.oui.texteffects.core.j.b.class) == false) goto L40;
        com.obric.oui.texteffects.core.j.b r111 = (com.obric.oui.texteffects.core.j.b) ZeusTransformUtils.preCheckCast(r18, com.obric.oui.texteffects.core.j.b.class, "com.obric.memorydata.plugin");
    L41:
        if (r111 != null) goto L43;
        com.obric.oui.texteffects.core.d r112 = null;
    L44:
        if (r112 != null) goto L47;
        r12 = false;
    L47:
        Log.d(r4, r20.append(r12).toString());
        goto L49
    L43:
        r112 = r111.g();
        goto L44
    L40:
        r111 = null;
        goto L41
    L36:
        r110 = false;
        goto L37
    L32:
        r16 = false;
        goto L33
    L28:
        r15 = false;
    L49:
        String r22 = r18.a();
        if (ZeusTransformUtils.instanceOf(r18, com.obric.oui.texteffects.core.j.a.class) == false) goto L52;
        com.obric.oui.texteffects.core.j.a r0 = (com.obric.oui.texteffects.core.j.a) ZeusTransformUtils.preCheckCast(r18, com.obric.oui.texteffects.core.j.a.class, "com.obric.memorydata.plugin");
    L53:
        if (r0 != null) goto L55;
        String r23 = null;
    L56:
        r21.a(r17, r22, r23, r19, r7, r8, r9, r10, r11);
        return;
    L55:
        r23 = r0.c();
        goto L56
    L52:
        r0 = null;
        goto L53
    }

    private final boolean a(com.obric.oui.texteffects.core.b r4) {
        com.obric.oui.texteffects.core.f r0 = r4.b();
        boolean r2 = false;
        if (r0 != null) goto L5;
        com.obric.oui.texteffects.core.c r5 = r4.a();
        if (r5 != null) goto L13;
        return false;
    L13:
        if (b(r5.a()) == false) goto L18;
        if (b(r5.b()) == false) goto L18;
        return false;
    L18:
        return !Intrinsics.areEqual(r5.a(), r5.b());
    L5:
        if (r0.a() != r0.b()) goto L8;
        r2 = true;
    L8:
        return !r2;
    }

    private final boolean a(com.obric.oui.texteffects.core.e r1) {
        if (r1.a().a() != r1.a().b()) goto L5;
        boolean r0 = true;
    L7:
        return !r0;
    L5:
        r0 = false;
        goto L7
    }

    private final boolean a(com.obric.oui.texteffects.core.m r1) {
        if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.texteffects.core.m.b.class) == false) goto L5;
    L18:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.texteffects.core.m.a.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.texteffects.core.m.e.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.texteffects.core.m.d.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.texteffects.core.m.g.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.texteffects.core.m.f.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.texteffects.core.m.c.class) == true) goto L18;
        return false;
    }

    private final float b(com.obric.oui.texteffects.core.b r9, float r10, float r11, float r12) {
        com.obric.oui.texteffects.core.f r0 = r9.b();
        if (r0 != null) goto L5;
        com.obric.oui.texteffects.core.c r13 = r9.a();
        if (r13 != null) goto L11;
        return 0.0f;
    L11:
        return a(this, r13.b(), r13.c(), r10, 0.0f, r11, 4, null);
    L5:
        return a(r0.b(), r0.c(), r11) * r12;
    }

    private final float b(com.obric.oui.texteffects.core.e r2, float r3) {
        return a(r2.a().b(), r2.a().c(), r3);
    }

    private final float b(com.obric.oui.texteffects.core.m r2, float r3) {
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.texteffects.core.m.a.class) == false) goto L6;
        return ((com.obric.oui.texteffects.core.m.a) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.texteffects.core.m.a.class, "com.obric.memorydata.plugin")).a() * r3;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.texteffects.core.m.b.class) == true) goto L11;
        return 0.0f;
    L11:
        return ((com.obric.oui.texteffects.core.m.b) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.texteffects.core.m.b.class, "com.obric.memorydata.plugin")).a();
    }

    private final float b(t r9, long r10) {
        List<q> r0 = r9.b();
        if (r0.isEmpty() == false) goto L6;
        return 0.0f;
    L6:
        if (r10 > ((q) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r0), q.class, "com.obric.memorydata.plugin")).a()) goto L10;
        return a(((q) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r0), q.class, "com.obric.memorydata.plugin")).b(), 0.0f);
    L10:
        if (r10 >= ((q) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r0), q.class, "com.obric.memorydata.plugin")).a()) goto L12;
        int r1 = a(r0, r10);
        q r3 = (q) ZeusTransformUtils.preCheckCast(r0.get(r1 - 1), q.class, "com.obric.memorydata.plugin");
        q r2 = (q) ZeusTransformUtils.preCheckCast(r0.get(r1), q.class, "com.obric.memorydata.plugin");
        return a(a(r3.b(), 0.0f), a(r2.b(), a(r3.b(), 0.0f)), a(r9.c(), RangesKt.coerceIn((r10 - r3.a()) / RangesKt.coerceAtLeast(r2.a() - r3.a(), 1), 0.0f, 1.0f)));
    L12:
        return a(((q) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r0), q.class, "com.obric.memorydata.plugin")).b(), 0.0f);
    }

    private final long b(u r11, long r12) {
        long r8 = RangesKt.coerceAtLeast(r11.b(), 1);
        r r0 = r11.c();
        if (Intrinsics.areEqual(r0, r.b.f14634a) == false) goto L6;
        return a(r12, r8);
    L6:
        if (ZeusTransformUtils.instanceOf(r0, r.a.class) == false) goto L12;
        if (r12 < (((long) RangesKt.coerceAtLeast(((r.a) ZeusTransformUtils.preCheckCast(r11.c(), r.a.class, "com.obric.memorydata.plugin")).a(), 1)) * r8)) goto L18;
        return r8;
    L18:
        return a(RangesKt.coerceAtLeast(r12, 0), r8);
    L12:
        if (Intrinsics.areEqual(r0, r.c.f14635a) == false) goto L16;
        return RangesKt.coerceIn(r12, 0, r8);
    L16:
        throw new NoWhenBranchMatchedException();
    }

    private final boolean b(com.obric.oui.texteffects.core.b r4) {
        com.obric.oui.texteffects.core.f r0 = r4.b();
        if (r0 != null) goto L5;
        com.obric.oui.texteffects.core.c r5 = r4.a();
        if (r5 != null) goto L20;
        return true;
    L20:
        if (b(r5.a()) == true) goto L22;
        return false;
    L22:
        if (b(r5.b()) == true) goto L24;
        return false;
    L24:
        return true;
    L5:
        if (r0.a() != 0.0f) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L10;
        return false;
    L10:
        if (r0.b() != 0.0f) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L15;
        return false;
    L15:
        return true;
    L12:
        r6 = false;
        goto L13
    L7:
        r3 = false;
        goto L8
    }

    private final boolean b(com.obric.oui.texteffects.core.e r4) {
        if (r4.a().c() != CharacterRangeUnit.Absolute) goto L16;
        if (r4.a().a() != 1.0f) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L16;
        if (r4.a().b() != 1.0f) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L16;
        return true;
    L12:
        r5 = false;
        goto L13
    L7:
        r3 = false;
    L16:
        return false;
    }

    private final boolean b(com.obric.oui.texteffects.core.m r5) {
        if (ZeusTransformUtils.instanceOf(r5, com.obric.oui.texteffects.core.m.a.class) == false) goto L8;
        if (((com.obric.oui.texteffects.core.m.a) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.texteffects.core.m.a.class, "com.obric.memorydata.plugin")).a() != 0.0f) goto L13;
        return true;
    L13:
        return false;
    L8:
        if (ZeusTransformUtils.instanceOf(r5, com.obric.oui.texteffects.core.m.b.class) == false) goto L13;
        if (((com.obric.oui.texteffects.core.m.b) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.texteffects.core.m.b.class, "com.obric.memorydata.plugin")).a() != 0.0f) goto L13;
        return true;
    }

    private final float c(com.obric.oui.texteffects.core.b r11, float r12, float r13, float r14) {
        com.obric.oui.texteffects.core.f r0 = r11.b();
        if (r0 == null) goto L15;
        boolean r3 = true;
        if (r0.a() != 0.0f) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L15;
        if (r0.b() == 0.0f) goto L13;
        r3 = false;
    L13:
        if (r3 == false) goto L15;
        return 0.0f;
    L7:
        r2 = false;
    L15:
        if (r0 != null) goto L17;
        com.obric.oui.texteffects.core.c r15 = r11.a();
        if (r15 != null) goto L22;
        return 0.0f;
    L22:
        if (b(r15.a()) == false) goto L27;
        if (b(r15.b()) == false) goto L27;
        return 0.0f;
    L27:
        return a(this, r15.a(), r15.c(), r12, 0.0f, r13, 4, null);
    L17:
        return a(r0.a(), r0.c(), r13) * r14;
    }

    public final float a(com.obric.oui.texteffects.core.a r8, long r9, float r11) {
        Intrinsics.checkNotNullParameter(r8, "spec");
        List<q> r0 = r8.a();
        if (r0.isEmpty() == false) goto L6;
        return r11;
    L6:
        if (r9 > ((q) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r0), q.class, "com.obric.memorydata.plugin")).a()) goto L10;
        return a(((q) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r0), q.class, "com.obric.memorydata.plugin")).b(), r11);
    L10:
        if (r9 >= ((q) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r0), q.class, "com.obric.memorydata.plugin")).a()) goto L12;
        int r1 = a(r0, r9);
        q r2 = (q) ZeusTransformUtils.preCheckCast(r0.get(r1 - 1), q.class, "com.obric.memorydata.plugin");
        q r3 = (q) ZeusTransformUtils.preCheckCast(r0.get(r1), q.class, "com.obric.memorydata.plugin");
        return a(a(r2.b(), r11), a(r3.b(), r11), a(r8.b(), RangesKt.coerceIn((r9 - r2.a()) / RangesKt.coerceAtLeast(r3.a() - r2.a(), 1), 0.0f, 1.0f)));
    L12:
        return a(((q) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r0), q.class, "com.obric.memorydata.plugin")).b(), r11);
    }

    public final f a(u r22, long r23, f r25) {
        Intrinsics.checkNotNullParameter(r22, "spec");
        Intrinsics.checkNotNullParameter(r25, "out");
        long r5 = b(r22, r23);
        r25.a(r23, r5);
        Iterator<com.obric.oui.texteffects.core.l> r3 = r22.d().iterator();
    L4:
        if (r3.hasNext() == false) goto L22;
        com.obric.oui.texteffects.core.l r7 = (com.obric.oui.texteffects.core.l) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.oui.texteffects.core.l.class, "com.obric.memorydata.plugin");
        long r13 = r5 - r7.b();
        if (r13 < 0) goto L4;
        if (r13 > r7.c()) goto L4;
        com.obric.oui.texteffects.a r11 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == true) goto L13;
    L15:
        Iterator<com.obric.oui.texteffects.core.k> r8 = r7.e().iterator();
    L17:
        if (r8.hasNext() == false) goto L4;
        Iterator<com.obric.oui.texteffects.core.j> r9 = ((com.obric.oui.texteffects.core.k) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.oui.texteffects.core.k.class, "com.obric.memorydata.plugin")).b().iterator();
    L20:
        if (r9.hasNext() == false) goto L17;
        f14709a.a(r7.a(), (com.obric.oui.texteffects.core.j) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.oui.texteffects.core.j.class, "com.obric.memorydata.plugin"), r13, r25.c());
        goto L20
    L13:
        if (com.obric.oui.texteffects.a.b() == false) goto L15;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", "TimelineSampler"), "stageReusable hit spec=" + r22.a() + ", stage=" + r7.a() + ", playTime=" + r23 + ", stagePlayTime=" + r13 + ", duration=" + r7.c());
        goto L15
    L22:
        com.obric.oui.texteffects.a r4 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == true) goto L25;
    L27:
        return r25;
    L25:
        if (com.obric.oui.texteffects.a.b() == false) goto L27;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", "TimelineSampler"), "#sampleReusable spec=" + r22.a() + ", playTime=" + r23 + ", normalized=" + r5 + ", activeLayers=" + r25.b());
        goto L27
    }

    public final h a(u r17, long r18) {
        long r1 = r18;
        Intrinsics.checkNotNullParameter(r17, "spec");
        long r4 = b(r17, r18);
        ArrayList r0 = new ArrayList(a(r17));
        com.obric.oui.texteffects.a r6 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == true) goto L5;
    L7:
        Iterator<com.obric.oui.texteffects.core.l> r7 = r17.d().iterator();
    L9:
        if (r7.hasNext() == false) goto L29;
        com.obric.oui.texteffects.core.l r10 = (com.obric.oui.texteffects.core.l) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.oui.texteffects.core.l.class, "com.obric.memorydata.plugin");
        long r12 = r4 - r10.b();
        if (r12 < 0) goto L27;
        if (r12 > r10.c()) goto L9;
        com.obric.oui.texteffects.a r14 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == true) goto L18;
    L20:
        Iterator<com.obric.oui.texteffects.core.k> r2 = r10.e().iterator();
    L22:
        if (r2.hasNext() == false) goto L27;
        Iterator<com.obric.oui.texteffects.core.j> r3 = ((com.obric.oui.texteffects.core.k) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.oui.texteffects.core.k.class, "com.obric.memorydata.plugin")).b().iterator();
    L25:
        if (r3.hasNext() == false) goto L22;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).add(f14709a.a(r10.a(), (com.obric.oui.texteffects.core.j) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.oui.texteffects.core.j.class, "com.obric.memorydata.plugin"), r12));
        r2 = r2;
        goto L25
    L18:
        if (com.obric.oui.texteffects.a.b() == false) goto L20;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", "TimelineSampler"), "\tstage hit spec=" + r17.a() + ", stage=" + r10.a() + ", playTime=" + r1 + ", stagePlayTime=" + r12 + ", duration=" + r10.c());
    L27:
        r1 = r18;
        goto L9
    L29:
        return new h(r18, r4, (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"));
    L5:
        if (com.obric.oui.texteffects.a.b() == false) goto L7;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", "TimelineSampler"), "sample spec=" + r17.a() + ", playTime=" + r1 + ", activeLayers=" + r0.size() + ", normalized=" + r4);
        goto L7
    }

    public final a a(com.obric.oui.texteffects.core.d r51, long r52, int r54, float r55, float r56, float[] r57, float r58, a r59) {
        Intrinsics.checkNotNullParameter(r51, "spec");
        Intrinsics.checkNotNullParameter(r59, "out");
        r59.b(r54);
        if (r54 > 0) goto L5;
        return r59;
    L5:
        long r9 = RangesKt.coerceAtLeast(r51.b(), 1);
        long r4 = RangesKt.coerceIn(r52 - r51.a(), 0, r9);
        com.obric.oui.texteffects.a r2 = com.obric.oui.texteffects.a.f14578a;
        String r8 = "OTextEff/frame/";
        if (com.obric.oui.texteffects.a.a() == false) goto L11;
        if (com.obric.oui.texteffects.a.b() == false) goto L11;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", "TimelineSampler"), "sampleCharacterEffect count=" + r54 + ", stagePlayTime=" + r52 + ", localTime=" + r4 + ", duration=" + r9 + ", order=" + r51.c() + ", textWidth=" + r56);
    L11:
        boolean r18 = a(r51.d());
        boolean r19 = a(r51.e());
        boolean r20 = a(r51.f());
        boolean r21 = a(r51.g());
        boolean r22 = a(r51.h());
        boolean r23 = a(r51.i());
        ArraysKt.fill(r59.b(), a(r51.d().b(), r4, r9), 0, r54);
        if (r18 == true) goto L20;
        if (r19 == true) goto L20;
        if (r20 == true) goto L20;
        if (r21 == true) goto L20;
        if (r22 == true) goto L20;
        if (r23 == true) goto L20;
        boolean r0 = false;
    L21:
        float r10 = 1.0f;
        if (r0 == true) goto L40;
        if (b(r51.d()) == true) goto L26;
    L37:
        a(r59, r54, a(r51.d(), r56, 1.0f), c(r51.e(), r55, r56, r58), c(r51.f(), r55, r56, r58), c(r51.g(), r55, r56, r58), c(r51.h(), r55, r56, r58), a(r51.i(), r56, 1.0f));
        return r59;
    L26:
        if (b(r51.e()) == false) goto L37;
        if (b(r51.f()) == false) goto L37;
        if (b(r51.g()) == false) goto L37;
        if (b(r51.h()) == false) goto L37;
        if (b(r51.i()) == false) goto L37;
        a(r59, r54);
        return r59;
    L40:
        if (r18 == false) goto L42;
        float r27 = a(r51.d(), r56);
    L43:
        if (r18 == false) goto L45;
        float r28 = b(r51.d(), r56);
    L46:
        if (r18 == false) goto L48;
        float r29 = 0.0f;
    L49:
        com.obric.oui.texteffects.core.b r1 = r51.e();
        if (r19 == false) goto L52;
        float r3 = a(r1, r55, r56, r58);
    L53:
        float r30 = r3;
        if (r19 == false) goto L56;
        float r31 = b(r51.e(), r55, r56, r58);
    L57:
        com.obric.oui.texteffects.core.b r5 = r51.f();
        if (r20 == false) goto L60;
        float r6 = a(r5, r55, r56, r58);
    L61:
        float r32 = r6;
        if (r20 == false) goto L64;
        float r33 = b(r51.f(), r55, r56, r58);
    L65:
        com.obric.oui.texteffects.core.b r7 = r51.g();
        if (r21 == false) goto L68;
        float r11 = a(r7, r55, r56, r58);
    L69:
        float r34 = r11;
        if (r21 == false) goto L72;
        float r35 = b(r51.g(), r55, r56, r58);
    L73:
        com.obric.oui.texteffects.core.b r12 = r51.h();
        if (r22 == false) goto L76;
        float r13 = a(r12, r55, r56, r58);
    L77:
        float r36 = r13;
        if (r22 == false) goto L80;
        float r37 = b(r51.h(), r55, r56, r58);
    L81:
        if (r23 == false) goto L83;
        float r38 = a(r51.i(), r56);
    L84:
        if (r23 == false) goto L86;
        float r39 = b(r51.i(), r56);
    L88:
        if (r23 == false) goto L90;
        float r40 = 0.0f;
    L91:
        boolean r14 = false;
        a(r54, r57, r51.c(), r56, r59.c());
        float r42 = 0.0f;
        int r15 = 0;
        float r41 = 0.0f;
    L92:
        if (r15 >= r54) goto L116;
        int r43 = r15 + 1;
        float r44 = r59.c()[r15];
        float[] r45 = r59.d();
        if (r18 == false) goto L96;
        float r16 = r10;
        boolean r17 = false;
        float r24 = RangesKt.coerceIn(a(r27, r28, r51.d().b(), r51.d().c(), r4, r9, r44, r56), 0.0f, r16);
    L97:
        r45[r15] = r24;
        if (r19 == false) goto L100;
        float r46 = a(r15, r30, r31, r51.e().c(), r51.e().d(), r4, r9, r44, r56);
    L101:
        if (r21 == false) goto L103;
        float r25 = a(r15, r34, r35, r51.g().c(), r51.g().d(), r4, r9, r44, r56);
    L104:
        r41 = r41 + r46;
        r59.e()[r15] = r41 + r25;
        if (r20 == false) goto L107;
        float r47 = a(r15, r32, r33, r51.f().c(), r51.f().d(), r4, r9, r44, r56);
    L108:
        if (r22 == false) goto L110;
        float r26 = a(r15, r36, r37, r51.h().c(), r51.h().d(), r4, r9, r44, r56);
    L111:
        r42 = r42 + r47;
        r59.f()[r15] = r42 + r26;
        float[] r110 = r59.g();
        if (r23 == false) goto L114;
        float r48 = a(r38, r39, r51.i().b(), r51.i().c(), r4, r9, r44, r56);
        char r49 = 4719;
        float r50 = RangesKt.coerceAtLeast(r48, 0.001f);
    L115:
        r110[r15] = r50;
        r10 = r16;
        r14 = r17;
        r15 = r43;
        r8 = r8;
        r9 = r9;
        goto L92
    L114:
        r49 = 4719;
        r50 = r40;
        goto L115
    L110:
        r26 = r36;
        goto L111
    L107:
        r47 = r32;
        goto L108
    L103:
        r25 = r34;
        goto L104
    L100:
        r46 = r30;
        goto L101
    L96:
        r17 = r14;
        r16 = r10;
        r24 = r29;
        goto L97
    L116:
        String r410 = r8;
        com.obric.oui.texteffects.a r53 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == true) goto L119;
    L121:
        return r59;
    L119:
        if (com.obric.oui.texteffects.a.b() == false) goto L121;
        int r60 = r54 - 1;
        Log.d(Intrinsics.stringPlus(r410, "TimelineSampler"), "\t\tsampleCharacterEffect done count=" + r54 + ", firstAlpha=" + ArraysKt.firstOrNull(r59.d()) + ", lastAlpha=" + ArraysKt.getOrNull(r59.d(), r60) + ", firstTx=" + ArraysKt.firstOrNull(r59.e()) + ", lastTx=" + ArraysKt.getOrNull(r59.e(), r60) + ", firstScale=" + ArraysKt.firstOrNull(r59.g()) + ", lastScale=" + ArraysKt.getOrNull(r59.g(), r60));
        goto L121
    L90:
        r40 = RangesKt.coerceAtLeast(a(r51.i(), r56, 1.0f), 0.001f);
        goto L91
    L86:
        r39 = 0.0f;
        goto L88
    L83:
        r38 = 0.0f;
        goto L84
    L80:
        r37 = 0.0f;
        goto L81
    L76:
        r13 = c(r12, r55, r56, r58);
        goto L77
    L72:
        r35 = 0.0f;
        goto L73
    L68:
        r11 = c(r7, r55, r56, r58);
        goto L69
    L64:
        r33 = 0.0f;
        goto L65
    L60:
        r6 = c(r5, r55, r56, r58);
        goto L61
    L56:
        r31 = 0.0f;
        goto L57
    L52:
        r3 = c(r1, r55, r56, r58);
        goto L53
    L48:
        r29 = RangesKt.coerceIn(a(r51.d(), r56, 1.0f), 0.0f, 1.0f);
        goto L49
    L45:
        r28 = 0.0f;
        goto L46
    L42:
        r27 = 0.0f;
    L20:
        r0 = true;
        goto L21
    }
}
