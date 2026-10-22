package com.obric.memorydata.middleware.api.a;

import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.store.StoreManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/middleware/api/diagnostic/AccessibilityDebugSettings;", "", "<init>", "()V", "STORE_NAME", "", "KEY_KEEP_SERVICE_ON", "isAvailable", "", "shouldKeepServiceOn", "setKeepServiceOn", "enabled", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11599a = null;

    static {
        f11599a = new a();
    }

    private a() {
    }

    public final boolean a() {
        return AppContext.INSTANCE.isDebug();
    }

    public final boolean b() {
        if (a() == true) goto L6;
        return false;
    L6:
        return StoreManager.INSTANCE.getStore("memory_accessibility_debug", 1).getBoolean("keep_service_on", false);
    }
}
