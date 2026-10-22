package com.obric.capabilitykit.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/entity/ResultCode;", "", "()V", "ERROR_CREDENTIAL_ENCRYPTED_STORAGE_LOCKED", "", "ERROR_DONATE_TEMPORARY_FAILED", "ERROR_EMPTY_ENTITY", "ERROR_MEMORY_SERVICE_DISABLED", "ERROR_MULTI_DETAIL", "ERROR_PERMISSION_DENIED", "ERROR_UNSUPPORTED_ENTITY", "INTERNAL_ERROR", "OK", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ResultCode {
    public static final int ERROR_CREDENTIAL_ENCRYPTED_STORAGE_LOCKED = 305;
    public static final int ERROR_DONATE_TEMPORARY_FAILED = 303;
    public static final int ERROR_EMPTY_ENTITY = 301;
    public static final int ERROR_MEMORY_SERVICE_DISABLED = 306;
    public static final int ERROR_MULTI_DETAIL = 304;
    public static final int ERROR_PERMISSION_DENIED = 111;
    public static final int ERROR_UNSUPPORTED_ENTITY = 302;
    public static final ResultCode INSTANCE = null;
    public static final int INTERNAL_ERROR = 501;
    public static final int OK = 0;

    static {
        INSTANCE = new ResultCode();
    }

    private ResultCode() {
    }
}
