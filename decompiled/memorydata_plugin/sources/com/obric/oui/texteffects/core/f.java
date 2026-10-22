package com.obric.oui.texteffects.core;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/texteffects/core/CharacterFloatRange;", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "end", Scraps.INNER_UNIT, "Lcom/obric/oui/texteffects/core/CharacterRangeUnit;", "(FFLcom/obric/oui/texteffects/core/CharacterRangeUnit;)V", "getEnd", "()F", "getStart", "getUnit", "()Lcom/obric/oui/texteffects/core/CharacterRangeUnit;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f14593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f14594b;
    private final CharacterRangeUnit c;

    public f(float r2, float r3, CharacterRangeUnit r4) {
        Intrinsics.checkNotNullParameter(r4, Scraps.INNER_UNIT);
        this.f14593a = r2;
        this.f14594b = r3;
        this.c = r4;
    }

    public /* synthetic */ f(float r1, float r2, CharacterRangeUnit r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = CharacterRangeUnit.Absolute;
    L5:
        this(r1, r2, r3);
    }

    public final float a() {
        return this.f14593a;
    }

    public final float b() {
        return this.f14594b;
    }

    public final CharacterRangeUnit c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(Float.valueOf(this.f14593a), Float.valueOf(r6.f14593a)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Float.valueOf(this.f14594b), Float.valueOf(r6.f14594b)) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Float.hashCode(this.f14593a) * 31) + Float.hashCode(this.f14594b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "CharacterFloatRange(start=" + this.f14593a + ", end=" + this.f14594b + ", unit=" + this.c + ')';
    }
}
