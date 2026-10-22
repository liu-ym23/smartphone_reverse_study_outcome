package com.obric.oui.texteffects.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/texteffects/core/CharacterDimensionPropertySpec;", "", EventBody.KEY_VALUE, "Lcom/obric/oui/texteffects/core/CharacterDimensionRange;", "valuePercent", "Lcom/obric/oui/texteffects/core/CharacterFloatRange;", TypedValues.CycleType.S_WAVE_OFFSET, "Lcom/obric/oui/texteffects/core/CharacterOffsetSpec;", "shape", "Lcom/obric/oui/texteffects/core/CharacterShapeSpec;", "(Lcom/obric/oui/texteffects/core/CharacterDimensionRange;Lcom/obric/oui/texteffects/core/CharacterFloatRange;Lcom/obric/oui/texteffects/core/CharacterOffsetSpec;Lcom/obric/oui/texteffects/core/CharacterShapeSpec;)V", "getOffset", "()Lcom/obric/oui/texteffects/core/CharacterOffsetSpec;", "getShape", "()Lcom/obric/oui/texteffects/core/CharacterShapeSpec;", "getValue", "()Lcom/obric/oui/texteffects/core/CharacterDimensionRange;", "getValuePercent", "()Lcom/obric/oui/texteffects/core/CharacterFloatRange;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f14585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f14586b;
    private final g c;
    private final h d;

    public b() {
        this(null, null, null, null, 15, null);
    }

    public b(c r2, f r3, g r4, h r5) {
        Intrinsics.checkNotNullParameter(r4, TypedValues.CycleType.S_WAVE_OFFSET);
        Intrinsics.checkNotNullParameter(r5, "shape");
        this.f14585a = r2;
        this.f14586b = r3;
        this.c = r4;
        this.d = r5;
    }

    public /* synthetic */ b(c r7, f r8, g r9, h r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r7 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r8 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r9 = new g(0.0f, 0.0f, null, 7, null);
    L12:
        if ((r11 & 8) == 0) goto L14;
        r10 = new h(0.0f, null, null, 7, null);
    L14:
        this(r7, r8, r9, r10);
    }

    public final c a() {
        return this.f14585a;
    }

    public final f b() {
        return this.f14586b;
    }

    public final g c() {
        return this.c;
    }

    public final h d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f14585a, r6.f14585a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f14586b, r6.f14586b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        c r0 = this.f14585a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        f r4 = this.f14586b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((r3 + r1) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CharacterDimensionPropertySpec(value=" + this.f14585a + ", valuePercent=" + this.f14586b + ", offset=" + this.c + ", shape=" + this.d + ')';
    }
}
