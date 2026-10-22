package androidx.core.net;

import android.net.TrafficStats;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

/* JADX INFO: loaded from: classes.dex */
public final class TrafficStatsCompat {

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static void tagDatagramSocket(DatagramSocket r5) throws SocketException {
            TrafficStats.tagDatagramSocket(r5);
        }

        @DoNotInline
        public static void untagDatagramSocket(DatagramSocket r5) throws SocketException {
            TrafficStats.untagDatagramSocket(r5);
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
    public static void incrementOperationCount(int r5) {
        TrafficStats.incrementOperationCount(r5);
    }

    @Deprecated
    public static void setThreadStatsTag(int r5) {
        TrafficStats.setThreadStatsTag(r5);
    }

    public static void tagDatagramSocket(@NonNull DatagramSocket r5) throws SocketException {
        Api24Impl.tagDatagramSocket(r5);
    }

    @Deprecated
    public static void tagSocket(Socket r5) throws SocketException {
        TrafficStats.tagSocket(r5);
    }

    public static void untagDatagramSocket(@NonNull DatagramSocket r5) throws SocketException {
        Api24Impl.untagDatagramSocket(r5);
    }

    @Deprecated
    public static void untagSocket(Socket r5) throws SocketException {
        TrafficStats.untagSocket(r5);
    }

    @Deprecated
    public static void incrementOperationCount(int r5, int r10) {
        TrafficStats.incrementOperationCount(r5, r10);
    }
}
