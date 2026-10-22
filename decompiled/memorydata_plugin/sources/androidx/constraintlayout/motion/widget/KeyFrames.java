package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        HashMap<String, Constructor<? extends Key>> r0 = new HashMap();
        sKeyMakers = r0;
        r0.put("KeyAttribute", KeyAttributes.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
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

    public KeyFrames(Context r8, XmlPullParser r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.memorydata.plugin");
        this.mFramesMap = new HashMap();
        Key r0 = null;
        int r2 = r11.getEventType();     // Catch: IOException -> L44 XmlPullParserException -> L46
    L5:
        if (r2 == 1) goto L69;
        if (r2 != 2) goto L9;
        String r3 = r11.getName();     // Catch: IOException -> L44 XmlPullParserException -> L46
        if (sKeyMakers.containsKey(r3) == false) goto L30;
        Constructor r4 = (Constructor) ZeusTransformUtils.preCheckCast(sKeyMakers.get(r3), Constructor.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L25 IOException -> L44 XmlPullParserException -> L46
        if (r4 == null) goto L24;
        Key r5 = (Key) ZeusTransformUtils.preCheckCast(r4.newInstance(new Object[0]), Key.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L25 IOException -> L44 XmlPullParserException -> L46
        r5.load(r10, Xml.asAttributeSet(r11));     // Catch: Exception -> L21 IOException -> L44 XmlPullParserException -> L46
        addKey(r5);     // Catch: Exception -> L21 IOException -> L44 XmlPullParserException -> L46
    L28:
        r0 = r5;
    L42:
        r2 = r11.next();     // Catch: IOException -> L44 XmlPullParserException -> L46
    L21:
        Exception e = e;
    L27:
        Log.e(TAG, "unable to create ", e);     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L28
    L24:
        throw new NullPointerException("Keymaker for " + r3 + " not found");     // Catch: Exception -> L25 IOException -> L44 XmlPullParserException -> L46
    L25:
        e = move-exception;
        r5 = r0;
        e = e;
        goto L27
    L30:
        if (r3.equalsIgnoreCase("CustomAttribute") == false) goto L37;
        if (r0 == null) goto L42;
        if (r0.mCustomConstraints == null) goto L42;
        HashMap<String, ConstraintAttribute> r6 = r0.mCustomConstraints;     // Catch: IOException -> L44 XmlPullParserException -> L46
    L35:
        ConstraintAttribute.parse(r10, r11, r6);     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L42
    L37:
        if (r3.equalsIgnoreCase("CustomMethod") == false) goto L42;
        if (r0 == null) goto L42;
        if (r0.mCustomConstraints == null) goto L42;
        r6 = r0.mCustomConstraints;     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L35
    L9:
        if (r2 != 3) goto L42;
        if (ViewTransition.KEY_FRAME_SET_TAG.equals(r11.getName()) == false) goto L42;
        return;
    L69:
        return;
    L44:
        e = move-exception;
        e.printStackTrace();
        return;
    L46:
        e = move-exception;
        e.printStackTrace();
    }

    static String name(int r2, Context r3) {
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getResourceEntryName(r2);
    }

    public void addAllFrames(MotionController r3) {
        ArrayList<Key> r2 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mFramesMap.get(-1), ArrayList.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r3.addKeys(r2);
        return;
    }

    public void addFrames(MotionController r5) {
        ArrayList<Key> r0 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mFramesMap.get(Integer.valueOf(r5.mId)), ArrayList.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r5.addKeys(r0);
    L5:
        ArrayList r4 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mFramesMap.get(-1), ArrayList.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L13;
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L19;
        Key r1 = (Key) ZeusTransformUtils.preCheckCast(r6.next(), Key.class, "com.obric.memorydata.plugin");
        if (r1.matches(((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5.mView.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).constraintTag) == false) goto L9;
        r5.addKey(r1);
        goto L9
    L19:
        return;
    }

    public void addKey(Key r4) {
        if (this.mFramesMap.containsKey(Integer.valueOf(r4.mTargetId)) == true) goto L5;
        this.mFramesMap.put(Integer.valueOf(r4.mTargetId), new ArrayList());
    L5:
        ArrayList r3 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mFramesMap.get(Integer.valueOf(r4.mTargetId)), ArrayList.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.add(r4);
        return;
    }

    public ArrayList<Key> getKeyFramesForView(int r2) {
        return (ArrayList) ZeusTransformUtils.preCheckCast(this.mFramesMap.get(Integer.valueOf(r2)), ArrayList.class, "com.obric.memorydata.plugin");
    }

    public Set<Integer> getKeys() {
        return this.mFramesMap.keySet();
    }
}
