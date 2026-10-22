package com.google.android.material.a;

import android.animation.TypeEvaluator;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class c implements TypeEvaluator<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f3743a = null;

    static {
        f3743a = new c();
    }

    public c() {
    }

    public static c a() {
        return f3743a;
    }

    public Integer a(float r11, Integer r12, Integer r13) {
        int r10 = r12.intValue();
        float r14 = ((r10 >> 24) & 255) / 255.0f;
        int r15 = r13.intValue();
        float r1 = (float) Math.pow(((r10 >> 16) & 255) / 255.0f, 2.2d);
        float r2 = (float) Math.pow(((r10 >> 8) & 255) / 255.0f, 2.2d);
        float r16 = (float) Math.pow((r10 & 255) / 255.0f, 2.2d);
        float r4 = (float) Math.pow(((r15 >> 16) & 255) / 255.0f, 2.2d);
        float r17 = r14 + (((((r15 >> 24) & 255) / 255.0f) - r14) * r11);
        float r3 = r2 + ((((float) Math.pow(((r15 >> 8) & 255) / 255.0f, 2.2d)) - r2) * r11);
        float r18 = r16 + (r11 * (((float) Math.pow((r15 & 255) / 255.0f, 2.2d)) - r16));
        float r19 = ((float) Math.pow(r1 + ((r4 - r1) * r11), 0.45454545454545453d)) * 255.0f;
        float r110 = ((float) Math.pow(r3, 0.45454545454545453d)) * 255.0f;
        float r111 = ((float) Math.pow(r18, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(r111) | (((Math.round(r19) << 16) | (Math.round(r17 * 255.0f) << 24)) | (Math.round(r110) << 8)));
    }

    @Override // android.animation.TypeEvaluator
    public /* synthetic */ Integer evaluate(float r3, Integer r4, Integer r5) {
        return a(r3, (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin"), (Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin"));
    }
}
