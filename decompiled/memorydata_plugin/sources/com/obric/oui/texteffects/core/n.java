package com.obric.oui.texteffects.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/texteffects/core/FillSpec;", "", "()V", "GradientGroup", "LinearGradient", "ShapeMappedLinearGradient", "TextColor", "Lcom/obric/oui/texteffects/core/FillSpec$TextColor;", "Lcom/obric/oui/texteffects/core/FillSpec$LinearGradient;", "Lcom/obric/oui/texteffects/core/FillSpec$ShapeMappedLinearGradient;", "Lcom/obric/oui/texteffects/core/FillSpec$GradientGroup;", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class n {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/texteffects/core/FillSpec$GradientGroup;", "Lcom/obric/oui/texteffects/core/FillSpec;", "layers", "", "Lcom/obric/oui/texteffects/core/GradientLayerSpec;", "groupAlpha", "Lcom/obric/oui/texteffects/core/AnimatedFloatSpec;", "(Ljava/util/List;Lcom/obric/oui/texteffects/core/AnimatedFloatSpec;)V", "getGroupAlpha", "()Lcom/obric/oui/texteffects/core/AnimatedFloatSpec;", "getLayers", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<p> f14620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.oui.texteffects.core.a f14621b;

        public a(List<p> r3, com.obric.oui.texteffects.core.a r4) {
            List<p> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "layers");
            Intrinsics.checkNotNullParameter(r4, "groupAlpha");
            super(null);
            this.f14620a = r5;
            this.f14621b = r4;
        }

        public final List<p> a() {
            return this.f14620a;
        }

        public final com.obric.oui.texteffects.core.a b() {
            return this.f14621b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f14620a, r6.f14620a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f14621b, r6.f14621b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f14620a.hashCode() * 31) + this.f14621b.hashCode();
        }

        public String toString() {
            return "GradientGroup(layers=" + this.f14620a + ", groupAlpha=" + this.f14621b + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/texteffects/core/FillSpec$LinearGradient;", "Lcom/obric/oui/texteffects/core/FillSpec;", "colors", "", "positions", "", "([I[F)V", "getColors", "()[I", "getPositions", "()[F", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f14622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float[] f14623b;

        public final int[] a() {
            return this.f14622a;
        }

        public final float[] b() {
            return this.f14623b;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L9;
            return false;
        L9:
            if (Arrays.equals(this.f14622a, ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).f14622a) == false) goto L14;
            if (Arrays.equals(this.f14623b, ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).f14623b) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f14622a) * 31) + Arrays.hashCode(this.f14623b);
        }

        public String toString() {
            return "LinearGradient(colors=" + Arrays.toString(this.f14622a) + ", positions=" + Arrays.toString(this.f14623b) + ')';
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u000eHÆ\u0003JO\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0002J\b\u0010)\u001a\u00020\u000eH\u0016J\t\u0010*\u001a\u00020+HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/obric/oui/texteffects/core/FillSpec$ShapeMappedLinearGradient;", "Lcom/obric/oui/texteffects/core/FillSpec;", "colors", "", "positions", "", TypedValues.CycleType.S_WAVE_OFFSET, "Lcom/obric/oui/texteffects/core/CharacterOffsetSpec;", "shape", "Lcom/obric/oui/texteffects/core/CharacterShapeSpec;", "delayMs", "", "durationMs", "stopCount", "", "([I[FLcom/obric/oui/texteffects/core/CharacterOffsetSpec;Lcom/obric/oui/texteffects/core/CharacterShapeSpec;JJI)V", "getColors", "()[I", "getDelayMs", "()J", "getDurationMs", "getOffset", "()Lcom/obric/oui/texteffects/core/CharacterOffsetSpec;", "getPositions", "()[F", "getShape", "()Lcom/obric/oui/texteffects/core/CharacterShapeSpec;", "getStopCount", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f14624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float[] f14625b;
        private final g c;
        private final h d;
        private final long e;
        private final long f;
        private final int g;

        public final int[] a() {
            return this.f14624a;
        }

        public final float[] b() {
            return this.f14625b;
        }

        public final g c() {
            return this.c;
        }

        public final h d() {
            return this.d;
        }

        public final long e() {
            return this.e;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r10, c.class) == true) goto L9;
            return false;
        L9:
            if (Arrays.equals(this.f14624a, ((c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.memorydata.plugin")).f14624a) == false) goto L24;
            if (Arrays.equals(this.f14625b, ((c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.memorydata.plugin")).f14625b) == false) goto L24;
            if (Intrinsics.areEqual(this.c, ((c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.memorydata.plugin")).c) == false) goto L24;
            if (Intrinsics.areEqual(this.d, ((c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.memorydata.plugin")).d) == false) goto L24;
            if (this.e != ((c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.memorydata.plugin")).e) goto L24;
            if (this.f != ((c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.memorydata.plugin")).f) goto L24;
            if (this.g != ((c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.memorydata.plugin")).g) goto L24;
            return true;
        L24:
            return false;
        }

        public final long f() {
            return this.f;
        }

        public final int g() {
            return this.g;
        }

        public int hashCode() {
            return (((((((((((Arrays.hashCode(this.f14624a) * 31) + Arrays.hashCode(this.f14625b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g;
        }

        public String toString() {
            return "ShapeMappedLinearGradient(colors=" + Arrays.toString(this.f14624a) + ", positions=" + Arrays.toString(this.f14625b) + ", offset=" + this.c + ", shape=" + this.d + ", delayMs=" + this.e + ", durationMs=" + this.f + ", stopCount=" + this.g + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/texteffects/core/FillSpec$TextColor;", "Lcom/obric/oui/texteffects/core/FillSpec;", "()V", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f14626a = null;

        static {
            f14626a = new d();
        }

        private d() {
            super(null);
        }
    }

    private n() {
    }

    public /* synthetic */ n(DefaultConstructorMarker r1) {
        this();
    }
}
