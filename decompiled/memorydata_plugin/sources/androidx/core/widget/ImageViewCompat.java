package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ImageViewCompat {

    static class Api21Impl {
        private Api21Impl() {
        }

        static ColorStateList getImageTintList(ImageView r0) {
            return r0.getImageTintList();
        }

        static PorterDuff.Mode getImageTintMode(ImageView r0) {
            return r0.getImageTintMode();
        }

        static void setImageTintList(ImageView r0, ColorStateList r1) {
            r0.setImageTintList(r1);
        }

        static void setImageTintMode(ImageView r0, PorterDuff.Mode r1) {
            r0.setImageTintMode(r1);
        }
    }

    private ImageViewCompat() {
    }

    public static ColorStateList getImageTintList(ImageView r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getImageTintList(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, TintableImageSourceView.class) == true) goto L11;
        return null;
    L11:
        return ((TintableImageSourceView) ZeusTransformUtils.preCheckCast(r2, TintableImageSourceView.class, "com.obric.memorydata.plugin")).getSupportImageTintList();
    }

    public static PorterDuff.Mode getImageTintMode(ImageView r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getImageTintMode(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, TintableImageSourceView.class) == true) goto L11;
        return null;
    L11:
        return ((TintableImageSourceView) ZeusTransformUtils.preCheckCast(r2, TintableImageSourceView.class, "com.obric.memorydata.plugin")).getSupportImageTintMode();
    }

    public static void setImageTintList(ImageView r2, ColorStateList r3) {
        if (Build.VERSION.SDK_INT < 21) goto L15;
        Api21Impl.setImageTintList(r2, r3);
        if (Build.VERSION.SDK_INT != 21) goto L18;
        Drawable r4 = r2.getDrawable();
        if (r4 != null) goto L9;
        return;
    L9:
        if (Api21Impl.getImageTintList(r2) != null) goto L11;
        return;
    L11:
        if (r4.isStateful() == false) goto L13;
        r4.setState(r2.getDrawableState());
    L13:
        r2.setImageDrawable(r4);
        return;
    L18:
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r2, TintableImageSourceView.class) == false) goto L22;
        ((TintableImageSourceView) ZeusTransformUtils.preCheckCast(r2, TintableImageSourceView.class, "com.obric.memorydata.plugin")).setSupportImageTintList(r3);
        return;
    }

    public static void setImageTintMode(ImageView r2, PorterDuff.Mode r3) {
        if (Build.VERSION.SDK_INT < 21) goto L15;
        Api21Impl.setImageTintMode(r2, r3);
        if (Build.VERSION.SDK_INT != 21) goto L18;
        Drawable r4 = r2.getDrawable();
        if (r4 != null) goto L9;
        return;
    L9:
        if (Api21Impl.getImageTintList(r2) != null) goto L11;
        return;
    L11:
        if (r4.isStateful() == false) goto L13;
        r4.setState(r2.getDrawableState());
    L13:
        r2.setImageDrawable(r4);
        return;
    L18:
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r2, TintableImageSourceView.class) == false) goto L22;
        ((TintableImageSourceView) ZeusTransformUtils.preCheckCast(r2, TintableImageSourceView.class, "com.obric.memorydata.plugin")).setSupportImageTintMode(r3);
        return;
    }
}
