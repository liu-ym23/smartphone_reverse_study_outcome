package com.obric.common.oea.foundation.animation.token;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"com/obric/common/oea/foundation/animation/token/AnimationProperty$FloatProperty", "", "Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$FloatProperty;", "", "propertyName", "Ljava/lang/String;", "getPropertyName", "()Ljava/lang/String;", "Companion", "a", "X", "Y", "SCALE_X", "SCALE_Y", "ROTATION", "ROTATION_X", "ROTATION_Y", "TRANSLATION_X", "TRANSLATION_Y", "ALPHA", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
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
    public static final /* synthetic */ AnimationProperty$FloatProperty[] a = null;
    private final String propertyName;

    public static AnimationProperty$FloatProperty valueOf(String r1) {
        return (AnimationProperty$FloatProperty) r27.a.a(AnimationProperty$FloatProperty.class, r1);
    }

    public static AnimationProperty$FloatProperty[] values() {
        return (AnimationProperty$FloatProperty[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty$a] */
    static {
        AnimationProperty$FloatProperty r1 = new AnimationProperty$FloatProperty("X", 0, "x");
        X = r1;
        AnimationProperty$FloatProperty r2 = new AnimationProperty$FloatProperty("Y", 1, "y");
        Y = r2;
        AnimationProperty$FloatProperty r3 = new AnimationProperty$FloatProperty("SCALE_X", 2, "scaleX");
        SCALE_X = r3;
        AnimationProperty$FloatProperty r4 = new AnimationProperty$FloatProperty("SCALE_Y", 3, "scaleY");
        SCALE_Y = r4;
        AnimationProperty$FloatProperty r5 = new AnimationProperty$FloatProperty("ROTATION", 4, "rotation");
        ROTATION = r5;
        AnimationProperty$FloatProperty r6 = new AnimationProperty$FloatProperty("ROTATION_X", 5, "rotationX");
        ROTATION_X = r6;
        AnimationProperty$FloatProperty r7 = new AnimationProperty$FloatProperty("ROTATION_Y", 6, "rotationY");
        ROTATION_Y = r7;
        AnimationProperty$FloatProperty r8 = new AnimationProperty$FloatProperty("TRANSLATION_X", 7, "translationX");
        TRANSLATION_X = r8;
        AnimationProperty$FloatProperty r9 = new AnimationProperty$FloatProperty("TRANSLATION_Y", 8, "translationY");
        TRANSLATION_Y = r9;
        AnimationProperty$FloatProperty r10 = new AnimationProperty$FloatProperty("ALPHA", 9, "alpha");
        ALPHA = r10;
        a = new AnimationProperty$FloatProperty[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
        Companion = new a();
    }

    public final String getPropertyName() {
        return this.propertyName;
    }

    public AnimationProperty$FloatProperty(String r1, int r2, String r3) {
        super(r1, r2);
        this.propertyName = r3;
    }
}
