package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiKeyListener implements KeyListener {
    private final EmojiCompatHandleKeyDownHelper mEmojiCompatHandleKeyDownHelper;
    private final KeyListener mKeyListener;

    public static class EmojiCompatHandleKeyDownHelper {
        public EmojiCompatHandleKeyDownHelper() {
        }

        public boolean handleKeyDown(@NonNull Editable r10, int r11, @NonNull KeyEvent r12) {
            return EmojiCompat.handleOnKeyDown(r10, r11, r12);
        }
    }

    EmojiKeyListener(KeyListener r10) {
        this(r10, new EmojiCompatHandleKeyDownHelper());
    }

    EmojiKeyListener(KeyListener r10, EmojiCompatHandleKeyDownHelper r11) {
        this.mKeyListener = r10;
        this.mEmojiCompatHandleKeyDownHelper = r11;
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View r10, Editable r11, int r12) {
        this.mKeyListener.clearMetaKeyState(r10, r11, r12);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.mKeyListener.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View r10, Editable r11, int r12, KeyEvent r13) {
        if (this.mEmojiCompatHandleKeyDownHelper.handleKeyDown(r11, r12, r13) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mKeyListener.onKeyDown(r10, r11, r12, r13) == true) goto L8;
        return false;
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View r10, Editable r11, KeyEvent r12) {
        return this.mKeyListener.onKeyOther(r10, r11, r12);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View r10, Editable r11, int r12, KeyEvent r13) {
        return this.mKeyListener.onKeyUp(r10, r11, r12, r13);
    }
}
