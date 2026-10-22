package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.core.R;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.utilities.Contrast;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ColorStateListInflaterCompat {
    private static final ThreadLocal<TypedValue> sTempTypedValue = null;

    static {
        sTempTypedValue = new ThreadLocal();
    }

    private ColorStateListInflaterCompat() {
    }

    @NonNull
    public static ColorStateList createFromXml(@NonNull Resources r5, @NonNull XmlPullParser r10, @Nullable Resources.Theme r11) throws XmlPullParserException, IOException {
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

    @NonNull
    public static ColorStateList createFromXmlInner(@NonNull Resources r5, @NonNull XmlPullParser r10, @NonNull AttributeSet r11, @Nullable Resources.Theme r12) throws XmlPullParserException, IOException {
        String r13 = r10.getName();
        if (r13.equals("selector") == false) goto L7;
        return inflate(r5, r10, r11, r12);
    L7:
        throw new XmlPullParserException(r10.getPositionDescription() + ": invalid color state list tag " + r13);
    }

    @NonNull
    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> r5 = sTempTypedValue;
        TypedValue r10 = r5.get();
        if (r10 != null) goto L6;
        TypedValue r11 = new TypedValue();
        r5.set(r11);
        return r11;
    L6:
        return r10;
    }

    @Nullable
    public static ColorStateList inflate(@NonNull Resources r5, @XmlRes int r10, @Nullable Resources.Theme r11) {
        return createFromXml(r5, r5.getXml(r10), r11);
    L4:
        e = move-exception;
        Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
        return null;
    }

    private static boolean isColorInt(@NonNull Resources r5, @ColorRes int r10) {
        TypedValue r11 = getTypedValue();
        r5.getValue(r10, r11, true);
        int r12 = r11.type;
        if (r12 >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r12 > 31) goto L7;
        return true;
    }

    @ColorInt
    private static int modulateColorAlpha(@ColorInt int r5, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r10, @FloatRange(from = 0.0d, to = 100.0d) float r11) {
        if (r11 >= 0.0f) goto L5;
    L7:
        boolean r12 = false;
    L9:
        if (r10 != 1.0f) goto L12;
        if (r12 == true) goto L12;
        return r5;
    L12:
        int r13 = MathUtils.clamp((int) ((Color.alpha(r5) * r10) + 0.5f), 0, 255);
        if (r12 == false) goto L16;
        CamColor r14 = CamColor.fromColor(r5);
        r5 = CamColor.toColor(r14.getHue(), r14.getChroma(), r11);
    L16:
        return (r5 & ViewCompat.MEASURED_SIZE_MASK) | (r13 << 24);
    L5:
        if (r11 > 100.0f) goto L7;
        r12 = true;
        goto L9
    }

    private static TypedArray obtainAttributes(Resources r5, Resources.Theme r10, AttributeSet r11, int[] r12) {
        if (r10 != null) goto L5;
        return r5.obtainAttributes(r11, r12);
    L5:
        return r10.obtainStyledAttributes(r11, r12, 0, 0);
    }

    private static ColorStateList inflate(@NonNull Resources r17, @NonNull XmlPullParser r18, @NonNull AttributeSet r19, @Nullable Resources.Theme r20) throws XmlPullParserException, IOException {
        int r5 = 1;
        int r10 = r18.getDepth() + 1;
        int[][] r11 = new int[20][];
        int[] r12 = new int[20];
        int r13 = 0;
    L3:
        int r14 = r18.next();
        if (r14 == r5) goto L51;
        int r15 = r18.getDepth();
        if (r15 >= r10) goto L10;
        if (r14 == 3) goto L51;
    L10:
        if (r14 != 2) goto L50;
        if (r15 > r10) goto L50;
        if (r18.getName().equals("item") == false) goto L50;
        TypedArray r16 = obtainAttributes(r17, r20, r19, R.styleable.ColorStateListItem);
        int r110 = r16.getResourceId(R.styleable.ColorStateListItem_android_color, -1);
        if (r110 != (-1)) goto L18;
    L22:
        int r111 = r16.getColor(R.styleable.ColorStateListItem_android_color, -65281);
    L23:
        float r112 = 1.0f;
        if (r16.hasValue(R.styleable.ColorStateListItem_android_alpha) == false) goto L27;
        r112 = r16.getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0f);
    L30:
        if (r16.hasValue(R.styleable.ColorStateListItem_android_lStar) == false) goto L32;
        float r113 = r16.getFloat(R.styleable.ColorStateListItem_android_lStar, -1.0f);
    L33:
        r16.recycle();
        int r21 = r19.getAttributeCount();
        int[] r114 = new int[r21];
        int r115 = 0;
        int r116 = 0;
    L34:
        if (r115 >= r21) goto L49;
        int r22 = r19.getAttributeNameResource(r115);
        if (r22 == 16843173) goto L48;
        if (r22 == 16843551) goto L48;
        if (r22 == R.attr.alpha) goto L48;
        if (r22 == R.attr.lStar) goto L48;
        int r23 = r116 + 1;
        if (r19.getAttributeBooleanValue(r115, false) == true) goto L47;
        r22 = -r22;
    L47:
        r114[r116] = r22;
        r116 = r23;
    L48:
        r115 = r115 + 1;
        goto L34
    L49:
        int[] r24 = StateSet.trimStateSet(r114, r116);
        r12 = GrowingArrayUtils.append(r12, r13, modulateColorAlpha(r111, r112, r113));
        r11 = (int[][]) GrowingArrayUtils.append(r11, r13, r24);
        r13 = r13 + 1;
        goto L50
    L32:
        r113 = r16.getFloat(R.styleable.ColorStateListItem_lStar, -1.0f);
        goto L33
    L27:
        if (r16.hasValue(R.styleable.ColorStateListItem_alpha) == false) goto L30;
        r112 = r16.getFloat(R.styleable.ColorStateListItem_alpha, 1.0f);
        goto L30
    L18:
        if (isColorInt(r17, r110) == true) goto L22;
        r111 = createFromXml(r17, r17.getXml(r110), r20).getDefaultColor();     // Catch: Exception -> L21
    L21:
        r111 = r16.getColor(R.styleable.ColorStateListItem_android_color, -65281);
    L50:
        r5 = 1;
    L51:
        int[] r25 = new int[r13];
        int[][] r26 = new int[r13][];
        System.arraycopy(r12, 0, r25, 0, r13);
        System.arraycopy(r11, 0, r26, 0, r13);
        return new ColorStateList(r26, r25);
    }
}
