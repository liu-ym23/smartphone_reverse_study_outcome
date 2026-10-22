package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class PendingIntentCompat {

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static void send(@NonNull PendingIntent r5, @NonNull Context r10, int r11, @NonNull Intent r12, @Nullable PendingIntent.OnFinished r13, @Nullable Handler r14, @Nullable String r15, @Nullable Bundle r16) throws PendingIntent.CanceledException {
            r5.send(r10, r11, r12, r13, r14, r15, r16);
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static PendingIntent getForegroundService(Context r5, int r10, Intent r11, int r12) {
            return PendingIntent.getForegroundService(r5, r10, r11, r12);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface Flags {
    }

    public static class GatedCallback implements Closeable {

        @Nullable
        private PendingIntent.OnFinished mCallback;
        private final CountDownLatch mComplete;
        private boolean mSuccess;

        public GatedCallback(@Nullable PendingIntent.OnFinished r5) {
            this.mComplete = new CountDownLatch(1);
            this.mCallback = r5;
            this.mSuccess = false;
        }

        public static /* synthetic */ void b(GatedCallback r5, PendingIntent r10, Intent r11, int r12, String r13, Bundle r14) {
            r5.onSendFinished(r10, r11, r12, r13, r14);
        }

        private void onSendFinished(PendingIntent r10, Intent r11, int r12, String r13, Bundle r14) {
            boolean r5 = false;
        L15:
            this.mComplete.await();     // Catch: Throwable -> L10 InterruptedException -> L14
        L4:
            if (r5 == false) goto L6;
            Thread.currentThread().interrupt();
        L6:
            PendingIntent.OnFinished r15 = this.mCallback;
            if (r15 == null) goto L18;
            r15.onSendFinished(r10, r11, r12, r13, r14);
            this.mCallback = null;
            return;
        L18:
            return;
        L14:
            r5 = true;
        L10:
            th = move-exception;
            if (r5 == false) goto L13;
            Thread.currentThread().interrupt();
        L13:
            throw th;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.mSuccess == true) goto L5;
            this.mCallback = null;
        L5:
            this.mComplete.countDown();
        }

        public void complete() {
            this.mSuccess = true;
        }

        @Nullable
        public PendingIntent.OnFinished getCallback() {
            if (this.mCallback != null) goto L7;
            return null;
        L7:
            return new b(this);
        }
    }

    private PendingIntentCompat() {
    }

    private static int addMutabilityFlags(boolean r5, int r10) {
        if (r5 == false) goto L5;
        int r11 = 33554432;
    L6:
        return r11 | r10;
    L5:
        r11 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        goto L6
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context r5, int r10, @NonNull @SuppressLint({"ArrayReturn"}) Intent[] r11, int r12, @Nullable Bundle r13, boolean r14) {
        return PendingIntent.getActivities(r5, r10, r11, addMutabilityFlags(r14, r12), r13);
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context r5, int r10, @NonNull Intent r11, int r12, boolean r13) {
        return PendingIntent.getActivity(r5, r10, r11, addMutabilityFlags(r13, r12));
    }

    @Nullable
    public static PendingIntent getBroadcast(@NonNull Context r5, int r10, @NonNull Intent r11, int r12, boolean r13) {
        return PendingIntent.getBroadcast(r5, r10, r11, addMutabilityFlags(r13, r12));
    }

    @NonNull
    @RequiresApi(26)
    public static PendingIntent getForegroundService(@NonNull Context r5, int r10, @NonNull Intent r11, int r12, boolean r13) {
        return Api26Impl.getForegroundService(r5, r10, r11, addMutabilityFlags(r13, r12));
    }

    @Nullable
    public static PendingIntent getService(@NonNull Context r5, int r10, @NonNull Intent r11, int r12, boolean r13) {
        return PendingIntent.getService(r5, r10, r11, addMutabilityFlags(r13, r12));
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent r5, int r10, @Nullable PendingIntent.OnFinished r11, @Nullable Handler r12) throws PendingIntent.CanceledException {
        GatedCallback r13 = new GatedCallback(r11);
        r5.send(r10, r13.getCallback(), r12);     // Catch: Throwable -> L6
        r13.complete();     // Catch: Throwable -> L6
        r13.close();
        return;
    L6:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context r5, int r10, @NonNull @SuppressLint({"ArrayReturn"}) Intent[] r11, int r12, boolean r13) {
        return PendingIntent.getActivities(r5, r10, r11, addMutabilityFlags(r13, r12));
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context r5, int r10, @NonNull Intent r11, int r12, @Nullable Bundle r13, boolean r14) {
        return PendingIntent.getActivity(r5, r10, r11, addMutabilityFlags(r14, r12), r13);
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent r10, @NonNull @SuppressLint({"ContextFirst"}) Context r11, int r12, @NonNull Intent r13, @Nullable PendingIntent.OnFinished r14, @Nullable Handler r15) throws PendingIntent.CanceledException {
        send(r10, r11, r12, r13, r14, r15, null, null);
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent r5, @NonNull @SuppressLint({"ContextFirst"}) Context r10, int r11, @NonNull Intent r12, @Nullable PendingIntent.OnFinished r13, @Nullable Handler r14, @Nullable String r15, @Nullable Bundle r16) throws PendingIntent.CanceledException {
        GatedCallback r17 = new GatedCallback(r13);
        Api23Impl.send(r5, r10, r11, r12, r13, r14, r15, r16);     // Catch: Throwable -> L6
        r17.complete();     // Catch: Throwable -> L6
        r17.close();
        return;
    L6:
        th = move-exception;
        r17.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }
}
