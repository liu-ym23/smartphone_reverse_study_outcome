package androidx.emoji2.viewsintegration;

import android.os.Build;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiEditTextHelper {
    private int mEmojiReplaceStrategy;
    private final HelperInternal mHelper;
    private int mMaxEmojiCount;

    static class HelperInternal {
        HelperInternal() {
        }

        @Nullable
        KeyListener getKeyListener(@Nullable KeyListener r10) {
            return r10;
        }

        boolean isEnabled() {
            return false;
        }

        InputConnection onCreateInputConnection(@NonNull InputConnection r10, @NonNull EditorInfo r11) {
            return r10;
        }

        void setEmojiReplaceStrategy(int r10) {
        }

        void setEnabled(boolean r10) {
        }

        void setMaxEmojiCount(int r10) {
        }
    }

    @RequiresApi(19)
    private static class HelperInternal19 extends HelperInternal {
        private final EditText mEditText;
        private final EmojiTextWatcher mTextWatcher;

        HelperInternal19(@NonNull EditText r10, boolean r11) {
            this.mEditText = r10;
            EmojiTextWatcher r12 = new EmojiTextWatcher(r10, r11);
            this.mTextWatcher = r12;
            r10.addTextChangedListener(r12);
            r10.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        KeyListener getKeyListener(@Nullable KeyListener r10) {
            if ((r10 instanceof EmojiKeyListener) == false) goto L5;
            return r10;
        L5:
            if (r10 != null) goto L9;
            return null;
        L9:
            if ((r10 instanceof NumberKeyListener) == false) goto L12;
            return r10;
        L12:
            return new EmojiKeyListener(r10);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        boolean isEnabled() {
            return this.mTextWatcher.isEnabled();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        InputConnection onCreateInputConnection(@NonNull InputConnection r10, @NonNull EditorInfo r11) {
            if ((r10 instanceof EmojiInputConnection) == false) goto L6;
            return r10;
        L6:
            return new EmojiInputConnection(this.mEditText, r10, r11);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void setEmojiReplaceStrategy(int r10) {
            this.mTextWatcher.setEmojiReplaceStrategy(r10);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void setEnabled(boolean r10) {
            this.mTextWatcher.setEnabled(r10);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void setMaxEmojiCount(int r10) {
            this.mTextWatcher.setMaxEmojiCount(r10);
        }
    }

    public EmojiEditTextHelper(@NonNull EditText r10) {
        this(r10, true);
    }

    public EmojiEditTextHelper(@NonNull EditText r10, boolean r11) {
        this.mMaxEmojiCount = Integer.MAX_VALUE;
        this.mEmojiReplaceStrategy = 0;
        Preconditions.checkNotNull(r10, "editText cannot be null");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        this.mHelper = new HelperInternal();
        return;
    L5:
        this.mHelper = new HelperInternal19(r10, r11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    @Nullable
    public KeyListener getKeyListener(@Nullable KeyListener r10) {
        return this.mHelper.getKeyListener(r10);
    }

    public int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    @Nullable
    public InputConnection onCreateInputConnection(@Nullable InputConnection r10, @NonNull EditorInfo r11) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return this.mHelper.onCreateInputConnection(r10, r11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEmojiReplaceStrategy(int r10) {
        this.mEmojiReplaceStrategy = r10;
        this.mHelper.setEmojiReplaceStrategy(r10);
    }

    public void setEnabled(boolean r10) {
        this.mHelper.setEnabled(r10);
    }

    public void setMaxEmojiCount(@IntRange(from = 0) int r10) {
        Preconditions.checkArgumentNonnegative(r10, "maxEmojiCount should be greater than 0");
        this.mMaxEmojiCount = r10;
        this.mHelper.setMaxEmojiCount(r10);
    }
}
