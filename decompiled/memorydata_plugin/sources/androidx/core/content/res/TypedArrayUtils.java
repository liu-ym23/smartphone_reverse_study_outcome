package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    private TypedArrayUtils() {
    }

    public static int getAttr(Context r2, int r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        TypedValue r0 = new TypedValue();
        r5.getTheme().resolveAttribute(r3, r0, true);
        if (r0.resourceId == 0) goto L5;
        return r3;
    L5:
        return r4;
    }

    public static boolean getBoolean(TypedArray r0, int r1, int r2, boolean r3) {
        return r0.getBoolean(r1, r0.getBoolean(r2, r3));
    }

    public static Drawable getDrawable(TypedArray r0, int r1, int r2) {
        Drawable r3 = r0.getDrawable(r1);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return r0.getDrawable(r2);
    }

    public static int getInt(TypedArray r0, int r1, int r2, int r3) {
        return r0.getInt(r1, r0.getInt(r2, r3));
    }

    public static boolean getNamedBoolean(TypedArray r2, XmlPullParser r3, String r4, int r5, boolean r6) {
        if (hasAttribute((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin"), r4) == true) goto L6;
        return r6;
    L6:
        return r2.getBoolean(r5, r6);
    }

    public static int getNamedColor(TypedArray r2, XmlPullParser r3, String r4, int r5, int r6) {
        if (hasAttribute((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin"), r4) == true) goto L6;
        return r6;
    L6:
        return r2.getColor(r5, r6);
    }

    public static ColorStateList getNamedColorStateList(TypedArray r2, XmlPullParser r3, Resources.Theme r4, String r5, int r6) {
        if (hasAttribute((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin"), r5) == false) goto L16;
        TypedValue r7 = new TypedValue();
        r2.getValue(r6, r7);
        if (r7.type == 2) goto L15;
        if (r7.type < 28) goto L13;
        if (r7.type > 31) goto L13;
        return getNamedColorStateListFromInt(r7);
    L13:
        return ColorStateListInflaterCompat.inflate(ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin"), r2.getResourceId(r6, 0), r4);
    L15:
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + r6 + ": " + r7);
    L16:
        return null;
    }

    private static ColorStateList getNamedColorStateListFromInt(TypedValue r0) {
        return ColorStateList.valueOf(r0.data);
    }

    public static ComplexColorCompat getNamedComplexColor(TypedArray r2, XmlPullParser r3, Resources.Theme r4, String r5, int r6, int r7) {
        if (hasAttribute((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin"), r5) == false) goto L14;
        TypedValue r8 = new TypedValue();
        r2.getValue(r6, r8);
        if (r8.type >= 28) goto L7;
    L10:
        ComplexColorCompat r9 = ComplexColorCompat.inflate(ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin"), r2.getResourceId(r6, 0), r4);
        if (r9 == null) goto L14;
        return r9;
    L7:
        if (r8.type > 31) goto L10;
        return ComplexColorCompat.from(r8.data);
    L14:
        return ComplexColorCompat.from(r7);
    }

    public static float getNamedFloat(TypedArray r2, XmlPullParser r3, String r4, int r5, float r6) {
        if (hasAttribute((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin"), r4) == true) goto L6;
        return r6;
    L6:
        return r2.getFloat(r5, r6);
    }

    public static int getNamedInt(TypedArray r2, XmlPullParser r3, String r4, int r5, int r6) {
        if (hasAttribute((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin"), r4) == true) goto L6;
        return r6;
    L6:
        return r2.getInt(r5, r6);
    }

    public static int getNamedResourceId(TypedArray r2, XmlPullParser r3, String r4, int r5, int r6) {
        if (hasAttribute((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin"), r4) == true) goto L6;
        return r6;
    L6:
        return r2.getResourceId(r5, r6);
    }

    public static String getNamedString(TypedArray r2, XmlPullParser r3, String r4, int r5) {
        if (hasAttribute((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin"), r4) == true) goto L7;
        return null;
    L7:
        return r2.getString(r5);
    }

    public static int getResourceId(TypedArray r0, int r1, int r2, int r3) {
        return r0.getResourceId(r1, r0.getResourceId(r2, r3));
    }

    public static String getString(TypedArray r0, int r1, int r2) {
        String r3 = r0.getString(r1);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return r0.getString(r2);
    }

    public static CharSequence getText(TypedArray r0, int r1, int r2) {
        CharSequence r3 = r0.getText(r1);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return r0.getText(r2);
    }

    public static CharSequence[] getTextArray(TypedArray r0, int r1, int r2) {
        CharSequence[] r3 = r0.getTextArray(r1);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return r0.getTextArray(r2);
    }

    public static boolean hasAttribute(XmlPullParser r2, String r3) {
        if (((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r2, XmlPullParser.class, "com.obric.memorydata.plugin")).getAttributeValue(NAMESPACE, r3) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static TypedArray obtainAttributes(Resources r2, Resources.Theme r3, AttributeSet r4, int[] r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return r2.obtainAttributes(r6, r5);
    L7:
        return r3.obtainStyledAttributes(r6, r5, 0, 0);
    }

    public static TypedValue peekNamedValue(TypedArray r2, XmlPullParser r3, String r4, int r5) {
        if (hasAttribute((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin"), r4) == true) goto L7;
        return null;
    L7:
        return r2.peekValue(r5);
    }
}
