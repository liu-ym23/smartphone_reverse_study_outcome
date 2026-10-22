package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiInputFilter implements InputFilter {
    private EmojiCompat.InitCallback mInitCallback;
    private final TextView mTextView;

    @RequiresApi(19)
    public static class InitCallbackImpl extends EmojiCompat.InitCallback {
        private final Reference<EmojiInputFilter> mEmojiInputFilterReference;
        private final Reference<TextView> mViewRef;

        public InitCallbackImpl(TextView r5, EmojiInputFilter r10) {
            this.mViewRef = new WeakReference(r5);
            this.mEmojiInputFilterReference = new WeakReference(r10);
        }

        private boolean isInputFilterCurrentlyRegisteredOnTextView(@Nullable TextView r5, @Nullable InputFilter r10) {
            if (r10 == null) goto L17;
            if (r5 == null) goto L17;
            InputFilter[] r11 = r5.getFilters();
            if (r11 != null) goto L9;
            return false;
        L9:
            int r12 = 0;
        L11:
            if (r12 >= r11.length) goto L17;
            if (r11[r12] == r10) goto L14;
            r12 = r12 + 1;
            goto L11
        L14:
            return true;
        L17:
            return false;
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void onInitialized() {
            super.onInitialized();
            TextView r5 = this.mViewRef.get();
            if (isInputFilterCurrentlyRegisteredOnTextView(r5, this.mEmojiInputFilterReference.get()) == true) goto L6;
            return;
        L6:
            if (r5.isAttachedToWindow() == false) goto L14;
            CharSequence r10 = r5.getText();
            CharSequence r11 = EmojiCompat.get().process(r10);
            if (r10 != r11) goto L10;
            return;
        L10:
            int r12 = Selection.getSelectionStart(r11);
            int r13 = Selection.getSelectionEnd(r11);
            r5.setText(r11);
            if ((r11 instanceof Spannable) == false) goto L15;
            EmojiInputFilter.updateSelection((Spannable) r11, r12, r13);
            return;
        L15:
            return;
        }
    }

    public EmojiInputFilter(@NonNull TextView r5) {
        this.mTextView = r5;
    }

    private EmojiCompat.InitCallback getInitCallback() {
        if (this.mInitCallback != null) goto L6;
        this.mInitCallback = new InitCallbackImpl(this.mTextView, this);
    L6:
        return this.mInitCallback;
    }

    public static void updateSelection(Spannable r5, int r10, int r11) {
        if (r10 < 0) goto L5;
        if (r11 < 0) goto L5;
        Selection.setSelection(r5, r10, r11);
        return;
    L5:
        if (r10 < 0) goto L7;
        Selection.setSelection(r5, r10);
        return;
    L7:
        if (r11 < 0) goto L12;
        Selection.setSelection(r5, r11);
        return;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r5, int r10, int r11, Spanned r12, int r13, int r14) {
        if (this.mTextView.isInEditMode() == false) goto L5;
        return r5;
    L5:
        int r15 = EmojiCompat.get().getLoadState();
        if (r15 != 0) goto L8;
    L28:
        EmojiCompat.get().registerInitCallback(getInitCallback());
        return r5;
    L8:
        if (r15 != 1) goto L10;
        if (r14 != 0) goto L19;
        if (r13 != 0) goto L19;
        if (r12.length() != 0) goto L19;
        if (r5 != this.mTextView.getText()) goto L19;
    L27:
        return r5;
    L19:
        if (r5 == null) goto L27;
        if (r10 == 0) goto L22;
    L24:
        r5 = r5.subSequence(r10, r11);
    L26:
        return EmojiCompat.get().process(r5, 0, r5.length());
    L22:
        if (r11 != r5.length()) goto L24;
    L10:
        if (r15 == 3) goto L28;
        return r5;
    }
}
