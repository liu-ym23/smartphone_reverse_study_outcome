package androidx.activity;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.core.os.BuildCompat;
import androidx.core.util.Consumer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class OnBackPressedCallback {
    private CopyOnWriteArrayList<Cancellable> mCancellables;
    private boolean mEnabled;
    private Consumer<Boolean> mEnabledConsumer;

    public OnBackPressedCallback(boolean r10) {
        this.mCancellables = new CopyOnWriteArrayList();
        this.mEnabled = r10;
    }

    void addCancellable(@NonNull Cancellable r10) {
        this.mCancellables.add(r10);
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public final boolean isEnabled() {
        return this.mEnabled;
    }

    @MainThread
    public final void remove() {
        Iterator<Cancellable> r10 = this.mCancellables.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().cancel();
        goto L4
    }

    void removeCancellable(@NonNull Cancellable r10) {
        this.mCancellables.remove(r10);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @MainThread
    public final void setEnabled(boolean r10) {
        this.mEnabled = r10;
        Consumer<Boolean> r11 = this.mEnabledConsumer;
        if (r11 == null) goto L6;
        r11.accept(Boolean.valueOf(r10));
        return;
    }

    void setIsEnabledConsumer(@Nullable Consumer<Boolean> r10) {
        this.mEnabledConsumer = r10;
    }
}
