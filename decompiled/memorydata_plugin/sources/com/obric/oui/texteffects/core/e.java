package com.obric.oui.texteffects.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/texteffects/core/CharacterFloatPropertySpec;", "", "valueRange", "Lcom/obric/oui/texteffects/core/CharacterFloatRange;", TypedValues.CycleType.S_WAVE_OFFSET, "Lcom/obric/oui/texteffects/core/CharacterOffsetSpec;", "shape", "Lcom/obric/oui/texteffects/core/CharacterShapeSpec;", "(Lcom/obric/oui/texteffects/core/CharacterFloatRange;Lcom/obric/oui/texteffects/core/CharacterOffsetSpec;Lcom/obric/oui/texteffects/core/CharacterShapeSpec;)V", "getOffset", "()Lcom/obric/oui/texteffects/core/CharacterOffsetSpec;", "getShape", "()Lcom/obric/oui/texteffects/core/CharacterShapeSpec;", "getValueRange", "()Lcom/obric/oui/texteffects/core/CharacterFloatRange;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f14591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f14592b;
    private final h c;

    public e(f r2, g r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "valueRange");
        Intrinsics.checkNotNullParameter(r3, TypedValues.CycleType.S_WAVE_OFFSET);
        Intrinsics.checkNotNullParameter(r4, "shape");
        this.f14591a = r2;
        this.f14592b = r3;
        this.c = r4;
    }

    public /* synthetic */ e(f r7, g r8, h r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 2) == 0) goto L6;
        r8 = new g(0.0f, 0.0f, null, 7, null);
    L6:
        if ((r10 & 4) == 0) goto L8;
        r9 = new h(0.0f, null, null, 7, null);
    L8:
        this(r7, r8, r9);
    }

    public final f a() {
        return this.f14591a;
    }

    public final g b() {
        return this.f14592b;
    }

    public final h c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f14591a, r6.f14591a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f14592b, r6.f14592b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f14591a.hashCode() * 31) + this.f14592b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "CharacterFloatPropertySpec(valueRange=" + this.f14591a + ", offset=" + this.f14592b + ", shape=" + this.c + ')';
    }
}
