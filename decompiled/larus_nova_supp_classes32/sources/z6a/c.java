package z6a;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public final List<Float> a;

    public c(List<Float> r1) {
        this.a = r1;
    }

    public final float a(int r6, float r7, float r8, float r9) {
        float r0 = r9 - r8;
        switch(r6) {
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L13;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        r7 = 0.0f;
        goto L13
    L5:
        r7 = ((((-((Float) ListProtector.get(this.a, 0)).floatValue()) - ((Float) ListProtector.get(this.a, 1)).floatValue()) + r8) + r9) * 0.5f;
        goto L13
    L6:
        r7 = (r7 * ((Float) ListProtector.get(this.a, 3)).floatValue()) / 100.0f;
        goto L13
    L7:
        r7 = r9 - ((Float) ListProtector.get(this.a, 1)).floatValue();
        goto L13
    L8:
        r7 = ((r9 + r8) + ((Float) ListProtector.get(this.a, 2)).floatValue()) * 0.5f;
        goto L13
    L9:
        r7 = r8 - ((Float) ListProtector.get(this.a, 0)).floatValue();
        goto L13
    L10:
        r7 = r0 * 0.1f;
        goto L13
    L11:
        r7 = (-r0) * 0.1f;
    L13:
        return (-r7) + r8;
    }
}
