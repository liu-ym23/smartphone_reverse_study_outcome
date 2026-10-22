package androidx.emoji2.viewsintegration;

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

    public static class HelperInternal {
        public HelperInternal() {
        }

        @Nullable
        public KeyListener getKeyListener(@Nullable KeyListener r5) {
            return r5;
        }

        public boolean isEnabled() {
            return false;
        }

        public InputConnection onCreateInputConnection(@NonNull InputConnection r5, @NonNull EditorInfo r10) {
            return r5;
        }

        public void setEmojiReplaceStrategy(int r5) {
        }

        public void setEnabled(boolean r5) {
        }

        public void setMaxEmojiCount(int r5) {
        }
    }

    @RequiresApi(19)
    public static class HelperInternal19 extends HelperInternal {
        private final EditText mEditText;
        private final EmojiTextWatcher mTextWatcher;

        public HelperInternal19(@NonNull EditText r5, boolean r10) {
            this.mEditText = r5;
            EmojiTextWatcher r11 = new EmojiTextWatcher(r5, r10);
            this.mTextWatcher = r11;
            r5.addTextChangedListener(r11);
            r5.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        public KeyListener getKeyListener(@Nullable KeyListener r5) {
            if ((r5 instanceof EmojiKeyListener) == false) goto L5;
            return r5;
        L5:
            if (r5 != null) goto L9;
            return null;
        L9:
            if ((r5 instanceof NumberKeyListener) == false) goto L12;
            return r5;
        L12:
            return new EmojiKeyListener(r5);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        public boolean isEnabled() {
            return this.mTextWatcher.isEnabled();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        public InputConnection onCreateInputConnection(@NonNull InputConnection r5, @NonNull EditorInfo r10) {
            if ((r5 instanceof EmojiInputConnection) == false) goto L6;
            return r5;
        L6:
            return new EmojiInputConnection(this.mEditText, r5, r10);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        public void setEmojiReplaceStrategy(int r5) {
            this.mTextWatcher.setEmojiReplaceStrategy(r5);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        public void setEnabled(boolean r5) {
            this.mTextWatcher.setEnabled(r5);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        public void setMaxEmojiCount(int r5) {
            this.mTextWatcher.setMaxEmojiCount(r5);
        }
    }

    public EmojiEditTextHelper(@NonNull EditText r5) {
        this(r5, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    @Nullable
    public KeyListener getKeyListener(@Nullable KeyListener r5) {
        return this.mHelper.getKeyListener(r5);
    }

    public int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    @Nullable
    public InputConnection onCreateInputConnection(@Nullable InputConnection r5, @NonNull EditorInfo r10) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return this.mHelper.onCreateInputConnection(r5, r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEmojiReplaceStrategy(int r5) {
        this.mEmojiReplaceStrategy = r5;
        this.mHelper.setEmojiReplaceStrategy(r5);
    }

    public void setEnabled(boolean r5) {
        this.mHelper.setEnabled(r5);
    }

    public void setMaxEmojiCount(@IntRange(from = 0) int r5) {
        Preconditions.checkArgumentNonnegative(r5, "maxEmojiCount should be greater than 0");
        this.mMaxEmojiCount = r5;
        this.mHelper.setMaxEmojiCount(r5);
    }

    public EmojiEditTextHelper(@NonNull EditText r5, boolean r10) {
        this.mMaxEmojiCount = Integer.MAX_VALUE;
        this.mEmojiReplaceStrategy = 0;
        Preconditions.checkNotNull(r5, "editText cannot be null");
        this.mHelper = new HelperInternal19(r5, r10);
    }
}
