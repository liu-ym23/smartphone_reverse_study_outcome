package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
class SnackbarManager {
    private static final int LONG_DURATION_MS = 2750;
    static final int MSG_TIMEOUT = 0;
    private static final int SHORT_DURATION_MS = 1500;
    private static SnackbarManager snackbarManager;

    @Nullable
    private SnackbarRecord currentSnackbar;

    @NonNull
    private final Handler handler;

    @NonNull
    private final Object lock;

    @Nullable
    private SnackbarRecord nextSnackbar;

    public interface Callback {
        void dismiss(int r5);

        void show();
    }

    public static class SnackbarRecord {

        @NonNull
        final WeakReference<Callback> callback;
        int duration;
        boolean paused;

        public SnackbarRecord(int r5, Callback r10) {
            this.callback = new WeakReference(r10);
            this.duration = r5;
        }

        public boolean isSnackbar(@Nullable Callback r5) {
            if (r5 != null) goto L4;
        L6:
            return false;
        L4:
            if (this.callback.get() != r5) goto L6;
            return true;
        }
    }

    private SnackbarManager() {
        this.lock = new Object();
        this.handler = new Handler(Looper.getMainLooper(), new AnonymousClass1(this));
    }

    private boolean cancelSnackbarLocked(@NonNull SnackbarRecord r5, int r10) {
        Callback r11 = r5.callback.get();
        if (r11 == null) goto L6;
        this.handler.removeCallbacksAndMessages(r5);
        r11.dismiss(r10);
        return true;
    L6:
        return false;
    }

    public static SnackbarManager getInstance() {
        if (snackbarManager != null) goto L6;
        snackbarManager = new SnackbarManager();
    L6:
        return snackbarManager;
    }

    private boolean isCurrentSnackbarLocked(Callback r5) {
        SnackbarRecord r10 = this.currentSnackbar;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isSnackbar(r5) == false) goto L7;
        return true;
    }

    private boolean isNextSnackbarLocked(Callback r5) {
        SnackbarRecord r10 = this.nextSnackbar;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isSnackbar(r5) == false) goto L7;
        return true;
    }

    private void scheduleTimeoutLocked(@NonNull SnackbarRecord r5) {
        int r10 = r5.duration;
        if (r10 != (-2)) goto L5;
        return;
    L5:
        if (r10 <= 0) goto L8;
    L11:
        this.handler.removeCallbacksAndMessages(r5);
        Handler r11 = this.handler;
        r11.sendMessageDelayed(Message.obtain(r11, 0, r5), r10);
        return;
    L8:
        if (r10 != (-1)) goto L10;
        r10 = SHORT_DURATION_MS;
        goto L11
    L10:
        r10 = LONG_DURATION_MS;
        goto L11
    }

    private void showNextSnackbarLocked() {
        SnackbarRecord r5 = this.nextSnackbar;
        if (r5 == null) goto L9;
        this.currentSnackbar = r5;
        this.nextSnackbar = null;
        Callback r10 = r5.callback.get();
        if (r10 == null) goto L7;
        r10.show();
        return;
    L7:
        this.currentSnackbar = null;
        return;
    }

    public void dismiss(Callback r5, int r10) {
        Object r11 = this.lock;
        monitor-enter(r11);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r5) == false) goto L10;
        cancelSnackbarLocked(this.currentSnackbar, r10);     // Catch: Throwable -> L7
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L10:
        if (isNextSnackbarLocked(r5) == false) goto L12;
        cancelSnackbarLocked(this.nextSnackbar, r10);     // Catch: Throwable -> L7
        goto L12
    }

    public void handleTimeout(@NonNull SnackbarRecord r5) {
        Object r10 = this.lock;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.currentSnackbar != r5) goto L7;
    L11:
        cancelSnackbarLocked(r5, 2);     // Catch: Throwable -> L9
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.nextSnackbar != r5) goto L12;
        goto L12
    }

    public boolean isCurrent(Callback r5) {
        Object r10 = this.lock;
        monitor-enter(r10);
        boolean r11 = isCurrentSnackbarLocked(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isCurrentOrNext(Callback r5) {
        Object r10 = this.lock;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r5) == false) goto L7;
    L12:
        boolean r11 = true;
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L7:
        if (isNextSnackbarLocked(r5) == true) goto L12;
        r11 = false;
        goto L13
    }

    public void onDismissed(Callback r5) {
        Object r10 = this.lock;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r5) == false) goto L11;
        this.currentSnackbar = null;     // Catch: Throwable -> L9
        if (this.nextSnackbar == null) goto L11;
        showNextSnackbarLocked();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
    }

    public void onShown(Callback r5) {
        Object r10 = this.lock;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r5) == false) goto L9;
        scheduleTimeoutLocked(this.currentSnackbar);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L7
    }

    public void pauseTimeout(Callback r5) {
        Object r10 = this.lock;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r5) == false) goto L11;
        SnackbarRecord r11 = this.currentSnackbar;     // Catch: Throwable -> L9
        if (r11.paused == true) goto L11;
        r11.paused = true;     // Catch: Throwable -> L9
        this.handler.removeCallbacksAndMessages(r11);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
    }

    public void restoreTimeoutIfPaused(Callback r5) {
        Object r10 = this.lock;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r5) == false) goto L11;
        SnackbarRecord r11 = this.currentSnackbar;     // Catch: Throwable -> L9
        if (r11.paused == false) goto L11;
        r11.paused = false;     // Catch: Throwable -> L9
        scheduleTimeoutLocked(r11);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
    }

    public void show(int r5, Callback r10) {
        Object r11 = this.lock;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r10) == false) goto L12;
        SnackbarRecord r12 = this.currentSnackbar;     // Catch: Throwable -> L9
        r12.duration = r5;     // Catch: Throwable -> L9
        this.handler.removeCallbacksAndMessages(r12);     // Catch: Throwable -> L9
        scheduleTimeoutLocked(this.currentSnackbar);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L12:
        if (isNextSnackbarLocked(r10) == false) goto L14;
        this.nextSnackbar.duration = r5;     // Catch: Throwable -> L9
    L15:
        SnackbarRecord r13 = this.currentSnackbar;     // Catch: Throwable -> L9
        if (r13 != null) goto L18;
    L21:
        this.currentSnackbar = null;     // Catch: Throwable -> L9
        showNextSnackbarLocked();     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L18:
        if (cancelSnackbarLocked(r13, 4) == false) goto L21;
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L14:
        this.nextSnackbar = new SnackbarRecord(r5, r10);     // Catch: Throwable -> L9
        goto L15
    }
}
