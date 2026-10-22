package androidx.emoji2.viewsintegration;

import android.os.Build;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiTextViewHelper {
    private final HelperInternal mHelper;

    static class HelperInternal {
        HelperInternal() {
        }

        @NonNull
        InputFilter[] getFilters(@NonNull InputFilter[] r10) {
            return r10;
        }

        public boolean isEnabled() {
            return false;
        }

        void setAllCaps(boolean r10) {
        }

        void setEnabled(boolean r10) {
        }

        void updateTransformationMethod() {
        }

        @Nullable
        TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod r10) {
            return r10;
        }
    }

    @RequiresApi(19)
    private static class HelperInternal19 extends HelperInternal {
        private final EmojiInputFilter mEmojiInputFilter;
        private boolean mEnabled;
        private final TextView mTextView;

        HelperInternal19(TextView r10) {
            this.mTextView = r10;
            this.mEnabled = true;
            this.mEmojiInputFilter = new EmojiInputFilter(r10);
        }

        @NonNull
        private InputFilter[] addEmojiInputFilterIfMissing(@NonNull InputFilter[] r10) {
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L8;
            if (r10[r12] == this.mEmojiInputFilter) goto L6;
            r12 = r12 + 1;
            goto L3
        L6:
            return r10;
        L8:
            InputFilter[] r13 = new InputFilter[r10.length + 1];
            System.arraycopy(r10, 0, r13, 0, r11);
            r13[r11] = this.mEmojiInputFilter;
            return r13;
        }

        private SparseArray<InputFilter> getEmojiInputFilterPositionArray(@NonNull InputFilter[] r10) {
            SparseArray<InputFilter> r11 = new SparseArray(1);
            int r12 = 0;
        L4:
            if (r12 >= r10.length) goto L9;
            if ((r10[r12] instanceof EmojiInputFilter) == false) goto L8;
            r11.put(r12, r10[r12]);
        L8:
            r12 = r12 + 1;
            goto L4
        L9:
            return r11;
        }

        @NonNull
        private InputFilter[] removeEmojiInputFilterIfPresent(@NonNull InputFilter[] r10) {
            SparseArray<InputFilter> r11 = getEmojiInputFilterPositionArray(r10);
            if (r11.size() != 0) goto L5;
            return r10;
        L5:
            int r12 = r10.length;
            InputFilter[] r13 = new InputFilter[r10.length - r11.size()];
            int r14 = 0;
            int r15 = 0;
        L6:
            if (r14 >= r12) goto L11;
            if (r11.indexOfKey(r14) >= 0) goto L10;
            r13[r15] = r10[r14];
            r15 = r15 + 1;
        L10:
            r14 = r14 + 1;
            goto L6
        L11:
            return r13;
        }

        @Nullable
        private TransformationMethod unwrapForDisabled(@Nullable TransformationMethod r10) {
            if ((r10 instanceof EmojiTransformationMethod) == true) goto L5;
            return r10;
        L5:
            return ((EmojiTransformationMethod) r10).getOriginalTransformationMethod();
        }

        private void updateFilters() {
            InputFilter[] r10 = this.mTextView.getFilters();
            this.mTextView.setFilters(getFilters(r10));
        }

        @NonNull
        private TransformationMethod wrapForEnabled(@Nullable TransformationMethod r10) {
            if ((r10 instanceof EmojiTransformationMethod) == false) goto L6;
            return r10;
        L6:
            if ((r10 instanceof PasswordTransformationMethod) == false) goto L9;
            return r10;
        L9:
            return new EmojiTransformationMethod(r10);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @NonNull
        InputFilter[] getFilters(@NonNull InputFilter[] r10) {
            if (this.mEnabled == true) goto L7;
            return removeEmojiInputFilterIfPresent(r10);
        L7:
            return addEmojiInputFilterIfMissing(r10);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public boolean isEnabled() {
            return this.mEnabled;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void setAllCaps(boolean r10) {
            if (r10 == false) goto L5;
            updateTransformationMethod();
            return;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void setEnabled(boolean r10) {
            this.mEnabled = r10;
            updateTransformationMethod();
            updateFilters();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        void setEnabledUnsafe(boolean r10) {
            this.mEnabled = r10;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void updateTransformationMethod() {
            TransformationMethod r10 = wrapTransformationMethod(this.mTextView.getTransformationMethod());
            this.mTextView.setTransformationMethod(r10);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @Nullable
        TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod r10) {
            if (this.mEnabled == false) goto L7;
            return wrapForEnabled(r10);
        L7:
            return unwrapForDisabled(r10);
        }
    }

    @RequiresApi(19)
    private static class SkippingHelper19 extends HelperInternal {
        private final HelperInternal19 mHelperDelegate;

        SkippingHelper19(TextView r10) {
            this.mHelperDelegate = new HelperInternal19(r10);
        }

        private boolean skipBecauseEmojiCompatNotInitialized() {
            return !EmojiCompat.isConfigured();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @NonNull
        InputFilter[] getFilters(@NonNull InputFilter[] r10) {
            if (skipBecauseEmojiCompatNotInitialized() == false) goto L6;
            return r10;
        L6:
            return this.mHelperDelegate.getFilters(r10);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public boolean isEnabled() {
            return this.mHelperDelegate.isEnabled();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void setAllCaps(boolean r10) {
            if (skipBecauseEmojiCompatNotInitialized() == false) goto L5;
            return;
        L5:
            this.mHelperDelegate.setAllCaps(r10);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void setEnabled(boolean r10) {
            boolean r11 = skipBecauseEmojiCompatNotInitialized();
            HelperInternal19 r12 = this.mHelperDelegate;
            if (r11 == false) goto L5;
            r12.setEnabledUnsafe(r10);
            return;
        L5:
            r12.setEnabled(r10);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void updateTransformationMethod() {
            if (skipBecauseEmojiCompatNotInitialized() == false) goto L5;
            return;
        L5:
            this.mHelperDelegate.updateTransformationMethod();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @Nullable
        TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod r10) {
            if (skipBecauseEmojiCompatNotInitialized() == false) goto L6;
            return r10;
        L6:
            return this.mHelperDelegate.wrapTransformationMethod(r10);
        }
    }

    public EmojiTextViewHelper(@NonNull TextView r10) {
        this(r10, true);
    }

    public EmojiTextViewHelper(@NonNull TextView r10, boolean r11) {
        Preconditions.checkNotNull(r10, "textView cannot be null");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        this.mHelper = new HelperInternal();
        return;
    L5:
        if (r11 == true) goto L7;
        HelperInternal r12 = new SkippingHelper19(r10);
    L8:
        this.mHelper = r12;
        return;
    L7:
        r12 = new HelperInternal19(r10);
        goto L8
    }

    @NonNull
    public InputFilter[] getFilters(@NonNull InputFilter[] r10) {
        return this.mHelper.getFilters(r10);
    }

    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    public void setAllCaps(boolean r10) {
        this.mHelper.setAllCaps(r10);
    }

    public void setEnabled(boolean r10) {
        this.mHelper.setEnabled(r10);
    }

    public void updateTransformationMethod() {
        this.mHelper.updateTransformationMethod();
    }

    @Nullable
    public TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod r10) {
        return this.mHelper.wrapTransformationMethod(r10);
    }
}
