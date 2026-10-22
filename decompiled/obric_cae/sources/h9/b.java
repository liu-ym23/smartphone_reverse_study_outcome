package h9;

import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: classes.dex */
public final class b implements TypeEvaluator<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f7948a = null;

    static {
        f7948a = new b();
    }

    @Override // android.animation.TypeEvaluator
    public final Integer evaluate(float r11, Integer r12, Integer r13) {
        int r10 = r12.intValue();
        float r14 = ((r10 >> 24) & 255) / 255.0f;
        int r15 = r13.intValue();
        float r8 = ((r15 >> 24) & 255) / 255.0f;
        float r16 = (float) Math.pow(((r10 >> 16) & 255) / 255.0f, 2.2d);
        float r17 = (float) Math.pow(((r10 >> 8) & 255) / 255.0f, 2.2d);
        float r18 = (float) Math.pow((r10 & 255) / 255.0f, 2.2d);
        float r19 = (float) Math.pow(((r15 >> 16) & 255) / 255.0f, 2.2d);
        float r20 = (float) Math.pow(((r15 >> 8) & 255) / 255.0f, 2.2d);
        float r110 = (float) Math.pow((r15 & 255) / 255.0f, 2.2d);
        float r111 = defpackage.a.a(r8, r14, r11, r14);
        float r21 = defpackage.a.a(r19, r16, r11, r16);
        float r22 = defpackage.a.a(r20, r17, r11, r17);
        float r112 = defpackage.a.a(r110, r18, r11, r18);
        float r113 = ((float) Math.pow(r21, 0.45454545454545453d)) * 255.0f;
        float r114 = ((float) Math.pow(r22, 0.45454545454545453d)) * 255.0f;
        float r115 = ((float) Math.pow(r112, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(r115) | (((Math.round(r113) << 16) | (Math.round(r111 * 255.0f) << 24)) | (Math.round(r114) << 8)));
    }
}
