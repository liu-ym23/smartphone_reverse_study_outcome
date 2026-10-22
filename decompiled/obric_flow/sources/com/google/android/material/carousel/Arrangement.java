package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.a;
import androidx.core.math.MathUtils;

/* JADX INFO: loaded from: classes2.dex */
final class Arrangement {
    private static final float MEDIUM_ITEM_FLEX_PERCENTAGE = 0.1f;
    final float cost;
    final int largeCount;
    float largeSize;
    int mediumCount;
    float mediumSize;
    final int priority;
    int smallCount;
    float smallSize;

    public Arrangement(int r5, float r10, float r11, float r12, int r13, float r14, int r15, float r16, int r17, float r18) {
        this.priority = r5;
        this.smallSize = MathUtils.clamp(r10, r11, r12);
        this.smallCount = r13;
        this.mediumSize = r14;
        this.mediumCount = r15;
        this.largeSize = r16;
        this.largeCount = r17;
        fit(r18, r11, r12, r16);
        this.cost = cost(r16);
    }

    private float calculateLargeSize(float r5, int r10, float r11, int r12, int r13) {
        if (r10 > 0) goto L5;
        r11 = 0.0f;
    L5:
        float r14 = r10;
        float r15 = r12 / 2.0f;
        return (r5 - ((r14 + r15) * r11)) / (r13 + r15);
    }

    private float cost(float r5) {
        if (isValid() == true) goto L7;
        return Float.MAX_VALUE;
    L7:
        return Math.abs(r5 - this.largeSize) * this.priority;
    }

    public static Arrangement findLowestCostArrangement(float r25, float r26, float r27, float r28, int[] r29, float r30, int[] r31, float r32, int[] r33) {
        int r5 = r33.length;
        Arrangement r10 = null;
        int r11 = 1;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L19;
        int r19 = r33[r12];
        int r15 = r31.length;
        int r14 = 0;
    L5:
        if (r14 >= r15) goto L18;
        int r20 = r31[r14];
        int r13 = r29.length;
        int r16 = 0;
    L7:
        if (r16 >= r13) goto L17;
        int r17 = r11;
        int r21 = r16;
        int r22 = r13;
        int r23 = r14;
        int r24 = r15;
        Arrangement r18 = new Arrangement(r17, r26, r27, r28, r29[r16], r30, r20, r32, r19, r25);
        if (r10 == null) goto L13;
        if (r18.cost < r10.cost) goto L13;
    L16:
        r11 = r11 + 1;
        r16 = r21 + 1;
        r13 = r22;
        r14 = r23;
        r15 = r24;
    L13:
        if (r18.cost == 0.0f) goto L14;
        r10 = r18;
        goto L16
    L14:
        return r18;
    L17:
        r14 = r14 + 1;
        goto L5
    L18:
        r12 = r12 + 1;
        goto L3
    L19:
        return r10;
    }

    private void fit(float r10, float r11, float r12, float r13) {
        float r5 = r10 - getSpace();
        int r14 = this.smallCount;
        if (r14 > 0) goto L5;
    L7:
        if (r14 > 0) goto L9;
    L11:
        int r15 = this.smallCount;
        if (r15 <= 0) goto L14;
        float r16 = this.smallSize;
    L15:
        this.smallSize = r16;
        float r17 = calculateLargeSize(r10, r15, r16, this.mediumCount, this.largeCount);
        this.largeSize = r17;
        float r18 = (this.smallSize + r17) / 2.0f;
        this.mediumSize = r18;
        int r19 = this.mediumCount;
        if (r19 > 0) goto L18;
        return;
    L18:
        if (r17 == r13) goto L25;
        float r110 = (r13 - r17) * this.largeCount;
        float r111 = Math.min(Math.abs(r110), (r18 * 0.1f) * r19);
        if (r110 <= 0.0f) goto L22;
        this.mediumSize -= r111 / this.mediumCount;
        this.largeSize = (r111 / this.largeCount) + this.largeSize;
        return;
    L22:
        this.mediumSize = (r111 / this.mediumCount) + this.mediumSize;
        this.largeSize -= r111 / this.largeCount;
        return;
    L25:
        return;
    L14:
        r16 = 0.0f;
        goto L15
    L9:
        if (r5 >= 0.0f) goto L11;
        float r112 = this.smallSize;
        this.smallSize = Math.max(r5 / r14, r11 - r112) + r112;
        goto L11
    L5:
        if (r5 <= 0.0f) goto L7;
        float r113 = this.smallSize;
        this.smallSize = Math.min(r5 / r14, r12 - r113) + r113;
        goto L11
    }

    private float getSpace() {
        return (this.smallSize * this.smallCount) + ((this.mediumSize * this.mediumCount) + (this.largeSize * this.largeCount));
    }

    private boolean isValid() {
        int r5 = this.largeCount;
        if (r5 > 0) goto L5;
    L14:
        if (r5 > 0) goto L16;
    L21:
        return true;
    L16:
        if (this.smallCount <= 0) goto L21;
        if (this.largeSize > this.smallSize) goto L20;
        return false;
    L20:
        return true;
    L5:
        if (this.smallCount <= 0) goto L14;
        if (this.mediumCount <= 0) goto L14;
        float r10 = this.largeSize;
        float r11 = this.mediumSize;
        if (r10 > r11) goto L11;
        return false;
    L11:
        if (r11 > this.smallSize) goto L13;
        return false;
    L13:
        return true;
    }

    public int getItemCount() {
        return (this.smallCount + this.mediumCount) + this.largeCount;
    }

    @NonNull
    public String toString() {
        StringBuilder r5 = new StringBuilder("Arrangement [priority=");
        r5.append(this.priority);
        r5.append(", smallCount=");
        r5.append(this.smallCount);
        r5.append(", smallSize=");
        r5.append(this.smallSize);
        r5.append(", mediumCount=");
        r5.append(this.mediumCount);
        r5.append(", mediumSize=");
        r5.append(this.mediumSize);
        r5.append(", largeCount=");
        r5.append(this.largeCount);
        r5.append(", largeSize=");
        r5.append(this.largeSize);
        r5.append(", cost=");
        return a.r(r5, this.cost, "]");
    }
}
