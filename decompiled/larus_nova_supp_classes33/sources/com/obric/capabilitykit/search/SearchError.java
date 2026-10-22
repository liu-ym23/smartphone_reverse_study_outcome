package com.obric.capabilitykit.search;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/search/SearchError;", "", "()V", "ERROR_QU", "", "ERR_API_DISABLED", "ERR_MEMORY_SERVICE_DISABLED", "ERR_MODEL_NOT_READY", "INTERNAL_ERROR", "OK", "SEARCH_ALL_ENTITY", "SERVICE_NOT_READY", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SearchError {
    public static final int ERROR_QU = 5;
    public static final int ERR_API_DISABLED = 4;
    public static final int ERR_MEMORY_SERVICE_DISABLED = 6;
    public static final int ERR_MODEL_NOT_READY = 3;
    public static final SearchError INSTANCE = null;
    public static final int INTERNAL_ERROR = 1;
    public static final int OK = 0;
    public static final int SEARCH_ALL_ENTITY = 101;
    public static final int SERVICE_NOT_READY = 2;

    static {
        INSTANCE = new SearchError();
    }

    private SearchError() {
    }
}
