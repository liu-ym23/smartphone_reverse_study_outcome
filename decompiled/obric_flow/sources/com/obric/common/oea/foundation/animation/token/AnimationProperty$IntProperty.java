package com.obric.common.oea.foundation.animation.token;

import kotlin.Metadata;
import lp.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"com/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty", "", "Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty;", "", "propertyName", "Ljava/lang/String;", "getPropertyName", "()Ljava/lang/String;", "Companion", "lp/b", "BACKGROUND_COLOR", "TEXT_COLOR", "STROKE_COLOR", "FILL_COLOR", "WIDTH", "HEIGHT", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnimationProperty$IntProperty extends Enum<AnimationProperty$IntProperty> {
    public static final AnimationProperty$IntProperty BACKGROUND_COLOR = null;
    public static final b Companion = null;
    public static final AnimationProperty$IntProperty FILL_COLOR = null;
    public static final AnimationProperty$IntProperty HEIGHT = null;
    public static final AnimationProperty$IntProperty STROKE_COLOR = null;
    public static final AnimationProperty$IntProperty TEXT_COLOR = null;
    public static final AnimationProperty$IntProperty WIDTH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationProperty$IntProperty[] f11326a = null;
    private final String propertyName;

    static {
        AnimationProperty$IntProperty r5 = new AnimationProperty$IntProperty("BACKGROUND_COLOR", 0, "backgroundColor");
        BACKGROUND_COLOR = r5;
        AnimationProperty$IntProperty r10 = new AnimationProperty$IntProperty("TEXT_COLOR", 1, "textColor");
        TEXT_COLOR = r10;
        AnimationProperty$IntProperty r11 = new AnimationProperty$IntProperty("STROKE_COLOR", 2, "strokeColor");
        STROKE_COLOR = r11;
        AnimationProperty$IntProperty r12 = new AnimationProperty$IntProperty("FILL_COLOR", 3, "fillColor");
        FILL_COLOR = r12;
        AnimationProperty$IntProperty r13 = new AnimationProperty$IntProperty("WIDTH", 4, "width");
        WIDTH = r13;
        AnimationProperty$IntProperty r14 = new AnimationProperty$IntProperty("HEIGHT", 5, "height");
        HEIGHT = r14;
        f11326a = new AnimationProperty$IntProperty[]{r5, r10, r11, r12, r13, r14};
        Companion = new b();
    }

    public AnimationProperty$IntProperty(String r5, int r10, String r11) {
        super(r5, r10);
        this.propertyName = r11;
    }

    public static AnimationProperty$IntProperty valueOf(String r5) {
        return (AnimationProperty$IntProperty) Enum.valueOf(AnimationProperty$IntProperty.class, r5);
    }

    public static AnimationProperty$IntProperty[] values() {
        return (AnimationProperty$IntProperty[]) f11326a.clone();
    }

    public final String getPropertyName() {
        return this.propertyName;
    }
}
