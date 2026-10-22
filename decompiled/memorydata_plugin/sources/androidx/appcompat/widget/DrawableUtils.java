package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] EMPTY_STATE_SET = null;
    public static final Rect INSETS_NONE = null;

    static class Api18Impl {
        private static final Field sBottom = null;
        private static final Method sGetOpticalInsets = null;
        private static final Field sLeft = null;
        private static final boolean sReflectionSuccessful = false;
        private static final Field sRight = null;
        private static final Field sTop = null;

        static {
            Class r3 = ZeusTransformUtils.forName("android.graphics.Insets", "com.obric.memorydata.plugin");     // Catch: NoSuchFieldException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L20
            Method r4 = Drawable.class.getMethod("getOpticalInsets", new Class[0]);     // Catch: NoSuchFieldException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L20
            Field r5 = r3.getField("left");     // Catch: NoSuchFieldException -> L13 ClassNotFoundException -> L14 NoSuchMethodException -> L15
        L35:
            Field r6 = r3.getField("top");     // Catch: NoSuchFieldException -> L10 ClassNotFoundException -> L11 NoSuchMethodException -> L12
            Field r7 = r3.getField("right");     // Catch: Throwable -> L9
            Field r8 = r3.getField("bottom");     // Catch: Throwable -> L28
            boolean r9 = true;
        L24:
            if (r9 == false) goto L26;
            sGetOpticalInsets = r4;
            sLeft = r5;
            sTop = r6;
            sRight = r7;
            sBottom = r8;
            sReflectionSuccessful = true;
            return;
        L26:
            sGetOpticalInsets = null;
            sLeft = null;
            sTop = null;
            sRight = null;
            sBottom = null;
            sReflectionSuccessful = false;
            return;
        L23:
            r9 = false;
            r8 = null;
        L9:
            r7 = null;
            goto L23
        L11:
            r6 = null;
        L22:
            r7 = r6;
        L10:
            r6 = null;
        L12:
            r6 = null;
        L14:
            r5 = null;
        L19:
            r6 = r5;
        L13:
            r5 = null;
        L17:
            r6 = r5;
        L15:
            r5 = null;
        L21:
            r6 = r5;
            goto L22
        L18:
            r4 = null;
            r5 = null;
        L16:
            r4 = null;
            r5 = null;
        L20:
            r4 = null;
            r5 = null;
            goto L21
        }

        private Api18Impl() {
        }

        static Rect getOpticalInsets(Drawable r5) {
            if (Build.VERSION.SDK_INT >= 29) goto L11;
            if (sReflectionSuccessful == false) goto L11;
            Object r6 = sGetOpticalInsets.invoke(r5, new Object[0]);     // Catch: Throwable -> L12
            if (r6 == null) goto L11;
            return new Rect(sLeft.getInt(r6), sTop.getInt(r6), sRight.getInt(r6), sBottom.getInt(r6));
        L11:
            return DrawableUtils.INSETS_NONE;
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static Insets getOpticalInsets(Drawable r0) {
            return r0.getOpticalInsets();
        }
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        EMPTY_STATE_SET = new int[0];
        INSETS_NONE = new Rect();
    }

    private DrawableUtils() {
    }

    public static boolean canSafelyMutateDrawable(Drawable r5) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        return true;
    L6:
        if (Build.VERSION.SDK_INT >= 15) goto L11;
        if (ZeusTransformUtils.instanceOf(r5, InsetDrawable.class) == false) goto L11;
        return false;
    L11:
        if (Build.VERSION.SDK_INT >= 15) goto L16;
        if (ZeusTransformUtils.instanceOf(r5, GradientDrawable.class) == false) goto L16;
        return false;
    L16:
        if (Build.VERSION.SDK_INT >= 17) goto L21;
        if (ZeusTransformUtils.instanceOf(r5, LayerDrawable.class) == false) goto L21;
        return false;
    L21:
        if (ZeusTransformUtils.instanceOf(r5, DrawableContainer.class) == false) goto L31;
        Drawable.ConstantState r6 = r5.getConstantState();
        if (ZeusTransformUtils.instanceOf(r6, DrawableContainer.DrawableContainerState.class) == false) goto L41;
        Drawable[] r7 = ((DrawableContainer.DrawableContainerState) ZeusTransformUtils.preCheckCast(r6, DrawableContainer.DrawableContainerState.class, "com.obric.memorydata.plugin")).getChildren();
        int r0 = r7.length;
        int r1 = 0;
    L25:
        if (r1 >= r0) goto L41;
        if (canSafelyMutateDrawable(r7[r1]) == false) goto L28;
        r1 = r1 + 1;
        goto L25
    L28:
        return false;
    L41:
        return true;
    L31:
        if (ZeusTransformUtils.instanceOf(r5, WrappedDrawable.class) == false) goto L36;
        Drawable r8 = ((WrappedDrawable) ZeusTransformUtils.preCheckCast(r5, WrappedDrawable.class, "com.obric.memorydata.plugin")).getWrappedDrawable();
    L34:
        return canSafelyMutateDrawable(r8);
    L36:
        if (ZeusTransformUtils.instanceOf(r5, DrawableWrapperCompat.class) == false) goto L39;
        r8 = ((DrawableWrapperCompat) ZeusTransformUtils.preCheckCast(r5, DrawableWrapperCompat.class, "com.obric.memorydata.plugin")).getDrawable();
        goto L34
    L39:
        if (ZeusTransformUtils.instanceOf(r5, ScaleDrawable.class) == false) goto L41;
        r8 = ((ScaleDrawable) ZeusTransformUtils.preCheckCast(r5, ScaleDrawable.class, "com.obric.memorydata.plugin")).getDrawable();
        goto L34
    }

    static void fixDrawable(Drawable r3) {
        String r0 = r3.getClass().getName();
        if (Build.VERSION.SDK_INT != 21) goto L8;
        if ("android.graphics.drawable.VectorDrawable".equals(r0) == false) goto L8;
    L6:
        forceDrawableStateChange(r3);
        return;
    L8:
        if (Build.VERSION.SDK_INT >= 29) goto L10;
        return;
    L10:
        if (Build.VERSION.SDK_INT < 31) goto L12;
        return;
    L12:
        if ("android.graphics.drawable.ColorStateListDrawable".equals(r0) == true) goto L6;
    }

    private static void forceDrawableStateChange(Drawable r2) {
        int[] r0 = r2.getState();
        if (r0 != null) goto L5;
    L8:
        r2.setState(CHECKED_STATE_SET);
    L9:
        r2.setState(r0);
        return;
    L5:
        if (r0.length == 0) goto L8;
        r2.setState(EMPTY_STATE_SET);
        goto L9
    }

    public static Rect getOpticalBounds(Drawable r4) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        Insets r5 = Api29Impl.getOpticalInsets(r4);
        return new Rect(r5.left, r5.top, r5.right, r5.bottom);
    L7:
        if (Build.VERSION.SDK_INT < 18) goto L11;
        return Api18Impl.getOpticalInsets(DrawableCompat.unwrap(r4));
    L11:
        return INSETS_NONE;
    }

    public static PorterDuff.Mode parseTintMode(int r1, PorterDuff.Mode r2) {
        if (r1 == 3) goto L21;
        if (r1 == 5) goto L19;
        if (r1 == 9) goto L17;
        switch(r1) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r2;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.SRC_ATOP;
    L19:
        return PorterDuff.Mode.SRC_IN;
    L21:
        return PorterDuff.Mode.SRC_OVER;
    }
}
