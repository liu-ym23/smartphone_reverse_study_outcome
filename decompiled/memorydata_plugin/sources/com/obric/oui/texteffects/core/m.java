package com.obric.oui.texteffects.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectValue;", "", "()V", "DimensionDp", "FloatValue", "InterpolatedDimension", "LayerWidth", "ParentWidth", "SelfWidthRatio", "TextWidthRatio", "Lcom/obric/oui/texteffects/core/EffectValue$FloatValue;", "Lcom/obric/oui/texteffects/core/EffectValue$DimensionDp;", "Lcom/obric/oui/texteffects/core/EffectValue$ParentWidth;", "Lcom/obric/oui/texteffects/core/EffectValue$LayerWidth;", "Lcom/obric/oui/texteffects/core/EffectValue$TextWidthRatio;", "Lcom/obric/oui/texteffects/core/EffectValue$SelfWidthRatio;", "Lcom/obric/oui/texteffects/core/EffectValue$InterpolatedDimension;", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class m {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectValue$DimensionDp;", "Lcom/obric/oui/texteffects/core/EffectValue;", EventBody.KEY_VALUE, "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f14612a;

        public a(float r2) {
            super(null);
            this.f14612a = r2;
        }

        public final float a() {
            return this.f14612a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(Float.valueOf(this.f14612a), Float.valueOf(r6.f14612a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.f14612a);
        }

        public String toString() {
            return "DimensionDp(value=" + this.f14612a + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectValue$FloatValue;", "Lcom/obric/oui/texteffects/core/EffectValue;", EventBody.KEY_VALUE, "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f14613a;

        public b(float r2) {
            super(null);
            this.f14613a = r2;
        }

        public final float a() {
            return this.f14613a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(Float.valueOf(this.f14613a), Float.valueOf(r6.f14613a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.f14613a);
        }

        public String toString() {
            return "FloatValue(value=" + this.f14613a + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0001HÆ\u0003J\t\u0010\r\u001a\u00020\u0001HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectValue$InterpolatedDimension;", "Lcom/obric/oui/texteffects/core/EffectValue;", "from", TypedValues.TransitionType.S_TO, "progress", "", "(Lcom/obric/oui/texteffects/core/EffectValue;Lcom/obric/oui/texteffects/core/EffectValue;F)V", "getFrom", "()Lcom/obric/oui/texteffects/core/EffectValue;", "getProgress", "()F", "getTo", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m f14614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final m f14615b;
        private final float c;

        public c(m r2, m r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "from");
            Intrinsics.checkNotNullParameter(r3, TypedValues.TransitionType.S_TO);
            super(null);
            this.f14614a = r2;
            this.f14615b = r3;
            this.c = r4;
        }

        public final m a() {
            return this.f14614a;
        }

        public final m b() {
            return this.f14615b;
        }

        public final float c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f14614a, r6.f14614a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f14615b, r6.f14615b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.c), Float.valueOf(r6.c)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f14614a.hashCode() * 31) + this.f14615b.hashCode()) * 31) + Float.hashCode(this.c);
        }

        public String toString() {
            return "InterpolatedDimension(from=" + this.f14614a + ", to=" + this.f14615b + ", progress=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectValue$LayerWidth;", "Lcom/obric/oui/texteffects/core/EffectValue;", "extraDp", "", "(F)V", "getExtraDp", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f14616a;

        public d() {
            this(0.0f, 1, null);
        }

        public d(float r2) {
            super(null);
            this.f14616a = r2;
        }

        public /* synthetic */ d(float r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = 0.0f;
        L5:
            this(r1);
        }

        public final float a() {
            return this.f14616a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(Float.valueOf(this.f14616a), Float.valueOf(r6.f14616a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.f14616a);
        }

        public String toString() {
            return "LayerWidth(extraDp=" + this.f14616a + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectValue$ParentWidth;", "Lcom/obric/oui/texteffects/core/EffectValue;", "extraDp", "", "(F)V", "getExtraDp", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f14617a;

        public e() {
            this(0.0f, 1, null);
        }

        public e(float r2) {
            super(null);
            this.f14617a = r2;
        }

        public /* synthetic */ e(float r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = 0.0f;
        L5:
            this(r1);
        }

        public final float a() {
            return this.f14617a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(Float.valueOf(this.f14617a), Float.valueOf(r6.f14617a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.f14617a);
        }

        public String toString() {
            return "ParentWidth(extraDp=" + this.f14617a + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectValue$SelfWidthRatio;", "Lcom/obric/oui/texteffects/core/EffectValue;", "ratio", "", "(F)V", "getRatio", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f14618a;

        public final float a() {
            return this.f14618a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(Float.valueOf(this.f14618a), Float.valueOf(r6.f14618a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.f14618a);
        }

        public String toString() {
            return "SelfWidthRatio(ratio=" + this.f14618a + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectValue$TextWidthRatio;", "Lcom/obric/oui/texteffects/core/EffectValue;", "ratio", "", "(F)V", "getRatio", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f14619a;

        public g(float r2) {
            super(null);
            this.f14619a = r2;
        }

        public final float a() {
            return this.f14619a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(Float.valueOf(this.f14619a), Float.valueOf(r6.f14619a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.f14619a);
        }

        public String toString() {
            return "TextWidthRatio(ratio=" + this.f14619a + ')';
        }
    }

    private m() {
    }

    public /* synthetic */ m(DefaultConstructorMarker r1) {
        this();
    }
}
