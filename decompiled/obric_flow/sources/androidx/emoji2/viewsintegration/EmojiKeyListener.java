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

        public boolean handleKeyDown(@NonNull Editable r5, int r10, @NonNull KeyEvent r11) {
            return EmojiCompat.handleOnKeyDown(r5, r10, r11);
        }
    }

    public EmojiKeyListener(KeyListener r5) {
        this(r5, new EmojiCompatHandleKeyDownHelper());
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View r5, Editable r10, int r11) {
        this.mKeyListener.clearMetaKeyState(r5, r10, r11);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.mKeyListener.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View r5, Editable r10, int r11, KeyEvent r12) {
        if (this.mEmojiCompatHandleKeyDownHelper.handleKeyDown(r10, r11, r12) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mKeyListener.onKeyDown(r5, r10, r11, r12) == true) goto L8;
        return false;
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View r5, Editable r10, KeyEvent r11) {
        return this.mKeyListener.onKeyOther(r5, r10, r11);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View r5, Editable r10, int r11, KeyEvent r12) {
        return this.mKeyListener.onKeyUp(r5, r10, r11, r12);
    }

    public EmojiKeyListener(KeyListener r5, EmojiCompatHandleKeyDownHelper r10) {
        this.mKeyListener = r5;
        this.mEmojiCompatHandleKeyDownHelper = r10;
    }
}
