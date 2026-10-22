package com.obric.oui.material;

import android.content.res.ColorStateList;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0016\u0010C\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010D\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010%J\u0016\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00104J\u0006\u0010J\u001a\u00020\u0000J\u0092\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010KJ\u0006\u0010L\u001a\u00020\u0000J\u0006\u0010M\u001a\u00020\u0000J\u0013\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010Q\u001a\u00020RH\u0016J\r\u0010S\u001a\u00020TH\u0000¢\u0006\u0002\bUJ\t\u0010V\u001a\u00020WHÖ\u0001R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006X"}, d2 = {"Lcom/obric/oui/material/MaterialConfig;", "", "fallbackBgColor", "Landroid/content/res/ColorStateList;", "blendConfigStateList", "Lcom/obric/oui/res/BlendConfigStateList;", "blendConfig", "", "Lcom/obric/oui/color/BlendConfig;", "strokeStateList", "Lcom/obric/oui/res/StrokeStateList;", "stroke", "Lcom/obric/oui/color/StrokeConfig;", "overlayBlendConfigStateList", "blurConfig", "Lcom/obric/oui/blur/BlurConfig;", "blurRadius", "", "shadow", "Lcom/obric/oui/shadow/ShadowConfig;", "fluid", "Lcom/obric/oui/fluid/FluidConfig;", "(Landroid/content/res/ColorStateList;Lcom/obric/oui/res/BlendConfigStateList;[Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/res/StrokeStateList;Lcom/obric/oui/color/StrokeConfig;Lcom/obric/oui/res/BlendConfigStateList;Lcom/obric/oui/blur/BlurConfig;Ljava/lang/Float;[Lcom/obric/oui/shadow/ShadowConfig;Lcom/obric/oui/fluid/FluidConfig;)V", "getBlendConfig", "()[Lcom/obric/oui/color/BlendConfig;", "setBlendConfig", "([Lcom/obric/oui/color/BlendConfig;)V", "[Lcom/obric/oui/color/BlendConfig;", "getBlendConfigStateList", "()Lcom/obric/oui/res/BlendConfigStateList;", "setBlendConfigStateList", "(Lcom/obric/oui/res/BlendConfigStateList;)V", "getBlurConfig", "()Lcom/obric/oui/blur/BlurConfig;", "setBlurConfig", "(Lcom/obric/oui/blur/BlurConfig;)V", "getBlurRadius", "()Ljava/lang/Float;", "setBlurRadius", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getFallbackBgColor", "()Landroid/content/res/ColorStateList;", "setFallbackBgColor", "(Landroid/content/res/ColorStateList;)V", "getFluid", "()Lcom/obric/oui/fluid/FluidConfig;", "setFluid", "(Lcom/obric/oui/fluid/FluidConfig;)V", "getOverlayBlendConfigStateList", "setOverlayBlendConfigStateList", "getShadow", "()[Lcom/obric/oui/shadow/ShadowConfig;", "setShadow", "([Lcom/obric/oui/shadow/ShadowConfig;)V", "[Lcom/obric/oui/shadow/ShadowConfig;", "getStroke", "()Lcom/obric/oui/color/StrokeConfig;", "setStroke", "(Lcom/obric/oui/color/StrokeConfig;)V", "getStrokeStateList", "()Lcom/obric/oui/res/StrokeStateList;", "setStrokeStateList", "(Lcom/obric/oui/res/StrokeStateList;)V", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Landroid/content/res/ColorStateList;Lcom/obric/oui/res/BlendConfigStateList;[Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/res/StrokeStateList;Lcom/obric/oui/color/StrokeConfig;Lcom/obric/oui/res/BlendConfigStateList;Lcom/obric/oui/blur/BlurConfig;Ljava/lang/Float;[Lcom/obric/oui/shadow/ShadowConfig;Lcom/obric/oui/fluid/FluidConfig;)Lcom/obric/oui/material/MaterialConfig;", "deepCopy", "deepCopyFromCore", "equals", "", "other", "hashCode", "", "toCore", "Lcom/obric/oui/material/MaterialConfigCore;", "toCore$OUI_standardRelease", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ColorStateList f14015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.oui.b.a f14016b;
    private com.obric.oui.color.a[] c;
    private com.obric.oui.b.c d;
    private com.obric.oui.color.e e;
    private com.obric.oui.b.a f;
    private com.obric.oui.blur.a g;
    private Float h;
    private com.obric.oui.shadow.a[] i;
    private com.obric.oui.fluid.a j;

    public c() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public c(ColorStateList r1, com.obric.oui.b.a r2, com.obric.oui.color.a[] r3, com.obric.oui.b.c r4, com.obric.oui.color.e r5, com.obric.oui.b.a r6, com.obric.oui.blur.a r7, Float r8, com.obric.oui.shadow.a[] r9, com.obric.oui.fluid.a r10) {
        this.f14015a = r1;
        this.f14016b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public /* synthetic */ c(ColorStateList r2, com.obric.oui.b.a r3, com.obric.oui.color.a[] r4, com.obric.oui.b.c r5, com.obric.oui.color.e r6, com.obric.oui.b.a r7, com.obric.oui.blur.a r8, Float r9, com.obric.oui.shadow.a[] r10, com.obric.oui.fluid.a r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r12 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r12 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r12 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r12 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r12 & 512) == 0) goto L32;
        r11 = null;
    L32:
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public final ColorStateList a() {
        return this.f14015a;
    }

    public final void a(ColorStateList r1) {
        this.f14015a = r1;
    }

    public final void a(com.obric.oui.b.a r1) {
        this.f14016b = r1;
    }

    public final void a(com.obric.oui.b.c r1) {
        this.d = r1;
    }

    public final void a(com.obric.oui.blur.a r1) {
        this.g = r1;
    }

    public final void a(com.obric.oui.color.e r1) {
        this.e = r1;
    }

    public final void a(com.obric.oui.fluid.a r1) {
        this.j = r1;
    }

    public final void a(com.obric.oui.color.a[] r1) {
        this.c = r1;
    }

    public final void a(com.obric.oui.shadow.a[] r1) {
        this.i = r1;
    }

    public final com.obric.oui.b.a b() {
        return this.f14016b;
    }

    public final void b(com.obric.oui.b.a r1) {
        this.f = r1;
    }

    public final com.obric.oui.color.a[] c() {
        return this.c;
    }

    public final com.obric.oui.b.c d() {
        return this.d;
    }

    public final com.obric.oui.color.e e() {
        return this.e;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 != null) goto L8;
        Class<?> r3 = null;
    L10:
        if (Intrinsics.areEqual(r2, r3) == true) goto L12;
        return false;
    L12:
        Objects.requireNonNull(r7, "null cannot be cast to non-null type com.obric.oui.material.MaterialConfig");
        c r4 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.h, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin")).h) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f14015a, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin")).f14015a) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.f14016b, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin")).f14016b) == true) goto L22;
        return false;
    L22:
        if (Arrays.equals(this.c, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin")).c) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.d, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin")).d) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.e, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin")).e) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.f, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin")).f) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.g, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin")).g) == true) goto L37;
        return false;
    L37:
        if (Arrays.equals(this.i, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin")).i) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.j, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin")).j) == true) goto L42;
        return false;
    L42:
        return true;
    L8:
        r3 = r7.getClass();
        goto L10
    }

    public final com.obric.oui.b.a f() {
        return this.f;
    }

    public final com.obric.oui.blur.a g() {
        return this.g;
    }

    public final Float h() {
        return this.h;
    }

    public int hashCode() {
        Float r0 = this.h;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ColorStateList r4 = this.f14015a;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        com.obric.oui.b.a r7 = this.f14016b;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        com.obric.oui.color.a[] r10 = this.c;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        com.obric.oui.b.c r13 = this.d;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        com.obric.oui.color.e r16 = this.e;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        com.obric.oui.b.a r19 = this.f;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        com.obric.oui.blur.a r22 = this.g;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        com.obric.oui.shadow.a[] r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        com.obric.oui.fluid.a r28 = this.j;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = Arrays.hashCode(r25);
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = Arrays.hashCode(r10);
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final com.obric.oui.shadow.a[] i() {
        return this.i;
    }

    public final com.obric.oui.fluid.a j() {
        return this.j;
    }

    public final e k() {
        ColorStateList r1 = this.f14015a;
        com.obric.oui.b.a r0 = this.f14016b;
        if (r0 != null) goto L5;
        com.obric.oui.b.b r3 = null;
    L6:
        com.obric.oui.color.a[] r2 = this.c;
        if (r2 != null) goto L9;
        com.obric.oui.color.b[] r4 = null;
    L10:
        com.obric.oui.b.c r5 = this.d;
        if (r5 != null) goto L13;
        com.obric.oui.b.d r6 = null;
    L14:
        com.obric.oui.color.e r7 = this.e;
        if (r7 != null) goto L17;
        com.obric.oui.color.f r8 = null;
    L18:
        com.obric.oui.b.a r9 = this.f;
        if (r9 != null) goto L21;
        com.obric.oui.b.b r10 = null;
    L22:
        com.obric.oui.blur.a r11 = this.g;
        if (r11 != null) goto L25;
        com.obric.oui.blur.b r12 = null;
    L26:
        Float r13 = this.h;
        com.obric.oui.shadow.a[] r14 = this.i;
        if (r14 != null) goto L29;
        com.obric.oui.shadow.b[] r15 = null;
    L30:
        com.obric.oui.fluid.a r16 = this.j;
        if (r16 != null) goto L33;
        com.obric.oui.fluid.b r17 = null;
    L35:
        return new e(r1, r3, r4, r6, r8, r10, r12, r13, r15, r17);
    L33:
        r17 = r16.b();
        goto L35
    L29:
        r15 = f.a(r14);
        goto L30
    L25:
        r12 = r11.f();
        goto L26
    L21:
        r10 = r9.b();
        goto L22
    L17:
        r8 = r7.d();
        goto L18
    L13:
        r6 = r5.b();
        goto L14
    L9:
        r4 = com.obric.oui.color.c.a(r2);
        goto L10
    L5:
        r3 = r0.b();
        goto L6
    }

    public final c l() {
        e r0 = k().k();
        Intrinsics.checkNotNullExpressionValue(r0, "toCore().deepCopy()");
        c r1 = f.a(r0);
        ColorStateList r2 = a();
        if (r2 != null) goto L5;
        ColorStateList r3 = null;
    L6:
        r1.a(r3);
        return r1;
    L5:
        r3 = f.a(r2);
        goto L6
    }

    public String toString() {
        return "MaterialConfig(fallbackBgColor=" + this.f14015a + ", blendConfigStateList=" + this.f14016b + ", blendConfig=" + Arrays.toString(this.c) + ", strokeStateList=" + this.d + ", stroke=" + this.e + ", overlayBlendConfigStateList=" + this.f + ", blurConfig=" + this.g + ", blurRadius=" + this.h + ", shadow=" + Arrays.toString(this.i) + ", fluid=" + this.j + ')';
    }
}
