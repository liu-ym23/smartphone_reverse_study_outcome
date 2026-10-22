package com.obric.oui.texteffects.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003Jc\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018¨\u0006."}, d2 = {"Lcom/obric/oui/texteffects/core/CharacterEffectSpec;", "", "delayMs", "", "durationMs", "order", "Lcom/obric/oui/texteffects/core/CharacterOrder;", "alpha", "Lcom/obric/oui/texteffects/core/CharacterFloatPropertySpec;", "trackingX", "Lcom/obric/oui/texteffects/core/CharacterDimensionPropertySpec;", "trackingY", "positionX", "positionY", "scale", "(JJLcom/obric/oui/texteffects/core/CharacterOrder;Lcom/obric/oui/texteffects/core/CharacterFloatPropertySpec;Lcom/obric/oui/texteffects/core/CharacterDimensionPropertySpec;Lcom/obric/oui/texteffects/core/CharacterDimensionPropertySpec;Lcom/obric/oui/texteffects/core/CharacterDimensionPropertySpec;Lcom/obric/oui/texteffects/core/CharacterDimensionPropertySpec;Lcom/obric/oui/texteffects/core/CharacterFloatPropertySpec;)V", "getAlpha", "()Lcom/obric/oui/texteffects/core/CharacterFloatPropertySpec;", "getDelayMs", "()J", "getDurationMs", "getOrder", "()Lcom/obric/oui/texteffects/core/CharacterOrder;", "getPositionX", "()Lcom/obric/oui/texteffects/core/CharacterDimensionPropertySpec;", "getPositionY", "getScale", "getTrackingX", "getTrackingY", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f14589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f14590b;
    private final CharacterOrder c;
    private final e d;
    private final b e;
    private final b f;
    private final b g;
    private final b h;
    private final e i;

    public d(long r2, long r4, CharacterOrder r6, e r7, b r8, b r9, b r10, b r11, e r12) {
        Intrinsics.checkNotNullParameter(r6, "order");
        Intrinsics.checkNotNullParameter(r7, "alpha");
        Intrinsics.checkNotNullParameter(r8, "trackingX");
        Intrinsics.checkNotNullParameter(r9, "trackingY");
        Intrinsics.checkNotNullParameter(r10, "positionX");
        Intrinsics.checkNotNullParameter(r11, "positionY");
        Intrinsics.checkNotNullParameter(r12, "scale");
        this.f14589a = r2;
        this.f14590b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
    }

    public /* synthetic */ d(long r21, long r23, CharacterOrder r25, e r26, b r27, b r28, b r29, b r30, e r31, int r32, DefaultConstructorMarker r33) {
        if ((r32 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r32 & 4) == 0) goto L9;
        CharacterOrder r8 = CharacterOrder.StartToEnd;
    L11:
        if ((r32 & 8) == 0) goto L13;
        e r9 = new e(new f(1.0f, 1.0f, null, 4, null), null, null, 6, null);
    L15:
        if ((r32 & 16) == 0) goto L17;
        b r10 = new b(null, new f(0.0f, 0.0f, null, 4, null), null, null, 13, null);
    L19:
        if ((r32 & 32) == 0) goto L21;
        b r11 = new b(null, new f(0.0f, 0.0f, null, 4, null), null, null, 13, null);
    L23:
        if ((r32 & 64) == 0) goto L25;
        b r12 = new b(new c((m) ZeusTransformUtils.preCheckCast(new m.a(0.0f), m.class, "com.obric.memorydata.plugin"), (m) ZeusTransformUtils.preCheckCast(new m.a(0.0f), m.class, "com.obric.memorydata.plugin"), null, 4, null), null, null, null, 14, null);
    L27:
        if ((r32 & 128) == 0) goto L29;
        b r13 = new b(new c((m) ZeusTransformUtils.preCheckCast(new m.a(0.0f), m.class, "com.obric.memorydata.plugin"), (m) ZeusTransformUtils.preCheckCast(new m.a(0.0f), m.class, "com.obric.memorydata.plugin"), null, 4, null), null, null, null, 14, null);
    L31:
        if ((r32 & 256) == 0) goto L33;
        e r14 = new e(new f(1.0f, 1.0f, null, 4, null), null, null, 6, null);
    L34:
        this(r4, r23, r8, r9, r10, r11, r12, r13, r14);
        return;
    L33:
        r14 = r31;
        goto L34
    L29:
        r13 = r30;
        goto L31
    L25:
        r12 = r29;
        goto L27
    L21:
        r11 = r28;
        goto L23
    L17:
        r10 = r27;
        goto L19
    L13:
        r9 = r26;
        goto L15
    L9:
        r8 = r25;
        goto L11
    L5:
        r4 = r21;
        goto L7
    }

    public final long a() {
        return this.f14589a;
    }

    public final long b() {
        return this.f14590b;
    }

    public final CharacterOrder c() {
        return this.c;
    }

    public final e d() {
        return this.d;
    }

    public final b e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
        return false;
    L8:
        d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
        if (this.f14589a == r10.f14589a) goto L12;
        return false;
    L12:
        if (this.f14590b == r10.f14590b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final b f() {
        return this.f;
    }

    public final b g() {
        return this.g;
    }

    public final b h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((((Long.hashCode(this.f14589a) * 31) + Long.hashCode(this.f14590b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
    }

    public final e i() {
        return this.i;
    }

    public String toString() {
        return "CharacterEffectSpec(delayMs=" + this.f14589a + ", durationMs=" + this.f14590b + ", order=" + this.c + ", alpha=" + this.d + ", trackingX=" + this.e + ", trackingY=" + this.f + ", positionX=" + this.g + ", positionY=" + this.h + ", scale=" + this.i + ')';
    }
}
