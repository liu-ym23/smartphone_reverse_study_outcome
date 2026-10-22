package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class AppCompatBackgroundHelper {
    private int mBackgroundResId;
    private TintInfo mBackgroundTint;
    private final AppCompatDrawableManager mDrawableManager;
    private TintInfo mInternalBackgroundTint;
    private TintInfo mTmpInfo;
    private final View mView;

    AppCompatBackgroundHelper(View r2) {
        this.mBackgroundResId = -1;
        this.mView = r2;
        this.mDrawableManager = AppCompatDrawableManager.get();
    }

    private boolean applyFrameworkTintUsingColorFilter(Drawable r4) {
        if (this.mTmpInfo != null) goto L5;
        this.mTmpInfo = new TintInfo();
    L5:
        TintInfo r0 = this.mTmpInfo;
        r0.clear();
        ColorStateList r1 = ViewCompat.getBackgroundTintList(this.mView);
        if (r1 == null) goto L8;
        r0.mHasTintList = true;
        r0.mTintList = r1;
    L8:
        PorterDuff.Mode r2 = ViewCompat.getBackgroundTintMode(this.mView);
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
        if (this.mInternalBackgroundTint == null) goto L8;
        return true;
    L8:
        return false;
    }

    void applySupportBackgroundTint() {
        Drawable r0 = this.mView.getBackground();
        if (r0 != null) goto L5;
        return;
    L5:
        if (shouldApplyFrameworkTintUsingColorFilter() == true) goto L7;
    L9:
        TintInfo r1 = this.mBackgroundTint;
        if (r1 == null) goto L12;
        AppCompatDrawableManager.tintDrawable(r0, r1, this.mView.getDrawableState());
        return;
    L12:
        TintInfo r2 = this.mInternalBackgroundTint;
        if (r2 == null) goto L18;
        AppCompatDrawableManager.tintDrawable(r0, r2, this.mView.getDrawableState());
        return;
    L18:
        return;
    L7:
        if (applyFrameworkTintUsingColorFilter(r0) == false) goto L9;
    }

    ColorStateList getSupportBackgroundTintList() {
        TintInfo r0 = this.mBackgroundTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintList;
    }

    PorterDuff.Mode getSupportBackgroundTintMode() {
        TintInfo r0 = this.mBackgroundTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintMode;
    }

    void loadFromAttributes(AttributeSet r14, int r15) {
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r14, AttributeSet.class, "com.obric.memorydata.plugin");
        TintTypedArray r16 = TintTypedArray.obtainStyledAttributes((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r9, R.styleable.ViewBackgroundHelper, r15, 0);
        View r6 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r6, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), R.styleable.ViewBackgroundHelper, r9, r16.getWrappedTypeArray(), r15, 0);
    L16:
        th = move-exception;
        r16.recycle();
        throw th;
    L4:
        if (r16.hasValue(ZeusTransformUtils.mapRes(R.styleable.ViewBackgroundHelper_android_background, "styleable", "ViewBackgroundHelper_android_background")) == false) goto L9;
        this.mBackgroundResId = r16.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ViewBackgroundHelper_android_background, "styleable", "ViewBackgroundHelper_android_background"), -1);     // Catch: Throwable -> L16
        ColorStateList r17 = this.mDrawableManager.getTintList((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.mBackgroundResId);     // Catch: Throwable -> L16
        if (r17 == null) goto L9;
        setInternalBackgroundTint(r17);     // Catch: Throwable -> L16
    L9:
        if (r16.hasValue(ZeusTransformUtils.mapRes(R.styleable.ViewBackgroundHelper_backgroundTint, "styleable", "ViewBackgroundHelper_backgroundTint")) == false) goto L12;
        ViewCompat.setBackgroundTintList(this.mView, r16.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.ViewBackgroundHelper_backgroundTint, "styleable", "ViewBackgroundHelper_backgroundTint")));     // Catch: Throwable -> L16
    L12:
        if (r16.hasValue(ZeusTransformUtils.mapRes(R.styleable.ViewBackgroundHelper_backgroundTintMode, "styleable", "ViewBackgroundHelper_backgroundTintMode")) == false) goto L14;
        ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.parseTintMode(r16.getInt(ZeusTransformUtils.mapRes(R.styleable.ViewBackgroundHelper_backgroundTintMode, "styleable", "ViewBackgroundHelper_backgroundTintMode"), -1), null));     // Catch: Throwable -> L16
    L14:
        r16.recycle();
    }

    void onSetBackgroundDrawable(Drawable r1) {
        this.mBackgroundResId = -1;
        setInternalBackgroundTint(null);
        applySupportBackgroundTint();
    }

    void onSetBackgroundResource(int r5) {
        this.mBackgroundResId = r5;
        AppCompatDrawableManager r0 = this.mDrawableManager;
        if (r0 == null) goto L5;
        ColorStateList r6 = r0.getTintList((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    L6:
        setInternalBackgroundTint(r6);
        applySupportBackgroundTint();
        return;
    L5:
        r6 = null;
        goto L6
    }

    void setInternalBackgroundTint(ColorStateList r2) {
        if (r2 != null) goto L4;
        this.mInternalBackgroundTint = null;
    L8:
        applySupportBackgroundTint();
        return;
    L4:
        if (this.mInternalBackgroundTint != null) goto L6;
        this.mInternalBackgroundTint = new TintInfo();
    L6:
        this.mInternalBackgroundTint.mTintList = r2;
        this.mInternalBackgroundTint.mHasTintList = true;
        goto L8
    }

    void setSupportBackgroundTintList(ColorStateList r2) {
        if (this.mBackgroundTint != null) goto L5;
        this.mBackgroundTint = new TintInfo();
    L5:
        this.mBackgroundTint.mTintList = r2;
        this.mBackgroundTint.mHasTintList = true;
        applySupportBackgroundTint();
    }

    void setSupportBackgroundTintMode(PorterDuff.Mode r2) {
        if (this.mBackgroundTint != null) goto L5;
        this.mBackgroundTint = new TintInfo();
    L5:
        this.mBackgroundTint.mTintMode = r2;
        this.mBackgroundTint.mHasTintMode = true;
        applySupportBackgroundTint();
    }
}
