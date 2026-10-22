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

        public boolean handleDeleteSurroundingText(@NonNull InputConnection r5, @NonNull Editable r10, @IntRange(from = 0) int r11, @IntRange(from = 0) int r12, boolean r13) {
            return EmojiCompat.handleDeleteSurroundingText(r5, r10, r11, r12, r13);
        }

        public void updateEditorInfoAttrs(@NonNull EditorInfo r5) {
            if (EmojiCompat.isConfigured() == false) goto L6;
            EmojiCompat.get().updateEditorInfo(r5);
            return;
        }
    }

    public EmojiInputConnection(@NonNull TextView r5, @NonNull InputConnection r10, @NonNull EditorInfo r11) {
        this(r5, r10, r11, new EmojiCompatDeleteHelper());
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

    public EmojiInputConnection(@NonNull TextView r5, @NonNull InputConnection r10, @NonNull EditorInfo r11, @NonNull EmojiCompatDeleteHelper r12) {
        super(r10, false);
        this.mTextView = r5;
        this.mEmojiCompatDeleteHelper = r12;
        r12.updateEditorInfoAttrs(r11);
    }
}
