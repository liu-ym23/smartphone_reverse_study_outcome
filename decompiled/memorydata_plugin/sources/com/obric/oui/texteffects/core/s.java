package com.obric.oui.texteffects.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/texteffects/core/MaskSpec;", "", "()V", "ShapeMappedLinearGradient", "Lcom/obric/oui/texteffects/core/MaskSpec$ShapeMappedLinearGradient;", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class s {

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u000eHÆ\u0003JO\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0002J\b\u0010)\u001a\u00020\u000eH\u0016J\t\u0010*\u001a\u00020+HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/obric/oui/texteffects/core/MaskSpec$ShapeMappedLinearGradient;", "Lcom/obric/oui/texteffects/core/MaskSpec;", "colors", "", "positions", "", TypedValues.CycleType.S_WAVE_OFFSET, "Lcom/obric/oui/texteffects/core/CharacterOffsetSpec;", "shape", "Lcom/obric/oui/texteffects/core/CharacterShapeSpec;", "delayMs", "", "durationMs", "stopCount", "", "([I[FLcom/obric/oui/texteffects/core/CharacterOffsetSpec;Lcom/obric/oui/texteffects/core/CharacterShapeSpec;JJI)V", "getColors", "()[I", "getDelayMs", "()J", "getDurationMs", "getOffset", "()Lcom/obric/oui/texteffects/core/CharacterOffsetSpec;", "getPositions", "()[F", "getShape", "()Lcom/obric/oui/texteffects/core/CharacterShapeSpec;", "getStopCount", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f14636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float[] f14637b;
        private final g c;
        private final h d;
        private final long e;
        private final long f;
        private final int g;

        public a(int[] r2, float[] r3, g r4, h r5, long r6, long r8, int r10) {
            Intrinsics.checkNotNullParameter(r2, "colors");
            Intrinsics.checkNotNullParameter(r3, "positions");
            Intrinsics.checkNotNullParameter(r4, TypedValues.CycleType.S_WAVE_OFFSET);
            Intrinsics.checkNotNullParameter(r5, "shape");
            super(null);
            this.f14636a = r2;
            this.f14637b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r8;
            this.g = r10;
        }

        public /* synthetic */ a(int[] r13, float[] r14, g r15, h r16, long r17, long r19, int r21, int r22, DefaultConstructorMarker r23) {
            if ((r22 & 16) == 0) goto L5;
            long r7 = 0;
        L7:
            if ((r22 & 64) == 0) goto L9;
            int r11 = 33;
        L10:
            this(r13, r14, r15, r16, r7, r19, r11);
            return;
        L9:
            r11 = r21;
            goto L10
        L5:
            r7 = r17;
            goto L7
        }

        public final int[] a() {
            return this.f14636a;
        }

        public final float[] b() {
            return this.f14637b;
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
            if (ZeusTransformUtils.instanceOf(r10, a.class) == true) goto L9;
            return false;
        L9:
            if (Arrays.equals(this.f14636a, ((a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.memorydata.plugin")).f14636a) == false) goto L24;
            if (Arrays.equals(this.f14637b, ((a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.memorydata.plugin")).f14637b) == false) goto L24;
            if (Intrinsics.areEqual(this.c, ((a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.memorydata.plugin")).c) == false) goto L24;
            if (Intrinsics.areEqual(this.d, ((a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.memorydata.plugin")).d) == false) goto L24;
            if (this.e != ((a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.memorydata.plugin")).e) goto L24;
            if (this.f != ((a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.memorydata.plugin")).f) goto L24;
            if (this.g != ((a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.memorydata.plugin")).g) goto L24;
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
            return (((((((((((Arrays.hashCode(this.f14636a) * 31) + Arrays.hashCode(this.f14637b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g;
        }

        public String toString() {
            return "ShapeMappedLinearGradient(colors=" + Arrays.toString(this.f14636a) + ", positions=" + Arrays.toString(this.f14637b) + ", offset=" + this.c + ", shape=" + this.d + ", delayMs=" + this.e + ", durationMs=" + this.f + ", stopCount=" + this.g + ')';
        }
    }

    private s() {
    }

    public /* synthetic */ s(DefaultConstructorMarker r1) {
        this();
    }
}
