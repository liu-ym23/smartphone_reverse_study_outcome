package androidx.transition;

import android.annotation.SuppressLint;
import androidx.annotation.StyleableRes;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"InlinedApi"})
class Styleable {

    @StyleableRes
    static final int[] ARC_MOTION = null;

    @StyleableRes
    static final int[] CHANGE_BOUNDS = null;

    @StyleableRes
    static final int[] CHANGE_TRANSFORM = null;

    @StyleableRes
    static final int[] FADE = null;

    @StyleableRes
    static final int[] PATTERN_PATH_MOTION = null;

    @StyleableRes
    static final int[] SLIDE = null;

    @StyleableRes
    static final int[] TRANSITION = null;

    @StyleableRes
    static final int[] TRANSITION_MANAGER = null;

    @StyleableRes
    static final int[] TRANSITION_SET = null;

    @StyleableRes
    static final int[] TRANSITION_TARGET = null;

    @StyleableRes
    static final int[] VISIBILITY_TRANSITION = null;

    interface ArcMotion {

        @StyleableRes
        public static final int MAXIMUM_ANGLE = 2;

        @StyleableRes
        public static final int MINIMUM_HORIZONTAL_ANGLE = 0;

        @StyleableRes
        public static final int MINIMUM_VERTICAL_ANGLE = 1;
    }

    interface ChangeBounds {

        @StyleableRes
        public static final int RESIZE_CLIP = 0;
    }

    interface ChangeTransform {

        @StyleableRes
        public static final int REPARENT = 0;

        @StyleableRes
        public static final int REPARENT_WITH_OVERLAY = 1;
    }

    interface Fade {

        @StyleableRes
        public static final int FADING_MODE = 0;
    }

    interface PatternPathMotion {

        @StyleableRes
        public static final int PATTERN_PATH_DATA = 0;
    }

    interface Slide {

        @StyleableRes
        public static final int SLIDE_EDGE = 0;
    }

    interface Transition {

        @StyleableRes
        public static final int DURATION = 1;

        @StyleableRes
        public static final int INTERPOLATOR = 0;

        @StyleableRes
        public static final int MATCH_ORDER = 3;

        @StyleableRes
        public static final int START_DELAY = 2;
    }

    interface TransitionManager {

        @StyleableRes
        public static final int FROM_SCENE = 0;

        @StyleableRes
        public static final int TO_SCENE = 1;

        @StyleableRes
        public static final int TRANSITION = 2;
    }

    interface TransitionSet {

        @StyleableRes
        public static final int TRANSITION_ORDERING = 0;
    }

    interface TransitionTarget {

        @StyleableRes
        public static final int EXCLUDE_CLASS = 3;

        @StyleableRes
        public static final int EXCLUDE_ID = 2;

        @StyleableRes
        public static final int EXCLUDE_NAME = 5;

        @StyleableRes
        public static final int TARGET_CLASS = 0;

        @StyleableRes
        public static final int TARGET_ID = 1;

        @StyleableRes
        public static final int TARGET_NAME = 4;
    }

    interface VisibilityTransition {

        @StyleableRes
        public static final int TRANSITION_VISIBILITY_MODE = 0;
    }

    static {
        TRANSITION_TARGET = new int[]{android.R.attr.targetClass, android.R.attr.targetId, android.R.attr.excludeId, android.R.attr.excludeClass, android.R.attr.targetName, android.R.attr.excludeName};
        TRANSITION_MANAGER = new int[]{android.R.attr.fromScene, android.R.attr.toScene, android.R.attr.transition};
        TRANSITION = new int[]{android.R.attr.interpolator, android.R.attr.duration, android.R.attr.startDelay, android.R.attr.matchOrder};
        CHANGE_BOUNDS = new int[]{android.R.attr.resizeClip};
        VISIBILITY_TRANSITION = new int[]{android.R.attr.transitionVisibilityMode};
        FADE = new int[]{android.R.attr.fadingMode};
        CHANGE_TRANSFORM = new int[]{android.R.attr.reparent, android.R.attr.reparentWithOverlay};
        SLIDE = new int[]{android.R.attr.slideEdge};
        TRANSITION_SET = new int[]{android.R.attr.transitionOrdering};
        ARC_MOTION = new int[]{android.R.attr.minimumHorizontalAngle, android.R.attr.minimumVerticalAngle, android.R.attr.maximumAngle};
        PATTERN_PATH_MOTION = new int[]{android.R.attr.patternPathData};
    }

    private Styleable() {
    }
}
