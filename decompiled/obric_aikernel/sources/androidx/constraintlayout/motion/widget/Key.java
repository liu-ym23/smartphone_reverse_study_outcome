package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class Key {
    public static final String ALPHA = "alpha";
    public static final String CURVEFIT = "curveFit";
    public static final String CUSTOM = "CUSTOM";
    public static final String ELEVATION = "elevation";
    public static final String MOTIONPROGRESS = "motionProgress";
    public static final String PIVOT_X = "transformPivotX";
    public static final String PIVOT_Y = "transformPivotY";
    public static final String PROGRESS = "progress";
    public static final String ROTATION = "rotation";
    public static final String ROTATION_X = "rotationX";
    public static final String ROTATION_Y = "rotationY";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String TRANSITIONEASING = "transitionEasing";
    public static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";
    public static final String TRANSLATION_Z = "translationZ";
    public static int UNSET = -1;
    public static final String VISIBILITY = "visibility";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_VARIES_BY = "waveVariesBy";
    HashMap<String, ConstraintAttribute> mCustomConstraints;
    int mFramePosition;
    int mTargetId;
    String mTargetString;
    protected int mType;

    static {
    }

    public Key() {
        int r10 = UNSET;
        this.mFramePosition = r10;
        this.mTargetId = r10;
        this.mTargetString = null;
    }

    public abstract void addValues(HashMap<String, ViewSpline> r10);

    public abstract Key clone();

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo4clone() {
        return clone();
    }

    public Key copy(Key r10) {
        this.mFramePosition = r10.mFramePosition;
        this.mTargetId = r10.mTargetId;
        this.mTargetString = r10.mTargetString;
        this.mType = r10.mType;
        this.mCustomConstraints = r10.mCustomConstraints;
        return this;
    }

    abstract void getAttributeNames(HashSet<String> r10);

    public int getFramePosition() {
        return this.mFramePosition;
    }

    abstract void load(Context r10, AttributeSet r11);

    boolean matches(String r10) {
        String r11 = this.mTargetString;
        if (r11 == null) goto L8;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.matches(r11);
    L8:
        return false;
    }

    public void setFramePosition(int r10) {
        this.mFramePosition = r10;
    }

    public void setInterpolation(HashMap<String, Integer> r10) {
    }

    public abstract void setValue(String r10, Object r11);

    public Key setViewId(int r10) {
        this.mTargetId = r10;
        return this;
    }

    boolean toBoolean(Object r10) {
        if ((r10 instanceof Boolean) == false) goto L6;
        return ((Boolean) r10).booleanValue();
    L6:
        return Boolean.parseBoolean(r10.toString());
    }

    float toFloat(Object r10) {
        if ((r10 instanceof Float) == false) goto L6;
        return ((Float) r10).floatValue();
    L6:
        return Float.parseFloat(r10.toString());
    }

    int toInt(Object r10) {
        if ((r10 instanceof Integer) == false) goto L6;
        return ((Integer) r10).intValue();
    L6:
        return Integer.parseInt(r10.toString());
    }
}
