package com.google.android.material.internal;

import android.content.Context;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextDrawableHelper {

    @Nullable
    private WeakReference<TextDrawableDelegate> delegate;
    private final TextAppearanceFontCallback fontCallback;

    @Nullable
    private TextAppearance textAppearance;
    private float textHeight;
    private final TextPaint textPaint;
    private boolean textSizeDirty;
    private float textWidth;

    public interface TextDrawableDelegate {
        @NonNull
        int[] getState();

        boolean onStateChange(int[] r5);

        void onTextSizeChange();
    }

    public TextDrawableHelper(@Nullable TextDrawableDelegate r5) {
        this.textPaint = new TextPaint(1);
        this.fontCallback = new AnonymousClass1(this);
        this.textSizeDirty = true;
        this.delegate = new WeakReference(null);
        setDelegate(r5);
    }

    public static /* synthetic */ boolean access$002(TextDrawableHelper r5, boolean r10) {
        r5.textSizeDirty = r10;
        return r10;
    }

    public static /* synthetic */ WeakReference access$100(TextDrawableHelper r5) {
        return r5.delegate;
    }

    private float calculateTextHeight(@Nullable String r5) {
        if (r5 != null) goto L6;
        return 0.0f;
    L6:
        return Math.abs(this.textPaint.getFontMetrics().ascent);
    }

    private float calculateTextWidth(@Nullable CharSequence r5) {
        if (r5 != null) goto L6;
        return 0.0f;
    L6:
        return this.textPaint.measureText(r5, 0, r5.length());
    }

    private void refreshTextDimens(String r5) {
        this.textWidth = calculateTextWidth(r5);
        this.textHeight = calculateTextHeight(r5);
        this.textSizeDirty = false;
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        return this.textAppearance;
    }

    public float getTextHeight(@Nullable String r5) {
        if (this.textSizeDirty == false) goto L5;
        refreshTextDimens(r5);
        return this.textHeight;
    L5:
        return this.textHeight;
    }

    @NonNull
    public TextPaint getTextPaint() {
        return this.textPaint;
    }

    public float getTextWidth(String r5) {
        if (this.textSizeDirty == false) goto L5;
        refreshTextDimens(r5);
        return this.textWidth;
    L5:
        return this.textWidth;
    }

    public boolean isTextWidthDirty() {
        return this.textSizeDirty;
    }

    public void setDelegate(@Nullable TextDrawableDelegate r5) {
        this.delegate = new WeakReference(r5);
    }

    public void setTextAppearance(@Nullable TextAppearance r5, Context r10) {
        if (this.textAppearance == r5) goto L14;
        this.textAppearance = r5;
        if (r5 == null) goto L10;
        r5.updateMeasureState(r10, this.textPaint, this.fontCallback);
        TextDrawableDelegate r11 = this.delegate.get();
        if (r11 == null) goto L9;
        TextPaint r12 = this.textPaint;
        r12.drawableState = r11.getState();
    L9:
        r5.updateDrawState(r10, this.textPaint, this.fontCallback);
        this.textSizeDirty = true;
    L10:
        TextDrawableDelegate r13 = this.delegate.get();
        if (r13 == null) goto L15;
        r13.onTextSizeChange();
        r13.onStateChange(r13.getState());
        return;
    L15:
        return;
    }

    public void setTextSizeDirty(boolean r5) {
        this.textSizeDirty = r5;
    }

    public void setTextWidthDirty(boolean r5) {
        this.textSizeDirty = r5;
    }

    public void updateTextPaintDrawState(Context r5) {
        this.textAppearance.updateDrawState(r5, this.textPaint, this.fontCallback);
    }
}
