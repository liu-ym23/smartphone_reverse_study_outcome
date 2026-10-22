package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CheckedTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class CheckedTextViewCompat {
    private static final String TAG = "CheckedTextViewCompat";

    private static class Api14Impl {
        private static Field sCheckMarkDrawableField;
        private static boolean sResolved;

        private Api14Impl() {
        }

        static Drawable getCheckMarkDrawable(CheckedTextView r4) {
            if (sResolved == false) goto L19;
        L10:
            Field r0 = sCheckMarkDrawableField;
            if (r0 != null) goto L17;
        L16:
            return null;
        L17:
            return (Drawable) ZeusTransformUtils.preCheckCast(r0.get(r4), Drawable.class, "com.obric.memorydata.plugin");
        L14:
            e = move-exception;
            Log.i(CheckedTextViewCompat.TAG, "Failed to get check mark drawable via reflection", e);
            sCheckMarkDrawableField = null;
            goto L16
        L19:
            Field r2 = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");     // Catch: NoSuchFieldException -> L7
            sCheckMarkDrawableField = r2;     // Catch: NoSuchFieldException -> L7
            r2.setAccessible(true);     // Catch: NoSuchFieldException -> L7
        L9:
            sResolved = true;
        L7:
            e = move-exception;
            Log.i(CheckedTextViewCompat.TAG, "Failed to retrieve mCheckMarkDrawable field", e);
            goto L9
        }
    }

    private static class Api16Impl {
        private Api16Impl() {
        }

        static Drawable getCheckMarkDrawable(CheckedTextView r0) {
            return r0.getCheckMarkDrawable();
        }
    }

    private static class Api21Impl {
        private Api21Impl() {
        }

        static ColorStateList getCheckMarkTintList(CheckedTextView r0) {
            return r0.getCheckMarkTintList();
        }

        static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView r0) {
            return r0.getCheckMarkTintMode();
        }

        static void setCheckMarkTintList(CheckedTextView r0, ColorStateList r1) {
            r0.setCheckMarkTintList(r1);
        }

        static void setCheckMarkTintMode(CheckedTextView r0, PorterDuff.Mode r1) {
            r0.setCheckMarkTintMode(r1);
        }
    }

    private CheckedTextViewCompat() {
    }

    public static Drawable getCheckMarkDrawable(CheckedTextView r2) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getCheckMarkDrawable(r2);
    L7:
        return Api14Impl.getCheckMarkDrawable(r2);
    }

    public static ColorStateList getCheckMarkTintList(CheckedTextView r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getCheckMarkTintList(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, TintableCheckedTextView.class) == true) goto L9;
        return null;
    L9:
        return ((TintableCheckedTextView) ZeusTransformUtils.preCheckCast(r2, TintableCheckedTextView.class, "com.obric.memorydata.plugin")).getSupportCheckMarkTintList();
    }

    public static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getCheckMarkTintMode(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, TintableCheckedTextView.class) == true) goto L9;
        return null;
    L9:
        return ((TintableCheckedTextView) ZeusTransformUtils.preCheckCast(r2, TintableCheckedTextView.class, "com.obric.memorydata.plugin")).getSupportCheckMarkTintMode();
    }

    public static void setCheckMarkTintList(CheckedTextView r2, ColorStateList r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setCheckMarkTintList(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, TintableCheckedTextView.class) == false) goto L10;
        ((TintableCheckedTextView) ZeusTransformUtils.preCheckCast(r2, TintableCheckedTextView.class, "com.obric.memorydata.plugin")).setSupportCheckMarkTintList(r3);
        return;
    }

    public static void setCheckMarkTintMode(CheckedTextView r2, PorterDuff.Mode r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setCheckMarkTintMode(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, TintableCheckedTextView.class) == false) goto L10;
        ((TintableCheckedTextView) ZeusTransformUtils.preCheckCast(r2, TintableCheckedTextView.class, "com.obric.memorydata.plugin")).setSupportCheckMarkTintMode(r3);
        return;
    }
}
