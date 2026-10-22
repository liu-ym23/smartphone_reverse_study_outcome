package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class PendingIntentCompat {

    @RequiresApi(16)
    private static class Api16Impl {
        private Api16Impl() {
        }

        @NonNull
        @DoNotInline
        public static PendingIntent getActivities(@NonNull Context r10, int r11, @NonNull @SuppressLint({"ArrayReturn"}) Intent[] r12, int r13, @NonNull Bundle r14) {
            return PendingIntent.getActivities(r10, r11, r12, r13, r14);
        }

        @NonNull
        @DoNotInline
        public static PendingIntent getActivity(@NonNull Context r10, int r11, @NonNull Intent r12, int r13, @NonNull Bundle r14) {
            return PendingIntent.getActivity(r10, r11, r12, r13, r14);
        }
    }

    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static PendingIntent getForegroundService(Context r10, int r11, Intent r12, int r13) {
            return PendingIntent.getForegroundService(r10, r11, r12, r13);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private PendingIntentCompat() {
    }

    private static int addMutabilityFlags(boolean r10, int r11) {
        if (r10 == false) goto L7;
        if (Build.VERSION.SDK_INT < 31) goto L11;
        int r12 = 33554432;
    L10:
        return r11 | r12;
    L11:
        return r11;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L12;
        r12 = 67108864;
        goto L10
    L12:
        return r11;
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context r10, int r11, @NonNull @SuppressLint({"ArrayReturn"}) Intent[] r12, int r13, @NonNull Bundle r14, boolean r15) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getActivities(r10, r11, r12, addMutabilityFlags(r15, r13), r14);
    L7:
        return PendingIntent.getActivities(r10, r11, r12, r13);
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context r10, int r11, @NonNull @SuppressLint({"ArrayReturn"}) Intent[] r12, int r13, boolean r14) {
        return PendingIntent.getActivities(r10, r11, r12, addMutabilityFlags(r14, r13));
    }

    @NonNull
    public static PendingIntent getActivity(@NonNull Context r10, int r11, @NonNull Intent r12, int r13, @NonNull Bundle r14, boolean r15) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getActivity(r10, r11, r12, addMutabilityFlags(r15, r13), r14);
    L7:
        return PendingIntent.getActivity(r10, r11, r12, r13);
    }

    @NonNull
    public static PendingIntent getActivity(@NonNull Context r10, int r11, @NonNull Intent r12, int r13, boolean r14) {
        return PendingIntent.getActivity(r10, r11, r12, addMutabilityFlags(r14, r13));
    }

    @NonNull
    public static PendingIntent getBroadcast(@NonNull Context r10, int r11, @NonNull Intent r12, int r13, boolean r14) {
        return PendingIntent.getBroadcast(r10, r11, r12, addMutabilityFlags(r14, r13));
    }

    @NonNull
    @RequiresApi(26)
    public static PendingIntent getForegroundService(@NonNull Context r10, int r11, @NonNull Intent r12, int r13, boolean r14) {
        return Api26Impl.getForegroundService(r10, r11, r12, addMutabilityFlags(r14, r13));
    }

    @NonNull
    public static PendingIntent getService(@NonNull Context r10, int r11, @NonNull Intent r12, int r13, boolean r14) {
        return PendingIntent.getService(r10, r11, r12, addMutabilityFlags(r14, r13));
    }
}
