package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.io.IOException;
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

    public static class WatcherWrapper implements TextWatcher, SpanWatcher {
        private final AtomicInteger mBlockCalls;
        final Object mObject;

        public WatcherWrapper(Object r5) {
            this.mBlockCalls = new AtomicInteger(0);
            this.mObject = r5;
        }

        private boolean isEmojiSpan(Object r5) {
            return r5 instanceof EmojiSpan;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r5) {
            ((TextWatcher) this.mObject).afterTextChanged(r5);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r5, int r10, int r11, int r12) {
            ((TextWatcher) this.mObject).beforeTextChanged(r5, r10, r11, r12);
        }

        public final void blockCalls() {
            this.mBlockCalls.incrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable r5, Object r10, int r11, int r12) {
            if (this.mBlockCalls.get() > 0) goto L5;
        L7:
            ((SpanWatcher) this.mObject).onSpanAdded(r5, r10, r11, r12);
            return;
        L5:
            if (isEmojiSpan(r10) == false) goto L7;
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable r10, Object r11, int r12, int r13, int r14, int r15) {
            if (this.mBlockCalls.get() > 0) goto L5;
        L7:
            ((SpanWatcher) this.mObject).onSpanChanged(r10, r11, r12, r13, r14, r15);
            return;
        L5:
            if (isEmojiSpan(r11) == false) goto L7;
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable r5, Object r10, int r11, int r12) {
            if (this.mBlockCalls.get() > 0) goto L5;
        L7:
            ((SpanWatcher) this.mObject).onSpanRemoved(r5, r10, r11, r12);
            return;
        L5:
            if (isEmojiSpan(r10) == false) goto L7;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r5, int r10, int r11, int r12) {
            ((TextWatcher) this.mObject).onTextChanged(r5, r10, r11, r12);
        }

        public final void unblockCalls() {
            this.mBlockCalls.decrementAndGet();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public SpannableBuilder(@NonNull Class<?> r5) {
        this.mWatchers = new ArrayList();
        Preconditions.checkNotNull(r5, "watcherClass cannot be null");
        this.mWatcherClass = r5;
    }

    private void blockWatchers() {
        int r5 = 0;
    L4:
        if (r5 >= this.mWatchers.size()) goto L6;
        this.mWatchers.get(r5).blockCalls();
        r5 = r5 + 1;
        goto L4
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static SpannableBuilder create(@NonNull Class<?> r5, @NonNull CharSequence r10) {
        return new SpannableBuilder(r5, r10);
    }

    private void fireWatchers() {
        int r5 = 0;
    L4:
        if (r5 >= this.mWatchers.size()) goto L6;
        this.mWatchers.get(r5).onTextChanged(this, 0, length(), length());
        r5 = r5 + 1;
        goto L4
    }

    private WatcherWrapper getWatcherFor(Object r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.mWatchers.size()) goto L9;
        WatcherWrapper r11 = this.mWatchers.get(r10);
        if (r11.mObject == r5) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return r11;
    L9:
        return null;
    }

    private boolean isWatcher(@Nullable Object r5) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (isWatcher(r5.getClass()) == false) goto L6;
        return true;
    }

    private void unblockwatchers() {
        int r5 = 0;
    L4:
        if (r5 >= this.mWatchers.size()) goto L6;
        this.mWatchers.get(r5).unblockCalls();
        r5 = r5 + 1;
        goto L4
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public /* bridge */ /* synthetic */ Editable append(char r5) {
        return append(r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void beginBatchEdit() {
        blockWatchers();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public /* bridge */ /* synthetic */ Editable delete(int r5, int r10) {
        return delete(r5, r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void endBatchEdit() {
        unblockwatchers();
        fireWatchers();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(@Nullable Object r5) {
        if (isWatcher(r5) == false) goto L8;
        WatcherWrapper r10 = getWatcherFor(r5);
        if (r10 == null) goto L8;
        r5 = r10;
    L8:
        return super.getSpanEnd(r5);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(@Nullable Object r5) {
        if (isWatcher(r5) == false) goto L8;
        WatcherWrapper r10 = getWatcherFor(r5);
        if (r10 == null) goto L8;
        r5 = r10;
    L8:
        return super.getSpanFlags(r5);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(@Nullable Object r5) {
        if (isWatcher(r5) == false) goto L8;
        WatcherWrapper r10 = getWatcherFor(r5);
        if (r10 == null) goto L8;
        r5 = r10;
    L8:
        return super.getSpanStart(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    @SuppressLint({"UnknownNullness"})
    public <T> T[] getSpans(int r5, int r10, @NonNull Class<T> r11) {
        if (isWatcher(r11) == false) goto L10;
        WatcherWrapper[] r12 = (WatcherWrapper[]) super.getSpans(r5, r10, WatcherWrapper.class);
        T[] r13 = (T[]) ((Object[]) Array.newInstance(r11, r12.length));
        int r14 = 0;
    L6:
        if (r14 >= r12.length) goto L8;
        r13[r14] = r12[r14].mObject;
        r14 = r14 + 1;
        goto L6
    L8:
        return r13;
    L10:
        return (T[]) super.getSpans(r5, r10, r11);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public /* bridge */ /* synthetic */ Editable insert(int r5, CharSequence r10) {
        return insert(r5, r10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int r5, int r10, @Nullable Class r11) {
        if (r11 != null) goto L4;
    L5:
        r11 = WatcherWrapper.class;
    L7:
        return super.nextSpanTransition(r5, r10, r11);
    L4:
        if (isWatcher(r11) == false) goto L7;
        goto L5
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(@Nullable Object r5) {
        if (isWatcher(r5) == false) goto L7;
        WatcherWrapper r10 = getWatcherFor(r5);
        if (r10 == null) goto L8;
        r5 = r10;
    L8:
        super.removeSpan(r5);
        if (r10 == null) goto L12;
        this.mWatchers.remove(r10);
        return;
    L12:
        return;
    L7:
        r10 = null;
        goto L8
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public /* bridge */ /* synthetic */ Editable replace(int r5, int r10, CharSequence r11) {
        return replace(r5, r10, r11);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(@Nullable Object r5, int r10, int r11, int r12) {
        if (isWatcher(r5) == false) goto L5;
        WatcherWrapper r13 = new WatcherWrapper(r5);
        this.mWatchers.add(r13);
        r5 = r13;
    L5:
        super.setSpan(r5, r10, r11, r12);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    @SuppressLint({"UnknownNullness"})
    public CharSequence subSequence(int r5, int r10) {
        return new SpannableBuilder(this.mWatcherClass, this, r5, r10);
    }

    private boolean isWatcher(@NonNull Class<?> r5) {
        if (this.mWatcherClass != r5) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public /* bridge */ /* synthetic */ Editable append(@SuppressLint({"UnknownNullness"}) CharSequence r5) {
        return append(r5);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder delete(int r5, int r10) {
        super.delete(r5, r10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public /* bridge */ /* synthetic */ Editable insert(int r5, CharSequence r10, int r11, int r12) {
        return insert(r5, r10, r11, r12);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public /* bridge */ /* synthetic */ Editable replace(int r5, int r10, CharSequence r11, int r12, int r13) {
        return replace(r5, r10, r11, r12, r13);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public /* bridge */ /* synthetic */ Editable append(@SuppressLint({"UnknownNullness"}) CharSequence r5, int r10, int r11) {
        return append(r5, r10, r11);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int r5, CharSequence r10) {
        super.insert(r5, r10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int r5, int r10, CharSequence r11) {
        blockWatchers();
        super.replace(r5, r10, r11);
        unblockwatchers();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public /* bridge */ /* synthetic */ Appendable append(char r5) throws IOException {
        return append(r5);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int r5, CharSequence r10, int r11, int r12) {
        super.insert(r5, r10, r11, r12);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public SpannableBuilder(@NonNull Class<?> r5, @NonNull CharSequence r10) {
        super(r10);
        this.mWatchers = new ArrayList();
        Preconditions.checkNotNull(r5, "watcherClass cannot be null");
        this.mWatcherClass = r5;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public /* bridge */ /* synthetic */ Appendable append(@SuppressLint({"UnknownNullness"}) CharSequence r5) throws IOException {
        return append(r5);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public /* bridge */ /* synthetic */ Appendable append(@SuppressLint({"UnknownNullness"}) CharSequence r5, int r10, int r11) throws IOException {
        return append(r5, r10, r11);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int r5, int r10, CharSequence r11, int r12, int r13) {
        blockWatchers();
        super.replace(r5, r10, r11, r12, r13);
        unblockwatchers();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence r5) {
        super.append(r5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public SpannableStringBuilder append(char r5) {
        super.append(r5);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public SpannableBuilder(@NonNull Class<?> r5, @NonNull CharSequence r10, int r11, int r12) {
        super(r10, r11, r12);
        this.mWatchers = new ArrayList();
        Preconditions.checkNotNull(r5, "watcherClass cannot be null");
        this.mWatcherClass = r5;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence r5, int r10, int r11) {
        super.append(r5, r10, r11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder append(CharSequence r5, Object r10, int r11) {
        super.append(r5, r10, r11);
        return this;
    }
}
