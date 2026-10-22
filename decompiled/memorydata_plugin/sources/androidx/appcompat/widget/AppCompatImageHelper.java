package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageHelper {
    private TintInfo mImageTint;
    private TintInfo mInternalImageTint;
    private int mLevel;
    private TintInfo mTmpInfo;
    private final ImageView mView;

    public AppCompatImageHelper(ImageView r2) {
        this.mLevel = 0;
        this.mView = r2;
    }

    private boolean applyFrameworkTintUsingColorFilter(Drawable r4) {
        if (this.mTmpInfo != null) goto L5;
        this.mTmpInfo = new TintInfo();
    L5:
        TintInfo r0 = this.mTmpInfo;
        r0.clear();
        ColorStateList r1 = ImageViewCompat.getImageTintList(this.mView);
        if (r1 == null) goto L8;
        r0.mHasTintList = true;
        r0.mTintList = r1;
    L8:
        PorterDuff.Mode r2 = ImageViewCompat.getImageTintMode(this.mView);
        if (r2 == null) goto L12;
        r0.mHasTintMode = true;
        r0.mTintMode = r2;
    L12:
        if (r0.mHasTintList == false) goto L14;
    L18:
        AppCompatDrawableManager.tintDrawable(r4, r0, this.mView.getDrawableState());
        return true;
    L14:
        if (r0.mHasTintMode == true) goto L18;
        return false;
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 > 21) goto L5;
        if (r0 != 21) goto L11;
        return true;
    L11:
        return false;
    L5:
        if (this.mInternalImageTint == null) goto L8;
        return true;
    L8:
        return false;
    }

    void applyImageLevel() {
        if (this.mView.getDrawable() == null) goto L6;
        this.mView.getDrawable().setLevel(this.mLevel);
        return;
    }

    void applySupportImageTint() {
        Drawable r0 = this.mView.getDrawable();
        if (r0 == null) goto L5;
        DrawableUtils.fixDrawable(r0);
    L5:
        if (r0 != null) goto L7;
        return;
    L7:
        if (shouldApplyFrameworkTintUsingColorFilter() == true) goto L9;
    L11:
        TintInfo r1 = this.mImageTint;
        if (r1 == null) goto L14;
        AppCompatDrawableManager.tintDrawable(r0, r1, this.mView.getDrawableState());
        return;
    L14:
        TintInfo r2 = this.mInternalImageTint;
        if (r2 == null) goto L20;
        AppCompatDrawableManager.tintDrawable(r0, r2, this.mView.getDrawableState());
        return;
    L20:
        return;
    L9:
        if (applyFrameworkTintUsingColorFilter(r0) == false) goto L11;
    }

    ColorStateList getSupportImageTintList() {
        TintInfo r0 = this.mImageTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintList;
    }

    PorterDuff.Mode getSupportImageTintMode() {
        TintInfo r0 = this.mImageTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintMode;
    }

    boolean hasOverlappingRendering() {
        Drawable r2 = this.mView.getBackground();
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r2, RippleDrawable.class) == false) goto L10;
        return false;
    L10:
        return true;
    }

    public void loadFromAttributes(AttributeSet r12, int r13) {
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        TintTypedArray r14 = TintTypedArray.obtainStyledAttributes((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r7, R.styleable.AppCompatImageView, r13, 0);
        ImageView r4 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r4, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), R.styleable.AppCompatImageView, r7, r14.getWrappedTypeArray(), r13, 0);
        Drawable r15 = this.mView.getDrawable();     // Catch: Throwable -> L21
        if (r15 != null) goto L11;
        int r5 = r14.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatImageView_srcCompat, "styleable", "AppCompatImageView_srcCompat"), -1);     // Catch: Throwable -> L21
        if (r5 == (-1)) goto L11;
        r15 = AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);     // Catch: Throwable -> L21
        if (r15 == null) goto L11;
        this.mView.setImageDrawable(r15);     // Catch: Throwable -> L21
    L11:
        if (r15 == null) goto L14;
        DrawableUtils.fixDrawable(r15);     // Catch: Throwable -> L21
    L14:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatImageView_tint, "styleable", "AppCompatImageView_tint")) == false) goto L17;
        ImageViewCompat.setImageTintList(this.mView, r14.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.AppCompatImageView_tint, "styleable", "AppCompatImageView_tint")));     // Catch: Throwable -> L21
    L17:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatImageView_tintMode, "styleable", "AppCompatImageView_tintMode")) == false) goto L19;
        ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.AppCompatImageView_tintMode, "styleable", "AppCompatImageView_tintMode"), -1), null));     // Catch: Throwable -> L21
    L19:
        r14.recycle();
        return;
    L21:
        th = move-exception;
        r14.recycle();
        throw th;
    }

    void obtainLevelFromDrawable(Drawable r1) {
        this.mLevel = r1.getLevel();
    }

    public void setImageResource(int r4) {
        if (r4 == 0) goto L7;
        Drawable r5 = AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        if (r5 == null) goto L6;
        DrawableUtils.fixDrawable(r5);
    L6:
        this.mView.setImageDrawable(r5);
    L8:
        applySupportImageTint();
        return;
    L7:
        this.mView.setImageDrawable(null);
        goto L8
    }

    void setInternalImageTint(ColorStateList r2) {
        if (r2 != null) goto L4;
        this.mInternalImageTint = null;
    L8:
        applySupportImageTint();
        return;
    L4:
        if (this.mInternalImageTint != null) goto L6;
        this.mInternalImageTint = new TintInfo();
    L6:
        this.mInternalImageTint.mTintList = r2;
        this.mInternalImageTint.mHasTintList = true;
        goto L8
    }

    void setSupportImageTintList(ColorStateList r2) {
        if (this.mImageTint != null) goto L5;
        this.mImageTint = new TintInfo();
    L5:
        this.mImageTint.mTintList = r2;
        this.mImageTint.mHasTintList = true;
        applySupportImageTint();
    }

    void setSupportImageTintMode(PorterDuff.Mode r2) {
        if (this.mImageTint != null) goto L5;
        this.mImageTint = new TintInfo();
    L5:
        this.mImageTint.mTintMode = r2;
        this.mImageTint.mHasTintMode = true;
        applySupportImageTint();
    }
}
