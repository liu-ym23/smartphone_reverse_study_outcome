package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class CompoundButtonCompat {
    private static final String TAG = "CompoundButtonCompat";
    private static Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;

    static class Api21Impl {
        private Api21Impl() {
        }

        static ColorStateList getButtonTintList(CompoundButton r0) {
            return r0.getButtonTintList();
        }

        static PorterDuff.Mode getButtonTintMode(CompoundButton r0) {
            return r0.getButtonTintMode();
        }

        static void setButtonTintList(CompoundButton r0, ColorStateList r1) {
            r0.setButtonTintList(r1);
        }

        static void setButtonTintMode(CompoundButton r0, PorterDuff.Mode r1) {
            r0.setButtonTintMode(r1);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static Drawable getButtonDrawable(CompoundButton r0) {
            return r0.getButtonDrawable();
        }
    }

    private CompoundButtonCompat() {
    }

    public static Drawable getButtonDrawable(CompoundButton r4) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getButtonDrawable(r4);
    L7:
        if (sButtonDrawableFieldFetched == false) goto L23;
    L14:
        Field r0 = sButtonDrawableField;
        if (r0 != null) goto L21;
    L20:
        return null;
    L21:
        return (Drawable) ZeusTransformUtils.preCheckCast(r0.get(r4), Drawable.class, "com.obric.memorydata.plugin");
    L18:
        e = move-exception;
        Log.i(TAG, "Failed to get button drawable via reflection", e);
        sButtonDrawableField = null;
        goto L20
    L23:
        Field r2 = CompoundButton.class.getDeclaredField("mButtonDrawable");     // Catch: NoSuchFieldException -> L11
        sButtonDrawableField = r2;     // Catch: NoSuchFieldException -> L11
        r2.setAccessible(true);     // Catch: NoSuchFieldException -> L11
    L13:
        sButtonDrawableFieldFetched = true;
    L11:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve mButtonDrawable field", e);
        goto L13
    }

    public static ColorStateList getButtonTintList(CompoundButton r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getButtonTintList(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, TintableCompoundButton.class) == true) goto L9;
        return null;
    L9:
        return ((TintableCompoundButton) ZeusTransformUtils.preCheckCast(r2, TintableCompoundButton.class, "com.obric.memorydata.plugin")).getSupportButtonTintList();
    }

    public static PorterDuff.Mode getButtonTintMode(CompoundButton r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getButtonTintMode(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, TintableCompoundButton.class) == true) goto L9;
        return null;
    L9:
        return ((TintableCompoundButton) ZeusTransformUtils.preCheckCast(r2, TintableCompoundButton.class, "com.obric.memorydata.plugin")).getSupportButtonTintMode();
    }

    public static void setButtonTintList(CompoundButton r2, ColorStateList r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setButtonTintList(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, TintableCompoundButton.class) == false) goto L10;
        ((TintableCompoundButton) ZeusTransformUtils.preCheckCast(r2, TintableCompoundButton.class, "com.obric.memorydata.plugin")).setSupportButtonTintList(r3);
        return;
    }

    public static void setButtonTintMode(CompoundButton r2, PorterDuff.Mode r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setButtonTintMode(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, TintableCompoundButton.class) == false) goto L10;
        ((TintableCompoundButton) ZeusTransformUtils.preCheckCast(r2, TintableCompoundButton.class, "com.obric.memorydata.plugin")).setSupportButtonTintMode(r3);
        return;
    }
}
