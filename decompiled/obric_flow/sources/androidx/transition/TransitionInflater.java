package androidx.transition;

import ai.j0;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
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

    private TransitionInflater(@NonNull Context r5) {
        this.mContext = r5;
    }

    private Object createCustom(AttributeSet r5, Class<?> r10, String r11) {
        String r12 = r5.getAttributeValue(null, "class");
        if (r12 == null) goto L22;
        ArrayMap<String, Constructor<?>> r13 = CONSTRUCTORS;     // Catch: Exception -> L18
        monitor-enter(r13);     // Catch: Exception -> L18
        Constructor<?> r14 = r13.get(r12);     // Catch: Throwable -> L11
        if (r14 != null) goto L13;
        Class<? extends U> r15 = Class.forName(r12, false, this.mContext.getClassLoader()).asSubclass(r10);     // Catch: Throwable -> L11
        if (r15 == 0) goto L13;
        r14 = r15.getConstructor(CONSTRUCTOR_SIGNATURE);     // Catch: Throwable -> L11
        r14.setAccessible(true);     // Catch: Throwable -> L11
        r13.put(r12, r14);     // Catch: Throwable -> L11
    L13:
        Object r16 = r14.newInstance(new Object[]{this.mContext, r5});     // Catch: Throwable -> L11
        monitor-exit(r13);     // Catch: Throwable -> L11
        return r16;
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L18
    L18:
        e = move-exception;
        throw new InflateException("Could not instantiate " + r10 + " class " + r12, e);
    L22:
        throw new InflateException(j0.j(r11, " tag must have a 'class' attribute"));
    }

    @Nullable
    private Transition createTransitionFromXml(XmlPullParser r10, AttributeSet r11, Transition r12) throws XmlPullParserException, IOException {
        int r5 = r10.getDepth();
        if ((r12 instanceof TransitionSet) == false) goto L5;
        TransitionSet r13 = (TransitionSet) r12;
    L6:
        Transition r14 = null;
    L7:
        int r15 = r10.next();
        if (r15 != 3) goto L12;
        if (r10.getDepth() > r5) goto L12;
    L82:
        return r14;
    L12:
        if (r15 == 1) goto L82;
        if (r15 != 2) goto L7;
        String r16 = r10.getName();
        if ("fade".equals(r16) == false) goto L20;
        r14 = new Fade(this.mContext, r11);
    L68:
        if (r14 == null) goto L7;
        if (r10.isEmptyElementTag() == true) goto L72;
        createTransitionFromXml(r10, r11, r14);
    L72:
        if (r13 != null) goto L73;
        if (r12 == null) goto L7;
        throw new InflateException("Could not add transition to another transition.");
    L73:
        r13.addTransition(r14);
        goto L6
    L20:
        if ("changeBounds".equals(r16) == false) goto L23;
        r14 = new ChangeBounds(this.mContext, r11);
        goto L68
    L23:
        if ("slide".equals(r16) == false) goto L26;
        r14 = new Slide(this.mContext, r11);
        goto L68
    L26:
        if ("explode".equals(r16) == false) goto L29;
        r14 = new Explode(this.mContext, r11);
        goto L68
    L29:
        if ("changeImageTransform".equals(r16) == false) goto L32;
        r14 = new ChangeImageTransform(this.mContext, r11);
        goto L68
    L32:
        if ("changeTransform".equals(r16) == false) goto L35;
        r14 = new ChangeTransform(this.mContext, r11);
        goto L68
    L35:
        if ("changeClipBounds".equals(r16) == false) goto L38;
        r14 = new ChangeClipBounds(this.mContext, r11);
        goto L68
    L38:
        if ("autoTransition".equals(r16) == false) goto L41;
        r14 = new AutoTransition(this.mContext, r11);
        goto L68
    L41:
        if ("changeScroll".equals(r16) == false) goto L44;
        r14 = new ChangeScroll(this.mContext, r11);
        goto L68
    L44:
        if ("transitionSet".equals(r16) == false) goto L47;
        r14 = new TransitionSet(this.mContext, r11);
        goto L68
    L47:
        if ("transition".equals(r16) == false) goto L50;
        r14 = (Transition) createCustom(r11, Transition.class, "transition");
        goto L68
    L50:
        if ("targets".equals(r16) == false) goto L53;
        getTargetIds(r10, r11, r12);
        goto L68
    L53:
        if ("arcMotion".equals(r16) == false) goto L59;
        if (r12 == null) goto L57;
        r12.setPathMotion(new ArcMotion(this.mContext, r11));
        goto L68
    L57:
        throw new RuntimeException("Invalid use of arcMotion element");
    L59:
        if ("pathMotion".equals(r16) == false) goto L65;
        if (r12 == null) goto L63;
        r12.setPathMotion((PathMotion) createCustom(r11, PathMotion.class, "pathMotion"));
        goto L68
    L63:
        throw new RuntimeException("Invalid use of pathMotion element");
    L65:
        if ("patternPathMotion".equals(r16) == false) goto L81;
        if (r12 == null) goto L79;
        r12.setPathMotion(new PatternPathMotion(this.mContext, r11));
        goto L68
    L79:
        throw new RuntimeException("Invalid use of patternPathMotion element");
    L81:
        throw new RuntimeException("Unknown scene name: " + r10.getName());
    L5:
        r13 = null;
        goto L6
    }

    @Nullable
    private TransitionManager createTransitionManagerFromXml(XmlPullParser r5, AttributeSet r10, @NonNull ViewGroup r11) throws XmlPullParserException, IOException {
        int r12 = r5.getDepth();
        TransitionManager r13 = null;
    L3:
        int r14 = r5.next();
        if (r14 != 3) goto L8;
        if (r5.getDepth() > r12) goto L8;
    L21:
        return r13;
    L8:
        if (r14 == 1) goto L21;
        if (r14 != 2) goto L3;
        String r15 = r5.getName();
        if (r15.equals("transitionManager") == true) goto L14;
        if (r15.equals("transition") == false) goto L20;
        if (r13 == null) goto L20;
        loadTransition(r10, r5, r11, r13);
    L20:
        throw new RuntimeException("Unknown scene name: " + r5.getName());
    L14:
        r13 = new TransitionManager();
        goto L3
    }

    @NonNull
    public static TransitionInflater from(@NonNull Context r5) {
        return new TransitionInflater(r5);
    }

    private void getTargetIds(XmlPullParser r10, AttributeSet r11, @NonNull Transition r12) throws XmlPullParserException, IOException {
        int r5 = r10.getDepth();
    L3:
        int r13 = r10.next();
        if (r13 != 3) goto L8;
        if (r10.getDepth() > r5) goto L8;
        return;
    L8:
        if (r13 == 1) goto L49;
        if (r13 != 2) goto L3;
        if (r10.getName().equals("target") == false) goto L38;
        TypedArray r14 = this.mContext.obtainStyledAttributes(r11, Styleable.TRANSITION_TARGET);
        int r15 = TypedArrayUtils.getNamedResourceId(r14, r10, "targetId", 1, 0);
        if (r15 == 0) goto L17;
        r12.addTarget(r15);
    L34:
        r14.recycle();
        goto L3
    L17:
        int r16 = TypedArrayUtils.getNamedResourceId(r14, r10, "excludeId", 2, 0);
        if (r16 == 0) goto L20;
        r12.excludeTarget(r16, true);
        goto L34
    L20:
        String r17 = TypedArrayUtils.getNamedString(r14, r10, "targetName", 4);
        if (r17 == null) goto L23;
        r12.addTarget(r17);
        goto L34
    L23:
        String r18 = TypedArrayUtils.getNamedString(r14, r10, "excludeName", 5);
        if (r18 == null) goto L26;
        r12.excludeTarget(r18, true);
        goto L34
    L26:
        String r19 = TypedArrayUtils.getNamedString(r14, r10, "excludeClass", 3);
        if (r19 != null) goto L40;
        String r20 = TypedArrayUtils.getNamedString(r14, r10, "targetClass", 0);     // Catch: ClassNotFoundException -> L29
        if (r20 == null) goto L34;
        r12.addTarget(Class.forName(r20));     // Catch: ClassNotFoundException -> L29
        goto L34
    L40:
        r12.excludeTarget(Class.forName(r19), true);     // Catch: ClassNotFoundException -> L29
    L29:
        e = move-exception;
        r14.recycle();
        throw new RuntimeException(j0.C("Could not create ", r19), e);
    L38:
        throw new RuntimeException("Unknown scene name: " + r10.getName());
    }

    private void loadTransition(AttributeSet r10, XmlPullParser r11, @NonNull ViewGroup r12, TransitionManager r13) throws Resources.NotFoundException {
        TypedArray r14 = this.mContext.obtainStyledAttributes(r10, Styleable.TRANSITION_MANAGER);
        int r5 = TypedArrayUtils.getNamedResourceId(r14, r11, "transition", 2, -1);
        int r15 = TypedArrayUtils.getNamedResourceId(r14, r11, "fromScene", 0, -1);
        Scene r16 = null;
        if (r15 >= 0) goto L5;
        Scene r17 = null;
    L6:
        int r18 = TypedArrayUtils.getNamedResourceId(r14, r11, "toScene", 1, -1);
        if (r18 < 0) goto L10;
        r16 = Scene.getSceneForLayout(r12, r18, this.mContext);
    L10:
        if (r5 < 0) goto L19;
        Transition r19 = inflateTransition(r5);
        if (r19 == null) goto L19;
        if (r16 == null) goto L18;
        if (r17 != null) goto L16;
        r13.setTransition(r16, r19);
        goto L19
    L16:
        r13.setTransition(r17, r16, r19);
        goto L19
    L18:
        throw new RuntimeException(j0.g(r5, "No toScene for transition ID "));
    L19:
        r14.recycle();
        return;
    L5:
        r17 = Scene.getSceneForLayout(r12, r15, this.mContext);
        goto L6
    }

    @Nullable
    public Transition inflateTransition(int r5) {
        XmlResourceParser r10 = this.mContext.getResources().getXml(r5);
        Transition r11 = createTransitionFromXml(r10, Xml.asAttributeSet(r10), null);     // Catch: Throwable -> L6 IOException -> L8 XmlPullParserException -> L10
        r10.close();
        return r11;
    L6:
        th = move-exception;
        r10.close();
        throw th;
    L8:
        e = move-exception;
        throw new InflateException(r10.getPositionDescription() + ": " + e.getMessage(), e);     // Catch: Throwable -> L6
    L10:
        e = move-exception;
        throw new InflateException(e.getMessage(), e);     // Catch: Throwable -> L6
    }

    @Nullable
    public TransitionManager inflateTransitionManager(int r5, @NonNull ViewGroup r10) {
        XmlResourceParser r11 = this.mContext.getResources().getXml(r5);
        TransitionManager r12 = createTransitionManagerFromXml(r11, Xml.asAttributeSet(r11), r10);     // Catch: Throwable -> L6 IOException -> L8 XmlPullParserException -> L10
        r11.close();
        return r12;
    L6:
        th = move-exception;
        r11.close();
        throw th;
    L8:
        e = move-exception;
        InflateException r13 = new InflateException(r11.getPositionDescription() + ": " + e.getMessage());     // Catch: Throwable -> L6
        r13.initCause(e);     // Catch: Throwable -> L6
        throw r13;     // Catch: Throwable -> L6
    L10:
        e = move-exception;
        InflateException r14 = new InflateException(e.getMessage());     // Catch: Throwable -> L6
        r14.initCause(e);     // Catch: Throwable -> L6
        throw r14;     // Catch: Throwable -> L6
    }
}
