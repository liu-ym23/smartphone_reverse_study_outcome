package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class EmojiInputFilter implements InputFilter {
    private EmojiCompat.InitCallback mInitCallback;
    private final TextView mTextView;

    private static class InitCallbackImpl extends EmojiCompat.InitCallback {
        private final Reference<EmojiInputFilter> mEmojiInputFilterReference;
        private final Reference<TextView> mViewRef;

        InitCallbackImpl(TextView r2, EmojiInputFilter r3) {
            this.mViewRef = new WeakReference(r2);
            this.mEmojiInputFilterReference = new WeakReference(r3);
        }

        private boolean isInputFilterCurrentlyRegisteredOnTextView(TextView r3, InputFilter r4) {
            InputFilter r2 = (InputFilter) ZeusTransformUtils.wrapperContextForParams(r4, InputFilter.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L17;
            if (r3 == null) goto L17;
            InputFilter[] r5 = r3.getFilters();
            if (r5 != null) goto L9;
            return false;
        L9:
            int r0 = 0;
        L11:
            if (r0 >= r5.length) goto L17;
            if (r5[r0] == r2) goto L14;
            r0 = r0 + 1;
            goto L11
        L14:
            return true;
        L17:
            return false;
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void onInitialized() {
            super.onInitialized();
            TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(this.mViewRef.get(), TextView.class, "com.obric.memorydata.plugin");
            if (isInputFilterCurrentlyRegisteredOnTextView(r0, (InputFilter) ZeusTransformUtils.preCheckCast(this.mEmojiInputFilterReference.get(), InputFilter.class, "com.obric.memorydata.plugin")) == true) goto L6;
            return;
        L6:
            if (r0.isAttachedToWindow() == false) goto L14;
            CharSequence r4 = r0.getText();
            CharSequence r1 = EmojiCompat.get().process(r4);
            if (r4 != r1) goto L10;
            return;
        L10:
            int r5 = Selection.getSelectionStart(r1);
            int r3 = Selection.getSelectionEnd(r1);
            r0.setText(r1);
            if (ZeusTransformUtils.instanceOf(r1, Spannable.class) == false) goto L15;
            EmojiInputFilter.updateSelection((Spannable) ZeusTransformUtils.preCheckCast(r1, Spannable.class, "com.obric.memorydata.plugin"), r5, r3);
            return;
        L15:
            return;
        }
    }

    EmojiInputFilter(TextView r1) {
        this.mTextView = r1;
    }

    private EmojiCompat.InitCallback getInitCallback() {
        if (this.mInitCallback != null) goto L6;
        this.mInitCallback = new InitCallbackImpl(this.mTextView, this);
    L6:
        return this.mInitCallback;
    }

    static void updateSelection(Spannable r2, int r3, int r4) {
        Spannable r5 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r2, Spannable.class, "com.obric.memorydata.plugin");
        if (r3 < 0) goto L6;
        if (r4 < 0) goto L6;
        Selection.setSelection(r5, r3, r4);
        return;
    L6:
        if (r3 < 0) goto L8;
        Selection.setSelection(r5, r3);
        return;
    L8:
        if (r4 < 0) goto L13;
        Selection.setSelection(r5, r4);
        return;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r3, int r4, int r5, Spanned r6, int r7, int r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Spanned r10 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r6, Spanned.class, "com.obric.memorydata.plugin");
        if (this.mTextView.isInEditMode() == false) goto L5;
        return r9;
    L5:
        int r0 = EmojiCompat.get().getLoadState();
        if (r0 == 0) goto L30;
        boolean r1 = true;
        if (r0 == 1) goto L13;
        if (r0 == 3) goto L30;
        return r9;
    L13:
        if (r8 != 0) goto L20;
        if (r7 != 0) goto L20;
        if (r10.length() != 0) goto L20;
        if (r9 != this.mTextView.getText()) goto L20;
        r1 = false;
    L20:
        if (r1 == false) goto L29;
        if (r9 == null) goto L29;
        if (r4 == 0) goto L24;
    L26:
        r9 = r9.subSequence(r4, r5);
    L28:
        return EmojiCompat.get().process(r9, 0, r9.length());
    L24:
        if (r5 != r9.length()) goto L26;
    L29:
        return r9;
    L30:
        EmojiCompat.get().registerInitCallback(getInitCallback());
        return r9;
    }
}
