package c64;

import android.util.Size;
import android.widget.ImageView;
import com.bytedance.awemeopen.infra.base.player.resize.VideoScaleModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements d {
    public c() {
    }

    @Override // c64.d
    public final b a(int r4, int r5, int r6, int r7) {
        boolean r0 = false;
        if (r4 <= r5) goto L5;
        boolean r2 = true;
    L6:
        if (r6 <= r7) goto L9;
        r0 = true;
    L9:
        if ((r0 ^ r2) == true) goto L28;
        int r1 = f.a;
        if (r6 <= 0) goto L25;
        if (r7 <= 0) goto L25;
        if (r4 > r6) goto L19;
        if (r5 > r7) goto L19;
        float r8 = r4;
        float r9 = r5;
        float r10 = Math.min((r8 * 1.0f) / r6, (1.0f * r9) / r7);
        Size r11 = new Size((int) (r8 / r10), (int) (r9 / r10));
    L27:
        return new b(r11, ImageView.ScaleType.CENTER_CROP, VideoScaleModel.FILL);
    L19:
        if (r4 <= r6) goto L22;
        if (r5 <= r7) goto L22;
        float r12 = r4;
        float r13 = r5;
        float r14 = Math.min((r12 * 1.0f) / r6, (1.0f * r13) / r7);
        r11 = new Size((int) (r12 / r14), (int) (r13 / r14));
    L22:
        if (r4 >= r6) goto L24;
        float r15 = r4;
        float r3 = (1.0f * r15) / r6;
        r11 = new Size((int) (r15 / r3), (int) (r5 / r3));
        goto L27
    L24:
        float r16 = r5;
        float r17 = (1.0f * r16) / r7;
        r11 = new Size((int) (r4 / r17), (int) (r16 / r17));
    L25:
        r11 = new Size(r4, r5);
        goto L27
    L28:
        return new b(f.a(r4, r5, r6, r7), ImageView.ScaleType.FIT_CENTER, VideoScaleModel.FIT);
    L5:
        r2 = false;
        goto L6
    }
}
