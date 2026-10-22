package com.obric.common.oea.foundation.animation.token;

import kotlin.Metadata;
import lp.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"com/obric/common/oea/foundation/animation/token/AnimationProperty$FloatProperty", "", "Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$FloatProperty;", "", "propertyName", "Ljava/lang/String;", "getPropertyName", "()Ljava/lang/String;", "Companion", "lp/a", "X", "Y", "SCALE_X", "SCALE_Y", "ROTATION", "ROTATION_X", "ROTATION_Y", "TRANSLATION_X", "TRANSLATION_Y", "ALPHA", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnimationProperty$FloatProperty extends Enum<AnimationProperty$FloatProperty> {
    public static final AnimationProperty$FloatProperty ALPHA = null;
    public static final a Companion = null;
    public static final AnimationProperty$FloatProperty ROTATION = null;
    public static final AnimationProperty$FloatProperty ROTATION_X = null;
    public static final AnimationProperty$FloatProperty ROTATION_Y = null;
    public static final AnimationProperty$FloatProperty SCALE_X = null;
    public static final AnimationProperty$FloatProperty SCALE_Y = null;
    public static final AnimationProperty$FloatProperty TRANSLATION_X = null;
    public static final AnimationProperty$FloatProperty TRANSLATION_Y = null;
    public static final AnimationProperty$FloatProperty X = null;
    public static final AnimationProperty$FloatProperty Y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationProperty$FloatProperty[] f11325a = null;
    private final String propertyName;

    static {
        AnimationProperty$FloatProperty r5 = new AnimationProperty$FloatProperty("X", 0, "x");
        X = r5;
        AnimationProperty$FloatProperty r10 = new AnimationProperty$FloatProperty("Y", 1, "y");
        Y = r10;
        AnimationProperty$FloatProperty r11 = new AnimationProperty$FloatProperty("SCALE_X", 2, "scaleX");
        SCALE_X = r11;
        AnimationProperty$FloatProperty r12 = new AnimationProperty$FloatProperty("SCALE_Y", 3, "scaleY");
        SCALE_Y = r12;
        AnimationProperty$FloatProperty r13 = new AnimationProperty$FloatProperty("ROTATION", 4, "rotation");
        ROTATION = r13;
        AnimationProperty$FloatProperty r14 = new AnimationProperty$FloatProperty("ROTATION_X", 5, "rotationX");
        ROTATION_X = r14;
        AnimationProperty$FloatProperty r15 = new AnimationProperty$FloatProperty("ROTATION_Y", 6, "rotationY");
        ROTATION_Y = r15;
        AnimationProperty$FloatProperty r16 = new AnimationProperty$FloatProperty("TRANSLATION_X", 7, "translationX");
        TRANSLATION_X = r16;
        AnimationProperty$FloatProperty r17 = new AnimationProperty$FloatProperty("TRANSLATION_Y", 8, "translationY");
        TRANSLATION_Y = r17;
        AnimationProperty$FloatProperty r18 = new AnimationProperty$FloatProperty("ALPHA", 9, "alpha");
        ALPHA = r18;
        f11325a = new AnimationProperty$FloatProperty[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18};
        Companion = new a();
    }

    public AnimationProperty$FloatProperty(String r5, int r10, String r11) {
        super(r5, r10);
        this.propertyName = r11;
    }

    public static AnimationProperty$FloatProperty valueOf(String r5) {
        return (AnimationProperty$FloatProperty) Enum.valueOf(AnimationProperty$FloatProperty.class, r5);
    }

    public static AnimationProperty$FloatProperty[] values() {
        return (AnimationProperty$FloatProperty[]) f11325a.clone();
    }

    public final String getPropertyName() {
        return this.propertyName;
    }
}
