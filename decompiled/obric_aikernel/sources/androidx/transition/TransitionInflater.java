package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class TransitionInflater {
    private static final ArrayMap<String, Constructor<?>> CONSTRUCTORS = null;
    private static final Class<?>[] CONSTRUCTOR_SIGNATURE = null;
    private final Context mContext;

    static {
        CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class};
        CONSTRUCTORS = new ArrayMap();
    }

    private TransitionInflater(@NonNull Context r10) {
        this.mContext = r10;
    }

    private Object createCustom(AttributeSet r10, Class<?> r11, String r12) {
        String r13 = r10.getAttributeValue(null, "class");
        if (r13 == null) goto L21;
        ArrayMap<String, Constructor<?>> r14 = CONSTRUCTORS;     // Catch: Exception -> L17
        monitor-enter(r14);     // Catch: Exception -> L17
        Constructor<?> r15 = r14.get(r13);     // Catch: Throwable -> L14
        if (r15 != null) goto L11;
        Class<? extends U> r16 = Class.forName(r13, false, this.mContext.getClassLoader()).asSubclass(r11);     // Catch: Throwable -> L14
        if (r16 == 0) goto L11;
        r15 = r16.getConstructor(CONSTRUCTOR_SIGNATURE);     // Catch: Throwable -> L14
        r15.setAccessible(true);     // Catch: Throwable -> L14
        r14.put(r13, r15);     // Catch: Throwable -> L14
    L11:
        Object r17 = r15.newInstance(new Object[]{this.mContext, r10});     // Catch: Throwable -> L14
        monitor-exit(r14);     // Catch: Throwable -> L14
        return r17;
    L14:
        th = move-exception;
        throw th;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        throw new InflateException("Could not instantiate " + r11 + " class " + r13, e);
    L21:
        throw new InflateException(r12 + " tag must have a 'class' attribute");
    }

    private Transition createTransitionFromXml(XmlPullParser r10, AttributeSet r11, Transition r12) {
        int r13 = r10.getDepth();
        if ((r12 instanceof TransitionSet) == false) goto L5;
        TransitionSet r14 = (TransitionSet) r12;
    L6:
        Transition r15 = null;
    L7:
        int r16 = r10.next();
        if (r16 != 3) goto L12;
        if (r10.getDepth() > r13) goto L12;
    L83:
        return r15;
    L12:
        if (r16 == 1) goto L83;
        if (r16 != 2) goto L7;
        String r17 = r10.getName();
        if ("fade".equals(r17) == false) goto L20;
        r15 = new Fade(this.mContext, r11);
    L69:
        if (r15 == null) goto L7;
        if (r10.isEmptyElementTag() == true) goto L73;
        createTransitionFromXml(r10, r11, r15);
    L73:
        if (r14 != null) goto L74;
        if (r12 == null) goto L7;
        throw new InflateException("Could not add transition to another transition.");
    L74:
        r14.addTransition(r15);
        goto L6
    L20:
        if ("changeBounds".equals(r17) == false) goto L23;
        r15 = new ChangeBounds(this.mContext, r11);
        goto L69
    L23:
        if ("slide".equals(r17) == false) goto L26;
        r15 = new Slide(this.mContext, r11);
        goto L69
    L26:
        if ("explode".equals(r17) == false) goto L29;
        r15 = new Explode(this.mContext, r11);
        goto L69
    L29:
        if ("changeImageTransform".equals(r17) == false) goto L32;
        r15 = new ChangeImageTransform(this.mContext, r11);
        goto L69
    L32:
        if ("changeTransform".equals(r17) == false) goto L35;
        r15 = new ChangeTransform(this.mContext, r11);
        goto L69
    L35:
        if ("changeClipBounds".equals(r17) == false) goto L38;
        r15 = new ChangeClipBounds(this.mContext, r11);
        goto L69
    L38:
        if (TypedValues.TransitionType.S_AUTO_TRANSITION.equals(r17) == false) goto L41;
        r15 = new AutoTransition(this.mContext, r11);
        goto L69
    L41:
        if ("changeScroll".equals(r17) == false) goto L44;
        r15 = new ChangeScroll(this.mContext, r11);
        goto L69
    L44:
        if ("transitionSet".equals(r17) == false) goto L47;
        r15 = new TransitionSet(this.mContext, r11);
        goto L69
    L47:
        if ("transition".equals(r17) == false) goto L50;
        r15 = (Transition) createCustom(r11, Transition.class, "transition");
        goto L69
    L50:
        if ("targets".equals(r17) == false) goto L53;
        getTargetIds(r10, r11, r12);
        goto L69
    L53:
        if ("arcMotion".equals(r17) == false) goto L60;
        if (r12 == null) goto L58;
        PathMotion r18 = new ArcMotion(this.mContext, r11);
    L56:
        r12.setPathMotion(r18);
        goto L69
    L58:
        throw new RuntimeException("Invalid use of arcMotion element");
    L60:
        if ("pathMotion".equals(r17) == false) goto L66;
        if (r12 == null) goto L64;
        r18 = (PathMotion) createCustom(r11, PathMotion.class, "pathMotion");
        goto L56
    L64:
        throw new RuntimeException("Invalid use of pathMotion element");
    L66:
        if ("patternPathMotion".equals(r17) == false) goto L82;
        if (r12 == null) goto L80;
        r18 = new PatternPathMotion(this.mContext, r11);
        goto L56
    L80:
        throw new RuntimeException("Invalid use of patternPathMotion element");
    L82:
        throw new RuntimeException("Unknown scene name: " + r10.getName());
    L5:
        r14 = null;
        goto L6
    }

    private TransitionManager createTransitionManagerFromXml(XmlPullParser r10, AttributeSet r11, ViewGroup r12) {
        int r13 = r10.getDepth();
        TransitionManager r14 = null;
    L3:
        int r15 = r10.next();
        if (r15 != 3) goto L8;
        if (r10.getDepth() > r13) goto L8;
    L21:
        return r14;
    L8:
        if (r15 == 1) goto L21;
        if (r15 != 2) goto L3;
        String r16 = r10.getName();
        if (r16.equals("transitionManager") == true) goto L14;
        if (r16.equals("transition") == false) goto L20;
        if (r14 == null) goto L20;
        loadTransition(r11, r10, r12, r14);
    L20:
        throw new RuntimeException("Unknown scene name: " + r10.getName());
    L14:
        r14 = new TransitionManager();
        goto L3
    }

    public static TransitionInflater from(Context r10) {
        return new TransitionInflater(r10);
    }

    @SuppressLint({"RestrictedApi"})
    private void getTargetIds(XmlPullParser r10, AttributeSet r11, Transition r12) {
        int r13 = r10.getDepth();
    L3:
        int r14 = r10.next();
        if (r14 != 3) goto L8;
        if (r10.getDepth() > r13) goto L8;
        return;
    L8:
        if (r14 == 1) goto L48;
        if (r14 != 2) goto L3;
        if (r10.getName().equals(TypedValues.AttributesType.S_TARGET) == false) goto L37;
        TypedArray r15 = this.mContext.obtainStyledAttributes(r11, Styleable.TRANSITION_TARGET);
        int r16 = TypedArrayUtils.getNamedResourceId(r15, r10, "targetId", 1, 0);
        if (r16 == 0) goto L17;
        r12.addTarget(r16);
    L32:
        r15.recycle();
        goto L3
    L17:
        int r17 = TypedArrayUtils.getNamedResourceId(r15, r10, "excludeId", 2, 0);
        if (r17 == 0) goto L20;
        r12.excludeTarget(r17, true);
        goto L32
    L20:
        String r18 = TypedArrayUtils.getNamedString(r15, r10, "targetName", 4);
        if (r18 == null) goto L23;
        r12.addTarget(r18);
        goto L32
    L23:
        String r19 = TypedArrayUtils.getNamedString(r15, r10, "excludeName", 5);
        if (r19 == null) goto L26;
        r12.excludeTarget(r19, true);
        goto L32
    L26:
        String r20 = TypedArrayUtils.getNamedString(r15, r10, "excludeClass", 3);
        if (r20 != null) goto L39;
        String r21 = TypedArrayUtils.getNamedString(r15, r10, "targetClass", 0);     // Catch: ClassNotFoundException -> L33
        if (r21 == null) goto L32;
        r12.addTarget(Class.forName(r21));     // Catch: ClassNotFoundException -> L33
        goto L32
    L39:
        r12.excludeTarget(Class.forName(r20), true);     // Catch: ClassNotFoundException -> L33
    L33:
        e = move-exception;
        r15.recycle();
        throw new RuntimeException("Could not create " + r20, e);
    L37:
        throw new RuntimeException("Unknown scene name: " + r10.getName());
    }

    @SuppressLint({"RestrictedApi"})
    private void loadTransition(AttributeSet r10, XmlPullParser r11, ViewGroup r12, TransitionManager r13) {
        TypedArray r14 = this.mContext.obtainStyledAttributes(r10, Styleable.TRANSITION_MANAGER);
        int r15 = TypedArrayUtils.getNamedResourceId(r14, r11, "transition", 2, -1);
        int r16 = TypedArrayUtils.getNamedResourceId(r14, r11, "fromScene", 0, -1);
        Scene r17 = null;
        if (r16 >= 0) goto L5;
        Scene r18 = null;
    L6:
        int r19 = TypedArrayUtils.getNamedResourceId(r14, r11, "toScene", 1, -1);
        if (r19 < 0) goto L10;
        r17 = Scene.getSceneForLayout(r12, r19, this.mContext);
    L10:
        if (r15 < 0) goto L19;
        Transition r20 = inflateTransition(r15);
        if (r20 == null) goto L19;
        if (r17 == null) goto L18;
        if (r18 != null) goto L16;
        r13.setTransition(r17, r20);
        goto L19
    L16:
        r13.setTransition(r18, r17, r20);
        goto L19
    L18:
        throw new RuntimeException("No toScene for transition ID " + r15);
    L19:
        r14.recycle();
        return;
    L5:
        r18 = Scene.getSceneForLayout(r12, r16, this.mContext);
        goto L6
    }

    public Transition inflateTransition(int r10) {
        XmlResourceParser r11 = this.mContext.getResources().getXml(r10);
        Transition r12 = createTransitionFromXml(r11, Xml.asAttributeSet(r11), null);     // Catch: Throwable -> L6 IOException -> L8 XmlPullParserException -> L11
        r11.close();
        return r12;
    L6:
        th = move-exception;
        r11.close();
        throw th;
    L8:
        e = move-exception;
        throw new InflateException(r11.getPositionDescription() + ": " + e.getMessage(), e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new InflateException(e.getMessage(), e);     // Catch: Throwable -> L6
    }

    public TransitionManager inflateTransitionManager(int r10, ViewGroup r11) {
        XmlResourceParser r12 = this.mContext.getResources().getXml(r10);
        TransitionManager r13 = createTransitionManagerFromXml(r12, Xml.asAttributeSet(r12), r11);     // Catch: Throwable -> L6 IOException -> L8 XmlPullParserException -> L11
        r12.close();
        return r13;
    L6:
        th = move-exception;
        r12.close();
        throw th;
    L8:
        e = move-exception;
        InflateException r14 = new InflateException(r12.getPositionDescription() + ": " + e.getMessage());     // Catch: Throwable -> L6
        r14.initCause(e);     // Catch: Throwable -> L6
        throw r14;     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        InflateException r15 = new InflateException(e.getMessage());     // Catch: Throwable -> L6
        r15.initCause(e);     // Catch: Throwable -> L6
        throw r15;     // Catch: Throwable -> L6
    }
}
