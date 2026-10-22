package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class ColorStateListInflaterCompat {
    private static final ThreadLocal<TypedValue> sTempTypedValue = null;

    static {
        sTempTypedValue = new ThreadLocal();
    }

    private ColorStateListInflaterCompat() {
    }

    public static ColorStateList createFromXml(Resources r4, XmlPullParser r5, Resources.Theme r6) {
        XmlPullParser r7 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r5, XmlPullParser.class, "com.obric.memorydata.plugin");
        AttributeSet r0 = Xml.asAttributeSet(r7);
    L3:
        int r1 = r7.next();
        if (r1 == 2) goto L8;
        if (r1 != 1) goto L3;
    L8:
        if (r1 != 2) goto L12;
        return createFromXmlInner(r4, r7, r0, r6);
    L12:
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList createFromXmlInner(Resources r2, XmlPullParser r3, AttributeSet r4, Resources.Theme r5) {
        XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        String r0 = r6.getName();
        if (r0.equals("selector") == false) goto L7;
        return inflate(r2, r6, r7, r5);
    L7:
        throw new XmlPullParserException(r6.getPositionDescription() + ": invalid color state list tag " + r0);
    }

    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> r0 = sTempTypedValue;
        TypedValue r1 = (TypedValue) ZeusTransformUtils.preCheckCast(r0.get(), TypedValue.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        TypedValue r2 = new TypedValue();
        r0.set(r2);
        return r2;
    L6:
        return r1;
    }

    public static ColorStateList inflate(Resources r0, int r1, Resources.Theme r2) {
        return createFromXml(r0, r0.getXml(r1), r2);
    L4:
        e = move-exception;
        Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
        return null;
    }

    private static ColorStateList inflate(Resources r18, XmlPullParser r19, AttributeSet r20, Resources.Theme r21) {
        r18 = r18;
        r21 = r21;
        XmlPullParser r2 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r19, XmlPullParser.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r20, AttributeSet.class, "com.obric.memorydata.plugin");
        int r6 = 1;
        int r5 = r2.getDepth() + 1;
        int[][] r8 = new int[20][];
        int[] r7 = new int[20];
        int r10 = 0;
    L3:
        int r11 = r2.next();
        if (r11 == r6) goto L55;
        int r12 = r2.getDepth();
        if (r12 >= r5) goto L10;
        if (r11 == 3) goto L55;
    L10:
        if (r11 != 2) goto L53;
        if (r12 > r5) goto L53;
        if (r2.getName().equals("item") == false) goto L53;
        TypedArray r13 = obtainAttributes(r18, r21, r4, R.styleable.ColorStateListItem);
        int r14 = r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ColorStateListItem_android_color, "styleable", "ColorStateListItem_android_color"), -1);
        if (r14 != (-1)) goto L18;
    L21:
        int r9 = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.ColorStateListItem_android_color, "styleable", "ColorStateListItem_android_color"), -65281);
    L22:
        float r15 = 1.0f;
        String r16 = "ColorStateListItem_android_alpha";
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.ColorStateListItem_android_alpha, "styleable", "ColorStateListItem_android_alpha")) == false) goto L26;
        int r17 = R.styleable.ColorStateListItem_android_alpha;
    L25:
        r15 = r13.getFloat(ZeusTransformUtils.mapRes(r17, "styleable", r16), 1.0f);
    L30:
        if (Build.VERSION.SDK_INT < 31) goto L34;
        String r110 = "ColorStateListItem_android_lStar";
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.ColorStateListItem_android_lStar, "styleable", "ColorStateListItem_android_lStar")) == false) goto L34;
        int r111 = R.styleable.ColorStateListItem_android_lStar;
    L35:
        float r22 = r13.getFloat(ZeusTransformUtils.mapRes(r111, "styleable", r110), -1.0f);
        r13.recycle();
        int r112 = r4.getAttributeCount();
        int[] r113 = new int[r112];
        int r114 = 0;
        int r115 = 0;
    L36:
        if (r114 >= r112) goto L52;
        int r0 = r4.getAttributeNameResource(r114);
        if (r0 != 16843173) goto L40;
    L50:
        XmlPullParser r116 = r2;
        int r117 = r5;
    L51:
        r114 = r114 + 1;
        r2 = r116;
        r5 = r117;
        goto L36
    L40:
        if (r0 == 16843551) goto L50;
        r116 = r2;
        r117 = r5;
        if (r0 == ZeusTransformUtils.mapRes(R.attr.alpha, "attr", "alpha")) goto L51;
        if (r0 == ZeusTransformUtils.mapRes(R.attr.lStar, "attr", "lStar")) goto L51;
        int r1 = r115 + 1;
        if (r4.getAttributeBooleanValue(r114, false) == true) goto L49;
        r0 = -r0;
    L49:
        r113[r115] = r0;
        r115 = r1;
        goto L51
    L52:
        int[] r3 = StateSet.trimStateSet(r113, r115);
        r7 = GrowingArrayUtils.append(r7, r10, modulateColorAlpha(r9, r15, r22));
        r8 = (int[][]) ZeusTransformUtils.preCheckCast(GrowingArrayUtils.append(r8, r10, r3), int[][].class, "com.obric.memorydata.plugin");
        r10 = r10 + 1;
    L54:
        r6 = 1;
    L34:
        r111 = R.styleable.ColorStateListItem_lStar;
        r110 = "ColorStateListItem_lStar";
        goto L35
    L26:
        r16 = "ColorStateListItem_alpha";
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.ColorStateListItem_alpha, "styleable", "ColorStateListItem_alpha")) == false) goto L30;
        r17 = R.styleable.ColorStateListItem_alpha;
        goto L25
    L18:
        if (isColorInt(r18, r14) == true) goto L21;
        r9 = createFromXml(r18, r18.getXml(r14), r21).getDefaultColor();     // Catch: Exception -> L57
    L53:
        r2 = r2;
        r5 = r5;
    L55:
        int[] r23 = new int[r10];
        int[][] r24 = new int[r10][];
        System.arraycopy(r7, 0, r23, 0, r10);
        System.arraycopy(r8, 0, r24, 0, r10);
        return new ColorStateList(r24, r23);
    }

    private static boolean isColorInt(Resources r2, int r3) {
        TypedValue r0 = getTypedValue();
        r2.getValue(r3, r0, true);
        if (r0.type >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r0.type > 31) goto L7;
        return true;
    }

    private static int modulateColorAlpha(int r3, float r4, float r5) {
        if (r5 >= 0.0f) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r4 != 1.0f) goto L12;
        if (r0 == true) goto L12;
        return r3;
    L12:
        int r6 = MathUtils.clamp((int) ((Color.alpha(r3) * r4) + 0.5f), 0, 255);
        if (r0 == false) goto L16;
        CamColor r7 = CamColor.fromColor(r3);
        r3 = CamColor.toColor(r7.getHue(), r7.getChroma(), r5);
    L16:
        return (r3 & ViewCompat.MEASURED_SIZE_MASK) | (r6 << 24);
    L5:
        if (r5 > 100.0f) goto L7;
        r0 = true;
        goto L9
    }

    private static TypedArray obtainAttributes(Resources r2, Resources.Theme r3, AttributeSet r4, int[] r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return r2.obtainAttributes(r6, r5);
    L6:
        return r3.obtainStyledAttributes(r6, r5, 0, 0);
    }
}
