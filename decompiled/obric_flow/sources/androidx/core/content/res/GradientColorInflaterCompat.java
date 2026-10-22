package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
final class GradientColorInflaterCompat {
    private static final int TILE_MODE_CLAMP = 0;
    private static final int TILE_MODE_MIRROR = 2;
    private static final int TILE_MODE_REPEAT = 1;

    public static final class ColorStops {
        final int[] mColors;
        final float[] mOffsets;

        public ColorStops(@NonNull List<Integer> r5, @NonNull List<Float> r10) {
            int r11 = r5.size();
            this.mColors = new int[r11];
            this.mOffsets = new float[r11];
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            this.mColors[r12] = r5.get(r12).intValue();
            this.mOffsets[r12] = r10.get(r12).floatValue();
            r12 = r12 + 1;
            goto L3
        }

        public ColorStops(@ColorInt int r5, @ColorInt int r10) {
            this.mColors = new int[]{r5, r10};
            this.mOffsets = new float[]{0.0f, 1.0f};
        }

        public ColorStops(@ColorInt int r5, @ColorInt int r10, @ColorInt int r11) {
            this.mColors = new int[]{r5, r10, r11};
            this.mOffsets = new float[]{0.0f, 0.5f, 1.0f};
        }
    }

    private GradientColorInflaterCompat() {
    }

    private static ColorStops checkColors(@Nullable ColorStops r5, @ColorInt int r10, @ColorInt int r11, boolean r12, @ColorInt int r13) {
        if (r5 == null) goto L4;
        return r5;
    L4:
        if (r12 == false) goto L8;
        return new ColorStops(r10, r13, r11);
    L8:
        return new ColorStops(r10, r11);
    }

    public static Shader createFromXml(@NonNull Resources r5, @NonNull XmlPullParser r10, @Nullable Resources.Theme r11) throws XmlPullParserException, IOException {
        AttributeSet r12 = Xml.asAttributeSet(r10);
    L3:
        int r13 = r10.next();
        if (r13 == 2) goto L8;
        if (r13 != 1) goto L3;
    L8:
        if (r13 != 2) goto L12;
        return createFromXmlInner(r5, r10, r12, r11);
    L12:
        throw new XmlPullParserException("No start tag found");
    }

    public static Shader createFromXmlInner(@NonNull Resources r20, @NonNull XmlPullParser r21, @NonNull AttributeSet r22, @Nullable Resources.Theme r23) throws IOException, XmlPullParserException {
        String r5 = r21.getName();
        if (r5.equals("gradient") == false) goto L19;
        TypedArray r10 = TypedArrayUtils.obtainAttributes(r20, r23, r22, R.styleable.GradientColor);
        float r11 = TypedArrayUtils.getNamedFloat(r10, r21, "startX", R.styleable.GradientColor_android_startX, 0.0f);
        float r12 = TypedArrayUtils.getNamedFloat(r10, r21, "startY", R.styleable.GradientColor_android_startY, 0.0f);
        float r13 = TypedArrayUtils.getNamedFloat(r10, r21, "endX", R.styleable.GradientColor_android_endX, 0.0f);
        float r14 = TypedArrayUtils.getNamedFloat(r10, r21, "endY", R.styleable.GradientColor_android_endY, 0.0f);
        float r15 = TypedArrayUtils.getNamedFloat(r10, r21, "centerX", R.styleable.GradientColor_android_centerX, 0.0f);
        float r16 = TypedArrayUtils.getNamedFloat(r10, r21, "centerY", R.styleable.GradientColor_android_centerY, 0.0f);
        int r17 = TypedArrayUtils.getNamedInt(r10, r21, "type", R.styleable.GradientColor_android_type, 0);
        int r18 = TypedArrayUtils.getNamedColor(r10, r21, "startColor", R.styleable.GradientColor_android_startColor, 0);
        boolean r19 = TypedArrayUtils.hasAttribute(r21, "centerColor");
        int r24 = TypedArrayUtils.getNamedColor(r10, r21, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
        int r25 = TypedArrayUtils.getNamedColor(r10, r21, "endColor", R.styleable.GradientColor_android_endColor, 0);
        int r26 = TypedArrayUtils.getNamedInt(r10, r21, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
        float r27 = TypedArrayUtils.getNamedFloat(r10, r21, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0.0f);
        r10.recycle();
        ColorStops r28 = checkColors(inflateChildElements(r20, r21, r22, r23), r18, r25, r19, r24);
        if (r17 == 1) goto L13;
        if (r17 == 2) goto L11;
        return new LinearGradient(r11, r12, r13, r14, r28.mColors, r28.mOffsets, parseTileMode(r26));
    L11:
        return new SweepGradient(r15, r16, r28.mColors, r28.mOffsets);
    L13:
        if (r27 <= 0.0f) goto L17;
        return new RadialGradient(r15, r16, r27, r28.mColors, r28.mOffsets, parseTileMode(r26));
    L17:
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    L19:
        throw new XmlPullParserException(r21.getPositionDescription() + ": invalid gradient color tag " + r5);
    }

    private static ColorStops inflateChildElements(@NonNull Resources r10, @NonNull XmlPullParser r11, @NonNull AttributeSet r12, @Nullable Resources.Theme r13) throws XmlPullParserException, IOException {
        int r5 = r11.getDepth() + 1;
        ArrayList r14 = new ArrayList(20);
        ArrayList r15 = new ArrayList(20);
    L3:
        int r16 = r11.next();
        if (r16 == 1) goto L23;
        int r17 = r11.getDepth();
        if (r17 >= r5) goto L10;
        if (r16 == 3) goto L23;
    L10:
        if (r16 != 2) goto L3;
        if (r17 > r5) goto L3;
        if (r11.getName().equals("item") == false) goto L3;
        TypedArray r18 = TypedArrayUtils.obtainAttributes(r10, r13, r12, R.styleable.GradientColorItem);
        boolean r19 = r18.hasValue(R.styleable.GradientColorItem_android_color);
        boolean r20 = r18.hasValue(R.styleable.GradientColorItem_android_offset);
        if (r19 == false) goto L21;
        if (r20 == false) goto L21;
        int r21 = r18.getColor(R.styleable.GradientColorItem_android_color, 0);
        float r22 = r18.getFloat(R.styleable.GradientColorItem_android_offset, 0.0f);
        r18.recycle();
        r15.add(Integer.valueOf(r21));
        r14.add(Float.valueOf(r22));
    L21:
        throw new XmlPullParserException(r11.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
    L23:
        if (r15.size() > 0) goto L25;
        return null;
    L25:
        return new ColorStops(r15, r14);
    }

    private static Shader.TileMode parseTileMode(int r5) {
        if (r5 == 1) goto L11;
        if (r5 == 2) goto L9;
        return Shader.TileMode.CLAMP;
    L9:
        return Shader.TileMode.MIRROR;
    L11:
        return Shader.TileMode.REPEAT;
    }
}
