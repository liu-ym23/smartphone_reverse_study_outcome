package androidx.emoji2.viewsintegration;

import android.os.Build;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiEditTextHelper {
    private int mEmojiReplaceStrategy;
    private final HelperInternal mHelper;
    private int mMaxEmojiCount;

    static class HelperInternal {
        HelperInternal() {
        }

        KeyListener getKeyListener(KeyListener r2) {
            return (KeyListener) ZeusTransformUtils.wrapperContextForParams(r2, KeyListener.class, "com.obric.memorydata.plugin");
        }

        boolean isEnabled() {
            return false;
        }

        InputConnection onCreateInputConnection(InputConnection r1, EditorInfo r2) {
            return (InputConnection) ZeusTransformUtils.wrapperContextForParams(r1, InputConnection.class, "com.obric.memorydata.plugin");
        }

        void setEmojiReplaceStrategy(int r1) {
        }

        void setEnabled(boolean r1) {
        }

        void setMaxEmojiCount(int r1) {
        }
    }

    private static class HelperInternal19 extends HelperInternal {
        private final EditText mEditText;
        private final EmojiTextWatcher mTextWatcher;

        HelperInternal19(EditText r2, boolean r3) {
            this.mEditText = r2;
            EmojiTextWatcher r0 = new EmojiTextWatcher(r2, r3);
            this.mTextWatcher = r0;
            r2.addTextChangedListener(r0);
            r2.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        KeyListener getKeyListener(KeyListener r2) {
            KeyListener r1 = (KeyListener) ZeusTransformUtils.wrapperContextForParams(r2, KeyListener.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r1, EmojiKeyListener.class) == false) goto L5;
            return r1;
        L5:
            if (r1 != null) goto L9;
            return null;
        L9:
            if (ZeusTransformUtils.instanceOf(r1, NumberKeyListener.class) == false) goto L12;
            return r1;
        L12:
            return new EmojiKeyListener(r1);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        boolean isEnabled() {
            return this.mTextWatcher.isEnabled();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        InputConnection onCreateInputConnection(InputConnection r3, EditorInfo r4) {
            InputConnection r5 = (InputConnection) ZeusTransformUtils.wrapperContextForParams(r3, InputConnection.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r5, EmojiInputConnection.class) == false) goto L6;
            return r5;
        L6:
            return new EmojiInputConnection(this.mEditText, r5, r4);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void setEmojiReplaceStrategy(int r1) {
            this.mTextWatcher.setEmojiReplaceStrategy(r1);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void setEnabled(boolean r1) {
            this.mTextWatcher.setEnabled(r1);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void setMaxEmojiCount(int r1) {
            this.mTextWatcher.setMaxEmojiCount(r1);
        }
    }

    public EmojiEditTextHelper(EditText r2) {
        this(r2, true);
    }

    public EmojiEditTextHelper(EditText r3, boolean r4) {
        this.mMaxEmojiCount = Integer.MAX_VALUE;
        this.mEmojiReplaceStrategy = 0;
        Preconditions.checkNotNull(r3, "editText cannot be null");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        this.mHelper = new HelperInternal();
        return;
    L5:
        this.mHelper = new HelperInternal19(r3, r4);
    }

    public int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    public KeyListener getKeyListener(KeyListener r3) {
        KeyListener r4 = (KeyListener) ZeusTransformUtils.wrapperContextForParams(r3, KeyListener.class, "com.obric.memorydata.plugin");
        return this.mHelper.getKeyListener(r4);
    }

    public int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    public InputConnection onCreateInputConnection(InputConnection r3, EditorInfo r4) {
        InputConnection r5 = (InputConnection) ZeusTransformUtils.wrapperContextForParams(r3, InputConnection.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L7;
        return null;
    L7:
        return this.mHelper.onCreateInputConnection(r5, r4);
    }

    public void setEmojiReplaceStrategy(int r1) {
        this.mEmojiReplaceStrategy = r1;
        this.mHelper.setEmojiReplaceStrategy(r1);
    }

    public void setEnabled(boolean r1) {
        this.mHelper.setEnabled(r1);
    }

    public void setMaxEmojiCount(int r2) {
        Preconditions.checkArgumentNonnegative(r2, "maxEmojiCount should be greater than 0");
        this.mMaxEmojiCount = r2;
        this.mHelper.setMaxEmojiCount(r2);
    }
}
