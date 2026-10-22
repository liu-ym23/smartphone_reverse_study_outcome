package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewModel {

    @Nullable
    private final Map<String, Object> mBagOfTags;
    private volatile boolean mCleared;

    @Nullable
    private final Set<Closeable> mCloseables;

    public ViewModel() {
        this.mBagOfTags = new HashMap();
        this.mCloseables = new LinkedHashSet();
        this.mCleared = false;
    }

    public ViewModel(@NonNull Closeable... r10) {
        this.mBagOfTags = new HashMap();
        LinkedHashSet r11 = new LinkedHashSet();
        this.mCloseables = r11;
        this.mCleared = false;
        r11.addAll(Arrays.asList(r10));
    }

    private static void closeWithRuntimeException(Object r10) {
        if ((r10 instanceof Closeable) == true) goto L10;
        return;
    L10:
        ((Closeable) r10).close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void addCloseable(@NonNull Closeable r10) {
        Set<Closeable> r11 = this.mCloseables;
        if (r11 == null) goto L11;
        monitor-enter(r11);
        this.mCloseables.add(r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @MainThread
    final void clear() {
        this.mCleared = true;
        Map<String, Object> r10 = this.mBagOfTags;
        if (r10 == null) goto L14;
        monitor-enter(r10);
        Iterator<Object> r11 = this.mBagOfTags.values().iterator();     // Catch: Throwable -> L11
    L7:
        if (r11.hasNext() == false) goto L9;
        closeWithRuntimeException(r11.next());     // Catch: Throwable -> L11
        goto L7
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        Set<Closeable> r12 = this.mCloseables;
        if (r12 == null) goto L26;
        monitor-enter(r12);
        Iterator<Closeable> r13 = this.mCloseables.iterator();     // Catch: Throwable -> L23
    L19:
        if (r13.hasNext() == false) goto L21;
        closeWithRuntimeException(r13.next());     // Catch: Throwable -> L23
        goto L19
    L21:
        monitor-exit(r12);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L26:
        onCleared();
    }

    <T> T getTag(String r10) {
        Map<String, Object> r11 = this.mBagOfTags;
        if (r11 != null) goto L6;
        return null;
    L6:
        monitor-enter(r11);
        T r12 = (T) this.mBagOfTags.get(r10);
        monitor-exit(r11);     // Catch: Throwable -> L10
        return r12;
    L10:
        th = move-exception;
        throw th;
    }

    protected void onCleared() {
    }

    <T> T setTagIfAbsent(String r10, T r11) {
        Map<String, Object> r12 = this.mBagOfTags;
        monitor-enter(r12);
        Object r13 = this.mBagOfTags.get(r10);     // Catch: Throwable -> L15
        if (r13 != null) goto L7;
        this.mBagOfTags.put(r10, r11);     // Catch: Throwable -> L15
    L7:
        monitor-exit(r12);     // Catch: Throwable -> L15
        if (r13 == null) goto L12;
        r11 = (T) r13;
    L12:
        if (this.mCleared == false) goto L14;
        closeWithRuntimeException(r11);
    L14:
        return r11;
    L15:
        th = move-exception;
        throw th;
    }
}
