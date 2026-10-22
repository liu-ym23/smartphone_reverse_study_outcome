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

    AppCompatEmojiTextHelper(@NonNull TextView r10) {
        this.mView = r10;
        this.mEmojiTextViewHelper = new EmojiTextViewHelper(r10, false);
    }

    @NonNull
    InputFilter[] getFilters(@NonNull InputFilter[] r10) {
        return this.mEmojiTextViewHelper.getFilters(r10);
    }

    public boolean isEnabled() {
        return this.mEmojiTextViewHelper.isEnabled();
    }

    void loadFromAttributes(@Nullable AttributeSet r10, int r11) {
        TypedArray r12 = this.mView.getContext().obtainStyledAttributes(r10, R.styleable.AppCompatTextView, r11, 0);
        int r13 = R.styleable.AppCompatTextView_emojiCompatEnabled;     // Catch: Throwable -> L8
        boolean r14 = true;
        if (r12.hasValue(r13) == false) goto L6;
        r14 = r12.getBoolean(r13, true);     // Catch: Throwable -> L8
    L6:
        r12.recycle();
        setEnabled(r14);
        return;
    L8:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    void setAllCaps(boolean r10) {
        this.mEmojiTextViewHelper.setAllCaps(r10);
    }

    void setEnabled(boolean r10) {
        this.mEmojiTextViewHelper.setEnabled(r10);
    }

    @Nullable
    public TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod r10) {
        return this.mEmojiTextViewHelper.wrapTransformationMethod(r10);
    }
}
