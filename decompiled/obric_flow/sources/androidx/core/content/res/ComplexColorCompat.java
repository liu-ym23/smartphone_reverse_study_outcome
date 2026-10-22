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
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ComplexColorCompat {
    private static final String LOG_TAG = "ComplexColorCompat";
    private int mColor;
    private final ColorStateList mColorStateList;
    private final Shader mShader;

    private ComplexColorCompat(Shader r5, ColorStateList r10, @ColorInt int r11) {
        this.mShader = r5;
        this.mColorStateList = r10;
        this.mColor = r11;
    }

    @NonNull
    private static ComplexColorCompat createFromXml(@NonNull Resources r5, @ColorRes int r10, @Nullable Resources.Theme r11) throws IOException, XmlPullParserException {
        XmlResourceParser r12 = r5.getXml(r10);
        AttributeSet r13 = Xml.asAttributeSet(r12);
    L3:
        int r14 = r12.next();
        if (r14 == 2) goto L8;
        if (r14 != 1) goto L3;
    L8:
        if (r14 != 2) goto L20;
        String r15 = r12.getName();
        r15.getClass();
        if (r15.equals("gradient") == true) goto L18;
        if (r15.equals("selector") == false) goto L16;
        return from(ColorStateListInflaterCompat.createFromXmlInner(r5, r12, r13, r11));
    L16:
        throw new XmlPullParserException(r12.getPositionDescription() + ": unsupported complex color tag " + r15);
    L18:
        return from(GradientColorInflaterCompat.createFromXmlInner(r5, r12, r13, r11));
    L20:
        throw new XmlPullParserException("No start tag found");
    }

    public static ComplexColorCompat from(@NonNull Shader r5) {
        return new ComplexColorCompat(r5, null, 0);
    }

    @Nullable
    public static ComplexColorCompat inflate(@NonNull Resources r5, @ColorRes int r10, @Nullable Resources.Theme r11) {
        return createFromXml(r5, r10, r11);
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
        ColorStateList r5 = this.mColorStateList;
        if (r5 == null) goto L9;
        if (r5.isStateful() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean onStateChanged(int[] r5) {
        if (isStateful() == false) goto L7;
        ColorStateList r10 = this.mColorStateList;
        int r11 = r10.getColorForState(r5, r10.getDefaultColor());
        if (r11 == this.mColor) goto L7;
        this.mColor = r11;
        return true;
    L7:
        return false;
    }

    public void setColor(@ColorInt int r5) {
        this.mColor = r5;
    }

    public boolean willDraw() {
        if (isGradient() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mColor != 0) goto L8;
        return false;
    }

    public static ComplexColorCompat from(@NonNull ColorStateList r5) {
        return new ComplexColorCompat(null, r5, r5.getDefaultColor());
    }

    public static ComplexColorCompat from(@ColorInt int r5) {
        return new ComplexColorCompat(null, null, r5);
    }
}
