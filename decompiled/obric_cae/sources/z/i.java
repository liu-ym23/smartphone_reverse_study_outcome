package z;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static c a(TypedArray r8, XmlPullParser r10, Resources.Theme r11, String r12, int r13) {
        if (d(r10, r12) == false) goto L18;
        TypedValue r14 = new TypedValue();
        r8.getValue(r13, r14);
        int r15 = r14.type;
        if (r15 < 28) goto L19;
        if (r15 > 31) goto L19;
        return new c(null, null, r14.data);
    L19:
        c r16 = c.a(r8.getResources(), r8.getResourceId(r13, 0), r11);     // Catch: Exception -> L13
    L15:
        if (r16 == null) goto L18;
        return r16;
    L13:
        e = move-exception;
        Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
        r16 = null;
    L18:
        return new c(null, null, 0);
    }

    public static float b(TypedArray r8, XmlPullParser r10, String r11, int r12, float r13) {
        if (d(r10, r11) == true) goto L6;
        return r13;
    L6:
        return r8.getFloat(r12, r13);
    }

    public static int c(TypedArray r8, XmlPullParser r10, String r11, int r12, int r13) {
        if (d(r10, r11) == true) goto L6;
        return r13;
    L6:
        return r8.getInt(r12, r13);
    }

    public static boolean d(XmlPullParser r8, String r10) {
        if (r8.getAttributeValue("http://schemas.android.com/apk/res/android", r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static TypedArray e(Resources r8, Resources.Theme r10, AttributeSet r11, int[] r12) {
        if (r10 != null) goto L6;
        return r8.obtainAttributes(r11, r12);
    L6:
        return r10.obtainStyledAttributes(r11, r12, 0, 0);
    }
}
