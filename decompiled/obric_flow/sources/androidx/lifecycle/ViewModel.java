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

    private static void closeWithRuntimeException(Object r5) {
        if ((r5 instanceof Closeable) == true) goto L10;
        return;
    L10:
        ((Closeable) r5).close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void addCloseable(@NonNull Closeable r5) {
        Set<Closeable> r10 = this.mCloseables;
        if (r10 == null) goto L11;
        monitor-enter(r10);
        this.mCloseables.add(r5);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @MainThread
    public final void clear() {
        this.mCleared = true;
        Map<String, Object> r5 = this.mBagOfTags;
        if (r5 == null) goto L15;
        monitor-enter(r5);
        Iterator<Object> r10 = this.mBagOfTags.values().iterator();     // Catch: Throwable -> L9
    L7:
        if (r10.hasNext() == false) goto L11;
        closeWithRuntimeException(r10.next());     // Catch: Throwable -> L9
        goto L7
    L11:
        monitor-exit(r5);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L15:
        Set<Closeable> r11 = this.mCloseables;
        if (r11 == null) goto L28;
        monitor-enter(r11);
        Iterator<Closeable> r12 = this.mCloseables.iterator();     // Catch: Throwable -> L22
    L20:
        if (r12.hasNext() == false) goto L24;
        closeWithRuntimeException(r12.next());     // Catch: Throwable -> L22
        goto L20
    L24:
        monitor-exit(r11);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L28:
        onCleared();
    }

    public <T> T getTag(String r5) {
        Map<String, Object> r10 = this.mBagOfTags;
        if (r10 != null) goto L6;
        return null;
    L6:
        monitor-enter(r10);
        T r11 = (T) this.mBagOfTags.get(r5);
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L10:
        th = move-exception;
        throw th;
    }

    public void onCleared() {
    }

    public <T> T setTagIfAbsent(String r5, T r10) {
        Map<String, Object> r11 = this.mBagOfTags;
        monitor-enter(r11);
        Object r12 = this.mBagOfTags.get(r5);     // Catch: Throwable -> L7
        if (r12 != null) goto L9;
        this.mBagOfTags.put(r5, r10);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
        if (r12 == null) goto L14;
        r10 = (T) r12;
    L14:
        if (this.mCleared == false) goto L16;
        closeWithRuntimeException(r10);
    L16:
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public ViewModel(@NonNull Closeable... r5) {
        this.mBagOfTags = new HashMap();
        LinkedHashSet r10 = new LinkedHashSet();
        this.mCloseables = r10;
        this.mCleared = false;
        r10.addAll(Arrays.asList(r5));
    }
}
