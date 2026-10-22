package com.obric.common.oea.foundation.animation.token;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001a\u0011\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0082\b\u001a8\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u001a\u0011\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\b\u001a\u001e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007\u001a0\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002\u001a\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007\u001a&\u0010 \u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007\u001a+\u0010!\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0082\b\u001a2\u0010\"\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0011\u0010#\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0014H\u0086\b\u001a \u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0000\u001a\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0000\u001a \u0010,\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0015\u0010-\u001a\u00020.*\u00020\u00012\u0006\u0010/\u001a\u00020\u0001H\u0080\b\u001a\u0015\u00100\u001a\u00020\u0001*\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0086\b\u001a\u0015\u00100\u001a\u00020\u0007*\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0086\b\u001a\u0015\u00102\u001a\u00020\u0001*\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0086\b\u001a\u0015\u00102\u001a\u00020\u0007*\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0086\b\u001a\u001d\u00104\u001a\u00020\u0001*\u00020\u00012\u0006\u00101\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0086\b\u001a\u001d\u00104\u001a\u00020\u0007*\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0086\b\u001a\r\u00105\u001a\u00020\u0014*\u00020\u0001H\u0086\b\u001a\r\u00105\u001a\u00020\u0014*\u00020\u0007H\u0086\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Epsilon", "", "FastOutSlowInEasing", "Lcom/obric/common/oea/foundation/animation/token/Easing;", "getFastOutSlowInEasing", "()Lcom/obric/common/oea/foundation/animation/token/Easing;", "FloatEpsilon", "", "Tau", "clampValidRootInUnitRange", "r", "computeCubicVerticalBounds", "Lcom/obric/common/oea/foundation/animation/util/FloatFloatPair;", "p0y", "p1y", "p2y", "p3y", "roots", "", "index", "", "doubleFromBits", "bits", "", "evaluateCubic", "p1", "p2", "t", "p0", "p3", "fastCbrt", "x", "findFirstCubicRoot", "findLineRoot", "findQuadraticRoots", "floatFromBits", "lerp", CommonConsts.APM_INNER_EVENT_COST_START, "stop", "fraction", "throwIllegalArgumentException", "", "message", "", "writeValidRootInUnitRange", "closeTo", "", "b", "fastCoerceAtLeast", "minimumValue", "fastCoerceAtMost", "maximumValue", "fastCoerceIn", "fastRoundToInt", "foundation_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f7726a = null;

    static {
        f7726a = (b) ZeusTransformUtils.preCheckCast(new a(0.4f, 0.0f, 0.2f, 1.0f), b.class, "com.obric.memorydata.plugin");
    }

    public static final float a(float r4) {
        float r0 = Float.intBitsToFloat(((int) ((((long) Float.floatToRawIntBits(r4)) & 8589934591L) / ((long) 3))) + 709952852);
        float r1 = r0 - ((r0 - (r4 / (r0 * r0))) * 0.33333334f);
        return r1 - ((r1 - (r4 / (r1 * r1))) * 0.33333334f);
    }

    public static final float a(float r2, float r3, float r4) {
        float r0 = (r2 - r3) + 0.33333334f;
        float r1 = r0 * r4;
        return ((((r1 + (r3 - (2.0f * r2))) * r4) + r2) * 3.0f) * r4;
    }

    public static final float a(float r24, float r25, float r26, float r27) {
        double r3 = r24;
        double r5 = ((r3 - (((double) r25) * 2.0d)) + ((double) r26)) * 3.0d;
        double r11 = ((double) (r25 - r24)) * 3.0d;
        double r13 = (((double) (-r24)) + (((double) (r25 - r26)) * 3.0d)) + ((double) r27);
        boolean r15 = true;
        if (Math.abs(r13 - 0.0d) >= 1.0E-7d) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L9;
        double r6 = r5 / r13;
        double r12 = r11 / r13;
        double r4 = r3 / r13;
        double r14 = ((r12 * 3.0d) - (r6 * r6)) / 9.0d;
        double r7 = (((((2.0d * r6) * r6) * r6) - ((9.0d * r6) * r12)) + (r4 * 27.0d)) / 54.0d;
        double r16 = (r14 * r14) * r14;
        double r8 = (r7 * r7) + r16;
        double r9 = r6 / 3.0d;
        if (r8 >= 0.0d) goto L109;
        double r10 = Math.sqrt(-r16);
        double r17 = (-r7) / r10;
        double r18 = 1.0d;
        if (r17 >= (-1.0d)) goto L65;
        r17 = -1.0d;
    L65:
        if (r17 > 1.0d) goto L68;
        r18 = r17;
    L68:
        double r19 = Math.acos(r18);
        double r0 = a((float) r10) * 2.0f;
        float r20 = (float) ((Math.cos(r19 / 3.0d) * r0) - r9);
        if (r20 >= 0.0f) goto L75;
        if (r20 < (-8.34465E-7f)) goto L73;
        r20 = 0.0f;
    L80:
        if (Float.isNaN(r20) == true) goto L82;
        return r20;
    L82:
        float r21 = (float) ((Math.cos((6.283185307179586d + r19) / 3.0d) * r0) - r9);
        if (r21 >= 0.0f) goto L89;
        if (r21 < (-8.34465E-7f)) goto L87;
        r21 = 0.0f;
    L94:
        if (Float.isNaN(r21) == true) goto L96;
        return r21;
    L96:
        float r1 = (float) ((r0 * Math.cos((r19 + 12.566370614359172d) / 3.0d)) - r9);
        if (r1 >= 0.0f) goto L103;
        if (r1 < (-8.34465E-7f)) goto L157;
        return 0.0f;
    L157:
        return Float.NaN;
    L103:
        if (r1 <= 1.0f) goto L108;
        if (r1 > 1.0000008f) goto L157;
        return 1.0f;
    L108:
        return r1;
    L87:
        r21 = Float.NaN;
        goto L94
    L89:
        if (r21 <= 1.0f) goto L94;
        if (r21 > 1.0000008f) goto L87;
        r21 = 1.0f;
    L73:
        r20 = Float.NaN;
        goto L80
    L75:
        if (r20 <= 1.0f) goto L80;
        if (r20 > 1.0000008f) goto L73;
        r20 = 1.0f;
        goto L80
    L109:
        if (r8 != 0.0d) goto L137;
        float r22 = -a((float) r7);
        float r23 = (float) r9;
        float r28 = (2.0f * r22) - r23;
        if (r28 >= 0.0f) goto L117;
        if (r28 < (-8.34465E-7f)) goto L115;
        r28 = 0.0f;
    L122:
        if (Float.isNaN(r28) == true) goto L124;
        return r28;
    L124:
        float r29 = (-r22) - r23;
        if (r29 >= 0.0f) goto L131;
        if (r29 < (-8.34465E-7f)) goto L160;
        return 0.0f;
    L160:
        return Float.NaN;
    L131:
        if (r29 <= 1.0f) goto L136;
        if (r29 > 1.0000008f) goto L160;
        return 1.0f;
    L136:
        return r29;
    L115:
        r28 = Float.NaN;
        goto L122
    L117:
        if (r28 <= 1.0f) goto L122;
        if (r28 > 1.0000008f) goto L115;
        r28 = 1.0f;
        goto L122
    L137:
        double r30 = Math.sqrt(r8);
        float r31 = (float) (((double) (a((float) ((-r7) + r30)) - a((float) (r7 + r30)))) - r9);
        if (r31 >= 0.0f) goto L144;
        if (r31 < (-8.34465E-7f)) goto L163;
        return 0.0f;
    L163:
        return Float.NaN;
    L144:
        if (r31 <= 1.0f) goto L149;
        if (r31 > 1.0000008f) goto L163;
        return 1.0f;
    L149:
        return r31;
    L9:
        if (Math.abs(r5 - 0.0d) >= 1.0E-7d) goto L11;
        boolean r32 = true;
    L12:
        if (r32 == true) goto L14;
        double r33 = Math.sqrt((r11 * r11) - ((4.0d * r5) * r3));
        double r34 = r5 * 2.0d;
        float r35 = (float) ((r33 - r11) / r34);
        if (r35 >= 0.0f) goto L39;
        if (r35 < (-8.34465E-7f)) goto L37;
        r35 = 0.0f;
    L44:
        if (Float.isNaN(r35) == true) goto L46;
        return r35;
    L46:
        float r36 = (float) (((-r11) - r33) / r34);
        if (r36 >= 0.0f) goto L53;
        if (r36 < (-8.34465E-7f)) goto L154;
        return 0.0f;
    L154:
        return Float.NaN;
    L53:
        if (r36 <= 1.0f) goto L58;
        if (r36 > 1.0000008f) goto L154;
        return 1.0f;
    L58:
        return r36;
    L37:
        r35 = Float.NaN;
        goto L44
    L39:
        if (r35 <= 1.0f) goto L44;
        if (r35 > 1.0000008f) goto L37;
        r35 = 1.0f;
        goto L44
    L14:
        if (Math.abs(r11 - 0.0d) < 1.0E-7d) goto L17;
        r15 = false;
    L17:
        if (r15 == false) goto L19;
        return Float.NaN;
    L19:
        float r37 = (float) ((-r3) / r11);
        if (r37 >= 0.0f) goto L26;
        if (r37 < (-8.34465E-7f)) goto L151;
        return 0.0f;
    L151:
        return Float.NaN;
    L26:
        if (r37 <= 1.0f) goto L31;
        if (r37 > 1.0000008f) goto L151;
        return 1.0f;
    L31:
        return r37;
    L11:
        r32 = false;
        goto L12
    L5:
        r2 = false;
        goto L7
    }

    private static final float a(float r2, float r3, float r4, float r5, float r6) {
        float r7 = (r5 + ((r3 - r4) * 3.0f)) - r2;
        float r8 = ((r4 - (2.0f * r3)) + r2) * 3.0f;
        float r9 = ((r7 * r6) + r8) * r6;
        return ((r9 + ((r3 - r2) * 3.0f)) * r6) + r2;
    }

    private static final int a(float r17, float r18, float r19, float[] r20, int r21) {
        double r3 = r17;
        double r5 = r18;
        double r7 = r19;
        double r11 = r5 * 2.0d;
        double r13 = (r3 - r11) + r7;
        if (r13 == 0.0d) goto L13;
        double r8 = -Math.sqrt((r5 * r5) - (r7 * r3));
        double r4 = (-r3) + r5;
        int r1 = b((float) ((-(r8 + r4)) / r13), r20, r21) + 0;
        int r15 = r1 + b((float) ((r8 - r4) / r13), r20, r21 + r1);
        if (r15 <= 1) goto L16;
        float r2 = r20[r21];
        int r6 = r21 + 1;
        float r9 = r20[r6];
        if (r2 <= r9) goto L10;
        r20[r21] = r9;
        r20[r6] = r2;
        return r15;
    L10:
        if (r2 == r9) goto L19;
        return r15;
    L19:
        return r15 - 1;
    L16:
        return r15;
    L13:
        if (r5 != r7) goto L15;
        return 0;
    L15:
        return 0 + b((float) ((r11 - r7) / (r11 - (r7 * 2.0d))), r20, r21);
    }

    public static final /* synthetic */ int a(float r0, float[] r1, int r2) {
        return b(r0, r1, r2);
    }

    public static final com.obric.common.oea.foundation.animation.e.a a(float r5, float r6, float r7, float r8, float[] r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "roots");
        float r0 = (r6 - r5) * 3.0f;
        float r2 = (r7 - r6) * 3.0f;
        float r3 = (r8 - r7) * 3.0f;
        int r1 = a(r0, r2, r3, r9, r10);
        float r4 = (r2 - r0) * 2.0f;
        float r11 = (r3 - r2) * 2.0f;
        float r12 = (-r4) / (r11 - r4);
        int r13 = r1 + a(r12, r9, r10 + r1);
        float r14 = Math.min(r5, r8);
        float r15 = Math.max(r5, r8);
        int r16 = 0;
    L3:
        if (r16 >= r13) goto L6;
        float r17 = a(r5, r6, r7, r8, r9[r16]);
        r14 = Math.min(r14, r17);
        r15 = Math.max(r15, r17);
        r16 = r16 + 1;
        goto L3
    L6:
        return new com.obric.common.oea.foundation.animation.e.a(r14, r15);
    }

    public static final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(r2), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static final float b(float r1, float r2, float r3) {
        return (r1 * (1 - r3)) + (r2 * r3);
    }

    private static final int b(float r4, float[] r5, int r6) {
        if (r4 >= 0.0f) goto L9;
        if (r4 < (-8.34465E-7f)) goto L7;
        r4 = 0.0f;
    L13:
        r5[r6] = r4;
        return !Float.isNaN(r4) ? 1 : 0;
    L7:
        r4 = Float.NaN;
        goto L13
    L9:
        if (r4 <= 1.0f) goto L13;
        if (r4 > 1.0000008f) goto L7;
        r4 = 1.0f;
        goto L13
    }
}
