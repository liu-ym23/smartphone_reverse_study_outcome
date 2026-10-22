package lp;

import com.lynx.tasm.animation.keyframe.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f19690a = 0;

    static {
        float[] r5 = new float[5];
        Intrinsics.checkNotNullParameter(r5, "roots");
        double r10 = 0.0f;
        double r11 = 3.0f;
        double r12 = r11 * 2.0d;
        double r13 = (r10 - r12) + r10;
        int r14 = 0;
        if (r13 == 0.0d) goto L13;
        double r15 = -Math.sqrt((r11 * r11) - (r10 * r10));
        double r16 = (-r10) + r11;
        int r17 = a((float) ((-(r15 + r16)) / r13), r5, 0);
        int r18 = a((float) ((r15 - r16) / r13), r5, r17) + r17;
        if (r18 <= 1) goto L16;
        float r19 = r5[0];
        float r20 = r5[1];
        if (r19 <= r20) goto L10;
        r5[0] = r20;
        r5[1] = r19;
        goto L16
    L10:
        if (r19 != r20) goto L16;
        r18 = r18 - 1;
    L16:
        int r21 = a(0.5f, r5, r18) + r18;
        float r22 = Math.min(0.0f, 1.0f);
        float r23 = Math.max(0.0f, 1.0f);
    L17:
        if (r14 >= r21) goto L19;
        float r24 = r5[r14];
        float r25 = ((((((-2.0f) * r24) + 3.0f) * r24) + 0.0f) * r24) + 0.0f;
        r22 = Math.min(r22, r25);
        r23 = Math.max(r23, r25);
        r14 = r14 + 1;
        goto L17
    L19:
        long r26 = new e(r22, r23).f10098b;
        Float.intBitsToFloat((int) (r26 >> 32));
        Float.intBitsToFloat((int) (4294967295L & r26));
        return;
    L13:
        if (r11 == r10) goto L15;
        r18 = a((float) ((r12 - r10) / (r12 - (r10 * 2.0d))), r5, 0);
        goto L16
    L15:
        r18 = 0;
        goto L16
    }

    public static final int a(float r5, float[] r10, int r11) {
        float r12 = 0.0f;
        if (r5 < 0.0f) goto L5;
        r12 = 1.0f;
        if (r5 > 1.0f) goto L11;
    L13:
        r10[r11] = r5;
        return !Float.isNaN(r5) ? 1 : 0;
    L11:
        if (r5 <= 1.0000008f) goto L6;
    L7:
        r5 = Float.NaN;
    L6:
        r5 = r12;
        goto L13
    L5:
        if (r5 < (-8.34465E-7f)) goto L7;
        goto L6
    }
}
