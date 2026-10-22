package com.obric.common.oea.foundation.animation.token;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"com/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty", "", "Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty;", "", "propertyName", "Ljava/lang/String;", "getPropertyName", "()Ljava/lang/String;", "Companion", "a", "BACKGROUND_COLOR", "TEXT_COLOR", "STROKE_COLOR", "FILL_COLOR", "WIDTH", "HEIGHT", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnimationProperty$IntProperty extends Enum<AnimationProperty$IntProperty> {
    public static final AnimationProperty$IntProperty BACKGROUND_COLOR = null;
    public static final a Companion = null;
    public static final AnimationProperty$IntProperty FILL_COLOR = null;
    public static final AnimationProperty$IntProperty HEIGHT = null;
    public static final AnimationProperty$IntProperty STROKE_COLOR = null;
    public static final AnimationProperty$IntProperty TEXT_COLOR = null;
    public static final AnimationProperty$IntProperty WIDTH = null;
    public static final /* synthetic */ AnimationProperty$IntProperty[] a = null;
    private final String propertyName;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.common.oea.foundation.animation.token.AnimationProperty$IntProperty$a] */
    static {
        AnimationProperty$IntProperty r1 = new AnimationProperty$IntProperty("BACKGROUND_COLOR", 0, "backgroundColor");
        BACKGROUND_COLOR = r1;
        AnimationProperty$IntProperty r2 = new AnimationProperty$IntProperty("TEXT_COLOR", 1, "textColor");
        TEXT_COLOR = r2;
        AnimationProperty$IntProperty r3 = new AnimationProperty$IntProperty("STROKE_COLOR", 2, "strokeColor");
        STROKE_COLOR = r3;
        AnimationProperty$IntProperty r4 = new AnimationProperty$IntProperty("FILL_COLOR", 3, "fillColor");
        FILL_COLOR = r4;
        AnimationProperty$IntProperty r5 = new AnimationProperty$IntProperty("WIDTH", 4, "width");
        WIDTH = r5;
        AnimationProperty$IntProperty r6 = new AnimationProperty$IntProperty("HEIGHT", 5, "height");
        HEIGHT = r6;
        a = new AnimationProperty$IntProperty[]{r1, r2, r3, r4, r5, r6};
        Companion = new a();
    }

    public static AnimationProperty$IntProperty valueOf(String r1) {
        return (AnimationProperty$IntProperty) r27.a.a(AnimationProperty$IntProperty.class, r1);
    }

    public static AnimationProperty$IntProperty[] values() {
        return (AnimationProperty$IntProperty[]) a.clone();
    }

    public final String getPropertyName() {
        return this.propertyName;
    }

    public AnimationProperty$IntProperty(String r1, int r2, String r3) {
        super(r1, r2);
        this.propertyName = r3;
    }
}
