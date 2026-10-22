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
    private static class InitCallbackImpl extends EmojiCompat.InitCallback {
        private final Reference<EmojiInputFilter> mEmojiInputFilterReference;
        private final Reference<TextView> mViewRef;

        InitCallbackImpl(TextView r10, EmojiInputFilter r11) {
            this.mViewRef = new WeakReference(r10);
            this.mEmojiInputFilterReference = new WeakReference(r11);
        }

        private boolean isInputFilterCurrentlyRegisteredOnTextView(@Nullable TextView r10, @Nullable InputFilter r11) {
            if (r11 == null) goto L17;
            if (r10 == null) goto L17;
            InputFilter[] r12 = r10.getFilters();
            if (r12 != null) goto L9;
            return false;
        L9:
            int r13 = 0;
        L11:
            if (r13 >= r12.length) goto L17;
            if (r12[r13] == r11) goto L14;
            r13 = r13 + 1;
            goto L11
        L14:
            return true;
        L17:
            return false;
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void onInitialized() {
            super.onInitialized();
            TextView r10 = this.mViewRef.get();
            if (isInputFilterCurrentlyRegisteredOnTextView(r10, this.mEmojiInputFilterReference.get()) == true) goto L6;
            return;
        L6:
            if (r10.isAttachedToWindow() == false) goto L14;
            CharSequence r11 = r10.getText();
            CharSequence r12 = EmojiCompat.get().process(r11);
            if (r11 != r12) goto L10;
            return;
        L10:
            int r13 = Selection.getSelectionStart(r12);
            int r14 = Selection.getSelectionEnd(r12);
            r10.setText(r12);
            if ((r12 instanceof Spannable) == false) goto L15;
            EmojiInputFilter.updateSelection((Spannable) r12, r13, r14);
            return;
        L15:
            return;
        }
    }

    EmojiInputFilter(@NonNull TextView r10) {
        this.mTextView = r10;
    }

    private EmojiCompat.InitCallback getInitCallback() {
        if (this.mInitCallback != null) goto L6;
        this.mInitCallback = new InitCallbackImpl(this.mTextView, this);
    L6:
        return this.mInitCallback;
    }

    static void updateSelection(Spannable r10, int r11, int r12) {
        if (r11 < 0) goto L5;
        if (r12 < 0) goto L5;
        Selection.setSelection(r10, r11, r12);
        return;
    L5:
        if (r11 < 0) goto L7;
        Selection.setSelection(r10, r11);
        return;
    L7:
        if (r12 < 0) goto L12;
        Selection.setSelection(r10, r12);
        return;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r10, int r11, int r12, Spanned r13, int r14, int r15) {
        if (this.mTextView.isInEditMode() == false) goto L5;
        return r10;
    L5:
        int r16 = EmojiCompat.get().getLoadState();
        if (r16 == 0) goto L30;
        boolean r17 = true;
        if (r16 == 1) goto L13;
        if (r16 == 3) goto L30;
        return r10;
    L13:
        if (r15 != 0) goto L20;
        if (r14 != 0) goto L20;
        if (r13.length() != 0) goto L20;
        if (r10 != this.mTextView.getText()) goto L20;
        r17 = false;
    L20:
        if (r17 == false) goto L29;
        if (r10 == null) goto L29;
        if (r11 == 0) goto L24;
    L26:
        r10 = r10.subSequence(r11, r12);
    L28:
        return EmojiCompat.get().process(r10, 0, r10.length());
    L24:
        if (r12 != r10.length()) goto L26;
    L29:
        return r10;
    L30:
        EmojiCompat.get().registerInitCallback(getInitCallback());
        return r10;
    }
}
