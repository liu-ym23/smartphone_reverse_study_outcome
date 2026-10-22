package com.lynx.tasm.animation;

import com.lynx.tasm.event.LynxTouchEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class AnimationConstant {
    public static final int[] a = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LayoutAnimationType {
    }

    static {
        a = new int[]{1, 16, 32, 64, LynxTouchEvent.kPseudoStateFocusTransition, 256, 512, 1024, 2048, 4096};
    }
}
