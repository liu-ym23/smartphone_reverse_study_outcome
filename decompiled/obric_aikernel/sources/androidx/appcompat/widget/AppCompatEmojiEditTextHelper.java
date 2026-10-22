package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

/* JADX INFO: loaded from: classes.dex */
class AppCompatEmojiEditTextHelper {

    @NonNull
    private final EmojiEditTextHelper mEmojiEditTextHelper;

    @NonNull
    private final EditText mView;

    AppCompatEmojiEditTextHelper(@NonNull EditText r10) {
        this.mView = r10;
        this.mEmojiEditTextHelper = new EmojiEditTextHelper(r10, false);
    }

    @Nullable
    KeyListener getKeyListener(@Nullable KeyListener r10) {
        if (isEmojiCapableKeyListener(r10) == true) goto L5;
        return r10;
    L5:
        return this.mEmojiEditTextHelper.getKeyListener(r10);
    }

    boolean isEmojiCapableKeyListener(KeyListener r10) {
        return !(r10 instanceof NumberKeyListener);
    }

    boolean isEnabled() {
        return this.mEmojiEditTextHelper.isEnabled();
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

    @Nullable
    InputConnection onCreateInputConnection(@Nullable InputConnection r10, @NonNull EditorInfo r11) {
        return this.mEmojiEditTextHelper.onCreateInputConnection(r10, r11);
    }

    void setEnabled(boolean r10) {
        this.mEmojiEditTextHelper.setEnabled(r10);
    }
}
