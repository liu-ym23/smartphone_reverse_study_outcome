package ag;

import com.facebook.imagepipeline.animated.base.AnimatedImage;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements AnimatedImage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e[] f164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f165b;

    public d(e[] r5) {
        this.f164a = r5;
        this.f165b = new int[r5.length];
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.f165b[r11] = this.f164a[r11].f166a;
        r11 = r11 + 1;
        goto L3
    }
}
