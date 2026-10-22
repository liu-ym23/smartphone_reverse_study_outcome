package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList;
    private PorterDuff.Mode mButtonTintMode;
    private boolean mHasButtonTint;
    private boolean mHasButtonTintMode;
    private boolean mSkipNextApply;
    private final CompoundButton mView;

    AppCompatCompoundButtonHelper(CompoundButton r2) {
        this.mButtonTintList = null;
        this.mButtonTintMode = null;
        this.mHasButtonTint = false;
        this.mHasButtonTintMode = false;
        this.mView = r2;
    }

    void applyButtonTint() {
        Drawable r0 = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mHasButtonTint == false) goto L7;
    L8:
        Drawable r1 = DrawableCompat.wrap(r0).mutate();
        if (this.mHasButtonTint == false) goto L12;
        DrawableCompat.setTintList(r1, this.mButtonTintList);
    L12:
        if (this.mHasButtonTintMode == false) goto L15;
        DrawableCompat.setTintMode(r1, this.mButtonTintMode);
    L15:
        if (r1.isStateful() == false) goto L17;
        r1.setState(this.mView.getDrawableState());
    L17:
        this.mView.setButtonDrawable(r1);
        return;
    L7:
        if (this.mHasButtonTintMode == true) goto L8;
    }

    int getCompoundPaddingLeft(int r3) {
        if (Build.VERSION.SDK_INT >= 17) goto L8;
        Drawable r2 = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (r2 != null) goto L7;
        return r3;
    L7:
        return r3 + r2.getIntrinsicWidth();
    L8:
        return r3;
    }

    ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    void loadFromAttributes(AttributeSet r17, int r18) {
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r17, AttributeSet.class, "com.obric.memorydata.plugin");
        TintTypedArray r6 = TintTypedArray.obtainStyledAttributes((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r11, R.styleable.CompoundButton, r18, 0);
        CompoundButton r8 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r8, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), R.styleable.CompoundButton, r11, r6.getWrappedTypeArray(), r18, 0);
    L24:
        th = move-exception;
        r6.recycle();
        throw th;
    L4:
        if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.CompoundButton_buttonCompat, "styleable", "CompoundButton_buttonCompat")) == false) goto L9;
        int r4 = r6.getResourceId(ZeusTransformUtils.mapRes(R.styleable.CompoundButton_buttonCompat, "styleable", "CompoundButton_buttonCompat"), 0);     // Catch: Throwable -> L24
        if (r4 == 0) goto L9;
        CompoundButton r9 = this.mView;     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        r9.setButtonDrawable(AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        boolean r5 = true;
    L10:
        if (r5 == true) goto L17;
        if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.CompoundButton_android_button, "styleable", "CompoundButton_android_button")) == false) goto L17;
        int r2 = r6.getResourceId(ZeusTransformUtils.mapRes(R.styleable.CompoundButton_android_button, "styleable", "CompoundButton_android_button"), 0);     // Catch: Throwable -> L24
        if (r2 == 0) goto L17;
        CompoundButton r7 = this.mView;     // Catch: Throwable -> L24
        r7.setButtonDrawable(AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2));     // Catch: Throwable -> L24
    L17:
        if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.CompoundButton_buttonTint, "styleable", "CompoundButton_buttonTint")) == false) goto L20;
        CompoundButtonCompat.setButtonTintList(this.mView, r6.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.CompoundButton_buttonTint, "styleable", "CompoundButton_buttonTint")));     // Catch: Throwable -> L24
    L20:
        if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.CompoundButton_buttonTintMode, "styleable", "CompoundButton_buttonTintMode")) == false) goto L22;
        CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(r6.getInt(ZeusTransformUtils.mapRes(R.styleable.CompoundButton_buttonTintMode, "styleable", "CompoundButton_buttonTintMode"), -1), null));     // Catch: Throwable -> L24
    L22:
        r6.recycle();
        return;
    L9:
        r5 = false;
        goto L10
    }

    void onSetButtonDrawable() {
        if (this.mSkipNextApply == false) goto L6;
        this.mSkipNextApply = false;
        return;
    L6:
        this.mSkipNextApply = true;
        applyButtonTint();
    }

    void setSupportButtonTintList(ColorStateList r1) {
        this.mButtonTintList = r1;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    void setSupportButtonTintMode(PorterDuff.Mode r1) {
        this.mButtonTintMode = r1;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }
}
