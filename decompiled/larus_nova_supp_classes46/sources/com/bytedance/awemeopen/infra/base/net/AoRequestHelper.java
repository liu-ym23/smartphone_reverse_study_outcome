package com.bytedance.awemeopen.infra.base.net;

import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.servicesapi.network.AoNetworkMetric;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLException;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import q64.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\u001b\u001a\u00020\u000eJ\b\u0010\u001c\u001a\u00020\u0006H\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006J\u001d\u0010!\u001a\u00020\u001e*\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\u001e*\u00020\u00102\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&J\n\u0010'\u001a\u00020\u0010*\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006("}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/AoRequestHelper;", "", "()V", "ID_CREATOR", "Ljava/util/concurrent/atomic/AtomicInteger;", "TAG", "", "mConnectTimeoutDic", "", "[Ljava/lang/String;", "mConnectionErrorDic", "mDNSErrorDic", "mNetworkDisableDic", "buildNativeErrorCode", "", "e", "", "buildNativeErrorResponse", "Lcom/bytedance/awemeopen/infra/base/net/AoNetResponse;", "url", "errorCode", "errorMsg", "libType", "Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "convertToBytes", "", "content", "generateRequestId", "getTimezoneOffset", "permitsRequestBody", "", "method", "requiresRequestBody", "isError", "errorDic", "(Ljava/lang/Throwable;[Ljava/lang/String;)Z", "isException", "cls", "Ljava/lang/Class;", "realCause", "ao_base_core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AoRequestHelper {
    private static final AtomicInteger ID_CREATOR = null;
    public static final AoRequestHelper INSTANCE = null;
    private static final String TAG = "BdpRequestHelper";
    private static final String[] mConnectTimeoutDic = null;
    private static final String[] mConnectionErrorDic = null;
    private static final String[] mDNSErrorDic = null;
    private static final String[] mNetworkDisableDic = null;

    private AoRequestHelper() {
    }

    static {
        INSTANCE = new AoRequestHelper();
        ID_CREATOR = new AtomicInteger(0);
        mNetworkDisableDic = new String[]{"network not available", "network_not_available", "err_network_access_denied"};
        mDNSErrorDic = new String[]{"unknownhost", "no address associated with hostname", "unknownhostexception", "err_name_not_resolved"};
        mConnectTimeoutDic = new String[]{"timed_out"};
        mConnectionErrorDic = new String[]{"Exception in connect"};
    }

    public final int generateRequestId() {
        return ID_CREATOR.incrementAndGet();
    }

    private final String getTimezoneOffset() {
        return String.valueOf(TimeZone.getDefault().getRawOffset() / 1000);
    L4:
        e = move-exception;
        AoLogger.c(TAG, new Object[]{"getTimezoneOffsetError", e});
        return "";
    }

    public final int buildNativeErrorCode(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        if (isError(r2, mNetworkDisableDic) == false) goto L7;
        return AoNetCode.NETWORK_NOT_AVAILABLE;
    L7:
        if (isException(r2, OutOfMemoryError.class) == false) goto L11;
        return AoNetCode.NATIVE_OOM_ERROR;
    L11:
        if (isException(r2, SocketTimeoutException.class) == false) goto L13;
        return AoNetCode.NETWORK_TIMEOUT;
    L13:
        if (isError(r2, mConnectTimeoutDic) == false) goto L16;
        return AoNetCode.NETWORK_TIMEOUT;
    L16:
        if (isException(r2, UnknownHostException.class) == false) goto L18;
        return AoNetCode.NETWORK_DNS_ERROR;
    L18:
        if (isError(r2, mDNSErrorDic) == false) goto L21;
        return AoNetCode.NETWORK_DNS_ERROR;
    L21:
        if (isException(r2, SSLException.class) == false) goto L25;
        return AoNetCode.NETWORK_SSL_ERROR;
    L25:
        if (isError(r2, mConnectionErrorDic) == false) goto L28;
        return AoNetCode.NETWORK_CONNECTION_ERROR;
    L28:
        return -1;
    }

    public final byte[] convertToBytes(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        return r2.getBytes(Charset.forName("UTF-8"));
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final boolean permitsRequestBody(String r2) {
        Intrinsics.checkNotNullParameter(r2, "method");
        if (requiresRequestBody(r2) == false) goto L5;
    L16:
        return true;
    L5:
        if (Intrinsics.areEqual(r2, "OPTIONS") == true) goto L16;
        if (Intrinsics.areEqual(r2, "DELETE") == true) goto L16;
        if (Intrinsics.areEqual(r2, "PROPFIND") == true) goto L16;
        if (Intrinsics.areEqual(r2, "MKCOL") == true) goto L16;
        if (Intrinsics.areEqual(r2, "LOCK") == true) goto L16;
        return false;
    }

    public final Throwable realCause(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        int r0 = 0;
        Throwable r1 = r4;
    L4:
        if (r0 >= 4) goto L9;
        if (r1.getCause() == null) goto L7;
        r1 = r1.getCause();
        Intrinsics.checkNotNull(r1);
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return r4;
    }

    public final boolean requiresRequestBody(String r2) {
        Intrinsics.checkNotNullParameter(r2, "method");
        if (Intrinsics.areEqual(r2, "POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (Intrinsics.areEqual(r2, "PUT") == true) goto L14;
        if (Intrinsics.areEqual(r2, "PATCH") == true) goto L14;
        if (Intrinsics.areEqual(r2, "PROPPATCH") == true) goto L14;
        if (Intrinsics.areEqual(r2, "REPORT") == true) goto L14;
        return false;
    }

    public final boolean isError(Throwable r7, String[] r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "errorDic");
        String r9 = r7.getMessage();
        if (r9 == null) goto L14;
        String r10 = r9.toLowerCase(Locale.getDefault());
        if (r10 == null) goto L14;
        int r1 = r8.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L14;
        if (StringsKt.contains$default(r10, r8[r2], false, 2, null) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return true;
    L14:
        return false;
    }

    public final boolean isException(Throwable r4, Class<?> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "cls");
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L12;
        if (r4 == null) goto L6;
        if (r5.isInstance(r4) == true) goto L9;
        r4 = r4.getCause();
        r1 = r1 + 1;
        goto L4
    L9:
        return true;
    L6:
        return false;
    L12:
        return false;
    }

    public final AoNetResponse buildNativeErrorResponse(String r12, int r13, String r14, AoRequestType r15) {
        Intrinsics.checkNotNullParameter(r12, "url");
        Intrinsics.checkNotNullParameter(r14, "errorMsg");
        Intrinsics.checkNotNullParameter(r15, "libType");
        c r1 = c.b;
        return new AoNetResponse(r13, r14, r12, c.b, null, new Exception(r14), r15, new AoNetworkMetric(), MapsKt.emptyMap());
    }
}
