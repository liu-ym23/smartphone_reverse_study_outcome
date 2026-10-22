package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.TypedArrayUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    private TransitionInflater(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    private Object createCustom(AttributeSet r6, Class<?> r7, String r8) {
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        String r0 = r9.getAttributeValue(null, "class");
        if (r0 == null) goto L21;
        ArrayMap<String, Constructor<?>> r10 = CONSTRUCTORS;     // Catch: Exception -> L17
        monitor-enter(r10);     // Catch: Exception -> L17
        Constructor<?> r1 = (Constructor) ZeusTransformUtils.preCheckCast(r10.get(r0), Constructor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r1 != null) goto L11;
        Class<? extends U> r4 = Class.forName(r0, false, this.mContext.getClassLoader()).asSubclass(r7);     // Catch: Throwable -> L14
        if (r4 == 0) goto L11;
        r1 = r4.getConstructor(CONSTRUCTOR_SIGNATURE);     // Catch: Throwable -> L14
        r1.setAccessible(true);     // Catch: Throwable -> L14
        r10.put(r0, r1);     // Catch: Throwable -> L14
    L11:
        Object r5 = r1.newInstance(new Object[]{this.mContext, r9});     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        return r5;
    L14:
        th = move-exception;
        throw th;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        throw new InflateException("Could not instantiate " + r7 + " class " + r0, e);
    L21:
        throw new InflateException(r8 + " tag must have a 'class' attribute");
    }

    private Transition createTransitionFromXml(XmlPullParser r9, AttributeSet r10, Transition r11) {
        XmlPullParser r12 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.memorydata.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        int r0 = r12.getDepth();
        if (ZeusTransformUtils.instanceOf(r11, TransitionSet.class) == false) goto L5;
        TransitionSet r2 = (TransitionSet) ZeusTransformUtils.preCheckCast(r11, TransitionSet.class, "com.obric.memorydata.plugin");
    L6:
        Transition r4 = null;
    L7:
        int r5 = r12.next();
        if (r5 != 3) goto L12;
        if (r12.getDepth() > r0) goto L12;
    L83:
        return r4;
    L12:
        if (r5 == 1) goto L83;
        if (r5 != 2) goto L7;
        String r6 = r12.getName();
        if ("fade".equals(r6) == false) goto L20;
        r4 = new Fade(this.mContext, r13);
    L69:
        if (r4 == null) goto L7;
        if (r12.isEmptyElementTag() == true) goto L73;
        createTransitionFromXml(r12, r13, r4);
    L73:
        if (r2 != null) goto L74;
        if (r11 == null) goto L7;
        throw new InflateException("Could not add transition to another transition.");
    L74:
        r2.addTransition(r4);
        goto L6
    L20:
        if ("changeBounds".equals(r6) == false) goto L23;
        r4 = new ChangeBounds(this.mContext, r13);
        goto L69
    L23:
        if ("slide".equals(r6) == false) goto L26;
        r4 = new Slide(this.mContext, r13);
        goto L69
    L26:
        if ("explode".equals(r6) == false) goto L29;
        r4 = new Explode(this.mContext, r13);
        goto L69
    L29:
        if ("changeImageTransform".equals(r6) == false) goto L32;
        r4 = new ChangeImageTransform(this.mContext, r13);
        goto L69
    L32:
        if ("changeTransform".equals(r6) == false) goto L35;
        r4 = new ChangeTransform(this.mContext, r13);
        goto L69
    L35:
        if ("changeClipBounds".equals(r6) == false) goto L38;
        r4 = new ChangeClipBounds(this.mContext, r13);
        goto L69
    L38:
        if (TypedValues.TransitionType.S_AUTO_TRANSITION.equals(r6) == false) goto L41;
        r4 = new AutoTransition(this.mContext, r13);
        goto L69
    L41:
        if ("changeScroll".equals(r6) == false) goto L44;
        r4 = new ChangeScroll(this.mContext, r13);
        goto L69
    L44:
        if ("transitionSet".equals(r6) == false) goto L47;
        r4 = new TransitionSet(this.mContext, r13);
        goto L69
    L47:
        if ("transition".equals(r6) == false) goto L50;
        r4 = (Transition) ZeusTransformUtils.preCheckCast(createCustom(r13, Transition.class, "transition"), Transition.class, "com.obric.memorydata.plugin");
        goto L69
    L50:
        if ("targets".equals(r6) == false) goto L53;
        getTargetIds(r12, r13, r11);
        goto L69
    L53:
        if ("arcMotion".equals(r6) == false) goto L60;
        if (r11 == null) goto L58;
        PathMotion r7 = new ArcMotion(this.mContext, r13);
    L56:
        r11.setPathMotion(r7);
        goto L69
    L58:
        throw new RuntimeException("Invalid use of arcMotion element");
    L60:
        if ("pathMotion".equals(r6) == false) goto L66;
        if (r11 == null) goto L64;
        r7 = (PathMotion) ZeusTransformUtils.preCheckCast(createCustom(r13, PathMotion.class, "pathMotion"), PathMotion.class, "com.obric.memorydata.plugin");
        goto L56
    L64:
        throw new RuntimeException("Invalid use of pathMotion element");
    L66:
        if ("patternPathMotion".equals(r6) == false) goto L82;
        if (r11 == null) goto L80;
        r7 = new PatternPathMotion(this.mContext, r13);
        goto L56
    L80:
        throw new RuntimeException("Invalid use of patternPathMotion element");
    L82:
        throw new RuntimeException("Unknown scene name: " + r12.getName());
    L5:
        r2 = null;
        goto L6
    }

    private TransitionManager createTransitionManagerFromXml(XmlPullParser r5, AttributeSet r6, ViewGroup r7) {
        XmlPullParser r8 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r5, XmlPullParser.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        int r0 = r8.getDepth();
        TransitionManager r1 = null;
    L3:
        int r2 = r8.next();
        if (r2 != 3) goto L8;
        if (r8.getDepth() > r0) goto L8;
    L21:
        return r1;
    L8:
        if (r2 == 1) goto L21;
        if (r2 != 2) goto L3;
        String r3 = r8.getName();
        if (r3.equals("transitionManager") == true) goto L14;
        if (r3.equals("transition") == false) goto L20;
        if (r1 == null) goto L20;
        loadTransition(r9, r8, r7, r1);
    L20:
        throw new RuntimeException("Unknown scene name: " + r8.getName());
    L14:
        r1 = new TransitionManager();
        goto L3
    }

    public static TransitionInflater from(Context r2) {
        return new TransitionInflater((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    private void getTargetIds(XmlPullParser r9, AttributeSet r10, Transition r11) {
        XmlPullParser r12 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.memorydata.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        int r0 = r12.getDepth();
    L3:
        int r2 = r12.next();
        if (r2 != 3) goto L8;
        if (r12.getDepth() > r0) goto L8;
        return;
    L8:
        if (r2 == 1) goto L48;
        if (r2 != 2) goto L3;
        if (r12.getName().equals(TypedValues.AttributesType.S_TARGET) == false) goto L37;
        TypedArray r3 = this.mContext.obtainStyledAttributes(r13, Styleable.TRANSITION_TARGET);
        int r6 = TypedArrayUtils.getNamedResourceId(r3, r12, "targetId", 1, 0);
        if (r6 == 0) goto L17;
        r11.addTarget(r6);
    L32:
        r3.recycle();
        goto L3
    L17:
        int r5 = TypedArrayUtils.getNamedResourceId(r3, r12, "excludeId", 2, 0);
        if (r5 == 0) goto L20;
        r11.excludeTarget(r5, true);
        goto L32
    L20:
        String r7 = TypedArrayUtils.getNamedString(r3, r12, "targetName", 4);
        if (r7 == null) goto L23;
        r11.addTarget(r7);
        goto L32
    L23:
        String r8 = TypedArrayUtils.getNamedString(r3, r12, "excludeName", 5);
        if (r8 == null) goto L26;
        r11.excludeTarget(r8, true);
        goto L32
    L26:
        String r4 = TypedArrayUtils.getNamedString(r3, r12, "excludeClass", 3);
        if (r4 != null) goto L39;
        String r14 = TypedArrayUtils.getNamedString(r3, r12, "targetClass", 0);     // Catch: ClassNotFoundException -> L33
        if (r14 == null) goto L32;
        r11.addTarget(ZeusTransformUtils.forName(r14, "com.obric.memorydata.plugin"));     // Catch: ClassNotFoundException -> L33
        goto L32
    L39:
        r11.excludeTarget(ZeusTransformUtils.forName(r4, "com.obric.memorydata.plugin"), true);     // Catch: ClassNotFoundException -> L33
    L33:
        e = move-exception;
        r3.recycle();
        throw new RuntimeException("Could not create " + r4, e);
    L37:
        throw new RuntimeException("Unknown scene name: " + r12.getName());
    }

    private void loadTransition(AttributeSet r7, XmlPullParser r8, ViewGroup r9, TransitionManager r10) {
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        XmlPullParser r12 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r8, XmlPullParser.class, "com.obric.memorydata.plugin");
        TypedArray r13 = this.mContext.obtainStyledAttributes(r11, Styleable.TRANSITION_MANAGER);
        int r0 = TypedArrayUtils.getNamedResourceId(r13, r12, "transition", 2, -1);
        int r1 = TypedArrayUtils.getNamedResourceId(r13, r12, "fromScene", 0, -1);
        Scene r3 = null;
        if (r1 >= 0) goto L5;
        Scene r2 = null;
    L6:
        int r14 = TypedArrayUtils.getNamedResourceId(r13, r12, "toScene", 1, -1);
        if (r14 < 0) goto L10;
        r3 = Scene.getSceneForLayout(r9, r14, this.mContext);
    L10:
        if (r0 < 0) goto L19;
        Transition r6 = inflateTransition(r0);
        if (r6 == null) goto L19;
        if (r3 == null) goto L18;
        if (r2 != null) goto L16;
        r10.setTransition(r3, r6);
        goto L19
    L16:
        r10.setTransition(r2, r3, r6);
        goto L19
    L18:
        throw new RuntimeException("No toScene for transition ID " + r0);
    L19:
        r13.recycle();
        return;
    L5:
        r2 = Scene.getSceneForLayout(r9, r1, this.mContext);
        goto L6
    }

    public Transition inflateTransition(int r4) {
        XmlResourceParser r5 = ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getXml(r4);
        Transition r3 = createTransitionFromXml(r5, Xml.asAttributeSet(r5), null);     // Catch: Throwable -> L6 IOException -> L8 XmlPullParserException -> L11
        r5.close();
        return r3;
    L6:
        th = move-exception;
        r5.close();
        throw th;
    L8:
        e = move-exception;
        throw new InflateException(r5.getPositionDescription() + ": " + e.getMessage(), e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new InflateException(e.getMessage(), e);     // Catch: Throwable -> L6
    }

    public TransitionManager inflateTransitionManager(int r3, ViewGroup r4) {
        XmlResourceParser r5 = ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getXml(r3);
        TransitionManager r2 = createTransitionManagerFromXml(r5, Xml.asAttributeSet(r5), r4);     // Catch: Throwable -> L6 IOException -> L8 XmlPullParserException -> L11
        r5.close();
        return r2;
    L6:
        th = move-exception;
        r5.close();
        throw th;
    L8:
        e = move-exception;
        InflateException r6 = new InflateException(r5.getPositionDescription() + ": " + e.getMessage());     // Catch: Throwable -> L6
        r6.initCause(e);     // Catch: Throwable -> L6
        throw r6;     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        InflateException r7 = new InflateException(e.getMessage());     // Catch: Throwable -> L6
        r7.initCause(e);     // Catch: Throwable -> L6
        throw r7;     // Catch: Throwable -> L6
    }
}
