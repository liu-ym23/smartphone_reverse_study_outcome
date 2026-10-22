package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class Key {
    static final String ALPHA = "alpha";
    static final String CUSTOM = "CUSTOM";
    static final String ELEVATION = "elevation";
    static final String PIVOT_X = "transformPivotX";
    static final String PIVOT_Y = "transformPivotY";
    static final String PROGRESS = "progress";
    static final String ROTATION = "rotation";
    static final String ROTATION_X = "rotationX";
    static final String ROTATION_Y = "rotationY";
    static final String SCALE_X = "scaleX";
    static final String SCALE_Y = "scaleY";
    static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    static final String TRANSLATION_X = "translationX";
    static final String TRANSLATION_Y = "translationY";
    static final String TRANSLATION_Z = "translationZ";
    public static int UNSET = -1;
    static final String WAVE_OFFSET = "waveOffset";
    static final String WAVE_PERIOD = "wavePeriod";
    static final String WAVE_VARIES_BY = "waveVariesBy";
    HashMap<String, ConstraintAttribute> mCustomConstraints;
    int mFramePosition;
    int mTargetId;
    String mTargetString;
    protected int mType;

    public Key() {
        int r5 = UNSET;
        this.mFramePosition = r5;
        this.mTargetId = r5;
        this.mTargetString = null;
    }

    public abstract void addValues(HashMap<String, SplineSet> r5);

    public abstract void getAttributeNames(HashSet<String> r5);

    public abstract void load(Context r5, AttributeSet r10);

    public boolean matches(String r5) {
        String r10 = this.mTargetString;
        if (r10 == null) goto L8;
        if (r5 != null) goto L7;
        return false;
    L7:
        return r5.matches(r10);
    L8:
        return false;
    }

    public void setInterpolation(HashMap<String, Integer> r5) {
    }

    public abstract void setValue(String r5, Object r10);

    public boolean toBoolean(Object r5) {
        if ((r5 instanceof Boolean) == false) goto L6;
        return ((Boolean) r5).booleanValue();
    L6:
        return Boolean.parseBoolean(r5.toString());
    }

    public float toFloat(Object r5) {
        if ((r5 instanceof Float) == false) goto L6;
        return ((Float) r5).floatValue();
    L6:
        return Float.parseFloat(r5.toString());
    }

    public int toInt(Object r5) {
        if ((r5 instanceof Integer) == false) goto L6;
        return ((Integer) r5).intValue();
    L6:
        return Integer.parseInt(r5.toString());
    }
}
