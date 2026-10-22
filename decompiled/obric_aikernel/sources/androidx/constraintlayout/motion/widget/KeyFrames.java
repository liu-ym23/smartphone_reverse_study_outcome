package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class KeyFrames {
    private static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    private static final String CUSTOM_METHOD = "CustomMethod";
    private static final String TAG = "KeyFrames";
    public static final int UNSET = -1;
    static HashMap<String, Constructor<? extends Key>> sKeyMakers;
    private HashMap<Integer, ArrayList<Key>> mFramesMap;

    static {
        HashMap<String, Constructor<? extends Key>> r10 = new HashMap();
        sKeyMakers = r10;
        r10.put("KeyAttribute", KeyAttributes.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put(TypedValues.PositionType.NAME, KeyPosition.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put(TypedValues.CycleType.NAME, KeyCycle.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put(TypedValues.TriggerType.NAME, KeyTrigger.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "unable to load", e);
    }

    public KeyFrames() {
        this.mFramesMap = new HashMap();
    }

    public KeyFrames(Context r10, XmlPullParser r11) {
        this.mFramesMap = new HashMap();
        Key r12 = null;
        int r13 = r11.getEventType();     // Catch: IOException -> L43 XmlPullParserException -> L45
    L5:
        if (r13 == 1) goto L68;
        if (r13 != 2) goto L9;
        String r14 = r11.getName();     // Catch: IOException -> L43 XmlPullParserException -> L45
        if (sKeyMakers.containsKey(r14) == false) goto L30;
        Constructor<? extends Key> r15 = sKeyMakers.get(r14);     // Catch: Exception -> L25
        if (r15 == null) goto L24;
        Key r16 = r15.newInstance(new Object[0]);     // Catch: Exception -> L25
        r16.load(r10, Xml.asAttributeSet(r11));     // Catch: Exception -> L21
        addKey(r16);     // Catch: Exception -> L21
    L28:
        r12 = r16;
    L41:
        r13 = r11.next();     // Catch: IOException -> L43 XmlPullParserException -> L45
    L21:
        Exception e10 = e;
    L27:
        Log.e(TAG, "unable to create ", e10);     // Catch: IOException -> L43 XmlPullParserException -> L45
        goto L28
    L24:
        throw new NullPointerException("Keymaker for " + r14 + " not found");     // Catch: Exception -> L25
    L25:
        e = move-exception;
        r16 = r12;
        e10 = e;
        goto L27
    L30:
        if (r14.equalsIgnoreCase("CustomAttribute") == false) goto L36;
        if (r12 == null) goto L41;
        HashMap<String, ConstraintAttribute> r17 = r12.mCustomConstraints;     // Catch: IOException -> L43 XmlPullParserException -> L45
        if (r17 == null) goto L41;
    L34:
        ConstraintAttribute.parse(r10, r11, r17);     // Catch: IOException -> L43 XmlPullParserException -> L45
        goto L41
    L36:
        if (r14.equalsIgnoreCase("CustomMethod") == false) goto L41;
        if (r12 == null) goto L41;
        r17 = r12.mCustomConstraints;     // Catch: IOException -> L43 XmlPullParserException -> L45
        if (r17 == null) goto L41;
    L9:
        if (r13 != 3) goto L41;
        if (ViewTransition.KEY_FRAME_SET_TAG.equals(r11.getName()) == false) goto L41;
        return;
    L68:
        return;
    L43:
        e = move-exception;
        e.printStackTrace();
        return;
    L45:
        e = move-exception;
        e.printStackTrace();
    }

    static String name(int r10, Context r11) {
        return r11.getResources().getResourceEntryName(r10);
    }

    public void addAllFrames(MotionController r10) {
        ArrayList<Key> r11 = this.mFramesMap.get(-1);
        if (r11 == null) goto L6;
        r10.addKeys(r11);
        return;
    }

    public void addFrames(MotionController r10) {
        ArrayList<Key> r11 = this.mFramesMap.get(Integer.valueOf(r10.mId));
        if (r11 == null) goto L5;
        r10.addKeys(r11);
    L5:
        ArrayList<Key> r12 = this.mFramesMap.get(-1);
        if (r12 == null) goto L13;
        Iterator<Key> r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L19;
        Key r14 = r13.next();
        if (r14.matches(((ConstraintLayout.LayoutParams) r10.mView.getLayoutParams()).constraintTag) == false) goto L9;
        r10.addKey(r14);
        goto L9
    L19:
        return;
    }

    public void addKey(Key r10) {
        if (this.mFramesMap.containsKey(Integer.valueOf(r10.mTargetId)) == true) goto L5;
        this.mFramesMap.put(Integer.valueOf(r10.mTargetId), new ArrayList());
    L5:
        ArrayList<Key> r11 = this.mFramesMap.get(Integer.valueOf(r10.mTargetId));
        if (r11 == null) goto L9;
        r11.add(r10);
        return;
    }

    public ArrayList<Key> getKeyFramesForView(int r10) {
        return this.mFramesMap.get(Integer.valueOf(r10));
    }

    public Set<Integer> getKeys() {
        return this.mFramesMap.keySet();
    }
}
