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
    public static ColorStateList createFromXml(@NonNull Resources r10, @NonNull XmlPullParser r11, @Nullable Resources.Theme r12) {
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

    @NonNull
    public static ColorStateList createFromXmlInner(@NonNull Resources r10, @NonNull XmlPullParser r11, @NonNull AttributeSet r12, @Nullable Resources.Theme r13) {
        String r14 = r11.getName();
        if (r14.equals("selector") == false) goto L7;
        return inflate(r10, r11, r12, r13);
    L7:
        throw new XmlPullParserException(r11.getPositionDescription() + ": invalid color state list tag " + r14);
    }

    @NonNull
    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> r10 = sTempTypedValue;
        TypedValue r11 = r10.get();
        if (r11 != null) goto L6;
        TypedValue r12 = new TypedValue();
        r10.set(r12);
        return r12;
    L6:
        return r11;
    }

    @Nullable
    public static ColorStateList inflate(@NonNull Resources r10, @XmlRes int r11, @Nullable Resources.Theme r12) {
        return createFromXml(r10, r10.getXml(r11), r12);
    L4:
        e = move-exception;
        Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
        return null;
    }

    private static ColorStateList inflate(@NonNull Resources r17, @NonNull XmlPullParser r18, @NonNull AttributeSet r19, @Nullable Resources.Theme r20) {
        int r10 = 1;
        int r11 = r18.getDepth() + 1;
        int[][] r12 = new int[20][];
        int[] r13 = new int[20];
        int r14 = 0;
    L3:
        int r15 = r18.next();
        if (r15 == r10) goto L53;
        int r16 = r18.getDepth();
        if (r16 >= r11) goto L10;
        if (r15 == 3) goto L53;
    L10:
        if (r15 != 2) goto L52;
        if (r16 > r11) goto L52;
        if (r18.getName().equals("item") == false) goto L52;
        TypedArray r21 = obtainAttributes(r17, r20, r19, R.styleable.ColorStateListItem);
        int r110 = R.styleable.ColorStateListItem_android_color;
        int r111 = r21.getResourceId(r110, -1);
        if (r111 != (-1)) goto L18;
    L22:
        int r112 = r21.getColor(r110, -65281);
    L23:
        float r113 = 1.0f;
        int r114 = R.styleable.ColorStateListItem_android_alpha;
        if (r21.hasValue(r114) == false) goto L26;
    L25:
        r113 = r21.getFloat(r114, 1.0f);
    L30:
        if (Build.VERSION.SDK_INT < 31) goto L34;
        int r115 = R.styleable.ColorStateListItem_android_lStar;
        if (r21.hasValue(r115) == false) goto L34;
    L35:
        float r116 = r21.getFloat(r115, -1.0f);
        r21.recycle();
        int r22 = r19.getAttributeCount();
        int[] r117 = new int[r22];
        int r118 = 0;
        int r119 = 0;
    L36:
        if (r118 >= r22) goto L51;
        int r23 = r19.getAttributeNameResource(r118);
        if (r23 == 16843173) goto L50;
        if (r23 == 16843551) goto L50;
        if (r23 == R.attr.alpha) goto L50;
        if (r23 == R.attr.lStar) goto L50;
        int r24 = r119 + 1;
        if (r19.getAttributeBooleanValue(r118, false) == true) goto L49;
        r23 = -r23;
    L49:
        r117[r119] = r23;
        r119 = r24;
    L50:
        r118 = r118 + 1;
        goto L36
    L51:
        int[] r25 = StateSet.trimStateSet(r117, r119);
        r13 = GrowingArrayUtils.append(r13, r14, modulateColorAlpha(r112, r113, r116));
        r12 = (int[][]) GrowingArrayUtils.append(r12, r14, r25);
        r14 = r14 + 1;
    L34:
        r115 = R.styleable.ColorStateListItem_lStar;
        goto L35
    L26:
        r114 = R.styleable.ColorStateListItem_alpha;
        if (r21.hasValue(r114) == false) goto L30;
    L18:
        if (isColorInt(r17, r111) == true) goto L22;
        r112 = createFromXml(r17, r17.getXml(r111), r20).getDefaultColor();     // Catch: Exception -> L21
    L21:
        r110 = R.styleable.ColorStateListItem_android_color;
    L52:
        r10 = 1;
    L53:
        int[] r26 = new int[r14];
        int[][] r27 = new int[r14][];
        System.arraycopy(r13, 0, r26, 0, r14);
        System.arraycopy(r12, 0, r27, 0, r14);
        return new ColorStateList(r27, r26);
    }

    private static boolean isColorInt(@NonNull Resources r10, @ColorRes int r11) {
        TypedValue r12 = getTypedValue();
        r10.getValue(r11, r12, true);
        int r13 = r12.type;
        if (r13 >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r13 > 31) goto L7;
        return true;
    }

    @ColorInt
    private static int modulateColorAlpha(@ColorInt int r10, @FloatRange(from = 0.0d, to = 1.0d) float r11, @FloatRange(from = 0.0d, to = 100.0d) float r12) {
        if (r12 >= 0.0f) goto L5;
    L7:
        boolean r13 = false;
    L9:
        if (r11 != 1.0f) goto L12;
        if (r13 == true) goto L12;
        return r10;
    L12:
        int r14 = MathUtils.clamp((int) ((Color.alpha(r10) * r11) + 0.5f), 0, 255);
        if (r13 == false) goto L16;
        CamColor r15 = CamColor.fromColor(r10);
        r10 = CamColor.toColor(r15.getHue(), r15.getChroma(), r12);
    L16:
        return (r10 & ViewCompat.MEASURED_SIZE_MASK) | (r14 << 24);
    L5:
        if (r12 > 100.0f) goto L7;
        r13 = true;
        goto L9
    }

    private static TypedArray obtainAttributes(Resources r10, Resources.Theme r11, AttributeSet r12, int[] r13) {
        if (r11 != null) goto L5;
        return r10.obtainAttributes(r12, r13);
    L5:
        return r11.obtainStyledAttributes(r12, r13, 0, 0);
    }
}
