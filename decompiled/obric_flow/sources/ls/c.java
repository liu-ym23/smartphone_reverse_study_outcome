package ls;

import android.graphics.LinearGradient;
import android.text.TextUtils;
import com.bytedance.ai.event.MessageIndication;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f19786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f19787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final char[] f19788c;
    public final float[] d;
    public final float e;
    public final TextUtils.TruncateAt f;
    public final float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f19789h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f19790i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearGradient f19791j;

    public c(CharSequence r5, CharSequence r10, char[] r11, float[] r12, float r13, TextUtils.TruncateAt r14, float r15, float r16, float r17) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r10, "displayText");
        Intrinsics.checkNotNullParameter(r11, "chars");
        Intrinsics.checkNotNullParameter(r12, "widths");
        this.f19786a = r5;
        this.f19787b = r10;
        this.f19788c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f19789h = r16;
        this.f19790i = r17;
        this.f19791j = null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        CharSequence r11 = r10.f19786a;
        if (Intrinsics.areEqual(this.f19786a, r11) == false) goto L30;
        if (Intrinsics.areEqual(this.f19787b, r10.f19787b) == false) goto L30;
        if (Arrays.equals(this.f19788c, r10.f19788c) == false) goto L30;
        if (Arrays.equals(this.d, r10.d) == false) goto L30;
        if (this.e != r10.e) goto L30;
        if (this.f != r10.f) goto L30;
        if (this.g != r10.g) goto L30;
        if (this.f19789h != r10.f19789h) goto L30;
        if (this.f19790i != r10.f19790i) goto L30;
        if (Intrinsics.areEqual(this.f19791j, r10.f19791j) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.b(this.e, (Arrays.hashCode(this.d) + ((Arrays.hashCode(this.f19788c) + ((this.f19787b.hashCode() + (this.f19786a.hashCode() * 31)) * 31)) * 31)) * 31, 31);
        int r10 = 0;
        TextUtils.TruncateAt r11 = this.f;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = androidx.constraintlayout.motion.widget.a.b(this.f19790i, androidx.constraintlayout.motion.widget.a.b(this.f19789h, androidx.constraintlayout.motion.widget.a.b(this.g, (r5 + r12) * 31, 31), 31), 31);
        LinearGradient r14 = this.f19791j;
        if (r14 == null) goto L11;
        r10 = r14.hashCode();
    L11:
        return r13 + r10;
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "TextLayoutCache(text=" + this.f19786a + ", displayText=" + this.f19787b + ", chars=" + Arrays.toString(this.f19788c) + ", widths=" + Arrays.toString(this.d) + ", contentWidth=" + this.e + ", ellipsize=" + this.f + ", textSizePx=" + this.g + ", baseTotalWidth=" + this.f19789h + ", baseStartX=" + this.f19790i + ", gradientShader=" + this.f19791j + ')';
    }
}
