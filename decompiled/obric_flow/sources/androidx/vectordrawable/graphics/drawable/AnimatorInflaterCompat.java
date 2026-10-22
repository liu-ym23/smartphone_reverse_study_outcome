package androidx.vectordrawable.graphics.drawable;

import ai.j0;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.annotation.AnimatorRes;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.a;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AnimatorInflaterCompat {
    private static final boolean DBG_ANIMATOR_INFLATER = false;
    private static final int MAX_NUM_POINTS = 100;
    private static final String TAG = "AnimatorInflater";
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_COLOR = 3;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int VALUE_TYPE_INT = 1;
    private static final int VALUE_TYPE_PATH = 2;
    private static final int VALUE_TYPE_UNDEFINED = 4;

    public static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {
        private PathParser.PathDataNode[] mNodeArray;

        public PathDataEvaluator() {
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ PathParser.PathDataNode[] evaluate(float r5, PathParser.PathDataNode[] r10, PathParser.PathDataNode[] r11) {
            return evaluate2(r5, r10, r11);
        }

        public PathDataEvaluator(PathParser.PathDataNode[] r5) {
            this.mNodeArray = r5;
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public PathParser.PathDataNode[] evaluate2(float r5, PathParser.PathDataNode[] r10, PathParser.PathDataNode[] r11) {
            if (PathParser.canMorph(r10, r11) == false) goto L14;
            if (PathParser.canMorph(this.mNodeArray, r10) == true) goto L7;
            this.mNodeArray = PathParser.deepCopyNodes(r10);
        L7:
            int r12 = 0;
        L9:
            if (r12 >= r10.length) goto L12;
            this.mNodeArray[r12].interpolatePathDataNode(r10[r12], r11[r12], r5);
            r12 = r12 + 1;
            goto L9
        L12:
            return this.mNodeArray;
        L14:
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private AnimatorInflaterCompat() {
    }

    private static Animator createAnimatorFromXml(Context r10, Resources r11, Resources.Theme r12, XmlPullParser r13, float r14) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(r10, r11, r12, r13, Xml.asAttributeSet(r13), null, 0, r14);
    }

    private static Keyframe createNewKeyframe(Keyframe r5, float r10) {
        if (r5.getType() != Float.TYPE) goto L6;
        return Keyframe.ofFloat(r10);
    L6:
        if (r5.getType() != Integer.TYPE) goto L9;
        return Keyframe.ofInt(r10);
    L9:
        return Keyframe.ofObject(r10);
    }

    private static void distributeKeyframes(Keyframe[] r5, float r10, int r11, int r12) {
        float r13 = r10 / ((r12 - r11) + 2);
    L3:
        if (r11 > r12) goto L5;
        r5[r11].setFraction(r5[r11 - 1].getFraction() + r13);
        r11 = r11 + 1;
        goto L3
    }

    private static void dumpKeyframes(Object[] r10, String r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length == 0) goto L20;
        Log.d(TAG, r11);
        int r12 = r10.length;
        int r5 = 0;
    L7:
        if (r5 >= r12) goto L21;
        Keyframe r13 = (Keyframe) r10[r5];
        StringBuilder r14 = j0.s(r5, "Keyframe ", ": fraction ");
        Object r15 = "null";
        if (r13.getFraction() >= 0.0f) goto L11;
        Object r16 = "null";
    L12:
        r14.append(r16);
        r14.append(", , value : ");
        if (r13.hasValue() == false) goto L15;
        r15 = r13.getValue();
    L15:
        r14.append(r15);
        Log.d(TAG, r14.toString());
        r5 = r5 + 1;
        goto L7
    L11:
        r16 = Float.valueOf(r13.getFraction());
        goto L12
    L21:
        return;
    }

    private static PropertyValuesHolder getPVH(TypedArray r11, int r12, int r13, int r14, String r15) {
        TypedValue r5 = r11.peekValue(r13);
        if (r5 == null) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        int r16 = r5.type;
    L9:
        TypedValue r17 = r11.peekValue(r14);
        if (r17 == null) goto L12;
        boolean r18 = true;
    L13:
        if (r18 == false) goto L15;
        int r19 = r17.type;
    L17:
        if (r12 != 4) goto L26;
        if (r10 == true) goto L20;
    L21:
        if (r18 == true) goto L23;
    L25:
        r12 = 0;
        goto L26
    L23:
        if (isColorType(r19) == false) goto L25;
    L24:
        r12 = 3;
        goto L26
    L20:
        if (isColorType(r16) == true) goto L24;
    L26:
        if (r12 != 0) goto L28;
        boolean r20 = true;
    L29:
        PropertyValuesHolder r21 = null;
        if (r12 != 2) goto L46;
        String r110 = r11.getString(r13);
        String r111 = r11.getString(r14);
        PathParser.PathDataNode[] r112 = PathParser.createNodesFromPathData(r110);
        PathParser.PathDataNode[] r113 = PathParser.createNodesFromPathData(r111);
        if (r112 != null) goto L34;
        if (r113 != null) goto L34;
        return null;
    L34:
        if (r112 == null) goto L44;
        PathDataEvaluator r22 = new PathDataEvaluator();
        if (r113 != null) goto L38;
        PropertyValuesHolder r114 = PropertyValuesHolder.ofObject(r15, r22, new Object[]{r112});
    L95:
        return r114;
    L38:
        if (PathParser.canMorph(r112, r113) == false) goto L42;
        r114 = PropertyValuesHolder.ofObject(r15, r22, new Object[]{r112, r113});
        goto L95
    L42:
        throw new InflateException(a.p(" Can't morph from ", r110, " to ", r111));
    L44:
        if (r113 != null) goto L97;
        return null;
    L97:
        return PropertyValuesHolder.ofObject(r15, new PathDataEvaluator(), new Object[]{r113});
    L46:
        if (r12 != 3) goto L48;
        ArgbEvaluator r115 = ArgbEvaluator.getInstance();
    L50:
        if (r20 == false) goto L66;
        if (r10 == false) goto L62;
        if (r16 != 5) goto L54;
        float r116 = r11.getDimension(r13, 0.0f);
    L55:
        if (r18 == false) goto L61;
        if (r19 != 5) goto L58;
        float r117 = r11.getDimension(r14, 0.0f);
    L59:
        PropertyValuesHolder r118 = PropertyValuesHolder.ofFloat(r15, new float[]{r116, r117});
    L60:
        r21 = r118;
    L90:
        if (r21 == null) goto L98;
        if (r115 == null) goto L99;
        r21.setEvaluator(r115);
        return r21;
    L99:
        return r21;
    L98:
        return r21;
    L58:
        r117 = r11.getFloat(r14, 0.0f);
        goto L59
    L61:
        r118 = PropertyValuesHolder.ofFloat(r15, new float[]{r116});
        goto L60
    L54:
        r116 = r11.getFloat(r13, 0.0f);
        goto L55
    L62:
        if (r19 != 5) goto L64;
        float r119 = r11.getDimension(r14, 0.0f);
    L65:
        r118 = PropertyValuesHolder.ofFloat(r15, new float[]{r119});
        goto L60
    L64:
        r119 = r11.getFloat(r14, 0.0f);
        goto L65
    L66:
        if (r10 == false) goto L82;
        if (r16 != 5) goto L70;
        int r120 = (int) r11.getDimension(r13, 0.0f);
    L73:
        if (r18 == false) goto L81;
        if (r19 != 5) goto L77;
        int r121 = (int) r11.getDimension(r14, 0.0f);
    L80:
        r21 = PropertyValuesHolder.ofInt(r15, new int[]{r120, r121});
        goto L90
    L77:
        if (isColorType(r19) == false) goto L79;
        r121 = r11.getColor(r14, 0);
        goto L80
    L79:
        r121 = r11.getInt(r14, 0);
        goto L80
    L81:
        r21 = PropertyValuesHolder.ofInt(r15, new int[]{r120});
        goto L90
    L70:
        if (isColorType(r16) == false) goto L72;
        r120 = r11.getColor(r13, 0);
        goto L73
    L72:
        r120 = r11.getInt(r13, 0);
        goto L73
    L82:
        if (r18 == false) goto L90;
        if (r19 != 5) goto L86;
        int r122 = (int) r11.getDimension(r14, 0.0f);
    L89:
        r21 = PropertyValuesHolder.ofInt(r15, new int[]{r122});
        goto L90
    L86:
        if (isColorType(r19) == false) goto L88;
        r122 = r11.getColor(r14, 0);
        goto L89
    L88:
        r122 = r11.getInt(r14, 0);
        goto L89
    L48:
        r115 = null;
        goto L50
    L28:
        r20 = false;
        goto L29
    L15:
        r19 = 0;
        goto L17
    L12:
        r18 = false;
        goto L13
    L8:
        r16 = 0;
        goto L9
    L5:
        r10 = false;
        goto L6
    }

    private static int inferValueTypeFromValues(TypedArray r5, int r10, int r11) {
        TypedValue r12 = r5.peekValue(r10);
        boolean r13 = true;
        if (r12 == null) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L8;
        int r15 = r12.type;
    L9:
        TypedValue r16 = r5.peekValue(r11);
        if (r16 != null) goto L13;
        r13 = false;
    L13:
        if (r13 == false) goto L15;
        int r17 = r16.type;
    L16:
        if (r14 == true) goto L18;
    L19:
        if (r13 == true) goto L21;
        return 0;
    L21:
        if (isColorType(r17) == false) goto L25;
    L22:
        return 3;
    L25:
        return 0;
    L18:
        if (isColorType(r15) == true) goto L22;
    L15:
        r17 = 0;
        goto L16
    L8:
        r15 = 0;
        goto L9
    L5:
        r14 = false;
        goto L6
    }

    private static int inferValueTypeOfKeyframe(Resources r5, Resources.Theme r10, AttributeSet r11, XmlPullParser r12) {
        TypedArray r13 = TypedArrayUtils.obtainAttributes(r5, r10, r11, AndroidResources.STYLEABLE_KEYFRAME);
        int r14 = 0;
        TypedValue r15 = TypedArrayUtils.peekNamedValue(r13, r12, "value", 0);
        if (r15 != null) goto L5;
    L7:
        r13.recycle();
        return r14;
    L5:
        if (isColorType(r15.type) == false) goto L7;
        r14 = 3;
        goto L7
    }

    private static boolean isColorType(int r5) {
        if (r5 >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r5 > 31) goto L7;
        return true;
    }

    public static Animator loadAnimator(Context r5, @AnimatorRes int r10) throws Resources.NotFoundException {
        return AnimatorInflater.loadAnimator(r5, r10);
    }

    private static Keyframe loadKeyframe(Context r10, Resources r11, Resources.Theme r12, AttributeSet r13, int r14, XmlPullParser r15) throws XmlPullParserException, IOException {
        TypedArray r16 = TypedArrayUtils.obtainAttributes(r11, r12, r13, AndroidResources.STYLEABLE_KEYFRAME);
        float r17 = TypedArrayUtils.getNamedFloat(r16, r15, "fraction", 3, -1.0f);
        TypedValue r5 = TypedArrayUtils.peekNamedValue(r16, r15, "value", 0);
        if (r5 == null) goto L5;
        boolean r18 = true;
    L7:
        if (r14 != 4) goto L13;
        if (r18 == true) goto L10;
    L12:
        r14 = 0;
        goto L13
    L10:
        if (isColorType(r5.type) == false) goto L12;
        r14 = 3;
    L13:
        if (r18 == false) goto L20;
        if (r14 == 0) goto L19;
        if (r14 == 1) goto L18;
        if (r14 == 3) goto L18;
        Keyframe r19 = null;
    L23:
        int r20 = TypedArrayUtils.getNamedResourceId(r16, r15, "interpolator", 1, 0);
        if (r20 <= 0) goto L26;
        r19.setInterpolator(AnimationUtilsCompat.loadInterpolator(r10, r20));
    L26:
        r16.recycle();
        return r19;
    L18:
        r19 = Keyframe.ofInt(r17, TypedArrayUtils.getNamedInt(r16, r15, "value", 0, 0));
        goto L23
    L19:
        r19 = Keyframe.ofFloat(r17, TypedArrayUtils.getNamedFloat(r16, r15, "value", 0, 0.0f));
        goto L23
    L20:
        if (r14 != 0) goto L22;
        r19 = Keyframe.ofFloat(r17);
        goto L23
    L22:
        r19 = Keyframe.ofInt(r17);
        goto L23
    L5:
        r18 = false;
        goto L7
    }

    private static ObjectAnimator loadObjectAnimator(Context r10, Resources r11, Resources.Theme r12, AttributeSet r13, float r14, XmlPullParser r15) throws Resources.NotFoundException {
        ObjectAnimator r16 = new ObjectAnimator();
        loadAnimator(r10, r11, r12, r13, r16, r14, r15);
        return r16;
    }

    private static PropertyValuesHolder loadPvh(Context r10, Resources r11, Resources.Theme r12, XmlPullParser r13, String r14, int r15) throws XmlPullParserException, IOException {
        PropertyValuesHolder r5 = null;
        ArrayList r16 = null;
    L3:
        int r17 = r13.next();
        if (r17 == 3) goto L18;
        if (r17 == 1) goto L18;
        if (r13.getName().equals("keyframe") == false) goto L3;
        if (r15 != 4) goto L12;
        r15 = inferValueTypeOfKeyframe(r11, r12, Xml.asAttributeSet(r13), r13);
    L12:
        Keyframe r18 = loadKeyframe(r10, r11, r12, Xml.asAttributeSet(r13), r15, r13);
        if (r18 == null) goto L17;
        if (r16 != null) goto L16;
        r16 = new ArrayList();
    L16:
        r16.add(r18);
    L17:
        r13.next();
    L18:
        if (r16 == null) goto L53;
        int r19 = r16.size();
        if (r19 <= 0) goto L53;
        int r110 = 0;
        Keyframe r111 = (Keyframe) r16.get(0);
        Keyframe r112 = (Keyframe) r16.get(r19 - 1);
        float r20 = r112.getFraction();
        if (r20 < 1.0f) goto L24;
    L27:
        float r113 = r111.getFraction();
        if (r113 != 0.0f) goto L30;
    L33:
        Keyframe[] r114 = new Keyframe[r19];
        r16.toArray(r114);
    L34:
        if (r110 >= r19) goto L50;
        Keyframe r115 = r114[r110];
        if (r115.getFraction() >= 0.0f) goto L49;
        if (r110 != 0) goto L39;
        r115.setFraction(0.0f);
        goto L49
    L39:
        int r21 = r19 - 1;
        if (r110 != r21) goto L42;
        r115.setFraction(1.0f);
        goto L49
    L42:
        int r116 = r110 + 1;
        int r22 = r110;
    L43:
        if (r116 >= r21) goto L48;
        if (r114[r116].getFraction() >= 0.0f) goto L48;
        r22 = r116;
        r116 = r116 + 1;
    L48:
        distributeKeyframes(r114, r114[r22 + 1].getFraction() - r114[r110 - 1].getFraction(), r110, r22);
    L49:
        r110 = r110 + 1;
        goto L34
    L50:
        r5 = PropertyValuesHolder.ofKeyframe(r14, r114);
        if (r15 != 3) goto L53;
        r5.setEvaluator(ArgbEvaluator.getInstance());
        goto L53
    L30:
        if (r113 >= 0.0f) goto L32;
        r111.setFraction(0.0f);
        goto L33
    L32:
        r16.add(0, createNewKeyframe(r111, 0.0f));
        r19 = r19 + 1;
        goto L33
    L24:
        if (r20 >= 0.0f) goto L26;
        r112.setFraction(1.0f);
        goto L27
    L26:
        r16.add(r16.size(), createNewKeyframe(r112, 1.0f));
        r19 = r19 + 1;
    L53:
        return r5;
    }

    private static PropertyValuesHolder[] loadValues(Context r17, Resources r18, Resources.Theme r19, XmlPullParser r20, AttributeSet r21) throws XmlPullParserException, IOException {
        PropertyValuesHolder[] r10 = null;
        ArrayList r11 = null;
    L3:
        int r5 = r20.getEventType();
        int r12 = 0;
        if (r5 == 3) goto L22;
        if (r5 == 1) goto L22;
        if (r5 != 2) goto L9;
        if (r20.getName().equals("propertyValuesHolder") == false) goto L21;
        TypedArray r14 = TypedArrayUtils.obtainAttributes(r18, r19, r21, AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
        String r15 = TypedArrayUtils.getNamedString(r14, r20, "propertyName", 3);
        int r13 = TypedArrayUtils.getNamedInt(r14, r20, "valueType", 2, 4);
        PropertyValuesHolder r16 = loadPvh(r17, r18, r19, r20, r15, r13);
        if (r16 != null) goto L15;
        r16 = getPVH(r14, r13, 0, 1, r15);
    L15:
        if (r16 == null) goto L19;
        if (r11 != null) goto L18;
        r11 = new ArrayList();
    L18:
        r11.add(r16);
    L19:
        r14.recycle();
    L21:
        r20.next();
        goto L3
    L9:
        r20.next();
    L22:
        if (r11 == null) goto L26;
        int r22 = r11.size();
        r10 = new PropertyValuesHolder[r22];
    L24:
        if (r12 >= r22) goto L26;
        r10[r12] = (PropertyValuesHolder) r11.get(r12);
        r12 = r12 + 1;
    L26:
        return r10;
    }

    private static void parseAnimatorFromTypeArray(ValueAnimator r11, TypedArray r12, TypedArray r13, float r14, XmlPullParser r15) {
        long r5 = TypedArrayUtils.getNamedInt(r12, r15, "duration", 1, 300);
        long r10 = TypedArrayUtils.getNamedInt(r12, r15, "startOffset", 2, 0);
        int r16 = TypedArrayUtils.getNamedInt(r12, r15, "valueType", 7, 4);
        if (TypedArrayUtils.hasAttribute(r15, "valueFrom") == true) goto L5;
    L12:
        r11.setDuration(r5);
        r11.setStartDelay(r10);
        r11.setRepeatCount(TypedArrayUtils.getNamedInt(r12, r15, "repeatCount", 3, 0));
        r11.setRepeatMode(TypedArrayUtils.getNamedInt(r12, r15, "repeatMode", 4, 1));
        if (r13 == null) goto L16;
        setupObjectAnimator(r11, r13, r16, r14, r15);
        return;
    L16:
        return;
    L5:
        if (TypedArrayUtils.hasAttribute(r15, "valueTo") == false) goto L12;
        if (r16 != 4) goto L9;
        r16 = inferValueTypeFromValues(r12, 5, 6);
    L9:
        PropertyValuesHolder r17 = getPVH(r12, r16, 5, 6, "");
        if (r17 == null) goto L12;
        r11.setValues(new PropertyValuesHolder[]{r17});
        goto L12
    }

    private static void setupObjectAnimator(ValueAnimator r5, TypedArray r10, int r11, float r12, XmlPullParser r13) {
        ObjectAnimator r14 = (ObjectAnimator) r5;
        String r15 = TypedArrayUtils.getNamedString(r10, r13, "pathData", 1);
        if (r15 == null) goto L13;
        String r16 = TypedArrayUtils.getNamedString(r10, r13, "propertyXName", 2);
        String r17 = TypedArrayUtils.getNamedString(r10, r13, "propertyYName", 3);
        if (r11 != 2) goto L7;
    L7:
        if (r16 != null) goto L12;
        if (r17 != null) goto L12;
        throw new InflateException(r10.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
    L12:
        setupPathMotion(PathParser.createPathFromPathData(r15), r14, r12 * 0.5f, r16, r17);
        return;
    L13:
        r14.setPropertyName(TypedArrayUtils.getNamedString(r10, r13, "propertyName", 0));
    }

    private static void setupPathMotion(Path r17, ObjectAnimator r18, float r19, String r20, String r21) {
        char r5 = 0;
        PathMeasure r10 = new PathMeasure(r17, false);
        ArrayList r11 = new ArrayList();
        float r12 = 0.0f;
        r11.add(Float.valueOf(0.0f));
        float r13 = 0.0f;
    L3:
        r13 = r13 + r10.getLength();
        r11.add(Float.valueOf(r13));
        if (r10.nextContour() == true) goto L3;
        PathMeasure r14 = new PathMeasure(r17, false);
        int r15 = Math.min(100, ((int) (r13 / r19)) + 1);
        float[] r16 = new float[r15];
        float[] r110 = new float[r15];
        float[] r111 = new float[2];
        float r22 = r13 / (r15 - 1);
        int r112 = 0;
        int r113 = 0;
    L6:
        PropertyValuesHolder r114 = null;
        if (r112 >= r15) goto L14;
        r14.getPosTan(r12 - ((Float) r11.get(r113)).floatValue(), r111, null);
        r16[r112] = r111[r5];
        r110[r112] = r111[1];
        r12 = r12 + r22;
        int r115 = r113 + 1;
        if (r115 >= r11.size()) goto L13;
        if (r12 <= ((Float) r11.get(r115)).floatValue()) goto L13;
        r14.nextContour();
        r113 = r115;
    L13:
        r112 = r112 + 1;
        r5 = 0;
        goto L6
    L14:
        if (r20 == null) goto L16;
        PropertyValuesHolder r23 = PropertyValuesHolder.ofFloat(r20, r16);
    L17:
        if (r21 == null) goto L19;
        r114 = PropertyValuesHolder.ofFloat(r21, r110);
    L19:
        if (r23 != null) goto L21;
        r18.setValues(new PropertyValuesHolder[]{r114});
        return;
    L21:
        if (r114 != null) goto L23;
        r18.setValues(new PropertyValuesHolder[]{r23});
        return;
    L23:
        r18.setValues(new PropertyValuesHolder[]{r23, r114});
        return;
    L16:
        r23 = null;
        goto L17
    }

    private static Animator createAnimatorFromXml(Context r18, Resources r19, Resources.Theme r20, XmlPullParser r21, AttributeSet r22, AnimatorSet r23, int r24, float r25) throws XmlPullParserException, IOException {
        int r12 = r21.getDepth();
        Animator r5 = null;
        ArrayList r13 = null;
    L3:
        int r10 = r21.next();
        int r14 = 0;
        if (r10 != 3) goto L8;
        if (r21.getDepth() > r12) goto L8;
    L37:
        if (r23 == null) goto L46;
        if (r13 == null) goto L46;
        Animator[] r11 = new Animator[r13.size()];
        Iterator r15 = r13.iterator();
    L41:
        if (r15.hasNext() == false) goto L43;
        r11[r14] = (Animator) r15.next();
        r14 = r14 + 1;
        goto L41
    L43:
        if (r24 != 0) goto L45;
        r23.playTogether(r11);
        goto L46
    L45:
        r23.playSequentially(r11);
    L46:
        return r5;
    L8:
        if (r10 == 1) goto L37;
        if (r10 != 2) goto L3;
        String r16 = r21.getName();
        if (r16.equals("objectAnimator") == false) goto L17;
        r5 = loadObjectAnimator(r18, r19, r20, r22, r25, r21);
    L30:
        if (r23 == null) goto L3;
        if (r14 != 0) goto L3;
        if (r13 != null) goto L34;
        r13 = new ArrayList();
    L34:
        r13.add(r5);
        goto L3
    L17:
        if (r16.equals("animator") == false) goto L20;
        r5 = loadAnimator(r18, r19, r20, r22, null, r25, r21);
        goto L30
    L20:
        if (r16.equals("set") == false) goto L23;
        AnimatorSet r17 = new AnimatorSet();
        TypedArray r26 = TypedArrayUtils.obtainAttributes(r19, r20, r22, AndroidResources.STYLEABLE_ANIMATOR_SET);
        createAnimatorFromXml(r18, r19, r20, r21, r22, r17, TypedArrayUtils.getNamedInt(r26, r21, "ordering", 0, 0), r25);
        r26.recycle();
        r5 = r17;
        goto L30
    L23:
        if (r16.equals("propertyValuesHolder") == false) goto L36;
        PropertyValuesHolder[] r27 = loadValues(r18, r19, r20, r21, Xml.asAttributeSet(r21));
        if (r27 != null) goto L27;
    L29:
        r14 = 1;
        goto L30
    L27:
        if ((r5 instanceof ValueAnimator) == false) goto L29;
        ((ValueAnimator) r5).setValues(r27);
        goto L29
    L36:
        throw new RuntimeException("Unknown animator name: " + r21.getName());
    }

    public static Animator loadAnimator(Context r5, Resources r10, Resources.Theme r11, @AnimatorRes int r12) throws Resources.NotFoundException {
        return loadAnimator(r5, r10, r11, r12, 1.0f);
    }

    public static Animator loadAnimator(Context r5, Resources r10, Resources.Theme r11, @AnimatorRes int r12, float r13) throws Resources.NotFoundException {
        XmlResourceParser r14 = null;
        r14 = r10.getAnimation(r12);     // Catch: Throwable -> L7 IOException -> L9 XmlPullParserException -> L11
        Animator r15 = createAnimatorFromXml(r5, r10, r11, r14, r13);     // Catch: Throwable -> L7 IOException -> L9 XmlPullParserException -> L11
        if (r14 == null) goto L6;
        r14.close();
    L6:
        return r15;
    L7:
        th = move-exception;
        if (r14 == null) goto L19;
        r14.close();
    L19:
        throw th;
    L9:
        e = move-exception;
        Resources.NotFoundException r16 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(r12));     // Catch: Throwable -> L7
        r16.initCause(e);     // Catch: Throwable -> L7
        throw r16;     // Catch: Throwable -> L7
    L11:
        e = move-exception;
        Resources.NotFoundException r17 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(r12));     // Catch: Throwable -> L7
        r17.initCause(e);     // Catch: Throwable -> L7
        throw r17;     // Catch: Throwable -> L7
    }

    private static ValueAnimator loadAnimator(Context r5, Resources r10, Resources.Theme r11, AttributeSet r12, ValueAnimator r13, float r14, XmlPullParser r15) throws Resources.NotFoundException {
        TypedArray r16 = TypedArrayUtils.obtainAttributes(r10, r11, r12, AndroidResources.STYLEABLE_ANIMATOR);
        TypedArray r17 = TypedArrayUtils.obtainAttributes(r10, r11, r12, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
        if (r13 != null) goto L5;
        r13 = new ValueAnimator();
    L5:
        parseAnimatorFromTypeArray(r13, r16, r17, r14, r15);
        int r18 = TypedArrayUtils.getNamedResourceId(r16, r15, "interpolator", 0, 0);
        if (r18 <= 0) goto L8;
        r13.setInterpolator(AnimationUtilsCompat.loadInterpolator(r5, r18));
    L8:
        r16.recycle();
        if (r17 == null) goto L11;
        r17.recycle();
    L11:
        return r13;
    }
}
