package com.obric.memorydata.middleware.a;

import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.middleware.database.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/middleware/synthesis/SynthesisAccess;", "", "<init>", "()V", "USER_DB", "", "RAW_DB", "CONFIG_KEY", "config", "Lorg/json/JSONObject;", "available", "", "expectedUid", "requireAccess", "", "uid", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11596a = null;

    static {
        f11596a = new a();
    }

    private a() {
    }

    public final JSONObject a() {
        JSONObject r1 = SettingsManager.INSTANCE.getJson("memory_task_synthesis");
        if (r1 != null) goto L5;
        r1 = new JSONObject();
    L5:
        JSONObject r0 = r1.optJSONObject("memory_task_synthesis");
        if (r0 != null) goto L9;
        return r1;
    L9:
        return r0;
    }

    public final boolean a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "expectedUid");
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L5;
        return false;
    L5:
        if (AppContext.INSTANCE.isLogin() == false) goto L27;
        JSONObject r4 = a();
        if (r4.has("enable") == true) goto L10;
    L12:
        i r6 = com.obric.memorydata.middleware.database.b.f11646a.a();
        if (r6.c() == false) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(r6.b(), r5) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(AppContext.INSTANCE.getUserId(), r5) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(com.obric.memorydata.middleware.database.b.f11646a.b(MemoryDbEngine.USER_LOGIC_DB_NAME), com.obric.memorydata.middleware.database.b.f11646a.c(MemoryDbEngine.USER_LOGIC_DB_NAME)) == true) goto L21;
        return false;
    L21:
        return true;
    L10:
        if (Intrinsics.areEqual(r4.opt("enable"), true) == true) goto L12;
        return false;
    L27:
        return false;
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        if (a(r2) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("ACCESS_UNAVAILABLE".toString());
    }
}
