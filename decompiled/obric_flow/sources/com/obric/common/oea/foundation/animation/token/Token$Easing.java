package com.obric.common.oea.foundation.animation.token;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u001d\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"com/obric/common/oea/foundation/animation/token/Token$Easing", "", "Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "", "values", "[F", "getValues", "()[F", "OUI_ANIMATION_EASING_LINEAR", "OUI_ANIMATION_EASING_STANDARD", "OUI_ANIMATION_EASING_EASE", "OUI_ANIMATION_EASING_EASE_IN", "OUI_ANIMATION_EASING_EASE_OUT", "OUI_ANIMATION_EASING_EASE_IN_OUT", "OUI_ANIMATION_EASING_EASE_IN_SINE", "OUI_ANIMATION_EASING_EASE_OUT_SINE", "OUI_ANIMATION_EASING_EASE_IN_OUT_SINE", "OUI_ANIMATION_EASING_EASE_IN_QUAD", "OUI_ANIMATION_EASING_EASE_OUT_QUAD", "OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD", "OUI_ANIMATION_EASING_EASE_IN_CUBIC", "OUI_ANIMATION_EASING_EASE_OUT_CUBIC", "OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC", "OUI_ANIMATION_EASING_EASE_IN_QUART", "OUI_ANIMATION_EASING_EASE_OUT_QUART", "OUI_ANIMATION_EASING_EASE_IN_OUT_QUART", "OUI_ANIMATION_EASING_EASE_IN_QUINT", "OUI_ANIMATION_EASING_EASE_OUT_QUINT", "OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT", "OUI_ANIMATION_EASING_EASE_IN_EXPO", "OUI_ANIMATION_EASING_EASE_OUT_EXPO", "OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum Token$Easing extends Enum<Token$Easing> {
    public static final Token$Easing OUI_ANIMATION_EASING_EASE = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_CUBIC = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_EXPO = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_QUART = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_SINE = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_QUAD = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_QUART = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_QUINT = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_SINE = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_CUBIC = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_EXPO = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_QUAD = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_QUART = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_QUINT = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_SINE = null;
    public static final Token$Easing OUI_ANIMATION_EASING_LINEAR = null;
    public static final Token$Easing OUI_ANIMATION_EASING_STANDARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Token$Easing[] f11330a = null;
    private final float[] values;

    static {
        Token$Easing r5 = new Token$Easing("OUI_ANIMATION_EASING_LINEAR", new float[]{0.0f, 0.0f, 1.0f, 1.0f}, 0);
        OUI_ANIMATION_EASING_LINEAR = r5;
        Token$Easing r10 = new Token$Easing("OUI_ANIMATION_EASING_STANDARD", new float[]{0.34f, 0.69f, 0.1f, 1.0f}, 1);
        OUI_ANIMATION_EASING_STANDARD = r10;
        Token$Easing r11 = new Token$Easing("OUI_ANIMATION_EASING_EASE", new float[]{0.25f, 0.1f, 0.25f, 1.0f}, 2);
        OUI_ANIMATION_EASING_EASE = r11;
        Token$Easing r12 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN", new float[]{0.42f, 0.0f, 1.0f, 1.0f}, 3);
        OUI_ANIMATION_EASING_EASE_IN = r12;
        Token$Easing r13 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT", new float[]{0.0f, 0.0f, 0.58f, 1.0f}, 4);
        OUI_ANIMATION_EASING_EASE_OUT = r13;
        Token$Easing r14 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT", new float[]{0.42f, 0.0f, 0.58f, 1.0f}, 5);
        OUI_ANIMATION_EASING_EASE_IN_OUT = r14;
        Token$Easing r15 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_SINE", new float[]{0.47f, 0.0f, 0.745f, 0.715f}, 6);
        OUI_ANIMATION_EASING_EASE_IN_SINE = r15;
        Token$Easing r16 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_SINE", new float[]{0.39f, 0.575f, 0.565f, 1.0f}, 7);
        OUI_ANIMATION_EASING_EASE_OUT_SINE = r16;
        Token$Easing r17 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_SINE", new float[]{0.445f, 0.05f, 0.55f, 0.95f}, 8);
        OUI_ANIMATION_EASING_EASE_IN_OUT_SINE = r17;
        Token$Easing r18 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_QUAD", new float[]{0.26f, 0.0f, 0.6f, 0.2f}, 9);
        OUI_ANIMATION_EASING_EASE_IN_QUAD = r18;
        Token$Easing r19 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_QUAD", new float[]{0.4f, 0.8f, 0.74f, 1.0f}, 10);
        OUI_ANIMATION_EASING_EASE_OUT_QUAD = r19;
        Token$Easing r110 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD", new float[]{0.48f, 0.04f, 0.52f, 0.96f}, 11);
        OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD = r110;
        Token$Easing r111 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_CUBIC", new float[]{0.4f, 0.0f, 0.68f, 0.06f}, 12);
        OUI_ANIMATION_EASING_EASE_IN_CUBIC = r111;
        Token$Easing r20 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_CUBIC", new float[]{0.32f, 0.94f, 0.6f, 1.0f}, 13);
        OUI_ANIMATION_EASING_EASE_OUT_CUBIC = r20;
        Token$Easing r21 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC", new float[]{0.66f, 0.0f, 0.34f, 1.0f}, 14);
        OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC = r21;
        Token$Easing r22 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_QUART", new float[]{0.52f, 0.0f, 0.74f, 0.0f}, 15);
        OUI_ANIMATION_EASING_EASE_IN_QUART = r22;
        Token$Easing r23 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_QUART", new float[]{0.26f, 1.0f, 0.48f, 1.0f}, 16);
        OUI_ANIMATION_EASING_EASE_OUT_QUART = r23;
        Token$Easing r24 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_QUART", new float[]{0.76f, 0.0f, 0.24f, 1.0f}, 17);
        OUI_ANIMATION_EASING_EASE_IN_OUT_QUART = r24;
        Token$Easing r25 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_QUINT", new float[]{0.64f, 0.0f, 0.78f, 0.0f}, 18);
        OUI_ANIMATION_EASING_EASE_IN_QUINT = r25;
        Token$Easing r26 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_QUINT", new float[]{0.22f, 1.0f, 0.36f, 1.0f}, 19);
        OUI_ANIMATION_EASING_EASE_OUT_QUINT = r26;
        Token$Easing r27 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT", new float[]{0.84f, 0.0f, 0.16f, 1.0f}, 20);
        OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT = r27;
        Token$Easing r28 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_EXPO", new float[]{0.66f, 0.0f, 0.86f, 0.0f}, 21);
        OUI_ANIMATION_EASING_EASE_IN_EXPO = r28;
        Token$Easing r29 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_EXPO", new float[]{0.14f, 1.0f, 0.34f, 1.0f}, 22);
        OUI_ANIMATION_EASING_EASE_OUT_EXPO = r29;
        Token$Easing r30 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO", new float[]{0.9f, 0.0f, 0.1f, 1.0f}, 23);
        OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO = r30;
        f11330a = new Token$Easing[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30};
    }

    public Token$Easing(String r5, float[] r10, int r11) {
        super(r5, r11);
        this.values = r10;
    }

    public static Token$Easing valueOf(String r5) {
        return (Token$Easing) Enum.valueOf(Token$Easing.class, r5);
    }

    public static Token$Easing[] values() {
        return (Token$Easing[]) f11330a.clone();
    }

    public final float[] getValues() {
        return this.values;
    }
}
