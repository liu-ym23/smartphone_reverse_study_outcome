package com.bytedance.awemeopen.infra.base.net;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/AoNetCode;", "", "()V", "NATIVE_EXCEED_MAX_SIZE", "", "NATIVE_OOM_ERROR", "NATIVE_REQUEST_EXECUTED", "NETWORK_CONNECTION_ERROR", "NETWORK_DNS_ERROR", "NETWORK_NOT_AVAILABLE", "NETWORK_NO_BODY", "NETWORK_PARAMS_ERROR", "NETWORK_SSL_ERROR", "NETWORK_TIMEOUT", "OTHER", "ao_base_core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AoNetCode {
    public static final AoNetCode INSTANCE = null;
    public static final int NATIVE_EXCEED_MAX_SIZE = -202;
    public static final int NATIVE_OOM_ERROR = -200;
    public static final int NATIVE_REQUEST_EXECUTED = -201;
    public static final int NETWORK_CONNECTION_ERROR = -106;
    public static final int NETWORK_DNS_ERROR = -102;
    public static final int NETWORK_NOT_AVAILABLE = -101;
    public static final int NETWORK_NO_BODY = -105;
    public static final int NETWORK_PARAMS_ERROR = -100;
    public static final int NETWORK_SSL_ERROR = -103;
    public static final int NETWORK_TIMEOUT = -104;
    public static final int OTHER = -1;

    static {
        INSTANCE = new AoNetCode();
    }

    private AoNetCode() {
    }
}
