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

    public AppCompatEmojiEditTextHelper(@NonNull EditText r5) {
        this.mView = r5;
        this.mEmojiEditTextHelper = new EmojiEditTextHelper(r5, false);
    }

    @Nullable
    public KeyListener getKeyListener(@Nullable KeyListener r5) {
        if (isEmojiCapableKeyListener(r5) == true) goto L5;
        return r5;
    L5:
        return this.mEmojiEditTextHelper.getKeyListener(r5);
    }

    public boolean isEmojiCapableKeyListener(KeyListener r5) {
        return !(r5 instanceof NumberKeyListener);
    }

    public boolean isEnabled() {
        return this.mEmojiEditTextHelper.isEnabled();
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

    @Nullable
    public InputConnection onCreateInputConnection(@Nullable InputConnection r5, @NonNull EditorInfo r10) {
        return this.mEmojiEditTextHelper.onCreateInputConnection(r5, r10);
    }

    public void setEnabled(boolean r5) {
        this.mEmojiEditTextHelper.setEnabled(r5);
    }
}
