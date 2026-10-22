package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public final class DrawableCompat {
    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    static class Api19Impl {
        private Api19Impl() {
        }

        static int getAlpha(Drawable r0) {
            return r0.getAlpha();
        }

        static Drawable getChild(DrawableContainer.DrawableContainerState r0, int r1) {
            return r0.getChild(r1);
        }

        static Drawable getDrawable(InsetDrawable r0) {
            return r0.getDrawable();
        }

        static boolean isAutoMirrored(Drawable r0) {
            return r0.isAutoMirrored();
        }

        static void setAutoMirrored(Drawable r0, boolean r1) {
            r0.setAutoMirrored(r1);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static void applyTheme(Drawable r0, Resources.Theme r1) {
            r0.applyTheme(r1);
        }

        static boolean canApplyTheme(Drawable r0) {
            return r0.canApplyTheme();
        }

        static ColorFilter getColorFilter(Drawable r0) {
            return r0.getColorFilter();
        }

        static void inflate(Drawable r2, Resources r3, XmlPullParser r4, AttributeSet r5, Resources.Theme r6) {
            r2.inflate(r3, (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), r6);
        }

        static void setHotspot(Drawable r0, float r1, float r2) {
            r0.setHotspot(r1, r2);
        }

        static void setHotspotBounds(Drawable r0, int r1, int r2, int r3, int r4) {
            r0.setHotspotBounds(r1, r2, r3, r4);
        }

        static void setTint(Drawable r0, int r1) {
            r0.setTint(r1);
        }

        static void setTintList(Drawable r0, ColorStateList r1) {
            r0.setTintList(r1);
        }

        static void setTintMode(Drawable r0, PorterDuff.Mode r1) {
            r0.setTintMode(r1);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static int getLayoutDirection(Drawable r0) {
            return r0.getLayoutDirection();
        }

        static boolean setLayoutDirection(Drawable r0, int r1) {
            return r0.setLayoutDirection(r1);
        }
    }

    private DrawableCompat() {
    }

    public static void applyTheme(Drawable r2, Resources.Theme r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.applyTheme(r2, r3);
        return;
    }

    public static boolean canApplyTheme(Drawable r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return false;
    L5:
        return Api21Impl.canApplyTheme(r2);
    }

    public static void clearColorFilter(Drawable r3) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
    L4:
        r3.clearColorFilter();
        return;
    L6:
        if (Build.VERSION.SDK_INT < 21) goto L4;
        r3.clearColorFilter();
        if (ZeusTransformUtils.instanceOf(r3, InsetDrawable.class) == false) goto L12;
        Drawable r4 = Api19Impl.getDrawable((InsetDrawable) ZeusTransformUtils.preCheckCast(r3, InsetDrawable.class, "com.obric.memorydata.plugin"));
    L10:
        clearColorFilter(r4);
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r3, WrappedDrawable.class) == false) goto L15;
        r4 = ((WrappedDrawable) ZeusTransformUtils.preCheckCast(r3, WrappedDrawable.class, "com.obric.memorydata.plugin")).getWrappedDrawable();
        goto L10
    L15:
        if (ZeusTransformUtils.instanceOf(r3, DrawableContainer.class) == false) goto L29;
        DrawableContainer.DrawableContainerState r5 = (DrawableContainer.DrawableContainerState) ZeusTransformUtils.preCheckCast(((DrawableContainer) ZeusTransformUtils.preCheckCast(r3, DrawableContainer.class, "com.obric.memorydata.plugin")).getConstantState(), DrawableContainer.DrawableContainerState.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L30;
        int r0 = 0;
        int r1 = r5.getChildCount();
    L19:
        if (r0 >= r1) goto L31;
        Drawable r2 = Api19Impl.getChild(r5, r0);
        if (r2 == null) goto L23;
        clearColorFilter(r2);
    L23:
        r0 = r0 + 1;
        goto L19
    L31:
        return;
    L30:
        return;
    }

    public static int getAlpha(Drawable r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 0;
    L5:
        return Api19Impl.getAlpha(r2);
    }

    public static ColorFilter getColorFilter(Drawable r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return Api21Impl.getColorFilter(r2);
    }

    public static int getLayoutDirection(Drawable r6) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getLayoutDirection(r6);
    L7:
        if (Build.VERSION.SDK_INT >= 17) goto L9;
    L22:
        return 0;
    L9:
        if (sGetLayoutDirectionMethodFetched == false) goto L23;
    L16:
        Method r0 = sGetLayoutDirectionMethod;
        if (r0 == null) goto L22;
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.invoke(r6, new Object[0]), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L20:
        e = move-exception;
        Log.i(TAG, "Failed to invoke getLayoutDirection() via reflection", e);
        sGetLayoutDirectionMethod = null;
        goto L22
    L23:
        Method r3 = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);     // Catch: NoSuchMethodException -> L13
        sGetLayoutDirectionMethod = r3;     // Catch: NoSuchMethodException -> L13
        r3.setAccessible(true);     // Catch: NoSuchMethodException -> L13
    L15:
        sGetLayoutDirectionMethodFetched = true;
    L13:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve getLayoutDirection() method", e);
        goto L15
    }

    public static void inflate(Drawable r2, Resources r3, XmlPullParser r4, AttributeSet r5, Resources.Theme r6) {
        XmlPullParser r7 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Api21Impl.inflate(r2, r3, r7, r8, r6);
        return;
    L5:
        r2.inflate(r3, r7, r8);
    }

    public static boolean isAutoMirrored(Drawable r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return Api19Impl.isAutoMirrored(r2);
    }

    @Deprecated
    public static void jumpToCurrentState(Drawable r0) {
        r0.jumpToCurrentState();
    }

    public static void setAutoMirrored(Drawable r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.setAutoMirrored(r2, r3);
        return;
    }

    public static void setHotspot(Drawable r2, float r3, float r4) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setHotspot(r2, r3, r4);
        return;
    }

    public static void setHotspotBounds(Drawable r2, int r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setHotspotBounds(r2, r3, r4, r5, r6);
        return;
    }

    public static boolean setLayoutDirection(Drawable r7, int r8) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.setLayoutDirection(r7, r8);
    L7:
        if (Build.VERSION.SDK_INT >= 17) goto L9;
    L21:
        return false;
    L9:
        if (sSetLayoutDirectionMethodFetched == false) goto L22;
    L15:
        Method r0 = sSetLayoutDirectionMethod;
        if (r0 == null) goto L21;
        r0.invoke(r7, new Object[]{Integer.valueOf(r8)});     // Catch: Exception -> L19
        return true;
    L19:
        e = move-exception;
        Log.i(TAG, "Failed to invoke setLayoutDirection(int) via reflection", e);
        sSetLayoutDirectionMethod = null;
        goto L21
    L22:
        Method r1 = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L12
        sSetLayoutDirectionMethod = r1;     // Catch: NoSuchMethodException -> L12
        r1.setAccessible(true);     // Catch: NoSuchMethodException -> L12
    L14:
        sSetLayoutDirectionMethodFetched = true;
    L12:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve setLayoutDirection(int) method", e);
        goto L14
    }

    public static void setTint(Drawable r2, int r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setTint(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, TintAwareDrawable.class) == false) goto L10;
        ((TintAwareDrawable) ZeusTransformUtils.preCheckCast(r2, TintAwareDrawable.class, "com.obric.memorydata.plugin")).setTint(r3);
        return;
    }

    public static void setTintList(Drawable r2, ColorStateList r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setTintList(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, TintAwareDrawable.class) == false) goto L10;
        ((TintAwareDrawable) ZeusTransformUtils.preCheckCast(r2, TintAwareDrawable.class, "com.obric.memorydata.plugin")).setTintList(r3);
        return;
    }

    public static void setTintMode(Drawable r2, PorterDuff.Mode r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setTintMode(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, TintAwareDrawable.class) == false) goto L10;
        ((TintAwareDrawable) ZeusTransformUtils.preCheckCast(r2, TintAwareDrawable.class, "com.obric.memorydata.plugin")).setTintMode(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T unwrap(Drawable r2) {
        if (ZeusTransformUtils.instanceOf(r2, WrappedDrawable.class) == true) goto L5;
        return r2;
    L5:
        return (T) ((WrappedDrawable) ZeusTransformUtils.preCheckCast(r2, WrappedDrawable.class, "com.obric.memorydata.plugin")).getWrappedDrawable();
    }

    public static Drawable wrap(Drawable r2) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return r2;
    L6:
        if (Build.VERSION.SDK_INT < 21) goto L13;
        if (ZeusTransformUtils.instanceOf(r2, TintAwareDrawable.class) == false) goto L10;
        return r2;
    L10:
        return new WrappedDrawableApi21(r2);
    L13:
        if (ZeusTransformUtils.instanceOf(r2, TintAwareDrawable.class) == false) goto L15;
        return r2;
    L15:
        return new WrappedDrawableApi14(r2);
    }
}
