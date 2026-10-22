package androidx.emoji2.viewsintegration;

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

    public static class HelperInternal {
        public HelperInternal() {
        }

        @NonNull
        public InputFilter[] getFilters(@NonNull InputFilter[] r5) {
            return r5;
        }

        public boolean isEnabled() {
            return false;
        }

        public void setAllCaps(boolean r5) {
        }

        public void setEnabled(boolean r5) {
        }

        public void updateTransformationMethod() {
        }

        @Nullable
        public TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod r5) {
            return r5;
        }
    }

    @RequiresApi(19)
    public static class HelperInternal19 extends HelperInternal {
        private final EmojiInputFilter mEmojiInputFilter;
        private boolean mEnabled;
        private final TextView mTextView;

        public HelperInternal19(TextView r5) {
            this.mTextView = r5;
            this.mEnabled = true;
            this.mEmojiInputFilter = new EmojiInputFilter(r5);
        }

        @NonNull
        private InputFilter[] addEmojiInputFilterIfMissing(@NonNull InputFilter[] r10) {
            int r5 = r10.length;
            int r11 = 0;
        L3:
            if (r11 >= r5) goto L8;
            if (r10[r11] == this.mEmojiInputFilter) goto L6;
            r11 = r11 + 1;
            goto L3
        L6:
            return r10;
        L8:
            InputFilter[] r12 = new InputFilter[r10.length + 1];
            System.arraycopy(r10, 0, r12, 0, r5);
            r12[r5] = this.mEmojiInputFilter;
            return r12;
        }

        private SparseArray<InputFilter> getEmojiInputFilterPositionArray(@NonNull InputFilter[] r5) {
            SparseArray<InputFilter> r10 = new SparseArray(1);
            int r11 = 0;
        L4:
            if (r11 >= r5.length) goto L9;
            InputFilter r12 = r5[r11];
            if ((r12 instanceof EmojiInputFilter) == false) goto L8;
            r10.put(r11, r12);
        L8:
            r11 = r11 + 1;
            goto L4
        L9:
            return r10;
        }

        @NonNull
        private InputFilter[] removeEmojiInputFilterIfPresent(@NonNull InputFilter[] r10) {
            SparseArray<InputFilter> r5 = getEmojiInputFilterPositionArray(r10);
            if (r5.size() != 0) goto L5;
            return r10;
        L5:
            int r11 = r10.length;
            InputFilter[] r12 = new InputFilter[r10.length - r5.size()];
            int r13 = 0;
            int r14 = 0;
        L6:
            if (r13 >= r11) goto L11;
            if (r5.indexOfKey(r13) >= 0) goto L10;
            r12[r14] = r10[r13];
            r14 = r14 + 1;
        L10:
            r13 = r13 + 1;
            goto L6
        L11:
            return r12;
        }

        @Nullable
        private TransformationMethod unwrapForDisabled(@Nullable TransformationMethod r5) {
            if ((r5 instanceof EmojiTransformationMethod) == true) goto L5;
            return r5;
        L5:
            return ((EmojiTransformationMethod) r5).getOriginalTransformationMethod();
        }

        private void updateFilters() {
            InputFilter[] r5 = this.mTextView.getFilters();
            this.mTextView.setFilters(getFilters(r5));
        }

        @NonNull
        private TransformationMethod wrapForEnabled(@Nullable TransformationMethod r5) {
            if ((r5 instanceof EmojiTransformationMethod) == false) goto L6;
            return r5;
        L6:
            if ((r5 instanceof PasswordTransformationMethod) == false) goto L9;
            return r5;
        L9:
            return new EmojiTransformationMethod(r5);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @NonNull
        public InputFilter[] getFilters(@NonNull InputFilter[] r5) {
            if (this.mEnabled == true) goto L7;
            return removeEmojiInputFilterIfPresent(r5);
        L7:
            return addEmojiInputFilterIfMissing(r5);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public boolean isEnabled() {
            return this.mEnabled;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public void setAllCaps(boolean r5) {
            if (r5 == false) goto L5;
            updateTransformationMethod();
            return;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public void setEnabled(boolean r5) {
            this.mEnabled = r5;
            updateTransformationMethod();
            updateFilters();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void setEnabledUnsafe(boolean r5) {
            this.mEnabled = r5;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public void updateTransformationMethod() {
            TransformationMethod r5 = wrapTransformationMethod(this.mTextView.getTransformationMethod());
            this.mTextView.setTransformationMethod(r5);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @Nullable
        public TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod r5) {
            if (this.mEnabled == false) goto L7;
            return wrapForEnabled(r5);
        L7:
            return unwrapForDisabled(r5);
        }
    }

    @RequiresApi(19)
    public static class SkippingHelper19 extends HelperInternal {
        private final HelperInternal19 mHelperDelegate;

        public SkippingHelper19(TextView r5) {
            this.mHelperDelegate = new HelperInternal19(r5);
        }

        private boolean skipBecauseEmojiCompatNotInitialized() {
            return !EmojiCompat.isConfigured();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @NonNull
        public InputFilter[] getFilters(@NonNull InputFilter[] r5) {
            if (skipBecauseEmojiCompatNotInitialized() == false) goto L6;
            return r5;
        L6:
            return this.mHelperDelegate.getFilters(r5);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public boolean isEnabled() {
            return this.mHelperDelegate.isEnabled();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public void setAllCaps(boolean r5) {
            if (skipBecauseEmojiCompatNotInitialized() == false) goto L5;
            return;
        L5:
            this.mHelperDelegate.setAllCaps(r5);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public void setEnabled(boolean r5) {
            if (skipBecauseEmojiCompatNotInitialized() == false) goto L5;
            this.mHelperDelegate.setEnabledUnsafe(r5);
            return;
        L5:
            this.mHelperDelegate.setEnabled(r5);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public void updateTransformationMethod() {
            if (skipBecauseEmojiCompatNotInitialized() == false) goto L5;
            return;
        L5:
            this.mHelperDelegate.updateTransformationMethod();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @Nullable
        public TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod r5) {
            if (skipBecauseEmojiCompatNotInitialized() == false) goto L6;
            return r5;
        L6:
            return this.mHelperDelegate.wrapTransformationMethod(r5);
        }
    }

    public EmojiTextViewHelper(@NonNull TextView r5) {
        this(r5, true);
    }

    @NonNull
    public InputFilter[] getFilters(@NonNull InputFilter[] r5) {
        return this.mHelper.getFilters(r5);
    }

    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    public void setAllCaps(boolean r5) {
        this.mHelper.setAllCaps(r5);
    }

    public void setEnabled(boolean r5) {
        this.mHelper.setEnabled(r5);
    }

    public void updateTransformationMethod() {
        this.mHelper.updateTransformationMethod();
    }

    @Nullable
    public TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod r5) {
        return this.mHelper.wrapTransformationMethod(r5);
    }

    public EmojiTextViewHelper(@NonNull TextView r5, boolean r10) {
        Preconditions.checkNotNull(r5, "textView cannot be null");
        if (r10 == true) goto L5;
        this.mHelper = new SkippingHelper19(r5);
        return;
    L5:
        this.mHelper = new HelperInternal19(r5);
    }
}
