package androidx.core.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class PendingIntentCompat {

    private static class Api16Impl {
        private Api16Impl() {
        }

        public static PendingIntent getActivities(Context r2, int r3, Intent[] r4, int r5, Bundle r6) {
            return PendingIntent.getActivities((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static PendingIntent getActivity(Context r2, int r3, Intent r4, int r5, Bundle r6) {
            return PendingIntent.getActivity((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        public static void send(PendingIntent r10, Context r11, int r12, Intent r13, PendingIntent.OnFinished r14, Handler r15, String r16, Bundle r17) {
            r10.send((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin"), r12, r13, (PendingIntent.OnFinished) ZeusTransformUtils.wrapperContextForParams(r14, PendingIntent.OnFinished.class, "com.obric.memorydata.plugin"), r15, r16, r17);
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        public static PendingIntent getForegroundService(Context r2, int r3, Intent r4, int r5) {
            return PendingIntent.getForegroundService((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static class GatedCallback implements Closeable {
        private PendingIntent.OnFinished mCallback;
        private final CountDownLatch mComplete;
        private boolean mSuccess;

        GatedCallback(PendingIntent.OnFinished r3) {
            PendingIntent.OnFinished r4 = (PendingIntent.OnFinished) ZeusTransformUtils.wrapperContextForParams(r3, PendingIntent.OnFinished.class, "com.obric.memorydata.plugin");
            this.mComplete = new CountDownLatch(1);
            this.mCallback = r4;
            this.mSuccess = false;
        }

        public static /* synthetic */ void lambda$dARjk2pGHL_3_vnErsOjaRzR5JA(GatedCallback r0, PendingIntent r1, Intent r2, int r3, String r4, Bundle r5) {
            r0.onSendFinished(r1, r2, r3, r4, r5);
        }

        private void onSendFinished(PendingIntent r8, Intent r9, int r10, String r11, Bundle r12) {
            boolean r0 = false;
        L15:
            this.mComplete.await();     // Catch: Throwable -> L10 InterruptedException -> L14
        L4:
            if (r0 == false) goto L6;
            Thread.currentThread().interrupt();
        L6:
            PendingIntent.OnFinished r1 = this.mCallback;
            if (r1 == null) goto L18;
            r1.onSendFinished(r8, r9, r10, r11, r12);
            this.mCallback = null;
            return;
        L18:
            return;
        L14:
            r0 = true;
        L10:
            th = move-exception;
            if (r0 == false) goto L13;
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

        public PendingIntent.OnFinished getCallback() {
            if (this.mCallback != null) goto L7;
            return null;
        L7:
            return new $$Lambda$PendingIntentCompat$GatedCallback$dARjk2pGHL_3_vnErsOjaRzR5JA(this);
        }
    }

    private PendingIntentCompat() {
    }

    private static int addMutabilityFlags(boolean r1, int r2) {
        if (r1 == false) goto L7;
        if (Build.VERSION.SDK_INT < 31) goto L11;
        int r3 = 33554432;
    L10:
        return r2 | r3;
    L11:
        return r2;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L12;
        r3 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        goto L10
    L12:
        return r2;
    }

    public static PendingIntent getActivities(Context r2, int r3, Intent[] r4, int r5, Bundle r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getActivities(r8, r3, r4, addMutabilityFlags(r7, r5), r6);
    L7:
        return PendingIntent.getActivities(r8, r3, r4, r5);
    }

    public static PendingIntent getActivities(Context r2, int r3, Intent[] r4, int r5, boolean r6) {
        return PendingIntent.getActivities((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, addMutabilityFlags(r6, r5));
    }

    public static PendingIntent getActivity(Context r2, int r3, Intent r4, int r5, Bundle r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getActivity(r8, r3, r4, addMutabilityFlags(r7, r5), r6);
    L7:
        return PendingIntent.getActivity(r8, r3, r4, r5);
    }

    public static PendingIntent getActivity(Context r2, int r3, Intent r4, int r5, boolean r6) {
        return PendingIntent.getActivity((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, addMutabilityFlags(r6, r5));
    }

    public static PendingIntent getBroadcast(Context r2, int r3, Intent r4, int r5, boolean r6) {
        return PendingIntent.getBroadcast((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, addMutabilityFlags(r6, r5));
    }

    public static PendingIntent getForegroundService(Context r2, int r3, Intent r4, int r5, boolean r6) {
        return Api26Impl.getForegroundService((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, addMutabilityFlags(r6, r5));
    }

    public static PendingIntent getService(Context r2, int r3, Intent r4, int r5, boolean r6) {
        return PendingIntent.getService((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, addMutabilityFlags(r6, r5));
    }

    public static void send(PendingIntent r2, int r3, PendingIntent.OnFinished r4, Handler r5) {
        GatedCallback r0 = new GatedCallback((PendingIntent.OnFinished) ZeusTransformUtils.wrapperContextForParams(r4, PendingIntent.OnFinished.class, "com.obric.memorydata.plugin"));
        r2.send(r3, r0.getCallback(), r5);     // Catch: Throwable -> L6
        r0.complete();     // Catch: Throwable -> L6
        r0.close();
        return;
    L6:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    public static void send(PendingIntent r10, Context r11, int r12, Intent r13, PendingIntent.OnFinished r14, Handler r15) {
        send(r10, (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin"), r12, r13, (PendingIntent.OnFinished) ZeusTransformUtils.wrapperContextForParams(r14, PendingIntent.OnFinished.class, "com.obric.memorydata.plugin"), r15, null, null);
    }

    public static void send(PendingIntent r10, Context r11, int r12, Intent r13, PendingIntent.OnFinished r14, Handler r15, String r16, Bundle r17) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        PendingIntent.OnFinished r6 = (PendingIntent.OnFinished) ZeusTransformUtils.wrapperContextForParams(r14, PendingIntent.OnFinished.class, "com.obric.memorydata.plugin");
        GatedCallback r1 = new GatedCallback(r6);
    L10:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L14
        throw th;
    L14:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.send(r10, r3, r12, r13, r6, r15, r16, r17);     // Catch: Throwable -> L10
    L7:
        r1.complete();     // Catch: Throwable -> L10
        r1.close();
        return;
    L6:
        r10.send(r3, r12, r13, r1.getCallback(), r15, r16);     // Catch: Throwable -> L10
        goto L7
    }
}
