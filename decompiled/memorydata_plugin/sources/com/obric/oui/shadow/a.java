package com.obric.oui.shadow;

import android.content.res.TypedArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001,BA\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\"\u001a\u00020\u0000J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0007HÖ\u0001J\r\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b)J\t\u0010*\u001a\u00020+HÖ\u0001R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006-"}, d2 = {"Lcom/obric/oui/shadow/ShadowConfig;", "", "x", "", "y", "blurRadius", TypedValues.Custom.S_COLOR, "", "spread", "blendMode", "(FFFIFI)V", "getBlendMode", "()I", "setBlendMode", "(I)V", "getBlurRadius", "()F", "setBlurRadius", "(F)V", "getColor", "setColor", "getSpread", "setSpread", "getX", "setX", "getY", "setY", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "deepCopy", "equals", "", "other", "hashCode", "toCore", "Lcom/obric/oui/shadow/ShadowConfigCore;", "toCore$OUI_standardRelease", "toString", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0774a f14456a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f14457b;
    private float c;
    private float d;
    private int e;
    private float f;
    private int g;

    /* JADX INFO: renamed from: com.obric.oui.shadow.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0014H\u0007J-\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/shadow/ShadowConfig$Companion;", "", "()V", "fromStyleRes", "Lcom/obric/oui/shadow/ShadowConfig;", "typedArray", "Landroid/content/res/TypedArray;", "colorId", "", "radiusId", "offsetXId", "offsetYId", "spreadId", "getShadowBlendIntArray", "", "shadowConfig", "lerp", CommonConsts.APM_INNER_EVENT_COST_START, "end", "fraction", "", "shadowConfigToParams", "", "density", "shadowConfigsToParamsList", "", "shadowConfigs", "", "([Lcom/obric/oui/shadow/ShadowConfig;F)Ljava/util/List;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0774a {
        private C0774a() {
        }

        public /* synthetic */ C0774a(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final a a(TypedArray r1, int r2, int r3, int r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r1, "typedArray");
            b r0 = b.a(r1, r2, r3, r4, r5, r6);
            Intrinsics.checkNotNullExpressionValue(r0, "result");
            return c.a(r0);
        }

        @JvmStatic
        public final int[] a(a r2) {
            Intrinsics.checkNotNullParameter(r2, "shadowConfig");
            b r1 = r2.f();
            int[] r0 = b.b(r1);
            r2.a(r1.f());
            Intrinsics.checkNotNullExpressionValue(r0, "result");
            return r0;
        }
    }

    static {
        f14456a = new C0774a(null);
    }

    public a(float r1, float r2, float r3, int r4, float r5, int r6) {
        this.f14457b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
    }

    @JvmStatic
    public static final a a(TypedArray r7, int r8, int r9, int r10, int r11, int r12) {
        return f14456a.a(r7, r8, r9, r10, r11, r12);
    }

    public final float a() {
        return this.f14457b;
    }

    public final void a(int r1) {
        this.g = r1;
    }

    public final float b() {
        return this.c;
    }

    public final float c() {
        return this.d;
    }

    public final int d() {
        return this.e;
    }

    public final float e() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(Float.valueOf(this.f14457b), Float.valueOf(r6.f14457b)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Float.valueOf(this.c), Float.valueOf(r6.c)) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.d), Float.valueOf(r6.d)) == true) goto L18;
        return false;
    L18:
        if (this.e == r6.e) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(Float.valueOf(this.f), Float.valueOf(r6.f)) == true) goto L24;
        return false;
    L24:
        if (this.g == r6.g) goto L26;
        return false;
    L26:
        return true;
    }

    public final b f() {
        return new b(this.f14457b, this.c, this.d, this.e, this.f, this.g);
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.f14457b) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Float.hashCode(this.f)) * 31) + Integer.hashCode(this.g);
    }

    public String toString() {
        return "ShadowConfig(x=" + this.f14457b + ", y=" + this.c + ", blurRadius=" + this.d + ", color=" + this.e + ", spread=" + this.f + ", blendMode=" + this.g + ')';
    }
}
