package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class EmojiInputConnection extends InputConnectionWrapper {
    private final EmojiCompatDeleteHelper mEmojiCompatDeleteHelper;
    private final TextView mTextView;

    public static class EmojiCompatDeleteHelper {
        public EmojiCompatDeleteHelper() {
        }

        public boolean handleDeleteSurroundingText(InputConnection r2, Editable r3, int r4, int r5, boolean r6) {
            return EmojiCompat.handleDeleteSurroundingText((InputConnection) ZeusTransformUtils.wrapperContextForParams(r2, InputConnection.class, "com.obric.memorydata.plugin"), (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.memorydata.plugin"), r4, r5, r6);
        }

        public void updateEditorInfoAttrs(EditorInfo r1) {
            if (EmojiCompat.isConfigured() == false) goto L6;
            EmojiCompat.get().updateEditorInfo(r1);
            return;
        }
    }

    EmojiInputConnection(TextView r3, InputConnection r4, EditorInfo r5) {
        this(r3, (InputConnection) ZeusTransformUtils.wrapperContextForParams(r4, InputConnection.class, "com.obric.memorydata.plugin"), r5, new EmojiCompatDeleteHelper());
    }

    EmojiInputConnection(TextView r3, InputConnection r4, EditorInfo r5, EmojiCompatDeleteHelper r6) {
        super((InputConnection) ZeusTransformUtils.wrapperContextForParams(r4, InputConnection.class, "com.obric.memorydata.plugin"), false);
        this.mTextView = r3;
        this.mEmojiCompatDeleteHelper = r6;
        r6.updateEditorInfoAttrs(r5);
    }

    private Editable getEditable() {
        return this.mTextView.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int r7, int r8) {
        if (this.mEmojiCompatDeleteHelper.handleDeleteSurroundingText(this, getEditable(), r7, r8, false) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.deleteSurroundingText(r7, r8) == true) goto L8;
        return false;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int r7, int r8) {
        if (this.mEmojiCompatDeleteHelper.handleDeleteSurroundingText(this, getEditable(), r7, r8, true) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.deleteSurroundingTextInCodePoints(r7, r8) == true) goto L8;
        return false;
    }
}
