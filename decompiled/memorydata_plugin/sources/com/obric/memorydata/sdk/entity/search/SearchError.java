package com.obric.memorydata.sdk.entity.search;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/SearchError;", "", "<init>", "()V", "OK", "", "ERR_UNKNOWN", "ERR_NO_PERMISSION", "ERR_INVALID_PARAMS", "ERR_QUERY_UNDERSTANDING_FAILED", "ERR_INTERNAL_ERROR", "ERR_MODEL_NOT_READY", "ERR_PACKAGE_FAILED", "ERR_PACKAGE_RUN_TIMEOUT", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchError {
    public static final int ERR_INTERNAL_ERROR = 1004;
    public static final int ERR_INVALID_PARAMS = 1002;
    public static final int ERR_MODEL_NOT_READY = 1005;
    public static final int ERR_NO_PERMISSION = 1001;
    public static final int ERR_PACKAGE_FAILED = 1006;
    public static final int ERR_PACKAGE_RUN_TIMEOUT = 1007;
    public static final int ERR_QUERY_UNDERSTANDING_FAILED = 1003;
    public static final int ERR_UNKNOWN = 1000;
    public static final SearchError INSTANCE = null;
    public static final int OK = 0;

    static {
        INSTANCE = new SearchError();
    }

    private SearchError() {
    }
}
