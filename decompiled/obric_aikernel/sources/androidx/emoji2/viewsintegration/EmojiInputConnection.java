package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiInputConnection extends InputConnectionWrapper {
    private final EmojiCompatDeleteHelper mEmojiCompatDeleteHelper;
    private final TextView mTextView;

    public static class EmojiCompatDeleteHelper {
        public EmojiCompatDeleteHelper() {
        }

        public boolean handleDeleteSurroundingText(@NonNull InputConnection r10, @NonNull Editable r11, @IntRange(from = 0) int r12, @IntRange(from = 0) int r13, boolean r14) {
            return EmojiCompat.handleDeleteSurroundingText(r10, r11, r12, r13, r14);
        }

        public void updateEditorInfoAttrs(@NonNull EditorInfo r10) {
            if (EmojiCompat.isConfigured() == false) goto L6;
            EmojiCompat.get().updateEditorInfo(r10);
            return;
        }
    }

    EmojiInputConnection(@NonNull TextView r10, @NonNull InputConnection r11, @NonNull EditorInfo r12) {
        this(r10, r11, r12, new EmojiCompatDeleteHelper());
    }

    EmojiInputConnection(@NonNull TextView r10, @NonNull InputConnection r11, @NonNull EditorInfo r12, @NonNull EmojiCompatDeleteHelper r13) {
        super(r11, false);
        this.mTextView = r10;
        this.mEmojiCompatDeleteHelper = r13;
        r13.updateEditorInfoAttrs(r12);
    }

    private Editable getEditable() {
        return this.mTextView.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int r10, int r11) {
        if (this.mEmojiCompatDeleteHelper.handleDeleteSurroundingText(this, getEditable(), r10, r11, false) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.deleteSurroundingText(r10, r11) == true) goto L8;
        return false;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int r10, int r11) {
        if (this.mEmojiCompatDeleteHelper.handleDeleteSurroundingText(this, getEditable(), r10, r11, true) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.deleteSurroundingTextInCodePoints(r10, r11) == true) goto L8;
        return false;
    }
}
