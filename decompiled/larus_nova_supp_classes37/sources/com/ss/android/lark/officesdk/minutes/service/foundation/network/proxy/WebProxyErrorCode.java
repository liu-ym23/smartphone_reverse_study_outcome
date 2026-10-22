package com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/WebProxyErrorCode;", "", "value", "", "message", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getMessage", "()Ljava/lang/String;", "SUCCESS", "INVALID_COMMAND", "INVALID_REQUEST_FORMAT", "DECODE_REQUEST_FAILED", "NETWORK_ERROR", "UNKNOWN_ERROR", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum WebProxyErrorCode extends Enum<WebProxyErrorCode> {
    public static final a Companion = null;
    public static final WebProxyErrorCode DECODE_REQUEST_FAILED = null;
    public static final WebProxyErrorCode INVALID_COMMAND = null;
    public static final WebProxyErrorCode INVALID_REQUEST_FORMAT = null;
    public static final WebProxyErrorCode NETWORK_ERROR = null;
    public static final WebProxyErrorCode SUCCESS = null;
    public static final WebProxyErrorCode UNKNOWN_ERROR = null;
    public static final /* synthetic */ WebProxyErrorCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String message;
    private final int value;

    public static EnumEntries<WebProxyErrorCode> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.WebProxyErrorCode$a] */
    static {
        WebProxyErrorCode r0 = new WebProxyErrorCode("SUCCESS", 0, 0, "Success");
        SUCCESS = r0;
        WebProxyErrorCode r1 = new WebProxyErrorCode("INVALID_COMMAND", 1, 1001, "Invalid or unsupported command");
        INVALID_COMMAND = r1;
        WebProxyErrorCode r3 = new WebProxyErrorCode("INVALID_REQUEST_FORMAT", 2, 1002, "Invalid request format");
        INVALID_REQUEST_FORMAT = r3;
        WebProxyErrorCode r5 = new WebProxyErrorCode("DECODE_REQUEST_FAILED", 3, 1003, "Failed to decode request base64");
        DECODE_REQUEST_FAILED = r5;
        WebProxyErrorCode r7 = new WebProxyErrorCode("NETWORK_ERROR", 4, 1004, "Network request failed");
        NETWORK_ERROR = r7;
        WebProxyErrorCode r9 = new WebProxyErrorCode("UNKNOWN_ERROR", 5, -1, "Unknown error");
        UNKNOWN_ERROR = r9;
        WebProxyErrorCode[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static WebProxyErrorCode[] values() {
        return (WebProxyErrorCode[]) a.clone();
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getValue() {
        return this.value;
    }

    public static WebProxyErrorCode valueOf(String r1) {
        return (WebProxyErrorCode) r27.a.a(WebProxyErrorCode.class, r1);
    }

    public WebProxyErrorCode(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.value = r3;
        this.message = r4;
    }
}
