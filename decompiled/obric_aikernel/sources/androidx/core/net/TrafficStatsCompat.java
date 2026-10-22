package androidx.core.net;

import android.net.TrafficStats;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.net.DatagramSocket;
import java.net.Socket;

/* JADX INFO: loaded from: classes.dex */
public final class TrafficStatsCompat {

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void tagDatagramSocket(DatagramSocket r10) {
            TrafficStats.tagDatagramSocket(r10);
        }

        @DoNotInline
        static void untagDatagramSocket(DatagramSocket r10) {
            TrafficStats.untagDatagramSocket(r10);
        }
    }

    private TrafficStatsCompat() {
    }

    @Deprecated
    public static void clearThreadStatsTag() {
        TrafficStats.clearThreadStatsTag();
    }

    @Deprecated
    public static int getThreadStatsTag() {
        return TrafficStats.getThreadStatsTag();
    }

    @Deprecated
    public static void incrementOperationCount(int r10) {
        TrafficStats.incrementOperationCount(r10);
    }

    @Deprecated
    public static void incrementOperationCount(int r10, int r11) {
        TrafficStats.incrementOperationCount(r10, r11);
    }

    @Deprecated
    public static void setThreadStatsTag(int r10) {
        TrafficStats.setThreadStatsTag(r10);
    }

    public static void tagDatagramSocket(@NonNull DatagramSocket r10) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Api24Impl.tagDatagramSocket(r10);
        return;
    L5:
        ParcelFileDescriptor r11 = ParcelFileDescriptor.fromDatagramSocket(r10);
        TrafficStats.tagSocket(new DatagramSocketWrapper(r10, r11.getFileDescriptor()));
        r11.detachFd();
    }

    @Deprecated
    public static void tagSocket(Socket r10) {
        TrafficStats.tagSocket(r10);
    }

    public static void untagDatagramSocket(@NonNull DatagramSocket r10) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Api24Impl.untagDatagramSocket(r10);
        return;
    L5:
        ParcelFileDescriptor r11 = ParcelFileDescriptor.fromDatagramSocket(r10);
        TrafficStats.untagSocket(new DatagramSocketWrapper(r10, r11.getFileDescriptor()));
        r11.detachFd();
    }

    @Deprecated
    public static void untagSocket(Socket r10) {
        TrafficStats.untagSocket(r10);
    }
}
