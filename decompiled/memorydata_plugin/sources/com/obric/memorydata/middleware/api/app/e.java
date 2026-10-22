package com.obric.memorydata.middleware.api.app;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005J-\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\fJ\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/middleware/api/app/MemorySwitchEffectiveState;", "", "<init>", "()V", "isAvailable", "", "isEnabled", "persistedEnabled", "isProviderEnabled", "resolve", "isLoggedIn", "isEnterpriseAccount", "resolve$middleware_api_obricRelease", "isAvailable$middleware_api_obricRelease", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f11601a = null;

    static {
        f11601a = new e();
    }

    private e() {
    }

    public final boolean a(boolean r3, boolean r4) {
        return a(UserSettings.INSTANCE.hasAgreePrivacyAndLogin(), UserSettings.INSTANCE.isEnterpriseAccount(), r4, r3);
    }

    public final boolean a(boolean r1, boolean r2, boolean r3, boolean r4) {
        if (b(r1, r2) == false) goto L7;
        if (r3 == false) goto L7;
        if (r4 == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean b(boolean r1, boolean r2) {
        if (r1 == false) goto L5;
        if (r2 == true) goto L5;
        return true;
    L5:
        return false;
    }
}
