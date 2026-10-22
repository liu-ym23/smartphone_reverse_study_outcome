package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CheckedTextViewCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class AppCompatCheckedTextViewHelper {
    private ColorStateList mCheckMarkTintList;
    private PorterDuff.Mode mCheckMarkTintMode;
    private boolean mHasCheckMarkTint;
    private boolean mHasCheckMarkTintMode;
    private boolean mSkipNextApply;
    private final CheckedTextView mView;

    AppCompatCheckedTextViewHelper(CheckedTextView r2) {
        this.mCheckMarkTintList = null;
        this.mCheckMarkTintMode = null;
        this.mHasCheckMarkTint = false;
        this.mHasCheckMarkTintMode = false;
        this.mView = r2;
    }

    void applyCheckMarkTint() {
        Drawable r0 = CheckedTextViewCompat.getCheckMarkDrawable(this.mView);
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mHasCheckMarkTint == false) goto L7;
    L8:
        Drawable r1 = DrawableCompat.wrap(r0).mutate();
        if (this.mHasCheckMarkTint == false) goto L12;
        DrawableCompat.setTintList(r1, this.mCheckMarkTintList);
    L12:
        if (this.mHasCheckMarkTintMode == false) goto L15;
        DrawableCompat.setTintMode(r1, this.mCheckMarkTintMode);
    L15:
        if (r1.isStateful() == false) goto L17;
        r1.setState(this.mView.getDrawableState());
    L17:
        this.mView.setCheckMarkDrawable(r1);
        return;
    L7:
        if (this.mHasCheckMarkTintMode == true) goto L8;
    }

    ColorStateList getSupportCheckMarkTintList() {
        return this.mCheckMarkTintList;
    }

    PorterDuff.Mode getSupportCheckMarkTintMode() {
        return this.mCheckMarkTintMode;
    }

    void loadFromAttributes(AttributeSet r17, int r18) {
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r17, AttributeSet.class, "com.obric.memorydata.plugin");
        TintTypedArray r6 = TintTypedArray.obtainStyledAttributes((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r11, R.styleable.CheckedTextView, r18, 0);
        CheckedTextView r8 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r8, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), R.styleable.CheckedTextView, r11, r6.getWrappedTypeArray(), r18, 0);
    L24:
        th = move-exception;
        r6.recycle();
        throw th;
    L4:
        if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.CheckedTextView_checkMarkCompat, "styleable", "CheckedTextView_checkMarkCompat")) == false) goto L9;
        int r4 = r6.getResourceId(ZeusTransformUtils.mapRes(R.styleable.CheckedTextView_checkMarkCompat, "styleable", "CheckedTextView_checkMarkCompat"), 0);     // Catch: Throwable -> L24
        if (r4 == 0) goto L9;
        CheckedTextView r9 = this.mView;     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        r9.setCheckMarkDrawable(AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        boolean r5 = true;
    L10:
        if (r5 == true) goto L17;
        if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.CheckedTextView_android_checkMark, "styleable", "CheckedTextView_android_checkMark")) == false) goto L17;
        int r2 = r6.getResourceId(ZeusTransformUtils.mapRes(R.styleable.CheckedTextView_android_checkMark, "styleable", "CheckedTextView_android_checkMark"), 0);     // Catch: Throwable -> L24
        if (r2 == 0) goto L17;
        CheckedTextView r7 = this.mView;     // Catch: Throwable -> L24
        r7.setCheckMarkDrawable(AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2));     // Catch: Throwable -> L24
    L17:
        if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.CheckedTextView_checkMarkTint, "styleable", "CheckedTextView_checkMarkTint")) == false) goto L20;
        CheckedTextViewCompat.setCheckMarkTintList(this.mView, r6.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.CheckedTextView_checkMarkTint, "styleable", "CheckedTextView_checkMarkTint")));     // Catch: Throwable -> L24
    L20:
        if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.CheckedTextView_checkMarkTintMode, "styleable", "CheckedTextView_checkMarkTintMode")) == false) goto L22;
        CheckedTextViewCompat.setCheckMarkTintMode(this.mView, DrawableUtils.parseTintMode(r6.getInt(ZeusTransformUtils.mapRes(R.styleable.CheckedTextView_checkMarkTintMode, "styleable", "CheckedTextView_checkMarkTintMode"), -1), null));     // Catch: Throwable -> L24
    L22:
        r6.recycle();
        return;
    L9:
        r5 = false;
        goto L10
    }

    void onSetCheckMarkDrawable() {
        if (this.mSkipNextApply == false) goto L6;
        this.mSkipNextApply = false;
        return;
    L6:
        this.mSkipNextApply = true;
        applyCheckMarkTint();
    }

    void setSupportCheckMarkTintList(ColorStateList r1) {
        this.mCheckMarkTintList = r1;
        this.mHasCheckMarkTint = true;
        applyCheckMarkTint();
    }

    void setSupportCheckMarkTintMode(PorterDuff.Mode r1) {
        this.mCheckMarkTintMode = r1;
        this.mHasCheckMarkTintMode = true;
        applyCheckMarkTint();
    }
}
