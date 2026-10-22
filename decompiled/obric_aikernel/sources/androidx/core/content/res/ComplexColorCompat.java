package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ComplexColorCompat {
    private static final String LOG_TAG = "ComplexColorCompat";
    private int mColor;
    private final ColorStateList mColorStateList;
    private final Shader mShader;

    private ComplexColorCompat(Shader r10, ColorStateList r11, @ColorInt int r12) {
        this.mShader = r10;
        this.mColorStateList = r11;
        this.mColor = r12;
    }

    @NonNull
    private static ComplexColorCompat createFromXml(@NonNull Resources r10, @ColorRes int r11, @Nullable Resources.Theme r12) {
        XmlResourceParser r13 = r10.getXml(r11);
        AttributeSet r14 = Xml.asAttributeSet(r13);
    L3:
        int r15 = r13.next();
        if (r15 == 2) goto L8;
        if (r15 != 1) goto L3;
    L8:
        if (r15 != 2) goto L20;
        String r16 = r13.getName();
        r16.hashCode();
        if (r16.equals("gradient") == true) goto L18;
        if (r16.equals("selector") == false) goto L16;
        return from(ColorStateListInflaterCompat.createFromXmlInner(r10, r13, r14, r12));
    L16:
        throw new XmlPullParserException(r13.getPositionDescription() + ": unsupported complex color tag " + r16);
    L18:
        return from(GradientColorInflaterCompat.createFromXmlInner(r10, r13, r14, r12));
    L20:
        throw new XmlPullParserException("No start tag found");
    }

    static ComplexColorCompat from(@ColorInt int r10) {
        return new ComplexColorCompat(null, null, r10);
    }

    static ComplexColorCompat from(@NonNull ColorStateList r10) {
        return new ComplexColorCompat(null, r10, r10.getDefaultColor());
    }

    static ComplexColorCompat from(@NonNull Shader r10) {
        return new ComplexColorCompat(r10, null, 0);
    }

    @Nullable
    public static ComplexColorCompat inflate(@NonNull Resources r10, @ColorRes int r11, @Nullable Resources.Theme r12) {
        return createFromXml(r10, r11, r12);
    L4:
        e = move-exception;
        Log.e(LOG_TAG, "Failed to inflate ComplexColor.", e);
        return null;
    }

    @ColorInt
    public int getColor() {
        return this.mColor;
    }

    @Nullable
    public Shader getShader() {
        return this.mShader;
    }

    public boolean isGradient() {
        if (this.mShader == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isStateful() {
        if (this.mShader != null) goto L9;
        ColorStateList r10 = this.mColorStateList;
        if (r10 == null) goto L9;
        if (r10.isStateful() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean onStateChanged(int[] r10) {
        if (isStateful() == false) goto L7;
        ColorStateList r11 = this.mColorStateList;
        int r12 = r11.getColorForState(r10, r11.getDefaultColor());
        if (r12 == this.mColor) goto L7;
        this.mColor = r12;
        return true;
    L7:
        return false;
    }

    public void setColor(@ColorInt int r10) {
        this.mColor = r10;
    }

    public boolean willDraw() {
        if (isGradient() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mColor != 0) goto L8;
        return false;
    }
}
