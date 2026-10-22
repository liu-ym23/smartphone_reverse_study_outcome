package com.ss.ugc.clientai.aiservice.ohr;

import android.graphics.RectF;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016J)\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0082\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/ss/ugc/clientai/aiservice/ohr/TouchAreaCalculator;", "", "()V", "TENSOR_SIZE", "", "allRecentTouchAreas", "", "Ljava/util/LinkedList;", "Landroid/graphics/RectF;", "[Ljava/util/LinkedList;", "calculationCount", "<set-?>", "hand", "getHand", "()I", "touchArea", "getTouchArea", "()Landroid/graphics/RectF;", "touchAreas", "[Landroid/graphics/RectF;", "areaOfPoints", "inputBuffer", "", "calculateLast", "", "updateInputs", "updateValue", "largestArea", "nextLargestArea", "smallestArea", "newArea", "service-ohr_release"}, k = 1, mv = {1, 4, 1})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectF[] f15805b;
    private final LinkedList<RectF>[] c;
    private int d;
    private final int e;

    public g() {
        this.f15804a = 15;
        this.f15805b = new RectF[]{new RectF(), new RectF()};
        this.c = new LinkedList[]{new LinkedList(), new LinkedList()};
        this.e = 6;
    }

    private final RectF a(float[] r8) {
        RectF r0 = new RectF();
        int r1 = r8.length / this.e;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L25;
        int r3 = this.e;
        float r4 = r8[r2 * r3];
        float r5 = r8[(r3 * r2) + 1];
        if (r0.left != 0.0f) goto L7;
    L8:
        r0.left = r4;
    L10:
        if (r0.top != 0.0f) goto L12;
    L13:
        r0.top = r5;
    L15:
        if (r0.right != 0.0f) goto L17;
    L18:
        r0.right = r4;
    L20:
        if (r0.bottom != 0.0f) goto L22;
    L23:
        r0.bottom = r5;
    L24:
        r2 = r2 + 1;
        goto L3
    L22:
        if (r5 <= r0.bottom) goto L24;
    L17:
        if (r4 <= r0.right) goto L20;
    L12:
        if (r5 >= r0.top) goto L15;
    L7:
        if (r4 >= r0.left) goto L10;
    L25:
        return r0;
    }

    public final void a(int r3, float[] r4) {
        Intrinsics.checkNotNullParameter(r4, "inputBuffer");
        if (r3 != 1) goto L5;
    L7:
        this.d = r3;
        LinkedList<RectF> r5 = this.c[r3 - 1];
        monitor-enter(r5);
        r5.offerLast(a(r4));     // Catch: Throwable -> L15
        if (r5.size() <= this.f15804a) goto L12;
        r5.removeFirst();     // Catch: Throwable -> L15
    L12:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r5);
        return;
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r3 == 2) goto L7;
    }
}
