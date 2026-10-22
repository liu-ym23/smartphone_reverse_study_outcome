package com.bytedance.awemeopen.infra.base.net;

import android.app.Application;
import com.bytedance.awemeopen.infra.base.net.download.AoDownloadRequest;
import com.bytedance.awemeopen.infra.base.net.download.AoDownloadResponse;
import com.bytedance.awemeopen.infra.base.net.upload.AoUploadRequest;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.awemeopen.servicesapi.network.AoRequest$FromSource;
import j64.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J \u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u00ad\u0001\u0010\r\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00112\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010&J \u0010'\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020(2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/AoNetworkEventHelper;", "", "()V", "NETWORK_TYPE", "", "mpDownloadMonitor", "", "request", "Lcom/bytedance/awemeopen/infra/base/net/download/AoDownloadRequest;", "response", "Lcom/bytedance/awemeopen/infra/base/net/download/AoDownloadResponse;", "status", "", "mpNetMonitor", "Lcom/bytedance/awemeopen/infra/base/net/AoNetRequest;", "Lcom/bytedance/awemeopen/infra/base/net/AoNetResponse;", "isCancel", "", "callDuration", "dnsDuration", "sslDuration", "connectDuration", "sendDuration", "waitDuration", "recvDuration", "metricDuration", "httpClientType", "url", "netFrom", "Lcom/bytedance/awemeopen/servicesapi/network/AoRequest$FromSource;", "netLib", "netCode", "netMessage", "throwable", "", "netXTTLogid", "socketReused", "protocol", "(IIIIIIIIILjava/lang/String;Lcom/bytedance/awemeopen/servicesapi/network/AoRequest$FromSource;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "mpUploadMonitor", "Lcom/bytedance/awemeopen/infra/base/net/upload/AoUploadRequest;", "ao_base_core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AoNetworkEventHelper {
    public static final AoNetworkEventHelper INSTANCE = null;
    public static final String NETWORK_TYPE = "network_type";

    static {
        INSTANCE = new AoNetworkEventHelper();
    }

    private AoNetworkEventHelper() {
    }

    public final void mpDownloadMonitor(final AoDownloadRequest r2, final AoDownloadResponse r3, final int r4) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "response");
        AoPool.a(new AnonymousClass1(r2, r3, r4));
    }

    public final void mpNetMonitor(final AoNetRequest r2, final AoNetResponse r3, final boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "response");
        AoPool.a(new C03411(r3, r2, r4));
    }

    public final void mpUploadMonitor(final AoUploadRequest r2, final AoNetResponse r3, final int r4) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "response");
        AoPool.a(new C03421(r2, r3, r4));
    }

    public final void mpNetMonitor(final int r22, final int r23, final int r24, final int r25, final int r26, final int r27, final int r28, final int r29, final int r30, final String r31, final AoRequest$FromSource r32, final String r33, final int r34, final String r35, final Throwable r36, final String r37, final Boolean r38, final String r39) {
        int r0 = b.a;
        final Application r2 = b.a(AoHostService.class).getHostApplication();
        AoPool.a(new AnonymousClass2(r31, r2, r32, r33, r34, r35, r37, r22, r23, r24, r25, r26, r27, r28, r29, r30, r38, r39, r36));
    }
}
