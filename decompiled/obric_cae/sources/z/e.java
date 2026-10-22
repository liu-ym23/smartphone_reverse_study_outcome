package z;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f14144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f14145b;

    public e(int r8, int r10) {
        this.f14144a = new int[]{r8, r10};
        this.f14145b = new float[]{0.0f, 1.0f};
    }

    public e(int r8, int r10, int r11) {
        this.f14144a = new int[]{r8, r10, r11};
        this.f14145b = new float[]{0.0f, 0.5f, 1.0f};
    }

    public e(ArrayList r8, ArrayList r10) {
        int r11 = r8.size();
        this.f14144a = new int[r11];
        this.f14145b = new float[r11];
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.f14144a[r12] = ((Integer) r8.get(r12)).intValue();
        this.f14145b[r12] = ((Float) r10.get(r12)).floatValue();
        r12 = r12 + 1;
        goto L3
    }
}
