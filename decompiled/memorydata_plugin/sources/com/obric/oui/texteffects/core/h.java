package com.obric.oui.texteffects.core;

import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/texteffects/core/CharacterShapeSpec;", "", "range", "", Scraps.INNER_UNIT, "Lcom/obric/oui/texteffects/core/CharacterRangeUnit;", "easing", "Lcom/obric/oui/texteffects/core/EasingSpec;", "(FLcom/obric/oui/texteffects/core/CharacterRangeUnit;Lcom/obric/oui/texteffects/core/EasingSpec;)V", "getEasing", "()Lcom/obric/oui/texteffects/core/EasingSpec;", "getRange", "()F", "getUnit", "()Lcom/obric/oui/texteffects/core/CharacterRangeUnit;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f14597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharacterRangeUnit f14598b;
    private final i c;

    public h() {
        this(0.0f, null, null, 7, null);
    }

    public h(float r2, CharacterRangeUnit r3, i r4) {
        Intrinsics.checkNotNullParameter(r3, Scraps.INNER_UNIT);
        Intrinsics.checkNotNullParameter(r4, "easing");
        this.f14597a = r2;
        this.f14598b = r3;
        this.c = r4;
    }

    public /* synthetic */ h(float r7, CharacterRangeUnit r8, i r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L6;
        r7 = 1.0f;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r8 = CharacterRangeUnit.TextWidthPercent;
    L9:
        if ((r10 & 4) == 0) goto L11;
        r9 = (i) ZeusTransformUtils.preCheckCast(new i.a(0, 0.0f, 0.0f, 7, null), i.class, "com.obric.memorydata.plugin");
    L11:
        this(r7, r8, r9);
    }

    public final float a() {
        return this.f14597a;
    }

    public final CharacterRangeUnit b() {
        return this.f14598b;
    }

    public final i c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(Float.valueOf(this.f14597a), Float.valueOf(r6.f14597a)) == true) goto L12;
        return false;
    L12:
        if (this.f14598b == r6.f14598b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Float.hashCode(this.f14597a) * 31) + this.f14598b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "CharacterShapeSpec(range=" + this.f14597a + ", unit=" + this.f14598b + ", easing=" + this.c + ')';
    }
}
