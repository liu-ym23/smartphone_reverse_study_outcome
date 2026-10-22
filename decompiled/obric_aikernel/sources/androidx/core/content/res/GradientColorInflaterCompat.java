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
import com.bytedance.common.wschannel.WsConstants;
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

    static final class ColorStops {
        final int[] mColors;
        final float[] mOffsets;

        ColorStops(@ColorInt int r10, @ColorInt int r11) {
            this.mColors = new int[]{r10, r11};
            this.mOffsets = new float[]{0.0f, 1.0f};
        }

        ColorStops(@ColorInt int r10, @ColorInt int r11, @ColorInt int r12) {
            this.mColors = new int[]{r10, r11, r12};
            this.mOffsets = new float[]{0.0f, 0.5f, 1.0f};
        }

        ColorStops(@NonNull List<Integer> r10, @NonNull List<Float> r11) {
            int r12 = r10.size();
            this.mColors = new int[r12];
            this.mOffsets = new float[r12];
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            this.mColors[r13] = r10.get(r13).intValue();
            this.mOffsets[r13] = r11.get(r13).floatValue();
            r13 = r13 + 1;
            goto L3
        }
    }

    private GradientColorInflaterCompat() {
    }

    private static ColorStops checkColors(@Nullable ColorStops r10, @ColorInt int r11, @ColorInt int r12, boolean r13, @ColorInt int r14) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        if (r13 == false) goto L9;
        return new ColorStops(r11, r14, r12);
    L9:
        return new ColorStops(r11, r12);
    }

    static Shader createFromXml(@NonNull Resources r10, @NonNull XmlPullParser r11, @Nullable Resources.Theme r12) {
        AttributeSet r13 = Xml.asAttributeSet(r11);
    L3:
        int r14 = r11.next();
        if (r14 == 2) goto L8;
        if (r14 != 1) goto L3;
    L8:
        if (r14 != 2) goto L12;
        return createFromXmlInner(r10, r11, r13, r12);
    L12:
        throw new XmlPullParserException("No start tag found");
    }

    static Shader createFromXmlInner(@NonNull Resources r20, @NonNull XmlPullParser r21, @NonNull AttributeSet r22, @Nullable Resources.Theme r23) {
        String r10 = r21.getName();
        if (r10.equals("gradient") == false) goto L19;
        TypedArray r11 = TypedArrayUtils.obtainAttributes(r20, r23, r22, R.styleable.GradientColor);
        float r12 = TypedArrayUtils.getNamedFloat(r11, r21, "startX", R.styleable.GradientColor_android_startX, 0.0f);
        float r13 = TypedArrayUtils.getNamedFloat(r11, r21, "startY", R.styleable.GradientColor_android_startY, 0.0f);
        float r14 = TypedArrayUtils.getNamedFloat(r11, r21, "endX", R.styleable.GradientColor_android_endX, 0.0f);
        float r15 = TypedArrayUtils.getNamedFloat(r11, r21, "endY", R.styleable.GradientColor_android_endY, 0.0f);
        float r16 = TypedArrayUtils.getNamedFloat(r11, r21, "centerX", R.styleable.GradientColor_android_centerX, 0.0f);
        float r17 = TypedArrayUtils.getNamedFloat(r11, r21, "centerY", R.styleable.GradientColor_android_centerY, 0.0f);
        int r18 = TypedArrayUtils.getNamedInt(r11, r21, WsConstants.KEY_CONNECTION_TYPE, R.styleable.GradientColor_android_type, 0);
        int r19 = TypedArrayUtils.getNamedColor(r11, r21, "startColor", R.styleable.GradientColor_android_startColor, 0);
        boolean r24 = TypedArrayUtils.hasAttribute(r21, "centerColor");
        int r25 = TypedArrayUtils.getNamedColor(r11, r21, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
        int r26 = TypedArrayUtils.getNamedColor(r11, r21, "endColor", R.styleable.GradientColor_android_endColor, 0);
        int r27 = TypedArrayUtils.getNamedInt(r11, r21, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
        float r28 = TypedArrayUtils.getNamedFloat(r11, r21, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0.0f);
        r11.recycle();
        ColorStops r29 = checkColors(inflateChildElements(r20, r21, r22, r23), r19, r26, r24, r25);
        if (r18 == 1) goto L13;
        if (r18 == 2) goto L11;
        return new LinearGradient(r12, r13, r14, r15, r29.mColors, r29.mOffsets, parseTileMode(r27));
    L11:
        return new SweepGradient(r16, r17, r29.mColors, r29.mOffsets);
    L13:
        if (r28 <= 0.0f) goto L17;
        return new RadialGradient(r16, r17, r28, r29.mColors, r29.mOffsets, parseTileMode(r27));
    L17:
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    L19:
        throw new XmlPullParserException(r21.getPositionDescription() + ": invalid gradient color tag " + r10);
    }

    private static ColorStops inflateChildElements(@NonNull Resources r10, @NonNull XmlPullParser r11, @NonNull AttributeSet r12, @Nullable Resources.Theme r13) {
        int r14 = r11.getDepth() + 1;
        ArrayList r15 = new ArrayList(20);
        ArrayList r16 = new ArrayList(20);
    L3:
        int r17 = r11.next();
        if (r17 == 1) goto L23;
        int r18 = r11.getDepth();
        if (r18 >= r14) goto L10;
        if (r17 == 3) goto L23;
    L10:
        if (r17 != 2) goto L3;
        if (r18 > r14) goto L3;
        if (r11.getName().equals("item") == false) goto L3;
        TypedArray r19 = TypedArrayUtils.obtainAttributes(r10, r13, r12, R.styleable.GradientColorItem);
        int r20 = R.styleable.GradientColorItem_android_color;
        boolean r21 = r19.hasValue(r20);
        int r22 = R.styleable.GradientColorItem_android_offset;
        boolean r23 = r19.hasValue(r22);
        if (r21 == false) goto L21;
        if (r23 == false) goto L21;
        int r24 = r19.getColor(r20, 0);
        float r25 = r19.getFloat(r22, 0.0f);
        r19.recycle();
        r16.add(Integer.valueOf(r24));
        r15.add(Float.valueOf(r25));
    L21:
        throw new XmlPullParserException(r11.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
    L23:
        if (r16.size() > 0) goto L25;
        return null;
    L25:
        return new ColorStops(r16, r15);
    }

    private static Shader.TileMode parseTileMode(int r10) {
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L9;
        return Shader.TileMode.CLAMP;
    L9:
        return Shader.TileMode.MIRROR;
    L11:
        return Shader.TileMode.REPEAT;
    }
}
