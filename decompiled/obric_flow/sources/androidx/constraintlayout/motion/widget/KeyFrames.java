package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
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
    private static final String TAG = "KeyFrames";
    public static final int UNSET = -1;
    static HashMap<String, Constructor<? extends Key>> sKeyMakers;
    private HashMap<Integer, ArrayList<Key>> mFramesMap;

    static {
        HashMap<String, Constructor<? extends Key>> r5 = new HashMap();
        sKeyMakers = r5;
        r5.put("KeyAttribute", KeyAttributes.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyPosition", KeyPosition.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyCycle", KeyCycle.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyTrigger", KeyTrigger.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "unable to load", e);
    }

    public KeyFrames(Context r10, XmlPullParser r11) {
        this.mFramesMap = new HashMap();
        int r5 = r11.getEventType();     // Catch: IOException -> L14 XmlPullParserException -> L16
        Key r12 = null;
    L5:
        if (r5 == 1) goto L56;
        if (r5 != 2) goto L9;
        String r13 = r11.getName();     // Catch: IOException -> L14 XmlPullParserException -> L16
        if (sKeyMakers.containsKey(r13) == false) goto L29;
        Key r14 = sKeyMakers.get(r13).newInstance(null);     // Catch: Exception -> L25
        r14.load(r10, Xml.asAttributeSet(r11));     // Catch: Exception -> L23
        addKey(r14);     // Catch: Exception -> L23
    L22:
        r12 = r14;
    L34:
        r5 = r11.next();     // Catch: IOException -> L14 XmlPullParserException -> L16
    L23:
        Exception e = e;
    L27:
        Log.e(TAG, "unable to create ", e);     // Catch: IOException -> L14 XmlPullParserException -> L16
    L25:
        e = move-exception;
        Key r15 = r12;
        e = e;
        r14 = r15;
        goto L27
    L29:
        if (r13.equalsIgnoreCase("CustomAttribute") == false) goto L34;
        if (r12 == null) goto L34;
        HashMap<String, ConstraintAttribute> r16 = r12.mCustomConstraints;     // Catch: IOException -> L14 XmlPullParserException -> L16
        if (r16 == null) goto L34;
        ConstraintAttribute.parse(r10, r11, r16);     // Catch: IOException -> L14 XmlPullParserException -> L16
        goto L34
    L9:
        if (r5 != 3) goto L34;
        if ("KeyFrameSet".equals(r11.getName()) == false) goto L34;
        return;
    L56:
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    }

    private void addKey(Key r5) {
        if (this.mFramesMap.containsKey(Integer.valueOf(r5.mTargetId)) == true) goto L5;
        this.mFramesMap.put(Integer.valueOf(r5.mTargetId), new ArrayList());
    L5:
        this.mFramesMap.get(Integer.valueOf(r5.mTargetId)).add(r5);
    }

    public static String name(int r5, Context r10) {
        return r10.getResources().getResourceEntryName(r5);
    }

    public void addFrames(MotionController r5) {
        ArrayList<Key> r10 = this.mFramesMap.get(Integer.valueOf(r5.mId));
        if (r10 == null) goto L5;
        r5.addKeys(r10);
    L5:
        ArrayList<Key> r11 = this.mFramesMap.get(-1);
        if (r11 == null) goto L13;
        Iterator<Key> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L19;
        Key r13 = r12.next();
        if (r13.matches(((ConstraintLayout.LayoutParams) r5.mView.getLayoutParams()).constraintTag) == false) goto L9;
        r5.addKey(r13);
        goto L9
    L19:
        return;
    }

    public ArrayList<Key> getKeyFramesForView(int r5) {
        return this.mFramesMap.get(Integer.valueOf(r5));
    }

    public Set<Integer> getKeys() {
        return this.mFramesMap.keySet();
    }
}
