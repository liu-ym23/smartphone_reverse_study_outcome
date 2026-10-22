package b6;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ContextThemeWrapper;
import q5.b;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f534a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f535b = null;

    static {
        f534a = new int[]{R.attr.theme, b.theme};
        f535b = new int[]{b.materialThemeOverlay};
    }

    @StyleRes
    private static int a(@NonNull Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, f534a);
        int r13 = r12.getResourceId(0, 0);
        int r14 = r12.getResourceId(1, 0);
        r12.recycle();
        if (r13 == 0) goto L6;
        return r13;
    L6:
        return r14;
    }

    @StyleRes
    private static int b(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        TypedArray r14 = r10.obtainStyledAttributes(r11, f535b, r12, r13);
        int r15 = r14.getResourceId(0, 0);
        r14.recycle();
        return r15;
    }

    @NonNull
    public static Context c(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        int r14 = b(r10, r11, r12, r13);
        if ((r10 instanceof ContextThemeWrapper) == true) goto L5;
    L7:
        boolean r15 = false;
    L8:
        if (r14 == 0) goto L15;
        if (r15 == true) goto L15;
        ContextThemeWrapper r16 = new ContextThemeWrapper(r10, r14);
        int r17 = a(r10, r11);
        if (r17 == 0) goto L14;
        r16.getTheme().applyStyle(r17, true);
    L14:
        return r16;
    L15:
        return r10;
    L5:
        if (((ContextThemeWrapper) r10).getThemeResId() != r14) goto L7;
        r15 = true;
        goto L8
    }
}
