package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;

/* JADX INFO: loaded from: classes.dex */
class AppCompatEmojiTextHelper {

    @NonNull
    private final EmojiTextViewHelper mEmojiTextViewHelper;

    @NonNull
    private final TextView mView;

    public AppCompatEmojiTextHelper(@NonNull TextView r5) {
        this.mView = r5;
        this.mEmojiTextViewHelper = new EmojiTextViewHelper(r5, false);
    }

    @NonNull
    public InputFilter[] getFilters(@NonNull InputFilter[] r5) {
        return this.mEmojiTextViewHelper.getFilters(r5);
    }

    public boolean isEnabled() {
        return this.mEmojiTextViewHelper.isEnabled();
    }

    public void loadFromAttributes(@Nullable AttributeSet r5, int r10) {
        TypedArray r11 = this.mView.getContext().obtainStyledAttributes(r5, R.styleable.AppCompatTextView, r10, 0);
        boolean r12 = true;
        if (r11.hasValue(R.styleable.AppCompatTextView_emojiCompatEnabled) == false) goto L9;
        r12 = r11.getBoolean(R.styleable.AppCompatTextView_emojiCompatEnabled, true);     // Catch: Throwable -> L7
    L9:
        r11.recycle();
        setEnabled(r12);
        return;
    L7:
        th = move-exception;
        r11.recycle();
        throw th;
    }

    public void setAllCaps(boolean r5) {
        this.mEmojiTextViewHelper.setAllCaps(r5);
    }

    public void setEnabled(boolean r5) {
        this.mEmojiTextViewHelper.setEnabled(r5);
    }

    @Nullable
    public TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod r5) {
        return this.mEmojiTextViewHelper.wrapTransformationMethod(r5);
    }
}
