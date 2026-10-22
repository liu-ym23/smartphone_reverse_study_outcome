package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class MotionKey implements TypedValues {
    public static final String ALPHA = "alpha";
    public static final String CUSTOM = "CUSTOM";
    public static final String ELEVATION = "elevation";
    public static final String ROTATION = "rotationZ";
    public static final String ROTATION_X = "rotationX";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";
    public static int UNSET = -1;
    public static final String VISIBILITY = "visibility";
    public HashMap<String, CustomVariable> mCustom;
    public int mFramePosition;
    int mTargetId;
    String mTargetString;
    public int mType;

    static {
    }

    public MotionKey() {
        int r10 = UNSET;
        this.mFramePosition = r10;
        this.mTargetId = r10;
        this.mTargetString = null;
    }

    public abstract void addValues(HashMap<String, SplineSet> r10);

    public abstract MotionKey clone();

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo3clone() {
        return clone();
    }

    public MotionKey copy(MotionKey r10) {
        this.mFramePosition = r10.mFramePosition;
        this.mTargetId = r10.mTargetId;
        this.mTargetString = r10.mTargetString;
        this.mType = r10.mType;
        return this;
    }

    public abstract void getAttributeNames(HashSet<String> r10);

    public int getFramePosition() {
        return this.mFramePosition;
    }

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

    public void setCustomAttribute(String r10, int r11, float r12) {
        this.mCustom.put(r10, new CustomVariable(r10, r11, r12));
    }

    public void setCustomAttribute(String r10, int r11, int r12) {
        this.mCustom.put(r10, new CustomVariable(r10, r11, r12));
    }

    public void setCustomAttribute(String r10, int r11, String r12) {
        this.mCustom.put(r10, new CustomVariable(r10, r11, r12));
    }

    public void setCustomAttribute(String r10, int r11, boolean r12) {
        this.mCustom.put(r10, new CustomVariable(r10, r11, r12));
    }

    public void setFramePosition(int r10) {
        this.mFramePosition = r10;
    }

    public void setInterpolation(HashMap<String, Integer> r10) {
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, float r11) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, int r11) {
        if (r10 == 100) goto L6;
        return false;
    L6:
        this.mFramePosition = r11;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, String r11) {
        if (r10 == 101) goto L6;
        return false;
    L6:
        this.mTargetString = r11;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, boolean r11) {
        return false;
    }

    public MotionKey setViewId(int r10) {
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
