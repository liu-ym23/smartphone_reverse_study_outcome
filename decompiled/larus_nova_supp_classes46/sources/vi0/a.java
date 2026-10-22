package vi0;

import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends com.bytedance.android.live.liveinteract.videotalk.utils.c {
    public final float b;
    public final float c;
    public final float d;
    public final float e;

    @Override // com.bytedance.android.live.liveinteract.videotalk.utils.c
    public final Path b(int r1, int r2, int r3) {
        return c(r1, 0.0f, 0.0f);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.utils.c
    public final Path c(int r4, float r5, float r6) {
        float r7 = this.d + (r4 * this.b);
        float r8 = this.e;
        RectF r0 = new RectF(r7, r8, this.b + r7, this.c + r8);
        if (r4 != 0) goto L5;
        float[] r9 = {20.0f, 20.0f, 0.0f, 0.0f, 0.0f, 0.0f, 20.0f, 20.0f};
    L6:
        Path r10 = new Path();
        r10.addRoundRect(r0, r9, Path.Direction.CW);
        return r10;
    L5:
        r9 = new float[]{0.0f, 0.0f, 20.0f, 20.0f, 20.0f, 20.0f, 0.0f, 0.0f};
        goto L6
    }

    public a(float r1, float r2, float r3, float r4) {
        this.d = r1;
        this.e = r2;
        this.b = r3 / 2.0f;
        this.c = r4 / 1.0f;
    }
}
