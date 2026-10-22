package com.ss.ugc.clientai.aiservice.ohr;

import android.graphics.RectF;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/ss/ugc/clientai/aiservice/ohr/OHRPredictResult;", "", "hand", "", "leftPercent", "", "rightPercent", "touchArea", "Landroid/graphics/RectF;", "(IFFLandroid/graphics/RectF;)V", "confidence", "getConfidence", "()F", "getHand", "()I", "getLeftPercent", "getRightPercent", "getTouchArea", "()Landroid/graphics/RectF;", "setTouchArea", "(Landroid/graphics/RectF;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "service-ohr_release"}, k = 1, mv = {1, 4, 1})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f15792b;
    private final float c;
    private RectF d;

    public d(int r1, float r2, float r3, RectF r4) {
        this.f15791a = r1;
        this.f15792b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final int a() {
        return this.f15791a;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L15;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin");
        if (this.f15791a == r4.f15791a) goto L9;
        return false;
    L9:
        if (Float.compare(this.f15792b, r4.f15792b) == 0) goto L11;
        return false;
    L11:
        if (Float.compare(this.c, r4.c) == 0) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L23;
        return false;
    L23:
        return true;
    L15:
        return false;
    }

    public int hashCode() {
        int r0 = ((((Integer.hashCode(this.f15791a) * 31) + Float.hashCode(this.f15792b)) * 31) + Float.hashCode(this.c)) * 31;
        RectF r2 = this.d;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r0 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public String toString() {
        return "OHRPredictResult(hand=" + this.f15791a + ", leftPercent=" + this.f15792b + ", rightPercent=" + this.c + ", touchArea=" + this.d + ")";
    }
}
