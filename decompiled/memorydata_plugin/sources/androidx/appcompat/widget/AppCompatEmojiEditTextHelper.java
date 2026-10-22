package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class AppCompatEmojiEditTextHelper {
    private final EmojiEditTextHelper mEmojiEditTextHelper;
    private final EditText mView;

    AppCompatEmojiEditTextHelper(EditText r3) {
        this.mView = r3;
        this.mEmojiEditTextHelper = new EmojiEditTextHelper(r3, false);
    }

    KeyListener getKeyListener(KeyListener r3) {
        KeyListener r4 = (KeyListener) ZeusTransformUtils.wrapperContextForParams(r3, KeyListener.class, "com.obric.memorydata.plugin");
        if (isEmojiCapableKeyListener(r4) == true) goto L5;
        return r4;
    L5:
        return this.mEmojiEditTextHelper.getKeyListener(r4);
    }

    boolean isEmojiCapableKeyListener(KeyListener r2) {
        return !ZeusTransformUtils.instanceOf((KeyListener) ZeusTransformUtils.wrapperContextForParams(r2, KeyListener.class, "com.obric.memorydata.plugin"), NumberKeyListener.class);
    }

    boolean isEnabled() {
        return this.mEmojiEditTextHelper.isEnabled();
    }

    void loadFromAttributes(AttributeSet r6, int r7) {
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r8, R.styleable.AppCompatTextView, r7, 0);
        boolean r2 = true;
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_emojiCompatEnabled, "styleable", "AppCompatTextView_emojiCompatEnabled")) == false) goto L6;
        r2 = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_emojiCompatEnabled, "styleable", "AppCompatTextView_emojiCompatEnabled"), true);     // Catch: Throwable -> L8
    L6:
        r9.recycle();
        setEnabled(r2);
        return;
    L8:
        th = move-exception;
        r9.recycle();
        throw th;
    }

    InputConnection onCreateInputConnection(InputConnection r3, EditorInfo r4) {
        InputConnection r5 = (InputConnection) ZeusTransformUtils.wrapperContextForParams(r3, InputConnection.class, "com.obric.memorydata.plugin");
        return this.mEmojiEditTextHelper.onCreateInputConnection(r5, r4);
    }

    void setEnabled(boolean r1) {
        this.mEmojiEditTextHelper.setEnabled(r1);
    }
}
