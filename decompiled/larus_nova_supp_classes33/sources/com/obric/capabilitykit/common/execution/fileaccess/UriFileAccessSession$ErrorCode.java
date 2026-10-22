package com.obric.capabilitykit.common.execution.fileaccess;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession$ErrorCode;", "", "()V", "ERROR_ACCESSING_INPUT_STREAM", "", "ERROR_ACCESSING_SHARER", "ERROR_INVALID_SHARER", "ERROR_NOT_SHARED_BY_THIS_ENTITY", "ERROR_OPENING_INPUT_STREAM", "ERROR_OPENING_URI", "ERROR_REQUESTING_URI", "ERROR_TIMEOUT", "ERROR_UNKNOWN_ERROR", "NO_ERROR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UriFileAccessSession$ErrorCode {
    public static final int ERROR_ACCESSING_INPUT_STREAM = 6;
    public static final int ERROR_ACCESSING_SHARER = 8;
    public static final int ERROR_INVALID_SHARER = 3;
    public static final int ERROR_NOT_SHARED_BY_THIS_ENTITY = 2;
    public static final int ERROR_OPENING_INPUT_STREAM = 5;
    public static final int ERROR_OPENING_URI = 4;
    public static final int ERROR_REQUESTING_URI = 7;
    public static final int ERROR_TIMEOUT = 9;
    public static final int ERROR_UNKNOWN_ERROR = 1;
    public static final UriFileAccessSession$ErrorCode INSTANCE = null;
    public static final int NO_ERROR = 0;

    static {
        INSTANCE = new UriFileAccessSession$ErrorCode();
    }

    private UriFileAccessSession$ErrorCode() {
    }
}
