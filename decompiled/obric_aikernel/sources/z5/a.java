package z5;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.PathParser;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.material.resources.b;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {
    private static float a(String[] r10, int r11) {
        float r12 = Float.parseFloat(r10[r11]);
        if (r12 < 0.0f) goto L8;
        if (r12 > 1.0f) goto L8;
        return r12;
    L8:
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + r12);
    }

    private static String b(String r10, String r11) {
        return r10.substring(r11.length() + 1, r10.length() - 1);
    }

    private static boolean c(String r10, String r11) {
        if (r10.startsWith(r11 + "(") == true) goto L5;
    L7:
        return false;
    L5:
        if (r10.endsWith(")") == false) goto L7;
        return true;
    }

    public static int d(@NonNull Context r10, @AttrRes int r11, int r12) {
        return b.c(r10, r11, r12);
    }

    @NonNull
    public static TimeInterpolator e(@NonNull Context r10, @AttrRes int r11, @NonNull TimeInterpolator r12) {
        TypedValue r13 = new TypedValue();
        if (r10.getTheme().resolveAttribute(r11, r13, true) == true) goto L5;
        return r12;
    L5:
        if (r13.type != 3) goto L21;
        String r14 = String.valueOf(r13.string);
        if (c(r14, "cubic-bezier") == false) goto L15;
        String[] r15 = b(r14, "cubic-bezier").split(",");
        if (r15.length != 4) goto L13;
        return PathInterpolatorCompat.create(a(r15, 0), a(r15, 1), a(r15, 2), a(r15, 3));
    L13:
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + r15.length);
    L15:
        if (c(r14, "path") == false) goto L19;
        return PathInterpolatorCompat.create(PathParser.createPathFromPathData(b(r14, "path")));
    L19:
        throw new IllegalArgumentException("Invalid motion easing type: " + r14);
    L21:
        throw new IllegalArgumentException("Motion easing theme attribute must be a string");
    }
}
