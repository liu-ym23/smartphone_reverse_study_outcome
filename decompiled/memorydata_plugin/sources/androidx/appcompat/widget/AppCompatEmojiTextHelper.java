package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class AppCompatEmojiTextHelper {
    private final EmojiTextViewHelper mEmojiTextViewHelper;
    private final TextView mView;

    AppCompatEmojiTextHelper(TextView r3) {
        this.mView = r3;
        this.mEmojiTextViewHelper = new EmojiTextViewHelper(r3, false);
    }

    InputFilter[] getFilters(InputFilter[] r1) {
        return this.mEmojiTextViewHelper.getFilters(r1);
    }

    public boolean isEnabled() {
        return this.mEmojiTextViewHelper.isEnabled();
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

    void setAllCaps(boolean r1) {
        this.mEmojiTextViewHelper.setAllCaps(r1);
    }

    void setEnabled(boolean r1) {
        this.mEmojiTextViewHelper.setEnabled(r1);
    }

    public TransformationMethod wrapTransformationMethod(TransformationMethod r3) {
        TransformationMethod r4 = (TransformationMethod) ZeusTransformUtils.wrapperContextForParams(r3, TransformationMethod.class, "com.obric.memorydata.plugin");
        return this.mEmojiTextViewHelper.wrapTransformationMethod(r4);
    }
}
