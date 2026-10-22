package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ArgbEvaluator implements TypeEvaluator {
    private static final ArgbEvaluator sInstance = null;

    static {
        sInstance = new ArgbEvaluator();
    }

    public ArgbEvaluator() {
    }

    public static ArgbEvaluator getInstance() {
        return sInstance;
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float r11, Object r12, Object r13) {
        int r10 = ((Integer) r12).intValue();
        float r14 = ((r10 >> 24) & 255) / 255.0f;
        int r15 = ((Integer) r13).intValue();
        float r16 = (float) Math.pow(((r10 >> 16) & 255) / 255.0f, 2.2d);
        float r17 = (float) Math.pow(((r10 >> 8) & 255) / 255.0f, 2.2d);
        float r18 = (float) Math.pow((r10 & 255) / 255.0f, 2.2d);
        float r19 = (float) Math.pow(((r15 >> 16) & 255) / 255.0f, 2.2d);
        float r110 = r14 + (((((r15 >> 24) & 255) / 255.0f) - r14) * r11);
        float r20 = r17 + ((((float) Math.pow(((r15 >> 8) & 255) / 255.0f, 2.2d)) - r17) * r11);
        float r111 = r18 + (r11 * (((float) Math.pow((r15 & 255) / 255.0f, 2.2d)) - r18));
        float r112 = ((float) Math.pow(r16 + ((r19 - r16) * r11), 0.45454545454545453d)) * 255.0f;
        float r113 = ((float) Math.pow(r20, 0.45454545454545453d)) * 255.0f;
        float r114 = ((float) Math.pow(r111, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(r114) | (((Math.round(r112) << 16) | (Math.round(r110 * 255.0f) << 24)) | (Math.round(r113) << 8)));
    }
}
