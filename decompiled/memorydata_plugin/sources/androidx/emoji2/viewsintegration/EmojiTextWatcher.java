package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class EmojiTextWatcher implements TextWatcher {
    private final EditText mEditText;
    private int mEmojiReplaceStrategy;
    private boolean mEnabled;
    private final boolean mExpectInitializedEmojiCompat;
    private EmojiCompat.InitCallback mInitCallback;
    private int mMaxEmojiCount;

    private static class InitCallbackImpl extends EmojiCompat.InitCallback {
        private final Reference<EditText> mViewRef;

        InitCallbackImpl(EditText r2) {
            this.mViewRef = new WeakReference(r2);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void onInitialized() {
            super.onInitialized();
            EmojiTextWatcher.processTextOnEnablingEvent((EditText) ZeusTransformUtils.preCheckCast(this.mViewRef.get(), EditText.class, "com.obric.memorydata.plugin"), 1);
        }
    }

    EmojiTextWatcher(EditText r2, boolean r3) {
        this.mMaxEmojiCount = Integer.MAX_VALUE;
        this.mEmojiReplaceStrategy = 0;
        this.mEditText = r2;
        this.mExpectInitializedEmojiCompat = r3;
        this.mEnabled = true;
    }

    private EmojiCompat.InitCallback getInitCallback() {
        if (this.mInitCallback != null) goto L6;
        this.mInitCallback = new InitCallbackImpl(this.mEditText);
    L6:
        return this.mInitCallback;
    }

    static void processTextOnEnablingEvent(EditText r2, int r3) {
        if (r3 != 1) goto L9;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.isAttachedToWindow() == false) goto L11;
        Editable r4 = r2.getEditableText();
        int r5 = Selection.getSelectionStart(r4);
        int r0 = Selection.getSelectionEnd(r4);
        EmojiCompat.get().process(r4);
        EmojiInputFilter.updateSelection(r4, r5, r0);
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
    public void afterTextChanged(Editable r2) {
        Editable r1 = (Editable) ZeusTransformUtils.wrapperContextForParams(r2, Editable.class, "com.obric.memorydata.plugin");
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
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
    public void onTextChanged(CharSequence r7, int r8, int r9, int r10) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.mEditText.isInEditMode() == false) goto L5;
        return;
    L5:
        if (shouldSkipForDisabledOrNotConfigured() == true) goto L24;
        if (r9 <= r10) goto L9;
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r11, Spannable.class) == false) goto L22;
        int r12 = EmojiCompat.get().getLoadState();
        if (r12 != 0) goto L13;
    L18:
        EmojiCompat.get().registerInitCallback(getInitCallback());
        return;
    L13:
        if (r12 != 1) goto L15;
        Spannable r1 = (Spannable) ZeusTransformUtils.preCheckCast(r11, Spannable.class, "com.obric.memorydata.plugin");
        EmojiCompat.get().process(r1, r8, r8 + r10, this.mMaxEmojiCount, this.mEmojiReplaceStrategy);
        return;
    L15:
        if (r12 == 3) goto L18;
        return;
    L22:
        return;
    }

    void setEmojiReplaceStrategy(int r1) {
        this.mEmojiReplaceStrategy = r1;
    }

    public void setEnabled(boolean r3) {
        if (this.mEnabled != r3) goto L5;
        return;
    L5:
        if (this.mInitCallback == null) goto L7;
        EmojiCompat.get().unregisterInitCallback(this.mInitCallback);
    L7:
        this.mEnabled = r3;
        if (r3 == false) goto L12;
        processTextOnEnablingEvent(this.mEditText, EmojiCompat.get().getLoadState());
        return;
    }

    void setMaxEmojiCount(int r1) {
        this.mMaxEmojiCount = r1;
    }
}
