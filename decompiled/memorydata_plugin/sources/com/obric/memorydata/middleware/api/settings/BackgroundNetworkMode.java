package com.obric.memorydata.middleware.api.settings;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/BackgroundNetworkMode;", "", "<init>", "()V", "LOOSE", "", "MEDIUM", "STRICT", "normalize", "mode", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BackgroundNetworkMode {
    public static final BackgroundNetworkMode INSTANCE = null;
    public static final int LOOSE = 0;
    public static final int MEDIUM = 1;
    public static final int STRICT = 2;

    static {
        INSTANCE = new BackgroundNetworkMode();
    }

    private BackgroundNetworkMode() {
    }

    public final int normalize(int r2) {
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L6;
        return r2;
    L6:
        if (r2 != 2) goto L8;
        return r2;
    L8:
        return 1;
    L9:
        return r2;
    }
}
