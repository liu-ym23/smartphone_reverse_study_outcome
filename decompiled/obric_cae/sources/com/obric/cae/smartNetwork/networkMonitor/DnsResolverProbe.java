package com.obric.cae.smartNetwork.networkMonitor;

import android.annotation.SuppressLint;
import android.net.DnsResolver;
import android.net.Network;
import com.obric.cae.log.CaeLog;
import java.net.InetAddress;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class DnsResolverProbe {
    private static final int DEFAULT_TIMEOUT = 10000;
    public static final int ERROR_CODE_HOST_INVALID = 3;
    public static final int ERROR_CODE_NETWORK_NOT_AVAILABLE = 1;
    public static final int ERROR_CODE_TIMEOUT = 5;
    public static final int ERROR_CODE_UNKNOWN = 0;
    public static final int ERROR_CODE_UNKNOWN_HOST = 4;
    public static final int ERROR_CODE_URL_INVALID = 2;
    private static final String TAG = "CaeNetworkMonitor";

    @SuppressLint({"NewApi"})
    private final DnsResolver.Callback<List<InetAddress>> mCallback;
    private DnsResolver mDnsResolver;
    private Network mNetwork;
    private final CompletableFuture<List<InetAddress>> mResultRef;

    public interface DnsResolverListener {
        void onDnsResolveFailed(String r8, int r10);

        void onDnsResolveSuccess(String r8, List<InetAddress> r10);
    }

    @SuppressLint({"NewApi"})
    public DnsResolverProbe(Network r8) {
        this.mResultRef = new CompletableFuture();
        this.mCallback = new AnonymousClass1(this);
        this.mNetwork = r8;
        this.mDnsResolver = DnsResolver.getInstance();
    }

    public static /* synthetic */ CompletableFuture access$000(DnsResolverProbe r8) {
        return r8.mResultRef;
    }

    private URL makeURL(String r8) {
        if (r8 == null) goto L10;
        return new URL(r8);
    L5:
        CaeLog.e("URLUtils", "Bad URL: ".concat(r8));
        return null;
    L10:
        return null;
    }

    @SuppressLint({"WrongConstant", "NewApi"})
    private void sendDnsProbe(String r10, DnsResolverListener r11) {
        this.mDnsResolver.query(this.mNetwork, r10, 0, new i.a(3), null, this.mCallback);
        int r8 = 0;
        List<InetAddress> r12 = this.mResultRef.get(10000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L9 Throwable -> L11 ExecutionException -> L14
        if (r12 != null) goto L6;
    L8:
        r11.onDnsResolveFailed(r10, r8);
        return;
    L6:
        if (r12.isEmpty() == true) goto L8;
        r11.onDnsResolveSuccess(r10, r12);
        return;
    L9:
        th = move-exception;
        r11.onDnsResolveFailed(r10, 0);
        throw th;
    L11:
        e = move-exception;
        CaeLog.e(TAG, "DNS resolve timeout: ", e);     // Catch: Throwable -> L9
        r11.onDnsResolveFailed(r10, 5);
        return;
    L14:
        e = move-exception;
        r8 = 4;
        CaeLog.e(TAG, "DNS resolve error: ", e);     // Catch: Throwable -> L9
        goto L8
    }

    public void executeDnsResolve(String r8, DnsResolverListener r10) {
        if (this.mNetwork != null) goto L7;
        CaeLog.e(TAG, "network is null");
        int r11 = 1;
    L5:
        r10.onDnsResolveFailed(null, r11);
        return;
    L7:
        URL r12 = makeURL(r8);
        if (r12 != null) goto L10;
        CaeLog.e(TAG, "url is invalid: " + r8);
        r11 = 2;
        goto L5
    L10:
        String r13 = r12.getHost();
        if (r13 != null) goto L13;
        CaeLog.e(TAG, "hostname is null");
        r11 = 3;
        goto L5
    L13:
        sendDnsProbe(r13, r10);
    }
}
