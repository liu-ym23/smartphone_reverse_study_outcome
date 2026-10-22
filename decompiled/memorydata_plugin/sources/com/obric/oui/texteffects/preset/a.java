package com.obric.oui.texteffects.preset;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.oui.texteffects.core.BlendSpec;
import com.obric.oui.texteffects.core.CharacterOrder;
import com.obric.oui.texteffects.core.CharacterRangeUnit;
import com.obric.oui.texteffects.core.Direction;
import com.obric.oui.texteffects.core.EffectProperty;
import com.obric.oui.texteffects.core.GradientBlurCurveType;
import com.obric.oui.texteffects.core.TextSource;
import com.obric.oui.texteffects.core.d;
import com.obric.oui.texteffects.core.f;
import com.obric.oui.texteffects.core.g;
import com.obric.oui.texteffects.core.h;
import com.obric.oui.texteffects.core.i;
import com.obric.oui.texteffects.core.j;
import com.obric.oui.texteffects.core.k;
import com.obric.oui.texteffects.core.l;
import com.obric.oui.texteffects.core.m;
import com.obric.oui.texteffects.core.n;
import com.obric.oui.texteffects.core.o;
import com.obric.oui.texteffects.core.p;
import com.obric.oui.texteffects.core.q;
import com.obric.oui.texteffects.core.r;
import com.obric.oui.texteffects.core.s;
import com.obric.oui.texteffects.core.t;
import com.obric.oui.texteffects.core.u;
import com.ss.bduploader.UploadKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002JC\u0010\u0012\u001a\u00020\u00132*\u0010\u0014\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u0015\"\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001bJC\u0010\u001c\u001a\u00020\u001d2*\u0010\u0014\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u0015\"\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001eJ)\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u000f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0015H\u0002¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002JI\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\u001a2*\u0010\u0014\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u0015\"\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0002¢\u0006\u0002\u0010,J,\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00172\b\b\u0002\u00101\u001a\u00020\u00182\b\b\u0002\u00102\u001a\u00020\u0018H\u0002J,\u00103\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00172\b\b\u0002\u00101\u001a\u00020\u00182\b\b\u0002\u00102\u001a\u00020\u0018H\u0002JI\u00104\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\u001a2*\u0010\u0014\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u0015\"\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0002¢\u0006\u0002\u0010,J\u0010\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u000208J;\u00109\u001a\u00020:2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010;\u001a\u00020\u00112\u001a\b\u0002\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u0015H\u0002¢\u0006\u0002\u0010=J_\u0010>\u001a\u00020?2*\u0010\u0014\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u0015\"\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010;\u001a\u00020\u00112\b\b\u0002\u0010@\u001a\u00020\u001a2\b\b\u0002\u0010A\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010BJV\u0010C\u001a\u00020.2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u00182\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\b\b\u0002\u0010H\u001a\u00020\u001aH\u0002J\u0010\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0002J\u0006\u0010L\u001a\u000206J\b\u0010M\u001a\u00020\u001dH\u0002J\b\u0010N\u001a\u00020\u001dH\u0002J\u0006\u0010O\u001a\u000206J\u0006\u0010P\u001a\u000206J9\u0010Q\u001a\u00020R2*\u0010\u0014\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u0015\"\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0002¢\u0006\u0002\u0010SJ\u001a\u0010T\u001a\u0002062\b\b\u0002\u0010U\u001a\u0002082\b\b\u0002\u0010V\u001a\u00020\u0018JT\u0010W\u001a\u00020X2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020Z2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010\\\u001a\u00020]2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010_2\b\b\u0002\u0010`\u001a\u00020a2\u000e\b\u0002\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001d0 H\u0002J\u0010\u0010c\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/obric/oui/texteffects/preset/DimPointEffectSpecFactory;", "", "()V", "IdPrefix", "", "easeInOutEasing", "Lcom/obric/oui/texteffects/core/EasingSpec$CubicBezier;", "easeInQuadEasing", "exitEffectEasing", "gradientOpacityEnterShapeEasing", "Lcom/obric/oui/texteffects/core/EasingSpec$AeShape;", "gradientOpacityExitShapeEasing", "positionShapeEasing", "trackingShapeEasing", "alphaRampColors", "", "direction", "Lcom/obric/oui/texteffects/core/Direction;", "animatedFloat", "Lcom/obric/oui/texteffects/core/AnimatedFloatSpec;", "frames", "", "Lkotlin/Pair;", "", "", "easing", "Lcom/obric/oui/texteffects/core/EasingSpec;", "([Lkotlin/Pair;Lcom/obric/oui/texteffects/core/EasingSpec;)Lcom/obric/oui/texteffects/core/AnimatedFloatSpec;", "blurTrack", "Lcom/obric/oui/texteffects/core/PropertyTrack;", "([Lkotlin/Pair;Lcom/obric/oui/texteffects/core/EasingSpec;)Lcom/obric/oui/texteffects/core/PropertyTrack;", "buildGradientLayers", "", "Lcom/obric/oui/texteffects/core/GradientLayerSpec;", "colors", "positionsByLayer", "", "([I[[F)Ljava/util/List;", "characterEnterEffect", "Lcom/obric/oui/texteffects/core/CharacterEffectSpec;", "characterExitEffect", "dpTrack", "property", "Lcom/obric/oui/texteffects/core/EffectProperty;", "(Lcom/obric/oui/texteffects/core/EffectProperty;Lcom/obric/oui/texteffects/core/EasingSpec;[Lkotlin/Pair;)Lcom/obric/oui/texteffects/core/PropertyTrack;", "enterIndicatorLayer", "Lcom/obric/oui/texteffects/core/EffectLayer$ExternalView;", "startMs", "durationMs", "fromRatio", "toRatio", "exitIndicatorLayer", "floatTrack", "generate", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "includeEnterIndicator", "", "gradientColorFill", "Lcom/obric/oui/texteffects/core/FillSpec$GradientGroup;", "gradientAlphaDirection", "groupAlphaFrames", "(Lcom/obric/oui/texteffects/core/Direction;Lcom/obric/oui/texteffects/core/Direction;[Lkotlin/Pair;)Lcom/obric/oui/texteffects/core/FillSpec$GradientGroup;", "gradientOpacityMask", "Lcom/obric/oui/texteffects/core/MaskSpec$ShapeMappedLinearGradient;", "motionEasing", "shapeEasing", "([Lkotlin/Pair;Lcom/obric/oui/texteffects/core/Direction;Lcom/obric/oui/texteffects/core/Direction;Lcom/obric/oui/texteffects/core/EasingSpec;Lcom/obric/oui/texteffects/core/EasingSpec;)Lcom/obric/oui/texteffects/core/MaskSpec$ShapeMappedLinearGradient;", "indicatorLayer", OaidModel.KEY_ID, "bindingKey", "gradientBlurConfig", "Lcom/obric/oui/texteffects/core/GradientBlurLayerSpec;", "easingSpec", "opaque", "", TypedValues.Custom.S_COLOR, "pending", "promptFadeInAlphaTrack", "promptFadeOutAlphaTrack", "promptPendingExit", "promptTextSwitch", "resolveScanFillConfig", "Lcom/obric/oui/texteffects/preset/DimPointEffectSpecFactory$ScanFillConfig;", "([Lkotlin/Pair;)Lcom/obric/oui/texteffects/preset/DimPointEffectSpecFactory$ScanFillConfig;", "rewrite", "includeIndicators", "oldGradientAlpha", "textLayer", "Lcom/obric/oui/texteffects/core/EffectLayer$Text;", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/oui/texteffects/core/TextSource;", "characterEffect", "fill", "Lcom/obric/oui/texteffects/core/FillSpec;", "mask", "Lcom/obric/oui/texteffects/core/MaskSpec;", "blend", "Lcom/obric/oui/texteffects/core/BlendSpec;", "properties", "transparent", "ScanFillConfig", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14644a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final i.b f14645b = null;
    private static final i.b c = null;
    private static final i.b d = null;
    private static final i.a e = null;
    private static final i.a f = null;
    private static final i.a g = null;
    private static final i.a h = null;

    /* JADX INFO: renamed from: com.obric.oui.texteffects.preset.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/texteffects/preset/DimPointEffectSpecFactory$ScanFillConfig;", "", "startOffsetRatio", "", "endOffsetRatio", "delayMs", "", "durationMs", "(FFJJ)V", "getDelayMs", "()J", "getDurationMs", "getEndOffsetRatio", "()F", "getStartOffsetRatio", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class C0782a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f14646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f14647b;
        private final long c;
        private final long d;

        public C0782a(float r1, float r2, long r3, long r5) {
            this.f14646a = r1;
            this.f14647b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final float a() {
            return this.f14646a;
        }

        public final float b() {
            return this.f14647b;
        }

        public final long c() {
            return this.c;
        }

        public final long d() {
            return this.d;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, C0782a.class) == true) goto L8;
            return false;
        L8:
            C0782a r10 = (C0782a) ZeusTransformUtils.preCheckCast(r9, C0782a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(Float.valueOf(this.f14646a), Float.valueOf(r10.f14646a)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.f14647b), Float.valueOf(r10.f14647b)) == true) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.f14646a) * 31) + Float.hashCode(this.f14647b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d);
        }

        public String toString() {
            return "ScanFillConfig(startOffsetRatio=" + this.f14646a + ", endOffsetRatio=" + this.f14647b + ", delayMs=" + this.c + ", durationMs=" + this.d + ')';
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14648a = null;

        static {
            int[] r0 = new int[Direction.values().length];
            r0[Direction.RightToLeft.ordinal()] = 1;
            f14648a = r0;
        }
    }

    static {
        f14644a = new a();
        f14645b = new i.b(0.33f, 0.0f, 0.67f, 1.0f);
        c = new i.b(0.42f, 0.0f, 0.58f, 1.0f);
        d = new i.b(0.26f, 0.0f, 0.6f, 0.2f);
        e = new i.a(0, 0.0f, 0.0f, 1, null);
        f = new i.a(0, 0.2f, 0.0f, 1, null);
        g = new i.a(0, 0.0f, 0.3f, 1, null);
        h = new i.a(0, 0.0f, 0.0f, 1, null);
    }

    private a() {
    }

    private final int a(int r1) {
        return 16777215 & r1;
    }

    private final com.obric.oui.texteffects.core.a a(Pair<Long, Float>[] r10, i r11) {
        int r0 = 0;
        if (r10.length != 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == true) goto L8;
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r10.length), Collection.class, "com.obric.memorydata.plugin");
        int r1 = r10.length;
    L10:
        if (r0 >= r1) goto L13;
        Pair<Long, Float> r3 = r10[r0];
        r12.add(new q(((Number) ZeusTransformUtils.preCheckCast(r3.getFirst(), Number.class, "com.obric.memorydata.plugin")).longValue(), (m) ZeusTransformUtils.preCheckCast(new m.b(((Number) ZeusTransformUtils.preCheckCast(r3.getSecond(), Number.class, "com.obric.memorydata.plugin")).floatValue()), m.class, "com.obric.memorydata.plugin")));
        r0 = r0 + 1;
        goto L10
    L13:
        return new com.obric.oui.texteffects.core.a((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), r11);
    L8:
        return com.obric.oui.texteffects.core.a.f14583a.a(1.0f);
    L5:
        r9 = false;
        goto L6
    }

    private final j.a a(long r14, long r16, float r18, float r19) {
        return a("enter_indicator", "enterScanIndicator", Direction.LeftToRight, r14, r16, r18, r19, new o(null, Direction.LeftToRight, GradientBlurCurveType.InOutQuad, 0.4f, Float.valueOf(0.8889f), 1, null), (i) ZeusTransformUtils.preCheckCast(c, i.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ j.a a(a r7, long r8, long r10, float r12, float r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r12 = -0.4f;
    L5:
        float r5 = r12;
        if ((r14 & 8) == 0) goto L9;
        r13 = 1.0f;
    L9:
        return r7.a(r8, r10, r5, r13);
    }

    private final j.a a(String r17, String r18, Direction r19, long r20, long r22, float r24, float r25, o r26, i r27) {
        m.g r2 = new m.g(r24);
        m.g r3 = new m.g(r25);
        List r4 = CollectionsKt.createListBuilder();
        if (r20 <= 0) goto L5;
        r4.add(new q(0, (m) ZeusTransformUtils.preCheckCast(new m.b(0.0f), m.class, "com.obric.memorydata.plugin")));
        r4.add(new q(r20, (m) ZeusTransformUtils.preCheckCast(new m.b(0.0f), m.class, "com.obric.memorydata.plugin")));
    L5:
        r4.add(new q(r20, (m) ZeusTransformUtils.preCheckCast(new m.b(1.0f), m.class, "com.obric.memorydata.plugin")));
        long r11 = r20 + r22;
        r4.add(new q(r11 - 1, (m) ZeusTransformUtils.preCheckCast(new m.b(0.0f), m.class, "com.obric.memorydata.plugin")));
        List r5 = CollectionsKt.build(r4);
        List r8 = CollectionsKt.createListBuilder();
        if (r20 <= 0) goto L8;
        r8.add(new q(0, (m) ZeusTransformUtils.preCheckCast(r2, m.class, "com.obric.memorydata.plugin")));
    L8:
        r8.add(new q(r20, (m) ZeusTransformUtils.preCheckCast(r2, m.class, "com.obric.memorydata.plugin")));
        r8.add(new q(r11, (m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.memorydata.plugin")));
        return new j.a(r17, r18, r26, CollectionsKt.listOf(new t[]{new t(EffectProperty.Visibility, r5, (i) ZeusTransformUtils.preCheckCast(i.c.f14603a, i.class, "com.obric.memorydata.plugin")), new t(EffectProperty.TranslationX, CollectionsKt.build(r8), r27)}));
    }

    static /* synthetic */ j.b a(a r12, String r13, TextSource r14, d r15, n r16, s r17, BlendSpec r18, List r19, int r20, Object r21) {
        List<t> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        if ((r20 & 4) == 0) goto L5;
        d r7 = null;
    L7:
        if ((r20 & 8) == 0) goto L9;
        n r8 = (n) ZeusTransformUtils.preCheckCast(n.d.f14626a, n.class, "com.obric.memorydata.plugin");
    L11:
        if ((r20 & 16) == 0) goto L13;
        s r9 = null;
    L15:
        if ((r20 & 32) == 0) goto L17;
        BlendSpec r10 = BlendSpec.SRC_OVER;
    L19:
        if ((r20 & 64) == 0) goto L22;
        r0 = CollectionsKt.emptyList();
    L22:
        return r12.a(r13, r14, r7, r8, r9, r10, r0);
    L17:
        r10 = r18;
        goto L19
    L13:
        r9 = r17;
        goto L15
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r15;
        goto L7
    }

    private final j.b a(String r9, TextSource r10, d r11, n r12, s r13, BlendSpec r14, List<t> r15) {
        return new j.b(r9, r10, r12, r13, r14, r11, (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin"));
    }

    private final n.a a(Direction r5, Direction r6, Pair<Long, Float>[] r7) {
        if (b.f14648a[r6.ordinal()] != 1) goto L5;
        int[] r0 = com.obric.oui.texteffects.preset.b.f14649a.a();
        int[] r1 = Arrays.copyOf(r0, r0.length);
        Intrinsics.checkNotNullExpressionValue(r1, "copyOf(this, size)");
        ArraysKt.reverse(r1);
    L7:
        if (b.f14648a[r6.ordinal()] != 1) goto L9;
        Object[] r8 = (Object[]) ZeusTransformUtils.preCheckCast(com.obric.oui.texteffects.preset.b.f14649a.b(), Object[].class, "com.obric.memorydata.plugin");
        Object[] r9 = Arrays.copyOf(r8, r8.length);
        Intrinsics.checkNotNullExpressionValue(r9, "copyOf(this, size)");
        ArraysKt.reverse((Object[]) ZeusTransformUtils.preCheckCast((float[][]) ZeusTransformUtils.preCheckCast(r9, float[][].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"));
        float[][] r10 = (float[][]) ZeusTransformUtils.preCheckCast(r9, float[][].class, "com.obric.memorydata.plugin");
    L11:
        return new n.a(a(r1, r10), a((Pair[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r7, r7.length), Pair[].class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.preCheckCast(c, i.class, "com.obric.memorydata.plugin")));
    L9:
        r10 = com.obric.oui.texteffects.preset.b.f14649a.b();
        goto L11
    L5:
        r1 = com.obric.oui.texteffects.preset.b.f14649a.a();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ n.a a(a r0, Direction r1, Direction r2, Pair[] r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = r1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = (Pair[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(new Pair[0], Object[].class, "com.obric.memorydata.plugin"), Pair[].class, "com.obric.memorydata.plugin");
    L9:
        return r0.a(r1, r2, r3);
    }

    static /* synthetic */ s.a a(a r6, Pair[] r7, Direction r8, Direction r9, i r10, i r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        Direction r3 = r8;
    L7:
        if ((r12 & 8) == 0) goto L9;
        r10 = (i) ZeusTransformUtils.preCheckCast(c, i.class, "com.obric.memorydata.plugin");
    L9:
        i r4 = r10;
        if ((r12 & 16) == 0) goto L13;
        r11 = (i) ZeusTransformUtils.preCheckCast(e, i.class, "com.obric.memorydata.plugin");
    L13:
        return r6.a(r7, r8, r3, r4, r11);
    L5:
        r3 = r9;
        goto L7
    }

    private final s.a a(Pair<Long, Float>[] r16, Direction r17, Direction r18, i r19, i r20) {
        C0782a r1 = a((Pair[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r16, r16.length), Pair[].class, "com.obric.memorydata.plugin"));
        return new s.a(a(r18), new float[]{0.0f, 1.0f}, new g(r1.a(), r1.b(), r19), new h(Math.abs(r1.a()), CharacterRangeUnit.TextWidthPercent, r20), r1.c(), r1.d(), 0, 64, null);
    }

    private final t a(EffectProperty r10, i r11, Pair<Long, Float>... r12) {
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r12.length), Collection.class, "com.obric.memorydata.plugin");
        int r0 = r12.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        Pair<Long, Float> r3 = r12[r2];
        r9.add(new q(((Number) ZeusTransformUtils.preCheckCast(r3.getFirst(), Number.class, "com.obric.memorydata.plugin")).longValue(), (m) ZeusTransformUtils.preCheckCast(new m.b(((Number) ZeusTransformUtils.preCheckCast(r3.getSecond(), Number.class, "com.obric.memorydata.plugin")).floatValue()), m.class, "com.obric.memorydata.plugin")));
        r2 = r2 + 1;
        goto L3
    L6:
        return new t(r10, (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), r11);
    }

    public static /* synthetic */ u a(a r0, boolean r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = 0.0f;
    L9:
        return r0.a(r1, r2);
    }

    private final C0782a a(Pair<Long, Float>... r13) {
        if (r13.length < 2) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L14;
        Pair r14 = (Pair) ZeusTransformUtils.preCheckCast(ArraysKt.first(r13), Pair.class, "com.obric.memorydata.plugin");
        Pair r1 = (Pair) ZeusTransformUtils.preCheckCast(ArraysKt.last(r13), Pair.class, "com.obric.memorydata.plugin");
        if (r13.length < 3) goto L10;
        Object r15 = r13[1].getFirst();
    L11:
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).longValue();
        return new C0782a(((Number) ZeusTransformUtils.preCheckCast(r14.getSecond(), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r1.getSecond(), Number.class, "com.obric.memorydata.plugin")).floatValue(), r3, RangesKt.coerceAtLeast(((Number) ZeusTransformUtils.preCheckCast(r1.getFirst(), Number.class, "com.obric.memorydata.plugin")).longValue() - r3, 1));
    L10:
        r15 = r14.getFirst();
        goto L11
    L14:
        throw new IllegalArgumentException("scan fill requires at least start/end frames".toString());
    L5:
        r12 = false;
        goto L6
    }

    private final List<p> a(int[] r17, float[][] r18) {
        if (r17.length != ((Object[]) ZeusTransformUtils.preCheckCast(r18, Object[].class, "com.obric.memorydata.plugin")).length) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L13;
        List r3 = CollectionsKt.createListBuilder();
        int r4 = r17.length;
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L11;
        int r7 = r5 + 1;
        int r8 = r17[r5];
        a r9 = f14644a;
        int[] r10 = {r9.a(r8), r9.b(r8)};
        float[] r6 = r18[r5];
        float[] r11 = Arrays.copyOf(r6, r6.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        r3.add(new p(r10, r11, false, 0.0f, 12, null));
        r5 = r7;
        goto L8
    L11:
        return CollectionsKt.build(r3);
    L13:
        throw new IllegalArgumentException(("Gradient layer positions size(" + ((Object[]) ZeusTransformUtils.preCheckCast(r18, Object[].class, "com.obric.memorydata.plugin")).length + ") must match colors size(" + r17.length + ").").toString());
    L5:
        r2 = false;
        goto L6
    }

    private final int[] a(Direction r2) {
        if (b.f14648a[r2.ordinal()] != 1) goto L6;
        return new int[]{ViewCompat.MEASURED_SIZE_MASK, -1};
    L6:
        return new int[]{-1, ViewCompat.MEASURED_SIZE_MASK};
    }

    private final int b(int r1) {
        return (-16777216) | r1;
    }

    private final j.a b(long r14, long r16, float r18, float r19) {
        return a("exit_indicator", "exitScanIndicator", Direction.RightToLeft, r14, r16, r18, r19, new o(null, Direction.RightToLeft, GradientBlurCurveType.InOutQuad, 0.5f, Float.valueOf(0.8889f), 1, null), (i) ZeusTransformUtils.preCheckCast(f14645b, i.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ j.a b(a r7, long r8, long r10, float r12, float r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r12 = -1.0f;
    L5:
        float r5 = r12;
        if ((r14 & 8) == 0) goto L9;
        r13 = 1.0f;
    L9:
        return r7.b(r8, r10, r5, r13);
    }

    private final t c() {
        return a(EffectProperty.Alpha, (i) ZeusTransformUtils.preCheckCast(d, i.class, "com.obric.memorydata.plugin"), new Pair[]{TuplesKt.to(0L, Float.valueOf(1.0f)), TuplesKt.to(150L, Float.valueOf(0.0f))});
    }

    private final d d() {
        return new d(150, AnimatedCharacterSpanPerformanceScenario.DurationMs, CharacterOrder.StartToEnd, null, new com.obric.oui.texteffects.core.b(null, new f(0.111f, 0.0f, null, 4, null), new g(-0.4f, 1.0f, (i) ZeusTransformUtils.preCheckCast(c, i.class, "com.obric.memorydata.plugin")), new h(0.4f, CharacterRangeUnit.TextWidthPercent, (i) ZeusTransformUtils.preCheckCast(g, i.class, "com.obric.memorydata.plugin")), 1, null), null, null, null, null, 488, null);
    }

    private final d e() {
        return new d(0, 600, CharacterOrder.StartToEnd, null, null, null, new com.obric.oui.texteffects.core.b(null, new f(0.0f, 0.333f, null, 4, null), new g(-0.5f, 1.0f, (i) ZeusTransformUtils.preCheckCast(f14645b, i.class, "com.obric.memorydata.plugin")), new h(0.5f, CharacterRangeUnit.TextWidthPercent, (i) ZeusTransformUtils.preCheckCast(h, i.class, "com.obric.memorydata.plugin")), 1, null), null, null, UploadKeys.KeyIsEnd2EndEncryptionPublicKey, null);
    }

    public final u a() {
        r r4 = (r) ZeusTransformUtils.preCheckCast(r.b.f14634a, r.class, "com.obric.memorydata.plugin");
        TextSource r11 = TextSource.Current;
        BlendSpec r15 = BlendSpec.SCREEN;
        Direction r17 = Direction.LeftToRight;
        Float r10 = Float.valueOf(0.0f);
        return new u("oui.dim_point.pending", 1500, r4, CollectionsKt.listOf(new l("pending_breath", 0, 1500, null, CollectionsKt.listOf(new k("pending_breath_group", CollectionsKt.listOf(new j.b[]{a(this, "base_text", TextSource.Current, null, null, null, null, null, 124, null), a(this, "gradient_overlay", r11, null, (n) ZeusTransformUtils.preCheckCast(a(this, r17, null, new Pair[]{TuplesKt.to(0L, r10), TuplesKt.to(750L, Float.valueOf(0.8f)), TuplesKt.to(1500L, r10)}, 2, null), n.class, "com.obric.memorydata.plugin"), null, r15, null, 84, null)}), null, 4, null)), 8, null)));
    }

    public final u a(boolean r31) {
        long r14 = Math.max(AnimatedCharacterSpanPerformanceScenario.DurationMs, 1450);
        s.a r0 = a(this, new Pair[]{TuplesKt.to(0L, Float.valueOf(-0.5f)), TuplesKt.to(Long.valueOf(AnimatedCharacterSpanPerformanceScenario.DurationMs), Float.valueOf(1.0f))}, Direction.LeftToRight, null, null, null, 28, null);
        TextSource r19 = TextSource.Current;
        BlendSpec r23 = BlendSpec.SCREEN;
        d r20 = d();
        Direction r25 = Direction.LeftToRight;
        Float r7 = Float.valueOf(0.8f);
        List r2 = CollectionsKt.mutableListOf(new j[]{(j) ZeusTransformUtils.preCheckCast(a(this, "generate_scan_base_text", TextSource.Current, d(), null, null, null, null, 120, null), j.class, "com.obric.memorydata.plugin"), (j) ZeusTransformUtils.preCheckCast(a(this, "generate_scan_text", r19, r20, (n) ZeusTransformUtils.preCheckCast(a(this, r25, null, new Pair[]{TuplesKt.to(0L, r7), TuplesKt.to(750L, r7), TuplesKt.to(1450L, Float.valueOf(0.0f))}, 2, null), n.class, "com.obric.memorydata.plugin"), null, r23, null, 80, null), j.class, "com.obric.memorydata.plugin")});
        if (r31 == false) goto L6;
        ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).add(a(0, AnimatedCharacterSpanPerformanceScenario.DurationMs, -0.4f, 1.0f));
    L6:
        return new u("oui.dim_point.generate", r14, null, CollectionsKt.mutableListOf(new l[]{new l("generate_enter", 0, r14, null, CollectionsKt.listOf(new k("generate_enter_group", r2, (s) ZeusTransformUtils.preCheckCast(r0, s.class, "com.obric.memorydata.plugin"))), 8, null)}), 4, null);
    }

    public final u a(boolean r35, float r36) {
        long r5 = Math.max(Math.max(AnimatedCharacterSpanPerformanceScenario.DurationMs, 1450), Math.max(600, 600));
        Float r10 = Float.valueOf(-0.4f);
        Float r14 = Float.valueOf(1.0f);
        s.a r11 = a(this, new Pair[]{TuplesKt.to(0L, r10), TuplesKt.to(50L, r10), TuplesKt.to(600L, r14)}, Direction.RightToLeft, null, (i) ZeusTransformUtils.preCheckCast(f14645b, i.class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.preCheckCast(f, i.class, "com.obric.memorydata.plugin"), 4, null);
        s.a r1 = a(this, new Pair[]{TuplesKt.to(0L, Float.valueOf(-0.5f)), TuplesKt.to(Long.valueOf(AnimatedCharacterSpanPerformanceScenario.DurationMs), r14)}, Direction.LeftToRight, null, null, null, 28, null);
        List r2 = CollectionsKt.mutableListOf(new j[]{(j) ZeusTransformUtils.preCheckCast(a(this, "old_text_exit", TextSource.Old, e(), null, null, null, null, 120, null), j.class, "com.obric.memorydata.plugin")});
        Float r15 = Float.valueOf(0.8f);
        if (r36 <= 0.001f) goto L5;
        ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).add(a(this, "old_gradient_exit", TextSource.Old, e(), (n) ZeusTransformUtils.preCheckCast(a(this, Direction.LeftToRight, null, new Pair[]{TuplesKt.to(0L, Float.valueOf(RangesKt.coerceIn(r36, 0.0f, 0.8f))), TuplesKt.to(600L, Float.valueOf(RangesKt.coerceIn(r36, 0.0f, 0.8f)))}, 2, null), n.class, "com.obric.memorydata.plugin"), null, null, null, 112, null));
        int r0 = 2;
    L6:
        j[] r7 = new j[r0];
        r7[0] = (j) ZeusTransformUtils.preCheckCast(a(this, "new_text_enter_base", TextSource.New, d(), null, null, null, null, 120, null), j.class, "com.obric.memorydata.plugin");
        r7[1] = (j) ZeusTransformUtils.preCheckCast(a(this, "new_text_enter", TextSource.New, d(), (n) ZeusTransformUtils.preCheckCast(a(this, Direction.LeftToRight, null, new Pair[]{TuplesKt.to(0L, r15), TuplesKt.to(750L, r15), TuplesKt.to(1450L, Float.valueOf(0.0f))}, 2, null), n.class, "com.obric.memorydata.plugin"), null, null, null, 112, null), j.class, "com.obric.memorydata.plugin");
        List r3 = CollectionsKt.mutableListOf(r7);
        if (r35 == false) goto L10;
        ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).add(b(this, 0, 600, 0.0f, 0.0f, 12, null));
        ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).add(a(this, 0, AnimatedCharacterSpanPerformanceScenario.DurationMs, 0.0f, 0.0f, 12, null));
    L10:
        return new u("oui.dim_point.rewrite", r5, null, CollectionsKt.mutableListOf(new l[]{new l("rewrite", 0, r5, null, CollectionsKt.listOf(new k[]{new k("rewrite_exit", r2, (s) ZeusTransformUtils.preCheckCast(r11, s.class, "com.obric.memorydata.plugin")), new k("rewrite_enter", r3, (s) ZeusTransformUtils.preCheckCast(r1, s.class, "com.obric.memorydata.plugin"))}), 8, null)}), 4, null);
    L5:
        r0 = 2;
        goto L6
    }

    public final u b() {
        return new u("oui.dim_point.prompt_pending_exit", 150, null, CollectionsKt.listOf(new l("prompt_pending_exit", 0, 150, null, CollectionsKt.listOf(new k("prompt_pending_exit_group", CollectionsKt.listOf(a(this, "prompt_text_exit", TextSource.Current, null, null, null, null, CollectionsKt.listOf(c()), 60, null)), null, 4, null)), 8, null)), 4, null);
    }
}
