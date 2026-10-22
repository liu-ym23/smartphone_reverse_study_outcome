package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiTextWatcher implements TextWatcher {
    private final EditText mEditText;
    private int mEmojiReplaceStrategy;
    private boolean mEnabled;
    private final boolean mExpectInitializedEmojiCompat;
    private EmojiCompat.InitCallback mInitCallback;
    private int mMaxEmojiCount;

    @RequiresApi(19)
    private static class InitCallbackImpl extends EmojiCompat.InitCallback {
        private final Reference<EditText> mViewRef;

        InitCallbackImpl(EditText r10) {
            this.mViewRef = new WeakReference(r10);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void onInitialized() {
            super.onInitialized();
            EmojiTextWatcher.processTextOnEnablingEvent(this.mViewRef.get(), 1);
        }
    }

    EmojiTextWatcher(EditText r10, boolean r11) {
        this.mMaxEmojiCount = Integer.MAX_VALUE;
        this.mEmojiReplaceStrategy = 0;
        this.mEditText = r10;
        this.mExpectInitializedEmojiCompat = r11;
        this.mEnabled = true;
    }

    private EmojiCompat.InitCallback getInitCallback() {
        if (this.mInitCallback != null) goto L6;
        this.mInitCallback = new InitCallbackImpl(this.mEditText);
    L6:
        return this.mInitCallback;
    }

    static void processTextOnEnablingEvent(@Nullable EditText r10, int r11) {
        if (r11 != 1) goto L9;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.isAttachedToWindow() == false) goto L11;
        Editable r12 = r10.getEditableText();
        int r13 = Selection.getSelectionStart(r12);
        int r14 = Selection.getSelectionEnd(r12);
        EmojiCompat.get().process(r12);
        EmojiInputFilter.updateSelection(r12, r13, r14);
        return;
    L11:
        return;
    }

    private boolean shouldSkipForDisabledOrNotConfigured() {
        if (this.mEnabled == true) goto L5;
    L10:
        return true;
    L5:
        if (this.mExpectInitializedEmojiCompat == false) goto L7;
    L9:
        return false;
    L7:
        if (EmojiCompat.isConfigured() == true) goto L9;
        goto L9
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r10) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
    }

    int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        if (this.mEditText.isInEditMode() == false) goto L5;
        return;
    L5:
        if (shouldSkipForDisabledOrNotConfigured() == true) goto L24;
        if (r12 <= r13) goto L9;
        return;
    L9:
        if ((r10 instanceof Spannable) == false) goto L22;
        int r14 = EmojiCompat.get().getLoadState();
        if (r14 != 0) goto L13;
    L18:
        EmojiCompat.get().registerInitCallback(getInitCallback());
        return;
    L13:
        if (r14 != 1) goto L15;
        EmojiCompat r15 = EmojiCompat.get();
        r15.process((Spannable) r10, r11, r11 + r13, this.mMaxEmojiCount, this.mEmojiReplaceStrategy);
        return;
    L15:
        if (r14 == 3) goto L18;
        return;
    L22:
        return;
    }

    void setEmojiReplaceStrategy(int r10) {
        this.mEmojiReplaceStrategy = r10;
    }

    public void setEnabled(boolean r10) {
        if (this.mEnabled != r10) goto L5;
        return;
    L5:
        if (this.mInitCallback == null) goto L7;
        EmojiCompat.get().unregisterInitCallback(this.mInitCallback);
    L7:
        this.mEnabled = r10;
        if (r10 == false) goto L12;
        processTextOnEnablingEvent(this.mEditText, EmojiCompat.get().getLoadState());
        return;
    }

    void setMaxEmojiCount(int r10) {
        this.mMaxEmojiCount = r10;
    }
}
