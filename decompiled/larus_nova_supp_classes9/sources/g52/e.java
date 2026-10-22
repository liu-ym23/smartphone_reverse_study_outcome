package g52;

import android.graphics.Typeface;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final /* synthetic */ int j = 0;
    public final float a;
    public final int b;
    public final Typeface c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final float h;
    public float i;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L24;
        e r4 = (e) r3;
        if (Float.compare(this.a, r4.a) == 0) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (Float.compare(this.h, r4.h) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.i, r4.i) == 0) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        int r0 = ((Float.floatToIntBits(this.a) * 31) + this.b) * 31;
        Typeface r1 = this.c;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return ((((((((((((r0 + r2) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + Float.floatToIntBits(this.h)) * 31) + Float.floatToIntBits(this.i);
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "TextConfig(textSizeInPx=" + this.a + ", minHeight=" + this.b + ", typeface=" + this.c + ", paddingLeft=" + this.d + ", paddingTop=" + this.e + ", paddingRight=" + this.f + ", paddingBottom=" + this.g + ", lineSpacing=" + this.h + ", fontSizeScale=" + this.i + ")";
    }

    public final void c(TextView r6) {
        Intrinsics.checkNotNullParameter(r6, "textView");
        int r0 = this.d;
        if (r0 != (-1)) goto L5;
        r0 = r6.getPaddingLeft();
    L5:
        int r2 = this.e;
        if (r2 != (-1)) goto L8;
        r2 = r6.getPaddingTop();
    L8:
        int r3 = this.f;
        if (r3 != (-1)) goto L11;
        r3 = r6.getPaddingRight();
    L11:
        int r4 = this.g;
        if (r4 != (-1)) goto L14;
        r4 = r6.getPaddingBottom();
    L14:
        r6.setPadding(r0, r2, r3, r4);
    }

    public static void b(e r2, ImageView r3) {
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "imageView");
        float r0 = r2.i;
        if (r0 <= 0) goto L6;
        r3.setScaleX(r0);
        r3.setScaleY(r2.i);
        return;
    }

    public final void a(TextView r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "textView");
        if (r6 == false) goto L5;
        float r7 = f.a(this.a, this.i);
    L6:
        r5.setTextSize(0, r7);
        r5.setMinHeight(this.b);
        float r8 = this.h;
        if (r8 == (-1.0f)) goto L9;
        r5.setLineSpacing(r8, r5.getLineSpacingMultiplier());
    L9:
        Typeface r9 = this.c;
        if (r9 == null) goto L12;
        r5.setTypeface(r9);
    L12:
        int r10 = this.d;
        if (r10 != (-1)) goto L15;
        r10 = r5.getPaddingLeft();
    L15:
        int r1 = this.e;
        if (r1 != (-1)) goto L18;
        r1 = r5.getPaddingTop();
    L18:
        int r2 = this.f;
        if (r2 != (-1)) goto L21;
        r2 = r5.getPaddingRight();
    L21:
        int r3 = this.g;
        if (r3 != (-1)) goto L24;
        r3 = r5.getPaddingBottom();
    L24:
        r5.setPadding(r10, r1, r2, r3);
        return;
    L5:
        r7 = this.a;
        goto L6
    }

    public /* synthetic */ e(float r11, int r13, Typeface r14, int r15, int r16, int r17, int r18) {
        this(r11, r13, r14, r15, r16, r17, r18, -1.0f, 0.0f);
    }

    public e(float r1, int r2, Typeface r3, int r4, int r5, int r6, int r7, float r8, float r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
