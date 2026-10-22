package defpackage;

import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$IntProperty;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f13a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f14b = null;

    static {
        int[] r5 = new int[AnimationProperty$FloatProperty.values().length];
        f13a = r5;
        r5[AnimationProperty$FloatProperty.X.ordinal()] = 1;
        r5[AnimationProperty$FloatProperty.Y.ordinal()] = 2;
        r5[AnimationProperty$FloatProperty.SCALE_X.ordinal()] = 3;
        r5[AnimationProperty$FloatProperty.SCALE_Y.ordinal()] = 4;
        r5[AnimationProperty$FloatProperty.ROTATION.ordinal()] = 5;
        r5[AnimationProperty$FloatProperty.TRANSLATION_X.ordinal()] = 6;
        r5[AnimationProperty$FloatProperty.TRANSLATION_Y.ordinal()] = 7;
        r5[AnimationProperty$FloatProperty.ROTATION_X.ordinal()] = 8;
        r5[AnimationProperty$FloatProperty.ROTATION_Y.ordinal()] = 9;
        r5[AnimationProperty$FloatProperty.ALPHA.ordinal()] = 10;
        int[] r10 = new int[AnimationProperty$IntProperty.values().length];
        f14b = r10;
        AnimationProperty$IntProperty r11 = AnimationProperty$IntProperty.BACKGROUND_COLOR;
        r10[r11.ordinal()] = 1;
        AnimationProperty$IntProperty r12 = AnimationProperty$IntProperty.TEXT_COLOR;
        r10[r12.ordinal()] = 2;
        AnimationProperty$IntProperty r13 = AnimationProperty$IntProperty.STROKE_COLOR;
        r10[r13.ordinal()] = 3;
        AnimationProperty$IntProperty r14 = AnimationProperty$IntProperty.FILL_COLOR;
        r10[r14.ordinal()] = 4;
        r10[AnimationProperty$IntProperty.WIDTH.ordinal()] = 5;
        r10[AnimationProperty$IntProperty.HEIGHT.ordinal()] = 6;
        int[] r15 = new int[AnimationProperty$IntProperty.values().length];
        r15[r11.ordinal()] = 1;
        r15[r12.ordinal()] = 2;
        r15[r13.ordinal()] = 3;
        r15[r14.ordinal()] = 4;
    }
}
