package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SpannableBuilder extends SpannableStringBuilder {

    @NonNull
    private final Class<?> mWatcherClass;

    @NonNull
    private final List<WatcherWrapper> mWatchers;

    private static class WatcherWrapper implements TextWatcher, SpanWatcher {
        private final AtomicInteger mBlockCalls;
        final Object mObject;

        WatcherWrapper(Object r10) {
            this.mBlockCalls = new AtomicInteger(0);
            this.mObject = r10;
        }

        private boolean isEmojiSpan(Object r10) {
            return r10 instanceof EmojiSpan;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            ((TextWatcher) this.mObject).afterTextChanged(r10);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
            ((TextWatcher) this.mObject).beforeTextChanged(r10, r11, r12, r13);
        }

        final void blockCalls() {
            this.mBlockCalls.incrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable r10, Object r11, int r12, int r13) {
            if (this.mBlockCalls.get() > 0) goto L5;
        L7:
            ((SpanWatcher) this.mObject).onSpanAdded(r10, r11, r12, r13);
            return;
        L5:
            if (isEmojiSpan(r11) == false) goto L7;
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable r10, Object r11, int r12, int r13, int r14, int r15) {
            if (this.mBlockCalls.get() <= 0) goto L8;
            if (isEmojiSpan(r11) == false) goto L8;
            return;
        L8:
            if (Build.VERSION.SDK_INT >= 28) goto L15;
            if (r12 <= r13) goto L11;
            int r16 = 0;
        L12:
            if (r14 <= r15) goto L14;
            int r17 = r16;
            int r18 = 0;
        L16:
            ((SpanWatcher) this.mObject).onSpanChanged(r10, r11, r17, r13, r18, r15);
            return;
        L14:
            r18 = r14;
            r17 = r16;
            goto L16
        L11:
            r16 = r12;
            goto L12
        L15:
            r17 = r12;
            r18 = r14;
            goto L16
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable r10, Object r11, int r12, int r13) {
            if (this.mBlockCalls.get() > 0) goto L5;
        L7:
            ((SpanWatcher) this.mObject).onSpanRemoved(r10, r11, r12, r13);
            return;
        L5:
            if (isEmojiSpan(r11) == false) goto L7;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
            ((TextWatcher) this.mObject).onTextChanged(r10, r11, r12, r13);
        }

        final void unblockCalls() {
            this.mBlockCalls.decrementAndGet();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    SpannableBuilder(@NonNull Class<?> r10) {
        this.mWatchers = new ArrayList();
        Preconditions.checkNotNull(r10, "watcherClass cannot be null");
        this.mWatcherClass = r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    SpannableBuilder(@NonNull Class<?> r10, @NonNull CharSequence r11) {
        super(r11);
        this.mWatchers = new ArrayList();
        Preconditions.checkNotNull(r10, "watcherClass cannot be null");
        this.mWatcherClass = r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    SpannableBuilder(@NonNull Class<?> r10, @NonNull CharSequence r11, int r12, int r13) {
        super(r11, r12, r13);
        this.mWatchers = new ArrayList();
        Preconditions.checkNotNull(r10, "watcherClass cannot be null");
        this.mWatcherClass = r10;
    }

    private void blockWatchers() {
        int r10 = 0;
    L4:
        if (r10 >= this.mWatchers.size()) goto L6;
        this.mWatchers.get(r10).blockCalls();
        r10 = r10 + 1;
        goto L4
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static SpannableBuilder create(@NonNull Class<?> r10, @NonNull CharSequence r11) {
        return new SpannableBuilder(r10, r11);
    }

    private void fireWatchers() {
        int r10 = 0;
    L4:
        if (r10 >= this.mWatchers.size()) goto L6;
        this.mWatchers.get(r10).onTextChanged(this, 0, length(), length());
        r10 = r10 + 1;
        goto L4
    }

    private WatcherWrapper getWatcherFor(Object r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mWatchers.size()) goto L9;
        WatcherWrapper r12 = this.mWatchers.get(r11);
        if (r12.mObject == r10) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r12;
    L9:
        return null;
    }

    private boolean isWatcher(@NonNull Class<?> r10) {
        if (this.mWatcherClass != r10) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isWatcher(@Nullable Object r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (isWatcher(r10.getClass()) == false) goto L6;
        return true;
    }

    private void unblockwatchers() {
        int r10 = 0;
    L4:
        if (r10 >= this.mWatchers.size()) goto L6;
        this.mWatchers.get(r10).unblockCalls();
        r10 = r10 + 1;
        goto L4
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public /* bridge */ /* synthetic */ Editable append(char r10) {
        return append(r10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public /* bridge */ /* synthetic */ Editable append(@SuppressLint({"UnknownNullness"}) CharSequence r10) {
        return append(r10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public /* bridge */ /* synthetic */ Editable append(@SuppressLint({"UnknownNullness"}) CharSequence r10, int r11, int r12) {
        return append(r10, r11, r12);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public SpannableStringBuilder append(char r10) {
        super.append(r10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence r10) {
        super.append(r10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence r10, int r11, int r12) {
        super.append(r10, r11, r12);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder append(CharSequence r10, Object r11, int r12) {
        super.append(r10, r11, r12);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public /* bridge */ /* synthetic */ Appendable append(char r10) {
        return append(r10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public /* bridge */ /* synthetic */ Appendable append(@SuppressLint({"UnknownNullness"}) CharSequence r10) {
        return append(r10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public /* bridge */ /* synthetic */ Appendable append(@SuppressLint({"UnknownNullness"}) CharSequence r10, int r11, int r12) {
        return append(r10, r11, r12);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void beginBatchEdit() {
        blockWatchers();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public /* bridge */ /* synthetic */ Editable delete(int r10, int r11) {
        return delete(r10, r11);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder delete(int r10, int r11) {
        super.delete(r10, r11);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void endBatchEdit() {
        unblockwatchers();
        fireWatchers();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(@Nullable Object r10) {
        if (isWatcher(r10) == false) goto L8;
        WatcherWrapper r11 = getWatcherFor(r10);
        if (r11 == null) goto L8;
        r10 = r11;
    L8:
        return super.getSpanEnd(r10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(@Nullable Object r10) {
        if (isWatcher(r10) == false) goto L8;
        WatcherWrapper r11 = getWatcherFor(r10);
        if (r11 == null) goto L8;
        r10 = r11;
    L8:
        return super.getSpanFlags(r10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(@Nullable Object r10) {
        if (isWatcher(r10) == false) goto L8;
        WatcherWrapper r11 = getWatcherFor(r10);
        if (r11 == null) goto L8;
        r10 = r11;
    L8:
        return super.getSpanStart(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    @SuppressLint({"UnknownNullness"})
    public <T> T[] getSpans(int r10, int r11, @NonNull Class<T> r12) {
        if (isWatcher(r12) == false) goto L10;
        WatcherWrapper[] r13 = (WatcherWrapper[]) super.getSpans(r10, r11, WatcherWrapper.class);
        T[] r14 = (T[]) ((Object[]) Array.newInstance(r12, r13.length));
        int r15 = 0;
    L6:
        if (r15 >= r13.length) goto L8;
        r14[r15] = r13[r15].mObject;
        r15 = r15 + 1;
        goto L6
    L8:
        return r14;
    L10:
        return (T[]) super.getSpans(r10, r11, r12);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public /* bridge */ /* synthetic */ Editable insert(int r10, CharSequence r11) {
        return insert(r10, r11);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public /* bridge */ /* synthetic */ Editable insert(int r10, CharSequence r11, int r12, int r13) {
        return insert(r10, r11, r12, r13);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int r10, CharSequence r11) {
        super.insert(r10, r11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int r10, CharSequence r11, int r12, int r13) {
        super.insert(r10, r11, r12, r13);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int r10, int r11, @Nullable Class r12) {
        if (r12 != null) goto L4;
    L5:
        r12 = WatcherWrapper.class;
    L7:
        return super.nextSpanTransition(r10, r11, r12);
    L4:
        if (isWatcher(r12) == false) goto L7;
        goto L5
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(@Nullable Object r10) {
        if (isWatcher(r10) == false) goto L7;
        WatcherWrapper r11 = getWatcherFor(r10);
        if (r11 == null) goto L8;
        r10 = r11;
    L8:
        super.removeSpan(r10);
        if (r11 == null) goto L12;
        this.mWatchers.remove(r11);
        return;
    L12:
        return;
    L7:
        r11 = null;
        goto L8
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public /* bridge */ /* synthetic */ Editable replace(int r10, int r11, CharSequence r12) {
        return replace(r10, r11, r12);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public /* bridge */ /* synthetic */ Editable replace(int r10, int r11, CharSequence r12, int r13, int r14) {
        return replace(r10, r11, r12, r13, r14);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int r10, int r11, CharSequence r12) {
        blockWatchers();
        super.replace(r10, r11, r12);
        unblockwatchers();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int r10, int r11, CharSequence r12, int r13, int r14) {
        blockWatchers();
        super.replace(r10, r11, r12, r13, r14);
        unblockwatchers();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(@Nullable Object r10, int r11, int r12, int r13) {
        if (isWatcher(r10) == false) goto L5;
        WatcherWrapper r14 = new WatcherWrapper(r10);
        this.mWatchers.add(r14);
        r10 = r14;
    L5:
        super.setSpan(r10, r11, r12, r13);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    @SuppressLint({"UnknownNullness"})
    public CharSequence subSequence(int r10, int r11) {
        return new SpannableBuilder(this.mWatcherClass, this, r10, r11);
    }
}
