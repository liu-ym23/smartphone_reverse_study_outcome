package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
final class GradientColorInflaterCompat {
    private static final int TILE_MODE_CLAMP = 0;
    private static final int TILE_MODE_MIRROR = 2;
    private static final int TILE_MODE_REPEAT = 1;

    static final class ColorStops {
        final int[] mColors;
        final float[] mOffsets;

        ColorStops(int r4, int r5) {
            this.mColors = new int[]{r4, r5};
            this.mOffsets = new float[]{0.0f, 1.0f};
        }

        ColorStops(int r4, int r5, int r6) {
            this.mColors = new int[]{r4, r5, r6};
            this.mOffsets = new float[]{0.0f, 0.5f, 1.0f};
        }

        ColorStops(List<Integer> r7, List<Float> r8) {
            List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            int r0 = r9.size();
            this.mColors = new int[r0];
            this.mOffsets = new float[r0];
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            this.mColors[r2] = ((Integer) ZeusTransformUtils.preCheckCast(r9.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue();
            this.mOffsets[r2] = ((Float) ZeusTransformUtils.preCheckCast(r10.get(r2), Float.class, "com.obric.memorydata.plugin")).floatValue();
            r2 = r2 + 1;
            goto L3
        }
    }

    private GradientColorInflaterCompat() {
    }

    private static ColorStops checkColors(ColorStops r0, int r1, int r2, boolean r3, int r4) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (r3 == false) goto L9;
        return new ColorStops(r1, r4, r2);
    L9:
        return new ColorStops(r1, r2);
    }

    static Shader createFromXml(Resources r4, XmlPullParser r5, Resources.Theme r6) {
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

    static Shader createFromXmlInner(Resources r21, XmlPullParser r22, AttributeSet r23, Resources.Theme r24) {
        XmlPullParser r2 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r22, XmlPullParser.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r23, AttributeSet.class, "com.obric.memorydata.plugin");
        String r4 = r2.getName();
        if (r4.equals("gradient") == false) goto L19;
        TypedArray r5 = TypedArrayUtils.obtainAttributes(r21, r24, r3, R.styleable.GradientColor);
        float r10 = TypedArrayUtils.getNamedFloat(r5, r2, "startX", ZeusTransformUtils.mapRes(R.styleable.GradientColor_android_startX, "styleable", "GradientColor_android_startX"), 0.0f);
        float r11 = TypedArrayUtils.getNamedFloat(r5, r2, "startY", ZeusTransformUtils.mapRes(R.styleable.GradientColor_android_startY, "styleable", "GradientColor_android_startY"), 0.0f);
        float r12 = TypedArrayUtils.getNamedFloat(r5, r2, "endX", ZeusTransformUtils.mapRes(R.styleable.GradientColor_android_endX, "styleable", "GradientColor_android_endX"), 0.0f);
        float r13 = TypedArrayUtils.getNamedFloat(r5, r2, "endY", ZeusTransformUtils.mapRes(R.styleable.GradientColor_android_endY, "styleable", "GradientColor_android_endY"), 0.0f);
        float r15 = TypedArrayUtils.getNamedFloat(r5, r2, "centerX", ZeusTransformUtils.mapRes(R.styleable.GradientColor_android_centerX, "styleable", "GradientColor_android_centerX"), 0.0f);
        float r6 = TypedArrayUtils.getNamedFloat(r5, r2, "centerY", ZeusTransformUtils.mapRes(R.styleable.GradientColor_android_centerY, "styleable", "GradientColor_android_centerY"), 0.0f);
        int r7 = TypedArrayUtils.getNamedInt(r5, r2, "type", ZeusTransformUtils.mapRes(R.styleable.GradientColor_android_type, "styleable", "GradientColor_android_type"), 0);
        int r8 = TypedArrayUtils.getNamedColor(r5, r2, "startColor", ZeusTransformUtils.mapRes(R.styleable.GradientColor_android_startColor, "styleable", "GradientColor_android_startColor"), 0);
        boolean r14 = TypedArrayUtils.hasAttribute(r2, "centerColor");
        int r9 = TypedArrayUtils.getNamedColor(r5, r2, "centerColor", ZeusTransformUtils.mapRes(R.styleable.GradientColor_android_centerColor, "styleable", "GradientColor_android_centerColor"), 0);
        int r16 = TypedArrayUtils.getNamedColor(r5, r2, "endColor", ZeusTransformUtils.mapRes(R.styleable.GradientColor_android_endColor, "styleable", "GradientColor_android_endColor"), 0);
        int r17 = TypedArrayUtils.getNamedInt(r5, r2, "tileMode", ZeusTransformUtils.mapRes(R.styleable.GradientColor_android_tileMode, "styleable", "GradientColor_android_tileMode"), 0);
        float r18 = TypedArrayUtils.getNamedFloat(r5, r2, "gradientRadius", ZeusTransformUtils.mapRes(R.styleable.GradientColor_android_gradientRadius, "styleable", "GradientColor_android_gradientRadius"), 0.0f);
        r5.recycle();
        ColorStops r0 = checkColors(inflateChildElements(r21, r2, r3, r24), r8, r16, r14, r9);
        if (r7 == 1) goto L13;
        if (r7 == 2) goto L11;
        return new LinearGradient(r10, r11, r12, r13, r0.mColors, r0.mOffsets, parseTileMode(r17));
    L11:
        return new SweepGradient(r15, r6, r0.mColors, r0.mOffsets);
    L13:
        if (r18 <= 0.0f) goto L17;
        return new RadialGradient(r15, r6, r18, r0.mColors, r0.mOffsets, parseTileMode(r17));
    L17:
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    L19:
        throw new XmlPullParserException(r2.getPositionDescription() + ": invalid gradient color tag " + r4);
    }

    private static ColorStops inflateChildElements(Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) {
        XmlPullParser r14 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.memorydata.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        int r0 = r14.getDepth() + 1;
        ArrayList r2 = new ArrayList(20);
        ArrayList r4 = new ArrayList(20);
    L3:
        int r3 = r14.next();
        if (r3 == 1) goto L23;
        int r5 = r14.getDepth();
        if (r5 >= r0) goto L10;
        if (r3 == 3) goto L23;
    L10:
        if (r3 != 2) goto L3;
        if (r5 > r0) goto L3;
        if (r14.getName().equals("item") == false) goto L3;
        TypedArray r6 = TypedArrayUtils.obtainAttributes(r10, r13, r15, R.styleable.GradientColorItem);
        boolean r7 = r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.GradientColorItem_android_color, "styleable", "GradientColorItem_android_color"));
        boolean r8 = r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.GradientColorItem_android_offset, "styleable", "GradientColorItem_android_offset"));
        if (r7 == false) goto L21;
        if (r8 == false) goto L21;
        int r9 = r6.getColor(ZeusTransformUtils.mapRes(R.styleable.GradientColorItem_android_color, "styleable", "GradientColorItem_android_color"), 0);
        float r16 = r6.getFloat(ZeusTransformUtils.mapRes(R.styleable.GradientColorItem_android_offset, "styleable", "GradientColorItem_android_offset"), 0.0f);
        r6.recycle();
        r4.add(Integer.valueOf(r9));
        r2.add(Float.valueOf(r16));
    L21:
        throw new XmlPullParserException(r14.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
    L23:
        if (r4.size() > 0) goto L25;
        return null;
    L25:
        return new ColorStops(r4, r2);
    }

    private static Shader.TileMode parseTileMode(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return Shader.TileMode.CLAMP;
    L9:
        return Shader.TileMode.MIRROR;
    L11:
        return Shader.TileMode.REPEAT;
    }
}
